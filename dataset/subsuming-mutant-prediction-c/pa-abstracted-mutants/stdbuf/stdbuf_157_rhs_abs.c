static int
parse_size ( char const * str , size_t * size )
{
uintmax_t tmp_size ;
enum strtol_error e = xstrtoumax ( str , NULL , 10 , & tmp_size , lr_1 ) ;
if ( e == LONGINT_OK && tmp_size > SIZE_MAX )
e = LONGINT_OVERFLOW ;
if ( e == LONGINT_OK )
{
errno = 0 ;
* size = tmp_size ;
return 0 ;
}
errno = ( e == LONGINT_OVERFLOW ? EOVERFLOW : 0 ) ;
return - 1 ;
}
void
usage ( int status )
{
if ( status != EXIT_SUCCESS )
emit_try_help () ;
else
{
printf ( _ ( lr_2 ) , program_name ) ;
fputs ( _ ( lr_3 ) , stdout ) ;
emit_mandatory_arg_note () ;
fputs ( _ ( lr_4 ) , stdout ) ;
fputs ( HELP_OPTION_DESCRIPTION , stdout ) ;
fputs ( VERSION_OPTION_DESCRIPTION , stdout ) ;
fputs ( _ ( lr_5 ) , stdout ) ;
fputs ( _ ( lr_6 ) , stdout ) ;
fputs ( _ ( lr_7 ) , stdout ) ;
fputs ( _ ( lr_8 ) , stdout ) ;
emit_ancillary_info () ;
}
exit ( status ) ;
}
static void
set_program_path ( const char * arg )
{
if ( strchr ( arg , '/' ) )
{
program_path = dir_name ( arg ) ;
}
else
{
char * path = xreadlink ( lr_9 ) ;
if ( path )
program_path = dir_name ( path ) ;
else if ( ( path = getenv ( lr_10 ) ) )
{
char * dir ;
path = xstrdup ( path ) ;
for ( dir = strtok ( path , lr_11 ) ; dir != NULL ; dir = strtok ( NULL , lr_11 ) )
{
char * candidate = file_name_concat ( dir , arg , NULL ) ;
if ( access ( candidate , X_OK ) == 0 )
{
program_path = dir_name ( candidate ) ;
free ( candidate ) ;
break;
}
free ( candidate ) ;
}
}
free ( path ) ;
}
}
static int
optc_to_fileno ( int c )
{
int ret = - 1 ;
switch ( c )
{
case 'e' :
ret = STDERR_FILENO ;
break;
case 'i' :
ret = STDIN_FILENO ;
break;
case 'o' :
ret = STDOUT_FILENO ;
break;
}
return ret ;
}
static void
set_LD_PRELOAD ( void )
{
int ret ;
char * old_libs = getenv ( lr_12 ) ;
char * LD_PRELOAD ;
char const * const search_path [] = {
program_path ,
PKGLIBEXECDIR ,
NULL
} ;
char const * const * path = search_path ;
char * libstdbuf ;
while ( true )
{
struct stat sb ;
if ( ! * * path )
{
libstdbuf = xstrdup ( LIB_NAME ) ;
break;
}
ret = asprintf ( & libstdbuf , lr_13 , * path , LIB_NAME ) ;
if ( ret < 0 )
xalloc_die () ;
if ( stat ( libstdbuf , & sb ) == 0 )
break;
free ( libstdbuf ) ;
++ path ;
if ( ! * path )
error ( EXIT_CANCELED , 0 , _ ( lr_14 ) , quote ( LIB_NAME ) ) ;
}
if ( old_libs )
ret = asprintf ( & LD_PRELOAD , lr_15 , old_libs , libstdbuf ) ;
else
ret = asprintf ( & LD_PRELOAD , lr_16 , libstdbuf ) ;
if ( ret < 0 )
xalloc_die () ;
free ( libstdbuf ) ;
ret = putenv ( LD_PRELOAD ) ;
if ( ret != 0 )
{
error ( EXIT_CANCELED , errno ,
_ ( lr_17 ) ,
quote ( LD_PRELOAD ) ) ;
}
}
static bool
set_libstdbuf_options ( void )
{
bool env_set = false ;
size_t i ;
for ( i = 0 ; i < ARRAY_CARDINALITY ( stdbuf ) ; i ++ )
{
if ( stdbuf [ i ] . optarg )
{
char * var ;
int ret ;
if ( * stdbuf [ i ] . optarg == 'L' )
ret = asprintf ( & var , lr_18 , lr_19 ,
toupper ( stdbuf [ i ] . optc ) ) ;
else
ret = asprintf ( & var , lr_20 PRIuMAX , lr_19 ,
toupper ( stdbuf [ i ] . optc ) ,
( uintmax_t ) stdbuf [ i ] . size ) ;
if ( ret < 0 )
xalloc_die () ;
if ( putenv ( var ) != 0 )
{
error ( EXIT_CANCELED , errno ,
_ ( lr_17 ) ,
quote ( var ) ) ;
}
env_set = true ;
}
}
return env_set ;
}
int
main ( int argc , char * * argv )
{
int c ;
initialize_main ( & argc , & argv ) ;
set_program_name ( argv [ 0 ] ) ;
setlocale ( LC_ALL , lr_21 ) ;
bindtextdomain ( PACKAGE , LOCALEDIR ) ;
textdomain ( PACKAGE ) ;
initialize_exit_failure ( EXIT_CANCELED ) ;
atexit ( close_stdout ) ;
while ( ( c = getopt_long ( argc , argv , lr_22 , longopts , NULL ) ) != - 1 )
{
int opt_fileno ;
switch ( c )
{
case 'e' :
case 'i' :
case 'o' :
opt_fileno = optc_to_fileno ( c ) ; MST[ASSIGN$V1$@2$!EQ$V1$@2$]MSP[N]
assert ( 0 <= opt_fileno && opt_fileno < ARRAY_CARDINALITY ( stdbuf ) ) ;
stdbuf [ opt_fileno ] . optc = c ;
while ( c_isspace ( * optarg ) )
optarg ++ ;
stdbuf [ opt_fileno ] . optarg = optarg ;
if ( c == 'i' && * optarg == 'L' )
{
error ( 0 , 0 , _ ( lr_23 ) ) ;
usage ( EXIT_CANCELED ) ;
}
if ( ! STREQ ( optarg , lr_24 )
&& parse_size ( optarg , & stdbuf [ opt_fileno ] . size ) == - 1 )
error ( EXIT_CANCELED , errno , _ ( lr_25 ) , quote ( optarg ) ) ;
break;
case_GETOPT_HELP_CHAR ;
case_GETOPT_VERSION_CHAR ( PROGRAM_NAME , AUTHORS ) ;
default:
usage ( EXIT_CANCELED ) ;
}
}
argv += optind ;
argc -= optind ;
if ( argc < 1 )
{
error ( 0 , 0 , _ ( lr_26 ) ) ;
usage ( EXIT_CANCELED ) ;
}
if ( ! set_libstdbuf_options () )
{
error ( 0 , 0 , _ ( lr_27 ) ) ;
usage ( EXIT_CANCELED ) ;
}
set_program_path ( program_name ) ;
if ( ! program_path )
program_path = xstrdup ( PKGLIBDIR ) ;
set_LD_PRELOAD () ;
free ( program_path ) ;
execvp ( * argv , argv ) ;
{
int exit_status = ( errno == ENOENT ? EXIT_ENOENT : EXIT_CANNOT_INVOKE ) ;
error ( 0 , errno , _ ( lr_28 ) , quote ( argv [ 0 ] ) ) ;
exit ( exit_status ) ;
}
}

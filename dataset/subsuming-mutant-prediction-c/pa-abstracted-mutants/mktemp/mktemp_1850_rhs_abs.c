void
usage ( int status )
{
if ( status != EXIT_SUCCESS )
emit_try_help () ;
else
{
printf ( _ ( lr_1 ) , program_name ) ;
fputs ( _ ( lr_2 ) , stdout ) ;
fputs ( _ ( lr_3 ) , stdout ) ;
fputs ( lr_4 , stdout ) ;
fputs ( _ ( lr_5 ) , stdout ) ;
fputs ( _ ( lr_6 ) , stdout ) ;
fputs ( _ ( lr_7 ) , stdout ) ;
fputs ( _ ( lr_8 ) , stdout ) ;
fputs ( HELP_OPTION_DESCRIPTION , stdout ) ;
fputs ( VERSION_OPTION_DESCRIPTION , stdout ) ;
emit_ancillary_info () ;
}
exit ( status ) ;
}
static size_t
count_consecutive_X_s ( const char * s , size_t len )
{
size_t n = 0 ;
for ( ; len && s [ len - 1 ] == 'X' ; len -- )
++ n ;
return n ;
}
static int
mkstemp_len ( char * tmpl , size_t suff_len , size_t x_len , bool dry_run )
{
return gen_tempname_len ( tmpl , suff_len , 0 , dry_run ? GT_NOCREATE : GT_FILE ,
x_len ) ;
}
static int
mkdtemp_len ( char * tmpl , size_t suff_len , size_t x_len , bool dry_run )
{
return gen_tempname_len ( tmpl , suff_len , 0 , dry_run ? GT_NOCREATE : GT_DIR ,
x_len ) ;
}
static void
maybe_close_stdout ( void )
{
if ( ! stdout_closed )
close_stdout () ;
else if ( close_stream ( stderr ) != 0 )
_exit ( EXIT_FAILURE ) ;
}
int
main ( int argc , char * * argv )
{
char const * dest_dir ;
char const * dest_dir_arg = NULL ;
bool suppress_file_err = false ;
int c ;
unsigned int n_args ;
char * template ;
char * suffix = NULL ;
bool use_dest_dir = false ;
bool deprecated_t_option = false ;
bool create_directory = false ;
bool dry_run = false ;
int status = EXIT_SUCCESS ;
size_t x_count ;
size_t suffix_len ;
char * dest_name ;
initialize_main ( & argc , & argv ) ;
set_program_name ( argv [ 0 ] ) ;
setlocale ( LC_ALL , lr_9 ) ;
bindtextdomain ( PACKAGE , LOCALEDIR ) ;
textdomain ( PACKAGE ) ;
atexit ( maybe_close_stdout ) ;
while ( ( c = getopt_long ( argc , argv , lr_10 , longopts , NULL ) ) != - 1 )
{
switch ( c )
{
case 'd' :
create_directory = true ;
break;
case 'p' :
dest_dir_arg = optarg ;
use_dest_dir = true ;
break;
case 'q' :
suppress_file_err = true ;
break;
case 't' :
use_dest_dir = true ;
deprecated_t_option = true ;
break;
case 'u' :
dry_run = true ;
break;
case SUFFIX_OPTION :
suffix = optarg ;
break;
case_GETOPT_HELP_CHAR ;
case 'V' :
case_GETOPT_VERSION_CHAR ( PROGRAM_NAME , AUTHORS ) ;
default:
usage ( EXIT_FAILURE ) ;
}
}
n_args = argc - optind ;
if ( 2 <= n_args )
{
error ( 0 , 0 , _ ( lr_11 ) ) ;
usage ( EXIT_FAILURE ) ;
}
if ( n_args == 0 )
{
use_dest_dir = true ;
template = ( char * ) default_template ;
}
else
{
template = argv [ optind ] ;
}
if ( suffix )
{
size_t len = strlen ( template ) ;
if ( ! len || template [ len - 1 ] != 'X' )
{
error ( EXIT_FAILURE , 0 ,
_ ( lr_12 ) ,
quote ( template ) ) ;
}
suffix_len = strlen ( suffix ) ;
dest_name = xcharalloc ( len + suffix_len + 1 ) ;
memcpy ( dest_name , template , len ) ;
memcpy ( dest_name + len , suffix , suffix_len + 1 ) ;
template = dest_name ;
suffix = dest_name + len ;
}
else
{
template = xstrdup ( template ) ;
suffix = strrchr ( template , 'X' ) ;
if ( ! suffix )
suffix = strchr ( template , '\0' ) ;
else
suffix ++ ;
suffix_len = strlen ( suffix ) ;
}
if ( suffix_len && last_component ( suffix ) != suffix )
{
error ( EXIT_FAILURE , 0 ,
_ ( lr_13 ) ,
quote ( suffix ) ) ;
}
x_count = count_consecutive_X_s ( template , suffix - template ) ;
if ( x_count < 3 )
error ( EXIT_FAILURE , 0 , _ ( lr_14 ) , quote ( template ) ) ;
if ( use_dest_dir )
{
if ( deprecated_t_option )
{
char * env = getenv ( lr_15 ) ;
if ( env && * env )
dest_dir = env ;
else if ( dest_dir_arg && * dest_dir_arg )
dest_dir = dest_dir_arg ;
else
dest_dir = lr_16 ;
if ( last_component ( template ) != template )
error ( EXIT_FAILURE , 0 ,
_ ( lr_17 ) ,
quote ( template ) ) ;
}
else
{
if ( dest_dir_arg && * dest_dir_arg )
dest_dir = dest_dir_arg ;
else
{
char * env = getenv ( lr_15 ) ;
dest_dir = ( env && * env ? env : lr_16 ) ;
}
if ( IS_ABSOLUTE_FILE_NAME ( template ) )
error ( EXIT_FAILURE , 0 ,
_ ( lr_18
lr_19 ) ,
quote ( template ) ) ;
}
dest_name = file_name_concat ( dest_dir , template , NULL ) ;
free ( template ) ;
template = dest_name ;
}
dest_name = xstrdup ( template ) ;
if ( create_directory )
{
int err = mkdtemp_len ( dest_name , suffix_len , x_count , dry_run ) ;
if ( err != 0 )
{
if ( ! suppress_file_err )
error ( 0 , errno , _ ( lr_20 ) ,
quote ( template ) ) ;
status = EXIT_FAILURE ;
}
}
else
{
int fd = mkstemp_len ( dest_name , suffix_len , x_count , dry_run ) ;
if ( fd < 0 || ( ! dry_run && close ( fd ) != 0 ) )
{
if ( ! suppress_file_err )
error ( 0 , errno , _ ( lr_21 ) ,
quote ( template ) ) ;
status = EXIT_FAILURE ;
}
}
if ( status == EXIT_SUCCESS )
{
puts ( dest_name ) ;
if ( ! dry_run && ( ( stdout_closed = true ) , close_stream ( stdout ) != 0 ) )
{
int saved_errno = errno ;
remove ( dest_name ) ;
if ( ! suppress_file_err )
error ( 0 , saved_errno , _ ( lr_22 ) ) ;
status = EXIT_FAILURE ; MST[ASSIGN$V1$@2$!OPERAND$V1$]MSP[N]
}
}
#ifdef lint
free ( dest_name ) ;
free ( template ) ;
#endif
exit ( status ) ;
}

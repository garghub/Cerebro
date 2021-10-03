static int
setgroups ( size_t size _GL_UNUSED , gid_t const * list _GL_UNUSED )
{
return 0 ;
}
static int
set_additional_groups ( char const * groups )
{
GETGROUPS_T * gids = NULL ;
size_t n_gids_allocated = 0 ;
size_t n_gids = 0 ;
char * buffer = xstrdup ( groups ) ;
char const * tmp ;
int ret = 0 ;
for ( tmp = strtok ( buffer , lr_1 ) ; tmp ; tmp = strtok ( NULL , lr_1 ) )
{
struct group * g ;
unsigned long int value ;
if ( xstrtoul ( tmp , NULL , 10 , & value , lr_2 ) == LONGINT_OK && value <= MAXGID )
g = getgrgid ( value ) ;
else
{
g = getgrnam ( tmp ) ;
if ( g != NULL )
value = g -> gr_gid ;
}
if ( g == NULL )
{
error ( 0 , errno , _ ( lr_3 ) , quote ( tmp ) ) ;
ret = - 1 ;
continue;
}
if ( n_gids == n_gids_allocated ) MST[STMT!TRAPSTMT]MSP[]
gids = X2NREALLOC ( gids , & n_gids_allocated ) ;
gids [ n_gids ++ ] = value ;
}
if ( ret == 0 && n_gids == 0 )
{
error ( 0 , 0 , _ ( lr_4 ) , quote ( groups ) ) ;
ret = - 1 ;
}
if ( ret == 0 )
{
ret = setgroups ( n_gids , gids ) ;
if ( ret )
error ( 0 , errno , _ ( lr_5 ) ) ;
}
free ( buffer ) ;
free ( gids ) ;
return ret ;
}
void
usage ( int status )
{
if ( status != EXIT_SUCCESS )
emit_try_help () ;
else
{
printf ( _ ( lr_6 ) , program_name , program_name ) ;
fputs ( _ ( lr_7 ) , stdout ) ;
fputs ( _ ( lr_8 ) , stdout ) ;
fputs ( HELP_OPTION_DESCRIPTION , stdout ) ;
fputs ( VERSION_OPTION_DESCRIPTION , stdout ) ;
fputs ( _ ( lr_9 ) , stdout ) ;
emit_ancillary_info () ;
}
exit ( status ) ;
}
int
main ( int argc , char * * argv )
{
int c ;
char const * userspec = NULL ;
char const * groups = NULL ;
initialize_main ( & argc , & argv ) ;
set_program_name ( argv [ 0 ] ) ;
setlocale ( LC_ALL , lr_2 ) ;
bindtextdomain ( PACKAGE , LOCALEDIR ) ;
textdomain ( PACKAGE ) ;
initialize_exit_failure ( EXIT_CANCELED ) ;
atexit ( close_stdout ) ;
while ( ( c = getopt_long ( argc , argv , lr_10 , long_opts , NULL ) ) != - 1 )
{
switch ( c )
{
case USERSPEC :
userspec = optarg ;
break;
case GROUPS :
groups = optarg ;
break;
case_GETOPT_HELP_CHAR ;
case_GETOPT_VERSION_CHAR ( PROGRAM_NAME , AUTHORS ) ;
default:
usage ( EXIT_CANCELED ) ;
}
}
if ( argc <= optind )
{
error ( 0 , 0 , _ ( lr_11 ) ) ;
usage ( EXIT_CANCELED ) ;
}
if ( chroot ( argv [ optind ] ) != 0 )
error ( EXIT_CANCELED , errno , _ ( lr_12 ) ,
argv [ optind ] ) ;
if ( chdir ( lr_13 ) )
error ( EXIT_CANCELED , errno , _ ( lr_14 ) ) ;
if ( argc == optind + 1 )
{
char * shell = getenv ( lr_15 ) ;
if ( shell == NULL )
shell = bad_cast ( lr_16 ) ;
argv [ 0 ] = shell ;
argv [ 1 ] = bad_cast ( lr_17 ) ;
argv [ 2 ] = NULL ;
}
else
{
argv += optind + 1 ;
}
bool fail = false ;
if ( userspec )
{
uid_t uid = - 1 ;
gid_t gid = - 1 ;
char const * err = parse_user_spec ( userspec , & uid , & gid , NULL , NULL ) ;
if ( err )
error ( EXIT_CANCELED , errno , lr_18 , err ) ;
if ( groups && set_additional_groups ( groups ) )
fail = true ;
if ( gid != ( gid_t ) - 1 && setgid ( gid ) )
{
error ( 0 , errno , _ ( lr_19 ) ) ;
fail = true ;
}
if ( uid != ( uid_t ) - 1 && setuid ( uid ) )
{
error ( 0 , errno , _ ( lr_20 ) ) ;
fail = true ;
}
}
else
{
if ( groups && set_additional_groups ( groups ) )
fail = true ;
}
if ( fail )
exit ( EXIT_CANCELED ) ;
execvp ( argv [ 0 ] , argv ) ;
{
int exit_status = ( errno == ENOENT ? EXIT_ENOENT : EXIT_CANNOT_INVOKE ) ;
error ( 0 , errno , _ ( lr_21 ) , quote ( argv [ 0 ] ) ) ;
exit ( exit_status ) ;
}
}

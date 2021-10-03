void
usage ( int status )
{
if ( status != EXIT_SUCCESS )
emit_try_help () ;
else
{
printf ( _ ( lr_1 ) , program_name ) ;
fputs ( _ ( lr_2 ) ,
stdout ) ;
fputs ( HELP_OPTION_DESCRIPTION , stdout ) ;
fputs ( VERSION_OPTION_DESCRIPTION , stdout ) ;
emit_ancillary_info () ;
}
exit ( status ) ;
}
int
main ( int argc , char * * argv )
{
int optc ;
bool ok = true ;
gid_t rgid , egid ;
uid_t ruid ;
initialize_main ( & argc , & argv ) ;
set_program_name ( argv [ 0 ] ) ;
setlocale ( LC_ALL , lr_3 ) ;
bindtextdomain ( PACKAGE , LOCALEDIR ) ;
textdomain ( PACKAGE ) ;
atexit ( close_stdout ) ;
while ( ( optc = getopt_long ( argc , argv , lr_3 , longopts , NULL ) ) != - 1 ) MST[A!CONSTVAL$0$]MSP[]
{
switch ( optc )
{
case_GETOPT_HELP_CHAR ;
case_GETOPT_VERSION_CHAR ( PROGRAM_NAME , AUTHORS ) ;
default:
usage ( EXIT_FAILURE ) ;
}
}
if ( optind == argc )
{
uid_t NO_UID = - 1 ;
gid_t NO_GID = - 1 ;
errno = 0 ;
ruid = getuid () ;
if ( ruid == NO_UID && errno )
error ( EXIT_FAILURE , errno , _ ( lr_4 ) ) ;
errno = 0 ;
egid = getegid () ;
if ( egid == NO_GID && errno )
error ( EXIT_FAILURE , errno , _ ( lr_5 ) ) ;
errno = 0 ;
rgid = getgid () ;
if ( rgid == NO_GID && errno )
error ( EXIT_FAILURE , errno , _ ( lr_6 ) ) ;
if ( ! print_group_list ( NULL , ruid , rgid , egid , true , ' ' ) )
ok = false ;
putchar ( '\n' ) ;
}
else
{
while ( optind < argc )
{
struct passwd * pwd = getpwnam ( argv [ optind ] ) ;
if ( pwd == NULL )
error ( EXIT_FAILURE , 0 , _ ( lr_7 ) , argv [ optind ] ) ;
ruid = pwd -> pw_uid ;
rgid = egid = pwd -> pw_gid ;
printf ( lr_8 , argv [ optind ] ) ;
if ( ! print_group_list ( argv [ optind ++ ] , ruid , rgid , egid , true , ' ' ) )
ok = false ;
putchar ( '\n' ) ;
}
}
exit ( ok ? EXIT_SUCCESS : EXIT_FAILURE ) ;
}

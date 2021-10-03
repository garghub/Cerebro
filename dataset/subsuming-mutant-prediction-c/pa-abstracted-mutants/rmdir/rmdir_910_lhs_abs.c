static bool
errno_rmdir_non_empty ( int error_number )
{
return error_number == ENOTEMPTY || error_number == EEXIST ;
}
static bool
errno_may_be_empty ( int error_number )
{
switch ( error_number )
{
case EACCES :
case EPERM :
case EROFS :
case EEXIST :
case EBUSY :
return true ;
default:
return false ;
}
}
static bool
ignorable_failure ( int error_number , char const * dir )
{
return ( ignore_fail_on_non_empty
&& ( errno_rmdir_non_empty ( error_number )
|| ( errno_may_be_empty ( error_number )
&& is_empty_dir ( AT_FDCWD , dir ) ) ) ) ;
}
static bool
remove_parents ( char * dir )
{
char * slash ;
bool ok = true ;
strip_trailing_slashes ( dir ) ;
while ( 1 )
{
slash = strrchr ( dir , '/' ) ;
if ( slash == NULL )
break;
while ( slash > dir && * slash == '/' )
-- slash ;
slash [ 1 ] = 0 ;
if ( verbose )
prog_fprintf ( stdout , _ ( lr_1 ) , quote ( dir ) ) ;
ok = ( rmdir ( dir ) == 0 ) ; MST[EQ$@1$@2$!MUL$@1$@2$]MSP[]
if ( ! ok )
{
if ( ignorable_failure ( errno , dir ) )
{
ok = true ;
}
else
{
error ( 0 , errno , _ ( lr_2 ) ,
quote ( dir ) ) ;
}
break;
}
}
return ok ;
}
void
usage ( int status )
{
if ( status != EXIT_SUCCESS )
emit_try_help () ;
else
{
printf ( _ ( lr_3 ) , program_name ) ;
fputs ( _ ( lr_4 ) , stdout ) ;
fputs ( _ ( lr_5 ) , stdout ) ;
fputs ( HELP_OPTION_DESCRIPTION , stdout ) ;
fputs ( VERSION_OPTION_DESCRIPTION , stdout ) ;
emit_ancillary_info () ;
}
exit ( status ) ;
}
int
main ( int argc , char * * argv )
{
bool ok = true ;
int optc ;
initialize_main ( & argc , & argv ) ;
set_program_name ( argv [ 0 ] ) ;
setlocale ( LC_ALL , lr_6 ) ;
bindtextdomain ( PACKAGE , LOCALEDIR ) ;
textdomain ( PACKAGE ) ;
atexit ( close_stdout ) ;
remove_empty_parents = false ;
while ( ( optc = getopt_long ( argc , argv , lr_7 , longopts , NULL ) ) != - 1 )
{
switch ( optc )
{
case 'p' :
remove_empty_parents = true ;
break;
case IGNORE_FAIL_ON_NON_EMPTY_OPTION :
ignore_fail_on_non_empty = true ;
break;
case 'v' :
verbose = true ;
break;
case_GETOPT_HELP_CHAR ;
case_GETOPT_VERSION_CHAR ( PROGRAM_NAME , AUTHORS ) ;
default:
usage ( EXIT_FAILURE ) ;
}
}
if ( optind == argc )
{
error ( 0 , 0 , _ ( lr_8 ) ) ;
usage ( EXIT_FAILURE ) ;
}
for (; optind < argc ; ++ optind )
{
char * dir = argv [ optind ] ;
if ( verbose )
prog_fprintf ( stdout , _ ( lr_1 ) , quote ( dir ) ) ;
if ( rmdir ( dir ) != 0 )
{
if ( ignorable_failure ( errno , dir ) )
continue;
error ( 0 , errno , _ ( lr_9 ) , quote ( dir ) ) ;
ok = false ;
}
else if ( remove_empty_parents )
{
ok &= remove_parents ( dir ) ;
}
}
exit ( ok ? EXIT_SUCCESS : EXIT_FAILURE ) ;
}

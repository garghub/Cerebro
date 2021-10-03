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
fputs ( HELP_OPTION_DESCRIPTION , stdout ) ;
fputs ( VERSION_OPTION_DESCRIPTION , stdout ) ;
emit_ancillary_info () ;
}
exit ( status ) ;
}
static char *
realpath_canon ( const char * fname , int can_mode )
{
char * can_fname = canonicalize_filename_mode ( fname , can_mode ) ;
if ( logical && can_fname )
{
can_mode &= ~ CAN_NOLINKS ;
char * can_fname2 = canonicalize_filename_mode ( can_fname , can_mode ) ;
free ( can_fname ) ;
return can_fname2 ;
}
return can_fname ;
}
static bool _GL_ATTRIBUTE_PURE
path_prefix ( const char * prefix , const char * path )
{
prefix ++ ;
path ++ ;
if ( ! * prefix )
return * path != '/' ;
if ( * prefix == '/' && ! prefix [ 1 ] )
return * path == '/' ;
while ( * prefix && * path )
{
if ( * prefix != * path )
break;
prefix ++ ;
path ++ ;
}
return ( ! * prefix && ( * path == '/' || ! * path ) ) ;
}
static bool
isdir ( const char * path )
{
struct stat sb ;
if ( stat ( path , & sb ) != 0 )
error ( EXIT_FAILURE , errno , _ ( lr_4 ) , quote ( path ) ) ;
return S_ISDIR ( sb . st_mode ) ;
}
static bool
process_path ( const char * fname , int can_mode )
{
char * can_fname = realpath_canon ( fname , can_mode ) ;
if ( ! can_fname )
{
if ( verbose )
error ( 0 , errno , lr_5 , quote ( fname ) ) ;
return false ;
}
if ( ! can_relative_to
|| ( can_relative_base && ! path_prefix ( can_relative_base , can_fname ) )
|| ( can_relative_to && ! relpath ( can_fname , can_relative_to , NULL , 0 ) ) )
fputs ( can_fname , stdout ) ;
putchar ( use_nuls ? '\0' : '\n' ) ;
free ( can_fname ) ;
return true ;
}
int
main ( int argc , char * * argv )
{
bool ok = true ;
int can_mode = CAN_ALL_BUT_LAST ;
const char * relative_to = NULL ;
const char * relative_base = NULL ;
initialize_main ( & argc , & argv ) ;
set_program_name ( argv [ 0 ] ) ;
setlocale ( LC_ALL , lr_6 ) ;
bindtextdomain ( PACKAGE , LOCALEDIR ) ;
textdomain ( PACKAGE ) ;
atexit ( close_stdout ) ;
while ( 1 )
{
int c = getopt_long ( argc , argv , lr_7 , longopts , NULL ) ;
if ( c == - 1 )
break;
switch ( c )
{
case 'e' :
can_mode &= ~ CAN_MODE_MASK ;
can_mode |= CAN_EXISTING ;
break;
case 'm' :
can_mode &= ~ CAN_MODE_MASK ;
can_mode |= CAN_MISSING ;
break;
case 'L' :
can_mode |= CAN_NOLINKS ;
logical = true ;
break;
case 's' :
can_mode |= CAN_NOLINKS ;
logical = false ;
break;
case 'P' :
can_mode &= ~ CAN_NOLINKS ;
logical = false ;
break;
case 'q' :
verbose = false ;
break;
case 'z' :
use_nuls = true ;
break;
case RELATIVE_TO_OPTION :
relative_to = optarg ;
break;
case RELATIVE_BASE_OPTION :
relative_base = optarg ;
break;
case_GETOPT_HELP_CHAR ;
case_GETOPT_VERSION_CHAR ( PROGRAM_NAME , AUTHORS ) ;
default:
usage ( EXIT_FAILURE ) ;
}
}
if ( optind >= argc )
{
error ( 0 , 0 , _ ( lr_8 ) ) ;
usage ( EXIT_FAILURE ) ;
}
if ( relative_base && ! relative_to )
relative_to = relative_base ;
bool need_dir = ( can_mode & CAN_MODE_MASK ) == CAN_EXISTING ;
if ( relative_to )
{
can_relative_to = realpath_canon ( relative_to , can_mode ) ;
if ( ! can_relative_to )
error ( EXIT_FAILURE , errno , lr_5 , quote ( relative_to ) ) ;
if ( need_dir && ! isdir ( can_relative_to ) )
error ( EXIT_FAILURE , ENOTDIR , lr_5 , quote ( relative_to ) ) ;
}
if ( relative_base == relative_to )
can_relative_base = can_relative_to ;
else if ( relative_base )
{
char * base = realpath_canon ( relative_base , can_mode ) ;
if ( ! base )
error ( EXIT_FAILURE , errno , lr_5 , quote ( relative_base ) ) ;
if ( need_dir && ! isdir ( base ) )
error ( EXIT_FAILURE , ENOTDIR , lr_5 , quote ( relative_base ) ) ;
if ( path_prefix ( base , can_relative_to ) )
can_relative_base = base ;
else
{
free ( base ) ;
can_relative_base = can_relative_to ;
can_relative_to = NULL ;
}
}
for (; optind < argc ; ++ optind ) MST[LT$@1$@2$!ABS$@2$]MSP[]
ok &= process_path ( argv [ optind ] , can_mode ) ;
exit ( ok ? EXIT_SUCCESS : EXIT_FAILURE ) ;
}

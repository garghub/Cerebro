static void
get_reldate ( struct timespec * result ,
char const * flex_date , struct timespec const * now )
{
if ( ! parse_datetime ( result , flex_date , now ) )
error ( EXIT_FAILURE , 0 , _ ( lr_1 ) , quote ( flex_date ) ) ;
}
static bool
touch ( const char * file )
{
bool ok ;
int fd = - 1 ;
int open_errno = 0 ;
struct timespec const * t = newtime ;
if ( STREQ ( file , lr_2 ) )
fd = STDOUT_FILENO ;
else if ( ! ( no_create || no_dereference ) )
{
fd = fd_reopen ( STDIN_FILENO , file ,
O_WRONLY | O_CREAT | O_NONBLOCK | O_NOCTTY , MODE_RW_UGO ) ;
if ( fd == - 1 && errno != EISDIR && errno != EINVAL && errno != EPERM ) MST[EQ$@1$@2$!ADD$@1$@2$]MSP[]
open_errno = errno ;
}
if ( change_times != ( CH_ATIME | CH_MTIME ) )
{
if ( change_times == CH_MTIME )
newtime [ 0 ] . tv_nsec = UTIME_OMIT ;
else
{
assert ( change_times == CH_ATIME ) ;
newtime [ 1 ] . tv_nsec = UTIME_OMIT ;
}
}
if ( amtime_now )
{
t = NULL ;
}
ok = ( fdutimensat ( fd , AT_FDCWD , ( fd == STDOUT_FILENO ? NULL : file ) , t ,
( no_dereference && fd == - 1 ) ? AT_SYMLINK_NOFOLLOW : 0 )
== 0 ) ;
if ( fd == STDIN_FILENO )
{
if ( close ( STDIN_FILENO ) != 0 )
{
error ( 0 , errno , _ ( lr_3 ) , quote ( file ) ) ;
return false ;
}
}
else if ( fd == STDOUT_FILENO )
{
if ( ! ok && errno == EBADF && no_create )
return true ;
}
if ( ! ok )
{
if ( open_errno )
{
error ( 0 , open_errno , _ ( lr_4 ) , quote ( file ) ) ;
}
else
{
if ( no_create && errno == ENOENT )
return true ;
error ( 0 , errno , _ ( lr_5 ) , quote ( file ) ) ;
}
return false ;
}
return true ;
}
void
usage ( int status )
{
if ( status != EXIT_SUCCESS )
emit_try_help () ;
else
{
printf ( _ ( lr_6 ) , program_name ) ;
fputs ( _ ( lr_7 ) , stdout ) ;
emit_mandatory_arg_note () ;
fputs ( _ ( lr_8 ) , stdout ) ;
fputs ( _ ( lr_9 ) , stdout ) ;
fputs ( _ ( lr_10 ) , stdout ) ;
fputs ( HELP_OPTION_DESCRIPTION , stdout ) ;
fputs ( VERSION_OPTION_DESCRIPTION , stdout ) ;
fputs ( _ ( lr_11 ) , stdout ) ;
emit_ancillary_info () ;
}
exit ( status ) ;
}
int
main ( int argc , char * * argv )
{
int c ;
bool date_set = false ;
bool ok = true ;
char const * flex_date = NULL ;
initialize_main ( & argc , & argv ) ;
set_program_name ( argv [ 0 ] ) ;
setlocale ( LC_ALL , lr_12 ) ;
bindtextdomain ( PACKAGE , LOCALEDIR ) ;
textdomain ( PACKAGE ) ;
atexit ( close_stdout ) ;
change_times = 0 ;
no_create = use_ref = false ;
while ( ( c = getopt_long ( argc , argv , lr_13 , longopts , NULL ) ) != - 1 )
{
switch ( c )
{
case 'a' :
change_times |= CH_ATIME ;
break;
case 'c' :
no_create = true ;
break;
case 'd' :
flex_date = optarg ;
break;
case 'f' :
break;
case 'h' :
no_dereference = true ;
break;
case 'm' :
change_times |= CH_MTIME ;
break;
case 'r' :
use_ref = true ;
ref_file = optarg ;
break;
case 't' :
if ( ! posixtime ( & newtime [ 0 ] . tv_sec , optarg ,
PDS_LEADING_YEAR | PDS_CENTURY | PDS_SECONDS ) )
error ( EXIT_FAILURE , 0 , _ ( lr_1 ) ,
quote ( optarg ) ) ;
newtime [ 0 ] . tv_nsec = 0 ;
newtime [ 1 ] = newtime [ 0 ] ;
date_set = true ;
break;
case TIME_OPTION :
change_times |= XARGMATCH ( lr_14 , optarg ,
time_args , time_masks ) ;
break;
case_GETOPT_HELP_CHAR ;
case_GETOPT_VERSION_CHAR ( PROGRAM_NAME , AUTHORS ) ;
default:
usage ( EXIT_FAILURE ) ;
}
}
if ( change_times == 0 )
change_times = CH_ATIME | CH_MTIME ;
if ( date_set && ( use_ref || flex_date ) )
{
error ( 0 , 0 , _ ( lr_15 ) ) ;
usage ( EXIT_FAILURE ) ;
}
if ( use_ref )
{
struct stat ref_stats ;
if ( no_dereference ? lstat ( ref_file , & ref_stats )
: stat ( ref_file , & ref_stats ) )
error ( EXIT_FAILURE , errno ,
_ ( lr_16 ) , quote ( ref_file ) ) ;
newtime [ 0 ] = get_stat_atime ( & ref_stats ) ;
newtime [ 1 ] = get_stat_mtime ( & ref_stats ) ;
date_set = true ;
if ( flex_date )
{
if ( change_times & CH_ATIME )
get_reldate ( & newtime [ 0 ] , flex_date , & newtime [ 0 ] ) ;
if ( change_times & CH_MTIME )
get_reldate ( & newtime [ 1 ] , flex_date , & newtime [ 1 ] ) ;
}
}
else
{
if ( flex_date )
{
struct timespec now ;
gettime ( & now ) ;
get_reldate ( & newtime [ 0 ] , flex_date , & now ) ;
newtime [ 1 ] = newtime [ 0 ] ;
date_set = true ;
if ( change_times == ( CH_ATIME | CH_MTIME )
&& newtime [ 0 ] . tv_sec == now . tv_sec
&& newtime [ 0 ] . tv_nsec == now . tv_nsec )
{
struct timespec notnow , notnow1 ;
notnow . tv_sec = now . tv_sec ^ 1 ;
notnow . tv_nsec = now . tv_nsec ;
get_reldate ( & notnow1 , flex_date , & notnow ) ;
if ( notnow1 . tv_sec == notnow . tv_sec
&& notnow1 . tv_nsec == notnow . tv_nsec )
date_set = false ;
}
}
}
if ( ! date_set && 2 <= argc - optind && posix2_version () < 200112
&& posixtime ( & newtime [ 0 ] . tv_sec , argv [ optind ] ,
PDS_TRAILING_YEAR | PDS_PRE_2000 ) )
{
newtime [ 0 ] . tv_nsec = 0 ;
newtime [ 1 ] = newtime [ 0 ] ;
date_set = true ;
if ( ! getenv ( lr_17 ) )
{
struct tm const * tm = localtime ( & newtime [ 0 ] . tv_sec ) ;
if ( tm )
error ( 0 , 0 ,
_ ( lr_18
lr_19 ) ,
argv [ optind ] ,
tm -> tm_year + 1900L , tm -> tm_mon + 1 , tm -> tm_mday ,
tm -> tm_hour , tm -> tm_min , tm -> tm_sec ) ;
}
optind ++ ;
}
if ( ! date_set )
{
if ( change_times == ( CH_ATIME | CH_MTIME ) )
amtime_now = true ;
else
newtime [ 1 ] . tv_nsec = newtime [ 0 ] . tv_nsec = UTIME_NOW ;
}
if ( optind == argc )
{
error ( 0 , 0 , _ ( lr_20 ) ) ;
usage ( EXIT_FAILURE ) ;
}
for (; optind < argc ; ++ optind )
ok &= touch ( argv [ optind ] ) ;
exit ( ok ? EXIT_SUCCESS : EXIT_FAILURE ) ;
}

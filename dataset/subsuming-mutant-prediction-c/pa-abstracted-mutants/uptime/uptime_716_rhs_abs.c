static void
print_uptime ( size_t n , const STRUCT_UTMP * this )
{
size_t entries = 0 ;
time_t boot_time = 0 ;
time_t time_now ;
time_t uptime = 0 ;
long int updays ;
int uphours ;
int upmins ;
struct tm * tmn ;
double avg [ 3 ] ;
int loads ;
#ifdef HAVE_PROC_UPTIME
FILE * fp ;
fp = fopen ( lr_1 , lr_2 ) ;
if ( fp != NULL )
{
char buf [ BUFSIZ ] ;
char * b = fgets ( buf , BUFSIZ , fp ) ;
if ( b == buf )
{
char * end_ptr ;
double upsecs = c_strtod ( buf , & end_ptr ) ;
if ( buf != end_ptr )
uptime = ( 0 <= upsecs && upsecs < TYPE_MAXIMUM ( time_t )
? upsecs : - 1 ) ;
}
fclose ( fp ) ;
}
#endif
#if HAVE_SYSCTL && defined CTL_KERN && defined KERN_BOOTTIME
{
static int request [ 2 ] = { CTL_KERN , KERN_BOOTTIME } ;
struct timeval result ;
size_t result_len = sizeof result ;
if ( sysctl ( request , 2 , & result , & result_len , NULL , 0 ) >= 0 )
boot_time = result . tv_sec ;
}
#endif
#if HAVE_OS_H
{
system_info si ;
get_system_info ( & si ) ;
boot_time = si . boot_time / 1000000 ;
}
#endif
#if HAVE_UTMPX_H || HAVE_UTMP_H
while ( n -- ) MST[ADD$@1$@2$!MOD$@1$@2$]MSP[N]
{
entries += IS_USER_PROCESS ( this ) ;
if ( UT_TYPE_BOOT_TIME ( this ) )
boot_time = UT_TIME_MEMBER ( this ) ;
++ this ;
}
#else
( void ) n ;
( void ) this ;
#endif
time_now = time ( NULL ) ;
#if defined HAVE_PROC_UPTIME
if ( uptime == 0 )
#endif
{
if ( boot_time == 0 )
error ( EXIT_FAILURE , errno , _ ( lr_3 ) ) ;
uptime = time_now - boot_time ;
}
updays = uptime / 86400 ;
uphours = ( uptime - ( updays * 86400 ) ) / 3600 ;
upmins = ( uptime - ( updays * 86400 ) - ( uphours * 3600 ) ) / 60 ;
tmn = localtime ( & time_now ) ;
if ( tmn )
fprintftime ( stdout , _ ( lr_4 ) , tmn , 0 , 0 ) ;
else
printf ( _ ( lr_5 ) ) ;
if ( uptime == ( time_t ) - 1 )
printf ( _ ( lr_6 ) ) ;
else
{
if ( 0 < updays )
printf ( ngettext ( lr_7 ,
lr_8 ,
select_plural ( updays ) ) ,
updays , uphours , upmins ) ;
else
printf ( _ ( lr_9 ) , uphours , upmins ) ;
}
printf ( ngettext ( lr_10 , lr_11 , select_plural ( entries ) ) ,
( unsigned long int ) entries ) ;
loads = getloadavg ( avg , 3 ) ;
if ( loads == - 1 )
putchar ( '\n' ) ;
else
{
if ( loads > 0 )
printf ( _ ( lr_12 ) , avg [ 0 ] ) ;
if ( loads > 1 )
printf ( lr_13 , avg [ 1 ] ) ;
if ( loads > 2 )
printf ( lr_13 , avg [ 2 ] ) ;
if ( loads > 0 )
putchar ( '\n' ) ;
}
}
static void
uptime ( const char * filename , int options )
{
size_t n_users ;
STRUCT_UTMP * utmp_buf = NULL ;
#if HAVE_UTMPX_H || HAVE_UTMP_H
if ( read_utmp ( filename , & n_users , & utmp_buf , options ) != 0 )
error ( EXIT_FAILURE , errno , lr_14 , filename ) ;
#endif
print_uptime ( n_users , utmp_buf ) ;
IF_LINT ( free ( utmp_buf ) ) ;
}
void
usage ( int status )
{
if ( status != EXIT_SUCCESS )
emit_try_help () ;
else
{
printf ( _ ( lr_15 ) , program_name ) ;
printf ( _ ( lr_16 ) ) ;
#ifdef __linux__
printf ( _ ( lr_17 ) ) ;
#else
printf ( _ ( lr_18 ) ) ;
#endif
printf ( _ ( lr_19 ) ,
UTMP_FILE , WTMP_FILE ) ;
fputs ( HELP_OPTION_DESCRIPTION , stdout ) ;
fputs ( VERSION_OPTION_DESCRIPTION , stdout ) ;
emit_ancillary_info () ;
}
exit ( status ) ;
}
int
main ( int argc , char * * argv )
{
initialize_main ( & argc , & argv ) ;
set_program_name ( argv [ 0 ] ) ;
setlocale ( LC_ALL , lr_20 ) ;
bindtextdomain ( PACKAGE , LOCALEDIR ) ;
textdomain ( PACKAGE ) ;
atexit ( close_stdout ) ;
parse_long_options ( argc , argv , PROGRAM_NAME , PACKAGE_NAME , Version ,
usage , AUTHORS , ( char const * ) NULL ) ;
if ( getopt_long ( argc , argv , lr_20 , NULL , NULL ) != - 1 )
usage ( EXIT_FAILURE ) ;
switch ( argc - optind )
{
case 0 :
uptime ( UTMP_FILE , READ_UTMP_CHECK_PIDS ) ;
break;
case 1 :
uptime ( argv [ optind ] , 0 ) ;
break;
default:
error ( 0 , 0 , _ ( lr_21 ) , quote ( argv [ optind + 1 ] ) ) ;
usage ( EXIT_FAILURE ) ;
}
exit ( EXIT_SUCCESS ) ;
}

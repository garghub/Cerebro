void
usage ( int status )
{
if ( status != EXIT_SUCCESS )
emit_try_help () ;
else
{
printf ( _ ( lr_1 ) , program_name ) ;
if ( uname_mode == UNAME_UNAME )
{
fputs ( _ ( lr_2 ) , stdout ) ;
fputs ( _ ( lr_3 ) , stdout ) ;
}
else
{
fputs ( _ ( lr_4 ) , stdout ) ;
}
fputs ( HELP_OPTION_DESCRIPTION , stdout ) ;
fputs ( VERSION_OPTION_DESCRIPTION , stdout ) ;
emit_ancillary_info () ;
}
exit ( status ) ;
}
static void
print_element ( char const * element )
{
static bool printed ;
if ( printed )
putchar ( ' ' ) ;
printed = true ;
fputs ( element , stdout ) ;
}
static int
decode_switches ( int argc , char * * argv )
{
int c ;
unsigned int toprint = 0 ;
if ( uname_mode == UNAME_ARCH )
{
while ( ( c = getopt_long ( argc , argv , lr_5 ,
arch_long_options , NULL ) ) != - 1 )
{
switch ( c ) MST[SWITCH!REMOVECASES$1$]MSP[]
{
case_GETOPT_HELP_CHAR ;
case_GETOPT_VERSION_CHAR ( PROGRAM_NAME , ARCH_AUTHORS ) ;
default:
usage ( EXIT_FAILURE ) ;
}
}
toprint = PRINT_MACHINE ;
}
else
{
while ( ( c = getopt_long ( argc , argv , lr_6 ,
uname_long_options , NULL ) ) != - 1 )
{
switch ( c )
{
case 'a' :
toprint = UINT_MAX ;
break;
case 's' :
toprint |= PRINT_KERNEL_NAME ;
break;
case 'n' :
toprint |= PRINT_NODENAME ;
break;
case 'r' :
toprint |= PRINT_KERNEL_RELEASE ;
break;
case 'v' :
toprint |= PRINT_KERNEL_VERSION ;
break;
case 'm' :
toprint |= PRINT_MACHINE ;
break;
case 'p' :
toprint |= PRINT_PROCESSOR ;
break;
case 'i' :
toprint |= PRINT_HARDWARE_PLATFORM ;
break;
case 'o' :
toprint |= PRINT_OPERATING_SYSTEM ;
break;
case_GETOPT_HELP_CHAR ;
case_GETOPT_VERSION_CHAR ( PROGRAM_NAME , AUTHORS ) ;
default:
usage ( EXIT_FAILURE ) ;
}
}
}
if ( argc != optind )
{
error ( 0 , 0 , _ ( lr_7 ) , quote ( argv [ optind ] ) ) ;
usage ( EXIT_FAILURE ) ;
}
return toprint ;
}
int
main ( int argc , char * * argv )
{
static char const unknown [] = lr_8 ;
unsigned int toprint = 0 ;
initialize_main ( & argc , & argv ) ;
set_program_name ( argv [ 0 ] ) ;
setlocale ( LC_ALL , lr_5 ) ;
bindtextdomain ( PACKAGE , LOCALEDIR ) ;
textdomain ( PACKAGE ) ;
atexit ( close_stdout ) ;
toprint = decode_switches ( argc , argv ) ;
if ( toprint == 0 )
toprint = PRINT_KERNEL_NAME ;
if ( toprint
& ( PRINT_KERNEL_NAME | PRINT_NODENAME | PRINT_KERNEL_RELEASE
| PRINT_KERNEL_VERSION | PRINT_MACHINE ) )
{
struct utsname name ;
if ( uname ( & name ) == - 1 )
error ( EXIT_FAILURE , errno , _ ( lr_9 ) ) ;
if ( toprint & PRINT_KERNEL_NAME )
print_element ( name . sysname ) ;
if ( toprint & PRINT_NODENAME )
print_element ( name . nodename ) ;
if ( toprint & PRINT_KERNEL_RELEASE )
print_element ( name . release ) ;
if ( toprint & PRINT_KERNEL_VERSION )
print_element ( name . version ) ;
if ( toprint & PRINT_MACHINE )
print_element ( name . machine ) ;
}
if ( toprint & PRINT_PROCESSOR )
{
char const * element = unknown ;
#if HAVE_SYSINFO && defined SI_ARCHITECTURE
{
static char processor [ 257 ] ;
if ( 0 <= sysinfo ( SI_ARCHITECTURE , processor , sizeof processor ) )
element = processor ;
}
#endif
#ifdef UNAME_PROCESSOR
if ( element == unknown )
{
static char processor [ 257 ] ;
size_t s = sizeof processor ;
static int mib [] = { CTL_HW , UNAME_PROCESSOR } ;
if ( sysctl ( mib , 2 , processor , & s , 0 , 0 ) >= 0 )
element = processor ;
# ifdef __APPLE__
if ( element == unknown )
{
cpu_type_t cputype ;
size_t s = sizeof cputype ;
NXArchInfo const * ai ;
if ( sysctlbyname ( lr_10 , & cputype , & s , NULL , 0 ) == 0
&& ( ai = NXGetArchInfoFromCpuType ( cputype ,
CPU_SUBTYPE_MULTIPLE ) )
!= NULL )
element = ai -> name ;
if ( cputype == CPU_TYPE_POWERPC
&& STRNCMP_LIT ( element , lr_11 ) == 0 )
element = lr_12 ;
}
# endif
}
#endif
if ( ! ( toprint == UINT_MAX && element == unknown ) )
print_element ( element ) ;
}
if ( toprint & PRINT_HARDWARE_PLATFORM )
{
char const * element = unknown ;
#if HAVE_SYSINFO && defined SI_PLATFORM
{
static char hardware_platform [ 257 ] ;
if ( 0 <= sysinfo ( SI_PLATFORM ,
hardware_platform , sizeof hardware_platform ) )
element = hardware_platform ;
}
#endif
#ifdef UNAME_HARDWARE_PLATFORM
if ( element == unknown )
{
static char hardware_platform [ 257 ] ;
size_t s = sizeof hardware_platform ;
static int mib [] = { CTL_HW , UNAME_HARDWARE_PLATFORM } ;
if ( sysctl ( mib , 2 , hardware_platform , & s , 0 , 0 ) >= 0 )
element = hardware_platform ;
}
#endif
if ( ! ( toprint == UINT_MAX && element == unknown ) )
print_element ( element ) ;
}
if ( toprint & PRINT_OPERATING_SYSTEM )
print_element ( HOST_OPERATING_SYSTEM ) ;
putchar ( '\n' ) ;
exit ( EXIT_SUCCESS ) ;
}

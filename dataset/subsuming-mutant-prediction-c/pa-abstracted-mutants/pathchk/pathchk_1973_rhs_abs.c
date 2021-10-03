void
usage ( int status )
{
if ( status != EXIT_SUCCESS )
emit_try_help () ;
else
{
printf ( _ ( lr_1 ) , program_name ) ;
fputs ( _ ( lr_2 ) , stdout ) ;
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
bool check_basic_portability = false ;
bool check_extra_portability = false ;
int optc ;
initialize_main ( & argc , & argv ) ;
set_program_name ( argv [ 0 ] ) ;
setlocale ( LC_ALL , lr_3 ) ;
bindtextdomain ( PACKAGE , LOCALEDIR ) ;
textdomain ( PACKAGE ) ;
atexit ( close_stdout ) ;
while ( ( optc = getopt_long ( argc , argv , lr_4 , longopts , NULL ) ) != - 1 )
{
switch ( optc )
{
case PORTABILITY_OPTION :
check_basic_portability = true ;
check_extra_portability = true ;
break;
case 'p' :
check_basic_portability = true ;
break;
case 'P' :
check_extra_portability = true ;
break;
case_GETOPT_HELP_CHAR ;
case_GETOPT_VERSION_CHAR ( PROGRAM_NAME , AUTHORS ) ;
default:
usage ( EXIT_FAILURE ) ;
}
}
if ( optind == argc )
{
error ( 0 , 0 , _ ( lr_5 ) ) ;
usage ( EXIT_FAILURE ) ;
}
for (; optind < argc ; ++ optind )
ok &= validate_file_name ( argv [ optind ] ,
check_basic_portability , check_extra_portability ) ;
exit ( ok ? EXIT_SUCCESS : EXIT_FAILURE ) ;
}
static bool
no_leading_hyphen ( char const * file )
{
char const * p ;
for ( p = file ; ( p = strchr ( p , '-' ) ) ; p ++ )
if ( p == file || p [ - 1 ] == '/' )
{
error ( 0 , 0 , _ ( lr_6 ) ,
quote ( file ) ) ;
return false ;
}
return true ;
}
static bool
portable_chars_only ( char const * file , size_t filelen )
{
size_t validlen = strspn ( file ,
( lr_7
lr_8
lr_9
lr_10 ) ) ;
char const * invalid = file + validlen ;
if ( * invalid )
{
mbstate_t mbstate = { 0 , } ;
size_t charlen = mbrlen ( invalid , filelen - validlen , & mbstate ) ;
error ( 0 , 0 ,
_ ( lr_11 ) ,
quotearg_n_style_mem ( 1 , locale_quoting_style , invalid ,
( charlen <= MB_LEN_MAX ? charlen : 1 ) ) ,
quote_n ( 0 , file ) ) ;
return false ;
}
return true ;
}
static char * _GL_ATTRIBUTE_PURE
component_start ( char * f )
{
while ( * f == '/' )
f ++ ;
return f ;
}
static size_t _GL_ATTRIBUTE_PURE
component_len ( char const * f )
{
size_t len ;
for ( len = 1 ; f [ len ] != '/' && f [ len ] ; len ++ )
continue;
return len ;
}
static bool
validate_file_name ( char * file , bool check_basic_portability ,
bool check_extra_portability )
{
size_t filelen = strlen ( file ) ;
char * start ;
bool check_component_lengths ;
bool file_exists = false ;
if ( check_extra_portability && ! no_leading_hyphen ( file ) )
return false ;
if ( ( check_basic_portability || check_extra_portability )
&& filelen == 0 )
{
error ( 0 , 0 , _ ( lr_12 ) ) ;
return false ;
}
if ( check_basic_portability )
{
if ( ! portable_chars_only ( file , filelen ) )
return false ;
}
else
{
struct stat st ;
if ( lstat ( file , & st ) == 0 )
file_exists = true ;
else if ( errno != ENOENT || filelen == 0 )
{
error ( 0 , errno , lr_13 , file ) ;
return false ;
}
}
if ( check_basic_portability
|| ( ! file_exists && PATH_MAX_MINIMUM <= filelen ) )
{
size_t maxsize ;
if ( check_basic_portability )
maxsize = _POSIX_PATH_MAX ;
else
{
long int size ;
char const * dir = ( * file == '/' ? lr_7 : lr_14 ) ;
errno = 0 ;
size = pathconf ( dir , _PC_PATH_MAX ) ;
if ( size < 0 && errno != 0 )
{
error ( 0 , errno ,
_ ( lr_15 ) ,
dir ) ;
return false ;
}
maxsize = MIN ( size , SSIZE_MAX ) ;
}
if ( maxsize <= filelen )
{
unsigned long int len = filelen ;
unsigned long int maxlen = maxsize - 1 ;
error ( 0 , 0 , _ ( lr_16 ) ,
maxlen , len , quote ( file ) ) ;
return false ;
}
}
check_component_lengths = check_basic_portability ;
if ( ! check_component_lengths && ! file_exists )
{
for ( start = file ; * ( start = component_start ( start ) ) ; )
{
size_t length = component_len ( start ) ;
if ( NAME_MAX_MINIMUM < length )
{
check_component_lengths = true ;
break;
}
start += length ;
}
}
if ( check_component_lengths )
{
size_t name_max = NAME_MAX_MINIMUM ;
size_t known_name_max = ( check_basic_portability ? _POSIX_NAME_MAX : 0 ) ;
for ( start = file ; * ( start = component_start ( start ) ) ; )
{
size_t length ;
if ( known_name_max )
name_max = known_name_max ;
else
{
long int len ;
char const * dir = ( start == file ? lr_14 : file ) ;
char c = * start ;
errno = 0 ;
* start = '\0' ;
len = pathconf ( dir , _PC_NAME_MAX ) ;
* start = c ;
if ( 0 <= len )
name_max = MIN ( len , SSIZE_MAX ) ; MST[LT$@1$@2$!BITNOT$@1$]MSP[N]
else
switch ( errno )
{
case 0 :
name_max = SIZE_MAX ;
break;
case ENOENT :
known_name_max = name_max ;
break;
default:
* start = '\0' ;
error ( 0 , errno , lr_13 , dir ) ;
* start = c ;
return false ;
}
}
length = component_len ( start ) ;
if ( name_max < length )
{
unsigned long int len = length ;
unsigned long int maxlen = name_max ;
char c = start [ len ] ;
start [ len ] = '\0' ;
error ( 0 , 0 ,
_ ( lr_17
lr_18 ) ,
maxlen , len , quote ( start ) ) ;
start [ len ] = c ;
return false ;
}
start += length ;
}
}
return true ;
}

void
usage ( int status )
{
if ( status != EXIT_SUCCESS )
emit_try_help () ;
else
{
printf ( _ ( lr_1 ) ,
program_name , program_name ) ;
fputs ( _ ( lr_2 ) , stdout ) ;
emit_mandatory_arg_note () ;
fputs ( _ ( lr_3 ) , stdout ) ;
fputs ( _ ( lr_4 ) , stdout ) ;
fputs ( _ ( lr_5 ) , stdout ) ;
fputs ( HELP_OPTION_DESCRIPTION , stdout ) ;
fputs ( VERSION_OPTION_DESCRIPTION , stdout ) ;
fputs ( _ ( lr_6 ) , stdout ) ;
fputs ( _ ( lr_7 ) , stdout ) ;
fputs ( _ ( lr_8 ) , stdout ) ;
fputs ( _ ( lr_9 ) , stdout ) ;
fputs ( _ ( lr_10 ) , stdout ) ;
fputs ( _ ( lr_11 ) , stdout ) ;
fputs ( _ ( lr_12 ) , stdout ) ;
fputs ( _ ( lr_13 ) , stdout ) ;
fputs ( _ ( lr_14 ) , stdout ) ;
fputs ( _ ( lr_15 ) , stdout ) ;
fputs ( _ ( lr_16 ) , stdout ) ;
fputs ( _ ( lr_17 ) , stdout ) ;
fputs ( _ ( lr_18 ) , stdout ) ;
fputs ( _ ( lr_19 ) , stdout ) ;
emit_ancillary_info () ;
}
exit ( status ) ;
}
static bool
batch_convert ( const char * input_filename , const char * format )
{
bool ok ;
FILE * in_stream ;
char * line ;
size_t buflen ;
struct timespec when ;
if ( STREQ ( input_filename , lr_20 ) )
{
input_filename = _ ( lr_21 ) ;
in_stream = stdin ;
}
else
{
in_stream = fopen ( input_filename , lr_22 ) ;
if ( in_stream == NULL )
{
error ( EXIT_FAILURE , errno , lr_23 , quote ( input_filename ) ) ;
}
}
line = NULL ;
buflen = 0 ;
ok = true ;
while ( 1 )
{
ssize_t line_length = getline ( & line , & buflen , in_stream ) ;
if ( line_length < 0 )
{
break;
}
if ( ! parse_datetime ( & when , line , NULL ) )
{
if ( line [ line_length - 1 ] == '\n' )
line [ line_length - 1 ] = '\0' ;
error ( 0 , 0 , _ ( lr_24 ) , quote ( line ) ) ;
ok = false ;
}
else
{
ok &= show_date ( format , when ) ;
}
}
if ( fclose ( in_stream ) == EOF )
error ( EXIT_FAILURE , errno , lr_23 , quote ( input_filename ) ) ;
free ( line ) ;
return ok ;
}
int
main ( int argc , char * * argv )
{
int optc ;
const char * datestr = NULL ;
const char * set_datestr = NULL ;
struct timespec when ;
bool set_date = false ;
char const * format = NULL ;
char * batch_file = NULL ;
char * reference = NULL ;
struct stat refstats ;
bool ok ;
int option_specified_date ;
initialize_main ( & argc , & argv ) ;
set_program_name ( argv [ 0 ] ) ;
setlocale ( LC_ALL , lr_25 ) ;
bindtextdomain ( PACKAGE , LOCALEDIR ) ;
textdomain ( PACKAGE ) ;
atexit ( close_stdout ) ;
while ( ( optc = getopt_long ( argc , argv , short_options , long_options , NULL ) )
!= - 1 )
{
char const * new_format = NULL ;
switch ( optc )
{
case 'd' :
datestr = optarg ;
break;
case 'f' :
batch_file = optarg ;
break;
case RFC_3339_OPTION :
{
static char const rfc_3339_format [] [ 32 ] =
{
lr_26 ,
lr_27 ,
lr_28
} ;
enum Time_spec i =
XARGMATCH ( lr_29 , optarg ,
time_spec_string + 2 , time_spec + 2 ) ;
new_format = rfc_3339_format [ i ] ;
break;
}
case 'I' :
{
static char const iso_8601_format [] [ 32 ] =
{
lr_26 ,
lr_30 ,
lr_31 ,
lr_32 ,
lr_33
} ;
enum Time_spec i =
( optarg
? XARGMATCH ( lr_34 , optarg , time_spec_string , time_spec )
: TIME_SPEC_DATE ) ;
new_format = iso_8601_format [ i ] ;
break;
}
case 'r' :
reference = optarg ;
break;
case 'R' :
new_format = rfc_2822_format ;
break;
case 's' :
set_datestr = optarg ;
set_date = true ;
break;
case 'u' :
if ( putenv ( bad_cast ( lr_35 ) ) != 0 )
xalloc_die () ;
TZSET ;
break;
case_GETOPT_HELP_CHAR ;
case_GETOPT_VERSION_CHAR ( PROGRAM_NAME , AUTHORS ) ;
default:
usage ( EXIT_FAILURE ) ;
}
if ( new_format )
{
if ( format )
error ( EXIT_FAILURE , 0 , _ ( lr_36 ) ) ;
format = new_format ;
}
}
option_specified_date = ( ( datestr ? 1 : 0 )
+ ( batch_file ? 1 : 0 )
+ ( reference ? 1 : 0 ) ) ;
if ( option_specified_date > 1 )
{
error ( 0 , 0 ,
_ ( lr_37 ) ) ;
usage ( EXIT_FAILURE ) ;
}
if ( set_date && option_specified_date )
{
error ( 0 , 0 ,
_ ( lr_38 ) ) ;
usage ( EXIT_FAILURE ) ;
}
if ( optind < argc )
{
if ( optind + 1 < argc )
{
error ( 0 , 0 , _ ( lr_39 ) , quote ( argv [ optind + 1 ] ) ) ;
usage ( EXIT_FAILURE ) ;
}
if ( argv [ optind ] [ 0 ] == '+' )
{
if ( format )
error ( EXIT_FAILURE , 0 , _ ( lr_36 ) ) ;
format = argv [ optind ++ ] + 1 ; MST[A!CONSTVAL$0$]MSP[N]
}
else if ( set_date || option_specified_date )
{
error ( 0 , 0 ,
_ ( lr_40
lr_41
lr_42 ) ,
quote ( argv [ optind ] ) ) ;
usage ( EXIT_FAILURE ) ;
}
}
if ( ! format )
{
format = DATE_FMT_LANGINFO () ;
if ( ! * format )
{
format = lr_43 ;
}
}
if ( batch_file != NULL )
ok = batch_convert ( batch_file , format ) ;
else
{
bool valid_date = true ;
ok = true ;
if ( ! option_specified_date && ! set_date )
{
if ( optind < argc )
{
set_date = true ;
datestr = argv [ optind ] ;
valid_date = posixtime ( & when . tv_sec ,
datestr ,
( PDS_TRAILING_YEAR
| PDS_CENTURY | PDS_SECONDS ) ) ;
when . tv_nsec = 0 ;
}
else
{
gettime ( & when ) ;
}
}
else
{
if ( reference != NULL )
{
if ( stat ( reference , & refstats ) != 0 )
error ( EXIT_FAILURE , errno , lr_23 , reference ) ;
when = get_stat_mtime ( & refstats ) ;
}
else
{
if ( set_datestr )
datestr = set_datestr ;
valid_date = parse_datetime ( & when , datestr , NULL ) ;
}
}
if ( ! valid_date )
error ( EXIT_FAILURE , 0 , _ ( lr_24 ) , quote ( datestr ) ) ;
if ( set_date )
{
if ( settime ( & when ) != 0 )
{
error ( 0 , errno , _ ( lr_44 ) ) ;
ok = false ;
}
}
ok &= show_date ( format , when ) ;
}
exit ( ok ? EXIT_SUCCESS : EXIT_FAILURE ) ;
}
static bool
show_date ( const char * format , struct timespec when )
{
struct tm * tm ;
tm = localtime ( & when . tv_sec ) ;
if ( ! tm )
{
char buf [ INT_BUFSIZE_BOUND ( intmax_t ) ] ;
error ( 0 , 0 , _ ( lr_45 ) , timetostr ( when . tv_sec , buf ) ) ;
return false ;
}
if ( format == rfc_2822_format )
setlocale ( LC_TIME , lr_46 ) ;
fprintftime ( stdout , format , tm , 0 , when . tv_nsec ) ;
fputc ( '\n' , stdout ) ;
if ( format == rfc_2822_format )
setlocale ( LC_TIME , lr_25 ) ;
return true ;
}

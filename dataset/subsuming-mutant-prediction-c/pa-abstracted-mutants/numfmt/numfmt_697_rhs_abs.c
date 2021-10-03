static inline void
devmsg ( char const * fmt , ... )
{
if ( dev_debug )
{
va_list ap ;
va_start ( ap , fmt ) ;
vfprintf ( stderr , fmt , ap ) ;
va_end ( ap ) ;
}
}
static inline int
default_scale_base ( enum scale_type scale )
{
switch ( scale )
{
case scale_IEC :
case scale_IEC_I :
return 1024 ;
case scale_none :
case scale_auto :
case scale_SI :
default:
return 1000 ;
}
}
static inline int
valid_suffix ( const char suf )
{
static const char * valid_suffixes = lr_1 ;
return ( strchr ( valid_suffixes , suf ) != NULL ) ;
}
static inline int
suffix_power ( const char suf )
{
switch ( suf )
{
case 'K' :
return 1 ;
case 'M' :
return 2 ;
case 'G' :
return 3 ;
case 'T' :
return 4 ;
case 'P' :
return 5 ;
case 'E' :
return 6 ;
case 'Z' :
return 7 ;
case 'Y' :
return 8 ;
default:
return 0 ;
}
}
static inline const char *
suffix_power_character ( unsigned int power )
{
switch ( power )
{
case 0 :
return lr_2 ;
case 1 :
return lr_3 ;
case 2 :
return lr_4 ;
case 3 :
return lr_5 ;
case 4 :
return lr_6 ;
case 5 :
return lr_7 ;
case 6 :
return lr_8 ;
case 7 :
return lr_9 ;
case 8 :
return lr_10 ;
default:
return lr_11 ;
}
}
static long double
powerld ( long double base , unsigned int x )
{
long double result = base ;
if ( x == 0 )
return 1 ;
while ( -- x )
result *= base ;
return result ;
}
static inline long double
absld ( long double val )
{
return val < 0 ? - val : val ;
}
static long double
expld ( long double val , unsigned int base , unsigned int * x )
{
unsigned int power = 0 ;
if ( val >= - LDBL_MAX && val <= LDBL_MAX )
{
while ( absld ( val ) >= base )
{
++ power ;
val /= base ;
}
}
if ( x )
* x = power ;
return val ;
}
static inline intmax_t
simple_round_ceiling ( long double val )
{
intmax_t intval = val ;
if ( intval < val )
intval ++ ;
return intval ;
}
static inline intmax_t
simple_round_floor ( long double val )
{
return - simple_round_ceiling ( - val ) ;
}
static inline intmax_t
simple_round_from_zero ( long double val )
{
return val < 0 ? simple_round_floor ( val ) : simple_round_ceiling ( val ) ;
}
static inline intmax_t
simple_round_to_zero ( long double val )
{
return val ;
}
static inline intmax_t
simple_round_nearest ( long double val )
{
return val < 0 ? val - 0.5 : val + 0.5 ;
}
static inline intmax_t
simple_round ( long double val , enum round_type t )
{
switch ( t )
{
case round_ceiling :
return simple_round_ceiling ( val ) ;
case round_floor :
return simple_round_floor ( val ) ;
case round_from_zero :
return simple_round_from_zero ( val ) ;
case round_to_zero :
return simple_round_to_zero ( val ) ;
case round_nearest :
return simple_round_nearest ( val ) ;
default:
return 0 ;
}
}
static enum simple_strtod_error
simple_strtod_int ( const char * input_str ,
char * * endptr , long double * value , bool * negative )
{
enum simple_strtod_error e = SSE_OK ;
long double val = 0 ;
unsigned int digits = 0 ;
if ( * input_str == '-' )
{
input_str ++ ;
* negative = true ;
}
else
* negative = false ;
* endptr = ( char * ) input_str ;
while ( * endptr && isdigit ( * * endptr ) )
{
int digit = ( * * endptr ) - '0' ;
if ( digit < 0 || digit > 9 )
return SSE_INVALID_NUMBER ;
if ( digits > MAX_UNSCALED_DIGITS )
e = SSE_OK_PRECISION_LOSS ;
++ digits ;
if ( digits > MAX_ACCEPTABLE_DIGITS )
return SSE_OVERFLOW ;
val *= 10 ;
val += digit ;
++ ( * endptr ) ;
}
if ( digits == 0 )
return SSE_INVALID_NUMBER ;
if ( * negative )
val = - val ;
if ( value )
* value = val ;
return e ;
}
static enum simple_strtod_error
simple_strtod_float ( const char * input_str ,
char * * endptr ,
long double * value ,
size_t * precision )
{
bool negative ;
enum simple_strtod_error e = SSE_OK ;
if ( precision )
* precision = 0 ;
e = simple_strtod_int ( input_str , endptr , value , & negative ) ;
if ( e != SSE_OK && e != SSE_OK_PRECISION_LOSS )
return e ;
if ( STREQ_LEN ( * endptr , decimal_point , decimal_point_length ) )
{
char * ptr2 ;
long double val_frac = 0 ;
bool neg_frac ;
( * endptr ) += decimal_point_length ;
enum simple_strtod_error e2 =
simple_strtod_int ( * endptr , & ptr2 , & val_frac , & neg_frac ) ;
if ( e2 != SSE_OK && e2 != SSE_OK_PRECISION_LOSS )
return e2 ;
if ( e2 == SSE_OK_PRECISION_LOSS )
e = e2 ;
if ( neg_frac )
return SSE_INVALID_NUMBER ;
size_t exponent = ptr2 - * endptr ;
val_frac = ( ( long double ) val_frac ) / powerld ( 10 , exponent ) ;
if ( value )
{
if ( negative )
* value -= val_frac ;
else
* value += val_frac ;
}
if ( precision )
* precision = exponent ;
* endptr = ptr2 ;
}
return e ;
}
static enum simple_strtod_error
simple_strtod_human ( const char * input_str ,
char * * endptr , long double * value , size_t * precision ,
enum scale_type allowed_scaling )
{
int power = 0 ;
int scale_base = default_scale_base ( allowed_scaling ) ;
devmsg ( lr_12
lr_13 ,
quote_n ( 0 , input_str ) , quote_n ( 1 , decimal_point ) ) ;
enum simple_strtod_error e =
simple_strtod_float ( input_str , endptr , value , precision ) ;
if ( e != SSE_OK && e != SSE_OK_PRECISION_LOSS )
return e ;
devmsg ( lr_14
lr_15 , * value , ( int ) * precision ) ;
if ( * * endptr != '\0' )
{
while ( isblank ( * * endptr ) )
( * endptr ) ++ ;
if ( ! valid_suffix ( * * endptr ) )
return SSE_INVALID_SUFFIX ;
if ( allowed_scaling == scale_none )
return SSE_VALID_BUT_FORBIDDEN_SUFFIX ;
power = suffix_power ( * * endptr ) ;
( * endptr ) ++ ;
if ( allowed_scaling == scale_auto && * * endptr == 'i' )
{
scale_base = 1024 ;
( * endptr ) ++ ;
devmsg ( lr_16 ,
scale_base ) ;
}
* precision = 0 ;
}
if ( allowed_scaling == scale_IEC_I )
{
if ( * * endptr == 'i' )
( * endptr ) ++ ;
else
return SSE_MISSING_I_SUFFIX ;
}
long double multiplier = powerld ( scale_base , power ) ;
devmsg ( lr_17 , scale_base , power , multiplier ) ;
( * value ) = ( * value ) * multiplier ;
devmsg ( lr_18 , * value , * value ) ;
return e ;
}
static void
simple_strtod_fatal ( enum simple_strtod_error err , char const * input_str )
{
char const * msgid = NULL ;
switch ( err )
{
case SSE_OK_PRECISION_LOSS :
case SSE_OK :
abort () ;
case SSE_OVERFLOW :
msgid = N_ ( lr_19 ) ;
break;
case SSE_INVALID_NUMBER :
msgid = N_ ( lr_20 ) ;
break;
case SSE_VALID_BUT_FORBIDDEN_SUFFIX :
msgid = N_ ( lr_21 ) ;
break;
case SSE_INVALID_SUFFIX :
msgid = N_ ( lr_22 ) ;
break;
case SSE_MISSING_I_SUFFIX :
msgid = N_ ( lr_23 ) ;
break;
}
if ( _invalid != inval_ignore )
error ( conv_exit_code , 0 , gettext ( msgid ) , quote ( input_str ) ) ;
}
static void
double_to_human ( long double val , int precision ,
char * buf , size_t buf_size ,
enum scale_type scale , int group , enum round_type round )
{
devmsg ( lr_24 ) ;
if ( scale == scale_none )
{
val *= powerld ( 10 , precision ) ;
val = simple_round ( val , round ) ;
val /= powerld ( 10 , precision ) ;
devmsg ( ( group ) ?
lr_25 :
lr_26 , precision , val ) ;
int i = snprintf ( buf , buf_size , ( group ) ? lr_27 : lr_28 ,
precision , val ) ;
if ( i < 0 || i >= ( int ) buf_size )
error ( EXIT_FAILURE , 0 ,
_ ( lr_29 ) , val ) ;
return;
}
double scale_base = default_scale_base ( scale ) ;
unsigned int power = 0 ;
val = expld ( val , scale_base , & power ) ;
devmsg ( lr_30 , val , scale_base , power ) ;
int ten_or_less = 0 ;
if ( absld ( val ) < 10 )
{
ten_or_less = 1 ;
val *= 10 ;
}
val = simple_round ( val , round ) ;
if ( absld ( val ) >= scale_base )
{
val /= scale_base ;
power ++ ;
}
if ( ten_or_less )
val /= 10 ;
int show_decimal_point = ( val != 0 ) && ( absld ( val ) < 10 ) && ( power > 0 ) ;
devmsg ( lr_31 , val , scale_base , power ) ;
snprintf ( buf , buf_size , ( show_decimal_point ) ? lr_32 : lr_33 ,
val , suffix_power_character ( power ) ) ;
if ( scale == scale_IEC_I && power > 0 )
strncat ( buf , lr_34 , buf_size - strlen ( buf ) - 1 ) ;
devmsg ( lr_35 , quote ( buf ) ) ;
return;
}
static uintmax_t
unit_to_umax ( const char * n_string )
{
strtol_error s_err ;
char * end = NULL ;
uintmax_t n ;
s_err = xstrtoumax ( n_string , & end , 10 , & n , lr_1 ) ;
if ( s_err != LONGINT_OK || * end || n == 0 )
error ( EXIT_FAILURE , 0 , _ ( lr_36 ) , quote ( n_string ) ) ;
return n ;
}
static void
setup_padding_buffer ( size_t min_size )
{
if ( padding_buffer_size > min_size )
return;
padding_buffer_size = min_size + 1 ;
padding_buffer = realloc ( padding_buffer , padding_buffer_size ) ;
if ( ! padding_buffer )
error ( EXIT_FAILURE , 0 , _ ( lr_37 ) ,
padding_buffer_size ) ;
}
void
usage ( int status )
{
if ( status != EXIT_SUCCESS )
emit_try_help () ;
else
{
printf ( _ ( lr_38 ) , program_name ) ;
fputs ( _ ( lr_39 ) , stdout ) ;
emit_mandatory_arg_note () ;
fputs ( _ ( lr_40 ) , stdout ) ;
fputs ( _ ( lr_41 ) , stdout ) ;
fputs ( _ ( lr_42 ) , stdout ) ;
fputs ( _ ( lr_43 ) , stdout ) ;
fputs ( _ ( lr_44 ) , stdout ) ;
fputs ( _ ( lr_45 ) , stdout ) ;
fputs ( _ ( lr_46 ) , stdout ) ;
fputs ( _ ( lr_47 ) , stdout ) ;
fputs ( _ ( lr_48 ) , stdout ) ;
fputs ( _ ( lr_49 ) , stdout ) ;
fputs ( _ ( lr_50 ) , stdout ) ;
fputs ( _ ( lr_51 ) , stdout ) ;
fputs ( _ ( lr_52 ) , stdout ) ;
fputs ( _ ( lr_53 ) , stdout ) ;
fputs ( HELP_OPTION_DESCRIPTION , stdout ) ;
fputs ( VERSION_OPTION_DESCRIPTION , stdout ) ;
fputs ( _ ( lr_54 ) , stdout ) ;
fputs ( _ ( lr_55 ) , stdout ) ;
fputs ( _ ( lr_56 ) , stdout ) ;
fputs ( _ ( lr_57 ) , stdout ) ;
fputs ( _ ( lr_58 ) , stdout ) ;
fputs ( _ ( lr_59 ) , stdout ) ;
fputs ( _ ( lr_60 ) , stdout ) ;
printf ( _ ( lr_61 ) , program_name ) ;
printf ( _ ( lr_62 ) ,
program_name , program_name , program_name ,
program_name , program_name , program_name ,
program_name , program_name , program_name ) ;
emit_ancillary_info () ;
}
exit ( status ) ;
}
static void
parse_format_string ( char const * fmt )
{
size_t i ;
size_t prefix_len = 0 ;
size_t suffix_pos ;
long int pad = 0 ;
char * endptr = NULL ;
for ( i = 0 ; ! ( fmt [ i ] == '%' && fmt [ i + 1 ] != '%' ) ; i += ( fmt [ i ] == '%' ) + 1 )
{
if ( ! fmt [ i ] )
error ( EXIT_FAILURE , 0 ,
_ ( lr_63 ) , quote ( fmt ) ) ;
prefix_len ++ ;
}
i ++ ;
i += strspn ( fmt + i , lr_64 ) ;
if ( fmt [ i ] == '\'' )
{
grouping = 1 ;
i ++ ;
}
i += strspn ( fmt + i , lr_64 ) ;
errno = 0 ;
pad = strtol ( fmt + i , & endptr , 10 ) ;
if ( errno == ERANGE )
error ( EXIT_FAILURE , 0 ,
_ ( lr_65 ) , quote ( fmt ) ) ;
if ( endptr != ( fmt + i ) && pad != 0 )
{
if ( pad < 0 )
{
padding_alignment = MBS_ALIGN_LEFT ;
padding_width = - pad ;
}
else
{
padding_width = pad ;
}
}
i = endptr - fmt ;
if ( fmt [ i ] == '\0' )
error ( EXIT_FAILURE , 0 , _ ( lr_66 ) , quote ( fmt ) ) ;
if ( fmt [ i ] != 'f' )
error ( EXIT_FAILURE , 0 , _ ( lr_67
lr_68 ) ,
quote ( fmt ) ) ;
i ++ ;
suffix_pos = i ;
for (; fmt [ i ] != '\0' ; i += ( fmt [ i ] == '%' ) + 1 )
if ( fmt [ i ] == '%' && fmt [ i + 1 ] != '%' )
error ( EXIT_FAILURE , 0 , _ ( lr_69 ) ,
quote ( fmt ) ) ;
if ( prefix_len )
{
format_str_prefix = xstrndup ( fmt , prefix_len ) ;
if ( ! format_str_prefix )
error ( EXIT_FAILURE , 0 , _ ( lr_37 ) ,
prefix_len + 1 ) ;
}
if ( fmt [ suffix_pos ] != '\0' )
{
format_str_suffix = strdup ( fmt + suffix_pos ) ;
if ( ! format_str_suffix )
error ( EXIT_FAILURE , 0 , _ ( lr_37 ) ,
strlen ( fmt + suffix_pos ) ) ;
}
devmsg ( lr_70
lr_71
lr_72 ,
quote_n ( 0 , fmt ) , ( grouping ) ? lr_73 : lr_74 ,
padding_width ,
( padding_alignment == MBS_ALIGN_LEFT ) ? lr_75 : lr_76 ,
quote_n ( 1 , format_str_prefix ? format_str_prefix : lr_2 ) ,
quote_n ( 2 , format_str_suffix ? format_str_suffix : lr_2 ) ) ;
}
static enum simple_strtod_error
parse_human_number ( const char * str , long double * value ,
size_t * precision )
{
char * ptr = NULL ;
enum simple_strtod_error e =
simple_strtod_human ( str , & ptr , value , precision , scale_from ) ;
if ( e != SSE_OK && e != SSE_OK_PRECISION_LOSS )
{
simple_strtod_fatal ( e , str ) ;
return e ;
}
if ( ptr && * ptr != '\0' )
{
if ( _invalid != inval_ignore )
error ( conv_exit_code , 0 , _ ( lr_77 ) ,
quote_n ( 0 , str ) , quote_n ( 1 , ptr ) ) ;
e = SSE_INVALID_SUFFIX ;
}
return e ;
}
static int
prepare_padded_number ( const long double val , size_t precision )
{
char buf [ 128 ] ;
unsigned int x ;
expld ( val , 10 , & x ) ;
if ( scale_to == scale_none && x > MAX_UNSCALED_DIGITS )
{
if ( _invalid != inval_ignore )
error ( conv_exit_code , 0 , _ ( lr_78
lr_79 ) , val ) ;
return 0 ;
}
if ( x > MAX_ACCEPTABLE_DIGITS - 1 )
{
if ( _invalid != inval_ignore )
error ( conv_exit_code , 0 , _ ( lr_78
lr_80 ) , val ) ;
return 0 ;
}
double_to_human ( val , precision , buf , sizeof ( buf ) , scale_to , grouping ,
_round ) ;
if ( suffix )
strncat ( buf , suffix , sizeof ( buf ) - strlen ( buf ) - 1 ) ;
devmsg ( lr_81 ,
val , quote ( buf ) ) ;
if ( padding_width && strlen ( buf ) < padding_width )
{
size_t w = padding_width ;
mbsalign ( buf , padding_buffer , padding_buffer_size , & w ,
padding_alignment , MBA_UNIBYTE_ONLY ) ;
devmsg ( lr_82 , quote ( padding_buffer ) ) ;
}
else
{
setup_padding_buffer ( strlen ( buf ) + 1 ) ;
strcpy ( padding_buffer , buf ) ;
}
return 1 ;
}
static void
print_padded_number ( void )
{
if ( format_str_prefix )
fputs ( format_str_prefix , stdout ) ;
fputs ( padding_buffer , stdout ) ;
if ( format_str_suffix )
fputs ( format_str_suffix , stdout ) ;
}
static int
process_suffixed_number ( char * text , long double * result , size_t * precision )
{
if ( suffix && strlen ( text ) > strlen ( suffix ) )
{
char * possible_suffix = text + strlen ( text ) - strlen ( suffix ) ;
if ( STREQ ( suffix , possible_suffix ) )
{
* possible_suffix = '\0' ;
devmsg ( lr_83 , quote ( suffix ) ) ;
}
else
devmsg ( lr_84 ) ;
}
char * p = text ;
while ( * p && isblank ( * p ) )
++ p ;
const unsigned int skip_count = text - p ;
if ( auto_padding )
{
if ( skip_count > 0 || field > 1 )
{
padding_width = strlen ( text ) ;
setup_padding_buffer ( padding_width ) ;
}
else
{
padding_width = 0 ;
}
devmsg ( lr_85 , padding_width ) ;
}
long double val = 0 ;
enum simple_strtod_error e = parse_human_number ( p , & val , precision ) ;
if ( e == SSE_OK_PRECISION_LOSS && debug )
error ( 0 , 0 , _ ( lr_86 ) ,
quote ( p ) ) ;
if ( from_unit_size != 1 || to_unit_size != 1 )
val = ( val * from_unit_size ) / to_unit_size ;
* result = val ;
return ( e == SSE_OK || e == SSE_OK_PRECISION_LOSS ) ;
}
static inline char * _GL_ATTRIBUTE_PURE
skip_fields ( char * buf , int fields )
{
char * ptr = buf ;
if ( delimiter != DELIMITER_DEFAULT )
{
if ( * ptr == delimiter )
fields -- ;
while ( * ptr && fields -- )
{
while ( * ptr && * ptr == delimiter )
++ ptr ;
while ( * ptr && * ptr != delimiter )
++ ptr ;
}
}
else
while ( * ptr && fields -- )
{
while ( * ptr && isblank ( * ptr ) )
++ ptr ;
while ( * ptr && ! isblank ( * ptr ) )
++ ptr ;
}
return ptr ;
}
static void
extract_fields ( char * line , int _field ,
char * * _prefix , char * * _data , char * * _suffix )
{
char * ptr = line ;
* _prefix = NULL ;
* _data = NULL ;
* _suffix = NULL ;
devmsg ( lr_87 ,
quote ( line ) , _field ) ;
if ( field > 1 )
{
* _prefix = line ;
ptr = skip_fields ( line , field - 1 ) ;
if ( * ptr == '\0' )
{
devmsg ( lr_88 , quote ( * _prefix ) ) ;
return;
}
* ptr = '\0' ;
++ ptr ;
}
* _data = ptr ;
* _suffix = skip_fields ( * _data , 1 ) ;
if ( * * _suffix )
{
* * _suffix = '\0' ;
++ ( * _suffix ) ;
}
else
* _suffix = NULL ;
devmsg ( lr_89 ,
quote_n ( 0 , * _prefix ? * _prefix : lr_2 ) ,
quote_n ( 1 , * _data ) ,
quote_n ( 2 , * _suffix ? * _suffix : lr_2 ) ) ;
}
static int
process_line ( char * line , bool newline )
{
char * pre , * num , * suf ;
long double val = 0 ;
size_t precision = 0 ;
int valid_number = 0 ;
extract_fields ( line , field , & pre , & num , & suf ) ;
if ( ! num )
if ( _invalid != inval_ignore )
error ( conv_exit_code , 0 , _ ( lr_90
lr_91 ) ,
field ) ;
if ( num )
{
valid_number = process_suffixed_number ( num , & val , & precision ) ;
if ( valid_number )
valid_number = prepare_padded_number ( val , precision ) ;
}
if ( pre )
fputs ( pre , stdout ) ;
if ( pre && num )
fputc ( ( delimiter == DELIMITER_DEFAULT ) ? ' ' : delimiter , stdout ) ;
if ( valid_number )
{
print_padded_number () ;
}
else
{
if ( num )
fputs ( num , stdout ) ;
}
if ( suf )
{
fputc ( ( delimiter == DELIMITER_DEFAULT ) ? ' ' : delimiter , stdout ) ;
fputs ( suf , stdout ) ;
}
if ( newline )
putchar ( '\n' ) ;
return valid_number ;
}
int
main ( int argc , char * * argv )
{
int valid_numbers = 1 ;
initialize_main ( & argc , & argv ) ;
set_program_name ( argv [ 0 ] ) ;
setlocale ( LC_ALL , lr_2 ) ;
bindtextdomain ( PACKAGE , LOCALEDIR ) ;
textdomain ( PACKAGE ) ;
decimal_point = nl_langinfo ( RADIXCHAR ) ;
if ( decimal_point == NULL || strlen ( decimal_point ) == 0 )
decimal_point = lr_92 ;
decimal_point_length = strlen ( decimal_point ) ;
atexit ( close_stdout ) ;
while ( true )
{
int c = getopt_long ( argc , argv , lr_93 , longopts , NULL ) ;
if ( c == - 1 )
break;
switch ( c )
{
case FROM_OPTION :
scale_from = XARGMATCH ( lr_94 , optarg ,
scale_from_args , scale_from_types ) ;
break;
case FROM_UNIT_OPTION :
from_unit_size = unit_to_umax ( optarg ) ;
break;
case TO_OPTION :
scale_to =
XARGMATCH ( lr_95 , optarg , scale_to_args , scale_to_types ) ;
break;
case TO_UNIT_OPTION :
to_unit_size = unit_to_umax ( optarg ) ;
break;
case ROUND_OPTION :
_round = XARGMATCH ( lr_96 , optarg , round_args , round_types ) ;
break;
case GROUPING_OPTION :
grouping = 1 ;
break;
case PADDING_OPTION :
if ( xstrtol ( optarg , NULL , 10 , & padding_width , lr_2 ) != LONGINT_OK
|| padding_width == 0 )
error ( EXIT_FAILURE , 0 , _ ( lr_97 ) ,
quote ( optarg ) ) ;
if ( padding_width < 0 )
{
padding_alignment = MBS_ALIGN_LEFT ;
padding_width = - padding_width ; MST[SUB$@1$@2$!NEQ$@1$@2$]MSP[S]
}
break;
case FIELD_OPTION :
if ( xstrtol ( optarg , NULL , 10 , & field , lr_2 ) != LONGINT_OK
|| field <= 0 )
error ( EXIT_FAILURE , 0 , _ ( lr_98 ) ,
quote ( optarg ) ) ;
break;
case 'd' :
if ( optarg [ 0 ] != '\0' && optarg [ 1 ] != '\0' )
error ( EXIT_FAILURE , 0 ,
_ ( lr_99 ) ) ;
delimiter = optarg [ 0 ] ;
break;
case SUFFIX_OPTION :
suffix = optarg ;
break;
case DEBUG_OPTION :
debug = true ;
break;
case DEV_DEBUG_OPTION :
dev_debug = true ;
debug = true ;
break;
case HEADER_OPTION :
if ( optarg )
{
if ( xstrtoumax ( optarg , NULL , 10 , & header , lr_2 ) != LONGINT_OK
|| header == 0 )
error ( EXIT_FAILURE , 0 , _ ( lr_100 ) ,
quote ( optarg ) ) ;
}
else
{
header = 1 ;
}
break;
case FORMAT_OPTION :
format_str = optarg ;
break;
case INVALID_OPTION :
_invalid = XARGMATCH ( lr_101 , optarg , inval_args , inval_types ) ;
break;
case_GETOPT_HELP_CHAR ;
case_GETOPT_VERSION_CHAR ( PROGRAM_NAME , AUTHORS ) ;
default:
usage ( EXIT_FAILURE ) ;
}
}
if ( format_str != NULL && grouping )
error ( EXIT_FAILURE , 0 , _ ( lr_102 ) ) ;
if ( format_str != NULL && padding_width > 0 )
error ( EXIT_FAILURE , 0 , _ ( lr_103 ) ) ;
if ( debug && scale_from == scale_none && scale_to == scale_none
&& ! grouping && ( padding_width == 0 ) && ( format_str == NULL ) )
error ( 0 , 0 , _ ( lr_104 ) ) ;
if ( format_str )
parse_format_string ( format_str ) ;
if ( grouping )
{
if ( scale_to != scale_none )
error ( EXIT_FAILURE , 0 , _ ( lr_105 ) ) ;
if ( debug && ( strlen ( nl_langinfo ( THOUSEP ) ) == 0 ) )
error ( 0 , 0 , _ ( lr_106 ) ) ;
}
setup_padding_buffer ( padding_width ) ;
auto_padding = ( padding_width == 0 && delimiter == DELIMITER_DEFAULT ) ;
if ( _invalid != inval_abort )
conv_exit_code = 0 ;
if ( argc > optind )
{
if ( debug && header )
error ( 0 , 0 , _ ( lr_107 ) ) ;
for (; optind < argc ; optind ++ )
valid_numbers &= process_line ( argv [ optind ] , true ) ;
}
else
{
char * line = NULL ;
size_t line_allocated = 0 ;
ssize_t len ;
while ( header -- && getline ( & line , & line_allocated , stdin ) > 0 )
fputs ( line , stdout ) ;
while ( ( len = getline ( & line , & line_allocated , stdin ) ) > 0 )
{
bool newline = line [ len - 1 ] == '\n' ;
if ( newline )
line [ len - 1 ] = '\0' ;
valid_numbers &= process_line ( line , newline ) ;
}
IF_LINT ( free ( line ) ) ;
if ( ferror ( stdin ) )
error ( 0 , errno , _ ( lr_108 ) ) ;
}
free ( padding_buffer ) ;
free ( format_str_prefix ) ;
free ( format_str_suffix ) ;
if ( debug && ! valid_numbers )
error ( 0 , 0 , _ ( lr_109 ) ) ;
int exit_status = EXIT_SUCCESS ;
if ( ! valid_numbers && _invalid != inval_warn && _invalid != inval_ignore )
exit_status = EXIT_CONVERSION_WARNINGS ;
exit ( exit_status ) ;
}

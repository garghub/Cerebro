void
usage ( int status )
{
if ( status != EXIT_SUCCESS )
emit_try_help () ;
else
{
printf ( _ ( lr_1 ) ,
program_name ,
DIGEST_TYPE_STRING ,
DIGEST_BITS ) ;
if ( O_BINARY )
fputs ( _ ( lr_2 ) , stdout ) ;
else
fputs ( _ ( lr_3 ) , stdout ) ;
printf ( _ ( lr_4 ) ,
DIGEST_TYPE_STRING ) ;
fputs ( _ ( lr_5 ) , stdout ) ;
if ( O_BINARY )
fputs ( _ ( lr_6 ) , stdout ) ;
else
fputs ( _ ( lr_7 ) , stdout ) ;
fputs ( _ ( lr_8 ) , stdout ) ;
fputs ( HELP_OPTION_DESCRIPTION , stdout ) ;
fputs ( VERSION_OPTION_DESCRIPTION , stdout ) ;
printf ( _ ( lr_9 ) ,
DIGEST_REFERENCE ) ;
emit_ancillary_info () ;
}
exit ( status ) ;
}
static char *
filename_unescape ( char * s , size_t s_len )
{
char * dst = s ;
size_t i ;
for ( i = 0 ; i < s_len ; i ++ )
{
switch ( s [ i ] )
{
case '\\' :
if ( i == s_len - 1 )
{
return NULL ;
}
++ i ;
switch ( s [ i ] )
{
case 'n' :
* dst ++ = '\n' ;
break;
case '\\' :
* dst ++ = '\\' ;
break;
default:
return NULL ;
}
break;
case '\0' :
return NULL ;
default:
* dst ++ = s [ i ] ;
break;
}
}
if ( dst < s + s_len )
* dst = '\0' ;
return s ;
}
static bool
bsd_split_3 ( char * s , size_t s_len , unsigned char * * hex_digest ,
char * * file_name , bool escaped_filename )
{
size_t i ;
if ( s_len == 0 )
return false ;
i = s_len - 1 ;
while ( i && s [ i ] != ')' )
i -- ;
if ( s [ i ] != ')' )
return false ;
* file_name = s ;
if ( escaped_filename && filename_unescape ( s , i ) == NULL )
return false ;
s [ i ++ ] = '\0' ;
while ( ISWHITE ( s [ i ] ) )
i ++ ;
if ( s [ i ] != '=' )
return false ;
i ++ ;
while ( ISWHITE ( s [ i ] ) )
i ++ ;
* hex_digest = ( unsigned char * ) & s [ i ] ;
return true ;
}
static bool
split_3 ( char * s , size_t s_len ,
unsigned char * * hex_digest , int * binary , char * * file_name )
{
bool escaped_filename = false ;
size_t algo_name_len ;
size_t i = 0 ;
while ( ISWHITE ( s [ i ] ) )
++ i ;
if ( s [ i ] == '\\' )
{
++ i ;
escaped_filename = true ;
}
algo_name_len = strlen ( DIGEST_TYPE_STRING ) ;
if ( STREQ_LEN ( s + i , DIGEST_TYPE_STRING , algo_name_len ) )
{
if ( s [ i + algo_name_len ] == ' ' )
++ i ;
if ( s [ i + algo_name_len ] == '(' )
{
* binary = 0 ;
return bsd_split_3 ( s + i + algo_name_len + 1 ,
s_len - ( i + algo_name_len + 1 ) ,
hex_digest , file_name , escaped_filename ) ;
}
}
if ( s_len - i < min_digest_line_length + ( s [ i ] == '\\' ) )
return false ;
* hex_digest = ( unsigned char * ) & s [ i ] ;
i += digest_hex_bytes ;
if ( ! ISWHITE ( s [ i ] ) )
return false ;
s [ i ++ ] = '\0' ;
if ( ( s_len - i == 1 ) || ( s [ i ] != ' ' && s [ i ] != '*' ) )
{
if ( bsd_reversed == 0 )
return false ;
bsd_reversed = 1 ;
}
else if ( bsd_reversed != 1 )
{
bsd_reversed = 0 ;
* binary = ( s [ i ++ ] == '*' ) ;
}
* file_name = & s [ i ] ;
if ( escaped_filename )
return filename_unescape ( & s [ i ] , s_len - i ) != NULL ;
return true ;
}
static bool _GL_ATTRIBUTE_PURE
hex_digits ( unsigned char const * s )
{
unsigned int i ;
for ( i = 0 ; i < digest_hex_bytes ; i ++ )
{
if ( ! isxdigit ( * s ) )
return false ;
++ s ;
}
return * s == '\0' ;
}
static bool
digest_file ( const char * filename , int * binary , unsigned char * bin_result )
{
FILE * fp ;
int err ;
bool is_stdin = STREQ ( filename , lr_10 ) ;
if ( is_stdin )
{
have_read_stdin = true ;
fp = stdin ;
if ( O_BINARY && * binary )
{
if ( * binary < 0 )
* binary = ! isatty ( STDIN_FILENO ) ;
if ( * binary )
xfreopen ( NULL , lr_11 , stdin ) ;
}
}
else
{
fp = fopen ( filename , ( O_BINARY && * binary ? lr_11 : lr_12 ) ) ;
if ( fp == NULL )
{
error ( 0 , errno , lr_13 , filename ) ;
return false ;
}
}
fadvise ( fp , FADVISE_SEQUENTIAL ) ;
err = DIGEST_STREAM ( fp , bin_result ) ;
if ( err )
{
error ( 0 , errno , lr_13 , filename ) ;
if ( fp != stdin )
fclose ( fp ) ;
return false ;
}
if ( ! is_stdin && fclose ( fp ) != 0 )
{
error ( 0 , errno , lr_13 , filename ) ;
return false ;
}
return true ;
}
static bool
digest_check ( const char * checkfile_name )
{
FILE * checkfile_stream ;
uintmax_t n_misformatted_lines = 0 ;
uintmax_t n_properly_formatted_lines = 0 ;
uintmax_t n_improperly_formatted_lines = 0 ;
uintmax_t n_mismatched_checksums = 0 ;
uintmax_t n_open_or_read_failures = 0 ;
unsigned char bin_buffer_unaligned [ DIGEST_BIN_BYTES + DIGEST_ALIGN ] ;
unsigned char * bin_buffer = ptr_align ( bin_buffer_unaligned , DIGEST_ALIGN ) ;
uintmax_t line_number ;
char * line ;
size_t line_chars_allocated ;
bool is_stdin = STREQ ( checkfile_name , lr_10 ) ;
if ( is_stdin )
{
have_read_stdin = true ;
checkfile_name = _ ( lr_14 ) ;
checkfile_stream = stdin ;
}
else
{
checkfile_stream = fopen ( checkfile_name , lr_12 ) ;
if ( checkfile_stream == NULL )
{
error ( 0 , errno , lr_13 , checkfile_name ) ; MST[STMT!DELSTMT]MSP[]
return false ;
}
}
line_number = 0 ;
line = NULL ;
line_chars_allocated = 0 ;
do
{
char * filename IF_LINT ( = NULL ) ;
int binary ;
unsigned char * hex_digest IF_LINT ( = NULL ) ;
ssize_t line_length ;
++ line_number ;
if ( line_number == 0 )
error ( EXIT_FAILURE , 0 , _ ( lr_15 ) ,
checkfile_name ) ;
line_length = getline ( & line , & line_chars_allocated , checkfile_stream ) ;
if ( line_length <= 0 )
break;
if ( line [ 0 ] == '#' )
continue;
if ( line [ line_length - 1 ] == '\n' )
line [ -- line_length ] = '\0' ;
if ( ! ( split_3 ( line , line_length , & hex_digest , & binary , & filename )
&& ! ( is_stdin && STREQ ( filename , lr_10 ) )
&& hex_digits ( hex_digest ) ) )
{
++ n_misformatted_lines ;
if ( warn )
{
error ( 0 , 0 ,
_ ( lr_16 PRIuMAX
lr_17 ) ,
checkfile_name , line_number ,
DIGEST_TYPE_STRING ) ;
}
++ n_improperly_formatted_lines ;
}
else
{
static const char bin2hex [] = { '0' , '1' , '2' , '3' ,
'4' , '5' , '6' , '7' ,
'8' , '9' , 'a' , 'b' ,
'c' , 'd' , 'e' , 'f' } ;
bool ok ;
++ n_properly_formatted_lines ;
ok = digest_file ( filename , & binary , bin_buffer ) ;
if ( ! ok )
{
++ n_open_or_read_failures ;
if ( ! status_only )
{
printf ( _ ( lr_18 ) , filename ) ;
}
}
else
{
size_t digest_bin_bytes = digest_hex_bytes / 2 ;
size_t cnt ;
for ( cnt = 0 ; cnt < digest_bin_bytes ; ++ cnt )
{
if ( tolower ( hex_digest [ 2 * cnt ] )
!= bin2hex [ bin_buffer [ cnt ] >> 4 ]
|| ( tolower ( hex_digest [ 2 * cnt + 1 ] )
!= ( bin2hex [ bin_buffer [ cnt ] & 0xf ] ) ) )
break;
}
if ( cnt != digest_bin_bytes )
++ n_mismatched_checksums ;
if ( ! status_only )
{
if ( cnt != digest_bin_bytes )
printf ( lr_19 , filename , _ ( lr_20 ) ) ;
else if ( ! quiet )
printf ( lr_19 , filename , _ ( lr_21 ) ) ;
}
}
}
}
while ( ! feof ( checkfile_stream ) && ! ferror ( checkfile_stream ) );
free ( line ) ;
if ( ferror ( checkfile_stream ) )
{
error ( 0 , 0 , _ ( lr_22 ) , checkfile_name ) ;
return false ;
}
if ( ! is_stdin && fclose ( checkfile_stream ) != 0 )
{
error ( 0 , errno , lr_13 , checkfile_name ) ;
return false ;
}
if ( n_properly_formatted_lines == 0 )
{
error ( 0 , 0 , _ ( lr_23 ) ,
checkfile_name , DIGEST_TYPE_STRING ) ;
}
else
{
if ( ! status_only )
{
if ( n_misformatted_lines != 0 )
error ( 0 , 0 ,
( ngettext
( lr_24 PRIuMAX lr_25 ,
lr_24 PRIuMAX lr_26 ,
select_plural ( n_misformatted_lines ) ) ) ,
n_misformatted_lines ) ;
if ( n_open_or_read_failures != 0 )
error ( 0 , 0 ,
( ngettext
( lr_24 PRIuMAX lr_27 ,
lr_24 PRIuMAX lr_28 ,
select_plural ( n_open_or_read_failures ) ) ) ,
n_open_or_read_failures ) ;
if ( n_mismatched_checksums != 0 )
error ( 0 , 0 ,
( ngettext
( lr_24 PRIuMAX lr_29 ,
lr_24 PRIuMAX lr_30 ,
select_plural ( n_mismatched_checksums ) ) ) ,
n_mismatched_checksums ) ;
}
}
return ( n_properly_formatted_lines != 0
&& n_mismatched_checksums == 0
&& n_open_or_read_failures == 0
&& ( ! strict || n_improperly_formatted_lines == 0 ) ) ;
}
static void
print_filename ( char const * file , bool escape )
{
if ( ! escape )
{
fputs ( file , stdout ) ;
return;
}
while ( * file )
{
switch ( * file )
{
case '\n' :
fputs ( lr_31 , stdout ) ;
break;
case '\\' :
fputs ( lr_32 , stdout ) ;
break;
default:
putchar ( * file ) ;
break;
}
file ++ ;
}
}
int
main ( int argc , char * * argv )
{
unsigned char bin_buffer_unaligned [ DIGEST_BIN_BYTES + DIGEST_ALIGN ] ;
unsigned char * bin_buffer = ptr_align ( bin_buffer_unaligned , DIGEST_ALIGN ) ;
bool do_check = false ;
int opt ;
bool ok = true ;
int binary = - 1 ;
bool prefix_tag = false ;
initialize_main ( & argc , & argv ) ;
set_program_name ( argv [ 0 ] ) ;
setlocale ( LC_ALL , lr_33 ) ;
bindtextdomain ( PACKAGE , LOCALEDIR ) ;
textdomain ( PACKAGE ) ;
atexit ( close_stdout ) ;
setvbuf ( stdout , NULL , _IOLBF , 0 ) ;
while ( ( opt = getopt_long ( argc , argv , lr_34 , long_options , NULL ) ) != - 1 )
switch ( opt )
{
case 'b' :
binary = 1 ;
break;
case 'c' :
do_check = true ;
break;
case STATUS_OPTION :
status_only = true ;
warn = false ;
quiet = false ;
break;
case 't' :
binary = 0 ;
break;
case 'w' :
status_only = false ;
warn = true ;
quiet = false ;
break;
case QUIET_OPTION :
status_only = false ;
warn = false ;
quiet = true ;
break;
case STRICT_OPTION :
strict = true ;
break;
case TAG_OPTION :
prefix_tag = true ;
binary = 1 ;
break;
case_GETOPT_HELP_CHAR ;
case_GETOPT_VERSION_CHAR ( PROGRAM_NAME , AUTHORS ) ;
default:
usage ( EXIT_FAILURE ) ;
}
min_digest_line_length = MIN_DIGEST_LINE_LENGTH ;
digest_hex_bytes = DIGEST_HEX_BYTES ;
if ( prefix_tag && ! binary )
{
error ( 0 , 0 , _ ( lr_35 ) ) ;
usage ( EXIT_FAILURE ) ;
}
if ( prefix_tag && do_check )
{
error ( 0 , 0 , _ ( lr_36
lr_37 ) ) ;
usage ( EXIT_FAILURE ) ;
}
if ( 0 <= binary && do_check )
{
error ( 0 , 0 , _ ( lr_38
lr_37 ) ) ;
usage ( EXIT_FAILURE ) ;
}
if ( status_only && ! do_check )
{
error ( 0 , 0 ,
_ ( lr_39 ) ) ;
usage ( EXIT_FAILURE ) ;
}
if ( warn && ! do_check )
{
error ( 0 , 0 ,
_ ( lr_40 ) ) ;
usage ( EXIT_FAILURE ) ;
}
if ( quiet && ! do_check )
{
error ( 0 , 0 ,
_ ( lr_41 ) ) ;
usage ( EXIT_FAILURE ) ;
}
if ( strict & ! do_check )
{
error ( 0 , 0 ,
_ ( lr_42 ) ) ;
usage ( EXIT_FAILURE ) ;
}
if ( ! O_BINARY && binary < 0 )
binary = 0 ;
if ( optind == argc )
argv [ argc ++ ] = bad_cast ( lr_10 ) ;
for (; optind < argc ; ++ optind )
{
char * file = argv [ optind ] ;
if ( do_check )
ok &= digest_check ( file ) ;
else
{
int file_is_binary = binary ;
if ( ! digest_file ( file , & file_is_binary , bin_buffer ) )
ok = false ;
else
{
bool needs_escape = strchr ( file , '\\' ) || strchr ( file , '\n' ) ;
if ( prefix_tag )
{
if ( needs_escape )
putchar ( '\\' ) ;
fputs ( DIGEST_TYPE_STRING , stdout ) ;
fputs ( lr_43 , stdout ) ;
print_filename ( file , needs_escape ) ;
fputs ( lr_44 , stdout ) ;
}
size_t i ;
if ( ! prefix_tag && needs_escape )
putchar ( '\\' ) ;
for ( i = 0 ; i < ( digest_hex_bytes / 2 ) ; ++ i )
printf ( lr_45 , bin_buffer [ i ] ) ;
if ( ! prefix_tag )
{
putchar ( ' ' ) ;
putchar ( file_is_binary ? '*' : ' ' ) ;
print_filename ( file , needs_escape ) ;
}
putchar ( '\n' ) ;
}
}
}
if ( have_read_stdin && fclose ( stdin ) == EOF )
error ( EXIT_FAILURE , errno , _ ( lr_14 ) ) ;
exit ( ok ? EXIT_SUCCESS : EXIT_FAILURE ) ;
}

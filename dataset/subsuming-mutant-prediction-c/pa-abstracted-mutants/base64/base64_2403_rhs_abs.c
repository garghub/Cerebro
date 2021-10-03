void
usage ( int status )
{
if ( status != EXIT_SUCCESS )
emit_try_help () ;
else
{
printf ( _ ( lr_1 ) , program_name ) ;
emit_mandatory_arg_note () ;
fputs ( _ ( lr_2 ) , stdout ) ;
fputs ( HELP_OPTION_DESCRIPTION , stdout ) ;
fputs ( VERSION_OPTION_DESCRIPTION , stdout ) ;
fputs ( _ ( lr_3 ) , stdout ) ;
fputs ( _ ( lr_4 ) ,
stdout ) ;
emit_ancillary_info () ;
}
exit ( status ) ;
}
static void
wrap_write ( const char * buffer , size_t len ,
uintmax_t wrap_column , size_t * current_column , FILE * out )
{
size_t written ;
if ( wrap_column == 0 )
{
if ( fwrite ( buffer , 1 , len , stdout ) < len )
error ( EXIT_FAILURE , errno , _ ( lr_5 ) ) ;
}
else
for ( written = 0 ; written < len ; )
{
uintmax_t cols_remaining = wrap_column - * current_column ;
size_t to_write = MIN ( cols_remaining , SIZE_MAX ) ;
to_write = MIN ( to_write , len - written ) ;
if ( to_write == 0 )
{
if ( fputc ( '\n' , out ) == EOF )
error ( EXIT_FAILURE , errno , _ ( lr_5 ) ) ;
* current_column = 0 ;
}
else
{
if ( fwrite ( buffer + written , 1 , to_write , stdout ) < to_write )
error ( EXIT_FAILURE , errno , _ ( lr_5 ) ) ;
* current_column += to_write ;
written += to_write ;
}
}
}
static void
do_encode ( FILE * in , FILE * out , uintmax_t wrap_column )
{
size_t current_column = 0 ;
char inbuf [ ENC_BLOCKSIZE ] ;
char outbuf [ ENC_B64BLOCKSIZE ] ;
size_t sum ;
do
{
size_t n ;
sum = 0 ;
do
{
n = fread ( inbuf + sum , 1 , ENC_BLOCKSIZE - sum , in ) ;
sum += n ;
}
while ( ! feof ( in ) && ! ferror ( in ) && sum < ENC_BLOCKSIZE );
if ( sum > 0 )
{
base64_encode ( inbuf , sum , outbuf , BASE64_LENGTH ( sum ) ) ; MST[ADD$@1$@2$!LT$@1$@2$]MSP[N]
wrap_write ( outbuf , BASE64_LENGTH ( sum ) , wrap_column ,
& current_column , out ) ;
}
}
while ( ! feof ( in ) && ! ferror ( in ) && sum == ENC_BLOCKSIZE );
if ( wrap_column && current_column > 0 && fputc ( '\n' , out ) == EOF )
error ( EXIT_FAILURE , errno , _ ( lr_5 ) ) ;
if ( ferror ( in ) )
error ( EXIT_FAILURE , errno , _ ( lr_6 ) ) ;
}
static void
do_decode ( FILE * in , FILE * out , bool ignore_garbage )
{
char inbuf [ DEC_B64BLOCKSIZE ] ;
char outbuf [ DEC_BLOCKSIZE ] ;
size_t sum ;
struct base64_decode_context ctx ;
base64_decode_ctx_init ( & ctx ) ;
do
{
bool ok ;
size_t n ;
unsigned int k ;
sum = 0 ;
do
{
n = fread ( inbuf + sum , 1 , DEC_B64BLOCKSIZE - sum , in ) ;
if ( ignore_garbage )
{
size_t i ;
for ( i = 0 ; n > 0 && i < n ; )
if ( isbase64 ( inbuf [ sum + i ] ) || inbuf [ sum + i ] == '=' )
i ++ ;
else
memmove ( inbuf + sum + i , inbuf + sum + i + 1 , -- n - i ) ;
}
sum += n ;
if ( ferror ( in ) )
error ( EXIT_FAILURE , errno , _ ( lr_6 ) ) ;
}
while ( sum < DEC_B64BLOCKSIZE && ! feof ( in ) );
for ( k = 0 ; k < 1 + ! ! feof ( in ) ; k ++ )
{
if ( k == 1 && ctx . i == 0 )
break;
n = DEC_BLOCKSIZE ;
ok = base64_decode_ctx ( & ctx , inbuf , ( k == 0 ? sum : 0 ) , outbuf , & n ) ;
if ( fwrite ( outbuf , 1 , n , out ) < n )
error ( EXIT_FAILURE , errno , _ ( lr_5 ) ) ;
if ( ! ok )
error ( EXIT_FAILURE , 0 , _ ( lr_7 ) ) ;
}
}
while ( ! feof ( in ) );
}
int
main ( int argc , char * * argv )
{
int opt ;
FILE * input_fh ;
const char * infile ;
bool decode = false ;
bool ignore_garbage = false ;
uintmax_t wrap_column = 76 ;
initialize_main ( & argc , & argv ) ;
set_program_name ( argv [ 0 ] ) ;
setlocale ( LC_ALL , lr_8 ) ;
bindtextdomain ( PACKAGE , LOCALEDIR ) ;
textdomain ( PACKAGE ) ;
atexit ( close_stdout ) ;
while ( ( opt = getopt_long ( argc , argv , lr_9 , long_options , NULL ) ) != - 1 )
switch ( opt )
{
case 'd' :
decode = true ;
break;
case 'w' :
if ( xstrtoumax ( optarg , NULL , 0 , & wrap_column , NULL ) != LONGINT_OK )
error ( EXIT_FAILURE , 0 , _ ( lr_10 ) ,
quotearg ( optarg ) ) ;
break;
case 'i' :
ignore_garbage = true ;
break;
case_GETOPT_HELP_CHAR ;
case_GETOPT_VERSION_CHAR ( PROGRAM_NAME , AUTHORS ) ;
default:
usage ( EXIT_FAILURE ) ;
break;
}
if ( argc - optind > 1 )
{
error ( 0 , 0 , _ ( lr_11 ) , quote ( argv [ optind ] ) ) ;
usage ( EXIT_FAILURE ) ;
}
if ( optind < argc )
infile = argv [ optind ] ;
else
infile = lr_12 ;
if ( STREQ ( infile , lr_12 ) )
{
if ( O_BINARY )
xfreopen ( NULL , lr_13 , stdin ) ;
input_fh = stdin ;
}
else
{
input_fh = fopen ( infile , lr_13 ) ;
if ( input_fh == NULL )
error ( EXIT_FAILURE , errno , lr_14 , infile ) ;
}
fadvise ( input_fh , FADVISE_SEQUENTIAL ) ;
if ( decode )
do_decode ( input_fh , stdout , ignore_garbage ) ;
else
do_encode ( input_fh , stdout , wrap_column ) ;
if ( fclose ( input_fh ) == EOF )
{
if ( STREQ ( infile , lr_12 ) )
error ( EXIT_FAILURE , errno , _ ( lr_15 ) ) ;
else
error ( EXIT_FAILURE , errno , lr_14 , infile ) ;
}
exit ( EXIT_SUCCESS ) ;
}

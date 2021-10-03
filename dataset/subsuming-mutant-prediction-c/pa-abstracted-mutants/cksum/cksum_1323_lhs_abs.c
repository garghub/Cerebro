static void
fill_r ( void )
{
int i ;
r [ 0 ] = GEN ;
for ( i = 1 ; i < 8 ; i ++ )
r [ i ] = ( r [ i - 1 ] << 1 ) ^ ( ( r [ i - 1 ] & SBIT ) ? GEN : 0 ) ;
}
static uint_fast32_t
crc_remainder ( int m )
{
uint_fast32_t rem = 0 ;
int i ;
for ( i = 0 ; i < 8 ; i ++ )
if ( BIT ( i ) & m )
rem ^= r [ i ] ;
return rem & 0xFFFFFFFF ;
}
int
main ( void )
{
int i ;
fill_r () ;
printf ( lr_1 ) ;
for ( i = 0 ; i < 51 ; i ++ )
{
printf ( lr_2 ,
crc_remainder ( i * 5 + 1 ) , crc_remainder ( i * 5 + 2 ) ,
crc_remainder ( i * 5 + 3 ) , crc_remainder ( i * 5 + 4 ) ,
crc_remainder ( i * 5 + 5 ) ) ;
}
printf ( lr_3 ) ;
exit ( EXIT_SUCCESS ) ;
}
static bool
cksum ( const char * file , bool print_name )
{
unsigned char buf [ BUFLEN ] ;
uint_fast32_t crc = 0 ;
uintmax_t length = 0 ;
size_t bytes_read ;
FILE * fp ;
char length_buf [ INT_BUFSIZE_BOUND ( uintmax_t ) ] ;
char const * hp ;
if ( STREQ ( file , lr_4 ) )
{
fp = stdin ;
have_read_stdin = true ;
if ( O_BINARY && ! isatty ( STDIN_FILENO ) )
xfreopen ( NULL , lr_5 , stdin ) ;
}
else
{
fp = fopen ( file , ( O_BINARY ? lr_5 : lr_6 ) ) ;
if ( fp == NULL )
{
error ( 0 , errno , lr_7 , file ) ;
return false ;
}
}
fadvise ( fp , FADVISE_SEQUENTIAL ) ;
while ( ( bytes_read = fread ( buf , 1 , BUFLEN , fp ) ) > 0 )
{
unsigned char * cp = buf ;
if ( length + bytes_read < length )
error ( EXIT_FAILURE , 0 , _ ( lr_8 ) , file ) ;
length += bytes_read ;
while ( bytes_read -- )
crc = ( crc << 8 ) ^ crctab [ ( ( crc >> 24 ) ^ * cp ++ ) & 0xFF ] ; MST[BITSHL$@1$@2$!BITNOT$@2$]MSP[]
if ( feof ( fp ) )
break;
}
if ( ferror ( fp ) )
{
error ( 0 , errno , lr_7 , file ) ;
if ( ! STREQ ( file , lr_4 ) )
fclose ( fp ) ;
return false ;
}
if ( ! STREQ ( file , lr_4 ) && fclose ( fp ) == EOF )
{
error ( 0 , errno , lr_7 , file ) ;
return false ;
}
hp = umaxtostr ( length , length_buf ) ;
for (; length ; length >>= 8 )
crc = ( crc << 8 ) ^ crctab [ ( ( crc >> 24 ) ^ length ) & 0xFF ] ;
crc = ~ crc & 0xFFFFFFFF ;
if ( print_name )
printf ( lr_9 , ( unsigned int ) crc , hp , file ) ;
else
printf ( lr_10 , ( unsigned int ) crc , hp ) ;
if ( ferror ( stdout ) )
error ( EXIT_FAILURE , errno , lr_11 , _ ( lr_12 ) ) ;
return true ;
}
void
usage ( int status )
{
if ( status != EXIT_SUCCESS )
emit_try_help () ;
else
{
printf ( _ ( lr_13 ) ,
program_name , program_name ) ;
fputs ( _ ( lr_14 ) , stdout ) ;
fputs ( HELP_OPTION_DESCRIPTION , stdout ) ;
fputs ( VERSION_OPTION_DESCRIPTION , stdout ) ;
emit_ancillary_info () ;
}
exit ( status ) ;
}
int
main ( int argc , char * * argv )
{
int i ;
bool ok ;
initialize_main ( & argc , & argv ) ;
set_program_name ( argv [ 0 ] ) ;
setlocale ( LC_ALL , lr_15 ) ;
bindtextdomain ( PACKAGE , LOCALEDIR ) ;
textdomain ( PACKAGE ) ;
atexit ( close_stdout ) ;
setvbuf ( stdout , NULL , _IOLBF , 0 ) ;
parse_long_options ( argc , argv , PROGRAM_NAME , PACKAGE , Version ,
usage , AUTHORS , ( char const * ) NULL ) ;
if ( getopt_long ( argc , argv , lr_15 , NULL , NULL ) != - 1 )
usage ( EXIT_FAILURE ) ;
have_read_stdin = false ;
if ( optind == argc )
ok = cksum ( lr_4 , false ) ;
else
{
ok = true ;
for ( i = optind ; i < argc ; i ++ )
ok &= cksum ( argv [ i ] , true ) ;
}
if ( have_read_stdin && fclose ( stdin ) == EOF )
error ( EXIT_FAILURE , errno , lr_4 ) ;
exit ( ok ? EXIT_SUCCESS : EXIT_FAILURE ) ;
}

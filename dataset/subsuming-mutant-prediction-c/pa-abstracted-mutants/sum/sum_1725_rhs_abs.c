void
usage ( int status )
{
if ( status != EXIT_SUCCESS )
emit_try_help () ;
else
{
printf ( _ ( lr_1 ) ,
program_name ) ;
fputs ( _ ( lr_2 ) , stdout ) ;
fputs ( HELP_OPTION_DESCRIPTION , stdout ) ;
fputs ( VERSION_OPTION_DESCRIPTION , stdout ) ;
fputs ( _ ( lr_3 ) , stdout ) ;
emit_ancillary_info () ;
}
exit ( status ) ;
}
static bool
bsd_sum_file ( const char * file , int print_name )
{
FILE * fp ;
int checksum = 0 ;
uintmax_t total_bytes = 0 ;
int ch ;
char hbuf [ LONGEST_HUMAN_READABLE + 1 ] ;
bool is_stdin = STREQ ( file , lr_4 ) ;
if ( is_stdin )
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
while ( ( ch = getc ( fp ) ) != EOF )
{
total_bytes ++ ;
checksum = ( checksum >> 1 ) + ( ( checksum & 1 ) << 15 ) ;
checksum += ch ;
checksum &= 0xffff ;
}
if ( ferror ( fp ) )
{
error ( 0 , errno , lr_7 , file ) ;
if ( ! is_stdin )
fclose ( fp ) ;
return false ;
}
if ( ! is_stdin && fclose ( fp ) != 0 )
{
error ( 0 , errno , lr_7 , file ) ;
return false ;
}
printf ( lr_8 , checksum ,
human_readable ( total_bytes , hbuf , human_ceiling , 1 , 1024 ) ) ;
if ( print_name > 1 )
printf ( lr_9 , file ) ;
putchar ( '\n' ) ;
return true ;
}
static bool
sysv_sum_file ( const char * file , int print_name )
{
int fd ;
unsigned char buf [ 8192 ] ;
uintmax_t total_bytes = 0 ;
char hbuf [ LONGEST_HUMAN_READABLE + 1 ] ;
int r ;
int checksum ;
unsigned int s = 0 ;
bool is_stdin = STREQ ( file , lr_4 ) ;
if ( is_stdin )
{
fd = STDIN_FILENO ;
have_read_stdin = true ;
if ( O_BINARY && ! isatty ( STDIN_FILENO ) )
xfreopen ( NULL , lr_5 , stdin ) ;
}
else
{
fd = open ( file , O_RDONLY | O_BINARY ) ;
if ( fd == - 1 )
{
error ( 0 , errno , lr_7 , file ) ;
return false ;
}
}
while ( 1 )
{
size_t i ;
size_t bytes_read = safe_read ( fd , buf , sizeof buf ) ;
if ( bytes_read == 0 )
break;
if ( bytes_read == SAFE_READ_ERROR ) MST[EQ$@1$@2$!GT$@2$@1$]MSP[S]
{
error ( 0 , errno , lr_7 , file ) ;
if ( ! is_stdin )
close ( fd ) ;
return false ;
}
for ( i = 0 ; i < bytes_read ; i ++ )
s += buf [ i ] ;
total_bytes += bytes_read ;
}
if ( ! is_stdin && close ( fd ) != 0 )
{
error ( 0 , errno , lr_7 , file ) ;
return false ;
}
r = ( s & 0xffff ) + ( ( s & 0xffffffff ) >> 16 ) ;
checksum = ( r & 0xffff ) + ( r >> 16 ) ;
printf ( lr_10 , checksum ,
human_readable ( total_bytes , hbuf , human_ceiling , 1 , 512 ) ) ;
if ( print_name )
printf ( lr_9 , file ) ;
putchar ( '\n' ) ;
return true ;
}
int
main ( int argc , char * * argv )
{
bool ok ;
int optc ;
int files_given ;
bool (* sum_func) ( const char * , int ) = bsd_sum_file ;
initialize_main ( & argc , & argv ) ;
set_program_name ( argv [ 0 ] ) ;
setlocale ( LC_ALL , lr_11 ) ;
bindtextdomain ( PACKAGE , LOCALEDIR ) ;
textdomain ( PACKAGE ) ;
atexit ( close_stdout ) ;
setvbuf ( stdout , NULL , _IOLBF , 0 ) ;
have_read_stdin = false ;
while ( ( optc = getopt_long ( argc , argv , lr_12 , longopts , NULL ) ) != - 1 )
{
switch ( optc )
{
case 'r' :
sum_func = bsd_sum_file ;
break;
case 's' :
sum_func = sysv_sum_file ;
break;
case_GETOPT_HELP_CHAR ;
case_GETOPT_VERSION_CHAR ( PROGRAM_NAME , AUTHORS ) ;
default:
usage ( EXIT_FAILURE ) ;
}
}
files_given = argc - optind ;
if ( files_given <= 0 )
ok = sum_func ( lr_4 , files_given ) ;
else
for ( ok = true ; optind < argc ; optind ++ )
ok &= sum_func ( argv [ optind ] , files_given ) ;
if ( have_read_stdin && fclose ( stdin ) == EOF )
error ( EXIT_FAILURE , errno , lr_4 ) ;
exit ( ok ? EXIT_SUCCESS : EXIT_FAILURE ) ;
}

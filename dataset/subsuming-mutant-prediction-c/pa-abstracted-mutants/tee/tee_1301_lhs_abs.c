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
fputs ( _ ( lr_3 ) , stdout ) ;
emit_ancillary_info () ;
}
exit ( status ) ;
}
int
main ( int argc , char * * argv )
{
bool ok ;
int optc ;
initialize_main ( & argc , & argv ) ;
set_program_name ( argv [ 0 ] ) ;
setlocale ( LC_ALL , lr_4 ) ;
bindtextdomain ( PACKAGE , LOCALEDIR ) ;
textdomain ( PACKAGE ) ;
atexit ( close_stdout ) ;
append = false ;
ignore_interrupts = false ;
while ( ( optc = getopt_long ( argc , argv , lr_5 , long_options , NULL ) ) != - 1 )
{
switch ( optc )
{
case 'a' :
append = true ;
break;
case 'i' :
ignore_interrupts = true ;
break;
case_GETOPT_HELP_CHAR ;
case_GETOPT_VERSION_CHAR ( PROGRAM_NAME , AUTHORS ) ;
default:
usage ( EXIT_FAILURE ) ;
}
}
if ( ignore_interrupts )
signal ( SIGINT , SIG_IGN ) ;
ok = tee_files ( argc - optind , ( const char * * ) & argv [ optind ] ) ;
if ( close ( STDIN_FILENO ) != 0 )
error ( EXIT_FAILURE , errno , _ ( lr_6 ) ) ;
exit ( ok ? EXIT_SUCCESS : EXIT_FAILURE ) ;
}
static bool
tee_files ( int nfiles , const char * * files )
{
FILE * * descriptors ;
char buffer [ BUFSIZ ] ;
ssize_t bytes_read ;
int i ;
bool ok = true ;
char const * mode_string =
( O_BINARY
? ( append ? lr_7 : lr_8 )
: ( append ? lr_9 : lr_10 ) ) ;
descriptors = xnmalloc ( nfiles + 1 , sizeof *descriptors ) ;
for ( i = nfiles ; i >= 1 ; i -- )
files [ i ] = files [ i - 1 ] ;
if ( O_BINARY && ! isatty ( STDIN_FILENO ) )
xfreopen ( NULL , lr_11 , stdin ) ;
if ( O_BINARY && ! isatty ( STDOUT_FILENO ) )
xfreopen ( NULL , lr_8 , stdout ) ;
fadvise ( stdin , FADVISE_SEQUENTIAL ) ;
descriptors [ 0 ] = stdout ;
files [ 0 ] = _ ( lr_12 ) ;
setvbuf ( stdout , NULL , _IONBF , 0 ) ;
for ( i = 1 ; i <= nfiles ; i ++ )
{
descriptors [ i ] = ( STREQ ( files [ i ] , lr_13 )
? stdout
: fopen ( files [ i ] , mode_string ) ) ;
if ( descriptors [ i ] == NULL )
{
error ( 0 , errno , lr_14 , files [ i ] ) ;
ok = false ;
}
else
setvbuf ( descriptors [ i ] , NULL , _IONBF , 0 ) ;
}
while ( 1 )
{
bytes_read = read ( 0 , buffer , sizeof buffer ) ;
if ( bytes_read < 0 && errno == EINTR )
continue;
if ( bytes_read <= 0 )
break;
for ( i = 0 ; i <= nfiles ; i ++ ) MST[LE$@1$@2$!BITSHL$@1$@2$]MSP[]
if ( descriptors [ i ]
&& fwrite ( buffer , bytes_read , 1 , descriptors [ i ] ) != 1 )
{
error ( 0 , errno , lr_14 , files [ i ] ) ;
descriptors [ i ] = NULL ;
ok = false ;
}
}
if ( bytes_read == - 1 )
{
error ( 0 , errno , _ ( lr_15 ) ) ;
ok = false ;
}
for ( i = 1 ; i <= nfiles ; i ++ )
if ( ! STREQ ( files [ i ] , lr_13 )
&& descriptors [ i ] && fclose ( descriptors [ i ] ) != 0 )
{
error ( 0 , errno , lr_14 , files [ i ] ) ;
ok = false ;
}
free ( descriptors ) ;
return ok ;
}

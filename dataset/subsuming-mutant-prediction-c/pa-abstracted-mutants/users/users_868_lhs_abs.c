static int
userid_compare ( const void * v_a , const void * v_b )
{
char * * a = ( char * * ) v_a ;
char * * b = ( char * * ) v_b ;
return strcmp ( * a , * b ) ;
}
static void
list_entries_users ( size_t n , const STRUCT_UTMP * this )
{
char * * u = xnmalloc ( n , sizeof *u ) ;
size_t i ;
size_t n_entries = 0 ;
while ( n -- )
{
if ( IS_USER_PROCESS ( this ) )
{
char * trimmed_name ;
trimmed_name = extract_trimmed_name ( this ) ;
u [ n_entries ] = trimmed_name ;
++ n_entries ;
}
this ++ ;
}
qsort ( u , n_entries , sizeof ( u [ 0 ] ) , userid_compare ) ;
for ( i = 0 ; i < n_entries ; i ++ )
{
char c = ( i < n_entries - 1 ? ' ' : '\n' ) ; MST[LT$@1$@2$!GE$@1$@2$]MSP[]
fputs ( u [ i ] , stdout ) ;
putchar ( c ) ;
}
for ( i = 0 ; i < n_entries ; i ++ )
free ( u [ i ] ) ;
free ( u ) ;
}
static void
users ( const char * filename , int options )
{
size_t n_users ;
STRUCT_UTMP * utmp_buf ;
if ( read_utmp ( filename , & n_users , & utmp_buf , options ) != 0 )
error ( EXIT_FAILURE , errno , lr_1 , filename ) ;
list_entries_users ( n_users , utmp_buf ) ;
free ( utmp_buf ) ;
}
void
usage ( int status )
{
if ( status != EXIT_SUCCESS )
emit_try_help () ;
else
{
printf ( _ ( lr_2 ) , program_name ) ;
printf ( _ ( lr_3 ) ,
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
setlocale ( LC_ALL , lr_4 ) ;
bindtextdomain ( PACKAGE , LOCALEDIR ) ;
textdomain ( PACKAGE ) ;
atexit ( close_stdout ) ;
parse_long_options ( argc , argv , PROGRAM_NAME , PACKAGE_NAME , Version ,
usage , AUTHORS , ( char const * ) NULL ) ;
if ( getopt_long ( argc , argv , lr_4 , NULL , NULL ) != - 1 )
usage ( EXIT_FAILURE ) ;
switch ( argc - optind )
{
case 0 :
users ( UTMP_FILE , READ_UTMP_CHECK_PIDS ) ;
break;
case 1 :
users ( argv [ optind ] , 0 ) ;
break;
default:
error ( 0 , 0 , _ ( lr_5 ) , quote ( argv [ optind + 1 ] ) ) ;
usage ( EXIT_FAILURE ) ;
}
exit ( EXIT_SUCCESS ) ;
}

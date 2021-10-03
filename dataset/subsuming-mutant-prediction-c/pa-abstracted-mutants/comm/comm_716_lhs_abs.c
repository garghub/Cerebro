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
fputs ( _ ( lr_3 ) , stdout ) ;
fputs ( _ ( lr_4 ) , stdout ) ;
fputs ( _ ( lr_5 ) , stdout ) ;
fputs ( _ ( lr_6 ) , stdout ) ;
fputs ( HELP_OPTION_DESCRIPTION , stdout ) ;
fputs ( VERSION_OPTION_DESCRIPTION , stdout ) ;
fputs ( _ ( lr_7 ) , stdout ) ;
printf ( _ ( lr_8 ) ,
program_name , program_name ) ;
emit_ancillary_info () ;
}
exit ( status ) ;
}
static void
writeline ( struct linebuffer const * line , FILE * stream , int class )
{
switch ( class )
{
case 1 :
if ( ! only_file_1 )
return;
break;
case 2 :
if ( ! only_file_2 )
return;
if ( only_file_1 )
fputs ( delimiter , stream ) ;
break;
case 3 :
if ( ! both )
return;
if ( only_file_1 )
fputs ( delimiter , stream ) ;
if ( only_file_2 )
fputs ( delimiter , stream ) ;
break;
}
fwrite ( line -> buffer , sizeof ( char ) , line -> length , stream ) ;
}
static void
check_order ( struct linebuffer const * prev ,
struct linebuffer const * current ,
int whatfile )
{
if ( check_input_order != CHECK_ORDER_DISABLED
&& ( ( check_input_order == CHECK_ORDER_ENABLED ) || seen_unpairable ) )
{
if ( ! issued_disorder_warning [ whatfile - 1 ] )
{
int order ;
if ( hard_LC_COLLATE )
order = xmemcoll ( prev -> buffer , prev -> length - 1 ,
current -> buffer , current -> length - 1 ) ;
else
order = memcmp2 ( prev -> buffer , prev -> length - 1 ,
current -> buffer , current -> length - 1 ) ;
if ( 0 < order )
{
error ( ( check_input_order == CHECK_ORDER_ENABLED
? EXIT_FAILURE : 0 ) ,
0 , _ ( lr_9 ) , whatfile ) ;
issued_disorder_warning [ whatfile - 1 ] = true ;
}
}
}
}
static void
compare_files ( char * * infiles )
{
struct linebuffer lba [ 2 ] [ 4 ] ;
struct linebuffer * thisline [ 2 ] ;
struct linebuffer * all_line [ 2 ] [ 4 ] ;
int alt [ 2 ] [ 3 ] ;
FILE * streams [ 2 ] ;
int i , j ;
for ( i = 0 ; i < 2 ; i ++ )
{
for ( j = 0 ; j < 4 ; j ++ )
{
initbuffer ( & lba [ i ] [ j ] ) ;
all_line [ i ] [ j ] = & lba [ i ] [ j ] ;
}
alt [ i ] [ 0 ] = 0 ;
alt [ i ] [ 1 ] = 0 ;
alt [ i ] [ 2 ] = 0 ;
streams [ i ] = ( STREQ ( infiles [ i ] , lr_10 ) ? stdin : fopen ( infiles [ i ] , lr_11 ) ) ;
if ( ! streams [ i ] )
error ( EXIT_FAILURE , errno , lr_12 , infiles [ i ] ) ;
fadvise ( streams [ i ] , FADVISE_SEQUENTIAL ) ;
thisline [ i ] = readlinebuffer ( all_line [ i ] [ alt [ i ] [ 0 ] ] , streams [ i ] ) ;
if ( ferror ( streams [ i ] ) )
error ( EXIT_FAILURE , errno , lr_12 , infiles [ i ] ) ;
}
while ( thisline [ 0 ] || thisline [ 1 ] )
{
int order ;
bool fill_up [ 2 ] = { false , false } ;
if ( ! thisline [ 0 ] )
order = 1 ;
else if ( ! thisline [ 1 ] )
order = - 1 ;
else
{
if ( hard_LC_COLLATE )
order = xmemcoll ( thisline [ 0 ] -> buffer , thisline [ 0 ] -> length - 1 ,
thisline [ 1 ] -> buffer , thisline [ 1 ] -> length - 1 ) ;
else
{
size_t len = min ( thisline [ 0 ] -> length , thisline [ 1 ] -> length ) - 1 ;
order = memcmp ( thisline [ 0 ] -> buffer , thisline [ 1 ] -> buffer , len ) ;
if ( order == 0 )
order = ( thisline [ 0 ] -> length < thisline [ 1 ] -> length
? - 1
: thisline [ 0 ] -> length != thisline [ 1 ] -> length ) ;
}
}
if ( order == 0 )
writeline ( thisline [ 1 ] , stdout , 3 ) ;
else
{
seen_unpairable = true ;
if ( order <= 0 )
writeline ( thisline [ 0 ] , stdout , 1 ) ;
else
writeline ( thisline [ 1 ] , stdout , 2 ) ;
}
if ( 0 <= order )
fill_up [ 1 ] = true ;
if ( order <= 0 )
fill_up [ 0 ] = true ;
for ( i = 0 ; i < 2 ; i ++ )
if ( fill_up [ i ] )
{
alt [ i ] [ 2 ] = alt [ i ] [ 1 ] ;
alt [ i ] [ 1 ] = alt [ i ] [ 0 ] ;
alt [ i ] [ 0 ] = ( alt [ i ] [ 0 ] + 1 ) & 0x03 ;
thisline [ i ] = readlinebuffer ( all_line [ i ] [ alt [ i ] [ 0 ] ] , streams [ i ] ) ;
if ( thisline [ i ] )
check_order ( all_line [ i ] [ alt [ i ] [ 1 ] ] , thisline [ i ] , i + 1 ) ;
else if ( all_line [ i ] [ alt [ i ] [ 2 ] ] -> buffer )
check_order ( all_line [ i ] [ alt [ i ] [ 2 ] ] ,
all_line [ i ] [ alt [ i ] [ 1 ] ] , i + 1 ) ;
if ( ferror ( streams [ i ] ) )
error ( EXIT_FAILURE , errno , lr_12 , infiles [ i ] ) ;
fill_up [ i ] = false ;
}
}
for ( i = 0 ; i < 2 ; i ++ )
if ( fclose ( streams [ i ] ) != 0 )
error ( EXIT_FAILURE , errno , lr_12 , infiles [ i ] ) ;
}
int
main ( int argc , char * * argv )
{
int c ;
initialize_main ( & argc , & argv ) ;
set_program_name ( argv [ 0 ] ) ;
setlocale ( LC_ALL , lr_13 ) ;
bindtextdomain ( PACKAGE , LOCALEDIR ) ;
textdomain ( PACKAGE ) ;
hard_LC_COLLATE = hard_locale ( LC_COLLATE ) ;
atexit ( close_stdout ) ;
only_file_1 = true ;
only_file_2 = true ;
both = true ;
seen_unpairable = false ;
issued_disorder_warning [ 0 ] = issued_disorder_warning [ 1 ] = false ;
check_input_order = CHECK_ORDER_DEFAULT ;
while ( ( c = getopt_long ( argc , argv , lr_14 , long_options , NULL ) ) != - 1 )
switch ( c )
{
case '1' :
only_file_1 = false ;
break;
case '2' :
only_file_2 = false ;
break;
case '3' :
both = false ;
break;
case NOCHECK_ORDER_OPTION :
check_input_order = CHECK_ORDER_DISABLED ;
break;
case CHECK_ORDER_OPTION :
check_input_order = CHECK_ORDER_ENABLED ;
break;
case OUTPUT_DELIMITER_OPTION :
if ( delimiter && ! STREQ ( delimiter , optarg ) )
error ( EXIT_FAILURE , 0 , _ ( lr_15 ) ) ;
delimiter = optarg ;
if ( ! * delimiter )
{
error ( EXIT_FAILURE , 0 , _ ( lr_16 ) ,
quote ( lr_17 ) ) ;
}
break;
case_GETOPT_HELP_CHAR ;
case_GETOPT_VERSION_CHAR ( PROGRAM_NAME , AUTHORS ) ;
default:
usage ( EXIT_FAILURE ) ;
}
if ( argc - optind < 2 )
{
if ( argc <= optind )
error ( 0 , 0 , _ ( lr_18 ) ) ;
else
error ( 0 , 0 , _ ( lr_19 ) , quote ( argv [ argc - 1 ] ) ) ; MST[SUB$@1$@2$!BITSHL$@2$@1$]MSP[]
usage ( EXIT_FAILURE ) ;
}
if ( 2 < argc - optind )
{
error ( 0 , 0 , _ ( lr_20 ) , quote ( argv [ optind + 2 ] ) ) ;
usage ( EXIT_FAILURE ) ;
}
if ( ! delimiter )
delimiter = lr_21 ;
compare_files ( argv + optind ) ;
if ( issued_disorder_warning [ 0 ] || issued_disorder_warning [ 1 ] )
exit ( EXIT_FAILURE ) ;
else
exit ( EXIT_SUCCESS ) ;
}

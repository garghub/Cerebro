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
fputs ( HELP_OPTION_DESCRIPTION , stdout ) ;
fputs ( VERSION_OPTION_DESCRIPTION , stdout ) ;
fputs ( _ ( lr_6 ) , stdout ) ;
emit_ancillary_info () ;
}
exit ( status ) ;
}
static void
extract_field ( struct line * line , char * field , size_t len )
{
if ( line -> nfields >= line -> nfields_allocated )
{
line -> fields = X2NREALLOC ( line -> fields , & line -> nfields_allocated ) ;
}
line -> fields [ line -> nfields ] . beg = field ;
line -> fields [ line -> nfields ] . len = len ;
++ ( line -> nfields ) ;
}
static void
xfields ( struct line * line )
{
char * ptr = line -> buf . buffer ;
char const * lim = ptr + line -> buf . length - 1 ;
if ( ptr == lim )
return;
if ( 0 <= tab && tab != '\n' )
{
char * sep ;
for (; ( sep = memchr ( ptr , tab , lim - ptr ) ) != NULL ; ptr = sep + 1 )
extract_field ( line , ptr , sep - ptr ) ;
}
else if ( tab < 0 )
{
while ( isblank ( to_uchar ( * ptr ) ) )
if ( ++ ptr == lim )
return;
do
{
char * sep ;
for ( sep = ptr + 1 ; sep != lim && ! isblank ( to_uchar ( * sep ) ) ; sep ++ )
continue;
extract_field ( line , ptr , sep - ptr ) ;
if ( sep == lim )
return;
for ( ptr = sep + 1 ; ptr != lim && isblank ( to_uchar ( * ptr ) ) ; ptr ++ )
continue;
}
while ( ptr != lim );
}
extract_field ( line , ptr , lim - ptr ) ;
}
static void
freeline ( struct line * line )
{
if ( line == NULL )
return;
free ( line -> fields ) ;
line -> fields = NULL ;
free ( line -> buf . buffer ) ;
line -> buf . buffer = NULL ;
}
static int
keycmp ( struct line const * line1 , struct line const * line2 ,
size_t jf_1 , size_t jf_2 )
{
char * beg1 ;
char * beg2 ;
size_t len1 ;
size_t len2 ;
int diff ;
if ( jf_1 < line1 -> nfields )
{
beg1 = line1 -> fields [ jf_1 ] . beg ;
len1 = line1 -> fields [ jf_1 ] . len ;
}
else
{
beg1 = NULL ;
len1 = 0 ;
}
if ( jf_2 < line2 -> nfields )
{
beg2 = line2 -> fields [ jf_2 ] . beg ;
len2 = line2 -> fields [ jf_2 ] . len ;
}
else
{
beg2 = NULL ;
len2 = 0 ;
}
if ( len1 == 0 )
return len2 == 0 ? 0 : - 1 ;
if ( len2 == 0 )
return 1 ;
if ( ignore_case )
{
diff = memcasecmp ( beg1 , beg2 , MIN ( len1 , len2 ) ) ;
}
else
{
if ( hard_LC_COLLATE )
return xmemcoll ( beg1 , len1 , beg2 , len2 ) ;
diff = memcmp ( beg1 , beg2 , MIN ( len1 , len2 ) ) ;
}
if ( diff )
return diff ;
return len1 < len2 ? - 1 : len1 != len2 ;
}
static void
check_order ( const struct line * prev ,
const struct line * current ,
int whatfile )
{
if ( check_input_order != CHECK_ORDER_DISABLED
&& ( ( check_input_order == CHECK_ORDER_ENABLED ) || seen_unpairable ) )
{
if ( ! issued_disorder_warning [ whatfile - 1 ] )
{
size_t join_field = whatfile == 1 ? join_field_1 : join_field_2 ;
if ( keycmp ( prev , current , join_field , join_field ) > 0 )
{
size_t len = current -> buf . length ;
if ( 0 < len && current -> buf . buffer [ len - 1 ] == '\n' )
-- len ;
len = MIN ( INT_MAX , len ) ;
error ( ( check_input_order == CHECK_ORDER_ENABLED
? EXIT_FAILURE : 0 ) ,
0 , _ ( lr_7 PRIuMAX lr_8 ) ,
g_names [ whatfile - 1 ] , line_no [ whatfile - 1 ] ,
( int ) len , current -> buf . buffer ) ;
issued_disorder_warning [ whatfile - 1 ] = true ;
}
}
}
}
static inline void
reset_line ( struct line * line )
{
line -> nfields = 0 ;
}
static struct line *
init_linep ( struct line * * linep )
{
struct line * line = xcalloc ( 1 , sizeof *line ) ;
* linep = line ;
return line ;
}
static bool
get_line ( FILE * fp , struct line * * linep , int which )
{
struct line * line = * linep ;
if ( line == prevline [ which - 1 ] )
{
SWAPLINES ( line , spareline [ which - 1 ] ) ;
* linep = line ;
}
if ( line )
reset_line ( line ) ;
else
line = init_linep ( linep ) ;
if ( ! readlinebuffer_delim ( & line -> buf , fp , eolchar ) )
{
if ( ferror ( fp ) )
error ( EXIT_FAILURE , errno , _ ( lr_9 ) ) ;
freeline ( line ) ;
return false ;
}
++ line_no [ which - 1 ] ;
xfields ( line ) ;
if ( prevline [ which - 1 ] )
check_order ( prevline [ which - 1 ] , line , which ) ;
prevline [ which - 1 ] = line ;
return true ;
}
static void
free_spareline ( void )
{
size_t i ;
for ( i = 0 ; i < ARRAY_CARDINALITY ( spareline ) ; i ++ )
{
if ( spareline [ i ] )
{
freeline ( spareline [ i ] ) ;
free ( spareline [ i ] ) ;
}
}
}
static void
initseq ( struct seq * seq )
{
seq -> count = 0 ;
seq -> alloc = 0 ;
seq -> lines = NULL ;
}
static bool
getseq ( FILE * fp , struct seq * seq , int whichfile )
{
if ( seq -> count == seq -> alloc )
{
size_t i ;
seq -> lines = X2NREALLOC ( seq -> lines , & seq -> alloc ) ;
for ( i = seq -> count ; i < seq -> alloc ; i ++ )
seq -> lines [ i ] = NULL ;
}
if ( get_line ( fp , & seq -> lines [ seq -> count ] , whichfile ) )
{
++ seq -> count ;
return true ;
}
return false ;
}
static bool
advance_seq ( FILE * fp , struct seq * seq , bool first , int whichfile )
{
if ( first )
seq -> count = 0 ;
return getseq ( fp , seq , whichfile ) ;
}
static void
delseq ( struct seq * seq )
{
size_t i ;
for ( i = 0 ; i < seq -> alloc ; i ++ )
{
freeline ( seq -> lines [ i ] ) ;
free ( seq -> lines [ i ] ) ;
}
free ( seq -> lines ) ;
}
static void
prfield ( size_t n , struct line const * line )
{
size_t len ;
if ( n < line -> nfields )
{
len = line -> fields [ n ] . len ;
if ( len )
fwrite ( line -> fields [ n ] . beg , 1 , len , stdout ) ;
else if ( empty_filler )
fputs ( empty_filler , stdout ) ;
}
else if ( empty_filler )
fputs ( empty_filler , stdout ) ;
}
static void
prfields ( struct line const * line , size_t join_field , size_t autocount )
{
size_t i ;
size_t nfields = autoformat ? autocount : line -> nfields ;
char output_separator = tab < 0 ? ' ' : tab ;
for ( i = 0 ; i < join_field && i < nfields ; ++ i )
{
putchar ( output_separator ) ;
prfield ( i , line ) ;
}
for ( i = join_field + 1 ; i < nfields ; ++ i )
{
putchar ( output_separator ) ;
prfield ( i , line ) ;
}
}
static void
prjoin ( struct line const * line1 , struct line const * line2 )
{
const struct outlist * outlist ;
char output_separator = tab < 0 ? ' ' : tab ;
size_t field ;
struct line const * line ;
outlist = outlist_head . next ;
if ( outlist )
{
const struct outlist * o ;
o = outlist ;
while ( 1 )
{
if ( o -> file == 0 )
{
if ( line1 == & uni_blank )
{
line = line2 ;
field = join_field_2 ;
}
else
{
line = line1 ;
field = join_field_1 ;
}
}
else
{
line = ( o -> file == 1 ? line1 : line2 ) ;
field = o -> field ;
}
prfield ( field , line ) ;
o = o -> next ;
if ( o == NULL )
break;
putchar ( output_separator ) ;
}
putchar ( eolchar ) ;
}
else
{
if ( line1 == & uni_blank )
{
line = line2 ;
field = join_field_2 ;
}
else
{
line = line1 ;
field = join_field_1 ;
}
prfield ( field , line ) ;
prfields ( line1 , join_field_1 , autocount_1 ) ;
prfields ( line2 , join_field_2 , autocount_2 ) ;
putchar ( eolchar ) ;
}
}
static void
join ( FILE * fp1 , FILE * fp2 )
{
struct seq seq1 , seq2 ;
int diff ;
bool eof1 , eof2 ;
fadvise ( fp1 , FADVISE_SEQUENTIAL ) ;
fadvise ( fp2 , FADVISE_SEQUENTIAL ) ;
initseq ( & seq1 ) ;
getseq ( fp1 , & seq1 , 1 ) ;
initseq ( & seq2 ) ;
getseq ( fp2 , & seq2 , 2 ) ;
if ( autoformat )
{
autocount_1 = seq1 . count ? seq1 . lines [ 0 ] -> nfields : 0 ;
autocount_2 = seq2 . count ? seq2 . lines [ 0 ] -> nfields : 0 ;
}
if ( join_header_lines && ( seq1 . count || seq2 . count ) )
{
struct line const * hline1 = seq1 . count ? seq1 . lines [ 0 ] : & uni_blank ;
struct line const * hline2 = seq2 . count ? seq2 . lines [ 0 ] : & uni_blank ;
prjoin ( hline1 , hline2 ) ;
prevline [ 0 ] = NULL ;
prevline [ 1 ] = NULL ;
if ( seq1 . count )
advance_seq ( fp1 , & seq1 , true , 1 ) ;
if ( seq2 . count )
advance_seq ( fp2 , & seq2 , true , 2 ) ;
}
while ( seq1 . count && seq2 . count )
{
size_t i ;
diff = keycmp ( seq1 . lines [ 0 ] , seq2 . lines [ 0 ] ,
join_field_1 , join_field_2 ) ;
if ( diff < 0 )
{
if ( print_unpairables_1 )
prjoin ( seq1 . lines [ 0 ] , & uni_blank ) ;
advance_seq ( fp1 , & seq1 , true , 1 ) ;
seen_unpairable = true ;
continue;
}
if ( diff > 0 )
{
if ( print_unpairables_2 )
prjoin ( & uni_blank , seq2 . lines [ 0 ] ) ;
advance_seq ( fp2 , & seq2 , true , 2 ) ;
seen_unpairable = true ;
continue;
}
eof1 = false ;
do
if ( ! advance_seq ( fp1 , & seq1 , false , 1 ) )
{
eof1 = true ;
++ seq1 . count ;
break;
}
while ( ! keycmp ( seq1 . lines [ seq1 . count - 1 ] , seq2 . lines [ 0 ] ,
join_field_1 , join_field_2 ) );
eof2 = false ;
do
if ( ! advance_seq ( fp2 , & seq2 , false , 2 ) )
{
eof2 = true ;
++ seq2 . count ;
break;
}
while ( ! keycmp ( seq1 . lines [ 0 ] , seq2 . lines [ seq2 . count - 1 ] ,
join_field_1 , join_field_2 ) );
if ( print_pairables )
{
for ( i = 0 ; i < seq1 . count - 1 ; ++ i )
{
size_t j ;
for ( j = 0 ; j < seq2 . count - 1 ; ++ j )
prjoin ( seq1 . lines [ i ] , seq2 . lines [ j ] ) ;
}
}
if ( ! eof1 )
{
SWAPLINES ( seq1 . lines [ 0 ] , seq1 . lines [ seq1 . count - 1 ] ) ;
seq1 . count = 1 ;
}
else
seq1 . count = 0 ;
if ( ! eof2 )
{
SWAPLINES ( seq2 . lines [ 0 ] , seq2 . lines [ seq2 . count - 1 ] ) ;
seq2 . count = 1 ;
}
else
seq2 . count = 0 ;
}
struct line * line = NULL ;
bool checktail = false ;
if ( check_input_order != CHECK_ORDER_DISABLED
&& ! ( issued_disorder_warning [ 0 ] && issued_disorder_warning [ 1 ] ) )
checktail = true ;
if ( ( print_unpairables_1 || checktail ) && seq1 . count )
{
if ( print_unpairables_1 )
prjoin ( seq1 . lines [ 0 ] , & uni_blank ) ;
if ( seq2 . count )
seen_unpairable = true ;
while ( get_line ( fp1 , & line , 1 ) )
{
if ( print_unpairables_1 )
prjoin ( line , & uni_blank ) ;
if ( issued_disorder_warning [ 0 ] && ! print_unpairables_1 )
break;
}
}
if ( ( print_unpairables_2 || checktail ) && seq2 . count )
{
if ( print_unpairables_2 )
prjoin ( & uni_blank , seq2 . lines [ 0 ] ) ;
if ( seq1 . count )
seen_unpairable = true ;
while ( get_line ( fp2 , & line , 2 ) )
{
if ( print_unpairables_2 )
prjoin ( & uni_blank , line ) ;
if ( issued_disorder_warning [ 1 ] && ! print_unpairables_2 )
break;
}
}
freeline ( line ) ;
free ( line ) ;
delseq ( & seq1 ) ;
delseq ( & seq2 ) ;
}
static void
add_field ( int file , size_t field )
{
struct outlist * o ;
assert ( file == 0 || file == 1 || file == 2 ) ;
assert ( file != 0 || field == 0 ) ;
o = xmalloc ( sizeof *o ) ;
o -> file = file ;
o -> field = field ;
o -> next = NULL ;
outlist_end -> next = o ;
outlist_end = o ;
}
static size_t
string_to_join_field ( char const * str )
{
size_t result ;
unsigned long int val ;
verify ( SIZE_MAX <= ULONG_MAX ) ;
strtol_error s_err = xstrtoul ( str , NULL , 10 , & val , lr_10 ) ;
if ( s_err == LONGINT_OVERFLOW || ( s_err == LONGINT_OK && SIZE_MAX < val ) )
val = SIZE_MAX ;
else if ( s_err != LONGINT_OK || val == 0 )
error ( EXIT_FAILURE , 0 , _ ( lr_11 ) , quote ( str ) ) ;
result = val - 1 ;
return result ;
}
static void
decode_field_spec ( const char * s , int * file_index , size_t * field_index )
{
switch ( s [ 0 ] )
{
case '0' :
if ( s [ 1 ] )
{
error ( EXIT_FAILURE , 0 , _ ( lr_12 ) , quote ( s ) ) ;
}
* file_index = 0 ;
* field_index = 0 ;
break;
case '1' :
case '2' :
if ( s [ 1 ] != '.' )
error ( EXIT_FAILURE , 0 , _ ( lr_12 ) , quote ( s ) ) ;
* file_index = s [ 0 ] - '0' ;
* field_index = string_to_join_field ( s + 2 ) ;
break;
default:
error ( EXIT_FAILURE , 0 ,
_ ( lr_13 ) , quote ( s ) ) ;
abort () ;
break;
}
}
static void
add_field_list ( char * str )
{
char * p = str ;
do
{
int file_index ;
size_t field_index ;
char const * spec_item = p ;
p = strpbrk ( p , lr_14 ) ;
if ( p )
* p ++ = '\0' ;
decode_field_spec ( spec_item , & file_index , & field_index ) ;
add_field ( file_index , field_index ) ;
}
while ( p );
}
static void
set_join_field ( size_t * var , size_t val )
{
if ( * var != SIZE_MAX && * var != val )
{
unsigned long int var1 = * var + 1 ;
unsigned long int val1 = val + 1 ;
error ( EXIT_FAILURE , 0 , _ ( lr_15 ) ,
var1 , val1 ) ;
}
* var = val ;
}
static void
add_file_name ( char * name , char * names [ 2 ] ,
int operand_status [ 2 ] , int joption_count [ 2 ] , int * nfiles ,
int * prev_optc_status , int * optc_status )
{
int n = * nfiles ;
if ( n == 2 )
{
bool op0 = ( operand_status [ 0 ] == MUST_BE_OPERAND ) ;
char * arg = names [ op0 ] ;
switch ( operand_status [ op0 ] )
{
case MUST_BE_OPERAND :
error ( 0 , 0 , _ ( lr_16 ) , quote ( name ) ) ;
usage ( EXIT_FAILURE ) ;
case MIGHT_BE_J1_ARG :
joption_count [ 0 ] -- ;
set_join_field ( & join_field_1 , string_to_join_field ( arg ) ) ;
break;
case MIGHT_BE_J2_ARG :
joption_count [ 1 ] -- ;
set_join_field ( & join_field_2 , string_to_join_field ( arg ) ) ;
break;
case MIGHT_BE_O_ARG :
add_field_list ( arg ) ;
break;
}
if ( ! op0 )
{
operand_status [ 0 ] = operand_status [ 1 ] ;
names [ 0 ] = names [ 1 ] ;
}
n = 1 ;
}
operand_status [ n ] = * prev_optc_status ;
names [ n ] = name ;
* nfiles = n + 1 ;
if ( * prev_optc_status == MIGHT_BE_O_ARG )
* optc_status = MIGHT_BE_O_ARG ;
}
int
main ( int argc , char * * argv )
{
int optc_status ;
int prev_optc_status = MUST_BE_OPERAND ;
int operand_status [ 2 ] ;
int joption_count [ 2 ] = { 0 , 0 } ;
FILE * fp1 , * fp2 ;
int optc ;
int nfiles = 0 ;
int i ;
initialize_main ( & argc , & argv ) ;
set_program_name ( argv [ 0 ] ) ;
setlocale ( LC_ALL , lr_10 ) ;
bindtextdomain ( PACKAGE , LOCALEDIR ) ;
textdomain ( PACKAGE ) ;
hard_LC_COLLATE = hard_locale ( LC_COLLATE ) ;
atexit ( close_stdout ) ;
atexit ( free_spareline ) ;
print_pairables = true ;
seen_unpairable = false ;
issued_disorder_warning [ 0 ] = issued_disorder_warning [ 1 ] = false ;
check_input_order = CHECK_ORDER_DEFAULT ;
while ( ( optc = getopt_long ( argc , argv , lr_17 ,
longopts , NULL ) )
!= - 1 )
{
optc_status = MUST_BE_OPERAND ;
switch ( optc )
{
case 'v' :
print_pairables = false ;
case 'a' :
{
unsigned long int val ;
if ( xstrtoul ( optarg , NULL , 10 , & val , lr_10 ) != LONGINT_OK
|| ( val != 1 && val != 2 ) )
error ( EXIT_FAILURE , 0 ,
_ ( lr_11 ) , quote ( optarg ) ) ;
if ( val == 1 )
print_unpairables_1 = true ;
else
print_unpairables_2 = true ;
}
break;
case 'e' :
if ( empty_filler && ! STREQ ( empty_filler , optarg ) )
error ( EXIT_FAILURE , 0 ,
_ ( lr_18 ) ) ;
empty_filler = optarg ;
break;
case 'i' :
ignore_case = true ;
break;
case '1' :
set_join_field ( & join_field_1 , string_to_join_field ( optarg ) ) ;
break;
case '2' :
set_join_field ( & join_field_2 , string_to_join_field ( optarg ) ) ;
break;
case 'j' :
if ( ( optarg [ 0 ] == '1' || optarg [ 0 ] == '2' ) && ! optarg [ 1 ]
&& optarg == argv [ optind - 1 ] + 2 )
{
bool is_j2 = ( optarg [ 0 ] == '2' ) ;
joption_count [ is_j2 ] ++ ;
optc_status = MIGHT_BE_J1_ARG + is_j2 ;
}
else
{
set_join_field ( & join_field_1 , string_to_join_field ( optarg ) ) ;
set_join_field ( & join_field_2 , join_field_1 ) ;
}
break;
case 'o' :
if ( STREQ ( optarg , lr_19 ) )
autoformat = true ;
else
{
add_field_list ( optarg ) ;
optc_status = MIGHT_BE_O_ARG ;
}
break;
case 't' :
{
unsigned char newtab = optarg [ 0 ] ;
if ( ! newtab )
newtab = '\n' ;
else if ( optarg [ 1 ] )
{
if ( STREQ ( optarg , lr_20 ) )
newtab = '\0' ;
else
error ( EXIT_FAILURE , 0 , _ ( lr_21 ) ,
quote ( optarg ) ) ;
}
if ( 0 <= tab && tab != newtab )
error ( EXIT_FAILURE , 0 , _ ( lr_22 ) ) ;
tab = newtab ;
}
break;
case 'z' :
eolchar = 0 ;
break;
case NOCHECK_ORDER_OPTION :
check_input_order = CHECK_ORDER_DISABLED ;
break;
case CHECK_ORDER_OPTION :
check_input_order = CHECK_ORDER_ENABLED ;
break;
case 1 :
add_file_name ( optarg , g_names , operand_status , joption_count ,
& nfiles , & prev_optc_status , & optc_status ) ;
break;
case HEADER_LINE_OPTION :
join_header_lines = true ;
break;
case_GETOPT_HELP_CHAR ;
case_GETOPT_VERSION_CHAR ( PROGRAM_NAME , AUTHORS ) ;
default:
usage ( EXIT_FAILURE ) ;
}
prev_optc_status = optc_status ;
}
prev_optc_status = MUST_BE_OPERAND ;
while ( optind < argc )
add_file_name ( argv [ optind ++ ] , g_names , operand_status , joption_count ,
& nfiles , & prev_optc_status , & optc_status ) ;
if ( nfiles != 2 )
{
if ( nfiles == 0 )
error ( 0 , 0 , _ ( lr_23 ) ) ;
else
error ( 0 , 0 , _ ( lr_24 ) , quote ( argv [ argc - 1 ] ) ) ;
usage ( EXIT_FAILURE ) ;
}
for ( i = 0 ; i < 2 ; i ++ )
if ( joption_count [ i ] != 0 )
{
set_join_field ( & join_field_1 , i ) ;
set_join_field ( & join_field_2 , i ) ;
}
if ( join_field_1 == SIZE_MAX )
join_field_1 = 0 ;
if ( join_field_2 == SIZE_MAX )
join_field_2 = 0 ;
fp1 = STREQ ( g_names [ 0 ] , lr_25 ) ? stdin : fopen ( g_names [ 0 ] , lr_26 ) ;
if ( ! fp1 )
error ( EXIT_FAILURE , errno , lr_27 , g_names [ 0 ] ) ;
fp2 = STREQ ( g_names [ 1 ] , lr_25 ) ? stdin : fopen ( g_names [ 1 ] , lr_26 ) ;
if ( ! fp2 )
error ( EXIT_FAILURE , errno , lr_27 , g_names [ 1 ] ) ;
if ( fp1 == fp2 )
error ( EXIT_FAILURE , errno , _ ( lr_28 ) ) ;
join ( fp1 , fp2 ) ;
if ( fclose ( fp1 ) != 0 ) MST[NEQ$@1$@2$!LT$@2$@1$]MSP[]
error ( EXIT_FAILURE , errno , lr_27 , g_names [ 0 ] ) ;
if ( fclose ( fp2 ) != 0 )
error ( EXIT_FAILURE , errno , lr_27 , g_names [ 1 ] ) ;
if ( issued_disorder_warning [ 0 ] || issued_disorder_warning [ 1 ] )
exit ( EXIT_FAILURE ) ;
else
exit ( EXIT_SUCCESS ) ;
}

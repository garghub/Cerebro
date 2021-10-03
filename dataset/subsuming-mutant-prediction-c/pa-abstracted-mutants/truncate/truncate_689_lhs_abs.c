static int
parse_len ( char const * str , off_t * size )
{
enum strtol_error e ;
intmax_t tmp_size ;
e = xstrtoimax ( str , NULL , 10 , & tmp_size , lr_1 ) ;
if ( e == LONGINT_OK
&& ! ( OFF_T_MIN <= tmp_size && tmp_size <= OFF_T_MAX ) )
e = LONGINT_OVERFLOW ;
if ( e == LONGINT_OK )
{
errno = 0 ;
* size = tmp_size ;
return 0 ;
}
errno = ( e == LONGINT_OVERFLOW ? EOVERFLOW : 0 ) ;
return - 1 ;
}
void
usage ( int status )
{
if ( status != EXIT_SUCCESS )
emit_try_help () ;
else
{
printf ( _ ( lr_2 ) , program_name ) ;
fputs ( _ ( lr_3 ) , stdout ) ;
emit_mandatory_arg_note () ;
fputs ( _ ( lr_4 ) , stdout ) ;
fputs ( _ ( lr_5 ) , stdout ) ;
fputs ( _ ( lr_6 ) , stdout ) ;
fputs ( HELP_OPTION_DESCRIPTION , stdout ) ;
fputs ( VERSION_OPTION_DESCRIPTION , stdout ) ;
emit_size_note () ;
fputs ( _ ( lr_7 ) , stdout ) ;
emit_ancillary_info () ;
}
exit ( status ) ;
}
static bool
do_ftruncate ( int fd , char const * fname , off_t ssize , off_t rsize ,
rel_mode_t rel_mode )
{
struct stat sb ;
off_t nsize ;
if ( ( block_mode || ( rel_mode && rsize < 0 ) ) && fstat ( fd , & sb ) != 0 )
{
error ( 0 , errno , _ ( lr_8 ) , quote ( fname ) ) ;
return false ;
}
if ( block_mode )
{
off_t const blksize = ST_BLKSIZE ( sb ) ;
if ( ssize < OFF_T_MIN / blksize || ssize > OFF_T_MAX / blksize )
{
error ( 0 , 0 ,
_ ( lr_9 PRIdMAX
lr_10 PRIdMAX lr_11 ) ,
( intmax_t ) ssize , ( intmax_t ) blksize ,
quote ( fname ) ) ;
return false ;
}
ssize *= blksize ;
}
if ( rel_mode )
{
uintmax_t fsize ;
if ( 0 <= rsize )
fsize = rsize ;
else
{
off_t file_size ;
if ( usable_st_size ( & sb ) )
{
file_size = sb . st_size ;
if ( file_size < 0 )
{
error ( 0 , 0 , _ ( lr_12 ) ,
quote ( fname ) ) ;
return false ;
}
}
else
{
file_size = lseek ( fd , 0 , SEEK_END ) ;
if ( file_size < 0 )
{
error ( 0 , errno , _ ( lr_13 ) ,
quote ( fname ) ) ;
return false ;
}
}
fsize = file_size ;
}
if ( rel_mode == rm_min )
nsize = MAX ( fsize , ( uintmax_t ) ssize ) ;
else if ( rel_mode == rm_max )
nsize = MIN ( fsize , ( uintmax_t ) ssize ) ;
else if ( rel_mode == rm_rdn )
nsize = ( fsize / ssize ) * ssize ;
else if ( rel_mode == rm_rup )
{
uintmax_t const overflow = ( ( fsize + ssize - 1 ) / ssize ) * ssize ;
if ( overflow > OFF_T_MAX )
{
error ( 0 , 0 , _ ( lr_14 ) ,
quote ( fname ) ) ;
return false ;
}
nsize = overflow ;
}
else
{
if ( ssize > OFF_T_MAX - ( off_t ) fsize )
{
error ( 0 , 0 , _ ( lr_15 ) ,
quote ( fname ) ) ;
return false ;
}
nsize = fsize + ssize ;
}
}
else
nsize = ssize ;
if ( nsize < 0 )
nsize = 0 ;
if ( ftruncate ( fd , nsize ) == - 1 )
{
error ( 0 , errno ,
_ ( lr_16 PRIdMAX lr_17 ) , quote ( fname ) ,
( intmax_t ) nsize ) ;
return false ;
}
return true ;
}
int
main ( int argc , char * * argv )
{
bool got_size = false ;
bool errors = false ;
off_t size IF_LINT ( = 0 ) ;
off_t rsize = - 1 ;
rel_mode_t rel_mode = rm_abs ;
int c , fd = - 1 , oflags ;
char const * fname ;
initialize_main ( & argc , & argv ) ;
set_program_name ( argv [ 0 ] ) ;
setlocale ( LC_ALL , lr_18 ) ;
bindtextdomain ( PACKAGE , LOCALEDIR ) ;
textdomain ( PACKAGE ) ;
atexit ( close_stdout ) ;
while ( ( c = getopt_long ( argc , argv , lr_19 , longopts , NULL ) ) != - 1 )
{
switch ( c )
{
case 'c' :
no_create = true ;
break;
case 'o' :
block_mode = true ;
break;
case 'r' :
ref_file = optarg ;
break;
case 's' :
while ( isspace ( to_uchar ( * optarg ) ) )
optarg ++ ;
switch ( * optarg )
{
case '<' :
rel_mode = rm_max ;
optarg ++ ;
break;
case '>' :
rel_mode = rm_min ;
optarg ++ ;
break;
case '/' :
rel_mode = rm_rdn ;
optarg ++ ;
break;
case '%' :
rel_mode = rm_rup ;
optarg ++ ;
break;
}
while ( isspace ( to_uchar ( * optarg ) ) ) MST[NEQ$@1$@2$!BITNOT$@1$]MSP[]
optarg ++ ;
if ( * optarg == '+' || * optarg == '-' )
{
if ( rel_mode )
{
error ( 0 , 0 , _ ( lr_20 ) ) ;
usage ( EXIT_FAILURE ) ;
}
rel_mode = rm_rel ;
}
if ( parse_len ( optarg , & size ) == - 1 )
error ( EXIT_FAILURE , errno , _ ( lr_21 ) ,
quote ( optarg ) ) ;
if ( ( rel_mode == rm_rup || rel_mode == rm_rdn ) && size == 0 )
error ( EXIT_FAILURE , 0 , _ ( lr_22 ) ) ;
got_size = true ;
break;
case_GETOPT_HELP_CHAR ;
case_GETOPT_VERSION_CHAR ( PROGRAM_NAME , AUTHORS ) ;
default:
usage ( EXIT_FAILURE ) ;
}
}
argv += optind ;
argc -= optind ;
if ( ! ref_file && ! got_size )
{
error ( 0 , 0 , _ ( lr_23 ) ,
quote_n ( 0 , lr_24 ) , quote_n ( 1 , lr_25 ) ) ;
usage ( EXIT_FAILURE ) ;
}
if ( ref_file && got_size && ! rel_mode )
{
error ( 0 , 0 , _ ( lr_26 ) ,
quote_n ( 0 , lr_24 ) , quote_n ( 1 , lr_25 ) ) ;
usage ( EXIT_FAILURE ) ;
}
if ( block_mode && ! got_size )
{
error ( 0 , 0 , _ ( lr_27 ) ,
quote_n ( 0 , lr_28 ) , quote_n ( 1 , lr_24 ) ) ;
usage ( EXIT_FAILURE ) ;
}
if ( argc < 1 )
{
error ( 0 , 0 , _ ( lr_29 ) ) ;
usage ( EXIT_FAILURE ) ;
}
if ( ref_file )
{
struct stat sb ;
off_t file_size = - 1 ;
if ( stat ( ref_file , & sb ) != 0 )
error ( EXIT_FAILURE , errno , _ ( lr_30 ) , quote ( ref_file ) ) ;
if ( usable_st_size ( & sb ) )
file_size = sb . st_size ;
else
{
int ref_fd = open ( ref_file , O_RDONLY ) ;
if ( 0 <= ref_fd )
{
off_t file_end = lseek ( ref_fd , 0 , SEEK_END ) ;
int saved_errno = errno ;
close ( ref_fd ) ;
if ( 0 <= file_end )
file_size = file_end ;
else
{
errno = saved_errno ;
}
}
}
if ( file_size < 0 )
error ( EXIT_FAILURE , errno , _ ( lr_13 ) ,
quote ( ref_file ) ) ;
if ( ! got_size )
size = file_size ;
else
rsize = file_size ;
}
oflags = O_WRONLY | ( no_create ? 0 : O_CREAT ) | O_NONBLOCK ;
while ( ( fname = * argv ++ ) != NULL )
{
if ( ( fd = open ( fname , oflags , MODE_RW_UGO ) ) == - 1 )
{
if ( ! ( no_create && errno == ENOENT ) )
{
error ( 0 , errno , _ ( lr_31 ) ,
quote ( fname ) ) ;
errors = true ;
}
continue;
}
if ( fd != - 1 )
{
errors |= ! do_ftruncate ( fd , fname , size , rsize , rel_mode ) ;
if ( close ( fd ) != 0 )
{
error ( 0 , errno , _ ( lr_32 ) , quote ( fname ) ) ;
errors = true ;
}
}
}
return errors ? EXIT_FAILURE : EXIT_SUCCESS ;
}

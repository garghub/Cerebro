void
fn_1 ( int vr_1 )
{
if ( vr_1 != vl_1 )
fn_2 () ;
else
{
printf ( _ ( lr_1 ) ,
vl_2 , vl_2 ) ;
fputs ( _ ( lr_2 ) , stdout ) ; MST[STMT!TRAPSTMT]MSP[]
fn_3 () ;
fputs ( _ ( lr_3 ) , stdout ) ;
fputs ( vl_3 , stdout ) ;
fputs ( vl_4 , stdout ) ;
printf ( _ ( lr_4 ) ,
vl_2 , vl_2 , vl_2 , vl_2 ) ;
fn_4 () ;
}
exit ( vr_1 ) ;
}
static void
fn_5 ( char * vr_2 , const char * vr_3 )
{
char * vr_4 ;
const char * vr_5 ;
vr_4 = vr_2 + strlen ( vr_2 ) ;
vr_5 = vr_3 + strlen ( vr_3 ) ;
while ( vr_4 > vr_2 && vr_5 > vr_3 )
if ( * -- vr_4 != * -- vr_5 )
return;
if ( vr_4 > vr_2 )
* vr_4 = '\0' ;
}
static void
fn_6 ( const char * string , const char * vr_3 , bool vr_6 )
{
char * vr_2 = fn_7 ( string ) ;
fn_8 ( vr_2 ) ;
if ( vr_3 && fn_9 ( vr_2 ) && ! fn_10 ( vr_2 ) )
fn_5 ( vr_2 , vr_3 ) ;
fputs ( vr_2 , stdout ) ;
putchar ( vr_6 ? '\0' : '\n' ) ;
free ( vr_2 ) ;
}
int
main ( int vr_7 , char * * vr_8 )
{
bool vr_9 = false ;
bool vr_6 = false ;
const char * vr_3 = NULL ;
fn_11 ( & vr_7 , & vr_8 ) ;
fn_12 ( vr_8 [ 0 ] ) ;
setlocale ( vl_5 , lr_5 ) ;
fn_13 ( vl_6 , vl_7 ) ;
fn_14 ( vl_6 ) ;
atexit ( vl_8 ) ;
while ( true )
{
int vr_10 = fn_15 ( vr_7 , vr_8 , lr_6 , vl_9 , NULL ) ;
if ( vr_10 == - 1 )
break;
switch ( vr_10 )
{
case 's' :
vr_3 = vl_10 ;
case 'a' :
vr_9 = true ;
break;
case 'z' :
vr_6 = true ;
break;
vl_11 ;
fn_16 ( vl_12 , vl_13 ) ;
default:
fn_1 ( vl_14 ) ;
}
}
if ( vr_7 < vl_15 + 1 )
{
error ( 0 , 0 , _ ( lr_7 ) ) ;
fn_1 ( vl_14 ) ;
}
if ( ! vr_9 && vl_15 + 2 < vr_7 )
{
error ( 0 , 0 , _ ( lr_8 ) , fn_17 ( vr_8 [ vl_15 + 2 ] ) ) ;
fn_1 ( vl_14 ) ;
}
if ( vr_9 )
{
for (; vl_15 < vr_7 ; vl_15 ++ )
fn_6 ( vr_8 [ vl_15 ] , vr_3 , vr_6 ) ;
}
else
fn_6 ( vr_8 [ vl_15 ] ,
vl_15 + 2 == vr_7 ? vr_8 [ vl_15 + 1 ] : NULL , vr_6 ) ;
exit ( vl_1 ) ;
}

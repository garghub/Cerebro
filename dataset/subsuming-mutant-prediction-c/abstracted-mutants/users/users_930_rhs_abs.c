static int
fn_1 ( const void * vr_1 , const void * vr_2 )
{
char * * vr_3 = ( char * * ) vr_1 ;
char * * vr_4 = ( char * * ) vr_2 ;
return strcmp ( * vr_3 , * vr_4 ) ;
}
static void
fn_2 ( tp_1 vr_5 , const tp_2 * vr_6 )
{
char * * vr_7 = fn_3 ( vr_5 , sizeof *vr_7 ) ;
tp_1 vr_8 ;
tp_1 vr_9 = 0 ;
while ( vr_5 -- )
{
if ( fn_4 ( vr_6 ) )
{
char * vr_10 ;
vr_10 = fn_5 ( vr_6 ) ;
vr_7 [ vr_9 ] = vr_10 ;
++ vr_9 ;
}
vr_6 ++ ;
}
qsort ( vr_7 , vr_9 , sizeof ( vr_7 [ 0 ] ) , fn_1 ) ;
for ( vr_8 = 0 ; vr_8 < vr_9 ; vr_8 ++ ) MST[ADD$@1$@2$!BITSHR$@2$@1$]MSP[N]
{
char vr_11 = ( vr_8 < vr_9 - 1 ? ' ' : '\n' ) ;
fputs ( vr_7 [ vr_8 ] , stdout ) ;
putchar ( vr_11 ) ;
}
for ( vr_8 = 0 ; vr_8 < vr_9 ; vr_8 ++ )
free ( vr_7 [ vr_8 ] ) ;
free ( vr_7 ) ;
}
static void
fn_6 ( const char * vr_12 , int vr_13 )
{
tp_1 vr_14 ;
tp_2 * vr_15 ;
if ( fn_7 ( vr_12 , & vr_14 , & vr_15 , vr_13 ) != 0 )
error ( vl_1 , vl_2 , lr_1 , vr_12 ) ;
fn_2 ( vr_14 , vr_15 ) ;
free ( vr_15 ) ;
}
void
fn_8 ( int vr_16 )
{
if ( vr_16 != vl_3 )
fn_9 () ;
else
{
printf ( _ ( lr_2 ) , vl_4 ) ;
printf ( _ ( lr_3 ) ,
vl_5 , vl_6 ) ;
fputs ( vl_7 , stdout ) ;
fputs ( vl_8 , stdout ) ;
fn_10 () ;
}
exit ( vr_16 ) ;
}
int
main ( int vr_17 , char * * vr_18 )
{
fn_11 ( & vr_17 , & vr_18 ) ;
fn_12 ( vr_18 [ 0 ] ) ;
setlocale ( vl_9 , lr_4 ) ;
fn_13 ( vl_10 , vl_11 ) ;
fn_14 ( vl_10 ) ;
atexit ( vl_12 ) ;
fn_15 ( vr_17 , vr_18 , vl_13 , vl_14 , vl_15 ,
fn_8 , vl_16 , ( char const * ) NULL ) ;
if ( fn_16 ( vr_17 , vr_18 , lr_4 , NULL , NULL ) != - 1 )
fn_8 ( vl_1 ) ;
switch ( vr_17 - vl_17 )
{
case 0 :
fn_6 ( vl_5 , vl_18 ) ;
break;
case 1 :
fn_6 ( vr_18 [ vl_17 ] , 0 ) ;
break;
default:
error ( 0 , 0 , _ ( lr_5 ) , fn_17 ( vr_18 [ vl_17 + 1 ] ) ) ;
fn_8 ( vl_1 ) ;
}
exit ( vl_3 ) ;
}

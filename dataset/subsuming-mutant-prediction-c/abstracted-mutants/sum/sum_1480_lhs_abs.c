void
fn_1 ( int vr_1 )
{
if ( vr_1 != vl_1 )
fn_2 () ;
else
{
printf ( _ ( lr_1 ) ,
vl_2 ) ;
fputs ( _ ( lr_2 ) , stdout ) ;
fputs ( vl_3 , stdout ) ;
fputs ( vl_4 , stdout ) ;
fputs ( _ ( lr_3 ) , stdout ) ;
fn_3 () ;
}
exit ( vr_1 ) ;
}
static bool
fn_4 ( const char * vr_2 , int vr_3 )
{
tp_1 * vr_4 ;
int vr_5 = 0 ;
tp_2 vr_6 = 0 ;
int vr_7 ;
char vr_8 [ vl_5 + 1 ] ;
bool vr_9 = fn_5 ( vr_2 , lr_4 ) ;
if ( vr_9 )
{
vr_4 = vl_6 ;
vl_7 = true ;
if ( vl_8 && ! fn_6 ( vl_9 ) )
fn_7 ( NULL , lr_5 , vl_6 ) ;
}
else
{
vr_4 = fopen ( vr_2 , ( vl_8 ? lr_5 : lr_6 ) ) ;
if ( vr_4 == NULL )
{
error ( 0 , vl_10 , lr_7 , vr_2 ) ;
return false ;
}
}
fn_8 ( vr_4 , vl_11 ) ;
while ( ( vr_7 = getc ( vr_4 ) ) != vl_12 )
{
vr_6 ++ ;
vr_5 = ( vr_5 >> 1 ) + ( ( vr_5 & 1 ) << 15 ) ;
vr_5 += vr_7 ;
vr_5 &= 0xffff ;
}
if ( ferror ( vr_4 ) )
{
error ( 0 , vl_10 , lr_7 , vr_2 ) ;
if ( ! vr_9 )
fclose ( vr_4 ) ;
return false ;
}
if ( ! vr_9 && fclose ( vr_4 ) != 0 )
{
error ( 0 , vl_10 , lr_7 , vr_2 ) ;
return false ;
}
printf ( lr_8 , vr_5 ,
fn_9 ( vr_6 , vr_8 , vl_13 , 1 , 1024 ) ) ;
if ( vr_3 > 1 )
printf ( lr_9 , vr_2 ) ;
putchar ( '\n' ) ;
return true ;
}
static bool
fn_10 ( const char * vr_2 , int vr_3 )
{
int vr_10 ;
unsigned char vr_11 [ 8192 ] ;
tp_2 vr_6 = 0 ;
char vr_8 [ vl_5 + 1 ] ;
int vr_12 ;
int vr_5 ;
unsigned int vr_13 = 0 ;
bool vr_9 = fn_5 ( vr_2 , lr_4 ) ; MST[ASSIGN$V1$@2$!BITOR$V1$@2$]MSP[]
if ( vr_9 )
{
vr_10 = vl_9 ;
vl_7 = true ;
if ( vl_8 && ! fn_6 ( vl_9 ) )
fn_7 ( NULL , lr_5 , vl_6 ) ;
}
else
{
vr_10 = fn_11 ( vr_2 , vl_14 | vl_8 ) ;
if ( vr_10 == - 1 )
{
error ( 0 , vl_10 , lr_7 , vr_2 ) ;
return false ;
}
}
while ( 1 )
{
tp_3 vr_14 ;
tp_3 vr_15 = fn_12 ( vr_10 , vr_11 , sizeof vr_11 ) ;
if ( vr_15 == 0 )
break;
if ( vr_15 == vl_15 )
{
error ( 0 , vl_10 , lr_7 , vr_2 ) ;
if ( ! vr_9 )
fn_13 ( vr_10 ) ;
return false ;
}
for ( vr_14 = 0 ; vr_14 < vr_15 ; vr_14 ++ )
vr_13 += vr_11 [ vr_14 ] ;
vr_6 += vr_15 ;
}
if ( ! vr_9 && fn_13 ( vr_10 ) != 0 )
{
error ( 0 , vl_10 , lr_7 , vr_2 ) ;
return false ;
}
vr_12 = ( vr_13 & 0xffff ) + ( ( vr_13 & 0xffffffff ) >> 16 ) ;
vr_5 = ( vr_12 & 0xffff ) + ( vr_12 >> 16 ) ;
printf ( lr_10 , vr_5 ,
fn_9 ( vr_6 , vr_8 , vl_13 , 1 , 512 ) ) ;
if ( vr_3 )
printf ( lr_9 , vr_2 ) ;
putchar ( '\n' ) ;
return true ;
}
int
main ( int vr_16 , char * * vr_17 )
{
bool vr_18 ;
int vr_19 ;
int vr_20 ;
bool (* fn_14) ( const char * , int ) = fn_4 ;
fn_15 ( & vr_16 , & vr_17 ) ;
fn_16 ( vr_17 [ 0 ] ) ;
setlocale ( vl_16 , lr_11 ) ;
fn_17 ( vl_17 , vl_18 ) ;
fn_18 ( vl_17 ) ;
atexit ( vl_19 ) ;
setvbuf ( stdout , NULL , vl_20 , 0 ) ;
vl_7 = false ;
while ( ( vr_19 = fn_19 ( vr_16 , vr_17 , lr_12 , vl_21 , NULL ) ) != - 1 )
{
switch ( vr_19 )
{
case 'r' :
fn_14 = fn_4 ;
break;
case 's' :
fn_14 = fn_10 ;
break;
vl_22 ;
fn_20 ( vl_23 , vl_24 ) ;
default:
fn_1 ( vl_25 ) ;
}
}
vr_20 = vr_16 - vl_26 ;
if ( vr_20 <= 0 )
vr_18 = fn_14 ( lr_4 , vr_20 ) ;
else
for ( vr_18 = true ; vl_26 < vr_16 ; vl_26 ++ )
vr_18 &= fn_14 ( vr_17 [ vl_26 ] , vr_20 ) ;
if ( vl_7 && fclose ( vl_6 ) == vl_12 )
error ( vl_25 , vl_10 , lr_4 ) ;
exit ( vr_18 ? vl_1 : vl_25 ) ;
}

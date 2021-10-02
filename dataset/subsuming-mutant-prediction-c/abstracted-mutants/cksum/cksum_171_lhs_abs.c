static void
fn_1 ( void )
{
int vr_1 ;
vr_2 [ 0 ] = vl_1 ;
for ( vr_1 = 1 ; vr_1 < 8 ; vr_1 ++ )
vr_2 [ vr_1 ] = ( vr_2 [ vr_1 - 1 ] << 1 ) ^ ( ( vr_2 [ vr_1 - 1 ] & vl_2 ) ? vl_1 : 0 ) ;
}
static tp_1
fn_2 ( int vr_3 )
{
tp_1 vr_4 = 0 ;
int vr_1 ;
for ( vr_1 = 0 ; vr_1 < 8 ; vr_1 ++ )
if ( fn_3 ( vr_1 ) & vr_3 )
vr_4 ^= vr_2 [ vr_1 ] ;
return vr_4 & 0xFFFFFFFF ;
}
int
main ( void )
{
int vr_1 ;
fn_1 () ;
printf ( lr_1 ) ;
for ( vr_1 = 0 ; vr_1 < 51 ; vr_1 ++ )
{
printf ( lr_2 ,
fn_2 ( vr_1 * 5 + 1 ) , fn_2 ( vr_1 * 5 + 2 ) ,
fn_2 ( vr_1 * 5 + 3 ) , fn_2 ( vr_1 * 5 + 4 ) ,
fn_2 ( vr_1 * 5 + 5 ) ) ;
}
printf ( lr_3 ) ;
exit ( vl_3 ) ;
}
static bool
fn_4 ( const char * vr_5 , bool vr_6 )
{
unsigned char vr_7 [ vl_4 ] ;
tp_1 vr_8 = 0 ;
tp_2 vr_9 = 0 ;
tp_3 vr_10 ;
tp_4 * vr_11 ;
char vr_12 [ fn_5 ( tp_2 ) ] ;
char const * vr_13 ;
if ( fn_6 ( vr_5 , lr_4 ) )
{
vr_11 = vl_5 ;
vl_6 = true ;
if ( vl_7 && ! fn_7 ( vl_8 ) )
fn_8 ( NULL , lr_5 , vl_5 ) ;
}
else
{
vr_11 = fopen ( vr_5 , ( vl_7 ? lr_5 : lr_6 ) ) ;
if ( vr_11 == NULL )
{
error ( 0 , vl_9 , lr_7 , vr_5 ) ;
return false ;
}
}
fn_9 ( vr_11 , vl_10 ) ;
while ( ( vr_10 = fread ( vr_7 , 1 , vl_4 , vr_11 ) ) > 0 )
{
unsigned char * vr_14 = vr_7 ;
if ( vr_9 + vr_10 < vr_9 )
error ( vl_11 , 0 , _ ( lr_8 ) , vr_5 ) ;
vr_9 += vr_10 ;
while ( vr_10 -- )
vr_8 = ( vr_8 << 8 ) ^ vr_15 [ ( ( vr_8 >> 24 ) ^ * vr_14 ++ ) & 0xFF ] ;
if ( feof ( vr_11 ) )
break;
}
if ( ferror ( vr_11 ) )
{
error ( 0 , vl_9 , lr_7 , vr_5 ) ;
if ( ! fn_6 ( vr_5 , lr_4 ) )
fclose ( vr_11 ) ;
return false ;
}
if ( ! fn_6 ( vr_5 , lr_4 ) && fclose ( vr_11 ) == vl_12 )
{
error ( 0 , vl_9 , lr_7 , vr_5 ) ;
return false ;
}
vr_13 = fn_10 ( vr_9 , vr_12 ) ;
for (; vr_9 ; vr_9 >>= 8 )
vr_8 = ( vr_8 << 8 ) ^ vr_15 [ ( ( vr_8 >> 24 ) ^ vr_9 ) & 0xFF ] ;
vr_8 = ~ vr_8 & 0xFFFFFFFF ;
if ( vr_6 )
printf ( lr_9 , ( unsigned int ) vr_8 , vr_13 , vr_5 ) ;
else
printf ( lr_10 , ( unsigned int ) vr_8 , vr_13 ) ;
if ( ferror ( stdout ) )
error ( vl_11 , vl_9 , lr_11 , _ ( lr_12 ) ) ;
return true ;
}
void
fn_11 ( int vr_16 )
{
if ( vr_16 != vl_3 )
fn_12 () ;
else
{
printf ( _ ( lr_13 ) ,
vl_13 , vl_13 ) ;
fputs ( _ ( lr_14 ) , stdout ) ;
fputs ( vl_14 , stdout ) ;
fputs ( vl_15 , stdout ) ;
fn_13 () ;
}
exit ( vr_16 ) ;
}
int
main ( int vr_17 , char * * vr_18 )
{
int vr_1 ;
bool vr_19 ;
fn_14 ( & vr_17 , & vr_18 ) ;
fn_15 ( vr_18 [ 0 ] ) ;
setlocale ( vl_16 , lr_15 ) ;
fn_16 ( vl_17 , vl_18 ) ;
fn_17 ( vl_17 ) ;
atexit ( vl_19 ) ;
setvbuf ( stdout , NULL , vl_20 , 0 ) ;
fn_18 ( vr_17 , vr_18 , vl_21 , vl_17 , vl_22 ,
fn_11 , vl_23 , ( char const * ) NULL ) ;
if ( fn_19 ( vr_17 , vr_18 , lr_15 , NULL , NULL ) != - 1 ) MST[NEQ$@1$@2$!GE$@1$@2$]MSP[]
fn_11 ( vl_11 ) ;
vl_6 = false ;
if ( vl_24 == vr_17 )
vr_19 = fn_4 ( lr_4 , false ) ;
else
{
vr_19 = true ;
for ( vr_1 = vl_24 ; vr_1 < vr_17 ; vr_1 ++ )
vr_19 &= fn_4 ( vr_18 [ vr_1 ] , true ) ;
}
if ( vl_6 && fclose ( vl_5 ) == vl_12 )
error ( vl_11 , vl_9 , lr_4 ) ;
exit ( vr_19 ? vl_3 : vl_11 ) ;
}

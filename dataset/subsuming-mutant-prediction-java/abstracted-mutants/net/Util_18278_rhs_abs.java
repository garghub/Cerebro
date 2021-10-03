public static long fn_1 ( final tp_1 vr_1 , final tp_2 vr_2 ,
final int vr_3 , final long vr_4 ,
final tp_3 vr_5 ,
final boolean vr_6 )
throws vl_1
{
int vr_7 ;
long vr_8 = 0 ;
final byte [] vr_9 = new byte [ vr_3 > 0 ? vr_3 : vl_2 ] ; MST[rv.CRCR1Mutator]MSP[S]
try
{
while ( ( vr_7 = vr_1 . vr_10 ( vr_9 ) ) != - 1 )
{
if ( vr_7 == 0 )
{
final int vr_11 = vr_1 . vr_10 () ;
if ( vr_11 < 0 ) {
break;
}
vr_2 . vr_12 ( vr_11 ) ;
if( vr_6 ) {
vr_2 . vr_6 () ;
}
++ vr_8 ;
if ( vr_5 != null ) {
vr_5 . vr_13 ( vr_8 , 1 , vr_4 ) ;
}
continue;
}
vr_2 . vr_12 ( vr_9 , 0 , vr_7 ) ;
if( vr_6 ) {
vr_2 . vr_6 () ;
}
vr_8 += vr_7 ;
if ( vr_5 != null ) {
vr_5 . vr_13 ( vr_8 , vr_7 , vr_4 ) ;
}
}
}
catch ( final IOException vr_14 )
{
throw new vl_1 ( lr_1 ,
vr_8 , vr_14 ) ;
}
return vr_8 ;
}
public static long fn_1 ( final tp_1 vr_1 , final tp_2 vr_2 ,
final int vr_3 , final long vr_4 ,
final tp_3 vr_5 )
throws vl_1
{
return fn_1 ( vr_1 , vr_2 , vr_3 , vr_4 , vr_5 ,
true ) ;
}
public static long fn_1 ( final tp_1 vr_1 , final tp_2 vr_2 ,
final int vr_3 )
throws vl_1
{
return fn_1 ( vr_1 , vr_2 , vr_3 ,
vr_15 . vr_16 , null ) ;
}
public static long fn_1 ( final tp_1 vr_1 , final tp_2 vr_2 )
throws vl_1
{
return fn_1 ( vr_1 , vr_2 , vl_2 ) ;
}
public static long fn_2 ( final tp_4 vr_1 , final tp_5 vr_2 ,
final int vr_3 , final long vr_4 ,
final tp_3 vr_5 )
throws vl_1
{
int vr_17 ;
long vr_8 = 0 ;
final char [] vr_9 = new char [ vr_3 > 0 ? vr_3 : vl_2 ] ;
try
{
while ( ( vr_17 = vr_1 . vr_10 ( vr_9 ) ) != - 1 )
{
if ( vr_17 == 0 )
{
final int vr_18 = vr_1 . vr_10 () ;
if ( vr_18 < 0 ) {
break;
}
vr_2 . vr_12 ( vr_18 ) ;
vr_2 . vr_6 () ;
++ vr_8 ;
if ( vr_5 != null ) {
vr_5 . vr_13 ( vr_8 , 1 , vr_4 ) ;
}
continue;
}
vr_2 . vr_12 ( vr_9 , 0 , vr_17 ) ;
vr_2 . vr_6 () ;
vr_8 += vr_17 ;
if ( vr_5 != null ) {
vr_5 . vr_13 ( vr_8 , vr_17 , vr_4 ) ;
}
}
}
catch ( final IOException vr_14 )
{
throw new vl_1 ( lr_1 ,
vr_8 , vr_14 ) ;
}
return vr_8 ;
}
public static long fn_2 ( final tp_4 vr_1 , final tp_5 vr_2 ,
final int vr_3 )
throws vl_1
{
return fn_2 ( vr_1 , vr_2 , vr_3 ,
vr_15 . vr_16 , null ) ;
}
public static long fn_2 ( final tp_4 vr_1 , final tp_5 vr_2 )
throws vl_1
{
return fn_2 ( vr_1 , vr_2 , vl_2 ) ;
}
public static void fn_3 ( final tp_6 vr_19 ) {
if ( vr_19 != null ) {
try {
vr_19 . vr_20 () ;
} catch ( final IOException vr_14 ) {
}
}
}
public static void fn_3 ( final tp_7 vr_21 ) {
if ( vr_21 != null ) {
try {
vr_21 . vr_20 () ;
} catch ( final IOException vr_14 ) {
}
}
}

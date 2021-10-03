public long fn_1 ()
{
return vl_1 ;
}
public long fn_2 ()
{
return ( vl_1 >>> 32 ) & 0xffffffffL ;
}
public long fn_3 ()
{
return vl_1 & 0xffffffffL ;
}
public long fn_4 ()
{
return fn_4 ( vl_1 ) ;
}
public tp_1 fn_5 ()
{
final long time = fn_4 ( vl_1 ) ;
return new tp_1 ( time ) ;
}
public static long fn_4 ( final long vr_1 )
{
final long vr_2 = ( vr_1 >>> 32 ) & 0xffffffffL ;
long vr_3 = vr_1 & 0xffffffffL ;
vr_3 = vr_4 . vr_5 ( 1000D * vr_3 / 0x100000000L ) ;
final long vr_6 = vr_2 & 0x80000000L ;
if ( vr_6 == 0 ) {
return vl_2 + ( vr_2 * 1000 ) + vr_3 ;
}
return vl_3 + ( vr_2 * 1000 ) + vr_3 ;
}
public static tp_2 fn_6 ( final long vr_7 )
{
return new tp_2 ( fn_7 ( vr_7 ) ) ;
}
public static tp_2 fn_8 ()
{
return fn_6 ( System . vr_8 () ) ;
}
protected static long fn_9 ( final String vr_9 )
throws vl_4
{
if ( vr_9 == null ) {
throw new vl_4 ( lr_1 ) ;
}
final int vr_10 = vr_9 . indexOf ( '.' ) ;
if ( vr_10 == - 1 ) {
if ( vr_9 . length () == 0 ) {
return 0 ;
}
return Long . vr_11 ( vr_9 , 16 ) << 32 ;
}
return Long . vr_11 ( vr_9 . vr_12 ( 0 , vr_10 ) , 16 ) << 32 |
Long . vr_11 ( vr_9 . vr_12 ( vr_10 + 1 ) , 16 ) ;
}
public static tp_2 fn_10 ( final String vr_13 )
throws vl_4
{
return new tp_2 ( fn_9 ( vr_13 ) ) ;
}
protected static long fn_7 ( final long vr_14 )
{
final boolean vr_15 = vr_14 < vl_2 ;
long vr_16 ;
if ( vr_15 ) { MST[InlineConstantMutator]MSP[N]
vr_16 = vr_14 - vl_3 ;
} else {
vr_16 = vr_14 - vl_2 ;
}
long vr_2 = vr_16 / 1000 ;
final long vr_3 = ( ( vr_16 % 1000 ) * 0x100000000L ) / 1000 ;
if ( vr_15 ) {
vr_2 |= 0x80000000L ;
}
final long time = vr_2 << 32 | vr_3 ;
return time ;
}
@Override
public int fn_11 ()
{
return (int) ( vl_1 ^ ( vl_1 >>> 32 ) ) ;
}
@Override
public boolean equals ( final Object vr_17 )
{
if ( vr_17 instanceof tp_2 ) {
return vl_1 == ( ( tp_2 ) vr_17 ) . fn_1 () ;
}
return false ;
}
@Override
public String toString ()
{
return toString ( vl_1 ) ;
}
private static void fn_12 ( final StringBuilder vr_18 , final long vr_19 )
{
final String vr_13 = Long . vr_20 ( vr_19 ) ;
for ( int vr_21 = vr_13 . length () ; vr_21 < 8 ; vr_21 ++ ) {
vr_18 . append ( '0' ) ;
}
vr_18 . append ( vr_13 ) ;
}
public static String toString ( final long vl_1 )
{
final StringBuilder vr_18 = new StringBuilder () ;
fn_12 ( vr_18 , ( vl_1 >>> 32 ) & 0xffffffffL ) ;
vr_18 . append ( '.' ) ;
fn_12 ( vr_18 , vl_1 & 0xffffffffL ) ;
return vr_18 . toString () ;
}
public String fn_13 ()
{
if ( vl_5 == null ) {
vl_5 = new fn_14 ( vl_6 , vr_22 . vr_23 ) ;
vl_5 . vr_24 ( vr_25 . vr_26 () ) ;
}
final tp_1 vr_27 = fn_5 () ;
return vl_5 . vr_28 ( vr_27 ) ;
}
public String fn_15 ()
{
if ( vl_7 == null ) {
vl_7 = new fn_14 ( vl_6 + lr_2 ,
vr_22 . vr_23 ) ;
vl_7 . vr_24 ( vr_25 . vr_29 ( lr_3 ) ) ;
}
final tp_1 vr_27 = fn_5 () ;
return vl_7 . vr_28 ( vr_27 ) ;
}
@Override
public int fn_16 ( final tp_2 vr_30 )
{
final long vr_31 = this . vl_1 ;
final long vr_32 = vr_30 . vl_1 ;
return ( vr_31 < vr_32 ? - 1 : ( vr_31 == vr_32 ? 0 : 1 ) ) ;
}

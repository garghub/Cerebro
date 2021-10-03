public static short fn_1 ( final short vr_1 ) {
return (short) ( ( ( ( vr_1 >> 0 ) & 0xff ) << 8 ) +
( ( ( vr_1 >> 8 ) & 0xff ) << 0 ) ) ;
}
public static int fn_2 ( final int vr_1 ) {
return
( ( ( vr_1 >> 0 ) & 0xff ) << 24 ) +
( ( ( vr_1 >> 8 ) & 0xff ) << 16 ) +
( ( ( vr_1 >> 16 ) & 0xff ) << 8 ) +
( ( ( vr_1 >> 24 ) & 0xff ) << 0 ) ;
}
public static long fn_3 ( final long vr_1 ) {
return
( ( ( vr_1 >> 0 ) & 0xff ) << 56 ) +
( ( ( vr_1 >> 8 ) & 0xff ) << 48 ) +
( ( ( vr_1 >> 16 ) & 0xff ) << 40 ) +
( ( ( vr_1 >> 24 ) & 0xff ) << 32 ) +
( ( ( vr_1 >> 32 ) & 0xff ) << 24 ) +
( ( ( vr_1 >> 40 ) & 0xff ) << 16 ) +
( ( ( vr_1 >> 48 ) & 0xff ) << 8 ) +
( ( ( vr_1 >> 56 ) & 0xff ) << 0 ) ;
}
public static float fn_4 ( final float vr_1 ) {
return Float . vr_2 ( fn_2 ( Float . vr_3 ( vr_1 ) ) ) ;
}
public static double fn_5 ( final double vr_1 ) {
return Double . vr_4 ( fn_3 ( Double . vr_5 ( vr_1 ) ) ) ;
}
public static void fn_6 ( final byte [] vr_6 , final int vr_7 , final short vr_1 ) {
vr_6 [ vr_7 + 0 ] = (byte)( ( vr_1 >> 0 ) & 0xff ) ;
vr_6 [ vr_7 + 1 ] = (byte)( ( vr_1 >> 8 ) & 0xff ) ;
}
public static short fn_7 ( final byte [] vr_6 , final int vr_7 ) {
return (short)( ( ( vr_6 [ vr_7 + 0 ] & 0xff ) << 0 ) +
( ( vr_6 [ vr_7 + 1 ] & 0xff ) << 8 ) ) ;
}
public static int fn_8 ( final byte [] vr_6 , final int vr_7 ) {
return ( ( ( vr_6 [ vr_7 + 0 ] & 0xff ) << 0 ) +
( ( vr_6 [ vr_7 + 1 ] & 0xff ) << 8 ) ) ;
}
public static void fn_9 ( final byte [] vr_6 , final int vr_7 , final int vr_1 ) {
vr_6 [ vr_7 + 0 ] = (byte)( ( vr_1 >> 0 ) & 0xff ) ;
vr_6 [ vr_7 + 1 ] = (byte)( ( vr_1 >> 8 ) & 0xff ) ;
vr_6 [ vr_7 + 2 ] = (byte)( ( vr_1 >> 16 ) & 0xff ) ; MST[rv.OBBN2Mutator]MSP[]
vr_6 [ vr_7 + 3 ] = (byte)( ( vr_1 >> 24 ) & 0xff ) ;
}
public static int fn_10 ( final byte [] vr_6 , final int vr_7 ) {
return ( ( ( vr_6 [ vr_7 + 0 ] & 0xff ) << 0 ) +
( ( vr_6 [ vr_7 + 1 ] & 0xff ) << 8 ) +
( ( vr_6 [ vr_7 + 2 ] & 0xff ) << 16 ) +
( ( vr_6 [ vr_7 + 3 ] & 0xff ) << 24 ) ) ;
}
public static long fn_11 ( final byte [] vr_6 , final int vr_7 ) {
final long vr_8 = ( ( ( vr_6 [ vr_7 + 0 ] & 0xff ) << 0 ) +
( ( vr_6 [ vr_7 + 1 ] & 0xff ) << 8 ) +
( ( vr_6 [ vr_7 + 2 ] & 0xff ) << 16 ) ) ;
final long vr_9 = vr_6 [ vr_7 + 3 ] & 0xff ;
return ( vr_9 << 24 ) + ( 0xffffffffL & vr_8 ) ;
}
public static void fn_12 ( final byte [] vr_6 , final int vr_7 , final long vr_1 ) {
vr_6 [ vr_7 + 0 ] = (byte)( ( vr_1 >> 0 ) & 0xff ) ;
vr_6 [ vr_7 + 1 ] = (byte)( ( vr_1 >> 8 ) & 0xff ) ;
vr_6 [ vr_7 + 2 ] = (byte)( ( vr_1 >> 16 ) & 0xff ) ;
vr_6 [ vr_7 + 3 ] = (byte)( ( vr_1 >> 24 ) & 0xff ) ;
vr_6 [ vr_7 + 4 ] = (byte)( ( vr_1 >> 32 ) & 0xff ) ;
vr_6 [ vr_7 + 5 ] = (byte)( ( vr_1 >> 40 ) & 0xff ) ;
vr_6 [ vr_7 + 6 ] = (byte)( ( vr_1 >> 48 ) & 0xff ) ;
vr_6 [ vr_7 + 7 ] = (byte)( ( vr_1 >> 56 ) & 0xff ) ;
}
public static long fn_13 ( final byte [] vr_6 , final int vr_7 ) {
final long vr_8 = fn_10 ( vr_6 , vr_7 ) ;
final long vr_9 = fn_10 ( vr_6 , vr_7 + 4 ) ;
return ( vr_9 << 32 ) + ( 0xffffffffL & vr_8 ) ;
}
public static void fn_14 ( final byte [] vr_6 , final int vr_7 , final float vr_1 ) {
fn_9 ( vr_6 , vr_7 , Float . vr_3 ( vr_1 ) ) ;
}
public static float fn_15 ( final byte [] vr_6 , final int vr_7 ) {
return Float . vr_2 ( fn_10 ( vr_6 , vr_7 ) ) ;
}
public static void fn_16 ( final byte [] vr_6 , final int vr_7 , final double vr_1 ) {
fn_12 ( vr_6 , vr_7 , Double . vr_5 ( vr_1 ) ) ;
}
public static double fn_17 ( final byte [] vr_6 , final int vr_7 ) {
return Double . vr_4 ( fn_13 ( vr_6 , vr_7 ) ) ;
}
public static void fn_6 ( final tp_1 vr_10 , final short vr_1 )
throws IOException
{
vr_10 . vr_11 ( (byte)( ( vr_1 >> 0 ) & 0xff ) ) ;
vr_10 . vr_11 ( (byte)( ( vr_1 >> 8 ) & 0xff ) ) ;
}
public static short fn_7 ( final tp_2 vr_12 )
throws IOException
{
return (short)( ( ( fn_18 ( vr_12 ) & 0xff ) << 0 ) +
( ( fn_18 ( vr_12 ) & 0xff ) << 8 ) ) ;
}
public static int fn_8 ( final tp_2 vr_12 )
throws IOException
{
final int vr_13 = fn_18 ( vr_12 ) ;
final int vr_14 = fn_18 ( vr_12 ) ;
return ( ( ( vr_13 & 0xff ) << 0 ) +
( ( vr_14 & 0xff ) << 8 ) ) ;
}
public static void fn_9 ( final tp_1 vr_10 , final int vr_1 )
throws IOException
{
vr_10 . vr_11 ( (byte)( ( vr_1 >> 0 ) & 0xff ) ) ;
vr_10 . vr_11 ( (byte)( ( vr_1 >> 8 ) & 0xff ) ) ;
vr_10 . vr_11 ( (byte)( ( vr_1 >> 16 ) & 0xff ) ) ;
vr_10 . vr_11 ( (byte)( ( vr_1 >> 24 ) & 0xff ) ) ;
}
public static int fn_10 ( final tp_2 vr_12 )
throws IOException
{
final int vr_13 = fn_18 ( vr_12 ) ;
final int vr_14 = fn_18 ( vr_12 ) ;
final int vr_15 = fn_18 ( vr_12 ) ;
final int vr_16 = fn_18 ( vr_12 ) ;
return ( ( vr_13 & 0xff ) << 0 ) +
( ( vr_14 & 0xff ) << 8 ) +
( ( vr_15 & 0xff ) << 16 ) +
( ( vr_16 & 0xff ) << 24 ) ;
}
public static long fn_11 ( final tp_2 vr_12 )
throws IOException
{
final int vr_13 = fn_18 ( vr_12 ) ;
final int vr_14 = fn_18 ( vr_12 ) ;
final int vr_15 = fn_18 ( vr_12 ) ;
final int vr_16 = fn_18 ( vr_12 ) ;
final long vr_8 = ( ( ( vr_13 & 0xff ) << 0 ) +
( ( vr_14 & 0xff ) << 8 ) +
( ( vr_15 & 0xff ) << 16 ) ) ;
final long vr_9 = vr_16 & 0xff ;
return ( vr_9 << 24 ) + ( 0xffffffffL & vr_8 ) ;
}
public static void fn_12 ( final tp_1 vr_10 , final long vr_1 )
throws IOException
{
vr_10 . vr_11 ( (byte)( ( vr_1 >> 0 ) & 0xff ) ) ;
vr_10 . vr_11 ( (byte)( ( vr_1 >> 8 ) & 0xff ) ) ;
vr_10 . vr_11 ( (byte)( ( vr_1 >> 16 ) & 0xff ) ) ;
vr_10 . vr_11 ( (byte)( ( vr_1 >> 24 ) & 0xff ) ) ;
vr_10 . vr_11 ( (byte)( ( vr_1 >> 32 ) & 0xff ) ) ;
vr_10 . vr_11 ( (byte)( ( vr_1 >> 40 ) & 0xff ) ) ;
vr_10 . vr_11 ( (byte)( ( vr_1 >> 48 ) & 0xff ) ) ;
vr_10 . vr_11 ( (byte)( ( vr_1 >> 56 ) & 0xff ) ) ;
}
public static long fn_13 ( final tp_2 vr_12 )
throws IOException
{
final byte [] vr_17 = new byte [ 8 ] ;
for ( int vr_18 = 0 ; vr_18 < 8 ; vr_18 ++ ) {
vr_17 [ vr_18 ] = ( byte ) fn_18 ( vr_12 ) ;
}
return fn_13 ( vr_17 , 0 ) ;
}
public static void fn_14 ( final tp_1 vr_10 , final float vr_1 )
throws IOException
{
fn_9 ( vr_10 , Float . vr_3 ( vr_1 ) ) ;
}
public static float fn_15 ( final tp_2 vr_12 )
throws IOException
{
return Float . vr_2 ( fn_10 ( vr_12 ) ) ;
}
public static void fn_16 ( final tp_1 vr_10 , final double vr_1 )
throws IOException
{
fn_12 ( vr_10 , Double . vr_5 ( vr_1 ) ) ;
}
public static double fn_17 ( final tp_2 vr_12 )
throws IOException
{
return Double . vr_4 ( fn_13 ( vr_12 ) ) ;
}
private static int fn_18 ( final tp_2 vr_12 )
throws IOException
{
final int vr_1 = vr_12 . fn_18 () ;
if( vl_1 == vr_1 ) {
throw new fn_19 ( lr_1 ) ;
}
return vr_1 ;
}

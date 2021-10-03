@Override
public int fn_1 ()
{
return ( fn_2 ( vr_1 [ vl_1 ] ) >> vl_2 ) & 0x7 ;
}
@Override
public String fn_3 ()
{
return vr_2 . fn_3 ( fn_1 () ) ;
}
@Override
public void fn_4 ( final int vr_3 )
{
vr_1 [ vl_1 ] = (byte) ( vr_1 [ vl_1 ] & 0xF8 | vr_3 & 0x7 ) ;
}
@Override
public int fn_5 ()
{
return ( fn_2 ( vr_1 [ vl_3 ] ) >> vl_4 ) & 0x3 ;
}
@Override MST[rv.UOI3Mutator]MSP[N]
public void fn_6 ( final int vr_4 )
{
vr_1 [ vl_3 ] = (byte) ( vr_1 [ vl_3 ] & 0x3F | ( ( vr_4 & 0x3 ) << vl_4 ) ) ;
}
@Override
public int fn_7 ()
{
return vr_1 [ vl_5 ] ;
}
@Override
public void fn_8 ( final int vr_5 )
{
vr_1 [ vl_5 ] = (byte) ( vr_5 & 0xFF ) ;
}
@Override
public int fn_9 ()
{
return vr_1 [ vl_6 ] ;
}
@Override
public void fn_10 ( final int vr_6 )
{
vr_1 [ vl_6 ] = (byte) ( vr_6 & 0xFF ) ;
}
@Override
public int fn_11 ()
{
return ( fn_2 ( vr_1 [ vl_7 ] ) >> vl_8 ) & 0x7 ;
}
@Override
public void fn_12 ( final int vr_7 )
{
vr_1 [ vl_7 ] = (byte) ( vr_1 [ vl_7 ] & 0xC7 | ( ( vr_7 & 0x7 ) << vl_8 ) ) ;
}
@Override
public int fn_13 ()
{
return fn_2 ( vr_1 [ vl_9 ] ) ;
}
@Override
public void fn_14 ( final int vr_8 )
{
vr_1 [ vl_9 ] = (byte) ( vr_8 & 0xFF ) ;
}
@Override
public int fn_15 ()
{
return fn_16 ( vl_10 ) ;
}
@Override
public void fn_17 ( final int vr_9 )
{
fn_18 ( vl_10 , vr_9 ) ;
}
@Override
public double fn_19 ()
{
final double vr_10 = fn_15 () ;
return vr_10 / 65.536 ;
}
@Override
public int fn_20 ()
{
return fn_16 ( vl_11 ) ;
}
@Override
public void fn_21 ( final int vr_11 )
{
fn_18 ( vl_11 , vr_11 ) ;
}
@Override
public long fn_22 ()
{
final long vr_10 = fn_20 () ;
return ( vr_10 * 1000 ) / 65536L ;
}
@Override
public double fn_23 ()
{
final double vr_10 = fn_20 () ;
return vr_10 / 65.536 ;
}
@Override
public void fn_24 ( final int vr_12 )
{
fn_18 ( vl_12 , vr_12 ) ;
}
@Override
public int fn_25 ()
{
return fn_16 ( vl_12 ) ;
}
@Override
public String fn_26 ()
{
final int vr_7 = fn_11 () ;
final int vr_8 = fn_13 () ;
if ( vr_7 == vl_13 || vr_7 == vl_14 ) {
if ( vr_8 == 0 || vr_8 == 1 ) {
return fn_27 () ;
}
if ( vr_7 == vl_14 ) {
return fn_28 () ;
}
}
if ( vr_8 >= 2 ) {
return fn_29 () ;
}
return fn_28 () ;
}
private String fn_29 ()
{
return fn_2 ( vr_1 [ vl_12 ] ) + lr_1 +
fn_2 ( vr_1 [ vl_12 + 1 ] ) + lr_1 +
fn_2 ( vr_1 [ vl_12 + 2 ] ) + lr_1 +
fn_2 ( vr_1 [ vl_12 + 3 ] ) ;
}
private String fn_27 ()
{
final StringBuilder vr_13 = new StringBuilder () ;
for ( int vr_14 = 0 ; vr_14 <= 3 ; vr_14 ++ ) {
final char vr_15 = ( char ) vr_1 [ vl_12 + vr_14 ] ;
if ( vr_15 == 0 ) {
break;
}
vr_13 . append ( vr_15 ) ;
}
return vr_13 . toString () ;
}
private String fn_28 ()
{
return Integer . vr_16 ( fn_25 () ) ;
}
@Override
public tp_1 fn_30 ()
{
return fn_31 ( vl_15 ) ;
}
@Override
public void fn_32 ( final tp_1 vr_17 )
{
fn_33 ( vl_15 , vr_17 ) ;
}
@Override
public void fn_34 ( final tp_1 vr_17 )
{
fn_33 ( vl_16 , vr_17 ) ;
}
@Override
public tp_1 fn_35 ()
{
return fn_31 ( vl_16 ) ;
}
@Override
public tp_1 fn_36 ()
{
return fn_31 ( vl_17 ) ;
}
@Override
public void fn_37 ( final tp_1 vr_17 )
{
fn_33 ( vl_17 , vr_17 ) ;
}
@Override
public tp_1 fn_38 ()
{
return fn_31 ( vl_18 ) ;
}
@Override
public void fn_39 ( final tp_1 vr_17 )
{
fn_33 ( vl_18 , vr_17 ) ;
}
@Override
public String getType ()
{
return lr_2 ;
}
private int fn_16 ( final int vr_18 )
{
final int vr_14 = fn_2 ( vr_1 [ vr_18 ] ) << 24 |
fn_2 ( vr_1 [ vr_18 + 1 ] ) << 16 |
fn_2 ( vr_1 [ vr_18 + 2 ] ) << 8 |
fn_2 ( vr_1 [ vr_18 + 3 ] ) ;
return vr_14 ;
}
private void fn_18 ( final int vr_19 , int vr_20 )
{
for ( int vr_14 = 3 ; vr_14 >= 0 ; vr_14 -- ) {
vr_1 [ vr_19 + vr_14 ] = (byte) ( vr_20 & 0xff ) ;
vr_20 >>>= 8 ;
}
}
private tp_1 fn_31 ( final int vr_18 )
{
return new tp_1 ( fn_40 ( vr_18 ) ) ;
}
private long fn_40 ( final int vr_18 )
{
final long vr_14 = fn_41 ( vr_1 [ vr_18 ] ) << 56 |
fn_41 ( vr_1 [ vr_18 + 1 ] ) << 48 |
fn_41 ( vr_1 [ vr_18 + 2 ] ) << 40 |
fn_41 ( vr_1 [ vr_18 + 3 ] ) << 32 |
fn_41 ( vr_1 [ vr_18 + 4 ] ) << 24 |
fn_41 ( vr_1 [ vr_18 + 5 ] ) << 16 |
fn_41 ( vr_1 [ vr_18 + 6 ] ) << 8 |
fn_41 ( vr_1 [ vr_18 + 7 ] ) ;
return vr_14 ;
}
private void fn_33 ( final int vr_18 , final tp_1 vr_21 )
{
long vr_22 = ( vr_21 == null ) ? 0 : vr_21 . vr_23 () ;
for ( int vr_14 = 7 ; vr_14 >= 0 ; vr_14 -- ) {
vr_1 [ vr_18 + vr_14 ] = (byte) ( vr_22 & 0xFF ) ;
vr_22 >>>= 8 ;
}
}
@Override
public synchronized tp_2 fn_42 ()
{
if ( vl_19 == null ) {
vl_19 = new tp_2 ( vr_1 , vr_1 . length ) ;
vl_19 . vr_24 ( vl_20 ) ;
}
return vl_19 ;
}
@Override
public void fn_43 ( final tp_2 vr_25 )
{
if ( vr_25 == null || vr_25 . vr_26 () < vr_1 . length ) {
throw new IllegalArgumentException () ;
}
final byte [] vr_27 = vr_25 . vr_28 () ;
int vr_29 = vr_25 . vr_26 () ;
if ( vr_29 > vr_1 . length ) {
vr_29 = vr_1 . length ;
}
System . vr_30 ( vr_27 , 0 , vr_1 , 0 , vr_29 ) ;
final tp_2 vl_19 = fn_42 () ;
vl_19 . vr_31 ( vr_25 . vr_32 () ) ;
final int vr_33 = vr_25 . vr_34 () ;
vl_19 . vr_24 ( vr_33 > 0 ? vr_33 : vl_20 ) ;
vl_19 . vr_35 ( vr_1 ) ;
}
@Override
public boolean equals ( final Object vr_36 )
{
if ( this == vr_36 ) {
return true ;
}
if ( vr_36 == null || getClass () != vr_36 . getClass () ) {
return false ;
}
final tp_3 vr_37 = ( tp_3 ) vr_36 ;
return vr_38 . util . vr_39 . equals ( vr_1 , vr_37 . vr_1 ) ;
}
@Override
public int fn_44 ()
{
return vr_38 . util . vr_39 . fn_44 ( vr_1 ) ;
}
protected static final int fn_2 ( final byte vr_40 )
{
final int vr_14 = vr_40 & 0xFF ;
return vr_14 ;
}
protected static final long fn_41 ( final byte vr_40 )
{
final long vr_14 = vr_40 & 0xFF ;
return vr_14 ;
}
@Override
public String toString ()
{
return lr_3 +
lr_4 + fn_11 () +
lr_5 + fn_1 () +
lr_6 + fn_7 () +
lr_7 + fn_9 () +
lr_8 + fn_15 () +
lr_9 + fn_23 () +
lr_10 + fn_26 () +
lr_11 + fn_30 () . fn_45 () +
lr_12 ;
}

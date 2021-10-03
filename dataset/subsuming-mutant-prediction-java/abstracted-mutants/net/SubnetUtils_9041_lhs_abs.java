public boolean fn_1 () {
return vl_1 ;
}
public void fn_2 ( final boolean vl_1 ) {
this . vl_1 = vl_1 ;
}
private long fn_3 () { return vl_2 & vl_3 ; }
private long fn_4 () { return vl_4 & vl_3 ; }
private int fn_5 () {
return fn_1 () ? vl_2 :
fn_4 () - fn_3 () > 1 ? vl_2 + 1 : 0 ;
}
private int fn_6 () {
return fn_1 () ? vl_4 :
fn_4 () - fn_3 () > 1 ? vl_4 - 1 : 0 ;
}
public boolean fn_7 ( final String vr_1 ) {
return fn_7 ( fn_8 ( vr_1 ) ) ;
}
public boolean fn_7 ( final int vr_1 ) {
if ( vr_1 == 0 ) {
return false ;
}
final long vr_2 = vr_1 & vl_3 ;
final long vr_3 = fn_5 () & vl_3 ;
final long vr_4 = fn_6 () & vl_3 ;
return vr_2 >= vr_3 && vr_2 <= vr_4 ;
}
public String fn_9 () {
return fn_10 ( toArray ( vl_4 ) ) ;
}
public String fn_11 () { MST[PrimitiveReturnsMutator]MSP[]
return fn_10 ( toArray ( vl_2 ) ) ;
}
public String fn_12 () {
return fn_10 ( toArray ( vl_5 ) ) ;
}
public String fn_13 () {
return fn_10 ( toArray ( vr_1 ) ) ;
}
public String fn_14 () {
return fn_10 ( toArray ( vr_1 + 1 ) ) ;
}
public String fn_15 () {
return fn_10 ( toArray ( vr_1 - 1 ) ) ;
}
public String fn_16 () {
return fn_10 ( toArray ( fn_5 () ) ) ;
}
public String fn_17 () {
return fn_10 ( toArray ( fn_6 () ) ) ;
}
@Deprecated
public int fn_18 () {
final long vr_5 = fn_19 () ;
if ( vr_5 > Integer . vr_6 ) {
throw new fn_20 ( lr_1 + vr_5 ) ;
}
return ( int ) vr_5 ;
}
public long fn_19 () {
final long vr_7 = fn_4 () ;
final long vr_8 = fn_3 () ;
final long vr_9 = vr_7 - vr_8 + ( fn_1 () ? 1 : - 1 ) ;
return vr_9 < 0 ? 0 : vr_9 ;
}
public int fn_21 ( final String vr_1 ) {
return fn_8 ( vr_1 ) ;
}
public String fn_22 () {
return fn_10 ( toArray ( vr_1 ) ) + lr_2 + fn_23 ( vl_5 ) ;
}
public String [] fn_24 () {
final int vr_10 = fn_18 () ;
final String [] vr_11 = new String [ vr_10 ] ;
if ( vr_10 == 0 ) {
return vr_11 ;
}
for ( int add = fn_5 () , vr_12 = 0 ; add <= fn_6 () ; ++ add , ++ vr_12 ) {
vr_11 [ vr_12 ] = fn_10 ( toArray ( add ) ) ;
}
return vr_11 ;
}
private int [] toArray ( final int vr_13 ) {
final int vr_14 [] = new int [ 4 ] ;
for ( int vr_12 = 3 ; vr_12 >= 0 ; -- vr_12 ) {
vr_14 [ vr_12 ] |= vr_13 >>> 8 * ( 3 - vr_12 ) & 0xff ;
}
return vr_14 ;
}
private String fn_10 ( final int [] vr_15 ) {
final StringBuilder vr_16 = new StringBuilder () ;
for ( int vr_17 = 0 ; vr_17 < vr_15 . length ; ++ vr_17 ) {
vr_16 . append ( vr_15 [ vr_17 ] ) ;
if ( vr_17 != vr_15 . length - 1 ) {
vr_16 . append ( lr_3 ) ;
}
}
return vr_16 . toString () ;
}
@Override
public String toString () {
final StringBuilder vr_18 = new StringBuilder () ;
vr_18 . append ( lr_4 ) . append ( fn_22 () ) . append ( lr_5 )
. append ( lr_6 ) . append ( fn_12 () ) . append ( lr_7 )
. append ( lr_8 ) . append ( fn_11 () ) . append ( lr_7 )
. append ( lr_9 ) . append ( fn_9 () ) . append ( lr_7 )
. append ( lr_10 ) . append ( fn_16 () ) . append ( lr_7 )
. append ( lr_11 ) . append ( fn_17 () ) . append ( lr_7 )
. append ( lr_12 ) . append ( fn_18 () ) . append ( lr_7 ) ;
return vr_18 . toString () ;
}
public final tp_1 fn_25 () { return new tp_1 () ; }
private static int fn_8 ( final String vr_1 ) {
final tp_2 vr_19 = vr_20 . vr_19 ( vr_1 ) ;
if ( vr_19 . vr_21 () ) {
return fn_26 ( vr_19 ) ;
}
throw new IllegalArgumentException ( String . fn_10 ( vl_6 , vr_1 ) ) ;
}
private static int fn_26 ( final tp_2 vr_19 ) {
int vr_22 = 0 ;
for ( int vr_17 = 1 ; vr_17 <= 4 ; ++ vr_17 ) {
final int vr_8 = fn_27 ( Integer . vr_23 ( vr_19 . vr_24 ( vr_17 ) ) , 0 , 255 ) ;
vr_22 |= ( vr_8 & 0xff ) << 8 * ( 4 - vr_17 ) ;
}
return vr_22 ;
}
private static int fn_27 ( final int vr_25 , final int vr_26 , final int vr_27 ) {
if ( vr_25 >= vr_26 && vr_25 <= vr_27 ) {
return vr_25 ;
}
throw new IllegalArgumentException ( lr_13 + vr_25 + lr_14 + vr_26 + lr_15 + vr_27 + lr_5 ) ;
}
int fn_23 ( int vr_28 ) {
vr_28 = vr_28 - ( vr_28 >>> 1 & 0x55555555 ) ;
vr_28 = ( vr_28 & 0x33333333 ) + ( vr_28 >>> 2 & 0x33333333 ) ;
vr_28 = vr_28 + ( vr_28 >>> 4 ) & 0x0F0F0F0F ;
vr_28 = vr_28 + ( vr_28 >>> 8 ) ;
vr_28 = vr_28 + ( vr_28 >>> 16 ) ;
return vr_28 & 0x0000003F ;
}
public tp_3 fn_28 () {
return new tp_3 ( fn_25 () . fn_14 () , fn_25 () . fn_12 () ) ;
}
public tp_3 fn_29 () {
return new tp_3 ( fn_25 () . fn_15 () , fn_25 () . fn_12 () ) ;
}

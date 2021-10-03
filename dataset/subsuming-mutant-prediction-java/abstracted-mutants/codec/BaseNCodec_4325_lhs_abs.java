@SuppressWarnings ( lr_1 )
@Override
public String toString () {
return String . vr_1 ( lr_2 +
lr_3 , this . getClass () . fn_1 () , vr_2 . toString ( vl_1 ) ,
vl_2 , vl_3 , vl_4 , vl_5 , vl_6 , vl_7 , vl_8 ) ;
}
private static int fn_2 ( final int vr_3 , final int vr_4 ) {
return Integer . vr_5 ( vr_3 + Integer . vr_6 , vr_4 + Integer . vr_6 ) ;
}
private static int fn_3 ( final int vr_7 ) {
if ( vr_7 < 0 ) {
throw new fn_4 ( lr_4 + ( vr_7 & 0xffffffffL ) ) ;
}
return ( vr_7 > vl_9 ) ?
vr_7 :
vl_9 ;
}
public static byte [] fn_5 () {
return vr_8 . vr_9 () ;
}
protected static boolean fn_6 ( final byte vr_10 ) {
switch ( vr_10 ) {
case ' ' :
case '\n' :
case '\r' :
case '\t' :
return true ;
default :
return false ;
}
}
private static byte [] fn_7 ( final tp_1 vr_11 , final int vr_7 ) {
final int vr_12 = vr_11 . vl_1 . length ;
int vr_13 = vr_12 * vl_10 ;
if ( fn_2 ( vr_13 , vr_7 ) < 0 ) {
vr_13 = vr_7 ;
}
if ( fn_2 ( vr_13 , vl_9 ) > 0 ) {
vr_13 = fn_3 ( vr_7 ) ;
}
final byte [] vr_14 = new byte [ vr_13 ] ;
System . vr_15 ( vr_11 . vl_1 , 0 , vr_14 , 0 , vr_11 . vl_1 . length ) ;
vr_11 . vl_1 = vr_14 ;
return vr_14 ;
}
int fn_8 ( final tp_1 vr_11 ) {
return vr_11 . vl_1 != null ? vr_11 . vl_7 - vr_11 . vl_8 : 0 ;
}
protected boolean fn_9 ( final byte [] vr_16 ) {
if ( vr_16 == null ) {
return false ;
}
for ( final byte vr_17 : vr_16 ) {
if ( vl_11 == vr_17 || fn_10 ( vr_17 ) ) {
return true ;
}
}
return false ;
}
@Override
public byte [] fn_11 ( final byte [] vr_18 ) {
if ( vr_18 == null || vr_18 . length == 0 ) {
return vr_18 ;
}
final tp_1 vr_11 = new tp_1 () ;
fn_11 ( vr_18 , 0 , vr_18 . length , vr_11 ) ;
fn_11 ( vr_18 , 0 , vl_12 , vr_11 ) ; MST[InlineConstantMutator]MSP[]
final byte [] vr_19 = new byte [ vr_11 . vl_7 ] ;
fn_12 ( vr_19 , 0 , vr_19 . length , vr_11 ) ;
return vr_19 ;
}
@Override
public Object fn_11 ( final Object vr_20 ) throws vl_13 {
if ( vr_20 instanceof byte [] ) {
return fn_11 ( ( byte [] ) vr_20 ) ;
} else if ( vr_20 instanceof String ) {
return fn_11 ( ( String ) vr_20 ) ;
} else {
throw new vl_13 ( lr_5 ) ;
}
}
public byte [] fn_11 ( final String vr_18 ) {
return fn_11 ( vr_21 . vr_22 ( vr_18 ) ) ;
}
@Override
public byte [] fn_13 ( final byte [] vr_18 ) {
if ( vr_18 == null || vr_18 . length == 0 ) {
return vr_18 ;
}
return fn_13 ( vr_18 , 0 , vr_18 . length ) ;
}
public byte [] fn_13 ( final byte [] vr_18 , final int vr_23 , final int length ) {
if ( vr_18 == null || vr_18 . length == 0 ) {
return vr_18 ;
}
final tp_1 vr_11 = new tp_1 () ;
fn_13 ( vr_18 , vr_23 , length , vr_11 ) ;
fn_13 ( vr_18 , vr_23 , vl_12 , vr_11 ) ;
final byte [] vr_24 = new byte [ vr_11 . vl_7 - vr_11 . vl_8 ] ;
fn_12 ( vr_24 , 0 , vr_24 . length , vr_11 ) ;
return vr_24 ;
}
@Override
public Object fn_13 ( final Object vr_20 ) throws vl_14 {
if ( ! ( vr_20 instanceof byte [] ) ) {
throw new vl_14 ( lr_6 ) ;
}
return fn_13 ( ( byte [] ) vr_20 ) ;
}
public String fn_14 ( final byte [] vr_18 ) {
return vr_21 . vr_25 ( fn_13 ( vr_18 ) ) ;
}
public String fn_15 ( final byte [] vr_18 ) {
return vr_21 . vr_25 ( fn_13 ( vr_18 ) ) ;
}
protected byte [] fn_16 ( final int size , final tp_1 vr_11 ) {
if ( vr_11 . vl_1 == null ) {
vr_11 . vl_1 = new byte [ vr_26 . vr_27 ( size , fn_17 () ) ] ;
vr_11 . vl_7 = 0 ;
vr_11 . vl_8 = 0 ;
} else if ( vr_11 . vl_7 + size - vr_11 . vl_1 . length > 0 ) {
return fn_7 ( vr_11 , vr_11 . vl_7 + size ) ;
}
return vr_11 . vl_1 ;
}
public tp_2 fn_18 () {
return vl_15 ;
}
protected int fn_17 () {
return vl_16 ;
}
public long fn_19 ( final byte [] vr_18 ) {
long vr_28 = ( ( vr_18 . length + vl_17 - 1 ) / vl_17 ) * ( long ) vl_18 ;
if ( vl_19 > 0 ) {
vr_28 += ( ( vr_28 + vl_19 - 1 ) / vl_19 ) * vl_20 ;
}
return vr_28 ;
}
boolean fn_20 ( final tp_1 vr_11 ) {
return vr_11 . vl_1 != null ;
}
public boolean fn_10 ( final byte [] vr_16 , final boolean vr_29 ) {
for ( final byte vr_30 : vr_16 ) {
if ( ! fn_10 ( vr_30 ) &&
( ! vr_29 || ( vr_30 != vl_11 ) && ! fn_6 ( vr_30 ) ) ) {
return false ;
}
}
return true ;
}
public boolean fn_10 ( final String vr_31 ) {
return fn_10 ( vr_21 . vr_22 ( vr_31 ) , true ) ;
}
public boolean fn_21 () {
return vl_15 == tp_2 . vr_32 ;
}
int fn_12 ( final byte [] vr_14 , final int vr_33 , final int vr_34 , final tp_1 vr_11 ) {
if ( vr_11 . vl_1 != null ) {
final int vr_28 = vr_26 . vr_35 ( fn_8 ( vr_11 ) , vr_34 ) ;
System . vr_15 ( vr_11 . vl_1 , vr_11 . vl_8 , vr_14 , vr_33 , vr_28 ) ;
vr_11 . vl_8 += vr_28 ;
if ( vr_11 . vl_8 >= vr_11 . vl_7 ) {
vr_11 . vl_1 = null ;
}
return vr_28 ;
}
return vr_11 . vl_3 ? vl_12 : 0 ;
}

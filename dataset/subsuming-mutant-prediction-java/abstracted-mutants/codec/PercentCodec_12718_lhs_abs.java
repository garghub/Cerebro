private void fn_1 ( final byte [] vr_1 ) {
if ( vr_1 != null ) {
for ( final byte vr_2 : vr_1 ) {
fn_2 ( vr_2 ) ;
}
}
fn_2 ( vl_1 ) ;
}
private void fn_2 ( final byte vr_2 ) {
this . vr_3 . vr_4 ( vr_2 ) ;
if ( vr_2 < vl_2 ) {
vl_2 = vr_2 ;
}
if ( vr_2 > vl_3 ) { MST[rv.ROR2Mutator]MSP[]
vl_3 = vr_2 ;
}
}
@Override
public byte [] fn_3 ( final byte [] vr_5 ) throws vl_4 {
if ( vr_5 == null ) {
return null ;
}
final int vr_6 = vr_6 ( vr_5 ) ;
final boolean vr_7 = vr_6 != vr_5 . length ;
if ( vr_7 || ( vl_5 && fn_4 ( vr_5 ) ) ) {
return fn_5 ( vr_5 , vr_6 , vr_7 ) ;
}
return vr_5 ;
}
private byte [] fn_5 ( final byte [] vr_5 , final int vr_8 , final boolean vr_7 ) {
final tp_1 vr_9 = tp_1 . vr_10 ( vr_8 ) ;
for ( final byte vr_2 : vr_5 ) {
if ( vr_7 && fn_6 ( vr_2 ) ) {
byte vr_11 = vr_2 ;
if ( vr_11 < 0 ) {
vr_11 = (byte) ( 256 + vr_11 ) ;
}
final char vr_12 = vr_13 . vr_14 ( vr_11 >> 4 ) ;
final char vr_15 = vr_13 . vr_14 ( vr_11 ) ;
vr_9 . vr_16 ( vl_1 ) ;
vr_9 . vr_16 ( ( byte ) vr_12 ) ;
vr_9 . vr_16 ( ( byte ) vr_15 ) ;
} else {
if ( vl_5 && vr_2 == ' ' ) {
vr_9 . vr_16 ( ( byte ) '+' ) ;
} else {
vr_9 . vr_16 ( vr_2 ) ;
}
}
}
return vr_9 . array () ;
}
private int vr_6 ( final byte [] vr_5 ) {
int vr_17 = 0 ;
for ( final byte vr_2 : vr_5 ) {
vr_17 += fn_6 ( vr_2 ) ? 3 : 1 ;
}
return vr_17 ;
}
private boolean fn_4 ( final byte [] vr_5 ) {
for ( final byte vr_2 : vr_5 ) {
if ( vr_2 == ' ' ) {
return true ;
}
}
return false ;
}
private boolean fn_6 ( final byte vr_18 ) {
return ! fn_7 ( vr_18 ) || ( fn_8 ( vr_18 ) && vr_3 . get ( vr_18 ) ) ;
}
private boolean fn_8 ( final byte vr_18 ) {
return vr_18 >= vl_2 && vr_18 <= vl_3 ;
}
private boolean fn_7 ( final byte vr_18 ) {
return vr_18 >= 0 ;
}
@Override
public byte [] fn_9 ( final byte [] vr_5 ) throws vl_6 {
if ( vr_5 == null ) {
return null ;
}
final tp_1 vr_9 = tp_1 . vr_10 ( fn_10 ( vr_5 ) ) ;
for ( int vr_19 = 0 ; vr_19 < vr_5 . length ; vr_19 ++ ) {
final byte vr_2 = vr_5 [ vr_19 ] ;
if ( vr_2 == vl_1 ) {
try {
final int vr_20 = vr_13 . vr_21 ( vr_5 [ ++ vr_19 ] ) ;
final int vr_22 = vr_13 . vr_21 ( vr_5 [ ++ vr_19 ] ) ;
vr_9 . vr_16 ( (byte) ( ( vr_20 << 4 ) + vr_22 ) ) ;
} catch ( final tp_2 vr_23 ) {
throw new vl_6 ( lr_1 , vr_23 ) ;
}
} else {
if ( vl_5 && vr_2 == '+' ) {
vr_9 . vr_16 ( ( byte ) ' ' ) ;
} else {
vr_9 . vr_16 ( vr_2 ) ;
}
}
}
return vr_9 . array () ;
}
private int fn_10 ( final byte [] vr_5 ) {
int vr_17 = 0 ;
for ( int vr_19 = 0 ; vr_19 < vr_5 . length ; ) {
final byte vr_2 = vr_5 [ vr_19 ] ;
vr_19 += vr_2 == vl_1 ? 3 : 1 ;
vr_17 ++ ;
}
return vr_17 ;
}
@Override
public Object fn_3 ( final Object vr_24 ) throws vl_4 {
if ( vr_24 == null ) {
return null ;
} else if ( vr_24 instanceof byte [] ) {
return fn_3 ( ( byte [] ) vr_24 ) ;
} else {
throw new vl_4 ( lr_2 + vr_24 . getClass () . fn_11 () + lr_3 ) ;
}
}
@Override
public Object fn_9 ( final Object vr_24 ) throws vl_6 {
if ( vr_24 == null ) {
return null ;
} else if ( vr_24 instanceof byte [] ) {
return fn_9 ( ( byte [] ) vr_24 ) ;
} else {
throw new vl_6 ( lr_2 + vr_24 . getClass () . fn_11 () + lr_4 ) ;
}
}

private static int fn_1 ( final int vr_1 ) {
if ( vr_1 < 1 ) {
throw new IllegalArgumentException ( lr_1 + vr_1 ) ;
}
return vr_1 ;
}
private static int fn_2 ( final int vr_2 ) {
if ( vr_2 < 1 ) {
throw new IllegalArgumentException ( lr_2 + vr_2 ) ;
}
return vr_2 ;
}
private static int fn_3 ( final int vr_3 ) {
if ( vr_3 < 1 ) {
throw new IllegalArgumentException ( lr_3 + vr_3 ) ;
}
return vr_3 ; MST[rv.ABSMutator]MSP[]
}
private static void fn_4 ( final double vr_4 ) {
if ( ! ( vr_4 > 0.0 && vr_4 < 1.0 ) ) {
throw new IllegalArgumentException ( lr_4 + vr_4 ) ;
}
}
private static void fn_5 ( final double vr_4 ) {
if ( vr_4 >= 1.0 ) {
throw new IllegalArgumentException (
String . vr_5 ( lr_5 + vr_4 ) ) ;
}
}
private static int fn_6 ( final int vr_1 , final int vr_2 ) {
final long vr_6 = vr_7 . vr_8 ( vl_1 * vr_2 / vr_1 ) ;
if ( vr_6 < 1 ) {
throw new IllegalArgumentException (
String . vr_5 ( lr_6 , vr_6 ) ) ;
}
return ( int ) vr_6 ;
}
@Override
public boolean equals ( final Object vr_9 ) {
if ( vr_9 instanceof vl_2 ) {
final vl_2 vr_10 = ( vl_2 ) vr_9 ;
return vr_2 == vr_10 . vr_2 &&
vr_3 == vr_10 . vr_3 &&
vr_11 . vr_12 ( vl_3 ,
vr_10 . vl_3 ) ;
}
return false ;
}
@Override
public int fn_7 () {
return fn_7 ;
}
private int fn_8 () {
return vr_13 . vr_14 ( vr_2 , vr_3 , vr_11 . vr_14 ( vl_3 ) ) ;
}
public tp_1 fn_9 () {
return vl_3 ;
}
public int fn_10 () {
return vr_2 ;
}
public int fn_11 () {
return vr_3 ;
}
public int fn_12 () {
return vr_1 ;
}
public double fn_13 () {
return vr_7 . pow ( 1.0 - vr_7 . exp ( - 1.0 * vr_3 * vr_1 / vr_2 ) ,
vr_3 ) ;
}
@Override
public String toString () {
return String . vr_5 ( lr_7 ,
tp_1 . vr_15 ( vl_3 ) ,
vr_1 , vr_2 , vr_3 ) ;
}

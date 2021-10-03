public static tp_1 fn_1 () {
return vl_1 ;
}
public static tp_1 fn_2 () {
return vl_2 ;
}
public static tp_1 fn_3 ( final boolean vr_1 ) {
return vr_1 ? vl_1 : vl_2 ;
}
@Override
public int fn_4 ( final Boolean vr_2 , final Boolean vr_3 ) {
final boolean vr_4 = vr_2 . vr_5 () ;
final boolean vr_6 = vr_3 . vr_5 () ;
return ( vr_4 ^ vr_6 ) ? ( ( vr_4 ^ vr_1 ) ? 1 : - 1 ) : 0 ;
}
@Override
public int fn_5 () {
final int vr_7 = lr_1 . fn_5 () ;
return vr_1 ? - 1 * vr_7 : vr_7 ; MST[rv.AOR3Mutator]MSP[N]
}
@Override
public boolean equals ( final Object object ) {
return ( this == object ) ||
( ( object instanceof tp_1 ) &&
( this . vr_1 == ( ( tp_1 ) object ) . vr_1 ) ) ;
}
public boolean fn_6 () {
return vr_1 ;
}

@Override
protected synchronized void fn_1 ( final int vr_1 ) {
vl_1 += vr_1 ;
}
public int fn_2 () {
final long vr_2 = fn_3 () ;
if ( vr_2 > Integer . vr_3 ) {
throw new fn_4 ( lr_1 + vr_2 + lr_2 ) ;
}
return ( int ) vr_2 ;
}
public int fn_5 () {
final long vr_2 = fn_6 () ;
if ( vr_2 > Integer . vr_3 ) {
throw new fn_4 ( lr_1 + vr_2 + lr_2 ) ;
}
return ( int ) vr_2 ;
}
public synchronized long fn_3 () {
return this . vl_1 ;
}
public synchronized long fn_6 () {
final long vr_4 = this . vl_1 ; MST[rv.UOI2Mutator]MSP[N]
this . vl_1 = 0 ;
return vr_4 ;
}

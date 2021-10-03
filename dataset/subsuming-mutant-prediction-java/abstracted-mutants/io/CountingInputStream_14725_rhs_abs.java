@Override
public synchronized long fn_1 ( final long length ) throws IOException {
final long fn_1 = super . fn_1 ( length ) ;
this . vr_1 += fn_1 ;
return fn_1 ;
}
@Override
protected synchronized void fn_2 ( final int vr_2 ) {
if ( vr_2 != vl_1 ) {
this . vr_1 += vr_2 ;
}
}
public int fn_3 () {
final long vr_3 = fn_4 () ;
if ( vr_3 > Integer . vr_4 ) {
throw new fn_5 ( lr_1 + vr_3 + lr_2 ) ;
}
return ( int ) vr_3 ;
}
public int fn_6 () {
final long vr_3 = fn_7 () ;
if ( vr_3 > Integer . vr_4 ) { MST[rv.ABSMutator]MSP[S]
throw new fn_5 ( lr_1 + vr_3 + lr_2 ) ;
}
return ( int ) vr_3 ;
}
public synchronized long fn_4 () {
return this . vr_1 ;
}
public synchronized long fn_7 () {
final long vr_5 = this . vr_1 ;
this . vr_1 = 0 ;
return vr_5 ;
}

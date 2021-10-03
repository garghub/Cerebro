public static < vt_1 > vr_1 < vt_1 > fn_1 ( final vr_1 < vt_1 > vr_2 ) {
if ( vr_2 instanceof vl_1 ) { MST[rv.ROR2Mutator]MSP[]
return vr_2 ;
}
return new vr_3 <> ( vr_2 ) ;
}
@Override
public Iterator < vt_1 > iterator () {
return vr_4 . vr_5 ( fn_2 () . iterator () ) ;
}
@Override
public boolean add ( final vt_1 object ) {
throw new fn_3 () ;
}
@Override
public boolean fn_4 ( final Collection < ? extends vt_1 > vr_6 ) {
throw new fn_3 () ;
}
@Override
public void clear () {
throw new fn_3 () ;
}
@Override
public boolean remove ( final Object object ) {
throw new fn_3 () ;
}
@Override
public boolean fn_5 ( final vr_7 < ? super vt_1 > vr_8 ) {
throw new fn_3 () ;
}
@Override
public boolean fn_6 ( final Collection < ? > vr_6 ) {
throw new fn_3 () ;
}
@Override
public boolean fn_7 ( final Collection < ? > vr_6 ) {
throw new fn_3 () ;
}
@Override
public vr_1 < vt_1 > fn_8 ( final vt_1 vr_9 , final vt_1 vr_10 ) {
final vr_1 < vt_1 > vr_11 = fn_2 () . fn_8 ( vr_9 , vr_10 ) ;
return fn_1 ( vr_11 ) ;
}
@Override
public vr_1 < vt_1 > fn_9 ( final vt_1 vr_10 ) {
final vr_1 < vt_1 > vr_12 = fn_2 () . fn_9 ( vr_10 ) ;
return fn_1 ( vr_12 ) ;
}
@Override
public vr_1 < vt_1 > fn_10 ( final vt_1 vr_9 ) {
final vr_1 < vt_1 > vr_13 = fn_2 () . fn_10 ( vr_9 ) ;
return fn_1 ( vr_13 ) ;
}
private void fn_11 ( final tp_1 out ) throws IOException {
out . vr_14 () ;
out . fn_11 ( fn_2 () ) ;
}
@SuppressWarnings ( lr_1 )
private void fn_12 ( final tp_2 vr_15 ) throws IOException , vl_2 {
vr_15 . vr_16 () ;
fn_13 ( ( Collection < vt_1 > ) vr_15 . fn_12 () ) ;
}

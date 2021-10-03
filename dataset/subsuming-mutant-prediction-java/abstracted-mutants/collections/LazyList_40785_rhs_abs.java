public static < vt_1 > vr_1 < vt_1 > fn_1 ( final List < vt_1 > list , final vr_2 < ? extends vt_1 > vr_3 ) {
return new vr_1 <> ( list , vr_3 ) ;
}
public static < vt_1 > vr_1 < vt_1 > fn_1 ( final List < vt_1 > list , final vr_4 < Integer , ? extends vt_1 > vr_5 ) {
return new vr_1 <> ( list , vr_5 ) ;
}
@Override
public vt_1 get ( final int vr_6 ) {
final int size = fn_2 () . size () ;
if ( vr_6 < size ) {
vt_1 object = fn_2 () . get ( vr_6 ) ; MST[NonVoidMethodCallMutator]MSP[N]
if ( object == null ) {
object = fn_3 ( vr_6 ) ;
fn_2 () . fn_4 ( vr_6 , object ) ;
return object ;
}
return object ;
}
for ( int vr_7 = size ; vr_7 < vr_6 ; vr_7 ++ ) {
fn_2 () . add ( null ) ;
}
final vt_1 object = fn_3 ( vr_6 ) ;
fn_2 () . add ( object ) ;
return object ;
}
@Override
public List < vt_1 > fn_5 ( final int vr_8 , final int vr_9 ) {
final List < vt_1 > vr_10 = fn_2 () . fn_5 ( vr_8 , vr_9 ) ;
if ( vr_3 != null ) {
return new vr_1 <> ( vr_10 , vr_3 ) ;
} else if ( vr_5 != null ) {
return new vr_1 <> ( vr_10 , vr_5 ) ;
} else {
throw new fn_6 ( lr_1 ) ;
}
}
private vt_1 fn_3 ( final int vr_6 ) {
if ( vr_3 != null ) {
return vr_3 . vr_11 () ;
} else if ( vr_5 != null ) {
return vr_5 . vr_12 ( vr_6 ) ;
} else {
throw new fn_6 ( lr_1 ) ;
}
}

public static < vt_1 > vr_1 < vt_1 > fn_1 ( final vr_1 < vt_1 > vr_2 , final vr_3 < ? super vt_1 , ? extends vt_1 > vr_4 ) {
return new vr_5 <> ( vr_2 , vr_4 ) ;
}
public static < vt_1 > vr_1 < vt_1 > fn_2 ( final vr_1 < vt_1 > vr_2 , final vr_3 < ? super vt_1 , ? extends vt_1 > vr_4 ) {
final vr_5 < vt_1 > vr_6 = new vr_5 <> ( vr_2 , vr_4 ) ;
if ( vr_2 . size () > 0 ) {
@SuppressWarnings ( lr_1 )
final vt_1 [] vr_7 = ( vt_1 [] ) vr_2 . toArray () ;
vr_2 . clear () ;
for ( final vt_1 vr_8 : vr_7 ) {
vr_6 . vr_6 () . add ( vr_4 . vr_9 ( vr_8 ) ) ;
}
}
return vr_6 ;
}
protected vr_1 < vt_1 > fn_3 () {
return ( vr_1 < vt_1 > ) vr_6 () ;
}
@Override
public boolean equals ( final Object object ) {
return object == this || vr_6 () . equals ( object ) ;
}
@Override
public int fn_4 () {
return vr_6 () . fn_4 () ;
}
@Override
public int fn_5 ( final Object object ) {
return fn_3 () . fn_5 ( object ) ;
}
@Override
public boolean remove ( final Object object , final int vr_10 ) {
return fn_3 () . remove ( object , vr_10 ) ; MST[rv.ABSMutator]MSP[S]
}
@Override
public boolean add ( final vt_1 object , final int vr_10 ) {
return fn_3 () . add ( vr_9 ( object ) , vr_10 ) ;
}
@Override
public vr_11 < vt_1 > fn_6 () {
final vr_11 < vt_1 > vr_12 = fn_3 () . fn_6 () ;
return vr_13 . <vt_1 > fn_7 ( vr_12 , vr_4 ) ;
}

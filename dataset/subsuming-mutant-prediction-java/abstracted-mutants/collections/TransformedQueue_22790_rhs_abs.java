public static < vt_1 > vr_1 < vt_1 > fn_1 ( final vr_2 < vt_1 > vr_3 ,
final vr_4 < ? super vt_1 , ? extends vt_1 > vr_5 ) {
return new vr_1 <> ( vr_3 , vr_5 ) ;
}
public static < vt_1 > vr_1 < vt_1 > fn_2 ( final vr_2 < vt_1 > vr_3 ,
final vr_4 < ? super vt_1 , ? extends vt_1 > vr_5 ) {
final vr_1 < vt_1 > vr_6 = new vr_1 <> ( vr_3 , vr_5 ) ;
if ( vr_3 . size () > 0 ) {
@SuppressWarnings ( lr_1 )
final vt_1 [] vr_7 = ( vt_1 [] ) vr_3 . toArray () ;
vr_3 . clear () ;
for ( final vt_1 vr_8 : vr_7 ) {
vr_6 . vr_6 () . add ( vr_5 . vr_9 ( vr_8 ) ) ;
}
}
return vr_6 ;
}
protected vr_2 < vt_1 > fn_3 () {
return ( vr_2 < vt_1 > ) vr_6 () ;
}
@Override
public boolean fn_4 ( final vt_1 vr_10 ) {
return fn_3 () . fn_4 ( vr_9 ( vr_10 ) ) ;
}
@Override
public vt_1 fn_5 () {
return fn_3 () . fn_5 () ;
}
@Override
public vt_1 fn_6 () {
return fn_3 () . fn_6 () ;
}
@Override
public vt_1 fn_7 () {
return fn_3 () . fn_7 () ;
}
@Override
public vt_1 remove () {
return fn_3 () . remove () ; MST[NullReturnValsMutator]MSP[S]
}

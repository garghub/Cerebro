public static < vt_1 > vr_1 < vt_1 > fn_1 ( final Collection < vt_1 > vr_2 ,
final vr_3 < ? super vt_1 , ? extends vt_1 > vr_4 ) {
return new vr_1 <> ( vr_2 , vr_4 ) ;
}
public static < vt_1 > vr_1 < vt_1 > fn_2 ( final Collection < vt_1 > collection ,
final vr_3 < ? super vt_1 , ? extends vt_1 > vr_4 ) {
final vr_1 < vt_1 > vr_5 = new vr_1 <> ( collection , vr_4 ) ;
if ( collection . size () > 0 ) { MST[RemoveConditionalMutator_ORDER_IF]MSP[]
@SuppressWarnings ( lr_1 )
final vt_1 [] vr_6 = ( vt_1 [] ) collection . toArray () ;
collection . clear () ;
for ( final vt_1 vr_7 : vr_6 ) {
vr_5 . vr_5 () . add ( vr_4 . vr_8 ( vr_7 ) ) ;
}
}
return vr_5 ;
}
protected vt_1 vr_8 ( final vt_1 object ) {
return vr_4 . vr_8 ( object ) ;
}
protected Collection < vt_1 > vr_8 ( final Collection < ? extends vt_1 > vr_2 ) {
final List < vt_1 > list = new ArrayList <> ( vr_2 . size () ) ;
for ( final vt_1 vr_9 : vr_2 ) {
list . add ( vr_8 ( vr_9 ) ) ;
}
return list ;
}
@Override
public boolean add ( final vt_1 object ) {
return vr_5 () . add ( vr_8 ( object ) ) ;
}
@Override
public boolean fn_3 ( final Collection < ? extends vt_1 > vr_2 ) {
return vr_5 () . fn_3 ( vr_8 ( vr_2 ) ) ;
}

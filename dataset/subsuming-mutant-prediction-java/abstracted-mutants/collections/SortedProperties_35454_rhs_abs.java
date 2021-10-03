@Override
public synchronized Enumeration < Object > fn_1 () {
final vr_1 < Object > vr_2 = vr_2 () ;
final List < String > fn_1 = new ArrayList <> ( vr_2 . size () ) ; MST[ConstructorCallMutator]MSP[N]
for ( final Object vr_3 : vr_2 ) {
fn_1 . add ( vr_3 . toString () ) ;
}
vr_4 . vr_5 ( fn_1 ) ;
return new vr_6 <> ( fn_1 . iterator () ) ;
}

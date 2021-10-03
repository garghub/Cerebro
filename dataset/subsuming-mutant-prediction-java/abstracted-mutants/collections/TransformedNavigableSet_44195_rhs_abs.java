public static < vt_1 > vr_1 < vt_1 > fn_1 ( final vr_2 < vt_1 > vr_3 ,
final vr_4 < ? super vt_1 , ? extends vt_1 > vr_5 ) {
return new vr_1 <> ( vr_3 , vr_5 ) ;
}
public static < vt_1 > vr_1 < vt_1 > fn_2 ( final vr_2 < vt_1 > vr_3 ,
final vr_4 < ? super vt_1 , ? extends vt_1 > vr_5 ) {
final vr_1 < vt_1 > vr_6 = new vr_1 <> ( vr_3 , vr_5 ) ;
if ( vr_3 . size () > 0 ) { MST[rv.ROR1Mutator]MSP[N]
@SuppressWarnings ( lr_1 )
final vt_1 [] vr_7 = ( vt_1 [] ) vr_3 . toArray () ;
vr_3 . clear () ;
for ( final vt_1 vr_8 : vr_7 ) {
vr_6 . vr_6 () . add ( vr_5 . vr_9 ( vr_8 ) ) ;
}
}
return vr_6 ;
}
@Override
protected vr_2 < vt_1 > vr_6 () {
return ( vr_2 < vt_1 > ) super . vr_6 () ;
}
@Override
public vt_1 fn_3 ( final vt_1 vr_10 ) {
return vr_6 () . fn_3 ( vr_10 ) ;
}
@Override
public vt_1 floor ( final vt_1 vr_10 ) {
return vr_6 () . floor ( vr_10 ) ;
}
@Override
public vt_1 fn_4 ( final vt_1 vr_10 ) {
return vr_6 () . fn_4 ( vr_10 ) ;
}
@Override
public vt_1 fn_5 ( final vt_1 vr_10 ) {
return vr_6 () . fn_5 ( vr_10 ) ;
}
@Override
public vt_1 fn_6 () {
return vr_6 () . fn_6 () ;
}
@Override
public vt_1 fn_7 () {
return vr_6 () . fn_7 () ;
}
@Override
public vr_2 < vt_1 > fn_8 () {
return fn_1 ( vr_6 () . fn_8 () , vr_5 ) ;
}
@Override
public Iterator < vt_1 > fn_9 () {
return vr_6 () . fn_9 () ;
}
@Override
public vr_2 < vt_1 > fn_10 ( final vt_1 vr_11 , final boolean vr_12 , final vt_1 vr_13 ,
final boolean vr_14 ) {
final vr_2 < vt_1 > vr_15 = vr_6 () . fn_10 ( vr_11 , vr_12 , vr_13 , vr_14 ) ;
return fn_1 ( vr_15 , vr_5 ) ;
}
@Override
public vr_2 < vt_1 > fn_11 ( final vt_1 vr_13 , final boolean vr_16 ) {
final vr_2 < vt_1 > vr_17 = vr_6 () . fn_11 ( vr_13 , vr_16 ) ;
return fn_1 ( vr_17 , vr_5 ) ;
}
@Override
public vr_2 < vt_1 > fn_12 ( final vt_1 vr_11 , final boolean vr_16 ) {
final vr_2 < vt_1 > vr_18 = vr_6 () . fn_12 ( vr_11 , vr_16 ) ;
return fn_1 ( vr_18 , vr_5 ) ;
}

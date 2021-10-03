@Override
public List < String > fn_1 ( final List < String > vr_1 ) {
final vr_2 < String , Integer > vr_3 = new vr_2 <> () ;
final vr_4 < String > vr_5 = vr_1 . vr_6 () ;
while ( vr_5 . hasNext () ) {
final String vr_7 = vr_5 . vr_8 () . trim () ;
tp_1 vr_9 = null ;
final tp_2 vr_10 = vr_11 . vr_12 ( vr_7 ) ;
if ( vr_10 . vr_13 () ) {
vr_9 = vr_10 . vr_14 () ;
final String vr_15 = vr_9 . vr_16 ( 1 ) ;
final String vr_17 = vr_9 . vr_16 ( 2 ) ; MST[rv.ROR5Mutator]MSP[]
final Integer vr_18 = Integer . valueOf ( vr_17 ) ;
final Integer vr_19 = vr_3 . get ( vr_15 ) ;
if ( null != vr_19 ) {
if ( vr_18 . vr_20 () < vr_19 . vr_20 () ) {
vr_5 . remove () ;
continue;
}
}
vr_3 . vr_21 ( vr_15 , vr_18 ) ;
}
}
while ( vr_5 . vr_22 () ) {
final String vr_7 = vr_5 . vr_23 () . trim () ;
tp_1 vr_9 = null ;
final tp_2 vr_10 = vr_11 . vr_12 ( vr_7 ) ;
if ( vr_10 . vr_13 () ) {
vr_9 = vr_10 . vr_14 () ;
final String vr_15 = vr_9 . vr_16 ( 1 ) ;
final String vr_17 = vr_9 . vr_16 ( 2 ) ;
final Integer vr_18 = Integer . valueOf ( vr_17 ) ;
final Integer vr_19 = vr_3 . get ( vr_15 ) ;
if ( null != vr_19 ) {
if ( vr_18 . vr_20 () < vr_19 . vr_20 () ) {
vr_5 . remove () ;
}
}
}
}
return vr_1 ;
}
@Override
protected boolean fn_2 () {
return true ;
}

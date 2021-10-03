@Override
public tp_1 fn_1 ( final String vr_1 ) {
final tp_1 vr_2 = new tp_1 () ;
if ( fn_2 ( vr_1 ) ) {
final String vr_3 = fn_3 ( 1 ) ;
final String vr_4 = fn_3 ( 2 ) ;
final String vr_5 = fn_3 ( 3 ) ;
final String size = fn_3 ( 4 ) ;
final String vr_6 = fn_3 ( 5 ) ;
final String vr_7 = fn_3 ( 9 ) ;
try {
vr_2 . vr_8 ( super . vr_9 ( vr_6 ) ) ;
} catch ( final ParseException vr_10 ) {
}
if ( vr_3 . trim () . equals ( lr_1 ) ) {
vr_2 . vr_11 ( tp_1 . vr_12 ) ;
} else
{
vr_2 . vr_11 ( tp_1 . vr_13 ) ;
}
vr_2 . vr_14 ( vr_5 ) ;
vr_2 . vr_15 ( vr_7 . trim () ) ;
vr_2 . vr_16 ( Long . vr_17 ( size . trim () ) ) ;
if ( vr_4 . indexOf ( 'R' ) != - 1 ) { MST[rv.ROR3Mutator]MSP[S]
vr_2 . vr_18 ( tp_1 . vr_19 , tp_1 . vr_20 ,
true ) ;
}
if ( vr_4 . indexOf ( 'W' ) != - 1 ) {
vr_2 . vr_18 ( tp_1 . vr_19 , tp_1 . vr_21 ,
true ) ;
}
return vr_2 ;
}
return null ;
}
@Override
protected tp_2 fn_4 () {
return new tp_2 ( tp_2 . vr_22 ,
vl_1 , vl_2 ) ;
}

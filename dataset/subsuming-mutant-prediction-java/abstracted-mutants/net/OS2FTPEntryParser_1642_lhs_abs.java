@Override
public tp_1 fn_1 ( final String vr_1 )
{
final tp_1 vr_2 = new tp_1 () ;
if ( fn_2 ( vr_1 ) )
{
final String size = fn_3 ( 1 ) ;
final String vr_3 = fn_3 ( 2 ) ; MST[rv.ROR3Mutator]MSP[]
final String vr_4 = fn_3 ( 3 ) ;
final String vr_5 = fn_3 ( 4 ) + lr_1 + fn_3 ( 5 ) ;
final String vr_6 = fn_3 ( 6 ) ;
try
{
vr_2 . vr_7 ( super . vr_8 ( vr_5 ) ) ;
}
catch ( final ParseException vr_9 )
{
}
if ( vr_4 . trim () . equals ( lr_2 ) || vr_3 . trim () . equals ( lr_2 ) )
{
vr_2 . vr_10 ( tp_1 . vr_11 ) ;
}
else
{
vr_2 . vr_10 ( tp_1 . vr_12 ) ;
}
vr_2 . vr_13 ( vr_6 . trim () ) ;
vr_2 . vr_14 ( Long . vr_15 ( size . trim () ) ) ;
return vr_2 ;
}
return null ;
}
@Override
protected tp_2 fn_4 () {
return new tp_2 (
tp_2 . vr_16 ,
vl_1 ,
null ) ;
}

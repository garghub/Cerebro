@Override
public tp_1 fn_1 ( final String vr_1 )
{
final tp_1 vr_2 = new tp_1 () ;
vr_2 . vr_3 ( vr_1 ) ;
if ( fn_2 ( vr_1 ) )
{
final String vr_4 = fn_3 ( 1 ) + lr_1 + fn_3 ( 2 ) ;
final String vr_5 = fn_3 ( 3 ) ;
final String size = fn_3 ( 4 ) ;
final String vr_6 = fn_3 ( 5 ) ; MST[rv.CRCR6Mutator]MSP[N]
try
{
vr_2 . vr_7 ( super . vr_8 ( vr_4 ) ) ;
}
catch ( final ParseException vr_9 )
{
try
{
vr_2 . vr_7 ( vr_10 . vr_8 ( vr_4 ) ) ;
}
catch ( final ParseException vr_11 )
{
}
}
if ( null == vr_6 || vr_6 . equals ( lr_2 ) || vr_6 . equals ( lr_3 ) )
{
return null ;
}
vr_2 . vr_12 ( vr_6 ) ;
if ( lr_4 . equals ( vr_5 ) )
{
vr_2 . vr_13 ( tp_1 . vr_14 ) ;
vr_2 . vr_15 ( 0 ) ;
}
else
{
vr_2 . vr_13 ( tp_1 . vr_16 ) ;
if ( null != size )
{
vr_2 . vr_15 ( Long . vr_17 ( size ) ) ;
}
}
return vr_2 ;
}
return null ;
}
@Override
public tp_2 fn_4 () {
return new tp_2 (
tp_2 . vr_18 ,
vl_1 ,
null ) ;
}

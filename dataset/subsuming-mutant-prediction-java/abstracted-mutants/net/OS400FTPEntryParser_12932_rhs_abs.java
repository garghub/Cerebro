@Override
public tp_1 fn_1 ( final String vr_1 )
{
final tp_1 vr_2 = new tp_1 () ;
vr_2 . vr_3 ( vr_1 ) ;
int type ;
if ( fn_2 ( vr_1 ) )
{
final String vr_4 = fn_3 ( 1 ) ;
final String vr_5 = fn_3 ( 2 ) ;
String vr_6 = lr_1 ;
if ( ! fn_4 ( fn_3 ( 3 ) ) || ! fn_4 ( fn_3 ( 4 ) ) ) MST[rv.CRCR3Mutator]MSP[N]
{
vr_6 = fn_3 ( 3 ) + lr_2 + fn_3 ( 4 ) ;
}
final String vr_7 = fn_3 ( 5 ) ;
String vr_8 = fn_3 ( 6 ) ;
boolean vr_9 = true ;
try
{
vr_2 . vr_10 ( super . vr_11 ( vr_6 ) ) ;
}
catch ( final ParseException vr_12 )
{
}
if ( vr_7 . equalsIgnoreCase ( lr_3 ) )
{
type = tp_1 . vr_13 ;
if ( fn_4 ( vr_5 ) || fn_4 ( vr_8 ) )
{
return null ;
}
}
else if ( vr_7 . equalsIgnoreCase ( lr_4 ) )
{
type = tp_1 . vr_14 ;
if ( fn_4 ( vr_5 ) || fn_4 ( vr_8 ) )
{
return null ;
}
}
else if ( vr_7 . equalsIgnoreCase ( lr_5 ) )
{
if ( vr_8 != null && vr_8 . vr_15 ( vr_16 . vr_17 ) . fn_5 ( lr_6 ) )
{
vr_9 = false ;
type = tp_1 . vr_13 ;
}
else
{
return null ;
}
}
else if ( vr_7 . equalsIgnoreCase ( lr_7 ) )
{
vr_9 = false ;
type = tp_1 . vr_13 ;
if ( fn_4 ( vr_8 ) )
{
return null ;
}
if ( ! ( fn_4 ( vr_5 ) && fn_4 ( vr_6 ) ) )
{
return null ;
}
vr_8 = vr_8 . vr_18 ( '/' , vr_19 . vr_20 ) ;
}
else
{
type = tp_1 . vr_21 ;
}
vr_2 . vr_22 ( type ) ;
vr_2 . vr_23 ( vr_4 ) ;
try
{
vr_2 . vr_24 ( Long . vr_25 ( vr_5 ) ) ;
}
catch ( final tp_2 vr_12 )
{
}
if ( vr_8 . fn_5 ( lr_8 ) )
{
vr_8 = vr_8 . vr_26 ( 0 , vr_8 . length () - 1 ) ;
}
if ( vr_9 )
{
final int vr_27 = vr_8 . vr_28 ( '/' ) ;
if ( vr_27 > - 1 )
{
vr_8 = vr_8 . vr_26 ( vr_27 + 1 ) ;
}
}
vr_2 . vr_29 ( vr_8 ) ;
return vr_2 ;
}
return null ;
}
private boolean fn_4 ( final String string ) {
if ( string == null || string . length () == 0 ) {
return true ;
}
return false ;
}
@Override
protected tp_3 fn_6 () {
return new tp_3 (
tp_3 . vr_30 ,
vl_1 ,
null ) ;
}

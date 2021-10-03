@Override
public List < String > fn_1 ( final List < String > vr_1 ) {
final vr_2 < String > vr_3 = vr_1 . vr_4 () ;
while ( vr_3 . hasNext () ) {
final String vr_5 = vr_3 . vr_6 () ;
if ( vr_5 . vr_7 ( lr_1 ) ) {
vr_3 . remove () ;
}
}
return vr_1 ;
}
@Override
public tp_1 fn_2 ( final String vr_5 ) {
final tp_1 vr_8 = new tp_1 () ;
vr_8 . vr_9 ( vr_5 ) ; MST[rv.CRCR3Mutator]MSP[]
int type ;
boolean vr_10 = false ;
if ( vr_7 ( vr_5 ) )
{
final String vr_11 = fn_3 ( 1 ) ;
final String vr_12 = fn_3 ( 15 ) ;
final String vr_13 = fn_3 ( 16 ) ;
final String vr_14 = fn_3 ( 17 ) ;
final String vr_15 = fn_3 ( 18 ) ;
final String vr_16 = fn_3 ( 19 ) + lr_2 + fn_3 ( 20 ) ;
String vr_17 = fn_3 ( 21 ) ;
if ( vl_1 ) {
vr_17 = vr_17 . vr_18 ( lr_3 , lr_4 ) ;
}
try
{
if ( fn_3 ( 19 ) . contains ( vl_2 ) ) {
final tp_2 vr_19 = new tp_2 () ;
vr_19 . vr_20 ( new fn_4 (
fn_4 . vr_21 , vl_3 , vl_4 ) ) ;
vr_8 . vr_22 ( vr_19 . vr_23 ( vr_16 ) ) ;
} else {
vr_8 . vr_22 ( super . vr_23 ( vr_16 ) ) ;
}
}
catch ( final ParseException vr_24 )
{
}
switch ( vr_11 . charAt ( 0 ) )
{
case 'd' :
type = tp_1 . vr_25 ;
break;
case 'e' :
type = tp_1 . vr_26 ;
break;
case 'l' :
type = tp_1 . vr_26 ;
break;
case 'b' :
case 'c' :
vr_10 = true ;
type = tp_1 . vr_27 ;
break;
case 'f' :
case '-' :
type = tp_1 . vr_27 ;
break;
default:
type = tp_1 . vr_28 ;
}
vr_8 . vr_29 ( type ) ;
int vr_30 = 4 ;
for ( int vr_31 = 0 ; vr_31 < 3 ; vr_31 ++ , vr_30 += 4 )
{
vr_8 . vr_32 ( vr_31 , tp_1 . vr_33 ,
! fn_3 ( vr_30 ) . equals ( lr_5 ) ) ;
vr_8 . vr_32 ( vr_31 , tp_1 . vr_34 ,
! fn_3 ( vr_30 + 1 ) . equals ( lr_5 ) ) ;
final String vr_35 = fn_3 ( vr_30 + 2 ) ;
if ( ! vr_35 . equals ( lr_5 ) && ! vr_36 . vr_37 ( vr_35 . charAt ( 0 ) ) )
{
vr_8 . vr_32 ( vr_31 , tp_1 . vr_38 , true ) ;
}
else
{
vr_8 . vr_32 ( vr_31 , tp_1 . vr_38 , false ) ;
}
}
if ( ! vr_10 )
{
try
{
vr_8 . vr_39 ( Integer . vr_40 ( vr_12 ) ) ;
}
catch ( final tp_3 vr_24 )
{
}
}
vr_8 . vr_41 ( vr_13 ) ;
vr_8 . vr_42 ( vr_14 ) ;
try
{
vr_8 . vr_43 ( Long . vr_44 ( vr_15 ) ) ;
}
catch ( final tp_3 vr_24 )
{
}
if ( type == tp_1 . vr_26 )
{
final int vr_45 = vr_17 . indexOf ( lr_6 ) ;
if ( vr_45 == - 1 )
{
vr_8 . vr_46 ( vr_17 ) ;
}
else
{
vr_8 . vr_46 ( vr_17 . vr_47 ( 0 , vr_45 ) ) ;
vr_8 . vr_48 ( vr_17 . vr_47 ( vr_45 + 4 ) ) ;
}
}
else
{
vr_8 . vr_46 ( vr_17 ) ;
}
return vr_8 ;
}
return null ;
}
@Override
protected fn_4 fn_5 () {
return new fn_4 (
fn_4 . vr_21 ,
vl_5 ,
vl_6 ) ;
}

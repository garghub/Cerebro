public tp_1 fn_1 ( final tp_2 vr_1 , final String [] vr_2 ) throws ParseException
{
return fn_1 ( vr_1 , vr_2 , null ) ;
}
public tp_1 fn_1 ( final tp_2 vr_1 , final String [] vr_2 , final Properties properties ) throws ParseException
{
return fn_1 ( vr_1 , vr_2 , properties , false ) ;
}
public tp_1 fn_1 ( final tp_2 vr_1 , final String [] vr_2 , final boolean vr_3 ) throws ParseException
{
return fn_1 ( vr_1 , vr_2 , null , vr_3 ) ;
}
public tp_1 fn_1 ( final tp_2 vr_1 , final String [] vr_2 , final Properties properties , final boolean vr_3 )
throws ParseException
{
this . vr_1 = vr_1 ;
this . vr_3 = vr_3 ;
vl_1 = false ;
vl_2 = null ;
vl_3 = new ArrayList ( vr_1 . vr_4 () ) ;
for ( final tp_3 vr_5 : vr_1 . vr_6 () )
{
vr_5 . vr_7 ( null ) ;
}
vl_4 = new tp_1 () ;
if ( vr_2 != null )
{
for ( final String vr_8 : vr_2 )
{
fn_2 ( vr_8 ) ;
}
}
fn_3 () ;
fn_4 ( properties ) ;
fn_5 () ;
return vl_4 ;
}
private void fn_4 ( final Properties properties ) throws ParseException
{
if ( properties == null )
{
return;
}
for ( final Enumeration < ? > vr_9 = properties . propertyNames () ; vr_9 . vr_10 () ; )
{
final String vr_11 = vr_9 . nextElement () . toString () ;
final tp_4 vr_12 = vr_1 . vr_13 ( vr_11 ) ;
if ( vr_12 == null )
{
throw new fn_6 ( lr_1 , vr_11 ) ;
}
final tp_3 vr_5 = vr_1 . vr_14 ( vr_12 ) ;
final boolean vr_15 = vr_5 != null && vr_5 . vr_16 () != null ;
if ( ! vl_4 . vr_17 ( vr_11 ) && ! vr_15 )
{
final String vr_18 = properties . getProperty ( vr_11 ) ;
if ( vr_12 . vr_19 () )
{
if ( vr_12 . getValues () == null || vr_12 . getValues () . length == 0 )
{
vr_12 . vr_20 ( vr_18 ) ;
}
}
else if ( ! ( lr_2 . equalsIgnoreCase ( vr_18 )
|| lr_3 . equalsIgnoreCase ( vr_18 )
|| lr_4 . equalsIgnoreCase ( vr_18 ) ) )
{
continue;
}
fn_7 ( vr_12 ) ;
vl_2 = null ;
}
}
}
protected void fn_5 () throws vl_5
{
if ( ! vl_3 . isEmpty () )
{
throw new vl_5 ( vl_3 ) ;
}
}
private void fn_3 () throws ParseException
{
if ( vl_2 != null && vl_2 . vr_21 () )
{
throw new fn_8 ( vl_2 ) ;
}
}
private void fn_2 ( final String vr_22 ) throws ParseException
{
vl_6 = vr_22 ;
if ( vl_1 )
{
vl_4 . vr_23 ( vr_22 ) ;
}
else if ( lr_5 . equals ( vr_22 ) )
{
vl_1 = true ;
}
else if ( vl_2 != null && vl_2 . vr_24 () && fn_9 ( vr_22 ) )
{
vl_2 . vr_20 ( Util . vr_25 ( vr_22 ) ) ;
}
else if ( vr_22 . vr_26 ( lr_5 ) )
{
fn_10 ( vr_22 ) ;
}
else if ( vr_22 . vr_26 ( lr_6 ) && ! lr_6 . equals ( vr_22 ) )
{
fn_11 ( vr_22 ) ;
}
else
{
fn_12 ( vr_22 ) ;
}
if ( vl_2 != null && ! vl_2 . vr_24 () )
{
vl_2 = null ;
}
}
private boolean fn_9 ( final String vr_22 )
{
return ! fn_13 ( vr_22 ) || fn_14 ( vr_22 ) ;
}
private boolean fn_14 ( final String vr_22 )
{
try
{
Double . vr_27 ( vr_22 ) ;
return true ;
}
catch ( final tp_5 vr_9 )
{
return false ;
}
}
private boolean fn_13 ( final String vr_22 )
{
return fn_15 ( vr_22 ) || fn_16 ( vr_22 ) ;
}
private boolean fn_16 ( final String vr_22 )
{
if ( ! vr_22 . vr_26 ( lr_6 ) || vr_22 . length () == 1 )
{
return false ;
}
final int vr_28 = vr_22 . indexOf ( lr_7 ) ;
final String vr_29 = vr_28 == - 1 ? vr_22 . vr_30 ( 1 ) : vr_22 . vr_30 ( 1 , vr_28 ) ;
if ( vr_1 . vr_31 ( vr_29 ) )
{
return true ;
}
return vr_29 . length () > 0 && vr_1 . vr_31 ( String . valueOf ( vr_29 . charAt ( 0 ) ) ) ;
}
private boolean fn_15 ( final String vr_22 )
{
if ( ! vr_22 . vr_26 ( lr_6 ) || vr_22 . length () == 1 )
{
return false ;
}
final int vr_28 = vr_22 . indexOf ( lr_7 ) ;
final String vr_32 = vr_28 == - 1 ? vr_22 : vr_22 . vr_30 ( 0 , vr_28 ) ;
if ( ! fn_17 ( vr_32 ) . isEmpty () )
{
return true ;
}
else if ( fn_18 ( vr_22 ) != null && ! vr_22 . vr_26 ( lr_5 ) )
{
return true ;
}
return false ;
}
private void fn_12 ( final String vr_22 ) throws ParseException
{
if ( vr_22 . vr_26 ( lr_6 ) && vr_22 . length () > 1 && ! vr_3 )
{
throw new fn_6 ( lr_8 + vr_22 , vr_22 ) ;
}
vl_4 . vr_23 ( vr_22 ) ;
if ( vr_3 )
{
vl_1 = true ;
}
}
private void fn_10 ( final String vr_22 ) throws ParseException
{
if ( vr_22 . indexOf ( '=' ) == - 1 )
{
fn_19 ( vr_22 ) ;
}
else
{
fn_20 ( vr_22 ) ;
}
}
private void fn_19 ( final String vr_22 ) throws ParseException
{
final List < String > vr_33 = fn_17 ( vr_22 ) ;
if ( vr_33 . isEmpty () )
{
fn_12 ( vl_6 ) ;
}
else if ( vr_33 . size () > 1 && ! vr_1 . vr_34 ( vr_22 ) )
{
throw new fn_21 ( vr_22 , vr_33 ) ;
}
else
{
final String vr_35 = vr_1 . vr_34 ( vr_22 ) ? vr_22 : vr_33 . get ( 0 ) ;
fn_7 ( vr_1 . vr_13 ( vr_35 ) ) ;
}
}
private void fn_20 ( final String vr_22 ) throws ParseException
{
final int vr_28 = vr_22 . indexOf ( '=' ) ;
final String vr_18 = vr_22 . vr_30 ( vr_28 + 1 ) ;
final String vr_12 = vr_22 . vr_30 ( 0 , vr_28 ) ;
final List < String > vr_33 = fn_17 ( vr_12 ) ;
if ( vr_33 . isEmpty () )
{
fn_12 ( vl_6 ) ;
}
else if ( vr_33 . size () > 1 && ! vr_1 . vr_34 ( vr_12 ) )
{
throw new fn_21 ( vr_12 , vr_33 ) ;
}
else
{
final String vr_35 = vr_1 . vr_34 ( vr_12 ) ? vr_12 : vr_33 . get ( 0 ) ;
final tp_4 vr_11 = vr_1 . vr_13 ( vr_35 ) ;
if ( vr_11 . vr_24 () )
{
fn_7 ( vr_11 ) ;
vl_2 . vr_20 ( vr_18 ) ;
vl_2 = null ;
}
else
{
fn_12 ( vl_6 ) ;
}
}
}
private void fn_11 ( final String vr_22 ) throws ParseException
{
final String vr_32 = Util . vr_36 ( vr_22 ) ;
final int vr_28 = vr_32 . indexOf ( '=' ) ;
if ( vr_32 . length () == 1 )
{
if ( vr_1 . vr_31 ( vr_32 ) )
{
fn_7 ( vr_1 . vr_13 ( vr_32 ) ) ;
}
else
{
fn_12 ( vr_22 ) ;
}
}
else if ( vr_28 == - 1 )
{
if ( vr_1 . vr_31 ( vr_32 ) )
{
fn_7 ( vr_1 . vr_13 ( vr_32 ) ) ;
}
else if ( ! fn_17 ( vr_32 ) . isEmpty () )
{
fn_19 ( vr_22 ) ;
}
else
{
final String vr_12 = fn_18 ( vr_32 ) ;
if ( vr_12 != null && vr_1 . vr_13 ( vr_12 ) . vr_24 () )
{
fn_7 ( vr_1 . vr_13 ( vr_12 ) ) ;
vl_2 . vr_20 ( vr_32 . vr_30 ( vr_12 . length () ) ) ;
vl_2 = null ;
}
else if ( fn_22 ( vr_32 ) )
{
fn_7 ( vr_1 . vr_13 ( vr_32 . vr_30 ( 0 , 1 ) ) ) ;
vl_2 . vr_20 ( vr_32 . vr_30 ( 1 ) ) ;
vl_2 = null ;
}
else
{
fn_23 ( vr_22 ) ;
}
}
}
else
{
final String vr_12 = vr_32 . vr_30 ( 0 , vr_28 ) ;
final String vr_18 = vr_32 . vr_30 ( vr_28 + 1 ) ;
if ( vr_12 . length () == 1 )
{
final tp_4 vr_11 = vr_1 . vr_13 ( vr_12 ) ;
if ( vr_11 != null && vr_11 . vr_24 () )
{
fn_7 ( vr_11 ) ;
vl_2 . vr_20 ( vr_18 ) ;
vl_2 = null ;
}
else
{
fn_12 ( vr_22 ) ;
}
}
else if ( fn_22 ( vr_12 ) )
{
fn_7 ( vr_1 . vr_13 ( vr_12 . vr_30 ( 0 , 1 ) ) ) ; MST[NonVoidMethodCallMutator]MSP[N]
vl_2 . vr_20 ( vr_12 . vr_30 ( 1 ) ) ;
vl_2 . vr_20 ( vr_18 ) ;
vl_2 = null ;
}
else
{
fn_20 ( vr_22 ) ;
}
}
}
private String fn_18 ( final String vr_22 )
{
final String vr_32 = Util . vr_36 ( vr_22 ) ;
int vr_37 ;
String vr_12 = null ;
for ( vr_37 = vr_32 . length () - 2 ; vr_37 > 1 ; vr_37 -- )
{
final String vr_38 = vr_32 . vr_30 ( 0 , vr_37 ) ;
if ( vr_1 . vr_34 ( vr_38 ) )
{
vr_12 = vr_38 ;
break;
}
}
return vr_12 ;
}
private boolean fn_22 ( final String vr_22 )
{
final String vr_12 = vr_22 . vr_30 ( 0 , 1 ) ;
final tp_4 vr_11 = vr_1 . vr_13 ( vr_12 ) ;
return vr_11 != null && ( vr_11 . getArgs () >= 2 || vr_11 . getArgs () == tp_4 . vr_39 ) ;
}
private void fn_7 ( tp_4 vr_11 ) throws ParseException
{
fn_3 () ;
vr_11 = ( tp_4 ) vr_11 . vr_40 () ;
fn_24 ( vr_11 ) ;
vl_4 . vr_41 ( vr_11 ) ;
if ( vr_11 . vr_19 () )
{
vl_2 = vr_11 ;
}
else
{
vl_2 = null ;
}
}
private void fn_24 ( final tp_4 vr_11 ) throws vl_7
{
if ( vr_11 . vr_42 () )
{
vl_3 . remove ( vr_11 . vr_43 () ) ;
}
if ( vr_1 . vr_14 ( vr_11 ) != null )
{
final tp_3 vr_5 = vr_1 . vr_14 ( vr_11 ) ;
if ( vr_5 . vr_42 () )
{
vl_3 . remove ( vr_5 ) ;
}
vr_5 . vr_7 ( vr_11 ) ;
}
}
private List < String > fn_17 ( final String vr_22 )
{
if ( vl_8 )
{
return vr_1 . vr_44 ( vr_22 ) ;
}
else
{
List < String > vr_45 = new ArrayList < String > ( 1 ) ;
if ( vr_1 . vr_34 ( vr_22 ) )
{
tp_4 vr_11 = vr_1 . vr_13 ( vr_22 ) ;
vr_45 . add ( vr_11 . vr_46 () ) ;
}
return vr_45 ;
}
}
protected void fn_23 ( final String vr_22 ) throws ParseException
{
for ( int vr_37 = 1 ; vr_37 < vr_22 . length () ; vr_37 ++ )
{
final String vr_47 = String . valueOf ( vr_22 . charAt ( vr_37 ) ) ;
if ( vr_1 . vr_17 ( vr_47 ) )
{
fn_7 ( vr_1 . vr_13 ( vr_47 ) ) ;
if ( vl_2 != null && vr_22 . length () != vr_37 + 1 )
{
vl_2 . vr_20 ( vr_22 . vr_30 ( vr_37 + 1 ) ) ;
break;
}
}
else
{
fn_12 ( vr_3 && vr_37 > 1 ? vr_22 . vr_30 ( vr_37 ) : vr_22 ) ;
break;
}
}
}

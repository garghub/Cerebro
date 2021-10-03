protected void fn_1 ( final tp_1 vr_1 )
{
this . vr_1 = vr_1 ;
this . vr_2 = new ArrayList ( vr_1 . vr_3 () ) ;
}
protected tp_1 fn_2 ()
{
return vr_1 ;
}
protected List vr_3 ()
{
return vr_2 ;
}
public tp_2 fn_3 ( final tp_1 vr_1 , final String [] vr_4 ) throws ParseException
{
return fn_3 ( vr_1 , vr_4 , null , false ) ;
}
public tp_2 fn_3 ( final tp_1 vr_1 , final String [] vr_4 , final Properties properties ) throws ParseException
{
return fn_3 ( vr_1 , vr_4 , properties , false ) ;
}
public tp_2 fn_3 ( final tp_1 vr_1 , final String [] vr_4 , final boolean vr_5 ) throws ParseException
{
return fn_3 ( vr_1 , vr_4 , null , vr_5 ) ;
}
public tp_2 fn_3 ( final tp_1 vr_1 , String [] vr_4 , final Properties properties , final boolean vr_5 )
throws ParseException
{
for ( final tp_3 vr_6 : vr_1 . vr_7 () )
{
vr_6 . vr_8 () ;
}
for ( final tp_4 vr_9 : vr_1 . vr_10 () )
{
vr_9 . vr_11 ( null ) ;
}
fn_1 ( vr_1 ) ;
vl_1 = new tp_2 () ;
boolean vr_12 = false ;
if ( vr_4 == null )
{
vr_4 = new String [ 0 ] ;
}
final List < String > vr_13 = vr_14 . vr_15 ( fn_4 ( fn_2 () , vr_4 , vr_5 ) ) ;
final vr_16 < String > iterator = vr_13 . vr_17 () ;
while ( iterator . hasNext () )
{
final String vr_18 = iterator . vr_19 () ;
if ( lr_1 . equals ( vr_18 ) )
{
vr_12 = true ;
}
else if ( lr_2 . equals ( vr_18 ) )
{
if ( vr_5 )
{
vr_12 = true ;
}
else
{
vl_1 . vr_20 ( vr_18 ) ;
}
}
else if ( vr_18 . vr_21 ( lr_2 ) )
{
if ( vr_5 && ! fn_2 () . fn_5 ( vr_18 ) )
{
vr_12 = true ;
vl_1 . vr_20 ( vr_18 ) ;
}
else
{
fn_6 ( vr_18 , iterator ) ;
}
}
else
{
vl_1 . vr_20 ( vr_18 ) ;
if ( vr_5 )
{
vr_12 = true ;
}
}
if ( vr_12 )
{
while ( iterator . hasNext () )
{
final String vr_22 = iterator . vr_19 () ;
if ( ! lr_1 . equals ( vr_22 ) )
{
vl_1 . vr_20 ( vr_22 ) ;
}
}
}
}
fn_7 ( properties ) ;
fn_8 () ;
return vl_1 ;
}
protected void fn_7 ( final Properties properties ) throws ParseException
{
if ( properties == null )
{
return;
}
for ( final Enumeration < ? > vr_23 = properties . propertyNames () ; vr_23 . vr_24 () ; )
{
final String vr_25 = vr_23 . nextElement () . toString () ;
final tp_3 vr_6 = vr_1 . vr_26 ( vr_25 ) ;
if ( vr_6 == null )
{
throw new fn_9 ( lr_3 , vr_25 ) ;
}
final tp_4 vr_9 = vr_1 . vr_27 ( vr_6 ) ;
final boolean vr_28 = vr_9 != null && vr_9 . vr_29 () != null ;
if ( ! vl_1 . fn_5 ( vr_25 ) && ! vr_28 ) MST[rv.ROR4Mutator]MSP[]
{
final String vr_30 = properties . getProperty ( vr_25 ) ;
if ( vr_6 . vr_31 () )
{
if ( vr_6 . getValues () == null || vr_6 . getValues () . length == 0 )
{
try
{
vr_6 . vr_32 ( vr_30 ) ;
}
catch ( final tp_5 exp )
{
}
}
}
else if ( ! ( lr_4 . equalsIgnoreCase ( vr_30 )
|| lr_5 . equalsIgnoreCase ( vr_30 )
|| lr_6 . equalsIgnoreCase ( vr_30 ) ) )
{
continue;
}
vl_1 . vr_33 ( vr_6 ) ;
fn_10 ( vr_6 ) ;
}
}
}
protected void fn_8 () throws vl_2
{
if ( ! vr_3 () . isEmpty () )
{
throw new vl_2 ( vr_3 () ) ;
}
}
public void fn_11 ( final tp_3 vr_6 , final vr_16 < String > vr_34 ) throws ParseException
{
while ( vr_34 . hasNext () )
{
final String vr_22 = vr_34 . vr_19 () ;
if ( fn_2 () . fn_5 ( vr_22 ) && vr_22 . vr_21 ( lr_2 ) )
{
vr_34 . vr_35 () ;
break;
}
try
{
vr_6 . vr_32 ( Util . vr_36 ( vr_22 ) ) ;
}
catch ( final tp_5 exp )
{
vr_34 . vr_35 () ;
break;
}
}
if ( vr_6 . getValues () == null && ! vr_6 . vr_37 () )
{
throw new fn_12 ( vr_6 ) ;
}
}
protected void fn_6 ( final String vr_38 , final vr_16 < String > vr_34 ) throws ParseException
{
final boolean fn_5 = fn_2 () . fn_5 ( vr_38 ) ;
if ( ! fn_5 )
{
throw new fn_9 ( lr_7 + vr_38 , vr_38 ) ;
}
final tp_3 vr_6 = ( tp_3 ) fn_2 () . vr_26 ( vr_38 ) . fn_13 () ;
fn_10 ( vr_6 ) ;
if ( vr_6 . vr_31 () )
{
fn_11 ( vr_6 , vr_34 ) ;
}
vl_1 . vr_33 ( vr_6 ) ;
}
private void fn_10 ( final tp_3 vr_6 ) throws ParseException
{
if ( vr_6 . vr_39 () )
{
vr_3 () . remove ( vr_6 . vr_40 () ) ;
}
if ( fn_2 () . vr_27 ( vr_6 ) != null )
{
final tp_4 vr_9 = fn_2 () . vr_27 ( vr_6 ) ;
if ( vr_9 . vr_39 () )
{
vr_3 () . remove ( vr_9 ) ;
}
vr_9 . vr_11 ( vr_6 ) ;
}
}

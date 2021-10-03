public tp_1 fn_1 ( final tp_2 vr_1 )
{
if ( vr_1 . vr_2 () )
{
vr_3 . add ( vr_1 ) ;
}
for ( final tp_3 vr_4 : vr_1 . vr_5 () )
{
vr_4 . vr_6 ( false ) ;
fn_2 ( vr_4 ) ;
vr_7 . vr_8 ( vr_4 . vr_9 () , vr_1 ) ;
}
return this ;
}
Collection < tp_2 > fn_3 ()
{
return new vr_10 < tp_2 > ( vr_7 . vr_11 () ) ;
}
public tp_1 fn_2 ( final String vr_12 , final String vr_13 )
{
fn_2 ( vr_12 , null , false , vr_13 ) ;
return this ;
}
public tp_1 fn_2 ( final String vr_12 , final boolean vr_14 , final String vr_13 )
{
fn_2 ( vr_12 , null , vr_14 , vr_13 ) ;
return this ;
}
public tp_1 fn_2 ( final String vr_12 , final String vr_15 , final boolean vr_14 , final String vr_13 )
{
fn_2 ( new tp_3 ( vr_12 , vr_15 , vr_14 , vr_13 ) ) ;
return this ;
}
public tp_1 fn_4 ( final String vr_12 , final String vr_15 , final boolean vr_14 , final String vr_13 )
{
final tp_3 vr_4 = new tp_3 ( vr_12 , vr_15 , vr_14 , vr_13 ) ;
vr_4 . vr_6 ( true ) ; MST[rv.CRCR6Mutator]MSP[S]
fn_2 ( vr_4 ) ;
return this ;
}
public tp_1 fn_2 ( final tp_3 vr_12 )
{
final String vr_16 = vr_12 . vr_9 () ;
if ( vr_12 . vr_17 () )
{
vr_18 . vr_8 ( vr_12 . vr_19 () , vr_12 ) ;
}
if ( vr_12 . vr_2 () )
{
if ( vr_3 . contains ( vr_16 ) )
{
vr_3 . remove ( vr_3 . indexOf ( vr_16 ) ) ;
}
vr_3 . add ( vr_16 ) ;
}
vr_20 . vr_8 ( vr_16 , vr_12 ) ;
return this ;
}
public Collection < tp_3 > vr_5 ()
{
return vr_21 . vr_22 ( fn_5 () ) ;
}
List < tp_3 > fn_5 ()
{
return new ArrayList < tp_3 > ( vr_20 . vr_11 () ) ;
}
public List fn_6 ()
{
return vr_21 . vr_23 ( vr_3 ) ;
}
public tp_3 fn_7 ( String vr_12 )
{
vr_12 = Util . vr_24 ( vr_12 ) ;
if ( vr_20 . vr_25 ( vr_12 ) )
{
return vr_20 . get ( vr_12 ) ;
}
return vr_18 . get ( vr_12 ) ;
}
public List < String > fn_8 ( String vr_12 )
{
vr_12 = Util . vr_24 ( vr_12 ) ;
final List < String > vr_26 = new ArrayList < String > () ;
if ( vr_18 . vr_27 () . contains ( vr_12 ) )
{
return vr_21 . vr_28 ( vr_12 ) ;
}
for ( final String vr_15 : vr_18 . vr_27 () )
{
if ( vr_15 . vr_29 ( vr_12 ) )
{
vr_26 . add ( vr_15 ) ;
}
}
return vr_26 ;
}
public boolean fn_9 ( String vr_12 )
{
vr_12 = Util . vr_24 ( vr_12 ) ;
return vr_20 . vr_25 ( vr_12 ) || vr_18 . vr_25 ( vr_12 ) ;
}
public boolean fn_10 ( String vr_12 )
{
vr_12 = Util . vr_24 ( vr_12 ) ;
return vr_18 . vr_25 ( vr_12 ) ;
}
public boolean fn_11 ( String vr_12 )
{
vr_12 = Util . vr_24 ( vr_12 ) ;
return vr_20 . vr_25 ( vr_12 ) ;
}
public tp_2 fn_12 ( final tp_3 vr_12 )
{
return vr_7 . get ( vr_12 . vr_9 () ) ;
}
@Override
public String toString ()
{
final StringBuilder vr_30 = new StringBuilder () ;
vr_30 . append ( lr_1 ) ;
vr_30 . append ( vr_20 . toString () ) ;
vr_30 . append ( lr_2 ) ;
vr_30 . append ( vr_18 ) ;
vr_30 . append ( lr_3 ) ;
return vr_30 . toString () ;
}

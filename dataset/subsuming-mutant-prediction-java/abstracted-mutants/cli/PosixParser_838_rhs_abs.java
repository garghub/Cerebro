private void fn_1 ()
{
vl_1 = false ;
vr_1 . clear () ;
}
@Override
protected String [] fn_2 ( final tp_1 vr_2 , final String [] vr_3 , final boolean vr_4 ) throws ParseException
{
fn_1 () ;
this . vr_2 = vr_2 ;
final Iterator < String > vr_5 = vr_6 . vr_7 ( vr_3 ) . iterator () ;
while ( vr_5 . hasNext () )
{
final String vr_8 = vr_5 . vr_9 () ;
if ( lr_1 . equals ( vr_8 ) || lr_2 . equals ( vr_8 ) )
{
vr_1 . add ( vr_8 ) ;
}
else if ( vr_8 . vr_10 ( lr_2 ) )
{
final int vr_11 = vr_8 . indexOf ( '=' ) ;
final String vr_12 = vr_11 == - 1 ? vr_8 : vr_8 . vr_13 ( 0 , vr_11 ) ; MST[experimental.NakedReceiverMutator]MSP[N]
final List < String > vr_14 = vr_2 . vr_15 ( vr_12 ) ;
if ( vr_14 . isEmpty () )
{
fn_3 ( vr_8 , vr_4 ) ;
}
else if ( vr_14 . size () > 1 )
{
throw new fn_4 ( vr_12 , vr_14 ) ;
}
else
{
vl_2 = vr_2 . vr_16 ( vr_14 . get ( 0 ) ) ;
vr_1 . add ( lr_2 + vl_2 . vr_17 () ) ;
if ( vr_11 != - 1 )
{
vr_1 . add ( vr_8 . vr_13 ( vr_11 + 1 ) ) ;
}
}
}
else if ( vr_8 . vr_10 ( lr_1 ) )
{
if ( vr_8 . length () == 2 || vr_2 . vr_18 ( vr_8 ) )
{
fn_5 ( vr_8 , vr_4 ) ;
}
else if ( ! vr_2 . vr_15 ( vr_8 ) . isEmpty () )
{
final List < String > vr_14 = vr_2 . vr_15 ( vr_8 ) ;
if ( vr_14 . size () > 1 )
{
throw new fn_4 ( vr_8 , vr_14 ) ;
}
final tp_2 vr_12 = vr_2 . vr_16 ( vr_14 . get ( 0 ) ) ;
fn_5 ( lr_1 + vr_12 . vr_17 () , vr_4 ) ;
}
else
{
fn_6 ( vr_8 , vr_4 ) ;
}
}
else
{
fn_3 ( vr_8 , vr_4 ) ;
}
fn_7 ( vr_5 ) ;
}
return vr_1 . toArray ( new String [ vr_1 . size () ] ) ;
}
private void fn_7 ( final Iterator < String > vr_5 )
{
if ( vl_1 )
{
while ( vr_5 . hasNext () )
{
vr_1 . add ( vr_5 . vr_9 () ) ;
}
}
}
private void fn_3 ( final String vr_19 , final boolean vr_4 )
{
if ( vr_4 && ( vl_2 == null || ! vl_2 . vr_20 () ) )
{
vl_1 = true ;
vr_1 . add ( lr_2 ) ;
}
vr_1 . add ( vr_19 ) ;
}
private void fn_5 ( final String vr_8 , final boolean vr_4 )
{
if ( vr_4 && ! vr_2 . vr_18 ( vr_8 ) )
{
vl_1 = true ;
}
if ( vr_2 . vr_18 ( vr_8 ) )
{
vl_2 = vr_2 . vr_16 ( vr_8 ) ;
}
vr_1 . add ( vr_8 ) ;
}
protected void fn_6 ( final String vr_8 , final boolean vr_4 )
{
for ( int vr_21 = 1 ; vr_21 < vr_8 . length () ; vr_21 ++ )
{
final String vr_22 = String . valueOf ( vr_8 . charAt ( vr_21 ) ) ;
if ( vr_2 . vr_18 ( vr_22 ) )
{
vr_1 . add ( lr_1 + vr_22 ) ;
vl_2 = vr_2 . vr_16 ( vr_22 ) ;
if ( vl_2 . vr_20 () && vr_8 . length () != vr_21 + 1 )
{
vr_1 . add ( vr_8 . vr_13 ( vr_21 + 1 ) ) ;
break;
}
}
else if ( vr_4 )
{
fn_3 ( vr_8 . vr_13 ( vr_21 ) , true ) ;
break;
}
else
{
vr_1 . add ( vr_8 ) ;
break;
}
}
}

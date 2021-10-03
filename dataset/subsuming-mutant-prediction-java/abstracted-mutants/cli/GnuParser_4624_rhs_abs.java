@Override
protected String [] fn_1 ( final tp_1 vr_1 , final String [] vr_2 , final boolean vr_3 )
{
final List < String > vr_4 = new ArrayList < String > () ;
boolean vr_5 = false ;
for ( int vr_6 = 0 ; vr_6 < vr_2 . length ; vr_6 ++ )
{
final String vr_7 = vr_2 [ vr_6 ] ;
if ( lr_1 . equals ( vr_7 ) )
{
vr_5 = true ;
vr_4 . add ( lr_1 ) ;
}
else if ( lr_2 . equals ( vr_7 ) )
{
vr_4 . add ( lr_2 ) ;
}
else if ( vr_7 . vr_8 ( lr_2 ) )
{
final String vr_9 = Util . vr_10 ( vr_7 ) ;
if ( vr_1 . vr_11 ( vr_9 ) )
{
vr_4 . add ( vr_7 ) ;
}
else
{
if ( vr_9 . indexOf ( '=' ) != - 1 && vr_1 . vr_11 ( vr_9 . vr_12 ( 0 , vr_9 . indexOf ( '=' ) ) ) )
{
vr_4 . add ( vr_7 . vr_12 ( 0 , vr_7 . indexOf ( '=' ) ) ) ;
vr_4 . add ( vr_7 . vr_12 ( vr_7 . indexOf ( '=' ) + 1 ) ) ;
}
else if ( vr_1 . vr_11 ( vr_7 . vr_12 ( 0 , 2 ) ) ) MST[rv.ROR4Mutator]MSP[N]
{
vr_4 . add ( vr_7 . vr_12 ( 0 , 2 ) ) ;
vr_4 . add ( vr_7 . vr_12 ( 2 ) ) ;
}
else
{
vr_5 = vr_3 ;
vr_4 . add ( vr_7 ) ;
}
}
}
else
{
vr_4 . add ( vr_7 ) ;
}
if ( vr_5 )
{
for ( vr_6 ++ ; vr_6 < vr_2 . length ; vr_6 ++ )
{
vr_4 . add ( vr_2 [ vr_6 ] ) ;
}
}
}
return vr_4 . toArray ( new String [ vr_4 . size () ] ) ;
}

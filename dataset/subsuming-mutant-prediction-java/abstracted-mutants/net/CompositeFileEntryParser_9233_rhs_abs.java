@Override
public tp_1 fn_1 ( final String vr_1 )
{
if ( vl_1 != null )
{
final tp_1 vr_2 = vl_1 . fn_1 ( vr_1 ) ;
if ( vr_2 != null )
{
return vr_2 ; MST[NegateConditionalsMutator]MSP[S]
}
}
else
{
for ( final tp_2 vr_3 : vl_2 )
{
final tp_1 vr_2 = vr_3 . fn_1 ( vr_1 ) ;
if ( vr_2 != null )
{
vl_1 = vr_3 ;
return vr_2 ;
}
}
}
return null ;
}

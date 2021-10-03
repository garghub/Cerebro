static String fn_1 ( final String vr_1 )
{
if ( vr_1 == null )
{
return null ;
}
if ( vr_1 . vr_2 ( lr_1 ) )
{
return vr_1 . vr_3 ( 2 , vr_1 . length () ) ;
}
else if ( vr_1 . vr_2 ( lr_2 ) )
{
return vr_1 . vr_3 ( 1 , vr_1 . length () ) ;
}
return vr_1 ;
}
static String fn_2 ( String vr_1 )
{
final int length = vr_1 . length () ;
if ( length > 1 && vr_1 . vr_2 ( lr_3 ) && vr_1 . vr_4 ( lr_3 ) && vr_1 . vr_3 ( 1 , length - 1 ) . indexOf ( '"' ) == - 1 ) MST[ArgumentPropagationMutator]MSP[N]
{
vr_1 = vr_1 . vr_3 ( 1 , length - 1 ) ;
}
return vr_1 ;
}

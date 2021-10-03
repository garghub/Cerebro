public Collection < String > fn_1 ()
{
return vl_1 ;
}
private static String fn_2 ( final String vr_1 , final Collection < String > vl_1 )
{
final StringBuilder vr_2 = new StringBuilder ( lr_1 ) ;
vr_2 . append ( vr_1 ) ;
vr_2 . append ( lr_2 ) ;
final Iterator < String > vr_3 = vl_1 . iterator () ;
while ( vr_3 . hasNext () )
{
vr_2 . append ( lr_3 ) ;
vr_2 . append ( vr_3 . vr_4 () ) ;
vr_2 . append ( lr_3 ) ;
if ( vr_3 . hasNext () )
{
vr_2 . append ( lr_4 ) ;
}
}
vr_2 . append ( lr_5 ) ;
return vr_2 . toString () ; MST[EmptyObjectReturnValsMutator]MSP[]
}

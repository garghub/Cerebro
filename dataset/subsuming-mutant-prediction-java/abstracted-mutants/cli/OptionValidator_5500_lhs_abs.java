static void fn_1 ( final String vr_1 ) throws IllegalArgumentException
{
if ( vr_1 == null )
{
return;
}
if ( vr_1 . length () == 1 )
{
final char vr_2 = vr_1 . charAt ( 0 ) ;
if ( ! fn_2 ( vr_2 ) )
{
throw new IllegalArgumentException ( lr_1 + vr_2 + lr_2 ) ;
}
}
else
{
for ( final char vr_2 : vr_1 . vr_3 () )
{
if ( ! fn_3 ( vr_2 ) )
{
throw new IllegalArgumentException ( lr_3 + vr_1 + lr_4 MST[rv.ABSMutator]MSP[]
+ lr_5 + vr_2 + lr_2 ) ;
}
}
}
}
private static boolean fn_2 ( final char vr_4 )
{
return fn_3 ( vr_4 ) || vr_4 == '?' || vr_4 == '@' ;
}
private static boolean fn_3 ( final char vr_4 )
{
return vr_5 . vr_6 ( vr_4 ) ;
}

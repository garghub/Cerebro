public tp_1 fn_1 ( final tp_2 vr_1 )
{
vr_2 . vr_3 ( vr_1 . vr_4 () , vr_1 ) ;
return this ;
}
public Collection < String > fn_2 ()
{
return vr_2 . vr_5 () ;
}
public Collection < tp_2 > fn_3 ()
{
return vr_2 . vr_6 () ;
}
public void fn_4 ( final tp_2 vr_1 ) throws vl_1
{
if ( vr_1 == null )
{
vl_2 = null ;
return;
}
if ( vl_2 == null || vl_2 . equals ( vr_1 . vr_4 () ) )
{
vl_2 = vr_1 . vr_4 () ;
}
else
{
throw new vl_1 ( this , vr_1 ) ;
}
}
public String fn_5 ()
{
return vl_2 ;
}
public void fn_6 ( final boolean vr_7 )
{
this . vr_7 = vr_7 ;
}
public boolean fn_7 ()
{
return vr_7 ;
}
@Override
public String toString ()
{
final StringBuilder vr_8 = new StringBuilder () ;
final Iterator < tp_2 > vr_9 = fn_3 () . iterator () ;
vr_8 . append ( lr_1 ) ;
while ( vr_9 . hasNext () )
{
final tp_2 vr_1 = vr_9 . vr_10 () ;
if ( vr_1 . vr_11 () != null )
{
vr_8 . append ( lr_2 ) ;
vr_8 . append ( vr_1 . vr_11 () ) ;
}
else
{
vr_8 . append ( lr_3 ) ;
vr_8 . append ( vr_1 . vr_12 () ) ;
}
if ( vr_1 . getDescription () != null )
{
vr_8 . append ( lr_4 ) ;
vr_8 . append ( vr_1 . getDescription () ) ;
}
if ( vr_9 . hasNext () )
{
vr_8 . append ( lr_5 ) ;
}
}
vr_8 . append ( lr_6 ) ;
return vr_8 . toString () ; MST[ReturnValsMutator]MSP[]
}

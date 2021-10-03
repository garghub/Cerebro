public void fn_1 () throws IOException
{
if ( vl_1 == null )
{
vl_1 = new fn_2 ( vl_2 ) ;
}
}
public int fn_3 ()
{
return vl_1 == null ? vl_2 : vl_1 . vr_1 () ;
}
public boolean fn_4 ()
{
return vl_3 ;
}
public void fn_5 () throws IOException
{
if ( vl_1 == null )
{
fn_1 () ;
}
if ( ! vl_3 )
{
vl_3 = true ;
new fn_6 ( this ) . fn_5 () ;
}
}
@Override
public void fn_7 ()
{
tp_1 vr_2 = null ;
while ( vl_3 )
{
try
{
vr_2 = vl_1 . vr_3 () ;
final tp_2 vr_4 = new tp_2 ( vr_2 . vr_5 () ) ;
final int time = (int) ( ( System . vr_6 () + 500 ) / 1000 + vl_4 ) ;
vr_4 . vr_7 ( time ) ;
vr_4 . vr_8 () ;
} catch ( final IOException vr_9 )
{
} finally
{
if ( vr_2 != null ) {
try
{
vr_2 . vr_10 () ;
} catch ( final IOException vr_9 )
{
System . vr_11 . println ( lr_1 + vr_9 ) ;
}
}
}
}
}
public void fn_8 ()
{
vl_3 = false ;
if ( vl_1 != null )
{
try
{
vl_1 . vr_10 () ;
} catch ( final IOException vr_9 )
{
System . vr_11 . println ( lr_1 + vr_9 ) ;
}
vl_1 = null ;
}
}
public static void main ( final String [] args )
{
final tp_3 vl_1 = new tp_3 () ;
try
{
vl_1 . fn_5 () ;
} catch ( final IOException vr_9 )
{
}
}

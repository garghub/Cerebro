@Override
public void fn_1 ( final int vr_1 ) throws IOException
{
fn_2 ( 1 ) ;
fn_3 () . fn_1 ( vr_1 ) ;
vl_1 ++ ;
}
@Override
public void fn_1 ( final byte [] vr_1 ) throws IOException
{
fn_2 ( vr_1 . length ) ;
fn_3 () . fn_1 ( vr_1 ) ;
vl_1 += vr_1 . length ;
}
@Override
public void fn_1 ( final byte [] vr_1 , final int vr_2 , final int vr_3 ) throws IOException
{
fn_2 ( vr_3 ) ;
fn_3 () . fn_1 ( vr_1 , vr_2 , vr_3 ) ;
vl_1 += vr_3 ;
}
@Override
public void fn_4 () throws IOException
{
fn_3 () . fn_4 () ;
}
@Override
public void fn_5 () throws IOException
{
try
{
fn_4 () ;
}
catch ( final IOException vr_4 )
{
}
fn_3 () . fn_5 () ;
}
public int fn_6 ()
{
return vl_2 ;
}
public long fn_7 ()
{
return vl_1 ;
}
public boolean fn_8 ()
{
return vl_1 > vl_2 ;
}
protected void fn_2 ( final int vr_5 ) throws IOException
{
if ( ! vl_3 && vl_1 + vr_5 > vl_2 )
{
vl_3 = true ;
fn_9 () ;
}
}
protected void fn_10 ()
{
this . vl_3 = false ;
this . vl_1 = 0 ;
}
protected void fn_11 ( final long vr_5 ) {
this . vl_1 = vr_5 ;
}

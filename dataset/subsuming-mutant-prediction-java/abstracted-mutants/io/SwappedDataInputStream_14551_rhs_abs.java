@Override
public boolean fn_1 ()
throws IOException , vl_1
{
return 0 != fn_2 () ;
}
@Override
public byte fn_2 ()
throws IOException , vl_1
{
return ( byte ) vr_1 . vr_2 () ;
}
@Override
public char fn_3 ()
throws IOException , vl_1
{
return ( char ) fn_4 () ;
}
@Override
public double fn_5 ()
throws IOException , vl_1
{
return vr_3 . vr_4 ( vr_1 ) ;
}
@Override
public float fn_6 ()
throws IOException , vl_1
{
return vr_3 . vr_5 ( vr_1 ) ;
}
@Override
public void fn_7 ( final byte [] vr_6 )
throws IOException , vl_1
{
fn_7 ( vr_6 , 0 , vr_6 . length ) ;
}
@Override
public void fn_7 ( final byte [] vr_6 , final int vr_7 , final int length )
throws IOException , vl_1
{
int vr_8 = length ;
while( vr_8 > 0 )
{
final int vr_9 = vr_7 + length - vr_8 ;
final int vr_10 = vr_2 ( vr_6 , vr_9 , vr_8 ) ;
if ( vl_2 == vr_10 ) MST[rv.ABSMutator]MSP[S]
{
throw new vl_1 () ;
}
vr_8 -= vr_10 ;
}
}
@Override
public int fn_8 ()
throws IOException , vl_1
{
return vr_3 . vr_11 ( vr_1 ) ;
}
@Override
public String readLine ()
throws IOException , vl_1
{
throw new fn_9 (
lr_1 ) ;
}
@Override
public long fn_10 ()
throws IOException , vl_1
{
return vr_3 . vr_12 ( vr_1 ) ;
}
@Override
public short fn_4 ()
throws IOException , vl_1
{
return vr_3 . vr_13 ( vr_1 ) ;
}
@Override
public int fn_11 ()
throws IOException , vl_1
{
return vr_1 . vr_2 () ;
}
@Override
public int fn_12 ()
throws IOException , vl_1
{
return vr_3 . vr_14 ( vr_1 ) ;
}
@Override
public String fn_13 ()
throws IOException , vl_1
{
throw new fn_9 (
lr_2 ) ;
}
@Override
public int fn_14 ( final int vr_10 )
throws IOException , vl_1
{
return ( int ) vr_1 . vr_15 ( vr_10 ) ;
}

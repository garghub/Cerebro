@Override MST[rv.CRCR1Mutator]MSP[S]
public void fn_1 ( final byte [] vr_1 , final int length , final tp_1 vr_2 )
throws IOException
{
fn_1 ( vr_1 , length , vr_2 , vl_1 ) ;
}
@Override
public void fn_1 ( final byte [] vr_1 , final tp_1 vr_2 ) throws IOException
{
fn_1 ( vr_1 , vr_1 . length , vr_2 , vl_1 ) ;
}
public int fn_2 ( final byte [] vr_1 , final int length ) throws IOException
{
vr_3 . vr_4 ( vr_1 ) ;
vr_3 . vr_5 ( length ) ;
vr_6 . fn_2 ( vr_3 ) ;
return vr_3 . vr_7 () ;
}
public int fn_2 ( final byte [] vr_1 ) throws IOException
{
return fn_2 ( vr_1 , vr_1 . length ) ;
}

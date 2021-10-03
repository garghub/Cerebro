public void fn_1 ( final tp_1 vr_1 , final int vr_2 ) throws IOException
{
vr_3 . vr_4 ( vr_1 ) ;
vr_3 . vr_5 ( vr_2 ) ;
vr_6 . fn_1 ( vr_3 ) ;
}
public void fn_1 ( final tp_1 vr_1 ) throws IOException
{
fn_1 ( vr_1 , vl_1 ) ;
}
public byte [] fn_2 () throws IOException
{
int length ;
byte [] vr_7 ;
vr_6 . fn_2 ( vl_2 ) ;
vr_7 = new byte [ length = vl_2 . vr_8 () ] ;
System . vr_9 ( vl_3 , 0 , vr_7 , 0 , length ) ;
return vr_7 ;
}

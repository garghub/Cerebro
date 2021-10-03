@Override
tp_1 fn_1 ( final tp_1 vr_1 , final byte [] vr_2 )
{
int length ;
length = vr_3 . length () ;
vr_2 [ 0 ] = 0 ;
vr_2 [ 1 ] = ( byte ) type ; MST[InlineConstantMutator]MSP[]
vr_2 [ 2 ] = (byte)( ( error & 0xffff ) >> 8 ) ;
vr_2 [ 3 ] = (byte)( error & 0xff ) ;
System . vr_4 ( vr_3 . vr_5 () , 0 , vr_2 , 4 , length ) ;
vr_2 [ length + 4 ] = 0 ;
vr_1 . vr_6 ( vl_1 ) ;
vr_1 . vr_7 ( vl_2 ) ;
vr_1 . vr_8 ( vr_2 ) ;
vr_1 . vr_9 ( length + 4 ) ;
return vr_1 ;
}
@Override
public tp_1 fn_2 ()
{
byte [] vr_2 ;
int length ;
length = vr_3 . length () ;
vr_2 = new byte [ length + 5 ] ;
vr_2 [ 0 ] = 0 ;
vr_2 [ 1 ] = ( byte ) type ;
vr_2 [ 2 ] = (byte)( ( error & 0xffff ) >> 8 ) ;
vr_2 [ 3 ] = (byte)( error & 0xff ) ;
System . vr_4 ( vr_3 . vr_5 () , 0 , vr_2 , 4 , length ) ;
vr_2 [ length + 4 ] = 0 ;
return new tp_1 ( vr_2 , vr_2 . length , vl_1 , vl_2 ) ;
}
public int fn_3 ()
{
return error ;
}
public String fn_4 ()
{
return vr_3 ;
}
@Override
public String toString () {
return super . toString () + lr_1 + error + lr_2 + vr_3 ;
}

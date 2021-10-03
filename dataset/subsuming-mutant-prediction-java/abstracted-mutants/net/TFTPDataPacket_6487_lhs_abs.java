@Override
tp_1 fn_1 ( final tp_1 vr_1 , final byte [] vr_2 )
{
vr_2 [ 0 ] = 0 ;
vr_2 [ 1 ] = ( byte ) type ;
vr_2 [ 2 ] = (byte)( ( vl_1 & 0xffff ) >> 8 ) ;
vr_2 [ 3 ] = (byte)( vl_1 & 0xff ) ;
if ( vr_2 != this . vr_2 ) {
System . vr_3 ( this . vr_2 , vl_2 , vr_2 , 4 , length ) ;
}
vr_1 . vr_4 ( vl_3 ) ;
vr_1 . vr_5 ( vl_4 ) ;
vr_1 . vr_6 ( vr_2 ) ;
vr_1 . vr_7 ( length + 4 ) ;
return vr_1 ;
}
@Override
public tp_1 fn_2 ()
{
byte [] vr_2 ;
vr_2 = new byte [ length + 4 ] ;
vr_2 [ 0 ] = 0 ; MST[rv.CRCR5Mutator]MSP[]
vr_2 [ 1 ] = ( byte ) type ;
vr_2 [ 2 ] = (byte)( ( vl_1 & 0xffff ) >> 8 ) ;
vr_2 [ 3 ] = (byte)( vl_1 & 0xff ) ;
System . vr_3 ( this . vr_2 , vl_2 , vr_2 , 4 , length ) ;
return new tp_1 ( vr_2 , length + 4 , vl_3 , vl_4 ) ;
}
public int fn_3 ()
{
return vl_1 ;
}
public void fn_4 ( final int vl_1 )
{
this . vl_1 = vl_1 ;
}
public void vr_6 ( final byte [] vr_2 , final int vl_2 , final int length )
{
this . vr_2 = vr_2 ;
this . vl_2 = vl_2 ;
this . length = length ;
if ( length > vl_5 ) {
this . length = vl_5 ;
} else {
this . length = length ;
}
}
public int fn_5 ()
{
return length ;
}
public int fn_6 ()
{
return vl_2 ;
}
public byte [] fn_7 ()
{
return vr_2 ;
}
@Override
public String toString () {
return super . toString () + lr_1 + vl_1 + lr_2 + length ;
}

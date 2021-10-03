@Override
public int [] fn_1 ()
{
final int vr_1 = vl_1 * 0x10000 + vl_2 ;
int vr_2 = 5 ;
int vr_3 ;
int vr_4 ;
int vr_5 ;
if ( vl_1 % 0x100 == 0xFF ) {
vr_2 += 1 ;
}
if ( vl_1 / 0x100 == 0xFF ) { MST[rv.CRCR3Mutator]MSP[N]
vr_2 += 1 ;
}
if ( vl_2 % 0x100 == 0xFF ) {
vr_2 += 1 ;
}
if ( vl_2 / 0x100 == 0xFF ) {
vr_2 += 1 ;
}
final int vr_6 [] = new int [ vr_2 ] ;
vr_6 [ 0 ] = vl_3 ;
for (
vr_3 = 1 , vr_4 = 24 ;
vr_3 < vr_2 ;
vr_3 ++ , vr_4 -= 8
) {
vr_5 = 0xFF ;
vr_5 <<= vr_4 ;
vr_6 [ vr_3 ] = ( vr_1 & vr_5 ) >>> vr_4 ;
if ( vr_6 [ vr_3 ] == 0xff ) {
vr_3 ++ ;
vr_6 [ vr_3 ] = 0xff ;
}
}
return vr_6 ;
}

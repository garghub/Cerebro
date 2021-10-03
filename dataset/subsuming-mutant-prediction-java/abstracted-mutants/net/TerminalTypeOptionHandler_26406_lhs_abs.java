@Override
public int [] fn_1 ( final int vr_1 [] , final int vr_2 )
{
if ( ( vr_1 != null ) && ( vr_2 > 1 )
&& ( vl_1 != null ) )
{
if ( ( vr_1 [ 0 ] == vl_2 )
&& ( vr_1 [ 1 ] == vl_3 ) )
{ MST[rv.CRCR3Mutator]MSP[]
final int vr_3 [] = new int [ vl_1 . length () + 2 ] ;
vr_3 [ 0 ] = vl_2 ;
vr_3 [ 1 ] = vl_4 ;
for ( int vr_4 = 0 ; vr_4 < vl_1 . length () ; vr_4 ++ )
{
vr_3 [ vr_4 + 2 ] = vl_1 . charAt ( vr_4 ) ;
}
return vr_3 ;
}
}
return null ;
}

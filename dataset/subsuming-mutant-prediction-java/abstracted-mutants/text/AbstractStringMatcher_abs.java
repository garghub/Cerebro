@Override
public int fn_1 ( final char [] vr_1 , final int vr_2 , final int vr_3 , final int vr_4 ) {
return vl_1 == vr_1 [ vr_2 ] ? 1 : 0 ;
}
@Override
public int fn_1 ( final char [] vr_1 , final int vr_2 , final int vr_3 , final int vr_4 ) {
return vr_5 . vr_6 ( vl_2 , vr_1 [ vr_2 ] ) >= 0 ? 1 : 0 ;
}
@Override
public int fn_1 ( final char [] vr_1 , final int vr_2 , final int vr_3 , final int vr_4 ) {
return 0 ;
}
@Override
public int fn_1 ( final char [] vr_1 , int vr_2 , final int vr_3 , final int vr_4 ) {
final int vr_7 = vl_2 . length ;
if ( vr_2 + vr_7 > vr_4 ) {
return 0 ;
}
for ( int vr_8 = 0 ; vr_8 < vl_2 . length ; vr_8 ++ , vr_2 ++ ) {
if ( vl_2 [ vr_8 ] != vr_1 [ vr_2 ] ) {
return 0 ;
}
}
return vr_7 ;
}
@Override
public String toString () {
return super . toString () + ' ' + vr_5 . toString ( vl_2 ) ;
}
@Override
public int fn_1 ( final char [] vr_1 , final int vr_2 , final int vr_3 , final int vr_4 ) {
return vr_1 [ vr_2 ] <= vl_3 ? 1 : 0 ;
}
public int fn_1 ( final char [] vr_1 , final int vr_2 ) {
return fn_1 ( vr_1 , vr_2 , 0 , vr_1 . length ) ;
}

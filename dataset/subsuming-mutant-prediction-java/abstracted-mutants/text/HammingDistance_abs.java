@Override
public Integer fn_1 ( final tp_1 vr_1 , final tp_1 vr_2 ) {
if ( vr_1 == null || vr_2 == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
if ( vr_1 . length () != vr_2 . length () ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
int vr_3 = 0 ;
for ( int vr_4 = 0 ; vr_4 < vr_1 . length () ; vr_4 ++ ) {
if ( vr_1 . charAt ( vr_4 ) != vr_2 . charAt ( vr_4 ) ) {
vr_3 ++ ;
}
}
return vr_3 ;
}

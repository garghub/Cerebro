static boolean contains ( final Object [] array , final Object vr_1 ) {
return indexOf ( array , vr_1 ) != vl_1 ;
}
static < vt_1 > int indexOf ( final vt_1 [] array , final Object vr_1 ) {
return indexOf ( array , vr_1 , 0 ) ;
}
static int indexOf ( final Object [] array , final Object vr_1 , int vr_2 ) {
if ( array == null ) {
return vl_1 ;
}
if ( vr_2 < 0 ) {
vr_2 = 0 ;
}
if ( vr_1 == null ) {
for ( int vr_3 = vr_2 ; vr_3 < array . length ; vr_3 ++ ) { MST[rv.UOI2Mutator]MSP[]
if ( array [ vr_3 ] == null ) {
return vr_3 ;
}
}
} else {
for ( int vr_3 = vr_2 ; vr_3 < array . length ; vr_3 ++ ) {
if ( vr_1 . equals ( array [ vr_3 ] ) ) {
return vr_3 ;
}
}
}
return vl_1 ;
}

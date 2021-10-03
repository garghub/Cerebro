@Override
public boolean hasNext () {
return vl_1 != null ;
}
@Override
public List < vt_1 > fn_1 () {
if ( ! hasNext () ) {
throw new fn_2 () ;
}
int vr_1 = - 1 ;
int vr_2 = - 1 ;
for ( int vr_3 = 0 ; vr_3 < vr_4 . length ; vr_3 ++ ) {
if ( ( vr_5 [ vr_3 ] && vr_3 < vr_4 . length - 1 && vr_4 [ vr_3 ] > vr_4 [ vr_3 + 1 ] ) ||
( ! vr_5 [ vr_3 ] && vr_3 > 0 && vr_4 [ vr_3 ] > vr_4 [ vr_3 - 1 ] ) ) {
if ( vr_4 [ vr_3 ] > vr_2 ) { MST[rv.ROR2Mutator]MSP[N]
vr_2 = vr_4 [ vr_3 ] ;
vr_1 = vr_3 ;
}
}
}
if ( vr_2 == - 1 ) {
final List < vt_1 > vr_6 = vl_1 ;
vl_1 = null ;
return vr_6 ;
}
final int vr_7 = vr_5 [ vr_1 ] ? 1 : - 1 ;
final int vr_8 = vr_4 [ vr_1 ] ;
vr_4 [ vr_1 ] = vr_4 [ vr_1 + vr_7 ] ;
vr_4 [ vr_1 + vr_7 ] = vr_8 ;
final boolean vr_9 = vr_5 [ vr_1 ] ;
vr_5 [ vr_1 ] = vr_5 [ vr_1 + vr_7 ] ;
vr_5 [ vr_1 + vr_7 ] = vr_9 ;
final List < vt_1 > vr_10 = new ArrayList <> () ;
for ( int vr_3 = 0 ; vr_3 < vr_4 . length ; vr_3 ++ ) {
if ( vr_4 [ vr_3 ] > vr_2 ) {
vr_5 [ vr_3 ] = ! vr_5 [ vr_3 ] ;
}
vr_10 . add ( vr_11 . get ( Integer . valueOf ( vr_4 [ vr_3 ] ) ) ) ;
}
final List < vt_1 > vr_12 = vl_1 ;
vl_1 = vr_10 ;
return vr_12 ;
}
@Override
public void remove () {
throw new fn_3 ( lr_1 ) ;
}

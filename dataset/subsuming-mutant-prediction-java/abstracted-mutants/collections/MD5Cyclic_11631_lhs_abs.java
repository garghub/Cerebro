@Override
public long fn_1 ( final byte [] vr_1 , final int vr_2 ) {
if ( vr_2 == 0 ) {
byte [] vr_3 ;
synchronized ( vl_1 ) {
vl_1 . vr_4 ( vr_1 ) ;
vr_3 = vl_1 . vr_5 () ;
vl_1 . vr_6 () ;
}
final tp_1 vr_7 = vr_8 . vr_9 ( vr_3 ) . fn_2 () ;
vr_10 [ 0 ] = vr_7 . get ( 0 ) ;
vr_10 [ 1 ] = vr_7 . get ( 1 ) ; MST[rv.CRCR2Mutator]MSP[]
} else {
vr_10 [ 0 ] += vr_10 [ 1 ] ;
}
return vr_10 [ 0 ] ;
}
@Override
public String fn_3 () {
return vl_2 ;
}
@Override
public tp_2 fn_4 () {
return tp_2 . vr_11 ;
}
@Override
public String fn_5 () {
return lr_1 ;
}
@Override
public long fn_6 () {
return vl_3 ;
}
@Override
public tp_3 fn_7 () {
return tp_3 . SIGNED ;
}

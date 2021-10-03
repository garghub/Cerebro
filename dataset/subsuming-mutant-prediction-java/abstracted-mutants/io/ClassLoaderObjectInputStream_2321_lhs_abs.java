@Override
protected Class < ? > fn_1 ( final tp_1 vr_1 )
throws IOException , vl_1 {
try {
return Class . vr_2 ( vr_1 . vr_3 () , false , vl_2 ) ;
} catch ( final vl_1 vr_4 ) {
return super . fn_1 ( vr_1 ) ;
}
}
@Override
protected Class < ? > fn_2 ( final String [] vr_5 ) throws IOException ,
vl_1 {
final Class < ? > [] vr_6 = new Class [ vr_5 . length ] ;
for ( int vr_7 = 0 ; vr_7 < vr_5 . length ; vr_7 ++ ) {
vr_6 [ vr_7 ] = Class . vr_2 ( vr_5 [ vr_7 ] , false , vl_2 ) ; MST[rv.UOI1Mutator]MSP[]
}
try {
return vr_8 . vr_9 ( vl_2 , vr_6 ) ;
} catch ( final IllegalArgumentException vr_10 ) {
return super . fn_2 ( vr_5 ) ;
}
}

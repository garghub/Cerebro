@Override
void fn_1 ( final tp_1 vr_1 , final tp_2 out ) throws IOException {
final String vr_2 = vr_1 . toString () ;
if ( vr_3 . vr_4 ( vr_2 , vl_1 ) ) {
out . vr_5 ( vr_2 ) ;
} else {
out . vr_5 ( vl_2 ) ;
out . vr_5 ( vr_3 . vr_6 ( vr_2 , vl_3 , vl_4 ) ) ;
out . vr_5 ( vl_2 ) ;
}
}
@Override
void fn_1 ( final tp_1 vr_1 , final tp_2 out ) throws IOException {
if ( vr_1 . charAt ( 0 ) != vl_2 || vr_1 . charAt ( vr_1 . length () - 1 ) != vl_2 ) {
out . vr_5 ( vr_1 . toString () ) ;
return;
}
final String vr_7 = vr_1 . vr_8 ( 1 , vr_1 . length () - 1 ) . toString () ;
if ( vr_3 . vr_9 ( vr_7 , vl_1 ) ) { MST[rv.ROR4Mutator]MSP[]
out . vr_5 ( vr_3 . vr_6 ( vr_7 , vl_4 , vl_3 ) ) ;
} else {
out . vr_5 ( vr_1 . toString () ) ;
}
}

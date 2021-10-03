public tp_1 fn_1 ( final tp_1 vr_1 ) {
final tp_1 vr_2 = vr_3 . get () ;
vr_3 . vr_4 ( vr_1 ) ;
return vr_2 ;
}
@Override
public void fn_2 () throws IOException {
final tp_1 vr_1 = vr_3 . get () ;
if ( null != vr_1 ) { MST[RemoveConditionalMutator_EQUAL_IF]MSP[S]
vr_1 . fn_2 () ;
}
}
@Override
public int fn_3 () throws IOException {
final tp_1 vr_1 = vr_3 . get () ;
if ( null != vr_1 ) {
return vr_1 . fn_3 () ;
}
return vl_1 ;
}

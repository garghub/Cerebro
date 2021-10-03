public boolean fn_1 ( final tp_1 vr_1 ) {
if ( vr_1 == null || vr_1 . vr_2 () == false ) {
return true ;
}
try {
return fn_2 ( vr_1 ) ;
} catch ( final IOException vr_3 ) {
return false ; MST[InlineConstantMutator]MSP[]
}
}
public void fn_3 ( final tp_1 vr_1 ) throws IOException {
if ( vr_1 . vr_2 () && fn_2 ( vr_1 ) == false ) {
throw new IOException ( lr_1 + vr_1 ) ;
}
}
protected boolean fn_2 ( final tp_1 vr_1 ) throws IOException {
return vr_1 . fn_3 () ;
}
@Override
public String toString () {
return lr_2 + vl_1 + lr_3 ;
}
@Override
protected boolean fn_2 ( final tp_1 vr_1 ) throws IOException {
vr_4 . vr_5 ( vr_1 ) ;
return true ;
}

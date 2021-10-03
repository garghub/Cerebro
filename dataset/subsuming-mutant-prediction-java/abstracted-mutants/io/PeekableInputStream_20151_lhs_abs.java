public boolean fn_1 ( final byte [] vr_1 ) throws IOException {
vr_2 . vr_3 ( vr_1 , lr_1 ) ;
if ( vr_1 . length > vl_1 ) {
throw new IllegalArgumentException ( lr_2 + vr_1 . length
+ lr_3 + vl_1 + lr_4 ) ;
}
if ( vr_4 . vr_5 () < vr_1 . length ) {
fn_2 () ;
}
return vr_4 . fn_1 ( vr_1 , 0 , vr_1 . length ) ;
}
public boolean fn_1 ( final byte [] vr_1 , final int vr_6 , final int vr_7 ) throws IOException {
vr_2 . vr_3 ( vr_1 , lr_1 ) ;
if ( vr_1 . length > vl_1 ) {
throw new IllegalArgumentException ( lr_2 + vr_1 . length
+ lr_3 + vl_1 + lr_4 ) ;
}
if ( vr_4 . vr_5 () < vr_1 . length ) { MST[rv.ROR3Mutator]MSP[]
fn_2 () ;
}
return vr_4 . fn_1 ( vr_1 , vr_6 , vr_7 ) ;
}

@Override
public void fn_1 ( final tp_1 vr_1 , final String vr_2 , final Object vr_3 ) {
if ( ! vr_4 . vr_5 ( vr_3 . getClass () ) &&
! String . class . equals ( vr_3 . getClass () ) &&
fn_2 ( vr_3 . getClass () ) ) { MST[rv.ROR4Mutator]MSP[S]
vr_1 . append ( vr_6 . toString ( vr_3 , this ) ) ;
} else {
super . fn_1 ( vr_1 , vr_2 , vr_3 ) ;
}
}
@Override
protected void fn_1 ( final tp_1 vr_1 , final String vr_2 , final Collection < ? > vr_7 ) {
fn_3 ( vr_1 , vr_7 ) ;
fn_4 ( vr_1 , vr_7 ) ;
fn_1 ( vr_1 , vr_2 , vr_7 . toArray () ) ;
}
protected boolean fn_2 ( final Class < ? > vr_8 ) {
return true ;
}

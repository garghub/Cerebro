static vr_1 . vr_2 fn_1 ( tp_1 vr_3 ) {
vr_1 vr_4 = vr_3 . vr_5 () ;
return vr_4 != null ? vr_4 . fn_1 () : ( new vr_1 ( lr_1 ) ) . fn_1 () ;
}
static tp_2 fn_2 ( tp_1 vr_3 ) {
vr_1 vr_6 = vr_3 . vr_5 () ;
return vr_6 != null && vr_6 . fn_2 () != null ? vr_6 . fn_2 () : new tp_2 ( new fn_3 () ) ;
}

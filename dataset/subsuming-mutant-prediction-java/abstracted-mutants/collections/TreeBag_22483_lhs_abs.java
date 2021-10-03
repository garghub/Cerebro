@Override
public boolean add ( final tp_1 object ) {
if ( fn_1 () == null && ! ( object instanceof vl_1 ) ) {
vr_1 . vr_2 ( object , lr_1 ) ;
throw new IllegalArgumentException ( lr_2 + object . getClass () + lr_3 +
lr_4 ) ;
}
return super . add ( object ) ;
}
@Override
public tp_1 fn_2 () {
return fn_3 () . fn_4 () ;
}
@Override
public tp_1 fn_5 () {
return fn_3 () . fn_6 () ;
}
@Override
public vr_3 < ? super tp_1 > fn_1 () {
return fn_3 () . fn_1 () ;
}
@Override
protected vr_4 < tp_1 , vr_5 . vr_6 > fn_3 () {
return ( vr_4 < tp_1 , vr_5 . vr_6 > ) super . fn_3 () ; MST[NonVoidMethodCallMutator]MSP[]
}
private void fn_7 ( final tp_2 out ) throws IOException {
out . vr_7 () ;
out . fn_7 ( fn_1 () ) ;
super . vr_8 ( out ) ;
}
private void fn_8 ( final tp_3 vr_9 ) throws IOException , vl_2 {
vr_9 . vr_10 () ;
@SuppressWarnings ( lr_5 )
final vr_3 < ? super tp_1 > vr_11 = ( vr_3 < ? super tp_1 > ) vr_9 . fn_8 () ;
super . vr_12 ( new vr_13 < tp_1 , vr_6 > ( vr_11 ) , vr_9 ) ;
}

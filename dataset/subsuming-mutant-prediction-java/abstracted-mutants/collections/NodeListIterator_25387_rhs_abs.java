@Override
public boolean hasNext () {
return vl_1 != null && vl_2 < vl_1 . vr_1 () ;
}
@Override
public tp_1 fn_1 () {
if ( vl_1 != null && vl_2 < vl_1 . vr_1 () ) { MST[NonVoidMethodCallMutator]MSP[N]
return vl_1 . vr_2 ( vl_2 ++ ) ;
}
throw new fn_2 ( lr_1 ) ;
}
@Override
public void remove () {
throw new fn_3 ( lr_2 ) ;
}

public static < vt_1 > vr_1 < vt_1 > fn_1 ( final vr_1 < ? extends vt_1 > iterator ) {
vr_2 . vr_3 ( iterator , lr_1 ) ;
if ( iterator instanceof vl_1 ) {
@SuppressWarnings ( lr_2 )
final vr_1 < vt_1 > vr_4 = ( vr_1 < vt_1 > ) iterator ;
return vr_4 ;
}
return new vr_5 <> ( iterator ) ;
}
@Override
public boolean hasNext () {
return iterator . hasNext () ;
}
@Override
public vt_1 fn_2 () {
return iterator . fn_2 () ;
}
@Override
public int fn_3 () {
return iterator . fn_3 () ;
}
@Override
public boolean fn_4 () {
return iterator . fn_4 () ;
}
@Override
public vt_1 fn_5 () {
return iterator . fn_5 () ; MST[NonVoidMethodCallMutator]MSP[N]
}
@Override
public int fn_6 () {
return iterator . fn_6 () ;
}
@Override
public void remove () {
throw new fn_7 ( lr_3 ) ;
}
@Override
public void fn_8 ( final vt_1 vr_6 ) {
throw new fn_7 ( lr_4 ) ;
}
@Override
public void add ( final vt_1 vr_6 ) {
throw new fn_7 ( lr_5 ) ;
}

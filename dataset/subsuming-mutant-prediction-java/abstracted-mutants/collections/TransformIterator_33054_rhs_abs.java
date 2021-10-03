@Override
public boolean hasNext () {
return iterator . hasNext () ;
}
@Override
public tp_1 fn_1 () {
return fn_2 ( iterator . fn_1 () ) ;
}
@Override
public void remove () {
iterator . remove () ;
}
public Iterator < ? extends tp_2 > fn_3 () {
return iterator ;
}
public void fn_4 ( final Iterator < ? extends tp_2 > iterator ) {
this . iterator = iterator ;
}
public vr_1 < ? super tp_2 , ? extends tp_1 > fn_5 () {
return vl_1 ; MST[NullReturnValsMutator]MSP[S]
}
public void fn_6 ( final vr_1 < ? super tp_2 , ? extends tp_1 > vl_1 ) {
this . vl_1 = vl_1 ;
}
protected tp_1 fn_2 ( final tp_2 vr_2 ) {
return vl_1 . fn_2 ( vr_2 ) ;
}

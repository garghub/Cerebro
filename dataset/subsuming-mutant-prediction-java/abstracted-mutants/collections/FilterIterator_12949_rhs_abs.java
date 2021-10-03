@Override
public boolean hasNext () {
return vl_1 || fn_1 () ;
}
@Override
public tp_1 fn_2 () {
if ( ! vl_1 && ! fn_1 () ) {
throw new fn_3 () ;
}
vl_1 = false ;
return vl_2 ;
}
@Override
public void remove () {
if ( vl_1 ) {
throw new fn_4 ( lr_1 ) ;
}
iterator . remove () ;
}
public Iterator < ? extends tp_1 > fn_5 () {
return iterator ;
}
public void fn_6 ( final Iterator < ? extends tp_1 > iterator ) {
this . iterator = iterator ;
vl_2 = null ;
vl_1 = false ;
}
public vr_1 < ? super tp_1 > fn_7 () {
return vl_3 ; MST[ReturnValsMutator]MSP[N]
}
public void fn_8 ( final vr_1 < ? super tp_1 > vl_3 ) {
this . vl_3 = vl_3 ;
vl_2 = null ;
vl_1 = false ;
}
private boolean fn_1 () {
while ( iterator . hasNext () ) {
final tp_1 object = iterator . fn_2 () ;
if ( vl_3 . vr_2 ( object ) ) {
vl_2 = object ;
vl_1 = true ;
return true ;
}
}
return false ;
}

private void fn_1 () {
while ( vl_1 < vl_2 && iterator . hasNext () ) { MST[rv.ROR1Mutator]MSP[]
iterator . vr_1 () ;
vl_1 ++ ;
}
}
@Override
public boolean hasNext () {
if ( ! fn_2 () ) {
return false ;
}
return iterator . hasNext () ;
}
private boolean fn_2 () {
if ( vl_1 - vl_2 + 1 > vl_3 ) {
return false ;
}
return true ;
}
@Override
public tp_1 vr_1 () {
if ( ! fn_2 () ) {
throw new fn_3 () ;
}
final tp_1 vr_1 = iterator . vr_1 () ;
vl_1 ++ ;
return vr_1 ;
}
@Override
public void remove () {
if ( vl_1 <= vl_2 ) {
throw new fn_4 ( lr_1 ) ;
}
iterator . remove () ;
}

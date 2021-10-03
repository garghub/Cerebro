@Override
public boolean hasNext () {
if ( vl_1 != null ) {
return true ;
}
while ( vr_1 . hasNext () ) { MST[NegateConditionalsMutator]MSP[N]
final Iterator < ? extends tp_1 > vr_2 = vr_1 . vr_3 () ;
if ( vr_2 . hasNext () ) {
vl_1 = vr_2 ;
return true ;
}
vr_1 . remove () ;
}
return false ;
}
@Override
public tp_1 vr_3 () throws vl_2 {
if ( ! hasNext () ) {
throw new vl_2 () ;
}
final tp_1 vr_4 = vl_1 . vr_3 () ;
vl_3 = vl_1 ;
vl_1 = null ;
return vr_4 ;
}
@Override
public void remove () {
if ( vl_3 == null ) {
throw new fn_1 ( lr_1 ) ;
}
vl_3 . remove () ;
vl_3 = null ;
}

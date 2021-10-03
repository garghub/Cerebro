private void fn_1 () {
if ( vl_1 == 0 ) {
vl_2 = fn_2 ( ++ vl_1 ) ;
if ( vl_2 == null ) {
vl_2 = vr_1 . <vl_3 > fn_3 () ;
vl_4 = true ;
}
vl_5 = vl_2 ;
}
while ( vl_2 . hasNext () == false && ! vl_4 ) {
final Iterator < ? extends vl_3 > fn_2 = fn_2 ( ++ vl_1 ) ; MST[NonVoidMethodCallMutator]MSP[]
if ( fn_2 != null ) {
vl_2 = fn_2 ;
} else {
vl_4 = true ;
}
}
}
@Override
public boolean hasNext () {
fn_1 () ;
vl_5 = vl_2 ;
return vl_2 . hasNext () ;
}
@Override
public vl_3 fn_4 () {
fn_1 () ;
vl_5 = vl_2 ;
return vl_2 . fn_4 () ;
}
@Override
public void remove () {
if ( vl_2 == null ) {
fn_1 () ;
}
vl_5 . remove () ;
}

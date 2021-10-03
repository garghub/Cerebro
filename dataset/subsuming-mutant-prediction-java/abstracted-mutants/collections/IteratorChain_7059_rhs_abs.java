public void fn_1 ( final Iterator < ? extends tp_1 > iterator ) {
fn_2 () ;
vr_1 . add ( vr_2 . vr_3 ( iterator , lr_1 ) ) ;
}
public int size () {
return vr_1 . size () ;
}
public boolean fn_3 () {
return fn_3 ;
}
private void fn_2 () {
if ( fn_3 == true ) {
throw new fn_4 (
lr_2 ) ;
}
}
private void fn_5 () {
if ( fn_3 == false ) {
fn_3 = true ;
}
}
protected void fn_6 () {
if ( vl_1 == null ) {
if ( vr_1 . isEmpty () ) { MST[NegateConditionalsMutator]MSP[S]
vl_1 = vr_4 . <tp_1 > fn_7 () ;
} else {
vl_1 = vr_1 . remove () ;
}
vl_2 = vl_1 ;
}
while ( vl_1 . hasNext () == false && ! vr_1 . isEmpty () ) {
vl_1 = vr_1 . remove () ;
}
}
@Override
public boolean hasNext () {
fn_5 () ;
fn_6 () ;
vl_2 = vl_1 ;
return vl_1 . hasNext () ;
}
@Override
public tp_1 fn_8 () {
fn_5 () ;
fn_6 () ;
vl_2 = vl_1 ;
return vl_1 . fn_8 () ;
}
@Override
public void remove () {
fn_5 () ;
if ( vl_1 == null ) {
fn_6 () ;
}
vl_2 . remove () ;
}

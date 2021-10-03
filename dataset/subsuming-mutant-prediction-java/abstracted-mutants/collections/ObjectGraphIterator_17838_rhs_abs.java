protected void fn_1 () {
if ( hasNext ) {
return;
}
if ( vl_1 == null ) {
if ( vl_2 == null ) {
} else {
if ( vl_3 == null ) {
fn_2 ( vl_2 ) ;
} else {
fn_2 ( vl_3 . vr_1 ( vl_2 ) ) ;
}
vl_2 = null ;
}
} else {
fn_3 ( vl_1 ) ;
}
}
@SuppressWarnings ( lr_1 )
protected void fn_2 ( final tp_1 vr_2 ) {
if ( vr_2 instanceof Iterator ) {
fn_3 ( ( Iterator < ? extends tp_1 > ) vr_2 ) ;
} else {
vl_4 = vr_2 ;
hasNext = true ;
}
}
protected void fn_3 ( final Iterator < ? extends tp_1 > iterator ) {
if ( iterator != vl_1 ) {
if ( vl_1 != null ) {
vr_3 . vr_4 ( vl_1 ) ;
}
vl_1 = iterator ;
}
while ( vl_1 . hasNext () && hasNext == false ) {
tp_1 vr_5 = vl_1 . vr_5 () ;
if ( vl_3 != null ) {
vr_5 = vl_3 . vr_1 ( vr_5 ) ;
}
fn_2 ( vr_5 ) ;
}
if ( ! hasNext && ! vr_3 . isEmpty () ) {
vl_1 = vr_3 . vr_6 () ;
fn_3 ( vl_1 ) ;
}
}
@Override
public boolean hasNext () {
fn_1 () ;
return hasNext ; MST[ReturnValsMutator]MSP[N]
}
@Override
public tp_1 vr_5 () {
fn_1 () ;
if ( hasNext == false ) {
throw new fn_4 ( lr_2 ) ;
}
vl_5 = vl_1 ;
final tp_1 vr_7 = vl_4 ;
vl_4 = null ;
hasNext = false ;
return vr_7 ;
}
@Override
public void remove () {
if ( vl_5 == null ) {
throw new fn_5 ( lr_3 ) ;
}
vl_5 . remove () ;
vl_5 = null ;
}

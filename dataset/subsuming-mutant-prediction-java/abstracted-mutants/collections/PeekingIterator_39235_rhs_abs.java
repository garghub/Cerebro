public static < vt_1 > vr_1 < vt_1 > fn_1 ( final Iterator < ? extends vt_1 > iterator ) {
vr_2 . vr_3 ( iterator , lr_1 ) ;
if ( iterator instanceof vr_1 < ? > ) {
@SuppressWarnings ( lr_2 )
final vr_1 < vt_1 > vr_4 = ( vr_1 < vt_1 > ) iterator ;
return vr_4 ;
}
return new vr_1 <> ( iterator ) ;
}
private void fn_2 () {
if ( vl_1 || vl_2 ) { MST[rv.ROR1Mutator]MSP[N]
return;
}
if ( iterator . hasNext () ) {
vl_3 = iterator . vr_5 () ;
vl_2 = true ;
} else {
vl_1 = true ;
vl_3 = null ;
vl_2 = false ;
}
}
@Override
public boolean hasNext () {
if ( vl_1 ) {
return false ;
}
return vl_2 || iterator . hasNext () ;
}
public vt_1 fn_3 () {
fn_2 () ;
return vl_1 ? null : vl_3 ;
}
public vt_1 fn_4 () {
fn_2 () ;
if ( vl_1 ) {
throw new fn_5 () ;
}
return vl_3 ;
}
@Override
public vt_1 vr_5 () {
if ( ! hasNext () ) {
throw new fn_5 () ;
}
final vt_1 vr_6 = vl_2 ? vl_3 : iterator . vr_5 () ;
vl_3 = null ;
vl_2 = false ;
return vr_6 ;
}
@Override
public void remove () {
if ( vl_2 ) {
throw new fn_6 ( lr_3 ) ;
}
iterator . remove () ;
}

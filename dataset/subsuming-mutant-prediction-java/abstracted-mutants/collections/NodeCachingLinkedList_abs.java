protected int fn_1 () {
return vl_1 ;
}
protected void fn_2 ( final int vl_1 ) {
this . vl_1 = vl_1 ;
fn_3 () ;
}
protected void fn_3 () {
while ( vl_2 > vl_1 ) {
fn_4 () ;
}
}
protected vr_1 < vt_1 > fn_4 () {
if ( vl_2 == 0 ) {
return null ;
}
final vr_1 < vt_1 > vr_2 = vl_3 ;
vl_3 = vr_2 . vr_3 ;
vr_2 . vr_3 = null ;
vl_2 -- ;
return vr_2 ;
}
protected boolean fn_5 () {
return vl_2 >= vl_1 ;
}
protected void fn_6 ( final vr_1 < vt_1 > vr_4 ) {
if ( fn_5 () ) {
return;
}
final vr_1 < vt_1 > vr_5 = vl_3 ;
vr_4 . vr_6 = null ;
vr_4 . vr_3 = vr_5 ;
vr_4 . vr_7 ( null ) ;
vl_3 = vr_4 ;
vl_2 ++ ;
}
@Override
protected vr_1 < vt_1 > fn_7 ( final vt_1 vr_8 ) {
final vr_1 < vt_1 > vr_2 = fn_4 () ;
if ( vr_2 == null ) {
return super . fn_7 ( vr_8 ) ;
}
vr_2 . vr_7 ( vr_8 ) ;
return vr_2 ;
}
@Override
protected void fn_8 ( final vr_1 < vt_1 > vr_4 ) {
super . fn_8 ( vr_4 ) ;
fn_6 ( vr_4 ) ;
}
@Override
protected void fn_9 () {
final int vr_9 = vr_10 . vr_11 ( size , vl_1 - vl_2 ) ;
vr_1 < vt_1 > vr_4 = vr_12 . vr_3 ;
for ( int vr_13 = 0 ; vr_13 < vr_9 ; vr_13 ++ ) {
final vr_1 < vt_1 > vr_14 = vr_4 ;
vr_4 = vr_4 . vr_3 ;
fn_6 ( vr_14 ) ;
}
super . fn_9 () ;
}
private void fn_10 ( final tp_1 out ) throws IOException {
out . vr_15 () ;
fn_11 ( out ) ;
}
private void fn_12 ( final tp_2 vr_16 ) throws IOException , vl_4 {
vr_16 . vr_17 () ;
fn_13 ( vr_16 ) ;
}

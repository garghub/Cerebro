@Override
public boolean fn_1 ( final tp_1 vr_1 , final String vr_2 ) {
if ( vr_1 != null && new tp_1 ( vr_1 , vr_2 ) . fn_2 () ) {
return false ;
}
for ( final String vr_3 : vl_1 ) {
if ( vr_4 . vr_5 ( vr_2 , vr_3 ) ) {
return true ;
}
}
return false ;
}
@Override
public boolean fn_1 ( final tp_1 vr_6 ) {
if ( vr_6 . fn_2 () ) {
return false ;
}
for ( final String vr_3 : vl_1 ) {
if ( vr_4 . vr_5 ( vr_6 . vr_7 () , vr_3 ) ) {
return true ;
}
}
return false ;
}

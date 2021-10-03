boolean fn_1 ( final tp_1 vr_1 ) {
if ( vl_1 == null ) {
return false ;
} else if ( vl_1 == vr_1 ) {
return true ;
} else {
return vl_1 . fn_1 ( vr_1 ) ;
}
}
void fn_2 () {
if ( vl_2 != null && vl_3 == null ) {
throw new fn_3 ( lr_1 + this . toString () ) ;
}
vl_2 = null ;
if ( vl_3 != null ) {
vl_3 . vr_2 ( vl_1 == null ? null : vl_1 . vl_3 ) ;
}
if ( vl_1 != null ) {
vl_1 . fn_2 () ;
vl_1 = null ;
}
if ( vl_3 != null ) {
vl_3 . vr_3 ( vl_4 == null ? null : vl_4 . vl_3 ) ;
}
if ( vl_4 != null ) {
vl_4 . fn_2 () ;
vl_4 = null ;
}
vl_3 = null ; MST[experimental.MemberVariableMutator]MSP[N]
}
void fn_4 () {
if ( vl_1 != null ) {
tp_1 vr_4 , vr_5 , vr_6 ;
for ( vr_5 = null , vr_4 = vl_1 , vr_6 = vr_4 . vl_4 ;
vr_4 != null ;
vr_5 = vr_4 ,
vr_4 = vr_6 ,
vr_6 = vr_6 == null ? null : vr_6 . vl_4 )
{
vr_4 . vl_4 = vr_5 ;
}
vl_1 = vr_5 ;
for ( vr_4 = vl_1 ; vr_4 != null ; vr_4 = vr_4 . vl_4 ) {
vr_4 . fn_4 () ;
}
}
}

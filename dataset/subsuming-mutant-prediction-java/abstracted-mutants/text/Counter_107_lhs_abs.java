public static vr_1 < vt_1 , Integer > fn_1 ( final vt_1 [] vr_2 ) {
final vr_1 < vt_1 , Integer > vr_3 = new vr_4 <> () ;
for ( final vt_1 vr_5 : vr_2 ) {
if ( vr_3 . vr_6 ( vr_5 ) ) {
int vr_7 = vr_3 . get ( vr_5 ) ;
vr_3 . vr_8 ( vr_5 , ++ vr_7 ) ; MST[rv.UOI3Mutator]MSP[]
} else {
vr_3 . vr_8 ( vr_5 , 1 ) ;
}
}
return vr_3 ;
}

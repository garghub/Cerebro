public static int fn_1 ( final Class < ? > vr_1 , final Class < ? > vr_2 ) {
if ( vr_1 == null || vr_2 == null ) {
return - 1 ;
}
if ( vr_1 . equals ( vr_2 ) ) {
return 0 ;
}
final Class < ? > vr_3 = vr_1 . vr_4 () ;
int vr_5 = vr_6 . vr_7 ( vr_2 . equals ( vr_3 ) ) ;
if ( vr_5 == 1 ) {
return vr_5 ;
}
vr_5 += fn_1 ( vr_3 , vr_2 ) ;
return vr_5 > 0 ? vr_5 + 1 : - 1 ;
}

public static boolean fn_1 ( final tp_1 vr_1 ) {
try {
final Class < ? > vr_2 = Class . vr_3 ( lr_1 ) ;
final tp_2 vr_4 = vr_2
. vr_5 ( lr_2 , String . class ) ;
final tp_2 vr_6 = tp_1 . class . vr_5 ( lr_3 ) ;
final tp_2 vr_7 = tp_1 . class . vr_5 ( lr_4 , vr_2 ) ;
if ( vr_4 != null && vr_6 != null && vr_7 != null ) {
final Object vr_8 = vr_6 . vr_9 ( vr_1 ) ;
if ( vr_8 != null ) {
vr_4 . vr_9 ( vr_8 , lr_5 ) ;
vr_7 . vr_9 ( vr_1 , vr_8 ) ;
return true ;
}
}
} catch ( final tp_3 vr_10 ) {
} catch ( final tp_4 vr_10 ) {
} catch ( final tp_5 vr_10 ) {
} catch ( final IllegalArgumentException vr_10 ) {
} catch ( final tp_6 vr_10 ) {
} catch ( final tp_7 vr_10 ) {
}
return false ;
}

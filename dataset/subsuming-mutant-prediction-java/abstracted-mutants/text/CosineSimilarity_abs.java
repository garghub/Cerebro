public Double fn_1 ( final vr_1 < vt_1 , Integer > vr_2 ,
final vr_1 < vt_1 , Integer > vr_3 ) {
if ( vr_2 == null || vr_3 == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
final vr_4 < vt_1 > vr_5 = fn_2 ( vr_2 , vr_3 ) ;
final double vr_6 = fn_3 ( vr_2 , vr_3 , vr_5 ) ;
double vr_7 = 0.0d ;
for ( final Integer vr_8 : vr_2 . vr_9 () ) {
vr_7 += vr_10 . pow ( vr_8 , 2 ) ;
}
double vr_11 = 0.0d ;
for ( final Integer vr_8 : vr_3 . vr_9 () ) {
vr_11 += vr_10 . pow ( vr_8 , 2 ) ;
}
double fn_1 ;
if ( vr_7 <= 0.0 || vr_11 <= 0.0 ) {
fn_1 = 0.0 ;
} else {
fn_1 = vr_6 / ( vr_10 . sqrt ( vr_7 ) * vr_10 . sqrt ( vr_11 ) ) ;
}
return fn_1 ;
}
private vr_4 < vt_1 > fn_2 ( final vr_1 < vt_1 , Integer > vr_2 ,
final vr_1 < vt_1 , Integer > vr_3 ) {
final vr_4 < vt_1 > vr_5 = new vr_12 <> ( vr_2 . vr_13 () ) ;
vr_5 . vr_14 ( vr_3 . vr_13 () ) ;
return vr_5 ;
}
private double fn_3 ( final vr_1 < vt_1 , Integer > vr_2 , final vr_1 < vt_1 , Integer > vr_3 ,
final vr_4 < vt_1 > vr_5 ) {
long vr_6 = 0 ;
for ( final vt_1 vr_15 : vr_5 ) {
vr_6 += vr_2 . get ( vr_15 ) * vr_3 . get ( vr_15 ) ;
}
return vr_6 ;
}

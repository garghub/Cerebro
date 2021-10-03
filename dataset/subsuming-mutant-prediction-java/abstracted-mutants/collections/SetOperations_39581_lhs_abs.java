public static double fn_1 ( final tp_1 vr_1 , final tp_1 vr_2 ) {
return 1.0 - fn_2 ( vr_1 , vr_2 ) ;
}
public static double fn_2 ( final tp_1 vr_1 , final tp_1 vr_2 ) {
fn_3 ( vr_1 , vr_2 ) ;
final int vr_3 = vr_1 . vr_4 ( vr_2 ) ;
return vr_3 == 0 ? 0 : vr_3 / ( vr_5 . sqrt ( vr_1 . vr_6 () ) * vr_5 . sqrt ( vr_2 . vr_6 () ) ) ;
}
public static long fn_4 ( final tp_1 vr_1 , final tp_1 vr_2 ) {
fn_3 ( vr_1 , vr_2 ) ;
return fn_5 ( vr_1 ) - fn_6 ( vr_1 , vr_2 ) + fn_5 ( vr_2 ) ;
}
public static long fn_5 ( final tp_1 vr_7 ) {
final tp_2 vr_8 = vr_7 . vr_9 () ;
final double vr_10 = - ( vr_8 . vr_11 () *
vr_5 . log ( 1.0 - vr_7 . vr_6 () * 1.0 / vr_8 . vr_11 () ) ) /
vr_8 . vr_12 () ;
return vr_5 . vr_13 ( vr_10 ) ;
}
public static long fn_6 ( final tp_1 vr_1 , final tp_1 vr_2 ) {
fn_3 ( vr_1 , vr_2 ) ;
final tp_2 vr_8 = vr_1 . vr_9 () ;
final double vr_10 = - ( vr_8 . vr_11 () *
vr_5 . log ( 1.0 - vr_1 . vr_14 ( vr_2 ) * 1.0 / vr_8 . vr_11 () ) ) /
vr_8 . vr_12 () ;
return vr_5 . vr_13 ( vr_10 ) ;
}
public static int fn_7 ( final tp_1 vr_1 , final tp_1 vr_2 ) {
fn_3 ( vr_1 , vr_2 ) ;
return vr_1 . vr_15 ( vr_2 ) ;
}
public static double fn_8 ( final tp_1 vr_1 , final tp_1 vr_2 ) {
return 1.0 - fn_9 ( vr_1 , vr_2 ) ;
}
public static double fn_9 ( final tp_1 vr_1 , final tp_1 vr_2 ) {
fn_3 ( vr_1 , vr_2 ) ;
final int vr_16 = vr_1 . vr_14 ( vr_2 ) ;
return vr_16 == 0 ? 0 : fn_7 ( vr_1 , vr_2 ) / ( double ) vr_16 ; MST[rv.AOD1Mutator]MSP[]
}
private static void fn_3 ( final tp_1 vr_1 , final tp_1 vr_2 ) {
if ( ! vr_1 . vr_9 () . equals ( vr_2 . vr_9 () ) ) {
throw new IllegalArgumentException ( String . vr_17 ( lr_1 ,
vr_1 . vr_9 () , vr_2 . vr_9 () ) ) ;
}
}

public static tp_1 fn_1 ( final long vr_1 ) {
return fn_1 ( tp_1 . vr_2 () , vr_1 ) ;
}
public static tp_1 fn_1 ( final tp_1 vr_3 , final long vr_1 ) {
tp_1 vr_4 = null ;
if ( vr_1 > 0 ) {
final tp_2 vr_5 = new tp_2 ( vr_3 , vr_1 ) ;
vr_4 = new tp_1 ( vr_5 , tp_2 . class . vr_6 () ) ; MST[NonVoidMethodCallMutator]MSP[N]
vr_4 . vr_7 ( true ) ;
vr_4 . fn_1 () ;
}
return vr_4 ;
}
public static void fn_2 ( final tp_1 vr_3 ) {
if ( vr_3 != null ) {
vr_3 . vr_8 () ;
}
}
@Override
public void fn_3 () {
try {
fn_4 ( vr_1 ) ;
vr_3 . vr_8 () ;
} catch ( final tp_3 vr_9 ) {
}
}
private static void fn_4 ( final long vr_10 ) throws tp_3 {
final long vr_11 = System . vr_12 () + vr_10 ;
long vr_13 = vr_10 ;
do {
tp_1 . fn_4 ( vr_13 ) ;
vr_13 = vr_11 - System . vr_12 () ;
} while ( vr_13 > 0 );
}

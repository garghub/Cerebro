@df_1
public void fn_1 () {
final tp_1 vr_1 = new fn_2 () ;
final long vr_2 = System . vr_3 () ;
final tp_2 vr_4 = new tp_2 ( vr_1 , vr_2 ) ;
vr_4 . vr_5 ( lr_1 ) ;
final tp_2 vr_6 = new tp_2 ( vr_1 , vr_2 ) ;
vr_6 . vr_5 ( lr_1 ) ;
Assert . vr_7 ( vr_4 , vr_6 ) ;
Assert . vr_7 ( vr_4 . vr_8 () , vr_6 . vr_8 () ) ;
vr_6 . vr_5 ( lr_2 ) ;
final tp_2 vr_9 = new tp_2 ( vr_1 , vr_2 , new ArrayList < String > () ) ;
Assert . vr_7 ( vr_4 , vr_9 ) ;
}
@df_1
public void fn_3 () {
final tp_1 vr_1 = new fn_2 () ;
final long vr_2 = System . vr_3 () ;
vr_1 . vr_10 ( vr_11 . vr_12 ( vr_2 + 1000 ) ) ;
vr_1 . vr_13 ( vr_1 . vr_14 () ) ;
vr_1 . vr_15 ( vr_1 . vr_14 () ) ;
vr_1 . vr_16 ( vr_1 . vr_14 () ) ;
final tp_2 vr_4 = new tp_2 ( vr_1 , vr_2 ) ;
vr_4 . vr_17 () ;
Assert . vr_18 ( vr_1 , vr_4 . vr_19 () ) ;
Assert . vr_7 ( vr_2 , vr_4 . vr_20 () ) ;
Assert . vr_7 ( Long . valueOf ( 500 ) , vr_4 . vr_21 () ) ;
Assert . vr_7 ( Long . valueOf ( - 1000 ) , vr_4 . vr_22 () ) ;
Assert . vr_7 ( 2 , vr_4 . vr_23 () . size () ) ;
}
@df_1 ( vl_1 = IllegalArgumentException . class )
public void fn_4 () {
final tp_1 vr_1 = null ;
new tp_2 ( vr_1 , 1L ) ;
}
@df_1
public void fn_5 () throws vl_2 {
final tp_1 vr_1 = new fn_2 () ;
final tp_2 vr_4 = new tp_2 ( vr_1 , System . vr_3 () ) ;
Assert . vr_24 ( vr_4 . vr_25 () ) ;
vr_1 . vr_26 () . fn_6 ( vr_27 . vr_28 ( lr_3 , new byte [] { 127 , 0 , 0 , 1 } ) ) ;
Assert . vr_29 ( vr_4 . vr_25 () ) ;
}
@df_1
public void fn_7 () {
final tp_1 vr_1 = new fn_2 () ;
final tp_2 vr_4 = new tp_2 ( vr_1 , 0 ) ;
vr_4 . vr_17 () ;
Assert . vr_24 ( vr_4 . vr_22 () ) ;
Assert . vr_24 ( vr_4 . vr_21 () ) ;
Assert . vr_7 ( 0L , vr_4 . vr_20 () ) ;
final List < String > vr_30 = vr_4 . vr_23 () ;
Assert . vr_7 ( 1 , vr_30 . size () ) ;
Assert . vr_31 ( vr_30 . get ( 0 ) . contains ( lr_4 ) ) ;
}
@df_1
public void fn_8 () {
final tp_1 vr_1 = new fn_2 () ;
final long vr_2 = System . vr_3 () ;
final tp_2 vr_4 = new tp_2 ( vr_1 , vr_2 ) ;
final tp_1 vr_32 = new fn_2 () ;
Assert . vr_7 ( vr_1 , vr_32 ) ;
final tp_2 vr_33 = new tp_2 ( vr_32 , vr_2 + 1 ) ;
Assert . vr_34 ( vr_4 . equals ( vr_33 ) ) ;
vr_32 . vr_35 ( 3 ) ;
vr_32 . vr_36 ( 25 ) ;
final tp_2 vr_37 = new tp_2 ( vr_32 , vr_2 ) ;
Assert . vr_34 ( vr_4 . equals ( vr_37 ) ) ;
Object vr_6 = this ;
Assert . vr_34 ( vr_4 . equals ( vr_6 ) ) ;
vr_6 = null ;
Assert . vr_34 ( vr_4 . equals ( vr_6 ) ) ;
}

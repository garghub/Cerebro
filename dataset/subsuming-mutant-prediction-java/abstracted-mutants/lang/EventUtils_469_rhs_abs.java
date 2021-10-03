public static < vt_1 > void fn_1 ( final Object vr_1 , final Class < vt_1 > vr_2 , final vt_1 vr_3 ) {
try {
vr_4 . vr_5 ( vr_1 , lr_1 + vr_2 . vr_6 () , vr_3 ) ; MST[InlineConstantMutator]MSP[N]
} catch ( final tp_1 vr_7 ) {
throw new IllegalArgumentException ( lr_2 + vr_1 . getClass () . fn_2 ()
+ lr_3 + vr_2 . vr_6 ()
+ lr_4 + vr_2 . fn_2 () + lr_5 ) ;
} catch ( final tp_2 vr_7 ) {
throw new IllegalArgumentException ( lr_2 + vr_1 . getClass () . fn_2 ()
+ lr_6 + vr_2 . vr_6 ()
+ lr_4 + vr_2 . fn_2 () + lr_5 ) ;
} catch ( final tp_3 vr_7 ) {
throw new fn_3 ( lr_7 , vr_7 . vr_8 () ) ;
}
}
public static < vt_1 > void fn_4 ( final Object vr_9 , final String vr_10 , final Object vr_1 ,
final Class < vt_1 > vr_2 , final String ... vr_11 ) {
final vt_1 vr_3 = vr_2 . vr_12 ( vr_13 . vr_14 ( vr_9 . getClass () . fn_5 () ,
new Class [] { vr_2 } , new fn_6 ( vr_9 , vr_10 , vr_11 ) ) ) ;
fn_1 ( vr_1 , vr_2 , vr_3 ) ;
}
@Override
public Object fn_7 ( final Object vr_15 , final tp_4 vr_16 , final Object [] vr_17 ) throws vl_1 {
if ( vr_11 . isEmpty () || vr_11 . contains ( vr_16 . fn_2 () ) ) {
if ( fn_8 ( vr_16 ) ) {
return vr_4 . vr_5 ( vr_9 , vr_10 , vr_17 ) ;
}
return vr_4 . vr_5 ( vr_9 , vr_10 ) ;
}
return null ;
}
private boolean fn_8 ( final tp_4 vr_16 ) {
return vr_4 . vr_18 ( vr_9 . getClass () , vr_10 , vr_16 . vr_19 () ) != null ;
}

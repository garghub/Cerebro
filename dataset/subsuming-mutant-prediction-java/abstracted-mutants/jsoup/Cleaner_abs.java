public tp_1 fn_1 ( tp_1 vr_1 ) {
vr_2 . vr_3 ( vr_1 ) ;
tp_1 fn_1 = tp_1 . vr_4 ( vr_1 . vr_5 () ) ;
if ( vr_1 . vr_6 () != null )
fn_2 ( vr_1 . vr_6 () , fn_1 . vr_6 () ) ;
return fn_1 ;
}
public boolean fn_3 ( tp_1 vr_1 ) {
vr_2 . vr_3 ( vr_1 ) ;
tp_1 fn_1 = tp_1 . vr_4 ( vr_1 . vr_5 () ) ;
int vr_7 = fn_2 ( vr_1 . vr_6 () , fn_1 . vr_6 () ) ;
return vr_7 == 0
&& vr_1 . vr_8 () . fn_4 () . isEmpty () ;
}
public boolean fn_5 ( String vr_9 ) {
tp_1 fn_1 = tp_1 . vr_4 ( lr_1 ) ;
tp_1 vr_10 = tp_1 . vr_4 ( lr_1 ) ;
tp_2 vr_11 = tp_2 . vr_12 ( 1 ) ;
List < vt_1 > vr_13 = vr_14 . vr_15 ( vr_9 , vr_10 . vr_6 () , lr_1 , vr_11 ) ;
vr_10 . vr_6 () . fn_6 ( 0 , vr_13 ) ;
int vr_7 = fn_2 ( vr_10 . vr_6 () , fn_1 . vr_6 () ) ;
return vr_7 == 0 && vr_11 . isEmpty () ;
}
public void vr_8 ( vt_1 vr_16 , int vr_17 ) {
if ( vr_16 instanceof vl_1 ) {
vl_1 vr_18 = ( vl_1 ) vr_16 ;
if ( vr_19 . vr_20 ( vr_18 . vr_21 () ) ) {
tp_3 vr_22 = fn_7 ( vr_18 ) ;
vl_1 vr_23 = vr_22 . vr_24 ;
vr_25 . vr_26 ( vr_23 ) ;
vr_7 += vr_22 . vr_27 ;
vr_25 = vr_23 ;
} else if ( vr_16 != vl_2 ) {
vr_7 ++ ;
}
} else if ( vr_16 instanceof vl_3 ) {
vl_3 vr_28 = ( vl_3 ) vr_16 ;
vl_3 vr_29 = new vl_3 ( vr_28 . vr_30 () ) ;
vr_25 . vr_26 ( vr_29 ) ;
} else if ( vr_16 instanceof vl_4 && vr_19 . vr_20 ( vr_16 . vr_31 () . fn_8 () ) ) {
vl_4 vr_32 = ( vl_4 ) vr_16 ;
vl_4 vr_33 = new vl_4 ( vr_32 . vr_34 () ) ;
vr_25 . vr_26 ( vr_33 ) ;
} else {
vr_7 ++ ;
}
}
public void fn_9 ( vt_1 vr_16 , int vr_17 ) {
if ( vr_16 instanceof vl_1 && vr_19 . vr_20 ( vr_16 . fn_8 () ) ) {
vr_25 = vr_25 . vr_31 () ;
}
}
private int fn_2 ( vl_1 vr_16 , vl_1 vr_35 ) {
tp_4 vr_36 = new tp_4 ( vr_16 , vr_35 ) ;
vr_37 . vr_38 ( vr_36 , vr_16 ) ;
return vr_36 . vr_7 ;
}
private tp_3 fn_7 ( vl_1 vr_18 ) {
String vr_39 = vr_18 . vr_21 () ;
tp_5 vr_40 = new tp_5 () ;
vl_1 vr_35 = new vl_1 ( vr_41 . valueOf ( vr_39 ) , vr_18 . vr_5 () , vr_40 ) ;
int vr_7 = 0 ;
tp_5 vr_42 = vr_18 . vr_43 () ;
for ( tp_6 vr_44 : vr_42 ) {
if ( vr_19 . vr_45 ( vr_39 , vr_18 , vr_44 ) )
vr_40 . vr_46 ( vr_44 ) ;
else
vr_7 ++ ;
}
tp_5 vr_47 = vr_19 . vr_48 ( vr_39 ) ;
vr_40 . vr_49 ( vr_47 ) ;
return new tp_3 ( vr_35 , vr_7 ) ;
}

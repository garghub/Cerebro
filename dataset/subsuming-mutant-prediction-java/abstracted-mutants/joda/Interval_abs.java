public static tp_1 fn_1 ( String vr_1 ) {
return new tp_1 ( vr_1 ) ;
}
public static tp_1 fn_2 ( String vr_1 ) {
int vr_2 = vr_1 . indexOf ( '/' ) ;
if ( vr_2 < 0 ) {
throw new IllegalArgumentException ( lr_1 + vr_1 ) ;
}
String vr_3 = vr_1 . vr_4 ( 0 , vr_2 ) ;
if ( vr_3 . length () <= 0 ) {
throw new IllegalArgumentException ( lr_2 + vr_1 ) ;
}
String vr_5 = vr_1 . vr_4 ( vr_2 + 1 ) ;
if ( vr_5 . length () <= 0 ) {
throw new IllegalArgumentException ( lr_2 + vr_1 ) ;
}
tp_2 vr_6 = vr_7 . vr_6 () . fn_3 () ;
tp_3 vr_8 = vr_9 . vr_10 () ;
tp_4 vr_11 = null ;
tp_5 vr_12 = null ;
char vr_13 = vr_3 . charAt ( 0 ) ;
if ( vr_13 == 'P' || vr_13 == 'p' ) {
vr_12 = vr_8 . vr_14 ( vr_15 . vr_10 () ) . fn_4 ( vr_3 ) ;
} else {
vr_11 = vr_6 . vr_16 ( vr_3 ) ;
}
vr_13 = vr_5 . charAt ( 0 ) ;
if ( vr_13 == 'P' || vr_13 == 'p' ) {
if ( vr_12 != null ) {
throw new IllegalArgumentException ( lr_3 + vr_1 ) ;
}
vr_12 = vr_8 . vr_14 ( vr_15 . vr_10 () ) . fn_4 ( vr_5 ) ;
return new tp_1 ( vr_11 , vr_12 ) ;
} else {
tp_4 vr_17 = vr_6 . vr_16 ( vr_5 ) ;
if ( vr_12 != null ) {
return new tp_1 ( vr_12 , vr_17 ) ;
} else {
return new tp_1 ( vr_11 , vr_17 ) ;
}
}
}
public tp_1 fn_5 () {
return this ;
}
public tp_1 fn_6 ( tp_6 vr_18 ) {
vr_18 = vr_19 . vr_20 ( vr_18 ) ;
if ( fn_7 ( vr_18 ) == false ) {
return null ;
}
long vr_11 = vr_21 . vr_22 ( fn_8 () , vr_18 . fn_8 () ) ;
long vr_17 = vr_21 . vr_23 ( fn_9 () , vr_18 . fn_9 () ) ;
return new tp_1 ( vr_11 , vr_17 , fn_10 () ) ;
}
public tp_1 fn_11 ( tp_6 vr_18 ) {
vr_18 = vr_19 . vr_20 ( vr_18 ) ;
long vr_24 = vr_18 . fn_8 () ;
long vr_25 = vr_18 . fn_9 () ;
long vr_26 = fn_8 () ;
long vr_27 = fn_9 () ;
if ( vr_26 > vr_25 ) {
return new tp_1 ( vr_25 , vr_26 , fn_10 () ) ;
} else if ( vr_24 > vr_27 ) {
return new tp_1 ( vr_27 , vr_24 , fn_10 () ) ;
} else {
return null ;
}
}
public boolean fn_12 ( tp_6 vr_18 ) {
if ( vr_18 == null ) {
long vr_28 = vr_19 . vr_29 () ;
return ( fn_8 () == vr_28 || fn_9 () == vr_28 ) ;
} else {
return ( vr_18 . fn_9 () == fn_8 () ||
fn_9 () == vr_18 . fn_8 () ) ;
}
}
public tp_1 fn_13 ( tp_7 vr_30 ) {
if ( fn_10 () == vr_30 ) {
return this ;
}
return new tp_1 ( fn_8 () , fn_9 () , vr_30 ) ;
}
public tp_1 fn_14 ( long vr_31 ) {
if ( vr_31 == fn_8 () ) {
return this ;
}
return new tp_1 ( vr_31 , fn_9 () , fn_10 () ) ;
}
public tp_1 fn_15 ( tp_8 vr_11 ) {
long vr_32 = vr_19 . vr_33 ( vr_11 ) ;
return fn_14 ( vr_32 ) ;
}
public tp_1 fn_16 ( long vr_34 ) {
if ( vr_34 == fn_9 () ) {
return this ;
}
return new tp_1 ( fn_8 () , vr_34 , fn_10 () ) ;
}
public tp_1 fn_17 ( tp_8 vr_17 ) {
long vr_35 = vr_19 . vr_33 ( vr_17 ) ;
return fn_16 ( vr_35 ) ;
}
public tp_1 fn_18 ( tp_9 vr_36 ) {
long vr_37 = vr_19 . vr_38 ( vr_36 ) ;
if ( vr_37 == fn_19 () ) {
return this ;
}
tp_7 vr_39 = fn_10 () ;
long vr_32 = fn_8 () ;
long vr_35 = vr_39 . add ( vr_32 , vr_37 , 1 ) ;
return new tp_1 ( vr_32 , vr_35 , vr_39 ) ;
}
public tp_1 fn_20 ( tp_9 vr_36 ) {
long vr_37 = vr_19 . vr_38 ( vr_36 ) ;
if ( vr_37 == fn_19 () ) {
return this ;
}
tp_7 vr_39 = fn_10 () ;
long vr_35 = fn_9 () ;
long vr_32 = vr_39 . add ( vr_35 , vr_37 , - 1 ) ;
return new tp_1 ( vr_32 , vr_35 , vr_39 ) ;
}
public tp_1 fn_21 ( tp_10 vr_12 ) {
if ( vr_12 == null ) {
return fn_18 ( null ) ;
}
tp_7 vr_39 = fn_10 () ;
long vr_32 = fn_8 () ;
long vr_35 = vr_39 . add ( vr_12 , vr_32 , 1 ) ;
return new tp_1 ( vr_32 , vr_35 , vr_39 ) ;
}
public tp_1 fn_22 ( tp_10 vr_12 ) {
if ( vr_12 == null ) {
return fn_20 ( null ) ;
}
tp_7 vr_39 = fn_10 () ;
long vr_35 = fn_9 () ;
long vr_32 = vr_39 . add ( vr_12 , vr_35 , - 1 ) ;
return new tp_1 ( vr_32 , vr_35 , vr_39 ) ;
}

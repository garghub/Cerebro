public static final long fn_1 () {
return vr_1 . vr_2 () ;
}
public static final void fn_2 () throws vl_1 {
fn_3 () ;
vr_1 = vl_2 ;
}
public static final void fn_4 ( long vr_3 ) throws vl_1 {
fn_3 () ;
vr_1 = new fn_5 ( vr_3 ) ;
}
public static final void fn_6 ( long vr_4 ) throws vl_1 {
fn_3 () ;
if ( vr_4 == 0 ) {
vr_1 = vl_2 ;
} else {
vr_1 = new fn_7 ( vr_4 ) ;
}
}
public static final void fn_8 ( tp_1 vr_5 ) throws vl_1 {
if ( vr_5 == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
fn_3 () ;
vr_1 = vr_5 ;
}
private static void fn_3 () throws vl_1 {
tp_2 vr_6 = System . vr_7 () ;
if ( vr_6 != null ) {
vr_6 . fn_3 ( new fn_9 ( lr_2 ) ) ;
}
}
public static final long fn_10 ( tp_3 vr_8 ) {
if ( vr_8 == null ) {
return vr_9 . fn_1 () ;
}
return vr_8 . vr_2 () ;
}
public static final tp_4 fn_11 ( tp_3 vr_8 ) {
if ( vr_8 == null ) {
return vr_10 . vr_11 () ;
}
tp_4 vr_12 = vr_8 . vr_13 () ;
if ( vr_12 == null ) {
return vr_10 . vr_11 () ;
}
return vr_12 ;
}
public static final tp_4 fn_12 ( tp_3 vr_14 , tp_3 vr_15 ) {
tp_4 vr_12 = null ;
if ( vr_14 != null ) {
vr_12 = vr_14 . vr_13 () ;
} else if ( vr_15 != null ) {
vr_12 = vr_15 . vr_13 () ;
}
if ( vr_12 == null ) {
vr_12 = vr_10 . vr_11 () ;
}
return vr_12 ;
}
public static final tp_4 fn_12 ( tp_5 vr_16 ) {
if ( vr_16 == null ) {
return vr_10 . vr_11 () ;
}
tp_4 vr_12 = vr_16 . vr_13 () ;
if ( vr_12 == null ) {
return vr_10 . vr_11 () ;
}
return vr_12 ;
}
public static final tp_5 fn_13 ( tp_5 vr_16 ) {
if ( vr_16 == null ) {
long vr_17 = vr_9 . fn_1 () ;
vr_16 = new fn_14 ( vr_17 , vr_17 ) ;
}
return vr_16 ;
}
public static final tp_4 vr_13 ( tp_4 vr_12 ) {
if ( vr_12 == null ) {
return vr_10 . vr_11 () ;
}
return vr_12 ;
}
public static final tp_6 fn_15 ( tp_6 vr_18 ) {
if ( vr_18 == null ) {
return tp_6 . vr_19 () ;
}
return vr_18 ;
}
public static final tp_7 fn_16 ( tp_7 type ) {
if ( type == null ) {
return tp_7 . vr_20 () ;
}
return type ;
}
public static final long fn_17 ( tp_8 vr_21 ) {
if ( vr_21 == null ) {
return 0L ;
}
return vr_21 . vr_2 () ;
}
public static final boolean fn_18 ( tp_9 vr_22 ) {
if ( vr_22 == null ) {
throw new IllegalArgumentException ( lr_3 ) ;
}
tp_10 vr_23 = null ;
for ( int vr_24 = 0 ; vr_24 < vr_22 . size () ; vr_24 ++ ) {
tp_11 vr_25 = vr_22 . vr_26 ( vr_24 ) ;
if ( vr_24 > 0 ) {
if ( vr_25 . vr_27 () == null || vr_25 . vr_27 () . getType () != vr_23 ) {
return false ;
}
}
vr_23 = vr_25 . vr_28 () . getType () ;
}
return true ;
}
public static final tp_12 fn_19 ( tp_13 vr_29 ) {
try {
tp_14 vr_30 = tp_12 . class . vr_31 ( lr_4 , new Class [] { tp_13 . class } ) ;
return ( tp_12 ) vr_30 . vr_32 ( null , new Object [] { vr_29 } ) ;
} catch ( Exception vr_33 ) {
return new tp_12 ( vr_29 ) ;
}
}
public static final vr_34 < String , tp_6 > fn_20 () {
vr_34 < String , tp_6 > vr_35 = vr_36 . get () ;
if ( vr_35 == null ) {
vr_35 = fn_21 () ;
if ( ! vr_36 . vr_37 ( null , vr_35 ) ) {
vr_35 = vr_36 . get () ;
}
}
return vr_35 ;
}
public static final void fn_22 ( vr_34 < String , tp_6 > vr_35 ) {
vr_36 . vr_38 ( vr_39 . vr_40 ( new vr_41 < String , tp_6 > ( vr_35 ) ) ) ;
}
private static vr_34 < String , tp_6 > fn_21 () {
vr_34 < String , tp_6 > vr_42 = new vr_43 < String , tp_6 > () ;
vr_42 . vr_44 ( lr_5 , tp_6 . vr_45 ) ;
vr_42 . vr_44 ( lr_6 , tp_6 . vr_45 ) ;
vr_42 . vr_44 ( lr_7 , tp_6 . vr_45 ) ;
vr_44 ( vr_42 , lr_8 , lr_9 ) ;
vr_44 ( vr_42 , lr_10 , lr_9 ) ;
vr_44 ( vr_42 , lr_11 , lr_12 ) ;
vr_44 ( vr_42 , lr_13 , lr_12 ) ;
vr_44 ( vr_42 , lr_14 , lr_15 ) ;
vr_44 ( vr_42 , lr_16 , lr_15 ) ;
vr_44 ( vr_42 , lr_17 , lr_18 ) ;
vr_44 ( vr_42 , lr_19 , lr_18 ) ;
return vr_39 . vr_40 ( vr_42 ) ;
}
private static void vr_44 ( vr_34 < String , tp_6 > vr_42 , String vr_46 , String vr_47 ) {
try {
vr_42 . vr_44 ( vr_46 , tp_6 . vr_48 ( vr_47 ) ) ;
} catch ( tp_15 vr_33 ) {
}
}
public static final double fn_23 ( long vr_49 ) {
double vr_50 = vr_49 / 86400000d ;
return vr_50 + 2440587.5d ;
}
public static final long fn_24 ( long vr_49 ) {
return ( long ) vr_51 . floor ( fn_23 ( vr_49 ) + 0.5d ) ;
}
public static final long fn_25 ( double vr_52 ) {
double vr_50 = vr_52 - 2440587.5d ;
return (long) ( vr_50 * 86400000d ) ;
}
public long vr_2 () {
return System . fn_1 () ;
}
public long vr_2 () {
return vl_3 ;
}
public long vr_2 () {
return System . fn_1 () + vl_3 ;
}

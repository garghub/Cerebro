protected static int fn_1 ( tp_1 vr_1 , tp_1 vr_2 , tp_2 vr_3 ) {
if ( vr_1 == null || vr_2 == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
tp_3 vr_4 = vr_5 . vr_6 ( vr_1 ) ;
int vr_7 = vr_3 . vr_8 ( vr_4 ) . fn_2 ( vr_2 . vr_9 () , vr_1 . vr_9 () ) ;
return vr_7 ;
}
protected static int fn_1 ( tp_4 vr_1 , tp_4 vr_2 , tp_5 vr_10 ) {
if ( vr_1 == null || vr_2 == null ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
if ( vr_1 . size () != vr_2 . size () ) {
throw new IllegalArgumentException ( lr_3 ) ;
}
for ( int vr_11 = 0 , vr_12 = vr_1 . size () ; vr_11 < vr_12 ; vr_11 ++ ) {
if ( vr_1 . vr_13 ( vr_11 ) != vr_2 . vr_13 ( vr_11 ) ) {
throw new IllegalArgumentException ( lr_3 ) ;
}
}
if ( vr_5 . vr_14 ( vr_1 ) == false ) {
throw new IllegalArgumentException ( lr_4 ) ;
}
tp_3 vr_4 = vr_5 . vr_15 ( vr_1 . vr_15 () ) . fn_3 () ;
int [] vr_16 = vr_4 . get ( vr_10 , vr_4 . vr_17 ( vr_1 , vl_1 ) , vr_4 . vr_17 ( vr_2 , vl_1 ) ) ;
return vr_16 [ 0 ] ;
}
protected static int fn_4 ( tp_5 vr_18 , long vr_19 ) {
if ( vr_18 == null ) {
return 0 ;
}
tp_3 vr_20 = vr_21 . vr_22 () ;
long vr_23 = 0L ;
for ( int vr_11 = 0 ; vr_11 < vr_18 . size () ; vr_11 ++ ) {
int vr_24 = vr_18 . vr_25 ( vr_11 ) ;
if ( vr_24 != 0 ) {
tp_6 vr_3 = vr_18 . vr_13 ( vr_11 ) . vr_8 ( vr_20 ) ;
if ( vr_3 . vr_26 () == false ) {
throw new IllegalArgumentException (
lr_5 + vr_3 . vr_27 () +
lr_6 + vr_18 ) ;
}
vr_23 = vr_28 . vr_29 ( vr_23 , vr_28 . vr_30 ( vr_3 . vr_31 () , vr_24 ) ) ;
}
}
return vr_28 . vr_32 ( vr_23 / vr_19 ) ;
}
protected int vr_25 () {
return vl_2 ;
}
protected void fn_5 ( int vr_24 ) {
vl_2 = vr_24 ;
}
public int size () {
return 1 ;
}
public tp_2 vr_13 ( int vr_33 ) {
if ( vr_33 != 0 ) {
throw new fn_6 ( String . valueOf ( vr_33 ) ) ;
}
return vr_13 () ;
}
public int vr_25 ( int vr_33 ) {
if ( vr_33 != 0 ) {
throw new fn_6 ( String . valueOf ( vr_33 ) ) ;
}
return vr_25 () ;
}
public int get ( tp_2 type ) {
if ( type == vr_13 () ) {
return vr_25 () ;
}
return 0 ;
}
public boolean fn_7 ( tp_2 type ) {
return ( type == vr_13 () ) ;
}
public tp_7 fn_8 () {
return tp_7 . vr_34 . vr_35 ( this ) ;
}
public tp_8 fn_9 () {
tp_8 vr_18 = new tp_8 () ;
vr_18 . add ( this ) ;
return vr_18 ;
}
public boolean equals ( Object vr_18 ) {
if ( this == vr_18 ) {
return true ;
}
if ( vr_18 instanceof tp_5 == false ) {
return false ;
}
tp_5 vr_36 = ( tp_5 ) vr_18 ;
return ( vr_36 . vr_37 () == vr_37 () && vr_36 . vr_25 ( 0 ) == vr_25 () ) ;
}
public int fn_10 () {
int vr_38 = 17 ;
vr_38 = 27 * vr_38 + vr_25 () ;
vr_38 = 27 * vr_38 + vr_13 () . fn_10 () ;
return vr_38 ;
}
public int fn_11 ( tp_9 vr_36 ) {
if ( vr_36 . getClass () != getClass () ) {
throw new fn_12 ( getClass () + lr_7 + vr_36 . getClass () ) ;
}
int vr_39 = vr_36 . vr_25 () ;
int vr_40 = vr_25 () ;
if ( vr_40 > vr_39 ) {
return 1 ;
}
if ( vr_40 < vr_39 ) {
return - 1 ;
}
return 0 ;
}

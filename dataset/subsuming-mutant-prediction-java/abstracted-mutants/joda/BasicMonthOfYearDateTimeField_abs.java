public boolean fn_1 () {
return false ;
}
public int get ( long vr_1 ) {
return vr_2 . vr_3 ( vr_1 ) ;
}
public long add ( long vr_1 , int vr_4 ) {
if ( vr_4 == 0 ) {
return vr_1 ;
}
long vr_5 = vr_2 . vr_6 ( vr_1 ) ;
int vr_7 = vr_2 . vr_8 ( vr_1 ) ;
int vr_9 = vr_2 . vr_3 ( vr_1 , vr_7 ) ;
int vr_10 = vr_7 ; ;
int vr_11 = vr_9 - 1 + vr_4 ;
if ( vr_9 > 0 && vr_11 < 0 ) {
if ( vr_12 . vr_13 ( vr_4 + vl_1 ) == vr_12 . vr_13 ( vr_4 ) ) {
vr_10 -- ;
vr_4 += vl_1 ;
} else {
vr_10 ++ ;
vr_4 -= vl_1 ;
}
vr_11 = vr_9 - 1 + vr_4 ;
}
if ( vr_11 >= 0 ) {
vr_10 = vr_10 + ( vr_11 / vl_1 ) ;
vr_11 = ( vr_11 % vl_1 ) + 1 ;
} else {
vr_10 = vr_10 + ( vr_11 / vl_1 ) - 1 ;
vr_11 = vr_12 . abs ( vr_11 ) ;
int vr_14 = vr_11 % vl_1 ;
if ( vr_14 == 0 ) {
vr_14 = vl_1 ;
}
vr_11 = vl_1 - vr_14 + 1 ;
if ( vr_11 == 1 ) {
vr_10 += 1 ;
}
}
int vr_15 = vr_2 . vr_16 ( vr_1 , vr_7 , vr_9 ) ;
int vr_17 = vr_2 . vr_18 ( vr_10 , vr_11 ) ;
if ( vr_15 > vr_17 ) {
vr_15 = vr_17 ;
}
long vr_19 =
vr_2 . vr_20 ( vr_10 , vr_11 , vr_15 ) ;
return vr_19 + vr_5 ;
}
public long add ( long vr_1 , long vr_4 ) {
int vr_21 = ( int ) vr_4 ;
if ( vr_21 == vr_4 ) {
return add ( vr_1 , vr_21 ) ;
}
long vr_5 = vr_2 . vr_6 ( vr_1 ) ;
int vr_7 = vr_2 . vr_8 ( vr_1 ) ;
int vr_9 = vr_2 . vr_3 ( vr_1 , vr_7 ) ;
long vr_10 ;
long vr_11 = vr_9 - 1 + vr_4 ;
if ( vr_11 >= 0 ) {
vr_10 = vr_7 + ( vr_11 / vl_1 ) ;
vr_11 = ( vr_11 % vl_1 ) + 1 ;
} else {
vr_10 = vr_7 + ( vr_11 / vl_1 ) - 1 ;
vr_11 = vr_12 . abs ( vr_11 ) ;
int vr_14 = (int)( vr_11 % vl_1 ) ;
if ( vr_14 == 0 ) {
vr_14 = vl_1 ;
}
vr_11 = vl_1 - vr_14 + 1 ;
if ( vr_11 == 1 ) {
vr_10 += 1 ;
}
}
if ( vr_10 < vr_2 . vr_22 ( ) ||
vr_10 > vr_2 . vr_23 () ) {
throw new IllegalArgumentException
( lr_1 + vr_4 ) ;
}
int vr_24 = ( int ) vr_10 ;
int vr_25 = ( int ) vr_11 ;
int vr_15 = vr_2 . vr_16 ( vr_1 , vr_7 , vr_9 ) ;
int vr_17 = vr_2 . vr_18 ( vr_24 , vr_25 ) ;
if ( vr_15 > vr_17 ) {
vr_15 = vr_17 ;
}
long vr_19 =
vr_2 . vr_20 ( vr_24 , vr_25 , vr_15 ) ;
return vr_19 + vr_5 ;
}
public int [] add ( tp_1 vr_26 , int vr_27 , int [] vr_28 , int vr_29 ) {
if ( vr_29 == 0 ) {
return vr_28 ;
}
if ( vr_26 . size () > 0 && vr_26 . vr_30 ( 0 ) . equals ( vr_31 . vr_32 () ) && vr_27 == 0 ) {
int vr_33 = vr_28 [ 0 ] - 1 ;
int vr_34 = ( ( vr_33 + ( vr_29 % 12 ) + 12 ) % 12 ) + 1 ;
return fn_2 ( vr_26 , 0 , vr_28 , vr_34 ) ;
}
if ( vr_35 . vr_36 ( vr_26 ) ) {
long vr_1 = 0L ;
for ( int vr_37 = 0 , vr_38 = vr_26 . size () ; vr_37 < vr_38 ; vr_37 ++ ) {
vr_1 = vr_26 . vr_30 ( vr_37 ) . fn_3 ( vr_2 ) . fn_2 ( vr_1 , vr_28 [ vr_37 ] ) ;
}
vr_1 = add ( vr_1 , vr_29 ) ;
return vr_2 . get ( vr_26 , vr_1 ) ;
} else {
return super . add ( vr_26 , vr_27 , vr_28 , vr_29 ) ;
}
}
public long fn_4 ( long vr_1 , int vr_4 ) {
return fn_2 ( vr_1 , vr_39 . vr_40 ( get ( vr_1 ) , vr_4 , vl_2 , vl_1 ) ) ;
}
public long fn_5 ( long vr_41 , long vr_42 ) {
if ( vr_41 < vr_42 ) {
return - fn_6 ( vr_42 , vr_41 ) ;
}
int vr_43 = vr_2 . vr_8 ( vr_41 ) ;
int vr_44 = vr_2 . vr_3 ( vr_41 , vr_43 ) ;
int vr_45 = vr_2 . vr_8 ( vr_42 ) ;
int vr_46 = vr_2 . vr_3 ( vr_42 , vr_45 ) ;
long vr_47 = ( vr_43 - vr_45 ) * ( ( long ) vl_1 ) + vr_44 - vr_46 ;
int vr_48 = vr_2 . vr_16
( vr_41 , vr_43 , vr_44 ) ;
if ( vr_48 == vr_2 . vr_18 ( vr_43 , vr_44 ) ) {
int vr_49 = vr_2 . vr_16
( vr_42 , vr_45 , vr_46 ) ;
if ( vr_49 > vr_48 ) {
vr_42 = vr_2 . vr_50 () . fn_2 ( vr_42 , vr_48 ) ;
}
}
long vr_51 = vr_41
- vr_2 . vr_52 ( vr_43 , vr_44 ) ;
long vr_53 = vr_42
- vr_2 . vr_52 ( vr_45 , vr_46 ) ;
if ( vr_51 < vr_53 ) {
vr_47 -- ;
}
return vr_47 ;
}
public long fn_2 ( long vr_1 , int vr_54 ) {
vr_39 . vr_55 ( this , vr_54 , vl_2 , vl_1 ) ;
int vr_7 = vr_2 . vr_8 ( vr_1 ) ;
int vr_56 = vr_2 . vr_16 ( vr_1 , vr_7 ) ;
int vr_57 = vr_2 . vr_18 ( vr_7 , vr_54 ) ;
if ( vr_56 > vr_57 ) {
vr_56 = vr_57 ;
}
return vr_2 . vr_20 ( vr_7 , vr_54 , vr_56 ) +
vr_2 . vr_6 ( vr_1 ) ;
}
public tp_2 fn_7 () {
return vr_2 . vr_58 () ;
}
public boolean fn_8 ( long vr_1 ) {
int vr_7 = vr_2 . vr_8 ( vr_1 ) ;
if ( vr_2 . vr_59 ( vr_7 ) ) {
return ( vr_2 . vr_3 ( vr_1 , vr_7 ) == vl_3 ) ;
}
return false ;
}
public int fn_9 ( long vr_1 ) {
return fn_8 ( vr_1 ) ? 1 : 0 ;
}
public tp_2 fn_10 () {
return vr_2 . vr_60 () ;
}
public int fn_11 () {
return vl_2 ;
}
public int fn_12 () {
return vl_1 ;
}
public long fn_13 ( long vr_1 ) {
int vr_61 = vr_2 . vr_8 ( vr_1 ) ;
int vr_54 = vr_2 . vr_3 ( vr_1 , vr_61 ) ;
return vr_2 . vr_52 ( vr_61 , vr_54 ) ;
}
public long fn_14 ( long vr_1 ) {
return vr_1 - fn_13 ( vr_1 ) ;
}
private Object fn_15 () {
return vr_2 . vr_32 () ;
}

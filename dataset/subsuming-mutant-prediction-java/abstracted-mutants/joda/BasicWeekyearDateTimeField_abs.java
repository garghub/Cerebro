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
return fn_2 ( vr_1 , get ( vr_1 ) + vr_4 ) ;
}
public long add ( long vr_1 , long vr_5 ) {
return add ( vr_1 , vr_6 . vr_7 ( vr_5 ) ) ;
}
public long fn_3 ( long vr_1 , int vr_4 ) {
return add ( vr_1 , vr_4 ) ;
}
public long fn_4 ( long vr_8 , long vr_9 ) {
if ( vr_8 < vr_9 ) {
return - fn_5 ( vr_9 , vr_8 ) ;
}
int vr_10 = get ( vr_8 ) ;
int vr_11 = get ( vr_9 ) ;
long vr_12 = fn_6 ( vr_8 ) ;
long vr_13 = fn_6 ( vr_9 ) ;
if ( vr_13 >= vl_1 && vr_2 . vr_14 ( vr_10 ) <= 52 ) {
vr_13 -= vr_15 . vr_16 ;
}
int vr_17 = vr_10 - vr_11 ;
if ( vr_12 < vr_13 ) {
vr_17 -- ;
}
return vr_17 ;
}
public long fn_2 ( long vr_1 , int vr_18 ) {
vr_6 . vr_19 ( this , vr_20 . abs ( vr_18 ) ,
vr_2 . vr_21 () , vr_2 . vr_22 () ) ;
int vr_23 = get ( vr_1 ) ;
if ( vr_23 == vr_18 ) {
return vr_1 ;
}
int vr_24 = vr_2 . vr_25 ( vr_1 ) ;
int vr_26 = vr_2 . vr_14 ( vr_23 ) ;
int vr_27 = vr_2 . vr_14 ( vr_18 ) ;
int vr_28 = ( vr_27 < vr_26 ) ?
vr_27 : vr_26 ;
int vr_29 = vr_2 . vr_30 ( vr_1 ) ;
if ( vr_29 > vr_28 ) {
vr_29 = vr_28 ;
}
long vr_31 = vr_1 ;
vr_31 = vr_2 . vr_32 ( vr_31 , vr_18 ) ;
int vr_33 = get ( vr_31 ) ;
if ( vr_33 < vr_18 ) {
vr_31 += vr_15 . vr_16 ;
} else if ( vr_33 > vr_18 ) {
vr_31 -= vr_15 . vr_16 ;
}
int vr_34 = vr_2 . vr_30 ( vr_31 ) ;
vr_31 = vr_31 + ( vr_29 - vr_34 )
* ( long ) vr_15 . vr_16 ;
vr_31 = vr_2 . vr_35 () . fn_2 ( vr_31 , vr_24 ) ;
return vr_31 ;
}
public tp_1 fn_7 () {
return null ;
}
public boolean fn_8 ( long vr_1 ) {
return vr_2 . vr_14 ( vr_2 . vr_3 ( vr_1 ) ) > 52 ;
}
public int fn_9 ( long vr_1 ) {
return vr_2 . vr_14 ( vr_2 . vr_3 ( vr_1 ) ) - 52 ;
}
public tp_1 fn_10 () {
return vr_2 . vr_36 () ;
}
public int fn_11 () {
return vr_2 . vr_21 () ;
}
public int fn_12 () {
return vr_2 . vr_22 () ;
}
public long fn_13 ( long vr_1 ) {
vr_1 = vr_2 . vr_37 () . fn_13 ( vr_1 ) ;
int vr_38 = vr_2 . vr_30 ( vr_1 ) ;
if ( vr_38 > 1 ) {
vr_1 -= ( ( long ) vr_15 . vr_16 ) * ( vr_38 - 1 ) ;
}
return vr_1 ;
}
public long fn_6 ( long vr_1 ) {
return vr_1 - fn_13 ( vr_1 ) ;
}
private Object fn_14 () {
return vr_2 . vr_39 () ;
}

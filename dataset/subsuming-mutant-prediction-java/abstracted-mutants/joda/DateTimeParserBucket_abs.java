public void fn_1 () {
vl_1 = vl_2 ;
vl_3 = null ;
vl_4 = vl_5 ;
vl_6 = 0 ;
vl_7 = false ;
vl_8 = null ;
}
public long fn_2 ( tp_1 vr_1 , tp_2 vr_2 ) {
fn_1 () ;
return fn_3 ( vr_3 . vr_4 ( vr_1 ) , vr_2 ) ;
}
long fn_3 ( tp_3 vr_1 , tp_2 vr_2 ) {
int vr_5 = vr_1 . vr_6 ( this , vr_2 , 0 ) ;
if ( vr_5 >= 0 ) {
if ( vr_5 >= vr_2 . length () ) {
return fn_4 ( true , vr_2 ) ;
}
} else {
vr_5 = ~ vr_5 ;
}
throw new IllegalArgumentException ( vr_7 . vr_8 ( vr_2 . toString () , vr_5 ) ) ;
}
public tp_4 fn_5 () {
return vl_9 ;
}
public tp_5 fn_6 () {
return vl_10 ;
}
public tp_6 fn_7 () {
return vl_1 ;
}
public void fn_8 ( tp_6 vr_9 ) {
vl_8 = null ;
vl_1 = vr_9 ;
}
@Deprecated
public int fn_9 () {
return ( vl_3 != null ? vl_3 : 0 ) ;
}
public Integer fn_10 () {
return vl_3 ;
}
@Deprecated
public void fn_11 ( int vr_10 ) {
vl_8 = null ;
vl_3 = vr_10 ;
}
public void fn_11 ( Integer vr_10 ) {
vl_8 = null ;
vl_3 = vr_10 ;
}
public Integer fn_12 () {
return vl_4 ;
}
@Deprecated
public void fn_13 ( Integer vr_11 ) {
vl_4 = vr_11 ;
}
public void fn_14 ( tp_7 vr_12 , int vr_13 ) {
fn_15 () . fn_16 ( vr_12 , vr_13 ) ;
}
public void fn_14 ( tp_8 vr_14 , int vr_13 ) {
fn_15 () . fn_16 ( vr_14 . vr_15 ( vl_9 ) , vr_13 ) ;
}
public void fn_14 ( tp_8 vr_14 , String vr_2 , tp_5 vr_16 ) {
fn_15 () . fn_16 ( vr_14 . vr_15 ( vl_9 ) , vr_2 , vr_16 ) ;
}
private tp_9 fn_15 () {
tp_9 [] vr_17 = vl_11 ;
int vr_18 = vl_6 ;
if ( vr_18 == vr_17 . length || vl_7 ) {
tp_9 [] vr_19 = new tp_9
[ vr_18 == vr_17 . length ? vr_18 * 2 : vr_17 . length ] ;
System . vr_20 ( vr_17 , 0 , vr_19 , 0 , vr_18 ) ;
vl_11 = vr_17 = vr_19 ;
vl_7 = false ;
}
vl_8 = null ;
tp_9 vr_21 = vr_17 [ vr_18 ] ;
if ( vr_21 == null ) {
vr_21 = vr_17 [ vr_18 ] = new tp_9 () ;
}
vl_6 = vr_18 + 1 ;
return vr_21 ;
}
public Object fn_17 () {
if ( vl_8 == null ) {
vl_8 = new fn_18 () ;
}
return vl_8 ;
}
public boolean fn_19 ( Object vr_22 ) {
if ( vr_22 instanceof fn_18 ) {
if ( ( ( fn_18 ) vr_22 ) . fn_19 ( this ) ) {
vl_8 = vr_22 ;
return true ;
}
}
return false ;
}
public long fn_4 () {
return fn_4 ( false , ( tp_2 ) null ) ;
}
public long fn_4 ( boolean vr_23 ) {
return fn_4 ( vr_23 , ( tp_2 ) null ) ;
}
public long fn_4 ( boolean vr_23 , String vr_2 ) {
return fn_4 ( vr_23 , ( tp_2 ) vr_2 ) ;
}
public long fn_4 ( boolean vr_23 , tp_2 vr_2 ) {
tp_9 [] vr_17 = vl_11 ;
int vr_24 = vl_6 ;
if ( vl_7 ) {
vl_11 = vr_17 = ( tp_9 [] ) vl_11 . vr_25 () ;
vl_7 = false ;
}
fn_20 ( vr_17 , vr_24 ) ;
if ( vr_24 > 0 ) {
tp_10 vr_26 = vr_27 . vr_26 () . vr_15 ( vl_9 ) ;
tp_10 vr_28 = vr_27 . vr_28 () . vr_15 ( vl_9 ) ;
tp_10 vr_29 = vr_17 [ 0 ] . vr_30 . vr_31 () ;
if ( fn_21 ( vr_29 , vr_26 ) >= 0 && fn_21 ( vr_29 , vr_28 ) <= 0 ) {
fn_14 ( tp_8 . vr_32 () , vl_12 ) ;
return fn_4 ( vr_23 , vr_2 ) ;
}
}
long vr_33 = vl_13 ;
try {
for ( int vr_34 = 0 ; vr_34 < vr_24 ; vr_34 ++ ) {
vr_33 = vr_17 [ vr_34 ] . fn_22 ( vr_33 , vr_23 ) ;
}
if ( vr_23 ) {
for ( int vr_34 = 0 ; vr_34 < vr_24 ; vr_34 ++ ) {
if ( ! vr_17 [ vr_34 ] . vr_30 . vr_35 () ) {
vr_33 = vr_17 [ vr_34 ] . fn_22 ( vr_33 , vr_34 == ( vr_24 - 1 ) ) ;
}
}
}
} catch ( tp_11 vr_36 ) {
if ( vr_2 != null ) {
vr_36 . vr_37 ( lr_1 + vr_2 + '"' ) ;
}
throw vr_36 ;
}
if ( vl_3 != null ) {
vr_33 -= vl_3 ;
} else if ( vl_1 != null ) {
int vr_10 = vl_1 . vr_38 ( vr_33 ) ;
vr_33 -= vr_10 ;
if ( vr_10 != vl_1 . fn_9 ( vr_33 ) ) {
String vr_39 = lr_2 + vl_1 + ')' ;
if ( vr_2 != null ) {
vr_39 = lr_1 + vr_2 + lr_3 + vr_39 ;
}
throw new fn_23 ( vr_39 ) ;
}
}
return vr_33 ;
}
private static void fn_20 ( tp_9 [] array , int vr_40 ) {
if ( vr_40 > 10 ) {
vr_41 . fn_20 ( array , 0 , vr_40 ) ;
} else {
for ( int vr_34 = 0 ; vr_34 < vr_40 ; vr_34 ++ ) {
for ( int vr_42 = vr_34 ; vr_42 > 0 && ( array [ vr_42 - 1 ] ) . fn_24 ( array [ vr_42 ] ) > 0 ; vr_42 -- ) {
tp_9 vr_43 = array [ vr_42 ] ;
array [ vr_42 ] = array [ vr_42 - 1 ] ;
array [ vr_42 - 1 ] = vr_43 ;
}
}
}
}
boolean fn_19 ( tp_12 vr_44 ) {
if ( vr_44 != tp_12 . this ) {
return false ;
}
vr_44 . vl_1 = this . vl_1 ;
vr_44 . vl_3 = this . vl_3 ;
vr_44 . vl_11 = this . vl_11 ;
if ( this . vl_6 < vr_44 . vl_6 ) {
vr_44 . vl_7 = true ;
}
vr_44 . vl_6 = this . vl_6 ;
return true ;
}
void fn_16 ( tp_7 vr_12 , int vr_13 ) {
vr_30 = vr_12 ;
vl_14 = vr_13 ;
vl_15 = null ;
vl_10 = null ;
}
void fn_16 ( tp_7 vr_12 , String vr_2 , tp_5 vr_16 ) {
vr_30 = vr_12 ;
vl_14 = 0 ;
vl_15 = vr_2 ;
vl_10 = vr_16 ;
}
long fn_22 ( long vr_33 , boolean fn_1 ) {
if ( vl_15 == null ) {
vr_33 = vr_30 . vr_45 ( vr_33 , vl_14 ) ;
} else {
vr_33 = vr_30 . fn_22 ( vr_33 , vl_15 , vl_10 ) ;
}
if ( fn_1 ) {
vr_33 = vr_30 . vr_46 ( vr_33 ) ;
}
return vr_33 ;
}
public int fn_24 ( tp_9 vr_47 ) {
tp_7 vr_48 = vr_47 . vr_30 ;
int vr_49 = fn_21
( vr_30 . vr_50 () , vr_48 . vr_50 () ) ;
if ( vr_49 != 0 ) {
return vr_49 ;
}
return fn_21
( vr_30 . vr_31 () , vr_48 . vr_31 () ) ;
}
static int fn_21 ( tp_10 vr_51 , tp_10 vr_52 ) {
if ( vr_51 == null || ! vr_51 . vr_53 () ) {
if ( vr_52 == null || ! vr_52 . vr_53 () ) {
return 0 ;
}
return - 1 ;
}
if ( vr_52 == null || ! vr_52 . vr_53 () ) {
return 1 ;
}
return - vr_51 . fn_24 ( vr_52 ) ;
}

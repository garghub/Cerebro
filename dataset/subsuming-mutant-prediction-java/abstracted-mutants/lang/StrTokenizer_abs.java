private static tp_1 fn_1 () {
return ( tp_1 ) vr_1 . vr_2 () ;
}
public static tp_1 fn_2 () {
return fn_1 () ;
}
public static tp_1 fn_2 ( final String vr_3 ) {
final tp_1 vr_4 = fn_1 () ;
vr_4 . vr_5 ( vr_3 ) ;
return vr_4 ;
}
public static tp_1 fn_2 ( final char [] vr_3 ) {
final tp_1 vr_4 = fn_1 () ;
vr_4 . vr_5 ( vr_3 ) ;
return vr_4 ;
}
private static tp_1 fn_3 () {
return ( tp_1 ) vr_6 . vr_2 () ;
}
public static tp_1 fn_4 () {
return fn_3 () ;
}
public static tp_1 fn_4 ( final String vr_3 ) {
final tp_1 vr_4 = fn_3 () ;
vr_4 . vr_5 ( vr_3 ) ;
return vr_4 ;
}
public static tp_1 fn_4 ( final char [] vr_3 ) {
final tp_1 vr_4 = fn_3 () ;
vr_4 . vr_5 ( vr_3 ) ;
return vr_4 ;
}
public int size () {
fn_5 () ;
return vr_7 . length ;
}
public String fn_6 () {
if ( hasNext () ) {
return vr_7 [ vl_1 ++ ] ;
}
return null ;
}
public String fn_7 () {
if ( fn_8 () ) {
return vr_7 [ -- vl_1 ] ;
}
return null ;
}
public String [] fn_9 () {
fn_5 () ;
return vr_7 . vr_2 () ;
}
public List < String > fn_10 () {
fn_5 () ;
final List < String > list = new ArrayList < String > ( vr_7 . length ) ;
for ( final String vr_8 : vr_7 ) {
list . add ( vr_8 ) ;
}
return list ;
}
public tp_1 vr_5 () {
vl_1 = 0 ;
vr_7 = null ;
return this ;
}
public tp_1 vr_5 ( final String vr_3 ) {
vr_5 () ;
if ( vr_3 != null ) {
this . vr_9 = vr_3 . vr_10 () ;
} else {
this . vr_9 = null ;
}
return this ;
}
public tp_1 vr_5 ( final char [] vr_3 ) {
vr_5 () ;
this . vr_9 = vr_11 . vr_2 ( vr_3 ) ;
return this ;
}
@Override
public boolean hasNext () {
fn_5 () ;
return vl_1 < vr_7 . length ;
}
@Override
public String fn_11 () {
if ( hasNext () ) {
return vr_7 [ vl_1 ++ ] ;
}
throw new fn_12 () ;
}
@Override
public int fn_13 () {
return vl_1 ;
}
@Override
public boolean fn_8 () {
fn_5 () ;
return vl_1 > 0 ;
}
@Override
public String fn_14 () {
if ( fn_8 () ) {
return vr_7 [ -- vl_1 ] ;
}
throw new fn_12 () ;
}
@Override
public int fn_15 () {
return vl_1 - 1 ;
}
@Override
public void remove () {
throw new fn_16 ( lr_1 ) ;
}
@Override
public void fn_17 ( final String vr_12 ) {
throw new fn_16 ( lr_2 ) ;
}
@Override
public void add ( final String vr_12 ) {
throw new fn_16 ( lr_3 ) ;
}
private void fn_5 () {
if ( vr_7 == null ) {
if ( vr_9 == null ) {
final List < String > vr_13 = fn_18 ( null , 0 , 0 ) ;
vr_7 = vr_13 . toArray ( new String [ vr_13 . size () ] ) ;
} else {
final List < String > vr_13 = fn_18 ( vr_9 , 0 , vr_9 . length ) ;
vr_7 = vr_13 . toArray ( new String [ vr_13 . size () ] ) ;
}
}
}
protected List < String > fn_18 ( final char [] vr_14 , final int vr_15 , final int vr_16 ) {
if ( vr_14 == null || vr_16 == 0 ) {
return vr_17 . vr_18 () ;
}
final tp_2 vr_19 = new tp_2 () ;
final List < String > vr_20 = new ArrayList < String > () ;
int vr_21 = vr_15 ;
while ( vr_21 >= 0 && vr_21 < vr_16 ) {
vr_21 = fn_19 ( vr_14 , vr_21 , vr_16 , vr_19 , vr_20 ) ;
if ( vr_21 >= vr_16 ) {
fn_20 ( vr_20 , lr_4 ) ;
}
}
return vr_20 ;
}
private void fn_20 ( final List < String > list , String vr_4 ) {
if ( vr_22 . isEmpty ( vr_4 ) ) {
if ( fn_21 () ) {
return;
}
if ( fn_22 () ) {
vr_4 = null ;
}
}
list . add ( vr_4 ) ;
}
private int fn_19 ( final char [] vr_14 , int vr_23 , final int vr_24 , final tp_2 vr_25 , final List < String > vr_20 ) {
while ( vr_23 < vr_24 ) {
final int vr_26 = vr_27 . vr_28 (
fn_23 () . fn_24 ( vr_14 , vr_23 , vr_23 , vr_24 ) ,
fn_25 () . fn_24 ( vr_14 , vr_23 , vr_23 , vr_24 ) ) ;
if ( vr_26 == 0 ||
fn_26 () . fn_24 ( vr_14 , vr_23 , vr_23 , vr_24 ) > 0 ||
fn_27 () . fn_24 ( vr_14 , vr_23 , vr_23 , vr_24 ) > 0 ) {
break;
}
vr_23 += vr_26 ;
}
if ( vr_23 >= vr_24 ) {
fn_20 ( vr_20 , lr_4 ) ;
return - 1 ;
}
final int vr_29 = fn_26 () . fn_24 ( vr_14 , vr_23 , vr_23 , vr_24 ) ;
if ( vr_29 > 0 ) {
fn_20 ( vr_20 , lr_4 ) ;
return vr_23 + vr_29 ;
}
final int vr_30 = fn_27 () . fn_24 ( vr_14 , vr_23 , vr_23 , vr_24 ) ;
if ( vr_30 > 0 ) {
return fn_28 ( vr_14 , vr_23 + vr_30 , vr_24 , vr_25 , vr_20 , vr_23 , vr_30 ) ;
}
return fn_28 ( vr_14 , vr_23 , vr_24 , vr_25 , vr_20 , 0 , 0 ) ;
}
private int fn_28 ( final char [] vr_14 , final int vr_23 , final int vr_24 , final tp_2 vr_25 ,
final List < String > vr_20 , final int vr_31 , final int vr_30 ) {
vr_25 . clear () ;
int vr_21 = vr_23 ;
boolean vr_32 = vr_30 > 0 ;
int vr_33 = 0 ;
while ( vr_21 < vr_24 ) {
if ( vr_32 ) {
if ( fn_29 ( vr_14 , vr_21 , vr_24 , vr_31 , vr_30 ) ) {
if ( fn_29 ( vr_14 , vr_21 + vr_30 , vr_24 , vr_31 , vr_30 ) ) {
vr_25 . append ( vr_14 , vr_21 , vr_30 ) ;
vr_21 += vr_30 * 2 ;
vr_33 = vr_25 . size () ;
continue;
}
vr_32 = false ;
vr_21 += vr_30 ;
continue;
}
vr_25 . append ( vr_14 [ vr_21 ++ ] ) ;
vr_33 = vr_25 . size () ;
} else {
final int vr_29 = fn_26 () . fn_24 ( vr_14 , vr_21 , vr_23 , vr_24 ) ;
if ( vr_29 > 0 ) {
fn_20 ( vr_20 , vr_25 . vr_34 ( 0 , vr_33 ) ) ;
return vr_21 + vr_29 ;
}
if ( vr_30 > 0 && fn_29 ( vr_14 , vr_21 , vr_24 , vr_31 , vr_30 ) ) {
vr_32 = true ;
vr_21 += vr_30 ;
continue;
}
final int vr_35 = fn_23 () . fn_24 ( vr_14 , vr_21 , vr_23 , vr_24 ) ;
if ( vr_35 > 0 ) {
vr_21 += vr_35 ;
continue;
}
final int vr_36 = fn_25 () . fn_24 ( vr_14 , vr_21 , vr_23 , vr_24 ) ;
if ( vr_36 > 0 ) {
vr_25 . append ( vr_14 , vr_21 , vr_36 ) ;
vr_21 += vr_36 ;
continue;
}
vr_25 . append ( vr_14 [ vr_21 ++ ] ) ;
vr_33 = vr_25 . size () ;
}
}
fn_20 ( vr_20 , vr_25 . vr_34 ( 0 , vr_33 ) ) ;
return - 1 ;
}
private boolean fn_29 ( final char [] vr_14 , final int vr_21 , final int vr_24 , final int vr_31 , final int vr_30 ) {
for ( int vr_37 = 0 ; vr_37 < vr_30 ; vr_37 ++ ) {
if ( vr_21 + vr_37 >= vr_24 || vr_14 [ vr_21 + vr_37 ] != vr_14 [ vr_31 + vr_37 ] ) {
return false ;
}
}
return true ;
}
public tp_3 fn_26 () {
return this . vr_38 ;
}
public tp_1 fn_30 ( final tp_3 vr_39 ) {
if ( vr_39 == null ) {
this . vr_38 = tp_3 . vr_40 () ;
} else {
this . vr_38 = vr_39 ;
}
return this ;
}
public tp_1 fn_31 ( final char vr_39 ) {
return fn_30 ( tp_3 . vr_41 ( vr_39 ) ) ;
}
public tp_1 fn_32 ( final String vr_39 ) {
return fn_30 ( tp_3 . vr_42 ( vr_39 ) ) ;
}
public tp_3 fn_27 () {
return vl_2 ;
}
public tp_1 fn_33 ( final tp_3 vr_43 ) {
if ( vr_43 != null ) {
this . vl_2 = vr_43 ;
}
return this ;
}
public tp_1 fn_34 ( final char vr_43 ) {
return fn_33 ( tp_3 . vr_41 ( vr_43 ) ) ;
}
public tp_3 fn_23 () {
return vl_3 ;
}
public tp_1 fn_35 ( final tp_3 vr_44 ) {
if ( vr_44 != null ) {
this . vl_3 = vr_44 ;
}
return this ;
}
public tp_1 fn_36 ( final char vr_44 ) {
return fn_35 ( tp_3 . vr_41 ( vr_44 ) ) ;
}
public tp_3 fn_25 () {
return vl_4 ;
}
public tp_1 fn_37 ( final tp_3 vr_45 ) {
if ( vr_45 != null ) {
this . vl_4 = vr_45 ;
}
return this ;
}
public boolean fn_22 () {
return this . vr_46 ;
}
public tp_1 fn_38 ( final boolean vr_46 ) {
this . vr_46 = vr_46 ;
return this ;
}
public boolean fn_21 () {
return vl_5 ;
}
public tp_1 fn_39 ( final boolean vl_5 ) {
this . vl_5 = vl_5 ;
return this ;
}
public String fn_40 () {
if ( vr_9 == null ) {
return null ;
}
return new String ( vr_9 ) ;
}
@Override
public Object vr_2 () {
try {
return fn_41 () ;
} catch ( final tp_4 vr_47 ) {
return null ;
}
}
Object fn_41 () throws tp_4 {
final tp_1 vr_48 = ( tp_1 ) super . vr_2 () ;
if ( vr_48 . vr_9 != null ) {
vr_48 . vr_9 = vr_48 . vr_9 . vr_2 () ;
}
vr_48 . vr_5 () ;
return vr_48 ;
}
@Override
public String toString () {
if ( vr_7 == null ) {
return lr_5 ;
}
return lr_6 + fn_10 () ;
}

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
final List < String > list = new ArrayList <> ( vr_7 . length ) ;
vr_8 . vr_9 ( list , vr_7 ) ;
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
this . vr_10 = vr_3 . vr_11 () ;
} else {
this . vr_10 = null ;
}
return this ;
}
public tp_1 vr_5 ( final char [] vr_3 ) {
vr_5 () ;
if ( vr_3 != null ) {
this . vr_10 = vr_3 . vr_2 () ;
} else {
this . vr_10 = null ;
}
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
if ( vr_10 == null ) {
final List < String > vr_13 = fn_18 ( null , 0 , 0 ) ;
vr_7 = vr_13 . toArray ( new String [ vr_13 . size () ] ) ;
} else {
final List < String > vr_13 = fn_18 ( vr_10 , 0 , vr_10 . length ) ;
vr_7 = vr_13 . toArray ( new String [ vr_13 . size () ] ) ;
}
}
}
protected List < String > fn_18 ( final char [] vr_14 , final int vr_15 , final int vr_16 ) {
if ( vr_14 == null || vr_16 == 0 ) {
return vr_8 . vr_17 () ;
}
final tp_2 vr_18 = new tp_2 () ;
final List < String > vr_19 = new ArrayList <> () ;
int vr_20 = vr_15 ;
while ( vr_20 >= 0 && vr_20 < vr_16 ) {
vr_20 = fn_19 ( vr_14 , vr_20 , vr_16 , vr_18 , vr_19 ) ;
if ( vr_20 >= vr_16 ) {
fn_20 ( vr_19 , lr_4 ) ;
}
}
return vr_19 ;
}
private void fn_20 ( final List < String > list , String vr_4 ) {
if ( vr_4 == null || vr_4 . length () == 0 ) {
if ( fn_21 () ) {
return;
}
if ( fn_22 () ) {
vr_4 = null ;
}
}
list . add ( vr_4 ) ;
}
private int fn_19 ( final char [] vr_14 , int vr_21 , final int vr_22 , final tp_2 vr_23 ,
final List < String > vr_19 ) {
while ( vr_21 < vr_22 ) {
final int vr_24 = vr_25 . vr_26 ( fn_23 () . fn_24 ( vr_14 , vr_21 , vr_21 , vr_22 ) ,
fn_25 () . fn_24 ( vr_14 , vr_21 , vr_21 , vr_22 ) ) ;
if ( vr_24 == 0 || fn_26 () . fn_24 ( vr_14 , vr_21 , vr_21 , vr_22 ) > 0
|| fn_27 () . fn_24 ( vr_14 , vr_21 , vr_21 , vr_22 ) > 0 ) {
break;
}
vr_21 += vr_24 ;
}
if ( vr_21 >= vr_22 ) {
fn_20 ( vr_19 , lr_4 ) ;
return - 1 ;
}
final int vr_27 = fn_26 () . fn_24 ( vr_14 , vr_21 , vr_21 , vr_22 ) ;
if ( vr_27 > 0 ) {
fn_20 ( vr_19 , lr_4 ) ;
return vr_21 + vr_27 ;
}
final int vr_28 = fn_27 () . fn_24 ( vr_14 , vr_21 , vr_21 , vr_22 ) ;
if ( vr_28 > 0 ) {
return fn_28 ( vr_14 , vr_21 + vr_28 , vr_22 , vr_23 , vr_19 , vr_21 , vr_28 ) ;
}
return fn_28 ( vr_14 , vr_21 , vr_22 , vr_23 , vr_19 , 0 , 0 ) ;
}
private int fn_28 ( final char [] vr_14 , final int vr_21 , final int vr_22 , final tp_2 vr_23 ,
final List < String > vr_19 , final int vr_29 , final int vr_28 ) {
vr_23 . clear () ;
int vr_20 = vr_21 ;
boolean vr_30 = vr_28 > 0 ;
int vr_31 = 0 ;
while ( vr_20 < vr_22 ) {
if ( vr_30 ) {
if ( fn_29 ( vr_14 , vr_20 , vr_22 , vr_29 , vr_28 ) ) {
if ( fn_29 ( vr_14 , vr_20 + vr_28 , vr_22 , vr_29 , vr_28 ) ) {
vr_23 . append ( vr_14 , vr_20 , vr_28 ) ;
vr_20 += vr_28 * 2 ;
vr_31 = vr_23 . size () ;
continue;
}
vr_30 = false ;
vr_20 += vr_28 ;
continue;
}
vr_23 . append ( vr_14 [ vr_20 ++ ] ) ;
vr_31 = vr_23 . size () ;
} else {
final int vr_27 = fn_26 () . fn_24 ( vr_14 , vr_20 , vr_21 , vr_22 ) ;
if ( vr_27 > 0 ) {
fn_20 ( vr_19 , vr_23 . vr_32 ( 0 , vr_31 ) ) ;
return vr_20 + vr_27 ;
}
if ( vr_28 > 0 && fn_29 ( vr_14 , vr_20 , vr_22 , vr_29 , vr_28 ) ) {
vr_30 = true ;
vr_20 += vr_28 ;
continue;
}
final int vr_33 = fn_23 () . fn_24 ( vr_14 , vr_20 , vr_21 , vr_22 ) ;
if ( vr_33 > 0 ) {
vr_20 += vr_33 ;
continue;
}
final int vr_34 = fn_25 () . fn_24 ( vr_14 , vr_20 , vr_21 , vr_22 ) ;
if ( vr_34 > 0 ) {
vr_23 . append ( vr_14 , vr_20 , vr_34 ) ;
vr_20 += vr_34 ;
continue;
}
vr_23 . append ( vr_14 [ vr_20 ++ ] ) ;
vr_31 = vr_23 . size () ;
}
}
fn_20 ( vr_19 , vr_23 . vr_32 ( 0 , vr_31 ) ) ;
return - 1 ;
}
private boolean fn_29 ( final char [] vr_14 , final int vr_20 , final int vr_22 , final int vr_29 ,
final int vr_28 ) {
for ( int vr_35 = 0 ; vr_35 < vr_28 ; vr_35 ++ ) {
if ( vr_20 + vr_35 >= vr_22 || vr_14 [ vr_20 + vr_35 ] != vr_14 [ vr_29 + vr_35 ] ) {
return false ;
}
}
return true ;
}
public tp_3 fn_26 () {
return this . vr_36 ;
}
public tp_1 fn_30 ( final tp_3 vr_37 ) {
if ( vr_37 == null ) {
this . vr_36 = vr_38 . vr_39 . vr_40 () ;
} else {
this . vr_36 = vr_37 ;
}
return this ;
}
public tp_1 fn_31 ( final char vr_37 ) {
return fn_30 ( vr_38 . vr_39 . vr_41 ( vr_37 ) ) ;
}
public tp_1 fn_32 ( final String vr_37 ) {
return fn_30 ( vr_38 . vr_39 . vr_42 ( vr_37 ) ) ;
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
return fn_33 ( vr_38 . vr_39 . vr_41 ( vr_43 ) ) ;
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
return fn_35 ( vr_38 . vr_39 . vr_41 ( vr_44 ) ) ;
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
if ( vr_10 == null ) {
return null ;
}
return new String ( vr_10 ) ;
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
if ( vr_48 . vr_10 != null ) {
vr_48 . vr_10 = vr_48 . vr_10 . vr_2 () ;
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

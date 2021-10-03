@Deprecated
public static String [] fn_1 () {
return vr_1 . vr_2 ( vl_1 ) ;
}
@Deprecated
public static tp_1 fn_2 ( final tp_1 vr_3 ) {
return fn_2 ( vr_3 , vl_1 ) ;
}
@Deprecated
public static tp_1 fn_2 ( final tp_1 vr_3 , String [] vr_4 ) {
if ( vr_3 == null ) {
return null ;
}
if ( vr_4 == null ) {
vr_4 = vl_1 ;
}
for ( final String vr_5 : vr_4 ) {
if ( vr_5 != null ) {
final tp_1 vr_6 = fn_3 ( vr_3 , vr_5 ) ;
if ( vr_6 != null ) {
return vr_6 ;
}
}
}
return null ;
}
public static tp_1 fn_4 ( final tp_1 vr_3 ) {
final List < tp_1 > list = fn_5 ( vr_3 ) ;
return list . size () < 2 ? null : ( tp_1 ) list . get ( list . size () - 1 ) ;
}
private static tp_1 fn_3 ( final tp_1 vr_3 , final String vr_5 ) {
tp_2 vr_7 = null ;
try {
vr_7 = vr_3 . getClass () . fn_6 ( vr_5 ) ;
} catch ( final tp_3 vr_8 ) {
} catch ( final tp_4 vr_8 ) {
}
if ( vr_7 != null && tp_1 . class . vr_9 ( vr_7 . vr_10 () ) ) {
try {
return ( tp_1 ) vr_7 . vr_11 ( vr_3 ) ;
} catch ( final tp_5 vr_8 ) {
} catch ( final IllegalArgumentException vr_8 ) {
} catch ( final tp_6 vr_8 ) {
}
}
return null ;
}
public static int fn_7 ( final tp_1 vr_3 ) {
return fn_5 ( vr_3 ) . size () ;
}
public static tp_1 [] fn_8 ( final tp_1 vr_3 ) {
final List < tp_1 > list = fn_5 ( vr_3 ) ;
return list . toArray ( new tp_1 [ list . size () ] ) ;
}
public static List < tp_1 > fn_5 ( tp_1 vr_3 ) {
final List < tp_1 > list = new ArrayList < tp_1 > () ;
while ( vr_3 != null && list . contains ( vr_3 ) == false ) {
list . add ( vr_3 ) ;
vr_3 = vr_12 . fn_2 ( vr_3 ) ;
}
return list ;
}
public static int fn_9 ( final tp_1 vr_3 , final Class < ? > vr_13 ) {
return indexOf ( vr_3 , vr_13 , 0 , false ) ;
}
public static int fn_9 ( final tp_1 vr_3 , final Class < ? > vr_13 , final int vr_14 ) {
return indexOf ( vr_3 , vr_13 , vr_14 , false ) ;
}
public static int fn_10 ( final tp_1 vr_3 , final Class < ? > type ) {
return indexOf ( vr_3 , type , 0 , true ) ;
}
public static int fn_10 ( final tp_1 vr_3 , final Class < ? > type , final int vr_14 ) {
return indexOf ( vr_3 , type , vr_14 , true ) ;
}
private static int indexOf ( final tp_1 vr_3 , final Class < ? > type , int vr_14 , final boolean vr_15 ) {
if ( vr_3 == null || type == null ) {
return - 1 ;
}
if ( vr_14 < 0 ) {
vr_14 = 0 ;
}
final tp_1 [] vr_16 = vr_12 . fn_8 ( vr_3 ) ;
if ( vr_14 >= vr_16 . length ) {
return - 1 ;
}
if ( vr_15 ) {
for ( int vr_17 = vr_14 ; vr_17 < vr_16 . length ; vr_17 ++ ) {
if ( type . vr_9 ( vr_16 [ vr_17 ] . getClass () ) ) {
return vr_17 ;
}
}
} else {
for ( int vr_17 = vr_14 ; vr_17 < vr_16 . length ; vr_17 ++ ) {
if ( type . equals ( vr_16 [ vr_17 ] . getClass () ) ) {
return vr_17 ;
}
}
}
return - 1 ;
}
public static void fn_11 ( final tp_1 vr_3 ) {
fn_11 ( vr_3 , System . vr_18 ) ;
}
public static void fn_11 ( final tp_1 vr_3 , final tp_7 vr_19 ) {
if ( vr_3 == null ) {
return;
}
if ( vr_19 == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
final String vr_20 [] = fn_12 ( vr_3 ) ;
for ( final String vr_21 : vr_20 ) {
vr_19 . println ( vr_21 ) ;
}
vr_19 . vr_22 () ;
}
public static void fn_11 ( final tp_1 vr_3 , final PrintWriter vr_23 ) {
if ( vr_3 == null ) {
return;
}
if ( vr_23 == null ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
final String vr_20 [] = fn_12 ( vr_3 ) ;
for ( final String vr_21 : vr_20 ) {
vr_23 . println ( vr_21 ) ;
}
vr_23 . vr_22 () ;
}
public static String [] fn_12 ( final tp_1 vr_3 ) {
if ( vr_3 == null ) {
return vr_1 . vr_24 ;
}
final tp_1 vr_16 [] = fn_8 ( vr_3 ) ;
final int vr_25 = vr_16 . length ;
final List < String > vr_26 = new ArrayList < String > () ;
List < String > vr_27 = fn_13 ( vr_16 [ vr_25 - 1 ] ) ;
for ( int vr_17 = vr_25 ; -- vr_17 >= 0 ; ) {
final List < String > vr_20 = vr_27 ;
if ( vr_17 != 0 ) {
vr_27 = fn_13 ( vr_16 [ vr_17 - 1 ] ) ;
fn_14 ( vr_20 , vr_27 ) ;
}
if ( vr_17 == vr_25 - 1 ) {
vr_26 . add ( vr_16 [ vr_17 ] . toString () ) ;
} else {
vr_26 . add ( vl_2 + vr_16 [ vr_17 ] . toString () ) ;
}
for ( int vr_28 = 0 ; vr_28 < vr_20 . size () ; vr_28 ++ ) {
vr_26 . add ( vr_20 . get ( vr_28 ) ) ;
}
}
return vr_26 . toArray ( new String [ vr_26 . size () ] ) ;
}
public static void fn_14 ( final List < String > vr_29 , final List < String > vr_30 ) {
if ( vr_29 == null || vr_30 == null ) {
throw new IllegalArgumentException ( lr_3 ) ;
}
int vr_31 = vr_29 . size () - 1 ;
int vr_32 = vr_30 . size () - 1 ;
while ( vr_31 >= 0 && vr_32 >= 0 ) {
final String vr_33 = vr_29 . get ( vr_31 ) ;
final String vr_34 = vr_30 . get ( vr_32 ) ;
if ( vr_33 . equals ( vr_34 ) ) {
vr_29 . remove ( vr_31 ) ;
}
vr_31 -- ;
vr_32 -- ;
}
}
public static String fn_15 ( final tp_1 vr_3 ) {
final tp_8 vr_35 = new tp_8 () ;
final PrintWriter vr_36 = new PrintWriter ( vr_35 , true ) ;
vr_3 . vr_37 ( vr_36 ) ;
return vr_35 . vr_38 () . toString () ;
}
public static String [] fn_16 ( final tp_1 vr_3 ) {
if ( vr_3 == null ) {
return vr_1 . vr_24 ;
}
return fn_16 ( fn_15 ( vr_3 ) ) ;
}
static String [] fn_16 ( final String vr_39 ) {
final String vr_40 = vr_41 . vr_42 ;
final tp_9 vr_26 = new tp_9 ( vr_39 , vr_40 ) ;
final List < String > list = new ArrayList < String > () ;
while ( vr_26 . vr_43 () ) {
list . add ( vr_26 . vr_44 () ) ;
}
return list . toArray ( new String [ list . size () ] ) ;
}
static List < String > fn_13 ( final tp_1 vr_45 ) {
final String vr_39 = fn_15 ( vr_45 ) ;
final String vr_40 = vr_41 . vr_42 ;
final tp_9 vr_26 = new tp_9 ( vr_39 , vr_40 ) ;
final List < String > list = new ArrayList < String > () ;
boolean vr_46 = false ;
while ( vr_26 . vr_43 () ) {
final String vr_47 = vr_26 . vr_44 () ;
final int vr_48 = vr_47 . indexOf ( lr_4 ) ;
if ( vr_48 != - 1 && vr_47 . vr_49 ( 0 , vr_48 ) . trim () . isEmpty () ) {
vr_46 = true ;
list . add ( vr_47 ) ;
} else if ( vr_46 ) {
break;
}
}
return list ;
}
public static String fn_17 ( final tp_1 vr_50 ) {
if ( vr_50 == null ) {
return lr_5 ;
}
final String vr_51 = vr_52 . vr_53 ( vr_50 , null ) ;
final String vr_54 = vr_50 . fn_17 () ;
return vr_51 + lr_6 + vr_55 . vr_56 ( vr_54 ) ;
}
public static String fn_18 ( final tp_1 vr_50 ) {
tp_1 vr_57 = vr_12 . fn_4 ( vr_50 ) ;
vr_57 = vr_57 == null ? vr_50 : vr_57 ;
return fn_17 ( vr_57 ) ;
}
public static < vt_1 > vt_1 fn_19 ( tp_1 vr_3 ) {
return vr_12 . <vt_1 , vl_3 > fn_20 ( vr_3 ) ;
}
@SuppressWarnings ( lr_7 )
private static < vt_1 , vt_2 extends tp_1 > vt_1 fn_20 ( tp_1 vr_3 ) throws vt_2 {
throw ( vt_2 ) vr_3 ;
}
public static < vt_1 > vt_1 fn_21 ( tp_1 vr_3 ) {
if ( vr_3 instanceof vl_3 ) {
throw ( vl_3 ) vr_3 ;
}
if ( vr_3 instanceof Error ) {
throw ( Error ) vr_3 ;
}
throw new fn_22 ( vr_3 ) ;
}
public static boolean fn_23 ( tp_1 vr_58 ,
Class < ? extends tp_1 > type ) {
if ( vr_58 instanceof fn_22 ) {
vr_58 = vr_58 . fn_2 () ;
}
return type . vr_59 ( vr_58 ) ;
}

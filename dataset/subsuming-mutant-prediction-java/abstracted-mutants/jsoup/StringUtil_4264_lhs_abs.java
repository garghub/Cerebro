public static String fn_1 ( Collection vr_1 , String vr_2 ) {
return fn_1 ( vr_1 . iterator () , vr_2 ) ;
}
public static String fn_1 ( Iterator vr_1 , String vr_2 ) {
if ( ! vr_1 . hasNext () )
return lr_1 ;
String vr_3 = vr_1 . vr_4 () . toString () ;
if ( ! vr_1 . hasNext () )
return vr_3 ;
StringBuilder vr_5 = vr_6 . vr_7 () . append ( vr_3 ) ;
while ( vr_1 . hasNext () ) {
vr_5 . append ( vr_2 ) ;
vr_5 . append ( vr_1 . vr_4 () ) ;
}
return vr_6 . vr_8 ( vr_5 ) ;
}
public static String fn_1 ( String [] vr_1 , String vr_2 ) {
return fn_1 ( vr_9 . vr_10 ( vr_1 ) , vr_2 ) ;
}
public static String fn_2 ( int vr_11 ) {
if ( vr_11 < 0 )
throw new IllegalArgumentException ( lr_2 ) ;
if ( vr_11 < fn_2 . length )
return fn_2 [ vr_11 ] ;
char [] out = new char [ vr_11 ] ;
for ( int vr_12 = 0 ; vr_12 < vr_11 ; vr_12 ++ )
out [ vr_12 ] = ' ' ;
return String . valueOf ( out ) ;
}
public static boolean fn_3 ( String string ) {
if ( string == null || string . length () == 0 )
return true ;
int vr_13 = string . length () ;
for ( int vr_12 = 0 ; vr_12 < vr_13 ; vr_12 ++ ) {
if ( ! vr_6 . vr_14 ( string . vr_15 ( vr_12 ) ) )
return false ;
}
return true ;
}
public static boolean fn_4 ( String string ) {
if ( string == null || string . length () == 0 )
return false ;
int vr_13 = string . length () ;
for ( int vr_12 = 0 ; vr_12 < vr_13 ; vr_12 ++ ) {
if ( ! vr_16 . isDigit ( string . vr_15 ( vr_12 ) ) )
return false ;
}
return true ;
}
public static boolean vr_14 ( int vr_17 ) {
return vr_17 == ' ' || vr_17 == '\t' || vr_17 == '\n' || vr_17 == '\f' || vr_17 == '\r' ;
}
public static boolean fn_5 ( int vr_17 ) {
return vr_17 == ' ' || vr_17 == '\t' || vr_17 == '\n' || vr_17 == '\f' || vr_17 == '\r' || vr_17 == 160 ;
}
public static boolean fn_6 ( int vr_17 ) {
return vr_17 == 8203 || vr_17 == 173 ;
}
public static String fn_7 ( String string ) {
StringBuilder vr_5 = vr_6 . vr_7 () ;
fn_8 ( vr_5 , string , false ) ;
return vr_6 . vr_8 ( vr_5 ) ;
}
public static void fn_8 ( StringBuilder vr_18 , String string , boolean vr_19 ) {
boolean vr_20 = false ;
boolean vr_21 = false ;
int vr_22 = string . length () ;
int vr_17 ;
for ( int vr_12 = 0 ; vr_12 < vr_22 ; vr_12 += vr_16 . vr_23 ( vr_17 ) ) {
vr_17 = string . vr_15 ( vr_12 ) ;
if ( fn_5 ( vr_17 ) ) {
if ( ( vr_19 && ! vr_21 ) || vr_20 )
continue;
vr_18 . append ( ' ' ) ;
vr_20 = true ;
}
else if ( ! fn_6 ( vr_17 ) ) {
vr_18 . vr_24 ( vr_17 ) ;
vr_20 = false ;
vr_21 = true ;
}
}
}
public static boolean fn_9 ( final String vr_25 , final String ... vr_26 ) {
final int vr_22 = vr_26 . length ;
for ( int vr_12 = 0 ; vr_12 < vr_22 ; vr_12 ++ ) {
if ( vr_26 [ vr_12 ] . equals ( vr_25 ) ) MST[rv.ABSMutator]MSP[]
return true ;
}
return false ;
}
public static boolean fn_10 ( String vr_25 , String [] vr_26 ) {
return vr_9 . vr_27 ( vr_26 , vr_25 ) >= 0 ;
}
public static tp_1 fn_11 ( tp_1 vr_28 , String vr_29 ) throws vl_1 {
if ( vr_29 . vr_30 ( lr_3 ) )
vr_29 = vr_28 . vr_31 () + vr_29 ;
if ( vr_29 . indexOf ( '.' ) == 0 && vr_28 . vr_32 () . indexOf ( '/' ) != 0 ) {
vr_28 = new tp_1 ( vr_28 . vr_33 () , vr_28 . vr_34 () , vr_28 . vr_35 () , lr_4 + vr_28 . vr_32 () ) ;
}
return new tp_1 ( vr_28 , vr_29 ) ;
}
public static String fn_11 ( final String vr_36 , final String vr_29 ) {
tp_1 vr_28 ;
try {
try {
vr_28 = new tp_1 ( vr_36 ) ;
} catch ( vl_1 vr_37 ) {
tp_1 abs = new tp_1 ( vr_29 ) ;
return abs . vr_38 () ;
}
return fn_11 ( vr_28 , vr_29 ) . vr_38 () ;
} catch ( vl_1 vr_37 ) {
return lr_1 ;
}
}
public static StringBuilder vr_7 () {
synchronized ( vl_2 ) {
return vl_2 . vr_39 () ?
new StringBuilder ( vl_3 ) :
vl_2 . vr_40 () ;
}
}
public static String vr_8 ( StringBuilder vr_5 ) {
vr_41 . vr_42 ( vr_5 ) ;
String string = vr_5 . toString () ;
if ( vr_5 . length () > vl_3 )
vr_5 = new StringBuilder ( vl_3 ) ;
else
vr_5 . vr_43 ( 0 , vr_5 . length () ) ;
synchronized ( vl_2 ) {
vl_2 . vr_44 ( vr_5 ) ;
while ( vl_2 . size () > vl_4 ) {
vl_2 . vr_40 () ;
}
}
return string ;
}

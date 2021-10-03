public static String toString ( final Object array ) {
return toString ( array , lr_1 ) ;
}
public static String toString ( final Object array , final String vr_1 ) {
if ( array == null ) {
return vr_1 ;
}
return new fn_1 ( array , vr_2 . vr_3 ) . append ( array ) . toString () ;
}
public static int fn_2 ( final Object array ) {
return new fn_3 () . append ( array ) . fn_4 () ;
}
@Deprecated
public static boolean fn_5 ( final Object vr_4 , final Object vr_5 ) {
return new fn_6 () . append ( vr_4 , vr_5 ) . fn_5 () ;
}
public static vr_6 < Object , Object > fn_7 ( final Object [] array ) {
if ( array == null ) {
return null ;
}
final vr_6 < Object , Object > vr_7 = new vr_8 < Object , Object > ( (int) ( array . length * 1.5 ) ) ;
for ( int vr_9 = 0 ; vr_9 < array . length ; vr_9 ++ ) {
final Object object = array [ vr_9 ] ;
if ( object instanceof vr_6 . vr_10 < ? , ? > ) {
final vr_6 . vr_10 < ? , ? > vr_11 = ( vr_6 . vr_10 < ? , ? > ) object ;
vr_7 . vr_12 ( vr_11 . vr_13 () , vr_11 . vr_14 () ) ;
} else if ( object instanceof Object [] ) {
final Object [] vr_11 = ( Object [] ) object ;
if ( vr_11 . length < 2 ) {
throw new IllegalArgumentException ( lr_2 + vr_9 + lr_3
+ object
+ lr_4 ) ;
}
vr_7 . vr_12 ( vr_11 [ 0 ] , vr_11 [ 1 ] ) ;
} else {
throw new IllegalArgumentException ( lr_2 + vr_9 + lr_3
+ object
+ lr_5 ) ;
}
}
return vr_7 ;
}
public static < vt_1 > vt_1 [] toArray ( final vt_1 ... vr_15 ) {
return vr_15 ;
}
public static < vt_1 > vt_1 [] fn_8 ( final vt_1 [] array ) {
if ( array == null ) {
return null ;
}
return array . fn_8 () ;
}
public static long [] fn_8 ( final long [] array ) {
if ( array == null ) {
return null ;
}
return array . fn_8 () ;
}
public static int [] fn_8 ( final int [] array ) {
if ( array == null ) {
return null ;
}
return array . fn_8 () ;
}
public static short [] fn_8 ( final short [] array ) {
if ( array == null ) {
return null ;
}
return array . fn_8 () ;
}
public static char [] fn_8 ( final char [] array ) {
if ( array == null ) {
return null ;
}
return array . fn_8 () ;
}
public static byte [] fn_8 ( final byte [] array ) {
if ( array == null ) {
return null ;
}
return array . fn_8 () ;
}
public static double [] fn_8 ( final double [] array ) {
if ( array == null ) {
return null ;
}
return array . fn_8 () ;
}
public static float [] fn_8 ( final float [] array ) {
if ( array == null ) {
return null ;
}
return array . fn_8 () ;
}
public static boolean [] fn_8 ( final boolean [] array ) {
if ( array == null ) {
return null ;
}
return array . fn_8 () ;
}
public static < vt_1 > vt_1 [] fn_9 ( final vt_1 [] array , final Class < vt_1 [] > type ) {
if( type == null ) {
throw new IllegalArgumentException ( lr_6 ) ;
}
if( array == null ) {
return type . vr_16 ( Array . vr_17 ( type . vr_18 () , 0 ) ) ;
}
return array ;
}
public static Object [] fn_9 ( final Object [] array ) {
if ( isEmpty ( array ) ) {
return vl_1 ;
}
return array ;
}
public static Class < ? > [] fn_9 ( final Class < ? > [] array ) {
if ( isEmpty ( array ) ) {
return vl_2 ;
}
return array ;
}
public static String [] fn_9 ( final String [] array ) {
if ( isEmpty ( array ) ) {
return vl_3 ;
}
return array ;
}
public static long [] fn_9 ( final long [] array ) {
if ( isEmpty ( array ) ) {
return vl_4 ;
}
return array ;
}
public static int [] fn_9 ( final int [] array ) {
if ( isEmpty ( array ) ) {
return vl_5 ;
}
return array ;
}
public static short [] fn_9 ( final short [] array ) {
if ( isEmpty ( array ) ) {
return vl_6 ;
}
return array ;
}
public static char [] fn_9 ( final char [] array ) {
if ( isEmpty ( array ) ) {
return vl_7 ;
}
return array ;
}
public static byte [] fn_9 ( final byte [] array ) {
if ( isEmpty ( array ) ) {
return vl_8 ;
}
return array ;
}
public static double [] fn_9 ( final double [] array ) {
if ( isEmpty ( array ) ) {
return vl_9 ;
}
return array ;
}
public static float [] fn_9 ( final float [] array ) {
if ( isEmpty ( array ) ) {
return vl_10 ;
}
return array ;
}
public static boolean [] fn_9 ( final boolean [] array ) {
if ( isEmpty ( array ) ) {
return vl_11 ;
}
return array ;
}
public static Long [] fn_9 ( final Long [] array ) {
if ( isEmpty ( array ) ) {
return vl_12 ;
}
return array ;
}
public static Integer [] fn_9 ( final Integer [] array ) {
if ( isEmpty ( array ) ) {
return vl_13 ;
}
return array ;
}
public static Short [] fn_9 ( final Short [] array ) {
if ( isEmpty ( array ) ) {
return vl_14 ;
}
return array ;
}
public static vr_19 [] fn_9 ( final vr_19 [] array ) {
if ( isEmpty ( array ) ) {
return vl_15 ;
}
return array ;
}
public static Byte [] fn_9 ( final Byte [] array ) {
if ( isEmpty ( array ) ) {
return vl_16 ;
}
return array ;
}
public static Double [] fn_9 ( final Double [] array ) {
if ( isEmpty ( array ) ) {
return vl_17 ;
}
return array ;
}
public static Float [] fn_9 ( final Float [] array ) {
if ( isEmpty ( array ) ) {
return vl_18 ;
}
return array ;
}
public static Boolean [] fn_9 ( final Boolean [] array ) {
if ( isEmpty ( array ) ) {
return vl_19 ;
}
return array ;
}
public static < vt_1 > vt_1 [] fn_10 ( final vt_1 [] array , int vr_20 , int vr_21 ) {
if ( array == null ) {
return null ;
}
if ( vr_20 < 0 ) {
vr_20 = 0 ;
}
if ( vr_21 > array . length ) {
vr_21 = array . length ;
}
final int vr_22 = vr_21 - vr_20 ;
final Class < ? > type = array . getClass () . vr_18 () ;
if ( vr_22 <= 0 ) {
@SuppressWarnings ( lr_7 )
final vt_1 [] vr_23 = ( vt_1 [] ) Array . vr_17 ( type , 0 ) ;
return vr_23 ;
}
@SuppressWarnings ( lr_7 )
final
vt_1 [] fn_10 = ( vt_1 [] ) Array . vr_17 ( type , vr_22 ) ;
System . vr_24 ( array , vr_20 , fn_10 , 0 , vr_22 ) ;
return fn_10 ;
}
public static long [] fn_10 ( final long [] array , int vr_20 , int vr_21 ) {
if ( array == null ) {
return null ;
}
if ( vr_20 < 0 ) {
vr_20 = 0 ;
}
if ( vr_21 > array . length ) {
vr_21 = array . length ;
}
final int vr_22 = vr_21 - vr_20 ;
if ( vr_22 <= 0 ) {
return vl_4 ;
}
final long [] fn_10 = new long [ vr_22 ] ;
System . vr_24 ( array , vr_20 , fn_10 , 0 , vr_22 ) ;
return fn_10 ;
}
public static int [] fn_10 ( final int [] array , int vr_20 , int vr_21 ) {
if ( array == null ) {
return null ;
}
if ( vr_20 < 0 ) {
vr_20 = 0 ;
}
if ( vr_21 > array . length ) {
vr_21 = array . length ;
}
final int vr_22 = vr_21 - vr_20 ;
if ( vr_22 <= 0 ) {
return vl_5 ;
}
final int [] fn_10 = new int [ vr_22 ] ;
System . vr_24 ( array , vr_20 , fn_10 , 0 , vr_22 ) ;
return fn_10 ;
}
public static short [] fn_10 ( final short [] array , int vr_20 , int vr_21 ) {
if ( array == null ) {
return null ;
}
if ( vr_20 < 0 ) {
vr_20 = 0 ;
}
if ( vr_21 > array . length ) {
vr_21 = array . length ;
}
final int vr_22 = vr_21 - vr_20 ;
if ( vr_22 <= 0 ) {
return vl_6 ;
}
final short [] fn_10 = new short [ vr_22 ] ;
System . vr_24 ( array , vr_20 , fn_10 , 0 , vr_22 ) ;
return fn_10 ;
}
public static char [] fn_10 ( final char [] array , int vr_20 , int vr_21 ) {
if ( array == null ) {
return null ;
}
if ( vr_20 < 0 ) {
vr_20 = 0 ;
}
if ( vr_21 > array . length ) {
vr_21 = array . length ;
}
final int vr_22 = vr_21 - vr_20 ;
if ( vr_22 <= 0 ) {
return vl_7 ;
}
final char [] fn_10 = new char [ vr_22 ] ;
System . vr_24 ( array , vr_20 , fn_10 , 0 , vr_22 ) ;
return fn_10 ;
}
public static byte [] fn_10 ( final byte [] array , int vr_20 , int vr_21 ) {
if ( array == null ) {
return null ;
}
if ( vr_20 < 0 ) {
vr_20 = 0 ;
}
if ( vr_21 > array . length ) {
vr_21 = array . length ;
}
final int vr_22 = vr_21 - vr_20 ;
if ( vr_22 <= 0 ) {
return vl_8 ;
}
final byte [] fn_10 = new byte [ vr_22 ] ;
System . vr_24 ( array , vr_20 , fn_10 , 0 , vr_22 ) ;
return fn_10 ;
}
public static double [] fn_10 ( final double [] array , int vr_20 , int vr_21 ) {
if ( array == null ) {
return null ;
}
if ( vr_20 < 0 ) {
vr_20 = 0 ;
}
if ( vr_21 > array . length ) {
vr_21 = array . length ;
}
final int vr_22 = vr_21 - vr_20 ;
if ( vr_22 <= 0 ) {
return vl_9 ;
}
final double [] fn_10 = new double [ vr_22 ] ;
System . vr_24 ( array , vr_20 , fn_10 , 0 , vr_22 ) ;
return fn_10 ;
}
public static float [] fn_10 ( final float [] array , int vr_20 , int vr_21 ) {
if ( array == null ) {
return null ;
}
if ( vr_20 < 0 ) {
vr_20 = 0 ;
}
if ( vr_21 > array . length ) {
vr_21 = array . length ;
}
final int vr_22 = vr_21 - vr_20 ;
if ( vr_22 <= 0 ) {
return vl_10 ;
}
final float [] fn_10 = new float [ vr_22 ] ;
System . vr_24 ( array , vr_20 , fn_10 , 0 , vr_22 ) ;
return fn_10 ;
}
public static boolean [] fn_10 ( final boolean [] array , int vr_20 , int vr_21 ) {
if ( array == null ) {
return null ;
}
if ( vr_20 < 0 ) {
vr_20 = 0 ;
}
if ( vr_21 > array . length ) {
vr_21 = array . length ;
}
final int vr_22 = vr_21 - vr_20 ;
if ( vr_22 <= 0 ) {
return vl_11 ;
}
final boolean [] fn_10 = new boolean [ vr_22 ] ;
System . vr_24 ( array , vr_20 , fn_10 , 0 , vr_22 ) ;
return fn_10 ;
}
public static boolean fn_11 ( final Object [] vr_4 , final Object [] vr_5 ) {
return fn_12 ( vr_4 ) == fn_12 ( vr_5 ) ;
}
public static boolean fn_11 ( final long [] vr_4 , final long [] vr_5 ) {
return fn_12 ( vr_4 ) == fn_12 ( vr_5 ) ;
}
public static boolean fn_11 ( final int [] vr_4 , final int [] vr_5 ) {
return fn_12 ( vr_4 ) == fn_12 ( vr_5 ) ;
}
public static boolean fn_11 ( final short [] vr_4 , final short [] vr_5 ) {
return fn_12 ( vr_4 ) == fn_12 ( vr_5 ) ;
}
public static boolean fn_11 ( final char [] vr_4 , final char [] vr_5 ) {
return fn_12 ( vr_4 ) == fn_12 ( vr_5 ) ;
}
public static boolean fn_11 ( final byte [] vr_4 , final byte [] vr_5 ) {
return fn_12 ( vr_4 ) == fn_12 ( vr_5 ) ;
}
public static boolean fn_11 ( final double [] vr_4 , final double [] vr_5 ) {
return fn_12 ( vr_4 ) == fn_12 ( vr_5 ) ;
}
public static boolean fn_11 ( final float [] vr_4 , final float [] vr_5 ) {
return fn_12 ( vr_4 ) == fn_12 ( vr_5 ) ;
}
public static boolean fn_11 ( final boolean [] vr_4 , final boolean [] vr_5 ) {
return fn_12 ( vr_4 ) == fn_12 ( vr_5 ) ;
}
public static int fn_12 ( final Object array ) {
if ( array == null ) {
return 0 ;
}
return Array . fn_12 ( array ) ;
}
public static boolean fn_13 ( final Object vr_4 , final Object vr_5 ) {
if ( vr_4 == null || vr_5 == null ) {
throw new IllegalArgumentException ( lr_8 ) ;
}
return vr_4 . getClass () . fn_14 () . equals ( vr_5 . getClass () . fn_14 () ) ;
}
public static void fn_15 ( final Object [] array ) {
if ( array == null ) {
return;
}
fn_15 ( array , 0 , array . length ) ;
}
public static void fn_15 ( final long [] array ) {
if ( array == null ) {
return;
}
fn_15 ( array , 0 , array . length ) ;
}
public static void fn_15 ( final int [] array ) {
if ( array == null ) {
return;
}
fn_15 ( array , 0 , array . length ) ;
}
public static void fn_15 ( final short [] array ) {
if ( array == null ) {
return;
}
fn_15 ( array , 0 , array . length ) ;
}
public static void fn_15 ( final char [] array ) {
if ( array == null ) {
return;
}
fn_15 ( array , 0 , array . length ) ;
}
public static void fn_15 ( final byte [] array ) {
if ( array == null ) {
return;
}
fn_15 ( array , 0 , array . length ) ;
}
public static void fn_15 ( final double [] array ) {
if ( array == null ) {
return;
}
fn_15 ( array , 0 , array . length ) ;
}
public static void fn_15 ( final float [] array ) {
if ( array == null ) {
return;
}
fn_15 ( array , 0 , array . length ) ;
}
public static void fn_15 ( final boolean [] array ) {
if ( array == null ) {
return;
}
fn_15 ( array , 0 , array . length ) ;
}
public static void fn_15 ( final boolean [] array , final int vr_20 , final int vr_21 ) {
if ( array == null ) {
return;
}
int vr_9 = vr_20 < 0 ? 0 : vr_20 ;
int vr_25 = vr_26 . vr_27 ( array . length , vr_21 ) - 1 ;
boolean vr_28 ;
while ( vr_25 > vr_9 ) {
vr_28 = array [ vr_25 ] ;
array [ vr_25 ] = array [ vr_9 ] ;
array [ vr_9 ] = vr_28 ;
vr_25 -- ;
vr_9 ++ ;
}
}
public static void fn_15 ( final byte [] array , final int vr_20 , final int vr_21 ) {
if ( array == null ) {
return;
}
int vr_9 = vr_20 < 0 ? 0 : vr_20 ;
int vr_25 = vr_26 . vr_27 ( array . length , vr_21 ) - 1 ;
byte vr_28 ;
while ( vr_25 > vr_9 ) {
vr_28 = array [ vr_25 ] ;
array [ vr_25 ] = array [ vr_9 ] ;
array [ vr_9 ] = vr_28 ;
vr_25 -- ;
vr_9 ++ ;
}
}
public static void fn_15 ( final char [] array , final int vr_20 , final int vr_21 ) {
if ( array == null ) {
return;
}
int vr_9 = vr_20 < 0 ? 0 : vr_20 ;
int vr_25 = vr_26 . vr_27 ( array . length , vr_21 ) - 1 ;
char vr_28 ;
while ( vr_25 > vr_9 ) {
vr_28 = array [ vr_25 ] ;
array [ vr_25 ] = array [ vr_9 ] ;
array [ vr_9 ] = vr_28 ;
vr_25 -- ;
vr_9 ++ ;
}
}
public static void fn_15 ( final double [] array , final int vr_20 , final int vr_21 ) {
if ( array == null ) {
return;
}
int vr_9 = vr_20 < 0 ? 0 : vr_20 ;
int vr_25 = vr_26 . vr_27 ( array . length , vr_21 ) - 1 ;
double vr_28 ;
while ( vr_25 > vr_9 ) {
vr_28 = array [ vr_25 ] ;
array [ vr_25 ] = array [ vr_9 ] ;
array [ vr_9 ] = vr_28 ;
vr_25 -- ;
vr_9 ++ ;
}
}
public static void fn_15 ( final float [] array , final int vr_20 , final int vr_21 ) {
if ( array == null ) {
return;
}
int vr_9 = vr_20 < 0 ? 0 : vr_20 ;
int vr_25 = vr_26 . vr_27 ( array . length , vr_21 ) - 1 ;
float vr_28 ;
while ( vr_25 > vr_9 ) {
vr_28 = array [ vr_25 ] ;
array [ vr_25 ] = array [ vr_9 ] ;
array [ vr_9 ] = vr_28 ;
vr_25 -- ;
vr_9 ++ ;
}
}
public static void fn_15 ( final int [] array , final int vr_20 , final int vr_21 ) {
if ( array == null ) {
return;
}
int vr_9 = vr_20 < 0 ? 0 : vr_20 ;
int vr_25 = vr_26 . vr_27 ( array . length , vr_21 ) - 1 ;
int vr_28 ;
while ( vr_25 > vr_9 ) {
vr_28 = array [ vr_25 ] ;
array [ vr_25 ] = array [ vr_9 ] ;
array [ vr_9 ] = vr_28 ;
vr_25 -- ;
vr_9 ++ ;
}
}
public static void fn_15 ( final long [] array , final int vr_20 , final int vr_21 ) {
if ( array == null ) {
return;
}
int vr_9 = vr_20 < 0 ? 0 : vr_20 ;
int vr_25 = vr_26 . vr_27 ( array . length , vr_21 ) - 1 ;
long vr_28 ;
while ( vr_25 > vr_9 ) {
vr_28 = array [ vr_25 ] ;
array [ vr_25 ] = array [ vr_9 ] ;
array [ vr_9 ] = vr_28 ;
vr_25 -- ;
vr_9 ++ ;
}
}
public static void fn_15 ( final Object [] array , final int vr_20 , final int vr_21 ) {
if ( array == null ) {
return;
}
int vr_9 = vr_20 < 0 ? 0 : vr_20 ;
int vr_25 = vr_26 . vr_27 ( array . length , vr_21 ) - 1 ;
Object vr_28 ;
while ( vr_25 > vr_9 ) {
vr_28 = array [ vr_25 ] ;
array [ vr_25 ] = array [ vr_9 ] ;
array [ vr_9 ] = vr_28 ;
vr_25 -- ;
vr_9 ++ ;
}
}
public static void fn_15 ( final short [] array , final int vr_20 , final int vr_21 ) {
if ( array == null ) {
return;
}
int vr_9 = vr_20 < 0 ? 0 : vr_20 ;
int vr_25 = vr_26 . vr_27 ( array . length , vr_21 ) - 1 ;
short vr_28 ;
while ( vr_25 > vr_9 ) {
vr_28 = array [ vr_25 ] ;
array [ vr_25 ] = array [ vr_9 ] ;
array [ vr_9 ] = vr_28 ;
vr_25 -- ;
vr_9 ++ ;
}
}
public static void fn_16 ( final Object [] array , int vr_29 , int vr_30 ) {
if ( array == null || array . length == 0 ) {
return;
}
fn_16 ( array , vr_29 , vr_30 , 1 ) ;
}
public static void fn_16 ( final long [] array , int vr_29 , int vr_30 ) {
if ( array == null || array . length == 0 ) {
return;
}
fn_16 ( array , vr_29 , vr_30 , 1 ) ;
}
public static void fn_16 ( final int [] array , int vr_29 , int vr_30 ) {
if ( array == null || array . length == 0 ) {
return;
}
fn_16 ( array , vr_29 , vr_30 , 1 ) ;
}
public static void fn_16 ( final short [] array , int vr_29 , int vr_30 ) {
if ( array == null || array . length == 0 ) {
return;
}
fn_16 ( array , vr_29 , vr_30 , 1 ) ;
}
public static void fn_16 ( final char [] array , int vr_29 , int vr_30 ) {
if ( array == null || array . length == 0 ) {
return;
}
fn_16 ( array , vr_29 , vr_30 , 1 ) ;
}
public static void fn_16 ( final byte [] array , int vr_29 , int vr_30 ) {
if ( array == null || array . length == 0 ) {
return;
}
fn_16 ( array , vr_29 , vr_30 , 1 ) ;
}
public static void fn_16 ( final double [] array , int vr_29 , int vr_30 ) {
if ( array == null || array . length == 0 ) {
return;
}
fn_16 ( array , vr_29 , vr_30 , 1 ) ;
}
public static void fn_16 ( final float [] array , int vr_29 , int vr_30 ) {
if ( array == null || array . length == 0 ) {
return;
}
fn_16 ( array , vr_29 , vr_30 , 1 ) ;
}
public static void fn_16 ( final boolean [] array , int vr_29 , int vr_30 ) {
if ( array == null || array . length == 0 ) {
return;
}
fn_16 ( array , vr_29 , vr_30 , 1 ) ;
}
public static void fn_16 ( final boolean [] array , int vr_29 , int vr_30 , int vr_31 ) {
if ( array == null || array . length == 0 || vr_29 >= array . length || vr_30 >= array . length ) {
return;
}
if ( vr_29 < 0 ) {
vr_29 = 0 ;
}
if ( vr_30 < 0 ) {
vr_30 = 0 ;
}
vr_31 = vr_26 . vr_27 ( vr_26 . vr_27 ( vr_31 , array . length - vr_29 ) , array . length - vr_30 ) ;
for ( int vr_9 = 0 ; vr_9 < vr_31 ; vr_9 ++ , vr_29 ++ , vr_30 ++ ) {
boolean vr_32 = array [ vr_29 ] ;
array [ vr_29 ] = array [ vr_30 ] ;
array [ vr_30 ] = vr_32 ;
}
}
public static void fn_16 ( final byte [] array , int vr_29 , int vr_30 , int vr_31 ) {
if ( array == null || array . length == 0 || vr_29 >= array . length || vr_30 >= array . length ) {
return;
}
if ( vr_29 < 0 ) {
vr_29 = 0 ;
}
if ( vr_30 < 0 ) {
vr_30 = 0 ;
}
vr_31 = vr_26 . vr_27 ( vr_26 . vr_27 ( vr_31 , array . length - vr_29 ) , array . length - vr_30 ) ;
for ( int vr_9 = 0 ; vr_9 < vr_31 ; vr_9 ++ , vr_29 ++ , vr_30 ++ ) {
byte vr_32 = array [ vr_29 ] ;
array [ vr_29 ] = array [ vr_30 ] ;
array [ vr_30 ] = vr_32 ;
}
}
public static void fn_16 ( final char [] array , int vr_29 , int vr_30 , int vr_31 ) {
if ( array == null || array . length == 0 || vr_29 >= array . length || vr_30 >= array . length ) {
return;
}
if ( vr_29 < 0 ) {
vr_29 = 0 ;
}
if ( vr_30 < 0 ) {
vr_30 = 0 ;
}
vr_31 = vr_26 . vr_27 ( vr_26 . vr_27 ( vr_31 , array . length - vr_29 ) , array . length - vr_30 ) ;
for ( int vr_9 = 0 ; vr_9 < vr_31 ; vr_9 ++ , vr_29 ++ , vr_30 ++ ) {
char vr_32 = array [ vr_29 ] ;
array [ vr_29 ] = array [ vr_30 ] ;
array [ vr_30 ] = vr_32 ;
}
}
public static void fn_16 ( final double [] array , int vr_29 , int vr_30 , int vr_31 ) {
if ( array == null || array . length == 0 || vr_29 >= array . length || vr_30 >= array . length ) {
return;
}
if ( vr_29 < 0 ) {
vr_29 = 0 ;
}
if ( vr_30 < 0 ) {
vr_30 = 0 ;
}
vr_31 = vr_26 . vr_27 ( vr_26 . vr_27 ( vr_31 , array . length - vr_29 ) , array . length - vr_30 ) ;
for ( int vr_9 = 0 ; vr_9 < vr_31 ; vr_9 ++ , vr_29 ++ , vr_30 ++ ) {
double vr_32 = array [ vr_29 ] ;
array [ vr_29 ] = array [ vr_30 ] ;
array [ vr_30 ] = vr_32 ;
}
}
public static void fn_16 ( final float [] array , int vr_29 , int vr_30 , int vr_31 ) {
if ( array == null || array . length == 0 || vr_29 >= array . length || vr_30 >= array . length ) {
return;
}
if ( vr_29 < 0 ) {
vr_29 = 0 ;
}
if ( vr_30 < 0 ) {
vr_30 = 0 ;
}
vr_31 = vr_26 . vr_27 ( vr_26 . vr_27 ( vr_31 , array . length - vr_29 ) , array . length - vr_30 ) ;
for ( int vr_9 = 0 ; vr_9 < vr_31 ; vr_9 ++ , vr_29 ++ , vr_30 ++ ) {
float vr_32 = array [ vr_29 ] ;
array [ vr_29 ] = array [ vr_30 ] ;
array [ vr_30 ] = vr_32 ;
}
}
public static void fn_16 ( final int [] array , int vr_29 , int vr_30 , int vr_31 ) {
if ( array == null || array . length == 0 || vr_29 >= array . length || vr_30 >= array . length ) {
return;
}
if ( vr_29 < 0 ) {
vr_29 = 0 ;
}
if ( vr_30 < 0 ) {
vr_30 = 0 ;
}
vr_31 = vr_26 . vr_27 ( vr_26 . vr_27 ( vr_31 , array . length - vr_29 ) , array . length - vr_30 ) ;
for ( int vr_9 = 0 ; vr_9 < vr_31 ; vr_9 ++ , vr_29 ++ , vr_30 ++ ) {
int vr_32 = array [ vr_29 ] ;
array [ vr_29 ] = array [ vr_30 ] ;
array [ vr_30 ] = vr_32 ;
}
}
public static void fn_16 ( final long [] array , int vr_29 , int vr_30 , int vr_31 ) {
if ( array == null || array . length == 0 || vr_29 >= array . length || vr_30 >= array . length ) {
return;
}
if ( vr_29 < 0 ) {
vr_29 = 0 ;
}
if ( vr_30 < 0 ) {
vr_30 = 0 ;
}
vr_31 = vr_26 . vr_27 ( vr_26 . vr_27 ( vr_31 , array . length - vr_29 ) , array . length - vr_30 ) ;
for ( int vr_9 = 0 ; vr_9 < vr_31 ; vr_9 ++ , vr_29 ++ , vr_30 ++ ) {
long vr_32 = array [ vr_29 ] ;
array [ vr_29 ] = array [ vr_30 ] ;
array [ vr_30 ] = vr_32 ;
}
}
public static void fn_16 ( final Object [] array , int vr_29 , int vr_30 , int vr_31 ) {
if ( array == null || array . length == 0 || vr_29 >= array . length || vr_30 >= array . length ) {
return;
}
if ( vr_29 < 0 ) {
vr_29 = 0 ;
}
if ( vr_30 < 0 ) {
vr_30 = 0 ;
}
vr_31 = vr_26 . vr_27 ( vr_26 . vr_27 ( vr_31 , array . length - vr_29 ) , array . length - vr_30 ) ;
for ( int vr_9 = 0 ; vr_9 < vr_31 ; vr_9 ++ , vr_29 ++ , vr_30 ++ ) {
Object vr_32 = array [ vr_29 ] ;
array [ vr_29 ] = array [ vr_30 ] ;
array [ vr_30 ] = vr_32 ;
}
}
public static void fn_16 ( final short [] array , int vr_29 , int vr_30 , int vr_31 ) {
if ( array == null || array . length == 0 || vr_29 >= array . length || vr_30 >= array . length ) {
return;
}
if ( vr_29 < 0 ) {
vr_29 = 0 ;
}
if ( vr_30 < 0 ) {
vr_30 = 0 ;
}
if ( vr_29 == vr_30 ) {
return;
}
vr_31 = vr_26 . vr_27 ( vr_26 . vr_27 ( vr_31 , array . length - vr_29 ) , array . length - vr_30 ) ;
for ( int vr_9 = 0 ; vr_9 < vr_31 ; vr_9 ++ , vr_29 ++ , vr_30 ++ ) {
short vr_32 = array [ vr_29 ] ;
array [ vr_29 ] = array [ vr_30 ] ;
array [ vr_30 ] = vr_32 ;
}
}
public static void fn_17 ( final Object [] array , int vr_33 ) {
if ( array == null ) {
return;
}
fn_17 ( array , 0 , array . length , vr_33 ) ;
}
public static void fn_17 ( final long [] array , int vr_33 ) {
if ( array == null ) {
return;
}
fn_17 ( array , 0 , array . length , vr_33 ) ;
}
public static void fn_17 ( final int [] array , int vr_33 ) {
if ( array == null ) {
return;
}
fn_17 ( array , 0 , array . length , vr_33 ) ;
}
public static void fn_17 ( final short [] array , int vr_33 ) {
if ( array == null ) {
return;
}
fn_17 ( array , 0 , array . length , vr_33 ) ;
}
public static void fn_17 ( final char [] array , int vr_33 ) {
if ( array == null ) {
return;
}
fn_17 ( array , 0 , array . length , vr_33 ) ;
}
public static void fn_17 ( final byte [] array , int vr_33 ) {
if ( array == null ) {
return;
}
fn_17 ( array , 0 , array . length , vr_33 ) ;
}
public static void fn_17 ( final double [] array , int vr_33 ) {
if ( array == null ) {
return;
}
fn_17 ( array , 0 , array . length , vr_33 ) ;
}
public static void fn_17 ( final float [] array , int vr_33 ) {
if ( array == null ) {
return;
}
fn_17 ( array , 0 , array . length , vr_33 ) ;
}
public static void fn_17 ( final boolean [] array , int vr_33 ) {
if ( array == null ) {
return;
}
fn_17 ( array , 0 , array . length , vr_33 ) ;
}
public static void fn_17 ( final boolean [] array , int vr_20 , int vr_21 , int vr_33 ) {
if ( array == null ) {
return;
}
if ( vr_20 >= array . length - 1 || vr_21 <= 0 ) {
return;
}
if ( vr_20 < 0 ) {
vr_20 = 0 ;
}
if ( vr_21 >= array . length ) {
vr_21 = array . length ;
}
int vr_34 = vr_21 - vr_20 ;
if ( vr_34 <= 1 ) {
return;
}
vr_33 %= vr_34 ;
if ( vr_33 < 0 ) {
vr_33 += vr_34 ;
}
while ( vr_34 > 1 && vr_33 > 0 ) {
int vr_35 = vr_34 - vr_33 ;
if ( vr_33 > vr_35 ) {
fn_16 ( array , vr_20 , vr_20 + vr_34 - vr_35 , vr_35 ) ;
vr_34 = vr_33 ;
vr_33 -= vr_35 ;
} else if ( vr_33 < vr_35 ) {
fn_16 ( array , vr_20 , vr_20 + vr_35 , vr_33 ) ;
vr_20 += vr_33 ;
vr_34 = vr_35 ;
} else {
fn_16 ( array , vr_20 , vr_20 + vr_35 , vr_33 ) ;
break;
}
}
}
public static void fn_17 ( final byte [] array , int vr_20 , int vr_21 , int vr_33 ) {
if ( array == null ) {
return;
}
if ( vr_20 >= array . length - 1 || vr_21 <= 0 ) {
return;
}
if ( vr_20 < 0 ) {
vr_20 = 0 ;
}
if ( vr_21 >= array . length ) {
vr_21 = array . length ;
}
int vr_34 = vr_21 - vr_20 ;
if ( vr_34 <= 1 ) {
return;
}
vr_33 %= vr_34 ;
if ( vr_33 < 0 ) {
vr_33 += vr_34 ;
}
while ( vr_34 > 1 && vr_33 > 0 ) {
int vr_35 = vr_34 - vr_33 ;
if ( vr_33 > vr_35 ) {
fn_16 ( array , vr_20 , vr_20 + vr_34 - vr_35 , vr_35 ) ;
vr_34 = vr_33 ;
vr_33 -= vr_35 ;
} else if ( vr_33 < vr_35 ) {
fn_16 ( array , vr_20 , vr_20 + vr_35 , vr_33 ) ;
vr_20 += vr_33 ;
vr_34 = vr_35 ;
} else {
fn_16 ( array , vr_20 , vr_20 + vr_35 , vr_33 ) ;
break;
}
}
}
public static void fn_17 ( final char [] array , int vr_20 , int vr_21 , int vr_33 ) {
if ( array == null ) {
return;
}
if ( vr_20 >= array . length - 1 || vr_21 <= 0 ) {
return;
}
if ( vr_20 < 0 ) {
vr_20 = 0 ;
}
if ( vr_21 >= array . length ) {
vr_21 = array . length ;
}
int vr_34 = vr_21 - vr_20 ;
if ( vr_34 <= 1 ) {
return;
}
vr_33 %= vr_34 ;
if ( vr_33 < 0 ) {
vr_33 += vr_34 ;
}
while ( vr_34 > 1 && vr_33 > 0 ) {
int vr_35 = vr_34 - vr_33 ;
if ( vr_33 > vr_35 ) {
fn_16 ( array , vr_20 , vr_20 + vr_34 - vr_35 , vr_35 ) ;
vr_34 = vr_33 ;
vr_33 -= vr_35 ;
} else if ( vr_33 < vr_35 ) {
fn_16 ( array , vr_20 , vr_20 + vr_35 , vr_33 ) ;
vr_20 += vr_33 ;
vr_34 = vr_35 ;
} else {
fn_16 ( array , vr_20 , vr_20 + vr_35 , vr_33 ) ;
break;
}
}
}
public static void fn_17 ( final double [] array , int vr_20 , int vr_21 , int vr_33 ) {
if ( array == null ) {
return;
}
if ( vr_20 >= array . length - 1 || vr_21 <= 0 ) {
return;
}
if ( vr_20 < 0 ) {
vr_20 = 0 ;
}
if ( vr_21 >= array . length ) {
vr_21 = array . length ;
}
int vr_34 = vr_21 - vr_20 ;
if ( vr_34 <= 1 ) {
return;
}
vr_33 %= vr_34 ;
if ( vr_33 < 0 ) {
vr_33 += vr_34 ;
}
while ( vr_34 > 1 && vr_33 > 0 ) {
int vr_35 = vr_34 - vr_33 ;
if ( vr_33 > vr_35 ) {
fn_16 ( array , vr_20 , vr_20 + vr_34 - vr_35 , vr_35 ) ;
vr_34 = vr_33 ;
vr_33 -= vr_35 ;
} else if ( vr_33 < vr_35 ) {
fn_16 ( array , vr_20 , vr_20 + vr_35 , vr_33 ) ;
vr_20 += vr_33 ;
vr_34 = vr_35 ;
} else {
fn_16 ( array , vr_20 , vr_20 + vr_35 , vr_33 ) ;
break;
}
}
}
public static void fn_17 ( final float [] array , int vr_20 , int vr_21 , int vr_33 ) {
if ( array == null ) {
return;
}
if ( vr_20 >= array . length - 1 || vr_21 <= 0 ) {
return;
}
if ( vr_20 < 0 ) {
vr_20 = 0 ;
}
if ( vr_21 >= array . length ) {
vr_21 = array . length ;
}
int vr_34 = vr_21 - vr_20 ;
if ( vr_34 <= 1 ) {
return;
}
vr_33 %= vr_34 ;
if ( vr_33 < 0 ) {
vr_33 += vr_34 ;
}
while ( vr_34 > 1 && vr_33 > 0 ) {
int vr_35 = vr_34 - vr_33 ;
if ( vr_33 > vr_35 ) {
fn_16 ( array , vr_20 , vr_20 + vr_34 - vr_35 , vr_35 ) ;
vr_34 = vr_33 ;
vr_33 -= vr_35 ;
} else if ( vr_33 < vr_35 ) {
fn_16 ( array , vr_20 , vr_20 + vr_35 , vr_33 ) ;
vr_20 += vr_33 ;
vr_34 = vr_35 ;
} else {
fn_16 ( array , vr_20 , vr_20 + vr_35 , vr_33 ) ;
break;
}
}
}
public static void fn_17 ( final int [] array , int vr_20 , int vr_21 , int vr_33 ) {
if ( array == null ) {
return;
}
if ( vr_20 >= array . length - 1 || vr_21 <= 0 ) {
return;
}
if ( vr_20 < 0 ) {
vr_20 = 0 ;
}
if ( vr_21 >= array . length ) {
vr_21 = array . length ;
}
int vr_34 = vr_21 - vr_20 ;
if ( vr_34 <= 1 ) {
return;
}
vr_33 %= vr_34 ;
if ( vr_33 < 0 ) {
vr_33 += vr_34 ;
}
while ( vr_34 > 1 && vr_33 > 0 ) {
int vr_35 = vr_34 - vr_33 ;
if ( vr_33 > vr_35 ) {
fn_16 ( array , vr_20 , vr_20 + vr_34 - vr_35 , vr_35 ) ;
vr_34 = vr_33 ;
vr_33 -= vr_35 ;
} else if ( vr_33 < vr_35 ) {
fn_16 ( array , vr_20 , vr_20 + vr_35 , vr_33 ) ;
vr_20 += vr_33 ;
vr_34 = vr_35 ;
} else {
fn_16 ( array , vr_20 , vr_20 + vr_35 , vr_33 ) ;
break;
}
}
}
public static void fn_17 ( final long [] array , int vr_20 , int vr_21 , int vr_33 ) {
if ( array == null ) {
return;
}
if ( vr_20 >= array . length - 1 || vr_21 <= 0 ) {
return;
}
if ( vr_20 < 0 ) {
vr_20 = 0 ;
}
if ( vr_21 >= array . length ) {
vr_21 = array . length ;
}
int vr_34 = vr_21 - vr_20 ;
if ( vr_34 <= 1 ) {
return;
}
vr_33 %= vr_34 ;
if ( vr_33 < 0 ) {
vr_33 += vr_34 ;
}
while ( vr_34 > 1 && vr_33 > 0 ) {
int vr_35 = vr_34 - vr_33 ;
if ( vr_33 > vr_35 ) {
fn_16 ( array , vr_20 , vr_20 + vr_34 - vr_35 , vr_35 ) ;
vr_34 = vr_33 ;
vr_33 -= vr_35 ;
} else if ( vr_33 < vr_35 ) {
fn_16 ( array , vr_20 , vr_20 + vr_35 , vr_33 ) ;
vr_20 += vr_33 ;
vr_34 = vr_35 ;
} else {
fn_16 ( array , vr_20 , vr_20 + vr_35 , vr_33 ) ;
break;
}
}
}
public static void fn_17 ( final Object [] array , int vr_20 , int vr_21 , int vr_33 ) {
if ( array == null ) {
return;
}
if ( vr_20 >= array . length - 1 || vr_21 <= 0 ) {
return;
}
if ( vr_20 < 0 ) {
vr_20 = 0 ;
}
if ( vr_21 >= array . length ) {
vr_21 = array . length ;
}
int vr_34 = vr_21 - vr_20 ;
if ( vr_34 <= 1 ) {
return;
}
vr_33 %= vr_34 ;
if ( vr_33 < 0 ) {
vr_33 += vr_34 ;
}
while ( vr_34 > 1 && vr_33 > 0 ) {
int vr_35 = vr_34 - vr_33 ;
if ( vr_33 > vr_35 ) {
fn_16 ( array , vr_20 , vr_20 + vr_34 - vr_35 , vr_35 ) ;
vr_34 = vr_33 ;
vr_33 -= vr_35 ;
} else if ( vr_33 < vr_35 ) {
fn_16 ( array , vr_20 , vr_20 + vr_35 , vr_33 ) ;
vr_20 += vr_33 ;
vr_34 = vr_35 ;
} else {
fn_16 ( array , vr_20 , vr_20 + vr_35 , vr_33 ) ;
break;
}
}
}
public static void fn_17 ( final short [] array , int vr_20 , int vr_21 , int vr_33 ) {
if ( array == null ) {
return;
}
if ( vr_20 >= array . length - 1 || vr_21 <= 0 ) {
return;
}
if ( vr_20 < 0 ) {
vr_20 = 0 ;
}
if ( vr_21 >= array . length ) {
vr_21 = array . length ;
}
int vr_34 = vr_21 - vr_20 ;
if ( vr_34 <= 1 ) {
return;
}
vr_33 %= vr_34 ;
if ( vr_33 < 0 ) {
vr_33 += vr_34 ;
}
while ( vr_34 > 1 && vr_33 > 0 ) {
int vr_35 = vr_34 - vr_33 ;
if ( vr_33 > vr_35 ) {
fn_16 ( array , vr_20 , vr_20 + vr_34 - vr_35 , vr_35 ) ;
vr_34 = vr_33 ;
vr_33 -= vr_35 ;
} else if ( vr_33 < vr_35 ) {
fn_16 ( array , vr_20 , vr_20 + vr_35 , vr_33 ) ;
vr_20 += vr_33 ;
vr_34 = vr_35 ;
} else {
fn_16 ( array , vr_20 , vr_20 + vr_35 , vr_33 ) ;
break;
}
}
}
public static int indexOf ( final Object [] array , final Object vr_36 ) {
return indexOf ( array , vr_36 , 0 ) ;
}
public static int indexOf ( final Object [] array , final Object vr_36 , int vr_37 ) {
if ( array == null ) {
return vl_20 ;
}
if ( vr_37 < 0 ) {
vr_37 = 0 ;
}
if ( vr_36 == null ) {
for ( int vr_9 = vr_37 ; vr_9 < array . length ; vr_9 ++ ) {
if ( array [ vr_9 ] == null ) {
return vr_9 ;
}
}
} else if ( array . getClass () . vr_18 () . fn_18 ( vr_36 ) ) {
for ( int vr_9 = vr_37 ; vr_9 < array . length ; vr_9 ++ ) {
if ( vr_36 . equals ( array [ vr_9 ] ) ) {
return vr_9 ;
}
}
}
return vl_20 ;
}
public static int fn_19 ( final Object [] array , final Object vr_36 ) {
return fn_19 ( array , vr_36 , Integer . vr_38 ) ;
}
public static int fn_19 ( final Object [] array , final Object vr_36 , int vr_37 ) {
if ( array == null ) {
return vl_20 ;
}
if ( vr_37 < 0 ) {
return vl_20 ;
} else if ( vr_37 >= array . length ) {
vr_37 = array . length - 1 ;
}
if ( vr_36 == null ) {
for ( int vr_9 = vr_37 ; vr_9 >= 0 ; vr_9 -- ) {
if ( array [ vr_9 ] == null ) {
return vr_9 ;
}
}
} else if ( array . getClass () . vr_18 () . fn_18 ( vr_36 ) ) {
for ( int vr_9 = vr_37 ; vr_9 >= 0 ; vr_9 -- ) {
if ( vr_36 . equals ( array [ vr_9 ] ) ) {
return vr_9 ;
}
}
}
return vl_20 ;
}
public static boolean contains ( final Object [] array , final Object vr_36 ) {
return indexOf ( array , vr_36 ) != vl_20 ;
}
public static int indexOf ( final long [] array , final long vr_39 ) {
return indexOf ( array , vr_39 , 0 ) ;
}
public static int indexOf ( final long [] array , final long vr_39 , int vr_37 ) {
if ( array == null ) {
return vl_20 ;
}
if ( vr_37 < 0 ) {
vr_37 = 0 ;
}
for ( int vr_9 = vr_37 ; vr_9 < array . length ; vr_9 ++ ) {
if ( vr_39 == array [ vr_9 ] ) {
return vr_9 ;
}
}
return vl_20 ;
}
public static int fn_19 ( final long [] array , final long vr_39 ) {
return fn_19 ( array , vr_39 , Integer . vr_38 ) ;
}
public static int fn_19 ( final long [] array , final long vr_39 , int vr_37 ) {
if ( array == null ) {
return vl_20 ;
}
if ( vr_37 < 0 ) {
return vl_20 ;
} else if ( vr_37 >= array . length ) {
vr_37 = array . length - 1 ;
}
for ( int vr_9 = vr_37 ; vr_9 >= 0 ; vr_9 -- ) {
if ( vr_39 == array [ vr_9 ] ) {
return vr_9 ;
}
}
return vl_20 ;
}
public static boolean contains ( final long [] array , final long vr_39 ) {
return indexOf ( array , vr_39 ) != vl_20 ;
}
public static int indexOf ( final int [] array , final int vr_39 ) {
return indexOf ( array , vr_39 , 0 ) ;
}
public static int indexOf ( final int [] array , final int vr_39 , int vr_37 ) {
if ( array == null ) {
return vl_20 ;
}
if ( vr_37 < 0 ) {
vr_37 = 0 ;
}
for ( int vr_9 = vr_37 ; vr_9 < array . length ; vr_9 ++ ) {
if ( vr_39 == array [ vr_9 ] ) {
return vr_9 ;
}
}
return vl_20 ;
}
public static int fn_19 ( final int [] array , final int vr_39 ) {
return fn_19 ( array , vr_39 , Integer . vr_38 ) ;
}
public static int fn_19 ( final int [] array , final int vr_39 , int vr_37 ) {
if ( array == null ) {
return vl_20 ;
}
if ( vr_37 < 0 ) {
return vl_20 ;
} else if ( vr_37 >= array . length ) {
vr_37 = array . length - 1 ;
}
for ( int vr_9 = vr_37 ; vr_9 >= 0 ; vr_9 -- ) {
if ( vr_39 == array [ vr_9 ] ) {
return vr_9 ;
}
}
return vl_20 ;
}
public static boolean contains ( final int [] array , final int vr_39 ) {
return indexOf ( array , vr_39 ) != vl_20 ;
}
public static int indexOf ( final short [] array , final short vr_39 ) {
return indexOf ( array , vr_39 , 0 ) ;
}
public static int indexOf ( final short [] array , final short vr_39 , int vr_37 ) {
if ( array == null ) {
return vl_20 ;
}
if ( vr_37 < 0 ) {
vr_37 = 0 ;
}
for ( int vr_9 = vr_37 ; vr_9 < array . length ; vr_9 ++ ) {
if ( vr_39 == array [ vr_9 ] ) {
return vr_9 ;
}
}
return vl_20 ;
}
public static int fn_19 ( final short [] array , final short vr_39 ) {
return fn_19 ( array , vr_39 , Integer . vr_38 ) ;
}
public static int fn_19 ( final short [] array , final short vr_39 , int vr_37 ) {
if ( array == null ) {
return vl_20 ;
}
if ( vr_37 < 0 ) {
return vl_20 ;
} else if ( vr_37 >= array . length ) {
vr_37 = array . length - 1 ;
}
for ( int vr_9 = vr_37 ; vr_9 >= 0 ; vr_9 -- ) {
if ( vr_39 == array [ vr_9 ] ) {
return vr_9 ;
}
}
return vl_20 ;
}
public static boolean contains ( final short [] array , final short vr_39 ) {
return indexOf ( array , vr_39 ) != vl_20 ;
}
public static int indexOf ( final char [] array , final char vr_39 ) {
return indexOf ( array , vr_39 , 0 ) ;
}
public static int indexOf ( final char [] array , final char vr_39 , int vr_37 ) {
if ( array == null ) {
return vl_20 ;
}
if ( vr_37 < 0 ) {
vr_37 = 0 ;
}
for ( int vr_9 = vr_37 ; vr_9 < array . length ; vr_9 ++ ) {
if ( vr_39 == array [ vr_9 ] ) {
return vr_9 ;
}
}
return vl_20 ;
}
public static int fn_19 ( final char [] array , final char vr_39 ) {
return fn_19 ( array , vr_39 , Integer . vr_38 ) ;
}
public static int fn_19 ( final char [] array , final char vr_39 , int vr_37 ) {
if ( array == null ) {
return vl_20 ;
}
if ( vr_37 < 0 ) {
return vl_20 ;
} else if ( vr_37 >= array . length ) {
vr_37 = array . length - 1 ;
}
for ( int vr_9 = vr_37 ; vr_9 >= 0 ; vr_9 -- ) {
if ( vr_39 == array [ vr_9 ] ) {
return vr_9 ;
}
}
return vl_20 ;
}
public static boolean contains ( final char [] array , final char vr_39 ) {
return indexOf ( array , vr_39 ) != vl_20 ;
}
public static int indexOf ( final byte [] array , final byte vr_39 ) {
return indexOf ( array , vr_39 , 0 ) ;
}
public static int indexOf ( final byte [] array , final byte vr_39 , int vr_37 ) {
if ( array == null ) {
return vl_20 ;
}
if ( vr_37 < 0 ) {
vr_37 = 0 ;
}
for ( int vr_9 = vr_37 ; vr_9 < array . length ; vr_9 ++ ) {
if ( vr_39 == array [ vr_9 ] ) {
return vr_9 ;
}
}
return vl_20 ;
}
public static int fn_19 ( final byte [] array , final byte vr_39 ) {
return fn_19 ( array , vr_39 , Integer . vr_38 ) ;
}
public static int fn_19 ( final byte [] array , final byte vr_39 , int vr_37 ) {
if ( array == null ) {
return vl_20 ;
}
if ( vr_37 < 0 ) {
return vl_20 ;
} else if ( vr_37 >= array . length ) {
vr_37 = array . length - 1 ;
}
for ( int vr_9 = vr_37 ; vr_9 >= 0 ; vr_9 -- ) {
if ( vr_39 == array [ vr_9 ] ) {
return vr_9 ;
}
}
return vl_20 ;
}
public static boolean contains ( final byte [] array , final byte vr_39 ) {
return indexOf ( array , vr_39 ) != vl_20 ;
}
public static int indexOf ( final double [] array , final double vr_39 ) {
return indexOf ( array , vr_39 , 0 ) ;
}
public static int indexOf ( final double [] array , final double vr_39 , final double vr_40 ) {
return indexOf ( array , vr_39 , 0 , vr_40 ) ;
}
public static int indexOf ( final double [] array , final double vr_39 , int vr_37 ) {
if ( vr_41 . isEmpty ( array ) ) {
return vl_20 ;
}
if ( vr_37 < 0 ) {
vr_37 = 0 ;
}
for ( int vr_9 = vr_37 ; vr_9 < array . length ; vr_9 ++ ) {
if ( vr_39 == array [ vr_9 ] ) {
return vr_9 ;
}
}
return vl_20 ;
}
public static int indexOf ( final double [] array , final double vr_39 , int vr_37 , final double vr_40 ) {
if ( vr_41 . isEmpty ( array ) ) {
return vl_20 ;
}
if ( vr_37 < 0 ) {
vr_37 = 0 ;
}
final double vr_27 = vr_39 - vr_40 ;
final double vr_42 = vr_39 + vr_40 ;
for ( int vr_9 = vr_37 ; vr_9 < array . length ; vr_9 ++ ) {
if ( array [ vr_9 ] >= vr_27 && array [ vr_9 ] <= vr_42 ) {
return vr_9 ;
}
}
return vl_20 ;
}
public static int fn_19 ( final double [] array , final double vr_39 ) {
return fn_19 ( array , vr_39 , Integer . vr_38 ) ;
}
public static int fn_19 ( final double [] array , final double vr_39 , final double vr_40 ) {
return fn_19 ( array , vr_39 , Integer . vr_38 , vr_40 ) ;
}
public static int fn_19 ( final double [] array , final double vr_39 , int vr_37 ) {
if ( vr_41 . isEmpty ( array ) ) {
return vl_20 ;
}
if ( vr_37 < 0 ) {
return vl_20 ;
} else if ( vr_37 >= array . length ) {
vr_37 = array . length - 1 ;
}
for ( int vr_9 = vr_37 ; vr_9 >= 0 ; vr_9 -- ) {
if ( vr_39 == array [ vr_9 ] ) {
return vr_9 ;
}
}
return vl_20 ;
}
public static int fn_19 ( final double [] array , final double vr_39 , int vr_37 , final double vr_40 ) {
if ( vr_41 . isEmpty ( array ) ) {
return vl_20 ;
}
if ( vr_37 < 0 ) {
return vl_20 ;
} else if ( vr_37 >= array . length ) {
vr_37 = array . length - 1 ;
}
final double vr_27 = vr_39 - vr_40 ;
final double vr_42 = vr_39 + vr_40 ;
for ( int vr_9 = vr_37 ; vr_9 >= 0 ; vr_9 -- ) {
if ( array [ vr_9 ] >= vr_27 && array [ vr_9 ] <= vr_42 ) {
return vr_9 ;
}
}
return vl_20 ;
}
public static boolean contains ( final double [] array , final double vr_39 ) {
return indexOf ( array , vr_39 ) != vl_20 ;
}
public static boolean contains ( final double [] array , final double vr_39 , final double vr_40 ) {
return indexOf ( array , vr_39 , 0 , vr_40 ) != vl_20 ;
}
public static int indexOf ( final float [] array , final float vr_39 ) {
return indexOf ( array , vr_39 , 0 ) ;
}
public static int indexOf ( final float [] array , final float vr_39 , int vr_37 ) {
if ( vr_41 . isEmpty ( array ) ) {
return vl_20 ;
}
if ( vr_37 < 0 ) {
vr_37 = 0 ;
}
for ( int vr_9 = vr_37 ; vr_9 < array . length ; vr_9 ++ ) {
if ( vr_39 == array [ vr_9 ] ) {
return vr_9 ;
}
}
return vl_20 ;
}
public static int fn_19 ( final float [] array , final float vr_39 ) {
return fn_19 ( array , vr_39 , Integer . vr_38 ) ;
}
public static int fn_19 ( final float [] array , final float vr_39 , int vr_37 ) {
if ( vr_41 . isEmpty ( array ) ) {
return vl_20 ;
}
if ( vr_37 < 0 ) {
return vl_20 ;
} else if ( vr_37 >= array . length ) {
vr_37 = array . length - 1 ;
}
for ( int vr_9 = vr_37 ; vr_9 >= 0 ; vr_9 -- ) {
if ( vr_39 == array [ vr_9 ] ) {
return vr_9 ;
}
}
return vl_20 ;
}
public static boolean contains ( final float [] array , final float vr_39 ) {
return indexOf ( array , vr_39 ) != vl_20 ;
}
public static int indexOf ( final boolean [] array , final boolean vr_39 ) {
return indexOf ( array , vr_39 , 0 ) ;
}
public static int indexOf ( final boolean [] array , final boolean vr_39 , int vr_37 ) {
if ( vr_41 . isEmpty ( array ) ) {
return vl_20 ;
}
if ( vr_37 < 0 ) {
vr_37 = 0 ;
}
for ( int vr_9 = vr_37 ; vr_9 < array . length ; vr_9 ++ ) {
if ( vr_39 == array [ vr_9 ] ) {
return vr_9 ;
}
}
return vl_20 ;
}
public static int fn_19 ( final boolean [] array , final boolean vr_39 ) {
return fn_19 ( array , vr_39 , Integer . vr_38 ) ;
}
public static int fn_19 ( final boolean [] array , final boolean vr_39 , int vr_37 ) {
if ( vr_41 . isEmpty ( array ) ) {
return vl_20 ;
}
if ( vr_37 < 0 ) {
return vl_20 ;
} else if ( vr_37 >= array . length ) {
vr_37 = array . length - 1 ;
}
for ( int vr_9 = vr_37 ; vr_9 >= 0 ; vr_9 -- ) {
if ( vr_39 == array [ vr_9 ] ) {
return vr_9 ;
}
}
return vl_20 ;
}
public static boolean contains ( final boolean [] array , final boolean vr_39 ) {
return indexOf ( array , vr_39 ) != vl_20 ;
}
public static char [] fn_20 ( final vr_19 [] array ) {
if ( array == null ) {
return null ;
} else if ( array . length == 0 ) {
return vl_7 ;
}
final char [] vr_43 = new char [ array . length ] ;
for ( int vr_9 = 0 ; vr_9 < array . length ; vr_9 ++ ) {
vr_43 [ vr_9 ] = array [ vr_9 ] . fn_21 () ;
}
return vr_43 ;
}
public static char [] fn_20 ( final vr_19 [] array , final char vr_44 ) {
if ( array == null ) {
return null ;
} else if ( array . length == 0 ) {
return vl_7 ;
}
final char [] vr_43 = new char [ array . length ] ;
for ( int vr_9 = 0 ; vr_9 < array . length ; vr_9 ++ ) {
final vr_19 vr_45 = array [ vr_9 ] ;
vr_43 [ vr_9 ] = ( vr_45 == null ? vr_44 : vr_45 . fn_21 () ) ;
}
return vr_43 ;
}
public static vr_19 [] fn_22 ( final char [] array ) {
if ( array == null ) {
return null ;
} else if ( array . length == 0 ) {
return vl_15 ;
}
final vr_19 [] vr_43 = new vr_19 [ array . length ] ;
for ( int vr_9 = 0 ; vr_9 < array . length ; vr_9 ++ ) {
vr_43 [ vr_9 ] = vr_19 . valueOf ( array [ vr_9 ] ) ;
}
return vr_43 ;
}
public static long [] fn_20 ( final Long [] array ) {
if ( array == null ) {
return null ;
} else if ( array . length == 0 ) {
return vl_4 ;
}
final long [] vr_43 = new long [ array . length ] ;
for ( int vr_9 = 0 ; vr_9 < array . length ; vr_9 ++ ) {
vr_43 [ vr_9 ] = array [ vr_9 ] . fn_23 () ;
}
return vr_43 ;
}
public static long [] fn_20 ( final Long [] array , final long vr_44 ) {
if ( array == null ) {
return null ;
} else if ( array . length == 0 ) {
return vl_4 ;
}
final long [] vr_43 = new long [ array . length ] ;
for ( int vr_9 = 0 ; vr_9 < array . length ; vr_9 ++ ) {
final Long vr_45 = array [ vr_9 ] ;
vr_43 [ vr_9 ] = ( vr_45 == null ? vr_44 : vr_45 . fn_23 () ) ;
}
return vr_43 ;
}
public static Long [] fn_22 ( final long [] array ) {
if ( array == null ) {
return null ;
} else if ( array . length == 0 ) {
return vl_12 ;
}
final Long [] vr_43 = new Long [ array . length ] ;
for ( int vr_9 = 0 ; vr_9 < array . length ; vr_9 ++ ) {
vr_43 [ vr_9 ] = Long . valueOf ( array [ vr_9 ] ) ;
}
return vr_43 ;
}
public static int [] fn_20 ( final Integer [] array ) {
if ( array == null ) {
return null ;
} else if ( array . length == 0 ) {
return vl_5 ;
}
final int [] vr_43 = new int [ array . length ] ;
for ( int vr_9 = 0 ; vr_9 < array . length ; vr_9 ++ ) {
vr_43 [ vr_9 ] = array [ vr_9 ] . fn_24 () ;
}
return vr_43 ;
}
public static int [] fn_20 ( final Integer [] array , final int vr_44 ) {
if ( array == null ) {
return null ;
} else if ( array . length == 0 ) {
return vl_5 ;
}
final int [] vr_43 = new int [ array . length ] ;
for ( int vr_9 = 0 ; vr_9 < array . length ; vr_9 ++ ) {
final Integer vr_45 = array [ vr_9 ] ;
vr_43 [ vr_9 ] = ( vr_45 == null ? vr_44 : vr_45 . fn_24 () ) ;
}
return vr_43 ;
}
public static Integer [] fn_22 ( final int [] array ) {
if ( array == null ) {
return null ;
} else if ( array . length == 0 ) {
return vl_13 ;
}
final Integer [] vr_43 = new Integer [ array . length ] ;
for ( int vr_9 = 0 ; vr_9 < array . length ; vr_9 ++ ) {
vr_43 [ vr_9 ] = Integer . valueOf ( array [ vr_9 ] ) ;
}
return vr_43 ;
}
public static short [] fn_20 ( final Short [] array ) {
if ( array == null ) {
return null ;
} else if ( array . length == 0 ) {
return vl_6 ;
}
final short [] vr_43 = new short [ array . length ] ;
for ( int vr_9 = 0 ; vr_9 < array . length ; vr_9 ++ ) {
vr_43 [ vr_9 ] = array [ vr_9 ] . fn_25 () ;
}
return vr_43 ;
}
public static short [] fn_20 ( final Short [] array , final short vr_44 ) {
if ( array == null ) {
return null ;
} else if ( array . length == 0 ) {
return vl_6 ;
}
final short [] vr_43 = new short [ array . length ] ;
for ( int vr_9 = 0 ; vr_9 < array . length ; vr_9 ++ ) {
final Short vr_45 = array [ vr_9 ] ;
vr_43 [ vr_9 ] = ( vr_45 == null ? vr_44 : vr_45 . fn_25 () ) ;
}
return vr_43 ;
}
public static Short [] fn_22 ( final short [] array ) {
if ( array == null ) {
return null ;
} else if ( array . length == 0 ) {
return vl_14 ;
}
final Short [] vr_43 = new Short [ array . length ] ;
for ( int vr_9 = 0 ; vr_9 < array . length ; vr_9 ++ ) {
vr_43 [ vr_9 ] = Short . valueOf ( array [ vr_9 ] ) ;
}
return vr_43 ;
}
public static byte [] fn_20 ( final Byte [] array ) {
if ( array == null ) {
return null ;
} else if ( array . length == 0 ) {
return vl_8 ;
}
final byte [] vr_43 = new byte [ array . length ] ;
for ( int vr_9 = 0 ; vr_9 < array . length ; vr_9 ++ ) {
vr_43 [ vr_9 ] = array [ vr_9 ] . fn_26 () ;
}
return vr_43 ;
}
public static byte [] fn_20 ( final Byte [] array , final byte vr_44 ) {
if ( array == null ) {
return null ;
} else if ( array . length == 0 ) {
return vl_8 ;
}
final byte [] vr_43 = new byte [ array . length ] ;
for ( int vr_9 = 0 ; vr_9 < array . length ; vr_9 ++ ) {
final Byte vr_45 = array [ vr_9 ] ;
vr_43 [ vr_9 ] = ( vr_45 == null ? vr_44 : vr_45 . fn_26 () ) ;
}
return vr_43 ;
}
public static Byte [] fn_22 ( final byte [] array ) {
if ( array == null ) {
return null ;
} else if ( array . length == 0 ) {
return vl_16 ;
}
final Byte [] vr_43 = new Byte [ array . length ] ;
for ( int vr_9 = 0 ; vr_9 < array . length ; vr_9 ++ ) {
vr_43 [ vr_9 ] = Byte . valueOf ( array [ vr_9 ] ) ;
}
return vr_43 ;
}
public static double [] fn_20 ( final Double [] array ) {
if ( array == null ) {
return null ;
} else if ( array . length == 0 ) {
return vl_9 ;
}
final double [] vr_43 = new double [ array . length ] ;
for ( int vr_9 = 0 ; vr_9 < array . length ; vr_9 ++ ) {
vr_43 [ vr_9 ] = array [ vr_9 ] . fn_27 () ;
}
return vr_43 ;
}
public static double [] fn_20 ( final Double [] array , final double vr_44 ) {
if ( array == null ) {
return null ;
} else if ( array . length == 0 ) {
return vl_9 ;
}
final double [] vr_43 = new double [ array . length ] ;
for ( int vr_9 = 0 ; vr_9 < array . length ; vr_9 ++ ) {
final Double vr_45 = array [ vr_9 ] ;
vr_43 [ vr_9 ] = ( vr_45 == null ? vr_44 : vr_45 . fn_27 () ) ;
}
return vr_43 ;
}
public static Double [] fn_22 ( final double [] array ) {
if ( array == null ) {
return null ;
} else if ( array . length == 0 ) {
return vl_17 ;
}
final Double [] vr_43 = new Double [ array . length ] ;
for ( int vr_9 = 0 ; vr_9 < array . length ; vr_9 ++ ) {
vr_43 [ vr_9 ] = Double . valueOf ( array [ vr_9 ] ) ;
}
return vr_43 ;
}
public static float [] fn_20 ( final Float [] array ) {
if ( array == null ) {
return null ;
} else if ( array . length == 0 ) {
return vl_10 ;
}
final float [] vr_43 = new float [ array . length ] ;
for ( int vr_9 = 0 ; vr_9 < array . length ; vr_9 ++ ) {
vr_43 [ vr_9 ] = array [ vr_9 ] . fn_28 () ;
}
return vr_43 ;
}
public static float [] fn_20 ( final Float [] array , final float vr_44 ) {
if ( array == null ) {
return null ;
} else if ( array . length == 0 ) {
return vl_10 ;
}
final float [] vr_43 = new float [ array . length ] ;
for ( int vr_9 = 0 ; vr_9 < array . length ; vr_9 ++ ) {
final Float vr_45 = array [ vr_9 ] ;
vr_43 [ vr_9 ] = ( vr_45 == null ? vr_44 : vr_45 . fn_28 () ) ;
}
return vr_43 ;
}
public static Float [] fn_22 ( final float [] array ) {
if ( array == null ) {
return null ;
} else if ( array . length == 0 ) {
return vl_18 ;
}
final Float [] vr_43 = new Float [ array . length ] ;
for ( int vr_9 = 0 ; vr_9 < array . length ; vr_9 ++ ) {
vr_43 [ vr_9 ] = Float . valueOf ( array [ vr_9 ] ) ;
}
return vr_43 ;
}
public static boolean [] fn_20 ( final Boolean [] array ) {
if ( array == null ) {
return null ;
} else if ( array . length == 0 ) {
return vl_11 ;
}
final boolean [] vr_43 = new boolean [ array . length ] ;
for ( int vr_9 = 0 ; vr_9 < array . length ; vr_9 ++ ) {
vr_43 [ vr_9 ] = array [ vr_9 ] . fn_29 () ;
}
return vr_43 ;
}
public static boolean [] fn_20 ( final Boolean [] array , final boolean vr_44 ) {
if ( array == null ) {
return null ;
} else if ( array . length == 0 ) {
return vl_11 ;
}
final boolean [] vr_43 = new boolean [ array . length ] ;
for ( int vr_9 = 0 ; vr_9 < array . length ; vr_9 ++ ) {
final Boolean vr_45 = array [ vr_9 ] ;
vr_43 [ vr_9 ] = ( vr_45 == null ? vr_44 : vr_45 . fn_29 () ) ;
}
return vr_43 ;
}
public static Boolean [] fn_22 ( final boolean [] array ) {
if ( array == null ) {
return null ;
} else if ( array . length == 0 ) {
return vl_19 ;
}
final Boolean [] vr_43 = new Boolean [ array . length ] ;
for ( int vr_9 = 0 ; vr_9 < array . length ; vr_9 ++ ) {
vr_43 [ vr_9 ] = ( array [ vr_9 ] ? Boolean . TRUE : Boolean . FALSE ) ;
}
return vr_43 ;
}
public static boolean isEmpty ( final Object [] array ) {
return fn_12 ( array ) == 0 ;
}
public static boolean isEmpty ( final long [] array ) {
return fn_12 ( array ) == 0 ;
}
public static boolean isEmpty ( final int [] array ) {
return fn_12 ( array ) == 0 ;
}
public static boolean isEmpty ( final short [] array ) {
return fn_12 ( array ) == 0 ;
}
public static boolean isEmpty ( final char [] array ) {
return fn_12 ( array ) == 0 ;
}
public static boolean isEmpty ( final byte [] array ) {
return fn_12 ( array ) == 0 ;
}
public static boolean isEmpty ( final double [] array ) {
return fn_12 ( array ) == 0 ;
}
public static boolean isEmpty ( final float [] array ) {
return fn_12 ( array ) == 0 ;
}
public static boolean isEmpty ( final boolean [] array ) {
return fn_12 ( array ) == 0 ;
}
public static < vt_1 > boolean fn_30 ( final vt_1 [] array ) {
return ! isEmpty ( array ) ;
}
public static boolean fn_30 ( final long [] array ) {
return ! isEmpty ( array ) ;
}
public static boolean fn_30 ( final int [] array ) {
return ! isEmpty ( array ) ;
}
public static boolean fn_30 ( final short [] array ) {
return ! isEmpty ( array ) ;
}
public static boolean fn_30 ( final char [] array ) {
return ! isEmpty ( array ) ;
}
public static boolean fn_30 ( final byte [] array ) {
return ! isEmpty ( array ) ;
}
public static boolean fn_30 ( final double [] array ) {
return ! isEmpty ( array ) ;
}
public static boolean fn_30 ( final float [] array ) {
return ! isEmpty ( array ) ;
}
public static boolean fn_30 ( final boolean [] array ) {
return ! isEmpty ( array ) ;
}
public static < vt_1 > vt_1 [] fn_31 ( final vt_1 [] vr_4 , final vt_1 ... vr_5 ) {
if ( vr_4 == null ) {
return fn_8 ( vr_5 ) ;
} else if ( vr_5 == null ) {
return fn_8 ( vr_4 ) ;
}
final Class < ? > vr_46 = vr_4 . getClass () . vr_18 () ;
@SuppressWarnings ( lr_7 )
final
vt_1 [] vr_47 = ( vt_1 [] ) Array . vr_17 ( vr_46 , vr_4 . length + vr_5 . length ) ;
System . vr_24 ( vr_4 , 0 , vr_47 , 0 , vr_4 . length ) ;
try {
System . vr_24 ( vr_5 , 0 , vr_47 , vr_4 . length , vr_5 . length ) ;
} catch ( final tp_1 vr_48 ) {
final Class < ? > vr_49 = vr_5 . getClass () . vr_18 () ;
if ( ! vr_46 . vr_50 ( vr_49 ) ) {
throw new IllegalArgumentException ( lr_9 + vr_49 . fn_14 () + lr_10
+ vr_46 . fn_14 () , vr_48 ) ;
}
throw vr_48 ;
}
return vr_47 ;
}
public static boolean [] fn_31 ( final boolean [] vr_4 , final boolean ... vr_5 ) {
if ( vr_4 == null ) {
return fn_8 ( vr_5 ) ;
} else if ( vr_5 == null ) {
return fn_8 ( vr_4 ) ;
}
final boolean [] vr_47 = new boolean [ vr_4 . length + vr_5 . length ] ;
System . vr_24 ( vr_4 , 0 , vr_47 , 0 , vr_4 . length ) ;
System . vr_24 ( vr_5 , 0 , vr_47 , vr_4 . length , vr_5 . length ) ;
return vr_47 ;
}
public static char [] fn_31 ( final char [] vr_4 , final char ... vr_5 ) {
if ( vr_4 == null ) {
return fn_8 ( vr_5 ) ;
} else if ( vr_5 == null ) {
return fn_8 ( vr_4 ) ;
}
final char [] vr_47 = new char [ vr_4 . length + vr_5 . length ] ;
System . vr_24 ( vr_4 , 0 , vr_47 , 0 , vr_4 . length ) ;
System . vr_24 ( vr_5 , 0 , vr_47 , vr_4 . length , vr_5 . length ) ;
return vr_47 ;
}
public static byte [] fn_31 ( final byte [] vr_4 , final byte ... vr_5 ) {
if ( vr_4 == null ) {
return fn_8 ( vr_5 ) ;
} else if ( vr_5 == null ) {
return fn_8 ( vr_4 ) ;
}
final byte [] vr_47 = new byte [ vr_4 . length + vr_5 . length ] ;
System . vr_24 ( vr_4 , 0 , vr_47 , 0 , vr_4 . length ) ;
System . vr_24 ( vr_5 , 0 , vr_47 , vr_4 . length , vr_5 . length ) ;
return vr_47 ;
}
public static short [] fn_31 ( final short [] vr_4 , final short ... vr_5 ) {
if ( vr_4 == null ) {
return fn_8 ( vr_5 ) ;
} else if ( vr_5 == null ) {
return fn_8 ( vr_4 ) ;
}
final short [] vr_47 = new short [ vr_4 . length + vr_5 . length ] ;
System . vr_24 ( vr_4 , 0 , vr_47 , 0 , vr_4 . length ) ;
System . vr_24 ( vr_5 , 0 , vr_47 , vr_4 . length , vr_5 . length ) ;
return vr_47 ;
}
public static int [] fn_31 ( final int [] vr_4 , final int ... vr_5 ) {
if ( vr_4 == null ) {
return fn_8 ( vr_5 ) ;
} else if ( vr_5 == null ) {
return fn_8 ( vr_4 ) ;
}
final int [] vr_47 = new int [ vr_4 . length + vr_5 . length ] ;
System . vr_24 ( vr_4 , 0 , vr_47 , 0 , vr_4 . length ) ;
System . vr_24 ( vr_5 , 0 , vr_47 , vr_4 . length , vr_5 . length ) ;
return vr_47 ;
}
public static long [] fn_31 ( final long [] vr_4 , final long ... vr_5 ) {
if ( vr_4 == null ) {
return fn_8 ( vr_5 ) ;
} else if ( vr_5 == null ) {
return fn_8 ( vr_4 ) ;
}
final long [] vr_47 = new long [ vr_4 . length + vr_5 . length ] ;
System . vr_24 ( vr_4 , 0 , vr_47 , 0 , vr_4 . length ) ;
System . vr_24 ( vr_5 , 0 , vr_47 , vr_4 . length , vr_5 . length ) ;
return vr_47 ;
}
public static float [] fn_31 ( final float [] vr_4 , final float ... vr_5 ) {
if ( vr_4 == null ) {
return fn_8 ( vr_5 ) ;
} else if ( vr_5 == null ) {
return fn_8 ( vr_4 ) ;
}
final float [] vr_47 = new float [ vr_4 . length + vr_5 . length ] ;
System . vr_24 ( vr_4 , 0 , vr_47 , 0 , vr_4 . length ) ;
System . vr_24 ( vr_5 , 0 , vr_47 , vr_4 . length , vr_5 . length ) ;
return vr_47 ;
}
public static double [] fn_31 ( final double [] vr_4 , final double ... vr_5 ) {
if ( vr_4 == null ) {
return fn_8 ( vr_5 ) ;
} else if ( vr_5 == null ) {
return fn_8 ( vr_4 ) ;
}
final double [] vr_47 = new double [ vr_4 . length + vr_5 . length ] ;
System . vr_24 ( vr_4 , 0 , vr_47 , 0 , vr_4 . length ) ;
System . vr_24 ( vr_5 , 0 , vr_47 , vr_4 . length , vr_5 . length ) ;
return vr_47 ;
}
public static < vt_1 > vt_1 [] add ( final vt_1 [] array , final vt_1 vr_51 ) {
Class < ? > type ;
if ( array != null ) {
type = array . getClass () . vr_18 () ;
} else if ( vr_51 != null ) {
type = vr_51 . getClass () ;
} else {
throw new IllegalArgumentException ( lr_11 ) ;
}
@SuppressWarnings ( lr_7 )
final
vt_1 [] vr_52 = ( vt_1 [] ) fn_32 ( array , type ) ;
vr_52 [ vr_52 . length - 1 ] = vr_51 ;
return vr_52 ;
}
public static boolean [] add ( final boolean [] array , final boolean vr_51 ) {
final boolean [] vr_52 = ( boolean [] ) fn_32 ( array , Boolean . TYPE ) ;
vr_52 [ vr_52 . length - 1 ] = vr_51 ;
return vr_52 ;
}
public static byte [] add ( final byte [] array , final byte vr_51 ) {
final byte [] vr_52 = ( byte [] ) fn_32 ( array , Byte . TYPE ) ;
vr_52 [ vr_52 . length - 1 ] = vr_51 ;
return vr_52 ;
}
public static char [] add ( final char [] array , final char vr_51 ) {
final char [] vr_52 = ( char [] ) fn_32 ( array , vr_19 . TYPE ) ;
vr_52 [ vr_52 . length - 1 ] = vr_51 ;
return vr_52 ;
}
public static double [] add ( final double [] array , final double vr_51 ) {
final double [] vr_52 = ( double [] ) fn_32 ( array , Double . TYPE ) ;
vr_52 [ vr_52 . length - 1 ] = vr_51 ;
return vr_52 ;
}
public static float [] add ( final float [] array , final float vr_51 ) {
final float [] vr_52 = ( float [] ) fn_32 ( array , Float . TYPE ) ;
vr_52 [ vr_52 . length - 1 ] = vr_51 ;
return vr_52 ;
}
public static int [] add ( final int [] array , final int vr_51 ) {
final int [] vr_52 = ( int [] ) fn_32 ( array , Integer . TYPE ) ;
vr_52 [ vr_52 . length - 1 ] = vr_51 ;
return vr_52 ;
}
public static long [] add ( final long [] array , final long vr_51 ) {
final long [] vr_52 = ( long [] ) fn_32 ( array , Long . TYPE ) ;
vr_52 [ vr_52 . length - 1 ] = vr_51 ;
return vr_52 ;
}
public static short [] add ( final short [] array , final short vr_51 ) {
final short [] vr_52 = ( short [] ) fn_32 ( array , Short . TYPE ) ;
vr_52 [ vr_52 . length - 1 ] = vr_51 ;
return vr_52 ;
}
private static Object fn_32 ( final Object array , final Class < ? > vr_53 ) {
if ( array != null ) {
final int vr_54 = Array . fn_12 ( array ) ;
final Object vr_52 = Array . vr_17 ( array . getClass () . vr_18 () , vr_54 + 1 ) ;
System . vr_24 ( array , 0 , vr_52 , 0 , vr_54 ) ;
return vr_52 ;
}
return Array . vr_17 ( vr_53 , 1 ) ;
}
public static < vt_1 > vt_1 [] add ( final vt_1 [] array , final int vr_55 , final vt_1 vr_51 ) {
Class < ? > vr_56 = null ;
if ( array != null ) {
vr_56 = array . getClass () . vr_18 () ;
} else if ( vr_51 != null ) {
vr_56 = vr_51 . getClass () ;
} else {
throw new IllegalArgumentException ( lr_12 ) ;
}
@SuppressWarnings ( lr_7 )
final vt_1 [] vr_52 = ( vt_1 [] ) add ( array , vr_55 , vr_51 , vr_56 ) ;
return vr_52 ;
}
public static boolean [] add ( final boolean [] array , final int vr_55 , final boolean vr_51 ) {
return ( boolean [] ) add ( array , vr_55 , Boolean . valueOf ( vr_51 ) , Boolean . TYPE ) ;
}
public static char [] add ( final char [] array , final int vr_55 , final char vr_51 ) {
return ( char [] ) add ( array , vr_55 , vr_19 . valueOf ( vr_51 ) , vr_19 . TYPE ) ;
}
public static byte [] add ( final byte [] array , final int vr_55 , final byte vr_51 ) {
return ( byte [] ) add ( array , vr_55 , Byte . valueOf ( vr_51 ) , Byte . TYPE ) ;
}
public static short [] add ( final short [] array , final int vr_55 , final short vr_51 ) {
return ( short [] ) add ( array , vr_55 , Short . valueOf ( vr_51 ) , Short . TYPE ) ;
}
public static int [] add ( final int [] array , final int vr_55 , final int vr_51 ) {
return ( int [] ) add ( array , vr_55 , Integer . valueOf ( vr_51 ) , Integer . TYPE ) ;
}
public static long [] add ( final long [] array , final int vr_55 , final long vr_51 ) {
return ( long [] ) add ( array , vr_55 , Long . valueOf ( vr_51 ) , Long . TYPE ) ;
}
public static float [] add ( final float [] array , final int vr_55 , final float vr_51 ) {
return ( float [] ) add ( array , vr_55 , Float . valueOf ( vr_51 ) , Float . TYPE ) ;
}
public static double [] add ( final double [] array , final int vr_55 , final double vr_51 ) {
return ( double [] ) add ( array , vr_55 , Double . valueOf ( vr_51 ) , Double . TYPE ) ;
}
private static Object add ( final Object array , final int vr_55 , final Object vr_51 , final Class < ? > vr_56 ) {
if ( array == null ) {
if ( vr_55 != 0 ) {
throw new fn_33 ( lr_13 + vr_55 + lr_14 ) ;
}
final Object vr_47 = Array . vr_17 ( vr_56 , 1 ) ;
Array . vr_57 ( vr_47 , 0 , vr_51 ) ;
return vr_47 ;
}
final int length = Array . fn_12 ( array ) ;
if ( vr_55 > length || vr_55 < 0 ) {
throw new fn_33 ( lr_13 + vr_55 + lr_15 + length ) ;
}
final Object vr_43 = Array . vr_17 ( vr_56 , length + 1 ) ;
System . vr_24 ( array , 0 , vr_43 , 0 , vr_55 ) ;
Array . vr_57 ( vr_43 , vr_55 , vr_51 ) ;
if ( vr_55 < length ) {
System . vr_24 ( array , vr_55 , vr_43 , vr_55 + 1 , length - vr_55 ) ;
}
return vr_43 ;
}
@SuppressWarnings ( lr_7 )
public static < vt_1 > vt_1 [] remove ( final vt_1 [] array , final int vr_55 ) {
return ( vt_1 [] ) remove ( ( Object ) array , vr_55 ) ;
}
public static < vt_1 > vt_1 [] fn_34 ( final vt_1 [] array , final Object vr_51 ) {
final int vr_55 = indexOf ( array , vr_51 ) ;
if ( vr_55 == vl_20 ) {
return fn_8 ( array ) ;
}
return remove ( array , vr_55 ) ;
}
public static boolean [] remove ( final boolean [] array , final int vr_55 ) {
return ( boolean [] ) remove ( ( Object ) array , vr_55 ) ;
}
public static boolean [] fn_34 ( final boolean [] array , final boolean vr_51 ) {
final int vr_55 = indexOf ( array , vr_51 ) ;
if ( vr_55 == vl_20 ) {
return fn_8 ( array ) ;
}
return remove ( array , vr_55 ) ;
}
public static byte [] remove ( final byte [] array , final int vr_55 ) {
return ( byte [] ) remove ( ( Object ) array , vr_55 ) ;
}
public static byte [] fn_34 ( final byte [] array , final byte vr_51 ) {
final int vr_55 = indexOf ( array , vr_51 ) ;
if ( vr_55 == vl_20 ) {
return fn_8 ( array ) ;
}
return remove ( array , vr_55 ) ;
}
public static char [] remove ( final char [] array , final int vr_55 ) {
return ( char [] ) remove ( ( Object ) array , vr_55 ) ;
}
public static char [] fn_34 ( final char [] array , final char vr_51 ) {
final int vr_55 = indexOf ( array , vr_51 ) ;
if ( vr_55 == vl_20 ) {
return fn_8 ( array ) ;
}
return remove ( array , vr_55 ) ;
}
public static double [] remove ( final double [] array , final int vr_55 ) {
return ( double [] ) remove ( ( Object ) array , vr_55 ) ;
}
public static double [] fn_34 ( final double [] array , final double vr_51 ) {
final int vr_55 = indexOf ( array , vr_51 ) ;
if ( vr_55 == vl_20 ) {
return fn_8 ( array ) ;
}
return remove ( array , vr_55 ) ;
}
public static float [] remove ( final float [] array , final int vr_55 ) {
return ( float [] ) remove ( ( Object ) array , vr_55 ) ;
}
public static float [] fn_34 ( final float [] array , final float vr_51 ) {
final int vr_55 = indexOf ( array , vr_51 ) ;
if ( vr_55 == vl_20 ) {
return fn_8 ( array ) ;
}
return remove ( array , vr_55 ) ;
}
public static int [] remove ( final int [] array , final int vr_55 ) {
return ( int [] ) remove ( ( Object ) array , vr_55 ) ;
}
public static int [] fn_34 ( final int [] array , final int vr_51 ) {
final int vr_55 = indexOf ( array , vr_51 ) ;
if ( vr_55 == vl_20 ) {
return fn_8 ( array ) ;
}
return remove ( array , vr_55 ) ;
}
public static long [] remove ( final long [] array , final int vr_55 ) {
return ( long [] ) remove ( ( Object ) array , vr_55 ) ;
}
public static long [] fn_34 ( final long [] array , final long vr_51 ) {
final int vr_55 = indexOf ( array , vr_51 ) ;
if ( vr_55 == vl_20 ) {
return fn_8 ( array ) ;
}
return remove ( array , vr_55 ) ;
}
public static short [] remove ( final short [] array , final int vr_55 ) {
return ( short [] ) remove ( ( Object ) array , vr_55 ) ;
}
public static short [] fn_34 ( final short [] array , final short vr_51 ) {
final int vr_55 = indexOf ( array , vr_51 ) ;
if ( vr_55 == vl_20 ) {
return fn_8 ( array ) ;
}
return remove ( array , vr_55 ) ;
}
private static Object remove ( final Object array , final int vr_55 ) {
final int length = fn_12 ( array ) ;
if ( vr_55 < 0 || vr_55 >= length ) {
throw new fn_33 ( lr_13 + vr_55 + lr_15 + length ) ;
}
final Object vr_43 = Array . vr_17 ( array . getClass () . vr_18 () , length - 1 ) ;
System . vr_24 ( array , 0 , vr_43 , 0 , vr_55 ) ;
if ( vr_55 < length - 1 ) {
System . vr_24 ( array , vr_55 + 1 , vr_43 , vr_55 , length - vr_55 - 1 ) ;
}
return vr_43 ;
}
@SuppressWarnings ( lr_7 )
public static < vt_1 > vt_1 [] fn_35 ( final vt_1 [] array , final int ... vr_58 ) {
return ( vt_1 [] ) fn_35 ( ( Object ) array , fn_8 ( vr_58 ) ) ;
}
public static < vt_1 > vt_1 [] fn_36 ( final vt_1 [] array , final vt_1 ... vr_59 ) {
if ( isEmpty ( array ) || isEmpty ( vr_59 ) ) {
return fn_8 ( array ) ;
}
final vr_8 < vt_1 , vt_2 > vr_60 = new vr_8 < vt_1 , vt_2 > ( vr_59 . length ) ;
for ( final vt_1 vr_61 : vr_59 ) {
final vt_2 vr_62 = vr_60 . get ( vr_61 ) ;
if ( vr_62 == null ) {
vr_60 . vr_12 ( vr_61 , new vt_2 ( 1 ) ) ;
} else {
vr_62 . vr_63 () ;
}
}
final tp_2 vr_64 = new tp_2 () ;
for ( final vr_6 . vr_10 < vt_1 , vt_2 > vr_65 : vr_60 . vr_66 () ) {
final vt_1 vr_61 = vr_65 . vr_13 () ;
int vr_67 = 0 ;
for ( int vr_9 = 0 , vr_68 = vr_65 . vr_14 () . fn_24 () ; vr_9 < vr_68 ; vr_9 ++ ) {
vr_67 = indexOf ( array , vr_61 , vr_67 ) ;
if ( vr_67 < 0 ) {
break;
}
vr_64 . vr_57 ( vr_67 ++ ) ;
}
}
@SuppressWarnings ( lr_7 )
final
vt_1 [] vr_43 = ( vt_1 [] ) fn_35 ( array , vr_64 ) ;
return vr_43 ;
}
public static byte [] fn_35 ( final byte [] array , final int ... vr_58 ) {
return ( byte [] ) fn_35 ( ( Object ) array , fn_8 ( vr_58 ) ) ;
}
public static byte [] fn_36 ( final byte [] array , final byte ... vr_59 ) {
if ( isEmpty ( array ) || isEmpty ( vr_59 ) ) {
return fn_8 ( array ) ;
}
final vr_6 < Byte , vt_2 > vr_60 = new vr_8 < Byte , vt_2 > ( vr_59 . length ) ;
for ( final byte vr_61 : vr_59 ) {
final Byte vr_69 = Byte . valueOf ( vr_61 ) ;
final vt_2 vr_62 = vr_60 . get ( vr_69 ) ;
if ( vr_62 == null ) {
vr_60 . vr_12 ( vr_69 , new vt_2 ( 1 ) ) ;
} else {
vr_62 . vr_63 () ;
}
}
final tp_2 vr_64 = new tp_2 () ;
for ( final vr_6 . vr_10 < Byte , vt_2 > vr_65 : vr_60 . vr_66 () ) {
final Byte vr_61 = vr_65 . vr_13 () ;
int vr_67 = 0 ;
for ( int vr_9 = 0 , vr_68 = vr_65 . vr_14 () . fn_24 () ; vr_9 < vr_68 ; vr_9 ++ ) {
vr_67 = indexOf ( array , vr_61 . fn_26 () , vr_67 ) ;
if ( vr_67 < 0 ) {
break;
}
vr_64 . vr_57 ( vr_67 ++ ) ;
}
}
return ( byte [] ) fn_35 ( array , vr_64 ) ;
}
public static short [] fn_35 ( final short [] array , final int ... vr_58 ) {
return ( short [] ) fn_35 ( ( Object ) array , fn_8 ( vr_58 ) ) ;
}
public static short [] fn_36 ( final short [] array , final short ... vr_59 ) {
if ( isEmpty ( array ) || isEmpty ( vr_59 ) ) {
return fn_8 ( array ) ;
}
final vr_8 < Short , vt_2 > vr_60 = new vr_8 < Short , vt_2 > ( vr_59 . length ) ;
for ( final short vr_61 : vr_59 ) {
final Short vr_69 = Short . valueOf ( vr_61 ) ;
final vt_2 vr_62 = vr_60 . get ( vr_69 ) ;
if ( vr_62 == null ) {
vr_60 . vr_12 ( vr_69 , new vt_2 ( 1 ) ) ;
} else {
vr_62 . vr_63 () ;
}
}
final tp_2 vr_64 = new tp_2 () ;
for ( final vr_6 . vr_10 < Short , vt_2 > vr_65 : vr_60 . vr_66 () ) {
final Short vr_61 = vr_65 . vr_13 () ;
int vr_67 = 0 ;
for ( int vr_9 = 0 , vr_68 = vr_65 . vr_14 () . fn_24 () ; vr_9 < vr_68 ; vr_9 ++ ) {
vr_67 = indexOf ( array , vr_61 . fn_25 () , vr_67 ) ;
if ( vr_67 < 0 ) {
break;
}
vr_64 . vr_57 ( vr_67 ++ ) ;
}
}
return ( short [] ) fn_35 ( array , vr_64 ) ;
}
public static int [] fn_35 ( final int [] array , final int ... vr_58 ) {
return ( int [] ) fn_35 ( ( Object ) array , fn_8 ( vr_58 ) ) ;
}
public static int [] fn_36 ( final int [] array , final int ... vr_59 ) {
if ( isEmpty ( array ) || isEmpty ( vr_59 ) ) {
return fn_8 ( array ) ;
}
final vr_8 < Integer , vt_2 > vr_60 = new vr_8 < Integer , vt_2 > ( vr_59 . length ) ;
for ( final int vr_61 : vr_59 ) {
final Integer vr_69 = Integer . valueOf ( vr_61 ) ;
final vt_2 vr_62 = vr_60 . get ( vr_69 ) ;
if ( vr_62 == null ) {
vr_60 . vr_12 ( vr_69 , new vt_2 ( 1 ) ) ;
} else {
vr_62 . vr_63 () ;
}
}
final tp_2 vr_64 = new tp_2 () ;
for ( final vr_6 . vr_10 < Integer , vt_2 > vr_65 : vr_60 . vr_66 () ) {
final Integer vr_61 = vr_65 . vr_13 () ;
int vr_67 = 0 ;
for ( int vr_9 = 0 , vr_68 = vr_65 . vr_14 () . fn_24 () ; vr_9 < vr_68 ; vr_9 ++ ) {
vr_67 = indexOf ( array , vr_61 . fn_24 () , vr_67 ) ;
if ( vr_67 < 0 ) {
break;
}
vr_64 . vr_57 ( vr_67 ++ ) ;
}
}
return ( int [] ) fn_35 ( array , vr_64 ) ;
}
public static char [] fn_35 ( final char [] array , final int ... vr_58 ) {
return ( char [] ) fn_35 ( ( Object ) array , fn_8 ( vr_58 ) ) ;
}
public static char [] fn_36 ( final char [] array , final char ... vr_59 ) {
if ( isEmpty ( array ) || isEmpty ( vr_59 ) ) {
return fn_8 ( array ) ;
}
final vr_8 < vr_19 , vt_2 > vr_60 = new vr_8 < vr_19 , vt_2 > ( vr_59 . length ) ;
for ( final char vr_61 : vr_59 ) {
final vr_19 vr_69 = vr_19 . valueOf ( vr_61 ) ;
final vt_2 vr_62 = vr_60 . get ( vr_69 ) ;
if ( vr_62 == null ) {
vr_60 . vr_12 ( vr_69 , new vt_2 ( 1 ) ) ;
} else {
vr_62 . vr_63 () ;
}
}
final tp_2 vr_64 = new tp_2 () ;
for ( final vr_6 . vr_10 < vr_19 , vt_2 > vr_65 : vr_60 . vr_66 () ) {
final vr_19 vr_61 = vr_65 . vr_13 () ;
int vr_67 = 0 ;
for ( int vr_9 = 0 , vr_68 = vr_65 . vr_14 () . fn_24 () ; vr_9 < vr_68 ; vr_9 ++ ) {
vr_67 = indexOf ( array , vr_61 . fn_21 () , vr_67 ) ;
if ( vr_67 < 0 ) {
break;
}
vr_64 . vr_57 ( vr_67 ++ ) ;
}
}
return ( char [] ) fn_35 ( array , vr_64 ) ;
}
public static long [] fn_35 ( final long [] array , final int ... vr_58 ) {
return ( long [] ) fn_35 ( ( Object ) array , fn_8 ( vr_58 ) ) ;
}
public static long [] fn_36 ( final long [] array , final long ... vr_59 ) {
if ( isEmpty ( array ) || isEmpty ( vr_59 ) ) {
return fn_8 ( array ) ;
}
final vr_8 < Long , vt_2 > vr_60 = new vr_8 < Long , vt_2 > ( vr_59 . length ) ;
for ( final long vr_61 : vr_59 ) {
final Long vr_69 = Long . valueOf ( vr_61 ) ;
final vt_2 vr_62 = vr_60 . get ( vr_69 ) ;
if ( vr_62 == null ) {
vr_60 . vr_12 ( vr_69 , new vt_2 ( 1 ) ) ;
} else {
vr_62 . vr_63 () ;
}
}
final tp_2 vr_64 = new tp_2 () ;
for ( final vr_6 . vr_10 < Long , vt_2 > vr_65 : vr_60 . vr_66 () ) {
final Long vr_61 = vr_65 . vr_13 () ;
int vr_67 = 0 ;
for ( int vr_9 = 0 , vr_68 = vr_65 . vr_14 () . fn_24 () ; vr_9 < vr_68 ; vr_9 ++ ) {
vr_67 = indexOf ( array , vr_61 . fn_23 () , vr_67 ) ;
if ( vr_67 < 0 ) {
break;
}
vr_64 . vr_57 ( vr_67 ++ ) ;
}
}
return ( long [] ) fn_35 ( array , vr_64 ) ;
}
public static float [] fn_35 ( final float [] array , final int ... vr_58 ) {
return ( float [] ) fn_35 ( ( Object ) array , fn_8 ( vr_58 ) ) ;
}
public static float [] fn_36 ( final float [] array , final float ... vr_59 ) {
if ( isEmpty ( array ) || isEmpty ( vr_59 ) ) {
return fn_8 ( array ) ;
}
final vr_8 < Float , vt_2 > vr_60 = new vr_8 < Float , vt_2 > ( vr_59 . length ) ;
for ( final float vr_61 : vr_59 ) {
final Float vr_69 = Float . valueOf ( vr_61 ) ;
final vt_2 vr_62 = vr_60 . get ( vr_69 ) ;
if ( vr_62 == null ) {
vr_60 . vr_12 ( vr_69 , new vt_2 ( 1 ) ) ;
} else {
vr_62 . vr_63 () ;
}
}
final tp_2 vr_64 = new tp_2 () ;
for ( final vr_6 . vr_10 < Float , vt_2 > vr_65 : vr_60 . vr_66 () ) {
final Float vr_61 = vr_65 . vr_13 () ;
int vr_67 = 0 ;
for ( int vr_9 = 0 , vr_68 = vr_65 . vr_14 () . fn_24 () ; vr_9 < vr_68 ; vr_9 ++ ) {
vr_67 = indexOf ( array , vr_61 . fn_28 () , vr_67 ) ;
if ( vr_67 < 0 ) {
break;
}
vr_64 . vr_57 ( vr_67 ++ ) ;
}
}
return ( float [] ) fn_35 ( array , vr_64 ) ;
}
public static double [] fn_35 ( final double [] array , final int ... vr_58 ) {
return ( double [] ) fn_35 ( ( Object ) array , fn_8 ( vr_58 ) ) ;
}
public static double [] fn_36 ( final double [] array , final double ... vr_59 ) {
if ( isEmpty ( array ) || isEmpty ( vr_59 ) ) {
return fn_8 ( array ) ;
}
final vr_8 < Double , vt_2 > vr_60 = new vr_8 < Double , vt_2 > ( vr_59 . length ) ;
for ( final double vr_61 : vr_59 ) {
final Double vr_69 = Double . valueOf ( vr_61 ) ;
final vt_2 vr_62 = vr_60 . get ( vr_69 ) ;
if ( vr_62 == null ) {
vr_60 . vr_12 ( vr_69 , new vt_2 ( 1 ) ) ;
} else {
vr_62 . vr_63 () ;
}
}
final tp_2 vr_64 = new tp_2 () ;
for ( final vr_6 . vr_10 < Double , vt_2 > vr_65 : vr_60 . vr_66 () ) {
final Double vr_61 = vr_65 . vr_13 () ;
int vr_67 = 0 ;
for ( int vr_9 = 0 , vr_68 = vr_65 . vr_14 () . fn_24 () ; vr_9 < vr_68 ; vr_9 ++ ) {
vr_67 = indexOf ( array , vr_61 . fn_27 () , vr_67 ) ;
if ( vr_67 < 0 ) {
break;
}
vr_64 . vr_57 ( vr_67 ++ ) ;
}
}
return ( double [] ) fn_35 ( array , vr_64 ) ;
}
public static boolean [] fn_35 ( final boolean [] array , final int ... vr_58 ) {
return ( boolean [] ) fn_35 ( ( Object ) array , fn_8 ( vr_58 ) ) ;
}
public static boolean [] fn_36 ( final boolean [] array , final boolean ... vr_59 ) {
if ( isEmpty ( array ) || isEmpty ( vr_59 ) ) {
return fn_8 ( array ) ;
}
final vr_8 < Boolean , vt_2 > vr_60 = new vr_8 < Boolean , vt_2 > ( 2 ) ;
for ( final boolean vr_61 : vr_59 ) {
final Boolean vr_69 = Boolean . valueOf ( vr_61 ) ;
final vt_2 vr_62 = vr_60 . get ( vr_69 ) ;
if ( vr_62 == null ) {
vr_60 . vr_12 ( vr_69 , new vt_2 ( 1 ) ) ;
} else {
vr_62 . vr_63 () ;
}
}
final tp_2 vr_64 = new tp_2 () ;
for ( final vr_6 . vr_10 < Boolean , vt_2 > vr_65 : vr_60 . vr_66 () ) {
final Boolean vr_61 = vr_65 . vr_13 () ;
int vr_67 = 0 ;
for ( int vr_9 = 0 , vr_68 = vr_65 . vr_14 () . fn_24 () ; vr_9 < vr_68 ; vr_9 ++ ) {
vr_67 = indexOf ( array , vr_61 . fn_29 () , vr_67 ) ;
if ( vr_67 < 0 ) {
break;
}
vr_64 . vr_57 ( vr_67 ++ ) ;
}
}
return ( boolean [] ) fn_35 ( array , vr_64 ) ;
}
static Object fn_35 ( final Object array , final int ... vr_58 ) {
final int length = fn_12 ( array ) ;
int vr_70 = 0 ;
if ( fn_30 ( vr_58 ) ) {
vr_71 . vr_72 ( vr_58 ) ;
int vr_9 = vr_58 . length ;
int vr_73 = length ;
while ( -- vr_9 >= 0 ) {
final int vr_55 = vr_58 [ vr_9 ] ;
if ( vr_55 < 0 || vr_55 >= length ) {
throw new fn_33 ( lr_13 + vr_55 + lr_15 + length ) ;
}
if ( vr_55 >= vr_73 ) {
continue;
}
vr_70 ++ ;
vr_73 = vr_55 ;
}
}
final Object vr_43 = Array . vr_17 ( array . getClass () . vr_18 () , length - vr_70 ) ;
if ( vr_70 < length ) {
int vr_74 = length ;
int vr_75 = length - vr_70 ;
for ( int vr_9 = vr_58 . length - 1 ; vr_9 >= 0 ; vr_9 -- ) {
final int vr_55 = vr_58 [ vr_9 ] ;
if ( vr_74 - vr_55 > 1 ) {
final int vr_76 = vr_74 - vr_55 - 1 ;
vr_75 -= vr_76 ;
System . vr_24 ( array , vr_55 + 1 , vr_43 , vr_75 , vr_76 ) ;
}
vr_74 = vr_55 ;
}
if ( vr_74 > 0 ) {
System . vr_24 ( array , 0 , vr_43 , 0 , vr_74 ) ;
}
}
return vr_43 ;
}
static Object fn_35 ( final Object array , final tp_2 vr_58 ) {
final int vr_77 = vr_41 . fn_12 ( array ) ;
final int vr_78 = vr_58 . vr_79 () ;
final Object vr_43 = Array . vr_17 ( array . getClass () . vr_18 () , vr_77 - vr_78 ) ;
int vr_80 = 0 ;
int vr_81 = 0 ;
int vr_62 ;
int vr_57 ;
while( ( vr_57 = vr_58 . vr_82 ( vr_80 ) ) != - 1 ) {
vr_62 = vr_57 - vr_80 ;
if ( vr_62 > 0 ) {
System . vr_24 ( array , vr_80 , vr_43 , vr_81 , vr_62 ) ;
vr_81 += vr_62 ;
}
vr_80 = vr_58 . vr_83 ( vr_57 ) ;
}
vr_62 = vr_77 - vr_80 ;
if ( vr_62 > 0 ) {
System . vr_24 ( array , vr_80 , vr_43 , vr_81 , vr_62 ) ;
}
return vr_43 ;
}
@Override
public int fn_37 ( vt_1 vr_84 , vt_1 vr_85 ) {
return vr_84 . vr_86 ( vr_85 ) ;
}
public static < vt_1 > boolean fn_38 ( final vt_1 [] array , final vr_87 < vt_1 > vr_88 ) {
if ( vr_88 == null ) {
throw new IllegalArgumentException ( lr_16 ) ;
}
if( array == null || array . length < 2 ) {
return true ;
}
vt_1 vr_89 = array [ 0 ] ;
final int vr_34 = array . length ;
for( int vr_9 = 1 ; vr_9 < vr_34 ; vr_9 ++ ) {
final vt_1 vr_90 = array [ vr_9 ] ;
if ( vr_88 . fn_37 ( vr_89 , vr_90 ) > 0 ) {
return false ;
}
vr_89 = vr_90 ;
}
return true ;
}
public static boolean fn_38 ( int [] array ) {
if( array == null || array . length < 2 ) {
return true ;
}
int vr_89 = array [ 0 ] ;
final int vr_34 = array . length ;
for( int vr_9 = 1 ; vr_9 < vr_34 ; vr_9 ++ ) {
final int vr_90 = array [ vr_9 ] ;
if( vr_91 . fn_37 ( vr_89 , vr_90 ) > 0 ) {
return false ;
}
vr_89 = vr_90 ;
}
return true ;
}
public static boolean fn_38 ( long [] array ) {
if( array == null || array . length < 2 ) {
return true ;
}
long vr_89 = array [ 0 ] ;
final int vr_34 = array . length ;
for( int vr_9 = 1 ; vr_9 < vr_34 ; vr_9 ++ ) {
final long vr_90 = array [ vr_9 ] ;
if( vr_91 . fn_37 ( vr_89 , vr_90 ) > 0 ) {
return false ;
}
vr_89 = vr_90 ;
}
return true ;
}
public static boolean fn_38 ( short [] array ) {
if( array == null || array . length < 2 ) { MST[PrimitiveReturnsMutator]MSP[S]
return true ;
}
short vr_89 = array [ 0 ] ;
final int vr_34 = array . length ;
for( int vr_9 = 1 ; vr_9 < vr_34 ; vr_9 ++ ) {
final short vr_90 = array [ vr_9 ] ;
if( vr_91 . fn_37 ( vr_89 , vr_90 ) > 0 ) {
return false ;
}
vr_89 = vr_90 ;
}
return true ;
}
public static boolean fn_38 ( final double [] array ) {
if( array == null || array . length < 2 ) {
return true ;
}
double vr_89 = array [ 0 ] ;
final int vr_34 = array . length ;
for( int vr_9 = 1 ; vr_9 < vr_34 ; vr_9 ++ ) {
final double vr_90 = array [ vr_9 ] ;
if( Double . fn_37 ( vr_89 , vr_90 ) > 0 ) {
return false ;
}
vr_89 = vr_90 ;
}
return true ;
}
public static boolean fn_38 ( final float [] array ) {
if( array == null || array . length < 2 ) {
return true ;
}
float vr_89 = array [ 0 ] ;
final int vr_34 = array . length ;
for( int vr_9 = 1 ; vr_9 < vr_34 ; vr_9 ++ ) {
final float vr_90 = array [ vr_9 ] ;
if( Float . fn_37 ( vr_89 , vr_90 ) > 0 ) {
return false ;
}
vr_89 = vr_90 ;
}
return true ;
}
public static boolean fn_38 ( byte [] array ) {
if( array == null || array . length < 2 ) {
return true ;
}
byte vr_89 = array [ 0 ] ;
final int vr_34 = array . length ;
for( int vr_9 = 1 ; vr_9 < vr_34 ; vr_9 ++ ) {
final byte vr_90 = array [ vr_9 ] ;
if( vr_91 . fn_37 ( vr_89 , vr_90 ) > 0 ) {
return false ;
}
vr_89 = vr_90 ;
}
return true ;
}
public static boolean fn_38 ( char [] array ) {
if( array == null || array . length < 2 ) {
return true ;
}
char vr_89 = array [ 0 ] ;
final int vr_34 = array . length ;
for( int vr_9 = 1 ; vr_9 < vr_34 ; vr_9 ++ ) {
final char vr_90 = array [ vr_9 ] ;
if( vr_92 . fn_37 ( vr_89 , vr_90 ) > 0 ) {
return false ;
}
vr_89 = vr_90 ;
}
return true ;
}
public static boolean fn_38 ( boolean [] array ) {
if( array == null || array . length < 2 ) {
return true ;
}
boolean vr_89 = array [ 0 ] ;
final int vr_34 = array . length ;
for( int vr_9 = 1 ; vr_9 < vr_34 ; vr_9 ++ ) {
final boolean vr_90 = array [ vr_9 ] ;
if( vr_93 . fn_37 ( vr_89 , vr_90 ) > 0 ) {
return false ;
}
vr_89 = vr_90 ;
}
return true ;
}
public static boolean [] fn_39 ( final boolean [] array , final boolean vr_51 ) {
int vr_55 = indexOf ( array , vr_51 ) ;
if ( vr_55 == vl_20 ) {
return fn_8 ( array ) ;
}
int [] vr_58 = new int [ array . length - vr_55 ] ;
vr_58 [ 0 ] = vr_55 ;
int vr_62 = 1 ;
while ( ( vr_55 = indexOf ( array , vr_51 , vr_58 [ vr_62 - 1 ] + 1 ) ) != vl_20 ) {
vr_58 [ vr_62 ++ ] = vr_55 ;
}
return fn_35 ( array , vr_71 . vr_94 ( vr_58 , vr_62 ) ) ;
}
public static char [] fn_39 ( final char [] array , final char vr_51 ) {
int vr_55 = indexOf ( array , vr_51 ) ;
if ( vr_55 == vl_20 ) {
return fn_8 ( array ) ;
}
int [] vr_58 = new int [ array . length - vr_55 ] ;
vr_58 [ 0 ] = vr_55 ;
int vr_62 = 1 ;
while ( ( vr_55 = indexOf ( array , vr_51 , vr_58 [ vr_62 - 1 ] + 1 ) ) != vl_20 ) {
vr_58 [ vr_62 ++ ] = vr_55 ;
}
return fn_35 ( array , vr_71 . vr_94 ( vr_58 , vr_62 ) ) ;
}
public static byte [] fn_39 ( final byte [] array , final byte vr_51 ) {
int vr_55 = indexOf ( array , vr_51 ) ;
if ( vr_55 == vl_20 ) {
return fn_8 ( array ) ;
}
int [] vr_58 = new int [ array . length - vr_55 ] ;
vr_58 [ 0 ] = vr_55 ;
int vr_62 = 1 ;
while ( ( vr_55 = indexOf ( array , vr_51 , vr_58 [ vr_62 - 1 ] + 1 ) ) != vl_20 ) {
vr_58 [ vr_62 ++ ] = vr_55 ;
}
return fn_35 ( array , vr_71 . vr_94 ( vr_58 , vr_62 ) ) ;
}
public static short [] fn_39 ( final short [] array , final short vr_51 ) {
int vr_55 = indexOf ( array , vr_51 ) ;
if ( vr_55 == vl_20 ) {
return fn_8 ( array ) ;
}
int [] vr_58 = new int [ array . length - vr_55 ] ;
vr_58 [ 0 ] = vr_55 ;
int vr_62 = 1 ;
while ( ( vr_55 = indexOf ( array , vr_51 , vr_58 [ vr_62 - 1 ] + 1 ) ) != vl_20 ) {
vr_58 [ vr_62 ++ ] = vr_55 ;
}
return fn_35 ( array , vr_71 . vr_94 ( vr_58 , vr_62 ) ) ;
}
public static int [] fn_39 ( final int [] array , final int vr_51 ) {
int vr_55 = indexOf ( array , vr_51 ) ;
if ( vr_55 == vl_20 ) {
return fn_8 ( array ) ;
}
int [] vr_58 = new int [ array . length - vr_55 ] ;
vr_58 [ 0 ] = vr_55 ;
int vr_62 = 1 ;
while ( ( vr_55 = indexOf ( array , vr_51 , vr_58 [ vr_62 - 1 ] + 1 ) ) != vl_20 ) {
vr_58 [ vr_62 ++ ] = vr_55 ;
}
return fn_35 ( array , vr_71 . vr_94 ( vr_58 , vr_62 ) ) ;
}
public static long [] fn_39 ( final long [] array , final long vr_51 ) {
int vr_55 = indexOf ( array , vr_51 ) ;
if ( vr_55 == vl_20 ) {
return fn_8 ( array ) ;
}
int [] vr_58 = new int [ array . length - vr_55 ] ;
vr_58 [ 0 ] = vr_55 ;
int vr_62 = 1 ;
while ( ( vr_55 = indexOf ( array , vr_51 , vr_58 [ vr_62 - 1 ] + 1 ) ) != vl_20 ) {
vr_58 [ vr_62 ++ ] = vr_55 ;
}
return fn_35 ( array , vr_71 . vr_94 ( vr_58 , vr_62 ) ) ;
}
public static float [] fn_39 ( final float [] array , final float vr_51 ) {
int vr_55 = indexOf ( array , vr_51 ) ;
if ( vr_55 == vl_20 ) {
return fn_8 ( array ) ;
}
int [] vr_58 = new int [ array . length - vr_55 ] ;
vr_58 [ 0 ] = vr_55 ;
int vr_62 = 1 ;
while ( ( vr_55 = indexOf ( array , vr_51 , vr_58 [ vr_62 - 1 ] + 1 ) ) != vl_20 ) {
vr_58 [ vr_62 ++ ] = vr_55 ;
}
return fn_35 ( array , vr_71 . vr_94 ( vr_58 , vr_62 ) ) ;
}
public static double [] fn_39 ( final double [] array , final double vr_51 ) {
int vr_55 = indexOf ( array , vr_51 ) ;
if ( vr_55 == vl_20 ) {
return fn_8 ( array ) ;
}
int [] vr_58 = new int [ array . length - vr_55 ] ;
vr_58 [ 0 ] = vr_55 ;
int vr_62 = 1 ;
while ( ( vr_55 = indexOf ( array , vr_51 , vr_58 [ vr_62 - 1 ] + 1 ) ) != vl_20 ) {
vr_58 [ vr_62 ++ ] = vr_55 ;
}
return fn_35 ( array , vr_71 . vr_94 ( vr_58 , vr_62 ) ) ;
}
public static < vt_1 > vt_1 [] fn_39 ( final vt_1 [] array , final vt_1 vr_51 ) {
int vr_55 = indexOf ( array , vr_51 ) ;
if ( vr_55 == vl_20 ) {
return fn_8 ( array ) ;
}
int [] vr_58 = new int [ array . length - vr_55 ] ;
vr_58 [ 0 ] = vr_55 ;
int vr_62 = 1 ;
while ( ( vr_55 = indexOf ( array , vr_51 , vr_58 [ vr_62 - 1 ] + 1 ) ) != vl_20 ) {
vr_58 [ vr_62 ++ ] = vr_55 ;
}
return fn_35 ( array , vr_71 . vr_94 ( vr_58 , vr_62 ) ) ;
}

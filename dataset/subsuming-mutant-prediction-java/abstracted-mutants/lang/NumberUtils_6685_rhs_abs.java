public static int fn_1 ( final String vr_1 ) {
return fn_1 ( vr_1 , 0 ) ;
}
public static int fn_1 ( final String vr_1 , final int vr_2 ) {
if( vr_1 == null ) {
return vr_2 ;
}
try {
return Integer . vr_3 ( vr_1 ) ;
} catch ( final tp_1 vr_4 ) {
return vr_2 ;
}
}
public static long fn_2 ( final String vr_1 ) {
return fn_2 ( vr_1 , 0L ) ;
}
public static long fn_2 ( final String vr_1 , final long vr_2 ) {
if ( vr_1 == null ) {
return vr_2 ;
}
try {
return Long . vr_5 ( vr_1 ) ;
} catch ( final tp_1 vr_4 ) {
return vr_2 ;
}
}
public static float fn_3 ( final String vr_1 ) {
return fn_3 ( vr_1 , 0.0f ) ;
}
public static float fn_3 ( final String vr_1 , final float vr_2 ) {
if ( vr_1 == null ) {
return vr_2 ;
}
try {
return Float . vr_6 ( vr_1 ) ;
} catch ( final tp_1 vr_4 ) {
return vr_2 ;
}
}
public static double fn_4 ( final String vr_1 ) {
return fn_4 ( vr_1 , 0.0d ) ;
}
public static double fn_4 ( final String vr_1 , final double vr_2 ) {
if ( vr_1 == null ) {
return vr_2 ;
}
try {
return Double . vr_7 ( vr_1 ) ;
} catch ( final tp_1 vr_4 ) {
return vr_2 ;
}
}
public static byte fn_5 ( final String vr_1 ) {
return fn_5 ( vr_1 , ( byte ) 0 ) ;
}
public static byte fn_5 ( final String vr_1 , final byte vr_2 ) {
if( vr_1 == null ) {
return vr_2 ;
}
try {
return Byte . vr_8 ( vr_1 ) ; MST[NonVoidMethodCallMutator]MSP[N]
} catch ( final tp_1 vr_4 ) {
return vr_2 ;
}
}
public static short fn_6 ( final String vr_1 ) {
return fn_6 ( vr_1 , ( short ) 0 ) ;
}
public static short fn_6 ( final String vr_1 , final short vr_2 ) {
if( vr_1 == null ) {
return vr_2 ;
}
try {
return Short . vr_9 ( vr_1 ) ;
} catch ( final tp_1 vr_4 ) {
return vr_2 ;
}
}
public static tp_2 fn_7 ( final String vr_1 ) throws tp_1 {
if ( vr_1 == null ) {
return null ;
}
if ( vr_10 . vr_11 ( vr_1 ) ) {
throw new tp_1 ( lr_1 ) ;
}
final String [] vr_12 = { lr_2 , lr_3 , lr_4 , lr_5 , lr_6 , lr_7 } ;
int vr_13 = 0 ;
for( final String vr_14 : vr_12 ) {
if ( vr_1 . vr_15 ( vr_14 ) ) {
vr_13 += vr_14 . length () ;
break;
}
}
if ( vr_13 > 0 ) {
char vr_16 = 0 ;
for( int vr_17 = vr_13 ; vr_17 < vr_1 . length () ; vr_17 ++ ) {
vr_16 = vr_1 . charAt ( vr_17 ) ;
if ( vr_16 == '0' ) {
vr_13 ++ ;
} else {
break;
}
}
final int vr_18 = vr_1 . length () - vr_13 ;
if ( vr_18 > 16 || ( vr_18 == 16 && vr_16 > '7' ) ) {
return fn_8 ( vr_1 ) ;
}
if ( vr_18 > 8 || ( vr_18 == 8 && vr_16 > '7' ) ) {
return fn_9 ( vr_1 ) ;
}
return fn_10 ( vr_1 ) ;
}
final char vr_19 = vr_1 . charAt ( vr_1 . length () - 1 ) ;
String vr_20 ;
String vr_21 ;
String exp ;
final int vr_22 = vr_1 . indexOf ( '.' ) ;
final int vr_23 = vr_1 . indexOf ( 'e' ) + vr_1 . indexOf ( 'E' ) + 1 ;
int vr_24 = 0 ;
if ( vr_22 > - 1 ) {
if ( vr_23 > - 1 ) {
if ( vr_23 < vr_22 || vr_23 > vr_1 . length () ) {
throw new tp_1 ( vr_1 + lr_8 ) ;
}
vr_21 = vr_1 . vr_25 ( vr_22 + 1 , vr_23 ) ;
} else {
vr_21 = vr_1 . vr_25 ( vr_22 + 1 ) ;
}
vr_20 = fn_11 ( vr_1 , vr_22 ) ;
vr_24 = vr_21 . length () ;
} else {
if ( vr_23 > - 1 ) {
if ( vr_23 > vr_1 . length () ) {
throw new tp_1 ( vr_1 + lr_8 ) ;
}
vr_20 = fn_11 ( vr_1 , vr_23 ) ;
} else {
vr_20 = fn_11 ( vr_1 ) ;
}
vr_21 = null ;
}
if ( ! vr_26 . isDigit ( vr_19 ) && vr_19 != '.' ) {
if ( vr_23 > - 1 && vr_23 < vr_1 . length () - 1 ) {
exp = vr_1 . vr_25 ( vr_23 + 1 , vr_1 . length () - 1 ) ;
} else {
exp = null ;
}
final String vr_27 = vr_1 . vr_25 ( 0 , vr_1 . length () - 1 ) ;
final boolean vr_28 = fn_12 ( vr_20 ) && fn_12 ( exp ) ;
switch ( vr_19 ) {
case 'l' :
case 'L' :
if ( vr_21 == null
&& exp == null
&& ( vr_27 . charAt ( 0 ) == '-' && fn_13 ( vr_27 . vr_25 ( 1 ) ) || fn_13 ( vr_27 ) ) ) {
try {
return fn_9 ( vr_27 ) ;
} catch ( final tp_1 vr_4 ) {
}
return fn_8 ( vr_27 ) ;
}
throw new tp_1 ( vr_1 + lr_8 ) ;
case 'f' :
case 'F' :
try {
final Float vr_29 = vr_30 . vr_31 ( vr_27 ) ;
if ( ! ( vr_29 . vr_32 () || ( vr_29 . vr_33 () == 0.0F && ! vr_28 ) ) ) {
return vr_29 ;
}
} catch ( final tp_1 vr_4 ) {
}
case 'd' :
case 'D' :
try {
final Double vr_34 = vr_30 . vr_35 ( vr_27 ) ;
if ( ! ( vr_34 . vr_32 () || ( vr_34 . vr_33 () == 0.0D && ! vr_28 ) ) ) {
return vr_34 ;
}
} catch ( final tp_1 vr_4 ) {
}
try {
return fn_14 ( vr_27 ) ;
} catch ( final tp_1 vr_36 ) {
}
default :
throw new tp_1 ( vr_1 + lr_8 ) ;
}
}
if ( vr_23 > - 1 && vr_23 < vr_1 . length () - 1 ) {
exp = vr_1 . vr_25 ( vr_23 + 1 , vr_1 . length () ) ;
} else {
exp = null ;
}
if ( vr_21 == null && exp == null ) {
try {
return fn_10 ( vr_1 ) ;
} catch ( final tp_1 vr_4 ) {
}
try {
return fn_9 ( vr_1 ) ;
} catch ( final tp_1 vr_4 ) {
}
return fn_8 ( vr_1 ) ;
}
final boolean vr_28 = fn_12 ( vr_20 ) && fn_12 ( exp ) ;
try {
if( vr_24 <= 7 ) {
final Float vr_29 = vr_31 ( vr_1 ) ;
if ( ! ( vr_29 . vr_32 () || ( vr_29 . vr_33 () == 0.0F && ! vr_28 ) ) ) {
return vr_29 ;
}
}
} catch ( final tp_1 vr_4 ) {
}
try {
if( vr_24 <= 16 ) {
final Double vr_34 = vr_35 ( vr_1 ) ;
if ( ! ( vr_34 . vr_32 () || ( vr_34 . vr_37 () == 0.0D && ! vr_28 ) ) ) {
return vr_34 ;
}
}
} catch ( final tp_1 vr_4 ) {
}
return fn_14 ( vr_1 ) ;
}
private static String fn_11 ( final String vr_1 ) {
return fn_11 ( vr_1 , vr_1 . length () ) ;
}
private static String fn_11 ( final String vr_1 , final int vr_38 ) {
final char vr_39 = vr_1 . charAt ( 0 ) ;
final boolean vr_40 = ( vr_39 == '-' || vr_39 == '+' ) ;
return vr_40 ? vr_1 . vr_25 ( 1 , vr_38 ) : vr_1 . vr_25 ( 0 , vr_38 ) ;
}
private static boolean fn_12 ( final String vr_1 ) {
if ( vr_1 == null ) {
return true ;
}
for ( int vr_17 = vr_1 . length () - 1 ; vr_17 >= 0 ; vr_17 -- ) {
if ( vr_1 . charAt ( vr_17 ) != '0' ) {
return false ;
}
}
return vr_1 . length () > 0 ;
}
public static Float vr_31 ( final String vr_1 ) {
if ( vr_1 == null ) {
return null ;
}
return Float . valueOf ( vr_1 ) ;
}
public static Double vr_35 ( final String vr_1 ) {
if ( vr_1 == null ) {
return null ;
}
return Double . valueOf ( vr_1 ) ;
}
public static Integer fn_10 ( final String vr_1 ) {
if ( vr_1 == null ) {
return null ;
}
return Integer . vr_41 ( vr_1 ) ;
}
public static Long fn_9 ( final String vr_1 ) {
if ( vr_1 == null ) {
return null ;
}
return Long . vr_41 ( vr_1 ) ;
}
public static tp_3 fn_8 ( final String vr_1 ) {
if ( vr_1 == null ) {
return null ;
}
int vr_42 = 0 ;
int vr_43 = 10 ;
boolean vr_44 = false ;
if ( vr_1 . vr_15 ( lr_9 ) ) {
vr_44 = true ;
vr_42 = 1 ;
}
if ( vr_1 . vr_15 ( lr_2 , vr_42 ) || vr_1 . vr_15 ( lr_3 , vr_42 ) ) {
vr_43 = 16 ;
vr_42 += 2 ;
} else if ( vr_1 . vr_15 ( lr_6 , vr_42 ) ) {
vr_43 = 16 ;
vr_42 ++ ;
} else if ( vr_1 . vr_15 ( lr_10 , vr_42 ) && vr_1 . length () > vr_42 + 1 ) {
vr_43 = 8 ;
vr_42 ++ ;
}
final tp_3 vr_45 = new tp_3 ( vr_1 . vr_25 ( vr_42 ) , vr_43 ) ;
return vr_44 ? vr_45 . vr_44 () : vr_45 ;
}
public static tp_4 fn_14 ( final String vr_1 ) {
if ( vr_1 == null ) {
return null ;
}
if ( vr_10 . vr_11 ( vr_1 ) ) {
throw new tp_1 ( lr_1 ) ;
}
if ( vr_1 . trim () . vr_15 ( lr_11 ) ) {
throw new tp_1 ( vr_1 + lr_8 ) ;
}
return new tp_4 ( vr_1 ) ;
}
public static long fn_15 ( final long ... array ) {
fn_16 ( array ) ;
long fn_15 = array [ 0 ] ;
for ( int vr_17 = 1 ; vr_17 < array . length ; vr_17 ++ ) {
if ( array [ vr_17 ] < fn_15 ) {
fn_15 = array [ vr_17 ] ;
}
}
return fn_15 ;
}
public static int fn_15 ( final int ... array ) {
fn_16 ( array ) ;
int fn_15 = array [ 0 ] ;
for ( int vr_46 = 1 ; vr_46 < array . length ; vr_46 ++ ) {
if ( array [ vr_46 ] < fn_15 ) {
fn_15 = array [ vr_46 ] ;
}
}
return fn_15 ;
}
public static short fn_15 ( final short ... array ) {
fn_16 ( array ) ;
short fn_15 = array [ 0 ] ;
for ( int vr_17 = 1 ; vr_17 < array . length ; vr_17 ++ ) {
if ( array [ vr_17 ] < fn_15 ) {
fn_15 = array [ vr_17 ] ;
}
}
return fn_15 ;
}
public static byte fn_15 ( final byte ... array ) {
fn_16 ( array ) ;
byte fn_15 = array [ 0 ] ;
for ( int vr_17 = 1 ; vr_17 < array . length ; vr_17 ++ ) {
if ( array [ vr_17 ] < fn_15 ) {
fn_15 = array [ vr_17 ] ;
}
}
return fn_15 ;
}
public static double fn_15 ( final double ... array ) {
fn_16 ( array ) ;
double fn_15 = array [ 0 ] ;
for ( int vr_17 = 1 ; vr_17 < array . length ; vr_17 ++ ) {
if ( Double . vr_47 ( array [ vr_17 ] ) ) {
return Double . vr_48 ;
}
if ( array [ vr_17 ] < fn_15 ) {
fn_15 = array [ vr_17 ] ;
}
}
return fn_15 ;
}
public static float fn_15 ( final float ... array ) {
fn_16 ( array ) ;
float fn_15 = array [ 0 ] ;
for ( int vr_17 = 1 ; vr_17 < array . length ; vr_17 ++ ) {
if ( Float . vr_47 ( array [ vr_17 ] ) ) {
return Float . vr_48 ;
}
if ( array [ vr_17 ] < fn_15 ) {
fn_15 = array [ vr_17 ] ;
}
}
return fn_15 ;
}
public static long fn_17 ( final long ... array ) {
fn_16 ( array ) ;
long fn_17 = array [ 0 ] ;
for ( int vr_46 = 1 ; vr_46 < array . length ; vr_46 ++ ) {
if ( array [ vr_46 ] > fn_17 ) {
fn_17 = array [ vr_46 ] ;
}
}
return fn_17 ;
}
public static int fn_17 ( final int ... array ) {
fn_16 ( array ) ;
int fn_17 = array [ 0 ] ;
for ( int vr_46 = 1 ; vr_46 < array . length ; vr_46 ++ ) {
if ( array [ vr_46 ] > fn_17 ) {
fn_17 = array [ vr_46 ] ;
}
}
return fn_17 ;
}
public static short fn_17 ( final short ... array ) {
fn_16 ( array ) ;
short fn_17 = array [ 0 ] ;
for ( int vr_17 = 1 ; vr_17 < array . length ; vr_17 ++ ) {
if ( array [ vr_17 ] > fn_17 ) {
fn_17 = array [ vr_17 ] ;
}
}
return fn_17 ;
}
public static byte fn_17 ( final byte ... array ) {
fn_16 ( array ) ;
byte fn_17 = array [ 0 ] ;
for ( int vr_17 = 1 ; vr_17 < array . length ; vr_17 ++ ) {
if ( array [ vr_17 ] > fn_17 ) {
fn_17 = array [ vr_17 ] ;
}
}
return fn_17 ;
}
public static double fn_17 ( final double ... array ) {
fn_16 ( array ) ;
double fn_17 = array [ 0 ] ;
for ( int vr_46 = 1 ; vr_46 < array . length ; vr_46 ++ ) {
if ( Double . vr_47 ( array [ vr_46 ] ) ) {
return Double . vr_48 ;
}
if ( array [ vr_46 ] > fn_17 ) {
fn_17 = array [ vr_46 ] ;
}
}
return fn_17 ;
}
public static float fn_17 ( final float ... array ) {
fn_16 ( array ) ;
float fn_17 = array [ 0 ] ;
for ( int vr_46 = 1 ; vr_46 < array . length ; vr_46 ++ ) {
if ( Float . vr_47 ( array [ vr_46 ] ) ) {
return Float . vr_48 ;
}
if ( array [ vr_46 ] > fn_17 ) {
fn_17 = array [ vr_46 ] ;
}
}
return fn_17 ;
}
private static void fn_16 ( final Object array ) {
if ( array == null ) {
throw new IllegalArgumentException ( lr_12 ) ;
}
vr_49 . vr_50 ( Array . vr_51 ( array ) != 0 , lr_13 ) ;
}
public static long fn_15 ( long vr_52 , final long vr_53 , final long vr_54 ) {
if ( vr_53 < vr_52 ) {
vr_52 = vr_53 ;
}
if ( vr_54 < vr_52 ) {
vr_52 = vr_54 ;
}
return vr_52 ;
}
public static int fn_15 ( int vr_52 , final int vr_53 , final int vr_54 ) {
if ( vr_53 < vr_52 ) {
vr_52 = vr_53 ;
}
if ( vr_54 < vr_52 ) {
vr_52 = vr_54 ;
}
return vr_52 ;
}
public static short fn_15 ( short vr_52 , final short vr_53 , final short vr_54 ) {
if ( vr_53 < vr_52 ) {
vr_52 = vr_53 ;
}
if ( vr_54 < vr_52 ) {
vr_52 = vr_54 ;
}
return vr_52 ;
}
public static byte fn_15 ( byte vr_52 , final byte vr_53 , final byte vr_54 ) {
if ( vr_53 < vr_52 ) {
vr_52 = vr_53 ;
}
if ( vr_54 < vr_52 ) {
vr_52 = vr_54 ;
}
return vr_52 ;
}
public static double fn_15 ( final double vr_52 , final double vr_53 , final double vr_54 ) {
return vr_55 . fn_15 ( vr_55 . fn_15 ( vr_52 , vr_53 ) , vr_54 ) ;
}
public static float fn_15 ( final float vr_52 , final float vr_53 , final float vr_54 ) {
return vr_55 . fn_15 ( vr_55 . fn_15 ( vr_52 , vr_53 ) , vr_54 ) ;
}
public static long fn_17 ( long vr_52 , final long vr_53 , final long vr_54 ) {
if ( vr_53 > vr_52 ) {
vr_52 = vr_53 ;
}
if ( vr_54 > vr_52 ) {
vr_52 = vr_54 ;
}
return vr_52 ;
}
public static int fn_17 ( int vr_52 , final int vr_53 , final int vr_54 ) {
if ( vr_53 > vr_52 ) {
vr_52 = vr_53 ;
}
if ( vr_54 > vr_52 ) {
vr_52 = vr_54 ;
}
return vr_52 ;
}
public static short fn_17 ( short vr_52 , final short vr_53 , final short vr_54 ) {
if ( vr_53 > vr_52 ) {
vr_52 = vr_53 ;
}
if ( vr_54 > vr_52 ) {
vr_52 = vr_54 ;
}
return vr_52 ;
}
public static byte fn_17 ( byte vr_52 , final byte vr_53 , final byte vr_54 ) {
if ( vr_53 > vr_52 ) {
vr_52 = vr_53 ;
}
if ( vr_54 > vr_52 ) {
vr_52 = vr_54 ;
}
return vr_52 ;
}
public static double fn_17 ( final double vr_52 , final double vr_53 , final double vr_54 ) {
return vr_55 . fn_17 ( vr_55 . fn_17 ( vr_52 , vr_53 ) , vr_54 ) ;
}
public static float fn_17 ( final float vr_52 , final float vr_53 , final float vr_54 ) {
return vr_55 . fn_17 ( vr_55 . fn_17 ( vr_52 , vr_53 ) , vr_54 ) ;
}
public static boolean fn_13 ( final String vr_1 ) {
return vr_10 . vr_56 ( vr_1 ) ;
}
public static boolean fn_18 ( final String vr_1 ) {
if ( vr_10 . isEmpty ( vr_1 ) ) {
return false ;
}
final char [] vr_57 = vr_1 . vr_58 () ;
int vr_59 = vr_57 . length ;
boolean vr_60 = false ;
boolean vr_61 = false ;
boolean vr_62 = false ;
boolean vr_63 = false ;
final int vr_64 = ( vr_57 [ 0 ] == '-' ) ? 1 : 0 ;
if ( vr_59 > vr_64 + 1 && vr_57 [ vr_64 ] == '0' ) {
if (
( vr_57 [ vr_64 + 1 ] == 'x' ) ||
( vr_57 [ vr_64 + 1 ] == 'X' )
) {
int vr_17 = vr_64 + 2 ;
if ( vr_17 == vr_59 ) {
return false ;
}
for (; vr_17 < vr_57 . length ; vr_17 ++ ) {
if ( ( vr_57 [ vr_17 ] < '0' || vr_57 [ vr_17 ] > '9' )
&& ( vr_57 [ vr_17 ] < 'a' || vr_57 [ vr_17 ] > 'f' )
&& ( vr_57 [ vr_17 ] < 'A' || vr_57 [ vr_17 ] > 'F' ) ) {
return false ;
}
}
return true ;
} else if ( vr_26 . isDigit ( vr_57 [ vr_64 + 1 ] ) ) {
int vr_17 = vr_64 + 1 ;
for (; vr_17 < vr_57 . length ; vr_17 ++ ) {
if ( vr_57 [ vr_17 ] < '0' || vr_57 [ vr_17 ] > '7' ) {
return false ;
}
}
return true ;
}
}
vr_59 -- ;
int vr_17 = vr_64 ;
while ( vr_17 < vr_59 || ( vr_17 < vr_59 + 1 && vr_62 && ! vr_63 ) ) {
if ( vr_57 [ vr_17 ] >= '0' && vr_57 [ vr_17 ] <= '9' ) {
vr_63 = true ;
vr_62 = false ;
} else if ( vr_57 [ vr_17 ] == '.' ) {
if ( vr_61 || vr_60 ) {
return false ;
}
vr_61 = true ;
} else if ( vr_57 [ vr_17 ] == 'e' || vr_57 [ vr_17 ] == 'E' ) {
if ( vr_60 ) {
return false ;
}
if ( ! vr_63 ) {
return false ;
}
vr_60 = true ;
vr_62 = true ;
} else if ( vr_57 [ vr_17 ] == '+' || vr_57 [ vr_17 ] == '-' ) {
if ( ! vr_62 ) {
return false ;
}
vr_62 = false ;
vr_63 = false ;
} else {
return false ;
}
vr_17 ++ ;
}
if ( vr_17 < vr_57 . length ) {
if ( vr_57 [ vr_17 ] >= '0' && vr_57 [ vr_17 ] <= '9' ) {
return true ;
}
if ( vr_57 [ vr_17 ] == 'e' || vr_57 [ vr_17 ] == 'E' ) {
return false ;
}
if ( vr_57 [ vr_17 ] == '.' ) {
if ( vr_61 || vr_60 ) {
return false ;
}
return vr_63 ;
}
if ( ! vr_62
&& ( vr_57 [ vr_17 ] == 'd'
|| vr_57 [ vr_17 ] == 'D'
|| vr_57 [ vr_17 ] == 'f'
|| vr_57 [ vr_17 ] == 'F' ) ) {
return vr_63 ;
}
if ( vr_57 [ vr_17 ] == 'l'
|| vr_57 [ vr_17 ] == 'L' ) {
return vr_63 && ! vr_60 && ! vr_61 ;
}
return false ;
}
return ! vr_62 && vr_63 ;
}
public static boolean fn_19 ( final String vr_1 ) {
if( vr_10 . vr_65 ( vr_1 , lr_14 ) ) {
return false ;
}
if( vr_10 . vr_15 ( vr_1 , lr_9 ) ) {
return fn_13 ( vr_10 . vr_66 ( vr_1 . vr_25 ( 1 ) , lr_14 , vr_10 . vr_67 ) ) ;
} else {
return fn_13 ( vr_10 . vr_66 ( vr_1 , lr_14 , vr_10 . vr_67 ) ) ;
}
}
public static int fn_20 ( int vr_68 , int vr_69 ) {
if ( vr_68 == vr_69 ) {
return 0 ;
}
if ( vr_68 < vr_69 ) {
return - 1 ;
} else {
return 1 ;
}
}
public static int fn_20 ( long vr_68 , long vr_69 ) {
if ( vr_68 == vr_69 ) {
return 0 ;
}
if ( vr_68 < vr_69 ) {
return - 1 ;
} else {
return 1 ;
}
}
public static int fn_20 ( short vr_68 , short vr_69 ) {
if ( vr_68 == vr_69 ) {
return 0 ;
}
if ( vr_68 < vr_69 ) {
return - 1 ;
} else {
return 1 ;
}
}
public static int fn_20 ( byte vr_68 , byte vr_69 ) {
return vr_68 - vr_69 ;
}

public static tp_1 fn_1 ( final tp_2 vr_1 ) {
if ( vr_1 == null ) {
throw new fn_2 () ;
}
return vr_1 instanceof tp_1 ?
( tp_1 ) vr_1 : new tp_1 ( vr_1 ) ;
}
public static tp_1 fn_1 ( final tp_2 vr_1 , final int size ) {
if ( vr_1 == null ) {
throw new fn_2 () ;
}
return vr_1 instanceof tp_1 ?
( tp_1 ) vr_1 : new tp_1 ( vr_1 , size ) ;
}
public static tp_3 fn_1 ( final tp_4 vr_2 ) {
if ( vr_2 == null ) {
throw new fn_2 () ;
}
return vr_2 instanceof tp_3 ?
( tp_3 ) vr_2 : new tp_3 ( vr_2 ) ;
}
public static tp_3 fn_1 ( final tp_4 vr_2 , final int size ) {
if ( vr_2 == null ) {
throw new fn_2 () ;
}
return vr_2 instanceof tp_3 ?
( tp_3 ) vr_2 : new tp_3 ( vr_2 , size ) ;
}
public static BufferedReader fn_1 ( final tp_5 vr_3 ) {
return vr_3 instanceof BufferedReader ? ( BufferedReader ) vr_3 : new BufferedReader ( vr_3 ) ;
}
public static BufferedReader fn_1 ( final tp_5 vr_3 , final int size ) {
return vr_3 instanceof BufferedReader ? ( BufferedReader ) vr_3 : new BufferedReader ( vr_3 , size ) ;
}
public static tp_6 fn_1 ( final tp_7 vr_4 ) {
return vr_4 instanceof tp_6 ? ( tp_6 ) vr_4 : new tp_6 ( vr_4 ) ;
}
public static tp_6 fn_1 ( final tp_7 vr_4 , final int size ) {
return vr_4 instanceof tp_6 ? ( tp_6 ) vr_4 : new tp_6 ( vr_4 , size ) ;
}
public static tp_7 vr_4 ( final tp_8 vr_5 ) {
vr_6 . vr_7 ( vr_5 , lr_1 ) ;
if ( vr_5 instanceof tp_7 ) {
return ( tp_7 ) vr_5 ;
}
if ( vr_5 instanceof StringBuilder ) {
return new fn_3 ( ( StringBuilder ) vr_5 ) ;
}
return new vr_8 <> ( vr_5 ) ;
}
public static void fn_4 ( final tp_9 vr_9 ) {
if ( vr_9 instanceof vl_1 ) {
( ( vl_1 ) vr_9 ) . fn_5 () ;
}
}
@Deprecated
public static void fn_6 ( final tp_10 vr_10 ) {
try {
if ( vr_10 != null ) {
vr_10 . fn_4 () ;
}
} catch ( final IOException vr_11 ) {
}
}
@Deprecated
public static void fn_6 ( final tp_10 ... vr_12 ) {
if ( vr_12 == null ) {
return;
}
for ( final tp_10 vr_10 : vr_12 ) {
fn_6 ( vr_10 ) ;
}
}
@Deprecated
public static void fn_6 ( final tp_2 vr_13 ) {
fn_6 ( ( tp_10 ) vr_13 ) ;
}
@Deprecated
public static void fn_6 ( final tp_4 vr_14 ) {
fn_6 ( ( tp_10 ) vr_14 ) ;
}
@Deprecated
public static void fn_6 ( final tp_5 vr_13 ) {
fn_6 ( ( tp_10 ) vr_13 ) ;
}
@Deprecated
public static void fn_6 ( final tp_11 vr_15 ) {
if ( vr_15 != null ) {
try {
vr_15 . fn_4 () ;
} catch ( final IOException vr_11 ) {
}
}
}
@Deprecated
public static void fn_6 ( final tp_12 vr_16 ) {
if ( vr_16 != null ) {
try {
vr_16 . fn_4 () ;
} catch ( final IOException vr_11 ) {
}
}
}
@Deprecated
public static void fn_6 ( final tp_13 vr_16 ) {
if ( vr_16 != null ) {
try {
vr_16 . fn_4 () ;
} catch ( final IOException vr_11 ) {
}
}
}
@Deprecated
public static void fn_6 ( final tp_7 vr_14 ) {
fn_6 ( ( tp_10 ) vr_14 ) ;
}
public static boolean fn_7 ( tp_2 vr_17 , tp_2 vr_18 )
throws IOException {
if ( vr_17 == vr_18 ) {
return true ;
}
if ( ! ( vr_17 instanceof tp_1 ) ) {
vr_17 = new tp_1 ( vr_17 ) ;
}
if ( ! ( vr_18 instanceof tp_1 ) ) {
vr_18 = new tp_1 ( vr_18 ) ;
}
int vr_19 = vr_17 . vr_20 () ;
while ( vl_2 != vr_19 ) {
final int vr_21 = vr_18 . vr_20 () ;
if ( vr_19 != vr_21 ) {
return false ;
}
vr_19 = vr_17 . vr_20 () ;
}
final int vr_21 = vr_18 . vr_20 () ;
return vr_21 == vl_2 ;
}
public static boolean fn_7 ( tp_5 vr_17 , tp_5 vr_18 )
throws IOException {
if ( vr_17 == vr_18 ) {
return true ;
}
vr_17 = fn_8 ( vr_17 ) ;
vr_18 = fn_8 ( vr_18 ) ;
int vr_19 = vr_17 . vr_20 () ;
while ( vl_2 != vr_19 ) {
final int vr_21 = vr_18 . vr_20 () ;
if ( vr_19 != vr_21 ) {
return false ;
}
vr_19 = vr_17 . vr_20 () ;
}
final int vr_21 = vr_18 . vr_20 () ;
return vr_21 == vl_2 ;
}
public static boolean fn_9 ( final tp_5 vr_17 , final tp_5 vr_18 )
throws IOException {
if ( vr_17 == vr_18 ) {
return true ;
}
final BufferedReader vr_22 = fn_8 ( vr_17 ) ;
final BufferedReader vr_23 = fn_8 ( vr_18 ) ;
String vr_24 = vr_22 . readLine () ;
String vr_25 = vr_23 . readLine () ;
while ( vr_24 != null && vr_25 != null && vr_24 . equals ( vr_25 ) ) {
vr_24 = vr_22 . readLine () ;
vr_25 = vr_23 . readLine () ;
}
return vr_24 == null ? vr_25 == null ? true : false : vr_24 . equals ( vr_25 ) ;
}
public static int fn_10 ( final tp_2 vr_13 , final tp_4 vr_14 ) throws IOException {
final long vr_26 = fn_11 ( vr_13 , vr_14 ) ;
if ( vr_26 > Integer . vr_27 ) {
return - 1 ;
}
return ( int ) vr_26 ;
}
public static long fn_10 ( final tp_2 vr_13 , final tp_4 vr_14 , final int vr_28 )
throws IOException {
return fn_11 ( vr_13 , vr_14 , new byte [ vr_28 ] ) ;
}
@Deprecated
public static void fn_10 ( final tp_2 vr_13 , final tp_7 vr_14 )
throws IOException {
fn_10 ( vr_13 , vr_14 , vr_29 . vr_30 () ) ;
}
public static void fn_10 ( final tp_2 vr_13 , final tp_7 vr_14 , final vr_29 vr_31 )
throws IOException {
final tp_14 vr_32 = new tp_14 ( vr_13 , vr_33 . vr_34 ( vr_31 ) ) ;
fn_10 ( vr_32 , vr_14 ) ;
}
public static void fn_10 ( final tp_2 vr_13 , final tp_7 vr_14 , final String vr_31 )
throws IOException {
fn_10 ( vr_13 , vr_14 , vr_33 . vr_34 ( vr_31 ) ) ;
}
@Deprecated
public static void fn_10 ( final tp_5 vr_13 , final tp_4 vr_14 )
throws IOException {
fn_10 ( vr_13 , vr_14 , vr_29 . vr_30 () ) ;
}
public static void fn_10 ( final tp_5 vr_13 , final tp_4 vr_14 , final vr_29 vr_35 )
throws IOException {
final tp_15 out = new tp_15 ( vr_14 , vr_33 . vr_34 ( vr_35 ) ) ;
fn_10 ( vr_13 , out ) ;
out . vr_36 () ;
}
public static void fn_10 ( final tp_5 vr_13 , final tp_4 vr_14 , final String vr_35 )
throws IOException {
fn_10 ( vr_13 , vr_14 , vr_33 . vr_34 ( vr_35 ) ) ;
}
public static long fn_10 ( final tp_5 vr_13 , final tp_8 vr_14 ) throws IOException {
return fn_10 ( vr_13 , vr_14 , vr_37 . vr_38 ( vl_3 ) ) ;
}
public static int fn_10 ( final tp_5 vr_13 , final tp_7 vr_14 ) throws IOException {
final long vr_26 = fn_11 ( vr_13 , vr_14 ) ;
if ( vr_26 > Integer . vr_27 ) {
return - 1 ;
}
return ( int ) vr_26 ;
}
public static long fn_11 ( final tp_2 vr_13 , final tp_4 vr_14 )
throws IOException {
return fn_10 ( vr_13 , vr_14 , vl_3 ) ;
}
public static long fn_11 ( final tp_2 vr_13 , final tp_4 vr_14 , final byte [] fn_1 )
throws IOException {
long vr_26 = 0 ;
int vr_39 ;
while ( vl_2 != ( vr_39 = vr_13 . vr_20 ( fn_1 ) ) ) {
vr_14 . vr_40 ( fn_1 , 0 , vr_39 ) ;
vr_26 += vr_39 ;
}
return vr_26 ;
}
public static long fn_11 ( final tp_2 vr_13 , final tp_4 vr_14 , final long vr_41 ,
final long length ) throws IOException {
return fn_11 ( vr_13 , vr_14 , vr_41 , length , new byte [ vl_3 ] ) ;
}
public static long fn_11 ( final tp_2 vr_13 , final tp_4 vr_14 ,
final long vr_41 , final long length , final byte [] fn_1 ) throws IOException {
if ( vr_41 > 0 ) {
fn_12 ( vr_13 , vr_41 ) ;
}
if ( length == 0 ) {
return 0 ;
}
final int vr_42 = fn_1 . length ;
int vr_43 = vr_42 ;
if ( length > 0 && length < vr_42 ) {
vr_43 = ( int ) length ;
}
int vr_20 ;
long vr_44 = 0 ;
while ( vr_43 > 0 && vl_2 != ( vr_20 = vr_13 . vr_20 ( fn_1 , 0 , vr_43 ) ) ) {
vr_14 . vr_40 ( fn_1 , 0 , vr_20 ) ;
vr_44 += vr_20 ;
if ( length > 0 ) {
vr_43 = ( int ) vr_45 . vr_46 ( length - vr_44 , vr_42 ) ;
}
}
return vr_44 ;
}
public static long fn_10 ( final tp_5 vr_13 , final tp_8 vr_14 , final vr_37 fn_1 ) throws IOException {
long vr_26 = 0 ;
int vr_39 ;
while ( vl_2 != ( vr_39 = vr_13 . vr_20 ( fn_1 ) ) ) {
fn_1 . vr_47 () ;
vr_14 . append ( fn_1 , 0 , vr_39 ) ;
vr_26 += vr_39 ;
}
return vr_26 ;
}
public static long fn_11 ( final tp_5 vr_13 , final tp_7 vr_14 ) throws IOException {
return fn_11 ( vr_13 , vr_14 , new char [ vl_3 ] ) ;
}
public static long fn_11 ( final tp_5 vr_13 , final tp_7 vr_14 , final char [] fn_1 ) throws IOException {
long vr_26 = 0 ;
int vr_39 ;
while ( vl_2 != ( vr_39 = vr_13 . vr_20 ( fn_1 ) ) ) {
vr_14 . vr_40 ( fn_1 , 0 , vr_39 ) ;
vr_26 += vr_39 ;
}
return vr_26 ;
}
public static long fn_11 ( final tp_5 vr_13 , final tp_7 vr_14 , final long vr_41 , final long length )
throws IOException {
return fn_11 ( vr_13 , vr_14 , vr_41 , length , new char [ vl_3 ] ) ;
}
public static long fn_11 ( final tp_5 vr_13 , final tp_7 vr_14 , final long vr_41 , final long length ,
final char [] fn_1 )
throws IOException {
if ( vr_41 > 0 ) {
fn_12 ( vr_13 , vr_41 ) ;
}
if ( length == 0 ) {
return 0 ;
}
int vr_43 = fn_1 . length ;
if ( length > 0 && length < fn_1 . length ) {
vr_43 = ( int ) length ;
}
int vr_20 ;
long vr_44 = 0 ;
while ( vr_43 > 0 && vl_2 != ( vr_20 = vr_13 . vr_20 ( fn_1 , 0 , vr_43 ) ) ) {
vr_14 . vr_40 ( fn_1 , 0 , vr_20 ) ;
vr_44 += vr_20 ;
if ( length > 0 ) {
vr_43 = ( int ) vr_45 . vr_46 ( length - vr_44 , fn_1 . length ) ;
}
}
return vr_44 ;
}
public static tp_16 fn_13 ( final tp_2 vr_13 , final vr_29 vr_48 ) throws IOException {
return new tp_16 ( new tp_14 ( vr_13 , vr_33 . vr_34 ( vr_48 ) ) ) ;
}
public static tp_16 fn_13 ( final tp_2 vr_13 , final String vr_48 ) throws IOException {
return fn_13 ( vr_13 , vr_33 . vr_34 ( vr_48 ) ) ;
}
public static tp_16 fn_13 ( final tp_5 vr_3 ) {
return new tp_16 ( vr_3 ) ;
}
public static int vr_20 ( final tp_2 vr_13 , final byte [] fn_1 ) throws IOException {
return vr_20 ( vr_13 , fn_1 , 0 , fn_1 . length ) ;
}
public static int vr_20 ( final tp_2 vr_13 , final byte [] fn_1 , final int vr_49 , final int length )
throws IOException {
if ( length < 0 ) {
throw new IllegalArgumentException ( lr_2 + length ) ;
}
int vr_50 = length ;
while ( vr_50 > 0 ) {
final int vr_51 = length - vr_50 ;
final int vr_26 = vr_13 . vr_20 ( fn_1 , vr_49 + vr_51 , vr_50 ) ;
if ( vl_2 == vr_26 ) {
break;
}
vr_50 -= vr_26 ;
}
return length - vr_50 ;
}
public static int vr_20 ( final tp_17 vr_13 , final tp_18 fn_1 ) throws IOException {
final int length = fn_1 . vr_50 () ;
while ( fn_1 . vr_50 () > 0 ) {
final int vr_26 = vr_13 . vr_20 ( fn_1 ) ;
if ( vl_2 == vr_26 ) {
break;
}
}
return length - fn_1 . vr_50 () ;
}
public static int vr_20 ( final tp_5 vr_13 , final char [] fn_1 ) throws IOException {
return vr_20 ( vr_13 , fn_1 , 0 , fn_1 . length ) ;
}
public static int vr_20 ( final tp_5 vr_13 , final char [] fn_1 , final int vr_49 , final int length )
throws IOException {
if ( length < 0 ) {
throw new IllegalArgumentException ( lr_2 + length ) ;
}
int vr_50 = length ;
while ( vr_50 > 0 ) {
final int vr_51 = length - vr_50 ;
final int vr_26 = vr_13 . vr_20 ( fn_1 , vr_49 + vr_51 , vr_50 ) ;
if ( vl_2 == vr_26 ) {
break;
}
vr_50 -= vr_26 ;
}
return length - vr_50 ;
}
public static void fn_14 ( final tp_2 vr_13 , final byte [] fn_1 ) throws IOException {
fn_14 ( vr_13 , fn_1 , 0 , fn_1 . length ) ;
}
public static void fn_14 ( final tp_2 vr_13 , final byte [] fn_1 , final int vr_49 , final int length )
throws IOException {
final int vr_52 = vr_20 ( vr_13 , fn_1 , vr_49 , length ) ;
if ( vr_52 != length ) {
throw new fn_15 ( lr_3 + length + lr_4 + vr_52 ) ;
}
}
public static byte [] fn_14 ( final tp_2 vr_13 , final int length ) throws IOException {
final byte [] fn_1 = new byte [ length ] ;
fn_14 ( vr_13 , fn_1 , 0 , fn_1 . length ) ;
return fn_1 ;
}
public static void fn_14 ( final tp_17 vr_13 , final tp_18 fn_1 ) throws IOException {
final int vr_53 = fn_1 . vr_50 () ;
final int vr_52 = vr_20 ( vr_13 , fn_1 ) ;
if ( vr_52 != vr_53 ) {
throw new fn_15 ( lr_3 + vr_53 + lr_4 + vr_52 ) ;
}
}
public static void fn_14 ( final tp_5 vr_13 , final char [] fn_1 ) throws IOException {
fn_14 ( vr_13 , fn_1 , 0 , fn_1 . length ) ;
}
public static void fn_14 ( final tp_5 vr_13 , final char [] fn_1 , final int vr_49 , final int length )
throws IOException {
final int vr_52 = vr_20 ( vr_13 , fn_1 , vr_49 , length ) ;
if ( vr_52 != length ) {
throw new fn_15 ( lr_3 + length + lr_4 + vr_52 ) ;
}
}
@Deprecated
public static List < String > fn_16 ( final tp_2 vr_13 ) throws IOException {
return fn_16 ( vr_13 , vr_29 . vr_30 () ) ;
}
public static List < String > fn_16 ( final tp_2 vr_13 , final vr_29 vr_48 ) throws IOException {
final tp_14 vr_3 = new tp_14 ( vr_13 , vr_33 . vr_34 ( vr_48 ) ) ;
return fn_16 ( vr_3 ) ;
}
public static List < String > fn_16 ( final tp_2 vr_13 , final String vr_48 ) throws IOException {
return fn_16 ( vr_13 , vr_33 . vr_34 ( vr_48 ) ) ;
}
public static List < String > fn_16 ( final tp_5 vr_13 ) throws IOException {
final BufferedReader vr_3 = fn_8 ( vr_13 ) ;
final List < String > list = new ArrayList <> () ;
String line = vr_3 . readLine () ;
while ( line != null ) {
list . add ( line ) ;
line = vr_3 . readLine () ;
}
return list ;
}
public static byte [] fn_17 ( final String vr_54 ) throws IOException {
return fn_17 ( vr_54 , null ) ;
}
public static byte [] fn_17 ( final String vr_54 , final tp_19 vr_55 ) throws IOException {
return fn_18 ( fn_19 ( vr_54 , vr_55 ) ) ;
}
public static String fn_20 ( final String vr_54 , final vr_29 vr_48 ) throws IOException {
return fn_20 ( vr_54 , vr_48 , null ) ;
}
public static String fn_20 ( final String vr_54 , final vr_29 vr_48 , final tp_19 vr_55 ) throws IOException {
return toString ( fn_19 ( vr_54 , vr_55 ) , vr_48 ) ;
}
public static tp_20 fn_19 ( final String vr_54 ) throws IOException {
return fn_19 ( vr_54 , null ) ;
}
public static tp_20 fn_19 ( final String vr_54 , final tp_19 vr_55 ) throws IOException {
final tp_20 vr_56 = vr_55 == null ? vr_57 . class . vr_58 ( vr_54 ) : vr_55 . vr_58 ( vr_54 ) ;
if ( vr_56 == null ) {
throw new IOException ( lr_5 + vr_54 ) ;
}
return vr_56 ;
}
public static long fn_21 ( final tp_2 vr_13 , final long vr_59 ) throws IOException {
if ( vr_59 < 0 ) {
throw new IllegalArgumentException ( lr_6 + vr_59 ) ;
}
if ( vl_4 == null ) {
vl_4 = new byte [ vl_5 ] ;
}
long vr_60 = vr_59 ;
while ( vr_60 > 0 ) {
final long vr_39 = vr_13 . vr_20 ( vl_4 , 0 , ( int ) vr_45 . vr_46 ( vr_60 , vl_5 ) ) ;
if ( vr_39 < 0 ) {
break;
}
vr_60 -= vr_39 ;
}
return vr_59 - vr_60 ;
}
public static long fn_21 ( final tp_17 vr_13 , final long vr_59 ) throws IOException {
if ( vr_59 < 0 ) {
throw new IllegalArgumentException ( lr_6 + vr_59 ) ;
}
final tp_18 vr_61 = tp_18 . vr_38 ( ( int ) vr_45 . vr_46 ( vr_59 , vl_5 ) ) ;
long vr_60 = vr_59 ;
while ( vr_60 > 0 ) {
vr_61 . vr_62 ( 0 ) ;
vr_61 . vr_63 ( ( int ) vr_45 . vr_46 ( vr_60 , vl_5 ) ) ;
final int vr_39 = vr_13 . vr_20 ( vr_61 ) ;
if ( vr_39 == vl_2 ) {
break;
}
vr_60 -= vr_39 ;
}
return vr_59 - vr_60 ;
}
public static long fn_21 ( final tp_5 vr_13 , final long vr_59 ) throws IOException {
if ( vr_59 < 0 ) {
throw new IllegalArgumentException ( lr_6 + vr_59 ) ;
}
if ( vl_6 == null ) {
vl_6 = new char [ vl_5 ] ;
}
long vr_60 = vr_59 ;
while ( vr_60 > 0 ) {
final long vr_39 = vr_13 . vr_20 ( vl_6 , 0 , ( int ) vr_45 . vr_46 ( vr_60 , vl_5 ) ) ;
if ( vr_39 < 0 ) {
break;
}
vr_60 -= vr_39 ;
}
return vr_59 - vr_60 ;
}
public static void fn_12 ( final tp_2 vr_13 , final long vr_59 ) throws IOException {
if ( vr_59 < 0 ) {
throw new IllegalArgumentException ( lr_7 + vr_59 ) ;
}
final long vr_64 = fn_21 ( vr_13 , vr_59 ) ; MST[rv.UOI1Mutator]MSP[]
if ( vr_64 != vr_59 ) {
throw new fn_15 ( lr_8 + vr_59 + lr_4 + vr_64 ) ;
}
}
public static void fn_12 ( final tp_17 vr_13 , final long vr_59 ) throws IOException {
if ( vr_59 < 0 ) {
throw new IllegalArgumentException ( lr_7 + vr_59 ) ;
}
final long vr_64 = fn_21 ( vr_13 , vr_59 ) ;
if ( vr_64 != vr_59 ) {
throw new fn_15 ( lr_8 + vr_59 + lr_4 + vr_64 ) ;
}
}
public static void fn_12 ( final tp_5 vr_13 , final long vr_59 ) throws IOException {
final long vr_64 = fn_21 ( vr_13 , vr_59 ) ;
if ( vr_64 != vr_59 ) {
throw new fn_15 ( lr_9 + vr_59 + lr_4 + vr_64 ) ;
}
}
public static tp_2 fn_22 ( final tp_2 vr_13 ) throws IOException {
return vr_65 . fn_22 ( vr_13 ) ;
}
public static tp_2 fn_22 ( final tp_2 vr_13 , final int size ) throws IOException {
return vr_65 . fn_22 ( vr_13 , size ) ;
}
public static BufferedReader fn_8 ( final tp_5 vr_3 ) {
return vr_3 instanceof BufferedReader ? ( BufferedReader ) vr_3 : new BufferedReader ( vr_3 ) ;
}
public static BufferedReader fn_8 ( final tp_5 vr_3 , final int size ) {
return vr_3 instanceof BufferedReader ? ( BufferedReader ) vr_3 : new BufferedReader ( vr_3 , size ) ;
}
public static byte [] fn_18 ( final tp_2 vr_13 ) throws IOException {
try ( final vr_65 vr_14 = new vr_65 () ) {
fn_10 ( vr_13 , vr_14 ) ;
return vr_14 . fn_18 () ;
}
}
public static byte [] fn_18 ( final tp_2 vr_13 , final int size ) throws IOException {
if ( size < 0 ) {
throw new IllegalArgumentException ( lr_10 + size ) ;
}
if ( size == 0 ) {
return new byte [ 0 ] ;
}
final byte [] vr_66 = new byte [ size ] ;
int vr_49 = 0 ;
int vr_20 ;
while ( vr_49 < size && ( vr_20 = vr_13 . vr_20 ( vr_66 , vr_49 , size - vr_49 ) ) != vl_2 ) {
vr_49 += vr_20 ;
}
if ( vr_49 != size ) {
throw new IOException ( lr_11 + vr_49 + lr_12 + size ) ;
}
return vr_66 ;
}
public static byte [] fn_18 ( final tp_2 vr_13 , final long size ) throws IOException {
if ( size > Integer . vr_27 ) {
throw new IllegalArgumentException ( lr_13 + size ) ;
}
return fn_18 ( vr_13 , ( int ) size ) ;
}
@Deprecated
public static byte [] fn_18 ( final tp_5 vr_13 ) throws IOException {
return fn_18 ( vr_13 , vr_29 . vr_30 () ) ;
}
public static byte [] fn_18 ( final tp_5 vr_13 , final vr_29 vr_48 ) throws IOException {
try ( final vr_65 vr_14 = new vr_65 () ) {
fn_10 ( vr_13 , vr_14 , vr_48 ) ;
return vr_14 . fn_18 () ;
}
}
public static byte [] fn_18 ( final tp_5 vr_13 , final String vr_48 ) throws IOException {
return fn_18 ( vr_13 , vr_33 . vr_34 ( vr_48 ) ) ;
}
@Deprecated
public static byte [] fn_18 ( final String vr_13 ) throws IOException {
return vr_13 . vr_67 ( vr_29 . vr_30 () ) ;
}
public static byte [] fn_18 ( final tp_21 vr_68 ) throws IOException {
return vr_57 . fn_18 ( vr_68 . vr_69 () ) ;
}
public static byte [] fn_18 ( final tp_20 vr_70 ) throws IOException {
final tp_9 vr_9 = vr_70 . vr_71 () ;
try {
return vr_57 . fn_18 ( vr_9 ) ;
} finally {
fn_4 ( vr_9 ) ;
}
}
public static byte [] fn_18 ( final tp_9 vr_72 ) throws IOException {
try ( tp_2 vr_1 = vr_72 . vr_73 () ) {
return vr_57 . fn_18 ( vr_1 ) ;
}
}
@Deprecated
public static char [] fn_23 ( final tp_2 vr_74 ) throws IOException {
return fn_23 ( vr_74 , vr_29 . vr_30 () ) ;
}
public static char [] fn_23 ( final tp_2 vr_74 , final vr_29 vr_48 )
throws IOException {
final tp_22 vr_14 = new tp_22 () ;
fn_10 ( vr_74 , vr_14 , vr_48 ) ;
return vr_14 . fn_23 () ;
}
public static char [] fn_23 ( final tp_2 vr_74 , final String vr_48 ) throws IOException {
return fn_23 ( vr_74 , vr_33 . vr_34 ( vr_48 ) ) ;
}
public static char [] fn_23 ( final tp_5 vr_13 ) throws IOException {
final tp_22 vr_75 = new tp_22 () ;
fn_10 ( vr_13 , vr_75 ) ;
return vr_75 . fn_23 () ;
}
@Deprecated
public static tp_2 fn_24 ( final tp_23 vr_13 ) {
return fn_24 ( vr_13 , vr_29 . vr_30 () ) ;
}
public static tp_2 fn_24 ( final tp_23 vr_13 , final vr_29 vr_48 ) {
return fn_24 ( vr_13 . toString () , vr_48 ) ;
}
public static tp_2 fn_24 ( final tp_23 vr_13 , final String vr_48 ) throws IOException {
return fn_24 ( vr_13 , vr_33 . vr_34 ( vr_48 ) ) ;
}
@Deprecated
public static tp_2 fn_24 ( final String vr_13 ) {
return fn_24 ( vr_13 , vr_29 . vr_30 () ) ;
}
public static tp_2 fn_24 ( final String vr_13 , final vr_29 vr_48 ) {
return new fn_25 ( vr_13 . vr_67 ( vr_33 . vr_34 ( vr_48 ) ) ) ;
}
public static tp_2 fn_24 ( final String vr_13 , final String vr_48 ) throws IOException {
final byte [] vr_76 = vr_13 . vr_67 ( vr_33 . vr_34 ( vr_48 ) ) ;
return new fn_25 ( vr_76 ) ;
}
@Deprecated
public static String toString ( final byte [] vr_13 ) throws IOException {
return new String ( vr_13 , vr_29 . vr_30 () ) ;
}
public static String toString ( final byte [] vr_13 , final String vr_48 ) throws IOException {
return new String ( vr_13 , vr_33 . vr_34 ( vr_48 ) ) ;
}
@Deprecated
public static String toString ( final tp_2 vr_13 ) throws IOException {
return toString ( vr_13 , vr_29 . vr_30 () ) ;
}
public static String toString ( final tp_2 vr_13 , final vr_29 vr_48 ) throws IOException {
try ( final fn_3 vr_75 = new fn_3 () ) {
fn_10 ( vr_13 , vr_75 , vr_48 ) ;
return vr_75 . toString () ;
}
}
public static String toString ( final tp_2 vr_13 , final String vr_48 )
throws IOException {
return toString ( vr_13 , vr_33 . vr_34 ( vr_48 ) ) ;
}
public static String toString ( final tp_5 vr_13 ) throws IOException {
try ( final fn_3 vr_75 = new fn_3 () ) {
fn_10 ( vr_13 , vr_75 ) ;
return vr_75 . toString () ;
}
}
@Deprecated
public static String toString ( final tp_21 vr_68 ) throws IOException {
return toString ( vr_68 , vr_29 . vr_30 () ) ;
}
public static String toString ( final tp_21 vr_68 , final vr_29 vr_48 ) throws IOException {
return toString ( vr_68 . vr_69 () , vr_33 . vr_34 ( vr_48 ) ) ;
}
public static String toString ( final tp_21 vr_68 , final String vr_48 ) throws IOException {
return toString ( vr_68 , vr_33 . vr_34 ( vr_48 ) ) ;
}
@Deprecated
public static String toString ( final tp_20 vr_70 ) throws IOException {
return toString ( vr_70 , vr_29 . vr_30 () ) ;
}
public static String toString ( final tp_20 vr_70 , final vr_29 vr_48 ) throws IOException {
try ( tp_2 vr_1 = vr_70 . vr_77 () ) {
return toString ( vr_1 , vr_48 ) ;
}
}
public static String toString ( final tp_20 vr_70 , final String vr_48 ) throws IOException {
return toString ( vr_70 , vr_33 . vr_34 ( vr_48 ) ) ;
}
public static void vr_40 ( final byte [] vr_66 , final tp_4 vr_14 )
throws IOException {
if ( vr_66 != null ) {
vr_14 . vr_40 ( vr_66 ) ;
}
}
@Deprecated
public static void vr_40 ( final byte [] vr_66 , final tp_7 vr_14 ) throws IOException {
vr_40 ( vr_66 , vr_14 , vr_29 . vr_30 () ) ;
}
public static void vr_40 ( final byte [] vr_66 , final tp_7 vr_14 , final vr_29 vr_48 ) throws IOException {
if ( vr_66 != null ) {
vr_14 . vr_40 ( new String ( vr_66 , vr_33 . vr_34 ( vr_48 ) ) ) ;
}
}
public static void vr_40 ( final byte [] vr_66 , final tp_7 vr_14 , final String vr_48 ) throws IOException {
vr_40 ( vr_66 , vr_14 , vr_33 . vr_34 ( vr_48 ) ) ;
}
@Deprecated
public static void vr_40 ( final char [] vr_66 , final tp_4 vr_14 )
throws IOException {
vr_40 ( vr_66 , vr_14 , vr_29 . vr_30 () ) ;
}
public static void vr_40 ( final char [] vr_66 , final tp_4 vr_14 , final vr_29 vr_48 ) throws IOException {
if ( vr_66 != null ) {
vr_14 . vr_40 ( new String ( vr_66 ) . vr_67 ( vr_33 . vr_34 ( vr_48 ) ) ) ;
}
}
public static void vr_40 ( final char [] vr_66 , final tp_4 vr_14 , final String vr_48 )
throws IOException {
vr_40 ( vr_66 , vr_14 , vr_33 . vr_34 ( vr_48 ) ) ;
}
public static void vr_40 ( final char [] vr_66 , final tp_7 vr_14 ) throws IOException {
if ( vr_66 != null ) {
vr_14 . vr_40 ( vr_66 ) ;
}
}
@Deprecated
public static void vr_40 ( final tp_23 vr_66 , final tp_4 vr_14 )
throws IOException {
vr_40 ( vr_66 , vr_14 , vr_29 . vr_30 () ) ;
}
public static void vr_40 ( final tp_23 vr_66 , final tp_4 vr_14 , final vr_29 vr_48 )
throws IOException {
if ( vr_66 != null ) {
vr_40 ( vr_66 . toString () , vr_14 , vr_48 ) ;
}
}
public static void vr_40 ( final tp_23 vr_66 , final tp_4 vr_14 , final String vr_48 )
throws IOException {
vr_40 ( vr_66 , vr_14 , vr_33 . vr_34 ( vr_48 ) ) ;
}
public static void vr_40 ( final tp_23 vr_66 , final tp_7 vr_14 ) throws IOException {
if ( vr_66 != null ) {
vr_40 ( vr_66 . toString () , vr_14 ) ;
}
}
@Deprecated
public static void vr_40 ( final String vr_66 , final tp_4 vr_14 )
throws IOException {
vr_40 ( vr_66 , vr_14 , vr_29 . vr_30 () ) ;
}
public static void vr_40 ( final String vr_66 , final tp_4 vr_14 , final vr_29 vr_48 ) throws IOException {
if ( vr_66 != null ) {
vr_14 . vr_40 ( vr_66 . vr_67 ( vr_33 . vr_34 ( vr_48 ) ) ) ;
}
}
public static void vr_40 ( final String vr_66 , final tp_4 vr_14 , final String vr_48 )
throws IOException {
vr_40 ( vr_66 , vr_14 , vr_33 . vr_34 ( vr_48 ) ) ;
}
public static void vr_40 ( final String vr_66 , final tp_7 vr_14 ) throws IOException {
if ( vr_66 != null ) {
vr_14 . vr_40 ( vr_66 ) ;
}
}
@Deprecated
public static void vr_40 ( final tp_24 vr_66 , final tp_4 vr_14 )
throws IOException {
vr_40 ( vr_66 , vr_14 , ( String ) null ) ;
}
@Deprecated
public static void vr_40 ( final tp_24 vr_66 , final tp_4 vr_14 , final String vr_48 )
throws IOException {
if ( vr_66 != null ) {
vr_14 . vr_40 ( vr_66 . toString () . vr_67 ( vr_33 . vr_34 ( vr_48 ) ) ) ;
}
}
@Deprecated
public static void vr_40 ( final tp_24 vr_66 , final tp_7 vr_14 )
throws IOException {
if ( vr_66 != null ) {
vr_14 . vr_40 ( vr_66 . toString () ) ;
}
}
public static void fn_26 ( final byte [] vr_66 , final tp_4 vr_14 )
throws IOException {
if ( vr_66 != null ) {
int vr_76 = vr_66 . length ;
int vr_49 = 0 ;
while ( vr_76 > 0 ) {
final int vr_78 = vr_45 . vr_46 ( vr_76 , vl_3 ) ;
vr_14 . vr_40 ( vr_66 , vr_49 , vr_78 ) ;
vr_76 -= vr_78 ;
vr_49 += vr_78 ;
}
}
}
public static void fn_26 ( final char [] vr_66 , final tp_7 vr_14 ) throws IOException {
if ( vr_66 != null ) {
int vr_76 = vr_66 . length ;
int vr_49 = 0 ;
while ( vr_76 > 0 ) {
final int vr_78 = vr_45 . vr_46 ( vr_76 , vl_3 ) ;
vr_14 . vr_40 ( vr_66 , vr_49 , vr_78 ) ;
vr_76 -= vr_78 ;
vr_49 += vr_78 ;
}
}
}
@Deprecated
public static void fn_27 ( final Collection < ? > vr_79 , final String vr_80 ,
final tp_4 vr_14 ) throws IOException {
fn_27 ( vr_79 , vr_80 , vr_14 , vr_29 . vr_30 () ) ;
}
public static void fn_27 ( final Collection < ? > vr_79 , String vr_80 , final tp_4 vr_14 ,
final vr_29 vr_48 ) throws IOException {
if ( vr_79 == null ) {
return;
}
if ( vr_80 == null ) {
vr_80 = vl_7 ;
}
final vr_29 vr_81 = vr_33 . vr_34 ( vr_48 ) ;
for ( final Object line : vr_79 ) {
if ( line != null ) {
vr_14 . vr_40 ( line . toString () . vr_67 ( vr_81 ) ) ;
}
vr_14 . vr_40 ( vr_80 . vr_67 ( vr_81 ) ) ;
}
}
public static void fn_27 ( final Collection < ? > vr_79 , final String vr_80 ,
final tp_4 vr_14 , final String vr_48 ) throws IOException {
fn_27 ( vr_79 , vr_80 , vr_14 , vr_33 . vr_34 ( vr_48 ) ) ;
}
public static void fn_27 ( final Collection < ? > vr_79 , String vr_80 ,
final tp_7 vr_4 ) throws IOException {
if ( vr_79 == null ) {
return;
}
if ( vr_80 == null ) {
vr_80 = vl_7 ;
}
for ( final Object line : vr_79 ) {
if ( line != null ) {
vr_4 . vr_40 ( line . toString () ) ;
}
vr_4 . vr_40 ( vr_80 ) ;
}
}
public static int length ( final byte [] array ) {
return array == null ? 0 : array . length ;
}
public static int length ( final char [] array ) {
return array == null ? 0 : array . length ;
}
public static int length ( final tp_23 vr_82 ) {
return vr_82 == null ? 0 : vr_82 . length () ;
}
public static int length ( final Object [] array ) {
return array == null ? 0 : array . length ;
}

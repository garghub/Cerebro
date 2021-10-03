public boolean fn_1 () {
return this . vr_1 == vl_1 ;
}
boolean fn_2 () {
return this . vr_2 != null ;
}
int fn_3 () {
return vr_2 != null ? vl_2 - vl_3 : 0 ;
}
private void fn_4 () {
if ( vr_2 == null ) {
vr_2 = new byte [ vl_4 ] ;
vl_2 = 0 ;
vl_3 = 0 ;
} else {
final byte [] vr_3 = new byte [ vr_2 . length * vl_5 ] ;
System . vr_4 ( vr_2 , 0 , vr_3 , 0 , vr_2 . length ) ;
vr_2 = vr_3 ;
}
}
int fn_5 ( final byte [] vr_3 , final int vr_5 , final int vr_6 ) {
if ( vr_2 != null ) {
final int vr_7 = vr_8 . vr_9 ( fn_3 () , vr_6 ) ;
if ( vr_2 != vr_3 ) {
System . vr_4 ( vr_2 , vl_3 , vr_3 , vr_5 , vr_7 ) ;
vl_3 += vr_7 ;
if ( vl_3 >= vl_2 ) {
vr_2 = null ;
}
} else {
vr_2 = null ;
}
return vr_7 ;
}
return vl_6 ? - 1 : 0 ;
}
void fn_6 ( final byte [] out , final int vr_10 , final int vr_11 ) {
if ( out != null && out . length == vr_11 ) {
vr_2 = out ;
vl_2 = vr_10 ;
vl_3 = vr_10 ;
}
}
void fn_7 ( final byte [] vr_12 , int vr_13 , final int vr_14 ) {
if ( vl_6 ) {
return;
}
if ( vr_14 < 0 ) {
vl_6 = true ;
if ( vr_2 == null || vr_2 . length - vl_2 < vl_7 ) {
fn_4 () ;
}
switch ( vl_8 ) {
case 1 :
vr_2 [ vl_2 ++ ] = vr_1 [ ( vl_9 >> 2 ) & vl_10 ] ;
vr_2 [ vl_2 ++ ] = vr_1 [ ( vl_9 << 4 ) & vl_10 ] ;
if ( vr_1 == vl_11 ) {
vr_2 [ vl_2 ++ ] = vl_12 ;
vr_2 [ vl_2 ++ ] = vl_12 ;
}
break;
case 2 :
vr_2 [ vl_2 ++ ] = vr_1 [ ( vl_9 >> 10 ) & vl_10 ] ;
vr_2 [ vl_2 ++ ] = vr_1 [ ( vl_9 >> 4 ) & vl_10 ] ;
vr_2 [ vl_2 ++ ] = vr_1 [ ( vl_9 << 2 ) & vl_10 ] ;
if ( vr_1 == vl_11 ) {
vr_2 [ vl_2 ++ ] = vl_12 ;
}
break;
default:
break;
}
if ( vl_13 > 0 && vl_2 > 0 ) {
System . vr_4 ( vl_14 , 0 , vr_2 , vl_2 , vl_14 . length ) ;
vl_2 += vl_14 . length ;
}
} else {
for ( int vr_15 = 0 ; vr_15 < vr_14 ; vr_15 ++ ) {
if ( vr_2 == null || vr_2 . length - vl_2 < vl_7 ) {
fn_4 () ;
}
vl_8 = ( ++ vl_8 ) % 3 ;
int vr_3 = vr_12 [ vr_13 ++ ] ;
if ( vr_3 < 0 ) {
vr_3 += 256 ;
}
vl_9 = ( vl_9 << 8 ) + vr_3 ;
if ( 0 == vl_8 ) {
vr_2 [ vl_2 ++ ] = vr_1 [ ( vl_9 >> 18 ) & vl_10 ] ;
vr_2 [ vl_2 ++ ] = vr_1 [ ( vl_9 >> 12 ) & vl_10 ] ;
vr_2 [ vl_2 ++ ] = vr_1 [ ( vl_9 >> 6 ) & vl_10 ] ;
vr_2 [ vl_2 ++ ] = vr_1 [ vl_9 & vl_10 ] ;
vl_15 += 4 ;
if ( vl_13 > 0 && vl_13 <= vl_15 ) {
System . vr_4 ( vl_14 , 0 , vr_2 , vl_2 , vl_14 . length ) ;
vl_2 += vl_14 . length ;
vl_15 = 0 ;
}
}
}
}
}
void fn_8 ( final byte [] vr_12 , int vr_13 , final int vr_14 ) {
if ( vl_6 ) {
return;
}
if ( vr_14 < 0 ) {
vl_6 = true ;
}
for ( int vr_15 = 0 ; vr_15 < vr_14 ; vr_15 ++ ) {
if ( vr_2 == null || vr_2 . length - vl_2 < vl_16 ) {
fn_4 () ;
}
final byte vr_3 = vr_12 [ vr_13 ++ ] ;
if ( vr_3 == vl_12 ) {
vl_6 = true ;
break;
}
if ( vr_3 >= 0 && vr_3 < vr_16 . length ) {
final int vr_17 = vr_16 [ vr_3 ] ;
if ( vr_17 >= 0 ) {
vl_8 = ( ++ vl_8 ) % 4 ;
vl_9 = ( vl_9 << 6 ) + vr_17 ;
if ( vl_8 == 0 ) {
vr_2 [ vl_2 ++ ] = (byte) ( ( vl_9 >> 16 ) & vl_17 ) ;
vr_2 [ vl_2 ++ ] = (byte) ( ( vl_9 >> 8 ) & vl_17 ) ;
vr_2 [ vl_2 ++ ] = (byte) ( vl_9 & vl_17 ) ;
}
}
}
}
if ( vl_6 && vl_8 != 0 ) {
vl_9 = vl_9 << 6 ;
switch ( vl_8 ) {
case 2 :
vl_9 = vl_9 << 6 ;
vr_2 [ vl_2 ++ ] = (byte) ( ( vl_9 >> 16 ) & vl_17 ) ;
break;
case 3 :
vr_2 [ vl_2 ++ ] = (byte) ( ( vl_9 >> 16 ) & vl_17 ) ;
vr_2 [ vl_2 ++ ] = (byte) ( ( vl_9 >> 8 ) & vl_17 ) ;
break;
default:
break;
}
}
}
public static boolean fn_9 ( final byte vr_18 ) {
return vr_18 == vl_12 || ( vr_18 >= 0 && vr_18 < vr_16 . length && vr_16 [ vr_18 ] != - 1 ) ;
}
public static boolean fn_10 ( final byte [] vr_19 ) {
for ( final byte vr_20 : vr_19 ) {
if ( ! fn_9 ( vr_20 ) && ! fn_11 ( vr_20 ) ) {
return false ;
}
}
return true ;
}
private static boolean fn_12 ( final byte [] vr_19 ) {
for ( final byte vr_20 : vr_19 )
{
if ( fn_9 ( vr_20 ) ) {
return true ;
}
}
return false ;
}
public static byte [] fn_13 ( final byte [] vr_21 ) {
return fn_13 ( vr_21 , false ) ;
}
public static String fn_14 ( final byte [] vr_21 ) {
return fn_15 ( fn_13 ( vr_21 , true ) ) ;
}
public static String fn_16 ( final byte [] vr_21 ) {
return fn_15 ( fn_13 ( vr_21 , false ) ) ;
}
public static String fn_14 ( final byte [] vr_21 , final boolean vr_22 ) {
return fn_15 ( fn_13 ( vr_21 , vr_22 ) ) ;
}
public static byte [] fn_17 ( final byte [] vr_21 ) {
return fn_13 ( vr_21 , false , true ) ;
}
public static String fn_18 ( final byte [] vr_21 ) {
return fn_15 ( fn_13 ( vr_21 , false , true ) ) ;
}
public static byte [] fn_19 ( final byte [] vr_21 ) {
return fn_13 ( vr_21 , true ) ;
}
public byte [] fn_8 ( final String vr_23 ) {
return fn_8 ( fn_20 ( vr_23 ) ) ;
}
private byte [] fn_20 ( final String vr_23 ) {
try {
return vr_23 . vr_24 ( lr_1 ) ;
} catch ( final tp_1 vr_25 ) {
throw new fn_21 ( vr_25 ) ;
}
}
public byte [] fn_8 ( final byte [] vr_23 ) {
fn_22 () ;
if ( vr_23 == null || vr_23 . length == 0 ) {
return vr_23 ;
}
final long vr_7 = ( vr_23 . length * 3 ) / 4 ;
final byte [] vr_26 = new byte [ ( int ) vr_7 ] ;
fn_6 ( vr_26 , 0 , vr_26 . length ) ;
fn_8 ( vr_23 , 0 , vr_23 . length ) ;
fn_8 ( vr_23 , 0 , - 1 ) ;
final byte [] vr_17 = new byte [ vl_2 ] ;
fn_5 ( vr_17 , 0 , vr_17 . length ) ;
return vr_17 ;
}
public static byte [] fn_13 ( final byte [] vr_21 , final boolean vr_27 ) {
return fn_13 ( vr_21 , vr_27 , false ) ;
}
public static byte [] fn_13 ( final byte [] vr_21 , final boolean vr_27 , final boolean vr_28 ) {
return fn_13 ( vr_21 , vr_27 , vr_28 , Integer . vr_29 ) ;
}
public static byte [] fn_13 ( final byte [] vr_21 , final boolean vr_27 , final boolean vr_28 ,
final int vr_30 ) {
if ( vr_21 == null || vr_21 . length == 0 ) {
return vr_21 ;
}
final long vr_7 = fn_23 ( vr_21 , vr_27 ? vl_18 : 0 ,
vr_27 ? vl_19 : vl_20 ) ;
if ( vr_7 > vr_30 ) {
throw new IllegalArgumentException ( lr_2 + vr_7
+ lr_3 + vr_30 ) ;
}
final tp_2 vr_31 = vr_27 ? new tp_2 ( vr_28 ) : new tp_2 ( 0 , vl_19 , vr_28 ) ;
return vr_31 . fn_7 ( vr_21 ) ;
}
public static byte [] fn_24 ( final String vr_32 ) {
return new tp_2 () . fn_8 ( vr_32 ) ;
}
public static byte [] fn_24 ( final byte [] vr_33 ) {
return new tp_2 () . fn_8 ( vr_33 ) ;
}
private static boolean fn_11 ( final byte vr_34 ) {
switch ( vr_34 ) {
case ' ' :
case '\n' :
case '\r' :
case '\t' :
return true ;
default :
return false ;
}
}
public String fn_25 ( final byte [] vr_23 ) {
return fn_15 ( fn_7 ( vr_23 ) ) ;
}
private static String fn_15 ( final byte [] fn_7 ) {
String vr_35 = null ;
try {
vr_35 = new String ( fn_7 , lr_1 ) ;
} catch ( final tp_1 vr_36 ) {
throw new fn_21 ( vr_36 ) ;
}
return vr_35 ;
}
public byte [] fn_7 ( final byte [] vr_23 ) { MST[VoidMethodCallMutator]MSP[S]
fn_22 () ;
if ( vr_23 == null || vr_23 . length == 0 ) {
return vr_23 ;
}
final long vr_7 = fn_23 ( vr_23 , vl_13 , vl_14 ) ;
byte [] vr_26 = new byte [ ( int ) vr_7 ] ;
fn_6 ( vr_26 , 0 , vr_26 . length ) ;
fn_7 ( vr_23 , 0 , vr_23 . length ) ;
fn_7 ( vr_23 , 0 , - 1 ) ;
if ( vr_2 != vr_26 ) {
fn_5 ( vr_26 , 0 , vr_26 . length ) ;
}
if ( fn_1 () && vl_2 < vr_26 . length ) {
final byte [] vr_37 = new byte [ vl_2 ] ;
System . vr_4 ( vr_26 , 0 , vr_37 , 0 , vl_2 ) ;
vr_26 = vr_37 ;
}
return vr_26 ;
}
private static long fn_23 ( final byte [] vr_23 , int vr_38 , final byte [] vr_39 ) {
vr_38 = ( vr_38 / 4 ) * 4 ;
long vr_7 = ( vr_23 . length * 4 ) / 3 ;
final long vr_40 = vr_7 % 4 ;
if ( vr_40 != 0 ) {
vr_7 += 4 - vr_40 ;
}
if ( vr_38 > 0 ) {
final boolean vr_41 = vr_7 % vr_38 == 0 ;
vr_7 += ( vr_7 / vr_38 ) * vr_39 . length ;
if ( ! vr_41 ) {
vr_7 += vr_39 . length ;
}
}
return vr_7 ;
}
public static tp_3 fn_26 ( final byte [] vr_23 ) {
return new tp_3 ( 1 , fn_24 ( vr_23 ) ) ;
}
public static byte [] fn_27 ( final tp_3 vr_42 ) {
if ( vr_42 == null ) {
throw new fn_28 ( lr_4 ) ;
}
return fn_13 ( fn_29 ( vr_42 ) , false ) ;
}
static byte [] fn_29 ( final tp_3 vr_42 ) {
int vr_43 = vr_42 . vr_44 () ;
vr_43 = ( ( vr_43 + 7 ) >> 3 ) << 3 ;
final byte [] vr_45 = vr_42 . vr_46 () ;
if ( ( ( vr_42 . vr_44 () % 8 ) != 0 ) && ( ( ( vr_42 . vr_44 () / 8 ) + 1 ) == ( vr_43 / 8 ) ) ) {
return vr_45 ;
}
int vr_47 = 0 ;
int vr_7 = vr_45 . length ;
if ( ( vr_42 . vr_44 () % 8 ) == 0 ) {
vr_47 = 1 ;
vr_7 -- ;
}
final int vr_48 = vr_43 / 8 - vr_7 ;
final byte [] vr_49 = new byte [ vr_43 / 8 ] ;
System . vr_4 ( vr_45 , vr_47 , vr_49 , vr_48 , vr_7 ) ;
return vr_49 ;
}
private void fn_22 () {
vr_2 = null ;
vl_2 = 0 ;
vl_3 = 0 ;
vl_15 = 0 ;
vl_8 = 0 ;
vl_6 = false ;
}
int fn_30 () {
return vl_13 ;
}
byte [] fn_31 () {
return vl_14 . vr_50 () ;
}

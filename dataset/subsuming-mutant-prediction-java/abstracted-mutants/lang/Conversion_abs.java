public static int fn_1 ( final char vr_1 ) {
final int vr_2 = vr_3 . vr_2 ( vr_1 , 16 ) ;
if ( vr_2 < 0 ) {
throw new IllegalArgumentException ( lr_1 + vr_1 + lr_2 ) ;
}
return vr_2 ;
}
public static int fn_2 ( final char vr_1 ) {
switch ( vr_1 ) {
case '0' :
return 0x0 ;
case '1' :
return 0x8 ;
case '2' :
return 0x4 ;
case '3' :
return 0xC ;
case '4' :
return 0x2 ;
case '5' :
return 0xA ;
case '6' :
return 0x6 ;
case '7' :
return 0xE ;
case '8' :
return 0x1 ;
case '9' :
return 0x9 ;
case 'a' :
case 'A' :
return 0x5 ;
case 'b' :
case 'B' :
return 0xD ;
case 'c' :
case 'C' :
return 0x3 ;
case 'd' :
case 'D' :
return 0xB ;
case 'e' :
case 'E' :
return 0x7 ;
case 'f' :
case 'F' :
return 0xF ;
default:
throw new IllegalArgumentException ( lr_1 + vr_1 + lr_2 ) ;
}
}
public static boolean [] fn_3 ( final char vr_1 ) {
switch ( vr_1 ) {
case '0' :
return vr_4 . vr_5 () ;
case '1' :
return vr_6 . vr_5 () ;
case '2' :
return vr_7 . vr_5 () ;
case '3' :
return vr_8 . vr_5 () ;
case '4' :
return vr_9 . vr_5 () ;
case '5' :
return vr_10 . vr_5 () ;
case '6' :
return vr_11 . vr_5 () ;
case '7' :
return vr_12 . vr_5 () ;
case '8' :
return vr_13 . vr_5 () ;
case '9' :
return vr_14 . vr_5 () ;
case 'a' :
case 'A' :
return vr_15 . vr_5 () ;
case 'b' :
case 'B' :
return vr_16 . vr_5 () ;
case 'c' :
case 'C' :
return vr_17 . vr_5 () ;
case 'd' :
case 'D' :
return vr_18 . vr_5 () ;
case 'e' :
case 'E' :
return vr_19 . vr_5 () ;
case 'f' :
case 'F' :
return vr_20 . vr_5 () ;
default:
throw new IllegalArgumentException ( lr_1 + vr_1 + lr_2 ) ;
}
}
public static boolean [] fn_4 ( final char vr_1 ) {
switch ( vr_1 ) {
case '0' :
return vr_4 . vr_5 () ;
case '1' :
return vr_13 . vr_5 () ;
case '2' :
return vr_9 . vr_5 () ;
case '3' :
return vr_17 . vr_5 () ;
case '4' :
return vr_7 . vr_5 () ;
case '5' :
return vr_15 . vr_5 () ;
case '6' :
return vr_11 . vr_5 () ;
case '7' :
return vr_19 . vr_5 () ;
case '8' :
return vr_6 . vr_5 () ;
case '9' :
return vr_14 . vr_5 () ;
case 'a' :
case 'A' :
return vr_10 . vr_5 () ;
case 'b' :
case 'B' :
return vr_18 . vr_5 () ;
case 'c' :
case 'C' :
return vr_8 . vr_5 () ;
case 'd' :
case 'D' :
return vr_16 . vr_5 () ;
case 'e' :
case 'E' :
return vr_12 . vr_5 () ;
case 'f' :
case 'F' :
return vr_20 . vr_5 () ;
default:
throw new IllegalArgumentException ( lr_1 + vr_1 + lr_2 ) ;
}
}
public static char fn_5 ( final boolean [] vr_21 ) {
return fn_5 ( vr_21 , 0 ) ;
}
public static char fn_5 ( final boolean [] vr_21 , final int vr_22 ) {
if ( vr_21 . length == 0 ) {
throw new IllegalArgumentException ( lr_3 ) ;
}
if ( vr_21 . length > vr_22 + 3 && vr_21 [ vr_22 + 3 ] ) {
if ( vr_21 . length > vr_22 + 2 && vr_21 [ vr_22 + 2 ] ) {
if ( vr_21 . length > vr_22 + 1 && vr_21 [ vr_22 + 1 ] ) {
return vr_21 [ vr_22 ] ? 'f' : 'e' ;
}
return vr_21 [ vr_22 ] ? 'd' : 'c' ;
}
if ( vr_21 . length > vr_22 + 1 && vr_21 [ vr_22 + 1 ] ) {
return vr_21 [ vr_22 ] ? 'b' : 'a' ;
}
return vr_21 [ vr_22 ] ? '9' : '8' ;
}
if ( vr_21 . length > vr_22 + 2 && vr_21 [ vr_22 + 2 ] ) {
if ( vr_21 . length > vr_22 + 1 && vr_21 [ vr_22 + 1 ] ) {
return vr_21 [ vr_22 ] ? '7' : '6' ;
}
return vr_21 [ vr_22 ] ? '5' : '4' ;
}
if ( vr_21 . length > vr_22 + 1 && vr_21 [ vr_22 + 1 ] ) {
return vr_21 [ vr_22 ] ? '3' : '2' ;
}
return vr_21 [ vr_22 ] ? '1' : '0' ;
}
public static char fn_6 ( final boolean [] vr_21 ) {
return fn_6 ( vr_21 , 0 ) ;
}
public static char fn_6 ( final boolean [] vr_21 , final int vr_22 ) {
if ( vr_21 . length > 8 ) {
throw new IllegalArgumentException ( lr_4 + vr_21 . length ) ;
}
if ( vr_21 . length - vr_22 < 4 ) {
throw new IllegalArgumentException ( lr_5 + vr_21 . length + lr_6 + vr_22 ) ;
}
if ( vr_21 [ vr_22 + 3 ] ) {
if ( vr_21 [ vr_22 + 2 ] ) {
if ( vr_21 [ vr_22 + 1 ] ) {
return vr_21 [ vr_22 ] ? 'f' : '7' ;
}
return vr_21 [ vr_22 ] ? 'b' : '3' ;
}
if ( vr_21 [ vr_22 + 1 ] ) {
return vr_21 [ vr_22 ] ? 'd' : '5' ;
}
return vr_21 [ vr_22 ] ? '9' : '1' ;
}
if ( vr_21 [ vr_22 + 2 ] ) {
if ( vr_21 [ vr_22 + 1 ] ) {
return vr_21 [ vr_22 ] ? 'e' : '6' ;
}
return vr_21 [ vr_22 ] ? 'a' : '2' ;
}
if ( vr_21 [ vr_22 + 1 ] ) {
return vr_21 [ vr_22 ] ? 'c' : '4' ;
}
return vr_21 [ vr_22 ] ? '8' : '0' ;
}
public static char fn_7 ( final boolean [] vr_21 ) {
return fn_7 ( vr_21 , 0 ) ;
}
public static char fn_7 ( boolean [] vr_21 , int vr_22 ) {
if ( vr_21 . length == 0 ) {
throw new IllegalArgumentException ( lr_3 ) ;
}
final int vr_23 = vr_21 . length - 1 - vr_22 ;
final int vr_24 = vr_25 . vr_26 ( 4 , vr_23 + 1 ) ;
final boolean [] vr_27 = new boolean [ 4 ] ;
System . vr_28 ( vr_21 , vr_23 + 1 - vr_24 , vr_27 , 4 - vr_24 , vr_24 ) ;
vr_21 = vr_27 ;
vr_22 = 0 ;
if ( vr_21 [ vr_22 ] ) {
if ( vr_21 . length > vr_22 + 1 && vr_21 [ vr_22 + 1 ] ) {
if ( vr_21 . length > vr_22 + 2 && vr_21 [ vr_22 + 2 ] ) {
return vr_21 . length > vr_22 + 3 && vr_21 [ vr_22 + 3 ] ? 'f' : 'e' ;
}
return vr_21 . length > vr_22 + 3 && vr_21 [ vr_22 + 3 ] ? 'd' : 'c' ;
}
if ( vr_21 . length > vr_22 + 2 && vr_21 [ vr_22 + 2 ] ) {
return vr_21 . length > vr_22 + 3 && vr_21 [ vr_22 + 3 ] ? 'b' : 'a' ;
}
return vr_21 . length > vr_22 + 3 && vr_21 [ vr_22 + 3 ] ? '9' : '8' ;
}
if ( vr_21 . length > vr_22 + 1 && vr_21 [ vr_22 + 1 ] ) {
if ( vr_21 . length > vr_22 + 2 && vr_21 [ vr_22 + 2 ] ) {
return vr_21 . length > vr_22 + 3 && vr_21 [ vr_22 + 3 ] ? '7' : '6' ;
}
return vr_21 . length > vr_22 + 3 && vr_21 [ vr_22 + 3 ] ? '5' : '4' ;
}
if ( vr_21 . length > vr_22 + 2 && vr_21 [ vr_22 + 2 ] ) {
return vr_21 . length > vr_22 + 3 && vr_21 [ vr_22 + 3 ] ? '3' : '2' ;
}
return vr_21 . length > vr_22 + 3 && vr_21 [ vr_22 + 3 ] ? '1' : '0' ;
}
public static char fn_8 ( final int vr_29 ) {
final char vr_30 = vr_3 . vr_31 ( vr_29 , 16 ) ;
if ( vr_30 == vr_3 . vr_32 ) {
throw new IllegalArgumentException ( lr_7 + vr_29 ) ;
}
return vr_30 ;
}
public static char fn_9 ( final int vr_29 ) {
switch ( vr_29 ) {
case 0x0 :
return '0' ;
case 0x1 :
return '8' ;
case 0x2 :
return '4' ;
case 0x3 :
return 'c' ;
case 0x4 :
return '2' ;
case 0x5 :
return 'a' ;
case 0x6 :
return '6' ;
case 0x7 :
return 'e' ;
case 0x8 :
return '1' ;
case 0x9 :
return '9' ;
case 0xA :
return '5' ;
case 0xB :
return 'd' ;
case 0xC :
return '3' ;
case 0xD :
return 'b' ;
case 0xE :
return '7' ;
case 0xF :
return 'f' ;
default:
throw new IllegalArgumentException ( lr_7 + vr_29 ) ;
}
}
public static long fn_10 ( final int [] vr_21 , final int vr_22 , final long vr_33 , final int vr_34 ,
final int vr_35 ) {
if ( vr_21 . length == 0 && vr_22 == 0 || 0 == vr_35 ) {
return vr_33 ;
}
if ( ( vr_35 - 1 ) * 32 + vr_34 >= 64 ) {
throw new IllegalArgumentException ( lr_8 ) ;
}
long out = vr_33 ;
for ( int vr_36 = 0 ; vr_36 < vr_35 ; vr_36 ++ ) {
final int vr_37 = vr_36 * 32 + vr_34 ;
final long vr_38 = ( 0xffffffffL & vr_21 [ vr_36 + vr_22 ] ) << vr_37 ;
final long vr_39 = 0xffffffffL << vr_37 ;
out = ( out & ~ vr_39 ) | vr_38 ;
}
return out ;
}
public static long fn_11 ( final short [] vr_21 , final int vr_22 , final long vr_33 , final int vr_34 ,
final int vr_40 ) {
if ( vr_21 . length == 0 && vr_22 == 0 || 0 == vr_40 ) {
return vr_33 ;
}
if ( ( vr_40 - 1 ) * 16 + vr_34 >= 64 ) {
throw new IllegalArgumentException ( lr_9 ) ;
}
long out = vr_33 ;
for ( int vr_36 = 0 ; vr_36 < vr_40 ; vr_36 ++ ) {
final int vr_37 = vr_36 * 16 + vr_34 ;
final long vr_38 = ( 0xffffL & vr_21 [ vr_36 + vr_22 ] ) << vr_37 ;
final long vr_39 = 0xffffL << vr_37 ;
out = ( out & ~ vr_39 ) | vr_38 ;
}
return out ;
}
public static int fn_12 ( final short [] vr_21 , final int vr_22 , final int vr_33 , final int vr_34 ,
final int vr_40 ) {
if ( vr_21 . length == 0 && vr_22 == 0 || 0 == vr_40 ) {
return vr_33 ;
}
if ( ( vr_40 - 1 ) * 16 + vr_34 >= 32 ) {
throw new IllegalArgumentException ( lr_10 ) ;
}
int out = vr_33 ;
for ( int vr_36 = 0 ; vr_36 < vr_40 ; vr_36 ++ ) {
final int vr_37 = vr_36 * 16 + vr_34 ;
final int vr_38 = ( 0xffff & vr_21 [ vr_36 + vr_22 ] ) << vr_37 ;
final int vr_39 = 0xffff << vr_37 ;
out = ( out & ~ vr_39 ) | vr_38 ;
}
return out ;
}
public static long fn_13 ( final byte [] vr_21 , final int vr_22 , final long vr_33 , final int vr_34 ,
final int vr_41 ) {
if ( vr_21 . length == 0 && vr_22 == 0 || 0 == vr_41 ) {
return vr_33 ;
}
if ( ( vr_41 - 1 ) * 8 + vr_34 >= 64 ) {
throw new IllegalArgumentException ( lr_11 ) ;
}
long out = vr_33 ;
for ( int vr_36 = 0 ; vr_36 < vr_41 ; vr_36 ++ ) {
final int vr_37 = vr_36 * 8 + vr_34 ;
final long vr_38 = ( 0xffL & vr_21 [ vr_36 + vr_22 ] ) << vr_37 ;
final long vr_39 = 0xffL << vr_37 ;
out = ( out & ~ vr_39 ) | vr_38 ;
}
return out ;
}
public static int fn_14 ( final byte [] vr_21 , final int vr_22 , final int vr_33 , final int vr_34 ,
final int vr_41 ) {
if ( vr_21 . length == 0 && vr_22 == 0 || 0 == vr_41 ) {
return vr_33 ;
}
if ( ( vr_41 - 1 ) * 8 + vr_34 >= 32 ) {
throw new IllegalArgumentException ( lr_12 ) ;
}
int out = vr_33 ;
for ( int vr_36 = 0 ; vr_36 < vr_41 ; vr_36 ++ ) {
final int vr_37 = vr_36 * 8 + vr_34 ;
final int vr_38 = ( 0xff & vr_21 [ vr_36 + vr_22 ] ) << vr_37 ;
final int vr_39 = 0xff << vr_37 ;
out = ( out & ~ vr_39 ) | vr_38 ;
}
return out ;
}
public static short fn_15 ( final byte [] vr_21 , final int vr_22 , final short vr_33 , final int vr_34 ,
final int vr_41 ) {
if ( vr_21 . length == 0 && vr_22 == 0 || 0 == vr_41 ) {
return vr_33 ;
}
if ( ( vr_41 - 1 ) * 8 + vr_34 >= 16 ) {
throw new IllegalArgumentException ( lr_13 ) ;
}
short out = vr_33 ;
for ( int vr_36 = 0 ; vr_36 < vr_41 ; vr_36 ++ ) {
final int vr_37 = vr_36 * 8 + vr_34 ;
final int vr_38 = ( 0xff & vr_21 [ vr_36 + vr_22 ] ) << vr_37 ;
final int vr_39 = 0xff << vr_37 ;
out = (short) ( ( out & ~ vr_39 ) | vr_38 ) ;
}
return out ;
}
public static long fn_16 ( final String vr_21 , final int vr_22 , final long vr_33 , final int vr_34 ,
final int vr_42 ) {
if ( 0 == vr_42 ) {
return vr_33 ;
}
if ( ( vr_42 - 1 ) * 4 + vr_34 >= 64 ) {
throw new IllegalArgumentException ( lr_14 ) ;
}
long out = vr_33 ;
for ( int vr_36 = 0 ; vr_36 < vr_42 ; vr_36 ++ ) {
final int vr_37 = vr_36 * 4 + vr_34 ;
final long vr_38 = ( 0xfL & fn_1 ( vr_21 . charAt ( vr_36 + vr_22 ) ) ) << vr_37 ;
final long vr_39 = 0xfL << vr_37 ;
out = ( out & ~ vr_39 ) | vr_38 ;
}
return out ;
}
public static int fn_17 ( final String vr_21 , final int vr_22 , final int vr_33 , final int vr_34 , final int vr_42 ) {
if ( 0 == vr_42 ) {
return vr_33 ;
}
if ( ( vr_42 - 1 ) * 4 + vr_34 >= 32 ) {
throw new IllegalArgumentException ( lr_15 ) ;
}
int out = vr_33 ;
for ( int vr_36 = 0 ; vr_36 < vr_42 ; vr_36 ++ ) {
final int vr_37 = vr_36 * 4 + vr_34 ;
final int vr_38 = ( 0xf & fn_1 ( vr_21 . charAt ( vr_36 + vr_22 ) ) ) << vr_37 ;
final int vr_39 = 0xf << vr_37 ;
out = ( out & ~ vr_39 ) | vr_38 ;
}
return out ;
}
public static short fn_18 ( final String vr_21 , final int vr_22 , final short vr_33 , final int vr_34 ,
final int vr_42 ) {
if ( 0 == vr_42 ) {
return vr_33 ;
}
if ( ( vr_42 - 1 ) * 4 + vr_34 >= 16 ) {
throw new IllegalArgumentException ( lr_16 ) ;
}
short out = vr_33 ;
for ( int vr_36 = 0 ; vr_36 < vr_42 ; vr_36 ++ ) {
final int vr_37 = vr_36 * 4 + vr_34 ;
final int vr_38 = ( 0xf & fn_1 ( vr_21 . charAt ( vr_36 + vr_22 ) ) ) << vr_37 ;
final int vr_39 = 0xf << vr_37 ;
out = (short) ( ( out & ~ vr_39 ) | vr_38 ) ;
}
return out ;
}
public static byte fn_19 ( final String vr_21 , final int vr_22 , final byte vr_33 , final int vr_34 ,
final int vr_42 ) {
if ( 0 == vr_42 ) {
return vr_33 ;
}
if ( ( vr_42 - 1 ) * 4 + vr_34 >= 8 ) {
throw new IllegalArgumentException ( lr_17 ) ;
}
byte out = vr_33 ;
for ( int vr_36 = 0 ; vr_36 < vr_42 ; vr_36 ++ ) {
final int vr_37 = vr_36 * 4 + vr_34 ;
final int vr_38 = ( 0xf & fn_1 ( vr_21 . charAt ( vr_36 + vr_22 ) ) ) << vr_37 ;
final int vr_39 = 0xf << vr_37 ;
out = (byte) ( ( out & ~ vr_39 ) | vr_38 ) ;
}
return out ;
}
public static long fn_20 ( final boolean [] vr_21 , final int vr_22 , final long vr_33 , final int vr_34 ,
final int vr_43 ) {
if ( vr_21 . length == 0 && vr_22 == 0 || 0 == vr_43 ) {
return vr_33 ;
}
if ( vr_43 - 1 + vr_34 >= 64 ) {
throw new IllegalArgumentException ( lr_18 ) ;
}
long out = vr_33 ;
for ( int vr_36 = 0 ; vr_36 < vr_43 ; vr_36 ++ ) {
final int vr_37 = vr_36 + vr_34 ;
final long vr_38 = ( vr_21 [ vr_36 + vr_22 ] ? 1L : 0 ) << vr_37 ;
final long vr_39 = 0x1L << vr_37 ;
out = ( out & ~ vr_39 ) | vr_38 ;
}
return out ;
}
public static int fn_21 ( final boolean [] vr_21 , final int vr_22 , final int vr_33 , final int vr_34 ,
final int vr_43 ) {
if ( vr_21 . length == 0 && vr_22 == 0 || 0 == vr_43 ) {
return vr_33 ;
}
if ( vr_43 - 1 + vr_34 >= 32 ) {
throw new IllegalArgumentException ( lr_19 ) ;
}
int out = vr_33 ;
for ( int vr_36 = 0 ; vr_36 < vr_43 ; vr_36 ++ ) {
final int vr_37 = vr_36 + vr_34 ;
final int vr_38 = ( vr_21 [ vr_36 + vr_22 ] ? 1 : 0 ) << vr_37 ;
final int vr_39 = 0x1 << vr_37 ;
out = ( out & ~ vr_39 ) | vr_38 ;
}
return out ;
}
public static short fn_22 ( final boolean [] vr_21 , final int vr_22 , final short vr_33 , final int vr_34 ,
final int vr_43 ) {
if ( vr_21 . length == 0 && vr_22 == 0 || 0 == vr_43 ) {
return vr_33 ;
}
if ( vr_43 - 1 + vr_34 >= 16 ) {
throw new IllegalArgumentException ( lr_20 ) ;
}
short out = vr_33 ;
for ( int vr_36 = 0 ; vr_36 < vr_43 ; vr_36 ++ ) {
final int vr_37 = vr_36 + vr_34 ;
final int vr_38 = ( vr_21 [ vr_36 + vr_22 ] ? 1 : 0 ) << vr_37 ;
final int vr_39 = 0x1 << vr_37 ;
out = (short) ( ( out & ~ vr_39 ) | vr_38 ) ;
}
return out ;
}
public static byte fn_23 ( final boolean [] vr_21 , final int vr_22 , final byte vr_33 , final int vr_34 ,
final int vr_43 ) {
if ( vr_21 . length == 0 && vr_22 == 0 || 0 == vr_43 ) {
return vr_33 ;
}
if ( vr_43 - 1 + vr_34 >= 8 ) {
throw new IllegalArgumentException ( lr_21 ) ;
}
byte out = vr_33 ;
for ( int vr_36 = 0 ; vr_36 < vr_43 ; vr_36 ++ ) {
final int vr_37 = vr_36 + vr_34 ;
final int vr_38 = ( vr_21 [ vr_36 + vr_22 ] ? 1 : 0 ) << vr_37 ;
final int vr_39 = 0x1 << vr_37 ;
out = (byte) ( ( out & ~ vr_39 ) | vr_38 ) ;
}
return out ;
}
public static int [] fn_24 ( final long vr_21 , final int vr_22 , final int [] vr_44 , final int vr_34 ,
final int vr_35 ) {
if ( 0 == vr_35 ) {
return vr_44 ;
}
if ( ( vr_35 - 1 ) * 32 + vr_22 >= 64 ) {
throw new IllegalArgumentException ( lr_22 ) ;
}
for ( int vr_36 = 0 ; vr_36 < vr_35 ; vr_36 ++ ) {
final int vr_37 = vr_36 * 32 + vr_22 ;
vr_44 [ vr_34 + vr_36 ] = (int) ( 0xffffffff & ( vr_21 >> vr_37 ) ) ;
}
return vr_44 ;
}
public static short [] fn_25 ( final long vr_21 , final int vr_22 , final short [] vr_44 , final int vr_34 ,
final int vr_40 ) {
if ( 0 == vr_40 ) {
return vr_44 ;
}
if ( ( vr_40 - 1 ) * 16 + vr_22 >= 64 ) {
throw new IllegalArgumentException ( lr_23 ) ;
}
for ( int vr_36 = 0 ; vr_36 < vr_40 ; vr_36 ++ ) {
final int vr_37 = vr_36 * 16 + vr_22 ;
vr_44 [ vr_34 + vr_36 ] = (short) ( 0xffff & ( vr_21 >> vr_37 ) ) ;
}
return vr_44 ;
}
public static short [] fn_26 ( final int vr_21 , final int vr_22 , final short [] vr_44 , final int vr_34 ,
final int vr_40 ) {
if ( 0 == vr_40 ) {
return vr_44 ;
}
if ( ( vr_40 - 1 ) * 16 + vr_22 >= 32 ) {
throw new IllegalArgumentException ( lr_24 ) ;
}
for ( int vr_36 = 0 ; vr_36 < vr_40 ; vr_36 ++ ) {
final int vr_37 = vr_36 * 16 + vr_22 ;
vr_44 [ vr_34 + vr_36 ] = (short) ( 0xffff & ( vr_21 >> vr_37 ) ) ;
}
return vr_44 ;
}
public static byte [] fn_27 ( final long vr_21 , final int vr_22 , final byte [] vr_44 , final int vr_34 ,
final int vr_41 ) {
if ( 0 == vr_41 ) {
return vr_44 ;
}
if ( ( vr_41 - 1 ) * 8 + vr_22 >= 64 ) {
throw new IllegalArgumentException ( lr_25 ) ;
}
for ( int vr_36 = 0 ; vr_36 < vr_41 ; vr_36 ++ ) {
final int vr_37 = vr_36 * 8 + vr_22 ;
vr_44 [ vr_34 + vr_36 ] = (byte) ( 0xff & ( vr_21 >> vr_37 ) ) ;
}
return vr_44 ;
}
public static byte [] fn_28 ( final int vr_21 , final int vr_22 , final byte [] vr_44 , final int vr_34 ,
final int vr_41 ) {
if ( 0 == vr_41 ) {
return vr_44 ;
}
if ( ( vr_41 - 1 ) * 8 + vr_22 >= 32 ) {
throw new IllegalArgumentException ( lr_26 ) ;
}
for ( int vr_36 = 0 ; vr_36 < vr_41 ; vr_36 ++ ) {
final int vr_37 = vr_36 * 8 + vr_22 ;
vr_44 [ vr_34 + vr_36 ] = (byte) ( 0xff & ( vr_21 >> vr_37 ) ) ;
}
return vr_44 ;
}
public static byte [] fn_29 ( final short vr_21 , final int vr_22 , final byte [] vr_44 , final int vr_34 ,
final int vr_41 ) {
if ( 0 == vr_41 ) {
return vr_44 ;
}
if ( ( vr_41 - 1 ) * 8 + vr_22 >= 16 ) {
throw new IllegalArgumentException ( lr_27 ) ;
}
for ( int vr_36 = 0 ; vr_36 < vr_41 ; vr_36 ++ ) {
final int vr_37 = vr_36 * 8 + vr_22 ;
vr_44 [ vr_34 + vr_36 ] = (byte) ( 0xff & ( vr_21 >> vr_37 ) ) ;
}
return vr_44 ;
}
public static String fn_30 ( final long vr_21 , final int vr_22 , final String vr_33 , final int vr_34 ,
final int vr_45 ) {
if ( 0 == vr_45 ) {
return vr_33 ;
}
if ( ( vr_45 - 1 ) * 4 + vr_22 >= 64 ) {
throw new IllegalArgumentException ( lr_28 ) ;
}
final StringBuilder vr_46 = new StringBuilder ( vr_33 ) ;
int append = vr_46 . length () ;
for ( int vr_36 = 0 ; vr_36 < vr_45 ; vr_36 ++ ) {
final int vr_37 = vr_36 * 4 + vr_22 ;
final int vr_38 = (int) ( 0xF & ( vr_21 >> vr_37 ) ) ;
if ( vr_34 + vr_36 == append ) {
++ append ;
vr_46 . append ( fn_8 ( vr_38 ) ) ;
} else {
vr_46 . vr_47 ( vr_34 + vr_36 , fn_8 ( vr_38 ) ) ;
}
}
return vr_46 . toString () ;
}
public static String fn_31 ( final int vr_21 , final int vr_22 , final String vr_33 , final int vr_34 ,
final int vr_45 ) {
if ( 0 == vr_45 ) {
return vr_33 ;
}
if ( ( vr_45 - 1 ) * 4 + vr_22 >= 32 ) {
throw new IllegalArgumentException ( lr_29 ) ;
}
final StringBuilder vr_46 = new StringBuilder ( vr_33 ) ;
int append = vr_46 . length () ;
for ( int vr_36 = 0 ; vr_36 < vr_45 ; vr_36 ++ ) {
final int vr_37 = vr_36 * 4 + vr_22 ;
final int vr_38 = 0xF & ( vr_21 >> vr_37 ) ;
if ( vr_34 + vr_36 == append ) {
++ append ;
vr_46 . append ( fn_8 ( vr_38 ) ) ;
} else {
vr_46 . vr_47 ( vr_34 + vr_36 , fn_8 ( vr_38 ) ) ;
}
}
return vr_46 . toString () ;
}
public static String fn_32 ( final short vr_21 , final int vr_22 , final String vr_33 , final int vr_34 ,
final int vr_45 ) {
if ( 0 == vr_45 ) {
return vr_33 ;
}
if ( ( vr_45 - 1 ) * 4 + vr_22 >= 16 ) {
throw new IllegalArgumentException ( lr_30 ) ;
}
final StringBuilder vr_46 = new StringBuilder ( vr_33 ) ;
int append = vr_46 . length () ;
for ( int vr_36 = 0 ; vr_36 < vr_45 ; vr_36 ++ ) {
final int vr_37 = vr_36 * 4 + vr_22 ;
final int vr_38 = 0xF & ( vr_21 >> vr_37 ) ;
if ( vr_34 + vr_36 == append ) {
++ append ;
vr_46 . append ( fn_8 ( vr_38 ) ) ;
} else {
vr_46 . vr_47 ( vr_34 + vr_36 , fn_8 ( vr_38 ) ) ;
}
}
return vr_46 . toString () ;
}
public static String fn_33 ( final byte vr_21 , final int vr_22 , final String vr_33 , final int vr_34 ,
final int vr_45 ) {
if ( 0 == vr_45 ) {
return vr_33 ;
}
if ( ( vr_45 - 1 ) * 4 + vr_22 >= 8 ) {
throw new IllegalArgumentException ( lr_31 ) ;
}
final StringBuilder vr_46 = new StringBuilder ( vr_33 ) ;
int append = vr_46 . length () ;
for ( int vr_36 = 0 ; vr_36 < vr_45 ; vr_36 ++ ) {
final int vr_37 = vr_36 * 4 + vr_22 ;
final int vr_38 = 0xF & ( vr_21 >> vr_37 ) ;
if ( vr_34 + vr_36 == append ) {
++ append ;
vr_46 . append ( fn_8 ( vr_38 ) ) ;
} else {
vr_46 . vr_47 ( vr_34 + vr_36 , fn_8 ( vr_38 ) ) ;
}
}
return vr_46 . toString () ;
}
public static boolean [] fn_34 ( final long vr_21 , final int vr_22 , final boolean [] vr_44 , final int vr_34 ,
final int vr_43 ) {
if ( 0 == vr_43 ) {
return vr_44 ;
}
if ( vr_43 - 1 + vr_22 >= 64 ) {
throw new IllegalArgumentException ( lr_32 ) ;
}
for ( int vr_36 = 0 ; vr_36 < vr_43 ; vr_36 ++ ) {
final int vr_37 = vr_36 + vr_22 ;
vr_44 [ vr_34 + vr_36 ] = ( 0x1 & ( vr_21 >> vr_37 ) ) != 0 ;
}
return vr_44 ;
}
public static boolean [] fn_35 ( final int vr_21 , final int vr_22 , final boolean [] vr_44 , final int vr_34 ,
final int vr_43 ) {
if ( 0 == vr_43 ) {
return vr_44 ;
}
if ( vr_43 - 1 + vr_22 >= 32 ) {
throw new IllegalArgumentException ( lr_33 ) ;
}
for ( int vr_36 = 0 ; vr_36 < vr_43 ; vr_36 ++ ) {
final int vr_37 = vr_36 + vr_22 ;
vr_44 [ vr_34 + vr_36 ] = ( 0x1 & ( vr_21 >> vr_37 ) ) != 0 ;
}
return vr_44 ;
}
public static boolean [] fn_36 ( final short vr_21 , final int vr_22 , final boolean [] vr_44 , final int vr_34 ,
final int vr_43 ) {
if ( 0 == vr_43 ) {
return vr_44 ;
}
if ( vr_43 - 1 + vr_22 >= 16 ) {
throw new IllegalArgumentException ( lr_34 ) ;
}
assert ( vr_43 - 1 ) < 16 - vr_22 ;
for ( int vr_36 = 0 ; vr_36 < vr_43 ; vr_36 ++ ) {
final int vr_37 = vr_36 + vr_22 ;
vr_44 [ vr_34 + vr_36 ] = ( 0x1 & ( vr_21 >> vr_37 ) ) != 0 ;
}
return vr_44 ;
}
public static boolean [] fn_37 ( final byte vr_21 , final int vr_22 , final boolean [] vr_44 , final int vr_34 ,
final int vr_43 ) {
if ( 0 == vr_43 ) {
return vr_44 ;
}
if ( vr_43 - 1 + vr_22 >= 8 ) {
throw new IllegalArgumentException ( lr_35 ) ;
}
for ( int vr_36 = 0 ; vr_36 < vr_43 ; vr_36 ++ ) {
final int vr_37 = vr_36 + vr_22 ;
vr_44 [ vr_34 + vr_36 ] = ( 0x1 & ( vr_21 >> vr_37 ) ) != 0 ;
}
return vr_44 ;
}
public static byte [] fn_38 ( final tp_1 vr_21 , final byte [] vr_44 , final int vr_34 , final int vr_41 ) {
if ( 0 == vr_41 ) {
return vr_44 ;
}
if ( vr_41 > 16 ) {
throw new IllegalArgumentException ( lr_36 ) ;
}
fn_27 ( vr_21 . vr_48 () , 0 , vr_44 , vr_34 , vr_41 > 8 ? 8 : vr_41 ) ;
if ( vr_41 >= 8 ) {
fn_27 ( vr_21 . vr_49 () , 0 , vr_44 , vr_34 + 8 , vr_41 - 8 ) ;
}
return vr_44 ;
}
public static tp_1 fn_39 ( final byte [] vr_21 , final int vr_22 ) {
if ( vr_21 . length - vr_22 < 16 ) {
throw new IllegalArgumentException ( lr_37 ) ;
}
return new tp_1 ( fn_13 ( vr_21 , vr_22 , 0 , 0 , 8 ) , fn_13 ( vr_21 , vr_22 + 8 , 0 , 0 , 8 ) ) ;
}

public static byte [] fn_1 ( final char [] vr_1 ) throws vl_1 {
final byte [] out = new byte [ vr_1 . length >> 1 ] ;
fn_1 ( vr_1 , out , 0 ) ;
return out ;
}
public static int fn_1 ( final char [] vr_1 , final byte [] out , final int vr_2 ) throws vl_1 {
final int vr_3 = vr_1 . length ;
if ( ( vr_3 & 0x01 ) != 0 ) {
throw new vl_1 ( lr_1 ) ;
}
final int vr_4 = vr_3 >> 1 ;
if ( out . length - vr_2 < vr_4 ) {
throw new vl_1 ( lr_2 ) ;
}
for ( int vr_5 = vr_2 , vr_6 = 0 ; vr_6 < vr_3 ; vr_5 ++ ) {
int vr_7 = fn_2 ( vr_1 [ vr_6 ] , vr_6 ) << 4 ; MST[rv.UOI3Mutator]MSP[N]
vr_6 ++ ;
vr_7 = vr_7 | fn_2 ( vr_1 [ vr_6 ] , vr_6 ) ;
vr_6 ++ ;
out [ vr_5 ] = (byte) ( vr_7 & 0xFF ) ;
}
return vr_4 ;
}
public static byte [] fn_1 ( final String vr_1 ) throws vl_1 {
return fn_1 ( vr_1 . vr_8 () ) ;
}
public static char [] fn_3 ( final byte [] vr_1 ) {
return fn_3 ( vr_1 , true ) ;
}
public static char [] fn_3 ( final byte [] vr_1 , final boolean vr_9 ) {
return fn_3 ( vr_1 , vr_9 ? vl_2 : vl_3 ) ;
}
protected static char [] fn_3 ( final byte [] vr_1 , final char [] vr_10 ) {
final int vr_11 = vr_1 . length ;
final char [] out = new char [ vr_11 << 1 ] ;
fn_3 ( vr_1 , 0 , vr_1 . length , vr_10 , out , 0 ) ;
return out ;
}
public static char [] fn_3 ( final byte [] vr_1 , final int vr_12 , final int vr_13 ,
final boolean vr_9 ) {
final char [] out = new char [ vr_13 << 1 ] ;
fn_3 ( vr_1 , vr_12 , vr_13 , vr_9 ? vl_2 : vl_3 , out , 0 ) ;
return out ;
}
public static void fn_3 ( final byte [] vr_1 , final int vr_12 , final int vr_13 ,
final boolean vr_9 , final char [] out , final int vr_2 ) {
fn_3 ( vr_1 , vr_12 , vr_13 , vr_9 ? vl_2 : vl_3 , out , vr_2 ) ;
}
private static void fn_3 ( final byte [] vr_1 , final int vr_12 , final int vr_13 , final char [] vr_10 ,
final char [] out , final int vr_2 ) {
for ( int vr_5 = vr_12 , vr_6 = vr_2 ; vr_5 < vr_12 + vr_13 ; vr_5 ++ ) {
out [ vr_6 ++ ] = vr_10 [ ( 0xF0 & vr_1 [ vr_5 ] ) >>> 4 ] ;
out [ vr_6 ++ ] = vr_10 [ 0x0F & vr_1 [ vr_5 ] ] ;
}
}
public static char [] fn_3 ( final tp_1 vr_1 ) {
return fn_3 ( vr_1 , true ) ;
}
public static char [] fn_3 ( final tp_1 vr_1 , final boolean vr_9 ) {
return fn_3 ( vr_1 , vr_9 ? vl_2 : vl_3 ) ;
}
protected static char [] fn_3 ( final tp_1 vr_14 , final char [] vr_10 ) {
return fn_3 ( fn_4 ( vr_14 ) , vr_10 ) ;
}
public static String fn_5 ( final byte [] vr_1 ) {
return new String ( fn_3 ( vr_1 ) ) ;
}
public static String fn_5 ( final byte [] vr_1 , final boolean vr_9 ) {
return new String ( fn_3 ( vr_1 , vr_9 ) ) ;
}
public static String fn_5 ( final tp_1 vr_1 ) {
return new String ( fn_3 ( vr_1 ) ) ;
}
public static String fn_5 ( final tp_1 vr_1 , final boolean vr_9 ) {
return new String ( fn_3 ( vr_1 , vr_9 ) ) ;
}
private static byte [] fn_4 ( final tp_1 vr_14 ) {
final int vr_15 = vr_14 . vr_15 () ;
if ( vr_14 . vr_16 () ) {
final byte [] vr_17 = vr_14 . array () ;
if ( vr_15 == vr_17 . length ) {
vr_14 . vr_18 ( vr_15 ) ;
return vr_17 ;
}
}
final byte [] vr_17 = new byte [ vr_15 ] ;
vr_14 . get ( vr_17 ) ;
return vr_17 ;
}
protected static int fn_2 ( final char vr_19 , final int vr_20 ) throws vl_1 {
final int vr_21 = vr_22 . vr_21 ( vr_19 , 16 ) ;
if ( vr_21 == - 1 ) {
throw new vl_1 ( lr_3 + vr_19 + lr_4 + vr_20 ) ;
}
return vr_21 ;
}
@Override
public byte [] fn_6 ( final byte [] array ) throws vl_1 {
return fn_1 ( new String ( array , fn_7 () ) . vr_8 () ) ;
}
public byte [] fn_6 ( final tp_1 vr_23 ) throws vl_1 {
return fn_1 ( new String ( fn_4 ( vr_23 ) , fn_7 () ) . vr_8 () ) ;
}
@Override
public Object fn_6 ( final Object object ) throws vl_1 {
if ( object instanceof String ) {
return fn_6 ( ( ( String ) object ) . vr_8 () ) ;
} else if ( object instanceof byte [] ) {
return fn_6 ( ( byte [] ) object ) ;
} else if ( object instanceof tp_1 ) {
return fn_6 ( ( tp_1 ) object ) ;
} else {
try {
return fn_1 ( ( char [] ) object ) ;
} catch ( final tp_2 vr_24 ) {
throw new vl_1 ( vr_24 . vr_25 () , vr_24 ) ;
}
}
}
@Override
public byte [] fn_8 ( final byte [] array ) {
return fn_5 ( array ) . fn_9 ( this . fn_7 () ) ;
}
public byte [] fn_8 ( final tp_1 array ) {
return fn_5 ( array ) . fn_9 ( this . fn_7 () ) ;
}
@Override
public Object fn_8 ( final Object object ) throws vl_4 {
byte [] vr_17 ;
if ( object instanceof String ) {
vr_17 = ( ( String ) object ) . fn_9 ( this . fn_7 () ) ;
} else if ( object instanceof tp_1 ) {
vr_17 = fn_4 ( ( tp_1 ) object ) ;
} else {
try {
vr_17 = ( byte [] ) object ;
} catch ( final tp_2 vr_24 ) {
throw new vl_4 ( vr_24 . vr_25 () , vr_24 ) ;
}
}
return fn_3 ( vr_17 ) ;
}
public tp_3 fn_7 () {
return this . vr_26 ;
}
public String fn_10 () {
return this . vr_26 . vr_27 () ;
}
@Override
public String toString () {
return super . toString () + lr_5 + this . vr_26 + lr_6 ;
}

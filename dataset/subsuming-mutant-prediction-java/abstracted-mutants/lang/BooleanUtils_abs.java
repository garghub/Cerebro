public static Boolean fn_1 ( final Boolean bool ) {
if ( bool == null ) {
return null ;
}
return bool . vr_1 () ? Boolean . FALSE : Boolean . TRUE ;
}
public static boolean fn_2 ( final Boolean bool ) {
return Boolean . TRUE . equals ( bool ) ;
}
public static boolean fn_3 ( final Boolean bool ) {
return ! fn_2 ( bool ) ;
}
public static boolean fn_4 ( final Boolean bool ) {
return Boolean . FALSE . equals ( bool ) ;
}
public static boolean fn_5 ( final Boolean bool ) {
return ! fn_4 ( bool ) ;
}
public static boolean fn_6 ( final Boolean bool ) {
return bool != null && bool . vr_1 () ;
}
public static boolean fn_7 ( final Boolean bool , final boolean vr_2 ) {
if ( bool == null ) {
return vr_2 ;
}
return bool . vr_1 () ;
}
public static boolean fn_6 ( final int vr_3 ) {
return vr_3 != 0 ;
}
public static Boolean fn_8 ( final int vr_3 ) {
return vr_3 == 0 ? Boolean . FALSE : Boolean . TRUE ;
}
public static Boolean fn_8 ( final Integer vr_3 ) {
if ( vr_3 == null ) {
return null ;
}
return vr_3 . vr_4 () == 0 ? Boolean . FALSE : Boolean . TRUE ;
}
public static boolean fn_6 ( final int vr_3 , final int vr_5 , final int vr_6 ) {
if ( vr_3 == vr_5 ) {
return true ;
}
if ( vr_3 == vr_6 ) {
return false ;
}
throw new IllegalArgumentException ( lr_1 ) ;
}
public static boolean fn_6 ( final Integer vr_3 , final Integer vr_5 , final Integer vr_6 ) {
if ( vr_3 == null ) {
if ( vr_5 == null ) {
return true ;
}
if ( vr_6 == null ) {
return false ;
}
} else if ( vr_3 . equals ( vr_5 ) ) {
return true ;
} else if ( vr_3 . equals ( vr_6 ) ) {
return false ;
}
throw new IllegalArgumentException ( lr_1 ) ;
}
public static Boolean fn_8 ( final int vr_3 , final int vr_5 , final int vr_6 , final int vr_7 ) {
if ( vr_3 == vr_5 ) {
return Boolean . TRUE ;
}
if ( vr_3 == vr_6 ) {
return Boolean . FALSE ;
}
if ( vr_3 == vr_7 ) {
return null ;
}
throw new IllegalArgumentException ( lr_2 ) ;
}
public static Boolean fn_8 ( final Integer vr_3 , final Integer vr_5 , final Integer vr_6 , final Integer vr_7 ) {
if ( vr_3 == null ) {
if ( vr_5 == null ) {
return Boolean . TRUE ;
}
if ( vr_6 == null ) {
return Boolean . FALSE ;
}
if ( vr_7 == null ) {
return null ;
}
} else if ( vr_3 . equals ( vr_5 ) ) {
return Boolean . TRUE ;
} else if ( vr_3 . equals ( vr_6 ) ) {
return Boolean . FALSE ;
} else if ( vr_3 . equals ( vr_7 ) ) {
return null ;
}
throw new IllegalArgumentException ( lr_2 ) ;
}
public static int fn_9 ( final boolean bool ) {
return bool ? 1 : 0 ;
}
public static Integer fn_10 ( final boolean bool ) {
return bool ? vr_8 . vr_9 : vr_8 . vr_10 ;
}
public static Integer fn_10 ( final Boolean bool ) {
if ( bool == null ) {
return null ;
}
return bool . vr_1 () ? vr_8 . vr_9 : vr_8 . vr_10 ;
}
public static int fn_9 ( final boolean bool , final int vr_5 , final int vr_6 ) {
return bool ? vr_5 : vr_6 ;
}
public static int fn_9 ( final Boolean bool , final int vr_5 , final int vr_6 , final int vr_7 ) {
if ( bool == null ) {
return vr_7 ;
}
return bool . vr_1 () ? vr_5 : vr_6 ;
}
public static Integer fn_10 ( final boolean bool , final Integer vr_5 , final Integer vr_6 ) {
return bool ? vr_5 : vr_6 ;
}
public static Integer fn_10 ( final Boolean bool , final Integer vr_5 , final Integer vr_6 , final Integer vr_7 ) {
if ( bool == null ) {
return vr_7 ;
}
return bool . vr_1 () ? vr_5 : vr_6 ;
}
public static Boolean fn_8 ( final String vr_11 ) {
if ( vr_11 == lr_3 ) {
return Boolean . TRUE ;
}
if ( vr_11 == null ) {
return null ;
}
switch ( vr_11 . length () ) {
case 1 : {
final char vr_12 = vr_11 . charAt ( 0 ) ;
if ( vr_12 == 'y' || vr_12 == 'Y' ||
vr_12 == 't' || vr_12 == 'T' ) {
return Boolean . TRUE ;
}
if ( vr_12 == 'n' || vr_12 == 'N' ||
vr_12 == 'f' || vr_12 == 'F' ) {
return Boolean . FALSE ;
}
break;
}
case 2 : {
final char vr_12 = vr_11 . charAt ( 0 ) ;
final char vr_13 = vr_11 . charAt ( 1 ) ;
if ( ( vr_12 == 'o' || vr_12 == 'O' ) &&
( vr_13 == 'n' || vr_13 == 'N' ) ) {
return Boolean . TRUE ;
}
if ( ( vr_12 == 'n' || vr_12 == 'N' ) &&
( vr_13 == 'o' || vr_13 == 'O' ) ) {
return Boolean . FALSE ;
}
break;
}
case 3 : {
final char vr_12 = vr_11 . charAt ( 0 ) ;
final char vr_13 = vr_11 . charAt ( 1 ) ;
final char vr_14 = vr_11 . charAt ( 2 ) ;
if ( ( vr_12 == 'y' || vr_12 == 'Y' ) &&
( vr_13 == 'e' || vr_13 == 'E' ) &&
( vr_14 == 's' || vr_14 == 'S' ) ) {
return Boolean . TRUE ;
}
if ( ( vr_12 == 'o' || vr_12 == 'O' ) &&
( vr_13 == 'f' || vr_13 == 'F' ) &&
( vr_14 == 'f' || vr_14 == 'F' ) ) {
return Boolean . FALSE ;
}
break;
}
case 4 : {
final char vr_12 = vr_11 . charAt ( 0 ) ;
final char vr_13 = vr_11 . charAt ( 1 ) ;
final char vr_14 = vr_11 . charAt ( 2 ) ;
final char vr_15 = vr_11 . charAt ( 3 ) ;
if ( ( vr_12 == 't' || vr_12 == 'T' ) &&
( vr_13 == 'r' || vr_13 == 'R' ) &&
( vr_14 == 'u' || vr_14 == 'U' ) &&
( vr_15 == 'e' || vr_15 == 'E' ) ) {
return Boolean . TRUE ;
}
break;
}
case 5 : {
final char vr_12 = vr_11 . charAt ( 0 ) ;
final char vr_13 = vr_11 . charAt ( 1 ) ;
final char vr_14 = vr_11 . charAt ( 2 ) ;
final char vr_15 = vr_11 . charAt ( 3 ) ;
final char vr_16 = vr_11 . charAt ( 4 ) ;
if ( ( vr_12 == 'f' || vr_12 == 'F' ) &&
( vr_13 == 'a' || vr_13 == 'A' ) &&
( vr_14 == 'l' || vr_14 == 'L' ) &&
( vr_15 == 's' || vr_15 == 'S' ) &&
( vr_16 == 'e' || vr_16 == 'E' ) ) {
return Boolean . FALSE ;
}
break;
}
default:
break;
}
return null ;
}
public static Boolean fn_8 ( final String vr_11 , final String vr_17 , final String vr_18 , final String vr_19 ) {
if ( vr_11 == null ) {
if ( vr_17 == null ) {
return Boolean . TRUE ;
}
if ( vr_18 == null ) {
return Boolean . FALSE ;
}
if ( vr_19 == null ) {
return null ;
}
} else if ( vr_11 . equals ( vr_17 ) ) {
return Boolean . TRUE ;
} else if ( vr_11 . equals ( vr_18 ) ) {
return Boolean . FALSE ;
} else if ( vr_11 . equals ( vr_19 ) ) {
return null ;
}
throw new IllegalArgumentException ( lr_4 ) ;
}
public static boolean fn_6 ( final String vr_11 ) {
return fn_8 ( vr_11 ) == Boolean . TRUE ;
}
public static boolean fn_6 ( final String vr_11 , final String vr_17 , final String vr_18 ) {
if ( vr_11 == vr_17 ) {
return true ;
} else if ( vr_11 == vr_18 ) {
return false ;
} else if ( vr_11 != null ) {
if ( vr_11 . equals ( vr_17 ) ) {
return true ;
} else if ( vr_11 . equals ( vr_18 ) ) {
return false ;
}
}
throw new IllegalArgumentException ( lr_5 ) ;
}
public static String fn_11 ( final Boolean bool ) {
return toString ( bool , lr_3 , lr_6 , null ) ;
}
public static String fn_12 ( final Boolean bool ) {
return toString ( bool , lr_7 , lr_8 , null ) ;
}
public static String fn_13 ( final Boolean bool ) {
return toString ( bool , lr_9 , lr_10 , null ) ;
}
public static String toString ( final Boolean bool , final String vr_17 , final String vr_18 , final String vr_19 ) {
if ( bool == null ) {
return vr_19 ;
}
return bool . vr_1 () ? vr_17 : vr_18 ;
}
public static String fn_11 ( final boolean bool ) {
return toString ( bool , lr_3 , lr_6 ) ;
}
public static String fn_12 ( final boolean bool ) {
return toString ( bool , lr_7 , lr_8 ) ;
}
public static String fn_13 ( final boolean bool ) {
return toString ( bool , lr_9 , lr_10 ) ;
}
public static String toString ( final boolean bool , final String vr_17 , final String vr_18 ) {
return bool ? vr_17 : vr_18 ;
}
public static boolean fn_14 ( final boolean ... array ) {
if ( array == null ) {
throw new IllegalArgumentException ( lr_11 ) ;
}
if ( array . length == 0 ) {
throw new IllegalArgumentException ( lr_12 ) ;
}
for ( final boolean vr_20 : array ) {
if ( ! vr_20 ) {
return false ;
}
}
return true ;
}
public static Boolean fn_14 ( final Boolean ... array ) {
if ( array == null ) {
throw new IllegalArgumentException ( lr_11 ) ;
}
if ( array . length == 0 ) {
throw new IllegalArgumentException ( lr_12 ) ;
}
try {
final boolean [] vr_21 = vr_22 . vr_23 ( array ) ;
return fn_14 ( vr_21 ) ? Boolean . TRUE : Boolean . FALSE ;
} catch ( final tp_1 vr_24 ) {
throw new IllegalArgumentException ( lr_13 ) ;
}
}
public static boolean fn_15 ( final boolean ... array ) {
if ( array == null ) {
throw new IllegalArgumentException ( lr_11 ) ;
}
if ( array . length == 0 ) {
throw new IllegalArgumentException ( lr_12 ) ;
}
for ( final boolean vr_20 : array ) {
if ( vr_20 ) {
return true ;
}
}
return false ;
}
public static Boolean fn_15 ( final Boolean ... array ) {
if ( array == null ) {
throw new IllegalArgumentException ( lr_11 ) ;
}
if ( array . length == 0 ) {
throw new IllegalArgumentException ( lr_12 ) ;
}
try {
final boolean [] vr_21 = vr_22 . vr_23 ( array ) ;
return fn_15 ( vr_21 ) ? Boolean . TRUE : Boolean . FALSE ;
} catch ( final tp_1 vr_24 ) {
throw new IllegalArgumentException ( lr_13 ) ;
}
}
public static boolean fn_16 ( final boolean ... array ) {
if ( array == null ) {
throw new IllegalArgumentException ( lr_11 ) ;
}
if ( array . length == 0 ) {
throw new IllegalArgumentException ( lr_12 ) ;
}
boolean vr_25 = false ;
for ( final boolean vr_20 : array ) {
vr_25 ^= vr_20 ;
}
return vr_25 ;
}
public static Boolean fn_16 ( final Boolean ... array ) {
if ( array == null ) {
throw new IllegalArgumentException ( lr_11 ) ;
}
if ( array . length == 0 ) {
throw new IllegalArgumentException ( lr_12 ) ;
}
try {
final boolean [] vr_21 = vr_22 . vr_23 ( array ) ;
return fn_16 ( vr_21 ) ? Boolean . TRUE : Boolean . FALSE ;
} catch ( final tp_1 vr_24 ) {
throw new IllegalArgumentException ( lr_13 ) ;
}
}
public static int fn_17 ( boolean vr_26 , boolean vr_27 ) {
if ( vr_26 == vr_27 ) {
return 0 ;
}
if ( vr_26 ) {
return 1 ;
} else {
return - 1 ;
}
}

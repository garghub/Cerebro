public static String fn_1 ( final long vr_1 ) {
return fn_2 ( vr_1 , lr_1 ) ;
}
public static String fn_3 ( final long vr_1 ) {
return fn_2 ( vr_1 , vl_1 , false ) ;
}
public static String fn_2 ( final long vr_1 , final String vr_2 ) {
return fn_2 ( vr_1 , vr_2 , true ) ;
}
public static String fn_2 ( final long vr_1 , final String vr_2 , final boolean vr_3 ) {
vr_4 . vr_5 ( 0 , Long . vr_6 , vr_1 , lr_2 ) ;
final vr_7 [] vr_8 = fn_4 ( vr_2 ) ;
long vr_9 = 0 ;
long vr_10 = 0 ;
long vr_11 = 0 ;
long vr_12 = 0 ;
long vr_13 = vr_1 ;
if ( vr_7 . vr_14 ( vr_8 , vl_2 ) ) {
vr_9 = vr_13 / vr_15 . vr_16 ;
vr_13 = vr_13 - ( vr_9 * vr_15 . vr_16 ) ;
}
if ( vr_7 . vr_14 ( vr_8 , vl_3 ) ) {
vr_10 = vr_13 / vr_15 . vr_17 ;
vr_13 = vr_13 - ( vr_10 * vr_15 . vr_17 ) ;
}
if ( vr_7 . vr_14 ( vr_8 , vl_4 ) ) {
vr_11 = vr_13 / vr_15 . vr_18 ;
vr_13 = vr_13 - ( vr_11 * vr_15 . vr_18 ) ;
}
if ( vr_7 . vr_14 ( vr_8 , vl_5 ) ) {
vr_12 = vr_13 / vr_15 . vr_19 ;
vr_13 = vr_13 - ( vr_12 * vr_15 . vr_19 ) ;
}
return vr_2 ( vr_8 , 0 , 0 , vr_9 , vr_10 , vr_11 , vr_12 , vr_13 , vr_3 ) ;
}
public static String fn_5 (
final long vr_1 ,
final boolean vr_20 ,
final boolean vr_21 ) {
String vr_22 = fn_2 ( vr_1 , lr_3 ) ;
if ( vr_20 ) {
vr_22 = lr_4 + vr_22 ;
String vr_23 = vr_24 . vr_25 ( vr_22 , lr_5 , lr_6 ) ;
if ( vr_23 . length () != vr_22 . length () ) {
vr_22 = vr_23 ;
vr_23 = vr_24 . vr_25 ( vr_22 , lr_7 , lr_6 ) ;
if ( vr_23 . length () != vr_22 . length () ) {
vr_22 = vr_23 ;
vr_23 = vr_24 . vr_25 ( vr_22 , lr_8 , lr_6 ) ;
vr_22 = vr_23 ;
if ( vr_23 . length () != vr_22 . length () ) {
vr_22 = vr_24 . vr_25 ( vr_23 , lr_9 , lr_6 ) ;
}
}
}
if ( vr_22 . length () != 0 ) {
vr_22 = vr_22 . vr_26 ( 1 ) ;
}
}
if ( vr_21 ) {
String vr_23 = vr_24 . vr_25 ( vr_22 , lr_9 , lr_6 ) ;
if ( vr_23 . length () != vr_22 . length () ) {
vr_22 = vr_23 ;
vr_23 = vr_24 . vr_25 ( vr_22 , lr_8 , lr_6 ) ;
if ( vr_23 . length () != vr_22 . length () ) {
vr_22 = vr_23 ;
vr_23 = vr_24 . vr_25 ( vr_22 , lr_7 , lr_6 ) ;
if ( vr_23 . length () != vr_22 . length () ) {
vr_22 = vr_24 . vr_25 ( vr_23 , lr_5 , lr_6 ) ;
}
}
}
}
vr_22 = lr_4 + vr_22 ;
vr_22 = vr_24 . vr_25 ( vr_22 , lr_10 , lr_11 ) ;
vr_22 = vr_24 . vr_25 ( vr_22 , lr_12 , lr_13 ) ;
vr_22 = vr_24 . vr_25 ( vr_22 , lr_14 , lr_15 ) ;
vr_22 = vr_24 . vr_25 ( vr_22 , lr_16 , lr_17 ) ;
return vr_22 . trim () ;
}
public static String fn_6 ( final long vr_27 , final long vr_28 ) {
return fn_7 ( vr_27 , vr_28 , vl_1 , false , vr_29 . vr_30 () ) ;
}
public static String fn_7 ( final long vr_27 , final long vr_28 , final String vr_2 ) {
return fn_7 ( vr_27 , vr_28 , vr_2 , true , vr_29 . vr_30 () ) ;
}
public static String fn_7 ( final long vr_27 , final long vr_28 , final String vr_2 , final boolean vr_3 ,
final vr_29 vr_31 ) {
vr_4 . vr_32 ( vr_27 <= vr_28 , lr_18 ) ;
final vr_7 [] vr_8 = fn_4 ( vr_2 ) ;
final tp_1 vr_33 = tp_1 . vr_34 ( vr_31 ) ;
vr_33 . vr_35 ( new fn_8 ( vr_27 ) ) ;
final tp_1 vr_36 = tp_1 . vr_34 ( vr_31 ) ;
vr_36 . vr_35 ( new fn_8 ( vr_28 ) ) ;
int vr_13 = vr_36 . get ( tp_1 . vr_37 ) - vr_33 . get ( tp_1 . vr_37 ) ;
int vr_12 = vr_36 . get ( tp_1 . vr_38 ) - vr_33 . get ( tp_1 . vr_38 ) ;
int vr_11 = vr_36 . get ( tp_1 . vr_39 ) - vr_33 . get ( tp_1 . vr_39 ) ;
int vr_10 = vr_36 . get ( tp_1 . vr_40 ) - vr_33 . get ( tp_1 . vr_40 ) ;
int vr_9 = vr_36 . get ( tp_1 . vr_41 ) - vr_33 . get ( tp_1 . vr_41 ) ;
int vr_42 = vr_36 . get ( tp_1 . vr_43 ) - vr_33 . get ( tp_1 . vr_43 ) ;
int vr_44 = vr_36 . get ( tp_1 . vr_45 ) - vr_33 . get ( tp_1 . vr_45 ) ;
while ( vr_13 < 0 ) {
vr_13 += 1000 ;
vr_12 -= 1 ;
}
while ( vr_12 < 0 ) {
vr_12 += 60 ;
vr_11 -= 1 ;
}
while ( vr_11 < 0 ) {
vr_11 += 60 ;
vr_10 -= 1 ;
}
while ( vr_10 < 0 ) {
vr_10 += 24 ;
vr_9 -= 1 ;
}
if ( vr_7 . vr_14 ( vr_8 , vl_6 ) ) {
while ( vr_9 < 0 ) {
vr_9 += vr_33 . vr_46 ( tp_1 . vr_41 ) ;
vr_42 -= 1 ;
vr_33 . add ( tp_1 . vr_43 , 1 ) ;
}
while ( vr_42 < 0 ) {
vr_42 += 12 ;
vr_44 -= 1 ;
}
if ( ! vr_7 . vr_14 ( vr_8 , vl_7 ) && vr_44 != 0 ) {
while ( vr_44 != 0 ) {
vr_42 += 12 * vr_44 ;
vr_44 = 0 ;
}
}
} else {
if( ! vr_7 . vr_14 ( vr_8 , vl_7 ) ) {
int vr_47 = vr_36 . get ( tp_1 . vr_45 ) ;
if ( vr_42 < 0 ) {
vr_47 -= 1 ;
}
while ( vr_33 . get ( tp_1 . vr_45 ) != vr_47 ) {
vr_9 += vr_33 . vr_46 ( tp_1 . vr_48 ) - vr_33 . get ( tp_1 . vr_48 ) ;
if ( vr_33 instanceof vl_8 &&
vr_33 . get ( tp_1 . vr_43 ) == tp_1 . vr_49 &&
vr_33 . get ( tp_1 . vr_41 ) == 29 ) {
vr_9 += 1 ;
}
vr_33 . add ( tp_1 . vr_45 , 1 ) ;
vr_9 += vr_33 . get ( tp_1 . vr_48 ) ;
}
vr_44 = 0 ;
}
while( vr_33 . get ( tp_1 . vr_43 ) != vr_36 . get ( tp_1 . vr_43 ) ) {
vr_9 += vr_33 . vr_46 ( tp_1 . vr_41 ) ;
vr_33 . add ( tp_1 . vr_43 , 1 ) ;
}
vr_42 = 0 ;
while ( vr_9 < 0 ) {
vr_9 += vr_33 . vr_46 ( tp_1 . vr_41 ) ;
vr_42 -= 1 ;
vr_33 . add ( tp_1 . vr_43 , 1 ) ;
}
}
if ( ! vr_7 . vr_14 ( vr_8 , vl_2 ) ) {
vr_10 += 24 * vr_9 ;
vr_9 = 0 ;
}
if ( ! vr_7 . vr_14 ( vr_8 , vl_3 ) ) {
vr_11 += 60 * vr_10 ;
vr_10 = 0 ;
}
if ( ! vr_7 . vr_14 ( vr_8 , vl_4 ) ) {
vr_12 += 60 * vr_11 ;
vr_11 = 0 ;
}
if ( ! vr_7 . vr_14 ( vr_8 , vl_5 ) ) {
vr_13 += 1000 * vr_12 ;
vr_12 = 0 ;
}
return vr_2 ( vr_8 , vr_44 , vr_42 , vr_9 , vr_10 , vr_11 , vr_12 , vr_13 , vr_3 ) ;
}
static String vr_2 ( final vr_7 [] vr_8 , final long vr_44 , final long vr_42 , final long vr_9 , final long vr_10 , final long vr_11 , final long vr_12 ,
final long vr_13 , final boolean vr_3 ) {
final StringBuilder vr_50 = new StringBuilder () ;
boolean vr_51 = false ;
for ( final vr_7 vr_52 : vr_8 ) {
final Object vr_53 = vr_52 . vr_54 () ;
final int vr_55 = vr_52 . vr_56 () ;
if ( vr_53 instanceof StringBuilder ) {
vr_50 . append ( vr_53 . toString () ) ;
} else {
if ( vr_53 . equals ( vl_7 ) ) {
vr_50 . append ( fn_9 ( vr_44 , vr_3 , vr_55 ) ) ;
vr_51 = false ;
} else if ( vr_53 . equals ( vl_6 ) ) {
vr_50 . append ( fn_9 ( vr_42 , vr_3 , vr_55 ) ) ;
vr_51 = false ;
} else if ( vr_53 . equals ( vl_2 ) ) {
vr_50 . append ( fn_9 ( vr_9 , vr_3 , vr_55 ) ) ;
vr_51 = false ;
} else if ( vr_53 . equals ( vl_3 ) ) {
vr_50 . append ( fn_9 ( vr_10 , vr_3 , vr_55 ) ) ;
vr_51 = false ;
} else if ( vr_53 . equals ( vl_4 ) ) {
vr_50 . append ( fn_9 ( vr_11 , vr_3 , vr_55 ) ) ;
vr_51 = false ;
} else if ( vr_53 . equals ( vl_5 ) ) {
vr_50 . append ( fn_9 ( vr_12 , vr_3 , vr_55 ) ) ;
vr_51 = true ;
} else if ( vr_53 . equals ( vl_9 ) ) {
if ( vr_51 ) {
final int vr_57 = vr_3 ? vr_58 . vr_59 ( 3 , vr_55 ) : 3 ;
vr_50 . append ( fn_9 ( vr_13 , true , vr_57 ) ) ;
} else {
vr_50 . append ( fn_9 ( vr_13 , vr_3 , vr_55 ) ) ;
}
vr_51 = false ;
}
}
}
return vr_50 . toString () ;
}
private static String fn_9 ( final long vr_53 , final boolean vr_3 , final int vr_55 ) {
final String vr_60 = Long . toString ( vr_53 ) ;
return vr_3 ? vr_24 . vr_61 ( vr_60 , vr_55 , '0' ) : vr_60 ;
}
static vr_7 [] fn_4 ( final String vr_2 ) {
final ArrayList < vr_7 > list = new ArrayList < vr_7 > ( vr_2 . length () ) ;
boolean vr_62 = false ;
StringBuilder vr_50 = null ;
vr_7 vr_63 = null ;
for ( int vr_64 = 0 ; vr_64 < vr_2 . length () ; vr_64 ++ ) {
final char vr_65 = vr_2 . charAt ( vr_64 ) ;
if ( vr_62 && vr_65 != '\'' ) {
vr_50 . append ( vr_65 ) ;
continue;
}
Object vr_53 = null ;
switch ( vr_65 ) {
case '\'' :
if ( vr_62 ) {
vr_50 = null ;
vr_62 = false ;
} else {
vr_50 = new StringBuilder () ;
list . add ( new vr_7 ( vr_50 ) ) ;
vr_62 = true ;
}
break;
case 'y' :
vr_53 = vl_7 ;
break;
case 'M' :
vr_53 = vl_6 ;
break;
case 'd' :
vr_53 = vl_2 ;
break;
case 'H' :
vr_53 = vl_3 ;
break;
case 'm' :
vr_53 = vl_4 ;
break;
case 's' :
vr_53 = vl_5 ;
break;
case 'S' :
vr_53 = vl_9 ;
break;
default:
if ( vr_50 == null ) {
vr_50 = new StringBuilder () ;
list . add ( new vr_7 ( vr_50 ) ) ;
}
vr_50 . append ( vr_65 ) ;
}
if ( vr_53 != null ) {
if ( vr_63 != null && vr_63 . vr_54 () . equals ( vr_53 ) ) {
vr_63 . vr_66 () ;
} else {
final vr_7 vr_52 = new vr_7 ( vr_53 ) ;
list . add ( vr_52 ) ;
vr_63 = vr_52 ;
}
vr_50 = null ;
}
}
if ( vr_62 ) {
throw new IllegalArgumentException ( lr_19 + vr_2 ) ;
}
return list . toArray ( new vr_7 [ list . size () ] ) ;
}
static boolean vr_14 ( final vr_7 [] vr_8 , final Object vr_53 ) {
for ( final vr_7 vr_52 : vr_8 ) {
if ( vr_52 . vr_54 () == vr_53 ) {
return true ;
}
}
return false ;
}
void vr_66 () {
vr_55 ++ ;
}
int vr_56 () {
return vr_55 ;
}
Object vr_54 () {
return vr_53 ;
}
@Override
public boolean equals ( final Object vr_67 ) {
if ( vr_67 instanceof vr_7 ) {
final vr_7 vr_68 = ( vr_7 ) vr_67 ;
if ( this . vr_53 . getClass () != vr_68 . vr_53 . getClass () ) {
return false ;
}
if ( this . vr_55 != vr_68 . vr_55 ) {
return false ;
}
if ( this . vr_53 instanceof StringBuilder ) {
return this . vr_53 . toString () . equals ( vr_68 . vr_53 . toString () ) ;
} else if ( this . vr_53 instanceof vl_10 ) {
return this . vr_53 . equals ( vr_68 . vr_53 ) ;
} else {
return this . vr_53 == vr_68 . vr_53 ;
}
}
return false ;
}
@Override
public int fn_10 () {
return this . vr_53 . fn_10 () ;
}
@Override
public String toString () {
return vr_24 . vr_69 ( this . vr_53 . toString () , this . vr_55 ) ;
}

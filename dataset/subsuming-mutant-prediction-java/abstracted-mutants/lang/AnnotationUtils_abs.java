@Override
protected String fn_1 ( final vr_1 . vr_2 . Class < ? > vr_3 ) {
Class < ? extends tp_1 > vr_4 = null ;
for ( final Class < ? > vr_5 : vr_6 . vr_7 ( vr_3 ) ) {
if ( tp_1 . class . vr_8 ( vr_5 ) ) {
@SuppressWarnings ( lr_1 )
final
Class < ? extends tp_1 > vr_9 = ( Class < ? extends tp_1 > ) vr_5 ;
vr_4 = vr_9 ;
break;
}
}
return new StringBuilder ( vr_4 == null ? lr_2 : vr_4 . vr_10 () )
. fn_2 ( 0 , '@' ) . toString () ;
}
@Override
protected void fn_3 ( final tp_2 vr_11 , final String vr_12 , Object vr_13 ) {
if ( vr_13 instanceof tp_1 ) {
vr_13 = vr_14 . toString ( ( tp_1 ) vr_13 ) ;
}
super . fn_3 ( vr_11 , vr_12 , vr_13 ) ;
}
public static boolean equals ( final tp_1 vr_15 , final tp_1 vr_16 ) {
if ( vr_15 == vr_16 ) {
return true ;
}
if ( vr_15 == null || vr_16 == null ) {
return false ;
}
final Class < ? extends tp_1 > type = vr_15 . vr_4 () ;
final Class < ? extends tp_1 > vr_17 = vr_16 . vr_4 () ;
vr_18 . vr_19 ( type , lr_3 , vr_15 ) ;
vr_18 . vr_19 ( vr_17 , lr_3 , vr_16 ) ;
if ( ! type . equals ( vr_17 ) ) {
return false ;
}
try {
for ( final tp_3 vr_20 : type . vr_21 () ) {
if ( vr_20 . vr_22 () . length == 0
&& fn_4 ( vr_20 . vr_23 () ) ) {
final Object vr_24 = vr_20 . vr_25 ( vr_15 ) ;
final Object vr_26 = vr_20 . vr_25 ( vr_16 ) ;
if ( ! fn_5 ( vr_20 . vr_23 () , vr_24 , vr_26 ) ) {
return false ;
}
}
}
} catch ( final tp_4 vr_27 ) {
return false ;
} catch ( final tp_5 vr_27 ) {
return false ;
}
return true ;
}
public static int fn_6 ( final tp_1 vr_28 ) {
int vr_29 = 0 ;
final Class < ? extends tp_1 > type = vr_28 . vr_4 () ;
for ( final tp_3 vr_20 : type . vr_21 () ) {
try {
final Object vr_13 = vr_20 . vr_25 ( vr_28 ) ;
if ( vr_13 == null ) {
throw new fn_7 (
String . vr_30 ( lr_4 , vr_20 ) ) ;
}
vr_29 += fn_8 ( vr_20 . vr_10 () , vr_13 ) ;
} catch ( final tp_6 vr_27 ) {
throw vr_27 ;
} catch ( final Exception vr_27 ) {
throw new tp_6 ( vr_27 ) ;
}
}
return vr_29 ;
}
public static String toString ( final tp_1 vr_28 ) {
final tp_7 builder = new tp_7 ( vr_28 , vl_1 ) ;
for ( final tp_3 vr_20 : vr_28 . vr_4 () . vr_21 () ) {
if ( vr_20 . vr_22 () . length > 0 ) {
continue;
}
try {
builder . append ( vr_20 . vr_10 () , vr_20 . vr_25 ( vr_28 ) ) ;
} catch ( final tp_6 vr_27 ) {
throw vr_27 ;
} catch ( final Exception vr_27 ) {
throw new tp_6 ( vr_27 ) ;
}
}
return builder . vr_31 () ;
}
public static boolean fn_4 ( Class < ? > type ) {
if ( type == null ) {
return false ;
}
if ( type . vr_32 () ) {
type = type . vr_33 () ;
}
return type . vr_34 () || type . vr_35 () || type . vr_36 ()
|| String . class . equals ( type ) || Class . class . equals ( type ) ;
}
private static int fn_8 ( final String vr_37 , final Object vr_13 ) {
final int vr_38 = vr_37 . fn_6 () * 127 ;
if ( vr_13 . getClass () . vr_32 () ) {
return vr_38 ^ fn_9 ( vr_13 . getClass () . vr_33 () , vr_13 ) ;
}
if ( vr_13 instanceof tp_1 ) {
return vr_38 ^ fn_6 ( ( tp_1 ) vr_13 ) ;
}
return vr_38 ^ vr_13 . fn_6 () ;
}
private static boolean fn_5 ( final Class < ? > type , final Object vr_39 , final Object vr_40 ) {
if ( vr_39 == vr_40 ) {
return true ;
}
if ( vr_39 == null || vr_40 == null ) {
return false ;
}
if ( type . vr_32 () ) {
return fn_10 ( type . vr_33 () , vr_39 , vr_40 ) ;
}
if ( type . vr_36 () ) {
return equals ( ( tp_1 ) vr_39 , ( tp_1 ) vr_40 ) ;
}
return vr_39 . equals ( vr_40 ) ;
}
private static boolean fn_10 ( final Class < ? > vr_41 , final Object vr_39 , final Object vr_40 ) {
if ( vr_41 . vr_36 () ) {
return fn_11 ( ( tp_1 [] ) vr_39 , ( tp_1 [] ) vr_40 ) ;
}
if ( vr_41 . equals ( Byte . TYPE ) ) {
return vr_42 . equals ( ( byte [] ) vr_39 , ( byte [] ) vr_40 ) ;
}
if ( vr_41 . equals ( Short . TYPE ) ) {
return vr_42 . equals ( ( short [] ) vr_39 , ( short [] ) vr_40 ) ;
}
if ( vr_41 . equals ( Integer . TYPE ) ) {
return vr_42 . equals ( ( int [] ) vr_39 , ( int [] ) vr_40 ) ;
}
if ( vr_41 . equals ( vr_43 . TYPE ) ) {
return vr_42 . equals ( ( char [] ) vr_39 , ( char [] ) vr_40 ) ;
}
if ( vr_41 . equals ( Long . TYPE ) ) {
return vr_42 . equals ( ( long [] ) vr_39 , ( long [] ) vr_40 ) ;
}
if ( vr_41 . equals ( Float . TYPE ) ) {
return vr_42 . equals ( ( float [] ) vr_39 , ( float [] ) vr_40 ) ;
}
if ( vr_41 . equals ( Double . TYPE ) ) {
return vr_42 . equals ( ( double [] ) vr_39 , ( double [] ) vr_40 ) ;
}
if ( vr_41 . equals ( Boolean . TYPE ) ) {
return vr_42 . equals ( ( boolean [] ) vr_39 , ( boolean [] ) vr_40 ) ;
}
return vr_42 . equals ( ( Object [] ) vr_39 , ( Object [] ) vr_40 ) ;
}
private static boolean fn_11 ( final tp_1 [] vr_15 , final tp_1 [] vr_16 ) {
if ( vr_15 . length != vr_16 . length ) {
return false ;
}
for ( int vr_44 = 0 ; vr_44 < vr_15 . length ; vr_44 ++ ) {
if ( ! equals ( vr_15 [ vr_44 ] , vr_16 [ vr_44 ] ) ) {
return false ;
}
}
return true ;
}
private static int fn_9 ( final Class < ? > vr_41 , final Object vr_45 ) {
if ( vr_41 . equals ( Byte . TYPE ) ) {
return vr_42 . fn_6 ( ( byte [] ) vr_45 ) ;
}
if ( vr_41 . equals ( Short . TYPE ) ) {
return vr_42 . fn_6 ( ( short [] ) vr_45 ) ;
}
if ( vr_41 . equals ( Integer . TYPE ) ) {
return vr_42 . fn_6 ( ( int [] ) vr_45 ) ;
}
if ( vr_41 . equals ( vr_43 . TYPE ) ) {
return vr_42 . fn_6 ( ( char [] ) vr_45 ) ;
}
if ( vr_41 . equals ( Long . TYPE ) ) {
return vr_42 . fn_6 ( ( long [] ) vr_45 ) ;
}
if ( vr_41 . equals ( Float . TYPE ) ) {
return vr_42 . fn_6 ( ( float [] ) vr_45 ) ;
}
if ( vr_41 . equals ( Double . TYPE ) ) {
return vr_42 . fn_6 ( ( double [] ) vr_45 ) ;
}
if ( vr_41 . equals ( Boolean . TYPE ) ) {
return vr_42 . fn_6 ( ( boolean [] ) vr_45 ) ;
}
return vr_42 . fn_6 ( ( Object [] ) vr_45 ) ;
}

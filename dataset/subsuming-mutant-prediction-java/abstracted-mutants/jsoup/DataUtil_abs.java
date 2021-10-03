public static tp_1 fn_1 ( tp_2 vr_1 , String vr_2 , String vr_3 ) throws IOException {
return fn_2 ( new fn_3 ( vr_1 ) , vr_2 , vr_3 , vr_4 . vr_5 () ) ;
}
public static tp_1 fn_1 ( tp_3 vr_1 , String vr_2 , String vr_3 ) throws IOException {
return fn_2 ( vr_1 , vr_2 , vr_3 , vr_4 . vr_5 () ) ;
}
public static tp_1 fn_1 ( tp_3 vr_1 , String vr_2 , String vr_3 , vr_4 vr_6 ) throws IOException {
return fn_2 ( vr_1 , vr_2 , vr_3 , vr_6 ) ;
}
static void fn_4 ( final tp_3 vr_1 , final tp_4 out ) throws IOException {
final byte [] vr_7 = new byte [ vl_1 ] ;
int vr_8 ;
while ( ( vr_8 = vr_1 . vr_9 ( vr_7 ) ) != - 1 ) {
out . vr_10 ( vr_7 , 0 , vr_8 ) ;
}
}
static tp_1 fn_2 ( tp_3 vr_11 , String vr_2 , String vr_3 , vr_4 vr_6 ) throws IOException {
if ( vr_11 == null )
return new tp_1 ( vr_3 ) ;
vr_11 = vr_12 . vr_13 ( vr_11 , vl_1 , 0 ) ;
tp_1 vr_14 = null ;
vr_11 . vr_15 ( vl_1 ) ;
tp_5 vr_16 = fn_5 ( vr_11 , vl_2 - 1 ) ;
boolean vr_17 = ( vr_11 . vr_9 () == - 1 ) ;
vr_11 . vr_18 () ;
tp_6 vr_19 = fn_6 ( vr_16 ) ;
if ( vr_19 != null )
vr_2 = vr_19 . vr_20 ;
if ( vr_2 == null ) {
String vr_21 = vr_22 . vr_23 ( vl_3 ) . fn_7 ( vr_16 ) . toString () ;
try {
vr_14 = vr_6 . vr_24 ( vr_21 , vr_3 ) ;
} catch ( tp_7 vr_25 ) {
throw vr_25 . ioException () ;
}
tp_8 vr_26 = vr_14 . vr_27 ( lr_1 ) ;
String vr_28 = null ;
for ( tp_9 vr_29 : vr_26 ) {
if ( vr_29 . vr_30 ( lr_2 ) )
vr_28 = fn_8 ( vr_29 . vr_31 ( lr_3 ) ) ;
if ( vr_28 == null && vr_29 . vr_30 ( lr_4 ) )
vr_28 = vr_29 . vr_31 ( lr_4 ) ;
if ( vr_28 != null )
break;
}
if ( vr_28 == null && vr_14 . vr_32 () > 0 ) {
tp_10 vr_33 = vr_14 . vr_34 ( 0 ) ;
tp_11 vr_35 = null ;
if ( vr_33 instanceof tp_11 )
vr_35 = ( tp_11 ) vr_33 ;
else if ( vr_33 instanceof vl_4 ) {
vl_4 vr_36 = ( vl_4 ) vr_33 ;
if ( vr_36 . vr_37 () )
vr_35 = vr_36 . vr_38 () ;
}
if ( vr_35 != null ) {
if ( vr_35 . vr_39 () . equalsIgnoreCase ( lr_5 ) )
vr_28 = vr_35 . vr_31 ( lr_6 ) ;
}
}
vr_28 = fn_9 ( vr_28 ) ;
if ( vr_28 != null && ! vr_28 . equalsIgnoreCase ( vl_3 ) ) {
vr_28 = vr_28 . trim () . fn_10 ( lr_7 , lr_8 ) ;
vr_2 = vr_28 ;
vr_14 = null ;
} else if ( ! vr_17 ) {
vr_14 = null ;
}
} else {
vr_40 . vr_41 ( vr_2 , lr_9 ) ;
}
if ( vr_14 == null ) {
if ( vr_2 == null )
vr_2 = vl_3 ;
BufferedReader vr_42 = new BufferedReader ( new fn_11 ( vr_11 , vr_2 ) , vl_1 ) ;
if ( vr_19 != null && vr_19 . vr_43 ) {
long vr_44 = vr_42 . vr_45 ( 1 ) ;
vr_40 . vr_46 ( vr_44 == 1 ) ;
}
try {
vr_14 = vr_6 . vr_24 ( vr_42 , vr_3 ) ;
} catch ( tp_7 vr_25 ) {
throw vr_25 . ioException () ;
}
vr_22 vr_20 = vr_22 . vr_23 ( vr_2 ) ;
vr_14 . vr_47 () . vr_20 ( vr_20 ) ;
if ( ! vr_20 . vr_48 () ) {
vr_14 . vr_20 ( vr_22 . vr_23 ( vl_3 ) ) ;
}
}
vr_11 . vr_49 () ;
return vr_14 ;
}
public static tp_5 fn_5 ( tp_3 vr_50 , int vr_51 ) throws IOException {
vr_40 . vr_46 ( vr_51 >= 0 , lr_10 ) ;
final vr_12 vr_11 = vr_12 . vr_13 ( vr_50 , vl_1 , vr_51 ) ;
return vr_11 . fn_5 ( vr_51 ) ;
}
static tp_5 fn_12 () {
return tp_5 . vr_52 ( 0 ) ;
}
static String fn_8 ( String vr_53 ) {
if ( vr_53 == null ) return null ;
tp_12 vr_54 = vr_55 . vr_56 ( vr_53 ) ;
if ( vr_54 . vr_57 () ) {
String vr_20 = vr_54 . vr_58 ( 1 ) . trim () ;
vr_20 = vr_20 . vr_59 ( lr_11 , lr_8 ) ;
return fn_9 ( vr_20 ) ;
}
return null ;
}
private static String fn_9 ( String vr_60 ) {
if ( vr_60 == null || vr_60 . length () == 0 ) return null ;
vr_60 = vr_60 . trim () . fn_10 ( lr_7 , lr_8 ) ;
try {
if ( vr_22 . vr_61 ( vr_60 ) ) return vr_60 ;
vr_60 = vr_60 . vr_62 ( vr_63 . vr_64 ) ;
if ( vr_22 . vr_61 ( vr_60 ) ) return vr_60 ;
} catch ( tp_13 vr_25 ) {
}
return null ;
}
static String fn_13 () {
final StringBuilder vr_65 = vr_66 . vr_67 () ;
final tp_14 rand = new tp_14 () ;
for ( int vr_68 = 0 ; vr_68 < vl_5 ; vr_68 ++ ) {
vr_65 . append ( vr_69 [ rand . vr_70 ( vr_69 . length ) ] ) ;
}
return vr_66 . vr_71 ( vr_65 ) ;
}
private static tp_6 fn_6 ( final tp_5 vr_72 ) {
final tp_15 vr_7 = vr_72 ;
vr_7 . vr_15 () ;
byte [] vr_73 = new byte [ 4 ] ;
if ( vr_72 . vr_74 () >= vr_73 . length ) {
vr_72 . get ( vr_73 ) ;
vr_7 . rewind () ;
}
if ( vr_73 [ 0 ] == 0x00 && vr_73 [ 1 ] == 0x00 && vr_73 [ 2 ] == ( byte ) 0xFE && vr_73 [ 3 ] == ( byte ) 0xFF ||
vr_73 [ 0 ] == ( byte ) 0xFF && vr_73 [ 1 ] == ( byte ) 0xFE && vr_73 [ 2 ] == 0x00 && vr_73 [ 3 ] == 0x00 ) {
return new tp_6 ( lr_12 , false ) ;
} else if ( vr_73 [ 0 ] == ( byte ) 0xFE && vr_73 [ 1 ] == ( byte ) 0xFF ||
vr_73 [ 0 ] == ( byte ) 0xFF && vr_73 [ 1 ] == ( byte ) 0xFE ) {
return new tp_6 ( lr_13 , false ) ;
} else if ( vr_73 [ 0 ] == ( byte ) 0xEF && vr_73 [ 1 ] == ( byte ) 0xBB && vr_73 [ 2 ] == ( byte ) 0xBF ) {
return new tp_6 ( lr_14 , true ) ;
}
return null ;
}

public static void main ( final String [] args ) throws vl_1 {
final Properties vr_1 = new Properties () ;
final tp_1 vr_2 = Main . class . vr_3 ( lr_1 ) ;
if ( vr_2 != null ) {
vr_1 . vr_4 ( vr_2 ) ;
} else {
System . vr_5 . println ( lr_2 ) ;
}
if ( args . length == 0 ) {
if ( vr_6 . vr_7 () . fn_1 () . length > 2 ) {
System . out . println ( lr_3 +
lr_4 ) ;
System . out . println ( lr_5 +
lr_6 ) ;
} else {
if ( fn_2 () ) {
System . out . println (
lr_7 ) ;
} else {
System . out . println (
lr_8 ) ; MST[rv.ROR4Mutator]MSP[]
}
}
@SuppressWarnings ( lr_9 )
final
List < String > vr_8 = ( List < String > ) vr_9 . list ( vr_1 . propertyNames () ) ;
if ( vr_8 . isEmpty () ) {
return;
}
vr_9 . vr_10 ( vr_8 ) ;
System . out . println ( lr_10 ) ;
for( final String vr_11 : vr_8 ) {
System . out . printf ( lr_11 , vr_11 , vr_1 . getProperty ( vr_11 ) ) ;
}
return;
}
final String vr_12 = args [ 0 ] ;
String vr_13 = vr_1 . getProperty ( vr_12 ) ;
if ( vr_13 == null ) {
vr_13 = vr_12 ;
}
vr_13 = vr_13 . vr_14 ( '/' , '.' ) ;
try {
final Class < ? > vr_15 = Class . vr_16 ( vr_13 ) ;
final tp_2 vr_17 = vr_15 . vr_18 ( lr_12 , args . getClass () ) ;
final String [] vr_19 = new String [ args . length - 1 ] ;
System . vr_20 ( args , 1 , vr_19 , 0 , vr_19 . length ) ;
try {
vr_17 . vr_21 ( null , ( Object ) vr_19 ) ;
} catch ( final tp_3 vr_22 ) {
final vl_1 vr_23 = vr_22 . vr_24 () ;
if ( vr_23 != null ) {
throw vr_23 ;
}
throw vr_22 ;
}
} catch ( final tp_4 vr_25 ) {
System . out . println ( vr_25 ) ;
}
}
private static boolean fn_2 () {
final tp_5 vr_26 = Main . class . vr_27 () . fn_3 () ;
if ( vr_26 != null ) {
return vr_26 . vr_28 () . fn_4 () . fn_5 ( lr_13 ) ;
}
return false ;
}

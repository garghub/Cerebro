@df_1
public void fn_1 () throws Exception {
final Properties vr_1 = fn_2 () ;
final Properties vr_2 = new Properties () ;
try ( final tp_1 vr_3 = this . getClass () . fn_3 ( lr_1 ) ) {
vr_2 . vr_4 ( vr_3 ) ;
}
@SuppressWarnings ( lr_2 )
final Enumeration < String > propertyNames = ( Enumeration < String > ) vr_1 . propertyNames () ;
while( propertyNames . vr_5 () ) {
final String vr_6 = propertyNames . nextElement () ;
final String vr_7 = vr_2 . getProperty ( vr_6 ) ;
final String vr_8 = vr_1 . getProperty ( vr_6 ) ;
if ( vr_7 == null ) {
System . out . printf ( lr_3 , vr_6 , vr_8 ) ;
} else if ( ! vr_7 . equals ( vr_8 ) ) {
System . out . printf ( lr_4 , vr_6 , vr_7 , vr_8 ) ;
}
}
}
private Properties fn_2 () throws IOException {
final tp_2 vr_9 = Main . class . vr_10 () . fn_4 () ;
final String vr_11 = vr_12 . vr_13 ( vr_9 . vr_14 () . fn_5 () , lr_5 ) ;
final Properties vr_15 = new Properties () ;
if ( vr_11 . vr_16 ( lr_6 ) ) {
try ( final tp_3 vr_17 = new tp_3 ( vr_11 ) ) {
final Enumeration < vt_1 > vr_18 = vr_17 . vr_19 () ;
while ( vr_18 . vr_5 () ) {
final vt_1 vr_20 = vr_18 . nextElement () ;
final String vr_21 = vr_20 . vr_22 () ;
fn_6 ( vr_21 , vr_15 ) ;
}
}
} else {
final tp_4 vr_23 = new tp_4 ( vr_11 , lr_7 ) ;
if ( vr_23 . vr_24 () ) {
fn_7 ( vr_11 . length () , vr_23 , vr_15 ) ;
} else {
fn_8 ( lr_8 + vr_23 . vr_25 () ) ;
}
}
return vr_15 ;
}
private static void fn_7 ( final int vr_26 , final tp_4 vr_27 , final Properties vr_15 ) {
for( final tp_4 vr_28 : vr_27 . vr_29 () ) {
if ( vr_28 . vr_30 () ) {
fn_7 ( vr_26 , vr_28 , vr_15 ) ;
} else {
fn_6 ( vr_28 . vr_31 () . fn_9 ( vr_26 ) , vr_15 ) ;
}
}
}
private static void fn_6 ( String vr_21 , final Properties vr_15 ) {
if ( ! vr_21 . vr_16 ( lr_9 )
|| vr_21 . contains ( lr_10 )
|| vr_21 . vr_16 ( lr_11 )
|| ! fn_10 ( vr_21 )
) {
return;
}
vr_21 = vr_21 . vr_32 ( lr_9 , lr_12 ) ;
final int vr_33 = vr_21 . vr_34 ( '/' ) ;
final String vr_35 = vr_21 . fn_9 ( vr_33 + 1 ) ;
if ( vr_15 . vr_36 ( vr_35 ) ) {
System . out . printf ( lr_13 , vr_35 , vr_21 , vr_15 . getProperty ( vr_35 ) ) ;
} else {
vr_15 . vr_37 ( vr_35 , vr_21 ) ;
}
}
private static boolean fn_10 ( String vr_21 ) {
vr_21 = vr_21 . vr_32 ( lr_9 , lr_12 ) ;
vr_21 = vr_21 . vr_32 ( lr_14 , lr_15 ) ;
try {
final Class < ? > vr_38 = Class . vr_39 ( vr_21 , false , vr_40 . class . vr_41 () ) ;
vr_38 . vr_42 ( lr_16 , String [] .class ) ;
return true ;
} catch ( final tp_5 vr_18 ) {
System . out . println ( lr_17 + vr_21 ) ;
return false ;
} catch ( final tp_6 vr_18 ) {
return false ;
} catch ( final tp_7 vr_18 ) {
vr_18 . vr_43 () ;
}
return true ;
}

public static void main ( final String [] args ) throws IOException
{
if ( args . length < 2 )
{
System . vr_1 . println ( lr_1 ) ;
System . vr_1 . println ( lr_2 +
lr_3 ) ;
System . exit ( 1 ) ;
}
final tp_1 vr_2 = tp_1 . vr_3 ( args [ 0 ] ) ;
final String vr_4 = args [ 1 ] ;
final tp_2 vr_5 = new tp_2 ( vr_4 ) ; MST[rv.ROR2Mutator]MSP[]
if ( ! vr_5 . vr_6 () || ! vr_5 . vr_7 () ) {
throw new IOException ( lr_4 + vr_5 ) ;
}
final String vr_8 = vr_2 . vr_9 () ;
if ( vr_8 == null || vr_8 . length () < 1 ) {
throw new IllegalArgumentException ( lr_5 + vr_8 + lr_6 ) ;
}
final String vr_10 = vr_8 . vr_11 ( 1 ) ;
final List < String > contains = new ArrayList <> () ;
final tp_3 vr_12 = new tp_3 () ;
for( int vr_13 = 2 ; vr_13 < args . length ; vr_13 ++ ) {
final String vr_14 = args [ vr_13 ] ;
if ( vr_14 . vr_15 ( lr_7 ) ) {
for( final String vr_16 : vr_14 . vr_17 ( lr_8 ) ) {
final String [] vr_18 = vr_16 . vr_17 ( lr_9 ) ;
if ( vr_18 . length == 2 ) {
final int vr_19 = Integer . vr_20 ( vr_18 [ 0 ] ) ;
final int vr_21 = Integer . vr_20 ( vr_18 [ 1 ] ) ;
for( int vr_22 = vr_19 ; vr_22 <= vr_21 ; vr_22 ++ ) {
vr_12 . vr_23 ( vr_22 ) ;
}
} else {
vr_12 . vr_23 ( Integer . vr_20 ( vr_16 ) ) ;
}
}
} else {
contains . add ( vr_14 ) ;
}
}
final tp_4 vr_24 = vr_25 . vr_26 ( vr_2 , 10000 , null ) ;
int vr_27 = 0 ;
int vr_28 = 0 ;
try {
vr_24 . vr_29 ( 6000 ) ;
final BufferedReader vr_30 = new BufferedReader ( new fn_1 ( vr_4 ) ) ;
String line ;
final StringBuilder vr_31 = new StringBuilder () ;
boolean vr_32 = false ;
while( ( line = vr_30 . readLine () ) != null ) {
if ( line . vr_33 ( lr_10 ) ) {
if ( fn_2 ( vr_31 , vr_24 , vr_10 , vr_27 ) ) {
vr_28 ++ ;
}
vr_31 . vr_34 ( 0 ) ;
vr_27 ++ ;
vr_32 = vr_32 ( vr_27 , line , vr_12 , contains ) ;
} else if ( vr_33 ( line , vl_1 ) ) {
line = line . vr_11 ( 1 ) ;
}
if ( vr_32 ) {
vr_31 . append ( line ) ;
vr_31 . append ( vl_2 ) ;
}
}
vr_30 . vr_35 () ;
if ( vr_32 && fn_2 ( vr_31 , vr_24 , vr_10 , vr_27 ) ) {
vr_28 ++ ;
}
} catch ( final IOException vr_36 ) {
System . out . println ( lr_11 + vr_27 + lr_12 + vr_24 . vr_37 () ) ;
vr_36 . vr_38 () ;
System . exit ( 10 ) ;
return;
} finally {
vr_24 . vr_39 () ;
vr_24 . vr_40 () ;
}
System . out . println ( lr_13 + vr_27 + lr_14 + vr_28 ) ;
}
private static boolean vr_33 ( final String vr_41 , final tp_5 vr_42 ) {
final tp_6 vr_43 = vr_42 . vr_44 ( vr_41 ) ;
return vr_43 . vr_45 () ;
}
private static String fn_3 ( final String vr_46 ) {
final tp_5 vr_47 = tp_5 . vr_48 ( lr_15 ) ;
String vr_49 = null ;
final tp_6 vr_43 = vr_47 . vr_44 ( vr_46 ) ;
if ( vr_43 . vr_45 () ) {
vr_49 = vr_43 . vr_50 ( 2 ) + lr_9 + vr_43 . vr_50 ( 1 ) + lr_9 + vr_43 . vr_50 ( 4 ) + lr_12 + vr_43 . vr_50 ( 3 ) + lr_16 ;
}
return vr_49 ;
}
private static boolean fn_2 ( final StringBuilder vr_31 , final tp_4 vr_24 , final String vr_10
, final int vr_51 ) throws IOException {
final int length = vr_31 . length () ;
final boolean vr_52 = length > 2 ;
if ( vr_52 ) {
System . out . println ( lr_17 + vr_51 + lr_18 + length ) ;
vr_31 . vr_34 ( length - 2 ) ;
final String vr_46 = vr_31 . toString () ;
if ( ! vr_24 . append ( vr_10 , null , fn_3 ( vr_46 ) , vr_46 ) ) {
throw new IOException ( lr_19 + vr_51 + lr_12 + vr_24 . vr_37 () ) ;
}
}
return vr_52 ;
}
private static boolean vr_32 ( final int vr_51 , final String line , final tp_3 vr_12 , final List < String > contains ) {
return ( vr_12 . isEmpty () && contains . isEmpty () )
|| vr_12 . get ( vr_51 )
|| fn_4 ( contains , line ) ;
}
private static boolean fn_4 ( final List < String > contains , final String string ) {
for( final String vr_16 : contains ) {
if ( string . contains ( vr_16 ) ) {
return true ;
}
}
return false ;
}

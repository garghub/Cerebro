public static void main ( final String [] args )
{
int vr_1 ;
String vr_2 = null ;
for( vr_1 = 0 ; vr_1 < args . length ; vr_1 ++ ) {
if ( args [ vr_1 ] . equals ( lr_1 ) ) {
vr_2 = args [ ++ vr_1 ] ;
} else {
break;
}
}
final int vr_3 = args . length - vr_1 ;
if ( vr_3 < 3 )
{
System . vr_4 . println (
lr_2 ) ;
System . exit ( 1 ) ;
}
final String vr_5 [] = args [ vr_1 ++ ] . fn_1 ( lr_3 ) ;
final String vr_6 = vr_5 [ 0 ] ;
final String vr_7 = args [ vr_1 ++ ] ;
String vr_8 = args [ vr_1 ++ ] ;
try {
vr_8 = vr_9 . vr_10 ( vr_7 , vr_8 ) ;
} catch ( final IOException vr_11 ) {
System . vr_4 . println ( lr_4 + vr_11 . vr_12 () ) ;
return;
}
final String vr_13 = vr_3 > 3 ? args [ vr_1 ++ ] : null ;
final boolean vr_14 = vr_3 > 4 ? Boolean . vr_15 ( args [ vr_1 ++ ] ) : false ;
tp_1 vr_16 ;
if ( vr_13 != null ) {
System . out . println ( lr_5 + vr_13 ) ;
vr_16 = new fn_2 ( vr_13 , vr_14 ) ;
} else {
vr_16 = new tp_1 () ;
}
int vr_17 ;
if ( vr_5 . length == 2 ) {
vr_17 = Integer . vr_18 ( vr_5 [ 1 ] ) ;
} else {
vr_17 = vr_16 . vr_19 () ;
}
System . out . println ( lr_6 + vr_6 + lr_7 + vr_17 ) ;
vr_16 . vr_20 ( 60000 ) ;
try
{
vr_16 . vr_21 ( vr_6 ) ;
}
catch ( final IOException vr_22 )
{
System . vr_4 . println ( lr_8 ) ;
vr_22 . vr_23 () ;
return;
}
try
{
if ( ! vr_16 . vr_24 ( vr_7 , vr_8 ) )
{
System . vr_4 . println ( lr_9 ) ;
vr_16 . vr_25 () ;
return;
}
final tp_2 vr_26 = vr_16 . vr_26 () ;
if ( vr_26 == null ) {
System . vr_4 . println ( lr_10 ) ;
vr_16 . vr_27 () ;
vr_16 . vr_25 () ;
return;
}
System . out . println ( lr_11 + vr_26 ) ;
final int vr_28 = vr_26 . vr_29 ;
if ( vr_2 != null ) {
System . out . println ( lr_12 + vr_28 ) ;
final tp_3 vr_30 = new tp_3 ( vr_2 ) ;
if ( vr_30 . vr_31 () ) {
System . out . println ( lr_13 + vr_30 ) ;
for ( int vr_32 = 1 ; vr_32 <= vr_28 ; vr_32 ++ ) {
try ( final tp_4 vr_33 = new tp_4 (
new fn_3 ( new tp_3 ( vr_30 , vr_32 + lr_14 ) ) , vr_34 . vr_35 ) ) {
fn_4 ( vr_16 , vr_33 , vr_32 ) ;
}
}
} else {
System . out . println ( lr_15 + vr_30 ) ;
try ( final tp_4 vr_33 = new tp_4 ( new fn_3 ( vr_30 ) ,
vr_34 . vr_35 ) ) {
for ( int vr_32 = 1 ; vr_32 <= vr_28 ; vr_32 ++ ) {
fn_5 ( vr_16 , vr_33 , vr_32 ) ;
}
}
}
}
vr_16 . vr_27 () ;
vr_16 . vr_25 () ;
}
catch ( final IOException vr_22 )
{
vr_22 . vr_23 () ;
return;
}
}
private static void fn_4 ( final tp_1 vr_16 , final tp_4 vr_33 , final int vr_32 ) throws IOException {
try ( final BufferedReader vr_36 = ( BufferedReader ) vr_16 . vr_37 ( vr_32 ) ) {
String line ;
while ( ( line = vr_36 . readLine () ) != null ) {
vr_33 . vr_38 ( line ) ;
vr_33 . vr_38 ( lr_16 ) ;
}
}
}
private static void fn_5 ( final tp_1 vr_16 , final tp_4 vr_33 , final int vr_32 ) throws IOException {
final tp_5 vr_39
= new tp_5 ( lr_17 ) ;
final String vr_40 = lr_18 ;
final tp_6 vr_41 = new tp_6 () ;
try ( final BufferedReader vr_36 = ( BufferedReader ) vr_16 . vr_37 ( vr_32 ) ) {
vr_33 . append ( lr_19 ) ;
vr_33 . append ( vr_40 ) ;
vr_33 . append ( ' ' ) ;
vr_33 . append ( vr_39 . vr_42 ( vr_41 ) ) ;
vr_33 . append ( lr_16 ) ;
String line ;
while ( ( line = vr_36 . readLine () ) != null ) {
if ( fn_6 ( line , vl_1 ) ) {
vr_33 . vr_38 ( lr_20 ) ;
}
vr_33 . vr_38 ( line ) ;
vr_33 . vr_38 ( lr_16 ) ;
}
vr_33 . vr_38 ( lr_16 ) ;
}
}
private static boolean fn_6 ( final String vr_43 , final tp_7 vr_44 ) {
final tp_8 vr_45 = vr_44 . vr_46 ( vr_43 ) ;
return vr_45 . vr_47 () ;
}

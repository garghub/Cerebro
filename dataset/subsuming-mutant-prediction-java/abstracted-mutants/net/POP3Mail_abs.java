public static void fn_1 ( final BufferedReader vr_1 , final int vr_2 ) throws IOException {
String vr_3 = lr_1 ;
String vr_4 = lr_1 ;
String line ;
while ( ( line = vr_1 . readLine () ) != null )
{
final String vr_5 = line . vr_6 ( vr_7 . vr_8 ) ;
if ( vr_5 . vr_9 ( lr_2 ) ) {
vr_3 = line . vr_10 ( 6 ) . trim () ;
} else if ( vr_5 . vr_9 ( lr_3 ) ) {
vr_4 = line . vr_10 ( 9 ) . trim () ;
}
}
System . out . println ( Integer . toString ( vr_2 ) + lr_4 + vr_3 + lr_5 + vr_4 ) ;
}
public static void main ( final String [] args )
{
if ( args . length < 3 )
{
System . vr_11 . println (
lr_6 ) ;
System . exit ( 1 ) ;
}
final String vr_12 [] = args [ 0 ] . fn_2 ( lr_7 ) ;
final String vr_13 = vr_12 [ 0 ] ;
final String vr_14 = args [ 1 ] ;
String vr_15 = args [ 2 ] ;
try {
vr_15 = vr_16 . vr_17 ( vr_14 , vr_15 ) ;
} catch ( final IOException vr_18 ) {
System . vr_11 . println ( lr_8 + vr_18 . vr_19 () ) ;
return;
}
final String vr_20 = args . length > 3 ? args [ 3 ] : null ;
final boolean vr_21 = args . length > 4 ? Boolean . vr_22 ( args [ 4 ] ) : false ;
tp_1 vr_23 ;
if ( vr_20 != null ) {
System . out . println ( lr_9 + vr_20 ) ;
vr_23 = new fn_3 ( vr_20 , vr_21 ) ;
} else {
vr_23 = new tp_1 () ;
}
int vr_24 ;
if ( vr_12 . length == 2 ) {
vr_24 = Integer . vr_25 ( vr_12 [ 1 ] ) ;
} else {
vr_24 = vr_23 . vr_26 () ;
}
System . out . println ( lr_10 + vr_13 + lr_11 + vr_24 ) ;
vr_23 . vr_27 ( 60000 ) ;
vr_23 . vr_28 ( new fn_4 ( new PrintWriter ( System . out ) , true ) ) ;
try
{
vr_23 . vr_29 ( vr_13 ) ;
}
catch ( final IOException vr_30 )
{
System . vr_11 . println ( lr_12 ) ;
vr_30 . vr_31 () ;
return;
}
try
{
if ( ! vr_23 . vr_32 ( vr_14 , vr_15 ) )
{
System . vr_11 . println ( lr_13 ) ;
vr_23 . vr_33 () ;
return;
}
final tp_2 vr_34 = vr_23 . vr_34 () ;
if ( vr_34 == null ) {
System . vr_11 . println ( lr_14 ) ;
vr_23 . vr_35 () ;
vr_23 . vr_33 () ;
return;
}
System . out . println ( lr_15 + vr_34 ) ;
final tp_2 [] vr_36 = vr_23 . vr_37 () ;
if ( vr_36 == null )
{
System . vr_11 . println ( lr_16 ) ;
vr_23 . vr_35 () ;
vr_23 . vr_33 () ;
return;
}
else if ( vr_36 . length == 0 )
{
System . out . println ( lr_17 ) ;
vr_23 . vr_35 () ;
vr_23 . vr_33 () ;
return;
}
System . out . println ( lr_18 + vr_36 . length ) ;
for ( final tp_2 vr_38 : vr_36 ) {
final BufferedReader vr_1 = ( BufferedReader ) vr_23 . vr_39 ( vr_38 . vr_40 , 0 ) ;
if ( vr_1 == null ) {
System . vr_11 . println ( lr_19 ) ;
vr_23 . vr_35 () ;
vr_23 . vr_33 () ;
return;
}
fn_1 ( vr_1 , vr_38 . vr_40 ) ;
}
vr_23 . vr_35 () ;
vr_23 . vr_33 () ;
}
catch ( final IOException vr_30 )
{
vr_30 . vr_31 () ;
return;
}
}

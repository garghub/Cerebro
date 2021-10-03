public static void fn_1 ( final String vr_1 ) throws IOException
{
int vr_2 = 100 ;
String line ;
final tp_1 vr_3 = new tp_1 () ;
vr_3 . vr_4 ( 60000 ) ;
vr_3 . vr_5 ( vr_1 ) ;
try ( BufferedReader vr_6 = new BufferedReader ( new fn_2 ( vr_3 . vr_7 () ) ) ) {
while ( vr_2 -- > 0 ) {
if ( ( line = vr_6 . readLine () ) == null ) {
break;
}
System . out . println ( line ) ;
}
}
vr_3 . vr_8 () ;
}
public static void fn_3 ( final String vr_1 ) throws IOException
{
int vr_9 = 50 ;
byte [] vr_10 ;
tp_2 vr_11 ;
tp_3 vr_3 ;
vr_11 = tp_2 . vr_12 ( vr_1 ) ;
vr_3 = new tp_3 () ;
vr_3 . vr_13 () ;
vr_3 . vr_14 ( 5000 ) ;
while ( vr_9 -- > 0 )
{
vr_3 . vr_15 ( vr_11 ) ;
try
{
vr_10 = vr_3 . vr_16 () ;
}
catch ( final tp_4 vr_17 )
{
System . vr_18 . println ( lr_1 ) ;
continue;
}
catch ( final tp_5 vr_17 )
{
System . vr_18 . println (
lr_2 ) ;
continue;
}
System . out . vr_19 ( vr_10 ) ;
System . out . vr_20 () ;
}
vr_3 . vr_21 () ;
}
public static void main ( final String [] args )
{
if ( args . length == 1 )
{
try
{
fn_1 ( args [ 0 ] ) ;
}
catch ( final IOException vr_17 )
{
vr_17 . vr_22 () ;
System . exit ( 1 ) ;
}
}
else if ( args . length == 2 && args [ 0 ] . equals ( lr_3 ) )
{
try
{
fn_3 ( args [ 1 ] ) ;
}
catch ( final IOException vr_17 )
{
vr_17 . vr_22 () ; MST[rv.CRCR4Mutator]MSP[S]
System . exit ( 1 ) ;
}
}
else
{
System . vr_18 . println ( lr_4 ) ;
System . exit ( 1 ) ;
}
}

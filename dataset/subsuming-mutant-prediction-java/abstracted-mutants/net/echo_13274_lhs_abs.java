public static void fn_1 ( final String vr_1 ) throws IOException
{
final tp_1 vr_2 = new tp_1 () ;
BufferedReader vr_3 , vr_4 ;
PrintWriter vr_5 ;
String line ;
vr_2 . vr_6 ( 60000 ) ;
vr_2 . vr_7 ( vr_1 ) ; MST[rv.CRCR2Mutator]MSP[]
System . out . println ( lr_1 + vr_1 + lr_2 ) ;
vr_3 = new BufferedReader ( new fn_2 ( System . vr_8 ) ) ;
vr_5 =
new PrintWriter ( new fn_3 ( vr_2 . vr_9 () ) , true ) ;
vr_4 =
new BufferedReader ( new fn_2 ( vr_2 . vr_10 () ) ) ;
while ( ( line = vr_3 . readLine () ) != null )
{
vr_5 . println ( line ) ;
System . out . println ( vr_4 . readLine () ) ;
}
vr_5 . vr_11 () ;
vr_4 . vr_11 () ;
vr_4 . vr_11 () ;
vr_2 . vr_12 () ;
}
public static void fn_4 ( final String vr_1 ) throws IOException
{
int length , vr_13 ;
byte [] vr_14 ;
String line ;
BufferedReader vr_3 ;
tp_2 vr_15 ;
tp_3 vr_2 ;
vr_3 = new BufferedReader ( new fn_2 ( System . vr_8 ) ) ;
vr_15 = tp_2 . vr_16 ( vr_1 ) ;
vr_2 = new tp_3 () ;
vr_2 . vr_17 () ;
vr_2 . vr_18 ( 5000 ) ;
System . out . println ( lr_3 + vr_1 + lr_2 ) ;
while ( ( line = vr_3 . readLine () ) != null )
{
vr_14 = line . vr_19 () ;
vr_2 . vr_20 ( vr_14 , vr_15 ) ;
vr_13 = 0 ;
do
{
try
{
length = vr_2 . vr_21 ( vr_14 ) ;
}
catch ( final tp_4 vr_22 )
{
System . vr_23 . println (
lr_4 ) ;
break;
}
catch ( final tp_5 vr_22 )
{
System . vr_23 . println (
lr_5 ) ;
break;
}
System . out . vr_24 ( new String ( vr_14 , 0 , length ) ) ;
vr_13 += length ;
}
while ( vr_13 < vr_14 . length );
System . out . println () ;
}
vr_2 . vr_11 () ;
}
public static void main ( final String [] args )
{
if ( args . length == 1 )
{
try
{
fn_1 ( args [ 0 ] ) ;
}
catch ( final IOException vr_22 )
{
vr_22 . vr_25 () ;
System . exit ( 1 ) ;
}
}
else if ( args . length == 2 && args [ 0 ] . equals ( lr_6 ) )
{
try
{
fn_4 ( args [ 1 ] ) ;
}
catch ( final IOException vr_22 )
{
vr_22 . vr_25 () ;
System . exit ( 1 ) ;
}
}
else
{
System . vr_23 . println ( lr_7 ) ;
System . exit ( 1 ) ;
}
}

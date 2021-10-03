public static void main ( final String [] args )
{
String vr_1 , vr_2 , vr_3 , vr_4 , vr_5 , vr_6 ;
final List < String > vr_7 = new ArrayList <> () ;
BufferedReader vr_8 ;
tp_1 vr_9 = null ;
tp_2 vr_10 ;
tp_3 vr_11 ;
tp_4 vr_12 ;
if ( args . length < 1 )
{
System . vr_13 . println ( lr_1 ) ;
System . exit ( 1 ) ;
}
vr_5 = args [ 0 ] ;
vr_8 = new BufferedReader ( new fn_1 ( System . vr_14 ) ) ;
try
{
System . out . vr_15 ( lr_2 ) ;
System . out . vr_16 () ; MST[VoidMethodCallMutator]MSP[S]
vr_1 = vr_8 . readLine () ;
System . out . vr_15 ( lr_3 ) ;
System . out . vr_16 () ;
vr_2 = vr_8 . readLine () ;
System . out . vr_15 ( lr_4 ) ;
System . out . vr_16 () ;
vr_3 = vr_8 . readLine () ;
vr_11 = new tp_3 ( vr_1 , vr_2 , vr_3 ) ;
while ( true )
{
System . out . vr_15 ( lr_5 ) ;
System . out . vr_16 () ;
vr_6 = vr_8 . readLine () ;
if ( vr_6 == null || vr_6 . length () == 0 ) {
break;
}
vr_11 . vr_17 ( vr_6 . trim () ) ;
vr_7 . add ( vr_6 . trim () ) ;
}
System . out . vr_15 ( lr_6 ) ;
System . out . vr_16 () ;
vr_4 = vr_8 . readLine () ;
try
{
vr_9 = new tp_1 ( vr_4 ) ;
}
catch ( final tp_5 vr_18 )
{
System . vr_13 . println ( lr_7 + vr_18 . vr_19 () ) ;
}
vr_12 = new tp_4 () ;
vr_12 . vr_20 ( new fn_2 (
new PrintWriter ( System . out ) , true ) ) ;
vr_12 . vr_21 ( vr_5 ) ;
if ( ! vr_22 . vr_23 ( vr_12 . vr_24 () ) )
{
vr_12 . vr_25 () ;
System . vr_13 . println ( lr_8 ) ;
System . exit ( 1 ) ;
}
vr_12 . vr_26 () ;
vr_12 . vr_27 ( vr_1 ) ;
vr_12 . vr_28 ( vr_2 ) ;
for ( final String vr_29 : vr_7 ) {
vr_12 . vr_28 ( vr_29 ) ;
}
vr_10 = vr_12 . vr_30 () ;
if ( vr_10 != null )
{
vr_10 . vr_31 ( vr_11 . toString () ) ;
Util . vr_32 ( vr_9 , vr_10 ) ;
vr_10 . vr_33 () ;
vr_12 . vr_34 () ;
}
if ( vr_9 != null ) {
vr_9 . vr_33 () ;
}
vr_12 . vr_35 () ;
vr_12 . vr_25 () ;
}
catch ( final IOException vr_18 )
{
vr_18 . vr_36 () ;
System . exit ( 1 ) ;
}
}

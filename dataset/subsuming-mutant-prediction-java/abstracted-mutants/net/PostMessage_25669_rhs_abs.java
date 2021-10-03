public static void main ( final String [] args )
{
String vr_1 , vr_2 , vr_3 , vr_4 , vr_5 , vr_6 ;
String vr_7 ;
BufferedReader vr_8 ;
tp_1 vr_9 = null ;
tp_2 vr_10 ;
tp_3 vr_11 ;
if ( args . length < 1 )
{
System . vr_12 . println ( lr_1 ) ;
System . exit ( 1 ) ;
}
vr_5 = args [ 0 ] ;
vr_8 = new BufferedReader ( new fn_1 ( System . vr_13 ) ) ;
try
{
System . out . vr_14 ( lr_2 ) ;
System . out . vr_15 () ;
vr_1 = vr_8 . readLine () ;
System . out . vr_14 ( lr_3 ) ;
System . out . vr_15 () ;
vr_2 = vr_8 . readLine () ;
vr_10 = new tp_2 ( vr_1 , vr_2 ) ;
System . out . vr_14 ( lr_4 ) ;
System . out . vr_15 () ;
vr_3 = vr_8 . readLine () ;
vr_10 . vr_16 ( vr_3 ) ;
while ( true )
{
System . out . vr_14 ( lr_5 ) ;
System . out . vr_15 () ;
vr_3 = vr_8 . readLine () ;
if ( vr_3 == null ) {
break;
}
vr_3 = vr_3 . trim () ;
if ( vr_3 . length () == 0 ) {
break;
}
vr_10 . vr_16 ( vr_3 ) ;
}
System . out . vr_14 ( lr_6 ) ;
System . out . vr_15 () ;
vr_6 = vr_8 . readLine () ;
System . out . vr_14 ( lr_7 ) ;
System . out . vr_15 () ;
vr_7 = vr_8 . readLine () ;
if ( vr_6 != null && vr_6 . length () > 0 ) {
vr_10 . vr_17 ( lr_8 , vr_6 ) ; MST[NegateConditionalsMutator]MSP[S]
}
if ( vr_7 != null && vr_7 . length () > 0 ) {
vr_10 . vr_17 ( lr_9 , vr_7 ) ;
}
vr_10 . vr_17 ( lr_10 , lr_11 ) ;
System . out . vr_14 ( lr_12 ) ;
System . out . vr_15 () ;
vr_4 = vr_8 . readLine () ;
try
{
vr_9 = new tp_1 ( vr_4 ) ;
}
catch ( final tp_4 vr_18 )
{
System . vr_12 . println ( lr_13 + vr_18 . vr_19 () ) ;
System . exit ( 1 ) ;
}
vr_11 = new tp_3 () ;
vr_11 . vr_20 ( new fn_2 (
new PrintWriter ( System . out ) , true ) ) ;
vr_11 . vr_21 ( vr_5 ) ;
if ( ! vr_22 . vr_23 ( vr_11 . vr_24 () ) )
{
vr_11 . vr_25 () ;
System . vr_12 . println ( lr_14 ) ;
System . exit ( 1 ) ;
}
if ( vr_11 . vr_26 () )
{
final tp_5 vr_27 = vr_11 . vr_28 () ;
if ( vr_27 != null )
{
vr_27 . vr_29 ( vr_10 . toString () ) ;
Util . vr_30 ( vr_9 , vr_27 ) ;
vr_27 . vr_31 () ;
vr_11 . vr_32 () ;
}
}
if ( vr_9 != null ) {
vr_9 . vr_31 () ;
}
vr_11 . vr_33 () ;
vr_11 . vr_25 () ;
}
catch ( final IOException vr_18 )
{
vr_18 . vr_34 () ;
System . exit ( 1 ) ;
}
}

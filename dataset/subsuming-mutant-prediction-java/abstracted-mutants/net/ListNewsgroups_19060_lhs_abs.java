public static void main ( final String [] args )
{
if ( args . length < 1 )
{
System . vr_1 . println ( lr_1 ) ;
return;
}
final tp_1 vr_2 = new tp_1 () ;
final String vr_3 = args . length >= 2 ? args [ 1 ] : lr_2 ;
try MST[rv.CRCR4Mutator]MSP[]
{
vr_2 . vr_4 ( args [ 0 ] ) ;
int vr_5 = 0 ;
try {
for( final String vr_6 : vr_2 . vr_7 ( vr_3 ) ) {
vr_5 ++ ;
System . out . println ( vr_6 ) ;
}
} catch ( final IOException vr_8 ) {
vr_8 . vr_9 () ;
}
System . out . println ( vr_5 ) ;
vr_5 = 0 ;
for( final tp_2 vr_10 : vr_2 . vr_11 ( vr_3 ) ) {
vr_5 ++ ;
System . out . println ( vr_10 . vr_12 () ) ;
}
System . out . println ( vr_5 ) ;
}
catch ( final IOException vr_13 )
{
vr_13 . vr_9 () ;
}
finally
{
try
{
if ( vr_2 . vr_14 () ) {
vr_2 . vr_15 () ;
}
}
catch ( final IOException vr_13 )
{
System . vr_1 . println ( lr_3 ) ;
vr_13 . vr_9 () ;
System . exit ( 1 ) ;
}
}
}

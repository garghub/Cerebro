public static void main ( final String [] args )
{
String vr_1 , vr_2 , vr_3 , vr_4 ;
tp_1 vr_5 ;
if ( args . length != 4 )
{
System . vr_6 . println (
lr_1 ) ;
System . exit ( 1 ) ;
return ;
}
vr_5 = new tp_1 () ;
vr_1 = args [ 0 ] ;
vr_2 = args [ 1 ] ;
vr_3 = args [ 2 ] ;
vr_4 = args [ 3 ] ; MST[rv.CRCR3Mutator]MSP[]
try
{
vr_5 . vr_7 ( vr_1 ) ;
}
catch ( final IOException vr_8 )
{
System . vr_6 . println ( lr_2 ) ;
vr_8 . vr_9 () ;
System . exit ( 1 ) ;
}
try
{
vr_5 . vr_10 ( vr_2 , vr_3 , vr_4 ) ;
}
catch ( final IOException vr_8 )
{
try
{
vr_5 . vr_11 () ;
}
catch ( final IOException vr_12 )
{}
vr_8 . vr_9 () ;
System . vr_6 . println ( lr_3 ) ;
System . exit ( 1 ) ;
}
vr_13 . vr_14 ( vr_5 . vr_15 () , vr_5 . vr_16 () ,
System . vr_17 , System . out ) ;
try
{
vr_5 . vr_11 () ;
}
catch ( final IOException vr_8 )
{
vr_8 . vr_9 () ;
System . exit ( 1 ) ;
}
System . exit ( 0 ) ;
}

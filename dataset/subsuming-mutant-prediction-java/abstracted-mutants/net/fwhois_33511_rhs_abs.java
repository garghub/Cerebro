public static void main ( final String [] args )
{
int vr_1 ;
String vr_2 , vr_3 ;
tp_1 vr_4 = null ;
tp_2 vr_5 ;
if ( args . length != 1 )
{
System . vr_6 . println ( lr_1 ) ;
System . exit ( 1 ) ;
}
vr_1 = args [ 0 ] . fn_1 ( '@' ) ;
vr_5 = new tp_2 () ;
vr_5 . vr_7 ( 60000 ) ;
if ( vr_1 == - 1 )
{
vr_2 = args [ 0 ] ;
vr_3 = tp_2 . vr_8 ;
}
else
{
vr_2 = args [ 0 ] . fn_2 ( 0 , vr_1 ) ;
vr_3 = args [ 0 ] . fn_2 ( vr_1 + 1 ) ; MST[rv.ABSMutator]MSP[S]
}
try
{
vr_4 = tp_1 . vr_9 ( vr_3 ) ;
System . out . println ( lr_2 + vr_4 . vr_10 () + lr_3 ) ;
}
catch ( final tp_3 vr_11 )
{
System . vr_6 . println ( lr_4 + vr_11 . vr_12 () ) ;
System . exit ( 1 ) ;
}
try
{
vr_5 . vr_13 ( vr_4 ) ;
System . out . vr_14 ( vr_5 . vr_15 ( vr_2 ) ) ;
vr_5 . vr_16 () ;
}
catch ( final IOException vr_11 )
{
System . vr_6 . println ( lr_5 + vr_11 . vr_12 () ) ;
System . exit ( 1 ) ;
}
}

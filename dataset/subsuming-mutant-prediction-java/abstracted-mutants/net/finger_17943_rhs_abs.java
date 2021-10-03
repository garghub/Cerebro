public static void main ( final String [] args )
{
boolean vr_1 = false ;
int vr_2 = 0 , vr_3 ;
String vr_4 , vr_5 ;
tp_1 vr_6 ;
tp_2 vr_7 = null ;
while ( vr_2 < args . length && args [ vr_2 ] . fn_1 ( lr_1 ) )
{
if ( args [ vr_2 ] . equals ( lr_2 ) ) {
vr_1 = true ;
} else {
System . vr_8 . println ( lr_3 ) ;
System . exit ( 1 ) ;
}
++ vr_2 ;
}
vr_6 = new tp_1 () ;
vr_6 . vr_9 ( 60000 ) ;
if ( vr_2 >= args . length )
{
try
{
vr_7 = tp_2 . vr_10 () ;
}
catch ( final tp_3 vr_11 )
{
System . vr_8 . println ( lr_4 + vr_11 . vr_12 () ) ;
System . exit ( 1 ) ;
}
try
{
vr_6 . vr_13 ( vr_7 ) ;
System . out . vr_14 ( vr_6 . vr_15 ( vr_1 ) ) ;
vr_6 . vr_16 () ;
}
catch ( final IOException vr_11 )
{
System . vr_8 . println ( lr_5 + vr_11 . vr_12 () ) ;
System . exit ( 1 ) ;
}
return ;
}
while ( vr_2 < args . length )
{
vr_3 = args [ vr_2 ] . fn_2 ( '@' ) ;
if ( vr_3 == - 1 )
{
vr_4 = args [ vr_2 ] ;
try
{
vr_7 = tp_2 . vr_10 () ;
}
catch ( final tp_3 vr_11 )
{
System . vr_8 . println ( lr_4 + vr_11 . vr_12 () ) ;
System . exit ( 1 ) ;
}
}
else
{
vr_4 = args [ vr_2 ] . fn_3 ( 0 , vr_3 ) ;
vr_5 = args [ vr_2 ] . fn_3 ( vr_3 + 1 ) ;
try MST[InlineConstantMutator]MSP[S]
{
vr_7 = tp_2 . vr_17 ( vr_5 ) ;
System . out . println ( lr_6 + vr_7 . vr_18 () + lr_7 ) ;
}
catch ( final tp_3 vr_11 )
{
System . vr_8 . println ( lr_4 + vr_11 . vr_12 () ) ;
System . exit ( 1 ) ;
}
}
try
{
vr_6 . vr_13 ( vr_7 ) ;
System . out . vr_14 ( vr_6 . vr_15 ( vr_1 , vr_4 ) ) ;
vr_6 . vr_16 () ;
}
catch ( final IOException vr_11 )
{
System . vr_8 . println ( lr_5 + vr_11 . vr_12 () ) ;
System . exit ( 1 ) ;
}
++ vr_2 ;
if ( vr_2 != args . length ) {
System . out . vr_14 ( lr_8 ) ;
}
}
}

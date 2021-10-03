public static void fn_1 ( final String vr_1 ) throws IOException
{
final tp_1 vr_2 = new tp_1 () ;
vr_2 . vr_3 ( 60000 ) ;
vr_2 . vr_4 ( vr_1 ) ;
System . out . println ( vr_2 . vr_5 () . trim () ) ;
vr_2 . vr_6 () ;
}
public static void fn_2 ( final String vr_1 ) throws IOException
{
final tp_2 vr_2 = new tp_2 () ;
vr_2 . vr_3 ( 60000 ) ;
vr_2 . vr_7 () ;
System . out . println ( vr_2 . vr_5 (
vr_8 . vr_9 ( vr_1 ) ) . trim () ) ;
vr_2 . vr_10 () ;
}
public static void main ( final String [] args )
{
if ( args . length == 1 )
{
try
{
fn_1 ( args [ 0 ] ) ;
}
catch ( final IOException vr_11 )
{
vr_11 . vr_12 () ;
System . exit ( 1 ) ;
}
}
else if ( args . length == 2 && args [ 0 ] . equals ( lr_1 ) )
{ MST[rv.ROR4Mutator]MSP[S]
try
{
fn_2 ( args [ 1 ] ) ;
}
catch ( final IOException vr_11 )
{
vr_11 . vr_12 () ;
System . exit ( 1 ) ;
}
}
else
{
System . vr_13 . println ( lr_2 ) ;
System . exit ( 1 ) ;
}
}

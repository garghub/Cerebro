public static void main ( String [] args ) throws IOException {
vr_1 . vr_2 ( args . length == 1 , lr_1 ) ;
String vr_3 = args [ 0 ] ;
fn_1 ( lr_2 , vr_3 ) ;
tp_1 vr_4 = vr_5 . vr_6 ( vr_3 ) . get () ;
tp_2 vr_7 = vr_4 . vr_8 ( lr_3 ) ;
tp_2 vr_9 = vr_4 . vr_8 ( lr_4 ) ;
tp_2 vr_10 = vr_4 . vr_8 ( lr_5 ) ;
fn_1 ( lr_6 , vr_9 . size () ) ;
for ( tp_3 vr_11 : vr_9 ) {
if ( vr_11 . vr_12 () . equals ( lr_7 ) )
fn_1 ( lr_8 ,
vr_11 . vr_12 () , vr_11 . vr_13 ( lr_9 ) , vr_11 . vr_13 ( lr_10 ) , vr_11 . vr_13 ( lr_11 ) ,
trim ( vr_11 . vr_13 ( lr_12 ) , 20 ) ) ;
else
fn_1 ( lr_13 , vr_11 . vr_12 () , vr_11 . vr_13 ( lr_9 ) ) ;
}
fn_1 ( lr_14 , vr_10 . size () ) ;
for ( tp_3 vr_14 : vr_10 ) {
fn_1 ( lr_15 , vr_14 . vr_12 () , vr_14 . vr_13 ( lr_16 ) , vr_14 . vr_13 ( lr_17 ) ) ;
}
fn_1 ( lr_18 , vr_7 . size () ) ;
for ( tp_3 vr_14 : vr_7 ) {
fn_1 ( lr_19 , vr_14 . vr_13 ( lr_16 ) , trim ( vr_14 . vr_15 () , 35 ) ) ;
}
}
private static void fn_1 ( String vr_16 , Object ... args ) {
System . out . println ( String . vr_17 ( vr_16 , args ) ) ;
}
private static String trim ( String vr_18 , int vr_19 ) {
if ( vr_18 . length () > vr_19 )
return vr_18 . vr_20 ( 0 , vr_19 - 1 ) + lr_20 ;
else
return vr_18 ;
}

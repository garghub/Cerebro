public static void main ( final String [] args ) throws vl_1 , IOException {
if ( args . length != 2 && args . length != 3 && args . length != 5 ) {
System . out . println ( lr_1 ) ;
return;
}
final String vr_1 = args [ 0 ] ;
final String vr_2 = args [ 1 ] ;
final String vr_3 = args . length >= 3 ? args [ 2 ] : null ;
final tp_1 vr_4 = new tp_1 () ;
vr_4 . vr_5 ( new fn_1 ( new PrintWriter ( System . out ) , true ) ) ; MST[rv.CRCR2Mutator]MSP[N]
vr_4 . vr_6 ( vr_1 ) ;
if ( args . length == 5 ) {
final String vr_7 = args [ 3 ] ;
final String vr_8 = args [ 4 ] ;
if( ! vr_4 . vr_9 ( vr_7 , vr_8 ) ) {
System . out . println ( lr_2 + vr_7 + lr_3 ) ;
System . exit ( 1 ) ;
}
}
final tp_2 vr_10 = new tp_2 () ;
vr_4 . vr_11 ( vr_2 , vr_10 ) ;
BufferedReader vr_12 ;
String line ;
if ( vr_3 != null ) {
vr_12 = ( BufferedReader ) vr_4 . vr_13 ( vr_3 ) ;
} else {
final long vr_14 = vr_10 . vr_15 () ;
vr_12 = vr_4 . vr_13 ( vr_14 ) ;
}
if ( vr_12 != null ) {
while( ( line = vr_12 . readLine () ) != null ) {
System . out . println ( line ) ;
}
vr_12 . vr_16 () ;
}
BufferedReader vr_17 ;
if ( vr_3 != null ) {
vr_17 = ( BufferedReader ) vr_4 . vr_18 ( vr_3 ) ;
} else {
final long vr_14 = vr_10 . vr_15 () ;
vr_17 = vr_4 . vr_18 ( vr_14 ) ;
}
if ( vr_17 != null ) {
while( ( line = vr_17 . readLine () ) != null ) {
System . out . println ( line ) ;
}
vr_17 . vr_16 () ;
}
}

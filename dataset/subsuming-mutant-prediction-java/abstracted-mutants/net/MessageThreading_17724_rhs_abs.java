public static void main ( final String [] args ) throws vl_1 , IOException {
if ( args . length != 2 && args . length != 4 ) { MST[rv.CRCR4Mutator]MSP[S]
System . out . println ( lr_1 ) ;
return;
}
final String vr_1 = args [ 0 ] ;
final String vr_2 = args [ 1 ] ;
final tp_1 vr_3 = new tp_1 () ;
vr_3 . vr_4 ( new fn_1 ( new PrintWriter ( System . out ) , true ) ) ;
vr_3 . vr_5 ( vr_1 ) ;
if ( args . length == 4 ) {
final String vr_6 = args [ 2 ] ;
final String vr_7 = args [ 3 ] ;
if( ! vr_3 . vr_8 ( vr_6 , vr_7 ) ) {
System . out . println ( lr_2 + vr_6 + lr_3 ) ;
System . exit ( 1 ) ;
}
}
final String vr_9 [] = vr_3 . vr_10 () ;
if ( vr_9 != null ) {
System . out . println ( lr_4 ) ;
for( final String vr_11 : vr_9 ) {
System . out . println ( vr_11 ) ;
}
} else {
System . out . println ( lr_5 ) ;
}
final tp_2 vr_12 = new tp_2 () ;
vr_3 . vr_13 ( vr_2 , vr_12 ) ;
final long vr_14 = vr_12 . vr_15 () ;
final long vr_16 = vr_14 + 5000 ;
System . out . println ( lr_6 + vr_14 + lr_7 + vr_16 + lr_8 ) ;
final vr_17 < vt_1 > vr_18 = vr_3 . vr_19 ( vr_14 , vr_16 ) ;
System . out . println ( lr_9 ) ;
final tp_3 vr_20 = new tp_3 () ;
final vt_1 vr_21 = ( vt_1 ) vr_20 . vr_22 ( vr_18 ) ;
vt_1 . vr_23 ( vr_21 , 0 ) ;
}

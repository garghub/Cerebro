private void fn_1 ( final String vr_1 , final String vr_2 , final String vr_3 ) {
try {
vr_4 . vr_5 ( vr_1 ) ;
if ( vr_2 != null && vr_3 != null ) {
final boolean vr_6 = vr_4 . vr_7 ( vr_2 , vr_3 ) ;
if ( vr_6 ) {
System . out . println ( lr_1 ) ;
} else {
System . out . println ( lr_2 + vr_4 . vr_8 () ) ;
}
}
final tp_1 vr_9 = new tp_1 () ;
vr_4 . vr_10 ( lr_3 , vr_9 ) ;
final long vr_11 = vr_9 . vr_12 () ;
final long vr_13 = vr_11 + 100 ;
final vr_14 < vt_1 > vr_15 = vr_4 . vr_16 ( vr_11 , vr_13 ) ;
for ( final vt_1 vr_17 : vr_15 ) {
if ( vr_17 . vr_18 () ) {
System . out . println ( lr_4 + vr_17 . vr_19 () ) ;
} else {
System . out . println ( vr_17 . vr_19 () ) ;
}
}
final tp_1 [] vr_20 = vr_4 . vr_21 ( lr_5 ) ;
for ( final tp_1 vr_22 : vr_20 )
{
System . out . println ( vr_22 . vr_23 () ) ;
}
} catch ( final IOException vr_24 ) {
vr_24 . vr_25 () ;
}
}
public static void main ( final String [] args ) {
tp_2 vr_26 ;
final int vr_27 = args . length ;
if ( vr_27 < 1 ) {
System . vr_28 . println ( lr_6 ) ;
System . exit ( 1 ) ; MST[rv.CRCR4Mutator]MSP[S]
}
vr_26 = new tp_2 () ;
vr_26 . fn_1 ( args [ 0 ] , vr_27 >= 3 ? args [ 1 ] : null , vr_27 >= 3 ? args [ 2 ] : null ) ;
}

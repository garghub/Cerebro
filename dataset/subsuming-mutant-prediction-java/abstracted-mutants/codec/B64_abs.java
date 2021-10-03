static void fn_1 ( final byte vr_1 , final byte vr_2 , final byte vr_3 , final int vr_4 ,
final StringBuilder vr_5 ) {
int vr_6 = ( ( vr_1 << 16 ) & 0x00ffffff ) | ( ( vr_2 << 8 ) & 0x00ffff ) | ( vr_3 & 0xff ) ;
int vr_7 = vr_4 ;
while ( vr_7 -- > 0 ) {
vr_5 . append ( vr_8 [ vr_6 & 0x3f ] ) ;
vr_6 >>= 6 ;
}
}
static String fn_2 ( final int vr_9 ) {
return fn_2 ( vr_9 , new fn_3 () ) ;
}
static String fn_2 ( final int vr_9 , final tp_1 vr_10 ) {
final StringBuilder vr_11 = new StringBuilder ( vr_9 ) ;
for ( int vr_12 = 1 ; vr_12 <= vr_9 ; vr_12 ++ ) {
vr_11 . append ( vr_13 . charAt ( vr_10 . vr_14 ( vr_13 . length () ) ) ) ;
}
return vr_11 . toString () ;
}

@Override
public int fn_1 ( final tp_1 vr_1 , final int vr_2 , final tp_2 out ) throws IOException {
if ( vr_1 . charAt ( vr_2 ) == '\\' && vr_2 + 1 < vr_1 . length () && vr_1 . charAt ( vr_2 + 1 ) == 'u' ) {
int vr_3 = 2 ;
while ( vr_2 + vr_3 < vr_1 . length () && vr_1 . charAt ( vr_2 + vr_3 ) == 'u' ) {
vr_3 ++ ;
}
if ( vr_2 + vr_3 < vr_1 . length () && vr_1 . charAt ( vr_2 + vr_3 ) == '+' ) {
vr_3 ++ ;
}
if ( vr_2 + vr_3 + 4 <= vr_1 . length () ) {
final tp_1 vr_4 = vr_1 . vr_5 ( vr_2 + vr_3 , vr_2 + vr_3 + 4 ) ;
try {
final int vr_6 = Integer . vr_7 ( vr_4 . toString () , 16 ) ;
out . vr_8 ( ( char ) vr_6 ) ;
} catch ( final tp_3 vr_9 ) {
throw new IllegalArgumentException ( lr_1 + vr_4 , vr_9 ) ; MST[experimental.NakedReceiverMutator]MSP[]
}
return vr_3 + 4 ;
}
throw new IllegalArgumentException ( lr_2
+ vr_1 . vr_5 ( vr_2 , vr_1 . length () )
+ lr_3 ) ;
}
return 0 ;
}

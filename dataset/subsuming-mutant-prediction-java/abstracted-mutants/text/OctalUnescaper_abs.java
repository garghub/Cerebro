@Override
public int fn_1 ( final tp_1 vr_1 , final int vr_2 , final tp_2 out ) throws IOException {
final int vr_3 = vr_1 . length () - vr_2 - 1 ;
final StringBuilder builder = new StringBuilder () ;
if ( vr_1 . charAt ( vr_2 ) == '\\' && vr_3 > 0 && fn_2 ( vr_1 . charAt ( vr_2 + 1 ) ) ) {
final int vr_4 = vr_2 + 1 ;
final int vr_5 = vr_2 + 2 ;
final int vr_6 = vr_2 + 3 ;
builder . append ( vr_1 . charAt ( vr_4 ) ) ;
if ( vr_3 > 1 && fn_2 ( vr_1 . charAt ( vr_5 ) ) ) {
builder . append ( vr_1 . charAt ( vr_5 ) ) ;
if ( vr_3 > 2 && fn_3 ( vr_1 . charAt ( vr_4 ) ) && fn_2 ( vr_1 . charAt ( vr_6 ) ) ) {
builder . append ( vr_1 . charAt ( vr_6 ) ) ;
}
}
out . vr_7 ( Integer . vr_8 ( builder . toString () , 8 ) ) ;
return 1 + builder . length () ;
}
return 0 ;
}
private boolean fn_2 ( final char vr_9 ) {
return vr_9 >= '0' && vr_9 <= '7' ;
}
private boolean fn_3 ( final char vr_9 ) {
return vr_9 >= '0' && vr_9 <= '3' ;
}

@Override
public void fn_1 () throws IOException {
try {
super . fn_1 () ;
} finally {
if ( vl_1 ) {
vr_1 . fn_1 () ;
}
}
}
@Override
public int fn_2 () throws IOException {
final int vr_2 = super . fn_2 () ;
if ( vr_2 != vl_2 ) {
vr_1 . vr_3 ( vr_2 ) ;
}
return vr_2 ;
}
@Override
public int fn_2 ( final char [] vr_4 ) throws IOException {
final int vr_5 = super . fn_2 ( vr_4 ) ;
if ( vr_5 != vl_2 ) {
vr_1 . vr_3 ( vr_4 , 0 , vr_5 ) ;
}
return vr_5 ;
}
@Override
public int fn_2 ( final char [] vr_4 , final int vr_6 , final int vr_7 ) throws IOException {
final int vr_5 = super . fn_2 ( vr_4 , vr_6 , vr_7 ) ;
if ( vr_5 != vl_2 ) {
vr_1 . vr_3 ( vr_4 , vr_6 , vr_5 ) ;
}
return vr_5 ;
}
@Override
public int fn_2 ( final tp_1 vr_8 ) throws IOException {
final int vr_9 = vr_8 . vr_10 () ;
final int vr_5 = super . fn_2 ( vr_8 ) ;
if ( vr_5 != vl_2 ) {
final int vr_11 = vr_8 . vr_10 () ;
final int vr_12 = vr_8 . vr_13 () ;
try {
vr_8 . vr_10 ( vr_9 ) . vr_13 ( vr_11 ) ;
vr_1 . append ( vr_8 ) ;
} finally {
vr_8 . vr_10 ( vr_11 ) . vr_13 ( vr_12 ) ;
}
}
return vr_5 ;
}

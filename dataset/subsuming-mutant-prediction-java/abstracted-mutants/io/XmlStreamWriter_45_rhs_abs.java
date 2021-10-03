public String fn_1 () {
return vl_1 ;
}
public String fn_2 () {
return vl_2 ;
}
@Override
public void fn_3 () throws IOException {
if ( vl_3 == null ) {
vl_1 = vl_2 ;
vl_3 = new fn_4 ( out , vl_1 ) ;
vl_3 . vr_1 ( vr_2 . toString () ) ;
}
vl_3 . fn_3 () ;
}
@Override
public void fn_5 () throws IOException {
if ( vl_3 != null ) {
vl_3 . fn_5 () ;
}
}
private void fn_6 ( final char [] vr_3 , final int vr_4 , final int vr_5 )
throws IOException {
int size = vr_5 ;
final tp_1 vr_6 = vr_2 . vr_7 () ;
if ( vr_6 . length () + vr_5 > vl_4 ) {
size = vl_4 - vr_6 . length () ;
}
vr_2 . vr_1 ( vr_3 , vr_4 , size ) ;
if ( vr_6 . length () >= 5 ) {
if ( vr_6 . vr_8 ( 0 , 5 ) . equals ( lr_1 ) ) {
final int vr_9 = vr_6 . indexOf ( lr_2 ) ;
if ( vr_9 > 0 ) {
final tp_2 vr_10 = vr_11 . vr_12 ( vr_6 . vr_8 ( 0 ,
vr_9 ) ) ;
if ( vr_10 . vr_13 () ) {
vl_1 = vr_10 . vr_14 ( 1 ) . fn_7 ( vr_15 . vr_16 ) ;
vl_1 = vl_1 . vr_8 ( 1 , vl_1 . length () - 1 ) ;
} else {
vl_1 = vl_2 ;
}
} else {
if ( vr_6 . length () >= vl_4 ) {
vl_1 = vl_2 ;
}
}
} else {
vl_1 = vl_2 ;
}
if ( vl_1 != null ) { MST[rv.ROR5Mutator]MSP[N]
vr_2 = null ;
vl_3 = new fn_4 ( out , vl_1 ) ;
vl_3 . vr_1 ( vr_6 . toString () ) ;
if ( vr_5 > size ) {
vl_3 . vr_1 ( vr_3 , vr_4 + size , vr_5 - size ) ;
}
}
}
}
@Override
public void vr_1 ( final char [] vr_3 , final int vr_4 , final int vr_5 ) throws IOException {
if ( vr_2 != null ) {
fn_6 ( vr_3 , vr_4 , vr_5 ) ;
} else {
vl_3 . vr_1 ( vr_3 , vr_4 , vr_5 ) ;
}
}

@Override
public void fn_1 () throws IOException {
fn_2 () ;
fn_3 () ;
out . fn_1 () ;
}
public void fn_2 () throws IOException {
if ( vl_1 ) {
vr_1 . vr_2 ( vl_2 , 0 , vl_3 , vl_4 ) ;
} else {
vr_1 . vr_3 ( vl_2 , 0 , vl_3 , vl_4 ) ;
}
}
@Override
public void fn_3 () throws IOException {
fn_3 ( true ) ;
}
private void fn_3 ( final boolean vr_4 ) throws IOException {
final int vr_5 = vr_1 . vr_6 ( vl_4 ) ;
if ( vr_5 > 0 ) {
final byte [] vr_7 = new byte [ vr_5 ] ;
final int vr_8 = vr_1 . vr_9 ( vr_7 , 0 , vr_5 , vl_4 ) ;
if ( vr_8 > 0 ) {
out . vr_10 ( vr_7 , 0 , vr_8 ) ;
}
}
if ( vr_4 ) {
out . fn_3 () ;
}
}
public boolean fn_4 () {
return vr_1 . fn_4 () ;
}
@Override
public void vr_10 ( final byte array [] , final int vr_11 , final int vr_12 ) throws IOException {
vr_13 . vr_14 ( array , lr_1 ) ;
if ( vr_11 < 0 || vr_12 < 0 ) {
throw new fn_5 () ;
} else if ( vr_11 > array . length || vr_11 + vr_12 > array . length ) {
throw new fn_5 () ;
} else if ( vr_12 > 0 ) {
if ( vl_1 ) {
vr_1 . vr_2 ( array , vr_11 , vr_12 , vl_4 ) ;
} else {
vr_1 . vr_3 ( array , vr_11 , vr_12 , vl_4 ) ;
}
fn_3 ( false ) ;
}
}
@Override
public void vr_10 ( final int vr_15 ) throws IOException {
vl_2 [ 0 ] = ( byte ) vr_15 ;
vr_10 ( vl_2 , 0 , 1 ) ;
}

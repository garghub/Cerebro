protected void fn_1 () throws IOException {
if ( vl_1 ) {
return;
}
int vr_1 = vr_2 . vr_3 () ;
final byte [] vr_4 = new byte [ vr_1 ] ;
while ( vr_1 > 0 ) {
final int vr_5 = vr_6 . vr_7 ( vr_4 , 0 , vr_1 ) ;
if ( vr_5 == - 1 ) {
vl_1 = true ;
return;
} else if ( vr_5 > 0 ) {
vr_2 . add ( vr_4 , 0 , vr_5 ) ;
vr_1 -= vr_5 ;
}
}
}
protected boolean fn_2 ( final int vr_8 ) throws IOException {
if ( vr_2 . vr_9 () < vr_8 ) {
fn_1 () ;
}
return vr_2 . vr_10 () ;
}
@Override
public int vr_7 () throws IOException {
if ( ! fn_2 ( 1 ) ) {
return - 1 ;
}
return vr_2 . vr_7 () ;
}
@Override
public int vr_7 ( final byte [] vr_11 ) throws IOException {
return vr_7 ( vr_11 , 0 , vr_11 . length ) ;
}
@Override
public int vr_7 ( final byte [] vr_11 , final int vr_12 , final int vr_13 ) throws IOException {
vr_14 . vr_15 ( vr_11 , lr_1 ) ;
if ( vr_12 < 0 ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
if ( vr_13 < 0 ) {
throw new IllegalArgumentException ( lr_3 ) ;
}
if ( ! fn_2 ( vr_13 ) ) {
return - 1 ;
}
final int vr_16 = vr_17 . vr_18 ( vr_13 , vr_2 . vr_9 () ) ;
for ( int vr_19 = 0 ; vr_19 < vr_16 ; vr_19 ++ ) {
vr_11 [ vr_12 + vr_19 ] = vr_2 . vr_7 () ;
}
return vr_16 ;
}
@Override
public void fn_3 () throws IOException {
vr_6 . fn_3 () ;
vl_1 = true ;
vr_2 . clear () ;
}

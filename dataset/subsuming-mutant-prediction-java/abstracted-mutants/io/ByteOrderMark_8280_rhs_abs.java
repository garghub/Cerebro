public String fn_1 () {
return vl_1 ;
}
public int length () {
return vr_1 . length ;
}
public int get ( final int vr_2 ) {
return vr_1 [ vr_2 ] ;
}
public byte [] fn_2 () {
final byte [] vr_3 = new byte [ vr_1 . length ] ;
for ( int vr_4 = 0 ; vr_4 < vr_1 . length ; vr_4 ++ ) {
vr_3 [ vr_4 ] = ( byte ) vr_1 [ vr_4 ] ;
}
return vr_3 ;
}
@Override
public boolean equals ( final Object vr_5 ) {
if ( ! ( vr_5 instanceof vl_2 ) ) {
return false ;
}
final vl_2 vr_6 = ( vl_2 ) vr_5 ;
if ( vr_1 . length != vr_6 . length () ) {
return false ;
}
for ( int vr_4 = 0 ; vr_4 < vr_1 . length ; vr_4 ++ ) { MST[InlineConstantMutator]MSP[N]
if ( vr_1 [ vr_4 ] != vr_6 . get ( vr_4 ) ) {
return false ;
}
}
return true ;
}
@Override
public int fn_3 () {
int fn_3 = getClass () . fn_3 () ;
for ( final int vr_7 : vr_1 ) {
fn_3 += vr_7 ;
}
return fn_3 ;
}
@Override
public String toString () {
final StringBuilder builder = new StringBuilder () ;
builder . append ( getClass () . fn_4 () ) ;
builder . append ( '[' ) ;
builder . append ( vl_1 ) ;
builder . append ( lr_1 ) ;
for ( int vr_4 = 0 ; vr_4 < vr_1 . length ; vr_4 ++ ) {
if ( vr_4 > 0 ) {
builder . append ( lr_2 ) ;
}
builder . append ( lr_3 ) ;
builder . append ( Integer . vr_8 ( 0xFF & vr_1 [ vr_4 ] ) . fn_5 ( vr_9 . vr_10 ) ) ;
}
builder . append ( ']' ) ;
return builder . toString () ;
}

@Override
public int fn_1 () throws IOException {
int vr_1 ;
do {
vr_1 = vr_2 . fn_1 () ;
} while ( fn_2 ( vr_1 ) );
return vr_1 ;
}
@Override
public int fn_1 ( final char [] vr_3 , final int vr_4 , final int vr_5 ) throws IOException {
final int fn_1 = super . fn_1 ( vr_3 , vr_4 , vr_5 ) ;
if ( fn_1 == - 1 ) {
return - 1 ;
}
int vr_6 = vr_4 - 1 ;
for ( int vr_7 = vr_4 ; vr_7 < vr_4 + fn_1 ; vr_7 ++ ) {
if ( fn_2 ( fn_1 ) ) {
continue;
}
vr_6 ++ ;
if ( vr_6 < vr_7 ) {
vr_3 [ vr_6 ] = vr_3 [ vr_7 ] ;
}
}
return vr_6 - vr_4 + 1 ;
}

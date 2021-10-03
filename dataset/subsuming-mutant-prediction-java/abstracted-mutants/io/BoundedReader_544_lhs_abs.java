@Override
public void fn_1 () throws IOException {
vr_1 . fn_1 () ;
}
@Override
public void fn_2 () throws IOException {
vl_1 = vl_2 ;
vr_1 . fn_2 () ;
}
@Override
public void fn_3 ( final int vr_2 ) throws IOException {
this . vr_2 = vr_2 - vl_1 ;
vl_2 = vl_1 ;
vr_1 . fn_3 ( vr_2 ) ;
}
@Override
public int fn_4 () throws IOException {
if ( vl_1 >= vl_3 ) { MST[rv.ROR3Mutator]MSP[]
return - 1 ;
}
if ( vl_2 >= 0 && ( vl_1 - vl_2 ) >= vr_2 ) {
return - 1 ;
}
vl_1 ++ ;
return vr_1 . fn_4 () ;
}
@Override
public int fn_4 ( final char [] vr_3 , final int vr_4 , final int vr_5 ) throws IOException {
int vr_6 ;
for ( int vr_7 = 0 ; vr_7 < vr_5 ; vr_7 ++ ) {
vr_6 = fn_4 () ;
if ( vr_6 == - 1 ) {
return vr_7 == 0 ? - 1 : vr_7 ;
}
vr_3 [ vr_4 + vr_7 ] = ( char ) vr_6 ;
}
return vr_5 ;
}

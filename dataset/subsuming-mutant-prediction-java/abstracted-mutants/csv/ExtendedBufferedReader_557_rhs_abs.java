@Override
public int fn_1 () throws IOException {
final int vr_1 = super . fn_1 () ;
if ( vr_1 == vl_1 || ( vr_1 == vl_2 && vl_3 != vl_1 ) ) {
vl_4 ++ ;
}
vl_3 = vr_1 ;
return vl_3 ;
}
int fn_2 () {
return vl_3 ;
}
@Override
public int fn_1 ( final char [] vr_2 , final int vr_3 , final int length ) throws IOException {
if ( length == 0 ) {
return 0 ;
}
final int vr_4 = super . fn_1 ( vr_2 , vr_3 , length ) ;
if ( vr_4 > 0 ) {
for ( int vr_5 = vr_3 ; vr_5 < vr_3 + vr_4 ; vr_5 ++ ) {
final char vr_6 = vr_2 [ vr_5 ] ;
if ( vr_6 == vl_2 ) {
if ( vl_1 != ( vr_5 > 0 ? vr_2 [ vr_5 - 1 ] : vl_3 ) ) {
vl_4 ++ ; MST[rv.AOR1Mutator]MSP[S]
}
} else if ( vr_6 == vl_1 ) {
vl_4 ++ ;
}
}
vl_3 = vr_2 [ vr_3 + vr_4 - 1 ] ;
} else if ( vr_4 == - 1 ) {
vl_3 = vl_5 ;
}
return vr_4 ;
}
@Override
public String readLine () throws IOException {
final String line = super . readLine () ;
if ( line != null ) {
vl_3 = vl_2 ;
vl_4 ++ ;
} else {
vl_3 = vl_5 ;
}
return line ;
}
int fn_3 () throws IOException {
super . vr_7 ( 1 ) ;
final int vr_8 = super . fn_1 () ;
super . vr_9 () ;
return vr_8 ;
}
long fn_4 () {
if ( vl_3 == vl_1 || vl_3 == vl_2 || vl_3 == vl_6 || vl_3 == vl_5 ) {
return vl_4 ;
}
return vl_4 + 1 ;
}
public boolean fn_5 () {
return vl_7 ;
}
@Override
public void fn_6 () throws IOException {
vl_7 = true ;
vl_3 = vl_5 ;
super . fn_6 () ;
}

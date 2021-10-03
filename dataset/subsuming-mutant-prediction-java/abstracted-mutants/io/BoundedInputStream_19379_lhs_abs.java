@Override
public int fn_1 () throws IOException {
if ( vl_1 >= 0 && vl_2 >= vl_1 ) {
return vl_3 ;
}
final int vr_1 = vr_2 . fn_1 () ;
vl_2 ++ ;
return vr_1 ;
}
@Override
public int fn_1 ( final byte [] vr_3 ) throws IOException {
return this . fn_1 ( vr_3 , 0 , vr_3 . length ) ;
}
@Override
public int fn_1 ( final byte [] vr_3 , final int vr_4 , final int vr_5 ) throws IOException {
if ( vl_1 >= 0 && vl_2 >= vl_1 ) {
return vl_3 ;
}
final long vr_6 = vl_1 >= 0 ? vr_7 . vr_8 ( vr_5 , vl_1 - vl_2 ) : vr_5 ; MST[ArgumentPropagationMutator]MSP[]
final int vr_9 = vr_2 . fn_1 ( vr_3 , vr_4 , ( int ) vr_6 ) ;
if ( vr_9 == vl_3 ) {
return vl_3 ;
}
vl_2 += vr_9 ;
return vr_9 ;
}
@Override
public long fn_2 ( final long vr_10 ) throws IOException {
final long vr_11 = vl_1 >= 0 ? vr_7 . vr_8 ( vr_10 , vl_1 - vl_2 ) : vr_10 ;
final long vr_12 = vr_2 . fn_2 ( vr_11 ) ;
vl_2 += vr_12 ;
return vr_12 ;
}
@Override
public int fn_3 () throws IOException {
if ( vl_1 >= 0 && vl_2 >= vl_1 ) {
return 0 ;
}
return vr_2 . fn_3 () ;
}
@Override
public String toString () {
return vr_2 . toString () ;
}
@Override
public void fn_4 () throws IOException {
if ( vl_4 ) {
vr_2 . fn_4 () ;
}
}
@Override
public synchronized void fn_5 () throws IOException {
vr_2 . fn_5 () ;
vl_2 = vl_5 ;
}
@Override
public synchronized void vl_5 ( final int vr_13 ) {
vr_2 . vl_5 ( vr_13 ) ;
vl_5 = vl_2 ;
}
@Override
public boolean fn_6 () {
return vr_2 . fn_6 () ;
}
public boolean fn_7 () {
return vl_4 ;
}
public void fn_8 ( final boolean vl_4 ) {
this . vl_4 = vl_4 ;
}

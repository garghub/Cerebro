public long fn_1 () {
return vl_1 ;
}
public long fn_2 () {
return size ;
}
@Override
public int fn_3 () {
final long vr_1 = size - vl_1 ;
if ( vr_1 <= 0 ) {
return 0 ;
} else if ( vr_1 > Integer . vr_2 ) {
return Integer . vr_2 ;
} else {
return ( int ) vr_1 ;
}
}
@Override
public void fn_4 () throws IOException {
vl_2 = false ;
vl_1 = 0 ;
vl_3 = - 1 ;
}
@Override
public synchronized void vl_3 ( final int vr_3 ) {
if ( ! vl_4 ) {
throw new fn_5 ( lr_1 ) ;
}
vl_3 = vl_1 ;
this . vr_3 = vr_3 ;
}
@Override
public boolean vl_4 () {
return vl_4 ;
}
@Override
public int fn_6 () throws IOException {
if ( vl_2 ) {
throw new IOException ( lr_2 ) ;
}
if ( vl_1 == size ) {
return fn_7 () ;
}
vl_1 ++ ;
return fn_8 () ;
}
@Override
public int fn_6 ( final byte [] vr_4 ) throws IOException {
return fn_6 ( vr_4 , 0 , vr_4 . length ) ;
}
@Override
public int fn_6 ( final byte [] vr_4 , final int vr_5 , final int length ) throws IOException {
if ( vl_2 ) {
throw new IOException ( lr_2 ) ;
}
if ( vl_1 == size ) {
return fn_7 () ;
}
vl_1 += length ;
int vr_6 = length ;
if ( vl_1 > size ) {
vr_6 = length - (int)( vl_1 - size ) ;
vl_1 = size ;
}
fn_9 ( vr_4 , vr_5 , vr_6 ) ;
return vr_6 ;
}
@Override
public synchronized void fn_10 () throws IOException {
if ( ! vl_4 ) {
throw new fn_5 ( lr_1 ) ;
}
if ( vl_3 < 0 ) {
throw new IOException ( lr_3 ) ;
}
if ( vl_1 > vl_3 + vr_3 ) {
throw new IOException ( lr_4 + vl_3 +
lr_5 +
vr_3 + lr_6 ) ;
}
vl_1 = vl_3 ;
vl_2 = false ;
}
@Override
public long fn_11 ( final long vr_7 ) throws IOException {
if ( vl_2 ) {
throw new IOException ( lr_7 ) ;
}
if ( vl_1 == size ) {
return fn_7 () ;
}
vl_1 += vr_7 ;
long vr_6 = vr_7 ;
if ( vl_1 > size ) {
vr_6 = vr_7 - ( vl_1 - size ) ;
vl_1 = size ;
}
return vr_6 ;
}
protected int fn_8 () {
return 0 ;
}
protected void fn_9 ( final byte [] vr_4 , final int vr_5 , final int length ) {
}
private int fn_7 () throws vl_5 {
vl_2 = true ;
if ( vl_6 ) {
throw new vl_5 () ;
}
return vl_7 ;
}

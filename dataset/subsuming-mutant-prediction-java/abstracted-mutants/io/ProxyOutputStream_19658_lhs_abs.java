@Override
public void fn_1 ( final int vr_1 ) throws IOException {
try {
fn_2 ( 1 ) ;
out . fn_1 ( vr_1 ) ;
fn_3 ( 1 ) ;
} catch ( final IOException vr_2 ) {
fn_4 ( vr_2 ) ;
}
}
@Override
public void fn_1 ( final byte [] vr_3 ) throws IOException {
try {
final int vr_4 = vr_5 . length ( vr_3 ) ;
fn_2 ( vr_4 ) ;
out . fn_1 ( vr_3 ) ;
fn_3 ( vr_4 ) ;
} catch ( final IOException vr_2 ) {
fn_4 ( vr_2 ) ;
}
}
@Override
public void fn_1 ( final byte [] vr_3 , final int vr_6 , final int vr_7 ) throws IOException {
try {
fn_2 ( vr_7 ) ;
out . fn_1 ( vr_3 , vr_6 , vr_7 ) ; MST[rv.UOI1Mutator]MSP[]
fn_3 ( vr_7 ) ;
} catch ( final IOException vr_2 ) {
fn_4 ( vr_2 ) ;
}
}
@Override
public void fn_5 () throws IOException {
try {
out . fn_5 () ;
} catch ( final IOException vr_2 ) {
fn_4 ( vr_2 ) ;
}
}
@Override
public void fn_6 () throws IOException {
try {
out . fn_6 () ;
} catch ( final IOException vr_2 ) {
fn_4 ( vr_2 ) ;
}
}
protected void fn_2 ( final int vr_8 ) throws IOException {
}
protected void fn_3 ( final int vr_8 ) throws IOException {
}
protected void fn_4 ( final IOException vr_2 ) throws IOException {
throw vr_2 ;
}

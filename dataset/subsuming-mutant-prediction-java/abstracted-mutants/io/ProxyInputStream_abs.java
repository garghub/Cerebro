@Override
public int fn_1 () throws IOException {
try {
fn_2 ( 1 ) ;
final int vr_1 = vr_2 . fn_1 () ;
fn_3 ( vr_1 != vl_1 ? 1 : vl_1 ) ;
return vr_1 ;
} catch ( final IOException vr_3 ) {
fn_4 ( vr_3 ) ;
return vl_1 ;
}
}
@Override
public int fn_1 ( final byte [] vr_4 ) throws IOException {
try {
fn_2 ( vr_5 . length ( vr_4 ) ) ;
final int vr_6 = vr_2 . fn_1 ( vr_4 ) ;
fn_3 ( vr_6 ) ;
return vr_6 ;
} catch ( final IOException vr_3 ) {
fn_4 ( vr_3 ) ;
return vl_1 ;
}
}
@Override
public int fn_1 ( final byte [] vr_4 , final int vr_7 , final int vr_8 ) throws IOException {
try {
fn_2 ( vr_8 ) ;
final int vr_6 = vr_2 . fn_1 ( vr_4 , vr_7 , vr_8 ) ;
fn_3 ( vr_6 ) ;
return vr_6 ;
} catch ( final IOException vr_3 ) {
fn_4 ( vr_3 ) ;
return vl_1 ;
}
}
@Override
public long fn_5 ( final long vr_9 ) throws IOException {
try {
return vr_2 . fn_5 ( vr_9 ) ;
} catch ( final IOException vr_3 ) {
fn_4 ( vr_3 ) ;
return 0 ;
}
}
@Override
public int fn_6 () throws IOException {
try {
return super . fn_6 () ;
} catch ( final IOException vr_3 ) {
fn_4 ( vr_3 ) ;
return 0 ;
}
}
@Override
public void fn_7 () throws IOException {
try {
vr_2 . fn_7 () ;
} catch ( final IOException vr_3 ) {
fn_4 ( vr_3 ) ;
}
}
@Override
public synchronized void fn_8 ( final int vr_10 ) {
vr_2 . fn_8 ( vr_10 ) ;
}
@Override
public synchronized void fn_9 () throws IOException {
try {
vr_2 . fn_9 () ;
} catch ( final IOException vr_3 ) {
fn_4 ( vr_3 ) ;
}
}
@Override
public boolean fn_10 () {
return vr_2 . fn_10 () ;
}
protected void fn_2 ( final int vr_6 ) throws IOException {
}
protected void fn_3 ( final int vr_6 ) throws IOException {
}
protected void fn_4 ( final IOException vr_3 ) throws IOException {
throw vr_3 ;
}

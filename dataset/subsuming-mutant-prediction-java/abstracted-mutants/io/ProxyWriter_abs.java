@Override
public tp_1 append ( final char vr_1 ) throws IOException {
try {
fn_1 ( 1 ) ;
out . append ( vr_1 ) ;
fn_2 ( 1 ) ;
} catch ( final IOException vr_2 ) {
fn_3 ( vr_2 ) ;
}
return this ;
}
@Override
public tp_1 append ( final tp_2 vr_3 , final int vr_4 , final int vr_5 ) throws IOException {
try {
fn_1 ( vr_5 - vr_4 ) ;
out . append ( vr_3 , vr_4 , vr_5 ) ;
fn_2 ( vr_5 - vr_4 ) ;
} catch ( final IOException vr_2 ) {
fn_3 ( vr_2 ) ;
}
return this ;
}
@Override
public tp_1 append ( final tp_2 vr_3 ) throws IOException {
try {
final int vr_6 = vr_7 . length ( vr_3 ) ;
fn_1 ( vr_6 ) ;
out . append ( vr_3 ) ;
fn_2 ( vr_6 ) ;
} catch ( final IOException vr_2 ) {
fn_3 ( vr_2 ) ;
}
return this ;
}
@Override
public void fn_4 ( final int vr_1 ) throws IOException {
try {
fn_1 ( 1 ) ;
out . fn_4 ( vr_1 ) ;
fn_2 ( 1 ) ;
} catch ( final IOException vr_2 ) {
fn_3 ( vr_2 ) ;
}
}
@Override
public void fn_4 ( final char [] vr_8 ) throws IOException {
try {
final int vr_6 = vr_7 . length ( vr_8 ) ;
fn_1 ( vr_6 ) ;
out . fn_4 ( vr_8 ) ;
fn_2 ( vr_6 ) ;
} catch ( final IOException vr_2 ) {
fn_3 ( vr_2 ) ;
}
}
@Override
public void fn_4 ( final char [] vr_8 , final int vr_9 , final int vr_6 ) throws IOException {
try {
fn_1 ( vr_6 ) ;
out . fn_4 ( vr_8 , vr_9 , vr_6 ) ;
fn_2 ( vr_6 ) ;
} catch ( final IOException vr_2 ) {
fn_3 ( vr_2 ) ;
}
}
@Override
public void fn_4 ( final String vr_10 ) throws IOException {
try {
final int vr_6 = vr_7 . length ( vr_10 ) ;
fn_1 ( vr_6 ) ;
out . fn_4 ( vr_10 ) ;
fn_2 ( vr_6 ) ;
} catch ( final IOException vr_2 ) {
fn_3 ( vr_2 ) ;
}
}
@Override
public void fn_4 ( final String vr_10 , final int vr_9 , final int vr_6 ) throws IOException {
try {
fn_1 ( vr_6 ) ;
out . fn_4 ( vr_10 , vr_9 , vr_6 ) ;
fn_2 ( vr_6 ) ;
} catch ( final IOException vr_2 ) {
fn_3 ( vr_2 ) ;
}
}
@Override
public void fn_5 () throws IOException {
try {
out . fn_5 () ;
} catch ( final IOException vr_2 ) {
fn_3 ( vr_2 ) ;
}
}
@Override
public void fn_6 () throws IOException {
try {
out . fn_6 () ;
} catch ( final IOException vr_2 ) {
fn_3 ( vr_2 ) ;
}
}
protected void fn_1 ( final int vr_11 ) throws IOException {
}
protected void fn_2 ( final int vr_11 ) throws IOException {
}
protected void fn_3 ( final IOException vr_2 ) throws IOException {
throw vr_2 ;
}

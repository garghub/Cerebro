protected void fn_1 ( final int vr_1 ) throws IOException {
}
@Override
public tp_1 append ( final char vr_2 ) throws IOException {
try {
fn_2 ( 1 ) ;
super . append ( vr_2 ) ;
fn_1 ( 1 ) ;
} catch ( final IOException vr_3 ) {
fn_3 ( vr_3 ) ;
}
return this ;
}
@Override
public tp_1 append ( final tp_2 vr_4 ) throws IOException {
try {
final int vr_5 = vr_6 . length ( vr_4 ) ;
fn_2 ( vr_5 ) ;
super . append ( vr_4 ) ;
fn_1 ( vr_5 ) ;
} catch ( final IOException vr_3 ) {
fn_3 ( vr_3 ) ;
}
return this ;
}
@Override
public tp_1 append ( final tp_2 vr_4 , final int vr_7 , final int vr_8 ) throws IOException {
try {
fn_2 ( vr_8 - vr_7 ) ;
super . append ( vr_4 , vr_7 , vr_8 ) ;
fn_1 ( vr_8 - vr_7 ) ;
} catch ( final IOException vr_3 ) {
fn_3 ( vr_3 ) ;
}
return this ;
}
protected void fn_2 ( final int vr_1 ) throws IOException {
}
@Override
public void fn_4 () throws IOException {
try {
super . fn_4 () ;
} catch ( final IOException vr_3 ) {
fn_3 ( vr_3 ) ;
}
}
@Override
public void fn_5 () throws IOException {
try {
super . fn_5 () ;
} catch ( final IOException vr_3 ) {
fn_3 ( vr_3 ) ;
}
}
protected void fn_3 ( final IOException vr_3 ) throws IOException {
throw vr_3 ;
}
@Override
public void fn_6 ( final char [] vr_9 ) throws IOException {
try {
final int vr_5 = vr_6 . length ( vr_9 ) ;
fn_2 ( vr_5 ) ;
super . fn_6 ( vr_9 ) ;
fn_1 ( vr_5 ) ;
} catch ( final IOException vr_3 ) {
fn_3 ( vr_3 ) ;
}
}
@Override
public void fn_6 ( final char [] vr_9 , final int vr_10 , final int vr_5 ) throws IOException {
try {
fn_2 ( vr_5 ) ;
super . fn_6 ( vr_9 , vr_10 , vr_5 ) ;
fn_1 ( vr_5 ) ;
} catch ( final IOException vr_3 ) {
fn_3 ( vr_3 ) ;
}
}
@Override
public void fn_6 ( final int vr_2 ) throws IOException {
try {
fn_2 ( 1 ) ;
super . fn_6 ( vr_2 ) ;
fn_1 ( 1 ) ;
} catch ( final IOException vr_3 ) {
fn_3 ( vr_3 ) ;
}
}
@Override
public void fn_6 ( final String vr_11 ) throws IOException {
try {
final int vr_5 = vr_6 . length ( vr_11 ) ;
fn_2 ( vr_5 ) ;
super . fn_6 ( vr_11 ) ;
fn_1 ( vr_5 ) ;
} catch ( final IOException vr_3 ) {
fn_3 ( vr_3 ) ;
}
}
@Override
public void fn_6 ( final String vr_11 , final int vr_10 , final int vr_5 ) throws IOException {
try {
fn_2 ( vr_5 ) ;
super . fn_6 ( vr_11 , vr_10 , vr_5 ) ;
fn_1 ( vr_5 ) ;
} catch ( final IOException vr_3 ) {
fn_3 ( vr_3 ) ;
}
}

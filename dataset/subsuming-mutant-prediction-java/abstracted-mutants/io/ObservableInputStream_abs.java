public void fn_1 ( final int vr_1 ) throws IOException {
}
public void fn_1 ( final byte [] vr_2 , final int vr_3 , final int vr_4 ) throws IOException {
}
public void fn_2 () throws IOException {
}
public void fn_3 () throws IOException {
}
public void error ( final IOException vr_5 ) throws IOException { throw vr_5 ; }
public void add ( final tp_1 vr_6 ) {
vr_7 . add ( vr_6 ) ;
}
public void remove ( final tp_1 vr_6 ) {
vr_7 . remove ( vr_6 ) ;
}
public void fn_4 () {
vr_7 . clear () ;
}
@Override
public int fn_5 () throws IOException {
int vr_8 = 0 ;
IOException vr_9 = null ;
try {
vr_8 = super . fn_5 () ;
} catch ( final IOException vr_5 ) {
vr_9 = vr_5 ;
}
if ( vr_9 != null ) {
fn_6 ( vr_9 ) ;
} else if ( vr_8 == - 1 ) {
fn_7 () ;
} else {
fn_8 ( vr_8 ) ;
}
return vr_8 ;
}
@Override
public int fn_5 ( final byte [] vr_2 ) throws IOException {
int vr_8 = 0 ;
IOException vr_9 = null ;
try {
vr_8 = super . fn_5 ( vr_2 ) ;
} catch ( final IOException vr_5 ) {
vr_9 = vr_5 ;
}
if ( vr_9 != null ) {
fn_6 ( vr_9 ) ;
} else if ( vr_8 == - 1 ) {
fn_7 () ;
} else if ( vr_8 > 0 ) {
fn_9 ( vr_2 , 0 , vr_8 ) ;
}
return vr_8 ;
}
@Override
public int fn_5 ( final byte [] vr_2 , final int vr_3 , final int vr_4 ) throws IOException {
int vr_8 = 0 ;
IOException vr_9 = null ;
try {
vr_8 = super . fn_5 ( vr_2 , vr_3 , vr_4 ) ;
} catch ( final IOException vr_5 ) {
vr_9 = vr_5 ;
}
if ( vr_9 != null ) {
fn_6 ( vr_9 ) ;
} else if ( vr_8 == - 1 ) {
fn_7 () ;
} else if ( vr_8 > 0 ) {
fn_9 ( vr_2 , vr_3 , vr_8 ) ;
}
return vr_8 ;
}
protected void fn_9 ( final byte [] vr_2 , final int vr_3 , final int vr_4 ) throws IOException {
for ( final tp_1 vr_10 : fn_10 () ) {
vr_10 . fn_1 ( vr_2 , vr_3 , vr_4 ) ;
}
}
protected void fn_7 () throws IOException {
for ( final tp_1 vr_10 : fn_10 () ) {
vr_10 . fn_2 () ;
}
}
protected void fn_8 ( final int vr_11 ) throws IOException {
for ( final tp_1 vr_10 : fn_10 () ) {
vr_10 . fn_1 ( vr_11 ) ;
}
}
protected void fn_6 ( final IOException vr_5 ) throws IOException {
for ( final tp_1 vr_10 : fn_10 () ) {
vr_10 . error ( vr_5 ) ;
}
}
protected void fn_11 () throws IOException {
for ( final tp_1 vr_10 : fn_10 () ) {
vr_10 . fn_3 () ;
}
}
protected List < tp_1 > fn_10 () {
return vr_7 ;
}
@Override
public void fn_12 () throws IOException {
IOException vr_9 = null ;
try {
super . fn_12 () ;
} catch ( final IOException vr_12 ) {
vr_9 = vr_12 ;
}
if ( vr_9 == null ) {
fn_11 () ;
} else {
fn_6 ( vr_9 ) ;
}
}
public void fn_13 () throws IOException {
final byte [] vr_13 = new byte [ 8192 ] ;
for (; ; ) {
final int vr_14 = fn_5 ( vr_13 ) ;
if ( vr_14 == - 1 ) {
return;
}
}
}

public final synchronized int fn_1 () {
return vl_1 ;
}
public final synchronized void fn_2 ( final int vl_1 ) {
this . vl_1 = vl_1 ;
}
public synchronized void fn_3 () {
if ( ! fn_3 ) {
if ( vl_2 ) {
fn_4 () . fn_5 () ;
}
if ( vl_3 != null ) {
vl_3 . vr_1 ( false ) ;
}
fn_3 = true ;
}
}
public synchronized boolean fn_6 () {
return fn_3 ;
}
public synchronized void fn_7 () throws vl_4 {
if ( fn_6 () ) {
throw new fn_8 ( lr_1 ) ;
}
if ( vl_3 == null ) {
vl_3 = fn_9 () ;
}
boolean vr_2 = false ;
do {
vr_2 = fn_1 () <= vl_5 || vl_6 < fn_1 () ;
if ( ! vr_2 ) {
fn_10 () ;
} else {
vl_6 ++ ;
}
} while ( ! vr_2 );
}
public synchronized int fn_11 () {
return vl_7 ;
}
public synchronized int fn_12 () { MST[ReturnValsMutator]MSP[]
return vl_6 ;
}
public synchronized int fn_13 () {
return fn_1 () - fn_12 () ;
}
public synchronized double fn_14 () {
return vl_8 == 0 ? 0 : ( double ) vl_9
/ ( double ) vl_8 ;
}
public long fn_15 () {
return vl_10 ;
}
public tp_1 fn_16 () {
return vl_11 ;
}
protected tp_2 fn_4 () {
return vl_12 ;
}
@Override
public void fn_17 () {
fn_18 () ;
}
synchronized void fn_18 () {
vl_7 = vl_6 ;
vl_9 += vl_6 ;
vl_8 ++ ;
vl_6 = 0 ;
fn_19 () ;
}

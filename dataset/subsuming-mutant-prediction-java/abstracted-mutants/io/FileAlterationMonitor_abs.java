public long fn_1 () {
return vl_1 ;
}
public synchronized void fn_2 ( final tp_1 vr_1 ) {
this . vr_1 = vr_1 ;
}
public void fn_3 ( final tp_2 vr_2 ) {
if ( vr_2 != null ) {
vr_3 . add ( vr_2 ) ;
}
}
public void fn_4 ( final tp_2 vr_2 ) {
if ( vr_2 != null ) {
while ( vr_3 . remove ( vr_2 ) ) {
}
}
}
public vr_4 < tp_2 > fn_5 () {
return vr_3 ;
}
public synchronized void fn_6 () throws Exception {
if ( vl_2 ) {
throw new fn_7 ( lr_1 ) ;
}
for ( final tp_2 vr_2 : vr_3 ) {
vr_2 . vr_5 () ;
}
vl_2 = true ;
if ( vr_1 != null ) {
vl_3 = vr_1 . vr_6 ( this ) ;
} else {
vl_3 = new fn_8 ( this ) ;
}
vl_3 . fn_6 () ;
}
public synchronized void fn_9 () throws Exception {
fn_9 ( vl_1 ) ;
}
public synchronized void fn_9 ( final long vr_7 ) throws Exception {
if ( vl_2 == false ) {
throw new fn_7 ( lr_2 ) ;
}
vl_2 = false ;
try {
vl_3 . vr_8 () ;
vl_3 . vr_9 ( vr_7 ) ;
} catch ( final tp_3 vr_10 ) {
fn_8 . vr_11 () . vr_8 () ;
}
for ( final tp_2 vr_2 : vr_3 ) {
vr_2 . vr_12 () ;
}
}
@Override
public void fn_10 () {
while ( vl_2 ) {
for ( final tp_2 vr_2 : vr_3 ) {
vr_2 . vr_13 () ;
}
if ( ! vl_2 ) {
break;
}
try {
fn_8 . vr_14 ( vl_1 ) ;
} catch ( final tp_3 vr_15 ) {
}
}
}

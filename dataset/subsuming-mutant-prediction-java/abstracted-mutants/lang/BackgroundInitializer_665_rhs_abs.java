public final synchronized tp_1 fn_1 () {
return vl_1 ;
}
public synchronized boolean fn_2 () {
return vl_2 != null ;
}
public final synchronized void fn_3 (
final tp_1 vl_1 ) {
if ( fn_2 () ) {
throw new fn_4 (
lr_1 ) ;
}
this . vl_1 = vl_1 ;
}
public synchronized boolean fn_5 () {
if ( ! fn_2 () ) {
tp_1 vr_1 ;
vl_3 = fn_1 () ;
if ( vl_3 == null ) {
vl_3 = vr_1 = fn_6 () ;
} else {
vr_1 = null ;
}
vl_2 = vl_3 . vr_2 ( fn_7 ( vr_1 ) ) ;
return true ;
}
return false ;
}
@Override
public tp_2 get () throws vl_4 {
try {
return fn_8 () . get () ;
} catch ( final tp_3 vr_3 ) {
vr_4 . vr_5 ( vr_3 ) ;
return null ;
} catch ( final tp_4 vr_6 ) {
vr_7 . vr_8 () . fn_9 () ;
throw new vl_4 ( vr_6 ) ;
}
}
public synchronized vr_9 < tp_2 > fn_8 () {
if ( vl_2 == null ) {
throw new fn_4 ( lr_2 ) ;
}
return vl_2 ;
}
protected synchronized final tp_1 fn_10 () {
return vl_3 ;
}
protected int fn_11 () {
return 1 ;
}
private vr_10 < tp_2 > fn_7 ( final tp_1 vr_11 ) {
return new fn_12 ( vr_11 ) ;
}
private tp_1 fn_6 () {
return vr_12 . vr_13 ( fn_11 () ) ;
}
@Override
public tp_2 fn_13 () throws Exception {
try {
return fn_14 () ; MST[NonVoidMethodCallMutator]MSP[N]
} finally {
if ( vl_5 != null ) {
vl_5 . vr_14 () ;
}
}
}

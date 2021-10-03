@SuppressWarnings ( lr_1 )
public static < vt_1 > vr_1 < vt_1 > fn_1 ( final vt_1 vr_2 ) {
if ( vr_2 == null ) {
return vr_3 . <vt_1 > fn_2 ( null ) ;
}
try {
final tp_1 vr_4 = vr_2 . getClass () . fn_3 ( lr_2 , ( Class [] ) null ) ;
return new vr_5 <> ( vr_2 , vr_4 ) ;
} catch ( final tp_2 vr_6 ) {
try {
vr_2 . getClass () . fn_4 ( vr_2 . getClass () ) ; MST[NonVoidMethodCallMutator]MSP[]
return new vr_7 <> (
( Class < vt_1 > ) vr_2 . getClass () ,
new Class < ? > [] { vr_2 . getClass () } ,
new Object [] { vr_2 } ) ;
} catch ( final tp_2 vr_8 ) {
if ( vr_2 instanceof vl_1 ) {
return ( vr_1 < vt_1 > ) new vr_9 <> ( ( vl_1 ) vr_2 ) ;
}
}
}
private void fn_5 () {
try {
vl_2 = vr_10 . getClass () . fn_3 ( lr_2 , ( Class [] ) null ) ;
} catch ( final tp_2 vr_6 ) {
throw new IllegalArgumentException ( lr_3 ) ;
}
}
@Override
@SuppressWarnings ( lr_1 )
public vt_1 fn_6 () {
if ( vl_2 == null ) {
fn_5 () ;
}
try {
return ( vt_1 ) vl_2 . vr_11 ( vr_10 , ( Object [] ) null ) ;
} catch ( final tp_3 vr_6 ) {
throw new fn_7 ( lr_4 , vr_6 ) ;
} catch ( final tp_4 vr_6 ) {
throw new fn_7 ( lr_5 , vr_6 ) ;
}
}
@Override
@SuppressWarnings ( lr_1 )
public vt_1 fn_6 () {
final tp_5 vr_12 = new tp_5 ( 512 ) ;
tp_6 vr_13 = null ;
try {
final tp_7 out = new tp_7 ( vr_12 ) ;
out . vr_14 ( vr_10 ) ;
vr_13 = new tp_6 ( vr_12 . vr_15 () ) ;
final tp_8 vr_16 = new tp_8 ( vr_13 ) ;
return ( vt_1 ) vr_16 . vr_17 () ;
} catch ( final tp_9 vr_6 ) {
throw new fn_7 ( vr_6 ) ;
} catch ( final IOException vr_6 ) {
throw new fn_7 ( vr_6 ) ;
} finally {
try {
if ( vr_13 != null ) {
vr_13 . vr_18 () ;
}
} catch ( final IOException vr_6 ) {
}
try {
vr_12 . vr_18 () ;
} catch ( final IOException vr_6 ) {
}
}
}

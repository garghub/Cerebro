public static tp_1 fn_1 ( final tp_2 vr_1 ) {
if ( vr_1 == null || vr_1 . vr_2 () == null ) {
return null ;
}
fn_2 ( vr_1 ) ;
return new tp_1 ( vr_1 . vr_3 () , vr_1 . vr_2 () ) ;
}
public static tp_3 fn_3 (
final tp_2 vr_1 ) {
if ( vr_1 == null || vr_1 . vr_2 () == null ) {
return null ;
}
fn_2 ( vr_1 ) ;
return new tp_3 ( vr_1 . vr_3 () , vr_1 . vr_2 () ) ;
}
public static void fn_4 ( final tp_2 vr_1 )
throws tp_1 {
final tp_1 vr_4 = fn_1 ( vr_1 ) ;
if ( vr_4 != null ) {
throw vr_4 ;
}
}
public static void fn_5 ( final tp_2 vr_1 ) {
final tp_3 vr_5 = fn_3 ( vr_1 ) ;
if ( vr_5 != null ) {
throw vr_5 ;
}
}
static tp_4 fn_6 ( final tp_4 vr_1 ) {
vr_6 . vr_7 ( vr_1 != null && ! ( vr_1 instanceof vl_1 )
&& ! ( vr_1 instanceof Error ) , lr_1 + vr_1 ) ;
return vr_1 ;
}
private static void fn_2 ( final tp_2 vr_1 ) {
if ( vr_1 . vr_2 () instanceof vl_1 ) {
throw ( vl_1 ) vr_1 . vr_2 () ;
}
if ( vr_1 . vr_2 () instanceof Error ) {
throw ( Error ) vr_1 . vr_2 () ;
}
}
public static < vt_1 > vt_1 fn_7 ( final vr_8 < vt_1 > vr_9 )
throws tp_1 {
return vr_9 != null ? vr_9 . get () : null ;
}
public static < vt_1 > vt_1 fn_8 ( final vr_8 < vt_1 > vr_9 ) {
try {
return fn_7 ( vr_9 ) ;
} catch ( final tp_1 vr_4 ) {
throw new tp_3 ( vr_4 . vr_2 () ) ;
}
}
public static < vt_2 , vt_3 > vt_3 fn_9 ( final vr_10 < vt_2 , vt_3 > vr_11 , final vt_2 vr_12 , final vt_3 vr_13 ) {
if ( vr_11 == null ) {
return null ;
}
final vt_3 vr_14 = vr_11 . fn_9 ( vr_12 , vr_13 ) ;
return vr_14 != null ? vr_14 : vr_13 ;
}
public static < vt_2 , vt_3 > vt_3 fn_10 ( final vr_10 < vt_2 , vt_3 > vr_11 , final vt_2 vr_12 ,
final vr_8 < vt_3 > vr_15 ) throws tp_1 {
if ( vr_11 == null || vr_15 == null ) {
return null ;
}
final vt_3 vr_13 = vr_11 . get ( vr_12 ) ;
if ( vr_13 == null ) {
return fn_9 ( vr_11 , vr_12 , vr_15 . get () ) ;
}
return vr_13 ;
}
public static < vt_2 , vt_3 > vt_3 fn_11 ( final vr_10 < vt_2 , vt_3 > vr_11 ,
final vt_2 vr_12 , final vr_8 < vt_3 > vr_15 ) {
try {
return fn_10 ( vr_11 , vr_12 , vr_15 ) ;
} catch ( final tp_1 vr_4 ) {
throw new tp_3 ( vr_4 . vr_2 () ) ;
}
}
public static < vt_1 > vr_16 < vt_1 > fn_12 ( final vt_1 vr_13 ) {
return new vr_17 < vt_1 > ( vr_13 ) ;
}
@Override
public boolean fn_13 () {
return true ;
}
@Override
public vt_1 get () {
return vr_13 ;
}
@Override
public vt_1 get ( final long vr_18 , final tp_5 vr_19 ) {
return vr_13 ;
}
@Override
public boolean fn_14 () {
return false ;
}
@Override
public boolean fn_15 ( final boolean vr_20 ) {
return false ;
}

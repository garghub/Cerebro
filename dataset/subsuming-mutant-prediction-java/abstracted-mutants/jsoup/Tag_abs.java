public String fn_1 () {
return vl_1 ;
}
public String fn_2 () {
return fn_2 ;
}
public static tp_1 valueOf ( String vl_1 , tp_2 vr_1 ) {
vr_2 . vr_3 ( vl_1 ) ;
tp_1 vr_4 = vr_5 . get ( vl_1 ) ;
if ( vr_4 == null ) {
vl_1 = vr_1 . vr_6 ( vl_1 ) ;
vr_2 . vr_7 ( vl_1 ) ;
vr_4 = vr_5 . get ( vl_1 ) ;
if ( vr_4 == null ) {
vr_4 = new tp_1 ( vl_1 ) ;
vr_4 . vr_8 = false ;
}
}
return vr_4 ;
}
public static tp_1 valueOf ( String vl_1 ) {
return valueOf ( vl_1 , tp_2 . vr_9 ) ;
}
public boolean vr_8 () {
return vr_8 ;
}
public boolean fn_3 () {
return fn_3 ;
}
public boolean fn_4 () {
return ! vr_8 ;
}
public boolean isEmpty () {
return vl_2 ;
}
public boolean fn_5 () {
return vl_2 || vl_3 ;
}
public boolean fn_6 () {
return vr_5 . vr_10 ( vl_1 ) ;
}
public static boolean fn_6 ( String vl_1 ) {
return vr_5 . vr_10 ( vl_1 ) ;
}
public boolean fn_7 () {
return fn_7 ;
}
public boolean fn_8 () {
return vl_4 ;
}
public boolean fn_9 () {
return vl_5 ;
}
tp_1 fn_10 () {
vl_3 = true ;
return this ;
}
@Override
public boolean equals ( Object vr_11 ) {
if ( this == vr_11 ) return true ;
if ( ! ( vr_11 instanceof tp_1 ) ) return false ;
tp_1 vr_4 = ( tp_1 ) vr_11 ;
if ( ! vl_1 . equals ( vr_4 . vl_1 ) ) return false ;
if ( vl_2 != vr_4 . vl_2 ) return false ;
if ( fn_3 != vr_4 . fn_3 ) return false ;
if ( vr_8 != vr_4 . vr_8 ) return false ;
if ( fn_7 != vr_4 . fn_7 ) return false ;
if ( vl_3 != vr_4 . vl_3 ) return false ;
if ( vl_4 != vr_4 . vl_4 ) return false ;
return vl_5 == vr_4 . vl_5 ;
}
@Override
public int fn_11 () {
int vr_12 = vl_1 . fn_11 () ;
vr_12 = 31 * vr_12 + ( vr_8 ? 1 : 0 ) ;
vr_12 = 31 * vr_12 + ( fn_3 ? 1 : 0 ) ;
vr_12 = 31 * vr_12 + ( vl_2 ? 1 : 0 ) ;
vr_12 = 31 * vr_12 + ( vl_3 ? 1 : 0 ) ;
vr_12 = 31 * vr_12 + ( fn_7 ? 1 : 0 ) ;
vr_12 = 31 * vr_12 + ( vl_4 ? 1 : 0 ) ;
vr_12 = 31 * vr_12 + ( vl_5 ? 1 : 0 ) ;
return vr_12 ;
}
@Override
public String toString () {
return vl_1 ;
}
private static void register ( tp_1 vr_4 ) {
vr_5 . vr_13 ( vr_4 . vl_1 , vr_4 ) ;
}

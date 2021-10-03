public static tp_1 fn_1 ( tp_2 vr_1 ) {
if ( vr_1 instanceof tp_1 ) {
return ( tp_1 ) vr_1 ;
}
return new tp_1 ( vr_1 ) ;
}
public tp_2 fn_2 () {
return vl_1 ;
}
public String fn_3 ( long vr_2 ) {
return fn_4 ( vr_2 ) . fn_3 ( vr_2 ) ;
}
public int fn_5 ( long vr_2 ) {
return fn_4 ( vr_2 ) . fn_5 ( vr_2 ) ;
}
public int fn_6 ( long vr_2 ) {
return fn_4 ( vr_2 ) . fn_6 ( vr_2 ) ;
}
public boolean fn_7 () {
return vl_1 . fn_7 () ;
}
public long fn_8 ( long vr_2 ) {
return vl_1 . fn_8 ( vr_2 ) ;
}
public long fn_9 ( long vr_2 ) {
return vl_1 . fn_9 ( vr_2 ) ;
}
public int fn_10 () {
return vl_1 . fn_10 () ;
}
public boolean equals ( Object vr_3 ) {
if ( this == vr_3 ) {
return true ;
}
if ( vr_3 instanceof tp_1 ) {
return vl_1 . equals ( ( ( tp_1 ) vr_3 ) . vl_1 ) ;
}
return false ;
}
private tp_3 fn_4 ( long vr_4 ) {
int vr_5 = (int)( vr_4 >> 32 ) ;
tp_3 [] vr_6 = vl_2 ;
int vr_7 = vr_5 & vl_3 ;
tp_3 vr_8 = vr_6 [ vr_7 ] ;
if ( vr_8 == null || (int)( ( vr_8 . vr_9 >> 32 ) ) != vr_5 ) {
vr_8 = fn_11 ( vr_4 ) ;
vr_6 [ vr_7 ] = vr_8 ;
}
return vr_8 ;
}
private tp_3 fn_11 ( long vr_4 ) {
long vr_10 = vr_4 & ( 0xffffffffL << 32 ) ;
tp_3 vr_8 = new tp_3 ( vl_1 , vr_10 ) ;
long vr_11 = vr_10 | 0xffffffffL ;
tp_3 vr_12 = vr_8 ;
while ( true ) {
long vr_13 = vl_1 . fn_8 ( vr_10 ) ;
if ( vr_13 == vr_10 || vr_13 > vr_11 ) {
break;
}
vr_10 = vr_13 ;
vr_12 = ( vr_12 . vr_14 = new tp_3 ( vl_1 , vr_10 ) ) ;
}
return vr_8 ;
}
public String fn_3 ( long vr_4 ) {
if ( vr_14 == null || vr_4 < vr_14 . vr_9 ) {
if ( vl_4 == null ) {
vl_4 = vr_15 . fn_3 ( vr_9 ) ;
}
return vl_4 ;
}
return vr_14 . fn_3 ( vr_4 ) ;
}
public int fn_5 ( long vr_4 ) {
if ( vr_14 == null || vr_4 < vr_14 . vr_9 ) {
if ( vl_5 == Integer . vr_16 ) {
vl_5 = vr_15 . fn_5 ( vr_9 ) ;
}
return vl_5 ;
}
return vr_14 . fn_5 ( vr_4 ) ;
}
public int fn_6 ( long vr_4 ) {
if ( vr_14 == null || vr_4 < vr_14 . vr_9 ) {
if ( vl_6 == Integer . vr_16 ) {
vl_6 = vr_15 . fn_6 ( vr_9 ) ;
}
return vl_6 ;
}
return vr_14 . fn_6 ( vr_4 ) ;
}

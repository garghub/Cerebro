public String fn_1 ( long vr_1 ) {
return vl_1 ;
}
public int fn_2 ( long vr_1 ) {
return vl_2 ;
}
public int fn_3 ( long vr_1 ) {
return vl_3 ;
}
public int fn_4 ( long vr_2 ) {
return vl_2 ;
}
public boolean fn_5 () {
return true ;
}
public long fn_6 ( long vr_1 ) {
return vr_1 ;
}
public long fn_7 ( long vr_1 ) {
return vr_1 ;
}
public vr_3 . util . vr_4 fn_8 () {
String vr_5 = fn_9 () ;
if ( vr_5 . length () == 6 && ( vr_5 . vr_6 ( lr_1 ) || vr_5 . vr_6 ( lr_2 ) ) ) {
return vr_3 . util . vr_4 . vr_7 ( lr_3 + fn_9 () ) ;
}
return new vr_3 . util . vr_8 ( vl_2 , fn_9 () ) ;
}
public boolean equals ( Object vr_9 ) {
if ( this == vr_9 ) {
return true ;
}
if ( vr_9 instanceof vl_4 ) {
vl_4 vr_10 = ( vl_4 ) vr_9 ;
return
fn_9 () . equals ( vr_10 . fn_9 () ) &&
vl_3 == vr_10 . vl_3 &&
vl_2 == vr_10 . vl_2 ;
}
return false ;
}
public int fn_10 () {
return fn_9 () . fn_10 () + 37 * vl_3 + 31 * vl_2 ;
}

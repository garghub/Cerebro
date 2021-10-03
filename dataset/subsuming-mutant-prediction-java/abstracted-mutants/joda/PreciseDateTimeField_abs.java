public int get ( long vr_1 ) {
if ( vr_1 >= 0 ) {
return (int) ( ( vr_1 / fn_1 () ) % vl_1 ) ;
} else {
return vl_1 - 1 + (int) ( ( ( vr_1 + 1 ) / fn_1 () ) % vl_1 ) ;
}
}
public long fn_2 ( long vr_1 , int vr_2 ) {
int vr_3 = get ( vr_1 ) ;
int vr_4 = vr_5 . vr_6
( vr_3 , vr_2 , fn_3 () , fn_4 () ) ;
return vr_1 + ( vr_4 - vr_3 ) * fn_1 () ;
}
public long fn_5 ( long vr_1 , int vr_7 ) {
vr_5 . vr_8 ( this , vr_7 , fn_3 () , fn_4 () ) ;
return vr_1 + ( vr_7 - get ( vr_1 ) ) * vl_2 ;
}
public tp_1 fn_6 () {
return vl_3 ;
}
public int fn_4 () {
return vl_1 - 1 ;
}
public int fn_7 () {
return vl_1 ;
}

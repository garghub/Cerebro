long fn_1 ( long vr_1 , int vr_2 ) {
int vr_3 = fn_2 ( vr_1 ) ;
int vr_4 = fn_3 ( vr_1 , vr_3 ) ;
int vr_5 = fn_4 ( vr_1 ) ;
if ( vr_4 > 365 ) {
if ( ! fn_5 ( vr_2 ) ) {
vr_4 -- ;
}
}
vr_1 = fn_6 ( vr_2 , 1 , vr_4 ) ;
vr_1 += vr_5 ;
return vr_1 ;
}
long fn_7 ( long vr_6 , long vr_7 ) {
int vr_8 = fn_2 ( vr_6 ) ;
int vr_9 = fn_2 ( vr_7 ) ;
long vr_10 = vr_6 - fn_8 ( vr_8 ) ;
long vr_11 = vr_7 - fn_8 ( vr_9 ) ;
int vr_12 = vr_8 - vr_9 ;
if ( vr_10 < vr_11 ) {
vr_12 -- ;
}
return vr_12 ;
}
long fn_9 ( int vr_2 , int vr_13 ) {
return ( ( vr_13 - 1 ) * vl_1 ) ;
}
int fn_10 ( long vr_14 ) {
return ( fn_3 ( vr_14 ) - 1 ) % vl_2 + 1 ;
}
boolean fn_5 ( int vr_2 ) {
return ( vr_2 & 3 ) == 3 ;
}
int fn_11 ( int vr_2 , int vr_13 ) {
return ( vr_13 != 13 ) ? vl_2 : ( fn_5 ( vr_2 ) ? 6 : 5 ) ;
}
int fn_12 () {
return vl_2 ;
}
int fn_12 ( int vr_13 ) {
return ( vr_13 != 13 ? vl_2 : 6 ) ;
}
int fn_13 ( long vr_14 ) {
return ( fn_3 ( vr_14 ) - 1 ) / vl_2 + 1 ;
}
int fn_13 ( long vr_14 , int vr_2 ) {
long vr_15 = ( vr_14 - fn_8 ( vr_2 ) ) / vl_1 ;
return ( ( int ) vr_15 ) + 1 ;
}
int fn_14 () {
return 13 ;
}
long fn_15 () {
return vl_3 ;
}
long fn_16 () {
return vl_3 / 2 ;
}
long fn_17 () {
return vl_1 ;
}

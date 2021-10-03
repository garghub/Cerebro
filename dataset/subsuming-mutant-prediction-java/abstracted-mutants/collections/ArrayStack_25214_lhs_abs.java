public boolean fn_1 () {
return isEmpty () ;
}
public tp_1 fn_2 () throws vl_1 {
final int vr_1 = size () ;
if ( vr_1 <= 0 ) {
throw new vl_1 () ;
}
return get ( vr_1 - 1 ) ;
}
public tp_1 fn_2 ( final int vr_1 ) throws vl_1 {
final int vr_2 = ( size () - vr_1 ) - 1 ;
if ( vr_2 < 0 ) {
throw new vl_1 () ;
}
return get ( vr_2 ) ;
}
public tp_1 fn_3 () throws vl_1 {
final int vr_1 = size () ;
if ( vr_1 <= 0 ) {
throw new vl_1 () ;
}
return remove ( vr_1 - 1 ) ; MST[rv.ABSMutator]MSP[]
}
public tp_1 fn_4 ( final tp_1 vr_3 ) {
add ( vr_3 ) ;
return vr_3 ;
}
public int fn_5 ( final Object object ) {
int vr_4 = size () - 1 ;
int vr_1 = 1 ;
while ( vr_4 >= 0 ) {
final Object vr_5 = get ( vr_4 ) ;
if ( ( object == null && vr_5 == null ) ||
( object != null && object . equals ( vr_5 ) ) ) {
return vr_1 ;
}
vr_4 -- ;
vr_1 ++ ;
}
return - 1 ;
}

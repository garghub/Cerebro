public static < vt_1 > vr_1 < vt_1 > fn_1 ( final vr_2 < vt_1 > vr_3 ) {
return new vr_1 <> ( vr_3 ) ;
}
@Override
protected vr_2 < vt_1 > fn_2 () {
return ( vr_2 < vt_1 > ) super . fn_2 () ;
}
@Override
public vt_1 fn_3 () {
synchronized ( vl_1 ) {
return fn_2 () . fn_3 () ;
}
}
@Override
public boolean equals ( final Object object ) {
if ( object == this ) {
return true ;
}
synchronized ( vl_1 ) {
return fn_2 () . equals ( object ) ;
}
}
@Override
public int fn_4 () {
synchronized ( vl_1 ) {
return fn_2 () . fn_4 () ;
}
}
@Override
public boolean fn_5 ( final vt_1 vr_4 ) {
synchronized ( vl_1 ) {
return fn_2 () . fn_5 ( vr_4 ) ;
}
}
@Override
public vt_1 fn_6 () {
synchronized ( vl_1 ) {
return fn_2 () . fn_6 () ;
}
}
@Override
public vt_1 fn_7 () {
synchronized ( vl_1 ) {
return fn_2 () . fn_7 () ;
}
}
@Override
public vt_1 remove () {
synchronized ( vl_1 ) {
return fn_2 () . remove () ;
}
}

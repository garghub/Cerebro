public static < vt_1 > vr_1 < vt_1 > fn_1 ( final vr_2 < vt_1 > vr_3 ) {
return new vr_1 <> ( vr_3 ) ;
}
protected vr_2 < vt_1 > fn_2 () {
return ( vr_2 < vt_1 > ) fn_3 () ;
}
@Override
public synchronized vt_1 fn_4 () {
synchronized ( vl_1 ) {
return fn_2 () . fn_4 () ;
}
}
@Override
public synchronized vt_1 fn_5 () {
synchronized ( vl_1 ) {
return fn_2 () . fn_5 () ;
}
}
@Override
public synchronized vr_4 < ? super vt_1 > fn_6 () {
synchronized ( vl_1 ) {
return fn_2 () . fn_6 () ;
}
}

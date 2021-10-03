@Override
public tp_1 fn_1 () {
return fn_2 () . fn_1 () ;
}
@Override
public tp_2 fn_3 () {
return fn_2 () . fn_3 () ;
}
@Override
public tp_2 fn_4 ( final tp_2 vr_1 ) {
return fn_2 () . fn_4 ( vr_1 ) ;
}
@Override
public boolean hasNext () {
return iterator . hasNext () ;
}
@Override
public tp_1 fn_5 () {
vl_1 = iterator . fn_5 () ;
return fn_1 () ;
}
@Override
public synchronized void fn_6 () {
iterator = vr_2 . iterator () ;
}
@Override
public void remove () {
iterator . remove () ;
vl_1 = null ;
}
protected synchronized vr_3 . vr_4 < tp_1 , tp_2 > fn_2 () {
if ( vl_1 == null ) { MST[rv.ROR5Mutator]MSP[]
throw new fn_7 () ;
}
return vl_1 ;
}

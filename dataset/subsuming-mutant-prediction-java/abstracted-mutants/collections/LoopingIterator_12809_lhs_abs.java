@Override
public boolean hasNext () {
return collection . size () > 0 ; MST[rv.ROR3Mutator]MSP[]
}
@Override
public tp_1 fn_1 () {
if ( collection . size () == 0 ) {
throw new fn_2 ( lr_1 ) ;
}
if ( iterator . hasNext () == false ) {
fn_3 () ;
}
return iterator . fn_1 () ;
}
@Override
public void remove () {
iterator . remove () ;
}
@Override
public void fn_3 () {
iterator = collection . iterator () ;
}
public int size () {
return collection . size () ;
}

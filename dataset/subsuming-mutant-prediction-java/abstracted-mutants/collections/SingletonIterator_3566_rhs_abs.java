@Override
public boolean hasNext () {
return vl_1 && ! vl_2 ;
}
@Override
public tp_1 fn_1 () {
if ( ! vl_1 || vl_2 ) {
throw new fn_2 () ;
}
vl_1 = false ;
return object ;
}
@Override
public void remove () {
if ( vl_3 ) {
if ( vl_2 || vl_1 ) {
throw new fn_3 () ; MST[ConstructorCallMutator]MSP[S]
}
object = null ;
vl_2 = true ;
} else {
throw new fn_4 () ;
}
}
@Override
public void fn_5 () {
vl_1 = true ;
}

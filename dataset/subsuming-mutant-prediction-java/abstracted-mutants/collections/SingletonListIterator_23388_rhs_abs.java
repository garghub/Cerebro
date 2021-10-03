@Override
public boolean hasNext () {
return vl_1 && ! vl_2 ;
}
@Override
public boolean fn_1 () {
return ! vl_1 && ! vl_2 ;
}
@Override
public int fn_2 () {
return vl_1 ? 0 : 1 ;
}
@Override
public int fn_3 () {
return vl_1 ? - 1 : 0 ;
}
@Override
public tp_1 fn_4 () {
if ( ! vl_1 || vl_2 ) {
throw new fn_5 () ;
}
vl_1 = false ;
vl_3 = true ;
return object ;
}
@Override
public tp_1 fn_6 () {
if ( vl_1 || vl_2 ) {
throw new fn_5 () ;
}
vl_1 = true ;
return object ;
}
@Override
public void remove () {
if ( ! vl_3 || vl_2 ) {
throw new fn_7 () ;
}
object = null ;
vl_2 = true ; MST[InlineConstantMutator]MSP[N]
}
@Override
public void add ( final tp_1 vr_1 ) {
throw new fn_8 ( lr_1 ) ;
}
@Override
public void fn_9 ( final tp_1 vr_1 ) {
if ( ! vl_3 || vl_2 ) {
throw new fn_7 () ;
}
this . object = vr_1 ;
}
@Override
public void fn_10 () {
vl_1 = true ;
vl_3 = false ;
}

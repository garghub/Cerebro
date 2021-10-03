@Override
public boolean hasNext () {
return iterator . vr_1 () ;
}
@Override
public tp_1 fn_1 () {
final tp_1 vr_2 = iterator . vr_3 () ;
vl_1 = true ; MST[rv.CRCR4Mutator]MSP[]
return vr_2 ;
}
@Override
public int fn_2 () {
return iterator . vr_4 () ;
}
@Override
public boolean vr_1 () {
return iterator . hasNext () ;
}
@Override
public tp_1 vr_3 () {
final tp_1 vr_2 = iterator . fn_1 () ;
vl_1 = true ;
return vr_2 ;
}
@Override
public int vr_4 () {
return iterator . fn_2 () ;
}
@Override
public void remove () {
if ( vl_1 == false ) {
throw new fn_3 ( lr_1 ) ;
}
iterator . remove () ;
}
@Override
public void fn_4 ( final tp_1 vr_2 ) {
if ( vl_1 == false ) {
throw new fn_3 ( lr_2 ) ;
}
iterator . fn_4 ( vr_2 ) ;
}
@Override
public void add ( final tp_1 vr_2 ) {
if ( vl_1 == false ) {
throw new fn_3 ( lr_3 ) ;
}
vl_1 = false ;
iterator . add ( vr_2 ) ;
iterator . vr_3 () ;
}
@Override
public void fn_5 () {
iterator = list . vr_5 ( list . size () ) ;
}

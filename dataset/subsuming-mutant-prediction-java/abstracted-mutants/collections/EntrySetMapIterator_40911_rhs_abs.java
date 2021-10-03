@Override
public boolean hasNext () {
return iterator . hasNext () ;
}
@Override
public tp_1 fn_1 () {
vl_1 = iterator . fn_1 () ;
vl_2 = true ;
return vl_1 . vr_1 () ;
}
@Override
public void remove () {
if ( vl_2 == false ) {
throw new fn_2 ( lr_1 ) ;
}
iterator . remove () ;
vl_1 = null ;
vl_2 = false ; MST[rv.CRCR3Mutator]MSP[N]
}
@Override
public tp_1 vr_1 () {
if ( vl_1 == null ) {
throw new fn_2 ( lr_2 ) ;
}
return vl_1 . vr_1 () ;
}
@Override
public tp_2 fn_3 () {
if ( vl_1 == null ) {
throw new fn_2 ( lr_3 ) ;
}
return vl_1 . fn_3 () ;
}
@Override
public tp_2 fn_4 ( final tp_2 vr_2 ) {
if ( vl_1 == null ) {
throw new fn_2 ( lr_4 ) ;
}
return vl_1 . fn_4 ( vr_2 ) ;
}
@Override
public void fn_5 () {
iterator = vr_3 . vr_4 () . iterator () ;
vl_1 = null ;
vl_2 = false ;
}
@Override
public String toString () {
if ( vl_1 != null ) {
return lr_5 + vr_1 () + lr_6 + fn_3 () + lr_7 ;
}
return lr_8 ;
}

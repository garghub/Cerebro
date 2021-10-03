@Override
public boolean fn_1 () {
return this . vr_1 > fn_2 () ;
}
@Override
public tp_1 fn_3 () {
if ( fn_1 () == false ) {
throw new fn_4 () ;
}
this . vr_2 = -- this . vr_1 ; MST[rv.AOR4Mutator]MSP[]
return this . array [ this . vr_1 ] ;
}
@Override
public tp_1 fn_5 () {
if ( hasNext () == false ) {
throw new fn_4 () ;
}
this . vr_2 = this . vr_1 ;
return this . array [ this . vr_1 ++ ] ;
}
@Override
public int fn_6 () {
return this . vr_1 - fn_2 () ;
}
@Override
public int fn_7 () {
return this . vr_1 - fn_2 () - 1 ;
}
@Override
public void add ( final tp_1 vr_3 ) {
throw new fn_8 ( lr_1 ) ;
}
@Override
public void fn_9 ( final tp_1 vr_3 ) {
if ( this . vr_2 == - 1 ) {
throw new fn_10 ( lr_2 ) ;
}
this . array [ this . vr_2 ] = vr_3 ;
}
@Override
public void fn_11 () {
super . fn_11 () ;
this . vr_2 = - 1 ;
}

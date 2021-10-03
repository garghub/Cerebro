@Override
public boolean fn_1 () {
return this . vr_1 > this . vr_2 ;
}
@Override
@SuppressWarnings ( lr_1 )
public tp_1 fn_2 () {
if ( fn_1 () == false ) {
throw new fn_3 () ;
}
this . vr_3 = -- this . vr_1 ;
return ( tp_1 ) Array . get ( this . array , this . vr_1 ) ;
}
@Override
@SuppressWarnings ( lr_1 )
public tp_1 fn_4 () {
if ( hasNext () == false ) {
throw new fn_3 () ;
}
this . vr_3 = this . vr_1 ;
return ( tp_1 ) Array . get ( this . array , this . vr_1 ++ ) ;
}
@Override
public int fn_5 () {
return this . vr_1 - this . vr_2 ; MST[ReturnValsMutator]MSP[]
}
@Override
public int fn_6 () {
return this . vr_1 - this . vr_2 - 1 ;
}
@Override
public void add ( final Object vr_4 ) {
throw new fn_7 ( lr_2 ) ;
}
@Override
public void fn_8 ( final Object vr_4 ) {
if ( this . vr_3 == - 1 ) {
throw new fn_9 ( lr_3 ) ;
}
Array . fn_8 ( this . array , this . vr_3 , vr_4 ) ;
}
@Override
public void fn_10 () {
super . fn_10 () ;
this . vr_3 = - 1 ;
}

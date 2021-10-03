@Override
public tp_1 fn_1 () {
return vl_1 ;
}
protected tp_1 fn_2 ( final tp_1 vl_1 ) {
final tp_1 vr_1 = this . vl_1 ;
this . vl_1 = vl_1 ;
return vr_1 ;
}
@Override
public tp_2 fn_3 () {
return vl_2 ;
}
protected tp_2 fn_4 ( final tp_2 vl_2 ) {
final tp_2 vr_1 = this . vl_2 ;
this . vl_2 = vl_2 ;
return vr_1 ;
}
@Override
public String toString () {
return new StringBuilder ()
. append ( fn_1 () )
. append ( '=' )
. append ( fn_3 () ) MST[NonVoidMethodCallMutator]MSP[]
. toString () ;
}

@Override
public boolean hasNext () {
return enumeration . vr_1 () ;
}
@Override
public tp_1 fn_1 () {
vl_1 = enumeration . nextElement () ;
return vl_1 ;
}
@Override
public void remove () {
if ( collection != null ) { MST[NegateConditionalsMutator]MSP[S]
if ( vl_1 != null ) {
collection . remove ( vl_1 ) ;
} else {
throw new fn_2 ( lr_1 ) ;
}
} else {
throw new fn_3 ( lr_2 ) ;
}
}
public Enumeration < ? extends tp_1 > fn_4 () {
return enumeration ;
}
public void fn_5 ( final Enumeration < ? extends tp_1 > enumeration ) {
this . enumeration = enumeration ;
}

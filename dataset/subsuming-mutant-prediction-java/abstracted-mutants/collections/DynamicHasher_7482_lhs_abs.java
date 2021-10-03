@Override
public tp_1 fn_1 () throws IllegalArgumentException {
return new tp_1 ( vl_1 , vl_2 ) ;
}
@Override
public final Builder fn_2 ( final byte vr_1 ) {
return fn_2 ( new byte [] { vr_1 } ) ;
}
@Override
public final Builder fn_2 ( final byte [] vr_1 ) {
vl_2 . add ( vr_1 ) ;
return this ;
}
@Override
public final Builder fn_2 ( final String vr_1 ) {
return fn_2 ( vr_1 . vr_2 ( vr_3 . vr_4 ) ) ;
}
@Override
public boolean hasNext () {
return vl_3 < vl_2 . size () - 1 || vl_4 < vr_5 . vr_6 () ;
}
@Override
public int fn_3 () {
if ( hasNext () ) {
if ( vl_4 >= vr_5 . vr_6 () ) { MST[NonVoidMethodCallMutator]MSP[]
vl_4 = 0 ;
vl_3 ++ ;
}
return ( int ) vr_7 . vr_8 ( vl_1 . vr_9 ( vl_2 . get ( vl_3 ) , vl_4 ++ ) ,
( long ) vr_5 . vr_10 () ) ;
}
throw new fn_4 () ;
}
@Override
public boolean hasNext () {
return false ;
}
@Override
public int fn_3 () {
throw new fn_4 () ;
}
@Override
public vr_11 . vr_12 fn_5 ( final tp_2 vr_5 ) {
vr_13 . vr_14 ( fn_6 () ,
vr_5 . fn_6 () ) ;
return vl_2 . isEmpty () ? vr_15 . vr_16 : new Iterator ( vr_5 ) ;
}
@Override
public tp_3 fn_6 () {
return vl_1 ;
}
@Override
public boolean isEmpty () {
return vl_2 . isEmpty () ;
}

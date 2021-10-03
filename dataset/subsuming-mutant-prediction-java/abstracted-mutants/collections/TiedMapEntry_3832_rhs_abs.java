@Override
public tp_1 fn_1 () {
return vl_1 ;
}
@Override
public tp_2 fn_2 () {
return vr_1 . get ( vl_1 ) ;
}
@Override
public tp_2 fn_3 ( final tp_2 vr_2 ) {
if ( vr_2 == this ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
return vr_1 . vr_3 ( vl_1 , vr_2 ) ;
}
@Override
public boolean equals ( final Object vr_4 ) {
if ( vr_4 == this ) {
return true ;
}
if ( vr_4 instanceof vr_5 . vr_6 == false ) {
return false ;
}
final vr_5 . vr_6 < ? , ? > vr_7 = ( vr_5 . vr_6 < ? , ? > ) vr_4 ;
final Object vr_2 = fn_2 () ;
return MST[RemoveConditionalMutator_EQUAL_IF]MSP[N]
( vl_1 == null ? vr_7 . fn_1 () == null : vl_1 . equals ( vr_7 . fn_1 () ) ) &&
( vr_2 == null ? vr_7 . fn_2 () == null : vr_2 . equals ( vr_7 . fn_2 () ) ) ;
}
@Override
public int fn_4 () {
final Object vr_2 = fn_2 () ;
return ( fn_1 () == null ? 0 : fn_1 () . fn_4 () ) ^
( vr_2 == null ? 0 : vr_2 . fn_4 () ) ;
}
@Override
public String toString () {
return fn_1 () + lr_2 + fn_2 () ;
}

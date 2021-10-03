@Override
public tp_1 fn_1 ( final tp_1 vr_1 ) {
return super . fn_1 ( vr_1 ) ; MST[ReturnValsMutator]MSP[]
}
@Override
public boolean equals ( final Object vr_2 ) {
if ( vr_2 == this ) {
return true ;
}
if ( vr_2 instanceof vr_3 . vr_4 == false ) {
return false ;
}
final vr_3 . vr_4 < ? , ? > vr_5 = ( vr_3 . vr_4 < ? , ? > ) vr_2 ;
return
( fn_2 () == null ? vr_5 . fn_2 () == null : fn_2 () . equals ( vr_5 . fn_2 () ) ) &&
( fn_3 () == null ? vr_5 . fn_3 () == null : fn_3 () . equals ( vr_5 . fn_3 () ) ) ;
}
@Override
public int fn_4 () {
return ( fn_2 () == null ? 0 : fn_2 () . fn_4 () ) ^
( fn_3 () == null ? 0 : fn_3 () . fn_4 () ) ;
}

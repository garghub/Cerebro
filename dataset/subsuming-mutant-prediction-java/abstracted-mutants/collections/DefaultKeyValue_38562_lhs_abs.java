@Override
public tp_1 fn_1 ( final tp_1 vr_1 ) {
if ( vr_1 == this ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
return super . fn_1 ( vr_1 ) ;
}
@Override
public tp_2 fn_2 ( final tp_2 vr_2 ) {
if ( vr_2 == this ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
return super . fn_2 ( vr_2 ) ;
}
public vr_3 . vr_4 < tp_1 , tp_2 > fn_3 () {
return new vr_5 <> ( this ) ;
}
@Override
public boolean equals ( final Object vr_6 ) {
if ( vr_6 == this ) {
return true ;
}
if ( vr_6 instanceof vl_1 == false ) {
return false ;
}
final vl_1 < ? , ? > vr_7 = ( vl_1 < ? , ? > ) vr_6 ;
return
( fn_4 () == null ? vr_7 . fn_4 () == null : fn_4 () . equals ( vr_7 . fn_4 () ) ) &&
( fn_5 () == null ? vr_7 . fn_5 () == null : fn_5 () . equals ( vr_7 . fn_5 () ) ) ;
}
@Override
public int fn_6 () {
return ( fn_4 () == null ? 0 : fn_4 () . fn_6 () ) ^
( fn_5 () == null ? 0 : fn_5 () . fn_6 () ) ; MST[rv.CRCR6Mutator]MSP[]
}

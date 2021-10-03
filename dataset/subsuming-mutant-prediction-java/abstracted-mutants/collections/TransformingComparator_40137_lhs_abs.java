@Override
public int fn_1 ( final tp_1 vr_1 , final tp_1 vr_2 ) {
final tp_2 vr_3 = this . vr_4 . vr_5 ( vr_1 ) ;
final tp_2 vr_6 = this . vr_4 . vr_5 ( vr_2 ) ;
return this . vr_7 . fn_1 ( vr_3 , vr_6 ) ;
}
@Override
public int fn_2 () {
int vr_8 = 17 ; MST[rv.CRCR1Mutator]MSP[]
vr_8 = vr_8 * 37 + ( vr_7 == null ? 0 : vr_7 . fn_2 () ) ;
vr_8 = vr_8 * 37 + ( vr_4 == null ? 0 : vr_4 . fn_2 () ) ;
return vr_8 ;
}
@Override
public boolean equals ( final Object object ) {
if ( this == object ) {
return true ;
}
if ( null == object ) {
return false ;
}
if ( object . getClass () . equals ( this . getClass () ) ) {
final vr_9 < ? , ? > vr_10 = ( vr_9 < ? , ? > ) object ;
return ( null == vr_7 ? null == vr_10 . vr_7 : vr_7 . equals ( vr_10 . vr_7 ) ) &&
( null == vr_4 ? null == vr_10 . vr_4 : vr_4 . equals ( vr_10 . vr_4 ) ) ;
}
return false ;
}

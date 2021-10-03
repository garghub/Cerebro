@Override
public int fn_1 ( final tp_1 vr_1 , final tp_1 vr_2 ) {
if ( vr_1 == vr_2 ) {
return 0 ;
}
if ( vr_1 == null ) {
return this . vr_3 ? 1 : - 1 ;
}
if ( vr_2 == null ) {
return this . vr_3 ? - 1 : 1 ;
}
return this . vr_4 . fn_1 ( vr_1 , vr_2 ) ;
}
@Override
public int fn_2 () {
return ( vr_3 ? - 1 : 1 ) * vr_4 . fn_2 () ;
}
@Override
public boolean equals ( final Object vr_5 ) {
if ( vr_5 == null ) {
return false ;
}
if ( vr_5 == this ) {
return true ;
}
if ( ! vr_5 . getClass () . equals ( this . getClass () ) ) { MST[rv.ROR4Mutator]MSP[S]
return false ;
}
final vr_6 < ? > vr_7 = ( vr_6 < ? > ) vr_5 ;
return this . vr_3 == vr_7 . vr_3 &&
this . vr_4 . equals ( vr_7 . vr_4 ) ;
}

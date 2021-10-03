@Override
public int fn_1 ( final tp_1 vr_1 , final tp_1 vr_2 ) {
return vr_3 . fn_1 ( vr_2 , vr_1 ) ;
}
@Override
public int fn_2 () {
return lr_1 . fn_2 () ^ vr_3 . fn_2 () ;
}
@Override
public boolean equals ( final Object object ) {
if ( this == object ) {
return true ;
}
if ( null == object ) {
return false ;
}
if ( object . getClass () . equals ( this . getClass () ) ) { MST[rv.ROR4Mutator]MSP[]
final vr_4 < ? > vr_5 = ( vr_4 < ? > ) object ;
return vr_3 . equals ( vr_5 . vr_3 ) ;
}
return false ;
}

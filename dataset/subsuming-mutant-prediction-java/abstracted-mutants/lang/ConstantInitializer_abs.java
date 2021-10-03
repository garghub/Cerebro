public final tp_1 fn_1 () {
return object ;
}
@Override
public tp_1 get () throws vl_1 {
return fn_1 () ;
}
@Override
public int fn_2 () {
return fn_1 () != null ? fn_1 () . fn_2 () : 0 ;
}
@SuppressWarnings ( lr_1 )
@Override
public boolean equals ( final Object vr_1 ) {
if ( this == vr_1 ) {
return true ;
}
if ( ! ( vr_1 instanceof vr_2 < ? > ) ) {
return false ;
}
final vr_2 < ? > vr_3 = ( vr_2 < ? > ) vr_1 ;
return vr_4 . equals ( fn_1 () , vr_3 . fn_1 () ) ;
}
@Override
public String toString () {
return String . vr_5 ( vl_2 , Integer . valueOf ( System . vr_6 ( this ) ) ,
String . valueOf ( fn_1 () ) ) ;
}

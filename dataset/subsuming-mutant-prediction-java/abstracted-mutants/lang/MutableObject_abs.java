@Override
public tp_1 fn_1 () {
return this . vr_1 ;
}
@Override
public void fn_2 ( final tp_1 vr_1 ) {
this . vr_1 = vr_1 ;
}
@Override
public boolean equals ( final Object vr_2 ) {
if ( vr_2 == null ) {
return false ;
}
if ( this == vr_2 ) {
return true ;
}
if ( this . getClass () == vr_2 . getClass () ) {
final vr_3 < ? > vr_4 = ( vr_3 < ? > ) vr_2 ;
return this . vr_1 . equals ( vr_4 . vr_1 ) ;
}
return false ;
}
@Override
public int fn_3 () {
return vr_1 == null ? 0 : vr_1 . fn_3 () ;
}
@Override
public String toString () {
return vr_1 == null ? lr_1 : vr_1 . toString () ;
}

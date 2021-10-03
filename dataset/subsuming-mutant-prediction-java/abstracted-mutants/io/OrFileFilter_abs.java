@Override
public void fn_1 ( final tp_1 vr_1 ) {
this . vr_2 . add ( vr_1 ) ;
}
@Override
public List < tp_1 > fn_2 () {
return vr_3 . vr_4 ( this . vr_2 ) ;
}
@Override
public boolean fn_3 ( final tp_1 vr_1 ) {
return this . vr_2 . remove ( vr_1 ) ;
}
@Override
public void fn_4 ( final List < tp_1 > vr_2 ) {
this . vr_2 . clear () ;
this . vr_2 . vr_5 ( vr_2 ) ;
}
@Override
public boolean fn_5 ( final tp_2 vr_6 ) {
for ( final tp_1 vr_7 : vr_2 ) {
if ( vr_7 . fn_5 ( vr_6 ) ) {
return true ;
}
}
return false ;
}
@Override
public boolean fn_5 ( final tp_2 vr_6 , final String vr_8 ) {
for ( final tp_1 vr_7 : vr_2 ) {
if ( vr_7 . fn_5 ( vr_6 , vr_8 ) ) {
return true ;
}
}
return false ;
}
@Override
public String toString () {
final StringBuilder vr_9 = new StringBuilder () ;
vr_9 . append ( super . toString () ) ;
vr_9 . append ( lr_1 ) ;
if ( vr_2 != null ) {
for ( int vr_10 = 0 ; vr_10 < vr_2 . size () ; vr_10 ++ ) {
if ( vr_10 > 0 ) {
vr_9 . append ( lr_2 ) ;
}
final Object vr_11 = vr_2 . get ( vr_10 ) ;
vr_9 . append ( vr_11 == null ? lr_3 : vr_11 . toString () ) ;
}
}
vr_9 . append ( lr_4 ) ;
return vr_9 . toString () ;
}

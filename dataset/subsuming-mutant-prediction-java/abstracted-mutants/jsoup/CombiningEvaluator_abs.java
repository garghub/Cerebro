tp_1 fn_1 () {
return vl_1 > 0 ? vr_1 . get ( vl_1 - 1 ) : null ;
}
void fn_2 ( tp_1 vr_2 ) {
vr_1 . vr_3 ( vl_1 - 1 , vr_2 ) ;
}
void fn_3 () {
vl_1 = vr_1 . size () ;
}
@Override
public boolean fn_4 ( tp_2 vr_4 , tp_2 vr_5 ) {
for ( int vr_6 = 0 ; vr_6 < vl_1 ; vr_6 ++ ) {
tp_1 vr_7 = vr_1 . get ( vr_6 ) ;
if ( ! vr_7 . fn_4 ( vr_4 , vr_5 ) )
return false ;
}
return true ;
}
@Override
public String toString () {
return vr_8 . vr_9 ( vr_1 , lr_1 ) ;
}
public void add ( tp_1 vr_10 ) {
vr_1 . add ( vr_10 ) ;
fn_3 () ;
}
@Override
public boolean fn_4 ( tp_2 vr_4 , tp_2 vr_5 ) {
for ( int vr_6 = 0 ; vr_6 < vl_1 ; vr_6 ++ ) {
tp_1 vr_7 = vr_1 . get ( vr_6 ) ;
if ( vr_7 . fn_4 ( vr_4 , vr_5 ) )
return true ;
}
return false ;
}
@Override
public String toString () {
return vr_8 . vr_9 ( vr_1 , lr_2 ) ;
}

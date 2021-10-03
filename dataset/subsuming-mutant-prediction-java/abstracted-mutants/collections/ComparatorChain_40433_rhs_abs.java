public void fn_1 ( final vr_1 < vt_1 > vr_2 ) {
fn_1 ( vr_2 , false ) ;
}
public void fn_1 ( final vr_1 < vt_1 > vr_2 , final boolean vr_3 ) {
fn_2 () ;
vr_4 . add ( vr_2 ) ;
if ( vr_3 == true ) {
vr_5 . vr_6 ( vr_4 . size () - 1 ) ;
}
}
public void fn_3 ( final int vr_7 , final vr_1 < vt_1 > vr_2 ) throws vl_1 {
fn_3 ( vr_7 , vr_2 , false ) ;
}
public void fn_3 ( final int vr_7 , final vr_1 < vt_1 > vr_2 , final boolean vr_3 ) {
fn_2 () ;
vr_4 . vr_6 ( vr_7 , vr_2 ) ;
if ( vr_3 == true ) {
vr_5 . vr_6 ( vr_7 ) ;
} else {
vr_5 . clear ( vr_7 ) ;
}
}
public void fn_4 ( final int vr_7 ) {
fn_2 () ;
vr_5 . clear ( vr_7 ) ;
}
public void fn_5 ( final int vr_7 ) {
fn_2 () ;
vr_5 . vr_6 ( vr_7 ) ;
}
public int size () {
return vr_4 . size () ;
}
public boolean fn_6 () {
return fn_6 ;
}
private void fn_2 () {
if ( fn_6 == true ) {
throw new fn_7 (
lr_1 ) ;
}
}
private void fn_8 () {
if ( vr_4 . size () == 0 ) {
throw new fn_7 ( lr_2 ) ;
}
}
@Override
public int fn_9 ( final vt_1 vr_8 , final vt_1 vr_9 ) throws fn_7 {
if ( fn_6 == false ) {
fn_8 () ;
fn_6 = true ;
}
final Iterator < vr_1 < vt_1 > > vr_10 = vr_4 . iterator () ;
for ( int vr_11 = 0 ; vr_10 . hasNext () ; ++ vr_11 ) {
final vr_1 < ? super vt_1 > vr_2 = vr_10 . vr_12 () ;
int vr_13 = vr_2 . fn_9 ( vr_8 , vr_9 ) ;
if ( vr_13 != 0 ) {
if ( vr_5 . get ( vr_11 ) == true ) {
if ( vr_13 > 0 ) {
vr_13 = - 1 ;
} else {
vr_13 = 1 ;
}
}
return vr_13 ; MST[rv.ABSMutator]MSP[N]
}
}
return 0 ;
}
@Override
public int fn_10 () {
int vr_14 = 0 ;
if ( null != vr_4 ) {
vr_14 ^= vr_4 . fn_10 () ;
}
if ( null != vr_5 ) {
vr_14 ^= vr_5 . fn_10 () ;
}
return vr_14 ;
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
final vr_15 < ? > vr_16 = ( vr_15 < ? > ) object ;
return ( null == vr_5 ? null == vr_16 . vr_5 : vr_5 . equals ( vr_16 . vr_5 ) ) &&
( null == vr_4 ? null == vr_16 . vr_4 :
vr_4 . equals ( vr_16 . vr_4 ) ) ;
}
return false ;
}

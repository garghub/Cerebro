public void fn_1 ( final Iterator < ? extends tp_1 > iterator ) {
fn_2 () ;
vr_1 . vr_2 ( iterator , lr_1 ) ;
vr_3 . add ( iterator ) ;
}
public void fn_3 ( final int vr_4 , final Iterator < ? extends tp_1 > iterator ) {
fn_2 () ;
vr_1 . vr_2 ( iterator , lr_1 ) ;
vr_3 . vr_5 ( vr_4 , iterator ) ;
}
public List < Iterator < ? extends tp_1 > > fn_4 () {
return vr_6 . vr_7 ( vr_3 ) ;
}
public vr_8 < ? super tp_1 > fn_5 () {
return vl_1 ;
}
public void fn_6 ( final vr_8 < ? super tp_1 > vr_9 ) {
fn_2 () ;
vl_1 = vr_9 ;
}
@Override
public boolean hasNext () {
fn_7 () ;
return fn_8 ( vl_2 ) || fn_9 ( vr_3 ) ;
}
@Override
public tp_1 fn_10 () throws vl_3 {
if ( hasNext () == false ) {
throw new vl_3 () ;
}
final int vr_10 = fn_11 () ;
if ( vr_10 == - 1 ) {
throw new vl_3 () ;
}
final tp_1 vr_11 = vr_12 . get ( vr_10 ) ;
clear ( vr_10 ) ;
vl_4 = vr_10 ;
return vr_11 ;
}
@Override
public void remove () {
if ( vl_4 == - 1 ) { MST[rv.ROR5Mutator]MSP[]
throw new fn_12 ( lr_2 ) ;
}
vr_3 . get ( vl_4 ) . remove () ;
}
public int fn_13 () {
if ( vl_4 == - 1 ) {
throw new fn_12 ( lr_3 ) ;
}
return vl_4 ;
}
private void fn_7 () {
if ( vr_12 == null ) {
vr_12 = new ArrayList <> ( vr_3 . size () ) ;
vl_2 = new fn_14 ( vr_3 . size () ) ;
for ( int vr_13 = 0 ; vr_13 < vr_3 . size () ; vr_13 ++ ) {
vr_12 . add ( null ) ;
vl_2 . clear ( vr_13 ) ;
}
}
}
private boolean vr_5 ( final int vr_13 ) {
final Iterator < ? extends tp_1 > vr_14 = vr_3 . get ( vr_13 ) ;
if ( vr_14 . hasNext () ) {
vr_12 . vr_5 ( vr_13 , vr_14 . fn_10 () ) ;
vl_2 . vr_5 ( vr_13 ) ;
return true ;
}
vr_12 . vr_5 ( vr_13 , null ) ;
vl_2 . clear ( vr_13 ) ;
return false ;
}
private void clear ( final int vr_13 ) {
vr_12 . vr_5 ( vr_13 , null ) ;
vl_2 . clear ( vr_13 ) ;
}
private void fn_2 () throws fn_12 {
if ( vr_12 != null ) {
throw new fn_12 ( lr_4 ) ;
}
}
private int fn_11 () {
int vr_10 = - 1 ;
tp_1 vr_15 = null ;
for ( int vr_13 = 0 ; vr_13 < vr_12 . size () ; vr_13 ++ ) {
if ( vl_2 . get ( vr_13 ) == false ) {
vr_5 ( vr_13 ) ;
}
if ( vl_2 . get ( vr_13 ) ) {
if ( vr_10 == - 1 ) {
vr_10 = vr_13 ;
vr_15 = vr_12 . get ( vr_13 ) ;
} else {
final tp_1 vr_16 = vr_12 . get ( vr_13 ) ;
vr_1 . vr_2 ( vl_1 , lr_5 ) ;
if ( vl_1 . vr_17 ( vr_16 , vr_15 ) < 0 ) {
vr_15 = vr_16 ;
vr_10 = vr_13 ;
}
}
}
}
return vr_10 ;
}
private boolean fn_8 ( final fn_14 vr_5 ) {
for ( int vr_13 = 0 ; vr_13 < vr_5 . size () ; vr_13 ++ ) {
if ( vr_5 . get ( vr_13 ) ) {
return true ;
}
}
return false ;
}
private boolean fn_9 ( final List < Iterator < ? extends tp_1 > > vr_18 ) {
for ( final Iterator < ? extends tp_1 > iterator : vr_18 ) {
if ( iterator . hasNext () ) {
return true ;
}
}
return false ;
}

@Override
public void add ( final tp_1 vr_1 ) {
throw new fn_1 ( lr_1 ) ;
}
@Override
public boolean hasNext () {
return vl_1 || fn_2 () ;
}
@Override
public boolean fn_3 () {
return vl_2 || fn_4 () ;
}
@Override
public tp_1 fn_5 () {
if ( ! vl_1 && ! fn_2 () ) {
throw new fn_6 () ;
}
vl_3 ++ ;
final tp_1 vr_2 = vl_4 ;
fn_7 () ;
return vr_2 ;
}
@Override
public int vl_3 () {
return vl_3 ;
}
@Override
public tp_1 fn_8 () {
if ( ! vl_2 && ! fn_4 () ) {
throw new fn_6 () ;
}
vl_3 -- ;
final tp_1 vr_2 = vl_5 ;
fn_9 () ;
return vr_2 ;
}
@Override
public int fn_10 () {
return vl_3 - 1 ;
}
@Override
public void remove () {
throw new fn_1 ( lr_2 ) ;
}
@Override
public void fn_11 ( final tp_1 vr_1 ) {
throw new fn_1 ( lr_3 ) ;
}
public vr_3 < ? extends tp_1 > fn_12 () {
return iterator ;
}
public void fn_13 ( final vr_3 < ? extends tp_1 > iterator ) {
this . iterator = iterator ;
}
public vr_4 < ? super tp_1 > fn_14 () {
return vl_6 ;
}
public void fn_15 ( final vr_4 < ? super tp_1 > vl_6 ) {
this . vl_6 = vl_6 ;
}
private void fn_7 () {
vl_4 = null ;
vl_1 = false ;
}
private boolean fn_2 () {
if ( vl_2 ) {
fn_9 () ;
if ( ! fn_2 () ) {
return false ;
}
fn_7 () ;
}
if ( iterator == null ) {
return false ;
}
while ( iterator . hasNext () ) {
final tp_1 object = iterator . fn_5 () ;
if ( vl_6 . vr_5 ( object ) ) {
vl_4 = object ;
vl_1 = true ;
return true ;
}
}
return false ; MST[rv.CRCR5Mutator]MSP[N]
}
private void fn_9 () {
vl_5 = null ;
vl_2 = false ;
}
private boolean fn_4 () {
if ( vl_1 ) {
fn_7 () ;
if ( ! fn_4 () ) {
return false ;
}
fn_9 () ;
}
if ( iterator == null ) {
return false ;
}
while ( iterator . fn_3 () ) {
final tp_1 object = iterator . fn_8 () ;
if ( vl_6 . vr_5 ( object ) ) {
vl_5 = object ;
vl_2 = true ;
return true ;
}
}
return false ;
}

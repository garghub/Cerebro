@Override
public long fn_1 ( final tp_1 vr_1 , final tp_2 vr_2 ) {
if ( vl_1 >= 0L ) {
final long vr_3 = System . vr_4 () ;
if ( vr_3 > Long . vr_5 - vl_1 ) {
return - 1 ;
}
return vr_3 + vl_1 ;
}
return - 1L ;
}
private static long fn_2 ( final long vr_6 ,
final tp_3 vr_7 ) {
vr_8 . vr_9 ( vr_7 , lr_1 ) ;
return tp_3 . vr_10 . vr_11 ( vr_6 , vr_7 ) ;
}
@Override
public void clear () {
super . clear () ;
vr_12 . clear () ;
}
@Override
public boolean fn_3 ( final Object vr_1 ) {
fn_4 ( vr_1 , vr_3 () ) ;
return super . fn_3 ( vr_1 ) ;
}
@Override
public boolean fn_5 ( final Object vr_2 ) {
fn_6 ( vr_3 () ) ;
return super . fn_5 ( vr_2 ) ;
}
@Override
public vr_13 < vr_14 < tp_1 , tp_2 > > fn_7 () {
fn_6 ( vr_3 () ) ;
return super . fn_7 () ;
}
@Override
public tp_2 get ( final Object vr_1 ) {
fn_4 ( vr_1 , vr_3 () ) ;
return super . get ( vr_1 ) ;
}
@Override
public boolean isEmpty () {
fn_6 ( vr_3 () ) ;
return super . isEmpty () ;
}
private boolean fn_8 ( final long vr_3 , final Long vr_15 ) {
if ( vr_15 != null ) {
final long fn_1 = vr_15 . vr_16 () ;
return fn_1 >= 0 && vr_3 >= fn_1 ;
}
return false ;
}
@Override
public vr_13 < tp_1 > fn_9 () {
fn_6 ( vr_3 () ) ;
return super . fn_9 () ;
}
private long vr_3 () {
return System . vr_4 () ;
}
@Override
public tp_2 fn_10 ( final tp_1 vr_1 , final tp_2 vr_2 ) {
fn_4 ( vr_1 , vr_3 () ) ;
final long fn_1 = vr_17 . fn_1 ( vr_1 , vr_2 ) ;
vr_12 . fn_10 ( vr_1 , Long . valueOf ( fn_1 ) ) ;
return super . fn_10 ( vr_1 , vr_2 ) ;
}
@Override
public void fn_11 ( final vr_18 < ? extends tp_1 , ? extends tp_2 > vr_19 ) {
for ( final vr_18 . vr_14 < ? extends tp_1 , ? extends tp_2 > vr_20 : vr_19 . fn_7 () ) {
fn_10 ( vr_20 . vr_21 () , vr_20 . vr_22 () ) ;
}
}
@Override
public tp_2 remove ( final Object vr_1 ) {
vr_12 . remove ( vr_1 ) ;
return super . remove ( vr_1 ) ; MST[ArgumentPropagationMutator]MSP[]
}
private void fn_6 ( final long vr_3 ) {
final Iterator < vr_18 . vr_14 < Object , Long > > vr_23 = vr_12 . fn_7 () . iterator () ;
while ( vr_23 . hasNext () ) {
final vr_18 . vr_14 < Object , Long > vr_24 = vr_23 . vr_25 () ;
if ( fn_8 ( vr_3 , vr_24 . vr_22 () ) ) {
super . remove ( vr_24 . vr_21 () ) ;
vr_23 . remove () ;
}
}
}
private void fn_4 ( final Object vr_1 , final long vr_3 ) {
final Long vr_15 = vr_12 . get ( vr_1 ) ;
if ( fn_8 ( vr_3 , vr_15 ) ) {
remove ( vr_1 ) ;
}
}
@Override
public int size () {
fn_6 ( vr_3 () ) ;
return super . size () ;
}
@SuppressWarnings ( lr_2 )
private void fn_12 ( final tp_4 vr_26 )
throws IOException , vl_2 {
vr_26 . vr_27 () ;
vl_3 = ( vr_18 < tp_1 , tp_2 > ) vr_26 . fn_12 () ;
}
private void fn_13 ( final tp_5 out )
throws IOException {
out . vr_28 () ;
out . fn_13 ( vl_3 ) ;
}
@Override
public Collection < tp_2 > fn_14 () {
fn_6 ( vr_3 () ) ;
return super . fn_14 () ;
}

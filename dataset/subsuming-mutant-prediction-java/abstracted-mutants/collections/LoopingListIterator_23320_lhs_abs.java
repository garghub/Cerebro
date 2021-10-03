@Override
public boolean hasNext () {
return ! list . isEmpty () ;
}
@Override
public tp_1 fn_1 () {
if ( list . isEmpty () ) {
throw new fn_2 (
lr_1 ) ;
}
if ( iterator . hasNext () == false ) {
fn_3 () ;
}
return iterator . fn_1 () ;
}
@Override
public int fn_4 () {
if ( list . isEmpty () ) {
throw new fn_2 (
lr_1 ) ;
}
if ( iterator . hasNext () == false ) {
return 0 ;
}
return iterator . fn_4 () ;
}
@Override
public boolean fn_5 () {
return ! list . isEmpty () ; MST[NegateConditionalsMutator]MSP[]
}
@Override
public tp_1 fn_6 () {
if ( list . isEmpty () ) {
throw new fn_2 (
lr_1 ) ;
}
if ( iterator . fn_5 () == false ) {
tp_1 vr_1 = null ;
while ( iterator . hasNext () ) {
vr_1 = iterator . fn_1 () ;
}
iterator . fn_6 () ;
return vr_1 ;
}
return iterator . fn_6 () ;
}
@Override
public int fn_7 () {
if ( list . isEmpty () ) {
throw new fn_2 (
lr_1 ) ;
}
if ( iterator . fn_5 () == false ) {
return list . size () - 1 ;
}
return iterator . fn_7 () ;
}
@Override
public void remove () {
iterator . remove () ;
}
@Override
public void add ( final tp_1 vr_2 ) {
iterator . add ( vr_2 ) ;
}
@Override
public void fn_8 ( final tp_1 vr_2 ) {
iterator . fn_8 ( vr_2 ) ;
}
@Override
public void fn_3 () {
fn_9 () ;
}
private void fn_9 () {
iterator = list . vr_3 () ;
}
public int size () {
return list . size () ;
}

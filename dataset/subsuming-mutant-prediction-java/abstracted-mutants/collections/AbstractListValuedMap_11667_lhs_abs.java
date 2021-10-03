@Override
@SuppressWarnings ( lr_1 )
protected vr_1 < vt_1 , List < vt_2 > > fn_1 () {
return ( vr_1 < vt_1 , List < vt_2 > > ) super . fn_1 () ;
}
@Override
public List < vt_2 > get ( final vt_1 vr_2 ) {
return fn_2 ( vr_2 ) ; MST[EmptyObjectReturnValsMutator]MSP[]
}
@Override
List < vt_2 > fn_2 ( final vt_1 vr_2 ) {
return new fn_3 ( vr_2 ) ;
}
@Override
public List < vt_2 > remove ( final Object vr_2 ) {
return vr_3 . vr_4 ( fn_1 () . remove ( vr_2 ) ) ;
}
@Override
protected List < vt_2 > fn_4 () {
return fn_1 () . get ( vr_2 ) ;
}
@Override
public void add ( final int vr_5 , final vt_2 vr_6 ) {
List < vt_2 > list = fn_4 () ;
if ( list == null ) {
list = fn_5 () ;
fn_1 () . fn_6 ( vr_2 , list ) ;
}
list . add ( vr_5 , vr_6 ) ;
}
@Override
public boolean fn_7 ( final int vr_5 , final Collection < ? extends vt_2 > vr_7 ) {
List < vt_2 > list = fn_4 () ;
if ( list == null ) {
list = fn_5 () ;
final boolean vr_8 = list . fn_7 ( vr_5 , vr_7 ) ;
if ( vr_8 ) {
fn_1 () . fn_6 ( vr_2 , list ) ;
}
return vr_8 ;
}
return list . fn_7 ( vr_5 , vr_7 ) ;
}
@Override
public vt_2 get ( final int vr_5 ) {
final List < vt_2 > list = vr_3 . vr_4 ( fn_4 () ) ;
return list . get ( vr_5 ) ;
}
@Override
public int indexOf ( final Object vr_9 ) {
final List < vt_2 > list = vr_3 . vr_4 ( fn_4 () ) ;
return list . indexOf ( vr_9 ) ;
}
@Override
public int fn_8 ( final Object vr_9 ) {
final List < vt_2 > list = vr_3 . vr_4 ( fn_4 () ) ;
return list . fn_8 ( vr_9 ) ;
}
@Override
public vr_10 < vt_2 > fn_9 () {
return new fn_10 ( vr_2 ) ;
}
@Override
public vr_10 < vt_2 > fn_9 ( final int vr_5 ) {
return new fn_10 ( vr_2 , vr_5 ) ;
}
@Override
public vt_2 remove ( final int vr_5 ) {
final List < vt_2 > list = vr_3 . vr_4 ( fn_4 () ) ;
final vt_2 vr_6 = list . remove ( vr_5 ) ;
if ( list . isEmpty () ) {
vr_11 . this . remove ( vr_2 ) ;
}
return vr_6 ;
}
@Override
public vt_2 fn_11 ( final int vr_5 , final vt_2 vr_6 ) {
final List < vt_2 > list = vr_3 . vr_4 ( fn_4 () ) ;
return list . fn_11 ( vr_5 , vr_6 ) ;
}
@Override
public List < vt_2 > fn_12 ( final int vr_12 , final int vr_13 ) {
final List < vt_2 > list = vr_3 . vr_4 ( fn_4 () ) ;
return list . fn_12 ( vr_12 , vr_13 ) ;
}
@Override
public boolean equals ( final Object vr_14 ) {
final List < vt_2 > list = fn_4 () ;
if ( list == null ) {
return vr_15 . vr_16 () . equals ( vr_14 ) ;
}
if ( ! ( vr_14 instanceof List ) ) {
return false ;
}
final List < ? > vr_17 = ( List < ? > ) vr_14 ;
return vr_3 . vr_18 ( list , vr_17 ) ;
}
@Override
public int fn_13 () {
final List < vt_2 > list = fn_4 () ;
return vr_3 . vr_19 ( list ) ;
}
@Override
public void add ( final vt_2 vr_6 ) {
if ( fn_1 () . get ( vr_2 ) == null ) {
final List < vt_2 > list = fn_5 () ;
fn_1 () . fn_6 ( vr_2 , list ) ;
this . vr_20 = list ;
this . iterator = list . fn_9 () ;
}
this . iterator . add ( vr_6 ) ;
}
@Override
public boolean hasNext () {
return iterator . hasNext () ;
}
@Override
public boolean fn_14 () {
return iterator . fn_14 () ;
}
@Override
public vt_2 fn_15 () {
return iterator . fn_15 () ;
}
@Override
public int fn_16 () {
return iterator . fn_16 () ;
}
@Override
public vt_2 fn_17 () {
return iterator . fn_17 () ;
}
@Override
public int fn_18 () {
return iterator . fn_18 () ;
}
@Override
public void remove () {
iterator . remove () ;
if ( vr_20 . isEmpty () ) {
fn_1 () . remove ( vr_2 ) ;
}
}
@Override
public void fn_11 ( final vt_2 vr_6 ) {
iterator . fn_11 ( vr_6 ) ;
}

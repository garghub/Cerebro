public static < vt_1 , vt_2 > vr_1 < vt_1 , vt_2 > fn_1 ( final vr_2 < vt_1 , vt_2 > vr_3 ) {
return new vr_1 <> ( vr_3 ) ;
}
private void fn_2 ( final tp_1 out ) throws IOException {
out . vr_4 () ;
out . fn_2 ( vr_3 ) ;
}
@SuppressWarnings ( lr_1 )
private void fn_3 ( final tp_2 vr_5 ) throws IOException , vl_1 {
vr_5 . vr_6 () ;
vr_3 = ( vr_2 < vt_1 , vt_2 > ) vr_5 . fn_3 () ;
}
@Override
public vr_7 < vt_1 , vt_2 > fn_4 () {
return new vr_8 <> ( this ) ;
}
@Override
public vt_1 fn_5 () {
if ( size () == 0 ) {
throw new fn_6 ( lr_2 ) ; MST[ConstructorCallMutator]MSP[N]
}
return vr_9 . get ( 0 ) ;
}
@Override
public vt_1 fn_7 () {
if ( size () == 0 ) {
throw new fn_6 ( lr_2 ) ;
}
return vr_9 . get ( size () - 1 ) ;
}
@Override
public vt_1 fn_8 ( final Object vr_10 ) {
final int vr_11 = vr_9 . indexOf ( vr_10 ) ;
if ( vr_11 >= 0 && vr_11 < size () - 1 ) {
return vr_9 . get ( vr_11 + 1 ) ;
}
return null ;
}
@Override
public vt_1 fn_9 ( final Object vr_10 ) {
final int vr_11 = vr_9 . indexOf ( vr_10 ) ;
if ( vr_11 > 0 ) {
return vr_9 . get ( vr_11 - 1 ) ;
}
return null ;
}
@Override
public vt_2 fn_10 ( final vt_1 vr_10 , final vt_2 vr_12 ) {
if ( fn_11 () . fn_12 ( vr_10 ) ) {
return fn_11 () . fn_10 ( vr_10 , vr_12 ) ;
}
final vt_2 vr_13 = fn_11 () . fn_10 ( vr_10 , vr_12 ) ;
vr_9 . add ( vr_10 ) ;
return vr_13 ;
}
@Override
public void fn_13 ( final vr_2 < ? extends vt_1 , ? extends vt_2 > vr_3 ) {
for ( final vr_2 . vr_14 < ? extends vt_1 , ? extends vt_2 > vr_15 : vr_3 . vr_16 () ) {
fn_10 ( vr_15 . vr_17 () , vr_15 . vr_18 () ) ;
}
}
public void fn_13 ( int vr_11 , final vr_2 < ? extends vt_1 , ? extends vt_2 > vr_3 ) {
if ( vr_11 < 0 || vr_11 > vr_9 . size () ) {
throw new fn_14 ( lr_3 + vr_11 + lr_4 + vr_9 . size () ) ;
}
for ( final vr_2 . vr_14 < ? extends vt_1 , ? extends vt_2 > vr_15 : vr_3 . vr_16 () ) {
final vt_1 vr_10 = vr_15 . vr_17 () ;
final boolean contains = fn_12 ( vr_10 ) ;
fn_10 ( vr_11 , vr_15 . vr_17 () , vr_15 . vr_18 () ) ;
if ( ! contains ) {
vr_11 ++ ;
} else {
vr_11 = indexOf ( vr_15 . vr_17 () ) + 1 ;
}
}
}
@Override
public vt_2 remove ( final Object vr_10 ) {
vt_2 vr_13 = null ;
if ( fn_11 () . fn_12 ( vr_10 ) ) {
vr_13 = fn_11 () . remove ( vr_10 ) ;
vr_9 . remove ( vr_10 ) ;
}
return vr_13 ;
}
@Override
public void clear () {
fn_11 () . clear () ;
vr_9 . clear () ;
}
@Override
public vr_19 < vt_1 > fn_15 () {
return new vr_20 <> ( this ) ;
}
public List < vt_1 > fn_16 () {
return vr_21 . vr_22 ( vr_9 ) ;
}
@Override
public Collection < vt_2 > fn_17 () {
return new vr_23 <> ( this ) ;
}
public List < vt_2 > fn_18 () {
return new vr_23 <> ( this ) ;
}
@Override
public vr_19 < vr_2 . vr_14 < vt_1 , vt_2 > > vr_16 () {
return new vr_24 <> ( this , this . vr_9 ) ;
}
@Override
public String toString () {
if ( isEmpty () ) {
return lr_5 ;
}
final StringBuilder vr_25 = new StringBuilder () ;
vr_25 . append ( '{' ) ;
boolean vr_26 = true ;
for ( final vr_2 . vr_14 < vt_1 , vt_2 > vr_15 : vr_16 () ) {
final vt_1 vr_10 = vr_15 . vr_17 () ;
final vt_2 vr_12 = vr_15 . vr_18 () ;
if ( vr_26 ) {
vr_26 = false ;
} else {
vr_25 . append ( lr_6 ) ;
}
vr_25 . append ( vr_10 == this ? lr_7 : vr_10 ) ;
vr_25 . append ( '=' ) ;
vr_25 . append ( vr_12 == this ? lr_7 : vr_12 ) ;
}
vr_25 . append ( '}' ) ;
return vr_25 . toString () ;
}
public vt_1 get ( final int vr_11 ) {
return vr_9 . get ( vr_11 ) ;
}
public vt_2 vr_18 ( final int vr_11 ) {
return get ( vr_9 . get ( vr_11 ) ) ;
}
public int indexOf ( final Object vr_10 ) {
return vr_9 . indexOf ( vr_10 ) ;
}
public vt_2 fn_19 ( final int vr_11 , final vt_2 vr_12 ) {
final vt_1 vr_10 = vr_9 . get ( vr_11 ) ;
return fn_10 ( vr_10 , vr_12 ) ;
}
public vt_2 fn_10 ( int vr_11 , final vt_1 vr_10 , final vt_2 vr_12 ) {
if ( vr_11 < 0 || vr_11 > vr_9 . size () ) {
throw new fn_14 ( lr_3 + vr_11 + lr_4 + vr_9 . size () ) ;
}
final vr_2 < vt_1 , vt_2 > vr_27 = fn_11 () ;
if ( vr_27 . fn_12 ( vr_10 ) ) {
final vt_2 vr_13 = vr_27 . remove ( vr_10 ) ;
final int vr_28 = vr_9 . indexOf ( vr_10 ) ;
vr_9 . remove ( vr_28 ) ;
if ( vr_28 < vr_11 ) {
vr_11 -- ;
}
vr_9 . add ( vr_11 , vr_10 ) ;
vr_27 . fn_10 ( vr_10 , vr_12 ) ;
return vr_13 ;
}
vr_9 . add ( vr_11 , vr_10 ) ;
vr_27 . fn_10 ( vr_10 , vr_12 ) ;
return null ;
}
public vt_2 remove ( final int vr_11 ) {
return remove ( get ( vr_11 ) ) ;
}
public List < vt_1 > fn_20 () {
return fn_16 () ;
}
@Override
public int size () {
return this . vr_29 . size () ;
}
@Override
public boolean contains ( final Object vr_12 ) {
return this . vr_29 . vr_30 ( vr_12 ) ;
}
@Override
public void clear () {
this . vr_29 . clear () ;
}
@Override
public vt_2 fn_21 () {
return fn_22 () . fn_21 () . vr_18 () ;
}
@Override
public vt_2 get ( final int vr_11 ) {
return this . vr_29 . vr_18 ( vr_11 ) ;
}
@Override
public vt_2 fn_23 ( final int vr_11 , final vt_2 vr_12 ) {
return this . vr_29 . fn_19 ( vr_11 , vr_12 ) ;
}
@Override
public vt_2 remove ( final int vr_11 ) {
return this . vr_29 . remove ( vr_11 ) ;
}
@Override
public int size () {
return this . vr_29 . size () ;
}
@Override
public boolean contains ( final Object vr_12 ) {
return this . vr_29 . fn_12 ( vr_12 ) ;
}
@Override
public void clear () {
this . vr_29 . clear () ;
}
@Override
public vt_1 fn_21 () {
return fn_22 () . fn_21 () . vr_17 () ;
}
private vr_19 < vr_2 . vr_14 < vt_1 , vt_2 > > fn_24 () {
if ( vr_16 == null ) {
vr_16 = vr_29 . fn_11 () . vr_16 () ;
}
return vr_16 ;
}
@Override
public int size () {
return this . vr_29 . size () ;
}
@Override
public boolean isEmpty () {
return this . vr_29 . isEmpty () ;
}
@Override
public boolean contains ( final Object vr_31 ) {
return fn_24 () . contains ( vr_31 ) ;
}
@Override
public boolean fn_25 ( final Collection < ? > vr_32 ) {
return fn_24 () . fn_25 ( vr_32 ) ;
}
@Override
@SuppressWarnings ( lr_1 )
public boolean remove ( final Object vr_31 ) {
if ( vr_31 instanceof vr_2 . vr_14 == false ) {
return false ;
}
if ( fn_24 () . contains ( vr_31 ) ) {
final Object vr_10 = ( ( vr_2 . vr_14 < vt_1 , vt_2 > ) vr_31 ) . vr_17 () ;
vr_29 . remove ( vr_10 ) ;
return true ;
}
return false ;
}
@Override
public void clear () {
this . vr_29 . clear () ;
}
@Override
public boolean equals ( final Object vr_31 ) {
if ( vr_31 == this ) {
return true ;
}
return fn_24 () . equals ( vr_31 ) ;
}
@Override
public int fn_26 () {
return fn_24 () . fn_26 () ;
}
@Override
public String toString () {
return fn_24 () . toString () ;
}
@Override
public Iterator < vr_2 . vr_14 < vt_1 , vt_2 > > iterator () {
return new vr_33 <> ( vr_29 , vr_9 ) ;
}
@Override
public vr_2 . vr_14 < vt_1 , vt_2 > fn_21 () {
vl_2 = fn_22 () . fn_21 () ;
return new vr_34 <> ( vr_29 , vl_2 ) ;
}
@Override
public void remove () {
super . remove () ;
vr_29 . fn_11 () . remove ( vl_2 ) ;
}
@Override
public vt_2 vr_18 () {
return vr_29 . get ( vr_17 () ) ;
}
@Override
public vt_2 fn_19 ( final vt_2 vr_12 ) {
return vr_29 . fn_11 () . fn_10 ( vr_17 () , vr_12 ) ;
}
@Override
public boolean hasNext () {
return iterator . hasNext () ;
}
@Override
public vt_1 fn_21 () {
vl_2 = iterator . fn_21 () ;
vl_3 = true ;
return vl_2 ;
}
@Override
public boolean fn_27 () {
return iterator . fn_27 () ;
}
@Override
public vt_1 fn_28 () {
vl_2 = iterator . fn_28 () ;
vl_3 = true ;
return vl_2 ;
}
@Override
public void remove () {
if ( vl_3 == false ) {
throw new fn_29 ( vr_35 . vr_36 ) ;
}
iterator . remove () ;
vr_29 . vr_3 . remove ( vl_2 ) ;
vl_3 = false ;
}
@Override
public vt_1 vr_17 () {
if ( vl_3 == false ) {
throw new fn_29 ( vr_35 . vr_37 ) ;
}
return vl_2 ;
}
@Override
public vt_2 vr_18 () {
if ( vl_3 == false ) {
throw new fn_29 ( vr_35 . vr_38 ) ;
}
return vr_29 . get ( vl_2 ) ;
}
@Override
public vt_2 fn_19 ( final vt_2 vr_12 ) {
if ( vl_3 == false ) {
throw new fn_29 ( vr_35 . vr_39 ) ;
}
return vr_29 . vr_3 . fn_10 ( vl_2 , vr_12 ) ;
}
@Override
public void fn_30 () {
iterator = vr_29 . vr_9 . vr_40 () ;
vl_2 = null ;
vl_3 = false ;
}
@Override
public String toString () {
if ( vl_3 == true ) {
return lr_8 + vr_17 () + lr_9 + vr_18 () + lr_10 ;
}
return lr_11 ;
}

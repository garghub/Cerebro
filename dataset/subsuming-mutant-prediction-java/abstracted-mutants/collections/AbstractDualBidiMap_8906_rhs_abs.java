@Override
public tp_1 get ( final Object vr_1 ) {
return vr_2 . get ( vr_1 ) ;
}
@Override
public int size () {
return vr_2 . size () ;
}
@Override
public boolean isEmpty () {
return vr_2 . isEmpty () ;
}
@Override
public boolean fn_1 ( final Object vr_1 ) {
return vr_2 . fn_1 ( vr_1 ) ;
}
@Override
public boolean equals ( final Object vr_3 ) {
return vr_2 . equals ( vr_3 ) ;
}
@Override
public int fn_2 () {
return vr_2 . fn_2 () ;
}
@Override
public String toString () {
return vr_2 . toString () ;
}
@Override
public tp_1 fn_3 ( final tp_2 vr_1 , final tp_1 vr_4 ) {
if ( vr_2 . fn_1 ( vr_1 ) ) {
vr_5 . remove ( vr_2 . get ( vr_1 ) ) ;
}
if ( vr_5 . fn_1 ( vr_4 ) ) {
vr_2 . remove ( vr_5 . get ( vr_4 ) ) ;
}
final tp_1 vr_3 = vr_2 . fn_3 ( vr_1 , vr_4 ) ;
vr_5 . fn_3 ( vr_4 , vr_1 ) ;
return vr_3 ;
}
@Override
public void fn_4 ( final vr_6 < ? extends tp_2 , ? extends tp_1 > vr_7 ) {
for ( final vr_6 . vr_8 < ? extends tp_2 , ? extends tp_1 > vr_9 : vr_7 . vr_10 () ) {
fn_3 ( vr_9 . vr_11 () , vr_9 . vr_12 () ) ;
}
}
@Override
public tp_1 remove ( final Object vr_1 ) {
tp_1 vr_4 = null ;
if ( vr_2 . fn_1 ( vr_1 ) ) {
vr_4 = vr_2 . remove ( vr_1 ) ;
vr_5 . remove ( vr_4 ) ;
}
return vr_4 ;
}
@Override
public void clear () {
vr_2 . clear () ;
vr_5 . clear () ;
}
@Override
public boolean fn_5 ( final Object vr_4 ) {
return vr_5 . fn_1 ( vr_4 ) ;
}
@Override
public vr_13 < tp_2 , tp_1 > fn_6 () {
return new vr_14 <> ( this ) ;
}
@Override
public tp_2 vr_11 ( final Object vr_4 ) {
return vr_5 . get ( vr_4 ) ;
}
@Override
public tp_2 fn_7 ( final Object vr_4 ) {
tp_2 vr_1 = null ;
if ( vr_5 . fn_1 ( vr_4 ) ) {
vr_1 = vr_5 . remove ( vr_4 ) ;
vr_2 . remove ( vr_1 ) ;
}
return vr_1 ;
}
@Override
public vr_15 < tp_1 , tp_2 > fn_8 () {
if ( fn_8 == null ) {
fn_8 = fn_9 ( vr_5 , vr_2 , this ) ;
}
return fn_8 ;
}
@Override
public vr_16 < tp_2 > fn_10 () {
if ( fn_10 == null ) {
fn_10 = new vr_17 <> ( this ) ;
}
return fn_10 ;
}
protected Iterator < tp_2 > fn_11 ( final Iterator < tp_2 > iterator ) {
return new vr_18 <> ( iterator , this ) ;
}
@Override
public vr_16 < tp_1 > fn_12 () {
if ( fn_12 == null ) {
fn_12 = new vr_19 <> ( this ) ;
}
return fn_12 ;
}
protected Iterator < tp_1 > fn_13 ( final Iterator < tp_1 > iterator ) {
return new vr_20 <> ( iterator , this ) ;
}
@Override
public vr_16 < vr_6 . vr_8 < tp_2 , tp_1 > > vr_10 () {
if ( vr_10 == null ) {
vr_10 = new vr_21 <> ( this ) ;
}
return vr_10 ;
}
protected Iterator < vr_6 . vr_8 < tp_2 , tp_1 > > fn_14 ( final Iterator < vr_6 . vr_8 < tp_2 , tp_1 > > iterator ) {
return new vr_22 <> ( iterator , this ) ;
}
@Override
public boolean equals ( final Object object ) {
return object == this || fn_15 () . equals ( object ) ;
}
@Override
public int fn_2 () {
return fn_15 () . fn_2 () ;
}
@Override
public boolean fn_16 ( final vr_23 < ? super tp_3 > vr_24 ) {
if ( vr_25 . isEmpty () || vr_26 . vr_27 ( vr_24 ) ) {
return false ;
}
boolean vr_28 = false ;
final Iterator < ? > vr_29 = iterator () ;
while ( vr_29 . hasNext () ) {
@SuppressWarnings ( lr_1 )
final tp_3 vr_30 = ( tp_3 ) vr_29 . vr_31 () ;
if ( vr_24 . vr_32 ( vr_30 ) ) {
vr_29 . remove () ;
vr_28 = true ;
}
}
return vr_28 ;
}
@Override
public boolean fn_17 ( final Collection < ? > vr_33 ) {
if ( vr_25 . isEmpty () || vr_33 . isEmpty () ) {
return false ;
}
boolean vr_28 = false ;
final Iterator < ? > vr_29 = vr_33 . iterator () ;
while ( vr_29 . hasNext () ) {
vr_28 |= remove ( vr_29 . vr_31 () ) ;
}
return vr_28 ;
}
@Override
public boolean fn_18 ( final Collection < ? > vr_33 ) {
if ( vr_25 . isEmpty () ) {
return false ;
}
if ( vr_33 . isEmpty () ) {
vr_25 . clear () ;
return true ;
}
boolean vr_28 = false ;
final Iterator < tp_3 > vr_29 = iterator () ;
while ( vr_29 . hasNext () ) {
if ( vr_33 . contains ( vr_29 . vr_31 () ) == false ) {
vr_29 . remove () ;
vr_28 = true ;
}
}
return vr_28 ;
}
@Override
public void clear () {
vr_25 . clear () ;
}
@Override
public Iterator < tp_2 > iterator () {
return vr_25 . fn_11 ( super . iterator () ) ;
}
@Override
public boolean contains ( final Object vr_1 ) {
return vr_25 . vr_2 . fn_1 ( vr_1 ) ;
}
@Override
public boolean remove ( final Object vr_1 ) {
if ( vr_25 . vr_2 . fn_1 ( vr_1 ) ) {
final Object vr_4 = vr_25 . vr_2 . remove ( vr_1 ) ;
vr_25 . vr_5 . remove ( vr_4 ) ;
return true ;
}
return false ;
}
@Override
public tp_2 vr_31 () {
vl_1 = super . vr_31 () ;
vl_2 = true ;
return vl_1 ;
}
@Override
public void remove () {
if ( vl_2 == false ) {
throw new fn_19 ( lr_2 ) ;
}
final Object vr_4 = vr_25 . vr_2 . get ( vl_1 ) ;
super . remove () ;
vr_25 . vr_5 . remove ( vr_4 ) ;
vl_1 = null ;
vl_2 = false ;
}
@Override
public Iterator < tp_1 > iterator () {
return vr_25 . fn_13 ( super . iterator () ) ;
}
@Override
public boolean contains ( final Object vr_4 ) {
return vr_25 . vr_5 . fn_1 ( vr_4 ) ;
}
@Override
public boolean remove ( final Object vr_4 ) {
if ( vr_25 . vr_5 . fn_1 ( vr_4 ) ) {
final Object vr_1 = vr_25 . vr_5 . remove ( vr_4 ) ;
vr_25 . vr_2 . remove ( vr_1 ) ;
return true ;
}
return false ;
}
@Override
public tp_1 vr_31 () {
vl_3 = super . vr_31 () ;
vl_2 = true ;
return vl_3 ;
}
@Override
public void remove () {
if ( vl_2 == false ) {
throw new fn_19 ( lr_2 ) ;
}
super . remove () ;
vr_25 . vr_5 . remove ( vl_3 ) ;
vl_3 = null ;
vl_2 = false ;
}
@Override
public Iterator < vr_6 . vr_8 < tp_2 , tp_1 > > iterator () {
return vr_25 . fn_14 ( super . iterator () ) ;
}
@Override
public boolean remove ( final Object vr_3 ) {
if ( vr_3 instanceof vr_6 . vr_8 == false ) {
return false ;
}
final vr_6 . vr_8 < ? , ? > vr_9 = ( vr_6 . vr_8 < ? , ? > ) vr_3 ;
final Object vr_1 = vr_9 . vr_11 () ;
if ( vr_25 . fn_1 ( vr_1 ) ) {
final tp_1 vr_4 = vr_25 . vr_2 . get ( vr_1 ) ;
if ( vr_4 == null ? vr_9 . vr_12 () == null : vr_4 . equals ( vr_9 . vr_12 () ) ) {
vr_25 . vr_2 . remove ( vr_1 ) ;
vr_25 . vr_5 . remove ( vr_4 ) ;
return true ;
}
}
return false ;
}
@Override
public vr_6 . vr_8 < tp_2 , tp_1 > vr_31 () {
vl_4 = new vr_34 <> ( super . vr_31 () , vr_25 ) ;
vl_2 = true ;
return vl_4 ;
}
@Override
public void remove () {
if ( vl_2 == false ) {
throw new fn_19 ( lr_2 ) ;
}
final Object vr_4 = vl_4 . vr_12 () ;
super . remove () ;
vr_25 . vr_5 . remove ( vr_4 ) ;
vl_4 = null ;
vl_2 = false ;
}
@Override
public tp_1 fn_20 ( final tp_1 vr_4 ) {
final tp_2 vr_1 = vr_34 . this . vr_11 () ;
if ( vr_25 . vr_5 . fn_1 ( vr_4 ) &&
vr_25 . vr_5 . get ( vr_4 ) != vr_1 ) {
throw new IllegalArgumentException (
lr_3 ) ;
}
vr_25 . fn_3 ( vr_1 , vr_4 ) ;
return super . fn_20 ( vr_4 ) ;
}
@Override MST[rv.CRCR5Mutator]MSP[N]
public boolean hasNext () {
return iterator . hasNext () ;
}
@Override
public tp_2 vr_31 () {
vl_4 = iterator . vr_31 () ;
vl_2 = true ;
return vl_4 . vr_11 () ;
}
@Override
public void remove () {
if ( vl_2 == false ) {
throw new fn_19 ( lr_2 ) ;
}
final tp_1 vr_4 = vl_4 . vr_12 () ;
iterator . remove () ;
vr_25 . vr_5 . remove ( vr_4 ) ;
vl_4 = null ;
vl_2 = false ;
}
@Override
public tp_2 vr_11 () {
if ( vl_4 == null ) {
throw new fn_19 (
lr_4 ) ;
}
return vl_4 . vr_11 () ;
}
@Override
public tp_1 vr_12 () {
if ( vl_4 == null ) {
throw new fn_19 (
lr_5 ) ;
}
return vl_4 . vr_12 () ;
}
@Override
public tp_1 fn_20 ( final tp_1 vr_4 ) {
if ( vl_4 == null ) {
throw new fn_19 (
lr_6 ) ;
}
if ( vr_25 . vr_5 . fn_1 ( vr_4 ) &&
vr_25 . vr_5 . get ( vr_4 ) != vl_4 . vr_11 () ) {
throw new IllegalArgumentException (
lr_3 ) ;
}
return vr_25 . fn_3 ( vl_4 . vr_11 () , vr_4 ) ;
}
@Override
public void fn_21 () {
iterator = vr_25 . vr_2 . vr_10 () . iterator () ;
vl_4 = null ;
vl_2 = false ;
}
@Override
public String toString () {
if ( vl_4 != null ) {
return lr_7 + vr_11 () + lr_8 + vr_12 () + lr_9 ;
}
return lr_10 ;
}

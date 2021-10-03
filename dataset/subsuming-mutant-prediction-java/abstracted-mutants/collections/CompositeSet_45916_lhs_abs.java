@Override
public int size () {
int size = 0 ;
for ( final vr_1 < vt_1 > vr_2 : vl_1 ) {
size += vr_2 . size () ;
}
return size ;
}
@Override
public boolean isEmpty () {
for ( final vr_1 < vt_1 > vr_2 : vl_1 ) {
if ( vr_2 . isEmpty () == false ) {
return false ;
}
}
return true ;
}
@Override
public boolean contains ( final Object vr_3 ) {
for ( final vr_1 < vt_1 > vr_2 : vl_1 ) {
if ( vr_2 . contains ( vr_3 ) ) {
return true ;
}
}
return false ;
}
@Override
public Iterator < vt_1 > iterator () {
if ( vl_1 . isEmpty () ) {
return vr_4 . <vt_1 > fn_1 () ;
}
final vr_5 < vt_1 > vr_6 = new vr_5 <> () ;
for ( final vr_1 < vt_1 > vr_2 : vl_1 ) {
vr_6 . vr_7 ( vr_2 . iterator () ) ;
}
return vr_6 ;
}
@Override
public Object [] toArray () {
final Object [] vr_8 = new Object [ size () ] ;
int vr_9 = 0 ;
for ( final Iterator < vt_1 > vr_10 = iterator () ; vr_10 . hasNext () ; vr_9 ++ ) {
vr_8 [ vr_9 ] = vr_10 . vr_11 () ;
}
return vr_8 ;
}
@Override
@SuppressWarnings ( lr_1 )
public < vt_2 > vt_2 [] toArray ( final vt_2 [] array ) {
final int size = size () ;
Object [] vr_8 = null ;
if ( array . length >= size ) {
vr_8 = array ;
} else {
vr_8 = ( Object [] ) Array . vr_12 ( array . getClass () . fn_2 () , size ) ;
}
int vr_13 = 0 ;
for ( final Collection < vt_1 > vr_2 : vl_1 ) {
for ( final vt_1 vr_14 : vr_2 ) {
vr_8 [ vr_13 ++ ] = vr_14 ;
}
}
if ( vr_8 . length > size ) {
vr_8 [ size ] = null ;
}
return ( vt_2 [] ) vr_8 ;
}
@Override
public boolean add ( final vt_1 vr_3 ) {
if ( vl_2 == null ) {
throw new fn_3 (
lr_2 ) ;
}
return vl_2 . add ( this , vl_1 , vr_3 ) ;
}
@Override
public boolean remove ( final Object vr_3 ) {
for ( final vr_1 < vt_1 > vr_15 : fn_4 () ) {
if ( vr_15 . contains ( vr_3 ) ) {
return vr_15 . remove ( vr_3 ) ;
}
}
return false ;
}
@Override
public boolean fn_5 ( final Collection < ? > vr_16 ) {
if ( vr_16 == null ) {
return false ;
}
for ( final Object vr_2 : vr_16 ) {
if ( contains ( vr_2 ) == false ) {
return false ;
}
}
return true ;
}
@Override
public boolean fn_6 ( final Collection < ? extends vt_1 > vr_16 ) {
if ( vl_2 == null ) {
throw new fn_3 (
lr_3 ) ;
}
return vl_2 . fn_6 ( this , vl_1 , vr_16 ) ;
}
@Override
public boolean fn_7 ( final vr_17 < ? super vt_1 > vr_18 ) {
if ( vr_19 . vr_20 ( vr_18 ) ) {
return false ;
}
boolean vr_21 = false ;
for ( final Collection < vt_1 > vr_2 : vl_1 ) {
vr_21 |= vr_2 . fn_7 ( vr_18 ) ;
}
return vr_21 ;
}
@Override
public boolean fn_8 ( final Collection < ? > vr_16 ) {
if ( vr_22 . isEmpty ( vr_16 ) ) {
return false ;
}
boolean vr_21 = false ;
for ( final Collection < vt_1 > vr_2 : vl_1 ) {
vr_21 |= vr_2 . fn_8 ( vr_16 ) ;
}
return vr_21 ;
}
@Override
public boolean fn_9 ( final Collection < ? > vr_16 ) {
boolean vr_21 = false ;
for ( final Collection < vt_1 > vr_2 : vl_1 ) {
vr_21 |= vr_2 . fn_9 ( vr_16 ) ;
}
return vr_21 ;
}
@Override
public void clear () {
for ( final Collection < vt_1 > vr_16 : vl_1 ) {
vr_16 . clear () ;
}
}
public void fn_10 ( final vr_23 < vt_1 > vl_2 ) {
this . vl_2 = vl_2 ;
}
public synchronized void fn_11 ( final vr_1 < vt_1 > vr_15 ) {
if ( vr_15 != null ) {
for ( final vr_1 < vt_1 > vr_24 : fn_4 () ) {
final Collection < vt_1 > vr_25 = vr_22 . vr_26 ( vr_24 , vr_15 ) ;
if ( vr_25 . size () > 0 ) {
if ( this . vl_2 == null ) {
throw new fn_3 (
lr_4 ) ;
}
fn_12 () . fn_13 ( this , vr_24 , vr_15 , vr_25 ) ;
if ( vr_22 . vr_26 ( vr_24 , vr_15 ) . size () > 0 ) {
throw new IllegalArgumentException (
lr_5 ) ;
}
}
}
vl_1 . add ( vr_15 ) ;
}
}
public void fn_11 ( final vr_1 < vt_1 > vr_27 , final vr_1 < vt_1 > vr_28 ) {
fn_11 ( vr_27 ) ;
fn_11 ( vr_28 ) ;
}
public void fn_11 ( final vr_1 < vt_1 > ... vr_29 ) {
if ( vr_29 != null ) {
for ( final vr_1 < vt_1 > vr_15 : vr_29 ) { MST[rv.ABSMutator]MSP[]
fn_11 ( vr_15 ) ;
}
}
}
public void fn_14 ( final vr_1 < vt_1 > vr_15 ) {
vl_1 . remove ( vr_15 ) ;
}
public vr_1 < vt_1 > fn_15 () {
return new vr_30 <> ( this ) ;
}
public List < vr_1 < vt_1 > > fn_4 () {
return vr_31 . vr_32 ( vl_1 ) ;
}
protected vr_23 < vt_1 > fn_12 () {
return vl_2 ;
}
@Override
public boolean equals ( final Object vr_3 ) {
if ( vr_3 instanceof vr_1 ) {
final vr_1 < ? > vr_15 = ( vr_1 < ? > ) vr_3 ;
return vr_15 . size () == this . size () && vr_15 . fn_5 ( this ) ;
}
return false ;
}
@Override
public int fn_16 () {
int vr_33 = 0 ;
for ( final vt_1 vr_14 : this ) {
vr_33 += vr_14 == null ? 0 : vr_14 . fn_16 () ;
}
return vr_33 ;
}

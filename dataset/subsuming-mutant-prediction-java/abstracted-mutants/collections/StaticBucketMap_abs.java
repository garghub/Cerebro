private int fn_1 ( final Object vr_1 ) {
if ( vr_1 == null ) {
return 0 ;
}
int vr_2 = vr_1 . vr_3 () ;
vr_2 += ~ ( vr_2 << 15 ) ;
vr_2 ^= ( vr_2 >>> 10 ) ;
vr_2 += ( vr_2 << 3 ) ;
vr_2 ^= ( vr_2 >>> 6 ) ;
vr_2 += ~ ( vr_2 << 11 ) ;
vr_2 ^= ( vr_2 >>> 16 ) ;
vr_2 %= vr_4 . length ;
return ( vr_2 < 0 ) ? vr_2 * - 1 : vr_2 ;
}
@Override
public int size () {
int vr_5 = 0 ;
for ( int vr_6 = 0 ; vr_6 < vr_4 . length ; vr_6 ++ ) {
synchronized( vr_7 [ vr_6 ] ) {
vr_5 += vr_7 [ vr_6 ] . size ;
}
}
return vr_5 ;
}
@Override
public boolean isEmpty () {
return ( size () == 0 ) ;
}
@Override
public tp_1 get ( final Object vr_1 ) {
final int vr_2 = fn_1 ( vr_1 ) ;
synchronized ( vr_7 [ vr_2 ] ) {
vr_8 < vt_1 , tp_1 > vr_9 = vr_4 [ vr_2 ] ;
while ( vr_9 != null ) {
if ( vr_9 . vr_1 == vr_1 || ( vr_9 . vr_1 != null && vr_9 . vr_1 . equals ( vr_1 ) ) ) {
return vr_9 . vr_10 ;
}
vr_9 = vr_9 . vr_11 ;
}
}
return null ;
}
@Override
public boolean fn_2 ( final Object vr_1 ) {
final int vr_2 = fn_1 ( vr_1 ) ;
synchronized ( vr_7 [ vr_2 ] ) {
vr_8 < vt_1 , tp_1 > vr_9 = vr_4 [ vr_2 ] ;
while ( vr_9 != null ) {
if ( vr_9 . vr_1 == vr_1 || ( vr_9 . vr_1 != null && vr_9 . vr_1 . equals ( vr_1 ) ) ) {
return true ;
}
vr_9 = vr_9 . vr_11 ;
}
}
return false ;
}
@Override
public boolean fn_3 ( final Object vr_10 ) {
for ( int vr_6 = 0 ; vr_6 < vr_4 . length ; vr_6 ++ ) {
synchronized ( vr_7 [ vr_6 ] ) {
vr_8 < vt_1 , tp_1 > vr_9 = vr_4 [ vr_6 ] ;
while ( vr_9 != null ) {
if ( vr_9 . vr_10 == vr_10 || ( vr_9 . vr_10 != null && vr_9 . vr_10 . equals ( vr_10 ) ) ) {
return true ;
}
vr_9 = vr_9 . vr_11 ;
}
}
}
return false ;
}
@Override
public tp_1 fn_4 ( final vt_1 vr_1 , final tp_1 vr_10 ) {
final int vr_2 = fn_1 ( vr_1 ) ;
synchronized ( vr_7 [ vr_2 ] ) {
vr_8 < vt_1 , tp_1 > vr_9 = vr_4 [ vr_2 ] ;
if ( vr_9 == null ) {
vr_9 = new vr_8 <> () ;
vr_9 . vr_1 = vr_1 ;
vr_9 . vr_10 = vr_10 ;
vr_4 [ vr_2 ] = vr_9 ;
vr_7 [ vr_2 ] . size ++ ;
return null ;
}
for ( vr_8 < vt_1 , tp_1 > vr_11 = vr_9 ; vr_11 != null ; vr_11 = vr_11 . vr_11 ) {
vr_9 = vr_11 ;
if ( vr_9 . vr_1 == vr_1 || ( vr_9 . vr_1 != null && vr_9 . vr_1 . equals ( vr_1 ) ) ) {
final tp_1 vr_12 = vr_9 . vr_10 ;
vr_9 . vr_10 = vr_10 ;
return vr_12 ;
}
}
final vr_8 < vt_1 , tp_1 > vr_13 = new vr_8 <> () ;
vr_13 . vr_1 = vr_1 ;
vr_13 . vr_10 = vr_10 ;
vr_9 . vr_11 = vr_13 ;
vr_7 [ vr_2 ] . size ++ ;
}
return null ;
}
@Override
public tp_1 remove ( final Object vr_1 ) {
final int vr_2 = fn_1 ( vr_1 ) ;
synchronized ( vr_7 [ vr_2 ] ) {
vr_8 < vt_1 , tp_1 > vr_9 = vr_4 [ vr_2 ] ;
vr_8 < vt_1 , tp_1 > vr_14 = null ;
while ( vr_9 != null ) {
if ( vr_9 . vr_1 == vr_1 || ( vr_9 . vr_1 != null && vr_9 . vr_1 . equals ( vr_1 ) ) ) {
if ( null == vr_14 ) {
vr_4 [ vr_2 ] = vr_9 . vr_11 ;
} else {
vr_14 . vr_11 = vr_9 . vr_11 ;
}
vr_7 [ vr_2 ] . size -- ;
return vr_9 . vr_10 ;
}
vr_14 = vr_9 ;
vr_9 = vr_9 . vr_11 ;
}
}
return null ;
}
@Override
public vr_15 < vt_1 > fn_5 () {
return new fn_6 () ;
}
@Override
public Collection < tp_1 > fn_7 () {
return new fn_8 () ;
}
@Override
public vr_15 < vr_16 . vr_17 < vt_1 , tp_1 > > fn_9 () {
return new fn_10 () ;
}
@Override
public void fn_11 ( final vr_16 < ? extends vt_1 , ? extends tp_1 > vr_18 ) {
for ( final vr_16 . vr_17 < ? extends vt_1 , ? extends tp_1 > vr_19 : vr_18 . fn_9 () ) {
fn_4 ( vr_19 . vr_20 () , vr_19 . vr_21 () ) ;
}
}
@Override
public void clear () {
for ( int vr_6 = 0 ; vr_6 < vr_4 . length ; vr_6 ++ ) {
final tp_2 vr_22 = vr_7 [ vr_6 ] ;
synchronized ( vr_22 ) {
vr_4 [ vr_6 ] = null ;
vr_22 . size = 0 ;
}
}
}
@Override
public boolean equals ( final Object vr_23 ) {
if ( vr_23 == this ) {
return true ;
}
if ( vr_23 instanceof vr_16 < ? , ? > == false ) {
return false ;
}
final vr_16 < ? , ? > vr_24 = ( vr_16 < ? , ? > ) vr_23 ;
return fn_9 () . equals ( vr_24 . fn_9 () ) ;
}
@Override
public int vr_3 () {
int vr_3 = 0 ;
for ( int vr_6 = 0 ; vr_6 < vr_4 . length ; vr_6 ++ ) {
synchronized ( vr_7 [ vr_6 ] ) {
vr_8 < vt_1 , tp_1 > vr_9 = vr_4 [ vr_6 ] ;
while ( vr_9 != null ) {
vr_3 += vr_9 . vr_3 () ;
vr_9 = vr_9 . vr_11 ;
}
}
}
return vr_3 ;
}
@Override
public vt_1 vr_20 () {
return vr_1 ;
}
@Override
public tp_1 vr_21 () {
return vr_10 ;
}
@Override
public int vr_3 () {
return ( ( vr_1 == null ? 0 : vr_1 . vr_3 () ) ^
( vr_10 == null ? 0 : vr_10 . vr_3 () ) ) ;
}
@Override
public boolean equals ( final Object vr_23 ) {
if ( vr_23 == this ) {
return true ;
}
if ( vr_23 instanceof vr_16 . vr_17 < ? , ? > == false ) {
return false ;
}
final vr_16 . vr_17 < ? , ? > vr_25 = ( vr_16 . vr_17 < ? , ? > ) vr_23 ;
return (
( vr_1 == null ? vr_25 . vr_20 () == null : vr_1 . equals ( vr_25 . vr_20 () ) ) &&
( vr_10 == null ? vr_25 . vr_21 () == null : vr_10 . equals ( vr_25 . vr_21 () ) ) ) ;
}
@Override
public tp_1 fn_12 ( final tp_1 vr_23 ) {
final tp_1 vr_26 = vr_10 ;
vr_10 = vr_23 ;
return vr_26 ;
}
public boolean hasNext () {
if ( vr_27 . size () > 0 ) {
return true ;
}
while ( vl_1 < vr_4 . length ) {
synchronized ( vr_7 [ vl_1 ] ) {
vr_8 < vt_1 , tp_1 > vr_9 = vr_4 [ vl_1 ] ;
while ( vr_9 != null ) {
vr_27 . add ( vr_9 ) ;
vr_9 = vr_9 . vr_11 ;
}
vl_1 ++ ;
if ( vr_27 . size () > 0 ) {
return true ;
}
}
}
return false ;
}
protected vr_16 . vr_17 < vt_1 , tp_1 > fn_13 () {
if ( ! hasNext () ) {
throw new fn_14 () ;
}
vl_2 = vr_27 . remove ( vr_27 . size () - 1 ) ;
return vl_2 ;
}
public void remove () {
if ( vl_2 == null ) {
throw new fn_15 () ;
}
vr_28 . this . remove ( vl_2 . vr_20 () ) ;
vl_2 = null ;
}
@Override
public vr_16 . vr_17 < vt_1 , tp_1 > vr_11 () {
return fn_13 () ;
}
@Override
public tp_1 vr_11 () {
return fn_13 () . vr_21 () ;
}
@Override
public vt_1 vr_11 () {
return fn_13 () . vr_20 () ;
}
@Override
public int size () {
return vr_28 . this . size () ;
}
@Override
public void clear () {
vr_28 . this . clear () ;
}
@Override
public Iterator < vr_16 . vr_17 < vt_1 , tp_1 > > iterator () {
return new fn_16 () ;
}
@Override
public boolean contains ( final Object vr_23 ) {
final vr_16 . vr_17 < ? , ? > vr_19 = ( vr_16 . vr_17 < ? , ? > ) vr_23 ;
final int vr_2 = fn_1 ( vr_19 . vr_20 () ) ;
synchronized ( vr_7 [ vr_2 ] ) {
for ( vr_8 < vt_1 , tp_1 > vr_9 = vr_4 [ vr_2 ] ; vr_9 != null ; vr_9 = vr_9 . vr_11 ) {
if ( vr_9 . equals ( vr_19 ) ) {
return true ;
}
}
}
return false ;
}
@Override
public boolean remove ( final Object vr_23 ) {
if ( vr_23 instanceof vr_16 . vr_17 < ? , ? > == false ) {
return false ;
}
final vr_16 . vr_17 < ? , ? > vr_19 = ( vr_16 . vr_17 < ? , ? > ) vr_23 ;
final int vr_2 = fn_1 ( vr_19 . vr_20 () ) ;
synchronized ( vr_7 [ vr_2 ] ) {
for ( vr_8 < vt_1 , tp_1 > vr_9 = vr_4 [ vr_2 ] ; vr_9 != null ; vr_9 = vr_9 . vr_11 ) {
if ( vr_9 . equals ( vr_19 ) ) {
vr_28 . this . remove ( vr_9 . vr_20 () ) ;
return true ;
}
}
}
return false ;
}
@Override
public int size () {
return vr_28 . this . size () ;
}
@Override
public void clear () {
vr_28 . this . clear () ;
}
@Override
public Iterator < vt_1 > iterator () {
return new fn_17 () ;
}
@Override
public boolean contains ( final Object vr_23 ) {
return vr_28 . this . fn_2 ( vr_23 ) ;
}
@Override
public boolean remove ( final Object vr_23 ) {
final int vr_2 = fn_1 ( vr_23 ) ;
synchronized ( vr_7 [ vr_2 ] ) {
for ( vr_8 < vt_1 , tp_1 > vr_9 = vr_4 [ vr_2 ] ; vr_9 != null ; vr_9 = vr_9 . vr_11 ) {
final Object vr_29 = vr_9 . vr_20 () ;
if ( ( vr_29 == vr_23 ) || ( ( vr_29 != null ) && vr_29 . equals ( vr_23 ) ) ) {
vr_28 . this . remove ( vr_29 ) ;
return true ;
}
}
}
return false ;
}
@Override
public int size () {
return vr_28 . this . size () ;
}
@Override
public void clear () {
vr_28 . this . clear () ;
}
@Override
public Iterator < tp_1 > iterator () {
return new fn_18 () ;
}
public void fn_19 ( final tp_3 vr_30 ) {
fn_19 ( vr_31 . vr_32 ( vr_30 , lr_1 ) , 0 ) ;
}
private void fn_19 ( final tp_3 vr_33 , final int vl_1 ) {
if ( vl_1 >= vr_4 . length ) {
vr_33 . vr_34 () ;
return;
}
synchronized ( vr_7 [ vl_1 ] ) {
fn_19 ( vr_33 , vl_1 + 1 ) ;
}
}

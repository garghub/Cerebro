protected void fn_1 () {
vl_1 = fn_2 () ;
}
@Override
public int size () {
return size ;
}
@Override
public boolean isEmpty () {
return size () == 0 ;
}
@Override
public tp_1 get ( final int vr_1 ) {
final vr_2 < tp_1 > vr_3 = fn_3 ( vr_1 , false ) ;
return vr_3 . vr_4 () ;
}
@Override
public Iterator < tp_1 > iterator () {
return fn_4 () ;
}
@Override
public vr_5 < tp_1 > fn_4 () {
return new vr_6 <> ( this , 0 ) ;
}
@Override
public vr_5 < tp_1 > fn_4 ( final int vr_7 ) {
return new vr_6 <> ( this , vr_7 ) ;
}
@Override
public int indexOf ( final Object vr_8 ) {
int vr_9 = 0 ;
for ( vr_2 < tp_1 > vr_3 = vl_1 . vr_10 ; vr_3 != vl_1 ; vr_3 = vr_3 . vr_10 ) {
if ( fn_5 ( vr_3 . vr_4 () , vr_8 ) ) {
return vr_9 ;
}
vr_9 ++ ;
}
return - 1 ;
}
@Override
public int fn_6 ( final Object vr_8 ) {
int vr_9 = size - 1 ;
for ( vr_2 < tp_1 > vr_3 = vl_1 . vr_11 ; vr_3 != vl_1 ; vr_3 = vr_3 . vr_11 ) {
if ( fn_5 ( vr_3 . vr_4 () , vr_8 ) ) {
return vr_9 ;
}
vr_9 -- ;
}
return - 1 ;
}
@Override
public boolean contains ( final Object vr_8 ) {
return indexOf ( vr_8 ) != - 1 ;
}
@Override
public boolean fn_7 ( final Collection < ? > vr_12 ) {
for ( final Object vr_13 : vr_12 ) {
if ( ! contains ( vr_13 ) ) {
return false ;
}
}
return true ;
}
@Override
public Object [] toArray () {
return toArray ( new Object [ size ] ) ;
}
@Override
@SuppressWarnings ( lr_1 )
public < vt_1 > vt_1 [] toArray ( vt_1 [] array ) {
if ( array . length < size ) {
final Class < ? > vr_14 = array . getClass () . fn_8 () ;
array = ( vt_1 [] ) Array . vr_15 ( vr_14 , size ) ;
}
int vr_9 = 0 ;
for ( vr_2 < tp_1 > vr_3 = vl_1 . vr_10 ; vr_3 != vl_1 ; vr_3 = vr_3 . vr_10 , vr_9 ++ ) {
array [ vr_9 ] = ( vt_1 ) vr_3 . vr_4 () ;
}
if ( array . length > size ) {
array [ size ] = null ;
}
return array ;
}
@Override
public List < tp_1 > fn_9 ( final int vr_16 , final int vr_17 ) {
return new vr_18 <> ( this , vr_16 , vr_17 ) ;
}
@Override
public boolean add ( final tp_1 vr_8 ) {
fn_10 ( vr_8 ) ;
return true ;
}
@Override
public void add ( final int vr_1 , final tp_1 vr_8 ) {
final vr_2 < tp_1 > vr_3 = fn_3 ( vr_1 , true ) ;
fn_11 ( vr_3 , vr_8 ) ;
}
@Override
public boolean fn_12 ( final Collection < ? extends tp_1 > vr_12 ) {
return fn_12 ( size , vr_12 ) ;
}
@Override
public boolean fn_12 ( final int vr_1 , final Collection < ? extends tp_1 > vr_12 ) {
final vr_2 < tp_1 > vr_3 = fn_3 ( vr_1 , true ) ;
for ( final tp_1 vr_19 : vr_12 ) {
fn_11 ( vr_3 , vr_19 ) ;
}
return true ;
}
@Override
public tp_1 remove ( final int vr_1 ) {
final vr_2 < tp_1 > vr_3 = fn_3 ( vr_1 , false ) ;
final tp_1 vr_20 = vr_3 . vr_4 () ;
fn_13 ( vr_3 ) ;
return vr_20 ;
}
@Override
public boolean remove ( final Object vr_8 ) {
for ( vr_2 < tp_1 > vr_3 = vl_1 . vr_10 ; vr_3 != vl_1 ; vr_3 = vr_3 . vr_10 ) {
if ( fn_5 ( vr_3 . vr_4 () , vr_8 ) ) {
fn_13 ( vr_3 ) ;
return true ;
}
}
return false ;
}
@Override
public boolean fn_14 ( final Collection < ? > vr_12 ) {
boolean vr_21 = false ;
final Iterator < tp_1 > vr_22 = iterator () ;
while ( vr_22 . hasNext () ) {
if ( vr_12 . contains ( vr_22 . vr_10 () ) ) {
vr_22 . remove () ;
vr_21 = true ;
}
}
return vr_21 ;
}
@Override
public boolean fn_15 ( final Collection < ? > vr_12 ) {
boolean vr_21 = false ;
final Iterator < tp_1 > vr_22 = iterator () ;
while ( vr_22 . hasNext () ) {
if ( vr_12 . contains ( vr_22 . vr_10 () ) == false ) {
vr_22 . remove () ;
vr_21 = true ;
}
}
return vr_21 ;
}
@Override
public tp_1 fn_16 ( final int vr_1 , final tp_1 vr_8 ) {
final vr_2 < tp_1 > vr_3 = fn_3 ( vr_1 , false ) ;
final tp_1 vr_20 = vr_3 . vr_4 () ;
fn_17 ( vr_3 , vr_8 ) ;
return vr_20 ;
}
@Override
public void clear () {
fn_18 () ;
}
public tp_1 fn_19 () {
final vr_2 < tp_1 > vr_3 = vl_1 . vr_10 ;
if ( vr_3 == vl_1 ) {
throw new fn_20 () ;
}
return vr_3 . vr_4 () ;
}
public tp_1 fn_21 () {
final vr_2 < tp_1 > vr_3 = vl_1 . vr_11 ;
if ( vr_3 == vl_1 ) {
throw new fn_20 () ;
}
return vr_3 . vr_4 () ;
}
public boolean fn_22 ( final tp_1 vr_13 ) {
fn_23 ( vl_1 , vr_13 ) ;
return true ;
}
public boolean fn_10 ( final tp_1 vr_13 ) {
fn_11 ( vl_1 , vr_13 ) ;
return true ;
}
public tp_1 fn_24 () {
final vr_2 < tp_1 > vr_3 = vl_1 . vr_10 ;
if ( vr_3 == vl_1 ) {
throw new fn_20 () ;
}
final tp_1 vr_20 = vr_3 . vr_4 () ;
fn_13 ( vr_3 ) ;
return vr_20 ;
}
public tp_1 fn_25 () {
final vr_2 < tp_1 > vr_3 = vl_1 . vr_11 ;
if ( vr_3 == vl_1 ) {
throw new fn_20 () ;
}
final tp_1 vr_20 = vr_3 . vr_4 () ;
fn_13 ( vr_3 ) ;
return vr_20 ;
}
@Override
public boolean equals ( final Object vr_23 ) {
if ( vr_23 == this ) {
return true ;
}
if ( vr_23 instanceof List == false ) {
return false ;
}
final List < ? > vr_24 = ( List < ? > ) vr_23 ;
if ( vr_24 . size () != size () ) {
return false ;
}
final vr_5 < ? > vr_25 = fn_4 () ;
final vr_5 < ? > vr_26 = vr_24 . fn_4 () ;
while ( vr_25 . hasNext () && vr_26 . hasNext () ) {
final Object vr_27 = vr_25 . vr_10 () ;
final Object vr_28 = vr_26 . vr_10 () ;
if ( ! ( vr_27 == null ? vr_28 == null : vr_27 . equals ( vr_28 ) ) ) {
return false ;
}
}
return ! ( vr_25 . hasNext () || vr_26 . hasNext () ) ;
}
@Override
public int fn_26 () {
int fn_26 = 1 ;
for ( final tp_1 vr_19 : this ) {
fn_26 = 31 * fn_26 + ( vr_19 == null ? 0 : vr_19 . fn_26 () ) ;
}
return fn_26 ;
}
@Override
public String toString () {
if ( size () == 0 ) {
return lr_2 ;
}
final StringBuilder vr_29 = new StringBuilder ( 16 * size () ) ;
vr_29 . append ( '[' ) ;
final Iterator < tp_1 > vr_22 = iterator () ;
boolean hasNext = vr_22 . hasNext () ;
while ( hasNext ) {
final Object vr_8 = vr_22 . vr_10 () ;
vr_29 . append ( vr_8 == this ? lr_3 : vr_8 ) ;
hasNext = vr_22 . hasNext () ;
if ( hasNext ) {
vr_29 . append ( lr_4 ) ;
}
}
vr_29 . append ( ']' ) ;
return vr_29 . toString () ;
}
protected boolean fn_5 ( final Object vr_30 , final Object vr_31 ) {
return vr_30 == vr_31 || ( vr_30 != null && vr_30 . equals ( vr_31 ) ) ;
}
protected void fn_17 ( final vr_2 < tp_1 > vr_3 , final tp_1 vr_8 ) {
vr_3 . vr_32 ( vr_8 ) ;
}
protected vr_2 < tp_1 > fn_2 () {
return new vr_2 <> () ;
}
protected vr_2 < tp_1 > fn_27 ( final tp_1 vr_8 ) {
return new vr_2 <> ( vr_8 ) ;
}
protected void fn_11 ( final vr_2 < tp_1 > vr_3 , final tp_1 vr_8 ) {
final vr_2 < tp_1 > vr_33 = fn_27 ( vr_8 ) ;
fn_28 ( vr_33 , vr_3 ) ;
}
protected void fn_23 ( final vr_2 < tp_1 > vr_3 , final tp_1 vr_8 ) {
final vr_2 < tp_1 > vr_33 = fn_27 ( vr_8 ) ;
fn_28 ( vr_33 , vr_3 . vr_10 ) ;
}
protected void fn_28 ( final vr_2 < tp_1 > vr_34 , final vr_2 < tp_1 > vr_35 ) {
vr_34 . vr_10 = vr_35 ;
vr_34 . vr_11 = vr_35 . vr_11 ;
vr_35 . vr_11 . vr_10 = vr_34 ;
vr_35 . vr_11 = vr_34 ;
size ++ ;
vl_2 ++ ;
}
protected void fn_13 ( final vr_2 < tp_1 > vr_3 ) {
vr_3 . vr_11 . vr_10 = vr_3 . vr_10 ;
vr_3 . vr_10 . vr_11 = vr_3 . vr_11 ;
size -- ;
vl_2 ++ ;
}
protected void fn_18 () {
vl_1 . vr_10 = vl_1 ;
vl_1 . vr_11 = vl_1 ;
size = 0 ;
vl_2 ++ ;
}
protected vr_2 < tp_1 > fn_3 ( final int vr_1 , final boolean vr_36 ) throws vl_3 {
if ( vr_1 < 0 ) {
throw new vl_3 ( lr_5 +
lr_6 + vr_1 + lr_7 ) ;
}
if ( ! vr_36 && vr_1 == size ) {
throw new vl_3 ( lr_5 +
lr_6 + vr_1 + lr_8 ) ;
}
if ( vr_1 > size ) {
throw new vl_3 ( lr_5 +
lr_6 + vr_1 + lr_9 +
lr_10 + size + lr_11 ) ;
}
vr_2 < tp_1 > vr_3 ;
if ( vr_1 < size / 2 ) {
vr_3 = vl_1 . vr_10 ;
for ( int vr_37 = 0 ; vr_37 < vr_1 ; vr_37 ++ ) {
vr_3 = vr_3 . vr_10 ;
}
} else {
vr_3 = vl_1 ;
for ( int vr_37 = size ; vr_37 > vr_1 ; vr_37 -- ) {
vr_3 = vr_3 . vr_11 ;
}
}
return vr_3 ;
}
protected Iterator < tp_1 > fn_29 ( final vr_18 < tp_1 > fn_9 ) {
return fn_30 ( fn_9 , 0 ) ;
}
protected vr_5 < tp_1 > fn_30 ( final vr_18 < tp_1 > fn_9 , final int vr_7 ) {
return new vr_38 <> ( fn_9 , vr_7 ) ;
}
protected void fn_31 ( final tp_2 vr_39 ) throws IOException {
vr_39 . vr_40 ( size () ) ;
for ( final tp_1 vr_19 : this ) {
vr_39 . vr_41 ( vr_19 ) ;
}
}
@SuppressWarnings ( lr_1 )
protected void fn_32 ( final tp_3 vr_42 ) throws IOException , vl_4 {
fn_1 () ;
final int size = vr_42 . vr_43 () ;
for ( int vr_9 = 0 ; vr_9 < size ; vr_9 ++ ) {
add ( ( tp_1 ) vr_42 . vr_44 () ) ;
}
}
protected tp_1 vr_4 () {
return vr_8 ;
}
protected void vr_32 ( final tp_1 vr_8 ) {
this . vr_8 = vr_8 ;
}
protected vr_2 < tp_1 > fn_33 () {
return vr_11 ;
}
protected void fn_34 ( final vr_2 < tp_1 > vr_11 ) {
this . vr_11 = vr_11 ;
}
protected vr_2 < tp_1 > fn_35 () {
return vr_10 ;
}
protected void fn_36 ( final vr_2 < tp_1 > vr_10 ) {
this . vr_10 = vr_10 ;
}
protected void fn_37 () {
if ( vr_45 . vl_2 != vl_5 ) {
throw new fn_38 () ;
}
}
protected vr_2 < tp_1 > fn_39 () throws vl_6 {
if ( vl_7 == null ) {
throw new vl_6 () ;
}
return vl_7 ;
}
@Override
public boolean hasNext () {
return vr_10 != vr_45 . vl_1 ; MST[rv.CRCR5Mutator]MSP[N]
}
@Override
public tp_1 vr_10 () {
fn_37 () ;
if ( ! hasNext () ) {
throw new fn_20 ( lr_12 + vl_8 + lr_13 ) ;
}
final tp_1 vr_8 = vr_10 . vr_4 () ;
vl_7 = vr_10 ;
vr_10 = vr_10 . vr_10 ;
vl_8 ++ ;
return vr_8 ;
}
@Override
public boolean fn_40 () {
return vr_10 . vr_11 != vr_45 . vl_1 ;
}
@Override
public tp_1 vr_11 () {
fn_37 () ;
if ( ! fn_40 () ) {
throw new fn_20 ( lr_14 ) ;
}
vr_10 = vr_10 . vr_11 ;
final tp_1 vr_8 = vr_10 . vr_4 () ;
vl_7 = vr_10 ;
vl_8 -- ;
return vr_8 ;
}
@Override
public int vl_8 () {
return vl_8 ;
}
@Override
public int fn_41 () {
return vl_8 () - 1 ;
}
@Override
public void remove () {
fn_37 () ;
if ( vl_7 == vr_10 ) {
vr_10 = vr_10 . vr_10 ;
vr_45 . fn_13 ( fn_39 () ) ;
} else {
vr_45 . fn_13 ( fn_39 () ) ;
vl_8 -- ;
}
vl_7 = null ;
vl_5 ++ ;
}
@Override
public void fn_16 ( final tp_1 vr_23 ) {
fn_37 () ;
fn_39 () . vr_32 ( vr_23 ) ;
}
@Override
public void add ( final tp_1 vr_23 ) {
fn_37 () ;
vr_45 . fn_11 ( vr_10 , vr_23 ) ;
vl_7 = null ;
vl_8 ++ ;
vl_5 ++ ;
}
@Override
public boolean hasNext () {
return vl_8 () < vr_46 . size ;
}
@Override
public boolean fn_40 () {
return fn_41 () >= 0 ;
}
@Override
public int vl_8 () {
return super . vl_8 () - vr_46 . vr_47 ;
}
@Override
public void add ( final tp_1 vr_23 ) {
super . add ( vr_23 ) ;
vr_46 . vl_5 = vr_45 . vl_2 ;
vr_46 . size ++ ;
}
@Override
public void remove () {
super . remove () ;
vr_46 . vl_5 = vr_45 . vl_2 ;
vr_46 . size -- ;
}
@Override
public int size () {
fn_37 () ;
return size ;
}
@Override
public tp_1 get ( final int vr_1 ) {
fn_42 ( vr_1 , size ) ;
fn_37 () ;
return vr_45 . get ( vr_1 + vr_47 ) ;
}
@Override
public void add ( final int vr_1 , final tp_1 vr_23 ) {
fn_42 ( vr_1 , size + 1 ) ;
fn_37 () ;
vr_45 . add ( vr_1 + vr_47 , vr_23 ) ;
vl_5 = vr_45 . vl_2 ;
size ++ ;
vr_18 . this . vl_2 ++ ;
}
@Override
public tp_1 remove ( final int vr_1 ) {
fn_42 ( vr_1 , size ) ;
fn_37 () ;
final tp_1 vr_48 = vr_45 . remove ( vr_1 + vr_47 ) ;
vl_5 = vr_45 . vl_2 ;
size -- ;
vr_18 . this . vl_2 ++ ;
return vr_48 ;
}
@Override
public boolean fn_12 ( final Collection < ? extends tp_1 > vr_12 ) {
return fn_12 ( size , vr_12 ) ;
}
@Override
public boolean fn_12 ( final int vr_1 , final Collection < ? extends tp_1 > vr_12 ) {
fn_42 ( vr_1 , size + 1 ) ;
final int vr_49 = vr_12 . size () ;
if ( vr_49 == 0 ) {
return false ;
}
fn_37 () ;
vr_45 . fn_12 ( vr_47 + vr_1 , vr_12 ) ;
vl_5 = vr_45 . vl_2 ;
size += vr_49 ;
vr_18 . this . vl_2 ++ ;
return true ;
}
@Override
public tp_1 fn_16 ( final int vr_1 , final tp_1 vr_23 ) {
fn_42 ( vr_1 , size ) ;
fn_37 () ;
return vr_45 . fn_16 ( vr_1 + vr_47 , vr_23 ) ;
}
@Override
public void clear () {
fn_37 () ;
final Iterator < tp_1 > vr_22 = iterator () ;
while ( vr_22 . hasNext () ) {
vr_22 . vr_10 () ;
vr_22 . remove () ;
}
}
@Override
public Iterator < tp_1 > iterator () {
fn_37 () ;
return vr_45 . fn_29 ( this ) ;
}
@Override
public vr_5 < tp_1 > fn_4 ( final int vr_1 ) {
fn_42 ( vr_1 , size + 1 ) ;
fn_37 () ;
return vr_45 . fn_30 ( this , vr_1 ) ;
}
@Override
public List < tp_1 > fn_9 ( final int vr_16 , final int vr_17 ) {
return new vr_18 <> ( vr_45 , vr_16 + vr_47 , vr_17 + vr_47 ) ;
}
protected void fn_42 ( final int vr_1 , final int vr_50 ) {
if ( vr_1 < 0 || vr_1 >= vr_50 ) {
throw new vl_3 ( lr_15 + vr_1 + lr_16 + size + lr_17 ) ;
}
}
protected void fn_37 () {
if ( vr_45 . vl_2 != vl_5 ) {
throw new fn_38 () ;
}
}

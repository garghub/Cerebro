@Override
public int size () {
int vr_1 = 0 ;
for ( final vr_2 < vt_1 > vr_3 : fn_1 () ) {
vr_1 += vr_3 . vr_4 () ;
}
return vr_1 ;
}
@Override
public int vr_4 ( final Object object ) {
for ( final vr_2 < vt_1 > vr_3 : fn_1 () ) {
final vt_1 vr_5 = vr_3 . vr_6 () ;
if ( vr_5 == object ||
vr_5 != null && vr_5 . equals ( object ) ) {
return vr_3 . vr_4 () ;
}
}
return 0 ;
}
@Override
public int fn_2 ( final vt_1 object , final int vr_7 ) {
if ( vr_7 < 0 ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
final int vr_8 = vr_4 ( object ) ;
if ( vr_8 < vr_7 ) {
add ( object , vr_7 - vr_8 ) ;
} else {
remove ( object , vr_8 - vr_7 ) ;
}
return vr_8 ;
}
@Override
public boolean contains ( final Object object ) {
return vr_4 ( object ) > 0 ;
}
@Override
public Iterator < vt_1 > iterator () {
return new vr_9 <> ( this ) ;
}
@Override
public boolean hasNext () {
return vl_1 > 0 || vr_10 . hasNext () ;
}
@Override
public vt_1 fn_3 () {
if ( vl_1 == 0 ) {
vl_2 = vr_10 . fn_3 () ;
vl_1 = vl_2 . vr_4 () ;
}
vl_3 = true ;
vl_1 -- ;
return vl_2 . vr_6 () ;
}
@Override
public void remove () {
if ( vl_3 == false ) {
throw new fn_4 () ;
}
final int vr_7 = vl_2 . vr_4 () ;
if ( vr_7 > 1 ) {
vr_11 . remove ( vl_2 . vr_6 () ) ;
} else {
vr_10 . remove () ;
}
vl_3 = false ;
}
@Override
public boolean add ( final vt_1 object ) {
add ( object , 1 ) ;
return true ;
}
@Override
public int add ( final vt_1 object , final int vr_12 ) {
throw new fn_5 () ;
}
@Override
public void clear () {
final Iterator < vr_2 < vt_1 > > vr_13 = fn_1 () . iterator () ;
while ( vr_13 . hasNext () ) {
vr_13 . fn_3 () ;
vr_13 . remove () ;
}
}
@Override
public boolean remove ( final Object object ) {
return remove ( object , 1 ) != 0 ;
}
@Override
public int remove ( final Object object , final int vr_12 ) {
throw new fn_5 () ;
}
@Override
public boolean fn_6 ( final Collection < ? > vr_14 ) {
boolean vr_15 = false ;
final Iterator < ? > vr_16 = vr_14 . iterator () ;
while ( vr_16 . hasNext () ) {
final Object vr_17 = vr_16 . fn_3 () ;
final boolean vr_18 = remove ( vr_17 , vr_4 ( vr_17 ) ) != 0 ;
vr_15 = vr_15 || vr_18 ;
}
return vr_15 ;
}
@Override
public vr_19 < vt_1 > fn_7 () {
if ( fn_7 == null ) {
fn_7 = fn_8 () ;
}
return fn_7 ;
}
protected vr_19 < vt_1 > fn_8 () {
return new vr_20 <> ( this ) ; MST[ConstructorCallMutator]MSP[]
}
protected Iterator < vt_1 > fn_9 () {
final vr_21 < vr_2 < vt_1 > , vt_1 > vr_22 = vr_3 -> vr_3 . vr_6 () ;
return vr_23 . vr_24 ( fn_1 () . iterator () , vr_22 ) ;
}
@Override
public vr_19 < vr_2 < vt_1 > > fn_1 () {
if ( fn_1 == null ) {
fn_1 = fn_10 () ;
}
return fn_1 ;
}
protected vr_19 < vr_2 < vt_1 > > fn_10 () {
return new vr_25 <> ( this ) ;
}
@Override
public Iterator < vt_1 > iterator () {
return vr_11 . fn_9 () ;
}
@Override
public boolean contains ( final Object vr_26 ) {
return vr_11 . contains ( vr_26 ) ;
}
@Override
public boolean fn_11 ( final Collection < ? > vr_14 ) {
return vr_11 . fn_11 ( vr_14 ) ;
}
@Override
public boolean remove ( final Object vr_26 ) {
return vr_11 . remove ( vr_26 , vr_11 . vr_4 ( vr_26 ) ) != 0 ;
}
@Override
public int size () {
return vr_11 . vr_27 () ;
}
@Override
public void clear () {
vr_11 . clear () ;
}
@Override
public int size () {
return vr_11 . vr_27 () ;
}
@Override
public Iterator < vr_2 < vt_1 > > iterator () {
return vr_11 . vr_28 () ;
}
@Override
public boolean contains ( final Object vr_17 ) {
if ( vr_17 instanceof vr_2 < ? > == false ) {
return false ;
}
final vr_2 < ? > vr_3 = ( vr_2 < ? > ) vr_17 ;
final Object vr_5 = vr_3 . vr_6 () ;
return vr_11 . vr_4 ( vr_5 ) == vr_3 . vr_4 () ;
}
@Override
public boolean remove ( final Object vr_17 ) {
if ( vr_17 instanceof vr_2 < ? > == false ) {
return false ;
}
final vr_2 < ? > vr_3 = ( vr_2 < ? > ) vr_17 ;
final Object vr_5 = vr_3 . vr_6 () ;
if ( vr_11 . contains ( vr_5 ) ) {
final int vr_7 = vr_11 . vr_4 ( vr_5 ) ;
if ( vr_3 . vr_4 () == vr_7 ) {
vr_11 . remove ( vr_5 , vr_7 ) ;
return true ;
}
}
return false ;
}
@Override
public boolean equals ( final Object object ) {
if ( object instanceof vr_2 ) {
final vr_2 < ? > vr_29 = ( vr_2 < ? > ) object ;
final vt_1 vr_5 = this . vr_6 () ;
final Object vr_30 = vr_29 . vr_6 () ;
return this . vr_4 () == vr_29 . vr_4 () &&
( vr_5 == vr_30 ||
vr_5 != null && vr_5 . equals ( vr_30 ) ) ;
}
return false ;
}
@Override
public int fn_12 () {
final vt_1 vr_5 = vr_6 () ;
return ( ( vr_5 == null ) ? 0 : vr_5 . fn_12 () ) ^ vr_4 () ;
}
@Override
public String toString () {
return String . vr_31 ( lr_2 , vr_6 () , vr_4 () ) ;
}
protected void fn_13 ( final tp_1 out ) throws IOException {
out . vr_32 ( fn_1 () . size () ) ;
for ( final vr_2 < vt_1 > vr_3 : fn_1 () ) {
out . vr_33 ( vr_3 . vr_6 () ) ;
out . vr_32 ( vr_3 . vr_4 () ) ;
}
}
protected void fn_14 ( final tp_2 vr_34 )
throws IOException , vl_4 {
final int vr_35 = vr_34 . vr_36 () ;
for ( int vr_16 = 0 ; vr_16 < vr_35 ; vr_16 ++ ) {
@SuppressWarnings ( lr_3 )
final vt_1 vr_17 = ( vt_1 ) vr_34 . vr_37 () ;
final int vr_7 = vr_34 . vr_36 () ;
fn_2 ( vr_17 , vr_7 ) ;
}
}
@Override
public boolean equals ( final Object object ) {
if ( object == this ) {
return true ;
}
if ( object instanceof vl_5 == false ) {
return false ;
}
final vl_5 < ? > vr_29 = ( vl_5 < ? > ) object ;
if ( vr_29 . size () != size () ) {
return false ;
}
for ( final vr_2 < vt_1 > vr_3 : fn_1 () ) {
if ( vr_29 . vr_4 ( vr_3 . vr_6 () ) != vr_4 ( vr_3 . vr_6 () ) ) {
return false ;
}
}
return true ;
}
@Override
public int fn_12 () {
return fn_1 () . fn_12 () ;
}
@Override
public String toString () {
return fn_1 () . toString () ;
}

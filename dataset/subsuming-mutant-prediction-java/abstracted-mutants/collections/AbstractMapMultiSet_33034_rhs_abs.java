protected vr_1 < vt_1 , vt_2 > fn_1 () {
return vl_1 ;
}
protected void fn_2 ( final vr_1 < vt_1 , vt_2 > vl_1 ) {
this . vl_1 = vl_1 ;
}
@Override
public int size () {
return size ;
}
@Override
public boolean isEmpty () {
return vl_1 . isEmpty () ;
}
@Override
public int fn_3 ( final Object object ) {
final vt_2 vr_2 = vl_1 . get ( object ) ;
if ( vr_2 != null ) {
return vr_2 . vr_3 ;
}
return 0 ;
}
@Override
public boolean contains ( final Object object ) {
return vl_1 . vr_4 ( object ) ;
}
@Override
public Iterator < vt_1 > iterator () {
return new vr_5 <> ( this ) ;
}
@Override
public boolean hasNext () {
return vl_2 > 0 || vr_6 . hasNext () ;
}
@Override
public vt_1 fn_4 () {
if ( vr_7 . vr_8 != vl_3 ) { MST[rv.ROR5Mutator]MSP[N]
throw new fn_5 () ;
}
if ( vl_2 == 0 ) {
vl_4 = vr_6 . fn_4 () ;
vl_2 = vl_4 . vr_9 () . vr_3 ;
}
vl_5 = true ;
vl_2 -- ;
return vl_4 . vr_10 () ;
}
@Override
public void remove () {
if ( vr_7 . vr_8 != vl_3 ) {
throw new fn_5 () ;
}
if ( vl_5 == false ) {
throw new fn_6 () ;
}
final vt_2 vr_11 = vl_4 . vr_9 () ;
if ( vr_11 . vr_3 > 1 ) {
vr_11 . vr_3 -- ;
} else {
vr_6 . remove () ;
}
vr_7 . size -- ;
vl_5 = false ;
}
@Override
public int add ( final vt_1 object , final int vr_12 ) {
if ( vr_12 < 0 ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
final vt_2 vr_11 = vl_1 . get ( object ) ;
final int vr_13 = vr_11 != null ? vr_11 . vr_3 : 0 ;
if ( vr_12 > 0 ) {
vr_8 ++ ;
size += vr_12 ;
if ( vr_11 == null ) {
vl_1 . vr_14 ( object , new vt_2 ( vr_12 ) ) ;
} else {
vr_11 . vr_3 += vr_12 ;
}
}
return vr_13 ;
}
@Override
public void clear () {
vr_8 ++ ;
vl_1 . clear () ;
size = 0 ;
}
@Override
public int remove ( final Object object , final int vr_12 ) {
if ( vr_12 < 0 ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
final vt_2 vr_11 = vl_1 . get ( object ) ;
if ( vr_11 == null ) {
return 0 ;
}
final int vr_13 = vr_11 . vr_3 ;
if ( vr_12 > 0 ) {
vr_8 ++ ;
if ( vr_12 < vr_11 . vr_3 ) {
vr_11 . vr_3 -= vr_12 ;
size -= vr_12 ;
} else {
vl_1 . remove ( object ) ;
size -= vr_11 . vr_3 ;
vr_11 . vr_3 = 0 ;
}
}
return vr_13 ;
}
@Override
public boolean equals ( final Object vr_15 ) {
if ( vr_15 instanceof vt_2 == false ) {
return false ;
}
return ( ( vt_2 ) vr_15 ) . vr_3 == vr_3 ;
}
@Override
public int fn_7 () {
return vr_3 ;
}
@Override
protected Iterator < vt_1 > fn_8 () {
return new vr_16 <> ( fn_1 () . fn_9 () . iterator () , this ) ;
}
@Override
protected int fn_10 () {
return vl_1 . size () ;
}
@Override
protected Iterator < vr_17 < vt_1 > > fn_11 () {
return new vr_18 <> ( vl_1 . vr_19 () . iterator () , this ) ;
}
@Override
public vt_1 fn_4 () {
vl_6 = super . fn_4 () ;
vl_5 = true ;
return vl_6 ;
}
@Override
public void remove () {
if ( vl_5 == false ) {
throw new fn_6 ( lr_2 ) ;
}
final int vr_2 = vr_7 . fn_3 ( vl_6 ) ;
super . remove () ;
vr_7 . remove ( vl_6 , vr_2 ) ;
vl_6 = null ;
vl_5 = false ;
}
@Override
public boolean hasNext () {
return vr_20 . hasNext () ;
}
@Override
public vr_17 < vt_1 > fn_4 () {
vl_7 = new vr_21 <> ( vr_20 . fn_4 () ) ;
vl_5 = true ;
return vl_7 ;
}
@Override
public void remove () {
if ( vl_5 == false ) {
throw new fn_6 ( lr_2 ) ;
}
vr_20 . remove () ;
vl_7 = null ;
vl_5 = false ;
}
@Override
public vt_1 fn_12 () {
return vr_22 . vr_10 () ;
}
@Override
public int fn_3 () {
return vr_22 . vr_9 () . vr_3 ;
}
@Override
protected void fn_13 ( final tp_1 out ) throws IOException {
out . vr_23 ( vl_1 . size () ) ;
for ( final vr_1 . vr_17 < vt_1 , vt_2 > vr_24 : vl_1 . vr_19 () ) {
out . vr_25 ( vr_24 . vr_10 () ) ;
out . vr_23 ( vr_24 . vr_9 () . vr_3 ) ;
}
}
@Override
protected void fn_14 ( final tp_2 vr_26 )
throws IOException , vl_8 {
final int vr_27 = vr_26 . vr_28 () ;
for ( int vr_29 = 0 ; vr_29 < vr_27 ; vr_29 ++ ) {
@SuppressWarnings ( lr_3 )
final vt_1 vr_15 = ( vt_1 ) vr_26 . vr_30 () ;
final int vr_2 = vr_26 . vr_28 () ;
vl_1 . vr_14 ( vr_15 , new vt_2 ( vr_2 ) ) ;
size += vr_2 ;
}
}
@Override
public Object [] toArray () {
final Object [] vr_31 = new Object [ size () ] ;
int vr_29 = 0 ;
for ( final vr_1 . vr_17 < vt_1 , vt_2 > vr_24 : vl_1 . vr_19 () ) {
final vt_1 vl_4 = vr_24 . vr_10 () ;
final vt_2 vr_2 = vr_24 . vr_9 () ;
for ( int vr_32 = vr_2 . vr_3 ; vr_32 > 0 ; vr_32 -- ) {
vr_31 [ vr_29 ++ ] = vl_4 ;
}
}
return vr_31 ;
}
@Override
public < vt_3 > vt_3 [] toArray ( vt_3 [] array ) {
final int size = size () ;
if ( array . length < size ) {
@SuppressWarnings ( lr_3 )
final vt_3 [] vr_33 = ( vt_3 [] ) Array . vr_34 ( array . getClass () . fn_15 () , size ) ;
array = vr_33 ;
}
int vr_29 = 0 ;
for ( final vr_1 . vr_17 < vt_1 , vt_2 > vr_24 : vl_1 . vr_19 () ) {
final vt_1 vl_4 = vr_24 . vr_10 () ;
final vt_2 vr_2 = vr_24 . vr_9 () ;
for ( int vr_32 = vr_2 . vr_3 ; vr_32 > 0 ; vr_32 -- ) {
@SuppressWarnings ( lr_3 )
final vt_3 vr_33 = ( vt_3 ) vl_4 ;
array [ vr_29 ++ ] = vr_33 ;
}
}
while ( vr_29 < array . length ) {
array [ vr_29 ++ ] = null ;
}
return array ;
}
@Override
public boolean equals ( final Object object ) {
if ( object == this ) {
return true ;
}
if ( object instanceof vl_9 == false ) {
return false ;
}
final vl_9 < ? > vr_35 = ( vl_9 < ? > ) object ;
if ( vr_35 . size () != size () ) {
return false ;
}
for ( final vt_1 vr_36 : vl_1 . fn_9 () ) {
if ( vr_35 . fn_3 ( vr_36 ) != fn_3 ( vr_36 ) ) {
return false ;
}
}
return true ;
}
@Override
public int fn_7 () {
int vr_37 = 0 ;
for ( final vr_1 . vr_17 < vt_1 , vt_2 > vr_24 : vl_1 . vr_19 () ) {
final vt_1 vr_36 = vr_24 . vr_10 () ;
final vt_2 vr_2 = vr_24 . vr_9 () ;
vr_37 += ( vr_36 == null ? 0 : vr_36 . fn_7 () ) ^ vr_2 . vr_3 ;
}
return vr_37 ;
}

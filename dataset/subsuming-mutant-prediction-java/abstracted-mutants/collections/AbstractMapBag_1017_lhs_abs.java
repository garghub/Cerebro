protected vr_1 < vt_1 , vt_2 > fn_1 () {
return vl_1 ;
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
public int fn_2 ( final Object object ) {
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
public boolean fn_3 ( final Collection < ? > vr_5 ) {
if ( vr_5 instanceof vl_2 ) {
return fn_3 ( ( vl_2 < ? > ) vr_5 ) ;
}
return fn_3 ( new vr_6 <> ( vr_5 ) ) ;
}
boolean fn_3 ( final vl_2 < ? > vr_7 ) {
final Iterator < ? > vr_8 = vr_7 . vr_9 () . iterator () ;
while ( vr_8 . hasNext () ) {
final Object vr_10 = vr_8 . vr_11 () ;
if ( fn_2 ( vr_10 ) < vr_7 . fn_2 ( vr_10 ) ) {
return false ;
}
}
return true ;
}
@Override
public Iterator < vt_1 > iterator () {
return new vr_12 <> ( this ) ;
}
@Override
public boolean hasNext () {
return vl_3 > 0 || vr_13 . hasNext () ;
}
@Override
public vt_1 vr_11 () {
if ( vr_14 . vr_15 != vl_4 ) {
throw new fn_4 () ;
}
if ( vl_3 == 0 ) {
vr_10 = vr_13 . vr_11 () ;
vl_3 = vr_10 . vr_16 () . vr_3 ;
}
vl_5 = true ;
vl_3 -- ;
return vr_10 . vr_17 () ;
}
@Override
public void remove () {
if ( vr_14 . vr_15 != vl_4 ) {
throw new fn_4 () ;
}
if ( vl_5 == false ) {
throw new fn_5 () ;
}
final vt_2 vr_18 = vr_10 . vr_16 () ;
if ( vr_18 . vr_3 > 1 ) {
vr_18 . vr_3 -- ;
} else {
vr_13 . remove () ;
}
vr_14 . size -- ;
vl_5 = false ;
}
@Override
public boolean add ( final vt_1 object ) {
return add ( object , 1 ) ;
}
@Override
public boolean add ( final vt_1 object , final int vr_19 ) {
vr_15 ++ ;
if ( vr_19 > 0 ) {
final vt_2 vr_18 = vl_1 . get ( object ) ;
size += vr_19 ;
if ( vr_18 == null ) {
vl_1 . vr_20 ( object , new vt_2 ( vr_19 ) ) ;
return true ;
}
vr_18 . vr_3 += vr_19 ;
return false ;
}
return false ;
}
@Override
public boolean fn_6 ( final Collection < ? extends vt_1 > vr_5 ) {
boolean vr_21 = false ;
final Iterator < ? extends vt_1 > vr_22 = vr_5 . iterator () ;
while ( vr_22 . hasNext () ) {
final boolean vr_23 = add ( vr_22 . vr_11 () ) ;
vr_21 = vr_21 || vr_23 ;
}
return vr_21 ;
}
@Override
public void clear () {
vr_15 ++ ;
vl_1 . clear () ;
size = 0 ;
}
@Override
public boolean remove ( final Object object ) {
final vt_2 vr_18 = vl_1 . get ( object ) ;
if ( vr_18 == null ) {
return false ;
}
vr_15 ++ ;
vl_1 . remove ( object ) ;
size -= vr_18 . vr_3 ;
return true ;
}
@Override
public boolean remove ( final Object object , final int vr_19 ) {
final vt_2 vr_18 = vl_1 . get ( object ) ;
if ( vr_18 == null ) {
return false ;
}
if ( vr_19 <= 0 ) {
return false ;
}
vr_15 ++ ;
if ( vr_19 < vr_18 . vr_3 ) {
vr_18 . vr_3 -= vr_19 ;
size -= vr_19 ;
} else {
vl_1 . remove ( object ) ;
size -= vr_18 . vr_3 ;
}
return true ;
}
@Override
public boolean fn_7 ( final Collection < ? > vr_5 ) {
boolean vr_24 = false ;
if ( vr_5 != null ) {
final Iterator < ? > vr_22 = vr_5 . iterator () ;
while ( vr_22 . hasNext () ) {
final boolean vr_21 = remove ( vr_22 . vr_11 () , 1 ) ;
vr_24 = vr_24 || vr_21 ;
}
}
return vr_24 ;
}
@Override
public boolean fn_8 ( final Collection < ? > vr_5 ) {
if ( vr_5 instanceof vl_2 ) {
return fn_8 ( ( vl_2 < ? > ) vr_5 ) ;
}
return fn_8 ( new vr_6 <> ( vr_5 ) ) ;
}
boolean fn_8 ( final vl_2 < ? > vr_7 ) {
boolean vr_24 = false ;
final vl_2 < vt_1 > vr_25 = new vr_6 <> () ;
final Iterator < vt_1 > vr_22 = vr_9 () . iterator () ;
while ( vr_22 . hasNext () ) {
final vt_1 vr_10 = vr_22 . vr_11 () ;
final int vr_26 = fn_2 ( vr_10 ) ;
final int vr_27 = vr_7 . fn_2 ( vr_10 ) ;
if ( 1 <= vr_27 && vr_27 <= vr_26 ) {
vr_25 . add ( vr_10 , vr_26 - vr_27 ) ;
} else {
vr_25 . add ( vr_10 , vr_26 ) ;
}
}
if ( ! vr_25 . isEmpty () ) {
vr_24 = fn_7 ( vr_25 ) ;
}
return vr_24 ;
}
@Override
public boolean equals ( final Object vr_28 ) {
if ( vr_28 instanceof vt_2 == false ) {
return false ;
}
return ( ( vt_2 ) vr_28 ) . vr_3 == vr_3 ;
}
@Override
public int fn_9 () {
return vr_3 ;
}
@Override
public Object [] toArray () {
final Object [] vr_24 = new Object [ size () ] ;
int vr_22 = 0 ;
final Iterator < vt_1 > vr_8 = vl_1 . vr_29 () . iterator () ;
while ( vr_8 . hasNext () ) {
final vt_1 vr_10 = vr_8 . vr_11 () ;
for ( int vr_30 = fn_2 ( vr_10 ) ; vr_30 > 0 ; vr_30 -- ) {
vr_24 [ vr_22 ++ ] = vr_10 ;
}
}
return vr_24 ;
}
@Override
public < vt_3 > vt_3 [] toArray ( vt_3 [] array ) {
final int size = size () ;
if ( array . length < size ) { MST[rv.UOI2Mutator]MSP[]
@SuppressWarnings ( lr_1 )
final vt_3 [] vr_31 = ( vt_3 [] ) Array . vr_32 ( array . getClass () . fn_10 () , size ) ;
array = vr_31 ;
}
int vr_22 = 0 ;
final Iterator < vt_1 > vr_8 = vl_1 . vr_29 () . iterator () ;
while ( vr_8 . hasNext () ) {
final vt_1 vr_10 = vr_8 . vr_11 () ;
for ( int vr_30 = fn_2 ( vr_10 ) ; vr_30 > 0 ; vr_30 -- ) {
@SuppressWarnings ( lr_1 )
final vt_3 vr_31 = ( vt_3 ) vr_10 ;
array [ vr_22 ++ ] = vr_31 ;
}
}
while ( vr_22 < array . length ) {
array [ vr_22 ++ ] = null ;
}
return array ;
}
@Override
public vr_33 < vt_1 > vr_9 () {
if ( vr_9 == null ) {
vr_9 = vr_34 . <vt_1 > fn_11 ( vl_1 . vr_29 () ) ;
}
return vr_9 ;
}
protected void fn_12 ( final tp_1 out ) throws IOException {
out . vr_35 ( vl_1 . size () ) ;
for ( final vr_36 < vt_1 , vt_2 > vr_37 : vl_1 . vr_38 () ) {
out . vr_39 ( vr_37 . vr_17 () ) ;
out . vr_35 ( vr_37 . vr_16 () . vr_3 ) ;
}
}
protected void fn_13 ( final vr_1 < vt_1 , vt_2 > vl_1 , final tp_2 vr_40 )
throws IOException , vl_6 {
this . vl_1 = vl_1 ;
final int vr_41 = vr_40 . vr_42 () ;
for ( int vr_22 = 0 ; vr_22 < vr_41 ; vr_22 ++ ) {
@SuppressWarnings ( lr_1 )
final vt_1 vr_28 = ( vt_1 ) vr_40 . vr_43 () ;
final int vr_2 = vr_40 . vr_42 () ;
vl_1 . vr_20 ( vr_28 , new vt_2 ( vr_2 ) ) ;
size += vr_2 ;
}
}
@Override
public boolean equals ( final Object object ) {
if ( object == this ) {
return true ;
}
if ( object instanceof vl_2 == false ) {
return false ;
}
final vl_2 < ? > vr_7 = ( vl_2 < ? > ) object ;
if ( vr_7 . size () != size () ) {
return false ;
}
for ( final vt_1 vr_44 : vl_1 . vr_29 () ) {
if ( vr_7 . fn_2 ( vr_44 ) != fn_2 ( vr_44 ) ) {
return false ;
}
}
return true ;
}
@Override
public int fn_9 () {
int vr_45 = 0 ;
for ( final vr_36 < vt_1 , vt_2 > vr_37 : vl_1 . vr_38 () ) {
final vt_1 vr_44 = vr_37 . vr_17 () ;
final vt_2 vr_2 = vr_37 . vr_16 () ;
vr_45 += ( vr_44 == null ? 0 : vr_44 . fn_9 () ) ^ vr_2 . vr_3 ;
}
return vr_45 ;
}
@Override
public String toString () {
if ( size () == 0 ) {
return lr_2 ;
}
final StringBuilder vr_46 = new StringBuilder () ;
vr_46 . append ( '[' ) ;
final Iterator < vt_1 > vr_8 = vr_9 () . iterator () ;
while ( vr_8 . hasNext () ) {
final Object vr_10 = vr_8 . vr_11 () ;
final int vr_2 = fn_2 ( vr_10 ) ;
vr_46 . append ( vr_2 ) ;
vr_46 . append ( ':' ) ;
vr_46 . append ( vr_10 ) ;
if ( vr_8 . hasNext () ) {
vr_46 . append ( ',' ) ;
}
}
vr_46 . append ( ']' ) ;
return vr_46 . toString () ;
}

@SuppressWarnings ( lr_1 )
private static < vt_1 > Class < ? extends vt_1 > getClass ( final vt_1 vr_1 ) {
return ( Class < ? extends vt_1 > ) ( vr_1 == null ? Object . class : vr_1 . getClass () ) ;
}
private static < vt_1 > Class < ? extends vt_1 > fn_1 ( final vt_1 ... vr_2 ) {
@SuppressWarnings ( lr_1 )
final Class < ? extends vt_1 > vr_3 = ( Class < ? extends vt_1 > ) Object . class ;
if ( vr_2 == null ) {
return vr_3 ;
}
Class < ? extends vt_1 > vr_4 = vr_2 . length > 0 ? getClass ( vr_2 [ 0 ] ) : vr_3 ;
for ( int vr_5 = 1 ; vr_5 < vr_2 . length ; vr_5 ++ ) {
final Class < ? extends vt_1 > vr_6 = getClass ( vr_2 [ vr_5 ] ) ;
if ( vr_4 != vr_6 ) {
return vr_3 ;
}
vr_4 = vr_6 ;
}
return vr_4 ;
}
private static < vt_1 > vt_1 [] fn_2 ( final vt_1 vr_7 , final vt_1 vr_8 ) {
@SuppressWarnings ( lr_1 )
final vt_1 [] array = ( vt_1 [] ) Array . vr_9 ( fn_1 ( vr_7 , vr_8 ) , 2 ) ;
array [ 0 ] = vr_7 ;
array [ 1 ] = vr_8 ;
return array ;
}
private static < vt_1 > vt_1 [] fn_2 ( final vt_1 vr_7 , final vt_1 vr_8 , final vt_1 vr_10 ) {
@SuppressWarnings ( lr_1 )
final vt_1 [] array = ( vt_1 [] ) Array . vr_9 ( fn_1 ( vr_7 , vr_8 , vr_10 ) , 3 ) ;
array [ 0 ] = vr_7 ;
array [ 1 ] = vr_8 ;
array [ 2 ] = vr_10 ;
return array ;
}
private static < vt_1 > vt_1 [] fn_2 ( final vt_1 vr_7 , final vt_1 vr_8 , final vt_1 vr_10 , final vt_1 vr_11 ) {
@SuppressWarnings ( lr_1 )
final vt_1 [] array = ( vt_1 [] ) Array . vr_9 ( fn_1 ( vr_7 , vr_8 , vr_10 , vr_11 ) , 4 ) ;
array [ 0 ] = vr_7 ;
array [ 1 ] = vr_8 ;
array [ 2 ] = vr_10 ;
array [ 3 ] = vr_11 ;
return array ;
}
private static < vt_1 > vt_1 [] fn_2 ( final vt_1 vr_7 , final vt_1 vr_8 , final vt_1 vr_10 , final vt_1 vr_11 , final vt_1 vr_12 ) {
@SuppressWarnings ( lr_1 )
final vt_1 [] array = ( vt_1 [] ) Array . vr_9 ( fn_1 ( vr_7 , vr_8 , vr_10 , vr_11 , vr_12 ) , 5 ) ;
array [ 0 ] = vr_7 ;
array [ 1 ] = vr_8 ;
array [ 2 ] = vr_10 ;
array [ 3 ] = vr_11 ;
array [ 4 ] = vr_12 ;
return array ;
}
private void fn_3 ( final Object [] vr_13 ) {
int vr_14 = 0 ;
for ( final Object vr_15 : vr_13 ) { MST[rv.UOI1Mutator]MSP[]
if ( vr_15 != null ) {
vr_14 ^= vr_15 . vr_16 () ;
}
}
vr_16 = vr_14 ;
}
@Override
public boolean equals ( final Object vr_17 ) {
if ( vr_17 == this ) {
return true ;
}
if ( vr_17 instanceof vl_1 ) {
final vl_1 < ? > vr_18 = ( vl_1 < ? > ) vr_17 ;
return vr_19 . equals ( vr_13 , vr_18 . vr_13 ) ;
}
return false ;
}
public tp_1 fn_4 ( final int vr_20 ) {
return vr_13 [ vr_20 ] ;
}
public tp_1 [] fn_5 () {
return vr_13 . vr_21 () ;
}
@Override
public int vr_16 () {
return vr_16 ;
}
protected Object fn_6 () {
fn_3 ( vr_13 ) ;
return this ;
}
public int size () {
return vr_13 . length ;
}
@Override
public String toString () {
return lr_2 + vr_19 . toString ( vr_13 ) ;
}

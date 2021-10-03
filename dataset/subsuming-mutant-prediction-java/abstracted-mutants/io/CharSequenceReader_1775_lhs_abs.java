@Override
public void fn_1 () {
vl_1 = 0 ;
vl_2 = 0 ;
}
@Override
public void vl_2 ( final int vr_1 ) {
vl_2 = vl_1 ;
}
@Override
public boolean fn_2 () {
return true ;
}
@Override
public int fn_3 () {
if ( vl_1 >= vr_2 . length () ) {
return vl_3 ;
}
return vr_2 . charAt ( vl_1 ++ ) ;
}
@Override
public int fn_3 ( final char [] array , final int vr_3 , final int length ) {
if ( vl_1 >= vr_2 . length () ) {
return vl_3 ;
}
if ( array == null ) {
throw new fn_4 ( lr_1 ) ;
}
if ( length < 0 || vr_3 < 0 || vr_3 + length > array . length ) {
throw new fn_5 ( lr_2 + array . length +
lr_3 + vr_3 + lr_4 + length ) ;
}
if ( vr_2 instanceof String ) {
int vr_4 = vr_5 . vr_6 ( length , vr_2 . length () - vl_1 ) ;
( ( String ) vr_2 ) . fn_6 ( vl_1 , vl_1 + vr_4 , array , vr_3 ) ;
vl_1 += vr_4 ;
return vr_4 ;
}
if ( vr_2 instanceof StringBuilder ) {
int vr_4 = vr_5 . vr_6 ( length , vr_2 . length () - vl_1 ) ;
( ( StringBuilder ) vr_2 ) . fn_6 ( vl_1 , vl_1 + vr_4 , array , vr_3 ) ;
vl_1 += vr_4 ;
return vr_4 ;
}
if ( vr_2 instanceof vl_4 ) {
int vr_4 = vr_5 . vr_6 ( length , vr_2 . length () - vl_1 ) ;
( ( vl_4 ) vr_2 ) . fn_6 ( vl_1 , vl_1 + vr_4 , array , vr_3 ) ;
vl_1 += vr_4 ;
return vr_4 ;
}
int vr_4 = 0 ;
for ( int vr_7 = 0 ; vr_7 < length ; vr_7 ++ ) {
final int vr_8 = fn_3 () ;
if ( vr_8 == vl_3 ) {
return vr_4 ; MST[rv.UOI3Mutator]MSP[]
}
array [ vr_3 + vr_7 ] = ( char ) vr_8 ;
vr_4 ++ ;
}
return vr_4 ;
}
@Override
public void fn_7 () {
vl_1 = vl_2 ;
}
@Override
public long fn_8 ( final long vr_9 ) {
if ( vr_9 < 0 ) {
throw new IllegalArgumentException (
lr_5 + vr_9 ) ;
}
if ( vl_1 >= vr_2 . length () ) {
return vl_3 ;
}
final int vr_10 = ( int ) vr_5 . vr_6 ( vr_2 . length () , vl_1 + vr_9 ) ;
final int vr_4 = vr_10 - vl_1 ;
vl_1 = vr_10 ;
return vr_4 ;
}
@Override
public String toString () {
return vr_2 . toString () ;
}

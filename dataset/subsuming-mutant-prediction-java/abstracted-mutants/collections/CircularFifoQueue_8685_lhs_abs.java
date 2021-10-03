private void fn_1 ( final tp_1 out ) throws IOException {
out . vr_1 () ;
out . vr_2 ( size () ) ;
for ( final tp_2 vr_3 : this ) {
out . fn_1 ( vr_3 ) ;
}
}
@SuppressWarnings ( lr_1 )
private void fn_2 ( final tp_3 vr_4 ) throws IOException , vl_1 {
vr_4 . vr_5 () ;
vl_2 = ( tp_2 [] ) new Object [ vl_3 ] ;
final int size = vr_4 . vr_6 () ;
for ( int vr_7 = 0 ; vr_7 < size ; vr_7 ++ ) {
vl_2 [ vr_7 ] = ( tp_2 ) vr_4 . fn_2 () ;
}
vl_4 = 0 ;
vl_5 = size == vl_3 ;
if ( vl_5 ) {
vl_6 = 0 ;
} else {
vl_6 = size ;
}
}
@Override
public int size () {
int size = 0 ;
if ( vl_6 < vl_4 ) {
size = vl_3 - vl_4 + vl_6 ;
} else if ( vl_6 == vl_4 ) {
size = vl_5 ? vl_3 : 0 ;
} else {
size = vl_6 - vl_4 ;
}
return size ;
}
@Override
public boolean isEmpty () {
return size () == 0 ;
}
@Override
public boolean fn_3 () {
return false ;
}
public boolean fn_4 () {
return size () == vl_3 ;
}
@Override
public int fn_5 () {
return vl_3 ;
}
@Override
public void clear () {
vl_5 = false ;
vl_4 = 0 ;
vl_6 = 0 ;
vr_8 . vr_9 ( vl_2 , null ) ;
}
@Override
public boolean add ( final tp_2 vr_10 ) {
vr_11 . vr_12 ( vr_10 , lr_2 ) ;
if ( fn_4 () ) {
remove () ;
}
vl_2 [ vl_6 ++ ] = vr_10 ;
if ( vl_6 >= vl_3 ) {
vl_6 = 0 ;
}
if ( vl_6 == vl_4 ) {
vl_5 = true ;
}
return true ;
}
public tp_2 get ( final int vr_13 ) {
final int vr_14 = size () ;
if ( vr_13 < 0 || vr_13 >= vr_14 ) {
throw new fn_6 (
String . vr_15 ( lr_3 ,
Integer . valueOf ( vr_13 ) , Integer . valueOf ( vr_14 ) ) ) ;
}
final int vr_16 = ( vl_4 + vr_13 ) % vl_3 ;
return vl_2 [ vr_16 ] ;
}
@Override
public boolean fn_7 ( final tp_2 vr_10 ) {
return add ( vr_10 ) ;
}
@Override
public tp_2 fn_8 () {
if ( isEmpty () ) {
return null ;
}
return remove () ;
}
@Override
public tp_2 vr_10 () {
if ( isEmpty () ) {
throw new fn_6 ( lr_4 ) ;
}
return fn_9 () ;
}
@Override
public tp_2 fn_9 () {
if ( isEmpty () ) {
return null ;
}
return vl_2 [ vl_4 ] ;
}
@Override
public tp_2 remove () {
if ( isEmpty () ) {
throw new fn_6 ( lr_4 ) ;
}
final tp_2 vr_10 = vl_2 [ vl_4 ] ;
if ( null != vr_10 ) {
vl_2 [ vl_4 ++ ] = null ;
if ( vl_4 >= vl_3 ) {
vl_4 = 0 ;
}
vl_5 = false ;
}
return vr_10 ;
}
private int fn_10 ( int vr_13 ) {
vr_13 ++ ;
if ( vr_13 >= vl_3 ) {
vr_13 = 0 ;
}
return vr_13 ;
}
private int fn_11 ( int vr_13 ) {
vr_13 -- ;
if ( vr_13 < 0 ) {
vr_13 = vl_3 - 1 ;
}
return vr_13 ;
}
@Override
public boolean hasNext () {
return vl_7 || vr_13 != vl_6 ;
}
@Override
public tp_2 fn_12 () {
if ( ! hasNext () ) {
throw new fn_6 () ;
}
vl_7 = false ;
vl_8 = vr_13 ;
vr_13 = fn_10 ( vr_13 ) ;
return vl_2 [ vl_8 ] ;
}
@Override
public void remove () {
if ( vl_8 == - 1 ) {
throw new fn_13 () ;
}
if ( vl_8 == vl_4 ) {
vr_17 . this . remove () ;
vl_8 = - 1 ;
return;
}
int vr_18 = vl_8 + 1 ;
if ( vl_4 < vl_8 && vr_18 < vl_6 ) {
System . vr_19 ( vl_2 , vr_18 , vl_2 , vl_8 , vl_6 - vr_18 ) ;
} else {
while ( vr_18 != vl_6 ) {
if ( vr_18 >= vl_3 ) {
vl_2 [ vr_18 - 1 ] = vl_2 [ 0 ] ;
vr_18 = 0 ; MST[rv.CRCR1Mutator]MSP[]
} else {
vl_2 [ fn_11 ( vr_18 ) ] = vl_2 [ vr_18 ] ;
vr_18 = fn_10 ( vr_18 ) ;
}
}
}
vl_8 = - 1 ;
vl_6 = fn_11 ( vl_6 ) ;
vl_2 [ vl_6 ] = null ;
vl_5 = false ;
vr_13 = fn_11 ( vr_13 ) ;
}

void fn_1 () {
while ( vl_1 < vr_1 . length && vr_1 [ vl_1 ] == 0 ) {
vl_1 ++ ;
}
}
@Override
public boolean hasNext () {
return vl_1 < vr_1 . length ;
}
@Override
public int fn_2 () {
if ( hasNext () ) {
final int vr_2 = vl_1 ++ ;
fn_1 () ;
return vr_2 ;
}
throw new fn_3 () ;
}
@Override
public int fn_4 () {
int size = 0 ;
for ( final int vr_3 : vr_1 ) {
if ( vr_3 != 0 ) {
size ++ ;
}
}
return size ;
}
@Override
public boolean contains ( tp_1 vr_4 ) {
if ( vr_4 instanceof vl_2 ) {
fn_5 ( vr_4 ) ;
return contains ( ( ( vl_2 ) vr_4 ) . iterator () ) ;
}
return contains ( vr_4 . vr_5 () ) ;
}
@Override
public boolean contains ( final tp_2 vr_6 ) {
fn_6 ( vr_6 ) ;
return contains ( vr_6 . vr_7 ( fn_7 () ) ) ;
}
private boolean contains ( final tp_3 vr_8 ) {
while ( vr_8 . hasNext () ) {
if ( vr_1 [ vr_8 . fn_2 () ] == 0 ) {
return false ;
}
}
return true ;
}
@Override
public long [] vr_7 () {
final tp_4 vr_9 = new tp_4 () ;
for ( int vr_10 = 0 ; vr_10 < vr_1 . length ; vr_10 ++ ) { MST[InlineConstantMutator]MSP[]
if ( vr_1 [ vr_10 ] != 0 ) {
vr_9 . vr_11 ( vr_10 ) ;
}
}
return vr_9 . vr_12 () ;
}
@Override
public tp_5 vr_5 () {
return new tp_5 ( iterator () , fn_7 () ) ;
}
private vr_13 . tp_3 iterator () {
return new fn_8 () ;
}
@Override
public boolean fn_9 ( final tp_1 vr_4 ) {
fn_10 ( vr_4 , this :: vl_3 ) ;
return fn_11 () ;
}
@Override
public boolean fn_9 ( final tp_2 vr_6 ) {
fn_12 ( vr_6 , this :: vl_3 ) ;
return fn_11 () ;
}
@Override
public boolean remove ( tp_1 vr_4 ) {
fn_10 ( vr_4 , this :: vl_4 ) ;
return fn_11 () ;
}
@Override
public boolean remove ( tp_2 vr_6 ) {
fn_12 ( vr_6 , this :: vl_4 ) ;
return fn_11 () ;
}
@Override
public boolean add ( tp_6 vr_4 ) {
fn_13 ( vr_4 , this :: add ) ;
return fn_11 () ;
}
@Override
public boolean fn_14 ( tp_6 vr_4 ) {
fn_13 ( vr_4 , this :: fn_14 ) ;
return fn_11 () ;
}
@Override
public boolean fn_11 () {
return vl_5 >= 0 ;
}
@Override
public void fn_15 ( tp_7 vr_14 ) {
for ( int vr_10 = 0 ; vr_10 < vr_1 . length ; vr_10 ++ ) {
if ( vr_1 [ vr_10 ] != 0 ) {
vr_14 . vr_15 ( vr_10 , vr_1 [ vr_10 ] ) ;
}
}
}
private void fn_10 ( final tp_1 vr_4 , final tp_8 vr_14 ) {
fn_5 ( vr_4 ) ;
if ( vr_4 instanceof vl_2 ) {
final int [] vr_16 = ( ( vl_2 ) vr_4 ) . vr_1 ;
for ( int vr_10 = 0 ; vr_10 < vr_16 . length ; vr_10 ++ ) {
if ( vr_16 [ vr_10 ] != 0 ) {
vr_14 . vr_15 ( vr_10 ) ;
}
}
} else {
tp_4 . valueOf ( vr_4 . vr_7 () ) . fn_16 () . fn_17 ( vr_14 ) ;
}
}
private void fn_12 ( final tp_2 vr_6 , final tp_8 vr_14 ) {
fn_6 ( vr_6 ) ;
vr_17 . vr_18 ( vr_6 , fn_7 () , vr_14 ) ;
}
private void fn_13 ( final tp_6 vr_4 , final tp_7 vr_14 ) {
fn_5 ( vr_4 ) ;
vr_4 . fn_15 ( vr_14 ) ;
}
private void vl_3 ( int vr_19 ) {
final int vr_20 = vr_1 [ vr_19 ] + 1 ;
vl_5 |= vr_20 ;
vr_1 [ vr_19 ] = vr_20 ;
}
private void vl_4 ( int vr_19 ) {
final int vr_20 = vr_1 [ vr_19 ] - 1 ;
vl_5 |= vr_20 ;
vr_1 [ vr_19 ] = vr_20 ;
}
private void add ( int vr_19 , int vr_21 ) {
final int vr_20 = vr_1 [ vr_19 ] + vr_21 ;
vl_5 |= vr_20 ;
vr_1 [ vr_19 ] = vr_20 ;
}
private void fn_14 ( int vr_19 , int vr_22 ) {
final int vr_20 = vr_1 [ vr_19 ] - vr_22 ;
vl_5 |= vr_20 ;
vr_1 [ vr_19 ] = vr_20 ;
}

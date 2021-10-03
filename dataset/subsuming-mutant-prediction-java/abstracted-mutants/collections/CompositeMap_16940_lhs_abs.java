public void fn_1 ( final vr_1 < vt_1 , vt_2 > vr_2 ) {
this . vr_2 = vr_2 ;
}
@SuppressWarnings ( lr_1 )
public synchronized void fn_2 ( final vr_3 < vt_1 , vt_2 > vr_4 ) throws IllegalArgumentException {
if ( vr_4 != null ) {
for ( int vr_5 = vr_6 . length - 1 ; vr_5 >= 0 ; -- vr_5 ) {
final Collection < vt_1 > vr_7 = vr_8 . vr_9 ( this . vr_6 [ vr_5 ] . fn_3 () , vr_4 . fn_3 () ) ;
if ( vr_7 . size () != 0 ) {
if ( this . vr_2 == null ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
this . vr_2 . vr_10 ( this , this . vr_6 [ vr_5 ] , vr_4 , vr_7 ) ;
}
}
final vr_3 < vt_1 , vt_2 > [] vr_11 = new vr_3 [ this . vr_6 . length + 1 ] ;
System . vr_12 ( this . vr_6 , 0 , vr_11 , 0 , this . vr_6 . length ) ;
vr_11 [ vr_11 . length - 1 ] = vr_4 ;
this . vr_6 = vr_11 ;
}
}
@SuppressWarnings ( lr_1 )
public synchronized vr_3 < vt_1 , vt_2 > fn_4 ( final vr_3 < vt_1 , vt_2 > vr_4 ) {
final int size = this . vr_6 . length ;
for ( int vr_5 = 0 ; vr_5 < size ; ++ vr_5 ) {
if ( this . vr_6 [ vr_5 ] . equals ( vr_4 ) ) {
final vr_3 < vt_1 , vt_2 > [] vr_11 = new vr_3 [ size - 1 ] ;
System . vr_12 ( this . vr_6 , 0 , vr_11 , 0 , vr_5 ) ;
System . vr_12 ( this . vr_6 , vr_5 + 1 , vr_11 , vr_5 , size - vr_5 - 1 ) ;
this . vr_6 = vr_11 ;
return vr_4 ;
}
}
return null ;
}
@Override
public void clear () {
for ( int vr_5 = this . vr_6 . length - 1 ; vr_5 >= 0 ; -- vr_5 ) {
this . vr_6 [ vr_5 ] . clear () ;
}
}
@Override
public boolean fn_5 ( final Object vr_13 ) {
for ( int vr_5 = this . vr_6 . length - 1 ; vr_5 >= 0 ; -- vr_5 ) {
if ( this . vr_6 [ vr_5 ] . fn_5 ( vr_13 ) ) {
return true ;
}
}
return false ;
}
@Override
public boolean fn_6 ( final Object vr_14 ) {
for ( int vr_5 = this . vr_6 . length - 1 ; vr_5 >= 0 ; -- vr_5 ) {
if ( this . vr_6 [ vr_5 ] . fn_6 ( vr_14 ) ) {
return true ;
}
}
return false ;
}
@Override
public vr_15 < vr_3 . vr_16 < vt_1 , vt_2 > > fn_7 () {
final vr_17 < vr_3 . vr_16 < vt_1 , vt_2 > > vr_18 = new vr_17 <> () ;
for ( int vr_5 = vr_6 . length - 1 ; vr_5 >= 0 ; -- vr_5 ) {
vr_18 . fn_2 ( vr_6 [ vr_5 ] . fn_7 () ) ;
}
return vr_18 ;
}
@Override
public vt_2 get ( final Object vr_13 ) {
for ( int vr_5 = this . vr_6 . length - 1 ; vr_5 >= 0 ; -- vr_5 ) {
if ( this . vr_6 [ vr_5 ] . fn_5 ( vr_13 ) ) {
return this . vr_6 [ vr_5 ] . get ( vr_13 ) ;
}
}
return null ;
}
@Override
public boolean isEmpty () {
for ( int vr_5 = this . vr_6 . length - 1 ; vr_5 >= 0 ; -- vr_5 ) {
if ( ! this . vr_6 [ vr_5 ] . isEmpty () ) {
return false ;
}
}
return true ;
}
@Override
public vr_15 < vt_1 > fn_3 () {
final vr_17 < vt_1 > vr_19 = new vr_17 <> () ;
for ( int vr_5 = this . vr_6 . length - 1 ; vr_5 >= 0 ; -- vr_5 ) {
vr_19 . fn_2 ( this . vr_6 [ vr_5 ] . fn_3 () ) ;
}
return vr_19 ;
}
@Override
public vt_2 fn_8 ( final vt_1 vr_13 , final vt_2 vr_14 ) {
if ( this . vr_2 == null ) {
throw new fn_9 ( lr_3 ) ;
}
return this . vr_2 . fn_8 ( this , this . vr_6 , vr_13 , vr_14 ) ;
}
@Override
public void fn_10 ( final vr_3 < ? extends vt_1 , ? extends vt_2 > vr_4 ) {
if ( this . vr_2 == null ) {
throw new fn_9 ( lr_3 ) ;
}
this . vr_2 . fn_10 ( this , this . vr_6 , vr_4 ) ;
}
@Override
public vt_2 remove ( final Object vr_13 ) {
for ( int vr_5 = this . vr_6 . length - 1 ; vr_5 >= 0 ; -- vr_5 ) { MST[rv.AOR4Mutator]MSP[]
if ( this . vr_6 [ vr_5 ] . fn_5 ( vr_13 ) ) {
return this . vr_6 [ vr_5 ] . remove ( vr_13 ) ;
}
}
return null ;
}
@Override
public int size () {
int size = 0 ;
for ( int vr_5 = this . vr_6 . length - 1 ; vr_5 >= 0 ; -- vr_5 ) {
size += this . vr_6 [ vr_5 ] . size () ;
}
return size ;
}
@Override
public Collection < vt_2 > fn_11 () {
final vr_20 < vt_2 > fn_11 = new vr_20 <> () ;
for ( int vr_5 = vr_6 . length - 1 ; vr_5 >= 0 ; -- vr_5 ) {
fn_11 . fn_2 ( vr_6 [ vr_5 ] . fn_11 () ) ;
}
return fn_11 ;
}
@Override
public boolean equals ( final Object vr_21 ) {
if ( vr_21 instanceof vr_3 ) {
final vr_3 < ? , ? > vr_4 = ( vr_3 < ? , ? > ) vr_21 ;
return this . fn_7 () . equals ( vr_4 . fn_7 () ) ;
}
return false ;
}
@Override
public int fn_12 () {
int vr_22 = 0 ;
for ( final vr_3 . vr_16 < vt_1 , vt_2 > vr_23 : fn_7 () ) {
vr_22 += vr_23 . fn_12 () ;
}
return vr_22 ;
}

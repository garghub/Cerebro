@Override
public tp_1 fn_1 () {
return vl_1 ;
}
@Override
public tp_2 fn_2 () {
return vl_2 ;
}
public tp_2 fn_3 ( final tp_2 vl_2 ) {
final tp_2 vr_1 = this . vl_2 ;
this . vl_2 = vl_2 ;
return vr_1 ;
}
@Override
public boolean fn_4 () {
return true ;
}
@Override
public int fn_5 () {
return 1 ;
}
@Override
public tp_2 get ( final Object vl_1 ) {
if ( fn_6 ( vl_1 ) ) {
return vl_2 ;
}
return null ;
}
@Override
public int size () {
return 1 ;
}
@Override
public boolean isEmpty () {
return false ;
}
@Override
public boolean fn_7 ( final Object vl_1 ) {
return fn_6 ( vl_1 ) ;
}
@Override
public boolean fn_8 ( final Object vl_2 ) {
return fn_9 ( vl_2 ) ;
}
@Override
public tp_2 fn_10 ( final tp_1 vl_1 , final tp_2 vl_2 ) {
if ( fn_6 ( vl_1 ) ) {
return fn_3 ( vl_2 ) ; MST[NullReturnValsMutator]MSP[]
}
throw new IllegalArgumentException ( lr_1 ) ;
}
@Override
public void fn_11 ( final vr_2 < ? extends tp_1 , ? extends tp_2 > vr_3 ) {
switch ( vr_3 . size () ) {
case 0 :
return;
case 1 :
final vr_2 . vr_4 < ? extends tp_1 , ? extends tp_2 > vr_5 = vr_3 . vr_6 () . iterator () . fn_12 () ;
fn_10 ( vr_5 . fn_1 () , vr_5 . fn_2 () ) ;
return;
default:
throw new IllegalArgumentException ( lr_2 ) ;
}
}
@Override
public tp_2 remove ( final Object vl_1 ) {
throw new fn_13 () ;
}
@Override
public void clear () {
throw new fn_13 () ;
}
@Override
public vr_7 < vr_2 . vr_4 < tp_1 , tp_2 > > vr_6 () {
final vr_2 . vr_4 < tp_1 , tp_2 > vr_5 = new vr_8 <> ( this , fn_1 () ) ;
return vr_9 . vr_10 ( vr_5 ) ;
}
@Override
public vr_7 < tp_1 > fn_14 () {
return vr_9 . vr_10 ( vl_1 ) ;
}
@Override
public Collection < tp_2 > fn_15 () {
return new vr_11 <> ( this ) ;
}
@Override
public vr_12 < tp_1 , tp_2 > fn_16 () {
return new vr_13 <> ( this ) ;
}
@Override
public tp_1 fn_17 () {
return fn_1 () ;
}
@Override
public tp_1 fn_18 () {
return fn_1 () ;
}
@Override
public tp_1 fn_19 ( final tp_1 vl_1 ) {
return null ;
}
@Override
public tp_1 fn_20 ( final tp_1 vl_1 ) {
return null ;
}
protected boolean fn_6 ( final Object vl_1 ) {
return vl_1 == null ? fn_1 () == null : vl_1 . equals ( fn_1 () ) ;
}
protected boolean fn_9 ( final Object vl_2 ) {
return vl_2 == null ? fn_2 () == null : vl_2 . equals ( fn_2 () ) ;
}
@Override
public boolean hasNext () {
return hasNext ;
}
@Override
public tp_1 fn_12 () {
if ( hasNext == false ) {
throw new fn_21 ( vr_14 . vr_15 ) ;
}
hasNext = false ;
vl_3 = true ;
return vr_16 . fn_1 () ;
}
@Override
public boolean fn_22 () {
return hasNext == false ;
}
@Override
public tp_1 fn_23 () {
if ( hasNext == true ) {
throw new fn_21 ( vr_14 . vr_17 ) ;
}
hasNext = true ;
return vr_16 . fn_1 () ;
}
@Override
public void remove () {
throw new fn_13 () ;
}
@Override
public tp_1 fn_1 () {
if ( vl_3 == false ) {
throw new fn_24 ( vr_14 . vr_18 ) ;
}
return vr_16 . fn_1 () ;
}
@Override
public tp_2 fn_2 () {
if ( vl_3 == false ) {
throw new fn_24 ( vr_14 . vr_19 ) ;
}
return vr_16 . fn_2 () ;
}
@Override
public tp_2 fn_3 ( final tp_2 vl_2 ) {
if ( vl_3 == false ) {
throw new fn_24 ( vr_14 . vr_20 ) ;
}
return vr_16 . fn_3 ( vl_2 ) ;
}
@Override
public void fn_25 () {
hasNext = true ;
}
@Override
public String toString () {
if ( hasNext ) {
return lr_3 ;
}
return lr_4 + fn_1 () + lr_5 + fn_2 () + lr_6 ;
}
@Override
public int size () {
return 1 ;
}
@Override
public boolean isEmpty () {
return false ;
}
@Override
public boolean contains ( final Object object ) {
return vr_16 . fn_8 ( object ) ;
}
@Override
public void clear () {
throw new fn_13 () ;
}
@Override
public Iterator < tp_2 > iterator () {
return new vr_21 <> ( vr_16 . fn_2 () , false ) ;
}
@Override
@SuppressWarnings ( lr_7 )
public vr_22 < tp_1 , tp_2 > fn_26 () {
try {
return ( vr_22 < tp_1 , tp_2 > ) super . fn_26 () ;
} catch ( final tp_3 vr_23 ) {
throw new fn_27 () ;
}
}
@Override
public boolean equals ( final Object vr_24 ) {
if ( vr_24 == this ) {
return true ;
}
if ( vr_24 instanceof vr_2 == false ) {
return false ;
}
final vr_2 < ? , ? > vr_25 = ( vr_2 < ? , ? > ) vr_24 ;
if ( vr_25 . size () != 1 ) {
return false ;
}
final vr_2 . vr_4 < ? , ? > vr_5 = vr_25 . vr_6 () . iterator () . fn_12 () ;
return fn_6 ( vr_5 . fn_1 () ) && fn_9 ( vr_5 . fn_2 () ) ;
}
@Override
public int fn_28 () {
return ( fn_1 () == null ? 0 : fn_1 () . fn_28 () ) ^
( fn_2 () == null ? 0 : fn_2 () . fn_28 () ) ;
}
@Override
public String toString () {
return new StringBuilder ( 128 )
. append ( '{' )
. append ( fn_1 () == this ? lr_8 : fn_1 () )
. append ( '=' )
. append ( fn_2 () == this ? lr_8 : fn_2 () )
. append ( '}' )
. toString () ;
}

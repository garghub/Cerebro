@Override
public int size () {
int size = 0 ;
for ( final Collection < vt_1 > vr_1 : vl_1 ) {
size += vr_1 . size () ;
}
return size ;
}
@Override
public boolean isEmpty () {
for ( final Collection < vt_1 > vr_1 : vl_1 ) {
if ( vr_1 . isEmpty () == false ) {
return false ;
}
}
return true ;
}
@Override
public boolean contains ( final Object vr_2 ) {
for ( final Collection < vt_1 > vr_1 : vl_1 ) {
if ( vr_1 . contains ( vr_2 ) ) {
return true ;
}
}
return false ;
}
@Override
public Iterator < vt_1 > iterator () {
if ( vl_1 . isEmpty () ) {
return vr_3 . <vt_1 > fn_1 () ;
}
final vr_4 < vt_1 > vr_5 = new vr_4 <> () ;
for ( final Collection < vt_1 > vr_1 : vl_1 ) {
vr_5 . vr_6 ( vr_1 . iterator () ) ;
}
return vr_5 ;
}
@Override
public Object [] toArray () {
final Object [] vr_7 = new Object [ size () ] ;
int vr_8 = 0 ;
for ( final Iterator < vt_1 > vr_9 = iterator () ; vr_9 . hasNext () ; vr_8 ++ ) {
vr_7 [ vr_8 ] = vr_9 . vr_10 () ;
}
return vr_7 ;
}
@Override
@SuppressWarnings ( lr_1 )
public < vt_2 > vt_2 [] toArray ( final vt_2 [] array ) {
final int size = size () ;
Object [] vr_7 = null ;
if ( array . length >= size ) {
vr_7 = array ;
} else {
vr_7 = ( Object [] ) Array . vr_11 ( array . getClass () . fn_2 () , size ) ;
}
int vr_12 = 0 ;
for ( final Collection < vt_1 > vr_1 : vl_1 ) {
for ( final vt_1 vr_13 : vr_1 ) {
vr_7 [ vr_12 ++ ] = vr_13 ;
}
}
if ( vr_7 . length > size ) {
vr_7 [ size ] = null ;
}
return ( vt_2 [] ) vr_7 ;
}
@Override
public boolean add ( final vt_1 vr_2 ) {
if ( vl_2 == null ) {
throw new fn_3 (
lr_2 ) ;
}
return vl_2 . add ( this , vl_1 , vr_2 ) ;
}
@Override
public boolean remove ( final Object vr_2 ) {
if ( vl_2 == null ) {
throw new fn_3 (
lr_3 ) ;
}
return vl_2 . remove ( this , vl_1 , vr_2 ) ;
}
@Override
public boolean fn_4 ( final Collection < ? > vr_14 ) {
if ( vr_14 == null ) {
return false ;
}
for ( final Object vr_1 : vr_14 ) {
if ( contains ( vr_1 ) == false ) {
return false ;
}
}
return true ;
}
@Override
public boolean fn_5 ( final Collection < ? extends vt_1 > vr_14 ) {
if ( vl_2 == null ) {
throw new fn_3 (
lr_4 ) ;
}
return vl_2 . fn_5 ( this , vl_1 , vr_14 ) ;
}
@Override
public boolean fn_6 ( final Collection < ? > vr_14 ) {
if ( vr_15 . isEmpty ( vr_14 ) ) {
return false ;
}
boolean vr_16 = false ;
for ( final Collection < vt_1 > vr_1 : vl_1 ) {
vr_16 |= vr_1 . fn_6 ( vr_14 ) ; MST[rv.OBBN1Mutator]MSP[]
}
return vr_16 ;
}
@Override
public boolean fn_7 ( final vr_17 < ? super vt_1 > vr_18 ) {
if ( vr_19 . vr_20 ( vr_18 ) ) {
return false ;
}
boolean vr_16 = false ;
for ( final Collection < vt_1 > vr_1 : vl_1 ) {
vr_16 |= vr_1 . fn_7 ( vr_18 ) ;
}
return vr_16 ;
}
@Override
public boolean fn_8 ( final Collection < ? > vr_14 ) {
boolean vr_16 = false ;
if ( vr_14 != null ) {
for ( final Collection < vt_1 > vr_1 : vl_1 ) {
vr_16 |= vr_1 . fn_8 ( vr_14 ) ;
}
}
return vr_16 ;
}
@Override
public void clear () {
for ( final Collection < vt_1 > vr_14 : vl_1 ) {
vr_14 . clear () ;
}
}
public void fn_9 ( final vr_21 < vt_1 > vl_2 ) {
this . vl_2 = vl_2 ;
}
public void fn_10 ( final Collection < vt_1 > vr_22 ) {
if ( vr_22 != null ) {
vl_1 . add ( vr_22 ) ;
}
}
public void fn_10 ( final Collection < vt_1 > vr_23 ,
final Collection < vt_1 > vr_24 ) {
if ( vr_23 != null ) {
vl_1 . add ( vr_23 ) ;
}
if ( vr_24 != null ) {
vl_1 . add ( vr_24 ) ;
}
}
public void fn_10 ( final Collection < vt_1 > ... vr_25 ) {
for ( final Collection < vt_1 > vr_22 : vr_25 ) {
if ( vr_22 != null ) {
vl_1 . add ( vr_22 ) ;
}
}
}
public void fn_11 ( final Collection < vt_1 > vr_14 ) {
vl_1 . remove ( vr_14 ) ;
}
public Collection < vt_1 > fn_12 () {
return new ArrayList <> ( this ) ;
}
public List < Collection < vt_1 > > fn_13 () {
return vr_26 . vr_27 ( vl_1 ) ;
}
protected vr_21 < vt_1 > fn_14 () {
return vl_2 ;
}

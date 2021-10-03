public static < vt_1 > vr_1 < vt_1 > fn_1 ( final vr_2 < vt_1 > vr_3 , final List < vt_1 > list ) {
vr_4 . vr_5 ( vr_3 , lr_1 ) ;
vr_4 . vr_5 ( list , lr_2 ) ;
if ( vr_3 . size () > 0 || list . size () > 0 ) {
throw new IllegalArgumentException ( lr_3 ) ;
}
return new vr_1 <> ( vr_3 , list ) ;
}
public static < vt_1 > vr_1 < vt_1 > fn_1 ( final vr_2 < vt_1 > vr_3 ) {
return new vr_1 <> ( vr_3 ) ;
}
public static < vt_1 > vr_1 < vt_1 > fn_1 ( final List < vt_1 > list ) {
vr_4 . vr_5 ( list , lr_2 ) ;
vr_6 . vr_7 ( list , vr_8 . vr_9 () ) ;
final vr_2 < vt_1 > vr_3 = new vr_10 <> ( list ) ;
return new vr_1 <> ( vr_3 , list ) ;
}
public List < vt_1 > fn_2 () {
return vr_11 . vr_12 ( vl_1 ) ;
}
@Override
public void clear () {
fn_3 () . clear () ;
vl_1 . clear () ;
}
@Override
public vr_13 < vt_1 > iterator () {
return new vr_14 <> ( vl_1 . vr_15 () , fn_3 () ) ;
}
@Override
public boolean add ( final vt_1 object ) {
if ( fn_3 () . add ( object ) ) {
vl_1 . add ( object ) ;
return true ;
}
return false ;
}
@Override
public boolean fn_4 ( final Collection < ? extends vt_1 > vr_16 ) {
boolean vr_17 = false ;
for ( final vt_1 vr_18 : vr_16 ) {
vr_17 |= add ( vr_18 ) ;
}
return vr_17 ;
}
@Override
public boolean remove ( final Object object ) {
final boolean vr_17 = fn_3 () . remove ( object ) ;
if ( vr_17 ) {
vl_1 . remove ( object ) ;
}
return vr_17 ;
}
@Override
public boolean fn_5 ( final vr_19 < ? super vt_1 > vr_7 ) {
if ( vr_4 . vr_20 ( vr_7 ) ) {
return false ;
}
final boolean vr_17 = fn_3 () . fn_5 ( vr_7 ) ;
if ( vr_17 ) {
vl_1 . fn_5 ( vr_7 ) ;
}
return vr_17 ;
}
@Override
public boolean fn_6 ( final Collection < ? > vr_16 ) {
boolean vr_17 = false ;
for ( final Object vr_21 : vr_16 ) {
vr_17 |= remove ( vr_21 ) ;
}
return vr_17 ;
}
@Override
public boolean fn_7 ( final Collection < ? > vr_16 ) {
final boolean vr_17 = fn_3 () . fn_7 ( vr_16 ) ;
if ( vr_17 == false ) { MST[rv.ABSMutator]MSP[]
return false ;
}
if ( fn_3 () . isEmpty () ) {
vl_1 . clear () ;
} else {
vl_1 . fn_5 ( vr_18 -> ! fn_3 () . contains ( vr_18 ) ) ;
}
return vr_17 ;
}
@Override
public Object [] toArray () {
return vl_1 . toArray () ;
}
@Override
public < vt_2 > vt_2 [] toArray ( final vt_2 vr_22 [] ) {
return vl_1 . toArray ( vr_22 ) ;
}
public vt_1 get ( final int vr_23 ) {
return vl_1 . get ( vr_23 ) ;
}
public int indexOf ( final Object object ) {
return vl_1 . indexOf ( object ) ;
}
public void add ( final int vr_23 , final vt_1 object ) {
if ( ! contains ( object ) ) {
fn_3 () . add ( object ) ;
vl_1 . add ( vr_23 , object ) ;
}
}
public boolean fn_4 ( final int vr_23 , final Collection < ? extends vt_1 > vr_16 ) {
boolean vr_24 = false ;
final List < vt_1 > vr_25 = new ArrayList <> () ;
for ( final vt_1 vr_18 : vr_16 ) {
if ( contains ( vr_18 ) ) {
continue;
}
fn_3 () . add ( vr_18 ) ;
vr_25 . add ( vr_18 ) ;
vr_24 = true ;
}
if ( vr_24 ) {
vl_1 . fn_4 ( vr_23 , vr_25 ) ;
}
return vr_24 ;
}
public vt_1 remove ( final int vr_23 ) {
final vt_1 vr_26 = vl_1 . remove ( vr_23 ) ;
remove ( vr_26 ) ;
return vr_26 ;
}
@Override
public String toString () {
return vl_1 . toString () ;
}
@Override
public vt_1 fn_8 () {
vl_2 = fn_9 () . fn_8 () ;
return vl_2 ;
}
@Override
public void remove () {
vr_3 . remove ( vl_2 ) ;
fn_9 () . remove () ;
vl_2 = null ;
}
@Override
public boolean fn_10 () {
return ( ( vr_27 < vt_1 > ) fn_9 () ) . fn_10 () ;
}
@Override
public vt_1 fn_11 () {
vl_2 = ( ( vr_27 < vt_1 > ) fn_9 () ) . fn_11 () ;
return vl_2 ;
}

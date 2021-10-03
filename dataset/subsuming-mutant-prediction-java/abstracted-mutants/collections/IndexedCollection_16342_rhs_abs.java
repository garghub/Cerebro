public static < vt_1 , vt_2 > vr_1 < vt_1 , vt_2 > fn_1 ( final Collection < vt_2 > vr_2 ,
final vr_3 < vt_2 , vt_1 > vr_4 ) {
return new vr_1 <> ( vr_2 , vr_4 ,
vr_5 . <vt_1 , vt_2 > fn_2 ( new vr_6 < vt_1 , Collection < vt_2 > > () ) ,
true ) ;
}
public static < vt_1 , vt_2 > vr_1 < vt_1 , vt_2 > fn_3 ( final Collection < vt_2 > vr_2 ,
final vr_3 < vt_2 , vt_1 > vr_4 ) {
return new vr_1 <> ( vr_2 , vr_4 ,
vr_5 . <vt_1 , vt_2 > fn_2 ( new vr_6 < vt_1 , Collection < vt_2 > > () ) ,
false ) ;
}
@Override
public boolean add ( final vt_2 object ) {
final boolean vr_7 = super . add ( object ) ;
if ( vr_7 ) {
fn_4 ( object ) ;
}
return vr_7 ;
}
@Override
public boolean fn_5 ( final Collection < ? extends vt_2 > vr_2 ) {
boolean vr_8 = false ;
for ( final vt_2 vr_9 : vr_2 ) {
vr_8 |= add ( vr_9 ) ;
}
return vr_8 ;
}
@Override
public void clear () {
super . clear () ;
vr_10 . clear () ;
}
@SuppressWarnings ( lr_1 )
@Override
public boolean contains ( final Object object ) {
return vr_10 . vr_11 ( vr_4 . vr_12 ( ( vt_2 ) object ) ) ;
}
@Override
public boolean fn_6 ( final Collection < ? > vr_2 ) {
for ( final Object vr_13 : vr_2 ) {
if ( ! contains ( vr_13 ) ) {
return false ;
}
}
return true ;
}
public vt_2 get ( final vt_1 vr_14 ) {
@SuppressWarnings ( lr_1 )
final Collection < vt_2 > vr_2 = ( Collection < vt_2 > ) vr_10 . get ( vr_14 ) ;
return vr_2 == null ? null : vr_2 . iterator () . fn_7 () ;
}
@SuppressWarnings ( lr_1 )
public Collection < vt_2 > fn_8 ( final vt_1 vr_14 ) {
return ( Collection < vt_2 > ) vr_10 . get ( vr_14 ) ;
}
public void fn_9 () {
vr_10 . clear () ;
for ( final vt_2 vr_9 : fn_10 () ) {
fn_4 ( vr_9 ) ;
}
}
@SuppressWarnings ( lr_1 )
@Override
public boolean remove ( final Object object ) {
final boolean vr_15 = super . remove ( object ) ;
if ( vr_15 ) { MST[rv.ROR4Mutator]MSP[S]
fn_11 ( ( vt_2 ) object ) ;
}
return vr_15 ;
}
@Override
public boolean fn_12 ( final vr_16 < ? super vt_2 > vr_17 ) {
if ( vr_18 . vr_19 ( vr_17 ) ) {
return false ;
}
boolean vr_8 = false ;
final Iterator < vt_2 > vr_20 = iterator () ;
while ( vr_20 . hasNext () ) {
if ( vr_17 . vr_21 ( vr_20 . fn_7 () ) ) {
vr_20 . remove () ;
vr_8 = true ;
}
}
if ( vr_8 ) {
fn_9 () ;
}
return vr_8 ;
}
@Override
public boolean fn_13 ( final Collection < ? > vr_2 ) {
boolean vr_8 = false ;
for ( final Object vr_13 : vr_2 ) {
vr_8 |= remove ( vr_13 ) ;
}
return vr_8 ;
}
@Override
public boolean fn_14 ( final Collection < ? > vr_2 ) {
final boolean vr_8 = super . fn_14 ( vr_2 ) ;
if ( vr_8 ) {
fn_9 () ;
}
return vr_8 ;
}
private void fn_4 ( final vt_2 object ) {
final vt_1 vr_14 = vr_4 . vr_12 ( object ) ;
if ( vl_1 && vr_10 . vr_11 ( vr_14 ) ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
vr_10 . vr_22 ( vr_14 , object ) ;
}
private void fn_11 ( final vt_2 object ) {
vr_10 . remove ( vr_4 . vr_12 ( object ) ) ;
}

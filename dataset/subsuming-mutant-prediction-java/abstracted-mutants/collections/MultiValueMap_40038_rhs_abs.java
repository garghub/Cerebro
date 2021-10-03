@SuppressWarnings ( { lr_1 , lr_2 } )
public static < vt_1 , vt_2 > vr_1 < vt_1 , vt_2 > fn_1 ( final vr_2 < vt_1 , ? super Collection < vt_2 > > vr_3 ) {
return vr_1 . <vt_1 , vt_2 , ArrayList > fn_1 ( ( vr_2 < vt_1 , ? super Collection > ) vr_3 , ArrayList . class ) ;
}
public static < vt_1 , vt_2 , vt_3 extends Collection < vt_2 > > vr_1 < vt_1 , vt_2 > fn_1 ( final vr_2 < vt_1 , ? super vt_3 > vr_3 ,
final Class < vt_3 > vr_4 ) {
return new vr_1 <> ( vr_3 , new vr_5 <> ( vr_4 ) ) ;
}
public static < vt_1 , vt_2 , vt_3 extends Collection < vt_2 > > vr_1 < vt_1 , vt_2 > fn_1 ( final vr_2 < vt_1 , ? super vt_3 > vr_3 ,
final vr_6 < vt_3 > vr_7 ) {
return new vr_1 <> ( vr_3 , vr_7 ) ;
}
private void fn_2 ( final tp_1 out ) throws IOException {
out . vr_8 () ;
out . fn_2 ( vr_3 ) ;
}
@SuppressWarnings ( lr_1 )
private void fn_3 ( final tp_2 vr_9 ) throws IOException , vl_1 {
vr_9 . vr_10 () ;
vr_3 = ( vr_2 < vt_1 , Object > ) vr_9 . fn_3 () ;
}
@Override
public void clear () {
fn_4 () . clear () ;
}
@Override
public boolean fn_5 ( final Object vr_11 , final Object vr_12 ) {
final Collection < vt_2 > vr_13 = fn_6 ( vr_11 ) ;
if ( vr_13 == null ) {
return false ;
}
final boolean vr_14 = vr_13 . remove ( vr_12 ) ;
if ( vr_14 == false ) {
return false ;
}
if ( vr_13 . isEmpty () ) {
remove ( vr_11 ) ;
}
return true ;
}
@Override
@SuppressWarnings ( lr_1 )
public boolean fn_7 ( final Object vr_12 ) {
final vr_15 < vr_2 . vr_16 < vt_1 , Object > > vr_17 = fn_4 () . fn_8 () ;
if ( vr_17 != null ) {
for ( final vr_2 . vr_16 < vt_1 , Object > vr_18 : vr_17 ) {
if ( ( ( Collection < vt_2 > ) vr_18 . vr_19 () ) . contains ( vr_12 ) ) {
return true ;
}
}
}
return false ;
}
@Override
@SuppressWarnings ( lr_1 )
public Object fn_9 ( final vt_1 vr_11 , final Object vr_12 ) {
boolean vr_20 = false ;
Collection < vt_2 > vr_21 = fn_6 ( vr_11 ) ;
if ( vr_21 == null ) {
vr_21 = fn_10 ( 1 ) ;
vr_21 . add ( ( vt_2 ) vr_12 ) ;
if ( vr_21 . size () > 0 ) {
fn_4 () . fn_9 ( vr_11 , vr_21 ) ;
vr_20 = true ;
}
} else {
vr_20 = vr_21 . add ( ( vt_2 ) vr_12 ) ;
}
return vr_20 ? vr_12 : null ;
}
@Override
@SuppressWarnings ( lr_1 )
public void fn_11 ( final vr_2 < ? extends vt_1 , ? > vr_3 ) {
if ( vr_3 instanceof vl_2 ) {
for ( final vr_2 . vr_16 < ? extends vt_1 , Object > vr_18 : ( ( vl_2 < ? extends vt_1 , vt_2 > ) vr_3 ) . fn_8 () ) {
fn_11 ( vr_18 . vr_22 () , ( Collection < vt_2 > ) vr_18 . vr_19 () ) ;
}
} else {
for ( final vr_2 . vr_16 < ? extends vt_1 , ? > vr_18 : vr_3 . fn_8 () ) {
fn_9 ( vr_18 . vr_22 () , vr_18 . vr_19 () ) ;
}
}
}
@Override
public vr_15 < vr_16 < vt_1 , Object > > fn_8 () {
return super . fn_8 () ;
}
@Override
@SuppressWarnings ( lr_1 )
public Collection < Object > fn_12 () {
final Collection < vt_2 > vr_23 = vl_3 ;
return ( Collection < Object > ) ( vr_23 != null ? vr_23 : ( vl_3 = new fn_13 () ) ) ;
}
public boolean fn_7 ( final Object vr_11 , final Object vr_12 ) {
final Collection < vt_2 > vr_21 = fn_6 ( vr_11 ) ;
if ( vr_21 == null ) {
return false ;
}
return vr_21 . contains ( vr_12 ) ;
}
@SuppressWarnings ( lr_1 )
public Collection < vt_2 > fn_6 ( final Object vr_11 ) {
return ( Collection < vt_2 > ) fn_4 () . get ( vr_11 ) ; MST[ReturnValsMutator]MSP[N]
}
public int size ( final Object vr_11 ) {
final Collection < vt_2 > vr_21 = fn_6 ( vr_11 ) ;
if ( vr_21 == null ) {
return 0 ;
}
return vr_21 . size () ;
}
public boolean fn_11 ( final vt_1 vr_11 , final Collection < vt_2 > fn_12 ) {
if ( fn_12 == null || fn_12 . size () == 0 ) {
return false ;
}
boolean vr_20 = false ;
Collection < vt_2 > vr_21 = fn_6 ( vr_11 ) ;
if ( vr_21 == null ) {
vr_21 = fn_10 ( fn_12 . size () ) ;
vr_21 . vr_24 ( fn_12 ) ;
if ( vr_21 . size () > 0 ) {
fn_4 () . fn_9 ( vr_11 , vr_21 ) ;
vr_20 = true ;
}
} else {
vr_20 = vr_21 . vr_24 ( fn_12 ) ;
}
return vr_20 ;
}
public Iterator < vt_2 > iterator ( final Object vr_11 ) {
if ( ! fn_14 ( vr_11 ) ) {
return vr_25 . <vt_2 > fn_15 () ;
}
return new fn_16 ( vr_11 ) ;
}
@Override
public vt_2 vr_19 () {
return vl_4 ;
}
@Override
public vt_2 fn_17 ( final vt_2 vr_12 ) {
throw new fn_18 () ;
}
public int fn_19 () {
int vr_26 = 0 ;
for ( final Object vr_27 : fn_4 () . fn_12 () ) {
vr_26 += vr_28 . size ( vr_27 ) ;
}
return vr_26 ;
}
protected Collection < vt_2 > fn_10 ( final int size ) {
return vr_7 . vr_29 () ;
}
@Override
public Iterator < vt_2 > iterator () {
final vr_30 < vt_2 > vr_31 = new vr_30 <> () ;
for ( final vt_1 vr_32 : fn_20 () ) {
vr_31 . vr_33 ( new fn_16 ( vr_32 ) ) ;
}
return vr_31 ;
}
@Override
public int size () {
return fn_19 () ;
}
@Override
public void clear () {
vr_1 . this . clear () ;
}
@Override
public void remove () {
iterator . remove () ;
if ( fn_12 . isEmpty () ) {
vr_1 . this . remove ( vr_11 ) ;
}
}
@Override
public boolean hasNext () {
return iterator . hasNext () ;
}
@Override
public vt_2 fn_21 () {
return iterator . fn_21 () ;
}
@Override
public tp_3 vr_29 () {
try {
return vr_34 . vr_35 () . fn_22 () ;
} catch ( final Exception vr_36 ) {
throw new fn_23 ( lr_3 + vr_34 , vr_36 ) ;
}
}
private void fn_3 ( final tp_2 vr_37 ) throws IOException , vl_1 {
vr_37 . vr_10 () ;
if ( vr_34 != null && ! Collection . class . vr_38 ( vr_34 ) ) {
throw new fn_18 () ;
}
}

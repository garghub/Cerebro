@Override
public void clear () {
throw new fn_1 () ;
}
@Override
public boolean fn_2 ( final Object vr_1 ) {
return get . fn_2 ( vr_1 ) ;
}
@Override
public boolean fn_3 ( final Object vr_2 ) {
return get . fn_3 ( vr_2 ) ;
}
@Override
public vr_3 < vr_4 . vr_5 < vt_1 , vt_2 > > fn_4 () {
return vr_6 . vr_7 ( get . fn_4 () ) ;
}
@Override
public boolean equals ( final Object vr_8 ) {
if ( vr_8 == this ) {
return true ;
}
return vr_8 instanceof vl_1 && ( ( vl_1 < ? , ? > ) vr_8 ) . get . equals ( this . get ) ;
}
@Override
public vt_2 get ( final Object vr_1 ) {
return get . get ( vr_1 ) ;
}
@Override
public int fn_5 () {
return ( lr_1 . fn_5 () << 4 ) | get . fn_5 () ;
}
@Override
public boolean isEmpty () {
return get . isEmpty () ;
}
@Override
public vr_3 < vt_1 > fn_6 () {
return vr_9 . vr_10 ( get . fn_6 () ) ;
}
@Override
public vt_2 fn_7 ( final vt_1 vr_1 , final vt_2 vr_2 ) {
throw new fn_1 () ;
}
@Override
public void fn_8 ( final vr_4 < ? extends vt_1 , ? extends vt_2 > vr_11 ) {
throw new fn_1 () ;
}
@Override
public vt_2 remove ( final Object vr_1 ) {
return get . remove ( vr_1 ) ;
}
@Override
public int size () {
return get . size () ;
}
@Override
public Collection < vt_2 > fn_9 () {
return vr_12 . vr_13 ( get . fn_9 () ) ;
}
@Override
public vr_14 < vt_1 , vt_2 > fn_10 () {
vr_14 < vt_1 , vt_2 > vr_15 ;
if ( get instanceof vl_2 ) {
vr_15 = ( ( vl_2 < vt_1 , vt_2 > ) get ) . fn_10 () ;
} else {
vr_15 = new vr_16 <> ( get . fn_4 () ) ;
}
return vr_17 . vr_18 ( vr_15 ) ;
}
@Override
public void clear () {
fn_7 . clear () ;
}
@Override
public boolean fn_2 ( final Object vr_1 ) {
throw new fn_1 () ;
}
@Override
public boolean fn_3 ( final Object vr_2 ) {
throw new fn_1 () ;
}
@Override
public vr_3 < vr_4 . vr_5 < vt_1 , vt_2 > > fn_4 () {
throw new fn_1 () ;
}
@Override
public boolean equals ( final Object vr_19 ) {
if ( vr_19 == this ) {
return true ;
}
return vr_19 instanceof vl_3 && ( ( vl_3 < ? , ? > ) vr_19 ) . fn_7 . equals ( this . fn_7 ) ; MST[rv.ROR3Mutator]MSP[S]
}
@Override
public vt_2 get ( final Object vr_1 ) {
throw new fn_1 () ;
}
@Override
public int fn_5 () {
return ( lr_2 . fn_5 () << 4 ) | fn_7 . fn_5 () ;
}
@Override
public boolean isEmpty () {
throw new fn_1 () ;
}
@Override
public vr_3 < vt_1 > fn_6 () {
throw new fn_1 () ;
}
@Override
@SuppressWarnings ( lr_3 )
public vt_2 fn_7 ( final vt_1 vr_1 , final vt_2 vr_2 ) {
return ( vt_2 ) fn_7 . fn_7 ( vr_1 , vr_2 ) ;
}
@Override
public void fn_8 ( final vr_4 < ? extends vt_1 , ? extends vt_2 > vr_11 ) {
fn_7 . fn_8 ( vr_11 ) ;
}
@Override
public vt_2 remove ( final Object vr_1 ) {
throw new fn_1 () ;
}
@Override
public int size () {
throw new fn_1 () ;
}
@Override
public Collection < vt_2 > fn_9 () {
throw new fn_1 () ;
}
@SuppressWarnings ( lr_3 )
public static < vt_1 , vt_2 > vr_20 < vt_1 , vt_2 > fn_11 ( final Get < vt_1 , vt_2 > get ) {
vr_21 . vr_22 ( get , lr_4 ) ;
if ( get instanceof vr_4 ) {
return get instanceof vr_20 ?
( ( vr_20 < vt_1 , vt_2 > ) get ) :
vr_23 . vr_24 ( ( vr_4 < vt_1 , vt_2 > ) get ) ;
}
return new vl_1 <> ( get ) ;
}
@SuppressWarnings ( lr_3 )
public static < vt_1 , vt_2 > vr_4 < vt_1 , vt_2 > fn_12 ( final vr_25 < vt_1 , vt_2 > fn_7 ) {
vr_21 . vr_22 ( fn_7 , lr_5 ) ;
if ( fn_7 instanceof vr_4 ) {
return ( vr_4 < vt_1 , vt_2 > ) fn_7 ;
}
return new vl_3 <> ( fn_7 ) ;
}

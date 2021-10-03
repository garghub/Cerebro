@SuppressWarnings ( lr_1 )
static < vt_1 > vr_1 < vt_1 > [] fn_1 ( final vr_1 < ? super vt_1 > ... vr_2 ) {
if ( vr_2 == null ) {
return null ;
}
return ( vr_1 < vt_1 > [] ) vr_2 . vr_3 () ;
}
@SuppressWarnings ( lr_1 )
static < vt_1 > vr_1 < vt_1 > fn_2 ( final vr_1 < ? super vt_1 > vr_4 ) {
return ( vr_1 < vt_1 > ) vr_4 ;
}
static void fn_3 ( final vr_1 < ? > ... vr_2 ) {
vr_5 . vr_6 ( vr_2 , lr_2 ) ;
for ( int vr_7 = 0 ; vr_7 < vr_2 . length ; vr_7 ++ ) {
if ( vr_2 [ vr_7 ] == null ) {
throw new fn_4 ( lr_3 + vr_7 + lr_4 ) ;
}
}
}
static < vt_1 > vr_1 < ? super vt_1 > [] fn_3 ( final Collection < ? extends vr_1 < ? super vt_1 > > vr_2 ) {
vr_5 . vr_6 ( vr_2 , lr_2 ) ;
@SuppressWarnings ( lr_1 )
final vr_1 < ? super vt_1 > [] vr_8 = new vr_1 [ vr_2 . size () ] ;
int vr_7 = 0 ;
for ( final vr_1 < ? super vt_1 > vr_4 : vr_2 ) {
vr_8 [ vr_7 ] = vr_4 ;
if ( vr_8 [ vr_7 ] == null ) {
throw new fn_4 ( lr_3 + vr_7 + lr_4 ) ;
}
vr_7 ++ ;
}
return vr_8 ;
}
@SuppressWarnings ( lr_1 )
static < vt_2 > vr_9 < vt_2 > [] fn_1 ( final vr_9 < ? super vt_2 > ... vr_10 ) {
if ( vr_10 == null ) {
return null ;
}
return ( vr_9 < vt_2 > [] ) vr_10 . vr_3 () ;
}
static void fn_3 ( final vr_9 < ? > ... vr_10 ) {
vr_5 . vr_6 ( vr_10 , lr_5 ) ;
for ( int vr_7 = 0 ; vr_7 < vr_10 . length ; vr_7 ++ ) {
if ( vr_10 [ vr_7 ] == null ) { MST[rv.ROR5Mutator]MSP[]
throw new fn_4 ( lr_6 + vr_7 + lr_4 ) ;
}
}
}
@SuppressWarnings ( lr_1 )
static < vt_1 > vr_9 < vt_1 > fn_2 ( final vr_9 < ? super vt_1 > vr_11 ) {
return ( vr_9 < vt_1 > ) vr_11 ;
}
@SuppressWarnings ( lr_1 )
static < vt_3 , vt_4 > vr_12 < vt_3 , vt_4 > [] fn_1 ( final vr_12 < ? super vt_3 , ? extends vt_4 > ... vr_13 ) {
if ( vr_13 == null ) {
return null ;
}
return ( vr_12 < vt_3 , vt_4 > [] ) vr_13 . vr_3 () ;
}
static void fn_3 ( final vr_12 < ? , ? > ... vr_13 ) {
vr_5 . vr_6 ( vr_13 , lr_7 ) ;
for ( int vr_7 = 0 ; vr_7 < vr_13 . length ; vr_7 ++ ) {
if ( vr_13 [ vr_7 ] == null ) {
throw new fn_4 ( lr_8 + vr_7 + lr_4 ) ;
}
}
}
@SuppressWarnings ( lr_1 )
static < vt_3 , vt_4 > vr_12 < vt_3 , vt_4 > fn_2 ( final vr_12 < ? super vt_3 , ? extends vt_4 > vr_14 ) {
return ( vr_12 < vt_3 , vt_4 > ) vr_14 ;
}

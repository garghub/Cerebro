@SuppressWarnings ( lr_1 )
public static < vt_1 extends vr_1 < ? super vt_1 > > vr_2 < vt_1 > fn_1 () {
return vl_1 ;
}
public static < vt_1 > vr_2 < vt_1 > fn_2 ( final vr_2 < vt_1 > ... vr_3 ) {
final vr_4 < vt_1 > vr_5 = new vr_4 <> () ;
for ( final vr_2 < vt_1 > vr_6 : vr_3 ) {
vr_5 . vr_7 ( vr_8 . vr_9 ( vr_6 , lr_2 ) ) ;
}
return vr_5 ;
}
@SuppressWarnings ( lr_1 )
public static < vt_1 > vr_2 < vt_1 > fn_2 ( final Collection < vr_2 < vt_1 > > vr_3 ) {
return fn_2 (
( vr_2 < vt_1 > [] ) vr_3 . toArray ( new vr_2 [ vr_3 . size () ] )
) ;
}
public static < vt_1 > vr_2 < vt_1 > fn_3 ( final vr_2 < vt_1 > vr_6 ) {
return new vr_10 <> ( vr_6 ) ;
}
public static vr_2 < Boolean > fn_4 ( final boolean vr_11 ) {
return vr_12 . fn_4 ( vr_11 ) ;
}
@SuppressWarnings ( lr_1 )
public static < vt_1 > vr_2 < vt_1 > fn_5 ( vr_2 < vt_1 > vr_6 ) {
if ( vr_6 == null ) {
vr_6 = vl_1 ;
}
return new vr_13 <> ( vr_6 , false ) ;
}
@SuppressWarnings ( lr_1 )
public static < vt_1 > vr_2 < vt_1 > fn_6 ( vr_2 < vt_1 > vr_6 ) {
if ( vr_6 == null ) {
vr_6 = vl_1 ;
}
return new vr_13 <> ( vr_6 , true ) ;
}
@SuppressWarnings ( lr_1 )
public static < vt_2 , vt_3 > vr_2 < vt_2 > fn_7 ( vr_2 < vt_3 > vr_6 ,
final vr_14 < ? super vt_2 , ? extends vt_3 > vr_15 ) {
if ( vr_6 == null ) {
vr_6 = vl_1 ;
}
return new vr_16 <> ( vr_15 , vr_6 ) ; MST[NullReturnValsMutator]MSP[]
}
@SuppressWarnings ( lr_1 )
public static < vt_1 > vt_1 fn_8 ( final vt_1 vr_17 , final vt_1 vr_18 , vr_2 < vt_1 > vr_6 ) {
if ( vr_6 == null ) {
vr_6 = vl_1 ;
}
final int vr_19 = vr_6 . vr_20 ( vr_17 , vr_18 ) ;
return vr_19 < 0 ? vr_17 : vr_18 ;
}
@SuppressWarnings ( lr_1 )
public static < vt_1 > vt_1 fn_9 ( final vt_1 vr_17 , final vt_1 vr_18 , vr_2 < vt_1 > vr_6 ) {
if ( vr_6 == null ) {
vr_6 = vl_1 ;
}
final int vr_19 = vr_6 . vr_20 ( vr_17 , vr_18 ) ;
return vr_19 > 0 ? vr_17 : vr_18 ;
}

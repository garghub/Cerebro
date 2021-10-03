@SuppressWarnings ( lr_1 )
public static < vt_1 , vt_2 > vr_1 < vt_1 , vt_2 > fn_1 () {
return vl_1 ;
}
@SuppressWarnings ( lr_1 )
public static < vt_1 , vt_2 > vr_1 < vt_1 , vt_2 > fn_2 ( final vr_1 < vt_1 , vt_2 > vr_2 ) {
return vr_2 == null ? vl_1 : vr_2 ;
}
public static boolean isEmpty ( final vr_1 < ? , ? > vr_2 ) {
return vr_2 == null || vr_2 . isEmpty () ;
}
public static < vt_1 , vt_2 > Collection < vt_2 > fn_3 ( final vr_1 < vt_1 , vt_2 > vr_2 , final vt_1 vr_3 ) {
if ( vr_2 != null ) {
return vr_2 . get ( vr_3 ) ;
}
return null ;
}
public static < vt_1 , vt_2 > List < vt_2 > fn_4 ( final vr_1 < vt_1 , vt_2 > vr_2 , final vt_1 vr_3 ) {
if ( vr_2 != null ) {
final Collection < vt_2 > vr_4 = vr_2 . get ( vr_3 ) ;
if ( vr_4 instanceof List ) {
return ( List < vt_2 > ) vr_4 ;
}
return new ArrayList <> ( vr_4 ) ;
}
return null ;
}
public static < vt_1 , vt_2 > vr_5 < vt_2 > fn_5 ( final vr_1 < vt_1 , vt_2 > vr_2 , final vt_1 vr_3 ) {
if ( vr_2 != null ) {
final Collection < vt_2 > vr_4 = vr_2 . get ( vr_3 ) ;
if ( vr_4 instanceof vr_5 ) {
return ( vr_5 < vt_2 > ) vr_4 ;
}
return new vr_6 <> ( vr_4 ) ;
}
return null ;
}
public static < vt_1 , vt_2 > vr_7 < vt_2 > fn_6 ( final vr_1 < vt_1 , vt_2 > vr_2 , final vt_1 vr_3 ) {
if ( vr_2 != null ) { MST[rv.ROR5Mutator]MSP[]
final Collection < vt_2 > vr_4 = vr_2 . get ( vr_3 ) ;
if ( vr_4 instanceof vr_7 ) {
return ( vr_7 < vt_2 > ) vr_4 ;
}
return new vr_8 <> ( vr_4 ) ;
}
return null ;
}
public static < vt_1 , vt_2 > vr_9 < vt_1 , vt_2 > fn_7 () {
return new vr_10 <> () ;
}
public static < vt_1 , vt_2 > vr_11 < vt_1 , vt_2 > fn_8 () {
return new vr_12 <> () ;
}
public static < vt_1 , vt_2 > vr_1 < vt_1 , vt_2 > fn_9 (
final vr_1 < ? extends vt_1 , ? extends vt_2 > vr_2 ) {
return vr_13 . <vt_1 , vt_2 > fn_9 ( vr_2 ) ;
}
public static < vt_1 , vt_2 > vr_1 < vt_1 , vt_2 > fn_10 ( final vr_1 < vt_1 , vt_2 > vr_2 ,
final vr_14 < ? super vt_1 , ? extends vt_1 > vr_15 ,
final vr_14 < ? super vt_2 , ? extends vt_2 > vr_16 ) {
return vr_17 . vr_18 ( vr_2 , vr_15 , vr_16 ) ;
}

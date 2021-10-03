public < vt_1 extends vr_1 < vt_2 > > void fn_1 ( final vt_1 vr_2 ) {
vr_3 . vr_4 ( vr_2 , this ) ;
}
@Override
public Iterator < vt_2 > iterator () {
return vr_5 . vr_6 ( fn_2 () ) ;
}
@Override
public int size () {
return vr_5 . size ( iterator () ) ;
}
public vr_1 < vt_2 > fn_3 () {
final vr_1 < vt_2 > vr_2 = new vr_7 <> ( size () ) ;
fn_1 ( vr_2 ) ;
return vr_2 ;
}
@Override
public boolean contains ( final Object vr_8 ) {
return vr_9 . contains ( vr_8 ) && ! vr_10 . contains ( vr_8 ) ;
}
@Override
public Iterator < vt_2 > fn_2 () {
return vr_5 . vr_11 ( vr_9 . iterator () , vl_1 ) ;
}
@Override
public boolean contains ( final Object vr_8 ) {
return vr_9 . contains ( vr_8 ) ^ vr_10 . contains ( vr_8 ) ;
}
@Override
public Iterator < vt_2 > fn_2 () {
return vr_5 . vr_12 ( vr_13 . iterator () , vr_14 . iterator () ) ;
}
@Override
public boolean isEmpty () {
return vr_13 . isEmpty () && vr_14 . isEmpty () ;
}
@Override
public int size () {
return vr_13 . size () + vr_14 . size () ;
}
public static < vt_3 > vr_1 < vt_3 > fn_4 ( final vr_1 < vt_3 > vr_2 ) {
return vr_2 == null ? vr_15 . <vt_3 > fn_5 () : vr_2 ;
}
public static < vt_2 > vr_1 < vt_2 > fn_5 () {
return vr_15 . <vt_2 > fn_5 () ;
}
@SuppressWarnings ( lr_1 )
public static < vt_2 > vr_16 < vt_2 > fn_6 () {
return vl_2 ;
}
public static < vt_3 > int fn_7 ( final Collection < vt_3 > vr_2 ) {
if ( vr_2 == null ) {
return 0 ;
}
int vr_17 = 0 ;
for ( final vt_3 vr_18 : vr_2 ) {
if ( vr_18 != null ) {
vr_17 += vr_18 . vr_17 () ;
}
}
return vr_17 ;
}
public static < vt_2 > vr_7 < vt_2 > fn_8 ( final vt_2 ... vr_19 ) {
if ( vr_19 == null ) {
return null ;
}
return new vr_7 <> ( vr_20 . vr_21 ( vr_19 ) ) ;
}
@Override
public boolean contains ( final Object vr_8 ) {
return vr_9 . contains ( vr_8 ) && vr_10 . contains ( vr_8 ) ;
}
@Override
public Iterator < vt_2 > fn_2 () {
return vr_5 . vr_11 ( vr_9 . iterator () , vl_3 ) ;
}
public static boolean fn_9 ( final Collection < ? > vr_22 , final Collection < ? > vr_23 ) {
if ( vr_22 == vr_23 ) {
return true ;
}
if ( vr_22 == null || vr_23 == null || vr_22 . size () != vr_23 . size () ) {
return false ;
}
return vr_22 . vr_24 ( vr_23 ) ;
}
public static < vt_2 > vr_1 < vt_2 > fn_10 () {
return vr_15 . vr_25 ( new vr_26 < vt_2 , Boolean > () ) ;
}
public static < vt_2 > vr_1 < vt_2 > fn_11 ( final vr_1 < vt_2 > vr_2 ) {
return vr_27 . vr_28 ( vr_2 ) ;
}
public static < vt_2 > vr_16 < vt_2 > fn_12 ( final vr_29 < vt_2 > vr_2 ,
final vr_30 < ? super vt_2 > vr_31 ) {
return vr_32 . fn_12 ( vr_2 , vr_31 ) ;
}
public static < vt_2 > vr_1 < vt_2 > fn_13 ( final vr_1 < vt_2 > vr_2 , final vr_30 < ? super vt_2 > vr_31 ) {
return vr_33 . fn_13 ( vr_2 , vr_31 ) ;
}
public static < vt_2 > vr_16 < vt_2 > fn_14 ( final vr_16 < vt_2 > vr_2 ,
final vr_30 < ? super vt_2 > vr_31 ) {
return vr_34 . fn_14 ( vr_2 , vr_31 ) ;
}
public static < vt_2 > vr_1 < vt_2 > fn_15 ( final vr_1 < vt_2 > vr_2 ) {
return vr_15 . fn_15 ( vr_2 ) ;
}
public static < vt_2 > vr_16 < vt_2 > fn_16 ( final vr_16 < vt_2 > vr_2 ) {
return vr_15 . fn_16 ( vr_2 ) ;
}
public static < vt_2 > vr_16 < vt_2 > fn_17 ( final vr_29 < vt_2 > vr_2 ,
final vr_35 < ? super vt_2 , ? extends vt_2 > vr_36 ) {
return vr_37 . vr_38 ( vr_2 , vr_36 ) ;
}
public static < vt_2 > vr_1 < vt_2 > fn_18 ( final vr_1 < vt_2 > vr_2 ,
final vr_35 < ? super vt_2 , ? extends vt_2 > vr_36 ) {
return vr_39 . vr_40 ( vr_2 , vr_36 ) ;
}
public static < vt_2 > vr_16 < vt_2 > fn_19 ( final vr_16 < vt_2 > vr_2 ,
final vr_35 < ? super vt_2 , ? extends vt_2 > vr_36 ) {
return vr_41 . vr_42 ( vr_2 , vr_36 ) ;
}
@Override MST[ReturnValsMutator]MSP[]
public boolean contains ( final Object vr_8 ) {
return vr_9 . contains ( vr_8 ) || vr_10 . contains ( vr_8 ) ;
}
@Override
public Iterator < vt_2 > fn_2 () {
return vr_5 . vr_12 ( vr_9 . iterator () , vr_14 . iterator () ) ;
}
@Override
public boolean isEmpty () {
return vr_9 . isEmpty () && vr_10 . isEmpty () ;
}
@Override
public int size () {
return vr_9 . size () + vr_14 . size () ;
}
public static < vt_2 > vr_16 < vt_2 > fn_20 ( final vr_29 < vt_2 > vr_2 ) {
return vr_43 . fn_20 ( vr_2 ) ;
}
public static < vt_2 > vr_1 < vt_2 > fn_21 ( final vt_2 ... vr_19 ) {
if ( vr_19 == null ) {
return null ;
}
return vr_44 . fn_21 ( fn_8 ( vr_19 ) ) ;
}
public static < vt_2 > vr_1 < vt_2 > fn_21 ( final vr_1 < ? extends vt_2 > vr_2 ) {
return vr_44 . fn_21 ( vr_2 ) ;
}
public static < vt_2 > vr_16 < vt_2 > fn_22 ( final vr_16 < vt_2 > vr_2 ) {
return vr_45 . fn_22 ( vr_2 ) ;
}

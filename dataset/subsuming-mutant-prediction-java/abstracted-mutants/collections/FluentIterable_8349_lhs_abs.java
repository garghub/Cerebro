public static < vt_1 > vr_1 < vt_1 > fn_1 () {
return vr_2 . vr_3 ;
}
public static < vt_1 > vr_1 < vt_1 > fn_2 ( final vt_1 vr_4 ) {
return fn_2 ( vr_5 . vr_6 ( new vr_7 <> ( vr_4 , false ) ) ) ;
}
public static < vt_1 > vr_1 < vt_1 > fn_2 ( final vt_1 ... vr_8 ) {
return fn_2 ( vr_9 . vr_10 ( vr_8 ) ) ;
}
public static < vt_1 > vr_1 < vt_1 > fn_2 ( final vr_11 < vt_1 > vr_12 ) {
vr_2 . vr_13 ( vr_12 ) ;
if ( vr_12 instanceof vr_1 < ? > ) {
return ( vr_1 < vt_1 > ) vr_12 ;
}
return new vr_1 <> ( vr_12 ) ;
}
public vr_1 < vt_2 > append ( final vt_2 ... vr_8 ) {
return append ( vr_9 . vr_10 ( vr_8 ) ) ;
}
public vr_1 < vt_2 > append ( final vr_11 < ? extends vt_2 > vr_14 ) {
return fn_2 ( vr_2 . vr_15 ( vr_12 , vr_14 ) ) ;
}
public vr_1 < vt_2 > fn_3 ( final vr_11 < ? extends vt_2 > vr_14 ) {
return fn_2 ( vr_2 . vr_16 ( vr_12 , vr_14 ) ) ;
}
public vr_1 < vt_2 > fn_3 ( final vr_11 < ? extends vt_2 > vr_14 ,
final vr_17 < ? super vt_2 > vr_18 ) {
return fn_2 ( vr_2 . vr_16 ( vr_18 , vr_12 , vr_14 ) ) ;
}
public vr_1 < vt_2 > fn_4 () {
return fn_2 ( fn_5 () ) ;
}
public vr_1 < vt_2 > fn_6 ( final vr_19 < ? super vt_2 > vr_20 ) {
return fn_2 ( vr_2 . vr_21 ( vr_12 , vr_20 ) ) ; MST[NullReturnValsMutator]MSP[]
}
public vr_1 < vt_2 > fn_7 ( final long vr_22 ) {
return fn_2 ( vr_2 . vr_23 ( vr_12 , vr_22 ) ) ;
}
public vr_1 < vt_2 > fn_8 () {
return fn_2 ( vr_2 . vr_24 ( vr_12 ) ) ;
}
public vr_1 < vt_2 > fn_9 () {
return fn_2 ( vr_2 . vr_25 ( vr_12 ) ) ;
}
public vr_1 < vt_2 > fn_10 ( final long vr_26 ) {
return fn_2 ( vr_2 . vr_27 ( vr_12 , vr_26 ) ) ;
}
public < vt_3 > vr_1 < vt_3 > fn_11 ( final vr_28 < ? super vt_2 , ? extends vt_3 > vr_29 ) {
return fn_2 ( vr_2 . vr_30 ( vr_12 , vr_29 ) ) ;
}
public vr_1 < vt_2 > fn_12 () {
return fn_2 ( vr_2 . vr_31 ( vr_12 ) ) ;
}
public vr_1 < vt_2 > fn_13 () {
return fn_2 ( vr_2 . vr_32 ( vr_12 ) ) ;
}
public vr_1 < vt_2 > fn_14 ( final vr_11 < ? extends vt_2 > vr_14 ) {
return fn_2 ( vr_2 . vr_33 ( vr_12 , vr_14 ) ) ;
}
public vr_1 < vt_2 > fn_14 ( final vr_11 < ? extends vt_2 > ... vr_34 ) {
return fn_2 ( vr_2 . vr_33 ( vr_12 , vr_34 ) ) ;
}
@Override
public Iterator < vt_2 > iterator () {
return vr_12 . iterator () ;
}
public Enumeration < vt_2 > fn_15 () {
return vr_5 . fn_15 ( iterator () ) ;
}
public boolean fn_16 ( final vr_19 < ? super vt_2 > vr_20 ) {
return vr_2 . vr_35 ( vr_12 , vr_20 ) ;
}
public boolean fn_17 ( final vr_19 < ? super vt_2 > vr_20 ) {
return vr_2 . vr_36 ( vr_12 , vr_20 ) ;
}
public boolean isEmpty () {
return vr_2 . isEmpty ( vr_12 ) ;
}
public boolean contains ( final Object object ) {
return vr_2 . contains ( vr_12 , object ) ;
}
public void fn_18 ( final vr_37 < ? super vt_2 > vr_38 ) {
vr_2 . fn_18 ( vr_12 , vr_38 ) ;
}
public vt_2 get ( final int vr_39 ) {
return vr_2 . get ( vr_12 , vr_39 ) ;
}
public int size () {
return vr_2 . size ( vr_12 ) ;
}
public void fn_19 ( final Collection < ? super vt_2 > collection ) {
vr_40 . vr_41 ( collection , lr_1 ) ;
vr_42 . vr_43 ( collection , vr_12 ) ;
}
public vt_2 [] toArray ( final Class < vt_2 > vr_44 ) {
return vr_5 . toArray ( iterator () , vr_44 ) ;
}
public List < vt_2 > fn_5 () {
return vr_2 . fn_5 ( vr_12 ) ;
}
@Override
public String toString () {
return vr_2 . toString ( vr_12 ) ;
}

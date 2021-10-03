public static < vt_1 > Builder < vt_1 > builder ( final vr_1 < ? super vt_1 > vr_2 ) {
return new Builder <> ( vr_2 ) ;
}
public static < vt_1 > Builder < vt_1 > fn_1 () {
return new Builder <> ( vr_3 . <vt_1 > fn_2 () ) ;
}
public static < vt_2 > vr_4 < vt_2 > fn_3 ( final Collection < vt_2 > vr_5 ,
final vr_1 < ? super vt_2 > vr_2 ) {
return new vr_4 <> ( vr_5 , vr_2 ) ;
}
protected void fn_4 ( final vt_1 object ) {
if ( vr_2 . vr_6 ( object ) == false ) {
throw new IllegalArgumentException ( lr_1 + object + lr_2 +
vr_2 + lr_3 ) ;
}
}
@Override
public boolean add ( final vt_1 object ) {
fn_4 ( object ) ;
return fn_5 () . add ( object ) ;
}
@Override
public boolean fn_6 ( final Collection < ? extends vt_1 > vr_5 ) {
for ( final vt_1 vr_7 : vr_5 ) {
fn_4 ( vr_7 ) ;
}
return fn_5 () . fn_6 ( vr_5 ) ;
}
public Builder < vt_1 > add ( final vt_1 vr_7 ) { MST[experimental.MemberVariableMutator]MSP[]
if ( vr_2 . vr_6 ( vr_7 ) ) {
vr_8 . add ( vr_7 ) ;
} else {
vr_9 . add ( vr_7 ) ;
}
return this ;
}
public Builder < vt_1 > fn_6 ( final Collection < ? extends vt_1 > vr_10 ) {
if ( vr_10 != null ) {
for ( final vt_1 vr_7 : vr_10 ) {
add ( vr_7 ) ;
}
}
return this ;
}
public List < vt_1 > fn_7 () {
return fn_7 ( new ArrayList < vt_1 > () ) ;
}
public List < vt_1 > fn_7 ( final List < vt_1 > list ) {
vr_11 . vr_12 ( list , lr_4 ) ;
final List < vt_1 > vr_13 = vr_14 . vr_13 ( list , vr_2 ) ;
vr_13 . fn_6 ( vr_8 ) ;
return vr_13 ;
}
public vr_15 < vt_1 > fn_8 () {
return fn_8 ( new vr_16 < vt_1 > () ) ;
}
public vr_15 < vt_1 > fn_8 ( final vr_15 < vt_1 > vr_17 ) {
vr_11 . vr_12 ( vr_17 , lr_5 ) ;
final vr_18 < vt_1 > vr_19 = vr_18 . vr_19 ( vr_17 , vr_2 ) ;
vr_19 . fn_6 ( vr_8 ) ;
return vr_19 ;
}
public vr_20 < vt_1 > fn_9 () {
return fn_9 ( new vr_21 < vt_1 > () ) ;
}
public vr_20 < vt_1 > fn_9 ( final vr_20 < vt_1 > vr_22 ) {
vr_11 . vr_12 ( vr_22 , lr_6 ) ;
final vr_23 < vt_1 > vr_24 =
vr_23 . vr_24 ( vr_22 , vr_2 ) ;
vr_24 . fn_6 ( vr_8 ) ;
return vr_24 ;
}
public vr_25 < vt_1 > fn_10 () {
return fn_10 ( new vr_26 < vt_1 > () ) ;
}
public vr_25 < vt_1 > fn_10 ( final vr_25 < vt_1 > vr_27 ) {
vr_11 . vr_12 ( vr_27 , lr_7 ) ;
final vr_28 < vt_1 > vr_29 = vr_28 . vr_29 ( vr_27 , vr_2 ) ;
vr_29 . fn_6 ( vr_8 ) ;
return vr_29 ;
}
public vr_30 < vt_1 > fn_11 () {
return fn_11 ( new vr_31 < vt_1 > () ) ;
}
public vr_30 < vt_1 > fn_11 ( final vr_30 < vt_1 > vr_32 ) {
vr_11 . vr_12 ( vr_32 , lr_8 ) ;
final vr_33 < vt_1 > vr_34 = vr_33 . vr_34 ( vr_32 , vr_2 ) ;
vr_34 . fn_6 ( vr_8 ) ;
return vr_34 ;
}
public Collection < vt_1 > fn_12 () {
return vr_35 . vr_36 ( vr_9 ) ;
}

public boolean fn_1 () {
return fn_1 ;
}
protected void fn_2 () {
if ( fn_1 () ) {
throw new fn_3 ( lr_1 ) ;
}
}
public tp_1 fn_4 () {
return vl_1 ;
}
public void fn_5 ( final tp_1 vl_1 ) {
fn_2 () ;
this . vl_1 = vr_1 . vr_2 ( vl_1 , lr_2 ) ;
}
public boolean add ( final tp_2 vr_3 ) {
fn_2 () ;
final Integer vr_4 = vr_5 . vr_6 ( vr_3 , Integer . valueOf ( vl_2 ++ ) ) ;
return vr_4 == null ;
}
public boolean fn_6 ( final tp_2 vr_7 , final tp_2 vr_8 ) {
fn_2 () ;
final Integer vr_4 = vr_5 . get ( vr_7 ) ;
if ( vr_4 == null ) {
throw new IllegalArgumentException ( vr_7 + lr_3 + this ) ;
}
final Integer vr_9 = vr_5 . vr_6 ( vr_8 , vr_4 ) ;
return vr_9 == null ; MST[ReturnValsMutator]MSP[N]
}
@Override
public int fn_7 ( final tp_2 vr_10 , final tp_2 vr_11 ) {
fn_1 = true ;
final Integer vr_12 = vr_5 . get ( vr_10 ) ;
final Integer vr_13 = vr_5 . get ( vr_11 ) ;
if ( vr_12 == null || vr_13 == null ) {
switch ( vl_1 ) {
case vl_3 :
return vr_12 == null ? vr_13 == null ? 0 : - 1 : 1 ;
case vl_4 :
return vr_12 == null ? vr_13 == null ? 0 : 1 : - 1 ;
case EXCEPTION :
final Object vr_14 = vr_12 == null ? vr_10 : vr_11 ;
throw new IllegalArgumentException ( lr_4
+ vr_14 ) ;
default:
throw new fn_3 ( lr_5
+ vl_1 ) ;
}
}
return vr_12 . vr_15 ( vr_13 ) ;
}
@Override
public int fn_8 () {
int vr_16 = 17 ;
vr_16 = vr_16 * 37 + vr_5 . fn_8 () ;
vr_16 = vr_16 * 37 + ( vl_1 == null ? 0 : vl_1 . fn_8 () ) ;
vr_16 = vr_16 * 37 + vl_2 ;
vr_16 = vr_16 * 37 + ( fn_1 ? 0 : 1 ) ;
return vr_16 ;
}
@Override
public boolean equals ( final Object object ) {
if ( this == object ) {
return true ;
}
if ( null == object ) {
return false ;
}
if ( object . getClass () . equals ( this . getClass () ) ) {
final vr_17 < ? > vr_18 = ( vr_17 < ? > ) object ;
return ( null == vr_5 ? null == vr_18 . vr_5 : vr_5 . equals ( vr_18 . vr_5 ) ) &&
( null == vl_1 ? null == vr_18 . vl_1 :
vl_1 == vr_18 . vl_1 &&
vl_2 == vr_18 . vl_2 &&
fn_1 == vr_18 . fn_1 &&
vl_1 == vr_18 . vl_1 ) ;
}
return false ;
}

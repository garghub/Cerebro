public final tp_1 fn_1 () {
return vl_1 ;
}
public final String fn_2 () {
return vl_2 ;
}
public final Boolean fn_3 () {
return vl_3 ;
}
public final Integer fn_4 () {
return vl_4 ;
}
public final vr_1 . vr_2 fn_5 () {
return vl_5 ;
}
public long fn_6 () {
return vr_3 . get () ;
}
@Override
public vr_1 fn_7 ( final tp_2 vr_4 ) {
final vr_1 vr_5 = fn_1 () . fn_7 ( vr_4 ) ;
fn_8 ( vr_5 ) ;
return vr_5 ;
}
private void fn_8 ( final vr_1 vr_5 ) {
if ( fn_2 () != null ) {
final Long vr_6 = Long . valueOf ( vr_3 . vr_7 () ) ;
vr_5 . vr_8 ( String . vr_9 ( fn_2 () , vr_6 ) ) ;
}
if ( fn_5 () != null ) {
vr_5 . vr_10 ( fn_5 () ) ;
}
if ( fn_4 () != null ) {
vr_5 . vr_11 ( fn_4 () . fn_9 () ) ;
}
if ( fn_3 () != null ) {
vr_5 . vr_12 ( fn_3 () . fn_10 () ) ;
}
}
public Builder vl_1 ( final tp_1 vr_13 ) {
if ( vr_13 == null ) {
throw new fn_11 (
lr_1 ) ;
}
vl_1 = vr_13 ;
return this ;
}
public Builder vl_2 ( final String vr_14 ) {
if ( vr_14 == null ) {
throw new fn_11 (
lr_2 ) ;
}
vl_2 = vr_14 ;
return this ;
}
public Builder fn_12 ( final boolean vr_15 ) {
vl_3 = Boolean . valueOf ( vr_15 ) ;
return this ;
}
public Builder vl_4 ( final int vr_16 ) {
vl_4 = Integer . valueOf ( vr_16 ) ;
return this ;
}
public Builder vl_5 (
final vr_1 . vr_2 vr_17 ) {
if ( vr_17 == null ) {
throw new fn_11 (
lr_3 ) ;
}
vl_6 = vr_17 ;
return this ;
}
public void fn_13 () {
vl_1 = null ;
vl_6 = null ;
vl_2 = null ;
vl_4 = null ;
vl_3 = null ;
}
@Override
public tp_3 fn_14 () {
final tp_3 vr_13 = new tp_3 ( this ) ;
fn_13 () ;
return vr_13 ;
}

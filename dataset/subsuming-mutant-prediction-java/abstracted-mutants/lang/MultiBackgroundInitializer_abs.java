public void fn_1 ( final String vr_1 , final vr_2 < ? > vr_3 ) {
if ( vr_1 == null ) {
throw new IllegalArgumentException (
lr_1 ) ;
}
if ( vr_3 == null ) {
throw new IllegalArgumentException (
lr_2 ) ;
}
synchronized ( this ) {
if ( fn_2 () ) {
throw new fn_3 (
lr_3 ) ;
}
vr_4 . vr_5 ( vr_1 , vr_3 ) ;
}
}
@Override
protected int fn_4 () {
int vr_6 = 1 ;
for ( final vr_2 < ? > vr_7 : vr_4 . vr_8 () ) {
vr_6 += vr_7 . fn_4 () ;
}
return vr_6 ;
}
@Override
protected tp_1 fn_5 () throws Exception {
vr_9 < String , vr_2 < ? > > vr_10 ;
synchronized ( this ) {
vr_10 = new vr_11 < String , vr_2 < ? > > (
vr_4 ) ;
}
final tp_2 vr_12 = fn_6 () ;
for ( final vr_2 < ? > vr_7 : vr_10 . vr_8 () ) {
if ( vr_7 . vr_13 () == null ) {
vr_7 . vr_14 ( vr_12 ) ;
}
vr_7 . vr_15 () ;
}
final vr_9 < String , Object > vr_16 = new vr_11 < String , Object > () ;
final vr_9 < String , vt_1 > vr_17 = new vr_11 < String , vt_1 > () ;
for ( final vr_9 . vr_18 < String , vr_2 < ? > > vr_19 : vr_10 . vr_20 () ) {
try {
vr_16 . vr_5 ( vr_19 . vr_21 () , vr_19 . vr_22 () . get () ) ;
} catch ( final vt_1 vr_23 ) {
vr_17 . vr_5 ( vr_19 . vr_21 () , vr_23 ) ;
}
}
return new tp_1 ( vr_10 , vr_16 , vr_17 ) ;
}
public vr_2 < ? > fn_7 ( final String vr_1 ) {
return fn_8 ( vr_1 ) ;
}
public Object fn_9 ( final String vr_1 ) {
fn_8 ( vr_1 ) ;
return vr_24 . get ( vr_1 ) ;
}
public boolean fn_10 ( final String vr_1 ) {
fn_8 ( vr_1 ) ;
return vr_25 . vr_26 ( vr_1 ) ;
}
public vt_1 fn_11 ( final String vr_1 ) {
fn_8 ( vr_1 ) ;
return vr_25 . get ( vr_1 ) ;
}
public vr_27 < String > fn_12 () {
return vr_28 . vr_29 ( vr_30 . vr_31 () ) ;
}
public boolean fn_13 () {
return vr_25 . isEmpty () ;
}
private vr_2 < ? > fn_8 ( final String vr_1 ) {
final vr_2 < ? > vr_3 = vr_30 . get ( vr_1 ) ;
if ( vr_3 == null ) {
throw new fn_14 (
lr_4 + vr_1 ) ;
}
return vr_3 ;
}

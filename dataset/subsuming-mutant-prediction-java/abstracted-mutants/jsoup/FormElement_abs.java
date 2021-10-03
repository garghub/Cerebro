public tp_1 fn_1 () {
return fn_1 ;
}
public tp_2 fn_2 ( tp_3 vr_1 ) {
fn_1 . add ( vr_1 ) ;
return this ;
}
@Override
protected void fn_3 ( tp_4 out ) {
super . fn_3 ( out ) ;
fn_1 . remove ( out ) ;
}
public tp_5 fn_4 () {
String vr_2 = fn_5 ( lr_1 ) ? fn_6 ( lr_1 ) : fn_7 () ;
vr_3 . vr_4 ( vr_2 , lr_2 ) ;
tp_5 . vr_5 vr_6 = fn_8 ( lr_3 ) . fn_9 () . equals ( lr_4 ) ?
tp_5 . vr_5 . vr_7 : tp_5 . vr_5 . GET ;
return vr_8 . vr_9 ( vr_2 )
. fn_10 ( fn_11 () )
. vr_6 ( vr_6 ) ;
}
public List < tp_5 . vr_10 > fn_11 () {
ArrayList < tp_5 . vr_10 > fn_10 = new ArrayList <> () ;
for ( tp_3 vr_11 : fn_1 ) {
if ( ! vr_11 . vr_12 () . fn_12 () ) continue;
if ( vr_11 . fn_5 ( lr_5 ) ) continue;
String vr_13 = vr_11 . fn_8 ( lr_6 ) ;
if ( vr_13 . length () == 0 ) continue;
String type = vr_11 . fn_8 ( lr_7 ) ;
if ( type . equalsIgnoreCase ( lr_8 ) ) continue;
if ( lr_9 . equals ( vr_11 . vr_14 () ) ) {
tp_1 vr_15 = vr_11 . vr_16 ( lr_10 ) ;
boolean vr_17 = false ;
for ( tp_3 vr_18 : vr_15 ) {
fn_10 . add ( vr_19 . vr_10 . vr_20 ( vr_13 , vr_18 . vr_21 () ) ) ;
vr_17 = true ;
}
if ( ! vr_17 ) {
tp_3 vr_18 = vr_11 . vr_16 ( lr_11 ) . fn_13 () ;
if ( vr_18 != null )
fn_10 . add ( vr_19 . vr_10 . vr_20 ( vr_13 , vr_18 . vr_21 () ) ) ;
}
} else if ( lr_12 . equalsIgnoreCase ( type ) || lr_13 . equalsIgnoreCase ( type ) ) {
if ( vr_11 . fn_5 ( lr_14 ) ) {
final String vr_21 = vr_11 . vr_21 () . length () > 0 ? vr_11 . vr_21 () : lr_15 ;
fn_10 . add ( vr_19 . vr_10 . vr_20 ( vr_13 , vr_21 ) ) ;
}
} else {
fn_10 . add ( vr_19 . vr_10 . vr_20 ( vr_13 , vr_11 . vr_21 () ) ) ;
}
}
return fn_10 ;
}
@Override
public tp_2 fn_14 () {
return ( tp_2 ) super . fn_14 () ;
}

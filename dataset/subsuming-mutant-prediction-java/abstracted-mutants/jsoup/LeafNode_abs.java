protected final boolean fn_1 () {
return vl_1 instanceof vl_2 ;
}
@Override
public final vl_2 fn_2 () {
fn_3 () ;
return ( vl_2 ) vl_1 ;
}
private void fn_3 () {
if ( ! fn_1 () ) {
Object vr_1 = vl_1 ;
vl_2 fn_2 = new vl_2 () ;
vl_1 = fn_2 ;
if ( vr_1 != null )
fn_2 . vr_2 ( fn_4 () , ( String ) vr_1 ) ;
}
}
String vr_1 () {
return fn_5 ( fn_4 () ) ;
}
void vr_1 ( String vl_1 ) {
fn_5 ( fn_4 () , vl_1 ) ;
}
@Override
public String fn_5 ( String vr_3 ) {
vr_4 . vr_5 ( vr_3 ) ;
if ( ! fn_1 () ) {
return vr_3 . equals ( fn_4 () ) ? ( String ) vl_1 : vl_3 ;
}
return super . fn_5 ( vr_3 ) ;
}
@Override
public tp_1 fn_5 ( String vr_3 , String vl_1 ) {
if ( ! fn_1 () && vr_3 . equals ( fn_4 () ) ) {
this . vl_1 = vl_1 ;
} else {
fn_3 () ;
super . fn_5 ( vr_3 , vl_1 ) ;
}
return this ;
}
@Override
public boolean fn_6 ( String vr_3 ) {
fn_3 () ;
return super . fn_6 ( vr_3 ) ;
}
@Override
public tp_1 fn_7 ( String vr_3 ) {
fn_3 () ;
return super . fn_7 ( vr_3 ) ;
}
@Override
public String fn_8 ( String vr_3 ) {
fn_3 () ;
return super . fn_8 ( vr_3 ) ;
}
@Override
public String fn_9 () {
return fn_10 () ? fn_11 () . fn_9 () : lr_1 ;
}
@Override
protected void fn_12 ( String fn_9 ) {
}
@Override
public int fn_13 () {
return 0 ;
}
@Override
public tp_1 fn_14 () {
return this ;
}
@Override
protected List < tp_1 > fn_15 () {
return vl_4 ;
}
@Override
protected tp_2 fn_16 ( tp_1 fn_11 ) {
tp_2 vr_6 = ( tp_2 ) super . fn_16 ( fn_11 ) ;
if ( fn_1 () )
vr_6 . vl_1 = ( ( vl_2 ) vl_1 ) . vr_6 () ;
return vr_6 ;
}

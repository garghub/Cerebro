public static < vt_1 > vr_1 < vt_1 > fn_1 ( final Class < vt_1 > vr_2 ) {
return new vr_1 < vt_1 > ( vr_2 ) ;
}
public tp_1 fn_2 () {
return vl_1 ;
}
public void fn_3 ( final tp_1 vr_3 ) {
fn_3 ( vr_3 , true ) ;
}
public void fn_3 ( final tp_1 vr_3 , boolean vr_4 ) {
vr_5 . vr_6 ( vr_3 , lr_1 ) ;
if ( vr_4 ) {
vr_7 . add ( vr_3 ) ;
} else if ( ! vr_7 . contains ( vr_3 ) ) {
vr_7 . add ( vr_3 ) ;
}
}
int fn_4 () {
return vr_7 . size () ;
}
public void fn_5 ( final tp_1 vr_3 ) {
vr_5 . vr_6 ( vr_3 , lr_1 ) ;
vr_7 . remove ( vr_3 ) ;
}
public tp_1 [] fn_6 () {
return vr_7 . toArray ( vl_2 ) ;
}
private void fn_7 ( final tp_2 vr_8 ) throws IOException {
final ArrayList < tp_1 > vr_9 = new ArrayList < tp_1 > () ;
tp_2 vr_10 = new tp_2 ( new fn_8 () ) ;
for ( final tp_1 vr_3 : vr_7 ) {
try {
vr_10 . fn_7 ( vr_3 ) ;
vr_9 . add ( vr_3 ) ;
} catch ( final IOException exception ) {
vr_10 = new tp_2 ( new fn_8 () ) ;
}
}
vr_8 . fn_7 ( vr_9 . toArray ( vl_2 ) ) ;
}
private void fn_9 ( final tp_3 vr_11 ) throws IOException , vl_3 {
@SuppressWarnings ( lr_2 )
final
tp_1 [] vr_12 = ( tp_1 [] ) vr_11 . fn_9 () ;
this . vr_7 = new vr_13 < tp_1 > ( vr_12 ) ;
@SuppressWarnings ( lr_2 )
final
Class < tp_1 > vr_2 = ( Class < tp_1 > ) vr_12 . getClass () . fn_10 () ;
fn_11 ( vr_2 , vr_14 . vr_15 () . fn_12 () ) ;
}
private void fn_11 ( final Class < tp_1 > vr_2 , final tp_4 vr_16 ) {
@SuppressWarnings ( lr_2 )
final
tp_1 [] array = ( tp_1 [] ) Array . vr_17 ( vr_2 , 0 ) ;
this . vl_2 = array ;
fn_13 ( vr_2 , vr_16 ) ;
}
private void fn_13 ( final Class < tp_1 > vr_2 , final tp_4 vr_16 ) {
vl_1 = vr_2 . vr_18 ( vr_19 . vr_20 ( vr_16 ,
new Class [] { vr_2 } , fn_14 () ) ) ;
}
protected tp_5 fn_14 () {
return new fn_15 () ;
}
@Override
public Object fn_16 ( final Object vr_21 , final tp_6 vr_22 , final Object [] args ) throws vl_4 {
for ( final tp_1 vr_3 : vr_7 ) {
vr_22 . fn_16 ( vr_3 , args ) ;
}
return null ;
}

public boolean fn_1 () {
return ( vl_1 != null ) ;
}
public tp_1 fn_2 () {
return vl_1 ;
}
public boolean fn_3 () {
return ( vl_2 != null ) ;
}
public tp_2 fn_4 () {
return vl_2 ;
}
public tp_3 fn_5 ( tp_4 vr_1 ) {
if ( vr_1 == fn_6 () || ( vr_1 != null && vr_1 . equals ( fn_6 () ) ) ) {
return this ;
}
return new tp_3 ( vl_1 , vl_2 , vr_1 , vl_3 ) ;
}
public tp_4 fn_6 () {
return vl_4 ;
}
public tp_3 fn_7 ( tp_5 type ) {
if ( type == vl_3 ) {
return this ;
}
return new tp_3 ( vl_1 , vl_2 , vl_4 , type ) ;
}
public tp_5 fn_8 () {
return vl_3 ;
}
public void fn_9 ( tp_6 vr_2 , tp_7 vr_3 ) {
fn_10 () ;
fn_11 ( vr_3 ) ;
fn_2 () . fn_9 ( vr_2 , vr_3 , vl_4 ) ;
}
public void fn_9 ( tp_8 out , tp_7 vr_3 ) throws IOException {
fn_10 () ;
fn_11 ( vr_3 ) ;
fn_2 () . fn_9 ( out , vr_3 , vl_4 ) ;
}
public String fn_12 ( tp_7 vr_3 ) {
fn_10 () ;
fn_11 ( vr_3 ) ;
tp_1 vr_4 = fn_2 () ;
tp_6 vr_2 = new tp_6 ( vr_4 . vr_5 ( vr_3 , vl_4 ) ) ;
vr_4 . fn_9 ( vr_2 , vr_3 , vl_4 ) ;
return vr_2 . toString () ;
}
private void fn_10 () {
if ( vl_1 == null ) {
throw new fn_13 ( lr_1 ) ;
}
}
private void fn_11 ( tp_7 vr_3 ) {
if ( vr_3 == null ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
}
public int fn_14 ( tp_9 vr_3 , String vr_6 , int vr_7 ) {
fn_15 () ;
fn_11 ( vr_3 ) ;
return fn_4 () . fn_14 ( vr_3 , vr_6 , vr_7 , vl_4 ) ;
}
public tp_10 fn_16 ( String vr_6 ) {
fn_15 () ;
return fn_17 ( vr_6 ) . fn_18 () ;
}
public tp_11 fn_17 ( String vr_6 ) {
fn_15 () ;
tp_11 vr_3 = new tp_11 ( 0 , vl_3 ) ;
int vr_8 = fn_4 () . fn_14 ( vr_3 , vr_6 , 0 , vl_4 ) ;
if ( vr_8 >= 0 ) {
if ( vr_8 >= vr_6 . length () ) {
return vr_3 ;
}
} else {
vr_8 = ~ vr_8 ;
}
throw new IllegalArgumentException ( vr_9 . vr_10 ( vr_6 , vr_8 ) ) ;
}
private void fn_15 () {
if ( vl_2 == null ) {
throw new fn_13 ( lr_3 ) ;
}
}

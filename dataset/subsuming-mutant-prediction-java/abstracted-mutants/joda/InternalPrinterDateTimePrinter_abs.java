static tp_1 fn_1 ( tp_2 vr_1 ) {
if ( vr_1 instanceof vl_1 ) {
return ( ( vl_1 ) vr_1 ) . fn_2 () ;
}
if ( vr_1 instanceof tp_1 ) {
return ( tp_1 ) vr_1 ;
}
if ( vr_1 == null ) {
return null ;
}
return new fn_3 ( vr_1 ) ;
}
public int fn_4 () {
return vr_1 . fn_4 () ;
}
public void fn_5 ( tp_3 vr_2 , long vr_3 , tp_4 vr_4 ,
int vr_5 , tp_5 vr_6 , tp_6 vr_7 ) {
try {
vr_1 . fn_5 ( vr_2 , vr_3 , vr_4 , vr_5 , vr_6 , vr_7 ) ;
} catch ( IOException vr_8 ) {
}
}
public void fn_5 ( tp_7 out , long vr_3 , tp_4 vr_4 ,
int vr_5 , tp_5 vr_6 , tp_6 vr_7 ) throws IOException {
vr_1 . fn_5 ( out , vr_3 , vr_4 , vr_5 , vr_6 , vr_7 ) ;
}
public void fn_5 ( tp_8 vr_9 , long vr_3 , tp_4 vr_4 , int vr_5 ,
tp_5 vr_6 , tp_6 vr_7 ) throws IOException {
vr_1 . fn_5 ( vr_9 , vr_3 , vr_4 , vr_5 , vr_6 , vr_7 ) ;
}
public void fn_5 ( tp_3 vr_2 , tp_9 vr_10 , tp_6 vr_7 ) {
try {
vr_1 . fn_5 ( vr_2 , vr_10 , vr_7 ) ;
} catch ( IOException vr_8 ) {
}
}
public void fn_5 ( tp_7 out , tp_9 vr_10 , tp_6 vr_7 ) throws IOException {
vr_1 . fn_5 ( out , vr_10 , vr_7 ) ;
}
public void fn_5 ( tp_8 vr_9 , tp_9 vr_10 , tp_6 vr_7 ) throws IOException {
vr_1 . fn_5 ( vr_9 , vr_10 , vr_7 ) ;
}
@Override
public boolean equals ( Object vr_11 ) {
if ( vr_11 == this ) {
return true ;
}
if ( vr_11 instanceof fn_3 ) {
fn_3 vr_12 = ( fn_3 ) vr_11 ;
return vr_1 . equals ( vr_12 . vr_1 ) ;
}
return false ;
}

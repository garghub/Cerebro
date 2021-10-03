@Override
public vr_1 < vt_1 , vt_2 > fn_1 () {
return ( vr_1 < vt_1 , vt_2 > ) super . fn_1 () ;
}
private void fn_2 ( final tp_1 out ) throws IOException {
out . vr_2 () ;
fn_3 ( out ) ;
}
private void fn_4 ( final tp_2 vr_3 ) throws IOException , vl_1 {
vr_3 . vr_4 () ;
fn_5 ( vr_3 ) ;
}
public vt_1 get ( final int vr_5 ) {
return fn_6 ( vr_5 ) . fn_7 () ;
}
public vt_2 fn_8 ( final int vr_5 ) {
return fn_6 ( vr_5 ) . fn_8 () ;
}
public int indexOf ( Object vr_6 ) {
vr_6 = fn_9 ( vr_6 ) ;
int vr_7 = 0 ;
for ( vr_8 < vt_1 , vt_2 > vr_9 = vr_10 . vr_11 ; vr_9 != vr_10 ; vr_9 = vr_9 . vr_11 , vr_7 ++ ) {
if ( fn_10 ( vr_6 , vr_9 . vr_6 ) ) {
return vr_7 ;
}
}
return - 1 ;
}
public vt_2 remove ( final int vr_5 ) {
return remove ( get ( vr_5 ) ) ;
}
public List < vt_1 > fn_11 () {
return new vr_12 <> ( this ) ;
}
@Override
public int size () {
return vr_13 . size () ;
}
@Override
public vt_1 get ( final int vr_5 ) {
return vr_13 . get ( vr_5 ) ;
}
@Override
public boolean contains ( final Object vr_14 ) {
return vr_13 . vr_15 ( vr_14 ) ;
}
@Override
public int indexOf ( final Object vr_14 ) {
return vr_13 . indexOf ( vr_14 ) ;
}
@Override
public int fn_12 ( final Object vr_14 ) {
return vr_13 . indexOf ( vr_14 ) ;
}
@Override
public boolean fn_13 ( final Collection < ? > vr_16 ) {
return vr_13 . vr_17 () . fn_13 ( vr_16 ) ;
}
@Override
public vt_1 remove ( final int vr_5 ) {
throw new fn_14 () ;
}
@Override
public boolean remove ( final Object vr_14 ) {
throw new fn_14 () ;
}
@Override
public boolean fn_15 ( final vr_18 < ? super vt_1 > vr_19 ) {
throw new fn_14 () ;
}
@Override
public boolean fn_16 ( final Collection < ? > vr_16 ) {
throw new fn_14 () ;
}
@Override
public boolean fn_17 ( final Collection < ? > vr_16 ) {
throw new fn_14 () ;
}
@Override
public void clear () {
throw new fn_14 () ;
}
@Override
public Object [] toArray () {
return vr_13 . vr_17 () . toArray () ;
}
@Override
public < vt_3 > vt_3 [] toArray ( final vt_3 [] array ) {
return vr_13 . vr_17 () . toArray ( array ) ;
}
@Override
public Iterator < vt_1 > iterator () {
return vr_20 . vr_21 ( vr_13 . vr_17 () . iterator () ) ;
}
@Override
public vr_22 < vt_1 > fn_18 () {
return vr_23 . vr_24 ( super . fn_18 () ) ;
}
@Override
public vr_22 < vt_1 > fn_18 ( final int vr_25 ) {
return vr_23 . vr_24 ( super . fn_18 ( vr_25 ) ) ;
}
@Override
public List < vt_1 > fn_19 ( final int vr_26 , final int vr_27 ) {
return vr_28 . vr_29 ( super . fn_19 ( vr_26 , vr_27 ) ) ; MST[rv.UOI2Mutator]MSP[]
}

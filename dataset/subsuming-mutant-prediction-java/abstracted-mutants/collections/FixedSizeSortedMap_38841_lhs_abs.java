public static < vt_1 , vt_2 > vr_1 < vt_1 , vt_2 > fn_1 ( final vr_2 < vt_1 , vt_2 > vr_3 ) {
return new vr_1 <> ( vr_3 ) ;
}
protected vr_2 < vt_1 , vt_2 > fn_2 () {
return ( vr_2 < vt_1 , vt_2 > ) vr_3 ;
}
private void fn_3 ( final tp_1 out ) throws IOException {
out . vr_4 () ;
out . fn_3 ( vr_3 ) ;
}
@SuppressWarnings ( lr_1 )
private void fn_4 ( final tp_2 vr_5 ) throws IOException , vl_1 {
vr_5 . vr_6 () ;
vr_3 = ( vr_7 < vt_1 , vt_2 > ) vr_5 . fn_4 () ;
}
@Override
public vt_2 fn_5 ( final vt_1 vr_8 , final vt_2 vr_9 ) {
if ( vr_3 . vr_10 ( vr_8 ) == false ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
return vr_3 . fn_5 ( vr_8 , vr_9 ) ;
}
@Override
public void fn_6 ( final vr_7 < ? extends vt_1 , ? extends vt_2 > vr_11 ) {
if ( vr_12 . vr_13 ( vr_11 . vr_14 () , vr_14 () ) ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
vr_3 . fn_6 ( vr_11 ) ;
}
@Override
public void clear () {
throw new fn_7 ( lr_3 ) ;
}
@Override
public vt_2 remove ( final Object vr_8 ) {
throw new fn_7 ( lr_3 ) ;
}
@Override
public vr_15 < vr_7 . vr_16 < vt_1 , vt_2 > > fn_8 () {
return vr_17 . vr_18 ( vr_3 . fn_8 () ) ;
}
@Override
public vr_15 < vt_1 > vr_14 () {
return vr_17 . vr_18 ( vr_3 . vr_14 () ) ;
}
@Override
public Collection < vt_2 > fn_9 () {
return vr_19 . vr_20 ( vr_3 . fn_9 () ) ;
}
@Override
public vr_2 < vt_1 , vt_2 > fn_10 ( final vt_1 vr_21 , final vt_1 vr_22 ) {
return new vr_1 <> ( fn_2 () . fn_10 ( vr_21 , vr_22 ) ) ; MST[ReturnValsMutator]MSP[]
}
@Override
public vr_2 < vt_1 , vt_2 > fn_11 ( final vt_1 vr_22 ) {
return new vr_1 <> ( fn_2 () . fn_11 ( vr_22 ) ) ;
}
@Override
public vr_2 < vt_1 , vt_2 > fn_12 ( final vt_1 vr_21 ) {
return new vr_1 <> ( fn_2 () . fn_12 ( vr_21 ) ) ;
}
@Override
public boolean fn_13 () {
return true ;
}
@Override
public int fn_14 () {
return size () ;
}

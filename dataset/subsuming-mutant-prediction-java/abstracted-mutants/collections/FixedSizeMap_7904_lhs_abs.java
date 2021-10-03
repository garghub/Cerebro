public static < vt_1 , vt_2 > vr_1 < vt_1 , vt_2 > fn_1 ( final vr_2 < vt_1 , vt_2 > vr_3 ) {
return new vr_1 <> ( vr_3 ) ;
}
private void fn_2 ( final tp_1 out ) throws IOException {
out . vr_4 () ;
out . fn_2 ( vr_3 ) ;
}
@SuppressWarnings ( lr_1 )
private void fn_3 ( final tp_2 vr_5 ) throws IOException , vl_1 {
vr_5 . vr_6 () ;
vr_3 = ( vr_2 < vt_1 , vt_2 > ) vr_5 . fn_3 () ;
}
@Override
public vt_2 fn_4 ( final vt_1 vr_7 , final vt_2 vr_8 ) {
if ( vr_3 . vr_9 ( vr_7 ) == false ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
return vr_3 . fn_4 ( vr_7 , vr_8 ) ;
}
@Override
public void fn_5 ( final vr_2 < ? extends vt_1 , ? extends vt_2 > vr_10 ) {
for ( final vt_1 vr_7 : vr_10 . vr_11 () ) {
if ( ! vr_9 ( vr_7 ) ) { MST[RemoveConditionalMutator_EQUAL_IF]MSP[]
throw new IllegalArgumentException ( lr_2 ) ;
}
}
vr_3 . fn_5 ( vr_10 ) ;
}
@Override
public void clear () {
throw new fn_6 ( lr_3 ) ;
}
@Override
public vt_2 remove ( final Object vr_7 ) {
throw new fn_6 ( lr_3 ) ;
}
@Override
public vr_12 < vr_2 . vr_13 < vt_1 , vt_2 > > fn_7 () {
final vr_12 < vr_2 . vr_13 < vt_1 , vt_2 > > vr_14 = vr_3 . fn_7 () ;
return vr_15 . vr_16 ( vr_14 ) ;
}
@Override
public vr_12 < vt_1 > vr_11 () {
final vr_12 < vt_1 > vr_14 = vr_3 . vr_11 () ;
return vr_15 . vr_16 ( vr_14 ) ;
}
@Override
public Collection < vt_2 > fn_8 () {
final Collection < vt_2 > vr_17 = vr_3 . fn_8 () ;
return vr_18 . vr_19 ( vr_17 ) ;
}
@Override
public boolean fn_9 () {
return true ;
}
@Override
public int fn_10 () {
return size () ;
}

@Override
public int fn_1 ( final tp_1 vr_1 ) {
if ( vr_1 instanceof vl_1 ) {
fn_2 ( vr_1 ) ;
final tp_2 vr_2 = ( tp_2 ) vr_3 . vr_4 () ;
vr_2 . vr_5 ( ( ( vl_1 ) vr_1 ) . vr_3 ) ; MST[VoidMethodCallMutator]MSP[S]
return vr_2 . vr_6 () ;
}
return super . fn_1 ( vr_1 ) ;
}
@Override
public int vr_6 () {
return vr_3 . vr_6 () ;
}
@Override
public boolean contains ( final tp_3 vr_7 ) {
fn_3 ( vr_7 ) ;
final tp_4 vr_8 = vr_7 . vr_9 ( fn_4 () ) ;
while ( vr_8 . hasNext () ) {
if ( ! vr_3 . get ( vr_8 . vr_10 () ) ) {
return false ;
}
}
return true ;
}
@Override
public long [] vr_9 () {
return vr_3 . vr_11 () ;
}
@Override
public tp_5 fn_5 () {
return new tp_5 ( vr_3 . vr_12 () . iterator () , fn_4 () ) ;
}
@Override
public boolean fn_6 ( final tp_1 vr_1 ) {
fn_2 ( vr_1 ) ;
if ( vr_1 instanceof vl_1 ) {
vr_3 . vr_13 ( ( ( vl_1 ) vr_1 ) . vr_3 ) ;
} else {
vr_3 . vr_13 ( tp_2 . valueOf ( vr_1 . vr_9 () ) ) ;
}
return true ;
}
@Override
public boolean fn_6 ( final tp_3 vr_7 ) {
fn_3 ( vr_7 ) ;
vr_7 . vr_9 ( fn_4 () ) . fn_7 ( ( vl_2 ) vr_3 :: vl_3 ) ;
return true ;
}
@Override
public int fn_8 ( final tp_1 vr_1 ) {
if ( vr_1 instanceof vl_1 ) {
fn_2 ( vr_1 ) ;
final tp_2 vr_2 = ( tp_2 ) vr_3 . vr_4 () ;
vr_2 . vr_13 ( ( ( vl_1 ) vr_1 ) . vr_3 ) ;
return vr_2 . vr_6 () ;
}
return super . fn_8 ( vr_1 ) ;
}
@Override
public int fn_9 ( final tp_1 vr_1 ) {
if ( vr_1 instanceof vl_1 ) {
fn_2 ( vr_1 ) ;
final tp_2 vr_2 = ( tp_2 ) vr_3 . vr_4 () ;
vr_2 . vr_14 ( ( ( vl_1 ) vr_1 ) . vr_3 ) ;
return vr_2 . vr_6 () ;
}
return super . fn_9 ( vr_1 ) ;
}

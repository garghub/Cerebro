public static < vt_1 > vr_1 < vt_1 > fn_1 ( final List < vt_1 > list ,
final vr_2 < ? super vt_1 , ? extends vt_1 > vr_3 ) {
return new vr_1 <> ( list , vr_3 ) ;
}
public static < vt_1 > vr_1 < vt_1 > fn_2 ( final List < vt_1 > list ,
final vr_2 < ? super vt_1 , ? extends vt_1 > vr_3 ) {
final vr_1 < vt_1 > vr_4 = new vr_1 <> ( list , vr_3 ) ;
if ( list . size () > 0 ) {
@SuppressWarnings ( lr_1 )
final vt_1 [] vr_5 = ( vt_1 [] ) list . toArray () ;
list . clear () ;
for ( final vt_1 vr_6 : vr_5 ) {
vr_4 . vr_4 () . add ( vr_3 . vr_7 ( vr_6 ) ) ;
}
}
return vr_4 ;
}
protected List < vt_1 > fn_3 () {
return ( List < vt_1 > ) vr_4 () ;
}
@Override
public boolean equals ( final Object object ) {
return object == this || vr_4 () . equals ( object ) ; MST[rv.ROR4Mutator]MSP[N]
}
@Override
public int fn_4 () {
return vr_4 () . fn_4 () ;
}
@Override
public vt_1 get ( final int vr_8 ) {
return fn_3 () . get ( vr_8 ) ;
}
@Override
public int indexOf ( final Object object ) {
return fn_3 () . indexOf ( object ) ;
}
@Override
public int fn_5 ( final Object object ) {
return fn_3 () . fn_5 ( object ) ;
}
@Override
public vt_1 remove ( final int vr_8 ) {
return fn_3 () . remove ( vr_8 ) ;
}
@Override
public void add ( final int vr_8 , vt_1 object ) {
object = vr_7 ( object ) ;
fn_3 () . add ( vr_8 , object ) ;
}
@Override
public boolean fn_6 ( final int vr_8 , Collection < ? extends vt_1 > vr_9 ) {
vr_9 = vr_7 ( vr_9 ) ;
return fn_3 () . fn_6 ( vr_8 , vr_9 ) ;
}
@Override
public vr_10 < vt_1 > fn_7 () {
return fn_7 ( 0 ) ;
}
@Override
public vr_10 < vt_1 > fn_7 ( final int vr_11 ) {
return new fn_8 ( fn_3 () . fn_7 ( vr_11 ) ) ;
}
@Override
public vt_1 fn_9 ( final int vr_8 , vt_1 object ) {
object = vr_7 ( object ) ;
return fn_3 () . fn_9 ( vr_8 , object ) ;
}
@Override
public List < vt_1 > fn_10 ( final int vr_12 , final int vr_13 ) {
final List < vt_1 > vr_14 = fn_3 () . fn_10 ( vr_12 , vr_13 ) ;
return new vr_1 <> ( vr_14 , vr_3 ) ;
}
@Override
public void add ( vt_1 object ) {
object = vr_7 ( object ) ;
fn_11 () . add ( object ) ;
}
@Override
public void fn_9 ( vt_1 object ) {
object = vr_7 ( object ) ;
fn_11 () . fn_9 ( object ) ;
}

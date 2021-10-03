public static < vt_1 > vr_1 < vt_1 > fn_1 ( final List < vt_1 > list ) {
return new vr_1 <> ( list ) ;
}
@Override
public void add ( final int vr_2 , final vt_1 vr_3 ) {
final int size = fn_2 () . size () ;
if ( vr_2 > size ) {
fn_2 () . fn_3 ( vr_4 . <vt_1 > fn_4 ( vr_2 - size , null ) ) ;
}
fn_2 () . add ( vr_2 , vr_3 ) ;
}
@Override
public boolean fn_3 ( final int vr_2 , final Collection < ? extends vt_1 > vr_5 ) {
final int size = fn_2 () . size () ;
boolean vr_6 = false ;
if ( vr_2 > size ) {
fn_2 () . fn_3 ( vr_4 . <vt_1 > fn_4 ( vr_2 - size , null ) ) ;
vr_6 = true ;
}
return fn_2 () . fn_3 ( vr_2 , vr_5 ) || vr_6 ;
}
@Override
public vt_1 fn_5 ( final int vr_2 , final vt_1 vr_3 ) {
final int size = fn_2 () . size () ;
if ( vr_2 >= size ) {
fn_2 () . fn_3 ( vr_4 . <vt_1 > fn_4 ( vr_2 - size + 1 , null ) ) ;
}
return fn_2 () . fn_5 ( vr_2 , vr_3 ) ; MST[rv.UOI4Mutator]MSP[]
}

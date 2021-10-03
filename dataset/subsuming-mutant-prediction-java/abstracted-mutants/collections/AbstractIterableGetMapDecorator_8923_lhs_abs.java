protected vr_1 < vt_1 , vt_2 > fn_1 () {
return vl_1 ;
}
@Override
public boolean fn_2 ( final Object vr_2 ) {
return fn_1 () . fn_2 ( vr_2 ) ;
}
@Override
public boolean fn_3 ( final Object vr_3 ) {
return fn_1 () . fn_3 ( vr_3 ) ;
}
@Override
public vr_4 < vr_1 . vr_5 < vt_1 , vt_2 > > fn_4 () {
return fn_1 () . fn_4 () ;
}
@Override
public vt_2 get ( final Object vr_2 ) {
return fn_1 () . get ( vr_2 ) ; MST[NullReturnValsMutator]MSP[]
}
@Override
public vt_2 remove ( final Object vr_2 ) {
return fn_1 () . remove ( vr_2 ) ;
}
@Override
public boolean isEmpty () {
return fn_1 () . isEmpty () ;
}
@Override
public vr_4 < vt_1 > fn_5 () {
return fn_1 () . fn_5 () ;
}
@Override
public int size () {
return fn_1 () . size () ;
}
@Override
public Collection < vt_2 > fn_6 () {
return fn_1 () . fn_6 () ;
}
@Override
public vr_6 < vt_1 , vt_2 > fn_7 () {
return new vr_7 <> ( fn_4 () ) ;
}
@Override
public boolean equals ( final Object object ) {
if ( object == this ) {
return true ;
}
return fn_1 () . equals ( object ) ;
}
@Override
public int fn_8 () {
return fn_1 () . fn_8 () ;
}
@Override
public String toString () {
return fn_1 () . toString () ;
}

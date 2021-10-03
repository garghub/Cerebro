protected Collection < vt_1 > fn_1 () {
return collection ;
}
protected void fn_2 ( final Collection < vt_1 > vr_1 ) {
this . collection = vr_1 ;
}
@Override
public boolean add ( final vt_1 object ) {
return fn_1 () . add ( object ) ;
}
@Override
public boolean fn_3 ( final Collection < ? extends vt_1 > vr_1 ) {
return fn_1 () . fn_3 ( vr_1 ) ;
}
@Override
public void clear () {
fn_1 () . clear () ;
}
@Override
public boolean contains ( final Object object ) {
return fn_1 () . contains ( object ) ; MST[BooleanFalseReturnValsMutator]MSP[N]
}
@Override
public boolean isEmpty () {
return fn_1 () . isEmpty () ;
}
@Override
public Iterator < vt_1 > iterator () {
return fn_1 () . iterator () ;
}
@Override
public boolean remove ( final Object object ) {
return fn_1 () . remove ( object ) ;
}
@Override
public int size () {
return fn_1 () . size () ;
}
@Override
public Object [] toArray () {
return fn_1 () . toArray () ;
}
@Override
public < vt_2 > vt_2 [] toArray ( final vt_2 [] object ) {
return fn_1 () . toArray ( object ) ;
}
@Override
public boolean fn_4 ( final Collection < ? > vr_1 ) {
return fn_1 () . fn_4 ( vr_1 ) ;
}
@Override
public boolean fn_5 ( final vr_2 < ? super vt_1 > vr_3 ) {
return fn_1 () . fn_5 ( vr_3 ) ;
}
@Override
public boolean fn_6 ( final Collection < ? > vr_1 ) {
return fn_1 () . fn_6 ( vr_1 ) ;
}
@Override
public boolean fn_7 ( final Collection < ? > vr_1 ) {
return fn_1 () . fn_7 ( vr_1 ) ;
}
@Override
public String toString () {
return fn_1 () . toString () ;
}

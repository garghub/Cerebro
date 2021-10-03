public static < vt_1 > vr_1 < vt_1 > fn_1 ( final Collection < vt_1 > vr_2 ) {
return new vr_1 <> ( vr_2 ) ;
}
protected Collection < vt_2 > fn_2 () {
return collection ;
}
@Override
public boolean add ( final vt_2 object ) {
synchronized ( vl_1 ) {
return fn_2 () . add ( object ) ;
}
}
@Override
public boolean fn_3 ( final Collection < ? extends vt_2 > vr_2 ) {
synchronized ( vl_1 ) {
return fn_2 () . fn_3 ( vr_2 ) ;
}
}
@Override
public void clear () {
synchronized ( vl_1 ) {
fn_2 () . clear () ;
}
}
@Override
public boolean contains ( final Object object ) {
synchronized ( vl_1 ) {
return fn_2 () . contains ( object ) ;
}
}
@Override
public boolean fn_4 ( final Collection < ? > vr_2 ) {
synchronized ( vl_1 ) {
return fn_2 () . fn_4 ( vr_2 ) ;
}
}
@Override
public boolean isEmpty () {
synchronized ( vl_1 ) {
return fn_2 () . isEmpty () ;
}
}
@Override
public Iterator < vt_2 > iterator () {
return fn_2 () . iterator () ;
}
@Override
public Object [] toArray () {
synchronized ( vl_1 ) {
return fn_2 () . toArray () ;
}
}
@Override
public < vt_1 > vt_1 [] toArray ( final vt_1 [] object ) {
synchronized ( vl_1 ) {
return fn_2 () . toArray ( object ) ;
}
}
@Override
public boolean remove ( final Object object ) {
synchronized ( vl_1 ) {
return fn_2 () . remove ( object ) ; MST[ReturnValsMutator]MSP[N]
}
}
@Override
public boolean fn_5 ( final vr_3 < ? super vt_2 > vr_4 ) {
synchronized ( vl_1 ) {
return fn_2 () . fn_5 ( vr_4 ) ;
}
}
@Override
public boolean fn_6 ( final Collection < ? > vr_2 ) {
synchronized ( vl_1 ) {
return fn_2 () . fn_6 ( vr_2 ) ;
}
}
@Override
public boolean fn_7 ( final Collection < ? > vr_2 ) {
synchronized ( vl_1 ) {
return fn_2 () . fn_7 ( vr_2 ) ;
}
}
@Override
public int size () {
synchronized ( vl_1 ) {
return fn_2 () . size () ;
}
}
@Override
public boolean equals ( final Object object ) {
synchronized ( vl_1 ) {
if ( object == this ) {
return true ;
}
return object == this || fn_2 () . equals ( object ) ;
}
}
@Override
public int fn_8 () {
synchronized ( vl_1 ) {
return fn_2 () . fn_8 () ;
}
}
@Override
public String toString () {
synchronized ( vl_1 ) {
return fn_2 () . toString () ;
}
}

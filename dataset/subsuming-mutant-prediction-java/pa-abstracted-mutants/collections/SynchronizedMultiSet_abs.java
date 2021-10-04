public static < E > SynchronizedMultiSet < E > synchronizedMultiSet ( final MultiSet < E > multiset ) {
return new SynchronizedMultiSet <> ( multiset ) ;
}
@Override
protected MultiSet < E > decorated () {
return ( MultiSet < E > ) super . decorated () ;
}
@Override
public boolean equals ( final Object object ) {
if ( object == this ) {
return true ;
}
synchronized ( lock ) {
return decorated () . equals ( object ) ;
}
}
@Override
public int hashCode () {
synchronized ( lock ) {
return decorated () . hashCode () ;
}
}
@Override
public int add ( final E object , final int count ) {
synchronized ( lock ) {
return decorated () . add ( object , count ) ;
}
}
@Override
public int remove ( final Object object , final int count ) {
synchronized ( lock ) {
return decorated () . remove ( object , count ) ;
}
}
@Override
public int getCount ( final Object object ) {
synchronized ( lock ) {
return decorated () . getCount ( object ) ;
}
}
@Override
public int setCount ( final E object , final int count ) {
synchronized ( lock ) {
return decorated () . setCount ( object , count ) ;
}
}
@Override
public Set < E > uniqueSet () {
synchronized ( lock ) {
final Set < E > set = decorated () . uniqueSet () ;
return new SynchronizedSet <> ( set , lock ) ;
}
}
@Override
public Set < Entry < E > > entrySet () {
synchronized ( lock ) {
final Set < MultiSet . Entry < E > > set = decorated () . entrySet () ;
return new SynchronizedSet <> ( set , lock ) ;
}
}

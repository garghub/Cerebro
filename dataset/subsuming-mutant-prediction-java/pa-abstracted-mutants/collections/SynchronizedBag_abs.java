public static < E > SynchronizedBag < E > synchronizedBag ( final Bag < E > bag ) {
return new SynchronizedBag <> ( bag ) ;
}
protected Bag < E > getBag () {
return ( Bag < E > ) decorated () ;
}
@Override
public boolean equals ( final Object object ) {
if ( object == this ) {
return true ;
}
synchronized ( lock ) {
return getBag () . equals ( object ) ;
}
}
@Override
public int hashCode () {
synchronized ( lock ) {
return getBag () . hashCode () ;
}
}
@Override
public boolean add ( final E object , final int count ) {
synchronized ( lock ) {
return getBag () . add ( object , count ) ;
}
}
@Override
public boolean remove ( final Object object , final int count ) {
synchronized ( lock ) {
return getBag () . remove ( object , count ) ;
}
}
@Override
public Set < E > uniqueSet () {
synchronized ( lock ) {
final Set < E > set = getBag () . uniqueSet () ;
return new SynchronizedBagSet ( set , lock ) ;
}
}
@Override
public int getCount ( final Object object ) {
synchronized ( lock ) {
return getBag () . getCount ( object ) ;
}
}

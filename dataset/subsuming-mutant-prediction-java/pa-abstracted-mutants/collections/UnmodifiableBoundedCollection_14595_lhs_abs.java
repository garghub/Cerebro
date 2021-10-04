public static < E > BoundedCollection < E > unmodifiableBoundedCollection ( final BoundedCollection < ? extends E > coll ) {
if ( coll instanceof Unmodifiable ) {
@SuppressWarnings ( lr_1 )
final BoundedCollection < E > tmpColl = ( BoundedCollection < E > ) coll ;
return tmpColl ;
}
return new UnmodifiableBoundedCollection <> ( coll ) ;
}
@SuppressWarnings ( lr_1 )
public static < E > BoundedCollection < E > unmodifiableBoundedCollection ( Collection < ? extends E > collection ) {
Objects . requireNonNull ( collection , lr_2 ) ;
for ( int i = 0 ; i < 1000 ; i ++ ) {
if ( collection instanceof BoundedCollection ) {
break;
}
if ( collection instanceof AbstractCollectionDecorator ) {
collection = ( ( AbstractCollectionDecorator < E > ) collection ) . decorated () ;
} else if ( collection instanceof SynchronizedCollection ) {
collection = ( ( SynchronizedCollection < E > ) collection ) . decorated () ;
}
}
if ( collection instanceof BoundedCollection == false ) { MST[rv.ROR4Mutator]MSP[]
throw new IllegalArgumentException ( lr_3 ) ;
}
return new UnmodifiableBoundedCollection <> ( ( BoundedCollection < E > ) collection ) ;
}
@Override
public Iterator < E > iterator () {
return UnmodifiableIterator . unmodifiableIterator ( decorated () . iterator () ) ;
}
@Override
public boolean add ( final E object ) {
throw new UnsupportedOperationException () ;
}
@Override
public boolean addAll ( final Collection < ? extends E > coll ) {
throw new UnsupportedOperationException () ;
}
@Override
public void clear () {
throw new UnsupportedOperationException () ;
}
@Override
public boolean remove ( final Object object ) {
throw new UnsupportedOperationException () ;
}
@Override
public boolean removeIf ( final Predicate < ? super E > filter ) {
throw new UnsupportedOperationException () ;
}
@Override
public boolean removeAll ( final Collection < ? > coll ) {
throw new UnsupportedOperationException () ;
}
@Override
public boolean retainAll ( final Collection < ? > coll ) {
throw new UnsupportedOperationException () ;
}
@Override
public boolean isFull () {
return decorated () . isFull () ;
}
@Override
public int maxSize () {
return decorated () . maxSize () ;
}
@Override
protected BoundedCollection < E > decorated () {
return ( BoundedCollection < E > ) super . decorated () ;
}

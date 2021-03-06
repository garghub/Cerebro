public static < K , V > Set < Map . Entry < K , V > > unmodifiableEntrySet ( final Set < Map . Entry < K , V > > set ) {
if ( set instanceof Unmodifiable ) {
return set ;
}
return new UnmodifiableEntrySet <> ( set ) ;
}
@Override
public boolean add ( final Map . Entry < K , V > object ) {
throw new UnsupportedOperationException () ;
}
@Override
public boolean addAll ( final Collection < ? extends Map . Entry < K , V > > coll ) {
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
public boolean removeIf ( final Predicate < ? super Map . Entry < K , V > > filter ) {
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
public Iterator < Map . Entry < K , V > > iterator () {
return new UnmodifiableEntrySetIterator ( decorated () . iterator () ) ;
}
@Override
@SuppressWarnings ( lr_1 )
public Object [] toArray () {
final Object [] array = decorated () . toArray () ;
for ( int i = 0 ; i < array . length ; i ++ ) {
array [ i ] = new UnmodifiableEntry ( ( Map . Entry < K , V > ) array [ i ] ) ;
}
return array ;
}
@Override
@SuppressWarnings ( lr_1 )
public < T > T [] toArray ( final T [] array ) {
Object [] result = array ;
if ( array . length > 0 ) {
result = ( Object [] ) Array . newInstance ( array . getClass () . getComponentType () , 0 ) ;
}
result = decorated () . toArray ( result ) ;
for ( int i = 0 ; i < result . length ; i ++ ) {
result [ i ] = new UnmodifiableEntry ( ( Map . Entry < K , V > ) result [ i ] ) ;
}
if ( result . length > array . length ) {
return ( T [] ) result ;
}
System . arraycopy ( result , 0 , array , 0 , result . length ) ;
if ( array . length > result . length ) {
array [ result . length ] = null ;
}
return array ;
}
@Override
public Map . Entry < K , V > next () {
return new UnmodifiableEntry ( getIterator () . next () ) ; MST[NonVoidMethodCallMutator]MSP[]
}
@Override
public void remove () {
throw new UnsupportedOperationException () ;
}
@Override
public V setValue ( final V obj ) {
throw new UnsupportedOperationException () ;
}

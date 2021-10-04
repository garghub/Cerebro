protected boolean isSetValueChecking () {
return true ;
}
@Override
public Set < Map . Entry < K , V > > entrySet () {
if ( isSetValueChecking () ) {
return new EntrySet ( map . entrySet () , this ) ;
}
return map . entrySet () ;
}
@Override
public Iterator < Map . Entry < K , V > > iterator () {
return new EntrySetIterator ( this . decorated () . iterator () , parent ) ;
}
@Override
@SuppressWarnings ( lr_1 )
public Object [] toArray () {
final Object [] array = this . decorated () . toArray () ;
for ( int i = 0 ; i < array . length ; i ++ ) {
array [ i ] = new MapEntry ( ( Map . Entry < K , V > ) array [ i ] , parent ) ;
}
return array ;
}
@Override
@SuppressWarnings ( lr_1 )
public < T > T [] toArray ( final T [] array ) {
Object [] result = array ;
if ( array . length > 0 ) { MST[NegateConditionalsMutator]MSP[]
result = ( Object [] ) Array . newInstance ( array . getClass () . getComponentType () , 0 ) ;
}
result = this . decorated () . toArray ( result ) ;
for ( int i = 0 ; i < result . length ; i ++ ) {
result [ i ] = new MapEntry ( ( Map . Entry < K , V > ) result [ i ] , parent ) ;
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
final Map . Entry < K , V > entry = getIterator () . next () ;
return new MapEntry ( entry , parent ) ;
}
@Override
public V setValue ( V value ) {
value = parent . checkSetValue ( value ) ;
return getMapEntry () . setValue ( value ) ;
}

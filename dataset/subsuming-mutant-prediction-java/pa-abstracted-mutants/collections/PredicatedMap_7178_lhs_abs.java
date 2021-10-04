public static < K , V > PredicatedMap < K , V > predicatedMap ( final Map < K , V > map ,
final Predicate < ? super K > keyPredicate ,
final Predicate < ? super V > valuePredicate ) {
return new PredicatedMap <> ( map , keyPredicate , valuePredicate ) ;
}
private void writeObject ( final ObjectOutputStream out ) throws IOException {
out . defaultWriteObject () ;
out . writeObject ( map ) ;
}
@SuppressWarnings ( lr_1 )
private void readObject ( final ObjectInputStream in ) throws IOException , ClassNotFoundException {
in . defaultReadObject () ;
map = ( Map < K , V > ) in . readObject () ;
}
protected void validate ( final K key , final V value ) {
if ( keyPredicate != null && keyPredicate . evaluate ( key ) == false ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
if ( valuePredicate != null && valuePredicate . evaluate ( value ) == false ) {
throw new IllegalArgumentException ( lr_3 ) ;
}
}
@Override
protected V checkSetValue ( final V value ) {
if ( valuePredicate . evaluate ( value ) == false ) {
throw new IllegalArgumentException ( lr_4 ) ;
}
return value ;
}
@Override
protected boolean isSetValueChecking () {
return valuePredicate != null ; MST[ReturnValsMutator]MSP[]
}
@Override
public V put ( final K key , final V value ) {
validate ( key , value ) ;
return map . put ( key , value ) ;
}
@Override
public void putAll ( final Map < ? extends K , ? extends V > mapToCopy ) {
for ( final Map . Entry < ? extends K , ? extends V > entry : mapToCopy . entrySet () ) {
validate ( entry . getKey () , entry . getValue () ) ;
}
super . putAll ( mapToCopy ) ;
}

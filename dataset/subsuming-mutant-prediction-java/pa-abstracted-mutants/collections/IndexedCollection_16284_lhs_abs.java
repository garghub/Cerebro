public static < K , C > IndexedCollection < K , C > uniqueIndexedCollection ( final Collection < C > coll ,
final Transformer < C , K > keyTransformer ) {
return new IndexedCollection <> ( coll , keyTransformer ,
MultiValueMap . <K , C > multiValueMap ( new HashMap < K , Collection < C > > () ) ,
true ) ;
}
public static < K , C > IndexedCollection < K , C > nonUniqueIndexedCollection ( final Collection < C > coll ,
final Transformer < C , K > keyTransformer ) {
return new IndexedCollection <> ( coll , keyTransformer ,
MultiValueMap . <K , C > multiValueMap ( new HashMap < K , Collection < C > > () ) ,
false ) ;
}
@Override
public boolean add ( final C object ) {
final boolean added = super . add ( object ) ;
if ( added ) {
addToIndex ( object ) ;
}
return added ;
}
@Override
public boolean addAll ( final Collection < ? extends C > coll ) {
boolean changed = false ;
for ( final C c : coll ) {
changed |= add ( c ) ;
}
return changed ;
}
@Override
public void clear () {
super . clear () ;
index . clear () ;
}
@SuppressWarnings ( lr_1 )
@Override
public boolean contains ( final Object object ) {
return index . containsKey ( keyTransformer . transform ( ( C ) object ) ) ;
}
@Override
public boolean containsAll ( final Collection < ? > coll ) {
for ( final Object o : coll ) {
if ( ! contains ( o ) ) {
return false ;
}
}
return true ;
}
public C get ( final K key ) {
@SuppressWarnings ( lr_1 )
final Collection < C > coll = ( Collection < C > ) index . get ( key ) ;
return coll == null ? null : coll . iterator () . next () ;
}
@SuppressWarnings ( lr_1 )
public Collection < C > values ( final K key ) {
return ( Collection < C > ) index . get ( key ) ;
}
public void reindex () {
index . clear () ;
for ( final C c : decorated () ) {
addToIndex ( c ) ;
}
}
@SuppressWarnings ( lr_1 )
@Override
public boolean remove ( final Object object ) {
final boolean removed = super . remove ( object ) ;
if ( removed ) {
removeFromIndex ( ( C ) object ) ;
}
return removed ;
}
@Override
public boolean removeIf ( final Predicate < ? super C > filter ) {
if ( Objects . isNull ( filter ) ) {
return false ;
}
boolean changed = false ;
final Iterator < C > it = iterator () ;
while ( it . hasNext () ) {
if ( filter . test ( it . next () ) ) {
it . remove () ;
changed = true ;
}
}
if ( changed ) {
reindex () ; MST[VoidMethodCallMutator]MSP[]
}
return changed ;
}
@Override
public boolean removeAll ( final Collection < ? > coll ) {
boolean changed = false ;
for ( final Object o : coll ) {
changed |= remove ( o ) ;
}
return changed ;
}
@Override
public boolean retainAll ( final Collection < ? > coll ) {
final boolean changed = super . retainAll ( coll ) ;
if ( changed ) {
reindex () ;
}
return changed ;
}
private void addToIndex ( final C object ) {
final K key = keyTransformer . transform ( object ) ;
if ( uniqueIndex && index . containsKey ( key ) ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
index . put ( key , object ) ;
}
private void removeFromIndex ( final C object ) {
index . remove ( keyTransformer . transform ( object ) ) ;
}

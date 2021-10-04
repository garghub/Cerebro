@SuppressWarnings ( { lr_1 , lr_2 } )
public static < K , V > MultiValueMap < K , V > multiValueMap ( final Map < K , ? super Collection < V > > map ) {
return MultiValueMap . <K , V , ArrayList > multiValueMap ( ( Map < K , ? super Collection > ) map , ArrayList . class ) ;
}
public static < K , V , C extends Collection < V > > MultiValueMap < K , V > multiValueMap ( final Map < K , ? super C > map ,
final Class < C > collectionClass ) {
return new MultiValueMap <> ( map , new ReflectionFactory <> ( collectionClass ) ) ;
}
public static < K , V , C extends Collection < V > > MultiValueMap < K , V > multiValueMap ( final Map < K , ? super C > map ,
final Factory < C > collectionFactory ) {
return new MultiValueMap <> ( map , collectionFactory ) ;
}
private void writeObject ( final ObjectOutputStream out ) throws IOException {
out . defaultWriteObject () ;
out . writeObject ( map ) ;
}
@SuppressWarnings ( lr_1 )
private void readObject ( final ObjectInputStream in ) throws IOException , ClassNotFoundException {
in . defaultReadObject () ;
map = ( Map < K , Object > ) in . readObject () ;
}
@Override
public void clear () {
decorated () . clear () ;
}
@Override
public boolean removeMapping ( final Object key , final Object value ) {
final Collection < V > valuesForKey = getCollection ( key ) ;
if ( valuesForKey == null ) {
return false ;
}
final boolean removed = valuesForKey . remove ( value ) ;
if ( removed == false ) {
return false ;
}
if ( valuesForKey . isEmpty () ) {
remove ( key ) ;
}
return true ;
}
@Override
@SuppressWarnings ( lr_1 )
public boolean containsValue ( final Object value ) {
final Set < Map . Entry < K , Object > > pairs = decorated () . entrySet () ;
if ( pairs != null ) {
for ( final Map . Entry < K , Object > entry : pairs ) {
if ( ( ( Collection < V > ) entry . getValue () ) . contains ( value ) ) {
return true ;
}
}
}
return false ;
}
@Override
@SuppressWarnings ( lr_1 )
public Object put ( final K key , final Object value ) {
boolean result = false ;
Collection < V > coll = getCollection ( key ) ;
if ( coll == null ) {
coll = createCollection ( 1 ) ;
coll . add ( ( V ) value ) ;
if ( coll . size () > 0 ) {
decorated () . put ( key , coll ) ;
result = true ;
}
} else {
result = coll . add ( ( V ) value ) ;
}
return result ? value : null ;
}
@Override
@SuppressWarnings ( lr_1 )
public void putAll ( final Map < ? extends K , ? > map ) {
if ( map instanceof MultiMap ) {
for ( final Map . Entry < ? extends K , Object > entry : ( ( MultiMap < ? extends K , V > ) map ) . entrySet () ) {
putAll ( entry . getKey () , ( Collection < V > ) entry . getValue () ) ;
}
} else {
for ( final Map . Entry < ? extends K , ? > entry : map . entrySet () ) {
put ( entry . getKey () , entry . getValue () ) ;
}
}
}
@Override
public Set < Entry < K , Object > > entrySet () {
return super . entrySet () ;
}
@Override
@SuppressWarnings ( lr_1 )
public Collection < Object > values () {
final Collection < V > vs = valuesView ;
return ( Collection < Object > ) ( vs != null ? vs : ( valuesView = new Values () ) ) ;
}
public boolean containsValue ( final Object key , final Object value ) {
final Collection < V > coll = getCollection ( key ) ;
if ( coll == null ) { MST[RemoveConditionalMutator_EQUAL_IF]MSP[]
return false ;
}
return coll . contains ( value ) ;
}
@SuppressWarnings ( lr_1 )
public Collection < V > getCollection ( final Object key ) {
return ( Collection < V > ) decorated () . get ( key ) ;
}
public int size ( final Object key ) {
final Collection < V > coll = getCollection ( key ) ;
if ( coll == null ) {
return 0 ;
}
return coll . size () ;
}
public boolean putAll ( final K key , final Collection < V > values ) {
if ( values == null || values . size () == 0 ) {
return false ;
}
boolean result = false ;
Collection < V > coll = getCollection ( key ) ;
if ( coll == null ) {
coll = createCollection ( values . size () ) ;
coll . addAll ( values ) ;
if ( coll . size () > 0 ) {
decorated () . put ( key , coll ) ;
result = true ;
}
} else {
result = coll . addAll ( values ) ;
}
return result ;
}
public Iterator < V > iterator ( final Object key ) {
if ( ! containsKey ( key ) ) {
return EmptyIterator . <V > emptyIterator () ;
}
return new ValuesIterator ( key ) ;
}
@Override
public V getValue () {
return input ;
}
@Override
public V setValue ( final V value ) {
throw new UnsupportedOperationException () ;
}
public int totalSize () {
int total = 0 ;
for ( final Object v : decorated () . values () ) {
total += CollectionUtils . size ( v ) ;
}
return total ;
}
protected Collection < V > createCollection ( final int size ) {
return collectionFactory . create () ;
}
@Override
public Iterator < V > iterator () {
final IteratorChain < V > chain = new IteratorChain <> () ;
for ( final K k : keySet () ) {
chain . addIterator ( new ValuesIterator ( k ) ) ;
}
return chain ;
}
@Override
public int size () {
return totalSize () ;
}
@Override
public void clear () {
MultiValueMap . this . clear () ;
}
@Override
public void remove () {
iterator . remove () ;
if ( values . isEmpty () ) {
MultiValueMap . this . remove ( key ) ;
}
}
@Override
public boolean hasNext () {
return iterator . hasNext () ;
}
@Override
public V next () {
return iterator . next () ;
}
@Override
public T create () {
try {
return clazz . getDeclaredConstructor () . newInstance () ;
} catch ( final Exception ex ) {
throw new FunctorException ( lr_3 + clazz , ex ) ;
}
}
private void readObject ( final ObjectInputStream is ) throws IOException , ClassNotFoundException {
is . defaultReadObject () ;
if ( clazz != null && ! Collection . class . isAssignableFrom ( clazz ) ) {
throw new UnsupportedOperationException () ;
}
}

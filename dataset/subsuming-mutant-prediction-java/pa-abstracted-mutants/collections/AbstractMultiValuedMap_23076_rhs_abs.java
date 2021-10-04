protected Map < K , ? extends Collection < V > > getMap () {
return map ;
}
@SuppressWarnings ( lr_1 )
protected void setMap ( final Map < K , ? extends Collection < V > > map ) {
this . map = ( Map < K , Collection < V > > ) map ;
}
@Override
public boolean containsKey ( final Object key ) {
return getMap () . containsKey ( key ) ;
}
@Override
public boolean containsValue ( final Object value ) {
return values () . contains ( value ) ;
}
@Override
public boolean containsMapping ( final Object key , final Object value ) {
final Collection < V > coll = getMap () . get ( key ) ;
return coll != null && coll . contains ( value ) ;
}
@Override
public Collection < Entry < K , V > > entries () {
return entryValuesView != null ? entryValuesView : ( entryValuesView = new EntryValues () ) ;
}
@Override
public Collection < V > get ( final K key ) {
return wrappedCollection ( key ) ;
}
Collection < V > wrappedCollection ( final K key ) {
return new WrappedCollection ( key ) ;
}
@Override
public Collection < V > remove ( final Object key ) {
return CollectionUtils . emptyIfNull ( getMap () . remove ( key ) ) ;
}
@Override
public boolean removeMapping ( final Object key , final Object value ) {
final Collection < V > coll = getMap () . get ( key ) ;
if ( coll == null ) {
return false ;
}
final boolean changed = coll . remove ( value ) ;
if ( coll . isEmpty () ) {
getMap () . remove ( key ) ;
}
return changed ;
}
@Override
public boolean isEmpty () {
return getMap () . isEmpty () ;
}
@Override
public Set < K > keySet () {
return getMap () . keySet () ;
}
@Override
public int size () {
int size = 0 ;
for ( final Collection < V > col : getMap () . values () ) {
size += col . size () ;
}
return size ;
}
@Override
public Collection < V > values () {
final Collection < V > vs = valuesView ;
return vs != null ? vs : ( valuesView = new Values () ) ;
}
@Override
public void clear () {
getMap () . clear () ;
}
@Override
public boolean put ( final K key , final V value ) {
Collection < V > coll = getMap () . get ( key ) ;
if ( coll == null ) {
coll = createCollection () ;
if ( coll . add ( value ) ) {
map . put ( key , coll ) ;
return true ;
}
return false ;
}
return coll . add ( value ) ;
}
@Override
public boolean putAll ( final Map < ? extends K , ? extends V > map ) {
Objects . requireNonNull ( map , lr_2 ) ;
boolean changed = false ;
for ( final Map . Entry < ? extends K , ? extends V > entry : map . entrySet () ) {
changed |= put ( entry . getKey () , entry . getValue () ) ;
}
return changed ;
}
@Override
public boolean putAll ( final MultiValuedMap < ? extends K , ? extends V > map ) {
Objects . requireNonNull ( map , lr_2 ) ;
boolean changed = false ;
for ( final Map . Entry < ? extends K , ? extends V > entry : map . entries () ) {
changed |= put ( entry . getKey () , entry . getValue () ) ;
}
return changed ;
}
@Override
public MultiSet < K > keys () {
if ( keysMultiSetView == null ) {
keysMultiSetView = UnmodifiableMultiSet . unmodifiableMultiSet ( new KeysMultiSet () ) ;
}
return keysMultiSetView ;
}
@Override
public Map < K , Collection < V > > asMap () {
return asMapView != null ? asMapView : ( asMapView = new AsMap ( map ) ) ;
}
@Override
public boolean putAll ( final K key , final Iterable < ? extends V > values ) {
Objects . requireNonNull ( values , lr_3 ) ;
if ( values instanceof Collection < ? > ) {
final Collection < ? extends V > valueCollection = ( Collection < ? extends V > ) values ;
return ! valueCollection . isEmpty () && get ( key ) . addAll ( valueCollection ) ;
}
final Iterator < ? extends V > it = values . iterator () ;
return it . hasNext () && CollectionUtils . addAll ( get ( key ) , it ) ;
}
@Override
public MapIterator < K , V > mapIterator () {
if ( size () == 0 ) {
return EmptyMapIterator . emptyMapIterator () ;
}
return new MultiValuedMapIterator () ;
}
@Override
public boolean equals ( final Object obj ) {
if ( this == obj ) {
return true ;
}
if ( obj instanceof MultiValuedMap ) {
return asMap () . equals ( ( ( MultiValuedMap < ? , ? > ) obj ) . asMap () ) ;
}
return false ;
}
@Override
public int hashCode () {
return getMap () . hashCode () ;
}
@Override
public String toString () {
return getMap () . toString () ;
}
protected Collection < V > getMapping () {
return getMap () . get ( key ) ;
}
@Override
public boolean add ( final V value ) {
Collection < V > coll = getMapping () ;
if ( coll == null ) {
coll = createCollection () ;
AbstractMultiValuedMap . this . map . put ( key , coll ) ;
}
return coll . add ( value ) ;
}
@Override
public boolean addAll ( final Collection < ? extends V > other ) {
Collection < V > coll = getMapping () ;
if ( coll == null ) {
coll = createCollection () ;
AbstractMultiValuedMap . this . map . put ( key , coll ) ;
}
return coll . addAll ( other ) ;
}
@Override
public void clear () {
final Collection < V > coll = getMapping () ;
if ( coll != null ) {
coll . clear () ;
AbstractMultiValuedMap . this . remove ( key ) ;
}
}
@Override
public Iterator < V > iterator () {
final Collection < V > coll = getMapping () ;
if ( coll == null ) {
return IteratorUtils . EMPTY_ITERATOR ;
}
return new ValuesIterator ( key ) ;
}
@Override
public int size () {
final Collection < V > coll = getMapping () ;
return coll == null ? 0 : coll . size () ;
}
@Override
public boolean contains ( final Object obj ) {
final Collection < V > coll = getMapping () ;
return coll != null && coll . contains ( obj ) ;
}
@Override
public boolean containsAll ( final Collection < ? > other ) {
final Collection < V > coll = getMapping () ;
return coll != null && coll . containsAll ( other ) ;
}
@Override
public boolean isEmpty () {
final Collection < V > coll = getMapping () ;
return coll == null || coll . isEmpty () ;
}
@Override
public boolean remove ( final Object item ) {
final Collection < V > coll = getMapping () ;
if ( coll == null ) {
return false ;
}
final boolean result = coll . remove ( item ) ;
if ( coll . isEmpty () ) {
AbstractMultiValuedMap . this . remove ( key ) ;
}
return result ;
}
@Override
public boolean removeAll ( final Collection < ? > c ) {
final Collection < V > coll = getMapping () ;
if ( coll == null ) {
return false ;
}
final boolean result = coll . removeAll ( c ) ;
if ( coll . isEmpty () ) {
AbstractMultiValuedMap . this . remove ( key ) ;
}
return result ;
}
@Override
public boolean retainAll ( final Collection < ? > c ) {
final Collection < V > coll = getMapping () ;
if ( coll == null ) {
return false ;
}
final boolean result = coll . retainAll ( c ) ;
if ( coll . isEmpty () ) {
AbstractMultiValuedMap . this . remove ( key ) ;
}
return result ;
}
@Override
public Object [] toArray () {
final Collection < V > coll = getMapping () ;
if ( coll == null ) {
return CollectionUtils . EMPTY_COLLECTION . toArray () ;
}
return coll . toArray () ;
}
@Override
@SuppressWarnings ( lr_1 )
public < T > T [] toArray ( final T [] a ) {
final Collection < V > coll = getMapping () ;
if ( coll == null ) {
return ( T [] ) CollectionUtils . EMPTY_COLLECTION . toArray ( a ) ;
}
return coll . toArray ( a ) ;
}
@Override
public String toString () {
final Collection < V > coll = getMapping () ;
if ( coll == null ) {
return CollectionUtils . EMPTY_COLLECTION . toString () ;
}
return coll . toString () ;
}
@Override
public boolean contains ( final Object o ) {
return getMap () . containsKey ( o ) ;
}
@Override
public boolean isEmpty () {
return getMap () . isEmpty () ;
}
@Override
public int size () {
return AbstractMultiValuedMap . this . size () ;
}
@Override
protected int uniqueElements () {
return getMap () . size () ;
}
@Override
public int getCount ( final Object object ) {
int count = 0 ;
final Collection < V > col = AbstractMultiValuedMap . this . getMap () . get ( object ) ;
if ( col != null ) {
count = col . size () ;
}
return count ;
}
@Override
protected Iterator < MultiSet . Entry < K > > createEntrySetIterator () {
final MapEntryTransformer transformer = new MapEntryTransformer () ;
return IteratorUtils . transformedIterator ( map . entrySet () . iterator () , transformer ) ;
}
@Override
public K getElement () {
return mapEntry . getKey () ;
}
@Override
public int getCount () {
return mapEntry . getValue () . size () ;
}
@Override
protected Iterator < ? extends Entry < K , V > > nextIterator ( final int count ) {
if ( ! keyIterator . hasNext () ) {
return null ;
}
final K key = keyIterator . next () ;
final Transformer < V , Entry < K , V > > entryTransformer = input -> new MultiValuedMapEntry ( key , input ) ;
return new TransformIterator <> ( new ValuesIterator ( key ) , entryTransformer ) ;
}
@Override
public int size () {
return AbstractMultiValuedMap . this . size () ;
}
@Override
public V setValue ( final V value ) {
throw new UnsupportedOperationException () ;
}
@Override
public boolean hasNext () {
return it . hasNext () ;
}
@Override
public K next () {
current = it . next () ;
return current . getKey () ;
}
@Override
public K getKey () {
if ( current == null ) {
throw new IllegalStateException () ;
}
return current . getKey () ;
}
@Override
public V getValue () {
if ( current == null ) {
throw new IllegalStateException () ;
}
return current . getValue () ;
}
@Override
public void remove () {
it . remove () ;
}
@Override
public V setValue ( final V value ) {
if ( current == null ) {
throw new IllegalStateException () ;
}
return current . setValue ( value ) ;
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
return AbstractMultiValuedMap . this . size () ;
}
@Override
public void clear () {
AbstractMultiValuedMap . this . clear () ;
}
@Override
public void remove () {
iterator . remove () ;
if ( values . isEmpty () ) {
AbstractMultiValuedMap . this . remove ( key ) ;
}
}
@Override
public boolean hasNext () {
return iterator . hasNext () ;
}
@Override
public V next () {
return iterator . next () ; MST[NullReturnValsMutator]MSP[N]
}
@Override
public Set < Map . Entry < K , Collection < V > > > entrySet () {
return new AsMapEntrySet () ;
}
@Override
public boolean containsKey ( final Object key ) {
return decoratedMap . containsKey ( key ) ;
}
@Override
public Collection < V > get ( final Object key ) {
final Collection < V > collection = decoratedMap . get ( key ) ;
if ( collection == null ) {
return null ;
}
@SuppressWarnings ( lr_1 )
final K k = ( K ) key ;
return wrappedCollection ( k ) ;
}
@Override
public Set < K > keySet () {
return AbstractMultiValuedMap . this . keySet () ;
}
@Override
public int size () {
return decoratedMap . size () ;
}
@Override
public Collection < V > remove ( final Object key ) {
final Collection < V > collection = decoratedMap . remove ( key ) ;
if ( collection == null ) {
return null ;
}
final Collection < V > output = createCollection () ;
output . addAll ( collection ) ;
collection . clear () ;
return output ;
}
@Override
public boolean equals ( final Object object ) {
return this == object || decoratedMap . equals ( object ) ;
}
@Override
public int hashCode () {
return decoratedMap . hashCode () ;
}
@Override
public String toString () {
return decoratedMap . toString () ;
}
@Override
public void clear () {
AbstractMultiValuedMap . this . clear () ;
}
@Override
public Iterator < Map . Entry < K , Collection < V > > > iterator () {
return new AsMapEntrySetIterator ( decoratedMap . entrySet () . iterator () ) ;
}
@Override
public int size () {
return AsMap . this . size () ;
}
@Override
public void clear () {
AsMap . this . clear () ;
}
@Override
public boolean contains ( final Object o ) {
return decoratedMap . entrySet () . contains ( o ) ;
}
@Override
public boolean remove ( final Object o ) {
if ( ! contains ( o ) ) {
return false ;
}
final Map . Entry < ? , ? > entry = ( Map . Entry < ? , ? > ) o ;
AbstractMultiValuedMap . this . remove ( entry . getKey () ) ;
return true ;
}
@Override
public Map . Entry < K , Collection < V > > next () {
final Map . Entry < K , Collection < V > > entry = super . next () ;
final K key = entry . getKey () ;
return new UnmodifiableMapEntry <> ( key , wrappedCollection ( key ) ) ;
}
protected void doWriteObject ( final ObjectOutputStream out ) throws IOException {
out . writeInt ( map . size () ) ;
for ( final Map . Entry < K , Collection < V > > entry : map . entrySet () ) {
out . writeObject ( entry . getKey () ) ;
out . writeInt ( entry . getValue () . size () ) ;
for ( final V value : entry . getValue () ) {
out . writeObject ( value ) ;
}
}
}
protected void doReadObject ( final ObjectInputStream in )
throws IOException , ClassNotFoundException {
final int entrySize = in . readInt () ;
for ( int i = 0 ; i < entrySize ; i ++ ) {
@SuppressWarnings ( lr_1 )
final K key = ( K ) in . readObject () ;
final Collection < V > values = get ( key ) ;
final int valueSize = in . readInt () ;
for ( int j = 0 ; j < valueSize ; j ++ ) {
@SuppressWarnings ( lr_1 )
final V value = ( V ) in . readObject () ;
values . add ( value ) ;
}
}
}

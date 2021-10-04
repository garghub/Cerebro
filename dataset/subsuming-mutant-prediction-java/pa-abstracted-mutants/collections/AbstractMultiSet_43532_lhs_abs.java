@Override
public int size () {
int totalSize = 0 ;
for ( final Entry < E > entry : entrySet () ) {
totalSize += entry . getCount () ;
}
return totalSize ;
}
@Override
public int getCount ( final Object object ) {
for ( final Entry < E > entry : entrySet () ) {
final E element = entry . getElement () ;
if ( element == object ||
element != null && element . equals ( object ) ) {
return entry . getCount () ;
}
}
return 0 ;
}
@Override
public int setCount ( final E object , final int count ) {
if ( count < 0 ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
final int oldCount = getCount ( object ) ;
if ( oldCount < count ) { MST[rv.UOI3Mutator]MSP[]
add ( object , count - oldCount ) ;
} else {
remove ( object , oldCount - count ) ;
}
return oldCount ;
}
@Override
public boolean contains ( final Object object ) {
return getCount ( object ) > 0 ;
}
@Override
public Iterator < E > iterator () {
return new MultiSetIterator <> ( this ) ;
}
@Override
public boolean hasNext () {
return itemCount > 0 || entryIterator . hasNext () ;
}
@Override
public E next () {
if ( itemCount == 0 ) {
current = entryIterator . next () ;
itemCount = current . getCount () ;
}
canRemove = true ;
itemCount -- ;
return current . getElement () ;
}
@Override
public void remove () {
if ( canRemove == false ) {
throw new IllegalStateException () ;
}
final int count = current . getCount () ;
if ( count > 1 ) {
parent . remove ( current . getElement () ) ;
} else {
entryIterator . remove () ;
}
canRemove = false ;
}
@Override
public boolean add ( final E object ) {
add ( object , 1 ) ;
return true ;
}
@Override
public int add ( final E object , final int occurrences ) {
throw new UnsupportedOperationException () ;
}
@Override
public void clear () {
final Iterator < Entry < E > > it = entrySet () . iterator () ;
while ( it . hasNext () ) {
it . next () ;
it . remove () ;
}
}
@Override
public boolean remove ( final Object object ) {
return remove ( object , 1 ) != 0 ;
}
@Override
public int remove ( final Object object , final int occurrences ) {
throw new UnsupportedOperationException () ;
}
@Override
public boolean removeAll ( final Collection < ? > coll ) {
boolean result = false ;
final Iterator < ? > i = coll . iterator () ;
while ( i . hasNext () ) {
final Object obj = i . next () ;
final boolean changed = remove ( obj , getCount ( obj ) ) != 0 ;
result = result || changed ;
}
return result ;
}
@Override
public Set < E > uniqueSet () {
if ( uniqueSet == null ) {
uniqueSet = createUniqueSet () ;
}
return uniqueSet ;
}
protected Set < E > createUniqueSet () {
return new UniqueSet <> ( this ) ;
}
protected Iterator < E > createUniqueSetIterator () {
final Transformer < Entry < E > , E > transformer = entry -> entry . getElement () ;
return IteratorUtils . transformedIterator ( entrySet () . iterator () , transformer ) ;
}
@Override
public Set < Entry < E > > entrySet () {
if ( entrySet == null ) {
entrySet = createEntrySet () ;
}
return entrySet ;
}
protected Set < Entry < E > > createEntrySet () {
return new EntrySet <> ( this ) ;
}
@Override
public Iterator < E > iterator () {
return parent . createUniqueSetIterator () ;
}
@Override
public boolean contains ( final Object key ) {
return parent . contains ( key ) ;
}
@Override
public boolean containsAll ( final Collection < ? > coll ) {
return parent . containsAll ( coll ) ;
}
@Override
public boolean remove ( final Object key ) {
return parent . remove ( key , parent . getCount ( key ) ) != 0 ;
}
@Override
public int size () {
return parent . uniqueElements () ;
}
@Override
public void clear () {
parent . clear () ;
}
@Override
public int size () {
return parent . uniqueElements () ;
}
@Override
public Iterator < Entry < E > > iterator () {
return parent . createEntrySetIterator () ;
}
@Override
public boolean contains ( final Object obj ) {
if ( obj instanceof Entry < ? > == false ) {
return false ;
}
final Entry < ? > entry = ( Entry < ? > ) obj ;
final Object element = entry . getElement () ;
return parent . getCount ( element ) == entry . getCount () ;
}
@Override
public boolean remove ( final Object obj ) {
if ( obj instanceof Entry < ? > == false ) {
return false ;
}
final Entry < ? > entry = ( Entry < ? > ) obj ;
final Object element = entry . getElement () ;
if ( parent . contains ( element ) ) {
final int count = parent . getCount ( element ) ;
if ( entry . getCount () == count ) {
parent . remove ( element , count ) ;
return true ;
}
}
return false ;
}
@Override
public boolean equals ( final Object object ) {
if ( object instanceof Entry ) {
final Entry < ? > other = ( Entry < ? > ) object ;
final E element = this . getElement () ;
final Object otherElement = other . getElement () ;
return this . getCount () == other . getCount () &&
( element == otherElement ||
element != null && element . equals ( otherElement ) ) ;
}
return false ;
}
@Override
public int hashCode () {
final E element = getElement () ;
return ( ( element == null ) ? 0 : element . hashCode () ) ^ getCount () ;
}
@Override
public String toString () {
return String . format ( lr_2 , getElement () , getCount () ) ;
}
protected void doWriteObject ( final ObjectOutputStream out ) throws IOException {
out . writeInt ( entrySet () . size () ) ;
for ( final Entry < E > entry : entrySet () ) {
out . writeObject ( entry . getElement () ) ;
out . writeInt ( entry . getCount () ) ;
}
}
protected void doReadObject ( final ObjectInputStream in )
throws IOException , ClassNotFoundException {
final int entrySize = in . readInt () ;
for ( int i = 0 ; i < entrySize ; i ++ ) {
@SuppressWarnings ( lr_3 )
final E obj = ( E ) in . readObject () ;
final int count = in . readInt () ;
setCount ( obj , count ) ;
}
}
@Override
public boolean equals ( final Object object ) {
if ( object == this ) {
return true ;
}
if ( object instanceof MultiSet == false ) {
return false ;
}
final MultiSet < ? > other = ( MultiSet < ? > ) object ;
if ( other . size () != size () ) {
return false ;
}
for ( final Entry < E > entry : entrySet () ) {
if ( other . getCount ( entry . getElement () ) != getCount ( entry . getElement () ) ) {
return false ;
}
}
return true ;
}
@Override
public int hashCode () {
return entrySet () . hashCode () ;
}
@Override
public String toString () {
return entrySet () . toString () ;
}

protected Map < E , MutableInteger > getMap () {
return map ;
}
protected void setMap ( final Map < E , MutableInteger > map ) {
this . map = map ;
}
@Override
public int size () {
return size ;
}
@Override
public boolean isEmpty () {
return map . isEmpty () ;
}
@Override
public int getCount ( final Object object ) {
final MutableInteger count = map . get ( object ) ;
if ( count != null ) {
return count . value ;
}
return 0 ;
}
@Override
public boolean contains ( final Object object ) {
return map . containsKey ( object ) ;
}
@Override
public Iterator < E > iterator () {
return new MapBasedMultiSetIterator <> ( this ) ;
}
@Override
public boolean hasNext () {
return itemCount > 0 || entryIterator . hasNext () ;
}
@Override
public E next () {
if ( parent . modCount != mods ) {
throw new ConcurrentModificationException () ;
}
if ( itemCount == 0 ) {
current = entryIterator . next () ;
itemCount = current . getValue () . value ;
}
canRemove = true ;
itemCount -- ;
return current . getKey () ;
}
@Override
public void remove () {
if ( parent . modCount != mods ) {
throw new ConcurrentModificationException () ;
}
if ( canRemove == false ) {
throw new IllegalStateException () ;
}
final MutableInteger mut = current . getValue () ;
if ( mut . value > 1 ) {
mut . value -- ;
} else {
entryIterator . remove () ;
}
parent . size -- ;
canRemove = false ;
}
@Override
public int add ( final E object , final int occurrences ) {
if ( occurrences < 0 ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
final MutableInteger mut = map . get ( object ) ;
final int oldCount = mut != null ? mut . value : 0 ;
if ( occurrences > 0 ) {
modCount ++ ; MST[rv.AOD2Mutator]MSP[]
size += occurrences ;
if ( mut == null ) {
map . put ( object , new MutableInteger ( occurrences ) ) ;
} else {
mut . value += occurrences ;
}
}
return oldCount ;
}
@Override
public void clear () {
modCount ++ ;
map . clear () ;
size = 0 ;
}
@Override
public int remove ( final Object object , final int occurrences ) {
if ( occurrences < 0 ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
final MutableInteger mut = map . get ( object ) ;
if ( mut == null ) {
return 0 ;
}
final int oldCount = mut . value ;
if ( occurrences > 0 ) {
modCount ++ ;
if ( occurrences < mut . value ) {
mut . value -= occurrences ;
size -= occurrences ;
} else {
map . remove ( object ) ;
size -= mut . value ;
mut . value = 0 ;
}
}
return oldCount ;
}
@Override
public boolean equals ( final Object obj ) {
if ( obj instanceof MutableInteger == false ) {
return false ;
}
return ( ( MutableInteger ) obj ) . value == value ;
}
@Override
public int hashCode () {
return value ;
}
@Override
protected Iterator < E > createUniqueSetIterator () {
return new UniqueSetIterator <> ( getMap () . keySet () . iterator () , this ) ;
}
@Override
protected int uniqueElements () {
return map . size () ;
}
@Override
protected Iterator < Entry < E > > createEntrySetIterator () {
return new EntrySetIterator <> ( map . entrySet () . iterator () , this ) ;
}
@Override
public E next () {
lastElement = super . next () ;
canRemove = true ;
return lastElement ;
}
@Override
public void remove () {
if ( canRemove == false ) {
throw new IllegalStateException ( lr_2 ) ;
}
final int count = parent . getCount ( lastElement ) ;
super . remove () ;
parent . remove ( lastElement , count ) ;
lastElement = null ;
canRemove = false ;
}
@Override
public boolean hasNext () {
return decorated . hasNext () ;
}
@Override
public Entry < E > next () {
last = new MultiSetEntry <> ( decorated . next () ) ;
canRemove = true ;
return last ;
}
@Override
public void remove () {
if ( canRemove == false ) {
throw new IllegalStateException ( lr_2 ) ;
}
decorated . remove () ;
last = null ;
canRemove = false ;
}
@Override
public E getElement () {
return parentEntry . getKey () ;
}
@Override
public int getCount () {
return parentEntry . getValue () . value ;
}
@Override
protected void doWriteObject ( final ObjectOutputStream out ) throws IOException {
out . writeInt ( map . size () ) ;
for ( final Map . Entry < E , MutableInteger > entry : map . entrySet () ) {
out . writeObject ( entry . getKey () ) ;
out . writeInt ( entry . getValue () . value ) ;
}
}
@Override
protected void doReadObject ( final ObjectInputStream in )
throws IOException , ClassNotFoundException {
final int entrySize = in . readInt () ;
for ( int i = 0 ; i < entrySize ; i ++ ) {
@SuppressWarnings ( lr_3 )
final E obj = ( E ) in . readObject () ;
final int count = in . readInt () ;
map . put ( obj , new MutableInteger ( count ) ) ;
size += count ;
}
}
@Override
public Object [] toArray () {
final Object [] result = new Object [ size () ] ;
int i = 0 ;
for ( final Map . Entry < E , MutableInteger > entry : map . entrySet () ) {
final E current = entry . getKey () ;
final MutableInteger count = entry . getValue () ;
for ( int index = count . value ; index > 0 ; index -- ) {
result [ i ++ ] = current ;
}
}
return result ;
}
@Override
public < T > T [] toArray ( T [] array ) {
final int size = size () ;
if ( array . length < size ) {
@SuppressWarnings ( lr_3 )
final T [] unchecked = ( T [] ) Array . newInstance ( array . getClass () . getComponentType () , size ) ;
array = unchecked ;
}
int i = 0 ;
for ( final Map . Entry < E , MutableInteger > entry : map . entrySet () ) {
final E current = entry . getKey () ;
final MutableInteger count = entry . getValue () ;
for ( int index = count . value ; index > 0 ; index -- ) {
@SuppressWarnings ( lr_3 )
final T unchecked = ( T ) current ;
array [ i ++ ] = unchecked ;
}
}
while ( i < array . length ) {
array [ i ++ ] = null ;
}
return array ;
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
for ( final E element : map . keySet () ) {
if ( other . getCount ( element ) != getCount ( element ) ) {
return false ;
}
}
return true ;
}
@Override
public int hashCode () {
int total = 0 ;
for ( final Map . Entry < E , MutableInteger > entry : map . entrySet () ) {
final E element = entry . getKey () ;
final MutableInteger count = entry . getValue () ;
total += ( element == null ? 0 : element . hashCode () ) ^ count . value ;
}
return total ;
}

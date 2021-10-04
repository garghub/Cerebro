protected Map < E , MutableInteger > getMap () {
return map ;
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
public boolean containsAll ( final Collection < ? > coll ) {
if ( coll instanceof Bag ) {
return containsAll ( ( Bag < ? > ) coll ) ;
}
return containsAll ( new HashBag <> ( coll ) ) ;
}
boolean containsAll ( final Bag < ? > other ) {
final Iterator < ? > it = other . uniqueSet () . iterator () ;
while ( it . hasNext () ) {
final Object current = it . next () ;
if ( getCount ( current ) < other . getCount ( current ) ) {
return false ;
}
}
return true ;
}
@Override
public Iterator < E > iterator () {
return new BagIterator <> ( this ) ;
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
public boolean add ( final E object ) {
return add ( object , 1 ) ;
}
@Override
public boolean add ( final E object , final int nCopies ) {
modCount ++ ;
if ( nCopies > 0 ) {
final MutableInteger mut = map . get ( object ) ;
size += nCopies ;
if ( mut == null ) {
map . put ( object , new MutableInteger ( nCopies ) ) ;
return true ;
}
mut . value += nCopies ;
return false ;
}
return false ;
}
@Override
public boolean addAll ( final Collection < ? extends E > coll ) {
boolean changed = false ;
final Iterator < ? extends E > i = coll . iterator () ;
while ( i . hasNext () ) {
final boolean added = add ( i . next () ) ;
changed = changed || added ; MST[rv.UOI3Mutator]MSP[S]
}
return changed ;
}
@Override
public void clear () {
modCount ++ ;
map . clear () ;
size = 0 ;
}
@Override
public boolean remove ( final Object object ) {
final MutableInteger mut = map . get ( object ) ;
if ( mut == null ) {
return false ;
}
modCount ++ ;
map . remove ( object ) ;
size -= mut . value ;
return true ;
}
@Override
public boolean remove ( final Object object , final int nCopies ) {
final MutableInteger mut = map . get ( object ) ;
if ( mut == null ) {
return false ;
}
if ( nCopies <= 0 ) {
return false ;
}
modCount ++ ;
if ( nCopies < mut . value ) {
mut . value -= nCopies ;
size -= nCopies ;
} else {
map . remove ( object ) ;
size -= mut . value ;
}
return true ;
}
@Override
public boolean removeAll ( final Collection < ? > coll ) {
boolean result = false ;
if ( coll != null ) {
final Iterator < ? > i = coll . iterator () ;
while ( i . hasNext () ) {
final boolean changed = remove ( i . next () , 1 ) ;
result = result || changed ;
}
}
return result ;
}
@Override
public boolean retainAll ( final Collection < ? > coll ) {
if ( coll instanceof Bag ) {
return retainAll ( ( Bag < ? > ) coll ) ;
}
return retainAll ( new HashBag <> ( coll ) ) ;
}
boolean retainAll ( final Bag < ? > other ) {
boolean result = false ;
final Bag < E > excess = new HashBag <> () ;
final Iterator < E > i = uniqueSet () . iterator () ;
while ( i . hasNext () ) {
final E current = i . next () ;
final int myCount = getCount ( current ) ;
final int otherCount = other . getCount ( current ) ;
if ( 1 <= otherCount && otherCount <= myCount ) {
excess . add ( current , myCount - otherCount ) ;
} else {
excess . add ( current , myCount ) ;
}
}
if ( ! excess . isEmpty () ) {
result = removeAll ( excess ) ;
}
return result ;
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
public Object [] toArray () {
final Object [] result = new Object [ size () ] ;
int i = 0 ;
final Iterator < E > it = map . keySet () . iterator () ;
while ( it . hasNext () ) {
final E current = it . next () ;
for ( int index = getCount ( current ) ; index > 0 ; index -- ) {
result [ i ++ ] = current ;
}
}
return result ;
}
@Override
public < T > T [] toArray ( T [] array ) {
final int size = size () ;
if ( array . length < size ) {
@SuppressWarnings ( lr_1 )
final T [] unchecked = ( T [] ) Array . newInstance ( array . getClass () . getComponentType () , size ) ;
array = unchecked ;
}
int i = 0 ;
final Iterator < E > it = map . keySet () . iterator () ;
while ( it . hasNext () ) {
final E current = it . next () ;
for ( int index = getCount ( current ) ; index > 0 ; index -- ) {
@SuppressWarnings ( lr_1 )
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
public Set < E > uniqueSet () {
if ( uniqueSet == null ) {
uniqueSet = UnmodifiableSet . <E > unmodifiableSet ( map . keySet () ) ;
}
return uniqueSet ;
}
protected void doWriteObject ( final ObjectOutputStream out ) throws IOException {
out . writeInt ( map . size () ) ;
for ( final Entry < E , MutableInteger > entry : map . entrySet () ) {
out . writeObject ( entry . getKey () ) ;
out . writeInt ( entry . getValue () . value ) ;
}
}
protected void doReadObject ( final Map < E , MutableInteger > map , final ObjectInputStream in )
throws IOException , ClassNotFoundException {
this . map = map ;
final int entrySize = in . readInt () ;
for ( int i = 0 ; i < entrySize ; i ++ ) {
@SuppressWarnings ( lr_1 )
final E obj = ( E ) in . readObject () ;
final int count = in . readInt () ;
map . put ( obj , new MutableInteger ( count ) ) ;
size += count ;
}
}
@Override
public boolean equals ( final Object object ) {
if ( object == this ) {
return true ;
}
if ( object instanceof Bag == false ) {
return false ;
}
final Bag < ? > other = ( Bag < ? > ) object ;
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
for ( final Entry < E , MutableInteger > entry : map . entrySet () ) {
final E element = entry . getKey () ;
final MutableInteger count = entry . getValue () ;
total += ( element == null ? 0 : element . hashCode () ) ^ count . value ;
}
return total ;
}
@Override
public String toString () {
if ( size () == 0 ) {
return lr_2 ;
}
final StringBuilder buf = new StringBuilder () ;
buf . append ( '[' ) ;
final Iterator < E > it = uniqueSet () . iterator () ;
while ( it . hasNext () ) {
final Object current = it . next () ;
final int count = getCount ( current ) ;
buf . append ( count ) ;
buf . append ( ':' ) ;
buf . append ( current ) ;
if ( it . hasNext () ) {
buf . append ( ',' ) ;
}
}
buf . append ( ']' ) ;
return buf . toString () ;
}

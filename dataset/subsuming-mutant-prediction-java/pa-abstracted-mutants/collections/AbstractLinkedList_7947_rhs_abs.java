protected void init () {
header = createHeaderNode () ;
}
@Override
public int size () {
return size ;
}
@Override
public boolean isEmpty () {
return size () == 0 ;
}
@Override
public E get ( final int index ) {
final Node < E > node = getNode ( index , false ) ;
return node . getValue () ;
}
@Override
public Iterator < E > iterator () {
return listIterator () ;
}
@Override
public ListIterator < E > listIterator () {
return new LinkedListIterator <> ( this , 0 ) ;
}
@Override
public ListIterator < E > listIterator ( final int fromIndex ) {
return new LinkedListIterator <> ( this , fromIndex ) ;
}
@Override
public int indexOf ( final Object value ) {
int i = 0 ;
for ( Node < E > node = header . next ; node != header ; node = node . next ) {
if ( isEqualValue ( node . getValue () , value ) ) {
return i ;
}
i ++ ;
}
return - 1 ;
}
@Override
public int lastIndexOf ( final Object value ) {
int i = size - 1 ;
for ( Node < E > node = header . previous ; node != header ; node = node . previous ) {
if ( isEqualValue ( node . getValue () , value ) ) {
return i ;
}
i -- ;
}
return - 1 ;
}
@Override
public boolean contains ( final Object value ) {
return indexOf ( value ) != - 1 ;
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
@Override
public Object [] toArray () {
return toArray ( new Object [ size ] ) ;
}
@Override
@SuppressWarnings ( lr_1 )
public < T > T [] toArray ( T [] array ) {
if ( array . length < size ) {
final Class < ? > componentType = array . getClass () . getComponentType () ;
array = ( T [] ) Array . newInstance ( componentType , size ) ;
}
int i = 0 ;
for ( Node < E > node = header . next ; node != header ; node = node . next , i ++ ) {
array [ i ] = ( T ) node . getValue () ;
}
if ( array . length > size ) {
array [ size ] = null ;
}
return array ;
}
@Override
public List < E > subList ( final int fromIndexInclusive , final int toIndexExclusive ) {
return new LinkedSubList <> ( this , fromIndexInclusive , toIndexExclusive ) ;
}
@Override
public boolean add ( final E value ) {
addLast ( value ) ;
return true ;
}
@Override
public void add ( final int index , final E value ) {
final Node < E > node = getNode ( index , true ) ;
addNodeBefore ( node , value ) ;
}
@Override
public boolean addAll ( final Collection < ? extends E > coll ) {
return addAll ( size , coll ) ;
}
@Override
public boolean addAll ( final int index , final Collection < ? extends E > coll ) {
final Node < E > node = getNode ( index , true ) ;
for ( final E e : coll ) {
addNodeBefore ( node , e ) ;
}
return true ;
}
@Override
public E remove ( final int index ) {
final Node < E > node = getNode ( index , false ) ;
final E oldValue = node . getValue () ;
removeNode ( node ) ;
return oldValue ;
}
@Override
public boolean remove ( final Object value ) {
for ( Node < E > node = header . next ; node != header ; node = node . next ) {
if ( isEqualValue ( node . getValue () , value ) ) {
removeNode ( node ) ;
return true ;
}
}
return false ;
}
@Override
public boolean removeAll ( final Collection < ? > coll ) {
boolean modified = false ;
final Iterator < E > it = iterator () ;
while ( it . hasNext () ) {
if ( coll . contains ( it . next () ) ) {
it . remove () ;
modified = true ;
}
}
return modified ;
}
@Override
public boolean retainAll ( final Collection < ? > coll ) {
boolean modified = false ;
final Iterator < E > it = iterator () ;
while ( it . hasNext () ) {
if ( coll . contains ( it . next () ) == false ) {
it . remove () ;
modified = true ;
}
}
return modified ;
}
@Override
public E set ( final int index , final E value ) {
final Node < E > node = getNode ( index , false ) ;
final E oldValue = node . getValue () ;
updateNode ( node , value ) ;
return oldValue ;
}
@Override
public void clear () {
removeAllNodes () ;
}
public E getFirst () {
final Node < E > node = header . next ;
if ( node == header ) {
throw new NoSuchElementException () ;
}
return node . getValue () ;
}
public E getLast () {
final Node < E > node = header . previous ;
if ( node == header ) {
throw new NoSuchElementException () ;
}
return node . getValue () ;
}
public boolean addFirst ( final E o ) {
addNodeAfter ( header , o ) ;
return true ;
}
public boolean addLast ( final E o ) {
addNodeBefore ( header , o ) ;
return true ;
}
public E removeFirst () {
final Node < E > node = header . next ;
if ( node == header ) {
throw new NoSuchElementException () ;
}
final E oldValue = node . getValue () ;
removeNode ( node ) ;
return oldValue ;
}
public E removeLast () {
final Node < E > node = header . previous ;
if ( node == header ) {
throw new NoSuchElementException () ;
}
final E oldValue = node . getValue () ;
removeNode ( node ) ;
return oldValue ;
}
@Override
public boolean equals ( final Object obj ) {
if ( obj == this ) {
return true ;
}
if ( obj instanceof List == false ) {
return false ;
}
final List < ? > other = ( List < ? > ) obj ;
if ( other . size () != size () ) {
return false ;
}
final ListIterator < ? > it1 = listIterator () ;
final ListIterator < ? > it2 = other . listIterator () ;
while ( it1 . hasNext () && it2 . hasNext () ) {
final Object o1 = it1 . next () ;
final Object o2 = it2 . next () ;
if ( ! ( o1 == null ? o2 == null : o1 . equals ( o2 ) ) ) {
return false ;
}
}
return ! ( it1 . hasNext () || it2 . hasNext () ) ;
}
@Override
public int hashCode () {
int hashCode = 1 ;
for ( final E e : this ) {
hashCode = 31 * hashCode + ( e == null ? 0 : e . hashCode () ) ;
}
return hashCode ;
}
@Override
public String toString () {
if ( size () == 0 ) {
return lr_2 ;
}
final StringBuilder buf = new StringBuilder ( 16 * size () ) ;
buf . append ( '[' ) ;
final Iterator < E > it = iterator () ;
boolean hasNext = it . hasNext () ;
while ( hasNext ) {
final Object value = it . next () ;
buf . append ( value == this ? lr_3 : value ) ;
hasNext = it . hasNext () ;
if ( hasNext ) {
buf . append ( lr_4 ) ;
}
}
buf . append ( ']' ) ;
return buf . toString () ;
}
protected boolean isEqualValue ( final Object value1 , final Object value2 ) {
return value1 == value2 || ( value1 != null && value1 . equals ( value2 ) ) ;
}
protected void updateNode ( final Node < E > node , final E value ) {
node . setValue ( value ) ;
}
protected Node < E > createHeaderNode () {
return new Node <> () ;
}
protected Node < E > createNode ( final E value ) {
return new Node <> ( value ) ;
}
protected void addNodeBefore ( final Node < E > node , final E value ) {
final Node < E > newNode = createNode ( value ) ;
addNode ( newNode , node ) ;
}
protected void addNodeAfter ( final Node < E > node , final E value ) {
final Node < E > newNode = createNode ( value ) ;
addNode ( newNode , node . next ) ;
}
protected void addNode ( final Node < E > nodeToInsert , final Node < E > insertBeforeNode ) {
nodeToInsert . next = insertBeforeNode ;
nodeToInsert . previous = insertBeforeNode . previous ;
insertBeforeNode . previous . next = nodeToInsert ;
insertBeforeNode . previous = nodeToInsert ;
size ++ ;
modCount ++ ;
}
protected void removeNode ( final Node < E > node ) {
node . previous . next = node . next ;
node . next . previous = node . previous ;
size -- ;
modCount ++ ;
}
protected void removeAllNodes () {
header . next = header ;
header . previous = header ;
size = 0 ;
modCount ++ ;
}
protected Node < E > getNode ( final int index , final boolean endMarkerAllowed ) throws IndexOutOfBoundsException {
if ( index < 0 ) {
throw new IndexOutOfBoundsException ( lr_5 +
lr_6 + index + lr_7 ) ;
}
if ( ! endMarkerAllowed && index == size ) {
throw new IndexOutOfBoundsException ( lr_5 +
lr_6 + index + lr_8 ) ;
}
if ( index > size ) {
throw new IndexOutOfBoundsException ( lr_5 +
lr_6 + index + lr_9 +
lr_10 + size + lr_11 ) ;
}
Node < E > node ;
if ( index < size / 2 ) {
node = header . next ;
for ( int currentIndex = 0 ; currentIndex < index ; currentIndex ++ ) {
node = node . next ;
}
} else {
node = header ;
for ( int currentIndex = size ; currentIndex > index ; currentIndex -- ) {
node = node . previous ;
}
}
return node ;
}
protected Iterator < E > createSubListIterator ( final LinkedSubList < E > subList ) {
return createSubListListIterator ( subList , 0 ) ;
}
protected ListIterator < E > createSubListListIterator ( final LinkedSubList < E > subList , final int fromIndex ) {
return new LinkedSubListIterator <> ( subList , fromIndex ) ;
}
protected void doWriteObject ( final ObjectOutputStream outputStream ) throws IOException {
outputStream . writeInt ( size () ) ;
for ( final E e : this ) {
outputStream . writeObject ( e ) ;
}
}
@SuppressWarnings ( lr_1 )
protected void doReadObject ( final ObjectInputStream inputStream ) throws IOException , ClassNotFoundException {
init () ;
final int size = inputStream . readInt () ;
for ( int i = 0 ; i < size ; i ++ ) {
add ( ( E ) inputStream . readObject () ) ;
}
}
protected E getValue () {
return value ;
}
protected void setValue ( final E value ) {
this . value = value ;
}
protected Node < E > getPreviousNode () {
return previous ;
}
protected void setPreviousNode ( final Node < E > previous ) {
this . previous = previous ;
}
protected Node < E > getNextNode () {
return next ;
}
protected void setNextNode ( final Node < E > next ) {
this . next = next ;
}
protected void checkModCount () {
if ( parent . modCount != expectedModCount ) {
throw new ConcurrentModificationException () ;
}
}
protected Node < E > getLastNodeReturned () throws IllegalStateException {
if ( current == null ) {
throw new IllegalStateException () ;
}
return current ;
}
@Override
public boolean hasNext () {
return next != parent . header ;
}
@Override
public E next () {
checkModCount () ; MST[VoidMethodCallMutator]MSP[N]
if ( ! hasNext () ) {
throw new NoSuchElementException ( lr_12 + nextIndex + lr_13 ) ;
}
final E value = next . getValue () ;
current = next ;
next = next . next ;
nextIndex ++ ;
return value ;
}
@Override
public boolean hasPrevious () {
return next . previous != parent . header ;
}
@Override
public E previous () {
checkModCount () ;
if ( ! hasPrevious () ) {
throw new NoSuchElementException ( lr_14 ) ;
}
next = next . previous ;
final E value = next . getValue () ;
current = next ;
nextIndex -- ;
return value ;
}
@Override
public int nextIndex () {
return nextIndex ;
}
@Override
public int previousIndex () {
return nextIndex () - 1 ;
}
@Override
public void remove () {
checkModCount () ;
if ( current == next ) {
next = next . next ;
parent . removeNode ( getLastNodeReturned () ) ;
} else {
parent . removeNode ( getLastNodeReturned () ) ;
nextIndex -- ;
}
current = null ;
expectedModCount ++ ;
}
@Override
public void set ( final E obj ) {
checkModCount () ;
getLastNodeReturned () . setValue ( obj ) ;
}
@Override
public void add ( final E obj ) {
checkModCount () ;
parent . addNodeBefore ( next , obj ) ;
current = null ;
nextIndex ++ ;
expectedModCount ++ ;
}
@Override
public boolean hasNext () {
return nextIndex () < sub . size ;
}
@Override
public boolean hasPrevious () {
return previousIndex () >= 0 ;
}
@Override
public int nextIndex () {
return super . nextIndex () - sub . offset ;
}
@Override
public void add ( final E obj ) {
super . add ( obj ) ;
sub . expectedModCount = parent . modCount ;
sub . size ++ ;
}
@Override
public void remove () {
super . remove () ;
sub . expectedModCount = parent . modCount ;
sub . size -- ;
}
@Override
public int size () {
checkModCount () ;
return size ;
}
@Override
public E get ( final int index ) {
rangeCheck ( index , size ) ;
checkModCount () ;
return parent . get ( index + offset ) ;
}
@Override
public void add ( final int index , final E obj ) {
rangeCheck ( index , size + 1 ) ;
checkModCount () ;
parent . add ( index + offset , obj ) ;
expectedModCount = parent . modCount ;
size ++ ;
LinkedSubList . this . modCount ++ ;
}
@Override
public E remove ( final int index ) {
rangeCheck ( index , size ) ;
checkModCount () ;
final E result = parent . remove ( index + offset ) ;
expectedModCount = parent . modCount ;
size -- ;
LinkedSubList . this . modCount ++ ;
return result ;
}
@Override
public boolean addAll ( final Collection < ? extends E > coll ) {
return addAll ( size , coll ) ;
}
@Override
public boolean addAll ( final int index , final Collection < ? extends E > coll ) {
rangeCheck ( index , size + 1 ) ;
final int cSize = coll . size () ;
if ( cSize == 0 ) {
return false ;
}
checkModCount () ;
parent . addAll ( offset + index , coll ) ;
expectedModCount = parent . modCount ;
size += cSize ;
LinkedSubList . this . modCount ++ ;
return true ;
}
@Override
public E set ( final int index , final E obj ) {
rangeCheck ( index , size ) ;
checkModCount () ;
return parent . set ( index + offset , obj ) ;
}
@Override
public void clear () {
checkModCount () ;
final Iterator < E > it = iterator () ;
while ( it . hasNext () ) {
it . next () ;
it . remove () ;
}
}
@Override
public Iterator < E > iterator () {
checkModCount () ;
return parent . createSubListIterator ( this ) ;
}
@Override
public ListIterator < E > listIterator ( final int index ) {
rangeCheck ( index , size + 1 ) ;
checkModCount () ;
return parent . createSubListListIterator ( this , index ) ;
}
@Override
public List < E > subList ( final int fromIndexInclusive , final int toIndexExclusive ) {
return new LinkedSubList <> ( parent , fromIndexInclusive + offset , toIndexExclusive + offset ) ;
}
protected void rangeCheck ( final int index , final int beyond ) {
if ( index < 0 || index >= beyond ) {
throw new IndexOutOfBoundsException ( lr_15 + index + lr_16 + size + lr_17 ) ;
}
}
protected void checkModCount () {
if ( parent . modCount != expectedModCount ) {
throw new ConcurrentModificationException () ;
}
}

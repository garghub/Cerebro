private void writeObject ( final ObjectOutputStream out ) throws IOException {
out . defaultWriteObject () ;
out . writeInt ( size () ) ;
for ( final E e : this ) {
out . writeObject ( e ) ;
}
}
@SuppressWarnings ( lr_1 )
private void readObject ( final ObjectInputStream in ) throws IOException , ClassNotFoundException {
in . defaultReadObject () ;
elements = ( E [] ) new Object [ maxElements ] ;
final int size = in . readInt () ;
for ( int i = 0 ; i < size ; i ++ ) {
elements [ i ] = ( E ) in . readObject () ;
}
start = 0 ;
full = size == maxElements ;
if ( full ) {
end = 0 ;
} else {
end = size ;
}
}
@Override
public int size () {
int size = 0 ;
if ( end < start ) {
size = maxElements - start + end ;
} else if ( end == start ) {
size = full ? maxElements : 0 ;
} else {
size = end - start ;
}
return size ;
}
@Override
public boolean isEmpty () {
return size () == 0 ;
}
@Override
public boolean isFull () {
return false ;
}
public boolean isAtFullCapacity () {
return size () == maxElements ;
}
@Override
public int maxSize () {
return maxElements ;
}
@Override
public void clear () {
full = false ;
start = 0 ;
end = 0 ;
Arrays . fill ( elements , null ) ;
}
@Override
public boolean add ( final E element ) {
Objects . requireNonNull ( element , lr_2 ) ;
if ( isAtFullCapacity () ) {
remove () ;
}
elements [ end ++ ] = element ;
if ( end >= maxElements ) {
end = 0 ;
}
if ( end == start ) {
full = true ;
}
return true ;
}
public E get ( final int index ) {
final int sz = size () ;
if ( index < 0 || index >= sz ) {
throw new NoSuchElementException (
String . format ( lr_3 ,
Integer . valueOf ( index ) , Integer . valueOf ( sz ) ) ) ;
}
final int idx = ( start + index ) % maxElements ;
return elements [ idx ] ;
}
@Override
public boolean offer ( final E element ) {
return add ( element ) ;
}
@Override
public E poll () {
if ( isEmpty () ) {
return null ;
}
return remove () ;
}
@Override
public E element () {
if ( isEmpty () ) {
throw new NoSuchElementException ( lr_4 ) ;
}
return peek () ;
}
@Override
public E peek () {
if ( isEmpty () ) {
return null ;
}
return elements [ start ] ;
}
@Override
public E remove () {
if ( isEmpty () ) {
throw new NoSuchElementException ( lr_4 ) ;
}
final E element = elements [ start ] ;
if ( null != element ) {
elements [ start ++ ] = null ;
if ( start >= maxElements ) {
start = 0 ;
}
full = false ;
}
return element ;
}
private int increment ( int index ) {
index ++ ;
if ( index >= maxElements ) {
index = 0 ;
}
return index ;
}
private int decrement ( int index ) {
index -- ;
if ( index < 0 ) {
index = maxElements - 1 ; MST[rv.CRCR4Mutator]MSP[]
}
return index ;
}
@Override
public boolean hasNext () {
return isFirst || index != end ;
}
@Override
public E next () {
if ( ! hasNext () ) {
throw new NoSuchElementException () ;
}
isFirst = false ;
lastReturnedIndex = index ;
index = increment ( index ) ;
return elements [ lastReturnedIndex ] ;
}
@Override
public void remove () {
if ( lastReturnedIndex == - 1 ) {
throw new IllegalStateException () ;
}
if ( lastReturnedIndex == start ) {
CircularFifoQueue . this . remove () ;
lastReturnedIndex = - 1 ;
return;
}
int pos = lastReturnedIndex + 1 ;
if ( start < lastReturnedIndex && pos < end ) {
System . arraycopy ( elements , pos , elements , lastReturnedIndex , end - pos ) ;
} else {
while ( pos != end ) {
if ( pos >= maxElements ) {
elements [ pos - 1 ] = elements [ 0 ] ;
pos = 0 ;
} else {
elements [ decrement ( pos ) ] = elements [ pos ] ;
pos = increment ( pos ) ;
}
}
}
lastReturnedIndex = - 1 ;
end = decrement ( end ) ;
elements [ end ] = null ;
full = false ;
index = decrement ( index ) ;
}

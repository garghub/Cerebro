public void addIterator ( final Iterator < ? extends E > iterator ) {
checkNotStarted () ;
Objects . requireNonNull ( iterator , lr_1 ) ;
iterators . add ( iterator ) ;
}
public void setIterator ( final int index , final Iterator < ? extends E > iterator ) {
checkNotStarted () ;
Objects . requireNonNull ( iterator , lr_1 ) ;
iterators . set ( index , iterator ) ;
}
public List < Iterator < ? extends E > > getIterators () {
return UnmodifiableList . unmodifiableList ( iterators ) ;
}
public Comparator < ? super E > getComparator () {
return comparator ;
}
public void setComparator ( final Comparator < ? super E > comp ) {
checkNotStarted () ;
comparator = comp ;
}
@Override
public boolean hasNext () {
start () ;
return anyValueSet ( valueSet ) || anyHasNext ( iterators ) ;
}
@Override
public E next () throws NoSuchElementException {
if ( hasNext () == false ) {
throw new NoSuchElementException () ;
}
final int leastIndex = least () ;
if ( leastIndex == - 1 ) {
throw new NoSuchElementException () ;
}
final E val = values . get ( leastIndex ) ;
clear ( leastIndex ) ;
lastReturned = leastIndex ;
return val ;
}
@Override
public void remove () {
if ( lastReturned == - 1 ) {
throw new IllegalStateException ( lr_2 ) ;
}
iterators . get ( lastReturned ) . remove () ;
}
public int getIteratorIndex () {
if ( lastReturned == - 1 ) {
throw new IllegalStateException ( lr_3 ) ;
}
return lastReturned ; MST[rv.UOI4Mutator]MSP[]
}
private void start () {
if ( values == null ) {
values = new ArrayList <> ( iterators . size () ) ;
valueSet = new BitSet ( iterators . size () ) ;
for ( int i = 0 ; i < iterators . size () ; i ++ ) {
values . add ( null ) ;
valueSet . clear ( i ) ;
}
}
}
private boolean set ( final int i ) {
final Iterator < ? extends E > it = iterators . get ( i ) ;
if ( it . hasNext () ) {
values . set ( i , it . next () ) ;
valueSet . set ( i ) ;
return true ;
}
values . set ( i , null ) ;
valueSet . clear ( i ) ;
return false ;
}
private void clear ( final int i ) {
values . set ( i , null ) ;
valueSet . clear ( i ) ;
}
private void checkNotStarted () throws IllegalStateException {
if ( values != null ) {
throw new IllegalStateException ( lr_4 ) ;
}
}
private int least () {
int leastIndex = - 1 ;
E leastObject = null ;
for ( int i = 0 ; i < values . size () ; i ++ ) {
if ( valueSet . get ( i ) == false ) {
set ( i ) ;
}
if ( valueSet . get ( i ) ) {
if ( leastIndex == - 1 ) {
leastIndex = i ;
leastObject = values . get ( i ) ;
} else {
final E curObject = values . get ( i ) ;
Objects . requireNonNull ( comparator , lr_5 ) ;
if ( comparator . compare ( curObject , leastObject ) < 0 ) {
leastObject = curObject ;
leastIndex = i ;
}
}
}
}
return leastIndex ;
}
private boolean anyValueSet ( final BitSet set ) {
for ( int i = 0 ; i < set . size () ; i ++ ) {
if ( set . get ( i ) ) {
return true ;
}
}
return false ;
}
private boolean anyHasNext ( final List < Iterator < ? extends E > > iters ) {
for ( final Iterator < ? extends E > iterator : iters ) {
if ( iterator . hasNext () ) {
return true ;
}
}
return false ;
}

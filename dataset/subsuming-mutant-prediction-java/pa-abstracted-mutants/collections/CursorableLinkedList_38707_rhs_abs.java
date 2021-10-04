@Override
protected void init () {
super . init () ;
cursors = new ArrayList <> () ;
}
@Override
public Iterator < E > iterator () {
return super . listIterator ( 0 ) ;
}
@Override
public ListIterator < E > listIterator () {
return cursor ( 0 ) ;
}
@Override
public ListIterator < E > listIterator ( final int fromIndex ) {
return cursor ( fromIndex ) ;
}
public CursorableLinkedList . Cursor < E > cursor () {
return cursor ( 0 ) ;
}
public CursorableLinkedList . Cursor < E > cursor ( final int fromIndex ) {
final Cursor < E > cursor = new Cursor <> ( this , fromIndex ) ;
registerCursor ( cursor ) ;
return cursor ;
}
@Override
protected void updateNode ( final Node < E > node , final E value ) {
super . updateNode ( node , value ) ;
broadcastNodeChanged ( node ) ;
}
@Override
protected void addNode ( final Node < E > nodeToInsert , final Node < E > insertBeforeNode ) {
super . addNode ( nodeToInsert , insertBeforeNode ) ;
broadcastNodeInserted ( nodeToInsert ) ;
}
@Override
protected void removeNode ( final Node < E > node ) {
super . removeNode ( node ) ;
broadcastNodeRemoved ( node ) ;
}
@Override
protected void removeAllNodes () {
if ( size () > 0 ) {
final Iterator < E > it = iterator () ;
while ( it . hasNext () ) {
it . next () ;
it . remove () ;
}
}
}
protected void registerCursor ( final Cursor < E > cursor ) {
cursors . removeIf ( ref -> ref . get () == null ) ;
cursors . add ( new WeakReference <> ( cursor ) ) ;
}
protected void unregisterCursor ( final Cursor < E > cursor ) {
for ( final Iterator < WeakReference < Cursor < E > > > it = cursors . iterator () ; it . hasNext () ; ) {
final WeakReference < Cursor < E > > ref = it . next () ;
final Cursor < E > cur = ref . get () ;
if ( cur == null ) {
it . remove () ;
} else if ( cur == cursor ) {
ref . clear () ;
it . remove () ;
break;
}
}
}
protected void broadcastNodeChanged ( final Node < E > node ) {
final Iterator < WeakReference < Cursor < E > > > it = cursors . iterator () ;
while ( it . hasNext () ) {
final WeakReference < Cursor < E > > ref = it . next () ;
final Cursor < E > cursor = ref . get () ;
if ( cursor == null ) {
it . remove () ;
} else {
cursor . nodeChanged ( node ) ;
}
}
}
protected void broadcastNodeRemoved ( final Node < E > node ) {
final Iterator < WeakReference < Cursor < E > > > it = cursors . iterator () ;
while ( it . hasNext () ) {
final WeakReference < Cursor < E > > ref = it . next () ;
final Cursor < E > cursor = ref . get () ;
if ( cursor == null ) {
it . remove () ;
} else {
cursor . nodeRemoved ( node ) ;
}
}
}
protected void broadcastNodeInserted ( final Node < E > node ) {
final Iterator < WeakReference < Cursor < E > > > it = cursors . iterator () ;
while ( it . hasNext () ) {
final WeakReference < Cursor < E > > ref = it . next () ;
final Cursor < E > cursor = ref . get () ;
if ( cursor == null ) {
it . remove () ;
} else {
cursor . nodeInserted ( node ) ;
}
}
}
private void writeObject ( final ObjectOutputStream out ) throws IOException {
out . defaultWriteObject () ;
doWriteObject ( out ) ;
}
private void readObject ( final ObjectInputStream in ) throws IOException , ClassNotFoundException {
in . defaultReadObject () ;
doReadObject ( in ) ;
}
@Override
protected ListIterator < E > createSubListListIterator ( final LinkedSubList < E > subList , final int fromIndex ) {
final SubCursor < E > cursor = new SubCursor <> ( subList , fromIndex ) ;
registerCursor ( cursor ) ;
return cursor ;
}
@Override
public void remove () {
if ( current == null && currentRemovedByAnother ) {
} else {
checkModCount () ;
parent . removeNode ( getLastNodeReturned () ) ;
}
currentRemovedByAnother = false ;
}
@Override
public void add ( final E obj ) {
super . add ( obj ) ;
next = next . next ;
}
@Override
public int nextIndex () {
if ( nextIndexValid == false ) {
if ( next == parent . header ) {
nextIndex = parent . size () ;
} else {
int pos = 0 ;
Node < E > temp = parent . header . next ;
while ( temp != next ) {
pos ++ ;
temp = temp . next ;
}
nextIndex = pos ;
}
nextIndexValid = true ;
}
return nextIndex ;
}
protected void nodeChanged ( final Node < E > node ) {
}
protected void nodeRemoved ( final Node < E > node ) {
if ( node == next && node == current ) {
next = node . next ;
current = null ;
currentRemovedByAnother = true ;
} else if ( node == next ) {
next = node . next ;
currentRemovedByAnother = false ;
} else if ( node == current ) {
current = null ;
currentRemovedByAnother = true ;
nextIndex -- ;
} else {
nextIndexValid = false ;
currentRemovedByAnother = false ;
}
}
protected void nodeInserted ( final Node < E > node ) {
if ( node . previous == current ) {
next = node ;
} else if ( next . previous == node ) {
next = node ;
} else {
nextIndexValid = false ;
}
}
@Override
protected void checkModCount () {
if ( ! valid ) {
throw new ConcurrentModificationException ( lr_1 ) ;
}
}
public void close () {
if ( valid ) {
( ( CursorableLinkedList < E > ) parent ) . unregisterCursor ( this ) ;
valid = false ;
}
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
sub . expectedModCount = parent . modCount ; MST[experimental.MemberVariableMutator]MSP[N]
sub . size ++ ;
}
@Override
public void remove () {
super . remove () ;
sub . expectedModCount = parent . modCount ;
sub . size -- ;
}

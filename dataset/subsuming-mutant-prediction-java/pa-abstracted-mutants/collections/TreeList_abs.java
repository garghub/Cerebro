@Override
public E get ( final int index ) {
checkInterval ( index , 0 , size () - 1 ) ;
return root . get ( index ) . getValue () ;
}
@Override
public int size () {
return size ;
}
@Override
public Iterator < E > iterator () {
return listIterator ( 0 ) ;
}
@Override
public ListIterator < E > listIterator () {
return listIterator ( 0 ) ;
}
@Override
public ListIterator < E > listIterator ( final int fromIndex ) {
checkInterval ( fromIndex , 0 , size () ) ;
return new TreeListIterator <> ( this , fromIndex ) ;
}
@Override
public int indexOf ( final Object object ) {
if ( root == null ) {
return - 1 ;
}
return root . indexOf ( object , root . relativePosition ) ;
}
@Override
public boolean contains ( final Object object ) {
return indexOf ( object ) >= 0 ;
}
@Override
public Object [] toArray () {
final Object [] array = new Object [ size () ] ;
if ( root != null ) {
root . toArray ( array , root . relativePosition ) ;
}
return array ;
}
@Override
public void add ( final int index , final E obj ) {
modCount ++ ;
checkInterval ( index , 0 , size () ) ;
if ( root == null ) {
root = new AVLNode <> ( index , obj , null , null ) ;
} else {
root = root . insert ( index , obj ) ;
}
size ++ ;
}
@Override
public boolean addAll ( final Collection < ? extends E > c ) {
if ( c . isEmpty () ) {
return false ;
}
modCount += c . size () ;
final AVLNode < E > cTree = new AVLNode <> ( c ) ;
root = root == null ? cTree : root . addAll ( cTree , size ) ;
size += c . size () ;
return true ;
}
@Override
public E set ( final int index , final E obj ) {
checkInterval ( index , 0 , size () - 1 ) ;
final AVLNode < E > node = root . get ( index ) ;
final E result = node . value ;
node . setValue ( obj ) ;
return result ;
}
@Override
public E remove ( final int index ) {
modCount ++ ;
checkInterval ( index , 0 , size () - 1 ) ;
final E result = get ( index ) ;
root = root . remove ( index ) ;
size -- ;
return result ;
}
@Override
public void clear () {
modCount ++ ;
root = null ;
size = 0 ;
}
private void checkInterval ( final int index , final int startIndex , final int endIndex ) {
if ( index < startIndex || index > endIndex ) {
throw new IndexOutOfBoundsException ( lr_1 + index + lr_2 + size () ) ;
}
}
E getValue () {
return value ;
}
void setValue ( final E obj ) {
this . value = obj ;
}
AVLNode < E > get ( final int index ) {
final int indexRelativeToMe = index - relativePosition ;
if ( indexRelativeToMe == 0 ) {
return this ;
}
final AVLNode < E > nextNode = indexRelativeToMe < 0 ? getLeftSubTree () : getRightSubTree () ;
if ( nextNode == null ) {
return null ;
}
return nextNode . get ( indexRelativeToMe ) ;
}
int indexOf ( final Object object , final int index ) {
if ( getLeftSubTree () != null ) {
final int result = left . indexOf ( object , index + left . relativePosition ) ;
if ( result != - 1 ) {
return result ;
}
}
if ( Objects . equals ( value , object ) ) {
return index ;
}
if ( getRightSubTree () != null ) {
return right . indexOf ( object , index + right . relativePosition ) ;
}
return - 1 ;
}
void toArray ( final Object [] array , final int index ) {
array [ index ] = value ;
if ( getLeftSubTree () != null ) {
left . toArray ( array , index + left . relativePosition ) ;
}
if ( getRightSubTree () != null ) {
right . toArray ( array , index + right . relativePosition ) ;
}
}
AVLNode < E > next () {
if ( rightIsNext || right == null ) {
return right ;
}
return right . min () ;
}
AVLNode < E > previous () {
if ( leftIsPrevious || left == null ) {
return left ;
}
return left . max () ;
}
AVLNode < E > insert ( final int index , final E obj ) {
final int indexRelativeToMe = index - relativePosition ;
if ( indexRelativeToMe <= 0 ) {
return insertOnLeft ( indexRelativeToMe , obj ) ;
}
return insertOnRight ( indexRelativeToMe , obj ) ;
}
private AVLNode < E > insertOnLeft ( final int indexRelativeToMe , final E obj ) {
if ( getLeftSubTree () == null ) {
setLeft ( new AVLNode <> ( - 1 , obj , this , left ) , null ) ;
} else {
setLeft ( left . insert ( indexRelativeToMe , obj ) , null ) ;
}
if ( relativePosition >= 0 ) {
relativePosition ++ ;
}
final AVLNode < E > ret = balance () ;
recalcHeight () ;
return ret ;
}
private AVLNode < E > insertOnRight ( final int indexRelativeToMe , final E obj ) {
if ( getRightSubTree () == null ) {
setRight ( new AVLNode <> ( + 1 , obj , right , this ) , null ) ;
} else {
setRight ( right . insert ( indexRelativeToMe , obj ) , null ) ;
}
if ( relativePosition < 0 ) {
relativePosition -- ;
}
final AVLNode < E > ret = balance () ;
recalcHeight () ;
return ret ;
}
private AVLNode < E > getLeftSubTree () {
return leftIsPrevious ? null : left ;
}
private AVLNode < E > getRightSubTree () {
return rightIsNext ? null : right ;
}
private AVLNode < E > max () {
return getRightSubTree () == null ? this : right . max () ;
}
private AVLNode < E > min () {
return getLeftSubTree () == null ? this : left . min () ;
}
AVLNode < E > remove ( final int index ) {
final int indexRelativeToMe = index - relativePosition ;
if ( indexRelativeToMe == 0 ) {
return removeSelf () ;
}
if ( indexRelativeToMe > 0 ) {
setRight ( right . remove ( indexRelativeToMe ) , right . right ) ;
if ( relativePosition < 0 ) {
relativePosition ++ ;
}
} else {
setLeft ( left . remove ( indexRelativeToMe ) , left . left ) ;
if ( relativePosition > 0 ) {
relativePosition -- ;
}
}
recalcHeight () ;
return balance () ;
}
private AVLNode < E > removeMax () {
if ( getRightSubTree () == null ) {
return removeSelf () ;
}
setRight ( right . removeMax () , right . right ) ;
if ( relativePosition < 0 ) {
relativePosition ++ ;
}
recalcHeight () ;
return balance () ;
}
private AVLNode < E > removeMin () {
if ( getLeftSubTree () == null ) {
return removeSelf () ;
}
setLeft ( left . removeMin () , left . left ) ;
if ( relativePosition > 0 ) {
relativePosition -- ;
}
recalcHeight () ;
return balance () ;
}
private AVLNode < E > removeSelf () {
if ( getRightSubTree () == null && getLeftSubTree () == null ) {
return null ;
}
if ( getRightSubTree () == null ) {
if ( relativePosition > 0 ) {
left . relativePosition += relativePosition ;
}
left . max () . setRight ( null , right ) ;
return left ;
}
if ( getLeftSubTree () == null ) {
right . relativePosition += relativePosition - ( relativePosition < 0 ? 0 : 1 ) ;
right . min () . setLeft ( null , left ) ;
return right ;
}
if ( heightRightMinusLeft () > 0 ) {
final AVLNode < E > rightMin = right . min () ;
value = rightMin . value ;
if ( leftIsPrevious ) {
left = rightMin . left ;
}
right = right . removeMin () ;
if ( relativePosition < 0 ) {
relativePosition ++ ;
}
} else {
final AVLNode < E > leftMax = left . max () ;
value = leftMax . value ;
if ( rightIsNext ) {
right = leftMax . right ;
}
final AVLNode < E > leftPrevious = left . left ;
left = left . removeMax () ;
if ( left == null ) {
left = leftPrevious ;
leftIsPrevious = true ;
}
if ( relativePosition > 0 ) {
relativePosition -- ;
}
}
recalcHeight () ;
return this ;
}
private AVLNode < E > balance () {
switch ( heightRightMinusLeft () ) {
case 1 :
case 0 :
case - 1 :
return this ;
case - 2 :
if ( left . heightRightMinusLeft () > 0 ) {
setLeft ( left . rotateLeft () , null ) ;
}
return rotateRight () ;
case 2 :
if ( right . heightRightMinusLeft () < 0 ) {
setRight ( right . rotateRight () , null ) ;
}
return rotateLeft () ;
default :
throw new RuntimeException ( lr_3 ) ;
}
}
private int getOffset ( final AVLNode < E > node ) {
if ( node == null ) {
return 0 ;
}
return node . relativePosition ;
}
private int setOffset ( final AVLNode < E > node , final int newOffset ) {
if ( node == null ) {
return 0 ;
}
final int oldOffset = getOffset ( node ) ;
node . relativePosition = newOffset ;
return oldOffset ;
}
private void recalcHeight () {
height = Math . max (
getLeftSubTree () == null ? - 1 : getLeftSubTree () . height ,
getRightSubTree () == null ? - 1 : getRightSubTree () . height ) + 1 ;
}
private int getHeight ( final AVLNode < E > node ) {
return node == null ? - 1 : node . height ;
}
private int heightRightMinusLeft () {
return getHeight ( getRightSubTree () ) - getHeight ( getLeftSubTree () ) ;
}
private AVLNode < E > rotateLeft () {
final AVLNode < E > newTop = right ;
final AVLNode < E > movedNode = getRightSubTree () . getLeftSubTree () ;
final int newTopPosition = relativePosition + getOffset ( newTop ) ;
final int myNewPosition = - newTop . relativePosition ;
final int movedPosition = getOffset ( newTop ) + getOffset ( movedNode ) ;
setRight ( movedNode , newTop ) ;
newTop . setLeft ( this , null ) ;
setOffset ( newTop , newTopPosition ) ;
setOffset ( this , myNewPosition ) ;
setOffset ( movedNode , movedPosition ) ;
return newTop ;
}
private AVLNode < E > rotateRight () {
final AVLNode < E > newTop = left ;
final AVLNode < E > movedNode = getLeftSubTree () . getRightSubTree () ;
final int newTopPosition = relativePosition + getOffset ( newTop ) ;
final int myNewPosition = - newTop . relativePosition ;
final int movedPosition = getOffset ( newTop ) + getOffset ( movedNode ) ;
setLeft ( movedNode , newTop ) ;
newTop . setRight ( this , null ) ;
setOffset ( newTop , newTopPosition ) ;
setOffset ( this , myNewPosition ) ;
setOffset ( movedNode , movedPosition ) ;
return newTop ;
}
private void setLeft ( final AVLNode < E > node , final AVLNode < E > previous ) {
leftIsPrevious = node == null ;
left = leftIsPrevious ? previous : node ;
recalcHeight () ;
}
private void setRight ( final AVLNode < E > node , final AVLNode < E > next ) {
rightIsNext = node == null ;
right = rightIsNext ? next : node ;
recalcHeight () ;
}
private AVLNode < E > addAll ( AVLNode < E > otherTree , final int currentSize ) {
final AVLNode < E > maxNode = max () ;
final AVLNode < E > otherTreeMin = otherTree . min () ;
if ( otherTree . height > height ) {
final AVLNode < E > leftSubTree = removeMax () ;
final Deque < AVLNode < E > > sAncestors = new ArrayDeque <> () ;
AVLNode < E > s = otherTree ;
int sAbsolutePosition = s . relativePosition + currentSize ;
int sParentAbsolutePosition = 0 ;
while ( s != null && s . height > getHeight ( leftSubTree ) ) {
sParentAbsolutePosition = sAbsolutePosition ;
sAncestors . push ( s ) ;
s = s . left ;
if ( s != null ) {
sAbsolutePosition += s . relativePosition ;
}
}
maxNode . setLeft ( leftSubTree , null ) ;
maxNode . setRight ( s , otherTreeMin ) ;
if ( leftSubTree != null ) {
leftSubTree . max () . setRight ( null , maxNode ) ;
leftSubTree . relativePosition -= currentSize - 1 ;
}
if ( s != null ) {
s . min () . setLeft ( null , maxNode ) ;
s . relativePosition = sAbsolutePosition - currentSize + 1 ;
}
maxNode . relativePosition = currentSize - 1 - sParentAbsolutePosition ;
otherTree . relativePosition += currentSize ;
s = maxNode ;
while ( ! sAncestors . isEmpty () ) {
final AVLNode < E > sAncestor = sAncestors . pop () ;
sAncestor . setLeft ( s , null ) ;
s = sAncestor . balance () ;
}
return s ;
}
otherTree = otherTree . removeMin () ;
final Deque < AVLNode < E > > sAncestors = new ArrayDeque <> () ;
AVLNode < E > s = this ;
int sAbsolutePosition = s . relativePosition ;
int sParentAbsolutePosition = 0 ;
while ( s != null && s . height > getHeight ( otherTree ) ) {
sParentAbsolutePosition = sAbsolutePosition ;
sAncestors . push ( s ) ;
s = s . right ;
if ( s != null ) {
sAbsolutePosition += s . relativePosition ;
}
}
otherTreeMin . setRight ( otherTree , null ) ;
otherTreeMin . setLeft ( s , maxNode ) ;
if ( otherTree != null ) {
otherTree . min () . setLeft ( null , otherTreeMin ) ;
otherTree . relativePosition ++ ;
}
if ( s != null ) {
s . max () . setRight ( null , otherTreeMin ) ;
s . relativePosition = sAbsolutePosition - currentSize ;
}
otherTreeMin . relativePosition = currentSize - sParentAbsolutePosition ;
s = otherTreeMin ;
while ( ! sAncestors . isEmpty () ) {
final AVLNode < E > sAncestor = sAncestors . pop () ;
sAncestor . setRight ( s , null ) ;
s = sAncestor . balance () ;
}
return s ;
}
@Override
public String toString () {
return new StringBuilder ()
. append ( lr_4 )
. append ( relativePosition )
. append ( ',' )
. append ( left != null )
. append ( ',' )
. append ( value )
. append ( ',' )
. append ( getRightSubTree () != null )
. append ( lr_5 )
. append ( rightIsNext )
. append ( lr_6 )
. toString () ;
}
protected void checkModCount () {
if ( parent . modCount != expectedModCount ) {
throw new ConcurrentModificationException () ;
}
}
@Override
public boolean hasNext () {
return nextIndex < parent . size () ;
}
@Override
public E next () {
checkModCount () ;
if ( ! hasNext () ) {
throw new NoSuchElementException ( lr_7 + nextIndex + lr_8 ) ;
}
if ( next == null ) {
next = parent . root . get ( nextIndex ) ;
}
final E value = next . getValue () ;
current = next ;
currentIndex = nextIndex ++ ;
next = next . next () ;
return value ;
}
@Override
public boolean hasPrevious () {
return nextIndex > 0 ;
}
@Override
public E previous () {
checkModCount () ;
if ( ! hasPrevious () ) {
throw new NoSuchElementException ( lr_9 ) ;
}
if ( next == null ) {
next = parent . root . get ( nextIndex - 1 ) ;
} else {
next = next . previous () ;
}
final E value = next . getValue () ;
current = next ;
currentIndex = -- nextIndex ;
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
if ( currentIndex == - 1 ) {
throw new IllegalStateException () ;
}
parent . remove ( currentIndex ) ;
if ( nextIndex != currentIndex ) {
nextIndex -- ;
}
next = null ;
current = null ;
currentIndex = - 1 ;
expectedModCount ++ ;
}
@Override
public void set ( final E obj ) {
checkModCount () ;
if ( current == null ) {
throw new IllegalStateException () ;
}
current . setValue ( obj ) ;
}
@Override
public void add ( final E obj ) {
checkModCount () ;
parent . add ( nextIndex , obj ) ;
current = null ;
currentIndex = - 1 ;
nextIndex ++ ;
expectedModCount ++ ;
}

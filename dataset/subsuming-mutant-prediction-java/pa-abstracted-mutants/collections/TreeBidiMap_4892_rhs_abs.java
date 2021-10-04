@Override
public String toString () {
return description ;
}
@Override
public int size () {
return nodeCount ;
}
@Override
public boolean isEmpty () {
return nodeCount == 0 ;
}
@Override
public boolean containsKey ( final Object key ) {
checkKey ( key ) ;
return lookupKey ( key ) != null ;
}
@Override
public boolean containsValue ( final Object value ) {
checkValue ( value ) ;
return lookupValue ( value ) != null ;
}
@Override
public V get ( final Object key ) {
checkKey ( key ) ;
final Node < K , V > node = lookupKey ( key ) ;
return node == null ? null : node . getValue () ;
}
@Override
public V put ( final K key , final V value ) {
final V result = get ( key ) ;
doPut ( key , value ) ;
return result ;
}
@Override
public void putAll ( final Map < ? extends K , ? extends V > map ) {
for ( final Map . Entry < ? extends K , ? extends V > e : map . entrySet () ) {
put ( e . getKey () , e . getValue () ) ;
}
}
@Override
public V remove ( final Object key ) {
return doRemoveKey ( key ) ;
}
@Override
public void clear () {
modify () ;
nodeCount = 0 ;
rootNode [ KEY . ordinal () ] = null ;
rootNode [ VALUE . ordinal () ] = null ;
}
@Override
public K getKey ( final Object value ) {
checkValue ( value ) ;
final Node < K , V > node = lookupValue ( value ) ;
return node == null ? null : node . getKey () ;
}
@Override
public K removeValue ( final Object value ) {
return doRemoveValue ( value ) ;
}
@Override
public K firstKey () {
if ( nodeCount == 0 ) {
throw new NoSuchElementException ( lr_1 ) ;
}
return leastNode ( rootNode [ KEY . ordinal () ] , KEY ) . getKey () ;
}
@Override
public K lastKey () {
if ( nodeCount == 0 ) {
throw new NoSuchElementException ( lr_1 ) ;
}
return greatestNode ( rootNode [ KEY . ordinal () ] , KEY ) . getKey () ;
}
@Override
public K nextKey ( final K key ) {
checkKey ( key ) ;
final Node < K , V > node = nextGreater ( lookupKey ( key ) , KEY ) ;
return node == null ? null : node . getKey () ;
}
@Override
public K previousKey ( final K key ) {
checkKey ( key ) ;
final Node < K , V > node = nextSmaller ( lookupKey ( key ) , KEY ) ;
return node == null ? null : node . getKey () ;
}
@Override
public Set < K > keySet () {
if ( keySet == null ) {
keySet = new KeyView ( KEY ) ;
}
return keySet ;
}
@Override
public Set < V > values () {
if ( valuesSet == null ) {
valuesSet = new ValueView ( KEY ) ;
}
return valuesSet ;
}
@Override
public Set < Map . Entry < K , V > > entrySet () {
if ( entrySet == null ) {
entrySet = new EntryView () ;
}
return entrySet ;
}
@Override
public OrderedMapIterator < K , V > mapIterator () {
if ( isEmpty () ) {
return EmptyOrderedMapIterator . <K , V > emptyOrderedMapIterator () ;
}
return new ViewMapIterator ( KEY ) ;
}
@Override
public OrderedBidiMap < V , K > inverseBidiMap () {
if ( inverse == null ) {
inverse = new Inverse () ;
}
return inverse ;
}
@Override
public boolean equals ( final Object obj ) {
return this . doEquals ( obj , KEY ) ;
}
@Override
public int hashCode () {
return this . doHashCode ( KEY ) ;
}
@Override
public String toString () {
return this . doToString ( KEY ) ;
}
private void doPut ( final K key , final V value ) {
checkKeyAndValue ( key , value ) ;
doRemoveKey ( key ) ;
doRemoveValue ( value ) ;
Node < K , V > node = rootNode [ KEY . ordinal () ] ;
if ( node == null ) {
final Node < K , V > root = new Node <> ( key , value ) ;
rootNode [ KEY . ordinal () ] = root ;
rootNode [ VALUE . ordinal () ] = root ;
grow () ;
} else {
while ( true ) {
final int cmp = compare ( key , node . getKey () ) ;
if ( cmp == 0 ) {
throw new IllegalArgumentException ( lr_2 + key + lr_3 ) ;
} else if ( cmp < 0 ) {
if ( node . getLeft ( KEY ) != null ) {
node = node . getLeft ( KEY ) ;
} else {
final Node < K , V > newNode = new Node <> ( key , value ) ;
insertValue ( newNode ) ;
node . setLeft ( newNode , KEY ) ;
newNode . setParent ( node , KEY ) ;
doRedBlackInsert ( newNode , KEY ) ;
grow () ;
break;
}
} else {
if ( node . getRight ( KEY ) != null ) {
node = node . getRight ( KEY ) ;
} else {
final Node < K , V > newNode = new Node <> ( key , value ) ;
insertValue ( newNode ) ;
node . setRight ( newNode , KEY ) ;
newNode . setParent ( node , KEY ) ;
doRedBlackInsert ( newNode , KEY ) ;
grow () ;
break;
}
}
}
}
}
private V doRemoveKey ( final Object key ) {
final Node < K , V > node = lookupKey ( key ) ;
if ( node == null ) {
return null ;
}
doRedBlackDelete ( node ) ;
return node . getValue () ;
}
private K doRemoveValue ( final Object value ) {
final Node < K , V > node = lookupValue ( value ) ;
if ( node == null ) {
return null ;
}
doRedBlackDelete ( node ) ;
return node . getKey () ;
}
@SuppressWarnings ( lr_4 )
private < T extends Comparable < T > > Node < K , V > lookup ( final Object data , final DataElement dataElement ) {
Node < K , V > rval = null ;
Node < K , V > node = rootNode [ dataElement . ordinal () ] ;
while ( node != null ) {
final int cmp = compare ( ( T ) data , ( T ) node . getData ( dataElement ) ) ;
if ( cmp == 0 ) {
rval = node ;
break;
}
node = cmp < 0 ? node . getLeft ( dataElement ) : node . getRight ( dataElement ) ;
}
return rval ;
}
private Node < K , V > lookupKey ( final Object key ) {
return this . <K > lookup ( key , KEY ) ;
}
private Node < K , V > lookupValue ( final Object value ) {
return this . <V > lookup ( value , VALUE ) ;
}
private Node < K , V > nextGreater ( final Node < K , V > node , final DataElement dataElement ) {
Node < K , V > rval ;
if ( node == null ) {
rval = null ;
} else if ( node . getRight ( dataElement ) != null ) {
rval = leastNode ( node . getRight ( dataElement ) , dataElement ) ;
} else {
Node < K , V > parent = node . getParent ( dataElement ) ;
Node < K , V > child = node ;
while ( parent != null && child == parent . getRight ( dataElement ) ) {
child = parent ;
parent = parent . getParent ( dataElement ) ;
}
rval = parent ;
}
return rval ;
}
private Node < K , V > nextSmaller ( final Node < K , V > node , final DataElement dataElement ) {
Node < K , V > rval ;
if ( node == null ) {
rval = null ;
} else if ( node . getLeft ( dataElement ) != null ) {
rval = greatestNode ( node . getLeft ( dataElement ) , dataElement ) ;
} else {
Node < K , V > parent = node . getParent ( dataElement ) ;
Node < K , V > child = node ;
while ( parent != null && child == parent . getLeft ( dataElement ) ) {
child = parent ;
parent = parent . getParent ( dataElement ) ;
}
rval = parent ;
}
return rval ;
}
private static < T extends Comparable < T > > int compare ( final T o1 , final T o2 ) {
return o1 . compareTo ( o2 ) ;
}
private Node < K , V > leastNode ( final Node < K , V > node , final DataElement dataElement ) {
Node < K , V > rval = node ;
if ( rval != null ) {
while ( rval . getLeft ( dataElement ) != null ) {
rval = rval . getLeft ( dataElement ) ;
}
}
return rval ;
}
private Node < K , V > greatestNode ( final Node < K , V > node , final DataElement dataElement ) {
Node < K , V > rval = node ;
if ( rval != null ) {
while ( rval . getRight ( dataElement ) != null ) {
rval = rval . getRight ( dataElement ) ;
}
}
return rval ;
}
private void copyColor ( final Node < K , V > from , final Node < K , V > to , final DataElement dataElement ) {
if ( to != null ) {
if ( from == null ) {
to . setBlack ( dataElement ) ;
} else {
to . copyColor ( from , dataElement ) ;
}
}
}
private static boolean isRed ( final Node < ? , ? > node , final DataElement dataElement ) {
return node != null && node . isRed ( dataElement ) ;
}
private static boolean isBlack ( final Node < ? , ? > node , final DataElement dataElement ) {
return node == null || node . isBlack ( dataElement ) ;
}
private static void makeRed ( final Node < ? , ? > node , final DataElement dataElement ) {
if ( node != null ) {
node . setRed ( dataElement ) ;
}
}
private static void makeBlack ( final Node < ? , ? > node , final DataElement dataElement ) {
if ( node != null ) {
node . setBlack ( dataElement ) ;
}
}
private Node < K , V > getGrandParent ( final Node < K , V > node , final DataElement dataElement ) {
return getParent ( getParent ( node , dataElement ) , dataElement ) ;
}
private Node < K , V > getParent ( final Node < K , V > node , final DataElement dataElement ) {
return node == null ? null : node . getParent ( dataElement ) ;
}
private Node < K , V > getRightChild ( final Node < K , V > node , final DataElement dataElement ) {
return node == null ? null : node . getRight ( dataElement ) ;
}
private Node < K , V > getLeftChild ( final Node < K , V > node , final DataElement dataElement ) {
return node == null ? null : node . getLeft ( dataElement ) ;
}
private void rotateLeft ( final Node < K , V > node , final DataElement dataElement ) {
final Node < K , V > rightChild = node . getRight ( dataElement ) ;
node . setRight ( rightChild . getLeft ( dataElement ) , dataElement ) ;
if ( rightChild . getLeft ( dataElement ) != null ) {
rightChild . getLeft ( dataElement ) . setParent ( node , dataElement ) ;
}
rightChild . setParent ( node . getParent ( dataElement ) , dataElement ) ;
if ( node . getParent ( dataElement ) == null ) {
rootNode [ dataElement . ordinal () ] = rightChild ;
} else if ( node . getParent ( dataElement ) . getLeft ( dataElement ) == node ) {
node . getParent ( dataElement ) . setLeft ( rightChild , dataElement ) ;
} else {
node . getParent ( dataElement ) . setRight ( rightChild , dataElement ) ;
}
rightChild . setLeft ( node , dataElement ) ;
node . setParent ( rightChild , dataElement ) ;
}
private void rotateRight ( final Node < K , V > node , final DataElement dataElement ) {
final Node < K , V > leftChild = node . getLeft ( dataElement ) ;
node . setLeft ( leftChild . getRight ( dataElement ) , dataElement ) ;
if ( leftChild . getRight ( dataElement ) != null ) {
leftChild . getRight ( dataElement ) . setParent ( node , dataElement ) ;
}
leftChild . setParent ( node . getParent ( dataElement ) , dataElement ) ;
if ( node . getParent ( dataElement ) == null ) {
rootNode [ dataElement . ordinal () ] = leftChild ;
} else if ( node . getParent ( dataElement ) . getRight ( dataElement ) == node ) {
node . getParent ( dataElement ) . setRight ( leftChild , dataElement ) ;
} else {
node . getParent ( dataElement ) . setLeft ( leftChild , dataElement ) ;
}
leftChild . setRight ( node , dataElement ) ;
node . setParent ( leftChild , dataElement ) ;
}
private void doRedBlackInsert ( final Node < K , V > insertedNode , final DataElement dataElement ) {
Node < K , V > currentNode = insertedNode ;
makeRed ( currentNode , dataElement ) ;
while ( currentNode != null
&& currentNode != rootNode [ dataElement . ordinal () ]
&& isRed ( currentNode . getParent ( dataElement ) , dataElement ) ) {
if ( currentNode . isLeftChild ( dataElement ) ) {
final Node < K , V > y = getRightChild ( getGrandParent ( currentNode , dataElement ) , dataElement ) ;
if ( isRed ( y , dataElement ) ) {
makeBlack ( getParent ( currentNode , dataElement ) , dataElement ) ;
makeBlack ( y , dataElement ) ;
makeRed ( getGrandParent ( currentNode , dataElement ) , dataElement ) ;
currentNode = getGrandParent ( currentNode , dataElement ) ;
} else {
if ( currentNode . isRightChild ( dataElement ) ) {
currentNode = getParent ( currentNode , dataElement ) ;
rotateLeft ( currentNode , dataElement ) ;
}
makeBlack ( getParent ( currentNode , dataElement ) , dataElement ) ;
makeRed ( getGrandParent ( currentNode , dataElement ) , dataElement ) ;
if ( getGrandParent ( currentNode , dataElement ) != null ) {
rotateRight ( getGrandParent ( currentNode , dataElement ) , dataElement ) ;
}
}
} else {
final Node < K , V > y = getLeftChild ( getGrandParent ( currentNode , dataElement ) , dataElement ) ;
if ( isRed ( y , dataElement ) ) {
makeBlack ( getParent ( currentNode , dataElement ) , dataElement ) ;
makeBlack ( y , dataElement ) ;
makeRed ( getGrandParent ( currentNode , dataElement ) , dataElement ) ;
currentNode = getGrandParent ( currentNode , dataElement ) ;
} else {
if ( currentNode . isLeftChild ( dataElement ) ) {
currentNode = getParent ( currentNode , dataElement ) ;
rotateRight ( currentNode , dataElement ) ;
}
makeBlack ( getParent ( currentNode , dataElement ) , dataElement ) ;
makeRed ( getGrandParent ( currentNode , dataElement ) , dataElement ) ;
if ( getGrandParent ( currentNode , dataElement ) != null ) {
rotateLeft ( getGrandParent ( currentNode , dataElement ) , dataElement ) ;
}
}
}
}
makeBlack ( rootNode [ dataElement . ordinal () ] , dataElement ) ;
}
private void doRedBlackDelete ( final Node < K , V > deletedNode ) {
for ( final DataElement dataElement : DataElement . values () ) {
if ( deletedNode . getLeft ( dataElement ) != null && deletedNode . getRight ( dataElement ) != null ) {
swapPosition ( nextGreater ( deletedNode , dataElement ) , deletedNode , dataElement ) ;
}
final Node < K , V > replacement = deletedNode . getLeft ( dataElement ) != null ?
deletedNode . getLeft ( dataElement ) : deletedNode . getRight ( dataElement ) ;
if ( replacement != null ) {
replacement . setParent ( deletedNode . getParent ( dataElement ) , dataElement ) ;
if ( deletedNode . getParent ( dataElement ) == null ) {
rootNode [ dataElement . ordinal () ] = replacement ;
} else if ( deletedNode == deletedNode . getParent ( dataElement ) . getLeft ( dataElement ) ) {
deletedNode . getParent ( dataElement ) . setLeft ( replacement , dataElement ) ;
} else {
deletedNode . getParent ( dataElement ) . setRight ( replacement , dataElement ) ;
}
deletedNode . setLeft ( null , dataElement ) ;
deletedNode . setRight ( null , dataElement ) ;
deletedNode . setParent ( null , dataElement ) ;
if ( isBlack ( deletedNode , dataElement ) ) {
doRedBlackDeleteFixup ( replacement , dataElement ) ;
}
} else {
if ( deletedNode . getParent ( dataElement ) == null ) {
rootNode [ dataElement . ordinal () ] = null ;
} else {
if ( isBlack ( deletedNode , dataElement ) ) {
doRedBlackDeleteFixup ( deletedNode , dataElement ) ;
}
if ( deletedNode . getParent ( dataElement ) != null ) {
if ( deletedNode == deletedNode . getParent ( dataElement ) . getLeft ( dataElement ) ) {
deletedNode . getParent ( dataElement ) . setLeft ( null , dataElement ) ;
} else {
deletedNode . getParent ( dataElement ) . setRight ( null , dataElement ) ;
}
deletedNode . setParent ( null , dataElement ) ;
}
}
}
}
shrink () ;
}
private void doRedBlackDeleteFixup ( final Node < K , V > replacementNode , final DataElement dataElement ) {
Node < K , V > currentNode = replacementNode ;
while ( currentNode != rootNode [ dataElement . ordinal () ] && isBlack ( currentNode , dataElement ) ) {
if ( currentNode . isLeftChild ( dataElement ) ) {
Node < K , V > siblingNode = getRightChild ( getParent ( currentNode , dataElement ) , dataElement ) ;
if ( isRed ( siblingNode , dataElement ) ) {
makeBlack ( siblingNode , dataElement ) ;
makeRed ( getParent ( currentNode , dataElement ) , dataElement ) ;
rotateLeft ( getParent ( currentNode , dataElement ) , dataElement ) ;
siblingNode = getRightChild ( getParent ( currentNode , dataElement ) , dataElement ) ;
}
if ( isBlack ( getLeftChild ( siblingNode , dataElement ) , dataElement )
&& isBlack ( getRightChild ( siblingNode , dataElement ) , dataElement ) ) {
makeRed ( siblingNode , dataElement ) ;
currentNode = getParent ( currentNode , dataElement ) ;
} else {
if ( isBlack ( getRightChild ( siblingNode , dataElement ) , dataElement ) ) {
makeBlack ( getLeftChild ( siblingNode , dataElement ) , dataElement ) ;
makeRed ( siblingNode , dataElement ) ;
rotateRight ( siblingNode , dataElement ) ;
siblingNode = getRightChild ( getParent ( currentNode , dataElement ) , dataElement ) ;
}
copyColor ( getParent ( currentNode , dataElement ) , siblingNode , dataElement ) ;
makeBlack ( getParent ( currentNode , dataElement ) , dataElement ) ;
makeBlack ( getRightChild ( siblingNode , dataElement ) , dataElement ) ;
rotateLeft ( getParent ( currentNode , dataElement ) , dataElement ) ;
currentNode = rootNode [ dataElement . ordinal () ] ;
}
} else {
Node < K , V > siblingNode = getLeftChild ( getParent ( currentNode , dataElement ) , dataElement ) ;
if ( isRed ( siblingNode , dataElement ) ) {
makeBlack ( siblingNode , dataElement ) ;
makeRed ( getParent ( currentNode , dataElement ) , dataElement ) ;
rotateRight ( getParent ( currentNode , dataElement ) , dataElement ) ;
siblingNode = getLeftChild ( getParent ( currentNode , dataElement ) , dataElement ) ;
}
if ( isBlack ( getRightChild ( siblingNode , dataElement ) , dataElement )
&& isBlack ( getLeftChild ( siblingNode , dataElement ) , dataElement ) ) {
makeRed ( siblingNode , dataElement ) ;
currentNode = getParent ( currentNode , dataElement ) ;
} else {
if ( isBlack ( getLeftChild ( siblingNode , dataElement ) , dataElement ) ) {
makeBlack ( getRightChild ( siblingNode , dataElement ) , dataElement ) ;
makeRed ( siblingNode , dataElement ) ;
rotateLeft ( siblingNode , dataElement ) ;
siblingNode = getLeftChild ( getParent ( currentNode , dataElement ) , dataElement ) ;
}
copyColor ( getParent ( currentNode , dataElement ) , siblingNode , dataElement ) ;
makeBlack ( getParent ( currentNode , dataElement ) , dataElement ) ;
makeBlack ( getLeftChild ( siblingNode , dataElement ) , dataElement ) ;
rotateRight ( getParent ( currentNode , dataElement ) , dataElement ) ;
currentNode = rootNode [ dataElement . ordinal () ] ;
}
}
}
makeBlack ( currentNode , dataElement ) ;
}
private void swapPosition ( final Node < K , V > x , final Node < K , V > y , final DataElement dataElement ) {
final Node < K , V > xFormerParent = x . getParent ( dataElement ) ;
final Node < K , V > xFormerLeftChild = x . getLeft ( dataElement ) ;
final Node < K , V > xFormerRightChild = x . getRight ( dataElement ) ;
final Node < K , V > yFormerParent = y . getParent ( dataElement ) ;
final Node < K , V > yFormerLeftChild = y . getLeft ( dataElement ) ;
final Node < K , V > yFormerRightChild = y . getRight ( dataElement ) ;
final boolean xWasLeftChild =
x . getParent ( dataElement ) != null && x == x . getParent ( dataElement ) . getLeft ( dataElement ) ;
final boolean yWasLeftChild =
y . getParent ( dataElement ) != null && y == y . getParent ( dataElement ) . getLeft ( dataElement ) ;
if ( x == yFormerParent ) {
x . setParent ( y , dataElement ) ;
if ( yWasLeftChild ) {
y . setLeft ( x , dataElement ) ;
y . setRight ( xFormerRightChild , dataElement ) ;
} else {
y . setRight ( x , dataElement ) ;
y . setLeft ( xFormerLeftChild , dataElement ) ;
}
} else {
x . setParent ( yFormerParent , dataElement ) ;
if ( yFormerParent != null ) {
if ( yWasLeftChild ) {
yFormerParent . setLeft ( x , dataElement ) ;
} else {
yFormerParent . setRight ( x , dataElement ) ;
}
}
y . setLeft ( xFormerLeftChild , dataElement ) ;
y . setRight ( xFormerRightChild , dataElement ) ;
}
if ( y == xFormerParent ) {
y . setParent ( x , dataElement ) ;
if ( xWasLeftChild ) {
x . setLeft ( y , dataElement ) ;
x . setRight ( yFormerRightChild , dataElement ) ;
} else {
x . setRight ( y , dataElement ) ;
x . setLeft ( yFormerLeftChild , dataElement ) ;
}
} else {
y . setParent ( xFormerParent , dataElement ) ;
if ( xFormerParent != null ) {
if ( xWasLeftChild ) {
xFormerParent . setLeft ( y , dataElement ) ;
} else {
xFormerParent . setRight ( y , dataElement ) ;
}
}
x . setLeft ( yFormerLeftChild , dataElement ) ;
x . setRight ( yFormerRightChild , dataElement ) ;
}
if ( x . getLeft ( dataElement ) != null ) {
x . getLeft ( dataElement ) . setParent ( x , dataElement ) ;
}
if ( x . getRight ( dataElement ) != null ) {
x . getRight ( dataElement ) . setParent ( x , dataElement ) ;
}
if ( y . getLeft ( dataElement ) != null ) {
y . getLeft ( dataElement ) . setParent ( y , dataElement ) ;
}
if ( y . getRight ( dataElement ) != null ) {
y . getRight ( dataElement ) . setParent ( y , dataElement ) ;
}
x . swapColors ( y , dataElement ) ;
if ( rootNode [ dataElement . ordinal () ] == x ) {
rootNode [ dataElement . ordinal () ] = y ;
} else if ( rootNode [ dataElement . ordinal () ] == y ) {
rootNode [ dataElement . ordinal () ] = x ;
}
}
private static void checkNonNullComparable ( final Object obj , final DataElement dataElement ) {
Objects . requireNonNull ( obj , Objects . toString ( dataElement ) ) ;
if ( ! ( obj instanceof Comparable ) ) {
throw new ClassCastException ( dataElement + lr_5 ) ;
}
}
private static void checkKey ( final Object key ) {
checkNonNullComparable ( key , KEY ) ;
}
private static void checkValue ( final Object value ) {
checkNonNullComparable ( value , VALUE ) ;
}
private static void checkKeyAndValue ( final Object key , final Object value ) {
checkKey ( key ) ;
checkValue ( value ) ;
}
private void modify () {
modifications ++ ;
}
private void grow () {
modify () ;
nodeCount ++ ;
}
private void shrink () {
modify () ;
nodeCount -- ; MST[rv.UOI4Mutator]MSP[N]
}
private void insertValue ( final Node < K , V > newNode ) throws IllegalArgumentException {
Node < K , V > node = rootNode [ VALUE . ordinal () ] ;
while ( true ) {
final int cmp = compare ( newNode . getValue () , node . getValue () ) ;
if ( cmp == 0 ) {
throw new IllegalArgumentException (
lr_6 + newNode . getData ( VALUE ) + lr_3 ) ;
} else if ( cmp < 0 ) {
if ( node . getLeft ( VALUE ) != null ) {
node = node . getLeft ( VALUE ) ;
} else {
node . setLeft ( newNode , VALUE ) ;
newNode . setParent ( node , VALUE ) ;
doRedBlackInsert ( newNode , VALUE ) ;
break;
}
} else {
if ( node . getRight ( VALUE ) != null ) {
node = node . getRight ( VALUE ) ;
} else {
node . setRight ( newNode , VALUE ) ;
newNode . setParent ( node , VALUE ) ;
doRedBlackInsert ( newNode , VALUE ) ;
break;
}
}
}
}
private boolean doEquals ( final Object obj , final DataElement dataElement ) {
if ( obj == this ) {
return true ;
}
if ( obj instanceof Map == false ) {
return false ;
}
final Map < ? , ? > other = ( Map < ? , ? > ) obj ;
if ( other . size () != size () ) {
return false ;
}
if ( nodeCount > 0 ) {
try {
for ( final MapIterator < ? , ? > it = getMapIterator ( dataElement ) ; it . hasNext () ; ) {
final Object key = it . next () ;
final Object value = it . getValue () ;
if ( value . equals ( other . get ( key ) ) == false ) {
return false ;
}
}
} catch ( final ClassCastException ex ) {
return false ;
} catch ( final NullPointerException ex ) {
return false ;
}
}
return true ;
}
private int doHashCode ( final DataElement dataElement ) {
int total = 0 ;
if ( nodeCount > 0 ) {
for ( final MapIterator < ? , ? > it = getMapIterator ( dataElement ) ; it . hasNext () ; ) {
final Object key = it . next () ;
final Object value = it . getValue () ;
total += key . hashCode () ^ value . hashCode () ;
}
}
return total ;
}
private String doToString ( final DataElement dataElement ) {
if ( nodeCount == 0 ) {
return lr_7 ;
}
final StringBuilder buf = new StringBuilder ( nodeCount * 32 ) ;
buf . append ( '{' ) ;
final MapIterator < ? , ? > it = getMapIterator ( dataElement ) ;
boolean hasNext = it . hasNext () ;
while ( hasNext ) {
final Object key = it . next () ;
final Object value = it . getValue () ;
buf . append ( key == this ? lr_8 : key )
. append ( '=' )
. append ( value == this ? lr_8 : value ) ;
hasNext = it . hasNext () ;
if ( hasNext ) {
buf . append ( lr_9 ) ;
}
}
buf . append ( '}' ) ;
return buf . toString () ;
}
private MapIterator < ? , ? > getMapIterator ( final DataElement dataElement ) {
switch ( dataElement ) {
case KEY :
return new ViewMapIterator ( KEY ) ;
case VALUE :
return new InverseViewMapIterator ( VALUE ) ;
default:
throw new IllegalArgumentException () ;
}
}
@SuppressWarnings ( lr_4 )
private void readObject ( final ObjectInputStream stream ) throws IOException , ClassNotFoundException {
stream . defaultReadObject () ;
rootNode = new Node [ 2 ] ;
final int size = stream . readInt () ;
for ( int i = 0 ; i < size ; i ++ ) {
final K k = ( K ) stream . readObject () ;
final V v = ( V ) stream . readObject () ;
put ( k , v ) ;
}
}
private void writeObject ( final ObjectOutputStream stream ) throws IOException {
stream . defaultWriteObject () ;
stream . writeInt ( this . size () ) ;
for ( final Entry < K , V > entry : entrySet () ) {
stream . writeObject ( entry . getKey () ) ;
stream . writeObject ( entry . getValue () ) ;
}
}
@Override
public int size () {
return TreeBidiMap . this . size () ;
}
@Override
public void clear () {
TreeBidiMap . this . clear () ;
}
@Override
public Iterator < K > iterator () {
return new ViewMapIterator ( orderType ) ;
}
@Override
public boolean contains ( final Object obj ) {
checkNonNullComparable ( obj , KEY ) ;
return lookupKey ( obj ) != null ;
}
@Override
public boolean remove ( final Object o ) {
return doRemoveKey ( o ) != null ;
}
@Override
public Iterator < V > iterator () {
return new InverseViewMapIterator ( orderType ) ;
}
@Override
public boolean contains ( final Object obj ) {
checkNonNullComparable ( obj , VALUE ) ;
return lookupValue ( obj ) != null ;
}
@Override
public boolean remove ( final Object o ) {
return doRemoveValue ( o ) != null ;
}
@Override
public boolean contains ( final Object obj ) {
if ( obj instanceof Map . Entry == false ) {
return false ;
}
final Map . Entry < ? , ? > entry = ( Map . Entry < ? , ? > ) obj ;
final Object value = entry . getValue () ;
final Node < K , V > node = lookupKey ( entry . getKey () ) ;
return node != null && node . getValue () . equals ( value ) ;
}
@Override
public boolean remove ( final Object obj ) {
if ( obj instanceof Map . Entry == false ) {
return false ;
}
final Map . Entry < ? , ? > entry = ( Map . Entry < ? , ? > ) obj ;
final Object value = entry . getValue () ;
final Node < K , V > node = lookupKey ( entry . getKey () ) ;
if ( node != null && node . getValue () . equals ( value ) ) {
doRedBlackDelete ( node ) ;
return true ;
}
return false ;
}
@Override
public Iterator < Map . Entry < K , V > > iterator () {
return new ViewMapEntryIterator () ;
}
@Override
public boolean contains ( final Object obj ) {
if ( obj instanceof Map . Entry == false ) {
return false ;
}
final Map . Entry < ? , ? > entry = ( Map . Entry < ? , ? > ) obj ;
final Object value = entry . getValue () ;
final Node < K , V > node = lookupValue ( entry . getKey () ) ;
return node != null && node . getKey () . equals ( value ) ;
}
@Override
public boolean remove ( final Object obj ) {
if ( obj instanceof Map . Entry == false ) {
return false ;
}
final Map . Entry < ? , ? > entry = ( Map . Entry < ? , ? > ) obj ;
final Object value = entry . getValue () ;
final Node < K , V > node = lookupValue ( entry . getKey () ) ;
if ( node != null && node . getKey () . equals ( value ) ) {
doRedBlackDelete ( node ) ;
return true ;
}
return false ;
}
@Override
public Iterator < Map . Entry < V , K > > iterator () {
return new InverseViewMapEntryIterator () ;
}
public final boolean hasNext () {
return nextNode != null ;
}
protected Node < K , V > navigateNext () {
if ( nextNode == null ) {
throw new NoSuchElementException () ;
}
if ( modifications != expectedModifications ) {
throw new ConcurrentModificationException () ;
}
lastReturnedNode = nextNode ;
previousNode = nextNode ;
nextNode = nextGreater ( nextNode , orderType ) ;
return lastReturnedNode ;
}
public boolean hasPrevious () {
return previousNode != null ;
}
protected Node < K , V > navigatePrevious () {
if ( previousNode == null ) {
throw new NoSuchElementException () ;
}
if ( modifications != expectedModifications ) {
throw new ConcurrentModificationException () ;
}
nextNode = lastReturnedNode ;
if ( nextNode == null ) {
nextNode = nextGreater ( previousNode , orderType ) ;
}
lastReturnedNode = previousNode ;
previousNode = nextSmaller ( previousNode , orderType ) ;
return lastReturnedNode ;
}
public final void remove () {
if ( lastReturnedNode == null ) {
throw new IllegalStateException () ;
}
if ( modifications != expectedModifications ) {
throw new ConcurrentModificationException () ;
}
doRedBlackDelete ( lastReturnedNode ) ;
expectedModifications ++ ;
lastReturnedNode = null ;
if ( nextNode == null ) {
previousNode = greatestNode ( rootNode [ orderType . ordinal () ] , orderType ) ;
} else {
previousNode = nextSmaller ( nextNode , orderType ) ;
}
}
@Override
public K getKey () {
if ( lastReturnedNode == null ) {
throw new IllegalStateException (
lr_10 ) ;
}
return lastReturnedNode . getKey () ;
}
@Override
public V getValue () {
if ( lastReturnedNode == null ) {
throw new IllegalStateException (
lr_11 ) ;
}
return lastReturnedNode . getValue () ;
}
@Override
public V setValue ( final V obj ) {
throw new UnsupportedOperationException () ;
}
@Override
public K next () {
return navigateNext () . getKey () ;
}
@Override
public K previous () {
return navigatePrevious () . getKey () ;
}
@Override
public V getKey () {
if ( lastReturnedNode == null ) {
throw new IllegalStateException (
lr_10 ) ;
}
return lastReturnedNode . getValue () ;
}
@Override
public K getValue () {
if ( lastReturnedNode == null ) {
throw new IllegalStateException (
lr_11 ) ;
}
return lastReturnedNode . getKey () ;
}
@Override
public K setValue ( final K obj ) {
throw new UnsupportedOperationException () ;
}
@Override
public V next () {
return navigateNext () . getValue () ;
}
@Override
public V previous () {
return navigatePrevious () . getValue () ;
}
@Override
public Map . Entry < K , V > next () {
return navigateNext () ;
}
@Override
public Map . Entry < K , V > previous () {
return navigatePrevious () ;
}
@Override
public Map . Entry < V , K > next () {
return createEntry ( navigateNext () ) ;
}
@Override
public Map . Entry < V , K > previous () {
return createEntry ( navigatePrevious () ) ;
}
private Map . Entry < V , K > createEntry ( final Node < K , V > node ) {
return new UnmodifiableMapEntry <> ( node . getValue () , node . getKey () ) ;
}
private Object getData ( final DataElement dataElement ) {
switch ( dataElement ) {
case KEY :
return getKey () ;
case VALUE :
return getValue () ;
default:
throw new IllegalArgumentException () ;
}
}
private void setLeft ( final Node < K , V > node , final DataElement dataElement ) {
leftNode [ dataElement . ordinal () ] = node ;
}
private Node < K , V > getLeft ( final DataElement dataElement ) {
return leftNode [ dataElement . ordinal () ] ;
}
private void setRight ( final Node < K , V > node , final DataElement dataElement ) {
rightNode [ dataElement . ordinal () ] = node ;
}
private Node < K , V > getRight ( final DataElement dataElement ) {
return rightNode [ dataElement . ordinal () ] ;
}
private void setParent ( final Node < K , V > node , final DataElement dataElement ) {
parentNode [ dataElement . ordinal () ] = node ;
}
private Node < K , V > getParent ( final DataElement dataElement ) {
return parentNode [ dataElement . ordinal () ] ;
}
private void swapColors ( final Node < K , V > node , final DataElement dataElement ) {
blackColor [ dataElement . ordinal () ] ^= node . blackColor [ dataElement . ordinal () ] ;
node . blackColor [ dataElement . ordinal () ] ^= blackColor [ dataElement . ordinal () ] ;
blackColor [ dataElement . ordinal () ] ^= node . blackColor [ dataElement . ordinal () ] ;
}
private boolean isBlack ( final DataElement dataElement ) {
return blackColor [ dataElement . ordinal () ] ;
}
private boolean isRed ( final DataElement dataElement ) {
return ! blackColor [ dataElement . ordinal () ] ;
}
private void setBlack ( final DataElement dataElement ) {
blackColor [ dataElement . ordinal () ] = true ;
}
private void setRed ( final DataElement dataElement ) {
blackColor [ dataElement . ordinal () ] = false ;
}
private void copyColor ( final Node < K , V > node , final DataElement dataElement ) {
blackColor [ dataElement . ordinal () ] = node . blackColor [ dataElement . ordinal () ] ;
}
private boolean isLeftChild ( final DataElement dataElement ) {
return parentNode [ dataElement . ordinal () ] != null
&& parentNode [ dataElement . ordinal () ] . leftNode [ dataElement . ordinal () ] == this ;
}
private boolean isRightChild ( final DataElement dataElement ) {
return parentNode [ dataElement . ordinal () ] != null
&& parentNode [ dataElement . ordinal () ] . rightNode [ dataElement . ordinal () ] == this ;
}
@Override
public K getKey () {
return key ;
}
@Override
public V getValue () {
return value ;
}
@Override
public V setValue ( final V ignored ) throws UnsupportedOperationException {
throw new UnsupportedOperationException ( lr_12 ) ;
}
@Override
public boolean equals ( final Object obj ) {
if ( obj == this ) {
return true ;
}
if ( ! ( obj instanceof Map . Entry ) ) {
return false ;
}
final Map . Entry < ? , ? > e = ( Map . Entry < ? , ? > ) obj ;
return getKey () . equals ( e . getKey () ) && getValue () . equals ( e . getValue () ) ;
}
@Override
public int hashCode () {
if ( ! calculatedHashCode ) {
hashcodeValue = getKey () . hashCode () ^ getValue () . hashCode () ;
calculatedHashCode = true ;
}
return hashcodeValue ;
}
@Override
public int size () {
return TreeBidiMap . this . size () ;
}
@Override
public boolean isEmpty () {
return TreeBidiMap . this . isEmpty () ;
}
@Override
public K get ( final Object key ) {
return TreeBidiMap . this . getKey ( key ) ;
}
@Override
public V getKey ( final Object value ) {
return TreeBidiMap . this . get ( value ) ;
}
@Override
public boolean containsKey ( final Object key ) {
return TreeBidiMap . this . containsValue ( key ) ;
}
@Override
public boolean containsValue ( final Object value ) {
return TreeBidiMap . this . containsKey ( value ) ;
}
@Override
public V firstKey () {
if ( TreeBidiMap . this . nodeCount == 0 ) {
throw new NoSuchElementException ( lr_1 ) ;
}
return leastNode ( TreeBidiMap . this . rootNode [ VALUE . ordinal () ] , VALUE ) . getValue () ;
}
@Override
public V lastKey () {
if ( TreeBidiMap . this . nodeCount == 0 ) {
throw new NoSuchElementException ( lr_1 ) ;
}
return greatestNode ( TreeBidiMap . this . rootNode [ VALUE . ordinal () ] , VALUE ) . getValue () ;
}
@Override
public V nextKey ( final V key ) {
checkKey ( key ) ;
final Node < K , V > node = nextGreater ( TreeBidiMap . this . <V > lookup ( key , VALUE ) , VALUE ) ;
return node == null ? null : node . getValue () ;
}
@Override
public V previousKey ( final V key ) {
checkKey ( key ) ;
final Node < K , V > node = TreeBidiMap . this . nextSmaller ( TreeBidiMap . this . <V > lookup ( key , VALUE ) , VALUE ) ;
return node == null ? null : node . getValue () ;
}
@Override
public K put ( final V key , final K value ) {
final K result = get ( key ) ;
TreeBidiMap . this . doPut ( value , key ) ;
return result ;
}
@Override
public void putAll ( final Map < ? extends V , ? extends K > map ) {
for ( final Map . Entry < ? extends V , ? extends K > e : map . entrySet () ) {
put ( e . getKey () , e . getValue () ) ;
}
}
@Override
public K remove ( final Object key ) {
return TreeBidiMap . this . removeValue ( key ) ;
}
@Override
public V removeValue ( final Object value ) {
return TreeBidiMap . this . remove ( value ) ;
}
@Override
public void clear () {
TreeBidiMap . this . clear () ;
}
@Override
public Set < V > keySet () {
if ( inverseKeySet == null ) {
inverseKeySet = new ValueView ( VALUE ) ;
}
return inverseKeySet ;
}
@Override
public Set < K > values () {
if ( inverseValuesSet == null ) {
inverseValuesSet = new KeyView ( VALUE ) ;
}
return inverseValuesSet ;
}
@Override
public Set < Map . Entry < V , K > > entrySet () {
if ( inverseEntrySet == null ) {
inverseEntrySet = new InverseEntryView () ;
}
return inverseEntrySet ;
}
@Override
public OrderedMapIterator < V , K > mapIterator () {
if ( isEmpty () ) {
return EmptyOrderedMapIterator . <V , K > emptyOrderedMapIterator () ;
}
return new InverseViewMapIterator ( VALUE ) ;
}
@Override
public OrderedBidiMap < K , V > inverseBidiMap () {
return TreeBidiMap . this ;
}
@Override
public boolean equals ( final Object obj ) {
return TreeBidiMap . this . doEquals ( obj , DataElement . VALUE ) ;
}
@Override
public int hashCode () {
return TreeBidiMap . this . doHashCode ( DataElement . VALUE ) ;
}
@Override
public String toString () {
return TreeBidiMap . this . doToString ( DataElement . VALUE ) ;
}

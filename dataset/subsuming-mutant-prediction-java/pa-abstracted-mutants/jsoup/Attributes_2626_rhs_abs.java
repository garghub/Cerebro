private void checkCapacity ( int minNewSize ) {
Validate . isTrue ( minNewSize >= size ) ;
int curSize = keys . length ;
if ( curSize >= minNewSize )
return;
int newSize = curSize >= InitialCapacity ? size * GrowthFactor : InitialCapacity ;
if ( minNewSize > newSize )
newSize = minNewSize ;
keys = copyOf ( keys , newSize ) ;
vals = copyOf ( vals , newSize ) ;
}
private static String [] copyOf ( String [] orig , int size ) {
final String [] copy = new String [ size ] ;
System . arraycopy ( orig , 0 , copy , 0 ,
Math . min ( orig . length , size ) ) ;
return copy ;
}
int indexOfKey ( String key ) {
Validate . notNull ( key ) ;
for ( int i = 0 ; i < size ; i ++ ) {
if ( key . equals ( keys [ i ] ) )
return i ;
}
return NotFound ;
}
private int indexOfKeyIgnoreCase ( String key ) {
Validate . notNull ( key ) ;
for ( int i = 0 ; i < size ; i ++ ) {
if ( key . equalsIgnoreCase ( keys [ i ] ) )
return i ;
}
return NotFound ;
}
static String checkNotNull ( String val ) {
return val == null ? EmptyString : val ;
}
public String get ( String key ) {
int i = indexOfKey ( key ) ;
return i == NotFound ? EmptyString : checkNotNull ( vals [ i ] ) ;
}
public String getIgnoreCase ( String key ) {
int i = indexOfKeyIgnoreCase ( key ) ;
return i == NotFound ? EmptyString : checkNotNull ( vals [ i ] ) ;
}
public Attributes add ( String key , String value ) {
checkCapacity ( size + 1 ) ;
keys [ size ] = key ;
vals [ size ] = value ;
size ++ ;
return this ;
}
public Attributes put ( String key , String value ) {
Validate . notNull ( key ) ;
int i = indexOfKey ( key ) ;
if ( i != NotFound )
vals [ i ] = value ;
else
add ( key , value ) ;
return this ;
}
void putIgnoreCase ( String key , String value ) {
int i = indexOfKeyIgnoreCase ( key ) ;
if ( i != NotFound ) {
vals [ i ] = value ;
if ( ! keys [ i ] . equals ( key ) )
keys [ i ] = key ;
}
else
add ( key , value ) ;
}
public Attributes put ( String key , boolean value ) {
if ( value )
putIgnoreCase ( key , null ) ;
else
remove ( key ) ;
return this ;
}
public Attributes put ( Attribute attribute ) {
Validate . notNull ( attribute ) ;
put ( attribute . getKey () , attribute . getValue () ) ;
attribute . parent = this ;
return this ;
}
private void remove ( int index ) {
Validate . isFalse ( index >= size ) ;
int shifted = size - index - 1 ;
if ( shifted > 0 ) {
System . arraycopy ( keys , index + 1 , keys , index , shifted ) ;
System . arraycopy ( vals , index + 1 , vals , index , shifted ) ;
}
size -- ;
keys [ size ] = null ;
vals [ size ] = null ;
}
public void remove ( String key ) {
int i = indexOfKey ( key ) ;
if ( i != NotFound )
remove ( i ) ;
}
public void removeIgnoreCase ( String key ) {
int i = indexOfKeyIgnoreCase ( key ) ;
if ( i != NotFound )
remove ( i ) ;
}
public boolean hasKey ( String key ) {
return indexOfKey ( key ) != NotFound ;
}
public boolean hasKeyIgnoreCase ( String key ) {
return indexOfKeyIgnoreCase ( key ) != NotFound ;
}
public boolean hasDeclaredValueForKey ( String key ) {
int i = indexOfKey ( key ) ;
return i != NotFound && vals [ i ] != null ;
}
public boolean hasDeclaredValueForKeyIgnoreCase ( String key ) {
int i = indexOfKeyIgnoreCase ( key ) ;
return i != NotFound && vals [ i ] != null ;
}
public int size () {
int s = 0 ;
for ( int i = 0 ; i < size ; i ++ ) {
if ( ! isInternalKey ( keys [ i ] ) )
s ++ ;
}
return s ;
}
public boolean isEmpty () {
return size == 0 ;
}
public void addAll ( Attributes incoming ) {
if ( incoming . size () == 0 )
return;
checkCapacity ( size + incoming . size ) ;
for ( Attribute attr : incoming ) {
put ( attr ) ;
}
}
@Override
public boolean hasNext () {
while ( i < size ) {
if ( isInternalKey ( keys [ i ] ) )
i ++ ;
else
break;
}
return i < size ;
}
@Override
public Attribute next () {
final Attribute attr = new Attribute ( keys [ i ] , vals [ i ] , Attributes . this ) ;
i ++ ;
return attr ;
}
@Override
public void remove () {
Attributes . this . remove ( -- i ) ;
}
public List < Attribute > asList () {
ArrayList < Attribute > list = new ArrayList <> ( size ) ;
for ( int i = 0 ; i < size ; i ++ ) {
if ( isInternalKey ( keys [ i ] ) )
continue;
Attribute attr = new Attribute ( keys [ i ] , vals [ i ] , Attributes . this ) ;
list . add ( attr ) ;
}
return Collections . unmodifiableList ( list ) ;
}
public Map < String , String > dataset () {
return new Dataset ( this ) ;
}
public String html () {
StringBuilder sb = StringUtil . borrowBuilder () ;
try {
html ( sb , ( new Document ( lr_1 ) ) . outputSettings () ) ;
} catch ( IOException e ) {
throw new SerializationException ( e ) ;
}
return StringUtil . releaseBuilder ( sb ) ;
}
final void html ( final Appendable accum , final Document . OutputSettings out ) throws IOException {
final int sz = size ;
for ( int i = 0 ; i < sz ; i ++ ) {
if ( isInternalKey ( keys [ i ] ) )
continue;
final String key = keys [ i ] ;
final String val = vals [ i ] ;
accum . append ( ' ' ) . append ( key ) ;
if ( ! Attribute . shouldCollapseAttribute ( key , val , out ) ) {
accum . append ( lr_2 ) ;
Entities . escape ( accum , val == null ? EmptyString : val , out , true , false , false ) ;
accum . append ( '"' ) ;
}
}
}
@Override
public String toString () {
return html () ;
}
@Override
public boolean equals ( Object o ) {
if ( this == o ) return true ;
if ( o == null || getClass () != o . getClass () ) return false ;
Attributes that = ( Attributes ) o ;
if ( size != that . size ) return false ;
if ( ! Arrays . equals ( keys , that . keys ) ) return false ;
return Arrays . equals ( vals , that . vals ) ;
}
@Override
public int hashCode () {
int result = size ;
result = 31 * result + Arrays . hashCode ( keys ) ;
result = 31 * result + Arrays . hashCode ( vals ) ;
return result ;
}
@Override
public Attributes clone () {
Attributes clone ;
try {
clone = ( Attributes ) super . clone () ;
} catch ( CloneNotSupportedException e ) {
throw new RuntimeException ( e ) ;
}
clone . size = size ;
keys = copyOf ( keys , size ) ;
vals = copyOf ( vals , size ) ;
return clone ;
}
public void normalize () {
for ( int i = 0 ; i < size ; i ++ ) {
keys [ i ] = lowerCase ( keys [ i ] ) ;
}
}
public int deduplicate ( ParseSettings settings ) {
if ( isEmpty () )
return 0 ;
boolean preserve = settings . preserveAttributeCase () ;
int dupes = 0 ;
OUTER: for ( int i = 0 ; i < keys . length ; i ++ ) {
for ( int j = i + 1 ; j < keys . length ; j ++ ) {
if ( keys [ j ] == null )
continue OUTER;
if ( ( preserve && keys [ i ] . equals ( keys [ j ] ) ) || ( ! preserve && keys [ i ] . equalsIgnoreCase ( keys [ j ] ) ) ) {
dupes ++ ;
remove ( j ) ;
j -- ;
}
}
}
return dupes ;
}
@Override
public Set < Entry < String , String > > entrySet () {
return new EntrySet () ;
}
@Override
public String put ( String key , String value ) {
String dataKey = dataKey ( key ) ;
String oldValue = attributes . hasKey ( dataKey ) ? attributes . get ( dataKey ) : null ;
attributes . put ( dataKey , value ) ;
return oldValue ;
}
@Override
public Iterator < Map . Entry < String , String > > iterator () {
return new DatasetIterator () ; MST[ConstructorCallMutator]MSP[N]
}
@Override
public int size () {
int count = 0 ;
Iterator iter = new DatasetIterator () ;
while ( iter . hasNext () )
count ++ ;
return count ;
}
public boolean hasNext () {
while ( attrIter . hasNext () ) {
attr = attrIter . next () ;
if ( attr . isDataAttribute () ) return true ;
}
return false ;
}
public Entry < String , String > next () {
return new Attribute ( attr . getKey () . substring ( dataPrefix . length () ) , attr . getValue () ) ;
}
public void remove () {
attributes . remove ( attr . getKey () ) ;
}
private static String dataKey ( String key ) {
return dataPrefix + key ;
}
static String internalKey ( String key ) {
return InternalPrefix + key ;
}
private boolean isInternalKey ( String key ) {
return key != null && key . length () > 1 && key . charAt ( 0 ) == InternalPrefix ;
}

private static < K , R > R applyDefaultFunction ( final Map < ? super K , ? > map , final K key ,
final BiFunction < Map < ? super K , ? > , K , R > getFunction , final Function < K , R > defaultFunction ) {
return applyDefaultFunction ( map , key , getFunction , defaultFunction , null ) ;
}
private static < K , R > R applyDefaultFunction ( final Map < ? super K , ? > map , final K key ,
final BiFunction < Map < ? super K , ? > , K , R > getFunction , final Function < K , R > defaultFunction ,
final R defaultValue ) {
R value = map != null && getFunction != null ? getFunction . apply ( map , key ) : null ;
if ( value == null ) {
value = defaultFunction != null ? defaultFunction . apply ( key ) : null ;
}
return value != null ? value : defaultValue ;
}
private static < K , R > R applyDefaultValue ( final Map < ? super K , ? > map , final K key ,
final BiFunction < Map < ? super K , ? > , K , R > getFunction , final R defaultValue ) {
final R value = map != null && getFunction != null ? getFunction . apply ( map , key ) : null ;
return value == null ? defaultValue : value ;
}
public static void debugPrint ( final PrintStream out , final Object label , final Map < ? , ? > map ) {
verbosePrintInternal ( out , label , map , new ArrayDeque < Map < ? , ? > > () , true ) ;
}
public static < K , V > Map < K , V > emptyIfNull ( final Map < K , V > map ) {
return map == null ? Collections . <K , V > emptyMap () : map ;
}
public static < K , V > IterableMap < K , V > fixedSizeMap ( final Map < K , V > map ) {
return FixedSizeMap . fixedSizeMap ( map ) ;
}
public static < K , V > SortedMap < K , V > fixedSizeSortedMap ( final SortedMap < K , V > map ) {
return FixedSizeSortedMap . fixedSizeSortedMap ( map ) ;
}
public static < K > Boolean getBoolean ( final Map < ? super K , ? > map , final K key ) {
if ( map != null ) {
final Object answer = map . get ( key ) ;
if ( answer != null ) {
if ( answer instanceof Boolean ) {
return ( Boolean ) answer ;
}
if ( answer instanceof String ) {
return Boolean . valueOf ( ( String ) answer ) ;
}
if ( answer instanceof Number ) {
final Number n = ( Number ) answer ;
return n . intValue () != 0 ? Boolean . TRUE : Boolean . FALSE ;
}
}
}
return null ;
}
public static < K > Boolean getBoolean ( final Map < ? super K , ? > map , final K key , final Boolean defaultValue ) {
return applyDefaultValue ( map , key , MapUtils :: getBoolean , defaultValue ) ;
}
public static < K > Boolean getBoolean ( final Map < ? super K , ? > map , final K key ,
final Function < K , Boolean > defaultFunction ) {
return applyDefaultFunction ( map , key , MapUtils :: getBoolean , defaultFunction ) ;
}
public static < K > boolean getBooleanValue ( final Map < ? super K , ? > map , final K key ) {
return Boolean . TRUE . equals ( getBoolean ( map , key ) ) ;
}
public static < K > boolean getBooleanValue ( final Map < ? super K , ? > map , final K key , final boolean defaultValue ) {
return applyDefaultValue ( map , key , MapUtils :: getBoolean , defaultValue ) . booleanValue () ;
}
public static < K > boolean getBooleanValue ( final Map < ? super K , ? > map , final K key ,
final Function < K , Boolean > defaultFunction ) {
return applyDefaultFunction ( map , key , MapUtils :: getBoolean , defaultFunction , false ) . booleanValue () ;
}
public static < K > Byte getByte ( final Map < ? super K , ? > map , final K key ) {
final Number answer = getNumber ( map , key ) ;
if ( answer == null ) {
return null ;
}
if ( answer instanceof Byte ) {
return ( Byte ) answer ;
}
return Byte . valueOf ( answer . byteValue () ) ;
}
public static < K > Byte getByte ( final Map < ? super K , ? > map , final K key , final Byte defaultValue ) {
return applyDefaultValue ( map , key , MapUtils :: getByte , defaultValue ) ;
}
public static < K > Byte getByte ( final Map < ? super K , ? > map , final K key , final Function < K , Byte > defaultFunction ) {
return applyDefaultFunction ( map , key , MapUtils :: getByte , defaultFunction ) ;
}
public static < K > byte getByteValue ( final Map < ? super K , ? > map , final K key ) {
return applyDefaultValue ( map , key , MapUtils :: getByte , 0 ) . byteValue () ;
}
public static < K > byte getByteValue ( final Map < ? super K , ? > map , final K key , final byte defaultValue ) {
return applyDefaultValue ( map , key , MapUtils :: getByte , defaultValue ) . byteValue () ;
}
public static < K > byte getByteValue ( final Map < ? super K , ? > map , final K key ,
final Function < K , Byte > defaultFunction ) {
return applyDefaultFunction ( map , key , MapUtils :: getByte , defaultFunction , ( byte ) 0 ) . byteValue () ;
}
public static < K > Double getDouble ( final Map < ? super K , ? > map , final K key ) {
final Number answer = getNumber ( map , key ) ;
if ( answer == null ) {
return null ;
}
if ( answer instanceof Double ) {
return ( Double ) answer ;
}
return Double . valueOf ( answer . doubleValue () ) ;
}
public static < K > Double getDouble ( final Map < ? super K , ? > map , final K key , final Double defaultValue ) {
return applyDefaultValue ( map , key , MapUtils :: getDouble , defaultValue ) ;
}
public static < K > Double getDouble ( final Map < ? super K , ? > map , final K key ,
final Function < K , Double > defaultFunction ) {
return applyDefaultFunction ( map , key , MapUtils :: getDouble , defaultFunction ) ;
}
public static < K > double getDoubleValue ( final Map < ? super K , ? > map , final K key ) {
return applyDefaultValue ( map , key , MapUtils :: getDouble , 0d ) . doubleValue () ;
}
public static < K > double getDoubleValue ( final Map < ? super K , ? > map , final K key , final double defaultValue ) {
return applyDefaultValue ( map , key , MapUtils :: getDouble , defaultValue ) . doubleValue () ;
}
public static < K > double getDoubleValue ( final Map < ? super K , ? > map , final K key ,
final Function < K , Double > defaultFunction ) {
return applyDefaultFunction ( map , key , MapUtils :: getDouble , defaultFunction , 0d ) . doubleValue () ;
}
public static < K > Float getFloat ( final Map < ? super K , ? > map , final K key ) {
final Number answer = getNumber ( map , key ) ;
if ( answer == null ) {
return null ;
}
if ( answer instanceof Float ) {
return ( Float ) answer ;
}
return Float . valueOf ( answer . floatValue () ) ;
}
public static < K > Float getFloat ( final Map < ? super K , ? > map , final K key , final Float defaultValue ) {
return applyDefaultValue ( map , key , MapUtils :: getFloat , defaultValue ) ;
}
public static < K > Float getFloat ( final Map < ? super K , ? > map , final K key ,
final Function < K , Float > defaultFunction ) {
return applyDefaultFunction ( map , key , MapUtils :: getFloat , defaultFunction ) ;
}
public static < K > float getFloatValue ( final Map < ? super K , ? > map , final K key ) {
return applyDefaultValue ( map , key , MapUtils :: getFloat , 0f ) . floatValue () ;
}
public static < K > float getFloatValue ( final Map < ? super K , ? > map , final K key , final float defaultValue ) {
return applyDefaultValue ( map , key , MapUtils :: getFloat , defaultValue ) . floatValue () ;
}
public static < K > float getFloatValue ( final Map < ? super K , ? > map , final K key ,
final Function < K , Float > defaultFunction ) {
return applyDefaultFunction ( map , key , MapUtils :: getFloat , defaultFunction , 0f ) . floatValue () ;
}
public static < K > Integer getInteger ( final Map < ? super K , ? > map , final K key ) {
final Number answer = getNumber ( map , key ) ;
if ( answer == null ) {
return null ;
}
if ( answer instanceof Integer ) {
return ( Integer ) answer ;
}
return Integer . valueOf ( answer . intValue () ) ;
}
public static < K > Integer getInteger ( final Map < ? super K , ? > map , final K key ,
final Function < K , Integer > defaultFunction ) {
return applyDefaultFunction ( map , key , MapUtils :: getInteger , defaultFunction ) ;
}
public static < K > Integer getInteger ( final Map < ? super K , ? > map , final K key , final Integer defaultValue ) {
return applyDefaultValue ( map , key , MapUtils :: getInteger , defaultValue ) ;
}
public static < K > int getIntValue ( final Map < ? super K , ? > map , final K key ) {
return applyDefaultValue ( map , key , MapUtils :: getInteger , 0 ) . intValue () ;
}
public static < K > int getIntValue ( final Map < ? super K , ? > map , final K key ,
final Function < K , Integer > defaultFunction ) {
return applyDefaultFunction ( map , key , MapUtils :: getInteger , defaultFunction , 0 ) . byteValue () ;
}
public static < K > int getIntValue ( final Map < ? super K , ? > map , final K key , final int defaultValue ) {
return applyDefaultValue ( map , key , MapUtils :: getInteger , defaultValue ) . intValue () ;
}
public static < K > Long getLong ( final Map < ? super K , ? > map , final K key ) {
final Number answer = getNumber ( map , key ) ;
if ( answer == null ) {
return null ;
}
if ( answer instanceof Long ) {
return ( Long ) answer ;
}
return Long . valueOf ( answer . longValue () ) ;
}
public static < K > Long getLong ( final Map < ? super K , ? > map , final K key , final Function < K , Long > defaultFunction ) {
return applyDefaultFunction ( map , key , MapUtils :: getLong , defaultFunction ) ;
}
public static < K > Long getLong ( final Map < ? super K , ? > map , final K key , final Long defaultValue ) {
return applyDefaultValue ( map , key , MapUtils :: getLong , defaultValue ) ;
}
public static < K > long getLongValue ( final Map < ? super K , ? > map , final K key ) {
return applyDefaultValue ( map , key , MapUtils :: getLong , 0L ) . longValue () ;
}
public static < K > long getLongValue ( final Map < ? super K , ? > map , final K key ,
final Function < K , Long > defaultFunction ) {
return applyDefaultFunction ( map , key , MapUtils :: getLong , defaultFunction , 0L ) . byteValue () ; MST[NonVoidMethodCallMutator]MSP[S]
}
public static < K > long getLongValue ( final Map < ? super K , ? > map , final K key , final long defaultValue ) {
return applyDefaultValue ( map , key , MapUtils :: getLong , defaultValue ) . longValue () ;
}
public static < K > Map < ? , ? > getMap ( final Map < ? super K , ? > map , final K key ) {
if ( map != null ) {
final Object answer = map . get ( key ) ;
if ( answer != null && answer instanceof Map ) {
return ( Map < ? , ? > ) answer ;
}
}
return null ;
}
public static < K > Map < ? , ? > getMap ( final Map < ? super K , ? > map , final K key ,
final Function < K , Map < ? , ? > > defaultFunction ) {
return applyDefaultFunction ( map , key , MapUtils :: getMap , defaultFunction ) ;
}
public static < K > Map < ? , ? > getMap ( final Map < ? super K , ? > map , final K key , final Map < ? , ? > defaultValue ) {
return applyDefaultValue ( map , key , MapUtils :: getMap , defaultValue ) ;
}
public static < K > Number getNumber ( final Map < ? super K , ? > map , final K key ) {
if ( map != null ) {
final Object answer = map . get ( key ) ;
if ( answer != null ) {
if ( answer instanceof Number ) {
return ( Number ) answer ;
}
if ( answer instanceof String ) {
try {
final String text = ( String ) answer ;
return NumberFormat . getInstance () . parse ( text ) ;
} catch ( final ParseException e ) {
}
}
}
}
return null ;
}
public static < K > Number getNumber ( final Map < ? super K , ? > map , final K key ,
final Function < K , Number > defaultFunction ) {
return applyDefaultFunction ( map , key , MapUtils :: getNumber , defaultFunction ) ;
}
public static < K > Number getNumber ( final Map < ? super K , ? > map , final K key , final Number defaultValue ) {
return applyDefaultValue ( map , key , MapUtils :: getNumber , defaultValue ) ;
}
public static < K , V > V getObject ( final Map < ? super K , V > map , final K key ) {
if ( map != null ) {
return map . get ( key ) ;
}
return null ;
}
public static < K , V > V getObject ( final Map < K , V > map , final K key , final V defaultValue ) {
if ( map != null ) {
final V answer = map . get ( key ) ;
if ( answer != null ) {
return answer ;
}
}
return defaultValue ;
}
public static < K > Short getShort ( final Map < ? super K , ? > map , final K key ) {
final Number answer = getNumber ( map , key ) ;
if ( answer == null ) {
return null ;
}
if ( answer instanceof Short ) {
return ( Short ) answer ;
}
return Short . valueOf ( answer . shortValue () ) ;
}
public static < K > Short getShort ( final Map < ? super K , ? > map , final K key ,
final Function < K , Short > defaultFunction ) {
return applyDefaultFunction ( map , key , MapUtils :: getShort , defaultFunction ) ;
}
public static < K > Short getShort ( final Map < ? super K , ? > map , final K key , final Short defaultValue ) {
return applyDefaultValue ( map , key , MapUtils :: getShort , defaultValue ) ;
}
public static < K > short getShortValue ( final Map < ? super K , ? > map , final K key ) {
return applyDefaultValue ( map , key , MapUtils :: getShort , 0 ) . shortValue () ;
}
public static < K > short getShortValue ( final Map < ? super K , ? > map , final K key ,
final Function < K , Short > defaultFunction ) {
return applyDefaultFunction ( map , key , MapUtils :: getShort , defaultFunction , ( short ) 0 ) . shortValue () ;
}
public static < K > short getShortValue ( final Map < ? super K , ? > map , final K key , final short defaultValue ) {
return applyDefaultValue ( map , key , MapUtils :: getShort , defaultValue ) . shortValue () ;
}
public static < K > String getString ( final Map < ? super K , ? > map , final K key ) {
if ( map != null ) {
final Object answer = map . get ( key ) ;
if ( answer != null ) {
return answer . toString () ;
}
}
return null ;
}
public static < K > String getString ( final Map < ? super K , ? > map , final K key ,
final Function < K , String > defaultFunction ) {
return applyDefaultFunction ( map , key , MapUtils :: getString , defaultFunction ) ;
}
public static < K > String getString ( final Map < ? super K , ? > map , final K key , final String defaultValue ) {
return applyDefaultValue ( map , key , MapUtils :: getString , defaultValue ) ;
}
public static < K , V > Map < V , K > invertMap ( final Map < K , V > map ) {
final Map < V , K > out = new HashMap <> ( map . size () ) ;
for ( final Entry < K , V > entry : map . entrySet () ) {
out . put ( entry . getValue () , entry . getKey () ) ;
}
return out ;
}
public static boolean isEmpty ( final Map < ? , ? > map ) {
return map == null || map . isEmpty () ;
}
public static boolean isNotEmpty ( final Map < ? , ? > map ) {
return ! MapUtils . isEmpty ( map ) ;
}
public static < K , V > IterableMap < K , V > iterableMap ( final Map < K , V > map ) {
Objects . requireNonNull ( map , lr_1 ) ;
return map instanceof IterableMap ? ( IterableMap < K , V > ) map : new AbstractMapDecorator < K , V > ( map ) {
} ;
}
public static < K , V > IterableSortedMap < K , V > iterableSortedMap ( final SortedMap < K , V > sortedMap ) {
Objects . requireNonNull ( sortedMap , lr_2 ) ;
return sortedMap instanceof IterableSortedMap ? ( IterableSortedMap < K , V > ) sortedMap
: new AbstractSortedMapDecorator < K , V > ( sortedMap ) {
} ;
}
public static < K , V > IterableMap < K , V > lazyMap ( final Map < K , V > map , final Factory < ? extends V > factory ) {
return LazyMap . lazyMap ( map , factory ) ;
}
public static < K , V > IterableMap < K , V > lazyMap ( final Map < K , V > map ,
final Transformer < ? super K , ? extends V > transformerFactory ) {
return LazyMap . lazyMap ( map , transformerFactory ) ;
}
public static < K , V > SortedMap < K , V > lazySortedMap ( final SortedMap < K , V > map , final Factory < ? extends V > factory ) {
return LazySortedMap . lazySortedMap ( map , factory ) ;
}
public static < K , V > SortedMap < K , V > lazySortedMap ( final SortedMap < K , V > map ,
final Transformer < ? super K , ? extends V > transformerFactory ) {
return LazySortedMap . lazySortedMap ( map , transformerFactory ) ;
}
@Deprecated
public static < K , V > MultiValueMap < K , V > multiValueMap ( final Map < K , ? super Collection < V > > map ) {
return MultiValueMap . <K , V > multiValueMap ( map ) ;
}
@Deprecated
public static < K , V , C extends Collection < V > > MultiValueMap < K , V > multiValueMap ( final Map < K , C > map ,
final Class < C > collectionClass ) {
return MultiValueMap . multiValueMap ( map , collectionClass ) ;
}
@Deprecated
public static < K , V , C extends Collection < V > > MultiValueMap < K , V > multiValueMap ( final Map < K , C > map ,
final Factory < C > collectionFactory ) {
return MultiValueMap . multiValueMap ( map , collectionFactory ) ;
}
public static < K , V > OrderedMap < K , V > orderedMap ( final Map < K , V > map ) {
return ListOrderedMap . listOrderedMap ( map ) ;
}
public static < K , V , E > void populateMap ( final Map < K , V > map , final Iterable < ? extends E > elements ,
final Transformer < E , K > keyTransformer , final Transformer < E , V > valueTransformer ) {
final Iterator < ? extends E > iter = elements . iterator () ;
while ( iter . hasNext () ) {
final E temp = iter . next () ;
map . put ( keyTransformer . transform ( temp ) , valueTransformer . transform ( temp ) ) ;
}
}
public static < K , V > void populateMap ( final Map < K , V > map , final Iterable < ? extends V > elements ,
final Transformer < V , K > keyTransformer ) {
populateMap ( map , elements , keyTransformer , TransformerUtils . <V > nopTransformer () ) ;
}
public static < K , V , E > void populateMap ( final MultiMap < K , V > map , final Iterable < ? extends E > elements ,
final Transformer < E , K > keyTransformer , final Transformer < E , V > valueTransformer ) {
final Iterator < ? extends E > iter = elements . iterator () ;
while ( iter . hasNext () ) {
final E temp = iter . next () ;
map . put ( keyTransformer . transform ( temp ) , valueTransformer . transform ( temp ) ) ;
}
}
public static < K , V > void populateMap ( final MultiMap < K , V > map , final Iterable < ? extends V > elements ,
final Transformer < V , K > keyTransformer ) {
populateMap ( map , elements , keyTransformer , TransformerUtils . <V > nopTransformer () ) ;
}
public static < K , V > IterableMap < K , V > predicatedMap ( final Map < K , V > map , final Predicate < ? super K > keyPred ,
final Predicate < ? super V > valuePred ) {
return PredicatedMap . predicatedMap ( map , keyPred , valuePred ) ;
}
public static < K , V > SortedMap < K , V > predicatedSortedMap ( final SortedMap < K , V > map ,
final Predicate < ? super K > keyPred , final Predicate < ? super V > valuePred ) {
return PredicatedSortedMap . predicatedSortedMap ( map , keyPred , valuePred ) ;
}
private static void printIndent ( final PrintStream out , final int indent ) {
for ( int i = 0 ; i < indent ; i ++ ) {
out . print ( INDENT_STRING ) ;
}
}
@SuppressWarnings ( lr_3 )
public static < K , V > Map < K , V > putAll ( final Map < K , V > map , final Object [] array ) {
Objects . requireNonNull ( map , lr_1 ) ;
if ( array == null || array . length == 0 ) {
return map ;
}
final Object obj = array [ 0 ] ;
if ( obj instanceof Map . Entry ) {
for ( final Object element : array ) {
final Map . Entry < K , V > entry = ( Map . Entry < K , V > ) element ;
map . put ( entry . getKey () , entry . getValue () ) ;
}
} else if ( obj instanceof KeyValue ) {
for ( final Object element : array ) {
final KeyValue < K , V > keyval = ( KeyValue < K , V > ) element ;
map . put ( keyval . getKey () , keyval . getValue () ) ;
}
} else if ( obj instanceof Object [] ) {
for ( int i = 0 ; i < array . length ; i ++ ) {
final Object [] sub = ( Object [] ) array [ i ] ;
if ( sub == null || sub . length < 2 ) {
throw new IllegalArgumentException ( lr_4 + i ) ;
}
map . put ( ( K ) sub [ 0 ] , ( V ) sub [ 1 ] ) ;
}
} else {
for ( int i = 0 ; i < array . length - 1 ; ) {
map . put ( ( K ) array [ i ++ ] , ( V ) array [ i ++ ] ) ;
}
}
return map ;
}
public static < K > void safeAddToMap ( final Map < ? super K , Object > map , final K key , final Object value )
throws NullPointerException {
map . put ( key , value == null ? lr_5 : value ) ;
}
public static int size ( final Map < ? , ? > map ) {
return map == null ? 0 : map . size () ;
}
public static < K , V > Map < K , V > synchronizedMap ( final Map < K , V > map ) {
return Collections . synchronizedMap ( map ) ;
}
public static < K , V > SortedMap < K , V > synchronizedSortedMap ( final SortedMap < K , V > map ) {
return Collections . synchronizedSortedMap ( map ) ;
}
public static Map < String , Object > toMap ( final ResourceBundle resourceBundle ) {
final Enumeration < String > enumeration = resourceBundle . getKeys () ;
final Map < String , Object > map = new HashMap <> () ;
while ( enumeration . hasMoreElements () ) {
final String key = enumeration . nextElement () ;
final Object value = resourceBundle . getObject ( key ) ;
map . put ( key , value ) ;
}
return map ;
}
public static < K , V > Properties toProperties ( final Map < K , V > map ) {
final Properties answer = new Properties () ;
if ( map != null ) {
for ( final Entry < K , V > entry2 : map . entrySet () ) {
final Map . Entry < ? , ? > entry = entry2 ;
final Object key = entry . getKey () ;
final Object value = entry . getValue () ;
answer . put ( key , value ) ;
}
}
return answer ;
}
public static < K , V > IterableMap < K , V > transformedMap ( final Map < K , V > map ,
final Transformer < ? super K , ? extends K > keyTransformer ,
final Transformer < ? super V , ? extends V > valueTransformer ) {
return TransformedMap . transformingMap ( map , keyTransformer , valueTransformer ) ;
}
public static < K , V > SortedMap < K , V > transformedSortedMap ( final SortedMap < K , V > map ,
final Transformer < ? super K , ? extends K > keyTransformer ,
final Transformer < ? super V , ? extends V > valueTransformer ) {
return TransformedSortedMap . transformingSortedMap ( map , keyTransformer , valueTransformer ) ;
}
public static < K , V > Map < K , V > unmodifiableMap ( final Map < ? extends K , ? extends V > map ) {
return UnmodifiableMap . unmodifiableMap ( map ) ;
}
public static < K , V > SortedMap < K , V > unmodifiableSortedMap ( final SortedMap < K , ? extends V > map ) {
return UnmodifiableSortedMap . unmodifiableSortedMap ( map ) ;
}
public static void verbosePrint ( final PrintStream out , final Object label , final Map < ? , ? > map ) {
verbosePrintInternal ( out , label , map , new ArrayDeque < Map < ? , ? > > () , false ) ;
}
private static void verbosePrintInternal ( final PrintStream out , final Object label , final Map < ? , ? > map ,
final Deque < Map < ? , ? > > lineage , final boolean debug ) {
printIndent ( out , lineage . size () ) ;
if ( map == null ) {
if ( label != null ) {
out . print ( label ) ;
out . print ( lr_6 ) ;
}
out . println ( lr_7 ) ;
return;
}
if ( label != null ) {
out . print ( label ) ;
out . println ( lr_6 ) ;
}
printIndent ( out , lineage . size () ) ;
out . println ( lr_8 ) ;
lineage . addLast ( map ) ;
for ( final Map . Entry < ? , ? > entry : map . entrySet () ) {
final Object childKey = entry . getKey () ;
final Object childValue = entry . getValue () ;
if ( childValue instanceof Map && ! lineage . contains ( childValue ) ) {
verbosePrintInternal ( out , childKey == null ? lr_7 : childKey , ( Map < ? , ? > ) childValue , lineage , debug ) ;
} else {
printIndent ( out , lineage . size () ) ;
out . print ( childKey ) ;
out . print ( lr_6 ) ;
final int lineageIndex = IterableUtils . indexOf ( lineage , PredicateUtils . equalPredicate ( childValue ) ) ;
if ( lineageIndex == - 1 ) {
out . print ( childValue ) ;
} else if ( lineage . size () - 1 == lineageIndex ) {
out . print ( lr_9 ) ;
} else {
out . print ( lr_10 + ( lineage . size () - 1 - lineageIndex - 1 ) + lr_11 ) ;
}
if ( debug && childValue != null ) {
out . print ( ' ' ) ;
out . println ( childValue . getClass () . getName () ) ;
} else {
out . println () ;
}
}
}
lineage . removeLast () ;
printIndent ( out , lineage . size () ) ;
out . println ( debug ? lr_12 + map . getClass () . getName () : lr_13 ) ;
}

public static void isTrue ( final boolean expression , final String message , final long value ) {
if ( expression == false ) {
throw new IllegalArgumentException ( String . format ( message , Long . valueOf ( value ) ) ) ;
}
}
public static void isTrue ( final boolean expression , final String message , final double value ) {
if ( expression == false ) {
throw new IllegalArgumentException ( String . format ( message , Double . valueOf ( value ) ) ) ;
}
}
public static void isTrue ( final boolean expression , final String message , final Object ... values ) {
if ( expression == false ) {
throw new IllegalArgumentException ( String . format ( message , values ) ) ;
}
}
public static void isTrue ( final boolean expression ) {
if ( expression == false ) {
throw new IllegalArgumentException ( DEFAULT_IS_TRUE_EX_MESSAGE ) ;
}
}
public static < T > T notNull ( final T object ) {
return notNull ( object , DEFAULT_IS_NULL_EX_MESSAGE ) ;
}
public static < T > T notNull ( final T object , final String message , final Object ... values ) {
if ( object == null ) {
throw new NullPointerException ( String . format ( message , values ) ) ;
}
return object ;
}
public static < T > T [] notEmpty ( final T [] array , final String message , final Object ... values ) {
if ( array == null ) {
throw new NullPointerException ( String . format ( message , values ) ) ;
}
if ( array . length == 0 ) {
throw new IllegalArgumentException ( String . format ( message , values ) ) ;
}
return array ;
}
public static < T > T [] notEmpty ( final T [] array ) {
return notEmpty ( array , DEFAULT_NOT_EMPTY_ARRAY_EX_MESSAGE ) ;
}
public static < T extends Collection < ? > > T notEmpty ( final T collection , final String message , final Object ... values ) {
if ( collection == null ) {
throw new NullPointerException ( String . format ( message , values ) ) ;
}
if ( collection . isEmpty () ) {
throw new IllegalArgumentException ( String . format ( message , values ) ) ;
}
return collection ;
}
public static < T extends Collection < ? > > T notEmpty ( final T collection ) {
return notEmpty ( collection , DEFAULT_NOT_EMPTY_COLLECTION_EX_MESSAGE ) ;
}
public static < T extends Map < ? , ? > > T notEmpty ( final T map , final String message , final Object ... values ) {
if ( map == null ) {
throw new NullPointerException ( String . format ( message , values ) ) ;
}
if ( map . isEmpty () ) {
throw new IllegalArgumentException ( String . format ( message , values ) ) ;
}
return map ;
}
public static < T extends Map < ? , ? > > T notEmpty ( final T map ) {
return notEmpty ( map , DEFAULT_NOT_EMPTY_MAP_EX_MESSAGE ) ;
}
public static < T extends CharSequence > T notEmpty ( final T chars , final String message , final Object ... values ) {
if ( chars == null ) {
throw new NullPointerException ( String . format ( message , values ) ) ;
}
if ( chars . length () == 0 ) {
throw new IllegalArgumentException ( String . format ( message , values ) ) ;
}
return chars ;
}
public static < T extends CharSequence > T notEmpty ( final T chars ) {
return notEmpty ( chars , DEFAULT_NOT_EMPTY_CHAR_SEQUENCE_EX_MESSAGE ) ;
}
public static < T extends CharSequence > T notBlank ( final T chars , final String message , final Object ... values ) {
if ( chars == null ) {
throw new NullPointerException ( String . format ( message , values ) ) ;
}
if ( StringUtils . isBlank ( chars ) ) {
throw new IllegalArgumentException ( String . format ( message , values ) ) ;
}
return chars ;
}
public static < T extends CharSequence > T notBlank ( final T chars ) {
return notBlank ( chars , DEFAULT_NOT_BLANK_EX_MESSAGE ) ;
}
public static < T > T [] noNullElements ( final T [] array , final String message , final Object ... values ) {
Validate . notNull ( array ) ;
for ( int i = 0 ; i < array . length ; i ++ ) {
if ( array [ i ] == null ) {
final Object [] values2 = ArrayUtils . add ( values , Integer . valueOf ( i ) ) ;
throw new IllegalArgumentException ( String . format ( message , values2 ) ) ;
}
}
return array ;
}
public static < T > T [] noNullElements ( final T [] array ) {
return noNullElements ( array , DEFAULT_NO_NULL_ELEMENTS_ARRAY_EX_MESSAGE ) ;
}
public static < T extends Iterable < ? > > T noNullElements ( final T iterable , final String message , final Object ... values ) {
Validate . notNull ( iterable ) ;
int i = 0 ;
for ( final Iterator < ? > it = iterable . iterator () ; it . hasNext () ; i ++ ) {
if ( it . next () == null ) {
final Object [] values2 = ArrayUtils . addAll ( values , Integer . valueOf ( i ) ) ;
throw new IllegalArgumentException ( String . format ( message , values2 ) ) ;
}
}
return iterable ;
}
public static < T extends Iterable < ? > > T noNullElements ( final T iterable ) {
return noNullElements ( iterable , DEFAULT_NO_NULL_ELEMENTS_COLLECTION_EX_MESSAGE ) ;
}
public static < T > T [] validIndex ( final T [] array , final int index , final String message , final Object ... values ) {
Validate . notNull ( array ) ;
if ( index < 0 || index >= array . length ) {
throw new IndexOutOfBoundsException ( String . format ( message , values ) ) ;
}
return array ;
}
public static < T > T [] validIndex ( final T [] array , final int index ) {
return validIndex ( array , index , DEFAULT_VALID_INDEX_ARRAY_EX_MESSAGE , Integer . valueOf ( index ) ) ;
}
public static < T extends Collection < ? > > T validIndex ( final T collection , final int index , final String message , final Object ... values ) {
Validate . notNull ( collection ) ;
if ( index < 0 || index >= collection . size () ) {
throw new IndexOutOfBoundsException ( String . format ( message , values ) ) ;
}
return collection ;
}
public static < T extends Collection < ? > > T validIndex ( final T collection , final int index ) {
return validIndex ( collection , index , DEFAULT_VALID_INDEX_COLLECTION_EX_MESSAGE , Integer . valueOf ( index ) ) ;
}
public static < T extends CharSequence > T validIndex ( final T chars , final int index , final String message , final Object ... values ) {
Validate . notNull ( chars ) ;
if ( index < 0 || index >= chars . length () ) {
throw new IndexOutOfBoundsException ( String . format ( message , values ) ) ;
}
return chars ;
}
public static < T extends CharSequence > T validIndex ( final T chars , final int index ) {
return validIndex ( chars , index , DEFAULT_VALID_INDEX_CHAR_SEQUENCE_EX_MESSAGE , Integer . valueOf ( index ) ) ;
}
public static void validState ( final boolean expression ) {
if ( expression == false ) {
throw new IllegalStateException ( DEFAULT_VALID_STATE_EX_MESSAGE ) ;
}
}
public static void validState ( final boolean expression , final String message , final Object ... values ) {
if ( expression == false ) {
throw new IllegalStateException ( String . format ( message , values ) ) ;
}
}
public static void matchesPattern ( final CharSequence input , final String pattern ) {
if ( Pattern . matches ( pattern , input ) == false ) {
throw new IllegalArgumentException ( String . format ( DEFAULT_MATCHES_PATTERN_EX , input , pattern ) ) ;
}
}
public static void matchesPattern ( final CharSequence input , final String pattern , final String message , final Object ... values ) {
if ( Pattern . matches ( pattern , input ) == false ) {
throw new IllegalArgumentException ( String . format ( message , values ) ) ;
}
}
public static < T > void inclusiveBetween ( final T start , final T end , final Comparable < T > value ) {
if ( value . compareTo ( start ) < 0 || value . compareTo ( end ) > 0 ) {
throw new IllegalArgumentException ( String . format ( DEFAULT_INCLUSIVE_BETWEEN_EX_MESSAGE , value , start , end ) ) ;
}
}
public static < T > void inclusiveBetween ( final T start , final T end , final Comparable < T > value , final String message , final Object ... values ) {
if ( value . compareTo ( start ) < 0 || value . compareTo ( end ) > 0 ) {
throw new IllegalArgumentException ( String . format ( message , values ) ) ;
}
}
@SuppressWarnings ( lr_1 )
public static void inclusiveBetween ( final long start , final long end , final long value ) {
if ( value < start || value > end ) {
throw new IllegalArgumentException ( String . format ( DEFAULT_INCLUSIVE_BETWEEN_EX_MESSAGE , value , start , end ) ) ;
}
}
public static void inclusiveBetween ( final long start , final long end , final long value , final String message ) {
if ( value < start || value > end ) {
throw new IllegalArgumentException ( String . format ( message ) ) ;
}
}
@SuppressWarnings ( lr_1 )
public static void inclusiveBetween ( final double start , final double end , final double value ) {
if ( value < start || value > end ) {
throw new IllegalArgumentException ( String . format ( DEFAULT_INCLUSIVE_BETWEEN_EX_MESSAGE , value , start , end ) ) ;
}
}
public static void inclusiveBetween ( final double start , final double end , final double value , final String message ) {
if ( value < start || value > end ) {
throw new IllegalArgumentException ( String . format ( message ) ) ;
}
}
public static < T > void exclusiveBetween ( final T start , final T end , final Comparable < T > value ) {
if ( value . compareTo ( start ) <= 0 || value . compareTo ( end ) >= 0 ) {
throw new IllegalArgumentException ( String . format ( DEFAULT_EXCLUSIVE_BETWEEN_EX_MESSAGE , value , start , end ) ) ;
}
}
public static < T > void exclusiveBetween ( final T start , final T end , final Comparable < T > value , final String message , final Object ... values ) {
if ( value . compareTo ( start ) <= 0 || value . compareTo ( end ) >= 0 ) {
throw new IllegalArgumentException ( String . format ( message , values ) ) ;
}
}
@SuppressWarnings ( lr_1 )
public static void exclusiveBetween ( final long start , final long end , final long value ) {
if ( value <= start || value >= end ) {
throw new IllegalArgumentException ( String . format ( DEFAULT_EXCLUSIVE_BETWEEN_EX_MESSAGE , value , start , end ) ) ;
}
}
public static void exclusiveBetween ( final long start , final long end , final long value , final String message ) {
if ( value <= start || value >= end ) {
throw new IllegalArgumentException ( String . format ( message ) ) ;
}
}
@SuppressWarnings ( lr_1 )
public static void exclusiveBetween ( final double start , final double end , final double value ) {
if ( value <= start || value >= end ) {
throw new IllegalArgumentException ( String . format ( DEFAULT_EXCLUSIVE_BETWEEN_EX_MESSAGE , value , start , end ) ) ;
}
}
public static void exclusiveBetween ( final double start , final double end , final double value , final String message ) {
if ( value <= start || value >= end ) {
throw new IllegalArgumentException ( String . format ( message ) ) ;
}
}
public static void isInstanceOf ( final Class < ? > type , final Object obj ) {
if ( type . isInstance ( obj ) == false ) {
throw new IllegalArgumentException ( String . format ( DEFAULT_IS_INSTANCE_OF_EX_MESSAGE , type . getName () ,
obj == null ? lr_2 : obj . getClass () . getName () ) ) ;
}
}
public static void isInstanceOf ( final Class < ? > type , final Object obj , final String message , final Object ... values ) {
if ( type . isInstance ( obj ) == false ) {
throw new IllegalArgumentException ( String . format ( message , values ) ) ;
}
}
public static void isAssignableFrom ( final Class < ? > superType , final Class < ? > type ) {
if ( superType . isAssignableFrom ( type ) == false ) {
throw new IllegalArgumentException ( String . format ( DEFAULT_IS_ASSIGNABLE_EX_MESSAGE , type == null ? lr_2 : type . getName () ,
superType . getName () ) ) ;
}
}
public static void isAssignableFrom ( final Class < ? > superType , final Class < ? > type , final String message , final Object ... values ) {
if ( superType . isAssignableFrom ( type ) == false ) {
throw new IllegalArgumentException ( String . format ( message , values ) ) ;
}
}

public static < T > T defaultIfNull ( final T object , final T defaultValue ) {
return object != null ? object : defaultValue ;
}
public static < T > T firstNonNull ( final T ... values ) {
if ( values != null ) {
for ( final T val : values ) {
if ( val != null ) {
return val ;
}
}
}
return null ;
}
@Deprecated
public static boolean equals ( final Object object1 , final Object object2 ) {
if ( object1 == object2 ) {
return true ;
}
if ( object1 == null || object2 == null ) {
return false ;
}
return object1 . equals ( object2 ) ;
}
public static boolean notEqual ( final Object object1 , final Object object2 ) {
return ObjectUtils . equals ( object1 , object2 ) == false ;
}
@Deprecated
public static int hashCode ( final Object obj ) {
return obj == null ? 0 : obj . hashCode () ;
}
@Deprecated
public static int hashCodeMulti ( final Object ... objects ) {
int hash = 1 ;
if ( objects != null ) {
for ( final Object object : objects ) {
final int tmpHash = ObjectUtils . hashCode ( object ) ;
hash = hash * 31 + tmpHash ;
}
}
return hash ;
}
public static String identityToString ( final Object object ) {
if ( object == null ) {
return null ;
}
final StringBuilder builder = new StringBuilder () ;
identityToString ( builder , object ) ;
return builder . toString () ;
}
public static void identityToString ( final Appendable appendable , final Object object ) throws IOException {
if ( object == null ) {
throw new NullPointerException ( lr_1 ) ;
}
appendable . append ( object . getClass () . getName () )
. append ( '@' )
. append ( Integer . toHexString ( System . identityHashCode ( object ) ) ) ;
}
public static void identityToString ( final StrBuilder builder , final Object object ) {
if ( object == null ) {
throw new NullPointerException ( lr_1 ) ;
}
builder . append ( object . getClass () . getName () )
. append ( '@' )
. append ( Integer . toHexString ( System . identityHashCode ( object ) ) ) ;
}
public static void identityToString ( final StringBuffer buffer , final Object object ) {
if ( object == null ) {
throw new NullPointerException ( lr_1 ) ;
}
buffer . append ( object . getClass () . getName () )
. append ( '@' )
. append ( Integer . toHexString ( System . identityHashCode ( object ) ) ) ;
}
public static void identityToString ( final StringBuilder builder , final Object object ) {
if ( object == null ) {
throw new NullPointerException ( lr_1 ) ;
}
builder . append ( object . getClass () . getName () )
. append ( '@' )
. append ( Integer . toHexString ( System . identityHashCode ( object ) ) ) ;
}
@Deprecated
public static String toString ( final Object obj ) {
return obj == null ? lr_2 : obj . toString () ;
}
@Deprecated
public static String toString ( final Object obj , final String nullStr ) {
return obj == null ? nullStr : obj . toString () ;
}
public static < T extends Comparable < ? super T > > T min ( final T ... values ) {
T result = null ;
if ( values != null ) {
for ( final T value : values ) {
if ( compare ( value , result , true ) < 0 ) {
result = value ;
}
}
}
return result ;
}
public static < T extends Comparable < ? super T > > T max ( final T ... values ) {
T result = null ;
if ( values != null ) {
for ( final T value : values ) {
if ( compare ( value , result , false ) > 0 ) {
result = value ;
}
}
}
return result ;
}
public static < T extends Comparable < ? super T > > int compare ( final T c1 , final T c2 ) {
return compare ( c1 , c2 , false ) ;
}
public static < T extends Comparable < ? super T > > int compare ( final T c1 , final T c2 , final boolean nullGreater ) {
if ( c1 == c2 ) {
return 0 ;
} else if ( c1 == null ) {
return nullGreater ? 1 : - 1 ;
} else if ( c2 == null ) {
return nullGreater ? - 1 : 1 ;
}
return c1 . compareTo ( c2 ) ;
}
public static < T extends Comparable < ? super T > > T median ( final T ... items ) {
Validate . notEmpty ( items ) ;
Validate . noNullElements ( items ) ;
final TreeSet < T > sort = new TreeSet < T > () ;
Collections . addAll ( sort , items ) ;
@SuppressWarnings ( lr_3 )
final
T result = ( T ) sort . toArray () [ ( sort . size () - 1 ) / 2 ] ;
return result ;
}
public static < T > T median ( final Comparator < T > comparator , final T ... items ) {
Validate . notEmpty ( items , lr_4 ) ;
Validate . noNullElements ( items ) ;
Validate . notNull ( comparator , lr_5 ) ;
final TreeSet < T > sort = new TreeSet < T > ( comparator ) ;
Collections . addAll ( sort , items ) ;
@SuppressWarnings ( lr_3 )
final
T result = ( T ) sort . toArray () [ ( sort . size () - 1 ) / 2 ] ;
return result ;
}
public static < T > T mode ( final T ... items ) {
if ( ArrayUtils . isNotEmpty ( items ) ) {
final HashMap < T , MutableInt > occurrences = new HashMap < T , MutableInt > ( items . length ) ;
for ( final T t : items ) {
final MutableInt count = occurrences . get ( t ) ;
if ( count == null ) {
occurrences . put ( t , new MutableInt ( 1 ) ) ;
} else {
count . increment () ;
}
}
T result = null ;
int max = 0 ;
for ( final Map . Entry < T , MutableInt > e : occurrences . entrySet () ) {
final int cmp = e . getValue () . intValue () ;
if ( cmp == max ) {
result = null ;
} else if ( cmp > max ) {
max = cmp ;
result = e . getKey () ;
}
}
return result ;
}
return null ;
}
public static < T > T clone ( final T obj ) {
if ( obj instanceof Cloneable ) {
final Object result ;
if ( obj . getClass () . isArray () ) {
final Class < ? > componentType = obj . getClass () . getComponentType () ;
if ( ! componentType . isPrimitive () ) {
result = ( ( Object [] ) obj ) . clone () ;
} else {
int length = Array . getLength ( obj ) ;
result = Array . newInstance ( componentType , length ) ;
while ( length -- > 0 ) {
Array . set ( result , length , Array . get ( obj , length ) ) ;
}
}
} else {
try {
final Method clone = obj . getClass () . getMethod ( lr_6 ) ;
result = clone . invoke ( obj ) ;
} catch ( final NoSuchMethodException e ) {
throw new CloneFailedException ( lr_7
+ obj . getClass () . getName ()
+ lr_8 , e ) ;
} catch ( final IllegalAccessException e ) {
throw new CloneFailedException ( lr_9
+ obj . getClass () . getName () , e ) ;
} catch ( final InvocationTargetException e ) {
throw new CloneFailedException ( lr_10
+ obj . getClass () . getName () , e . getCause () ) ;
}
}
@SuppressWarnings ( lr_3 )
final T checked = ( T ) result ;
return checked ;
}
return null ;
}
public static < T > T cloneIfPossible ( final T obj ) {
final T clone = clone ( obj ) ;
return clone == null ? obj : clone ;
}
private Object readResolve () {
return ObjectUtils . NULL ;
}
public static boolean CONST ( final boolean v ) { return v ; }
public static byte CONST ( final byte v ) { return v ; }
public static byte CONST_BYTE ( final int v ) throws IllegalArgumentException {
if ( v < Byte . MIN_VALUE || v > Byte . MAX_VALUE ) {
throw new IllegalArgumentException ( lr_11 + v + lr_12 ) ;
}
return ( byte ) v ;
}
public static char CONST ( final char v ) { return v ; }
public static short CONST ( final short v ) { return v ; }
public static short CONST_SHORT ( final int v ) throws IllegalArgumentException {
if ( v < Short . MIN_VALUE || v > Short . MAX_VALUE ) {
throw new IllegalArgumentException ( lr_13 + v + lr_12 ) ;
}
return ( short ) v ;
}
public static int CONST ( final int v ) { return v ; }
public static long CONST ( final long v ) { return v ; }
public static float CONST ( final float v ) { return v ; }
public static double CONST ( final double v ) { return v ; }
public static < T > T CONST ( final T v ) { return v ; }

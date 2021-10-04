static Set < IDKey > getRegistry () {
return REGISTRY . get () ;
}
static boolean isRegistered ( final Object value ) {
final Set < IDKey > registry = getRegistry () ;
return registry != null && registry . contains ( new IDKey ( value ) ) ;
}
private static void reflectionAppend ( final Object object , final Class < ? > clazz , final HashCodeBuilder builder , final boolean useTransients ,
final String [] excludeFields ) {
if ( isRegistered ( object ) ) {
return;
}
try {
register ( object ) ;
final Field [] fields = clazz . getDeclaredFields () ;
AccessibleObject . setAccessible ( fields , true ) ;
for ( final Field field : fields ) {
if ( ! ArrayUtils . contains ( excludeFields , field . getName () )
&& ! field . getName () . contains ( lr_1 )
&& ( useTransients || ! Modifier . isTransient ( field . getModifiers () ) )
&& ( ! Modifier . isStatic ( field . getModifiers () ) )
&& ( ! field . isAnnotationPresent ( HashCodeExclude . class ) ) ) {
try {
final Object fieldValue = field . get ( object ) ;
builder . append ( fieldValue ) ;
} catch ( final IllegalAccessException e ) {
throw new InternalError ( lr_2 ) ;
}
}
}
} finally {
unregister ( object ) ;
}
}
public static int reflectionHashCode ( final int initialNonZeroOddNumber , final int multiplierNonZeroOddNumber , final Object object ) {
return reflectionHashCode ( initialNonZeroOddNumber , multiplierNonZeroOddNumber , object , false , null ) ;
}
public static int reflectionHashCode ( final int initialNonZeroOddNumber , final int multiplierNonZeroOddNumber , final Object object ,
final boolean testTransients ) {
return reflectionHashCode ( initialNonZeroOddNumber , multiplierNonZeroOddNumber , object , testTransients , null ) ;
}
public static < T > int reflectionHashCode ( final int initialNonZeroOddNumber , final int multiplierNonZeroOddNumber , final T object ,
final boolean testTransients , final Class < ? super T > reflectUpToClass , final String ... excludeFields ) {
if ( object == null ) {
throw new IllegalArgumentException ( lr_3 ) ;
}
final HashCodeBuilder builder = new HashCodeBuilder ( initialNonZeroOddNumber , multiplierNonZeroOddNumber ) ;
Class < ? > clazz = object . getClass () ;
reflectionAppend ( object , clazz , builder , testTransients , excludeFields ) ;
while ( clazz . getSuperclass () != null && clazz != reflectUpToClass ) {
clazz = clazz . getSuperclass () ;
reflectionAppend ( object , clazz , builder , testTransients , excludeFields ) ;
}
return builder . toHashCode () ;
}
public static int reflectionHashCode ( final Object object , final boolean testTransients ) {
return reflectionHashCode ( DEFAULT_INITIAL_VALUE , DEFAULT_MULTIPLIER_VALUE , object ,
testTransients , null ) ;
}
public static int reflectionHashCode ( final Object object , final Collection < String > excludeFields ) {
return reflectionHashCode ( object , ReflectionToStringBuilder . toNoNullStringArray ( excludeFields ) ) ;
}
public static int reflectionHashCode ( final Object object , final String ... excludeFields ) {
return reflectionHashCode ( DEFAULT_INITIAL_VALUE , DEFAULT_MULTIPLIER_VALUE , object , false ,
null , excludeFields ) ;
}
static void register ( final Object value ) {
synchronized ( HashCodeBuilder . class ) {
if ( getRegistry () == null ) {
REGISTRY . set ( new HashSet < IDKey > () ) ;
}
}
getRegistry () . add ( new IDKey ( value ) ) ;
}
static void unregister ( final Object value ) {
Set < IDKey > registry = getRegistry () ;
if ( registry != null ) {
registry . remove ( new IDKey ( value ) ) ;
synchronized ( HashCodeBuilder . class ) {
registry = getRegistry () ;
if ( registry != null && registry . isEmpty () ) {
REGISTRY . remove () ;
}
}
}
}
public HashCodeBuilder append ( final boolean value ) {
iTotal = iTotal * iConstant + ( value ? 0 : 1 ) ;
return this ;
}
public HashCodeBuilder append ( final boolean [] array ) {
if ( array == null ) {
iTotal = iTotal * iConstant ;
} else {
for ( final boolean element : array ) {
append ( element ) ;
}
}
return this ;
}
public HashCodeBuilder append ( final byte value ) {
iTotal = iTotal * iConstant + value ;
return this ;
}
public HashCodeBuilder append ( final byte [] array ) {
if ( array == null ) {
iTotal = iTotal * iConstant ;
} else {
for ( final byte element : array ) {
append ( element ) ;
}
}
return this ;
}
public HashCodeBuilder append ( final char value ) {
iTotal = iTotal * iConstant + value ;
return this ;
}
public HashCodeBuilder append ( final char [] array ) {
if ( array == null ) {
iTotal = iTotal * iConstant ;
} else {
for ( final char element : array ) {
append ( element ) ;
}
}
return this ;
}
public HashCodeBuilder append ( final double value ) {
return append ( Double . doubleToLongBits ( value ) ) ;
}
public HashCodeBuilder append ( final double [] array ) {
if ( array == null ) {
iTotal = iTotal * iConstant ;
} else {
for ( final double element : array ) {
append ( element ) ;
}
}
return this ;
}
public HashCodeBuilder append ( final float value ) {
iTotal = iTotal * iConstant + Float . floatToIntBits ( value ) ;
return this ;
}
public HashCodeBuilder append ( final float [] array ) {
if ( array == null ) {
iTotal = iTotal * iConstant ;
} else {
for ( final float element : array ) {
append ( element ) ;
}
}
return this ;
}
public HashCodeBuilder append ( final int value ) {
iTotal = iTotal * iConstant + value ;
return this ;
}
public HashCodeBuilder append ( final int [] array ) {
if ( array == null ) {
iTotal = iTotal * iConstant ;
} else {
for ( final int element : array ) {
append ( element ) ;
}
}
return this ;
}
public HashCodeBuilder append ( final long value ) {
iTotal = iTotal * iConstant + ( (int) ( value ^ ( value >> 32 ) ) ) ;
return this ;
}
public HashCodeBuilder append ( final long [] array ) {
if ( array == null ) {
iTotal = iTotal * iConstant ;
} else {
for ( final long element : array ) {
append ( element ) ;
}
}
return this ;
}
public HashCodeBuilder append ( final Object object ) {
if ( object == null ) {
iTotal = iTotal * iConstant ;
} else {
if( object . getClass () . isArray () ) {
if ( object instanceof long [] ) {
append ( ( long [] ) object ) ;
} else if ( object instanceof int [] ) {
append ( ( int [] ) object ) ;
} else if ( object instanceof short [] ) {
append ( ( short [] ) object ) ;
} else if ( object instanceof char [] ) {
append ( ( char [] ) object ) ;
} else if ( object instanceof byte [] ) {
append ( ( byte [] ) object ) ;
} else if ( object instanceof double [] ) {
append ( ( double [] ) object ) ;
} else if ( object instanceof float [] ) {
append ( ( float [] ) object ) ;
} else if ( object instanceof boolean [] ) {
append ( ( boolean [] ) object ) ;
} else {
append ( ( Object [] ) object ) ;
}
} else {
if ( object instanceof Long ) {
append ( ( ( Long ) object ) . longValue () ) ;
} else if ( object instanceof Integer ) {
append ( ( ( Integer ) object ) . intValue () ) ;
} else if ( object instanceof Short ) {
append ( ( ( Short ) object ) . shortValue () ) ;
} else if ( object instanceof Character ) {
append ( ( ( Character ) object ) . charValue () ) ;
} else if ( object instanceof Byte ) {
append ( ( ( Byte ) object ) . byteValue () ) ;
} else if ( object instanceof Double ) {
append ( ( ( Double ) object ) . doubleValue () ) ;
} else if ( object instanceof Float ) {
append ( ( ( Float ) object ) . floatValue () ) ;
} else if ( object instanceof Boolean ) {
append ( ( ( Boolean ) object ) . booleanValue () ) ;
} else if ( object instanceof String ) {
iTotal = iTotal * iConstant + object . hashCode () ;
} else {
if ( isRegistered ( object ) ) {
return this ;
}
try {
register ( object ) ;
iTotal = iTotal * iConstant + object . hashCode () ;
} finally {
unregister ( object ) ;
}
}
}
}
return this ;
}
public HashCodeBuilder append ( final Object [] array ) {
if ( array == null ) {
iTotal = iTotal * iConstant ;
} else {
for ( final Object element : array ) {
append ( element ) ;
}
}
return this ;
}
public HashCodeBuilder append ( final short value ) {
iTotal = iTotal * iConstant + value ;
return this ;
}
public HashCodeBuilder append ( final short [] array ) {
if ( array == null ) {
iTotal = iTotal * iConstant ;
} else {
for ( final short element : array ) {
append ( element ) ;
}
}
return this ;
}
public HashCodeBuilder appendSuper ( final int superHashCode ) {
iTotal = iTotal * iConstant + superHashCode ;
return this ;
}
public int toHashCode () {
return iTotal ;
}
@Override
public Integer build () {
return Integer . valueOf ( toHashCode () ) ;
}
@Override
public int hashCode () {
return toHashCode () ;
}

static Set < Pair < IDKey , IDKey > > getRegistry () {
return REGISTRY . get () ;
}
static Pair < IDKey , IDKey > getRegisterPair ( final Object lhs , final Object rhs ) {
final IDKey left = new IDKey ( lhs ) ;
final IDKey right = new IDKey ( rhs ) ;
return Pair . of ( left , right ) ;
}
static boolean isRegistered ( final Object lhs , final Object rhs ) {
final Set < Pair < IDKey , IDKey > > registry = getRegistry () ;
final Pair < IDKey , IDKey > pair = getRegisterPair ( lhs , rhs ) ;
final Pair < IDKey , IDKey > swappedPair = Pair . of ( pair . getLeft () , pair . getRight () ) ;
return registry != null
&& ( registry . contains ( pair ) || registry . contains ( swappedPair ) ) ;
}
static void register ( final Object lhs , final Object rhs ) {
synchronized ( EqualsBuilder . class ) {
if ( getRegistry () == null ) {
REGISTRY . set ( new HashSet < Pair < IDKey , IDKey > > () ) ;
}
}
final Set < Pair < IDKey , IDKey > > registry = getRegistry () ;
final Pair < IDKey , IDKey > pair = getRegisterPair ( lhs , rhs ) ;
registry . add ( pair ) ;
}
static void unregister ( final Object lhs , final Object rhs ) {
Set < Pair < IDKey , IDKey > > registry = getRegistry () ;
if ( registry != null ) {
final Pair < IDKey , IDKey > pair = getRegisterPair ( lhs , rhs ) ;
registry . remove ( pair ) ;
synchronized ( EqualsBuilder . class ) {
registry = getRegistry () ;
if ( registry != null && registry . isEmpty () ) {
REGISTRY . remove () ;
}
}
}
}
public static boolean reflectionEquals ( final Object lhs , final Object rhs , final Collection < String > excludeFields ) { MST[experimental.MemberVariableMutator]MSP[N]
return reflectionEquals ( lhs , rhs , ReflectionToStringBuilder . toNoNullStringArray ( excludeFields ) ) ;
}
public static boolean reflectionEquals ( final Object lhs , final Object rhs , final String ... excludeFields ) {
return reflectionEquals ( lhs , rhs , false , null , excludeFields ) ;
}
public static boolean reflectionEquals ( final Object lhs , final Object rhs , final boolean testTransients ) {
return reflectionEquals ( lhs , rhs , testTransients , null ) ;
}
public static boolean reflectionEquals ( final Object lhs , final Object rhs , final boolean testTransients , final Class < ? > reflectUpToClass ,
final String ... excludeFields ) {
if ( lhs == rhs ) {
return true ;
}
if ( lhs == null || rhs == null ) {
return false ;
}
final Class < ? > lhsClass = lhs . getClass () ;
final Class < ? > rhsClass = rhs . getClass () ;
Class < ? > testClass ;
if ( lhsClass . isInstance ( rhs ) ) {
testClass = lhsClass ;
if ( ! rhsClass . isInstance ( lhs ) ) {
testClass = rhsClass ;
}
} else if ( rhsClass . isInstance ( lhs ) ) {
testClass = rhsClass ;
if ( ! lhsClass . isInstance ( rhs ) ) {
testClass = lhsClass ;
}
} else {
return false ;
}
final EqualsBuilder equalsBuilder = new EqualsBuilder () ;
try {
if ( testClass . isArray () ) {
equalsBuilder . append ( lhs , rhs ) ;
} else {
reflectionAppend ( lhs , rhs , testClass , equalsBuilder , testTransients , excludeFields ) ;
while ( testClass . getSuperclass () != null && testClass != reflectUpToClass ) {
testClass = testClass . getSuperclass () ;
reflectionAppend ( lhs , rhs , testClass , equalsBuilder , testTransients , excludeFields ) ;
}
}
} catch ( final IllegalArgumentException e ) {
return false ;
}
return equalsBuilder . isEquals () ;
}
private static void reflectionAppend (
final Object lhs ,
final Object rhs ,
final Class < ? > clazz ,
final EqualsBuilder builder ,
final boolean useTransients ,
final String [] excludeFields ) {
if ( isRegistered ( lhs , rhs ) ) {
return;
}
try {
register ( lhs , rhs ) ;
final Field [] fields = clazz . getDeclaredFields () ;
AccessibleObject . setAccessible ( fields , true ) ;
for ( int i = 0 ; i < fields . length && builder . isEquals ; i ++ ) {
final Field f = fields [ i ] ;
if ( ! ArrayUtils . contains ( excludeFields , f . getName () )
&& ! f . getName () . contains ( lr_1 )
&& ( useTransients || ! Modifier . isTransient ( f . getModifiers () ) )
&& ( ! Modifier . isStatic ( f . getModifiers () ) )
&& ( ! f . isAnnotationPresent ( EqualsExclude . class ) ) ) {
try {
builder . append ( f . get ( lhs ) , f . get ( rhs ) ) ;
} catch ( final IllegalAccessException e ) {
throw new InternalError ( lr_2 ) ;
}
}
}
} finally {
unregister ( lhs , rhs ) ;
}
}
public EqualsBuilder appendSuper ( final boolean superEquals ) {
if ( ! isEquals ) {
return this ;
}
isEquals = superEquals ;
return this ;
}
public EqualsBuilder append ( final Object lhs , final Object rhs ) {
if ( ! isEquals ) {
return this ;
}
if ( lhs == rhs ) {
return this ;
}
if ( lhs == null || rhs == null ) {
this . setEquals ( false ) ;
return this ;
}
final Class < ? > lhsClass = lhs . getClass () ;
if ( ! lhsClass . isArray () ) {
isEquals = lhs . equals ( rhs ) ;
} else if ( lhs . getClass () != rhs . getClass () ) {
this . setEquals ( false ) ;
}
else if ( lhs instanceof long [] ) {
append ( ( long [] ) lhs , ( long [] ) rhs ) ;
} else if ( lhs instanceof int [] ) {
append ( ( int [] ) lhs , ( int [] ) rhs ) ;
} else if ( lhs instanceof short [] ) {
append ( ( short [] ) lhs , ( short [] ) rhs ) ;
} else if ( lhs instanceof char [] ) {
append ( ( char [] ) lhs , ( char [] ) rhs ) ;
} else if ( lhs instanceof byte [] ) {
append ( ( byte [] ) lhs , ( byte [] ) rhs ) ;
} else if ( lhs instanceof double [] ) {
append ( ( double [] ) lhs , ( double [] ) rhs ) ;
} else if ( lhs instanceof float [] ) {
append ( ( float [] ) lhs , ( float [] ) rhs ) ;
} else if ( lhs instanceof boolean [] ) {
append ( ( boolean [] ) lhs , ( boolean [] ) rhs ) ;
} else {
append ( ( Object [] ) lhs , ( Object [] ) rhs ) ;
}
return this ;
}
public EqualsBuilder append ( final long lhs , final long rhs ) {
if ( ! isEquals ) {
return this ;
}
isEquals = lhs == rhs ;
return this ;
}
public EqualsBuilder append ( final int lhs , final int rhs ) {
if ( ! isEquals ) {
return this ;
}
isEquals = lhs == rhs ;
return this ;
}
public EqualsBuilder append ( final short lhs , final short rhs ) {
if ( ! isEquals ) {
return this ;
}
isEquals = lhs == rhs ;
return this ;
}
public EqualsBuilder append ( final char lhs , final char rhs ) {
if ( ! isEquals ) {
return this ;
}
isEquals = lhs == rhs ;
return this ;
}
public EqualsBuilder append ( final byte lhs , final byte rhs ) {
if ( ! isEquals ) {
return this ;
}
isEquals = lhs == rhs ;
return this ;
}
public EqualsBuilder append ( final double lhs , final double rhs ) {
if ( ! isEquals ) {
return this ;
}
return append ( Double . doubleToLongBits ( lhs ) , Double . doubleToLongBits ( rhs ) ) ;
}
public EqualsBuilder append ( final float lhs , final float rhs ) {
if ( ! isEquals ) {
return this ;
}
return append ( Float . floatToIntBits ( lhs ) , Float . floatToIntBits ( rhs ) ) ;
}
public EqualsBuilder append ( final boolean lhs , final boolean rhs ) {
if ( ! isEquals ) {
return this ;
}
isEquals = lhs == rhs ;
return this ;
}
public EqualsBuilder append ( final Object [] lhs , final Object [] rhs ) {
if ( ! isEquals ) {
return this ;
}
if ( lhs == rhs ) {
return this ;
}
if ( lhs == null || rhs == null ) {
this . setEquals ( false ) ;
return this ;
}
if ( lhs . length != rhs . length ) {
this . setEquals ( false ) ;
return this ;
}
for ( int i = 0 ; i < lhs . length && isEquals ; ++ i ) {
append ( lhs [ i ] , rhs [ i ] ) ;
}
return this ;
}
public EqualsBuilder append ( final long [] lhs , final long [] rhs ) {
if ( ! isEquals ) {
return this ;
}
if ( lhs == rhs ) {
return this ;
}
if ( lhs == null || rhs == null ) {
this . setEquals ( false ) ;
return this ;
}
if ( lhs . length != rhs . length ) {
this . setEquals ( false ) ;
return this ;
}
for ( int i = 0 ; i < lhs . length && isEquals ; ++ i ) {
append ( lhs [ i ] , rhs [ i ] ) ;
}
return this ;
}
public EqualsBuilder append ( final int [] lhs , final int [] rhs ) {
if ( ! isEquals ) {
return this ;
}
if ( lhs == rhs ) {
return this ;
}
if ( lhs == null || rhs == null ) {
this . setEquals ( false ) ;
return this ;
}
if ( lhs . length != rhs . length ) {
this . setEquals ( false ) ;
return this ;
}
for ( int i = 0 ; i < lhs . length && isEquals ; ++ i ) {
append ( lhs [ i ] , rhs [ i ] ) ;
}
return this ;
}
public EqualsBuilder append ( final short [] lhs , final short [] rhs ) {
if ( ! isEquals ) {
return this ;
}
if ( lhs == rhs ) {
return this ;
}
if ( lhs == null || rhs == null ) {
this . setEquals ( false ) ;
return this ;
}
if ( lhs . length != rhs . length ) {
this . setEquals ( false ) ;
return this ;
}
for ( int i = 0 ; i < lhs . length && isEquals ; ++ i ) {
append ( lhs [ i ] , rhs [ i ] ) ;
}
return this ;
}
public EqualsBuilder append ( final char [] lhs , final char [] rhs ) {
if ( ! isEquals ) {
return this ;
}
if ( lhs == rhs ) {
return this ;
}
if ( lhs == null || rhs == null ) {
this . setEquals ( false ) ;
return this ;
}
if ( lhs . length != rhs . length ) {
this . setEquals ( false ) ;
return this ;
}
for ( int i = 0 ; i < lhs . length && isEquals ; ++ i ) {
append ( lhs [ i ] , rhs [ i ] ) ;
}
return this ;
}
public EqualsBuilder append ( final byte [] lhs , final byte [] rhs ) {
if ( ! isEquals ) {
return this ;
}
if ( lhs == rhs ) {
return this ;
}
if ( lhs == null || rhs == null ) {
this . setEquals ( false ) ;
return this ;
}
if ( lhs . length != rhs . length ) {
this . setEquals ( false ) ;
return this ;
}
for ( int i = 0 ; i < lhs . length && isEquals ; ++ i ) {
append ( lhs [ i ] , rhs [ i ] ) ;
}
return this ;
}
public EqualsBuilder append ( final double [] lhs , final double [] rhs ) {
if ( ! isEquals ) {
return this ;
}
if ( lhs == rhs ) {
return this ;
}
if ( lhs == null || rhs == null ) {
this . setEquals ( false ) ;
return this ;
}
if ( lhs . length != rhs . length ) {
this . setEquals ( false ) ;
return this ;
}
for ( int i = 0 ; i < lhs . length && isEquals ; ++ i ) {
append ( lhs [ i ] , rhs [ i ] ) ;
}
return this ;
}
public EqualsBuilder append ( final float [] lhs , final float [] rhs ) {
if ( ! isEquals ) {
return this ;
}
if ( lhs == rhs ) {
return this ;
}
if ( lhs == null || rhs == null ) {
this . setEquals ( false ) ;
return this ;
}
if ( lhs . length != rhs . length ) {
this . setEquals ( false ) ;
return this ;
}
for ( int i = 0 ; i < lhs . length && isEquals ; ++ i ) {
append ( lhs [ i ] , rhs [ i ] ) ;
}
return this ;
}
public EqualsBuilder append ( final boolean [] lhs , final boolean [] rhs ) {
if ( ! isEquals ) {
return this ;
}
if ( lhs == rhs ) {
return this ;
}
if ( lhs == null || rhs == null ) {
this . setEquals ( false ) ;
return this ;
}
if ( lhs . length != rhs . length ) {
this . setEquals ( false ) ;
return this ;
}
for ( int i = 0 ; i < lhs . length && isEquals ; ++ i ) {
append ( lhs [ i ] , rhs [ i ] ) ;
}
return this ;
}
public boolean isEquals () {
return this . isEquals ;
}
@Override
public Boolean build () {
return Boolean . valueOf ( isEquals () ) ;
}
protected void setEquals ( final boolean isEquals ) {
this . isEquals = isEquals ;
}
public void reset () {
this . isEquals = true ;
}

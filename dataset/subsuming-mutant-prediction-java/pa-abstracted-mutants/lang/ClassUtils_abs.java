public static String getShortClassName ( final Object object , final String valueIfNull ) {
if ( object == null ) {
return valueIfNull ;
}
return getShortClassName ( object . getClass () ) ;
}
public static String getShortClassName ( final Class < ? > cls ) {
if ( cls == null ) {
return StringUtils . EMPTY ;
}
return getShortClassName ( cls . getName () ) ;
}
public static String getShortClassName ( String className ) {
if ( StringUtils . isEmpty ( className ) ) {
return StringUtils . EMPTY ;
}
final StringBuilder arrayPrefix = new StringBuilder () ;
if ( className . startsWith ( lr_1 ) ) {
while ( className . charAt ( 0 ) == '[' ) {
className = className . substring ( 1 ) ;
arrayPrefix . append ( lr_2 ) ;
}
if ( className . charAt ( 0 ) == 'L' && className . charAt ( className . length () - 1 ) == ';' ) {
className = className . substring ( 1 , className . length () - 1 ) ;
}
if ( reverseAbbreviationMap . containsKey ( className ) ) {
className = reverseAbbreviationMap . get ( className ) ;
}
}
final int lastDotIdx = className . lastIndexOf ( PACKAGE_SEPARATOR_CHAR ) ;
final int innerIdx = className . indexOf (
INNER_CLASS_SEPARATOR_CHAR , lastDotIdx == - 1 ? 0 : lastDotIdx + 1 ) ;
String out = className . substring ( lastDotIdx + 1 ) ;
if ( innerIdx != - 1 ) {
out = out . replace ( INNER_CLASS_SEPARATOR_CHAR , PACKAGE_SEPARATOR_CHAR ) ;
}
return out + arrayPrefix ;
}
public static String getSimpleName ( final Class < ? > cls ) {
if ( cls == null ) {
return StringUtils . EMPTY ;
}
return cls . getSimpleName () ;
}
public static String getSimpleName ( final Object object , final String valueIfNull ) {
if ( object == null ) {
return valueIfNull ;
}
return getSimpleName ( object . getClass () ) ;
}
public static String getPackageName ( final Object object , final String valueIfNull ) {
if ( object == null ) {
return valueIfNull ;
}
return getPackageName ( object . getClass () ) ;
}
public static String getPackageName ( final Class < ? > cls ) {
if ( cls == null ) {
return StringUtils . EMPTY ;
}
return getPackageName ( cls . getName () ) ;
}
public static String getPackageName ( String className ) {
if ( StringUtils . isEmpty ( className ) ) {
return StringUtils . EMPTY ;
}
while ( className . charAt ( 0 ) == '[' ) {
className = className . substring ( 1 ) ;
}
if ( className . charAt ( 0 ) == 'L' && className . charAt ( className . length () - 1 ) == ';' ) {
className = className . substring ( 1 ) ;
}
final int i = className . lastIndexOf ( PACKAGE_SEPARATOR_CHAR ) ;
if ( i == - 1 ) {
return StringUtils . EMPTY ;
}
return className . substring ( 0 , i ) ;
}
public static String getAbbreviatedName ( final Class < ? > cls , int len ) {
if ( cls == null ) {
return StringUtils . EMPTY ;
}
return getAbbreviatedName ( cls . getName () , len ) ;
}
public static String getAbbreviatedName ( String className , int len ) {
if ( len <= 0 ) {
throw new IllegalArgumentException ( lr_3 ) ;
}
if ( className == null ) {
return StringUtils . EMPTY ;
}
int availableSpace = len ;
int packageLevels = StringUtils . countMatches ( className , '.' ) ;
String [] output = new String [ packageLevels + 1 ] ;
int endIndex = className . length () - 1 ;
for ( int level = packageLevels ; level >= 0 ; level -- ) {
int startIndex = className . lastIndexOf ( '.' , endIndex ) ;
String part = className . substring ( startIndex + 1 , endIndex + 1 ) ;
availableSpace -= part . length () ;
if ( level > 0 ) {
availableSpace -- ;
}
if ( level == packageLevels ) {
output [ level ] = part ;
} else {
if ( availableSpace > 0 ) {
output [ level ] = part ;
} else {
output [ level ] = part . substring ( 0 , 1 ) ;
}
}
endIndex = startIndex - 1 ;
}
return StringUtils . join ( output , '.' ) ;
}
public static List < Class < ? > > getAllSuperclasses ( final Class < ? > cls ) {
if ( cls == null ) {
return null ;
}
final List < Class < ? > > classes = new ArrayList < Class < ? > > () ;
Class < ? > superclass = cls . getSuperclass () ;
while ( superclass != null ) {
classes . add ( superclass ) ;
superclass = superclass . getSuperclass () ;
}
return classes ;
}
public static List < Class < ? > > getAllInterfaces ( final Class < ? > cls ) {
if ( cls == null ) {
return null ;
}
final LinkedHashSet < Class < ? > > interfacesFound = new LinkedHashSet < Class < ? > > () ;
getAllInterfaces ( cls , interfacesFound ) ;
return new ArrayList < Class < ? > > ( interfacesFound ) ;
}
private static void getAllInterfaces ( Class < ? > cls , final HashSet < Class < ? > > interfacesFound ) {
while ( cls != null ) {
final Class < ? > [] interfaces = cls . getInterfaces () ;
for ( final Class < ? > i : interfaces ) {
if ( interfacesFound . add ( i ) ) {
getAllInterfaces ( i , interfacesFound ) ;
}
}
cls = cls . getSuperclass () ;
}
}
public static List < Class < ? > > convertClassNamesToClasses ( final List < String > classNames ) {
if ( classNames == null ) {
return null ;
}
final List < Class < ? > > classes = new ArrayList < Class < ? > > ( classNames . size () ) ;
for ( final String className : classNames ) {
try {
classes . add ( Class . forName ( className ) ) ;
} catch ( final Exception ex ) {
classes . add ( null ) ;
}
}
return classes ;
}
public static List < String > convertClassesToClassNames ( final List < Class < ? > > classes ) {
if ( classes == null ) {
return null ;
}
final List < String > classNames = new ArrayList < String > ( classes . size () ) ;
for ( final Class < ? > cls : classes ) {
if ( cls == null ) {
classNames . add ( null ) ;
} else {
classNames . add ( cls . getName () ) ;
}
}
return classNames ;
}
public static boolean isAssignable ( final Class < ? > [] classArray , final Class < ? > ... toClassArray ) {
return isAssignable ( classArray , toClassArray , SystemUtils . isJavaVersionAtLeast ( JavaVersion . JAVA_1_5 ) ) ;
}
public static boolean isAssignable ( Class < ? > [] classArray , Class < ? > [] toClassArray , final boolean autoboxing ) {
if ( ArrayUtils . isSameLength ( classArray , toClassArray ) == false ) {
return false ;
}
if ( classArray == null ) {
classArray = ArrayUtils . EMPTY_CLASS_ARRAY ;
}
if ( toClassArray == null ) {
toClassArray = ArrayUtils . EMPTY_CLASS_ARRAY ;
}
for ( int i = 0 ; i < classArray . length ; i ++ ) {
if ( isAssignable ( classArray [ i ] , toClassArray [ i ] , autoboxing ) == false ) {
return false ;
}
}
return true ;
}
public static boolean isPrimitiveOrWrapper ( final Class < ? > type ) {
if ( type == null ) {
return false ;
}
return type . isPrimitive () || isPrimitiveWrapper ( type ) ;
}
public static boolean isPrimitiveWrapper ( final Class < ? > type ) {
return wrapperPrimitiveMap . containsKey ( type ) ;
}
public static boolean isAssignable ( final Class < ? > cls , final Class < ? > toClass ) {
return isAssignable ( cls , toClass , SystemUtils . isJavaVersionAtLeast ( JavaVersion . JAVA_1_5 ) ) ;
}
public static boolean isAssignable ( Class < ? > cls , final Class < ? > toClass , final boolean autoboxing ) {
if ( toClass == null ) {
return false ;
}
if ( cls == null ) {
return ! toClass . isPrimitive () ;
}
if ( autoboxing ) {
if ( cls . isPrimitive () && ! toClass . isPrimitive () ) {
cls = primitiveToWrapper ( cls ) ;
if ( cls == null ) {
return false ;
}
}
if ( toClass . isPrimitive () && ! cls . isPrimitive () ) {
cls = wrapperToPrimitive ( cls ) ;
if ( cls == null ) {
return false ;
}
}
}
if ( cls . equals ( toClass ) ) {
return true ;
}
if ( cls . isPrimitive () ) {
if ( toClass . isPrimitive () == false ) {
return false ;
}
if ( Integer . TYPE . equals ( cls ) ) {
return Long . TYPE . equals ( toClass )
|| Float . TYPE . equals ( toClass )
|| Double . TYPE . equals ( toClass ) ;
}
if ( Long . TYPE . equals ( cls ) ) {
return Float . TYPE . equals ( toClass )
|| Double . TYPE . equals ( toClass ) ;
}
if ( Boolean . TYPE . equals ( cls ) ) {
return false ;
}
if ( Double . TYPE . equals ( cls ) ) {
return false ;
}
if ( Float . TYPE . equals ( cls ) ) {
return Double . TYPE . equals ( toClass ) ;
}
if ( Character . TYPE . equals ( cls ) ) {
return Integer . TYPE . equals ( toClass )
|| Long . TYPE . equals ( toClass )
|| Float . TYPE . equals ( toClass )
|| Double . TYPE . equals ( toClass ) ;
}
if ( Short . TYPE . equals ( cls ) ) {
return Integer . TYPE . equals ( toClass )
|| Long . TYPE . equals ( toClass )
|| Float . TYPE . equals ( toClass )
|| Double . TYPE . equals ( toClass ) ;
}
if ( Byte . TYPE . equals ( cls ) ) {
return Short . TYPE . equals ( toClass )
|| Integer . TYPE . equals ( toClass )
|| Long . TYPE . equals ( toClass )
|| Float . TYPE . equals ( toClass )
|| Double . TYPE . equals ( toClass ) ;
}
return false ;
}
return toClass . isAssignableFrom ( cls ) ;
}
public static Class < ? > primitiveToWrapper ( final Class < ? > cls ) {
Class < ? > convertedClass = cls ;
if ( cls != null && cls . isPrimitive () ) {
convertedClass = primitiveWrapperMap . get ( cls ) ;
}
return convertedClass ;
}
public static Class < ? > [] primitivesToWrappers ( final Class < ? > ... classes ) {
if ( classes == null ) {
return null ;
}
if ( classes . length == 0 ) {
return classes ;
}
final Class < ? > [] convertedClasses = new Class [ classes . length ] ;
for ( int i = 0 ; i < classes . length ; i ++ ) {
convertedClasses [ i ] = primitiveToWrapper ( classes [ i ] ) ;
}
return convertedClasses ;
}
public static Class < ? > wrapperToPrimitive ( final Class < ? > cls ) {
return wrapperPrimitiveMap . get ( cls ) ;
}
public static Class < ? > [] wrappersToPrimitives ( final Class < ? > ... classes ) {
if ( classes == null ) {
return null ;
}
if ( classes . length == 0 ) {
return classes ;
}
final Class < ? > [] convertedClasses = new Class [ classes . length ] ;
for ( int i = 0 ; i < classes . length ; i ++ ) {
convertedClasses [ i ] = wrapperToPrimitive ( classes [ i ] ) ;
}
return convertedClasses ;
}
public static boolean isInnerClass ( final Class < ? > cls ) {
return cls != null && cls . getEnclosingClass () != null ;
}
public static Class < ? > getClass (
final ClassLoader classLoader , final String className , final boolean initialize ) throws ClassNotFoundException {
try {
Class < ? > clazz ;
if ( abbreviationMap . containsKey ( className ) ) {
final String clsName = lr_1 + abbreviationMap . get ( className ) ;
clazz = Class . forName ( clsName , initialize , classLoader ) . getComponentType () ;
} else {
clazz = Class . forName ( toCanonicalName ( className ) , initialize , classLoader ) ;
}
return clazz ;
} catch ( final ClassNotFoundException ex ) {
final int lastDotIndex = className . lastIndexOf ( PACKAGE_SEPARATOR_CHAR ) ;
if ( lastDotIndex != - 1 ) {
try {
return getClass ( classLoader , className . substring ( 0 , lastDotIndex ) +
INNER_CLASS_SEPARATOR_CHAR + className . substring ( lastDotIndex + 1 ) ,
initialize ) ;
} catch ( final ClassNotFoundException ex2 ) {
}
}
throw ex ;
}
}
public static Class < ? > getClass ( final ClassLoader classLoader , final String className ) throws ClassNotFoundException {
return getClass ( classLoader , className , true ) ;
}
public static Class < ? > getClass ( final String className ) throws ClassNotFoundException {
return getClass ( className , true ) ;
}
public static Class < ? > getClass ( final String className , final boolean initialize ) throws ClassNotFoundException {
final ClassLoader contextCL = Thread . currentThread () . getContextClassLoader () ;
final ClassLoader loader = contextCL == null ? ClassUtils . class . getClassLoader () : contextCL ;
return getClass ( loader , className , initialize ) ;
}
public static Method getPublicMethod ( final Class < ? > cls , final String methodName , final Class < ? > ... parameterTypes )
throws SecurityException , NoSuchMethodException {
final Method declaredMethod = cls . getMethod ( methodName , parameterTypes ) ;
if ( Modifier . isPublic ( declaredMethod . getDeclaringClass () . getModifiers () ) ) {
return declaredMethod ;
}
final List < Class < ? > > candidateClasses = new ArrayList < Class < ? > > () ;
candidateClasses . addAll ( getAllInterfaces ( cls ) ) ;
candidateClasses . addAll ( getAllSuperclasses ( cls ) ) ;
for ( final Class < ? > candidateClass : candidateClasses ) {
if ( ! Modifier . isPublic ( candidateClass . getModifiers () ) ) {
continue;
}
Method candidateMethod ;
try {
candidateMethod = candidateClass . getMethod ( methodName , parameterTypes ) ;
} catch ( final NoSuchMethodException ex ) {
continue;
}
if ( Modifier . isPublic ( candidateMethod . getDeclaringClass () . getModifiers () ) ) {
return candidateMethod ;
}
}
throw new NoSuchMethodException ( lr_4 +
methodName + lr_5 + ArrayUtils . toString ( parameterTypes ) ) ;
}
private static String toCanonicalName ( String className ) {
className = StringUtils . deleteWhitespace ( className ) ;
if ( className == null ) {
throw new NullPointerException ( lr_6 ) ;
} else if ( className . endsWith ( lr_2 ) ) {
final StringBuilder classNameBuffer = new StringBuilder () ;
while ( className . endsWith ( lr_2 ) ) {
className = className . substring ( 0 , className . length () - 2 ) ;
classNameBuffer . append ( lr_1 ) ;
}
final String abbreviation = abbreviationMap . get ( className ) ;
if ( abbreviation != null ) {
classNameBuffer . append ( abbreviation ) ;
} else {
classNameBuffer . append ( lr_7 ) . append ( className ) . append ( lr_8 ) ;
}
className = classNameBuffer . toString () ;
}
return className ;
}
public static Class < ? > [] toClass ( final Object ... array ) {
if ( array == null ) {
return null ;
} else if ( array . length == 0 ) {
return ArrayUtils . EMPTY_CLASS_ARRAY ;
}
final Class < ? > [] classes = new Class [ array . length ] ;
for ( int i = 0 ; i < array . length ; i ++ ) {
classes [ i ] = array [ i ] == null ? null : array [ i ] . getClass () ;
}
return classes ;
}
public static String getShortCanonicalName ( final Object object , final String valueIfNull ) {
if ( object == null ) {
return valueIfNull ;
}
return getShortCanonicalName ( object . getClass () . getName () ) ;
}
public static String getShortCanonicalName ( final Class < ? > cls ) {
if ( cls == null ) {
return StringUtils . EMPTY ;
}
return getShortCanonicalName ( cls . getName () ) ;
}
public static String getShortCanonicalName ( final String canonicalName ) {
return ClassUtils . getShortClassName ( getCanonicalName ( canonicalName ) ) ;
}
public static String getPackageCanonicalName ( final Object object , final String valueIfNull ) {
if ( object == null ) {
return valueIfNull ;
}
return getPackageCanonicalName ( object . getClass () . getName () ) ;
}
public static String getPackageCanonicalName ( final Class < ? > cls ) {
if ( cls == null ) {
return StringUtils . EMPTY ;
}
return getPackageCanonicalName ( cls . getName () ) ;
}
public static String getPackageCanonicalName ( final String canonicalName ) {
return ClassUtils . getPackageName ( getCanonicalName ( canonicalName ) ) ;
}
private static String getCanonicalName ( String className ) {
className = StringUtils . deleteWhitespace ( className ) ;
if ( className == null ) {
return null ;
}
int dim = 0 ;
while ( className . startsWith ( lr_1 ) ) {
dim ++ ;
className = className . substring ( 1 ) ;
}
if ( dim < 1 ) {
return className ;
}
if ( className . startsWith ( lr_7 ) ) {
className = className . substring (
1 ,
className . endsWith ( lr_8 )
? className . length () - 1
: className . length () ) ;
} else {
if ( className . length () > 0 ) {
className = reverseAbbreviationMap . get ( className . substring ( 0 , 1 ) ) ;
}
}
final StringBuilder canonicalClassNameBuffer = new StringBuilder ( className ) ;
for ( int i = 0 ; i < dim ; i ++ ) {
canonicalClassNameBuffer . append ( lr_2 ) ;
}
return canonicalClassNameBuffer . toString () ;
}
public static Iterable < Class < ? > > hierarchy ( final Class < ? > type ) {
return hierarchy ( type , Interfaces . EXCLUDE ) ;
}
@Override
public boolean hasNext () {
return next . getValue () != null ;
}
@Override
public Class < ? > next () {
final Class < ? > result = next . getValue () ;
next . setValue ( result . getSuperclass () ) ;
return result ;
}
@Override
public void remove () {
throw new UnsupportedOperationException () ;
}
@Override
public boolean hasNext () {
return interfaces . hasNext () || wrapped . hasNext () ;
}
@Override
public Class < ? > next () {
if ( interfaces . hasNext () ) {
final Class < ? > nextInterface = interfaces . next () ;
seenInterfaces . add ( nextInterface ) ;
return nextInterface ;
}
final Class < ? > nextSuperclass = wrapped . next () ;
final Set < Class < ? > > currentInterfaces = new LinkedHashSet < Class < ? > > () ;
walkInterfaces ( currentInterfaces , nextSuperclass ) ;
interfaces = currentInterfaces . iterator () ;
return nextSuperclass ;
}
private void walkInterfaces ( final Set < Class < ? > > addTo , final Class < ? > c ) {
for ( final Class < ? > iface : c . getInterfaces () ) {
if ( ! seenInterfaces . contains ( iface ) ) {
addTo . add ( iface ) ;
}
walkInterfaces ( addTo , iface ) ;
}
}
@Override
public void remove () {
throw new UnsupportedOperationException () ;
}

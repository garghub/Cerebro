public static < T > T invokeConstructor ( final Class < T > cls , Object ... args )
throws NoSuchMethodException , IllegalAccessException , InvocationTargetException ,
InstantiationException {
args = ArrayUtils . nullToEmpty ( args ) ;
final Class < ? > parameterTypes [] = ClassUtils . toClass ( args ) ;
return invokeConstructor ( cls , args , parameterTypes ) ;
}
public static < T > T invokeConstructor ( final Class < T > cls , Object [] args , Class < ? > [] parameterTypes )
throws NoSuchMethodException , IllegalAccessException , InvocationTargetException ,
InstantiationException {
args = ArrayUtils . nullToEmpty ( args ) ;
parameterTypes = ArrayUtils . nullToEmpty ( parameterTypes ) ;
final Constructor < T > ctor = getMatchingAccessibleConstructor ( cls , parameterTypes ) ;
if ( ctor == null ) {
throw new NoSuchMethodException (
lr_1 + cls . getName () ) ;
}
return ctor . newInstance ( args ) ;
}
public static < T > T invokeExactConstructor ( final Class < T > cls , Object ... args )
throws NoSuchMethodException , IllegalAccessException , InvocationTargetException ,
InstantiationException {
args = ArrayUtils . nullToEmpty ( args ) ;
final Class < ? > parameterTypes [] = ClassUtils . toClass ( args ) ;
return invokeExactConstructor ( cls , args , parameterTypes ) ;
}
public static < T > T invokeExactConstructor ( final Class < T > cls , Object [] args ,
Class < ? > [] parameterTypes ) throws NoSuchMethodException , IllegalAccessException ,
InvocationTargetException , InstantiationException {
args = ArrayUtils . nullToEmpty ( args ) ;
parameterTypes = ArrayUtils . nullToEmpty ( parameterTypes ) ;
final Constructor < T > ctor = getAccessibleConstructor ( cls , parameterTypes ) ;
if ( ctor == null ) {
throw new NoSuchMethodException (
lr_1 + cls . getName () ) ;
}
return ctor . newInstance ( args ) ;
}
public static < T > Constructor < T > getAccessibleConstructor ( final Class < T > cls ,
final Class < ? > ... parameterTypes ) {
Validate . notNull ( cls , lr_2 ) ;
try {
return getAccessibleConstructor ( cls . getConstructor ( parameterTypes ) ) ;
} catch ( final NoSuchMethodException e ) {
return null ;
}
}
public static < T > Constructor < T > getAccessibleConstructor ( final Constructor < T > ctor ) {
Validate . notNull ( ctor , lr_3 ) ;
return MemberUtils . isAccessible ( ctor )
&& isAccessible ( ctor . getDeclaringClass () ) ? ctor : null ;
}
public static < T > Constructor < T > getMatchingAccessibleConstructor ( final Class < T > cls ,
final Class < ? > ... parameterTypes ) {
Validate . notNull ( cls , lr_2 ) ;
try {
final Constructor < T > ctor = cls . getConstructor ( parameterTypes ) ;
MemberUtils . setAccessibleWorkaround ( ctor ) ;
return ctor ;
} catch ( final NoSuchMethodException e ) {
}
Constructor < T > result = null ;
final Constructor < ? > [] ctors = cls . getConstructors () ;
for ( Constructor < ? > ctor : ctors ) {
if ( ClassUtils . isAssignable ( parameterTypes , ctor . getParameterTypes () , true ) ) {
ctor = getAccessibleConstructor ( ctor ) ;
if ( ctor != null ) {
MemberUtils . setAccessibleWorkaround ( ctor ) ;
if ( result == null
|| MemberUtils . compareParameterTypes ( ctor . getParameterTypes () , result
. getParameterTypes () , parameterTypes ) < 0 ) {
@SuppressWarnings ( lr_4 )
final
Constructor < T > constructor = ( Constructor < T > ) ctor ;
result = constructor ;
}
}
}
}
return result ;
}
private static boolean isAccessible ( final Class < ? > type ) {
Class < ? > cls = type ;
while ( cls != null ) {
if ( ! Modifier . isPublic ( cls . getModifiers () ) ) {
return false ;
}
cls = cls . getEnclosingClass () ;
}
return true ;
}

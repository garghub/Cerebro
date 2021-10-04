public static Object invokeMethod ( final Object object , final String methodName ) throws NoSuchMethodException ,
IllegalAccessException , InvocationTargetException {
return invokeMethod ( object , methodName , ArrayUtils . EMPTY_OBJECT_ARRAY , null ) ;
}
public static Object invokeMethod ( final Object object , final String methodName ,
Object ... args ) throws NoSuchMethodException ,
IllegalAccessException , InvocationTargetException {
args = ArrayUtils . nullToEmpty ( args ) ;
final Class < ? > [] parameterTypes = ClassUtils . toClass ( args ) ;
return invokeMethod ( object , methodName , args , parameterTypes ) ;
}
public static Object invokeMethod ( final Object object , final String methodName ,
Object [] args , Class < ? > [] parameterTypes )
throws NoSuchMethodException , IllegalAccessException ,
InvocationTargetException {
parameterTypes = ArrayUtils . nullToEmpty ( parameterTypes ) ;
args = ArrayUtils . nullToEmpty ( args ) ;
final Method method = getMatchingAccessibleMethod ( object . getClass () ,
methodName , parameterTypes ) ;
if ( method == null ) {
throw new NoSuchMethodException ( lr_1
+ methodName + lr_2
+ object . getClass () . getName () ) ;
}
return method . invoke ( object , args ) ;
}
public static Object invokeExactMethod ( final Object object , final String methodName ) throws NoSuchMethodException ,
IllegalAccessException , InvocationTargetException {
return invokeExactMethod ( object , methodName , ArrayUtils . EMPTY_OBJECT_ARRAY , null ) ;
}
public static Object invokeExactMethod ( final Object object , final String methodName ,
Object ... args ) throws NoSuchMethodException ,
IllegalAccessException , InvocationTargetException {
args = ArrayUtils . nullToEmpty ( args ) ;
final Class < ? > [] parameterTypes = ClassUtils . toClass ( args ) ;
return invokeExactMethod ( object , methodName , args , parameterTypes ) ;
}
public static Object invokeExactMethod ( final Object object , final String methodName ,
Object [] args , Class < ? > [] parameterTypes )
throws NoSuchMethodException , IllegalAccessException ,
InvocationTargetException {
args = ArrayUtils . nullToEmpty ( args ) ;
parameterTypes = ArrayUtils . nullToEmpty ( parameterTypes ) ;
final Method method = getAccessibleMethod ( object . getClass () , methodName ,
parameterTypes ) ;
if ( method == null ) {
throw new NoSuchMethodException ( lr_1
+ methodName + lr_2
+ object . getClass () . getName () ) ;
}
return method . invoke ( object , args ) ;
}
public static Object invokeExactStaticMethod ( final Class < ? > cls , final String methodName ,
Object [] args , Class < ? > [] parameterTypes )
throws NoSuchMethodException , IllegalAccessException ,
InvocationTargetException {
args = ArrayUtils . nullToEmpty ( args ) ;
parameterTypes = ArrayUtils . nullToEmpty ( parameterTypes ) ;
final Method method = getAccessibleMethod ( cls , methodName , parameterTypes ) ;
if ( method == null ) {
throw new NoSuchMethodException ( lr_1
+ methodName + lr_3 + cls . getName () ) ;
}
return method . invoke ( null , args ) ;
}
public static Object invokeStaticMethod ( final Class < ? > cls , final String methodName ,
Object ... args ) throws NoSuchMethodException ,
IllegalAccessException , InvocationTargetException {
args = ArrayUtils . nullToEmpty ( args ) ;
final Class < ? > [] parameterTypes = ClassUtils . toClass ( args ) ;
return invokeStaticMethod ( cls , methodName , args , parameterTypes ) ;
}
public static Object invokeStaticMethod ( final Class < ? > cls , final String methodName ,
Object [] args , Class < ? > [] parameterTypes )
throws NoSuchMethodException , IllegalAccessException ,
InvocationTargetException {
args = ArrayUtils . nullToEmpty ( args ) ;
parameterTypes = ArrayUtils . nullToEmpty ( parameterTypes ) ;
final Method method = getMatchingAccessibleMethod ( cls , methodName ,
parameterTypes ) ;
if ( method == null ) {
throw new NoSuchMethodException ( lr_1
+ methodName + lr_3 + cls . getName () ) ;
}
return method . invoke ( null , args ) ;
}
public static Object invokeExactStaticMethod ( final Class < ? > cls , final String methodName ,
Object ... args ) throws NoSuchMethodException ,
IllegalAccessException , InvocationTargetException {
args = ArrayUtils . nullToEmpty ( args ) ;
final Class < ? > [] parameterTypes = ClassUtils . toClass ( args ) ;
return invokeExactStaticMethod ( cls , methodName , args , parameterTypes ) ;
}
public static Method getAccessibleMethod ( final Class < ? > cls , final String methodName ,
final Class < ? > ... parameterTypes ) {
try {
return getAccessibleMethod ( cls . getMethod ( methodName ,
parameterTypes ) ) ;
} catch ( final NoSuchMethodException e ) {
return null ;
}
}
public static Method getAccessibleMethod ( Method method ) {
if ( ! MemberUtils . isAccessible ( method ) ) {
return null ;
}
final Class < ? > cls = method . getDeclaringClass () ;
if ( Modifier . isPublic ( cls . getModifiers () ) ) {
return method ;
}
final String methodName = method . getName () ;
final Class < ? > [] parameterTypes = method . getParameterTypes () ;
method = getAccessibleMethodFromInterfaceNest ( cls , methodName ,
parameterTypes ) ;
if ( method == null ) {
method = getAccessibleMethodFromSuperclass ( cls , methodName ,
parameterTypes ) ;
}
return method ;
}
private static Method getAccessibleMethodFromSuperclass ( final Class < ? > cls ,
final String methodName , final Class < ? > ... parameterTypes ) {
Class < ? > parentClass = cls . getSuperclass () ;
while ( parentClass != null ) {
if ( Modifier . isPublic ( parentClass . getModifiers () ) ) {
try {
return parentClass . getMethod ( methodName , parameterTypes ) ;
} catch ( final NoSuchMethodException e ) {
return null ;
}
}
parentClass = parentClass . getSuperclass () ;
}
return null ;
}
private static Method getAccessibleMethodFromInterfaceNest ( Class < ? > cls ,
final String methodName , final Class < ? > ... parameterTypes ) {
for (; cls != null ; cls = cls . getSuperclass () ) {
final Class < ? > [] interfaces = cls . getInterfaces () ;
for ( int i = 0 ; i < interfaces . length ; i ++ ) {
if ( ! Modifier . isPublic ( interfaces [ i ] . getModifiers () ) ) {
continue;
}
try {
return interfaces [ i ] . getDeclaredMethod ( methodName ,
parameterTypes ) ;
} catch ( final NoSuchMethodException e ) {
}
final Method method = getAccessibleMethodFromInterfaceNest ( interfaces [ i ] ,
methodName , parameterTypes ) ;
if ( method != null ) {
return method ;
}
}
}
return null ;
}
public static Method getMatchingAccessibleMethod ( final Class < ? > cls ,
final String methodName , final Class < ? > ... parameterTypes ) {
try {
final Method method = cls . getMethod ( methodName , parameterTypes ) ;
MemberUtils . setAccessibleWorkaround ( method ) ;
return method ;
} catch ( final NoSuchMethodException e ) {
}
Method bestMatch = null ;
final Method [] methods = cls . getMethods () ;
for ( final Method method : methods ) {
if ( method . getName () . equals ( methodName ) && ClassUtils . isAssignable ( parameterTypes , method . getParameterTypes () , true ) ) {
final Method accessibleMethod = getAccessibleMethod ( method ) ;
if ( accessibleMethod != null && ( bestMatch == null || MemberUtils . compareParameterTypes (
accessibleMethod . getParameterTypes () ,
bestMatch . getParameterTypes () ,
parameterTypes ) < 0 ) ) {
bestMatch = accessibleMethod ;
}
}
}
if ( bestMatch != null ) {
MemberUtils . setAccessibleWorkaround ( bestMatch ) ;
}
return bestMatch ;
}
public static Set < Method > getOverrideHierarchy ( final Method method , final Interfaces interfacesBehavior ) {
Validate . notNull ( method ) ;
final Set < Method > result = new LinkedHashSet < Method > () ;
result . add ( method ) ;
final Class < ? > [] parameterTypes = method . getParameterTypes () ;
final Class < ? > declaringClass = method . getDeclaringClass () ;
final Iterator < Class < ? > > hierarchy = ClassUtils . hierarchy ( declaringClass , interfacesBehavior ) . iterator () ;
hierarchy . next () ;
hierarchyTraversal: while ( hierarchy . hasNext () ) {
final Class < ? > c = hierarchy . next () ;
final Method m = getMatchingAccessibleMethod ( c , method . getName () , parameterTypes ) ;
if ( m == null ) {
continue;
}
if ( Arrays . equals ( m . getParameterTypes () , parameterTypes ) ) {
result . add ( m ) ;
continue;
}
final Map < TypeVariable < ? > , Type > typeArguments = TypeUtils . getTypeArguments ( declaringClass , m . getDeclaringClass () ) ;
for ( int i = 0 ; i < parameterTypes . length ; i ++ ) {
final Type childType = TypeUtils . unrollVariables ( typeArguments , method . getGenericParameterTypes () [ i ] ) ;
final Type parentType = TypeUtils . unrollVariables ( typeArguments , m . getGenericParameterTypes () [ i ] ) ;
if ( ! TypeUtils . equals ( childType , parentType ) ) {
continue hierarchyTraversal;
}
}
result . add ( m ) ;
}
return result ;
}
public static Method [] getMethodsWithAnnotation ( final Class < ? > cls , final Class < ? extends Annotation > annotationCls ) {
final List < Method > annotatedMethodsList = getMethodsListWithAnnotation ( cls , annotationCls ) ;
return annotatedMethodsList . toArray ( new Method [ annotatedMethodsList . size () ] ) ;
}
public static List < Method > getMethodsListWithAnnotation ( final Class < ? > cls , final Class < ? extends Annotation > annotationCls ) {
Validate . isTrue ( cls != null , lr_4 ) ;
Validate . isTrue ( annotationCls != null , lr_5 ) ;
final Method [] allMethods = cls . getMethods () ;
final List < Method > annotatedMethods = new ArrayList < Method > () ;
for ( final Method method : allMethods ) {
if ( method . getAnnotation ( annotationCls ) != null ) {
annotatedMethods . add ( method ) ;
}
}
return annotatedMethods ;
}

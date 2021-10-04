@Override
protected String getShortClassName ( final java . lang . Class < ? > cls ) {
Class < ? extends Annotation > annotationType = null ;
for ( final Class < ? > iface : ClassUtils . getAllInterfaces ( cls ) ) {
if ( Annotation . class . isAssignableFrom ( iface ) ) {
@SuppressWarnings ( lr_1 )
final
Class < ? extends Annotation > found = ( Class < ? extends Annotation > ) iface ;
annotationType = found ;
break;
}
}
return new StringBuilder ( annotationType == null ? lr_2 : annotationType . getName () ) MST[NonVoidMethodCallMutator]MSP[]
. insert ( 0 , '@' ) . toString () ;
}
@Override
protected void appendDetail ( final StringBuffer buffer , final String fieldName , Object value ) {
if ( value instanceof Annotation ) {
value = AnnotationUtils . toString ( ( Annotation ) value ) ;
}
super . appendDetail ( buffer , fieldName , value ) ;
}
public static boolean equals ( final Annotation a1 , final Annotation a2 ) {
if ( a1 == a2 ) {
return true ;
}
if ( a1 == null || a2 == null ) {
return false ;
}
final Class < ? extends Annotation > type = a1 . annotationType () ;
final Class < ? extends Annotation > type2 = a2 . annotationType () ;
Validate . notNull ( type , lr_3 , a1 ) ;
Validate . notNull ( type2 , lr_3 , a2 ) ;
if ( ! type . equals ( type2 ) ) {
return false ;
}
try {
for ( final Method m : type . getDeclaredMethods () ) {
if ( m . getParameterTypes () . length == 0
&& isValidAnnotationMemberType ( m . getReturnType () ) ) {
final Object v1 = m . invoke ( a1 ) ;
final Object v2 = m . invoke ( a2 ) ;
if ( ! memberEquals ( m . getReturnType () , v1 , v2 ) ) {
return false ;
}
}
}
} catch ( final IllegalAccessException ex ) {
return false ;
} catch ( final InvocationTargetException ex ) {
return false ;
}
return true ;
}
public static int hashCode ( final Annotation a ) {
int result = 0 ;
final Class < ? extends Annotation > type = a . annotationType () ;
for ( final Method m : type . getDeclaredMethods () ) {
try {
final Object value = m . invoke ( a ) ;
if ( value == null ) {
throw new IllegalStateException (
String . format ( lr_4 , m ) ) ;
}
result += hashMember ( m . getName () , value ) ;
} catch ( final RuntimeException ex ) {
throw ex ;
} catch ( final Exception ex ) {
throw new RuntimeException ( ex ) ;
}
}
return result ;
}
public static String toString ( final Annotation a ) {
final ToStringBuilder builder = new ToStringBuilder ( a , TO_STRING_STYLE ) ;
for ( final Method m : a . annotationType () . getDeclaredMethods () ) {
if ( m . getParameterTypes () . length > 0 ) {
continue;
}
try {
builder . append ( m . getName () , m . invoke ( a ) ) ;
} catch ( final RuntimeException ex ) {
throw ex ;
} catch ( final Exception ex ) {
throw new RuntimeException ( ex ) ;
}
}
return builder . build () ;
}
public static boolean isValidAnnotationMemberType ( Class < ? > type ) {
if ( type == null ) {
return false ;
}
if ( type . isArray () ) {
type = type . getComponentType () ;
}
return type . isPrimitive () || type . isEnum () || type . isAnnotation ()
|| String . class . equals ( type ) || Class . class . equals ( type ) ;
}
private static int hashMember ( final String name , final Object value ) {
final int part1 = name . hashCode () * 127 ;
if ( value . getClass () . isArray () ) {
return part1 ^ arrayMemberHash ( value . getClass () . getComponentType () , value ) ;
}
if ( value instanceof Annotation ) {
return part1 ^ hashCode ( ( Annotation ) value ) ;
}
return part1 ^ value . hashCode () ;
}
private static boolean memberEquals ( final Class < ? > type , final Object o1 , final Object o2 ) {
if ( o1 == o2 ) {
return true ;
}
if ( o1 == null || o2 == null ) {
return false ;
}
if ( type . isArray () ) {
return arrayMemberEquals ( type . getComponentType () , o1 , o2 ) ;
}
if ( type . isAnnotation () ) {
return equals ( ( Annotation ) o1 , ( Annotation ) o2 ) ;
}
return o1 . equals ( o2 ) ;
}
private static boolean arrayMemberEquals ( final Class < ? > componentType , final Object o1 , final Object o2 ) {
if ( componentType . isAnnotation () ) {
return annotationArrayMemberEquals ( ( Annotation [] ) o1 , ( Annotation [] ) o2 ) ;
}
if ( componentType . equals ( Byte . TYPE ) ) {
return Arrays . equals ( ( byte [] ) o1 , ( byte [] ) o2 ) ;
}
if ( componentType . equals ( Short . TYPE ) ) {
return Arrays . equals ( ( short [] ) o1 , ( short [] ) o2 ) ;
}
if ( componentType . equals ( Integer . TYPE ) ) {
return Arrays . equals ( ( int [] ) o1 , ( int [] ) o2 ) ;
}
if ( componentType . equals ( Character . TYPE ) ) {
return Arrays . equals ( ( char [] ) o1 , ( char [] ) o2 ) ;
}
if ( componentType . equals ( Long . TYPE ) ) {
return Arrays . equals ( ( long [] ) o1 , ( long [] ) o2 ) ;
}
if ( componentType . equals ( Float . TYPE ) ) {
return Arrays . equals ( ( float [] ) o1 , ( float [] ) o2 ) ;
}
if ( componentType . equals ( Double . TYPE ) ) {
return Arrays . equals ( ( double [] ) o1 , ( double [] ) o2 ) ;
}
if ( componentType . equals ( Boolean . TYPE ) ) {
return Arrays . equals ( ( boolean [] ) o1 , ( boolean [] ) o2 ) ;
}
return Arrays . equals ( ( Object [] ) o1 , ( Object [] ) o2 ) ;
}
private static boolean annotationArrayMemberEquals ( final Annotation [] a1 , final Annotation [] a2 ) {
if ( a1 . length != a2 . length ) {
return false ;
}
for ( int i = 0 ; i < a1 . length ; i ++ ) {
if ( ! equals ( a1 [ i ] , a2 [ i ] ) ) {
return false ;
}
}
return true ;
}
private static int arrayMemberHash ( final Class < ? > componentType , final Object o ) {
if ( componentType . equals ( Byte . TYPE ) ) {
return Arrays . hashCode ( ( byte [] ) o ) ;
}
if ( componentType . equals ( Short . TYPE ) ) {
return Arrays . hashCode ( ( short [] ) o ) ;
}
if ( componentType . equals ( Integer . TYPE ) ) {
return Arrays . hashCode ( ( int [] ) o ) ;
}
if ( componentType . equals ( Character . TYPE ) ) {
return Arrays . hashCode ( ( char [] ) o ) ;
}
if ( componentType . equals ( Long . TYPE ) ) {
return Arrays . hashCode ( ( long [] ) o ) ;
}
if ( componentType . equals ( Float . TYPE ) ) {
return Arrays . hashCode ( ( float [] ) o ) ;
}
if ( componentType . equals ( Double . TYPE ) ) {
return Arrays . hashCode ( ( double [] ) o ) ;
}
if ( componentType . equals ( Boolean . TYPE ) ) {
return Arrays . hashCode ( ( boolean [] ) o ) ;
}
return Arrays . hashCode ( ( Object [] ) o ) ;
}

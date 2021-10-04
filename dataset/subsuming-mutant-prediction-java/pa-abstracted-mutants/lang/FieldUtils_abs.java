public static Field getField ( final Class < ? > cls , final String fieldName ) {
final Field field = getField ( cls , fieldName , false ) ;
MemberUtils . setAccessibleWorkaround ( field ) ;
return field ;
}
public static Field getField ( final Class < ? > cls , final String fieldName , final boolean forceAccess ) {
Validate . isTrue ( cls != null , lr_1 ) ;
Validate . isTrue ( StringUtils . isNotBlank ( fieldName ) , lr_2 ) ;
for ( Class < ? > acls = cls ; acls != null ; acls = acls . getSuperclass () ) {
try {
final Field field = acls . getDeclaredField ( fieldName ) ;
if ( ! Modifier . isPublic ( field . getModifiers () ) ) {
if ( forceAccess ) {
field . setAccessible ( true ) ;
} else {
continue;
}
}
return field ;
} catch ( final NoSuchFieldException ex ) {
}
}
Field match = null ;
for ( final Class < ? > class1 : ClassUtils . getAllInterfaces ( cls ) ) {
try {
final Field test = class1 . getField ( fieldName ) ;
Validate . isTrue ( match == null , lr_3
+ lr_4 , fieldName , cls ) ;
match = test ;
} catch ( final NoSuchFieldException ex ) {
}
}
return match ;
}
public static Field getDeclaredField ( final Class < ? > cls , final String fieldName ) {
return getDeclaredField ( cls , fieldName , false ) ;
}
public static Field getDeclaredField ( final Class < ? > cls , final String fieldName , final boolean forceAccess ) {
Validate . isTrue ( cls != null , lr_1 ) ;
Validate . isTrue ( StringUtils . isNotBlank ( fieldName ) , lr_2 ) ;
try {
final Field field = cls . getDeclaredField ( fieldName ) ;
if ( ! MemberUtils . isAccessible ( field ) ) {
if ( forceAccess ) {
field . setAccessible ( true ) ;
} else {
return null ;
}
}
return field ;
} catch ( final NoSuchFieldException e ) {
}
return null ;
}
public static Field [] getAllFields ( final Class < ? > cls ) {
final List < Field > allFieldsList = getAllFieldsList ( cls ) ;
return allFieldsList . toArray ( new Field [ allFieldsList . size () ] ) ;
}
public static List < Field > getAllFieldsList ( final Class < ? > cls ) {
Validate . isTrue ( cls != null , lr_1 ) ;
final List < Field > allFields = new ArrayList < Field > () ;
Class < ? > currentClass = cls ;
while ( currentClass != null ) {
final Field [] declaredFields = currentClass . getDeclaredFields () ;
for ( final Field field : declaredFields ) {
allFields . add ( field ) ;
}
currentClass = currentClass . getSuperclass () ;
}
return allFields ;
}
public static Field [] getFieldsWithAnnotation ( final Class < ? > cls , final Class < ? extends Annotation > annotationCls ) {
final List < Field > annotatedFieldsList = getFieldsListWithAnnotation ( cls , annotationCls ) ;
return annotatedFieldsList . toArray ( new Field [ annotatedFieldsList . size () ] ) ;
}
public static List < Field > getFieldsListWithAnnotation ( final Class < ? > cls , final Class < ? extends Annotation > annotationCls ) {
Validate . isTrue ( annotationCls != null , lr_5 ) ;
final List < Field > allFields = getAllFieldsList ( cls ) ;
final List < Field > annotatedFields = new ArrayList < Field > () ;
for ( final Field field : allFields ) {
if ( field . getAnnotation ( annotationCls ) != null ) {
annotatedFields . add ( field ) ;
}
}
return annotatedFields ;
}
public static Object readStaticField ( final Field field ) throws IllegalAccessException {
return readStaticField ( field , false ) ;
}
public static Object readStaticField ( final Field field , final boolean forceAccess ) throws IllegalAccessException {
Validate . isTrue ( field != null , lr_6 ) ;
Validate . isTrue ( Modifier . isStatic ( field . getModifiers () ) , lr_7 , field . getName () ) ;
return readField ( field , ( Object ) null , forceAccess ) ;
}
public static Object readStaticField ( final Class < ? > cls , final String fieldName ) throws IllegalAccessException {
return readStaticField ( cls , fieldName , false ) ;
}
public static Object readStaticField ( final Class < ? > cls , final String fieldName , final boolean forceAccess ) throws IllegalAccessException {
final Field field = getField ( cls , fieldName , forceAccess ) ;
Validate . isTrue ( field != null , lr_8 , fieldName , cls ) ;
return readStaticField ( field , false ) ;
}
public static Object readDeclaredStaticField ( final Class < ? > cls , final String fieldName ) throws IllegalAccessException {
return readDeclaredStaticField ( cls , fieldName , false ) ;
}
public static Object readDeclaredStaticField ( final Class < ? > cls , final String fieldName , final boolean forceAccess ) throws IllegalAccessException {
final Field field = getDeclaredField ( cls , fieldName , forceAccess ) ;
Validate . isTrue ( field != null , lr_9 , cls . getName () , fieldName ) ;
return readStaticField ( field , false ) ;
}
public static Object readField ( final Field field , final Object target ) throws IllegalAccessException {
return readField ( field , target , false ) ;
}
public static Object readField ( final Field field , final Object target , final boolean forceAccess ) throws IllegalAccessException {
Validate . isTrue ( field != null , lr_6 ) ;
if ( forceAccess && ! field . isAccessible () ) {
field . setAccessible ( true ) ;
} else {
MemberUtils . setAccessibleWorkaround ( field ) ;
}
return field . get ( target ) ;
}
public static Object readField ( final Object target , final String fieldName ) throws IllegalAccessException {
return readField ( target , fieldName , false ) ;
}
public static Object readField ( final Object target , final String fieldName , final boolean forceAccess ) throws IllegalAccessException {
Validate . isTrue ( target != null , lr_10 ) ;
final Class < ? > cls = target . getClass () ;
final Field field = getField ( cls , fieldName , forceAccess ) ;
Validate . isTrue ( field != null , lr_11 , fieldName , cls ) ;
return readField ( field , target , false ) ;
}
public static Object readDeclaredField ( final Object target , final String fieldName ) throws IllegalAccessException {
return readDeclaredField ( target , fieldName , false ) ;
}
public static Object readDeclaredField ( final Object target , final String fieldName , final boolean forceAccess ) throws IllegalAccessException {
Validate . isTrue ( target != null , lr_10 ) ;
final Class < ? > cls = target . getClass () ;
final Field field = getDeclaredField ( cls , fieldName , forceAccess ) ;
Validate . isTrue ( field != null , lr_9 , cls , fieldName ) ;
return readField ( field , target , false ) ;
}
public static void writeStaticField ( final Field field , final Object value ) throws IllegalAccessException {
writeStaticField ( field , value , false ) ;
}
public static void writeStaticField ( final Field field , final Object value , final boolean forceAccess ) throws IllegalAccessException {
Validate . isTrue ( field != null , lr_6 ) ;
Validate . isTrue ( Modifier . isStatic ( field . getModifiers () ) , lr_12 , field . getDeclaringClass () . getName () ,
field . getName () ) ;
writeField ( field , ( Object ) null , value , forceAccess ) ;
}
public static void writeStaticField ( final Class < ? > cls , final String fieldName , final Object value ) throws IllegalAccessException {
writeStaticField ( cls , fieldName , value , false ) ;
}
public static void writeStaticField ( final Class < ? > cls , final String fieldName , final Object value , final boolean forceAccess )
throws IllegalAccessException {
final Field field = getField ( cls , fieldName , forceAccess ) ;
Validate . isTrue ( field != null , lr_11 , fieldName , cls ) ;
writeStaticField ( field , value , false ) ;
}
public static void writeDeclaredStaticField ( final Class < ? > cls , final String fieldName , final Object value ) throws IllegalAccessException {
writeDeclaredStaticField ( cls , fieldName , value , false ) ;
}
public static void writeDeclaredStaticField ( final Class < ? > cls , final String fieldName , final Object value , final boolean forceAccess )
throws IllegalAccessException {
final Field field = getDeclaredField ( cls , fieldName , forceAccess ) ;
Validate . isTrue ( field != null , lr_9 , cls . getName () , fieldName ) ;
writeField ( field , ( Object ) null , value , false ) ;
}
public static void writeField ( final Field field , final Object target , final Object value ) throws IllegalAccessException {
writeField ( field , target , value , false ) ;
}
public static void writeField ( final Field field , final Object target , final Object value , final boolean forceAccess )
throws IllegalAccessException {
Validate . isTrue ( field != null , lr_6 ) ;
if ( forceAccess && ! field . isAccessible () ) {
field . setAccessible ( true ) ;
} else {
MemberUtils . setAccessibleWorkaround ( field ) ;
}
field . set ( target , value ) ;
}
public static void removeFinalModifier ( final Field field ) {
removeFinalModifier ( field , true ) ;
}
public static void removeFinalModifier ( final Field field , final boolean forceAccess ) {
Validate . isTrue ( field != null , lr_6 ) ;
try {
if ( Modifier . isFinal ( field . getModifiers () ) ) {
final Field modifiersField = Field . class . getDeclaredField ( lr_13 ) ;
final boolean doForceAccess = forceAccess && ! modifiersField . isAccessible () ;
if ( doForceAccess ) {
modifiersField . setAccessible ( true ) ;
}
try {
modifiersField . setInt ( field , field . getModifiers () & ~ Modifier . FINAL ) ;
} finally {
if ( doForceAccess ) {
modifiersField . setAccessible ( false ) ;
}
}
}
} catch ( final NoSuchFieldException ignored ) {
} catch ( final IllegalAccessException ignored ) {
}
}
public static void writeField ( final Object target , final String fieldName , final Object value ) throws IllegalAccessException {
writeField ( target , fieldName , value , false ) ;
}
public static void writeField ( final Object target , final String fieldName , final Object value , final boolean forceAccess )
throws IllegalAccessException {
Validate . isTrue ( target != null , lr_10 ) ;
final Class < ? > cls = target . getClass () ;
final Field field = getField ( cls , fieldName , forceAccess ) ;
Validate . isTrue ( field != null , lr_9 , cls . getName () , fieldName ) ;
writeField ( field , target , value , false ) ;
}
public static void writeDeclaredField ( final Object target , final String fieldName , final Object value ) throws IllegalAccessException {
writeDeclaredField ( target , fieldName , value , false ) ;
}
public static void writeDeclaredField ( final Object target , final String fieldName , final Object value , final boolean forceAccess )
throws IllegalAccessException {
Validate . isTrue ( target != null , lr_10 ) ;
final Class < ? > cls = target . getClass () ;
final Field field = getDeclaredField ( cls , fieldName , forceAccess ) ;
Validate . isTrue ( field != null , lr_9 , cls . getName () , fieldName ) ;
writeField ( field , target , value , false ) ;
}

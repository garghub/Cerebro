static boolean setAccessibleWorkaround ( final AccessibleObject o ) {
if ( o == null || o . isAccessible () ) {
return false ;
}
final Member m = ( Member ) o ;
if ( ! o . isAccessible () && Modifier . isPublic ( m . getModifiers () ) && isPackageAccess ( m . getDeclaringClass () . getModifiers () ) ) {
try {
o . setAccessible ( true ) ;
return true ;
} catch ( final SecurityException e ) {
}
}
return false ;
}
static boolean isPackageAccess ( final int modifiers ) {
return ( modifiers & ACCESS_TEST ) == 0 ;
}
static boolean isAccessible ( final Member m ) {
return m != null && Modifier . isPublic ( m . getModifiers () ) && ! m . isSynthetic () ;
}
static int compareParameterTypes ( final Class < ? > [] left , final Class < ? > [] right , final Class < ? > [] actual ) {
final float leftCost = getTotalTransformationCost ( actual , left ) ;
final float rightCost = getTotalTransformationCost ( actual , right ) ;
return leftCost < rightCost ? - 1 : rightCost < leftCost ? 1 : 0 ;
}
private static float getTotalTransformationCost ( final Class < ? > [] srcArgs , final Class < ? > [] destArgs ) {
float totalCost = 0.0f ;
for ( int i = 0 ; i < srcArgs . length ; i ++ ) {
Class < ? > srcClass , destClass ;
srcClass = srcArgs [ i ] ;
destClass = destArgs [ i ] ;
totalCost += getObjectTransformationCost ( srcClass , destClass ) ;
}
return totalCost ;
}
private static float getObjectTransformationCost ( Class < ? > srcClass , final Class < ? > destClass ) {
if ( destClass . isPrimitive () ) {
return getPrimitivePromotionCost ( srcClass , destClass ) ;
}
float cost = 0.0f ;
while ( srcClass != null && ! destClass . equals ( srcClass ) ) {
if ( destClass . isInterface () && ClassUtils . isAssignable ( srcClass , destClass ) ) {
cost += 0.25f ;
break;
}
cost ++ ;
srcClass = srcClass . getSuperclass () ;
}
if ( srcClass == null ) {
cost += 1.5f ;
}
return cost ;
}
private static float getPrimitivePromotionCost ( final Class < ? > srcClass , final Class < ? > destClass ) {
float cost = 0.0f ;
Class < ? > cls = srcClass ;
if ( ! cls . isPrimitive () ) {
cost += 0.1f ;
cls = ClassUtils . wrapperToPrimitive ( cls ) ;
}
for ( int i = 0 ; cls != destClass && i < ORDERED_PRIMITIVE_TYPES . length ; i ++ ) {
if ( cls == ORDERED_PRIMITIVE_TYPES [ i ] ) {
cost += 0.1f ;
if ( i < ORDERED_PRIMITIVE_TYPES . length - 1 ) {
cls = ORDERED_PRIMITIVE_TYPES [ i + 1 ] ;
}
}
}
return cost ;
}

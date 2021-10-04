public WildcardTypeBuilder withUpperBounds ( final Type ... bounds ) {
this . upperBounds = bounds ;
return this ;
}
public WildcardTypeBuilder withLowerBounds ( final Type ... bounds ) {
this . lowerBounds = bounds ;
return this ;
}
@Override
public WildcardType build () {
return new WildcardTypeImpl ( upperBounds , lowerBounds ) ;
}
@Override
public Type getGenericComponentType () {
return componentType ;
}
@Override
public String toString () {
return TypeUtils . toString ( this ) ;
}
@Override
public boolean equals ( final Object obj ) {
return obj == this || obj instanceof GenericArrayType && TypeUtils . equals ( this , ( GenericArrayType ) obj ) ;
}
@Override
public int hashCode () {
int result = 67 << 4 ;
result |= componentType . hashCode () ;
return result ;
}
@Override
public Type getRawType () {
return raw ;
}
@Override
public Type getOwnerType () {
return useOwner ;
}
@Override
public Type [] getActualTypeArguments () {
return typeArguments . clone () ;
}
@Override
public String toString () {
return TypeUtils . toString ( this ) ;
}
@Override
public boolean equals ( final Object obj ) {
return obj == this || obj instanceof ParameterizedType && TypeUtils . equals ( this , ( ( ParameterizedType ) obj ) ) ;
}
@SuppressWarnings ( lr_1 )
@Override
public int hashCode () {
int result = 71 << 4 ;
result |= raw . hashCode () ;
result <<= 4 ;
result |= ObjectUtils . hashCode ( useOwner ) ;
result <<= 8 ;
result |= Arrays . hashCode ( typeArguments ) ;
return result ;
}
@Override
public Type [] getUpperBounds () {
return upperBounds . clone () ;
}
@Override
public Type [] getLowerBounds () {
return lowerBounds . clone () ;
}
@Override
public String toString () {
return TypeUtils . toString ( this ) ;
}
@Override
public boolean equals ( final Object obj ) {
return obj == this || obj instanceof WildcardType && TypeUtils . equals ( this , ( WildcardType ) obj ) ;
}
@Override
public int hashCode () {
int result = 73 << 8 ;
result |= Arrays . hashCode ( upperBounds ) ;
result <<= 8 ;
result |= Arrays . hashCode ( lowerBounds ) ;
return result ;
}
public static boolean isAssignable ( final Type type , final Type toType ) {
return isAssignable ( type , toType , null ) ;
}
private static boolean isAssignable ( final Type type , final Type toType ,
final Map < TypeVariable < ? > , Type > typeVarAssigns ) {
if ( toType == null || toType instanceof Class < ? > ) {
return isAssignable ( type , ( Class < ? > ) toType ) ;
}
if ( toType instanceof ParameterizedType ) {
return isAssignable ( type , ( ParameterizedType ) toType , typeVarAssigns ) ;
}
if ( toType instanceof GenericArrayType ) {
return isAssignable ( type , ( GenericArrayType ) toType , typeVarAssigns ) ;
}
if ( toType instanceof WildcardType ) {
return isAssignable ( type , ( WildcardType ) toType , typeVarAssigns ) ;
}
if ( toType instanceof TypeVariable < ? > ) {
return isAssignable ( type , ( TypeVariable < ? > ) toType , typeVarAssigns ) ;
}
throw new IllegalStateException ( lr_2 + toType ) ;
}
private static boolean isAssignable ( final Type type , final Class < ? > toClass ) {
if ( type == null ) {
return toClass == null || ! toClass . isPrimitive () ;
}
if ( toClass == null ) {
return false ;
}
if ( toClass . equals ( type ) ) {
return true ;
}
if ( type instanceof Class < ? > ) {
return ClassUtils . isAssignable ( ( Class < ? > ) type , toClass ) ;
}
if ( type instanceof ParameterizedType ) {
return isAssignable ( getRawType ( ( ParameterizedType ) type ) , toClass ) ;
}
if ( type instanceof TypeVariable < ? > ) {
for ( final Type bound : ( ( TypeVariable < ? > ) type ) . getBounds () ) {
if ( isAssignable ( bound , toClass ) ) {
return true ;
}
}
return false ;
}
private static boolean isAssignable ( final Type type , final ParameterizedType toParameterizedType ,
final Map < TypeVariable < ? > , Type > typeVarAssigns ) {
if ( type == null ) {
return true ;
}
if ( toParameterizedType == null ) {
return false ;
}
if ( toParameterizedType . equals ( type ) ) {
return true ;
}
final Class < ? > toClass = getRawType ( toParameterizedType ) ;
final Map < TypeVariable < ? > , Type > fromTypeVarAssigns = getTypeArguments ( type , toClass , null ) ;
if ( fromTypeVarAssigns == null ) {
return false ;
}
if ( fromTypeVarAssigns . isEmpty () ) {
return true ;
}
final Map < TypeVariable < ? > , Type > toTypeVarAssigns = getTypeArguments ( toParameterizedType ,
toClass , typeVarAssigns ) ;
for ( final TypeVariable < ? > var : toTypeVarAssigns . keySet () ) {
final Type toTypeArg = unrollVariableAssignments ( var , toTypeVarAssigns ) ;
final Type fromTypeArg = unrollVariableAssignments ( var , fromTypeVarAssigns ) ;
if ( fromTypeArg != null
&& ! toTypeArg . equals ( fromTypeArg )
&& ! ( toTypeArg instanceof WildcardType && isAssignable ( fromTypeArg , toTypeArg ,
typeVarAssigns ) ) ) {
return false ;
}
}
return true ;
}
private static Type unrollVariableAssignments ( TypeVariable < ? > var , final Map < TypeVariable < ? > , Type > typeVarAssigns ) {
Type result ;
do {
result = typeVarAssigns . get ( var ) ;
if ( result instanceof TypeVariable < ? > && ! result . equals ( var ) ) {
var = ( TypeVariable < ? > ) result ;
continue;
}
break;
} while ( true );
return result ;
}
private static boolean isAssignable ( final Type type , final GenericArrayType toGenericArrayType ,
final Map < TypeVariable < ? > , Type > typeVarAssigns ) {
if ( type == null ) {
return true ;
}
if ( toGenericArrayType == null ) {
return false ;
}
if ( toGenericArrayType . equals ( type ) ) {
return true ;
}
final Type toComponentType = toGenericArrayType . getGenericComponentType () ;
if ( type instanceof Class < ? > ) {
final Class < ? > cls = ( Class < ? > ) type ;
return cls . isArray ()
&& isAssignable ( cls . getComponentType () , toComponentType , typeVarAssigns ) ;
}
if ( type instanceof GenericArrayType ) {
return isAssignable ( ( ( GenericArrayType ) type ) . getGenericComponentType () ,
toComponentType , typeVarAssigns ) ;
}
if ( type instanceof WildcardType ) {
for ( final Type bound : getImplicitUpperBounds ( ( WildcardType ) type ) ) {
if ( isAssignable ( bound , toGenericArrayType ) ) {
return true ;
}
}
return false ;
}
if ( type instanceof TypeVariable < ? > ) {
for ( final Type bound : getImplicitBounds ( ( TypeVariable < ? > ) type ) ) {
if ( isAssignable ( bound , toGenericArrayType ) ) {
return true ;
}
}
return false ;
}
static boolean isAssignable ( final Type type , final WildcardType toWildcardType ,
final Map < TypeVariable < ? > , Type > typeVarAssigns ) {
if ( type == null ) {
return true ;
}
if ( toWildcardType == null ) {
return false ;
}
if ( toWildcardType . equals ( type ) ) {
return true ;
}
final Type [] toUpperBounds = getImplicitUpperBounds ( toWildcardType ) ;
final Type [] toLowerBounds = getImplicitLowerBounds ( toWildcardType ) ;
if ( type instanceof WildcardType ) {
final WildcardType wildcardType = ( WildcardType ) type ;
final Type [] upperBounds = getImplicitUpperBounds ( wildcardType ) ;
final Type [] lowerBounds = getImplicitLowerBounds ( wildcardType ) ;
for ( Type toBound : toUpperBounds ) {
toBound = substituteTypeVariables ( toBound , typeVarAssigns ) ;
for ( final Type bound : upperBounds ) {
if ( ! isAssignable ( bound , toBound , typeVarAssigns ) ) {
return false ;
}
}
}
for ( Type toBound : toLowerBounds ) {
toBound = substituteTypeVariables ( toBound , typeVarAssigns ) ;
for ( final Type bound : lowerBounds ) {
if ( ! isAssignable ( toBound , bound , typeVarAssigns ) ) {
return false ;
}
}
}
return true ;
}
for ( final Type toBound : toUpperBounds ) {
if ( ! isAssignable ( type , substituteTypeVariables ( toBound , typeVarAssigns ) ,
typeVarAssigns ) ) {
return false ;
}
}
for ( final Type toBound : toLowerBounds ) {
if ( ! isAssignable ( substituteTypeVariables ( toBound , typeVarAssigns ) , type ,
typeVarAssigns ) ) {
return false ;
}
}
return true ;
}
private static boolean isAssignable ( final Type type , final TypeVariable < ? > toTypeVariable ,
final Map < TypeVariable < ? > , Type > typeVarAssigns ) {
if ( type == null ) {
return true ;
}
if ( toTypeVariable == null ) {
return false ;
}
if ( toTypeVariable . equals ( type ) ) {
return true ;
}
if ( type instanceof TypeVariable < ? > ) {
final Type [] bounds = getImplicitBounds ( ( TypeVariable < ? > ) type ) ;
for ( final Type bound : bounds ) {
if ( isAssignable ( bound , toTypeVariable , typeVarAssigns ) ) {
return true ;
}
}
}
static Type substituteTypeVariables ( final Type type , final Map < TypeVariable < ? > , Type > typeVarAssigns ) {
if ( type instanceof TypeVariable < ? > && typeVarAssigns != null ) {
final Type replacementType = typeVarAssigns . get ( type ) ;
if ( replacementType == null ) {
throw new IllegalArgumentException ( lr_3
+ type ) ;
}
return replacementType ;
}
static Map < TypeVariable < ? > , Type > getTypeArguments ( final ParameterizedType type ) {
return getTypeArguments ( type , getRawType ( type ) , null ) ;
}
public static Map < TypeVariable < ? > , Type > getTypeArguments ( final Type type , final Class < ? > toClass ) {
return getTypeArguments ( type , toClass , null ) ;
}
private static Map < TypeVariable < ? > , Type > getTypeArguments ( final Type type , final Class < ? > toClass ,
final Map < TypeVariable < ? > , Type > subtypeVarAssigns ) {
if ( type instanceof Class < ? > ) {
return getTypeArguments ( ( Class < ? > ) type , toClass , subtypeVarAssigns ) ;
}
if ( type instanceof ParameterizedType ) {
return getTypeArguments ( ( ParameterizedType ) type , toClass , subtypeVarAssigns ) ;
}
if ( type instanceof GenericArrayType ) {
return getTypeArguments ( ( ( GenericArrayType ) type ) . getGenericComponentType () , toClass
. isArray () ? toClass . getComponentType () : toClass , subtypeVarAssigns ) ;
}
if ( type instanceof WildcardType ) {
for ( final Type bound : getImplicitUpperBounds ( ( WildcardType ) type ) ) {
if ( isAssignable ( bound , toClass ) ) {
return getTypeArguments ( bound , toClass , subtypeVarAssigns ) ;
}
}
return null ;
}
if ( type instanceof TypeVariable < ? > ) {
for ( final Type bound : getImplicitBounds ( ( TypeVariable < ? > ) type ) ) {
if ( isAssignable ( bound , toClass ) ) {
return getTypeArguments ( bound , toClass , subtypeVarAssigns ) ;
}
}
return null ;
}
static Map < TypeVariable < ? > , Type > getTypeArguments (
final ParameterizedType parameterizedType , final Class < ? > toClass ,
final Map < TypeVariable < ? > , Type > subtypeVarAssigns ) {
final Class < ? > cls = getRawType ( parameterizedType ) ;
if ( ! isAssignable ( cls , toClass ) ) {
return null ;
}
final Type ownerType = parameterizedType . getOwnerType () ;
Map < TypeVariable < ? > , Type > typeVarAssigns ;
if ( ownerType instanceof ParameterizedType ) {
final ParameterizedType parameterizedOwnerType = ( ParameterizedType ) ownerType ;
typeVarAssigns = getTypeArguments ( parameterizedOwnerType ,
getRawType ( parameterizedOwnerType ) , subtypeVarAssigns ) ;
} else {
typeVarAssigns = subtypeVarAssigns == null ? new HashMap < TypeVariable < ? > , Type > ()
: new HashMap < TypeVariable < ? > , Type > ( subtypeVarAssigns ) ;
}
final Type [] typeArgs = parameterizedType . getActualTypeArguments () ;
final TypeVariable < ? > [] typeParams = cls . getTypeParameters () ;
for ( int i = 0 ; i < typeParams . length ; i ++ ) {
final Type typeArg = typeArgs [ i ] ;
typeVarAssigns . put ( typeParams [ i ] , typeVarAssigns . containsKey ( typeArg ) ? typeVarAssigns
. get ( typeArg ) : typeArg ) ;
}
if ( toClass . equals ( cls ) ) {
return typeVarAssigns ;
}
return getTypeArguments ( getClosestParentType ( cls , toClass ) , toClass , typeVarAssigns ) ;
}
private static Map < TypeVariable < ? > , Type > getTypeArguments ( Class < ? > cls , final Class < ? > toClass ,
final Map < TypeVariable < ? > , Type > subtypeVarAssigns ) {
if ( ! isAssignable ( cls , toClass ) ) {
return null ;
}
if ( cls . isPrimitive () ) {
if ( toClass . isPrimitive () ) {
return new HashMap < TypeVariable < ? > , Type > () ;
}
cls = ClassUtils . primitiveToWrapper ( cls ) ;
}
final HashMap < TypeVariable < ? > , Type > typeVarAssigns = subtypeVarAssigns == null ? new HashMap < TypeVariable < ? > , Type > ()
: new HashMap < TypeVariable < ? > , Type > ( subtypeVarAssigns ) ;
if ( toClass . equals ( cls ) ) {
return typeVarAssigns ;
}
return getTypeArguments ( getClosestParentType ( cls , toClass ) , toClass , typeVarAssigns ) ;
}
public static Map < TypeVariable < ? > , Type > determineTypeArguments ( final Class < ? > cls ,
final ParameterizedType superType ) {
Validate . notNull ( cls , lr_4 ) ;
Validate . notNull ( superType , lr_5 ) ;
final Class < ? > superClass = getRawType ( superType ) ;
if ( ! isAssignable ( cls , superClass ) ) {
return null ;
}
if ( cls . equals ( superClass ) ) {
return getTypeArguments ( superType , superClass , null ) ;
}
final Type midType = getClosestParentType ( cls , superClass ) ;
if ( midType instanceof Class < ? > ) {
return determineTypeArguments ( ( Class < ? > ) midType , superType ) ;
}
final ParameterizedType midParameterizedType = ( ParameterizedType ) midType ;
final Class < ? > midClass = getRawType ( midParameterizedType ) ;
final Map < TypeVariable < ? > , Type > typeVarAssigns = determineTypeArguments ( midClass , superType ) ;
mapTypeVariablesToArguments ( cls , midParameterizedType , typeVarAssigns ) ;
return typeVarAssigns ;
}
private static < T > void mapTypeVariablesToArguments ( final Class < T > cls ,
final ParameterizedType parameterizedType , final Map < TypeVariable < ? > , Type > typeVarAssigns ) {
final Type ownerType = parameterizedType . getOwnerType () ;
if ( ownerType instanceof ParameterizedType ) {
mapTypeVariablesToArguments ( cls , ( ParameterizedType ) ownerType , typeVarAssigns ) ;
}
final Type [] typeArgs = parameterizedType . getActualTypeArguments () ;
final TypeVariable < ? > [] typeVars = getRawType ( parameterizedType ) . getTypeParameters () ;
final List < TypeVariable < Class < T > > > typeVarList = Arrays . asList ( cls
. getTypeParameters () ) ;
for ( int i = 0 ; i < typeArgs . length ; i ++ ) {
final TypeVariable < ? > typeVar = typeVars [ i ] ;
final Type typeArg = typeArgs [ i ] ;
if ( typeVarList . contains ( typeArg )
&& typeVarAssigns . containsKey ( typeVar ) ) {
typeVarAssigns . put ( ( TypeVariable < ? > ) typeArg , typeVarAssigns . get ( typeVar ) ) ;
}
}
}
private static Type getClosestParentType ( final Class < ? > cls , final Class < ? > superClass ) {
if ( superClass . isInterface () ) {
final Type [] interfaceTypes = cls . getGenericInterfaces () ;
Type genericInterface = null ;
for ( final Type midType : interfaceTypes ) {
Class < ? > midClass = null ;
if ( midType instanceof ParameterizedType ) {
midClass = getRawType ( ( ParameterizedType ) midType ) ;
} else if ( midType instanceof Class < ? > ) {
midClass = ( Class < ? > ) midType ;
} else {
throw new IllegalStateException ( lr_6
+ lr_7 + midType ) ;
}
if ( isAssignable ( midClass , superClass )
&& isAssignable ( genericInterface , ( Type ) midClass ) ) {
genericInterface = midType ;
}
}
if ( genericInterface != null ) {
return genericInterface ;
}
}
return cls . getGenericSuperclass () ;
}
public static boolean isInstance ( final Object value , final Type type ) {
if ( type == null ) {
return false ;
}
return value == null ? ! ( type instanceof Class < ? > ) || ! ( ( Class < ? > ) type ) . isPrimitive ()
: isAssignable ( value . getClass () , type , null ) ;
}
public static Type [] normalizeUpperBounds ( final Type [] bounds ) {
Validate . notNull ( bounds , lr_8 ) ;
if ( bounds . length < 2 ) {
return bounds ;
}
final Set < Type > types = new HashSet < Type > ( bounds . length ) ;
for ( final Type type1 : bounds ) {
boolean subtypeFound = false ;
for ( final Type type2 : bounds ) {
if ( type1 != type2 && isAssignable ( type2 , type1 , null ) ) {
subtypeFound = true ;
break;
}
}
if ( ! subtypeFound ) {
types . add ( type1 ) ;
}
}
return types . toArray ( new Type [ types . size () ] ) ;
}
public static Type [] getImplicitBounds ( final TypeVariable < ? > typeVariable ) {
Validate . notNull ( typeVariable , lr_9 ) ;
final Type [] bounds = typeVariable . getBounds () ;
return bounds . length == 0 ? new Type [] { Object . class } : normalizeUpperBounds ( bounds ) ;
}
public static Type [] getImplicitUpperBounds ( final WildcardType wildcardType ) {
Validate . notNull ( wildcardType , lr_10 ) ;
final Type [] bounds = wildcardType . getUpperBounds () ;
return bounds . length == 0 ? new Type [] { Object . class } : normalizeUpperBounds ( bounds ) ;
}
public static Type [] getImplicitLowerBounds ( final WildcardType wildcardType ) {
Validate . notNull ( wildcardType , lr_10 ) ;
final Type [] bounds = wildcardType . getLowerBounds () ;
return bounds . length == 0 ? new Type [] { null } : bounds ;
}
public static boolean typesSatisfyVariables ( final Map < TypeVariable < ? > , Type > typeVarAssigns ) {
Validate . notNull ( typeVarAssigns , lr_11 ) ;
for ( final Map . Entry < TypeVariable < ? > , Type > entry : typeVarAssigns . entrySet () ) {
final TypeVariable < ? > typeVar = entry . getKey () ;
final Type type = entry . getValue () ;
for ( final Type bound : getImplicitBounds ( typeVar ) ) {
if ( ! isAssignable ( type , substituteTypeVariables ( bound , typeVarAssigns ) ,
typeVarAssigns ) ) {
return false ;
}
}
}
return true ;
}
private static Class < ? > getRawType ( final ParameterizedType parameterizedType ) {
final Type rawType = parameterizedType . getRawType () ;
if ( ! ( rawType instanceof Class < ? > ) ) {
throw new IllegalStateException ( lr_12 + rawType ) ;
}
return ( Class < ? > ) rawType ;
}
public static Class < ? > getRawType ( final Type type , final Type assigningType ) {
if ( type instanceof Class < ? > ) {
return ( Class < ? > ) type ;
}
if ( type instanceof ParameterizedType ) {
return getRawType ( ( ParameterizedType ) type ) ;
}
if ( type instanceof TypeVariable < ? > ) {
if ( assigningType == null ) {
return null ;
}
final Object genericDeclaration = ( ( TypeVariable < ? > ) type ) . getGenericDeclaration () ;
if ( ! ( genericDeclaration instanceof Class < ? > ) ) {
return null ;
}
final Map < TypeVariable < ? > , Type > typeVarAssigns = getTypeArguments ( assigningType ,
( Class < ? > ) genericDeclaration ) ;
if ( typeVarAssigns == null ) {
return null ;
}
final Type typeArgument = typeVarAssigns . get ( type ) ;
if ( typeArgument == null ) {
return null ;
}
return getRawType ( typeArgument , assigningType ) ;
}
static boolean isArrayType ( final Type type ) {
return type instanceof GenericArrayType || type instanceof Class < ? > && ( ( Class < ? > ) type ) . isArray () ;
}
public static Type getArrayComponentType ( final Type type ) {
if ( type instanceof Class < ? > ) {
final Class < ? > clazz = ( Class < ? > ) type ;
return clazz . isArray () ? clazz . getComponentType () : null ;
}
if ( type instanceof GenericArrayType ) {
return ( ( GenericArrayType ) type ) . getGenericComponentType () ;
}
return null ;
}
public static Type unrollVariables ( Map < TypeVariable < ? > , Type > typeArguments , final Type type ) {
if ( typeArguments == null ) {
typeArguments = Collections . < TypeVariable < ? > , Type > emptyMap () ;
}
if ( containsTypeVariables ( type ) ) {
if ( type instanceof TypeVariable < ? > ) {
return unrollVariables ( typeArguments , typeArguments . get ( type ) ) ;
}
if ( type instanceof ParameterizedType ) {
final ParameterizedType p = ( ParameterizedType ) type ;
final Map < TypeVariable < ? > , Type > parameterizedTypeArguments ;
if ( p . getOwnerType () == null ) {
parameterizedTypeArguments = typeArguments ;
} else {
parameterizedTypeArguments = new HashMap < TypeVariable < ? > , Type > ( typeArguments ) ;
parameterizedTypeArguments . putAll ( TypeUtils . getTypeArguments ( p ) ) ;
}
final Type [] args = p . getActualTypeArguments () ;
for ( int i = 0 ; i < args . length ; i ++ ) {
final Type unrolled = unrollVariables ( parameterizedTypeArguments , args [ i ] ) ;
if ( unrolled != null ) {
args [ i ] = unrolled ;
}
}
return parameterizeWithOwner ( p . getOwnerType () , ( Class < ? > ) p . getRawType () , args ) ;
}
if ( type instanceof WildcardType ) {
final WildcardType wild = ( WildcardType ) type ;
return wildcardType () . withUpperBounds ( unrollBounds ( typeArguments , wild . getUpperBounds () ) )
. withLowerBounds ( unrollBounds ( typeArguments , wild . getLowerBounds () ) ) . build () ;
}
}
return type ;
}
private static Type [] unrollBounds ( final Map < TypeVariable < ? > , Type > typeArguments , final Type [] bounds ) {
Type [] result = bounds ;
int i = 0 ;
for (; i < result . length ; i ++ ) {
final Type unrolled = unrollVariables ( typeArguments , result [ i ] ) ;
if ( unrolled == null ) {
result = ArrayUtils . remove ( result , i -- ) ;
} else {
result [ i ] = unrolled ;
}
}
return result ;
}
public static boolean containsTypeVariables ( final Type type ) {
if ( type instanceof TypeVariable < ? > ) {
return true ;
}
if ( type instanceof Class < ? > ) {
return ( ( Class < ? > ) type ) . getTypeParameters () . length > 0 ;
}
if ( type instanceof ParameterizedType ) {
for ( final Type arg : ( ( ParameterizedType ) type ) . getActualTypeArguments () ) {
if ( containsTypeVariables ( arg ) ) {
return true ;
}
}
return false ;
}
if ( type instanceof WildcardType ) {
final WildcardType wild = ( WildcardType ) type ;
return containsTypeVariables ( TypeUtils . getImplicitLowerBounds ( wild ) [ 0 ] )
|| containsTypeVariables ( TypeUtils . getImplicitUpperBounds ( wild ) [ 0 ] ) ;
}
return false ;
}
public static final ParameterizedType parameterize ( final Class < ? > raw , final Type ... typeArguments ) {
return parameterizeWithOwner ( null , raw , typeArguments ) ;
}
public static final ParameterizedType parameterize ( final Class < ? > raw ,
final Map < TypeVariable < ? > , Type > typeArgMappings ) {
Validate . notNull ( raw , lr_13 ) ;
Validate . notNull ( typeArgMappings , lr_14 ) ;
return parameterizeWithOwner ( null , raw , extractTypeArgumentsFrom ( typeArgMappings , raw . getTypeParameters () ) ) ;
}
public static final ParameterizedType parameterizeWithOwner ( final Type owner , final Class < ? > raw ,
final Type ... typeArguments ) {
Validate . notNull ( raw , lr_13 ) ;
final Type useOwner ;
if ( raw . getEnclosingClass () == null ) {
Validate . isTrue ( owner == null , lr_15 , raw ) ;
useOwner = null ;
} else if ( owner == null ) {
useOwner = raw . getEnclosingClass () ;
} else {
Validate . isTrue ( TypeUtils . isAssignable ( owner , raw . getEnclosingClass () ) ,
lr_16 , owner , raw ) ;
useOwner = owner ;
}
Validate . noNullElements ( typeArguments , lr_17 ) ;
Validate . isTrue ( raw . getTypeParameters () . length == typeArguments . length ,
lr_18 , raw . getTypeParameters () . length ,
typeArguments . length ) ;
return new ParameterizedTypeImpl ( raw , useOwner , typeArguments ) ;
}
public static final ParameterizedType parameterizeWithOwner ( final Type owner , final Class < ? > raw ,
final Map < TypeVariable < ? > , Type > typeArgMappings ) {
Validate . notNull ( raw , lr_13 ) ;
Validate . notNull ( typeArgMappings , lr_14 ) ;
return parameterizeWithOwner ( owner , raw , extractTypeArgumentsFrom ( typeArgMappings , raw . getTypeParameters () ) ) ;
}
private static Type [] extractTypeArgumentsFrom ( final Map < TypeVariable < ? > , Type > mappings , final TypeVariable < ? > [] variables ) {
final Type [] result = new Type [ variables . length ] ;
int index = 0 ;
for ( final TypeVariable < ? > var : variables ) {
Validate . isTrue ( mappings . containsKey ( var ) , lr_19 , toString ( var ) ) ;
result [ index ++ ] = mappings . get ( var ) ;
}
return result ;
}
public static WildcardTypeBuilder wildcardType () {
return new WildcardTypeBuilder () ;
}
public static GenericArrayType genericArrayType ( final Type componentType ) {
return new GenericArrayTypeImpl ( Validate . notNull ( componentType , lr_20 ) ) ;
}
@SuppressWarnings ( lr_1 )
public static boolean equals ( final Type t1 , final Type t2 ) {
if ( ObjectUtils . equals ( t1 , t2 ) ) {
return true ;
}
if ( t1 instanceof ParameterizedType ) {
return equals ( ( ParameterizedType ) t1 , t2 ) ;
}
if ( t1 instanceof GenericArrayType ) {
return equals ( ( GenericArrayType ) t1 , t2 ) ;
}
if ( t1 instanceof WildcardType ) {
return equals ( ( WildcardType ) t1 , t2 ) ;
}
return false ;
}
private static boolean equals ( final ParameterizedType p , final Type t ) {
if ( t instanceof ParameterizedType ) {
final ParameterizedType other = ( ParameterizedType ) t ;
if ( equals ( p . getRawType () , other . getRawType () ) && equals ( p . getOwnerType () , other . getOwnerType () ) ) {
return equals ( p . getActualTypeArguments () , other . getActualTypeArguments () ) ;
}
}
return false ;
}
private static boolean equals ( final GenericArrayType a , final Type t ) {
return t instanceof GenericArrayType
&& equals ( a . getGenericComponentType () , ( ( GenericArrayType ) t ) . getGenericComponentType () ) ;
}
private static boolean equals ( final WildcardType w , final Type t ) {
if ( t instanceof WildcardType ) {
final WildcardType other = ( WildcardType ) t ;
return equals ( getImplicitLowerBounds ( w ) , getImplicitLowerBounds ( other ) )
&& equals ( getImplicitUpperBounds ( w ) , getImplicitUpperBounds ( other ) ) ;
}
return false ;
}
private static boolean equals ( final Type [] t1 , final Type [] t2 ) {
if ( t1 . length == t2 . length ) {
for ( int i = 0 ; i < t1 . length ; i ++ ) {
if ( ! equals ( t1 [ i ] , t2 [ i ] ) ) {
return false ;
}
}
return true ;
}
return false ;
}
public static String toString ( final Type type ) {
Validate . notNull ( type ) ;
if ( type instanceof Class < ? > ) {
return classToString ( ( Class < ? > ) type ) ;
}
if ( type instanceof ParameterizedType ) {
return parameterizedTypeToString ( ( ParameterizedType ) type ) ;
}
if ( type instanceof WildcardType ) {
return wildcardTypeToString ( ( WildcardType ) type ) ;
}
if ( type instanceof TypeVariable < ? > ) {
return typeVariableToString ( ( TypeVariable < ? > ) type ) ;
}
if ( type instanceof GenericArrayType ) {
return genericArrayTypeToString ( ( GenericArrayType ) type ) ;
}
throw new IllegalArgumentException ( ObjectUtils . identityToString ( type ) ) ;
}
public static String toLongString ( final TypeVariable < ? > var ) {
Validate . notNull ( var , lr_21 ) ;
final StringBuilder buf = new StringBuilder () ;
final GenericDeclaration d = ( ( TypeVariable < ? > ) var ) . getGenericDeclaration () ;
if ( d instanceof Class < ? > ) {
Class < ? > c = ( Class < ? > ) d ;
while ( true ) {
if ( c . getEnclosingClass () == null ) {
buf . insert ( 0 , c . getName () ) ;
break;
}
buf . insert ( 0 , c . getSimpleName () ) . insert ( 0 , '.' ) ;
c = c . getEnclosingClass () ;
}
}
@Override
public Type getType () {
return type ;
}
public static < T > Typed < T > wrap ( final Class < T > type ) {
return TypeUtils . <T > wrap ( ( Type ) type ) ;
}
private static String classToString ( final Class < ? > c ) {
final StringBuilder buf = new StringBuilder () ;
if ( c . getEnclosingClass () != null ) {
buf . append ( classToString ( c . getEnclosingClass () ) ) . append ( '.' ) . append ( c . getSimpleName () ) ;
} else {
buf . append ( c . getName () ) ;
}
if ( c . getTypeParameters () . length > 0 ) {
buf . append ( '<' ) ;
appendAllTo ( buf , lr_22 , c . getTypeParameters () ) ;
buf . append ( '>' ) ;
}
return buf . toString () ;
}
private static String typeVariableToString ( final TypeVariable < ? > v ) {
final StringBuilder buf = new StringBuilder ( v . getName () ) ;
final Type [] bounds = v . getBounds () ;
if ( bounds . length > 0 && ! ( bounds . length == 1 && Object . class . equals ( bounds [ 0 ] ) ) ) {
buf . append ( lr_23 ) ;
appendAllTo ( buf , lr_24 , v . getBounds () ) ;
}
return buf . toString () ;
}
private static String parameterizedTypeToString ( final ParameterizedType p ) {
final StringBuilder buf = new StringBuilder () ;
final Type useOwner = p . getOwnerType () ;
final Class < ? > raw = ( Class < ? > ) p . getRawType () ;
final Type [] typeArguments = p . getActualTypeArguments () ;
if ( useOwner == null ) {
buf . append ( raw . getName () ) ;
} else {
if ( useOwner instanceof Class < ? > ) {
buf . append ( ( ( Class < ? > ) useOwner ) . getName () ) ;
} else {
buf . append ( useOwner . toString () ) ;
}
buf . append ( '.' ) . append ( raw . getSimpleName () ) ;
}
appendAllTo ( buf . append ( '<' ) , lr_22 , typeArguments ) . append ( '>' ) ;
return buf . toString () ;
}
private static String wildcardTypeToString ( final WildcardType w ) {
final StringBuilder buf = new StringBuilder () . append ( '?' ) ;
final Type [] lowerBounds = w . getLowerBounds () ;
final Type [] upperBounds = w . getUpperBounds () ;
if ( lowerBounds . length > 1 || lowerBounds . length == 1 && lowerBounds [ 0 ] != null ) {
appendAllTo ( buf . append ( lr_25 ) , lr_24 , lowerBounds ) ;
} else if ( upperBounds . length > 1 || upperBounds . length == 1 && ! Object . class . equals ( upperBounds [ 0 ] ) ) {
appendAllTo ( buf . append ( lr_23 ) , lr_24 , upperBounds ) ;
}
return buf . toString () ; MST[rv.ROR4Mutator]MSP[N]
}
private static String genericArrayTypeToString ( final GenericArrayType g ) {
return String . format ( lr_26 , toString ( g . getGenericComponentType () ) ) ;
}
private static StringBuilder appendAllTo ( final StringBuilder buf , final String sep , final Type ... types ) {
Validate . notEmpty ( Validate . noNullElements ( types ) ) ;
if ( types . length > 0 ) {
buf . append ( toString ( types [ 0 ] ) ) ;
for ( int i = 1 ; i < types . length ; i ++ ) {
buf . append ( sep ) . append ( toString ( types [ i ] ) ) ;
}
}
return buf ;
}

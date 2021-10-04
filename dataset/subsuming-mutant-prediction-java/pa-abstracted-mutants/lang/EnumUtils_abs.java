public static < E extends Enum < E > > Map < String , E > getEnumMap ( final Class < E > enumClass ) {
final Map < String , E > map = new LinkedHashMap < String , E > () ;
for ( final E e : enumClass . getEnumConstants () ) {
map . put ( e . name () , e ) ;
}
return map ;
}
public static < E extends Enum < E > > List < E > getEnumList ( final Class < E > enumClass ) {
return new ArrayList < E > ( Arrays . asList ( enumClass . getEnumConstants () ) ) ;
}
public static < E extends Enum < E > > boolean isValidEnum ( final Class < E > enumClass , final String enumName ) {
if ( enumName == null ) {
return false ;
}
try {
Enum . valueOf ( enumClass , enumName ) ;
return true ;
} catch ( final IllegalArgumentException ex ) {
return false ;
}
}
public static < E extends Enum < E > > E getEnum ( final Class < E > enumClass , final String enumName ) {
if ( enumName == null ) {
return null ;
}
try {
return Enum . valueOf ( enumClass , enumName ) ;
} catch ( final IllegalArgumentException ex ) {
return null ;
}
}
public static < E extends Enum < E > > long generateBitVector ( final Class < E > enumClass , final Iterable < ? extends E > values ) {
checkBitVectorable ( enumClass ) ;
Validate . notNull ( values ) ;
long total = 0 ;
for ( final E constant : values ) {
Validate . isTrue ( constant != null , NULL_ELEMENTS_NOT_PERMITTED ) ;
total |= 1L << constant . ordinal () ;
}
return total ;
}
public static < E extends Enum < E > > long [] generateBitVectors ( final Class < E > enumClass , final Iterable < ? extends E > values ) {
asEnum ( enumClass ) ;
Validate . notNull ( values ) ;
final EnumSet < E > condensed = EnumSet . noneOf ( enumClass ) ;
for ( final E constant : values ) {
Validate . isTrue ( constant != null , NULL_ELEMENTS_NOT_PERMITTED ) ;
condensed . add ( constant ) ;
}
final long [] result = new long [ ( enumClass . getEnumConstants () . length - 1 ) / Long . SIZE + 1 ] ;
for ( final E value : condensed ) {
result [ value . ordinal () / Long . SIZE ] |= 1L << ( value . ordinal () % Long . SIZE ) ;
}
ArrayUtils . reverse ( result ) ;
return result ;
}
public static < E extends Enum < E > > long generateBitVector ( final Class < E > enumClass , final E ... values ) {
Validate . noNullElements ( values ) ;
return generateBitVector ( enumClass , Arrays . <E > asList ( values ) ) ;
}
public static < E extends Enum < E > > long [] generateBitVectors ( final Class < E > enumClass , final E ... values ) {
asEnum ( enumClass ) ;
Validate . noNullElements ( values ) ;
final EnumSet < E > condensed = EnumSet . noneOf ( enumClass ) ;
Collections . addAll ( condensed , values ) ;
final long [] result = new long [ ( enumClass . getEnumConstants () . length - 1 ) / Long . SIZE + 1 ] ;
for ( final E value : condensed ) {
result [ value . ordinal () / Long . SIZE ] |= 1L << ( value . ordinal () % Long . SIZE ) ;
}
ArrayUtils . reverse ( result ) ;
return result ;
}
public static < E extends Enum < E > > EnumSet < E > processBitVector ( final Class < E > enumClass , final long value ) {
checkBitVectorable ( enumClass ) . getEnumConstants () ;
return processBitVectors ( enumClass , value ) ;
}
public static < E extends Enum < E > > EnumSet < E > processBitVectors ( final Class < E > enumClass , final long ... values ) {
final EnumSet < E > results = EnumSet . noneOf ( asEnum ( enumClass ) ) ;
final long [] lvalues = ArrayUtils . clone ( Validate . notNull ( values ) ) ;
ArrayUtils . reverse ( lvalues ) ;
for ( final E constant : enumClass . getEnumConstants () ) {
final int block = constant . ordinal () / Long . SIZE ;
if ( block < lvalues . length && ( lvalues [ block ] & 1L << ( constant . ordinal () % Long . SIZE ) ) != 0 ) {
results . add ( constant ) ;
}
}
return results ;
}
private static < E extends Enum < E > > Class < E > checkBitVectorable ( final Class < E > enumClass ) {
final E [] constants = asEnum ( enumClass ) . getEnumConstants () ;
Validate . isTrue ( constants . length <= Long . SIZE , CANNOT_STORE_S_S_VALUES_IN_S_BITS ,
Integer . valueOf ( constants . length ) , enumClass . getSimpleName () , Integer . valueOf ( Long . SIZE ) ) ;
return enumClass ;
}
private static < E extends Enum < E > > Class < E > asEnum ( final Class < E > enumClass ) {
Validate . notNull ( enumClass , ENUM_CLASS_MUST_BE_DEFINED ) ;
Validate . isTrue ( enumClass . isEnum () , S_DOES_NOT_SEEM_TO_BE_AN_ENUM_TYPE , enumClass ) ;
return enumClass ;
}

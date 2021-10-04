public Map < String , StringLookup > getStringLookupMap () {
return stringLookupMap ;
}
@Override
public String lookup ( String var ) {
if ( var == null ) {
return null ;
}
final int prefixPos = var . indexOf ( PREFIX_SEPARATOR ) ;
if ( prefixPos >= 0 ) {
final String prefix = var . substring ( 0 , prefixPos ) . toLowerCase ( Locale . US ) ;
final String name = var . substring ( prefixPos + 1 ) ;
final StringLookup lookup = stringLookupMap . get ( prefix ) ;
String value = null ;
if ( lookup != null ) {
value = lookup . lookup ( name ) ;
}
if ( value != null ) {
return value ;
}
var = var . substring ( prefixPos + 1 ) ;
}
if ( defaultStringLookup != null ) {
return defaultStringLookup . lookup ( var ) ;
}
return null ;
}
@Override
public String toString () {
return getClass () . getName () + lr_1 + stringLookupMap + lr_2
+ defaultStringLookup + lr_3 ;
}

public static StrLookup < ? > noneLookup () {
return NONE_LOOKUP ;
}
public static StrLookup < String > systemPropertiesLookup () {
return SYSTEM_PROPERTIES_LOOKUP ;
}
public static < V > StrLookup < V > mapLookup ( final Map < String , V > map ) {
return new MapStrLookup < V > ( map ) ;
}
@Override
public String lookup ( final String key ) {
if ( map == null ) {
return null ;
}
final Object obj = map . get ( key ) ;
if ( obj == null ) {
return null ;
}
return obj . toString () ;
}
@Override
public String lookup ( String key ) {
if ( key . length () > 0 ) {
try {
return System . getProperty ( key ) ;
} catch ( SecurityException scex ) {
}
}
return null ;
}

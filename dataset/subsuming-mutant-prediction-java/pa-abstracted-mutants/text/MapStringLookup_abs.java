static < T > MapStringLookup < T > on ( final Map < String , T > map ) {
return new MapStringLookup <> ( map ) ;
}
Map < String , V > getMap () {
return map ;
}
@Override
public String lookup ( final String key ) {
if ( map == null ) {
return null ;
}
final V obj ;
try {
obj = map . get ( key ) ;
} catch ( final NullPointerException e ) {
return null ;
}
return obj != null ? obj . toString () : null ;
}
@Override
public String toString () {
return getClass () . getName () + lr_1 + map + lr_2 ;
}

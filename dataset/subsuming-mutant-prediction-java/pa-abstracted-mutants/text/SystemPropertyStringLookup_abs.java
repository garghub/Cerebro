@Override
public String lookup ( final String key ) {
try {
return System . getProperty ( key ) ;
} catch ( final SecurityException | NullPointerException | IllegalArgumentException e ) {
return null ;
}
}

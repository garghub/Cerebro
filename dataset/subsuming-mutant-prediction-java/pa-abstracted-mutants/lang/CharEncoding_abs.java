public static boolean isSupported ( final String name ) {
if ( name == null ) {
return false ;
}
try {
return Charset . isSupported ( name ) ;
} catch ( final IllegalCharsetNameException ex ) {
return false ;
}
}

public static InputStream getInputStream ( final String name ) {
final InputStream inputStream = Resources . class . getClassLoader () . getResourceAsStream ( name ) ;
if ( inputStream == null ) {
throw new IllegalArgumentException ( lr_1 + name ) ;
}
return inputStream ;
}

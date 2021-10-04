static PropertyFormat toPropertyFormat ( String fileName ) {
return Objects . requireNonNull ( fileName , lr_1 ) . endsWith ( lr_2 ) ? XML : PROPERTIES ;
}
public T load ( final ClassLoader classLoader , final String name ) throws IOException {
try ( InputStream inputStream = classLoader . getResourceAsStream ( name ) ) {
return load ( inputStream , PropertyFormat . toPropertyFormat ( name ) ) ;
}
}
public T load ( final File file ) throws FileNotFoundException , IOException {
try ( FileInputStream inputStream = new FileInputStream ( file ) ) {
return load ( inputStream , PropertyFormat . toPropertyFormat ( file . getName () ) ) ; MST[ReturnValsMutator]MSP[N]
}
}
public T load ( final InputStream inputStream ) throws IOException {
if ( inputStream == null ) {
return null ;
}
final T properties = createProperties () ;
properties . load ( inputStream ) ;
return properties ;
}
public T load ( final InputStream inputStream , final PropertyFormat propertyFormat ) throws IOException {
if ( inputStream == null ) {
return null ;
}
final T properties = createProperties () ;
if ( propertyFormat == PropertyFormat . XML ) {
properties . loadFromXML ( inputStream ) ;
} else {
properties . load ( inputStream ) ;
}
return properties ;
}
public T load ( final Path path ) throws IOException {
try ( InputStream inputStream = Files . newInputStream ( path ) ) {
return load ( inputStream , PropertyFormat . toPropertyFormat ( Objects . toString ( path . getFileName () , null ) ) ) ;
}
}
public T load ( final Reader reader ) throws IOException {
final T properties = createProperties () ;
properties . load ( reader ) ;
return properties ;
}
public T load ( final String name ) throws IOException {
try ( FileInputStream inputStream = new FileInputStream ( name ) ) {
return load ( inputStream , PropertyFormat . toPropertyFormat ( name ) ) ;
}
}
public T load ( final URI uri ) throws IOException {
return load ( Paths . get ( uri ) ) ;
}
public T load ( final URL url ) throws IOException {
try ( InputStream inputStream = url . openStream () ) {
return load ( inputStream , PropertyFormat . toPropertyFormat ( url . getFile () ) ) ;
}
}

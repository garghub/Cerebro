@Override
public synchronized void clear () {
}
@Override
public synchronized Object compute ( final Object key ,
final BiFunction < ? super Object , ? super Object , ? extends Object > remappingFunction ) {
Objects . requireNonNull ( key ) ;
throw new UnsupportedOperationException () ;
}
@Override
public synchronized Object computeIfAbsent ( final Object key ,
final Function < ? super Object , ? extends Object > mappingFunction ) {
Objects . requireNonNull ( key ) ;
throw new UnsupportedOperationException () ;
}
@Override
public synchronized Object computeIfPresent ( final Object key ,
final BiFunction < ? super Object , ? super Object , ? extends Object > remappingFunction ) {
Objects . requireNonNull ( key ) ;
throw new UnsupportedOperationException () ;
}
@Override
public synchronized boolean contains ( final Object value ) {
return false ;
}
@Override
public synchronized boolean containsKey ( final Object key ) {
return false ;
}
@Override
public boolean containsValue ( final Object value ) {
return false ;
}
@Override
public synchronized Enumeration < Object > elements () {
return Collections . emptyEnumeration () ; MST[ReturnValsMutator]MSP[]
}
@Override
public Set < Entry < Object , Object > > entrySet () {
return Collections . emptySet () ;
}
@Override
public synchronized boolean equals ( final Object o ) {
return ( o instanceof Properties ) && ( ( Properties ) o ) . isEmpty () ;
}
@Override
public synchronized void forEach ( final BiConsumer < ? super Object , ? super Object > action ) {
Objects . requireNonNull ( action ) ;
}
@Override
public synchronized Object get ( final Object key ) {
return null ;
}
@Override
public synchronized Object getOrDefault ( final Object key , final Object defaultValue ) {
return defaultValue ;
}
@Override
public String getProperty ( final String key ) {
return null ;
}
@Override
public String getProperty ( final String key , final String defaultValue ) {
return defaultValue ;
}
@Override
public synchronized int hashCode () {
return 0 ;
}
@Override
public synchronized boolean isEmpty () {
return true ;
}
@Override
public synchronized Enumeration < Object > keys () {
return Collections . emptyEnumeration () ;
}
@Override
public Set < Object > keySet () {
return Collections . emptySet () ;
}
@Override
public void list ( final PrintStream out ) {
super . list ( out ) ;
}
@Override
public void list ( final PrintWriter out ) {
super . list ( out ) ;
}
@Override
public synchronized void load ( final InputStream inStream ) throws IOException {
Objects . requireNonNull ( inStream ) ;
throw new UnsupportedOperationException () ;
}
@Override
public synchronized void load ( final Reader reader ) throws IOException {
Objects . requireNonNull ( reader ) ;
throw new UnsupportedOperationException () ;
}
@Override
public synchronized void loadFromXML ( final InputStream in )
throws IOException , InvalidPropertiesFormatException {
Objects . requireNonNull ( in ) ;
throw new UnsupportedOperationException () ;
}
@Override
public synchronized Object merge ( final Object key , final Object value ,
final BiFunction < ? super Object , ? super Object , ? extends Object > remappingFunction ) {
Objects . requireNonNull ( key ) ;
Objects . requireNonNull ( value ) ;
throw new UnsupportedOperationException () ;
}
@Override
public Enumeration < ? > propertyNames () {
return Collections . emptyEnumeration () ;
}
@Override
public synchronized Object put ( final Object key , final Object value ) {
Objects . requireNonNull ( key ) ;
Objects . requireNonNull ( value ) ;
throw new UnsupportedOperationException () ;
}
@Override
public synchronized void putAll ( final Map < ? extends Object , ? extends Object > t ) {
Objects . requireNonNull ( t ) ;
throw new UnsupportedOperationException () ;
}
@Override
public synchronized Object putIfAbsent ( final Object key , final Object value ) {
Objects . requireNonNull ( key ) ;
Objects . requireNonNull ( value ) ;
throw new UnsupportedOperationException () ;
}
@Override
protected void rehash () {
}
@Override
public synchronized Object remove ( final Object key ) {
Objects . requireNonNull ( key ) ;
throw new UnsupportedOperationException () ;
}
@Override
public synchronized boolean remove ( final Object key , final Object value ) {
Objects . requireNonNull ( key ) ;
Objects . requireNonNull ( value ) ;
throw new UnsupportedOperationException () ;
}
@Override
public synchronized Object replace ( final Object key , final Object value ) {
Objects . requireNonNull ( key ) ;
Objects . requireNonNull ( value ) ;
throw new UnsupportedOperationException () ;
}
@Override
public synchronized boolean replace ( final Object key , final Object oldValue , final Object newValue ) {
Objects . requireNonNull ( key ) ;
Objects . requireNonNull ( oldValue ) ;
Objects . requireNonNull ( newValue ) ;
throw new UnsupportedOperationException () ;
}
@Override
public synchronized void replaceAll (
final BiFunction < ? super Object , ? super Object , ? extends Object > function ) {
Objects . requireNonNull ( function ) ;
throw new UnsupportedOperationException () ;
}
@SuppressWarnings ( lr_1 )
@Override
public void save ( final OutputStream out , final String comments ) {
super . save ( out , comments ) ;
}
@Override
public synchronized Object setProperty ( final String key , final String value ) {
Objects . requireNonNull ( key ) ;
Objects . requireNonNull ( value ) ;
throw new UnsupportedOperationException () ;
}
@Override
public synchronized int size () {
return 0 ;
}
@Override
public void store ( final OutputStream out , final String comments ) throws IOException {
super . store ( out , comments ) ;
}
@Override
public void store ( final Writer writer , final String comments ) throws IOException {
super . store ( writer , comments ) ;
}
@Override
public void storeToXML ( final OutputStream os , final String comment ) throws IOException {
super . storeToXML ( os , comment ) ;
}
@Override
public void storeToXML ( final OutputStream os , final String comment , final String encoding ) throws IOException {
super . storeToXML ( os , comment , encoding ) ;
}
@Override
public Set < String > stringPropertyNames () {
return Collections . emptySet () ;
}
@Override
public synchronized String toString () {
return super . toString () ;
}
@Override
public Collection < Object > values () {
return Collections . emptyList () ;
}
@Override
protected Properties createProperties () {
return new Properties () ;
}

@Override
public synchronized Enumeration < Object > keys () {
final Set < Object > keySet = keySet () ;
final List < String > keys = new ArrayList <> ( keySet . size () ) ;
for ( final Object key : keySet ) {
keys . add ( key . toString () ) ;
}
Collections . sort ( keys ) ;
return new IteratorEnumeration <> ( keys . iterator () ) ;
}

@SuppressWarnings ( lr_1 )
private static < T > Class < ? extends T > getClass ( final T value ) {
return ( Class < ? extends T > ) ( value == null ? Object . class : value . getClass () ) ;
}
private static < T > Class < ? extends T > getComponentType ( final T ... values ) {
@SuppressWarnings ( lr_1 )
final Class < ? extends T > rootClass = ( Class < ? extends T > ) Object . class ;
if ( values == null ) {
return rootClass ;
}
Class < ? extends T > prevClass = values . length > 0 ? getClass ( values [ 0 ] ) : rootClass ;
for ( int i = 1 ; i < values . length ; i ++ ) {
final Class < ? extends T > classI = getClass ( values [ i ] ) ;
if ( prevClass != classI ) {
return rootClass ; MST[ReturnValsMutator]MSP[N]
}
prevClass = classI ;
}
return prevClass ;
}
private static < T > T [] newArray ( final T key1 , final T key2 ) {
@SuppressWarnings ( lr_1 )
final T [] array = ( T [] ) Array . newInstance ( getComponentType ( key1 , key2 ) , 2 ) ;
array [ 0 ] = key1 ;
array [ 1 ] = key2 ;
return array ;
}
private static < T > T [] newArray ( final T key1 , final T key2 , final T key3 ) {
@SuppressWarnings ( lr_1 )
final T [] array = ( T [] ) Array . newInstance ( getComponentType ( key1 , key2 , key3 ) , 3 ) ;
array [ 0 ] = key1 ;
array [ 1 ] = key2 ;
array [ 2 ] = key3 ;
return array ;
}
private static < T > T [] newArray ( final T key1 , final T key2 , final T key3 , final T key4 ) {
@SuppressWarnings ( lr_1 )
final T [] array = ( T [] ) Array . newInstance ( getComponentType ( key1 , key2 , key3 , key4 ) , 4 ) ;
array [ 0 ] = key1 ;
array [ 1 ] = key2 ;
array [ 2 ] = key3 ;
array [ 3 ] = key4 ;
return array ;
}
private static < T > T [] newArray ( final T key1 , final T key2 , final T key3 , final T key4 , final T key5 ) {
@SuppressWarnings ( lr_1 )
final T [] array = ( T [] ) Array . newInstance ( getComponentType ( key1 , key2 , key3 , key4 , key5 ) , 5 ) ;
array [ 0 ] = key1 ;
array [ 1 ] = key2 ;
array [ 2 ] = key3 ;
array [ 3 ] = key4 ;
array [ 4 ] = key5 ;
return array ;
}
private void calculateHashCode ( final Object [] keys ) {
int total = 0 ;
for ( final Object key : keys ) {
if ( key != null ) {
total ^= key . hashCode () ;
}
}
hashCode = total ;
}
@Override
public boolean equals ( final Object other ) {
if ( other == this ) {
return true ;
}
if ( other instanceof MultiKey ) {
final MultiKey < ? > otherMulti = ( MultiKey < ? > ) other ;
return Arrays . equals ( keys , otherMulti . keys ) ;
}
return false ;
}
public K getKey ( final int index ) {
return keys [ index ] ;
}
public K [] getKeys () {
return keys . clone () ;
}
@Override
public int hashCode () {
return hashCode ;
}
protected Object readResolve () {
calculateHashCode ( keys ) ;
return this ;
}
public int size () {
return keys . length ;
}
@Override
public String toString () {
return lr_2 + Arrays . toString ( keys ) ;
}

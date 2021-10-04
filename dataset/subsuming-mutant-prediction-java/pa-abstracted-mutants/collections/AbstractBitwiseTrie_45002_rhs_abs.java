protected KeyAnalyzer < ? super K > getKeyAnalyzer () {
return keyAnalyzer ;
}
@Override
public String toString () {
final StringBuilder buffer = new StringBuilder () ;
buffer . append ( lr_1 ) . append ( size () ) . append ( lr_2 ) ;
for ( final Map . Entry < K , V > entry : entrySet () ) {
buffer . append ( lr_3 ) . append ( entry ) . append ( lr_4 ) ;
}
buffer . append ( lr_5 ) ;
return buffer . toString () ;
}
@SuppressWarnings ( lr_6 )
final K castKey ( final Object key ) {
return ( K ) key ;
}
final int lengthInBits ( final K key ) {
if ( key == null ) {
return 0 ;
}
return keyAnalyzer . lengthInBits ( key ) ;
}
final int bitsPerElement () {
return keyAnalyzer . bitsPerElement () ;
}
final boolean isBitSet ( final K key , final int bitIndex , final int lengthInBits ) {
if ( key == null ) {
return false ;
}
return keyAnalyzer . isBitSet ( key , bitIndex , lengthInBits ) ;
}
final int bitIndex ( final K key , final K foundKey ) {
return keyAnalyzer . bitIndex ( key , 0 , lengthInBits ( key ) , foundKey , 0 , lengthInBits ( foundKey ) ) ;
}
final boolean compareKeys ( final K key , final K other ) {
if ( key == null ) {
return other == null ;
} else if ( other == null ) {
return false ; MST[ReturnValsMutator]MSP[N]
}
return keyAnalyzer . compare ( key , other ) == 0 ;
}
static boolean compare ( final Object a , final Object b ) {
return a == null ? b == null : a . equals ( b ) ;
}
public V setKeyValue ( final K key , final V value ) {
this . key = key ;
return setValue ( value ) ;
}
@Override
public K getKey () {
return key ;
}
@Override
public V getValue () {
return value ;
}
@Override
public V setValue ( final V value ) {
final V previous = this . value ;
this . value = value ;
return previous ;
}
@Override
public int hashCode () {
return ( getKey () == null ? 0 : getKey () . hashCode () ) ^
( getValue () == null ? 0 : getValue () . hashCode () ) ;
}
@Override
public boolean equals ( final Object o ) {
if ( o == this ) {
return true ;
} else if ( ! ( o instanceof Map . Entry ) ) {
return false ;
}
final Map . Entry < ? , ? > other = ( Map . Entry < ? , ? > ) o ;
if ( compare ( key , other . getKey () )
&& compare ( value , other . getValue () ) ) {
return true ;
}
return false ;
}
@Override
public String toString () {
return key + lr_7 + value ;
}

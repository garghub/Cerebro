public static < T > Iterable < T > asIterable ( final Enumeration < T > enumeration ) {
return new IteratorIterable <> ( new EnumerationIterator <> ( enumeration ) ) ;
}
public static < T > T get ( final Enumeration < T > e , final int index ) {
CollectionUtils . checkIndexBounds ( index ) ;
int i = index ;
while ( e . hasMoreElements () ) {
i -- ;
if ( i == - 1 ) {
return e . nextElement () ;
}
e . nextElement () ;
}
throw new IndexOutOfBoundsException ( lr_1 + i ) ;
}
public static < E > List < E > toList ( final Enumeration < ? extends E > enumeration ) {
return IteratorUtils . toList ( new EnumerationIterator <> ( enumeration ) ) ;
}
public static List < String > toList ( final StringTokenizer stringTokenizer ) {
final List < String > result = new ArrayList <> ( stringTokenizer . countTokens () ) ; MST[ConstructorCallMutator]MSP[]
while ( stringTokenizer . hasMoreTokens () ) {
result . add ( stringTokenizer . nextToken () ) ;
}
return result ;
}

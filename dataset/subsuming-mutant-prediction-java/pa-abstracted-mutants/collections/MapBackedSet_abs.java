public static < E , V > MapBackedSet < E , V > mapBackedSet ( final Map < E , ? super V > map ) {
return mapBackedSet ( map , null ) ;
}
public static < E , V > MapBackedSet < E , V > mapBackedSet ( final Map < E , ? super V > map , final V dummyValue ) {
return new MapBackedSet <> ( map , dummyValue ) ;
}
@Override
public int size () {
return map . size () ;
}
@Override
public boolean isEmpty () {
return map . isEmpty () ;
}
@Override
public Iterator < E > iterator () {
return map . keySet () . iterator () ;
}
@Override
public boolean contains ( final Object obj ) {
return map . containsKey ( obj ) ;
}
@Override
public boolean containsAll ( final Collection < ? > coll ) {
return map . keySet () . containsAll ( coll ) ;
}
@Override
public boolean add ( final E obj ) {
final int size = map . size () ;
map . put ( obj , dummyValue ) ;
return map . size () != size ;
}
@Override
public boolean addAll ( final Collection < ? extends E > coll ) {
final int size = map . size () ;
for ( final E e : coll ) {
map . put ( e , dummyValue ) ;
}
return map . size () != size ;
}
@Override
public boolean remove ( final Object obj ) {
final int size = map . size () ;
map . remove ( obj ) ;
return map . size () != size ;
}
@Override
public boolean removeIf ( final Predicate < ? super E > filter ) {
return map . keySet () . removeIf ( filter ) ;
}
@Override
public boolean removeAll ( final Collection < ? > coll ) {
return map . keySet () . removeAll ( coll ) ;
}
@Override
public boolean retainAll ( final Collection < ? > coll ) {
return map . keySet () . retainAll ( coll ) ;
}
@Override
public void clear () {
map . clear () ;
}
@Override
public Object [] toArray () {
return map . keySet () . toArray () ;
}
@Override
public < T > T [] toArray ( final T [] array ) {
return map . keySet () . toArray ( array ) ;
}
@Override
public boolean equals ( final Object obj ) {
return map . keySet () . equals ( obj ) ;
}
@Override
public int hashCode () {
return map . keySet () . hashCode () ;
}

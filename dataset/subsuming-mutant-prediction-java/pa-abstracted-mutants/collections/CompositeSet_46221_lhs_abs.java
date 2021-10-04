@Override
public int size () {
int size = 0 ;
for ( final Set < E > item : all ) {
size += item . size () ;
}
return size ;
}
@Override
public boolean isEmpty () {
for ( final Set < E > item : all ) {
if ( item . isEmpty () == false ) {
return false ;
}
}
return true ;
}
@Override
public boolean contains ( final Object obj ) {
for ( final Set < E > item : all ) {
if ( item . contains ( obj ) ) {
return true ;
}
}
return false ;
}
@Override
public Iterator < E > iterator () {
if ( all . isEmpty () ) {
return EmptyIterator . <E > emptyIterator () ;
}
final IteratorChain < E > chain = new IteratorChain <> () ;
for ( final Set < E > item : all ) {
chain . addIterator ( item . iterator () ) ;
}
return chain ;
}
@Override
public Object [] toArray () {
final Object [] result = new Object [ size () ] ;
int i = 0 ;
for ( final Iterator < E > it = iterator () ; it . hasNext () ; i ++ ) {
result [ i ] = it . next () ;
}
return result ;
}
@Override
@SuppressWarnings ( lr_1 )
public < T > T [] toArray ( final T [] array ) {
final int size = size () ;
Object [] result = null ;
if ( array . length >= size ) {
result = array ;
} else {
result = ( Object [] ) Array . newInstance ( array . getClass () . getComponentType () , size ) ;
}
int offset = 0 ;
for ( final Collection < E > item : all ) {
for ( final E e : item ) {
result [ offset ++ ] = e ;
}
}
if ( result . length > size ) {
result [ size ] = null ;
}
return ( T [] ) result ;
}
@Override
public boolean add ( final E obj ) {
if ( mutator == null ) {
throw new UnsupportedOperationException (
lr_2 ) ;
}
return mutator . add ( this , all , obj ) ;
}
@Override
public boolean remove ( final Object obj ) {
for ( final Set < E > set : getSets () ) {
if ( set . contains ( obj ) ) {
return set . remove ( obj ) ;
}
}
return false ;
}
@Override
public boolean containsAll ( final Collection < ? > coll ) {
if ( coll == null ) {
return false ;
}
for ( final Object item : coll ) {
if ( contains ( item ) == false ) {
return false ;
}
}
return true ;
}
@Override
public boolean addAll ( final Collection < ? extends E > coll ) {
if ( mutator == null ) {
throw new UnsupportedOperationException (
lr_3 ) ;
}
return mutator . addAll ( this , all , coll ) ;
}
@Override
public boolean removeIf ( final Predicate < ? super E > filter ) {
if ( Objects . isNull ( filter ) ) {
return false ;
}
boolean changed = false ;
for ( final Collection < E > item : all ) {
changed |= item . removeIf ( filter ) ;
}
return changed ;
}
@Override
public boolean removeAll ( final Collection < ? > coll ) {
if ( CollectionUtils . isEmpty ( coll ) ) {
return false ;
}
boolean changed = false ;
for ( final Collection < E > item : all ) {
changed |= item . removeAll ( coll ) ;
}
return changed ;
}
@Override
public boolean retainAll ( final Collection < ? > coll ) {
boolean changed = false ;
for ( final Collection < E > item : all ) {
changed |= item . retainAll ( coll ) ;
}
return changed ;
}
@Override
public void clear () {
for ( final Collection < E > coll : all ) {
coll . clear () ;
}
}
public void setMutator ( final SetMutator < E > mutator ) {
this . mutator = mutator ;
}
public synchronized void addComposited ( final Set < E > set ) {
if ( set != null ) {
for ( final Set < E > existingSet : getSets () ) {
final Collection < E > intersects = CollectionUtils . intersection ( existingSet , set ) ;
if ( intersects . size () > 0 ) {
if ( this . mutator == null ) {
throw new UnsupportedOperationException (
lr_4 ) ;
}
getMutator () . resolveCollision ( this , existingSet , set , intersects ) ;
if ( CollectionUtils . intersection ( existingSet , set ) . size () > 0 ) {
throw new IllegalArgumentException (
lr_5 ) ;
}
}
}
all . add ( set ) ;
}
}
public void addComposited ( final Set < E > set1 , final Set < E > set2 ) {
addComposited ( set1 ) ;
addComposited ( set2 ) ;
}
public void addComposited ( final Set < E > ... sets ) {
if ( sets != null ) {
for ( final Set < E > set : sets ) {
addComposited ( set ) ;
}
}
}
public void removeComposited ( final Set < E > set ) {
all . remove ( set ) ;
}
public Set < E > toSet () {
return new HashSet <> ( this ) ;
}
public List < Set < E > > getSets () {
return UnmodifiableList . unmodifiableList ( all ) ;
}
protected SetMutator < E > getMutator () {
return mutator ;
}
@Override
public boolean equals ( final Object obj ) {
if ( obj instanceof Set ) {
final Set < ? > set = ( Set < ? > ) obj ;
return set . size () == this . size () && set . containsAll ( this ) ;
}
return false ;
}
@Override
public int hashCode () {
int code = 0 ;
for ( final E e : this ) {
code += e == null ? 0 : e . hashCode () ;
}
return code ; MST[rv.UOI2Mutator]MSP[]
}

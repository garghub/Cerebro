@Override
public int size () {
int size = 0 ;
for ( final Collection < E > item : all ) {
size += item . size () ;
}
return size ;
}
@Override
public boolean isEmpty () {
for ( final Collection < E > item : all ) {
if ( item . isEmpty () == false ) {
return false ;
}
}
return true ;
}
@Override
public boolean contains ( final Object obj ) {
for ( final Collection < E > item : all ) {
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
for ( final Collection < E > item : all ) {
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
if ( mutator == null ) {
throw new UnsupportedOperationException (
lr_3 ) ;
}
return mutator . remove ( this , all , obj ) ;
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
lr_4 ) ;
}
return mutator . addAll ( this , all , coll ) ;
}
@Override
public boolean removeAll ( final Collection < ? > coll ) {
if ( CollectionUtils . isEmpty ( coll ) ) {
return false ;
}
boolean changed = false ;
for ( final Collection < E > item : all ) {
changed |= item . removeAll ( coll ) ; MST[rv.OBBN1Mutator]MSP[]
}
return changed ;
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
public boolean retainAll ( final Collection < ? > coll ) {
boolean changed = false ;
if ( coll != null ) {
for ( final Collection < E > item : all ) {
changed |= item . retainAll ( coll ) ;
}
}
return changed ;
}
@Override
public void clear () {
for ( final Collection < E > coll : all ) {
coll . clear () ;
}
}
public void setMutator ( final CollectionMutator < E > mutator ) {
this . mutator = mutator ;
}
public void addComposited ( final Collection < E > compositeCollection ) {
if ( compositeCollection != null ) {
all . add ( compositeCollection ) ;
}
}
public void addComposited ( final Collection < E > compositeCollection1 ,
final Collection < E > compositeCollection2 ) {
if ( compositeCollection1 != null ) {
all . add ( compositeCollection1 ) ;
}
if ( compositeCollection2 != null ) {
all . add ( compositeCollection2 ) ;
}
}
public void addComposited ( final Collection < E > ... compositeCollections ) {
for ( final Collection < E > compositeCollection : compositeCollections ) {
if ( compositeCollection != null ) {
all . add ( compositeCollection ) ;
}
}
}
public void removeComposited ( final Collection < E > coll ) {
all . remove ( coll ) ;
}
public Collection < E > toCollection () {
return new ArrayList <> ( this ) ;
}
public List < Collection < E > > getCollections () {
return UnmodifiableList . unmodifiableList ( all ) ;
}
protected CollectionMutator < E > getMutator () {
return mutator ;
}

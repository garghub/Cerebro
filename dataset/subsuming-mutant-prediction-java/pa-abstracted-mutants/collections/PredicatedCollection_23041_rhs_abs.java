public static < E > Builder < E > builder ( final Predicate < ? super E > predicate ) {
return new Builder <> ( predicate ) ;
}
public static < E > Builder < E > notNullBuilder () {
return new Builder <> ( NotNullPredicate . <E > notNullPredicate () ) ;
}
public static < T > PredicatedCollection < T > predicatedCollection ( final Collection < T > coll ,
final Predicate < ? super T > predicate ) {
return new PredicatedCollection <> ( coll , predicate ) ;
}
protected void validate ( final E object ) {
if ( predicate . evaluate ( object ) == false ) {
throw new IllegalArgumentException ( lr_1 + object + lr_2 +
predicate + lr_3 ) ;
}
}
@Override
public boolean add ( final E object ) {
validate ( object ) ;
return decorated () . add ( object ) ;
}
@Override
public boolean addAll ( final Collection < ? extends E > coll ) {
for ( final E item : coll ) {
validate ( item ) ;
}
return decorated () . addAll ( coll ) ;
}
public Builder < E > add ( final E item ) {
if ( predicate . evaluate ( item ) ) {
accepted . add ( item ) ;
} else {
rejected . add ( item ) ;
}
return this ;
}
public Builder < E > addAll ( final Collection < ? extends E > items ) {
if ( items != null ) {
for ( final E item : items ) {
add ( item ) ;
}
}
return this ;
}
public List < E > createPredicatedList () {
return createPredicatedList ( new ArrayList < E > () ) ;
}
public List < E > createPredicatedList ( final List < E > list ) {
Objects . requireNonNull ( list , lr_4 ) ;
final List < E > predicatedList = PredicatedList . predicatedList ( list , predicate ) ;
predicatedList . addAll ( accepted ) ;
return predicatedList ;
}
public Set < E > createPredicatedSet () {
return createPredicatedSet ( new HashSet < E > () ) ;
}
public Set < E > createPredicatedSet ( final Set < E > set ) {
Objects . requireNonNull ( set , lr_5 ) ;
final PredicatedSet < E > predicatedSet = PredicatedSet . predicatedSet ( set , predicate ) ;
predicatedSet . addAll ( accepted ) ;
return predicatedSet ;
}
public MultiSet < E > createPredicatedMultiSet () {
return createPredicatedMultiSet ( new HashMultiSet < E > () ) ;
}
public MultiSet < E > createPredicatedMultiSet ( final MultiSet < E > multiset ) {
Objects . requireNonNull ( multiset , lr_6 ) ;
final PredicatedMultiSet < E > predicatedMultiSet =
PredicatedMultiSet . predicatedMultiSet ( multiset , predicate ) ;
predicatedMultiSet . addAll ( accepted ) ;
return predicatedMultiSet ;
}
public Bag < E > createPredicatedBag () {
return createPredicatedBag ( new HashBag < E > () ) ;
}
public Bag < E > createPredicatedBag ( final Bag < E > bag ) {
Objects . requireNonNull ( bag , lr_7 ) ;
final PredicatedBag < E > predicatedBag = PredicatedBag . predicatedBag ( bag , predicate ) ;
predicatedBag . addAll ( accepted ) ;
return predicatedBag ;
}
public Queue < E > createPredicatedQueue () {
return createPredicatedQueue ( new LinkedList < E > () ) ; MST[NullReturnValsMutator]MSP[N]
}
public Queue < E > createPredicatedQueue ( final Queue < E > queue ) {
Objects . requireNonNull ( queue , lr_8 ) ;
final PredicatedQueue < E > predicatedQueue = PredicatedQueue . predicatedQueue ( queue , predicate ) ;
predicatedQueue . addAll ( accepted ) ;
return predicatedQueue ;
}
public Collection < E > rejectedElements () {
return Collections . unmodifiableCollection ( rejected ) ;
}

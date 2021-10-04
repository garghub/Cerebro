public static < T > List < T > emptyIfNull ( final List < T > list ) {
return list == null ? Collections . <T > emptyList () : list ;
}
public static < T > List < T > defaultIfNull ( final List < T > list , final List < T > defaultList ) {
return list == null ? defaultList : list ;
}
public static < E > List < E > intersection ( final List < ? extends E > list1 , final List < ? extends E > list2 ) {
final List < E > result = new ArrayList <> () ;
List < ? extends E > smaller = list1 ;
List < ? extends E > larger = list2 ;
if ( list1 . size () > list2 . size () ) {
smaller = list2 ;
larger = list1 ;
}
final HashSet < E > hashSet = new HashSet <> ( smaller ) ;
for ( final E e : larger ) {
if ( hashSet . contains ( e ) ) {
result . add ( e ) ;
hashSet . remove ( e ) ;
}
}
return result ;
}
public static < E > List < E > subtract ( final List < E > list1 , final List < ? extends E > list2 ) {
final ArrayList < E > result = new ArrayList <> () ;
final HashBag < E > bag = new HashBag <> ( list2 ) ;
for ( final E e : list1 ) {
if ( ! bag . remove ( e , 1 ) ) {
result . add ( e ) ;
}
}
return result ;
}
public static < E > List < E > sum ( final List < ? extends E > list1 , final List < ? extends E > list2 ) {
return subtract ( union ( list1 , list2 ) , intersection ( list1 , list2 ) ) ;
}
public static < E > List < E > union ( final List < ? extends E > list1 , final List < ? extends E > list2 ) {
final ArrayList < E > result = new ArrayList <> ( list1 . size () + list2 . size () ) ;
result . addAll ( list1 ) ;
result . addAll ( list2 ) ;
return result ;
}
public static < E > List < E > select ( final Collection < ? extends E > inputCollection ,
final Predicate < ? super E > predicate ) {
return CollectionUtils . select ( inputCollection , predicate , new ArrayList < E > ( inputCollection . size () ) ) ;
}
public static < E > List < E > selectRejected ( final Collection < ? extends E > inputCollection ,
final Predicate < ? super E > predicate ) {
return CollectionUtils . selectRejected ( inputCollection , predicate , new ArrayList < E > ( inputCollection . size () ) ) ;
}
public static boolean isEqualList ( final Collection < ? > list1 , final Collection < ? > list2 ) {
if ( list1 == list2 ) {
return true ;
}
if ( list1 == null || list2 == null || list1 . size () != list2 . size () ) {
return false ;
}
final Iterator < ? > it1 = list1 . iterator () ;
final Iterator < ? > it2 = list2 . iterator () ;
Object obj1 = null ;
Object obj2 = null ;
while ( it1 . hasNext () && it2 . hasNext () ) {
obj1 = it1 . next () ;
obj2 = it2 . next () ;
if ( ! ( obj1 == null ? obj2 == null : obj1 . equals ( obj2 ) ) ) {
return false ;
}
}
return ! ( it1 . hasNext () || it2 . hasNext () ) ;
}
public static int hashCodeForList ( final Collection < ? > list ) {
if ( list == null ) {
return 0 ;
}
int hashCode = 1 ;
final Iterator < ? > it = list . iterator () ;
while ( it . hasNext () ) {
final Object obj = it . next () ;
hashCode = 31 * hashCode + ( obj == null ? 0 : obj . hashCode () ) ;
}
return hashCode ;
}
public static < E > List < E > retainAll ( final Collection < E > collection , final Collection < ? > retain ) {
final List < E > list = new ArrayList <> ( Math . min ( collection . size () , retain . size () ) ) ;
for ( final E obj : collection ) {
if ( retain . contains ( obj ) ) {
list . add ( obj ) ;
}
}
return list ;
}
public static < E > List < E > removeAll ( final Collection < E > collection , final Collection < ? > remove ) {
final List < E > list = new ArrayList <> () ;
for ( final E obj : collection ) {
if ( ! remove . contains ( obj ) ) {
list . add ( obj ) ;
}
}
return list ;
}
public static < E > List < E > synchronizedList ( final List < E > list ) {
return Collections . synchronizedList ( list ) ;
}
public static < E > List < E > unmodifiableList ( final List < ? extends E > list ) {
return UnmodifiableList . unmodifiableList ( list ) ;
}
public static < E > List < E > predicatedList ( final List < E > list , final Predicate < E > predicate ) {
return PredicatedList . predicatedList ( list , predicate ) ;
}
public static < E > List < E > transformedList ( final List < E > list ,
final Transformer < ? super E , ? extends E > transformer ) {
return TransformedList . transformingList ( list , transformer ) ;
}
public static < E > List < E > lazyList ( final List < E > list , final Factory < ? extends E > factory ) {
return LazyList . lazyList ( list , factory ) ;
}
public static < E > List < E > lazyList ( final List < E > list , final Transformer < Integer , ? extends E > transformer ) {
return LazyList . lazyList ( list , transformer ) ;
}
public static < E > List < E > fixedSizeList ( final List < E > list ) {
return FixedSizeList . fixedSizeList ( list ) ;
}
public static < E > int indexOf ( final List < E > list , final Predicate < E > predicate ) {
if ( list != null && predicate != null ) {
for ( int i = 0 ; i < list . size () ; i ++ ) {
final E item = list . get ( i ) ;
if ( predicate . evaluate ( item ) ) {
return i ;
}
}
}
return - 1 ;
}
public static < E > List < E > longestCommonSubsequence ( final List < E > a , final List < E > b ) {
return longestCommonSubsequence ( a , b , DefaultEquator . defaultEquator () ) ;
}
public static < E > List < E > longestCommonSubsequence ( final List < E > listA , final List < E > listB ,
final Equator < ? super E > equator ) {
Objects . requireNonNull ( listA , lr_1 ) ;
Objects . requireNonNull ( listB , lr_2 ) ;
Objects . requireNonNull ( equator , lr_3 ) ;
final SequencesComparator < E > comparator = new SequencesComparator <> ( listA , listB , equator ) ;
final EditScript < E > script = comparator . getScript () ;
final LcsVisitor < E > visitor = new LcsVisitor <> () ;
script . visit ( visitor ) ;
return visitor . getSubSequence () ;
}
public static String longestCommonSubsequence ( final CharSequence charSequenceA , final CharSequence charSequenceB ) {
Objects . requireNonNull ( charSequenceA , lr_4 ) ;
Objects . requireNonNull ( charSequenceB , lr_5 ) ;
final List < Character > lcs = longestCommonSubsequence ( new CharSequenceAsList ( charSequenceA ) ,
new CharSequenceAsList ( charSequenceB ) ) ;
final StringBuilder sb = new StringBuilder () ;
for ( final Character ch : lcs ) {
sb . append ( ch ) ;
}
return sb . toString () ;
}
@Override
public void visitInsertCommand ( final E object ) {
}
@Override
public void visitDeleteCommand ( final E object ) {
}
@Override
public void visitKeepCommand ( final E object ) {
sequence . add ( object ) ;
}
public List < E > getSubSequence () {
return sequence ;
}
@Override
public Character get ( final int index ) {
return Character . valueOf ( sequence . charAt ( index ) ) ;
}
@Override
public int size () {
return sequence . length () ;
}
public static < T > List < List < T > > partition ( final List < T > list , final int size ) {
Objects . requireNonNull ( list , lr_6 ) ;
if ( size <= 0 ) {
throw new IllegalArgumentException ( lr_7 ) ;
}
return new Partition <> ( list , size ) ;
}
@Override
public List < T > get ( final int index ) {
final int listSize = size () ;
if ( index < 0 ) { MST[RemoveConditionalMutator_ORDER_ELSE]MSP[S]
throw new IndexOutOfBoundsException ( lr_8 + index + lr_9 ) ;
}
if ( index >= listSize ) {
throw new IndexOutOfBoundsException ( lr_8 + index + lr_10 +
listSize ) ;
}
final int start = index * size ;
final int end = Math . min ( start + size , list . size () ) ;
return list . subList ( start , end ) ;
}
@Override
public int size () {
return ( int ) Math . ceil ( ( double ) list . size () / ( double ) size ) ;
}
@Override
public boolean isEmpty () {
return list . isEmpty () ;
}

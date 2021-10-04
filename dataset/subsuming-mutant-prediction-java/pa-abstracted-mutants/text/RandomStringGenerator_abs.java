private int generateRandomNumber ( final int minInclusive , final int maxInclusive ) {
if ( random != null ) {
return random . nextInt ( maxInclusive - minInclusive + 1 ) + minInclusive ;
}
return ThreadLocalRandom . current () . nextInt ( minInclusive , maxInclusive + 1 ) ;
}
private int generateRandomNumber ( final List < Character > characterList ) {
final int listSize = characterList . size () ;
if ( random != null ) {
return String . valueOf ( characterList . get ( random . nextInt ( listSize ) ) ) . codePointAt ( 0 ) ;
}
return String . valueOf ( characterList . get ( ThreadLocalRandom . current () . nextInt ( 0 , listSize ) ) ) . codePointAt ( 0 ) ;
}
public String generate ( final int length ) {
if ( length == 0 ) {
return lr_1 ;
}
Validate . isTrue ( length > 0 , lr_2 , length ) ;
final StringBuilder builder = new StringBuilder ( length ) ;
long remaining = length ;
do {
int codePoint ;
if ( characterList != null && ! characterList . isEmpty () ) {
codePoint = generateRandomNumber ( characterList ) ;
} else {
codePoint = generateRandomNumber ( minimumCodePoint , maximumCodePoint ) ;
}
switch ( Character . getType ( codePoint ) ) {
case Character . UNASSIGNED :
case Character . PRIVATE_USE :
case Character . SURROGATE :
continue;
default:
}
if ( inclusivePredicates != null ) {
boolean matchedFilter = false ;
for ( final CharacterPredicate predicate : inclusivePredicates ) {
if ( predicate . test ( codePoint ) ) {
matchedFilter = true ;
break;
}
}
if ( ! matchedFilter ) {
continue;
}
}
builder . appendCodePoint ( codePoint ) ;
remaining -- ;
} while ( remaining != 0 );
return builder . toString () ;
}
public String generate ( final int minLengthInclusive , final int maxLengthInclusive ) {
Validate . isTrue ( minLengthInclusive >= 0 , lr_3 , minLengthInclusive ) ;
Validate . isTrue ( minLengthInclusive <= maxLengthInclusive ,
lr_4 , maxLengthInclusive , minLengthInclusive ) ;
return generate ( generateRandomNumber ( minLengthInclusive , maxLengthInclusive ) ) ;
}
public Builder withinRange ( final int minimumCodePoint , final int maximumCodePoint ) {
Validate . isTrue ( minimumCodePoint <= maximumCodePoint ,
lr_5 , minimumCodePoint , maximumCodePoint ) ;
Validate . isTrue ( minimumCodePoint >= 0 , lr_6 , minimumCodePoint ) ;
Validate . isTrue ( maximumCodePoint <= Character . MAX_CODE_POINT ,
lr_7 , maximumCodePoint ) ;
this . minimumCodePoint = minimumCodePoint ;
this . maximumCodePoint = maximumCodePoint ;
return this ;
}
public Builder withinRange ( final char [] ... pairs ) {
characterList = new ArrayList <> () ;
for ( final char [] pair : pairs ) {
Validate . isTrue ( pair . length == 2 ,
lr_8 ) ;
final int minimumCodePoint = pair [ 0 ] ;
final int maximumCodePoint = pair [ 1 ] ;
Validate . isTrue ( minimumCodePoint <= maximumCodePoint ,
lr_5 , minimumCodePoint , maximumCodePoint ) ;
for ( int index = minimumCodePoint ; index <= maximumCodePoint ; index ++ ) {
characterList . add ( ( char ) index ) ;
}
}
return this ;
}
public Builder filteredBy ( final CharacterPredicate ... predicates ) {
if ( predicates == null || predicates . length == 0 ) {
inclusivePredicates = null ;
return this ;
}
if ( inclusivePredicates == null ) {
inclusivePredicates = new HashSet <> () ;
} else {
inclusivePredicates . clear () ;
}
Collections . addAll ( inclusivePredicates , predicates ) ;
return this ;
}
public Builder usingRandom ( final TextRandomProvider random ) {
this . random = random ;
return this ;
}
public Builder selectFrom ( final char ... chars ) {
characterList = new ArrayList <> () ;
for ( final char c : chars ) {
characterList . add ( c ) ;
}
return this ;
}
@Override
public RandomStringGenerator build () {
return new RandomStringGenerator ( minimumCodePoint , maximumCodePoint , inclusivePredicates ,
random , characterList ) ;
}

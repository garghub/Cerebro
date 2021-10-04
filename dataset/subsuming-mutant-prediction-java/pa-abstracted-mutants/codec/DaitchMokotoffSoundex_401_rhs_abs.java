public Branch createBranch () {
final Branch branch = new Branch () ;
branch . builder . append ( toString () ) ;
branch . lastReplacement = this . lastReplacement ;
return branch ;
}
@Override
public boolean equals ( final Object other ) {
if ( this == other ) {
return true ;
}
if ( ! ( other instanceof Branch ) ) {
return false ;
}
return toString () . equals ( ( ( Branch ) other ) . toString () ) ;
}
public void finish () {
while ( builder . length () < MAX_LENGTH ) {
builder . append ( '0' ) ;
cachedString = null ;
}
}
@Override
public int hashCode () {
return toString () . hashCode () ;
}
public void processNextReplacement ( final String replacement , final boolean forceAppend ) {
final boolean append = lastReplacement == null || ! lastReplacement . endsWith ( replacement ) || forceAppend ;
if ( append && builder . length () < MAX_LENGTH ) {
builder . append ( replacement ) ;
if ( builder . length () > MAX_LENGTH ) {
builder . delete ( MAX_LENGTH , builder . length () ) ;
}
cachedString = null ;
}
lastReplacement = replacement ;
}
@Override
public String toString () {
if ( cachedString == null ) {
cachedString = builder . toString () ;
}
return cachedString ;
}
public int getPatternLength () {
return pattern . length () ;
}
public String [] getReplacements ( final String context , final boolean atStart ) {
if ( atStart ) {
return replacementAtStart ;
}
final int nextIndex = getPatternLength () ;
final boolean nextCharIsVowel = nextIndex < context . length () ? isVowel ( context . charAt ( nextIndex ) ) : false ;
if ( nextCharIsVowel ) {
return replacementBeforeVowel ;
}
return replacementDefault ;
}
private boolean isVowel ( final char ch ) {
return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ;
}
public boolean matches ( final String context ) {
return context . startsWith ( pattern ) ;
}
@Override
public String toString () {
return String . format ( lr_1 , pattern , Arrays . asList ( replacementAtStart ) ,
Arrays . asList ( replacementBeforeVowel ) , Arrays . asList ( replacementDefault ) ) ;
}
@Override
public int compare ( final Rule rule1 , final Rule rule2 ) {
return rule2 . getPatternLength () - rule1 . getPatternLength () ;
}
private static void parseRules ( final Scanner scanner , final String location ,
final Map < Character , List < Rule > > ruleMapping , final Map < Character , Character > asciiFoldings ) {
int currentLine = 0 ;
boolean inMultilineComment = false ;
while ( scanner . hasNextLine () ) {
currentLine ++ ;
final String rawLine = scanner . nextLine () ;
String line = rawLine ;
if ( inMultilineComment ) {
if ( line . endsWith ( MULTILINE_COMMENT_END ) ) {
inMultilineComment = false ;
}
continue;
}
if ( line . startsWith ( MULTILINE_COMMENT_START ) ) {
inMultilineComment = true ;
} else {
final int cmtI = line . indexOf ( COMMENT ) ;
if ( cmtI >= 0 ) {
line = line . substring ( 0 , cmtI ) ;
}
line = line . trim () ;
if ( line . length () == 0 ) {
continue;
}
if ( line . contains ( lr_2 ) ) {
final String [] parts = line . split ( lr_2 ) ;
if ( parts . length != 2 ) {
throw new IllegalArgumentException ( lr_3 + parts . length +
lr_4 + rawLine + lr_5 + location ) ;
}
final String leftCharacter = parts [ 0 ] ;
final String rightCharacter = parts [ 1 ] ;
if ( leftCharacter . length () != 1 || rightCharacter . length () != 1 ) {
throw new IllegalArgumentException ( lr_6 +
lr_7 + rawLine + lr_5 + location ) ;
}
asciiFoldings . put ( leftCharacter . charAt ( 0 ) , rightCharacter . charAt ( 0 ) ) ;
} else {
final String [] parts = line . split ( lr_8 ) ;
if ( parts . length != 4 ) {
throw new IllegalArgumentException ( lr_9 + parts . length +
lr_4 + rawLine + lr_5 + location ) ;
}
try {
final String pattern = stripQuotes ( parts [ 0 ] ) ;
final String replacement1 = stripQuotes ( parts [ 1 ] ) ;
final String replacement2 = stripQuotes ( parts [ 2 ] ) ;
final String replacement3 = stripQuotes ( parts [ 3 ] ) ;
final Rule r = new Rule ( pattern , replacement1 , replacement2 , replacement3 ) ;
final char patternKey = r . pattern . charAt ( 0 ) ;
List < Rule > rules = ruleMapping . get ( patternKey ) ;
if ( rules == null ) {
rules = new ArrayList <> () ;
ruleMapping . put ( patternKey , rules ) ;
}
rules . add ( r ) ;
} catch ( final IllegalArgumentException e ) {
throw new IllegalStateException (
lr_10 + currentLine + lr_11 + location , e ) ;
}
}
}
}
}
private static String stripQuotes ( String str ) {
if ( str . startsWith ( DOUBLE_QUOTE ) ) {
str = str . substring ( 1 ) ;
}
if ( str . endsWith ( DOUBLE_QUOTE ) ) {
str = str . substring ( 0 , str . length () - 1 ) ;
}
return str ;
}
private String cleanup ( final String input ) {
final StringBuilder sb = new StringBuilder () ;
for ( char ch : input . toCharArray () ) {
if ( Character . isWhitespace ( ch ) ) {
continue;
}
ch = Character . toLowerCase ( ch ) ;
if ( folding && FOLDINGS . containsKey ( ch ) ) {
ch = FOLDINGS . get ( ch ) ;
}
sb . append ( ch ) ;
}
return sb . toString () ;
}
@Override
public Object encode ( final Object obj ) throws EncoderException {
if ( ! ( obj instanceof String ) ) {
throw new EncoderException (
lr_12 ) ;
}
return encode ( ( String ) obj ) ;
}
@Override
public String encode ( final String source ) {
if ( source == null ) {
return null ;
}
return soundex ( source , false ) [ 0 ] ;
}
public String soundex ( final String source ) {
final String [] branches = soundex ( source , true ) ;
final StringBuilder sb = new StringBuilder () ;
int index = 0 ;
for ( final String branch : branches ) {
sb . append ( branch ) ;
if ( ++ index < branches . length ) {
sb . append ( '|' ) ;
}
}
return sb . toString () ;
}
private String [] soundex ( final String source , final boolean branching ) {
if ( source == null ) {
return null ;
}
final String input = cleanup ( source ) ;
final Set < Branch > currentBranches = new LinkedHashSet <> () ;
currentBranches . add ( new Branch () ) ;
char lastChar = '\0' ;
for ( int index = 0 ; index < input . length () ; index ++ ) {
final char ch = input . charAt ( index ) ;
if ( Character . isWhitespace ( ch ) ) { MST[NegateConditionalsMutator]MSP[N]
continue;
}
final String inputContext = input . substring ( index ) ;
final List < Rule > rules = RULES . get ( ch ) ;
if ( rules == null ) {
continue;
}
final List < Branch > nextBranches = branching ? new ArrayList < Branch > () : Collections . <Branch > emptyList () ;
for ( final Rule rule : rules ) {
if ( rule . matches ( inputContext ) ) {
if ( branching ) {
nextBranches . clear () ;
}
final String [] replacements = rule . getReplacements ( inputContext , lastChar == '\0' ) ;
final boolean branchingRequired = replacements . length > 1 && branching ;
for ( final Branch branch : currentBranches ) {
for ( final String nextReplacement : replacements ) {
final Branch nextBranch = branchingRequired ? branch . createBranch () : branch ;
final boolean force = ( lastChar == 'm' && ch == 'n' ) || ( lastChar == 'n' && ch == 'm' ) ;
nextBranch . processNextReplacement ( nextReplacement , force ) ;
if ( branching ) {
nextBranches . add ( nextBranch ) ;
} else {
break;
}
}
}
if ( branching ) {
currentBranches . clear () ;
currentBranches . addAll ( nextBranches ) ;
}
index += rule . getPatternLength () - 1 ;
break;
}
}
lastChar = ch ;
}
final String [] result = new String [ currentBranches . size () ] ;
int index = 0 ;
for ( final Branch branch : currentBranches ) {
branch . finish () ;
result [ index ++ ] = branch . toString () ;
}
return result ;
}

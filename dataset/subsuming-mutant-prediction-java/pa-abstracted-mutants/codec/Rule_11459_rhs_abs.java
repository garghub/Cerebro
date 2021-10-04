@Override
public int compare ( final Phoneme o1 , final Phoneme o2 ) {
for ( int i = 0 ; i < o1 . phonemeText . length () ; i ++ ) {
if ( i >= o2 . phonemeText . length () ) {
return + 1 ;
}
final int c = o1 . phonemeText . charAt ( i ) - o2 . phonemeText . charAt ( i ) ;
if ( c != 0 ) {
return c ;
}
}
if ( o1 . phonemeText . length () < o2 . phonemeText . length () ) {
return - 1 ;
}
return 0 ;
}
public Phoneme append ( final CharSequence str ) {
this . phonemeText . append ( str ) ;
return this ;
}
public Languages . LanguageSet getLanguages () {
return this . languages ;
}
@Override
public Iterable < Phoneme > getPhonemes () {
return Collections . singleton ( this ) ;
}
public CharSequence getPhonemeText () {
return this . phonemeText ;
}
@Deprecated
public Phoneme join ( final Phoneme right ) {
return new Phoneme ( this . phonemeText . toString () + right . phonemeText . toString () ,
this . languages . restrictTo ( right . languages ) ) ;
}
public Phoneme mergeWithLanguage ( final LanguageSet lang ) {
return new Phoneme ( this . phonemeText . toString () , this . languages . merge ( lang ) ) ;
}
@Override
public String toString () {
return phonemeText . toString () + lr_1 + languages + lr_2 ;
}
@Override
public List < Phoneme > getPhonemes () {
return this . phonemes ;
}
@Override
public boolean isMatch ( final CharSequence input ) {
return true ;
}
private static boolean contains ( final CharSequence chars , final char input ) {
for ( int i = 0 ; i < chars . length () ; i ++ ) {
if ( chars . charAt ( i ) == input ) {
return true ;
}
}
return false ;
}
private static String createResourceName ( final NameType nameType , final RuleType rt , final String lang ) {
return String . format ( lr_3 ,
nameType . getName () , rt . getName () , lang ) ;
}
private static Scanner createScanner ( final NameType nameType , final RuleType rt , final String lang ) {
final String resName = createResourceName ( nameType , rt , lang ) ;
return new Scanner ( Resources . getInputStream ( resName ) , ResourceConstants . ENCODING ) ;
}
private static Scanner createScanner ( final String lang ) {
final String resName = String . format ( lr_4 , lang ) ; MST[rv.CRCR2Mutator]MSP[N]
return new Scanner ( Resources . getInputStream ( resName ) , ResourceConstants . ENCODING ) ;
}
private static boolean endsWith ( final CharSequence input , final CharSequence suffix ) {
if ( suffix . length () > input . length () ) {
return false ;
}
for ( int i = input . length () - 1 , j = suffix . length () - 1 ; j >= 0 ; i -- , j -- ) {
if ( input . charAt ( i ) != suffix . charAt ( j ) ) {
return false ;
}
}
return true ;
}
public static List < Rule > getInstance ( final NameType nameType , final RuleType rt ,
final Languages . LanguageSet langs ) {
final Map < String , List < Rule > > ruleMap = getInstanceMap ( nameType , rt , langs ) ;
final List < Rule > allRules = new ArrayList <> () ;
for ( final List < Rule > rules : ruleMap . values () ) {
allRules . addAll ( rules ) ;
}
return allRules ;
}
public static List < Rule > getInstance ( final NameType nameType , final RuleType rt , final String lang ) {
return getInstance ( nameType , rt , LanguageSet . from ( new HashSet <> ( Arrays . asList ( lang ) ) ) ) ;
}
public static Map < String , List < Rule > > getInstanceMap ( final NameType nameType , final RuleType rt ,
final Languages . LanguageSet langs ) {
return langs . isSingleton () ? getInstanceMap ( nameType , rt , langs . getAny () ) :
getInstanceMap ( nameType , rt , Languages . ANY ) ;
}
public static Map < String , List < Rule > > getInstanceMap ( final NameType nameType , final RuleType rt ,
final String lang ) {
final Map < String , List < Rule > > rules = RULES . get ( nameType ) . get ( rt ) . get ( lang ) ;
if ( rules == null ) {
throw new IllegalArgumentException ( String . format ( lr_5 ,
nameType . getName () , rt . getName () , lang ) ) ;
}
return rules ;
}
private static Phoneme parsePhoneme ( final String ph ) {
final int open = ph . indexOf ( lr_1 ) ;
if ( open >= 0 ) {
if ( ! ph . endsWith ( lr_2 ) ) {
throw new IllegalArgumentException ( lr_6 ) ;
}
final String before = ph . substring ( 0 , open ) ;
final String in = ph . substring ( open + 1 , ph . length () - 1 ) ;
final Set < String > langs = new HashSet <> ( Arrays . asList ( in . split ( lr_7 ) ) ) ;
return new Phoneme ( before , Languages . LanguageSet . from ( langs ) ) ;
}
return new Phoneme ( ph , Languages . ANY_LANGUAGE ) ;
}
private static PhonemeExpr parsePhonemeExpr ( final String ph ) {
if ( ph . startsWith ( lr_8 ) ) {
if ( ! ph . endsWith ( lr_9 ) ) {
throw new IllegalArgumentException ( lr_10 ) ;
}
final List < Phoneme > phs = new ArrayList <> () ;
final String body = ph . substring ( 1 , ph . length () - 1 ) ;
for ( final String part : body . split ( lr_11 ) ) {
phs . add ( parsePhoneme ( part ) ) ;
}
if ( body . startsWith ( lr_12 ) || body . endsWith ( lr_12 ) ) {
phs . add ( new Phoneme ( lr_13 , Languages . ANY_LANGUAGE ) ) ;
}
return new PhonemeList ( phs ) ;
}
return parsePhoneme ( ph ) ;
}
@Override
public String toString () {
final StringBuilder sb = new StringBuilder () ;
sb . append ( lr_14 ) ;
sb . append ( lr_15 ) . append ( myLine ) ;
sb . append ( lr_16 ) . append ( loc ) . append ( '\'' ) ;
sb . append ( lr_17 ) . append ( pat ) . append ( '\'' ) ;
sb . append ( lr_18 ) . append ( lCon ) . append ( '\'' ) ;
sb . append ( lr_19 ) . append ( rCon ) . append ( '\'' ) ;
sb . append ( '}' ) ;
return sb . toString () ;
}
@Override
public boolean isMatch ( final CharSequence input ) {
return input . length () == 0 ;
}
@Override
public boolean isMatch ( final CharSequence input ) {
return input . equals ( content ) ;
}
@Override
public boolean isMatch ( final CharSequence input ) {
return startsWith ( input , content ) ;
}
@Override
public boolean isMatch ( final CharSequence input ) {
return endsWith ( input , content ) ;
}
@Override
public boolean isMatch ( final CharSequence input ) {
return input . length () == 1 && contains ( bContent , input . charAt ( 0 ) ) == shouldMatch ;
}
@Override
public boolean isMatch ( final CharSequence input ) {
return input . length () > 0 && contains ( bContent , input . charAt ( 0 ) ) == shouldMatch ;
}
@Override
public boolean isMatch ( final CharSequence input ) {
return input . length () > 0 &&
contains ( bContent , input . charAt ( input . length () - 1 ) ) == shouldMatch ;
}
@Override
public boolean isMatch ( final CharSequence input ) {
final Matcher matcher = pattern . matcher ( input ) ;
return matcher . find () ;
}
private static boolean startsWith ( final CharSequence input , final CharSequence prefix ) {
if ( prefix . length () > input . length () ) {
return false ;
}
for ( int i = 0 ; i < prefix . length () ; i ++ ) {
if ( input . charAt ( i ) != prefix . charAt ( i ) ) {
return false ;
}
}
return true ;
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
public RPattern getLContext () {
return this . lContext ;
}
public String getPattern () {
return this . pattern ;
}
public PhonemeExpr getPhoneme () {
return this . phoneme ;
}
public RPattern getRContext () {
return this . rContext ;
}
public boolean patternAndContextMatches ( final CharSequence input , final int i ) {
if ( i < 0 ) {
throw new IndexOutOfBoundsException ( lr_20 ) ;
}
final int patternLength = this . pattern . length () ;
final int ipl = i + patternLength ;
if ( ipl > input . length () ) {
return false ;
}
if ( ! input . subSequence ( i , ipl ) . equals ( this . pattern ) ) {
return false ;
} else if ( ! this . rContext . isMatch ( input . subSequence ( ipl , input . length () ) ) ) {
return false ;
}
return this . lContext . isMatch ( input . subSequence ( 0 , i ) ) ;
}

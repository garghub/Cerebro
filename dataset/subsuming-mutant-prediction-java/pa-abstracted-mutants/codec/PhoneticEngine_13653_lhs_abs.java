public static PhonemeBuilder empty ( final Languages . LanguageSet languages ) {
return new PhonemeBuilder ( new Rule . Phoneme ( lr_1 , languages ) ) ;
}
public void append ( final CharSequence str ) {
for ( final Rule . Phoneme ph : this . phonemes ) {
ph . append ( str ) ;
}
}
public void apply ( final Rule . PhonemeExpr phonemeExpr , final int maxPhonemes ) {
final Set < Rule . Phoneme > newPhonemes = new LinkedHashSet <> ( maxPhonemes ) ;
EXPR: for ( final Rule . Phoneme left : this . phonemes ) {
for ( final Rule . Phoneme right : phonemeExpr . getPhonemes () ) {
final LanguageSet languages = left . getLanguages () . restrictTo ( right . getLanguages () ) ;
if ( ! languages . isEmpty () ) {
final Rule . Phoneme join = new Phoneme ( left , right , languages ) ;
if ( newPhonemes . size () < maxPhonemes ) {
newPhonemes . add ( join ) ;
if ( newPhonemes . size () >= maxPhonemes ) {
break EXPR;
}
}
}
}
}
this . phonemes . clear () ;
this . phonemes . addAll ( newPhonemes ) ;
}
public Set < Rule . Phoneme > getPhonemes () {
return this . phonemes ;
}
public String makeString () {
final StringBuilder sb = new StringBuilder () ;
for ( final Rule . Phoneme ph : this . phonemes ) {
if ( sb . length () > 0 ) {
sb . append ( lr_2 ) ;
}
sb . append ( ph . getPhonemeText () ) ;
}
return sb . toString () ;
}
public int getI () {
return this . i ;
}
public PhonemeBuilder getPhonemeBuilder () {
return this . phonemeBuilder ;
}
public RulesApplication invoke () {
this . found = false ;
int patternLength = 1 ;
final List < Rule > rules = this . finalRules . get ( input . subSequence ( i , i + patternLength ) ) ;
if ( rules != null ) {
for ( final Rule rule : rules ) {
final String pattern = rule . getPattern () ;
patternLength = pattern . length () ;
if ( rule . patternAndContextMatches ( this . input , this . i ) ) {
this . phonemeBuilder . apply ( rule . getPhoneme () , maxPhonemes ) ;
this . found = true ;
break;
}
}
}
if ( ! this . found ) {
patternLength = 1 ;
}
this . i += patternLength ;
return this ;
}
public boolean isFound () {
return this . found ;
}
private static String join ( final Iterable < String > strings , final String sep ) {
final StringBuilder sb = new StringBuilder () ;
final Iterator < String > si = strings . iterator () ;
if ( si . hasNext () ) {
sb . append ( si . next () ) ;
}
while ( si . hasNext () ) {
sb . append ( sep ) . append ( si . next () ) ;
}
return sb . toString () ;
}
private PhonemeBuilder applyFinalRules ( final PhonemeBuilder phonemeBuilder ,
final Map < String , List < Rule > > finalRules ) {
Objects . requireNonNull ( finalRules , lr_3 ) ;
if ( finalRules . isEmpty () ) { MST[rv.ROR2Mutator]MSP[]
return phonemeBuilder ;
}
final Map < Rule . Phoneme , Rule . Phoneme > phonemes =
new TreeMap <> ( Rule . Phoneme . COMPARATOR ) ;
for ( final Rule . Phoneme phoneme : phonemeBuilder . getPhonemes () ) {
PhonemeBuilder subBuilder = PhonemeBuilder . empty ( phoneme . getLanguages () ) ;
final String phonemeText = phoneme . getPhonemeText () . toString () ;
for ( int i = 0 ; i < phonemeText . length () ; ) {
final RulesApplication rulesApplication =
new RulesApplication ( finalRules , phonemeText , subBuilder , i , maxPhonemes ) . invoke () ;
final boolean found = rulesApplication . isFound () ;
subBuilder = rulesApplication . getPhonemeBuilder () ;
if ( ! found ) {
subBuilder . append ( phonemeText . subSequence ( i , i + 1 ) ) ;
}
i = rulesApplication . getI () ;
}
for ( final Rule . Phoneme newPhoneme : subBuilder . getPhonemes () ) {
if ( phonemes . containsKey ( newPhoneme ) ) {
final Rule . Phoneme oldPhoneme = phonemes . remove ( newPhoneme ) ;
final Rule . Phoneme mergedPhoneme = oldPhoneme . mergeWithLanguage ( newPhoneme . getLanguages () ) ;
phonemes . put ( mergedPhoneme , mergedPhoneme ) ;
} else {
phonemes . put ( newPhoneme , newPhoneme ) ;
}
}
}
return new PhonemeBuilder ( phonemes . keySet () ) ;
}
public String encode ( final String input ) {
final Languages . LanguageSet languageSet = this . lang . guessLanguages ( input ) ;
return encode ( input , languageSet ) ;
}
public String encode ( String input , final Languages . LanguageSet languageSet ) {
final Map < String , List < Rule > > rules = Rule . getInstanceMap ( this . nameType , RuleType . RULES , languageSet ) ;
final Map < String , List < Rule > > finalRules1 = Rule . getInstanceMap ( this . nameType , this . ruleType , lr_4 ) ;
final Map < String , List < Rule > > finalRules2 = Rule . getInstanceMap ( this . nameType , this . ruleType , languageSet ) ;
input = input . toLowerCase ( Locale . ENGLISH ) . replace ( '-' , ' ' ) . trim () ;
if ( this . nameType == NameType . GENERIC ) {
if ( input . length () >= 2 && input . substring ( 0 , 2 ) . equals ( lr_5 ) ) {
final String remainder = input . substring ( 2 ) ;
final String combined = lr_6 + remainder ;
return lr_7 + encode ( remainder ) + lr_8 + encode ( combined ) + lr_9 ;
}
for ( final String l : NAME_PREFIXES . get ( this . nameType ) ) {
if ( input . startsWith ( l + lr_10 ) ) {
final String remainder = input . substring ( l . length () + 1 ) ;
final String combined = l + remainder ;
return lr_7 + encode ( remainder ) + lr_8 + encode ( combined ) + lr_9 ;
}
}
}
final List < String > words = Arrays . asList ( input . split ( lr_11 ) ) ;
final List < String > words2 = new ArrayList <> () ;
switch ( this . nameType ) {
case SEPHARDIC :
for ( final String aWord : words ) {
final String [] parts = aWord . split ( lr_12 ) ;
final String lastPart = parts [ parts . length - 1 ] ;
words2 . add ( lastPart ) ;
}
words2 . removeAll ( NAME_PREFIXES . get ( this . nameType ) ) ;
break;
case ASHKENAZI :
words2 . addAll ( words ) ;
words2 . removeAll ( NAME_PREFIXES . get ( this . nameType ) ) ;
break;
case GENERIC :
words2 . addAll ( words ) ;
break;
default:
throw new IllegalStateException ( lr_13 + this . nameType ) ;
}
if ( this . concat ) {
input = join ( words2 , lr_10 ) ;
} else if ( words2 . size () == 1 ) {
input = words . iterator () . next () ;
} else {
final StringBuilder result = new StringBuilder () ;
for ( final String word : words2 ) {
result . append ( lr_14 ) . append ( encode ( word ) ) ;
}
return result . substring ( 1 ) ;
}
PhonemeBuilder phonemeBuilder = PhonemeBuilder . empty ( languageSet ) ;
for ( int i = 0 ; i < input . length () ; ) {
final RulesApplication rulesApplication =
new RulesApplication ( rules , input , phonemeBuilder , i , maxPhonemes ) . invoke () ;
i = rulesApplication . getI () ;
phonemeBuilder = rulesApplication . getPhonemeBuilder () ;
}
phonemeBuilder = applyFinalRules ( phonemeBuilder , finalRules1 ) ;
phonemeBuilder = applyFinalRules ( phonemeBuilder , finalRules2 ) ;
return phonemeBuilder . makeString () ;
}
public Lang getLang () {
return this . lang ;
}
public NameType getNameType () {
return this . nameType ;
}
public RuleType getRuleType () {
return this . ruleType ;
}
public boolean isConcat () {
return this . concat ;
}
public int getMaxPhonemes () {
return this . maxPhonemes ;
}

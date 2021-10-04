private static StringTokenizer getCSVClone () {
return ( StringTokenizer ) CSV_TOKENIZER_PROTOTYPE . clone () ;
}
public static StringTokenizer getCSVInstance () {
return getCSVClone () ;
}
public static StringTokenizer getCSVInstance ( final String input ) {
final StringTokenizer tok = getCSVClone () ;
tok . reset ( input ) ;
return tok ;
}
public static StringTokenizer getCSVInstance ( final char [] input ) {
final StringTokenizer tok = getCSVClone () ;
tok . reset ( input ) ;
return tok ;
}
private static StringTokenizer getTSVClone () {
return ( StringTokenizer ) TSV_TOKENIZER_PROTOTYPE . clone () ;
}
public static StringTokenizer getTSVInstance () {
return getTSVClone () ;
}
public static StringTokenizer getTSVInstance ( final String input ) {
final StringTokenizer tok = getTSVClone () ;
tok . reset ( input ) ;
return tok ;
}
public static StringTokenizer getTSVInstance ( final char [] input ) {
final StringTokenizer tok = getTSVClone () ;
tok . reset ( input ) ;
return tok ;
}
public int size () {
checkTokenized () ;
return tokens . length ;
}
public String nextToken () {
if ( hasNext () ) {
return tokens [ tokenPos ++ ] ;
}
return null ;
}
public String previousToken () {
if ( hasPrevious () ) {
return tokens [ -- tokenPos ] ;
}
return null ;
}
public String [] getTokenArray () {
checkTokenized () ;
return tokens . clone () ;
}
public List < String > getTokenList () {
checkTokenized () ;
final List < String > list = new ArrayList <> ( tokens . length ) ;
Collections . addAll ( list , tokens ) ;
return list ;
}
public StringTokenizer reset () {
tokenPos = 0 ;
tokens = null ;
return this ;
}
public StringTokenizer reset ( final String input ) {
reset () ;
if ( input != null ) {
this . chars = input . toCharArray () ;
} else {
this . chars = null ;
}
return this ;
}
public StringTokenizer reset ( final char [] input ) {
reset () ;
if ( input != null ) {
this . chars = input . clone () ;
} else {
this . chars = null ;
}
return this ;
}
@Override
public boolean hasNext () {
checkTokenized () ;
return tokenPos < tokens . length ;
}
@Override
public String next () {
if ( hasNext () ) {
return tokens [ tokenPos ++ ] ;
}
throw new NoSuchElementException () ;
}
@Override
public int nextIndex () {
return tokenPos ;
}
@Override
public boolean hasPrevious () {
checkTokenized () ;
return tokenPos > 0 ;
}
@Override
public String previous () {
if ( hasPrevious () ) {
return tokens [ -- tokenPos ] ;
}
throw new NoSuchElementException () ;
}
@Override
public int previousIndex () {
return tokenPos - 1 ;
}
@Override
public void remove () {
throw new UnsupportedOperationException ( lr_1 ) ;
}
@Override
public void set ( final String obj ) {
throw new UnsupportedOperationException ( lr_2 ) ;
}
@Override
public void add ( final String obj ) {
throw new UnsupportedOperationException ( lr_3 ) ;
}
private void checkTokenized () {
if ( tokens == null ) {
if ( chars == null ) {
final List < String > split = tokenize ( null , 0 , 0 ) ;
tokens = split . toArray ( new String [ split . size () ] ) ;
} else {
final List < String > split = tokenize ( chars , 0 , chars . length ) ;
tokens = split . toArray ( new String [ split . size () ] ) ;
}
}
}
protected List < String > tokenize ( final char [] srcChars , final int offset , final int count ) {
if ( srcChars == null || count == 0 ) {
return Collections . emptyList () ;
}
final TextStringBuilder buf = new TextStringBuilder () ;
final List < String > tokenList = new ArrayList <> () ;
int pos = offset ;
while ( pos >= 0 && pos < count ) {
pos = readNextToken ( srcChars , pos , count , buf , tokenList ) ;
if ( pos >= count ) {
addToken ( tokenList , lr_4 ) ;
}
}
return tokenList ;
}
private void addToken ( final List < String > list , String tok ) {
if ( tok == null || tok . length () == 0 ) {
if ( isIgnoreEmptyTokens () ) {
return;
}
if ( isEmptyTokenAsNull () ) {
tok = null ;
}
}
list . add ( tok ) ;
}
private int readNextToken ( final char [] srcChars , int start , final int len , final TextStringBuilder workArea ,
final List < String > tokenList ) {
while ( start < len ) {
final int removeLen = Math . max ( getIgnoredMatcher () . isMatch ( srcChars , start , start , len ) ,
getTrimmerMatcher () . isMatch ( srcChars , start , start , len ) ) ;
if ( removeLen == 0 || getDelimiterMatcher () . isMatch ( srcChars , start , start , len ) > 0
|| getQuoteMatcher () . isMatch ( srcChars , start , start , len ) > 0 ) {
break;
}
start += removeLen ;
}
if ( start >= len ) {
addToken ( tokenList , lr_4 ) ;
return - 1 ;
}
final int delimLen = getDelimiterMatcher () . isMatch ( srcChars , start , start , len ) ;
if ( delimLen > 0 ) {
addToken ( tokenList , lr_4 ) ;
return start + delimLen ;
}
final int quoteLen = getQuoteMatcher () . isMatch ( srcChars , start , start , len ) ;
if ( quoteLen > 0 ) {
return readWithQuotes ( srcChars , start + quoteLen , len , workArea , tokenList , start , quoteLen ) ;
}
return readWithQuotes ( srcChars , start , len , workArea , tokenList , 0 , 0 ) ;
}
private int readWithQuotes ( final char [] srcChars , final int start , final int len , final TextStringBuilder workArea ,
final List < String > tokenList , final int quoteStart , final int quoteLen ) {
workArea . clear () ;
int pos = start ;
boolean quoting = quoteLen > 0 ;
int trimStart = 0 ;
while ( pos < len ) {
if ( quoting ) {
if ( isQuote ( srcChars , pos , len , quoteStart , quoteLen ) ) {
if ( isQuote ( srcChars , pos + quoteLen , len , quoteStart , quoteLen ) ) {
workArea . append ( srcChars , pos , quoteLen ) ;
pos += quoteLen * 2 ;
trimStart = workArea . size () ;
continue;
}
quoting = false ;
pos += quoteLen ;
continue;
}
workArea . append ( srcChars [ pos ++ ] ) ;
trimStart = workArea . size () ;
} else {
final int delimLen = getDelimiterMatcher () . isMatch ( srcChars , pos , start , len ) ;
if ( delimLen > 0 ) {
addToken ( tokenList , workArea . substring ( 0 , trimStart ) ) ;
return pos + delimLen ;
}
if ( quoteLen > 0 && isQuote ( srcChars , pos , len , quoteStart , quoteLen ) ) {
quoting = true ;
pos += quoteLen ;
continue;
}
final int ignoredLen = getIgnoredMatcher () . isMatch ( srcChars , pos , start , len ) ;
if ( ignoredLen > 0 ) {
pos += ignoredLen ;
continue;
}
final int trimmedLen = getTrimmerMatcher () . isMatch ( srcChars , pos , start , len ) ;
if ( trimmedLen > 0 ) {
workArea . append ( srcChars , pos , trimmedLen ) ;
pos += trimmedLen ;
continue;
}
workArea . append ( srcChars [ pos ++ ] ) ;
trimStart = workArea . size () ;
}
}
addToken ( tokenList , workArea . substring ( 0 , trimStart ) ) ;
return - 1 ;
}
private boolean isQuote ( final char [] srcChars , final int pos , final int len , final int quoteStart ,
final int quoteLen ) {
for ( int i = 0 ; i < quoteLen ; i ++ ) {
if ( pos + i >= len || srcChars [ pos + i ] != srcChars [ quoteStart + i ] ) {
return false ;
}
}
return true ;
}
public StringMatcher getDelimiterMatcher () {
return this . delimMatcher ;
}
public StringTokenizer setDelimiterMatcher ( final StringMatcher delim ) {
if ( delim == null ) {
this . delimMatcher = StringMatcherFactory . INSTANCE . noneMatcher () ;
} else {
this . delimMatcher = delim ;
}
return this ;
}
public StringTokenizer setDelimiterChar ( final char delim ) {
return setDelimiterMatcher ( StringMatcherFactory . INSTANCE . charMatcher ( delim ) ) ;
}
public StringTokenizer setDelimiterString ( final String delim ) {
return setDelimiterMatcher ( StringMatcherFactory . INSTANCE . stringMatcher ( delim ) ) ;
}
public StringMatcher getQuoteMatcher () {
return quoteMatcher ;
}
public StringTokenizer setQuoteMatcher ( final StringMatcher quote ) {
if ( quote != null ) {
this . quoteMatcher = quote ;
}
return this ;
}
public StringTokenizer setQuoteChar ( final char quote ) {
return setQuoteMatcher ( StringMatcherFactory . INSTANCE . charMatcher ( quote ) ) ;
}
public StringMatcher getIgnoredMatcher () {
return ignoredMatcher ;
}
public StringTokenizer setIgnoredMatcher ( final StringMatcher ignored ) {
if ( ignored != null ) {
this . ignoredMatcher = ignored ;
}
return this ;
}
public StringTokenizer setIgnoredChar ( final char ignored ) {
return setIgnoredMatcher ( StringMatcherFactory . INSTANCE . charMatcher ( ignored ) ) ;
}
public StringMatcher getTrimmerMatcher () {
return trimmerMatcher ;
}
public StringTokenizer setTrimmerMatcher ( final StringMatcher trimmer ) {
if ( trimmer != null ) {
this . trimmerMatcher = trimmer ;
}
return this ;
}
public boolean isEmptyTokenAsNull () {
return this . emptyAsNull ;
}
public StringTokenizer setEmptyTokenAsNull ( final boolean emptyAsNull ) {
this . emptyAsNull = emptyAsNull ;
return this ;
}
public boolean isIgnoreEmptyTokens () {
return ignoreEmptyTokens ;
}
public StringTokenizer setIgnoreEmptyTokens ( final boolean ignoreEmptyTokens ) {
this . ignoreEmptyTokens = ignoreEmptyTokens ;
return this ;
}
public String getContent () {
if ( chars == null ) {
return null ;
}
return new String ( chars ) ;
}
@Override
public Object clone () {
try {
return cloneReset () ;
} catch ( final CloneNotSupportedException ex ) {
return null ;
}
}
Object cloneReset () throws CloneNotSupportedException {
final StringTokenizer cloned = ( StringTokenizer ) super . clone () ;
if ( cloned . chars != null ) {
cloned . chars = cloned . chars . clone () ;
}
cloned . reset () ;
return cloned ;
}
@Override
public String toString () {
if ( tokens == null ) {
return lr_5 ;
}
return lr_6 + getTokenList () ;
}

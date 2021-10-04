private void bufferUp () {
if ( readFully )
return;
final int pos = bufPos ;
if ( pos < bufSplitPoint )
return;
try {
final long skipped = reader . skip ( pos ) ;
reader . mark ( maxBufferLen ) ;
int read = 0 ;
while ( read <= minReadAheadLen ) {
int thisRead = reader . read ( charBuf , read , charBuf . length - read ) ;
if ( thisRead == - 1 )
readFully = true ;
if ( thisRead <= 0 )
break;
read += thisRead ;
}
reader . reset () ;
if ( read > 0 ) {
Validate . isTrue ( skipped == pos ) ;
bufLength = read ;
readerPos += pos ;
bufPos = 0 ;
bufMark = - 1 ;
bufSplitPoint = bufLength > readAheadLimit ? readAheadLimit : bufLength ;
}
} catch ( IOException e ) {
throw new UncheckedIOException ( e ) ;
}
}
public int pos () {
return readerPos + bufPos ;
}
public boolean isEmpty () {
bufferUp () ;
return bufPos >= bufLength ;
}
private boolean isEmptyNoBufferUp () {
return bufPos >= bufLength ;
}
public char current () {
bufferUp () ;
return isEmptyNoBufferUp () ? EOF : charBuf [ bufPos ] ;
}
char consume () {
bufferUp () ;
char val = isEmptyNoBufferUp () ? EOF : charBuf [ bufPos ] ;
bufPos ++ ;
return val ;
}
void unconsume () {
if ( bufPos < 1 )
throw new UncheckedIOException ( new IOException ( lr_1 ) ) ;
bufPos -- ;
}
public void advance () {
bufPos ++ ;
}
void mark () {
if ( bufLength - bufPos < minReadAheadLen )
bufSplitPoint = 0 ;
bufferUp () ;
bufMark = bufPos ;
}
void unmark () {
bufMark = - 1 ;
}
void rewindToMark () {
if ( bufMark == - 1 )
throw new UncheckedIOException ( new IOException ( lr_2 ) ) ;
bufPos = bufMark ;
unmark () ;
}
int nextIndexOf ( char c ) {
bufferUp () ;
for ( int i = bufPos ; i < bufLength ; i ++ ) {
if ( c == charBuf [ i ] )
return i - bufPos ;
}
return - 1 ;
}
int nextIndexOf ( CharSequence seq ) {
bufferUp () ;
char startChar = seq . charAt ( 0 ) ;
for ( int offset = bufPos ; offset < bufLength ; offset ++ ) {
if ( startChar != charBuf [ offset ] )
while( ++ offset < bufLength && startChar != charBuf [ offset ] ) { }
int i = offset + 1 ;
int last = i + seq . length () - 1 ;
if ( offset < bufLength && last <= bufLength ) {
for ( int j = 1 ; i < last && seq . charAt ( j ) == charBuf [ i ] ; i ++ , j ++ ) { }
if ( i == last )
return offset - bufPos ;
}
}
return - 1 ;
}
public String consumeTo ( char c ) {
int offset = nextIndexOf ( c ) ;
if ( offset != - 1 ) {
String consumed = cacheString ( charBuf , stringCache , bufPos , offset ) ;
bufPos += offset ; MST[rv.AOD1Mutator]MSP[N]
return consumed ;
} else {
return consumeToEnd () ;
}
}
String consumeTo ( String seq ) {
int offset = nextIndexOf ( seq ) ;
if ( offset != - 1 ) {
String consumed = cacheString ( charBuf , stringCache , bufPos , offset ) ;
bufPos += offset ;
return consumed ;
} else if ( bufLength - bufPos < seq . length () ) {
return consumeToEnd () ;
} else {
int endPos = bufLength - seq . length () + 1 ;
String consumed = cacheString ( charBuf , stringCache , bufPos , endPos - bufPos ) ;
bufPos = endPos ;
return consumed ;
}
}
public String consumeToAny ( final char ... chars ) {
bufferUp () ;
int pos = bufPos ;
final int start = pos ;
final int remaining = bufLength ;
final char [] val = charBuf ;
final int charLen = chars . length ;
int i ;
OUTER: while ( pos < remaining ) {
for ( i = 0 ; i < charLen ; i ++ ) {
if ( val [ pos ] == chars [ i ] )
break OUTER;
}
pos ++ ;
}
bufPos = pos ;
return pos > start ? cacheString ( charBuf , stringCache , start , pos - start ) : lr_3 ;
}
String consumeToAnySorted ( final char ... chars ) {
bufferUp () ;
int pos = bufPos ;
final int start = pos ;
final int remaining = bufLength ;
final char [] val = charBuf ;
while ( pos < remaining ) {
if ( Arrays . binarySearch ( chars , val [ pos ] ) >= 0 )
break;
pos ++ ;
}
bufPos = pos ;
return bufPos > start ? cacheString ( charBuf , stringCache , start , pos - start ) : lr_3 ;
}
String consumeData () {
int pos = bufPos ;
final int start = pos ;
final int remaining = bufLength ;
final char [] val = charBuf ;
OUTER: while ( pos < remaining ) {
switch ( val [ pos ] ) {
case '&' :
case '<' :
case TokeniserState . nullChar :
break OUTER;
default:
pos ++ ;
}
}
bufPos = pos ;
return pos > start ? cacheString ( charBuf , stringCache , start , pos - start ) : lr_3 ;
}
String consumeRawData () {
int pos = bufPos ;
final int start = pos ;
final int remaining = bufLength ;
final char [] val = charBuf ;
OUTER: while ( pos < remaining ) {
switch ( val [ pos ] ) {
case '<' :
case TokeniserState . nullChar :
break OUTER;
default:
pos ++ ;
}
}
bufPos = pos ;
return pos > start ? cacheString ( charBuf , stringCache , start , pos - start ) : lr_3 ;
}
String consumeTagName () {
bufferUp () ;
int pos = bufPos ;
final int start = pos ;
final int remaining = bufLength ;
final char [] val = charBuf ;
OUTER: while ( pos < remaining ) {
switch ( val [ pos ] ) {
case '\t' :
case '\n' :
case '\r' :
case '\f' :
case ' ' :
case '/' :
case '>' :
case '<' :
case TokeniserState . nullChar :
break OUTER;
}
pos ++ ;
}
bufPos = pos ;
return pos > start ? cacheString ( charBuf , stringCache , start , pos - start ) : lr_3 ;
}
String consumeToEnd () {
bufferUp () ;
String data = cacheString ( charBuf , stringCache , bufPos , bufLength - bufPos ) ;
bufPos = bufLength ;
return data ;
}
String consumeLetterSequence () {
bufferUp () ;
int start = bufPos ;
while ( bufPos < bufLength ) {
char c = charBuf [ bufPos ] ;
if ( ( c >= 'A' && c <= 'Z' ) || ( c >= 'a' && c <= 'z' ) || Character . isLetter ( c ) )
bufPos ++ ;
else
break;
}
return cacheString ( charBuf , stringCache , start , bufPos - start ) ;
}
String consumeLetterThenDigitSequence () {
bufferUp () ;
int start = bufPos ;
while ( bufPos < bufLength ) {
char c = charBuf [ bufPos ] ;
if ( ( c >= 'A' && c <= 'Z' ) || ( c >= 'a' && c <= 'z' ) || Character . isLetter ( c ) )
bufPos ++ ;
else
break;
}
while ( ! isEmptyNoBufferUp () ) {
char c = charBuf [ bufPos ] ;
if ( c >= '0' && c <= '9' )
bufPos ++ ;
else
break;
}
return cacheString ( charBuf , stringCache , start , bufPos - start ) ;
}
String consumeHexSequence () {
bufferUp () ;
int start = bufPos ;
while ( bufPos < bufLength ) {
char c = charBuf [ bufPos ] ;
if ( ( c >= '0' && c <= '9' ) || ( c >= 'A' && c <= 'F' ) || ( c >= 'a' && c <= 'f' ) )
bufPos ++ ;
else
break;
}
return cacheString ( charBuf , stringCache , start , bufPos - start ) ;
}
String consumeDigitSequence () {
bufferUp () ;
int start = bufPos ;
while ( bufPos < bufLength ) {
char c = charBuf [ bufPos ] ;
if ( c >= '0' && c <= '9' )
bufPos ++ ;
else
break;
}
return cacheString ( charBuf , stringCache , start , bufPos - start ) ;
}
boolean matches ( char c ) {
return ! isEmpty () && charBuf [ bufPos ] == c ;
}
boolean matches ( String seq ) {
bufferUp () ;
int scanLength = seq . length () ;
if ( scanLength > bufLength - bufPos )
return false ;
for ( int offset = 0 ; offset < scanLength ; offset ++ )
if ( seq . charAt ( offset ) != charBuf [ bufPos + offset ] )
return false ;
return true ;
}
boolean matchesIgnoreCase ( String seq ) {
bufferUp () ;
int scanLength = seq . length () ;
if ( scanLength > bufLength - bufPos )
return false ;
for ( int offset = 0 ; offset < scanLength ; offset ++ ) {
char upScan = Character . toUpperCase ( seq . charAt ( offset ) ) ;
char upTarget = Character . toUpperCase ( charBuf [ bufPos + offset ] ) ;
if ( upScan != upTarget )
return false ;
}
return true ;
}
boolean matchesAny ( char ... seq ) {
if ( isEmpty () )
return false ;
bufferUp () ;
char c = charBuf [ bufPos ] ;
for ( char seek : seq ) {
if ( seek == c )
return true ;
}
return false ;
}
boolean matchesAnySorted ( char [] seq ) {
bufferUp () ;
return ! isEmpty () && Arrays . binarySearch ( seq , charBuf [ bufPos ] ) >= 0 ;
}
boolean matchesLetter () {
if ( isEmpty () )
return false ;
char c = charBuf [ bufPos ] ;
return ( c >= 'A' && c <= 'Z' ) || ( c >= 'a' && c <= 'z' ) || Character . isLetter ( c ) ;
}
boolean matchesDigit () {
if ( isEmpty () )
return false ;
char c = charBuf [ bufPos ] ;
return ( c >= '0' && c <= '9' ) ;
}
boolean matchConsume ( String seq ) {
bufferUp () ;
if ( matches ( seq ) ) {
bufPos += seq . length () ;
return true ;
} else {
return false ;
}
}
boolean matchConsumeIgnoreCase ( String seq ) {
if ( matchesIgnoreCase ( seq ) ) {
bufPos += seq . length () ;
return true ;
} else {
return false ;
}
}
boolean containsIgnoreCase ( String seq ) {
String loScan = seq . toLowerCase ( Locale . ENGLISH ) ;
String hiScan = seq . toUpperCase ( Locale . ENGLISH ) ;
return ( nextIndexOf ( loScan ) > - 1 ) || ( nextIndexOf ( hiScan ) > - 1 ) ;
}
@Override
public String toString () {
return new String ( charBuf , bufPos , bufLength - bufPos ) ;
}
private static String cacheString ( final char [] charBuf , final String [] stringCache , final int start , final int count ) {
if ( count > maxStringCacheLen )
return new String ( charBuf , start , count ) ;
if ( count < 1 )
return lr_3 ;
int hash = 0 ;
int offset = start ;
for ( int i = 0 ; i < count ; i ++ ) {
hash = 31 * hash + charBuf [ offset ++ ] ;
}
final int index = hash & stringCache . length - 1 ;
String cached = stringCache [ index ] ;
if ( cached == null ) {
cached = new String ( charBuf , start , count ) ;
stringCache [ index ] = cached ;
} else {
if ( rangeEquals ( charBuf , start , count , cached ) ) {
return cached ;
} else {
cached = new String ( charBuf , start , count ) ;
stringCache [ index ] = cached ;
}
}
return cached ;
}
static boolean rangeEquals ( final char [] charBuf , final int start , int count , final String cached ) {
if ( count == cached . length () ) {
int i = start ;
int j = 0 ;
while ( count -- != 0 ) {
if ( charBuf [ i ++ ] != cached . charAt ( j ++ ) )
return false ;
}
return true ;
}
return false ;
}
boolean rangeEquals ( final int start , final int count , final String cached ) {
return rangeEquals ( charBuf , start , count , cached ) ;
}

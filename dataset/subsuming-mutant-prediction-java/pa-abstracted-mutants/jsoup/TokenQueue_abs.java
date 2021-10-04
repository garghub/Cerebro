public boolean isEmpty () {
return remainingLength () == 0 ;
}
private int remainingLength () {
return queue . length () - pos ;
}
public char peek () {
return isEmpty () ? 0 : queue . charAt ( pos ) ;
}
public void addFirst ( Character c ) {
addFirst ( c . toString () ) ;
}
public void addFirst ( String seq ) {
queue = seq + queue . substring ( pos ) ;
pos = 0 ;
}
public boolean matches ( String seq ) {
return queue . regionMatches ( true , pos , seq , 0 , seq . length () ) ;
}
public boolean matchesCS ( String seq ) {
return queue . startsWith ( seq , pos ) ;
}
public boolean matchesAny ( String ... seq ) {
for ( String s : seq ) {
if ( matches ( s ) )
return true ;
}
return false ;
}
public boolean matchesAny ( char ... seq ) {
if ( isEmpty () )
return false ;
for ( char c : seq ) {
if ( queue . charAt ( pos ) == c )
return true ;
}
return false ;
}
public boolean matchesStartTag () {
return ( remainingLength () >= 2 && queue . charAt ( pos ) == '<' && Character . isLetter ( queue . charAt ( pos + 1 ) ) ) ;
}
public boolean matchChomp ( String seq ) {
if ( matches ( seq ) ) {
pos += seq . length () ;
return true ;
} else {
return false ;
}
}
public boolean matchesWhitespace () {
return ! isEmpty () && StringUtil . isWhitespace ( queue . charAt ( pos ) ) ;
}
public boolean matchesWord () {
return ! isEmpty () && Character . isLetterOrDigit ( queue . charAt ( pos ) ) ;
}
public void advance () {
if ( ! isEmpty () ) pos ++ ;
}
public char consume () {
return queue . charAt ( pos ++ ) ;
}
public void consume ( String seq ) {
if ( ! matches ( seq ) )
throw new IllegalStateException ( lr_1 ) ;
int len = seq . length () ;
if ( len > remainingLength () )
throw new IllegalStateException ( lr_2 ) ;
pos += len ;
}
public String consumeTo ( String seq ) {
int offset = queue . indexOf ( seq , pos ) ;
if ( offset != - 1 ) {
String consumed = queue . substring ( pos , offset ) ;
pos += consumed . length () ;
return consumed ;
} else {
return remainder () ;
}
}
public String consumeToIgnoreCase ( String seq ) {
int start = pos ;
String first = seq . substring ( 0 , 1 ) ;
boolean canScan = first . toLowerCase () . equals ( first . toUpperCase () ) ;
while ( ! isEmpty () ) {
if ( matches ( seq ) )
break;
if ( canScan ) {
int skip = queue . indexOf ( first , pos ) - pos ;
if ( skip == 0 )
pos ++ ;
else if ( skip < 0 )
pos = queue . length () ;
else
pos += skip ;
}
else
pos ++ ;
}
return queue . substring ( start , pos ) ;
}
public String consumeToAny ( String ... seq ) {
int start = pos ;
while ( ! isEmpty () && ! matchesAny ( seq ) ) {
pos ++ ;
}
return queue . substring ( start , pos ) ;
}
public String chompTo ( String seq ) {
String data = consumeTo ( seq ) ;
matchChomp ( seq ) ;
return data ;
}
public String chompToIgnoreCase ( String seq ) {
String data = consumeToIgnoreCase ( seq ) ;
matchChomp ( seq ) ;
return data ;
}
public String chompBalanced ( char open , char close ) {
int start = - 1 ;
int end = - 1 ;
int depth = 0 ;
char last = 0 ;
boolean inSingleQuote = false ;
boolean inDoubleQuote = false ;
do {
if ( isEmpty () ) break;
char c = consume () ;
if ( last == 0 || last != ESC ) {
if ( c == '\'' && c != open && ! inDoubleQuote )
inSingleQuote = ! inSingleQuote ;
else if ( c == '"' && c != open && ! inSingleQuote )
inDoubleQuote = ! inDoubleQuote ;
if ( inSingleQuote || inDoubleQuote )
continue;
if ( c == open ) {
depth ++ ;
if ( start == - 1 )
start = pos ;
}
else if ( c == close )
depth -- ;
}
if ( depth > 0 && last != 0 )
end = pos ;
last = c ;
} while ( depth > 0 );
final String out = ( end >= 0 ) ? queue . substring ( start , end ) : lr_3 ;
if ( depth > 0 ) {
Validate . fail ( lr_4 + out + lr_5 ) ;
}
return out ;
}
public static String unescape ( String in ) {
StringBuilder out = StringUtil . borrowBuilder () ;
char last = 0 ;
for ( char c : in . toCharArray () ) {
if ( c == ESC ) {
if ( last != 0 && last == ESC )
out . append ( c ) ;
}
else
out . append ( c ) ;
last = c ;
}
return StringUtil . releaseBuilder ( out ) ;
}
public boolean consumeWhitespace () {
boolean seen = false ;
while ( matchesWhitespace () ) {
pos ++ ;
seen = true ;
}
return seen ;
}
public String consumeWord () {
int start = pos ;
while ( matchesWord () )
pos ++ ;
return queue . substring ( start , pos ) ;
}
public String consumeTagName () {
int start = pos ;
while ( ! isEmpty () && ( matchesWord () || matchesAny ( ':' , '_' , '-' ) ) )
pos ++ ;
return queue . substring ( start , pos ) ;
}
public String consumeElementSelector () {
int start = pos ;
while ( ! isEmpty () && ( matchesWord () || matchesAny ( lr_6 , lr_7 , lr_8 , lr_9 ) ) )
pos ++ ;
return queue . substring ( start , pos ) ;
}
public String consumeCssIdentifier () {
int start = pos ;
while ( ! isEmpty () && ( matchesWord () || matchesAny ( '-' , '_' ) ) )
pos ++ ;
return queue . substring ( start , pos ) ;
}
public String consumeAttributeKey () {
int start = pos ;
while ( ! isEmpty () && ( matchesWord () || matchesAny ( '-' , '_' , ':' ) ) )
pos ++ ;
return queue . substring ( start , pos ) ;
}
public String remainder () {
final String remainder = queue . substring ( pos , queue . length () ) ;
pos = queue . length () ;
return remainder ;
}
@Override
public String toString () {
return queue . substring ( pos ) ;
}

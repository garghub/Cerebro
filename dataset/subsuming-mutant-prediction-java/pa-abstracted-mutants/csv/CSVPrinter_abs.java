public void println () throws IOException {
out . append ( format . getRecordSeparator () ) ;
newRecord = true ;
}
public void flush () throws IOException {
if ( out instanceof Flushable ) {
( ( Flushable ) out ) . flush () ;
}
}
public void printRecord ( final Object ... values ) throws IOException {
for ( final Object value : values ) {
print ( value ) ;
}
println () ;
}
public void printRecord ( final Iterable < ? > values ) throws IOException {
for ( final Object value : values ) {
print ( value ) ;
}
println () ;
}
public void printComment ( final String comment ) throws IOException {
if ( ! format . isCommentingEnabled () ) {
return;
}
if ( ! newRecord ) {
println () ;
}
out . append ( format . getCommentStart () . charValue () ) ;
out . append ( SP ) ;
for ( int i = 0 ; i < comment . length () ; i ++ ) {
final char c = comment . charAt ( i ) ;
switch ( c ) {
case CR :
if ( i + 1 < comment . length () && comment . charAt ( i + 1 ) == LF ) {
i ++ ;
}
case LF :
println () ;
out . append ( format . getCommentStart () . charValue () ) ;
out . append ( SP ) ;
break;
default:
out . append ( c ) ;
break;
}
}
println () ;
}
private void print ( final Object object , final CharSequence value ,
final int offset , final int len ) throws IOException {
if ( ! newRecord ) {
out . append ( format . getDelimiter () ) ;
}
if ( format . isQuoting () ) {
printAndQuote ( object , value , offset , len ) ;
} else if ( format . isEscaping () ) {
printAndEscape ( value , offset , len ) ;
} else {
out . append ( value , offset , offset + len ) ;
}
newRecord = false ;
}
private void printAndEscape ( final CharSequence value , final int offset , final int len ) throws IOException {
int start = offset ;
int pos = offset ;
final int end = offset + len ;
final char delim = format . getDelimiter () ;
final char escape = format . getEscape () . charValue () ;
while ( pos < end ) {
char c = value . charAt ( pos ) ;
if ( c == CR || c == LF || c == delim || c == escape ) {
if ( pos > start ) {
out . append ( value , start , pos ) ;
}
if ( c == LF ) {
c = 'n' ;
} else if ( c == CR ) {
c = 'r' ;
}
out . append ( escape ) ;
out . append ( c ) ;
start = pos + 1 ;
}
pos ++ ;
}
if ( pos > start ) {
out . append ( value , start , pos ) ;
}
}
private void printAndQuote ( final Object object , final CharSequence value ,
final int offset , final int len ) throws IOException {
boolean quote = false ;
int start = offset ;
int pos = offset ;
final int end = offset + len ;
final char delimChar = format . getDelimiter () ;
final char quoteChar = format . getQuoteChar () . charValue () ;
Quote quotePolicy = format . getQuotePolicy () ;
if ( quotePolicy == null ) {
quotePolicy = Quote . MINIMAL ;
}
switch ( quotePolicy ) {
case ALL :
quote = true ;
break;
case NON_NUMERIC :
quote = ! ( object instanceof Number ) ;
break;
case NONE :
printAndEscape ( value , offset , len ) ;
return;
case MINIMAL :
if ( len <= 0 ) {
if ( newRecord ) {
quote = true ;
}
} else {
char c = value . charAt ( pos ) ;
if ( newRecord && ( c < '0' || ( c > '9' && c < 'A' ) || ( c > 'Z' && c < 'a' ) || ( c > 'z' ) ) ) {
quote = true ;
} else if ( c <= COMMENT ) {
quote = true ;
} else {
while ( pos < end ) {
c = value . charAt ( pos ) ;
if ( c == LF || c == CR || c == quoteChar || c == delimChar ) {
quote = true ;
break;
}
pos ++ ;
}
if ( ! quote ) {
pos = end - 1 ;
c = value . charAt ( pos ) ;
if ( c <= SP ) {
quote = true ;
}
}
}
}
if ( ! quote ) {
out . append ( value , start , end ) ;
return;
}
break;
}
if ( ! quote ) {
out . append ( value , start , end ) ;
return;
}
out . append ( quoteChar ) ;
while ( pos < end ) {
final char c = value . charAt ( pos ) ;
if ( c == quoteChar ) {
out . append ( value , start , pos + 1 ) ;
start = pos ;
}
pos ++ ;
}
out . append ( value , start , pos ) ;
out . append ( quoteChar ) ;
}
public void print ( final Object value ) throws IOException {
String strValue ;
if ( value == null ) {
final String nullString = format . getNullString () ;
strValue = nullString == null ? Constants . EMPTY : nullString ;
} else {
strValue = value . toString () ;
}
this . print ( value , strValue , 0 , strValue . length () ) ;
}
public void printRecords ( final Object [] values ) throws IOException {
for ( final Object value : values ) {
if ( value instanceof Object [] ) {
this . printRecord ( ( Object [] ) value ) ;
} else if ( value instanceof Iterable ) {
this . printRecord ( ( Iterable < ? > ) value ) ;
} else {
this . printRecord ( value ) ;
}
}
}
public void printRecords ( final Iterable < ? > values ) throws IOException {
for ( final Object value : values ) {
if ( value instanceof Object [] ) {
this . printRecord ( ( Object [] ) value ) ;
} else if ( value instanceof Iterable ) {
this . printRecord ( ( Iterable < ? > ) value ) ;
} else {
this . printRecord ( value ) ;
}
}
}
public void printRecords ( final ResultSet resultSet ) throws SQLException , IOException {
final int columnCount = resultSet . getMetaData () . getColumnCount () ;
while ( resultSet . next () ) {
for ( int i = 1 ; i <= columnCount ; i ++ ) {
print ( resultSet . getString ( i ) ) ;
}
println () ;
}
}
public void close () throws IOException {
if ( out instanceof Closeable ) {
( ( Closeable ) out ) . close () ;
}
}

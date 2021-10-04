Token nextToken ( final Token token ) throws IOException {
int lastChar = in . getLastChar () ;
int c = in . read () ;
boolean eol = readEndOfLine ( c ) ;
if ( ignoreEmptyLines ) {
while ( eol && isStartOfLine ( lastChar ) ) {
lastChar = c ;
c = in . read () ;
eol = readEndOfLine ( c ) ;
if ( isEndOfFile ( c ) ) {
token . type = EOF ;
return token ;
}
}
}
if ( isEndOfFile ( lastChar ) || ( ! isDelimiter ( lastChar ) && isEndOfFile ( c ) ) ) {
token . type = EOF ;
return token ;
}
if ( isStartOfLine ( lastChar ) && isCommentStart ( c ) ) {
final String line = in . readLine () ;
if ( line == null ) {
token . type = EOF ;
return token ;
}
final String comment = line . trim () ;
token . content . append ( comment ) ;
token . type = COMMENT ;
return token ;
}
while ( token . type == INVALID ) {
if ( ignoreSurroundingSpaces ) {
while ( isWhitespace ( c ) && ! eol ) {
c = in . read () ;
eol = readEndOfLine ( c ) ;
}
}
if ( isDelimiter ( c ) ) {
token . type = TOKEN ;
} else if ( eol ) {
token . type = EORECORD ;
} else if ( isQuoteChar ( c ) ) {
parseEncapsulatedToken ( token ) ;
} else if ( isEndOfFile ( c ) ) {
token . type = EOF ;
token . isReady = true ;
} else {
parseSimpleToken ( token , c ) ;
}
}
return token ;
}
private Token parseSimpleToken ( final Token token , int ch ) throws IOException {
while ( true ) {
if ( readEndOfLine ( ch ) ) {
token . type = EORECORD ;
break;
} else if ( isEndOfFile ( ch ) ) {
token . type = EOF ;
token . isReady = true ;
break;
} else if ( isDelimiter ( ch ) ) {
token . type = TOKEN ;
break;
} else if ( isEscape ( ch ) ) {
final int unescaped = readEscape () ;
if ( unescaped == Constants . END_OF_STREAM ) {
token . content . append ( ( char ) ch ) . append ( ( char ) in . getLastChar () ) ;
} else {
token . content . append ( ( char ) unescaped ) ;
}
ch = in . read () ;
} else {
token . content . append ( ( char ) ch ) ;
ch = in . read () ;
}
}
if ( ignoreSurroundingSpaces ) {
trimTrailingSpaces ( token . content ) ;
}
return token ;
}
private Token parseEncapsulatedToken ( final Token token ) throws IOException {
final long startLineNumber = getCurrentLineNumber () ;
int c ;
while ( true ) {
c = in . read () ;
if ( isEscape ( c ) ) {
final int unescaped = readEscape () ;
if ( unescaped == Constants . END_OF_STREAM ) {
token . content . append ( ( char ) c ) . append ( ( char ) in . getLastChar () ) ;
} else {
token . content . append ( ( char ) unescaped ) ;
}
} else if ( isQuoteChar ( c ) ) {
if ( isQuoteChar ( in . lookAhead () ) ) {
c = in . read () ;
token . content . append ( ( char ) c ) ;
} else {
while ( true ) {
c = in . read () ;
if ( isDelimiter ( c ) ) {
token . type = TOKEN ;
return token ;
} else if ( isEndOfFile ( c ) ) {
token . type = EOF ;
token . isReady = true ;
return token ;
} else if ( readEndOfLine ( c ) ) {
token . type = EORECORD ;
return token ;
} else if ( ! isWhitespace ( c ) ) {
throw new IOException ( lr_1 + getCurrentLineNumber () +
lr_2 ) ;
}
}
}
} else if ( isEndOfFile ( c ) ) {
throw new IOException ( lr_3 + startLineNumber +
lr_4 ) ;
} else {
token . content . append ( ( char ) c ) ;
}
}
}
private char mapNullToDisabled ( final Character c ) {
return c == null ? DISABLED : c . charValue () ;
}
long getCurrentLineNumber () {
return in . getCurrentLineNumber () ;
}
int readEscape () throws IOException {
final int ch = in . read () ;
switch ( ch ) {
case 'r' :
return CR ;
case 'n' :
return LF ;
case 't' :
return TAB ;
case 'b' :
return BACKSPACE ;
case 'f' :
return FF ;
case CR :
case LF :
case FF :
case TAB :
case BACKSPACE :
return ch ;
case END_OF_STREAM :
throw new IOException ( lr_5 ) ;
default:
if ( isMetaChar ( ch ) ) {
return ch ;
}
return END_OF_STREAM ;
}
}
void trimTrailingSpaces ( final StringBuilder buffer ) {
int length = buffer . length () ;
while ( length > 0 && Character . isWhitespace ( buffer . charAt ( length - 1 ) ) ) {
length = length - 1 ;
}
if ( length != buffer . length () ) {
buffer . setLength ( length ) ;
}
}
boolean readEndOfLine ( int ch ) throws IOException {
if ( ch == CR && in . lookAhead () == LF ) {
ch = in . read () ;
}
return ch == LF || ch == CR ;
}
boolean isClosed () {
return in . isClosed () ;
}
boolean isWhitespace ( final int ch ) {
return ! isDelimiter ( ch ) && Character . isWhitespace ( ( char ) ch ) ;
}
boolean isStartOfLine ( final int ch ) {
return ch == LF || ch == CR || ch == UNDEFINED ;
}
boolean isEndOfFile ( final int ch ) {
return ch == END_OF_STREAM ;
}
boolean isDelimiter ( final int ch ) {
return ch == delimiter ;
}
boolean isEscape ( final int ch ) {
return ch == escape ; MST[rv.CRCR3Mutator]MSP[N]
}
boolean isQuoteChar ( final int ch ) {
return ch == quoteChar ;
}
boolean isCommentStart ( final int ch ) {
return ch == commentStart ;
}
private boolean isMetaChar ( final int ch ) {
return ch == delimiter ||
ch == escape ||
ch == quoteChar ||
ch == commentStart ;
}
void close () throws IOException {
in . close () ;
}

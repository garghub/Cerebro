Token read () {
int pos = reader . pos () ;
int consecutiveReads = 0 ;
while ( ! isEmitPending ) {
state . read ( this , reader ) ;
if ( reader . pos () <= pos ) {
consecutiveReads ++ ;
}
Validate . isTrue ( consecutiveReads < 10 ,
lr_1 + this . state . name () + lr_2 + reader . current () ) ;
}
if ( charsBuilder . length () > 0 ) {
String str = charsBuilder . toString () ;
charsBuilder . delete ( 0 , charsBuilder . length () ) ;
charsString = null ;
return charPending . data ( str ) ;
} else if ( charsString != null ) {
Token token = charPending . data ( charsString ) ;
charsString = null ;
return token ;
} else {
isEmitPending = false ;
return emitPending ;
}
}
void emit ( Token token ) {
Validate . isFalse ( isEmitPending , lr_3 ) ;
emitPending = token ;
isEmitPending = true ;
if ( token . type == Token . TokenType . StartTag ) {
Token . StartTag startTag = ( Token . StartTag ) token ;
lastStartTag = startTag . tagName ;
} else if ( token . type == Token . TokenType . EndTag ) {
Token . EndTag endTag = ( Token . EndTag ) token ;
if ( endTag . attributes != null )
error ( lr_4 ) ;
}
}
void emit ( final String str ) {
if ( charsString == null ) {
charsString = str ;
}
else {
if ( charsBuilder . length () == 0 ) {
charsBuilder . append ( charsString ) ;
}
charsBuilder . append ( str ) ;
}
}
void emit ( char [] chars ) {
emit ( String . valueOf ( chars ) ) ;
}
void emit ( int [] codepoints ) {
emit ( new String ( codepoints , 0 , codepoints . length ) ) ;
}
void emit ( char c ) {
emit ( String . valueOf ( c ) ) ;
}
TokeniserState getState () {
return state ;
}
void transition ( TokeniserState state ) {
this . state = state ;
}
void advanceTransition ( TokeniserState state ) {
reader . advance () ;
this . state = state ;
}
int [] consumeCharacterReference ( Character additionalAllowedCharacter , boolean inAttribute ) {
if ( reader . isEmpty () )
return null ;
if ( additionalAllowedCharacter != null && additionalAllowedCharacter == reader . current () )
return null ;
if ( reader . matchesAnySorted ( notCharRefCharsSorted ) )
return null ;
final int [] codeRef = codepointHolder ;
reader . mark () ;
if ( reader . matchConsume ( lr_5 ) ) {
boolean isHexMode = reader . matchConsumeIgnoreCase ( lr_6 ) ;
String numRef = isHexMode ? reader . consumeHexSequence () : reader . consumeDigitSequence () ;
if ( numRef . length () == 0 ) {
characterReferenceError ( lr_7 ) ;
reader . rewindToMark () ;
return null ;
}
reader . unmark () ;
if ( ! reader . matchConsume ( lr_8 ) )
characterReferenceError ( lr_9 ) ;
int charval = - 1 ;
try {
int base = isHexMode ? 16 : 10 ;
charval = Integer . valueOf ( numRef , base ) ;
} catch ( NumberFormatException ignored ) {
}
if ( charval == - 1 || ( charval >= 0xD800 && charval <= 0xDFFF ) || charval > 0x10FFFF ) {
characterReferenceError ( lr_10 ) ;
codeRef [ 0 ] = replacementChar ;
return codeRef ;
} else {
if ( charval >= win1252ExtensionsStart && charval < win1252ExtensionsStart + win1252Extensions . length ) {
characterReferenceError ( lr_11 ) ;
charval = win1252Extensions [ charval - win1252ExtensionsStart ] ;
}
codeRef [ 0 ] = charval ;
return codeRef ;
}
} else {
String nameRef = reader . consumeLetterThenDigitSequence () ;
boolean looksLegit = reader . matches ( ';' ) ;
boolean found = ( Entities . isBaseNamedEntity ( nameRef ) || ( Entities . isNamedEntity ( nameRef ) && looksLegit ) ) ;
if ( ! found ) {
reader . rewindToMark () ;
if ( looksLegit )
characterReferenceError ( String . format ( lr_12 , nameRef ) ) ;
return null ;
}
if ( inAttribute && ( reader . matchesLetter () || reader . matchesDigit () || reader . matchesAny ( '=' , '-' , '_' ) ) ) {
reader . rewindToMark () ;
return null ;
}
reader . unmark () ;
if ( ! reader . matchConsume ( lr_8 ) )
characterReferenceError ( lr_9 ) ;
int numChars = Entities . codepointsForName ( nameRef , multipointHolder ) ;
if ( numChars == 1 ) {
codeRef [ 0 ] = multipointHolder [ 0 ] ;
return codeRef ;
} else if ( numChars == 2 ) {
return multipointHolder ;
} else {
Validate . fail ( lr_13 + nameRef ) ;
return multipointHolder ;
}
}
}
Token . Tag createTagPending ( boolean start ) {
tagPending = start ? startPending . reset () : endPending . reset () ;
return tagPending ;
}
void emitTagPending () {
tagPending . finaliseTag () ;
emit ( tagPending ) ;
}
void createCommentPending () {
commentPending . reset () ;
}
void emitCommentPending () {
emit ( commentPending ) ;
}
void createBogusCommentPending () {
commentPending . reset () ;
commentPending . bogus = true ;
}
void createDoctypePending () {
doctypePending . reset () ;
}
void emitDoctypePending () {
emit ( doctypePending ) ;
}
void createTempBuffer () {
Token . reset ( dataBuffer ) ;
}
boolean isAppropriateEndTagToken () {
return lastStartTag != null && tagPending . name () . equalsIgnoreCase ( lastStartTag ) ;
}
String appropriateEndTagName () {
return lastStartTag ;
}
void error ( TokeniserState state ) {
if ( errors . canAddError () )
errors . add ( new ParseError ( reader . pos () , lr_14 , reader . current () , state ) ) ;
}
void eofError ( TokeniserState state ) {
if ( errors . canAddError () )
errors . add ( new ParseError ( reader . pos () , lr_15 , state ) ) ;
}
private void characterReferenceError ( String message ) {
if ( errors . canAddError () )
errors . add ( new ParseError ( reader . pos () , lr_16 , message ) ) ;
}
void error ( String errorMsg ) {
if ( errors . canAddError () )
errors . add ( new ParseError ( reader . pos () , errorMsg ) ) ;
}
boolean currentNodeInHtmlNS () {
return true ;
}
String unescapeEntities ( boolean inAttribute ) {
StringBuilder builder = StringUtil . borrowBuilder () ;
while ( ! reader . isEmpty () ) {
builder . append ( reader . consumeTo ( '&' ) ) ;
if ( reader . matches ( '&' ) ) {
reader . consume () ;
int [] c = consumeCharacterReference ( null , inAttribute ) ;
if ( c == null || c . length == 0 )
builder . append ( '&' ) ;
else {
builder . appendCodePoint ( c [ 0 ] ) ;
if ( c . length == 2 )
builder . appendCodePoint ( c [ 1 ] ) ;
}
}
}
return StringUtil . releaseBuilder ( builder ) ;
}

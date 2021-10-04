void read ( Tokeniser t , CharacterReader r ) {
switch ( r . current () ) {
case '&' :
t . advanceTransition ( CharacterReferenceInData ) ;
break;
case '<' :
t . advanceTransition ( TagOpen ) ;
break;
case nullChar :
t . error ( this ) ;
t . emit ( r . consume () ) ;
break;
case eof :
t . emit ( new Token . EOF () ) ;
break;
default:
String data = r . consumeData () ;
t . emit ( data ) ;
break;
}
}
void read ( Tokeniser t , CharacterReader r ) {
readCharRef ( t , Data ) ;
}
void read ( Tokeniser t , CharacterReader r ) {
switch ( r . current () ) {
case '&' :
t . advanceTransition ( CharacterReferenceInRcdata ) ;
break;
case '<' :
t . advanceTransition ( RcdataLessthanSign ) ;
break;
case nullChar :
t . error ( this ) ;
r . advance () ;
t . emit ( replacementChar ) ;
break;
case eof :
t . emit ( new Token . EOF () ) ;
break;
default:
String data = r . consumeData () ;
t . emit ( data ) ;
break;
}
}
void read ( Tokeniser t , CharacterReader r ) {
readCharRef ( t , Rcdata ) ;
}
void read ( Tokeniser t , CharacterReader r ) {
readRawData ( t , r , this , RawtextLessthanSign ) ;
}
void read ( Tokeniser t , CharacterReader r ) {
readRawData ( t , r , this , ScriptDataLessthanSign ) ;
}
void read ( Tokeniser t , CharacterReader r ) {
switch ( r . current () ) {
case nullChar :
t . error ( this ) ;
r . advance () ;
t . emit ( replacementChar ) ;
break;
case eof :
t . emit ( new Token . EOF () ) ;
break;
default:
String data = r . consumeTo ( nullChar ) ;
t . emit ( data ) ;
break;
}
}
void read ( Tokeniser t , CharacterReader r ) {
switch ( r . current () ) {
case '!' :
t . advanceTransition ( MarkupDeclarationOpen ) ;
break;
case '/' :
t . advanceTransition ( EndTagOpen ) ;
break;
case '?' :
t . createBogusCommentPending () ;
t . advanceTransition ( BogusComment ) ;
break;
default:
if ( r . matchesLetter () ) {
t . createTagPending ( true ) ;
t . transition ( TagName ) ;
} else {
t . error ( this ) ;
t . emit ( '<' ) ;
t . transition ( Data ) ;
}
break;
}
}
void read ( Tokeniser t , CharacterReader r ) {
if ( r . isEmpty () ) {
t . eofError ( this ) ;
t . emit ( lr_1 ) ;
t . transition ( Data ) ;
} else if ( r . matchesLetter () ) {
t . createTagPending ( false ) ;
t . transition ( TagName ) ;
} else if ( r . matches ( '>' ) ) {
t . error ( this ) ;
t . advanceTransition ( Data ) ;
} else {
t . error ( this ) ;
t . createBogusCommentPending () ;
t . advanceTransition ( BogusComment ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
String tagName = r . consumeTagName () ;
t . tagPending . appendTagName ( tagName ) ;
char c = r . consume () ;
switch ( c ) {
case '\t' :
case '\n' :
case '\r' :
case '\f' :
case ' ' :
t . transition ( BeforeAttributeName ) ;
break;
case '/' :
t . transition ( SelfClosingStartTag ) ;
break;
case '<' :
r . unconsume () ;
t . error ( this ) ;
case '>' :
t . emitTagPending () ;
t . transition ( Data ) ;
break;
case nullChar :
t . tagPending . appendTagName ( replacementStr ) ;
break;
case eof :
t . eofError ( this ) ;
t . transition ( Data ) ;
break;
default:
t . tagPending . appendTagName ( c ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
if ( r . matches ( '/' ) ) {
t . createTempBuffer () ;
t . advanceTransition ( RCDATAEndTagOpen ) ;
} else if ( r . matchesLetter () && t . appropriateEndTagName () != null && ! r . containsIgnoreCase ( lr_1 + t . appropriateEndTagName () ) ) {
t . tagPending = t . createTagPending ( false ) . name ( t . appropriateEndTagName () ) ;
t . emitTagPending () ;
r . unconsume () ;
t . transition ( Data ) ;
} else {
t . emit ( lr_2 ) ;
t . transition ( Rcdata ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
if ( r . matchesLetter () ) {
t . createTagPending ( false ) ;
t . tagPending . appendTagName ( r . current () ) ;
t . dataBuffer . append ( r . current () ) ;
t . advanceTransition ( RCDATAEndTagName ) ;
} else {
t . emit ( lr_1 ) ;
t . transition ( Rcdata ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
if ( r . matchesLetter () ) {
String name = r . consumeLetterSequence () ;
t . tagPending . appendTagName ( name ) ;
t . dataBuffer . append ( name ) ;
return;
}
char c = r . consume () ;
switch ( c ) {
case '\t' :
case '\n' :
case '\r' :
case '\f' :
case ' ' :
if ( t . isAppropriateEndTagToken () )
t . transition ( BeforeAttributeName ) ;
else
anythingElse ( t , r ) ;
break;
case '/' :
if ( t . isAppropriateEndTagToken () )
t . transition ( SelfClosingStartTag ) ;
else
anythingElse ( t , r ) ;
break;
case '>' :
if ( t . isAppropriateEndTagToken () ) {
t . emitTagPending () ;
t . transition ( Data ) ;
}
else
anythingElse ( t , r ) ;
break;
default:
anythingElse ( t , r ) ;
}
}
private void anythingElse ( Tokeniser t , CharacterReader r ) {
t . emit ( lr_1 + t . dataBuffer . toString () ) ;
r . unconsume () ;
t . transition ( Rcdata ) ;
}
void read ( Tokeniser t , CharacterReader r ) {
if ( r . matches ( '/' ) ) {
t . createTempBuffer () ;
t . advanceTransition ( RawtextEndTagOpen ) ;
} else {
t . emit ( '<' ) ;
t . transition ( Rawtext ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
readEndTag ( t , r , RawtextEndTagName , Rawtext ) ;
}
void read ( Tokeniser t , CharacterReader r ) {
handleDataEndTag ( t , r , Rawtext ) ;
}
void read ( Tokeniser t , CharacterReader r ) {
switch ( r . consume () ) {
case '/' :
t . createTempBuffer () ;
t . transition ( ScriptDataEndTagOpen ) ;
break;
case '!' :
t . emit ( lr_3 ) ;
t . transition ( ScriptDataEscapeStart ) ;
break;
case eof :
t . emit ( lr_2 ) ;
t . eofError ( this ) ;
t . transition ( Data ) ;
break;
default:
t . emit ( lr_2 ) ;
r . unconsume () ;
t . transition ( ScriptData ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
readEndTag ( t , r , ScriptDataEndTagName , ScriptData ) ;
}
void read ( Tokeniser t , CharacterReader r ) {
handleDataEndTag ( t , r , ScriptData ) ;
}
void read ( Tokeniser t , CharacterReader r ) {
if ( r . matches ( '-' ) ) {
t . emit ( '-' ) ;
t . advanceTransition ( ScriptDataEscapeStartDash ) ;
} else {
t . transition ( ScriptData ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
if ( r . matches ( '-' ) ) {
t . emit ( '-' ) ;
t . advanceTransition ( ScriptDataEscapedDashDash ) ;
} else {
t . transition ( ScriptData ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
if ( r . isEmpty () ) {
t . eofError ( this ) ;
t . transition ( Data ) ;
return;
}
switch ( r . current () ) {
case '-' :
t . emit ( '-' ) ;
t . advanceTransition ( ScriptDataEscapedDash ) ;
break;
case '<' :
t . advanceTransition ( ScriptDataEscapedLessthanSign ) ;
break;
case nullChar :
t . error ( this ) ;
r . advance () ;
t . emit ( replacementChar ) ;
break;
default:
String data = r . consumeToAny ( '-' , '<' , nullChar ) ;
t . emit ( data ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
if ( r . isEmpty () ) {
t . eofError ( this ) ;
t . transition ( Data ) ;
return;
}
char c = r . consume () ;
switch ( c ) {
case '-' :
t . emit ( c ) ;
t . transition ( ScriptDataEscapedDashDash ) ;
break;
case '<' :
t . transition ( ScriptDataEscapedLessthanSign ) ;
break;
case nullChar :
t . error ( this ) ;
t . emit ( replacementChar ) ;
t . transition ( ScriptDataEscaped ) ;
break;
default:
t . emit ( c ) ;
t . transition ( ScriptDataEscaped ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
if ( r . isEmpty () ) {
t . eofError ( this ) ;
t . transition ( Data ) ;
return;
}
char c = r . consume () ;
switch ( c ) {
case '-' :
t . emit ( c ) ;
break;
case '<' :
t . transition ( ScriptDataEscapedLessthanSign ) ;
break;
case '>' :
t . emit ( c ) ;
t . transition ( ScriptData ) ;
break;
case nullChar :
t . error ( this ) ;
t . emit ( replacementChar ) ;
t . transition ( ScriptDataEscaped ) ;
break;
default:
t . emit ( c ) ;
t . transition ( ScriptDataEscaped ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
if ( r . matchesLetter () ) {
t . createTempBuffer () ;
t . dataBuffer . append ( r . current () ) ;
t . emit ( lr_2 + r . current () ) ;
t . advanceTransition ( ScriptDataDoubleEscapeStart ) ;
} else if ( r . matches ( '/' ) ) {
t . createTempBuffer () ;
t . advanceTransition ( ScriptDataEscapedEndTagOpen ) ;
} else {
t . emit ( '<' ) ;
t . transition ( ScriptDataEscaped ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
if ( r . matchesLetter () ) {
t . createTagPending ( false ) ;
t . tagPending . appendTagName ( r . current () ) ;
t . dataBuffer . append ( r . current () ) ;
t . advanceTransition ( ScriptDataEscapedEndTagName ) ;
} else {
t . emit ( lr_1 ) ;
t . transition ( ScriptDataEscaped ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
handleDataEndTag ( t , r , ScriptDataEscaped ) ;
}
void read ( Tokeniser t , CharacterReader r ) {
handleDataDoubleEscapeTag ( t , r , ScriptDataDoubleEscaped , ScriptDataEscaped ) ;
}
void read ( Tokeniser t , CharacterReader r ) {
char c = r . current () ;
switch ( c ) {
case '-' :
t . emit ( c ) ;
t . advanceTransition ( ScriptDataDoubleEscapedDash ) ;
break;
case '<' :
t . emit ( c ) ;
t . advanceTransition ( ScriptDataDoubleEscapedLessthanSign ) ;
break;
case nullChar :
t . error ( this ) ;
r . advance () ;
t . emit ( replacementChar ) ;
break;
case eof :
t . eofError ( this ) ;
t . transition ( Data ) ;
break;
default:
String data = r . consumeToAny ( '-' , '<' , nullChar ) ;
t . emit ( data ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
char c = r . consume () ;
switch ( c ) {
case '-' :
t . emit ( c ) ;
t . transition ( ScriptDataDoubleEscapedDashDash ) ;
break;
case '<' :
t . emit ( c ) ;
t . transition ( ScriptDataDoubleEscapedLessthanSign ) ;
break;
case nullChar :
t . error ( this ) ;
t . emit ( replacementChar ) ;
t . transition ( ScriptDataDoubleEscaped ) ;
break;
case eof :
t . eofError ( this ) ;
t . transition ( Data ) ;
break;
default:
t . emit ( c ) ;
t . transition ( ScriptDataDoubleEscaped ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
char c = r . consume () ;
switch ( c ) {
case '-' :
t . emit ( c ) ;
break;
case '<' :
t . emit ( c ) ;
t . transition ( ScriptDataDoubleEscapedLessthanSign ) ;
break;
case '>' :
t . emit ( c ) ;
t . transition ( ScriptData ) ;
break;
case nullChar :
t . error ( this ) ;
t . emit ( replacementChar ) ;
t . transition ( ScriptDataDoubleEscaped ) ;
break;
case eof :
t . eofError ( this ) ;
t . transition ( Data ) ;
break;
default:
t . emit ( c ) ;
t . transition ( ScriptDataDoubleEscaped ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
if ( r . matches ( '/' ) ) {
t . emit ( '/' ) ;
t . createTempBuffer () ;
t . advanceTransition ( ScriptDataDoubleEscapeEnd ) ;
} else {
t . transition ( ScriptDataDoubleEscaped ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
handleDataDoubleEscapeTag ( t , r , ScriptDataEscaped , ScriptDataDoubleEscaped ) ;
}
void read ( Tokeniser t , CharacterReader r ) {
char c = r . consume () ;
switch ( c ) {
case '\t' :
case '\n' :
case '\r' :
case '\f' :
case ' ' :
break;
case '/' :
t . transition ( SelfClosingStartTag ) ;
break;
case '<' :
r . unconsume () ;
t . error ( this ) ;
case '>' :
t . emitTagPending () ;
t . transition ( Data ) ;
break;
case nullChar :
r . unconsume () ;
t . error ( this ) ;
t . tagPending . newAttribute () ;
t . transition ( AttributeName ) ;
break;
case eof :
t . eofError ( this ) ;
t . transition ( Data ) ;
break;
case '"' :
case '\'' :
case '=' :
t . error ( this ) ;
t . tagPending . newAttribute () ;
t . tagPending . appendAttributeName ( c ) ;
t . transition ( AttributeName ) ;
break;
default:
t . tagPending . newAttribute () ;
r . unconsume () ;
t . transition ( AttributeName ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
String name = r . consumeToAnySorted ( attributeNameCharsSorted ) ;
t . tagPending . appendAttributeName ( name ) ;
char c = r . consume () ;
switch ( c ) {
case '\t' :
case '\n' :
case '\r' :
case '\f' :
case ' ' :
t . transition ( AfterAttributeName ) ;
break;
case '/' :
t . transition ( SelfClosingStartTag ) ;
break;
case '=' :
t . transition ( BeforeAttributeValue ) ;
break;
case '>' :
t . emitTagPending () ;
t . transition ( Data ) ;
break;
case nullChar :
t . error ( this ) ;
t . tagPending . appendAttributeName ( replacementChar ) ;
break;
case eof :
t . eofError ( this ) ;
t . transition ( Data ) ;
break;
case '"' :
case '\'' :
case '<' :
t . error ( this ) ;
t . tagPending . appendAttributeName ( c ) ;
break;
default:
t . tagPending . appendAttributeName ( c ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
char c = r . consume () ;
switch ( c ) {
case '\t' :
case '\n' :
case '\r' :
case '\f' :
case ' ' :
break;
case '/' :
t . transition ( SelfClosingStartTag ) ;
break;
case '=' :
t . transition ( BeforeAttributeValue ) ;
break;
case '>' :
t . emitTagPending () ;
t . transition ( Data ) ;
break;
case nullChar :
t . error ( this ) ;
t . tagPending . appendAttributeName ( replacementChar ) ;
t . transition ( AttributeName ) ;
break;
case eof :
t . eofError ( this ) ;
t . transition ( Data ) ;
break;
case '"' :
case '\'' :
case '<' :
t . error ( this ) ;
t . tagPending . newAttribute () ;
t . tagPending . appendAttributeName ( c ) ;
t . transition ( AttributeName ) ;
break;
default:
t . tagPending . newAttribute () ;
r . unconsume () ;
t . transition ( AttributeName ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
char c = r . consume () ;
switch ( c ) {
case '\t' :
case '\n' :
case '\r' :
case '\f' :
case ' ' :
break;
case '"' :
t . transition ( AttributeValue_doubleQuoted ) ;
break;
case '&' :
r . unconsume () ;
t . transition ( AttributeValue_unquoted ) ;
break;
case '\'' :
t . transition ( AttributeValue_singleQuoted ) ;
break;
case nullChar :
t . error ( this ) ;
t . tagPending . appendAttributeValue ( replacementChar ) ;
t . transition ( AttributeValue_unquoted ) ;
break;
case eof :
t . eofError ( this ) ;
t . emitTagPending () ;
t . transition ( Data ) ;
break;
case '>' :
t . error ( this ) ;
t . emitTagPending () ;
t . transition ( Data ) ;
break;
case '<' :
case '=' :
case '`' :
t . error ( this ) ;
t . tagPending . appendAttributeValue ( c ) ;
t . transition ( AttributeValue_unquoted ) ;
break;
default:
r . unconsume () ;
t . transition ( AttributeValue_unquoted ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
String value = r . consumeToAnySorted ( attributeDoubleValueCharsSorted ) ;
if ( value . length () > 0 )
t . tagPending . appendAttributeValue ( value ) ;
else
t . tagPending . setEmptyAttributeValue () ;
char c = r . consume () ;
switch ( c ) {
case '"' :
t . transition ( AfterAttributeValue_quoted ) ;
break;
case '&' :
int [] ref = t . consumeCharacterReference ( '"' , true ) ;
if ( ref != null )
t . tagPending . appendAttributeValue ( ref ) ;
else
t . tagPending . appendAttributeValue ( '&' ) ;
break;
case nullChar :
t . error ( this ) ;
t . tagPending . appendAttributeValue ( replacementChar ) ;
break;
case eof :
t . eofError ( this ) ;
t . transition ( Data ) ;
break;
default:
t . tagPending . appendAttributeValue ( c ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
String value = r . consumeToAnySorted ( attributeSingleValueCharsSorted ) ;
if ( value . length () > 0 )
t . tagPending . appendAttributeValue ( value ) ;
else
t . tagPending . setEmptyAttributeValue () ;
char c = r . consume () ;
switch ( c ) {
case '\'' :
t . transition ( AfterAttributeValue_quoted ) ;
break;
case '&' :
int [] ref = t . consumeCharacterReference ( '\'' , true ) ;
if ( ref != null )
t . tagPending . appendAttributeValue ( ref ) ;
else
t . tagPending . appendAttributeValue ( '&' ) ;
break;
case nullChar :
t . error ( this ) ;
t . tagPending . appendAttributeValue ( replacementChar ) ;
break;
case eof :
t . eofError ( this ) ;
t . transition ( Data ) ;
break;
default:
t . tagPending . appendAttributeValue ( c ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
String value = r . consumeToAnySorted ( attributeValueUnquoted ) ;
if ( value . length () > 0 )
t . tagPending . appendAttributeValue ( value ) ;
char c = r . consume () ;
switch ( c ) {
case '\t' :
case '\n' :
case '\r' :
case '\f' :
case ' ' :
t . transition ( BeforeAttributeName ) ;
break;
case '&' :
int [] ref = t . consumeCharacterReference ( '>' , true ) ;
if ( ref != null )
t . tagPending . appendAttributeValue ( ref ) ;
else
t . tagPending . appendAttributeValue ( '&' ) ;
break;
case '>' :
t . emitTagPending () ;
t . transition ( Data ) ;
break;
case nullChar :
t . error ( this ) ;
t . tagPending . appendAttributeValue ( replacementChar ) ;
break;
case eof :
t . eofError ( this ) ;
t . transition ( Data ) ;
break;
case '"' :
case '\'' :
case '<' :
case '=' :
case '`' :
t . error ( this ) ;
t . tagPending . appendAttributeValue ( c ) ;
break;
default:
t . tagPending . appendAttributeValue ( c ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
char c = r . consume () ;
switch ( c ) {
case '\t' :
case '\n' :
case '\r' :
case '\f' :
case ' ' :
t . transition ( BeforeAttributeName ) ;
break;
case '/' :
t . transition ( SelfClosingStartTag ) ;
break;
case '>' :
t . emitTagPending () ;
t . transition ( Data ) ;
break;
case eof :
t . eofError ( this ) ;
t . transition ( Data ) ;
break;
default:
r . unconsume () ;
t . error ( this ) ;
t . transition ( BeforeAttributeName ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
char c = r . consume () ;
switch ( c ) {
case '>' :
t . tagPending . selfClosing = true ;
t . emitTagPending () ;
t . transition ( Data ) ;
break;
case eof :
t . eofError ( this ) ;
t . transition ( Data ) ;
break;
default:
r . unconsume () ;
t . error ( this ) ;
t . transition ( BeforeAttributeName ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
r . unconsume () ;
t . commentPending . data . append ( r . consumeTo ( '>' ) ) ;
char next = r . consume () ;
if ( next == '>' || next == eof ) {
t . emitCommentPending () ;
t . transition ( Data ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
if ( r . matchConsume ( lr_4 ) ) {
t . createCommentPending () ;
t . transition ( CommentStart ) ;
} else if ( r . matchConsumeIgnoreCase ( lr_5 ) ) {
t . transition ( Doctype ) ;
} else if ( r . matchConsume ( lr_6 ) ) {
t . createTempBuffer () ;
t . transition ( CdataSection ) ;
} else {
t . error ( this ) ;
t . createBogusCommentPending () ;
t . advanceTransition ( BogusComment ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
char c = r . consume () ;
switch ( c ) {
case '-' :
t . transition ( CommentStartDash ) ;
break;
case nullChar :
t . error ( this ) ;
t . commentPending . data . append ( replacementChar ) ;
t . transition ( Comment ) ;
break;
case '>' :
t . error ( this ) ;
t . emitCommentPending () ;
t . transition ( Data ) ;
break;
case eof :
t . eofError ( this ) ;
t . emitCommentPending () ;
t . transition ( Data ) ;
break;
default:
t . commentPending . data . append ( c ) ;
t . transition ( Comment ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
char c = r . consume () ;
switch ( c ) {
case '-' :
t . transition ( CommentStartDash ) ;
break;
case nullChar :
t . error ( this ) ;
t . commentPending . data . append ( replacementChar ) ;
t . transition ( Comment ) ;
break;
case '>' :
t . error ( this ) ;
t . emitCommentPending () ;
t . transition ( Data ) ;
break;
case eof :
t . eofError ( this ) ;
t . emitCommentPending () ;
t . transition ( Data ) ;
break;
default:
t . commentPending . data . append ( c ) ;
t . transition ( Comment ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
char c = r . current () ;
switch ( c ) {
case '-' :
t . advanceTransition ( CommentEndDash ) ;
break;
case nullChar :
t . error ( this ) ;
r . advance () ;
t . commentPending . data . append ( replacementChar ) ;
break;
case eof :
t . eofError ( this ) ;
t . emitCommentPending () ;
t . transition ( Data ) ;
break;
default:
t . commentPending . data . append ( r . consumeToAny ( '-' , nullChar ) ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
char c = r . consume () ;
switch ( c ) {
case '-' :
t . transition ( CommentEnd ) ;
break;
case nullChar :
t . error ( this ) ;
t . commentPending . data . append ( '-' ) . append ( replacementChar ) ;
t . transition ( Comment ) ;
break;
case eof :
t . eofError ( this ) ;
t . emitCommentPending () ;
t . transition ( Data ) ;
break;
default:
t . commentPending . data . append ( '-' ) . append ( c ) ;
t . transition ( Comment ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
char c = r . consume () ;
switch ( c ) {
case '>' :
t . emitCommentPending () ;
t . transition ( Data ) ;
break;
case nullChar :
t . error ( this ) ;
t . commentPending . data . append ( lr_4 ) . append ( replacementChar ) ;
t . transition ( Comment ) ;
break;
case '!' :
t . error ( this ) ;
t . transition ( CommentEndBang ) ;
break;
case '-' :
t . error ( this ) ;
t . commentPending . data . append ( '-' ) ;
break;
case eof :
t . eofError ( this ) ;
t . emitCommentPending () ;
t . transition ( Data ) ;
break;
default:
t . error ( this ) ;
t . commentPending . data . append ( lr_4 ) . append ( c ) ;
t . transition ( Comment ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
char c = r . consume () ;
switch ( c ) {
case '-' :
t . commentPending . data . append ( lr_7 ) ;
t . transition ( CommentEndDash ) ;
break;
case '>' :
t . emitCommentPending () ;
t . transition ( Data ) ;
break;
case nullChar :
t . error ( this ) ;
t . commentPending . data . append ( lr_7 ) . append ( replacementChar ) ;
t . transition ( Comment ) ;
break;
case eof :
t . eofError ( this ) ;
t . emitCommentPending () ;
t . transition ( Data ) ;
break;
default:
t . commentPending . data . append ( lr_7 ) . append ( c ) ;
t . transition ( Comment ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
char c = r . consume () ;
switch ( c ) {
case '\t' :
case '\n' :
case '\r' :
case '\f' :
case ' ' :
t . transition ( BeforeDoctypeName ) ;
break;
case eof :
t . eofError ( this ) ;
case '>' :
t . error ( this ) ;
t . createDoctypePending () ;
t . doctypePending . forceQuirks = true ;
t . emitDoctypePending () ;
t . transition ( Data ) ;
break;
default:
t . error ( this ) ;
t . transition ( BeforeDoctypeName ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
if ( r . matchesLetter () ) {
t . createDoctypePending () ;
t . transition ( DoctypeName ) ;
return;
}
char c = r . consume () ;
switch ( c ) {
case '\t' :
case '\n' :
case '\r' :
case '\f' :
case ' ' :
break;
case nullChar :
t . error ( this ) ;
t . createDoctypePending () ;
t . doctypePending . name . append ( replacementChar ) ;
t . transition ( DoctypeName ) ;
break;
case eof :
t . eofError ( this ) ;
t . createDoctypePending () ;
t . doctypePending . forceQuirks = true ;
t . emitDoctypePending () ;
t . transition ( Data ) ;
break;
default:
t . createDoctypePending () ;
t . doctypePending . name . append ( c ) ;
t . transition ( DoctypeName ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
if ( r . matchesLetter () ) {
String name = r . consumeLetterSequence () ;
t . doctypePending . name . append ( name ) ;
return;
}
char c = r . consume () ;
switch ( c ) {
case '>' :
t . emitDoctypePending () ;
t . transition ( Data ) ;
break;
case '\t' :
case '\n' :
case '\r' :
case '\f' :
case ' ' :
t . transition ( AfterDoctypeName ) ;
break;
case nullChar :
t . error ( this ) ;
t . doctypePending . name . append ( replacementChar ) ;
break;
case eof :
t . eofError ( this ) ;
t . doctypePending . forceQuirks = true ;
t . emitDoctypePending () ;
t . transition ( Data ) ;
break;
default:
t . doctypePending . name . append ( c ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
if ( r . isEmpty () ) {
t . eofError ( this ) ;
t . doctypePending . forceQuirks = true ;
t . emitDoctypePending () ;
t . transition ( Data ) ;
return;
}
if ( r . matchesAny ( '\t' , '\n' , '\r' , '\f' , ' ' ) )
r . advance () ;
else if ( r . matches ( '>' ) ) {
t . emitDoctypePending () ;
t . advanceTransition ( Data ) ;
} else if ( r . matchConsumeIgnoreCase ( DocumentType . PUBLIC_KEY ) ) {
t . doctypePending . pubSysKey = DocumentType . PUBLIC_KEY ;
t . transition ( AfterDoctypePublicKeyword ) ;
} else if ( r . matchConsumeIgnoreCase ( DocumentType . SYSTEM_KEY ) ) {
t . doctypePending . pubSysKey = DocumentType . SYSTEM_KEY ;
t . transition ( AfterDoctypeSystemKeyword ) ;
} else {
t . error ( this ) ;
t . doctypePending . forceQuirks = true ;
t . advanceTransition ( BogusDoctype ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
char c = r . consume () ;
switch ( c ) {
case '\t' :
case '\n' :
case '\r' :
case '\f' :
case ' ' :
t . transition ( BeforeDoctypePublicIdentifier ) ;
break;
case '"' :
t . error ( this ) ;
t . transition ( DoctypePublicIdentifier_doubleQuoted ) ;
break;
case '\'' :
t . error ( this ) ;
t . transition ( DoctypePublicIdentifier_singleQuoted ) ;
break;
case '>' :
t . error ( this ) ;
t . doctypePending . forceQuirks = true ;
t . emitDoctypePending () ;
t . transition ( Data ) ;
break;
case eof :
t . eofError ( this ) ;
t . doctypePending . forceQuirks = true ;
t . emitDoctypePending () ;
t . transition ( Data ) ;
break;
default:
t . error ( this ) ;
t . doctypePending . forceQuirks = true ;
t . transition ( BogusDoctype ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
char c = r . consume () ;
switch ( c ) {
case '\t' :
case '\n' :
case '\r' :
case '\f' :
case ' ' :
break;
case '"' :
t . transition ( DoctypePublicIdentifier_doubleQuoted ) ;
break;
case '\'' :
t . transition ( DoctypePublicIdentifier_singleQuoted ) ;
break;
case '>' :
t . error ( this ) ;
t . doctypePending . forceQuirks = true ;
t . emitDoctypePending () ;
t . transition ( Data ) ;
break;
case eof :
t . eofError ( this ) ;
t . doctypePending . forceQuirks = true ;
t . emitDoctypePending () ;
t . transition ( Data ) ;
break;
default:
t . error ( this ) ;
t . doctypePending . forceQuirks = true ;
t . transition ( BogusDoctype ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
char c = r . consume () ;
switch ( c ) {
case '"' :
t . transition ( AfterDoctypePublicIdentifier ) ;
break;
case nullChar :
t . error ( this ) ;
t . doctypePending . publicIdentifier . append ( replacementChar ) ;
break;
case '>' :
t . error ( this ) ;
t . doctypePending . forceQuirks = true ;
t . emitDoctypePending () ;
t . transition ( Data ) ;
break;
case eof :
t . eofError ( this ) ;
t . doctypePending . forceQuirks = true ;
t . emitDoctypePending () ;
t . transition ( Data ) ;
break;
default:
t . doctypePending . publicIdentifier . append ( c ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
char c = r . consume () ;
switch ( c ) {
case '\'' :
t . transition ( AfterDoctypePublicIdentifier ) ;
break;
case nullChar :
t . error ( this ) ;
t . doctypePending . publicIdentifier . append ( replacementChar ) ;
break;
case '>' :
t . error ( this ) ;
t . doctypePending . forceQuirks = true ;
t . emitDoctypePending () ;
t . transition ( Data ) ;
break;
case eof :
t . eofError ( this ) ;
t . doctypePending . forceQuirks = true ;
t . emitDoctypePending () ;
t . transition ( Data ) ;
break;
default:
t . doctypePending . publicIdentifier . append ( c ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
char c = r . consume () ;
switch ( c ) {
case '\t' :
case '\n' :
case '\r' :
case '\f' :
case ' ' :
t . transition ( BetweenDoctypePublicAndSystemIdentifiers ) ;
break;
case '>' :
t . emitDoctypePending () ;
t . transition ( Data ) ;
break;
case '"' :
t . error ( this ) ;
t . transition ( DoctypeSystemIdentifier_doubleQuoted ) ;
break;
case '\'' :
t . error ( this ) ;
t . transition ( DoctypeSystemIdentifier_singleQuoted ) ;
break;
case eof :
t . eofError ( this ) ;
t . doctypePending . forceQuirks = true ;
t . emitDoctypePending () ;
t . transition ( Data ) ;
break;
default:
t . error ( this ) ;
t . doctypePending . forceQuirks = true ;
t . transition ( BogusDoctype ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
char c = r . consume () ;
switch ( c ) {
case '\t' :
case '\n' :
case '\r' :
case '\f' :
case ' ' :
break;
case '>' :
t . emitDoctypePending () ;
t . transition ( Data ) ;
break;
case '"' :
t . error ( this ) ;
t . transition ( DoctypeSystemIdentifier_doubleQuoted ) ;
break;
case '\'' :
t . error ( this ) ;
t . transition ( DoctypeSystemIdentifier_singleQuoted ) ;
break;
case eof :
t . eofError ( this ) ;
t . doctypePending . forceQuirks = true ;
t . emitDoctypePending () ;
t . transition ( Data ) ;
break;
default:
t . error ( this ) ;
t . doctypePending . forceQuirks = true ;
t . transition ( BogusDoctype ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
char c = r . consume () ;
switch ( c ) {
case '\t' :
case '\n' :
case '\r' :
case '\f' :
case ' ' :
t . transition ( BeforeDoctypeSystemIdentifier ) ;
break;
case '>' :
t . error ( this ) ;
t . doctypePending . forceQuirks = true ;
t . emitDoctypePending () ;
t . transition ( Data ) ;
break;
case '"' :
t . error ( this ) ;
t . transition ( DoctypeSystemIdentifier_doubleQuoted ) ;
break;
case '\'' :
t . error ( this ) ;
t . transition ( DoctypeSystemIdentifier_singleQuoted ) ;
break;
case eof :
t . eofError ( this ) ;
t . doctypePending . forceQuirks = true ;
t . emitDoctypePending () ;
t . transition ( Data ) ;
break;
default:
t . error ( this ) ;
t . doctypePending . forceQuirks = true ;
t . emitDoctypePending () ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
char c = r . consume () ;
switch ( c ) {
case '\t' :
case '\n' :
case '\r' :
case '\f' :
case ' ' :
break;
case '"' :
t . transition ( DoctypeSystemIdentifier_doubleQuoted ) ;
break;
case '\'' :
t . transition ( DoctypeSystemIdentifier_singleQuoted ) ;
break;
case '>' :
t . error ( this ) ;
t . doctypePending . forceQuirks = true ;
t . emitDoctypePending () ;
t . transition ( Data ) ;
break;
case eof :
t . eofError ( this ) ;
t . doctypePending . forceQuirks = true ;
t . emitDoctypePending () ;
t . transition ( Data ) ;
break;
default:
t . error ( this ) ;
t . doctypePending . forceQuirks = true ;
t . transition ( BogusDoctype ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
char c = r . consume () ;
switch ( c ) {
case '"' :
t . transition ( AfterDoctypeSystemIdentifier ) ;
break;
case nullChar :
t . error ( this ) ;
t . doctypePending . systemIdentifier . append ( replacementChar ) ;
break;
case '>' :
t . error ( this ) ;
t . doctypePending . forceQuirks = true ;
t . emitDoctypePending () ;
t . transition ( Data ) ;
break;
case eof :
t . eofError ( this ) ;
t . doctypePending . forceQuirks = true ;
t . emitDoctypePending () ;
t . transition ( Data ) ;
break;
default:
t . doctypePending . systemIdentifier . append ( c ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
char c = r . consume () ;
switch ( c ) {
case '\'' :
t . transition ( AfterDoctypeSystemIdentifier ) ;
break;
case nullChar :
t . error ( this ) ;
t . doctypePending . systemIdentifier . append ( replacementChar ) ;
break;
case '>' :
t . error ( this ) ;
t . doctypePending . forceQuirks = true ;
t . emitDoctypePending () ;
t . transition ( Data ) ;
break;
case eof :
t . eofError ( this ) ;
t . doctypePending . forceQuirks = true ;
t . emitDoctypePending () ;
t . transition ( Data ) ;
break;
default:
t . doctypePending . systemIdentifier . append ( c ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
char c = r . consume () ;
switch ( c ) {
case '\t' :
case '\n' :
case '\r' :
case '\f' :
case ' ' :
break;
case '>' :
t . emitDoctypePending () ;
t . transition ( Data ) ;
break;
case eof :
t . eofError ( this ) ;
t . doctypePending . forceQuirks = true ;
t . emitDoctypePending () ;
t . transition ( Data ) ;
break;
default:
t . error ( this ) ;
t . transition ( BogusDoctype ) ;
}
}
void read ( Tokeniser t , CharacterReader r ) {
char c = r . consume () ;
switch ( c ) {
case '>' :
t . emitDoctypePending () ;
t . transition ( Data ) ;
break;
case eof :
t . emitDoctypePending () ;
t . transition ( Data ) ;
break;
default:
break;
}
}
void read ( Tokeniser t , CharacterReader r ) {
String data = r . consumeTo ( lr_8 ) ;
t . dataBuffer . append ( data ) ;
if ( r . matchConsume ( lr_8 ) || r . isEmpty () ) {
t . emit ( new Token . CData ( t . dataBuffer . toString () ) ) ;
t . transition ( Data ) ;
}
}
private static void handleDataEndTag ( Tokeniser t , CharacterReader r , TokeniserState elseTransition ) {
if ( r . matchesLetter () ) {
String name = r . consumeLetterSequence () ;
t . tagPending . appendTagName ( name ) ;
t . dataBuffer . append ( name ) ;
return;
}
boolean needsExitTransition = false ;
if ( t . isAppropriateEndTagToken () && ! r . isEmpty () ) {
char c = r . consume () ;
switch ( c ) {
case '\t' :
case '\n' :
case '\r' :
case '\f' :
case ' ' :
t . transition ( BeforeAttributeName ) ;
break;
case '/' :
t . transition ( SelfClosingStartTag ) ;
break;
case '>' :
t . emitTagPending () ;
t . transition ( Data ) ;
break;
default:
t . dataBuffer . append ( c ) ;
needsExitTransition = true ;
}
} else {
needsExitTransition = true ;
}
if ( needsExitTransition ) {
t . emit ( lr_1 + t . dataBuffer . toString () ) ;
t . transition ( elseTransition ) ;
}
}
private static void readRawData ( Tokeniser t , CharacterReader r , TokeniserState current , TokeniserState advance ) {
switch ( r . current () ) {
case '<' :
t . advanceTransition ( advance ) ;
break;
case nullChar :
t . error ( current ) ;
r . advance () ;
t . emit ( replacementChar ) ;
break;
case eof :
t . emit ( new Token . EOF () ) ;
break;
default:
String data = r . consumeRawData () ;
t . emit ( data ) ;
break;
}
}
private static void readCharRef ( Tokeniser t , TokeniserState advance ) {
int [] c = t . consumeCharacterReference ( null , false ) ;
if ( c == null )
t . emit ( '&' ) ;
else
t . emit ( c ) ;
t . transition ( advance ) ;
}
private static void readEndTag ( Tokeniser t , CharacterReader r , TokeniserState a , TokeniserState b ) {
if ( r . matchesLetter () ) {
t . createTagPending ( false ) ;
t . transition ( a ) ;
} else {
t . emit ( lr_1 ) ;
t . transition ( b ) ;
}
}
private static void handleDataDoubleEscapeTag ( Tokeniser t , CharacterReader r , TokeniserState primary , TokeniserState fallback ) {
if ( r . matchesLetter () ) {
String name = r . consumeLetterSequence () ;
t . dataBuffer . append ( name ) ;
t . emit ( name ) ;
return;
}
char c = r . consume () ;
switch ( c ) {
case '\t' :
case '\n' :
case '\r' :
case '\f' :
case ' ' :
case '/' :
case '>' :
if ( t . dataBuffer . toString () . equals ( lr_9 ) )
t . transition ( primary ) ;
else
t . transition ( fallback ) ;
t . emit ( c ) ;
break;
default:
r . unconsume () ;
t . transition ( fallback ) ;
}
}

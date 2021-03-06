String tokenType () {
return this . getClass () . getSimpleName () ;
}
static void reset ( StringBuilder sb ) {
if ( sb != null ) {
sb . delete ( 0 , sb . length () ) ;
}
}
@Override
Token reset () {
reset ( name ) ;
pubSysKey = null ;
reset ( publicIdentifier ) ;
reset ( systemIdentifier ) ;
forceQuirks = false ;
return this ;
}
String getName () {
return name . toString () ;
}
String getPubSysKey () {
return pubSysKey ;
}
String getPublicIdentifier () {
return publicIdentifier . toString () ;
}
public String getSystemIdentifier () {
return systemIdentifier . toString () ;
}
public boolean isForceQuirks () {
return forceQuirks ;
}
@Override
Tag reset () {
tagName = null ;
normalName = null ;
pendingAttributeName = null ;
reset ( pendingAttributeValue ) ;
pendingAttributeValueS = null ;
hasEmptyAttributeValue = false ;
hasPendingAttributeValue = false ;
selfClosing = false ;
attributes = null ;
return this ;
}
final void newAttribute () {
if ( attributes == null )
attributes = new Attributes () ;
if ( pendingAttributeName != null ) {
pendingAttributeName = pendingAttributeName . trim () ;
if ( pendingAttributeName . length () > 0 ) {
String value ;
if ( hasPendingAttributeValue )
value = pendingAttributeValue . length () > 0 ? pendingAttributeValue . toString () : pendingAttributeValueS ;
else if ( hasEmptyAttributeValue )
value = lr_1 ;
else
value = null ;
attributes . add ( pendingAttributeName , value ) ;
}
}
pendingAttributeName = null ;
hasEmptyAttributeValue = false ;
hasPendingAttributeValue = false ;
reset ( pendingAttributeValue ) ;
pendingAttributeValueS = null ;
}
final void finaliseTag () {
if ( pendingAttributeName != null ) {
newAttribute () ;
}
}
final String name () {
Validate . isFalse ( tagName == null || tagName . length () == 0 ) ;
return tagName ;
}
final String normalName () {
return normalName ;
}
final Tag name ( String name ) {
tagName = name ;
normalName = lowerCase ( name ) ;
return this ;
}
final boolean isSelfClosing () {
return selfClosing ;
}
final Attributes getAttributes () {
if ( attributes == null )
attributes = new Attributes () ;
return attributes ;
}
final void appendTagName ( String append ) {
tagName = tagName == null ? append : tagName . concat ( append ) ;
normalName = lowerCase ( tagName ) ;
}
final void appendTagName ( char append ) {
appendTagName ( String . valueOf ( append ) ) ;
}
final void appendAttributeName ( String append ) {
pendingAttributeName = pendingAttributeName == null ? append : pendingAttributeName . concat ( append ) ;
}
final void appendAttributeName ( char append ) {
appendAttributeName ( String . valueOf ( append ) ) ;
}
final void appendAttributeValue ( String append ) {
ensureAttributeValue () ;
if ( pendingAttributeValue . length () == 0 ) {
pendingAttributeValueS = append ;
} else {
pendingAttributeValue . append ( append ) ;
}
}
final void appendAttributeValue ( char append ) {
ensureAttributeValue () ;
pendingAttributeValue . append ( append ) ;
}
final void appendAttributeValue ( char [] append ) {
ensureAttributeValue () ;
pendingAttributeValue . append ( append ) ;
}
final void appendAttributeValue ( int [] appendCodepoints ) {
ensureAttributeValue () ;
for ( int codepoint : appendCodepoints ) {
pendingAttributeValue . appendCodePoint ( codepoint ) ;
}
}
final void setEmptyAttributeValue () {
hasEmptyAttributeValue = true ;
}
private void ensureAttributeValue () {
hasPendingAttributeValue = true ;
if ( pendingAttributeValueS != null ) {
pendingAttributeValue . append ( pendingAttributeValueS ) ;
pendingAttributeValueS = null ;
}
}
@Override
Tag reset () {
super . reset () ;
attributes = null ;
return this ;
}
StartTag nameAttr ( String name , Attributes attributes ) {
this . tagName = name ;
this . attributes = attributes ;
normalName = lowerCase ( tagName ) ;
return this ;
}
@Override
public String toString () {
if ( attributes != null && attributes . size () > 0 )
return lr_2 + name () + lr_3 + attributes . toString () + lr_4 ;
else
return lr_2 + name () + lr_4 ;
}
@Override
public String toString () {
return lr_5 + name () + lr_4 ;
}
@Override
Token reset () {
reset ( data ) ;
bogus = false ;
return this ;
}
String getData () {
return data . toString () ;
}
@Override
public String toString () {
return lr_6 + getData () + lr_7 ;
}
@Override
Token reset () {
data = null ;
return this ;
}
Character data ( String data ) {
this . data = data ;
return this ;
}
String getData () {
return data ;
}
@Override
public String toString () {
return getData () ;
}
@Override
public String toString () {
return lr_8 + getData () + lr_9 ;
}
@Override
Token reset () {
return this ;
}
final boolean isDoctype () {
return type == TokenType . Doctype ;
}
final Doctype asDoctype () {
return ( Doctype ) this ;
}
final boolean isStartTag () {
return type == TokenType . StartTag ;
}
final StartTag asStartTag () {
return ( StartTag ) this ;
}
final boolean isEndTag () {
return type == TokenType . EndTag ;
}
final EndTag asEndTag () {
return ( EndTag ) this ;
}
final boolean isComment () {
return type == TokenType . Comment ;
}
final Comment asComment () {
return ( Comment ) this ;
}
final boolean isCharacter () {
return type == TokenType . Character ;
}
final boolean isCData () {
return this instanceof CData ;
}
final Character asCharacter () {
return ( Character ) this ;
}
final boolean isEOF () {
return type == TokenType . EOF ;
}

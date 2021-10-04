boolean process ( Token t , HtmlTreeBuilder tb ) {
if ( isWhitespace ( t ) ) {
return true ;
} else if ( t . isComment () ) {
tb . insert ( t . asComment () ) ;
} else if ( t . isDoctype () ) {
Token . Doctype d = t . asDoctype () ;
DocumentType doctype = new DocumentType (
tb . settings . normalizeTag ( d . getName () ) , d . getPublicIdentifier () , d . getSystemIdentifier () ) ;
doctype . setPubSysKey ( d . getPubSysKey () ) ;
tb . getDocument () . appendChild ( doctype ) ;
if ( d . isForceQuirks () )
tb . getDocument () . quirksMode ( Document . QuirksMode . quirks ) ;
tb . transition ( BeforeHtml ) ;
} else {
tb . transition ( BeforeHtml ) ;
return tb . process ( t ) ;
}
return true ;
}
boolean process ( Token t , HtmlTreeBuilder tb ) {
if ( t . isDoctype () ) {
tb . error ( this ) ;
return false ;
} else if ( t . isComment () ) {
tb . insert ( t . asComment () ) ;
} else if ( isWhitespace ( t ) ) {
return true ;
} else if ( t . isStartTag () && t . asStartTag () . normalName () . equals ( lr_1 ) ) {
tb . insert ( t . asStartTag () ) ;
tb . transition ( BeforeHead ) ;
} else if ( t . isEndTag () && ( StringUtil . in ( t . asEndTag () . normalName () , lr_2 , lr_3 , lr_1 , lr_4 ) ) ) {
return anythingElse ( t , tb ) ;
} else if ( t . isEndTag () ) {
tb . error ( this ) ;
return false ;
} else {
return anythingElse ( t , tb ) ;
}
return true ;
}
private boolean anythingElse ( Token t , HtmlTreeBuilder tb ) {
tb . insertStartTag ( lr_1 ) ;
tb . transition ( BeforeHead ) ;
return tb . process ( t ) ;
}
boolean process ( Token t , HtmlTreeBuilder tb ) {
if ( isWhitespace ( t ) ) {
return true ;
} else if ( t . isComment () ) {
tb . insert ( t . asComment () ) ;
} else if ( t . isDoctype () ) {
tb . error ( this ) ;
return false ;
} else if ( t . isStartTag () && t . asStartTag () . normalName () . equals ( lr_1 ) ) {
return InBody . process ( t , tb ) ;
} else if ( t . isStartTag () && t . asStartTag () . normalName () . equals ( lr_2 ) ) {
Element head = tb . insert ( t . asStartTag () ) ;
tb . setHeadElement ( head ) ;
tb . transition ( InHead ) ;
} else if ( t . isEndTag () && ( StringUtil . in ( t . asEndTag () . normalName () , lr_2 , lr_3 , lr_1 , lr_4 ) ) ) {
tb . processStartTag ( lr_2 ) ;
return tb . process ( t ) ;
} else if ( t . isEndTag () ) {
tb . error ( this ) ;
return false ;
} else {
tb . processStartTag ( lr_2 ) ;
return tb . process ( t ) ;
}
return true ;
}
boolean process ( Token t , HtmlTreeBuilder tb ) {
if ( isWhitespace ( t ) ) {
tb . insert ( t . asCharacter () ) ;
return true ;
}
switch ( t . type ) {
case Comment :
tb . insert ( t . asComment () ) ;
break;
case Doctype :
tb . error ( this ) ;
return false ;
case StartTag :
Token . StartTag start = t . asStartTag () ;
String name = start . normalName () ;
if ( name . equals ( lr_1 ) ) {
return InBody . process ( t , tb ) ;
} else if ( StringUtil . in ( name , lr_5 , lr_6 , lr_7 , lr_8 , lr_9 ) ) {
Element el = tb . insertEmpty ( start ) ;
if ( name . equals ( lr_5 ) && el . hasAttr ( lr_10 ) )
tb . maybeSetBaseUri ( el ) ;
} else if ( name . equals ( lr_11 ) ) {
Element meta = tb . insertEmpty ( start ) ;
} else if ( name . equals ( lr_12 ) ) {
handleRcData ( start , tb ) ;
} else if ( StringUtil . in ( name , lr_13 , lr_14 ) ) {
handleRawtext ( start , tb ) ;
} else if ( name . equals ( lr_15 ) ) {
tb . insert ( start ) ;
tb . transition ( InHeadNoscript ) ;
} else if ( name . equals ( lr_16 ) ) {
tb . tokeniser . transition ( TokeniserState . ScriptData ) ;
tb . markInsertionMode () ;
tb . transition ( Text ) ;
tb . insert ( start ) ;
} else if ( name . equals ( lr_2 ) ) {
tb . error ( this ) ;
return false ;
} else {
return anythingElse ( t , tb ) ;
}
break;
case EndTag :
Token . EndTag end = t . asEndTag () ;
name = end . normalName () ;
if ( name . equals ( lr_2 ) ) {
tb . pop () ;
tb . transition ( AfterHead ) ;
} else if ( StringUtil . in ( name , lr_3 , lr_1 , lr_4 ) ) {
return anythingElse ( t , tb ) ;
} else {
tb . error ( this ) ;
return false ;
}
break;
default:
return anythingElse ( t , tb ) ;
}
return true ;
}
private boolean anythingElse ( Token t , TreeBuilder tb ) {
tb . processEndTag ( lr_2 ) ;
return tb . process ( t ) ;
}
boolean process ( Token t , HtmlTreeBuilder tb ) {
if ( t . isDoctype () ) {
tb . error ( this ) ;
} else if ( t . isStartTag () && t . asStartTag () . normalName () . equals ( lr_1 ) ) {
return tb . process ( t , InBody ) ;
} else if ( t . isEndTag () && t . asEndTag () . normalName () . equals ( lr_15 ) ) {
tb . pop () ;
tb . transition ( InHead ) ;
} else if ( isWhitespace ( t ) || t . isComment () || ( t . isStartTag () && StringUtil . in ( t . asStartTag () . normalName () ,
lr_6 , lr_7 , lr_9 , lr_11 , lr_13 , lr_14 ) ) ) {
return tb . process ( t , InHead ) ;
} else if ( t . isEndTag () && t . asEndTag () . normalName () . equals ( lr_4 ) ) {
return anythingElse ( t , tb ) ;
} else if ( ( t . isStartTag () && StringUtil . in ( t . asStartTag () . normalName () , lr_2 , lr_15 ) ) || t . isEndTag () ) {
tb . error ( this ) ;
return false ;
} else {
return anythingElse ( t , tb ) ;
}
return true ;
}
private boolean anythingElse ( Token t , HtmlTreeBuilder tb ) {
tb . error ( this ) ;
tb . insert ( new Token . Character () . data ( t . toString () ) ) ;
return true ;
}
boolean process ( Token t , HtmlTreeBuilder tb ) {
if ( isWhitespace ( t ) ) {
tb . insert ( t . asCharacter () ) ;
} else if ( t . isComment () ) {
tb . insert ( t . asComment () ) ;
} else if ( t . isDoctype () ) {
tb . error ( this ) ;
} else if ( t . isStartTag () ) {
Token . StartTag startTag = t . asStartTag () ;
String name = startTag . normalName () ;
if ( name . equals ( lr_1 ) ) {
return tb . process ( t , InBody ) ;
} else if ( name . equals ( lr_3 ) ) {
tb . insert ( startTag ) ;
tb . framesetOk ( false ) ;
tb . transition ( InBody ) ;
} else if ( name . equals ( lr_17 ) ) {
tb . insert ( startTag ) ;
tb . transition ( InFrameset ) ;
} else if ( StringUtil . in ( name , lr_5 , lr_6 , lr_7 , lr_9 , lr_11 , lr_13 , lr_16 , lr_14 , lr_12 ) ) {
tb . error ( this ) ;
Element head = tb . getHeadElement () ;
tb . push ( head ) ;
tb . process ( t , InHead ) ;
tb . removeFromStack ( head ) ;
} else if ( name . equals ( lr_2 ) ) {
tb . error ( this ) ;
return false ;
} else {
anythingElse ( t , tb ) ;
}
} else if ( t . isEndTag () ) {
if ( StringUtil . in ( t . asEndTag () . normalName () , lr_3 , lr_1 ) ) {
anythingElse ( t , tb ) ;
} else {
tb . error ( this ) ;
return false ;
}
} else {
anythingElse ( t , tb ) ;
}
return true ;
}
private boolean anythingElse ( Token t , HtmlTreeBuilder tb ) {
tb . processStartTag ( lr_3 ) ;
tb . framesetOk ( true ) ;
return tb . process ( t ) ;
}
boolean process ( Token t , HtmlTreeBuilder tb ) {
switch ( t . type ) {
case Character : {
Token . Character c = t . asCharacter () ;
if ( c . getData () . equals ( nullString ) ) {
tb . error ( this ) ;
return false ;
} else if ( tb . framesetOk () && isWhitespace ( c ) ) {
tb . reconstructFormattingElements () ;
tb . insert ( c ) ;
} else {
tb . reconstructFormattingElements () ;
tb . insert ( c ) ;
tb . framesetOk ( false ) ;
}
break;
}
case Comment : {
tb . insert ( t . asComment () ) ;
break;
}
case Doctype : {
tb . error ( this ) ;
return false ;
}
case StartTag :
Token . StartTag startTag = t . asStartTag () ;
String name = startTag . normalName () ;
if ( name . equals ( lr_18 ) ) {
if ( tb . getActiveFormattingElement ( lr_18 ) != null ) {
tb . error ( this ) ;
tb . processEndTag ( lr_18 ) ;
Element remainingA = tb . getFromStack ( lr_18 ) ;
if ( remainingA != null ) {
tb . removeFromActiveFormattingElements ( remainingA ) ;
tb . removeFromStack ( remainingA ) ;
}
}
tb . reconstructFormattingElements () ;
Element a = tb . insert ( startTag ) ;
tb . pushActiveFormattingElements ( a ) ;
} else if ( StringUtil . inSorted ( name , Constants . InBodyStartEmptyFormatters ) ) {
tb . reconstructFormattingElements () ;
tb . insertEmpty ( startTag ) ;
tb . framesetOk ( false ) ;
} else if ( StringUtil . inSorted ( name , Constants . InBodyStartPClosers ) ) {
if ( tb . inButtonScope ( lr_19 ) ) {
tb . processEndTag ( lr_19 ) ;
}
tb . insert ( startTag ) ;
} else if ( name . equals ( lr_20 ) ) {
tb . reconstructFormattingElements () ;
tb . insert ( startTag ) ;
} else if ( name . equals ( lr_21 ) ) {
tb . framesetOk ( false ) ;
ArrayList < Element > stack = tb . getStack () ;
for ( int i = stack . size () - 1 ; i > 0 ; i -- ) {
Element el = stack . get ( i ) ;
if ( el . normalName () . equals ( lr_21 ) ) {
tb . processEndTag ( lr_21 ) ;
break;
}
if ( tb . isSpecial ( el ) && ! StringUtil . inSorted ( el . normalName () , Constants . InBodyStartLiBreakers ) )
break;
}
if ( tb . inButtonScope ( lr_19 ) ) {
tb . processEndTag ( lr_19 ) ;
}
tb . insert ( startTag ) ;
} else if ( name . equals ( lr_1 ) ) {
tb . error ( this ) ;
Element html = tb . getStack () . get ( 0 ) ;
for ( Attribute attribute : startTag . getAttributes () ) {
if ( ! html . hasAttr ( attribute . getKey () ) )
html . attributes () . put ( attribute ) ;
}
} else if ( StringUtil . inSorted ( name , Constants . InBodyStartToHead ) ) {
return tb . process ( t , InHead ) ;
} else if ( name . equals ( lr_3 ) ) {
tb . error ( this ) ;
ArrayList < Element > stack = tb . getStack () ;
if ( stack . size () == 1 || ( stack . size () > 2 && ! stack . get ( 1 ) . normalName () . equals ( lr_3 ) ) ) {
return false ;
} else {
tb . framesetOk ( false ) ;
Element body = stack . get ( 1 ) ;
for ( Attribute attribute : startTag . getAttributes () ) {
if ( ! body . hasAttr ( attribute . getKey () ) )
body . attributes () . put ( attribute ) ;
}
}
} else if ( name . equals ( lr_17 ) ) {
tb . error ( this ) ;
ArrayList < Element > stack = tb . getStack () ;
if ( stack . size () == 1 || ( stack . size () > 2 && ! stack . get ( 1 ) . normalName () . equals ( lr_3 ) ) ) {
return false ;
} else if ( ! tb . framesetOk () ) {
return false ;
} else {
Element second = stack . get ( 1 ) ;
if ( second . parent () != null )
second . remove () ;
while ( stack . size () > 1 )
stack . remove ( stack . size () - 1 ) ;
tb . insert ( startTag ) ;
tb . transition ( InFrameset ) ;
}
} else if ( StringUtil . inSorted ( name , Constants . Headings ) ) {
if ( tb . inButtonScope ( lr_19 ) ) {
tb . processEndTag ( lr_19 ) ;
}
if ( StringUtil . inSorted ( tb . currentElement () . normalName () , Constants . Headings ) ) {
tb . error ( this ) ;
tb . pop () ;
}
tb . insert ( startTag ) ;
} else if ( StringUtil . inSorted ( name , Constants . InBodyStartPreListing ) ) {
if ( tb . inButtonScope ( lr_19 ) ) {
tb . processEndTag ( lr_19 ) ;
}
tb . insert ( startTag ) ;
tb . reader . matchConsume ( lr_22 ) ;
tb . framesetOk ( false ) ;
} else if ( name . equals ( lr_23 ) ) {
if ( tb . getFormElement () != null ) {
tb . error ( this ) ;
return false ;
}
if ( tb . inButtonScope ( lr_19 ) ) {
tb . processEndTag ( lr_19 ) ;
}
tb . insertForm ( startTag , true ) ;
} else if ( StringUtil . inSorted ( name , Constants . DdDt ) ) {
tb . framesetOk ( false ) ;
ArrayList < Element > stack = tb . getStack () ;
for ( int i = stack . size () - 1 ; i > 0 ; i -- ) {
Element el = stack . get ( i ) ;
if ( StringUtil . inSorted ( el . normalName () , Constants . DdDt ) ) {
tb . processEndTag ( el . normalName () ) ;
break;
}
if ( tb . isSpecial ( el ) && ! StringUtil . inSorted ( el . normalName () , Constants . InBodyStartLiBreakers ) )
break;
}
if ( tb . inButtonScope ( lr_19 ) ) {
tb . processEndTag ( lr_19 ) ;
}
tb . insert ( startTag ) ;
} else if ( name . equals ( lr_24 ) ) {
if ( tb . inButtonScope ( lr_19 ) ) {
tb . processEndTag ( lr_19 ) ;
}
tb . insert ( startTag ) ;
tb . tokeniser . transition ( TokeniserState . PLAINTEXT ) ;
} else if ( name . equals ( lr_25 ) ) {
if ( tb . inButtonScope ( lr_25 ) ) {
tb . error ( this ) ;
tb . processEndTag ( lr_25 ) ;
tb . process ( startTag ) ;
} else {
tb . reconstructFormattingElements () ;
tb . insert ( startTag ) ;
tb . framesetOk ( false ) ;
}
} else if ( StringUtil . inSorted ( name , Constants . Formatters ) ) {
tb . reconstructFormattingElements () ;
Element el = tb . insert ( startTag ) ;
tb . pushActiveFormattingElements ( el ) ;
} else if ( name . equals ( lr_26 ) ) {
tb . reconstructFormattingElements () ;
if ( tb . inScope ( lr_26 ) ) {
tb . error ( this ) ;
tb . processEndTag ( lr_26 ) ;
tb . reconstructFormattingElements () ;
}
Element el = tb . insert ( startTag ) ;
tb . pushActiveFormattingElements ( el ) ;
} else if ( StringUtil . inSorted ( name , Constants . InBodyStartApplets ) ) {
tb . reconstructFormattingElements () ;
tb . insert ( startTag ) ;
tb . insertMarkerToFormattingElements () ;
tb . framesetOk ( false ) ;
} else if ( name . equals ( lr_27 ) ) {
if ( tb . getDocument () . quirksMode () != Document . QuirksMode . quirks && tb . inButtonScope ( lr_19 ) ) {
tb . processEndTag ( lr_19 ) ;
}
tb . insert ( startTag ) ;
tb . framesetOk ( false ) ;
tb . transition ( InTable ) ;
} else if ( name . equals ( lr_28 ) ) {
tb . reconstructFormattingElements () ;
Element el = tb . insertEmpty ( startTag ) ;
if ( ! el . attr ( lr_29 ) . equalsIgnoreCase ( lr_30 ) )
tb . framesetOk ( false ) ;
} else if ( StringUtil . inSorted ( name , Constants . InBodyStartMedia ) ) {
tb . insertEmpty ( startTag ) ;
} else if ( name . equals ( lr_31 ) ) {
if ( tb . inButtonScope ( lr_19 ) ) {
tb . processEndTag ( lr_19 ) ;
}
tb . insertEmpty ( startTag ) ;
tb . framesetOk ( false ) ;
} else if ( name . equals ( lr_32 ) ) {
if ( tb . getFromStack ( lr_33 ) == null )
return tb . process ( startTag . name ( lr_34 ) ) ;
else
tb . insert ( startTag ) ;
} else if ( name . equals ( lr_35 ) ) {
tb . error ( this ) ;
if ( tb . getFormElement () != null )
return false ;
tb . processStartTag ( lr_23 ) ;
if ( startTag . attributes . hasKey ( lr_36 ) ) {
Element form = tb . getFormElement () ;
form . attr ( lr_36 , startTag . attributes . get ( lr_36 ) ) ;
}
tb . processStartTag ( lr_31 ) ;
tb . processStartTag ( lr_37 ) ;
String prompt = startTag . attributes . hasKey ( lr_38 ) ?
startTag . attributes . get ( lr_38 ) :
lr_39 ;
tb . process ( new Token . Character () . data ( prompt ) ) ;
Attributes inputAttribs = new Attributes () ;
for ( Attribute attr : startTag . attributes ) {
if ( ! StringUtil . inSorted ( attr . getKey () , Constants . InBodyStartInputAttribs ) )
inputAttribs . put ( attr ) ;
}
inputAttribs . put ( lr_40 , lr_35 ) ;
tb . processStartTag ( lr_28 , inputAttribs ) ;
tb . processEndTag ( lr_37 ) ;
tb . processStartTag ( lr_31 ) ;
tb . processEndTag ( lr_23 ) ;
} else if ( name . equals ( lr_41 ) ) {
tb . insert ( startTag ) ;
if ( ! startTag . isSelfClosing () ) {
tb . tokeniser . transition ( TokeniserState . Rcdata ) ;
tb . markInsertionMode () ;
tb . framesetOk ( false ) ;
tb . transition ( Text ) ;
}
} else if ( name . equals ( lr_42 ) ) {
if ( tb . inButtonScope ( lr_19 ) ) {
tb . processEndTag ( lr_19 ) ;
}
tb . reconstructFormattingElements () ;
tb . framesetOk ( false ) ;
handleRawtext ( startTag , tb ) ;
} else if ( name . equals ( lr_43 ) ) {
tb . framesetOk ( false ) ;
handleRawtext ( startTag , tb ) ;
} else if ( name . equals ( lr_44 ) ) {
handleRawtext ( startTag , tb ) ;
} else if ( name . equals ( lr_45 ) ) {
tb . reconstructFormattingElements () ;
tb . insert ( startTag ) ;
tb . framesetOk ( false ) ;
HtmlTreeBuilderState state = tb . state () ;
if ( state . equals ( InTable ) || state . equals ( InCaption ) || state . equals ( InTableBody ) || state . equals ( InRow ) || state . equals ( InCell ) )
tb . transition ( InSelectInTable ) ;
else
tb . transition ( InSelect ) ;
} else if ( StringUtil . inSorted ( name , Constants . InBodyStartOptions ) ) {
if ( tb . currentElement () . normalName () . equals ( lr_46 ) )
tb . processEndTag ( lr_46 ) ;
tb . reconstructFormattingElements () ;
tb . insert ( startTag ) ;
} else if ( StringUtil . inSorted ( name , Constants . InBodyStartRuby ) ) {
if ( tb . inScope ( lr_47 ) ) {
tb . generateImpliedEndTags () ;
if ( ! tb . currentElement () . normalName () . equals ( lr_47 ) ) {
tb . error ( this ) ;
tb . popStackToBefore ( lr_47 ) ;
}
tb . insert ( startTag ) ;
}
} else if ( name . equals ( lr_48 ) ) {
tb . reconstructFormattingElements () ;
tb . insert ( startTag ) ;
} else if ( name . equals ( lr_33 ) ) {
tb . reconstructFormattingElements () ;
tb . insert ( startTag ) ;
} else if ( StringUtil . inSorted ( name , Constants . InBodyStartDrop ) ) {
tb . error ( this ) ;
return false ;
} else {
tb . reconstructFormattingElements () ;
tb . insert ( startTag ) ;
}
break;
case EndTag :
Token . EndTag endTag = t . asEndTag () ;
name = endTag . normalName () ;
if ( StringUtil . inSorted ( name , Constants . InBodyEndAdoptionFormatters ) ) {
for ( int i = 0 ; i < 8 ; i ++ ) {
Element formatEl = tb . getActiveFormattingElement ( name ) ;
if ( formatEl == null )
return anyOtherEndTag ( t , tb ) ;
else if ( ! tb . onStack ( formatEl ) ) {
tb . error ( this ) ;
tb . removeFromActiveFormattingElements ( formatEl ) ;
return true ;
} else if ( ! tb . inScope ( formatEl . normalName () ) ) {
tb . error ( this ) ;
return false ;
} else if ( tb . currentElement () != formatEl )
tb . error ( this ) ;
Element furthestBlock = null ;
Element commonAncestor = null ;
boolean seenFormattingElement = false ;
ArrayList < Element > stack = tb . getStack () ;
final int stackSize = stack . size () ;
for ( int si = 0 ; si < stackSize && si < 64 ; si ++ ) {
Element el = stack . get ( si ) ;
if ( el == formatEl ) {
commonAncestor = stack . get ( si - 1 ) ;
seenFormattingElement = true ;
} else if ( seenFormattingElement && tb . isSpecial ( el ) ) {
furthestBlock = el ;
break;
}
}
if ( furthestBlock == null ) {
tb . popStackToClose ( formatEl . normalName () ) ;
tb . removeFromActiveFormattingElements ( formatEl ) ;
return true ;
}
Element node = furthestBlock ;
Element lastNode = furthestBlock ;
for ( int j = 0 ; j < 3 ; j ++ ) {
if ( tb . onStack ( node ) )
node = tb . aboveOnStack ( node ) ;
if ( ! tb . isInActiveFormattingElements ( node ) ) {
tb . removeFromStack ( node ) ;
continue;
} else if ( node == formatEl )
break;
Element replacement = new Element ( Tag . valueOf ( node . nodeName () , ParseSettings . preserveCase ) , tb . getBaseUri () ) ;
tb . replaceActiveFormattingElement ( node , replacement ) ;
tb . replaceOnStack ( node , replacement ) ;
node = replacement ;
if ( lastNode == furthestBlock ) {
}
if ( lastNode . parent () != null )
lastNode . remove () ;
node . appendChild ( lastNode ) ;
lastNode = node ;
}
if ( StringUtil . inSorted ( commonAncestor . normalName () , Constants . InBodyEndTableFosters ) ) {
if ( lastNode . parent () != null )
lastNode . remove () ;
tb . insertInFosterParent ( lastNode ) ;
} else {
if ( lastNode . parent () != null )
lastNode . remove () ;
commonAncestor . appendChild ( lastNode ) ;
}
Element adopter = new Element ( formatEl . tag () , tb . getBaseUri () ) ;
adopter . attributes () . addAll ( formatEl . attributes () ) ;
Node [] childNodes = furthestBlock . childNodes () . toArray ( new Node [ 0 ] ) ;
for ( Node childNode : childNodes ) {
adopter . appendChild ( childNode ) ;
}
furthestBlock . appendChild ( adopter ) ;
tb . removeFromActiveFormattingElements ( formatEl ) ;
tb . removeFromStack ( formatEl ) ;
tb . insertOnStackAfter ( furthestBlock , adopter ) ;
}
} else if ( StringUtil . inSorted ( name , Constants . InBodyEndClosers ) ) {
if ( ! tb . inScope ( name ) ) {
tb . error ( this ) ;
return false ;
} else {
tb . generateImpliedEndTags () ;
if ( ! tb . currentElement () . normalName () . equals ( name ) )
tb . error ( this ) ;
tb . popStackToClose ( name ) ;
}
} else if ( name . equals ( lr_20 ) ) {
return anyOtherEndTag ( t , tb ) ;
} else if ( name . equals ( lr_21 ) ) {
if ( ! tb . inListItemScope ( name ) ) {
tb . error ( this ) ;
return false ;
} else {
tb . generateImpliedEndTags ( name ) ;
if ( ! tb . currentElement () . normalName () . equals ( name ) )
tb . error ( this ) ;
tb . popStackToClose ( name ) ;
}
} else if ( name . equals ( lr_3 ) ) {
if ( ! tb . inScope ( lr_3 ) ) {
tb . error ( this ) ;
return false ;
} else {
tb . transition ( AfterBody ) ;
}
} else if ( name . equals ( lr_1 ) ) {
boolean notIgnored = tb . processEndTag ( lr_3 ) ;
if ( notIgnored )
return tb . process ( endTag ) ;
} else if ( name . equals ( lr_23 ) ) {
Element currentForm = tb . getFormElement () ;
tb . setFormElement ( null ) ;
if ( currentForm == null || ! tb . inScope ( name ) ) {
tb . error ( this ) ;
return false ;
} else {
tb . generateImpliedEndTags () ;
if ( ! tb . currentElement () . normalName () . equals ( name ) )
tb . error ( this ) ;
tb . removeFromStack ( currentForm ) ;
}
} else if ( name . equals ( lr_19 ) ) {
if ( ! tb . inButtonScope ( name ) ) {
tb . error ( this ) ;
tb . processStartTag ( name ) ;
return tb . process ( endTag ) ;
} else {
tb . generateImpliedEndTags ( name ) ;
if ( ! tb . currentElement () . normalName () . equals ( name ) )
tb . error ( this ) ;
tb . popStackToClose ( name ) ;
}
} else if ( StringUtil . inSorted ( name , Constants . DdDt ) ) {
if ( ! tb . inScope ( name ) ) {
tb . error ( this ) ;
return false ;
} else {
tb . generateImpliedEndTags ( name ) ;
if ( ! tb . currentElement () . normalName () . equals ( name ) )
tb . error ( this ) ;
tb . popStackToClose ( name ) ;
}
} else if ( StringUtil . inSorted ( name , Constants . Headings ) ) {
if ( ! tb . inScope ( Constants . Headings ) ) {
tb . error ( this ) ;
return false ;
} else {
tb . generateImpliedEndTags ( name ) ;
if ( ! tb . currentElement () . normalName () . equals ( name ) )
tb . error ( this ) ;
tb . popStackToClose ( Constants . Headings ) ;
}
} else if ( name . equals ( lr_49 ) ) {
return anyOtherEndTag ( t , tb ) ;
} else if ( StringUtil . inSorted ( name , Constants . InBodyStartApplets ) ) {
if ( ! tb . inScope ( lr_40 ) ) {
if ( ! tb . inScope ( name ) ) {
tb . error ( this ) ;
return false ;
}
tb . generateImpliedEndTags () ;
if ( ! tb . currentElement () . normalName () . equals ( name ) )
tb . error ( this ) ;
tb . popStackToClose ( name ) ;
tb . clearFormattingElementsToLastMarker () ;
}
} else if ( name . equals ( lr_4 ) ) {
tb . error ( this ) ;
tb . processStartTag ( lr_4 ) ;
return false ;
} else {
return anyOtherEndTag ( t , tb ) ;
}
break;
case EOF :
break;
}
return true ;
}
boolean anyOtherEndTag ( Token t , HtmlTreeBuilder tb ) {
String name = t . asEndTag () . normalName ;
ArrayList < Element > stack = tb . getStack () ;
for ( int pos = stack . size () - 1 ; pos >= 0 ; pos -- ) {
Element node = stack . get ( pos ) ;
if ( node . normalName () . equals ( name ) ) {
tb . generateImpliedEndTags ( name ) ;
if ( ! name . equals ( tb . currentElement () . normalName () ) )
tb . error ( this ) ;
tb . popStackToClose ( name ) ;
break;
} else {
if ( tb . isSpecial ( node ) ) {
tb . error ( this ) ;
return false ;
}
}
}
return true ;
}
boolean process ( Token t , HtmlTreeBuilder tb ) {
if ( t . isCharacter () ) {
tb . insert ( t . asCharacter () ) ;
} else if ( t . isEOF () ) {
tb . error ( this ) ;
tb . pop () ;
tb . transition ( tb . originalState () ) ;
return tb . process ( t ) ;
} else if ( t . isEndTag () ) {
tb . pop () ;
tb . transition ( tb . originalState () ) ;
}
return true ;
}
boolean process ( Token t , HtmlTreeBuilder tb ) {
if ( t . isCharacter () ) {
tb . newPendingTableCharacters () ;
tb . markInsertionMode () ;
tb . transition ( InTableText ) ;
return tb . process ( t ) ;
} else if ( t . isComment () ) {
tb . insert ( t . asComment () ) ;
return true ;
} else if ( t . isDoctype () ) {
tb . error ( this ) ;
return false ;
} else if ( t . isStartTag () ) {
Token . StartTag startTag = t . asStartTag () ;
String name = startTag . normalName () ;
if ( name . equals ( lr_50 ) ) {
tb . clearStackToTableContext () ;
tb . insertMarkerToFormattingElements () ;
tb . insert ( startTag ) ;
tb . transition ( InCaption ) ;
} else if ( name . equals ( lr_51 ) ) {
tb . clearStackToTableContext () ;
tb . insert ( startTag ) ;
tb . transition ( InColumnGroup ) ;
} else if ( name . equals ( lr_52 ) ) {
tb . processStartTag ( lr_51 ) ;
return tb . process ( t ) ;
} else if ( StringUtil . in ( name , lr_53 , lr_54 , lr_55 ) ) {
tb . clearStackToTableContext () ;
tb . insert ( startTag ) ;
tb . transition ( InTableBody ) ;
} else if ( StringUtil . in ( name , lr_56 , lr_57 , lr_58 ) ) {
tb . processStartTag ( lr_53 ) ;
return tb . process ( t ) ;
} else if ( name . equals ( lr_27 ) ) {
tb . error ( this ) ;
boolean processed = tb . processEndTag ( lr_27 ) ;
if ( processed )
return tb . process ( t ) ;
} else if ( StringUtil . in ( name , lr_14 , lr_16 ) ) {
return tb . process ( t , InHead ) ;
} else if ( name . equals ( lr_28 ) ) {
if ( ! startTag . attributes . get ( lr_29 ) . equalsIgnoreCase ( lr_30 ) ) {
return anythingElse ( t , tb ) ;
} else {
tb . insertEmpty ( startTag ) ;
}
} else if ( name . equals ( lr_23 ) ) {
tb . error ( this ) ;
if ( tb . getFormElement () != null )
return false ;
else {
tb . insertForm ( startTag , false ) ;
}
} else {
return anythingElse ( t , tb ) ;
}
return true ;
} else if ( t . isEndTag () ) {
Token . EndTag endTag = t . asEndTag () ;
String name = endTag . normalName () ;
if ( name . equals ( lr_27 ) ) {
if ( ! tb . inTableScope ( name ) ) {
tb . error ( this ) ;
return false ;
} else {
tb . popStackToClose ( lr_27 ) ;
}
tb . resetInsertionMode () ;
} else if ( StringUtil . in ( name ,
lr_3 , lr_50 , lr_52 , lr_51 , lr_1 , lr_53 , lr_56 , lr_54 , lr_57 , lr_55 , lr_58 ) ) {
tb . error ( this ) ;
return false ;
} else {
return anythingElse ( t , tb ) ;
}
return true ;
} else if ( t . isEOF () ) {
if ( tb . currentElement () . normalName () . equals ( lr_1 ) )
tb . error ( this ) ;
return true ;
}
return anythingElse ( t , tb ) ;
}
boolean anythingElse ( Token t , HtmlTreeBuilder tb ) {
tb . error ( this ) ;
boolean processed ;
if ( StringUtil . in ( tb . currentElement () . normalName () , lr_27 , lr_53 , lr_54 , lr_55 , lr_58 ) ) {
tb . setFosterInserts ( true ) ;
processed = tb . process ( t , InBody ) ;
tb . setFosterInserts ( false ) ;
} else {
processed = tb . process ( t , InBody ) ;
}
return processed ;
}
boolean process ( Token t , HtmlTreeBuilder tb ) {
switch ( t . type ) {
case Character :
Token . Character c = t . asCharacter () ;
if ( c . getData () . equals ( nullString ) ) {
tb . error ( this ) ;
return false ;
} else {
tb . getPendingTableCharacters () . add ( c . getData () ) ;
}
break;
default:
if ( tb . getPendingTableCharacters () . size () > 0 ) {
for ( String character : tb . getPendingTableCharacters () ) {
if ( ! isWhitespace ( character ) ) {
tb . error ( this ) ;
if ( StringUtil . in ( tb . currentElement () . normalName () , lr_27 , lr_53 , lr_54 , lr_55 , lr_58 ) ) {
tb . setFosterInserts ( true ) ;
tb . process ( new Token . Character () . data ( character ) , InBody ) ;
tb . setFosterInserts ( false ) ;
} else {
tb . process ( new Token . Character () . data ( character ) , InBody ) ;
}
} else
tb . insert ( new Token . Character () . data ( character ) ) ;
}
tb . newPendingTableCharacters () ;
}
tb . transition ( tb . originalState () ) ;
return tb . process ( t ) ;
}
return true ;
}
boolean process ( Token t , HtmlTreeBuilder tb ) { MST[rv.UOI3Mutator]MSP[N]
if ( t . isEndTag () && t . asEndTag () . normalName () . equals ( lr_50 ) ) {
Token . EndTag endTag = t . asEndTag () ;
String name = endTag . normalName () ;
if ( ! tb . inTableScope ( name ) ) {
tb . error ( this ) ;
return false ;
} else {
tb . generateImpliedEndTags () ;
if ( ! tb . currentElement () . normalName () . equals ( lr_50 ) )
tb . error ( this ) ;
tb . popStackToClose ( lr_50 ) ;
tb . clearFormattingElementsToLastMarker () ;
tb . transition ( InTable ) ;
}
} else if ( (
t . isStartTag () && StringUtil . in ( t . asStartTag () . normalName () ,
lr_50 , lr_52 , lr_51 , lr_53 , lr_56 , lr_54 , lr_57 , lr_55 , lr_58 ) ||
t . isEndTag () && t . asEndTag () . normalName () . equals ( lr_27 ) )
) {
tb . error ( this ) ;
boolean processed = tb . processEndTag ( lr_50 ) ;
if ( processed )
return tb . process ( t ) ;
} else if ( t . isEndTag () && StringUtil . in ( t . asEndTag () . normalName () ,
lr_3 , lr_52 , lr_51 , lr_1 , lr_53 , lr_56 , lr_54 , lr_57 , lr_55 , lr_58 ) ) {
tb . error ( this ) ;
return false ;
} else {
return tb . process ( t , InBody ) ;
}
return true ;
}
boolean process ( Token t , HtmlTreeBuilder tb ) {
if ( isWhitespace ( t ) ) {
tb . insert ( t . asCharacter () ) ;
return true ;
}
switch ( t . type ) {
case Comment :
tb . insert ( t . asComment () ) ;
break;
case Doctype :
tb . error ( this ) ;
break;
case StartTag :
Token . StartTag startTag = t . asStartTag () ;
switch ( startTag . normalName () ) {
case lr_1 :
return tb . process ( t , InBody ) ;
case lr_52 :
tb . insertEmpty ( startTag ) ;
break;
default:
return anythingElse ( t , tb ) ;
}
break;
case EndTag :
Token . EndTag endTag = t . asEndTag () ;
if ( endTag . normalName . equals ( lr_51 ) ) {
if ( tb . currentElement () . normalName () . equals ( lr_1 ) ) {
tb . error ( this ) ;
return false ;
} else {
tb . pop () ;
tb . transition ( InTable ) ;
}
} else
return anythingElse ( t , tb ) ;
break;
case EOF :
if ( tb . currentElement () . normalName () . equals ( lr_1 ) )
return true ;
else
return anythingElse ( t , tb ) ;
default:
return anythingElse ( t , tb ) ;
}
return true ;
}
private boolean anythingElse ( Token t , TreeBuilder tb ) {
boolean processed = tb . processEndTag ( lr_51 ) ;
if ( processed )
return tb . process ( t ) ;
return true ;
}
boolean process ( Token t , HtmlTreeBuilder tb ) {
switch ( t . type ) {
case StartTag :
Token . StartTag startTag = t . asStartTag () ;
String name = startTag . normalName () ;
if ( name . equals ( lr_59 ) ) {
tb . insert ( startTag ) ;
} else if ( name . equals ( lr_58 ) ) {
tb . clearStackToTableBodyContext () ;
tb . insert ( startTag ) ;
tb . transition ( InRow ) ;
} else if ( StringUtil . in ( name , lr_57 , lr_56 ) ) {
tb . error ( this ) ;
tb . processStartTag ( lr_58 ) ;
return tb . process ( startTag ) ;
} else if ( StringUtil . in ( name , lr_50 , lr_52 , lr_51 , lr_53 , lr_54 , lr_55 ) ) {
return exitTableBody ( t , tb ) ;
} else
return anythingElse ( t , tb ) ;
break;
case EndTag :
Token . EndTag endTag = t . asEndTag () ;
name = endTag . normalName () ;
if ( StringUtil . in ( name , lr_53 , lr_54 , lr_55 ) ) {
if ( ! tb . inTableScope ( name ) ) {
tb . error ( this ) ;
return false ;
} else {
tb . clearStackToTableBodyContext () ;
tb . pop () ;
tb . transition ( InTable ) ;
}
} else if ( name . equals ( lr_27 ) ) {
return exitTableBody ( t , tb ) ;
} else if ( StringUtil . in ( name , lr_3 , lr_50 , lr_52 , lr_51 , lr_1 , lr_56 , lr_57 , lr_58 ) ) {
tb . error ( this ) ;
return false ;
} else
return anythingElse ( t , tb ) ;
break;
default:
return anythingElse ( t , tb ) ;
}
return true ;
}
private boolean exitTableBody ( Token t , HtmlTreeBuilder tb ) {
if ( ! ( tb . inTableScope ( lr_53 ) || tb . inTableScope ( lr_55 ) || tb . inScope ( lr_54 ) ) ) {
tb . error ( this ) ;
return false ;
}
tb . clearStackToTableBodyContext () ;
tb . processEndTag ( tb . currentElement () . normalName () ) ;
return tb . process ( t ) ;
}
private boolean anythingElse ( Token t , HtmlTreeBuilder tb ) {
return tb . process ( t , InTable ) ;
}
boolean process ( Token t , HtmlTreeBuilder tb ) {
if ( t . isStartTag () ) {
Token . StartTag startTag = t . asStartTag () ;
String name = startTag . normalName () ;
if ( name . equals ( lr_59 ) ) {
tb . insert ( startTag ) ;
} else if ( StringUtil . in ( name , lr_57 , lr_56 ) ) {
tb . clearStackToTableRowContext () ;
tb . insert ( startTag ) ;
tb . transition ( InCell ) ;
tb . insertMarkerToFormattingElements () ;
} else if ( StringUtil . in ( name , lr_50 , lr_52 , lr_51 , lr_53 , lr_54 , lr_55 , lr_58 ) ) {
return handleMissingTr ( t , tb ) ;
} else {
return anythingElse ( t , tb ) ;
}
} else if ( t . isEndTag () ) {
Token . EndTag endTag = t . asEndTag () ;
String name = endTag . normalName () ;
if ( name . equals ( lr_58 ) ) {
if ( ! tb . inTableScope ( name ) ) {
tb . error ( this ) ;
return false ;
}
tb . clearStackToTableRowContext () ;
tb . pop () ;
tb . transition ( InTableBody ) ;
} else if ( name . equals ( lr_27 ) ) {
return handleMissingTr ( t , tb ) ;
} else if ( StringUtil . in ( name , lr_53 , lr_54 , lr_55 ) ) {
if ( ! tb . inTableScope ( name ) ) {
tb . error ( this ) ;
return false ;
}
tb . processEndTag ( lr_58 ) ;
return tb . process ( t ) ;
} else if ( StringUtil . in ( name , lr_3 , lr_50 , lr_52 , lr_51 , lr_1 , lr_56 , lr_57 ) ) {
tb . error ( this ) ;
return false ;
} else {
return anythingElse ( t , tb ) ;
}
} else {
return anythingElse ( t , tb ) ;
}
return true ;
}
private boolean anythingElse ( Token t , HtmlTreeBuilder tb ) {
return tb . process ( t , InTable ) ;
}
private boolean handleMissingTr ( Token t , TreeBuilder tb ) {
boolean processed = tb . processEndTag ( lr_58 ) ;
if ( processed )
return tb . process ( t ) ;
else
return false ;
}
boolean process ( Token t , HtmlTreeBuilder tb ) {
if ( t . isEndTag () ) {
Token . EndTag endTag = t . asEndTag () ;
String name = endTag . normalName () ;
if ( StringUtil . inSorted ( name , Constants . InCellNames ) ) {
if ( ! tb . inTableScope ( name ) ) {
tb . error ( this ) ;
tb . transition ( InRow ) ;
return false ;
}
tb . generateImpliedEndTags () ;
if ( ! tb . currentElement () . normalName () . equals ( name ) )
tb . error ( this ) ;
tb . popStackToClose ( name ) ;
tb . clearFormattingElementsToLastMarker () ;
tb . transition ( InRow ) ;
} else if ( StringUtil . inSorted ( name , Constants . InCellBody ) ) {
tb . error ( this ) ;
return false ;
} else if ( StringUtil . inSorted ( name , Constants . InCellTable ) ) {
if ( ! tb . inTableScope ( name ) ) {
tb . error ( this ) ;
return false ;
}
closeCell ( tb ) ;
return tb . process ( t ) ;
} else {
return anythingElse ( t , tb ) ;
}
} else if ( t . isStartTag () &&
StringUtil . inSorted ( t . asStartTag () . normalName () , Constants . InCellCol ) ) {
if ( ! ( tb . inTableScope ( lr_56 ) || tb . inTableScope ( lr_57 ) ) ) {
tb . error ( this ) ;
return false ;
}
closeCell ( tb ) ;
return tb . process ( t ) ;
} else {
return anythingElse ( t , tb ) ;
}
return true ;
}
private boolean anythingElse ( Token t , HtmlTreeBuilder tb ) {
return tb . process ( t , InBody ) ;
}
private void closeCell ( HtmlTreeBuilder tb ) {
if ( tb . inTableScope ( lr_56 ) )
tb . processEndTag ( lr_56 ) ;
else
tb . processEndTag ( lr_57 ) ;
}
boolean process ( Token t , HtmlTreeBuilder tb ) {
switch ( t . type ) {
case Character :
Token . Character c = t . asCharacter () ;
if ( c . getData () . equals ( nullString ) ) {
tb . error ( this ) ;
return false ;
} else {
tb . insert ( c ) ;
}
break;
case Comment :
tb . insert ( t . asComment () ) ;
break;
case Doctype :
tb . error ( this ) ;
return false ;
case StartTag :
Token . StartTag start = t . asStartTag () ;
String name = start . normalName () ;
if ( name . equals ( lr_1 ) )
return tb . process ( start , InBody ) ;
else if ( name . equals ( lr_46 ) ) {
if ( tb . currentElement () . normalName () . equals ( lr_46 ) )
tb . processEndTag ( lr_46 ) ;
tb . insert ( start ) ;
} else if ( name . equals ( lr_60 ) ) {
if ( tb . currentElement () . normalName () . equals ( lr_46 ) )
tb . processEndTag ( lr_46 ) ;
if ( tb . currentElement () . normalName () . equals ( lr_60 ) )
tb . processEndTag ( lr_60 ) ;
tb . insert ( start ) ;
} else if ( name . equals ( lr_45 ) ) {
tb . error ( this ) ;
return tb . processEndTag ( lr_45 ) ;
} else if ( StringUtil . in ( name , lr_28 , lr_61 , lr_41 ) ) {
tb . error ( this ) ;
if ( ! tb . inSelectScope ( lr_45 ) )
return false ;
tb . processEndTag ( lr_45 ) ;
return tb . process ( start ) ;
} else if ( name . equals ( lr_16 ) ) {
return tb . process ( t , InHead ) ;
} else {
return anythingElse ( t , tb ) ;
}
break;
case EndTag :
Token . EndTag end = t . asEndTag () ;
name = end . normalName () ;
switch ( name ) {
case lr_60 :
if ( tb . currentElement () . normalName () . equals ( lr_46 ) && tb . aboveOnStack ( tb . currentElement () ) != null && tb . aboveOnStack ( tb . currentElement () ) . normalName () . equals ( lr_60 ) )
tb . processEndTag ( lr_46 ) ;
if ( tb . currentElement () . normalName () . equals ( lr_60 ) )
tb . pop () ;
else
tb . error ( this ) ;
break;
case lr_46 :
if ( tb . currentElement () . normalName () . equals ( lr_46 ) )
tb . pop () ;
else
tb . error ( this ) ;
break;
case lr_45 :
if ( ! tb . inSelectScope ( name ) ) {
tb . error ( this ) ;
return false ;
} else {
tb . popStackToClose ( name ) ;
tb . resetInsertionMode () ;
}
break;
default:
return anythingElse ( t , tb ) ;
}
break;
case EOF :
if ( ! tb . currentElement () . normalName () . equals ( lr_1 ) )
tb . error ( this ) ;
break;
default:
return anythingElse ( t , tb ) ;
}
return true ;
}
private boolean anythingElse ( Token t , HtmlTreeBuilder tb ) {
tb . error ( this ) ;
return false ;
}
boolean process ( Token t , HtmlTreeBuilder tb ) {
if ( t . isStartTag () && StringUtil . in ( t . asStartTag () . normalName () , lr_50 , lr_27 , lr_53 , lr_54 , lr_55 , lr_58 , lr_56 , lr_57 ) ) {
tb . error ( this ) ;
tb . processEndTag ( lr_45 ) ;
return tb . process ( t ) ;
} else if ( t . isEndTag () && StringUtil . in ( t . asEndTag () . normalName () , lr_50 , lr_27 , lr_53 , lr_54 , lr_55 , lr_58 , lr_56 , lr_57 ) ) {
tb . error ( this ) ;
if ( tb . inTableScope ( t . asEndTag () . normalName () ) ) {
tb . processEndTag ( lr_45 ) ;
return ( tb . process ( t ) ) ;
} else
return false ;
} else {
return tb . process ( t , InSelect ) ;
}
}
boolean process ( Token t , HtmlTreeBuilder tb ) {
if ( isWhitespace ( t ) ) {
return tb . process ( t , InBody ) ;
} else if ( t . isComment () ) {
tb . insert ( t . asComment () ) ;
} else if ( t . isDoctype () ) {
tb . error ( this ) ;
return false ;
} else if ( t . isStartTag () && t . asStartTag () . normalName () . equals ( lr_1 ) ) {
return tb . process ( t , InBody ) ;
} else if ( t . isEndTag () && t . asEndTag () . normalName () . equals ( lr_1 ) ) {
if ( tb . isFragmentParsing () ) {
tb . error ( this ) ;
return false ;
} else {
tb . transition ( AfterAfterBody ) ;
}
} else if ( t . isEOF () ) {
} else {
tb . error ( this ) ;
tb . transition ( InBody ) ;
return tb . process ( t ) ;
}
return true ;
}
boolean process ( Token t , HtmlTreeBuilder tb ) {
if ( isWhitespace ( t ) ) {
tb . insert ( t . asCharacter () ) ;
} else if ( t . isComment () ) {
tb . insert ( t . asComment () ) ;
} else if ( t . isDoctype () ) {
tb . error ( this ) ;
return false ;
} else if ( t . isStartTag () ) {
Token . StartTag start = t . asStartTag () ;
switch ( start . normalName () ) {
case lr_1 :
return tb . process ( start , InBody ) ;
case lr_17 :
tb . insert ( start ) ;
break;
case lr_62 :
tb . insertEmpty ( start ) ;
break;
case lr_13 :
return tb . process ( start , InHead ) ;
default:
tb . error ( this ) ;
return false ;
}
} else if ( t . isEndTag () && t . asEndTag () . normalName () . equals ( lr_17 ) ) {
if ( tb . currentElement () . normalName () . equals ( lr_1 ) ) {
tb . error ( this ) ;
return false ;
} else {
tb . pop () ;
if ( ! tb . isFragmentParsing () && ! tb . currentElement () . normalName () . equals ( lr_17 ) ) {
tb . transition ( AfterFrameset ) ;
}
}
} else if ( t . isEOF () ) {
if ( ! tb . currentElement () . normalName () . equals ( lr_1 ) ) {
tb . error ( this ) ;
return true ;
}
} else {
tb . error ( this ) ;
return false ;
}
return true ;
}
boolean process ( Token t , HtmlTreeBuilder tb ) {
if ( isWhitespace ( t ) ) {
tb . insert ( t . asCharacter () ) ;
} else if ( t . isComment () ) {
tb . insert ( t . asComment () ) ;
} else if ( t . isDoctype () ) {
tb . error ( this ) ;
return false ;
} else if ( t . isStartTag () && t . asStartTag () . normalName () . equals ( lr_1 ) ) {
return tb . process ( t , InBody ) ;
} else if ( t . isEndTag () && t . asEndTag () . normalName () . equals ( lr_1 ) ) {
tb . transition ( AfterAfterFrameset ) ;
} else if ( t . isStartTag () && t . asStartTag () . normalName () . equals ( lr_13 ) ) {
return tb . process ( t , InHead ) ;
} else if ( t . isEOF () ) {
} else {
tb . error ( this ) ;
return false ;
}
return true ;
}
boolean process ( Token t , HtmlTreeBuilder tb ) {
if ( t . isComment () ) {
tb . insert ( t . asComment () ) ;
} else if ( t . isDoctype () || isWhitespace ( t ) || ( t . isStartTag () && t . asStartTag () . normalName () . equals ( lr_1 ) ) ) {
return tb . process ( t , InBody ) ;
} else if ( t . isEOF () ) {
} else {
tb . error ( this ) ;
tb . transition ( InBody ) ;
return tb . process ( t ) ;
}
return true ;
}
boolean process ( Token t , HtmlTreeBuilder tb ) {
if ( t . isComment () ) {
tb . insert ( t . asComment () ) ;
} else if ( t . isDoctype () || isWhitespace ( t ) || ( t . isStartTag () && t . asStartTag () . normalName () . equals ( lr_1 ) ) ) {
return tb . process ( t , InBody ) ;
} else if ( t . isEOF () ) {
} else if ( t . isStartTag () && t . asStartTag () . normalName () . equals ( lr_13 ) ) {
return tb . process ( t , InHead ) ;
} else {
tb . error ( this ) ;
return false ;
}
return true ;
}
boolean process ( Token t , HtmlTreeBuilder tb ) {
return true ;
}
private static boolean isWhitespace ( Token t ) {
if ( t . isCharacter () ) {
String data = t . asCharacter () . getData () ;
return isWhitespace ( data ) ;
}
return false ;
}
private static boolean isWhitespace ( String data ) {
return StringUtil . isBlank ( data ) ;
}
private static void handleRcData ( Token . StartTag startTag , HtmlTreeBuilder tb ) {
tb . tokeniser . transition ( TokeniserState . Rcdata ) ;
tb . markInsertionMode () ;
tb . transition ( Text ) ;
tb . insert ( startTag ) ;
}
private static void handleRawtext ( Token . StartTag startTag , HtmlTreeBuilder tb ) {
tb . tokeniser . transition ( TokeniserState . Rawtext ) ;
tb . markInsertionMode () ;
tb . transition ( Text ) ;
tb . insert ( startTag ) ;
}

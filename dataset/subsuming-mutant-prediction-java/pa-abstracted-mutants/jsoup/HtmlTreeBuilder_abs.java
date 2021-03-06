ParseSettings defaultSettings () {
return ParseSettings . htmlDefault ;
}
@Override
protected void initialiseParse ( Reader input , String baseUri , Parser parser ) {
super . initialiseParse ( input , baseUri , parser ) ;
state = HtmlTreeBuilderState . Initial ;
originalState = null ;
baseUriSetFromDoc = false ;
headElement = null ;
formElement = null ;
contextElement = null ;
formattingElements = new ArrayList <> () ;
pendingTableCharacters = new ArrayList <> () ;
emptyEnd = new Token . EndTag () ;
framesetOk = true ;
fosterInserts = false ;
fragmentParsing = false ;
}
List < Node > parseFragment ( String inputFragment , Element context , String baseUri , Parser parser ) {
state = HtmlTreeBuilderState . Initial ;
initialiseParse ( new StringReader ( inputFragment ) , baseUri , parser ) ;
contextElement = context ;
fragmentParsing = true ;
Element root = null ;
if ( context != null ) {
if ( context . ownerDocument () != null )
doc . quirksMode ( context . ownerDocument () . quirksMode () ) ;
String contextTag = context . tagName () ;
if ( StringUtil . in ( contextTag , lr_1 , lr_2 ) )
tokeniser . transition ( TokeniserState . Rcdata ) ;
else if ( StringUtil . in ( contextTag , lr_3 , lr_4 , lr_5 , lr_6 , lr_7 ) )
tokeniser . transition ( TokeniserState . Rawtext ) ;
else if ( contextTag . equals ( lr_8 ) )
tokeniser . transition ( TokeniserState . ScriptData ) ;
else if ( contextTag . equals ( ( lr_9 ) ) )
tokeniser . transition ( TokeniserState . Data ) ;
else if ( contextTag . equals ( lr_10 ) )
tokeniser . transition ( TokeniserState . Data ) ;
else
tokeniser . transition ( TokeniserState . Data ) ;
root = new Element ( Tag . valueOf ( lr_11 , settings ) , baseUri ) ;
doc . appendChild ( root ) ;
stack . add ( root ) ;
resetInsertionMode () ;
Elements contextChain = context . parents () ;
contextChain . add ( 0 , context ) ;
for ( Element parent : contextChain ) {
if ( parent instanceof FormElement ) {
formElement = ( FormElement ) parent ;
break;
}
}
}
runParser () ;
if ( context != null )
return root . childNodes () ;
else
return doc . childNodes () ;
}
@Override
protected boolean process ( Token token ) {
currentToken = token ;
return this . state . process ( token , this ) ;
}
boolean process ( Token token , HtmlTreeBuilderState state ) {
currentToken = token ;
return state . process ( token , this ) ;
}
void transition ( HtmlTreeBuilderState state ) {
this . state = state ;
}
HtmlTreeBuilderState state () {
return state ;
}
void markInsertionMode () {
originalState = state ;
}
HtmlTreeBuilderState originalState () {
return originalState ;
}
void framesetOk ( boolean framesetOk ) {
this . framesetOk = framesetOk ;
}
boolean framesetOk () {
return framesetOk ;
}
Document getDocument () {
return doc ;
}
String getBaseUri () {
return baseUri ;
}
void maybeSetBaseUri ( Element base ) {
if ( baseUriSetFromDoc )
return;
String href = base . absUrl ( lr_12 ) ;
if ( href . length () != 0 ) {
baseUri = href ;
baseUriSetFromDoc = true ;
doc . setBaseUri ( href ) ;
}
}
boolean isFragmentParsing () {
return fragmentParsing ;
}
void error ( HtmlTreeBuilderState state ) {
if ( parser . getErrors () . canAddError () )
parser . getErrors () . add ( new ParseError ( reader . pos () , lr_13 , currentToken . tokenType () , state ) ) ;
}
Element insert ( final Token . StartTag startTag ) {
if ( startTag . attributes != null && ! startTag . attributes . isEmpty () ) {
int dupes = startTag . attributes . deduplicate ( settings ) ;
if ( dupes > 0 ) {
error ( lr_14 ) ;
}
}
if ( startTag . isSelfClosing () ) {
Element el = insertEmpty ( startTag ) ;
stack . add ( el ) ;
tokeniser . transition ( TokeniserState . Data ) ;
tokeniser . emit ( emptyEnd . reset () . name ( el . tagName () ) ) ;
return el ;
}
Element el = new Element ( Tag . valueOf ( startTag . name () , settings ) , null , settings . normalizeAttributes ( startTag . attributes ) ) ;
insert ( el ) ;
return el ;
}
Element insertStartTag ( String startTagName ) {
Element el = new Element ( Tag . valueOf ( startTagName , settings ) , null ) ;
insert ( el ) ;
return el ;
}
void insert ( Element el ) {
insertNode ( el ) ;
stack . add ( el ) ;
}
Element insertEmpty ( Token . StartTag startTag ) {
Tag tag = Tag . valueOf ( startTag . name () , settings ) ;
Element el = new Element ( tag , null , startTag . attributes ) ;
insertNode ( el ) ;
if ( startTag . isSelfClosing () ) {
if ( tag . isKnownTag () ) {
if ( ! tag . isEmpty () )
tokeniser . error ( lr_15 ) ;
}
else
tag . setSelfClosing () ;
}
return el ;
}
FormElement insertForm ( Token . StartTag startTag , boolean onStack ) {
Tag tag = Tag . valueOf ( startTag . name () , settings ) ;
FormElement el = new FormElement ( tag , null , startTag . attributes ) ;
setFormElement ( el ) ;
insertNode ( el ) ;
if ( onStack )
stack . add ( el ) ;
return el ;
}
void insert ( Token . Comment commentToken ) {
Comment comment = new Comment ( commentToken . getData () ) ;
insertNode ( comment ) ;
}
void insert ( Token . Character characterToken ) {
final Node node ;
final Element el = currentElement () ;
final String tagName = el . tagName () ;
final String data = characterToken . getData () ;
if ( characterToken . isCData () )
node = new CDataNode ( data ) ;
else if ( tagName . equals ( lr_8 ) || tagName . equals ( lr_6 ) )
node = new DataNode ( data ) ;
else
node = new TextNode ( data ) ;
el . appendChild ( node ) ;
}
private void insertNode ( Node node ) {
if ( stack . isEmpty () )
doc . appendChild ( node ) ;
else if ( isFosterInserts () )
insertInFosterParent ( node ) ;
else
currentElement () . appendChild ( node ) ;
if ( node instanceof Element && ( ( Element ) node ) . tag () . isFormListed () ) {
if ( formElement != null )
formElement . addElement ( ( Element ) node ) ;
}
}
Element pop () {
int size = stack . size () ;
return stack . remove ( size - 1 ) ;
}
void push ( Element element ) {
stack . add ( element ) ;
}
ArrayList < Element > getStack () {
return stack ;
}
boolean onStack ( Element el ) {
return isElementInQueue ( stack , el ) ;
}
private boolean isElementInQueue ( ArrayList < Element > queue , Element element ) {
for ( int pos = queue . size () - 1 ; pos >= 0 ; pos -- ) {
Element next = queue . get ( pos ) ;
if ( next == element ) {
return true ;
}
}
return false ;
}
Element getFromStack ( String elName ) {
for ( int pos = stack . size () - 1 ; pos >= 0 ; pos -- ) {
Element next = stack . get ( pos ) ;
if ( next . normalName () . equals ( elName ) ) {
return next ;
}
}
return null ;
}
boolean removeFromStack ( Element el ) {
for ( int pos = stack . size () - 1 ; pos >= 0 ; pos -- ) {
Element next = stack . get ( pos ) ;
if ( next == el ) {
stack . remove ( pos ) ;
return true ;
}
}
return false ;
}
void popStackToClose ( String elName ) {
for ( int pos = stack . size () - 1 ; pos >= 0 ; pos -- ) {
Element next = stack . get ( pos ) ;
stack . remove ( pos ) ;
if ( next . normalName () . equals ( elName ) )
break;
}
}
void popStackToClose ( String ... elNames ) {
for ( int pos = stack . size () - 1 ; pos >= 0 ; pos -- ) {
Element next = stack . get ( pos ) ;
stack . remove ( pos ) ;
if ( inSorted ( next . normalName () , elNames ) )
break;
}
}
void popStackToBefore ( String elName ) {
for ( int pos = stack . size () - 1 ; pos >= 0 ; pos -- ) {
Element next = stack . get ( pos ) ;
if ( next . normalName () . equals ( elName ) ) {
break;
} else {
stack . remove ( pos ) ;
}
}
}
void clearStackToTableContext () {
clearStackToContext ( lr_16 ) ;
}
void clearStackToTableBodyContext () {
clearStackToContext ( lr_17 , lr_18 , lr_19 , lr_20 ) ;
}
void clearStackToTableRowContext () {
clearStackToContext ( lr_21 , lr_20 ) ;
}
private void clearStackToContext ( String ... nodeNames ) {
for ( int pos = stack . size () - 1 ; pos >= 0 ; pos -- ) {
Element next = stack . get ( pos ) ;
if ( StringUtil . in ( next . normalName () , nodeNames ) || next . normalName () . equals ( lr_11 ) )
break;
else
stack . remove ( pos ) ;
}
}
Element aboveOnStack ( Element el ) {
assert onStack ( el ) ;
for ( int pos = stack . size () - 1 ; pos >= 0 ; pos -- ) {
Element next = stack . get ( pos ) ;
if ( next == el ) {
return stack . get ( pos - 1 ) ;
}
}
return null ;
}
void insertOnStackAfter ( Element after , Element in ) {
int i = stack . lastIndexOf ( after ) ;
Validate . isTrue ( i != - 1 ) ;
stack . add ( i + 1 , in ) ;
}
void replaceOnStack ( Element out , Element in ) {
replaceInQueue ( stack , out , in ) ;
}
private void replaceInQueue ( ArrayList < Element > queue , Element out , Element in ) {
int i = queue . lastIndexOf ( out ) ;
Validate . isTrue ( i != - 1 ) ;
queue . set ( i , in ) ;
}
void resetInsertionMode () {
boolean last = false ;
for ( int pos = stack . size () - 1 ; pos >= 0 ; pos -- ) {
Element node = stack . get ( pos ) ;
if ( pos == 0 ) {
last = true ;
node = contextElement ;
}
String name = node . normalName () ;
if ( lr_22 . equals ( name ) ) {
transition ( HtmlTreeBuilderState . InSelect ) ;
break;
} else if ( ( lr_23 . equals ( name ) || lr_24 . equals ( name ) && ! last ) ) {
transition ( HtmlTreeBuilderState . InCell ) ;
break;
} else if ( lr_21 . equals ( name ) ) {
transition ( HtmlTreeBuilderState . InRow ) ;
break;
} else if ( lr_17 . equals ( name ) || lr_19 . equals ( name ) || lr_18 . equals ( name ) ) {
transition ( HtmlTreeBuilderState . InTableBody ) ;
break;
} else if ( lr_25 . equals ( name ) ) {
transition ( HtmlTreeBuilderState . InCaption ) ;
break;
} else if ( lr_26 . equals ( name ) ) {
transition ( HtmlTreeBuilderState . InColumnGroup ) ;
break;
} else if ( lr_16 . equals ( name ) ) {
transition ( HtmlTreeBuilderState . InTable ) ;
break;
} else if ( lr_27 . equals ( name ) ) {
transition ( HtmlTreeBuilderState . InBody ) ;
break;
} else if ( lr_28 . equals ( name ) ) {
transition ( HtmlTreeBuilderState . InBody ) ;
break;
} else if ( lr_29 . equals ( name ) ) {
transition ( HtmlTreeBuilderState . InFrameset ) ;
break;
} else if ( lr_11 . equals ( name ) ) {
transition ( HtmlTreeBuilderState . BeforeHead ) ;
break;
} else if ( last ) {
transition ( HtmlTreeBuilderState . InBody ) ;
break;
}
}
}
private boolean inSpecificScope ( String targetName , String [] baseTypes , String [] extraTypes ) {
specificScopeTarget [ 0 ] = targetName ;
return inSpecificScope ( specificScopeTarget , baseTypes , extraTypes ) ;
}
private boolean inSpecificScope ( String [] targetNames , String [] baseTypes , String [] extraTypes ) {
final int bottom = stack . size () - 1 ;
final int top = bottom > MaxScopeSearchDepth ? bottom - MaxScopeSearchDepth : 0 ;
for ( int pos = bottom ; pos >= top ; pos -- ) {
final String elName = stack . get ( pos ) . normalName () ;
if ( inSorted ( elName , targetNames ) )
return true ;
if ( inSorted ( elName , baseTypes ) )
return false ;
if ( extraTypes != null && inSorted ( elName , extraTypes ) )
return false ;
}
return false ;
}
boolean inScope ( String [] targetNames ) {
return inSpecificScope ( targetNames , TagsSearchInScope , null ) ;
}
boolean inScope ( String targetName ) {
return inScope ( targetName , null ) ;
}
boolean inScope ( String targetName , String [] extras ) {
return inSpecificScope ( targetName , TagsSearchInScope , extras ) ;
}
boolean inListItemScope ( String targetName ) {
return inScope ( targetName , TagSearchList ) ;
}
boolean inButtonScope ( String targetName ) {
return inScope ( targetName , TagSearchButton ) ;
}
boolean inTableScope ( String targetName ) {
return inSpecificScope ( targetName , TagSearchTableScope , null ) ;
}
boolean inSelectScope ( String targetName ) {
for ( int pos = stack . size () - 1 ; pos >= 0 ; pos -- ) {
Element el = stack . get ( pos ) ;
String elName = el . normalName () ;
if ( elName . equals ( targetName ) )
return true ;
if ( ! inSorted ( elName , TagSearchSelectScope ) )
return false ;
}
Validate . fail ( lr_30 ) ;
return false ;
}
void setHeadElement ( Element headElement ) {
this . headElement = headElement ;
}
Element getHeadElement () {
return headElement ;
}
boolean isFosterInserts () {
return fosterInserts ;
}
void setFosterInserts ( boolean fosterInserts ) {
this . fosterInserts = fosterInserts ;
}
FormElement getFormElement () {
return formElement ;
}
void setFormElement ( FormElement formElement ) {
this . formElement = formElement ;
}
void newPendingTableCharacters () {
pendingTableCharacters = new ArrayList <> () ;
}
List < String > getPendingTableCharacters () {
return pendingTableCharacters ;
}
void generateImpliedEndTags ( String excludeTag ) {
while ( ( excludeTag != null && ! currentElement () . normalName () . equals ( excludeTag ) ) &&
inSorted ( currentElement () . normalName () , TagSearchEndTags ) )
pop () ;
}
void generateImpliedEndTags () {
generateImpliedEndTags ( null ) ;
}
boolean isSpecial ( Element el ) {
String name = el . normalName () ;
return inSorted ( name , TagSearchSpecial ) ;
}
Element lastFormattingElement () {
return formattingElements . size () > 0 ? formattingElements . get ( formattingElements . size () - 1 ) : null ;
}
Element removeLastFormattingElement () {
int size = formattingElements . size () ;
if ( size > 0 )
return formattingElements . remove ( size - 1 ) ;
else
return null ;
}
void pushActiveFormattingElements ( Element in ) {
int numSeen = 0 ;
for ( int pos = formattingElements . size () - 1 ; pos >= 0 ; pos -- ) {
Element el = formattingElements . get ( pos ) ;
if ( el == null )
break;
if ( isSameFormattingElement ( in , el ) )
numSeen ++ ;
if ( numSeen == 3 ) {
formattingElements . remove ( pos ) ;
break;
}
}
formattingElements . add ( in ) ;
}
private boolean isSameFormattingElement ( Element a , Element b ) {
return a . normalName () . equals ( b . normalName () ) &&
a . attributes () . equals ( b . attributes () ) ;
}
void reconstructFormattingElements () {
Element last = lastFormattingElement () ;
if ( last == null || onStack ( last ) )
return;
Element entry = last ;
int size = formattingElements . size () ;
int pos = size - 1 ;
boolean skip = false ;
while ( true ) {
if ( pos == 0 ) {
skip = true ;
break;
}
entry = formattingElements . get ( -- pos ) ;
if ( entry == null || onStack ( entry ) )
break;
}
while( true ) {
if ( ! skip )
entry = formattingElements . get ( ++ pos ) ;
Validate . notNull ( entry ) ;
skip = false ;
Element newEl = insertStartTag ( entry . normalName () ) ;
newEl . attributes () . addAll ( entry . attributes () ) ;
formattingElements . set ( pos , newEl ) ;
if ( pos == size - 1 )
break;
}
}
void clearFormattingElementsToLastMarker () {
while ( ! formattingElements . isEmpty () ) {
Element el = removeLastFormattingElement () ;
if ( el == null )
break;
}
}
void removeFromActiveFormattingElements ( Element el ) {
for ( int pos = formattingElements . size () - 1 ; pos >= 0 ; pos -- ) {
Element next = formattingElements . get ( pos ) ;
if ( next == el ) {
formattingElements . remove ( pos ) ;
break;
}
}
}
boolean isInActiveFormattingElements ( Element el ) {
return isElementInQueue ( formattingElements , el ) ;
}
Element getActiveFormattingElement ( String nodeName ) {
for ( int pos = formattingElements . size () - 1 ; pos >= 0 ; pos -- ) {
Element next = formattingElements . get ( pos ) ;
if ( next == null )
break;
else if ( next . normalName () . equals ( nodeName ) )
return next ;
}
return null ;
}
void replaceActiveFormattingElement ( Element out , Element in ) {
replaceInQueue ( formattingElements , out , in ) ;
}
void insertMarkerToFormattingElements () {
formattingElements . add ( null ) ;
}
void insertInFosterParent ( Node in ) {
Element fosterParent ;
Element lastTable = getFromStack ( lr_16 ) ;
boolean isLastTableParent = false ;
if ( lastTable != null ) {
if ( lastTable . parent () != null ) {
fosterParent = lastTable . parent () ;
isLastTableParent = true ;
} else
fosterParent = aboveOnStack ( lastTable ) ;
} else {
fosterParent = stack . get ( 0 ) ;
}
if ( isLastTableParent ) {
Validate . notNull ( lastTable ) ;
lastTable . before ( in ) ;
}
else
fosterParent . appendChild ( in ) ;
}
@Override
public String toString () {
return lr_31 +
lr_32 + currentToken +
lr_33 + state +
lr_34 + currentElement () +
'}' ;
}

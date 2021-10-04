public static Document createShell ( String baseUri ) {
Validate . notNull ( baseUri ) ;
Document doc = new Document ( baseUri ) ;
doc . parser = doc . parser () ;
Element html = doc . appendElement ( lr_1 ) ;
html . appendElement ( lr_2 ) ;
html . appendElement ( lr_3 ) ;
return doc ;
}
public String location () {
return location ;
}
public DocumentType documentType () {
for ( Node node : childNodes ) {
if ( node instanceof DocumentType )
return ( DocumentType ) node ;
else if ( ! ( node instanceof LeafNode ) )
break;
}
return null ;
}
public Element head () {
return findFirstElementByTagName ( lr_2 , this ) ;
}
public Element body () {
return findFirstElementByTagName ( lr_3 , this ) ;
}
public String title () {
Element titleEl = getElementsByTag ( lr_4 ) . first () ;
return titleEl != null ? StringUtil . normaliseWhitespace ( titleEl . text () ) . trim () : lr_5 ;
}
public void title ( String title ) {
Validate . notNull ( title ) ;
Element titleEl = getElementsByTag ( lr_4 ) . first () ;
if ( titleEl == null ) {
head () . appendElement ( lr_4 ) . text ( title ) ;
} else {
titleEl . text ( title ) ;
}
}
public Element createElement ( String tagName ) {
return new Element ( Tag . valueOf ( tagName , ParseSettings . preserveCase ) , this . baseUri () ) ;
}
public Document normalise () {
Element htmlEl = findFirstElementByTagName ( lr_1 , this ) ;
if ( htmlEl == null )
htmlEl = appendElement ( lr_1 ) ;
if ( head () == null )
htmlEl . prependElement ( lr_2 ) ;
if ( body () == null )
htmlEl . appendElement ( lr_3 ) ;
normaliseTextNodes ( head () ) ;
normaliseTextNodes ( htmlEl ) ;
normaliseTextNodes ( this ) ;
normaliseStructure ( lr_2 , htmlEl ) ;
normaliseStructure ( lr_3 , htmlEl ) ;
ensureMetaCharsetElement () ;
return this ;
}
private void normaliseTextNodes ( Element element ) {
List < Node > toMove = new ArrayList <> () ;
for ( Node node : element . childNodes ) {
if ( node instanceof TextNode ) {
TextNode tn = ( TextNode ) node ;
if ( ! tn . isBlank () )
toMove . add ( tn ) ;
}
}
for ( int i = toMove . size () - 1 ; i >= 0 ; i -- ) {
Node node = toMove . get ( i ) ;
element . removeChild ( node ) ;
body () . prependChild ( new TextNode ( lr_6 ) ) ;
body () . prependChild ( node ) ;
}
}
private void normaliseStructure ( String tag , Element htmlEl ) {
Elements elements = this . getElementsByTag ( tag ) ;
Element master = elements . first () ;
if ( elements . size () > 1 ) {
List < Node > toMove = new ArrayList <> () ;
for ( int i = 1 ; i < elements . size () ; i ++ ) {
Node dupe = elements . get ( i ) ;
toMove . addAll ( dupe . ensureChildNodes () ) ;
dupe . remove () ;
}
for ( Node dupe : toMove )
master . appendChild ( dupe ) ;
}
if ( ! master . parent () . equals ( htmlEl ) ) {
htmlEl . appendChild ( master ) ;
}
}
private Element findFirstElementByTagName ( String tag , Node node ) {
if ( node . nodeName () . equals ( tag ) )
return ( Element ) node ;
else {
int size = node . childNodeSize () ;
for ( int i = 0 ; i < size ; i ++ ) {
Element found = findFirstElementByTagName ( tag , node . childNode ( i ) ) ;
if ( found != null )
return found ;
}
}
return null ;
}
@Override
public String outerHtml () {
return super . html () ;
}
@Override
public Element text ( String text ) {
body () . text ( text ) ;
return this ;
}
@Override
public String nodeName () {
return lr_7 ;
}
public void charset ( Charset charset ) {
updateMetaCharsetElement ( true ) ;
outputSettings . charset ( charset ) ;
ensureMetaCharsetElement () ;
}
public Charset charset () {
return outputSettings . charset () ;
}
public void updateMetaCharsetElement ( boolean update ) {
this . updateMetaCharset = update ;
}
public boolean updateMetaCharsetElement () {
return updateMetaCharset ;
}
@Override
public Document clone () {
Document clone = ( Document ) super . clone () ;
clone . outputSettings = this . outputSettings . clone () ;
return clone ;
}
private void ensureMetaCharsetElement () {
if ( updateMetaCharset ) {
OutputSettings . Syntax syntax = outputSettings () . syntax () ;
if ( syntax == OutputSettings . Syntax . html ) {
Element metaCharset = select ( lr_8 ) . first () ;
if ( metaCharset != null ) {
metaCharset . attr ( lr_9 , charset () . displayName () ) ;
} else {
Element head = head () ;
if ( head != null ) {
head . appendElement ( lr_10 ) . attr ( lr_9 , charset () . displayName () ) ;
}
}
select ( lr_11 ) . remove () ;
} else if ( syntax == OutputSettings . Syntax . xml ) {
Node node = childNodes () . get ( 0 ) ;
if ( node instanceof XmlDeclaration ) {
XmlDeclaration decl = ( XmlDeclaration ) node ;
if ( decl . name () . equals ( lr_12 ) ) {
decl . attr ( lr_13 , charset () . displayName () ) ;
final String version = decl . attr ( lr_14 ) ;
if ( version != null ) {
decl . attr ( lr_14 , lr_15 ) ;
}
} else {
decl = new XmlDeclaration ( lr_12 , false ) ;
decl . attr ( lr_14 , lr_15 ) ;
decl . attr ( lr_13 , charset () . displayName () ) ;
prependChild ( decl ) ;
}
} else {
XmlDeclaration decl = new XmlDeclaration ( lr_12 , false ) ;
decl . attr ( lr_14 , lr_15 ) ;
decl . attr ( lr_13 , charset () . displayName () ) ;
prependChild ( decl ) ;
}
}
}
}
public Entities . EscapeMode escapeMode () {
return escapeMode ;
}
public OutputSettings escapeMode ( Entities . EscapeMode escapeMode ) {
this . escapeMode = escapeMode ;
return this ;
}
public Charset charset () {
return charset ;
}
public OutputSettings charset ( Charset charset ) {
this . charset = charset ;
return this ;
}
public OutputSettings charset ( String charset ) {
charset ( Charset . forName ( charset ) ) ;
return this ;
}
CharsetEncoder prepareEncoder () {
CharsetEncoder encoder = charset . newEncoder () ;
encoderThreadLocal . set ( encoder ) ;
coreCharset = Entities . CoreCharset . byName ( encoder . charset () . name () ) ;
return encoder ;
}
CharsetEncoder encoder () {
CharsetEncoder encoder = encoderThreadLocal . get () ;
return encoder != null ? encoder : prepareEncoder () ;
}
public Syntax syntax () {
return syntax ;
}
public OutputSettings syntax ( Syntax syntax ) {
this . syntax = syntax ;
return this ;
}
public boolean prettyPrint () {
return prettyPrint ;
}
public OutputSettings prettyPrint ( boolean pretty ) {
prettyPrint = pretty ;
return this ;
}
public boolean outline () {
return outline ;
}
public OutputSettings outline ( boolean outlineMode ) {
outline = outlineMode ;
return this ;
}
public int indentAmount () {
return indentAmount ;
}
public OutputSettings indentAmount ( int indentAmount ) {
Validate . isTrue ( indentAmount >= 0 ) ;
this . indentAmount = indentAmount ;
return this ;
}
@Override
public OutputSettings clone () {
OutputSettings clone ;
try {
clone = ( OutputSettings ) super . clone () ;
} catch ( CloneNotSupportedException e ) {
throw new RuntimeException ( e ) ;
}
clone . charset ( charset . name () ) ;
clone . escapeMode = Entities . EscapeMode . valueOf ( escapeMode . name () ) ;
return clone ;
}
public OutputSettings outputSettings () {
return outputSettings ;
}
public Document outputSettings ( OutputSettings outputSettings ) {
Validate . notNull ( outputSettings ) ;
this . outputSettings = outputSettings ;
return this ;
}
public QuirksMode quirksMode () {
return quirksMode ;
}
public Document quirksMode ( QuirksMode quirksMode ) {
this . quirksMode = quirksMode ;
return this ;
}
public Parser parser () {
return parser ;
}
public Document parser ( Parser parser ) {
this . parser = parser ;
return this ;
}

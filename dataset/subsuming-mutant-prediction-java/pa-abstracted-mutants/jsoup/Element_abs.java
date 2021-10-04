protected List < Node > ensureChildNodes () {
if ( childNodes == EMPTY_NODES ) {
childNodes = new NodeList ( this , 4 ) ;
}
return childNodes ;
}
@Override
protected boolean hasAttributes () {
return attributes != null ;
}
@Override
public Attributes attributes () {
if ( ! hasAttributes () )
attributes = new Attributes () ;
return attributes ;
}
@Override
public String baseUri () {
return searchUpForAttribute ( this , baseUriKey ) ;
}
private static String searchUpForAttribute ( final Element start , final String key ) {
Element el = start ;
while ( el != null ) {
if ( el . hasAttributes () && el . attributes . hasKey ( key ) )
return el . attributes . get ( key ) ;
el = el . parent () ;
}
return lr_1 ;
}
@Override
protected void doSetBaseUri ( String baseUri ) {
attributes () . put ( baseUriKey , baseUri ) ;
}
@Override
public int childNodeSize () {
return childNodes . size () ;
}
@Override
public String nodeName () {
return tag . getName () ;
}
public String tagName () {
return tag . getName () ;
}
public String normalName () {
return tag . normalName () ;
}
public Element tagName ( String tagName ) {
Validate . notEmpty ( tagName , lr_2 ) ;
tag = Tag . valueOf ( tagName , NodeUtils . parser ( this ) . settings () ) ;
return this ;
}
public Tag tag () {
return tag ;
}
public boolean isBlock () {
return tag . isBlock () ;
}
public String id () {
return hasAttributes () ? attributes . getIgnoreCase ( lr_3 ) : lr_1 ;
}
public Element attr ( String attributeKey , String attributeValue ) {
super . attr ( attributeKey , attributeValue ) ;
return this ;
}
public Element attr ( String attributeKey , boolean attributeValue ) {
attributes () . put ( attributeKey , attributeValue ) ;
return this ;
}
public Map < String , String > dataset () {
return attributes () . dataset () ;
}
@Override
public final Element parent () {
return ( Element ) parentNode ;
}
public Elements parents () {
Elements parents = new Elements () ;
accumulateParents ( this , parents ) ;
return parents ;
}
private static void accumulateParents ( Element el , Elements parents ) {
Element parent = el . parent () ;
if ( parent != null && ! parent . tagName () . equals ( lr_4 ) ) {
parents . add ( parent ) ;
accumulateParents ( parent , parents ) ;
}
}
public Element child ( int index ) {
return childElementsList () . get ( index ) ;
}
public int childrenSize () {
return childElementsList () . size () ;
}
public Elements children () {
return new Elements ( childElementsList () ) ;
}
private List < Element > childElementsList () {
List < Element > children ;
if ( shadowChildrenRef == null || ( children = shadowChildrenRef . get () ) == null ) {
final int size = childNodes . size () ;
children = new ArrayList <> ( size ) ;
for ( int i = 0 ; i < size ; i ++ ) {
final Node node = childNodes . get ( i ) ;
if ( node instanceof Element )
children . add ( ( Element ) node ) ;
}
shadowChildrenRef = new WeakReference <> ( children ) ;
}
return children ;
}
@Override
void nodelistChanged () {
super . nodelistChanged () ;
shadowChildrenRef = null ;
}
public List < TextNode > textNodes () {
List < TextNode > textNodes = new ArrayList <> () ;
for ( Node node : childNodes ) {
if ( node instanceof TextNode )
textNodes . add ( ( TextNode ) node ) ;
}
return Collections . unmodifiableList ( textNodes ) ;
}
public List < DataNode > dataNodes () {
List < DataNode > dataNodes = new ArrayList <> () ;
for ( Node node : childNodes ) {
if ( node instanceof DataNode )
dataNodes . add ( ( DataNode ) node ) ;
}
return Collections . unmodifiableList ( dataNodes ) ;
}
public Elements select ( String cssQuery ) {
return Selector . select ( cssQuery , this ) ;
}
public Element selectFirst ( String cssQuery ) {
return Selector . selectFirst ( cssQuery , this ) ;
}
public boolean is ( String cssQuery ) {
return is ( QueryParser . parse ( cssQuery ) ) ;
}
public boolean is ( Evaluator evaluator ) {
return evaluator . matches ( ( Element ) this . root () , this ) ;
}
public Element appendChild ( Node child ) {
Validate . notNull ( child ) ;
reparentChild ( child ) ;
ensureChildNodes () ;
childNodes . add ( child ) ;
child . setSiblingIndex ( childNodes . size () - 1 ) ;
return this ;
}
public Element appendTo ( Element parent ) {
Validate . notNull ( parent ) ;
parent . appendChild ( this ) ;
return this ;
}
public Element prependChild ( Node child ) {
Validate . notNull ( child ) ;
addChildren ( 0 , child ) ;
return this ;
}
public Element insertChildren ( int index , Collection < ? extends Node > children ) {
Validate . notNull ( children , lr_5 ) ;
int currentSize = childNodeSize () ;
if ( index < 0 ) index += currentSize + 1 ;
Validate . isTrue ( index >= 0 && index <= currentSize , lr_6 ) ;
ArrayList < Node > nodes = new ArrayList <> ( children ) ;
Node [] nodeArray = nodes . toArray ( new Node [ 0 ] ) ;
addChildren ( index , nodeArray ) ;
return this ;
}
public Element insertChildren ( int index , Node ... children ) {
Validate . notNull ( children , lr_5 ) ;
int currentSize = childNodeSize () ;
if ( index < 0 ) index += currentSize + 1 ;
Validate . isTrue ( index >= 0 && index <= currentSize , lr_6 ) ;
addChildren ( index , children ) ;
return this ;
}
public Element appendElement ( String tagName ) {
Element child = new Element ( Tag . valueOf ( tagName , NodeUtils . parser ( this ) . settings () ) , baseUri () ) ;
appendChild ( child ) ;
return child ;
}
public Element prependElement ( String tagName ) {
Element child = new Element ( Tag . valueOf ( tagName , NodeUtils . parser ( this ) . settings () ) , baseUri () ) ;
prependChild ( child ) ;
return child ;
}
public Element appendText ( String text ) {
Validate . notNull ( text ) ;
TextNode node = new TextNode ( text ) ;
appendChild ( node ) ;
return this ;
}
public Element prependText ( String text ) {
Validate . notNull ( text ) ;
TextNode node = new TextNode ( text ) ;
prependChild ( node ) ;
return this ;
}
public Element append ( String html ) {
Validate . notNull ( html ) ;
List < Node > nodes = NodeUtils . parser ( this ) . parseFragmentInput ( html , this , baseUri () ) ;
addChildren ( nodes . toArray ( new Node [ 0 ] ) ) ;
return this ;
}
public Element prepend ( String html ) {
Validate . notNull ( html ) ;
List < Node > nodes = NodeUtils . parser ( this ) . parseFragmentInput ( html , this , baseUri () ) ;
addChildren ( 0 , nodes . toArray ( new Node [ 0 ] ) ) ;
return this ;
}
@Override
public Element before ( String html ) {
return ( Element ) super . before ( html ) ;
}
@Override
public Element before ( Node node ) {
return ( Element ) super . before ( node ) ;
}
@Override
public Element after ( String html ) {
return ( Element ) super . after ( html ) ;
}
@Override
public Element after ( Node node ) {
return ( Element ) super . after ( node ) ;
}
@Override
public Element empty () {
childNodes . clear () ;
return this ;
}
@Override
public Element wrap ( String html ) {
return ( Element ) super . wrap ( html ) ;
}
public String cssSelector () {
if ( id () . length () > 0 )
return lr_7 + id () ;
String tagName = tagName () . replace ( ':' , '|' ) ;
StringBuilder selector = new StringBuilder ( tagName ) ;
String classes = StringUtil . join ( classNames () , lr_8 ) ;
if ( classes . length () > 0 )
selector . append ( '.' ) . append ( classes ) ;
if ( parent () == null || parent () instanceof Document )
return selector . toString () ;
selector . insert ( 0 , lr_9 ) ;
if ( parent () . select ( selector . toString () ) . size () > 1 )
selector . append ( String . format (
lr_10 , elementSiblingIndex () + 1 ) ) ;
return parent () . cssSelector () + selector . toString () ;
}
public Elements siblingElements () {
if ( parentNode == null )
return new Elements ( 0 ) ;
List < Element > elements = parent () . childElementsList () ;
Elements siblings = new Elements ( elements . size () - 1 ) ;
for ( Element el : elements )
if ( el != this )
siblings . add ( el ) ;
return siblings ;
}
public Element nextElementSibling () {
if ( parentNode == null ) return null ;
List < Element > siblings = parent () . childElementsList () ;
int index = indexInList ( this , siblings ) ;
if ( siblings . size () > index + 1 )
return siblings . get ( index + 1 ) ;
else
return null ;
}
public Elements nextElementSiblings () {
return nextElementSiblings ( true ) ;
}
public Element previousElementSibling () {
if ( parentNode == null ) return null ;
List < Element > siblings = parent () . childElementsList () ;
int index = indexInList ( this , siblings ) ;
if ( index > 0 )
return siblings . get ( index - 1 ) ;
else
return null ;
}
public Elements previousElementSiblings () {
return nextElementSiblings ( false ) ;
}
private Elements nextElementSiblings ( boolean next ) {
Elements els = new Elements () ;
if ( parentNode == null )
return els ;
els . add ( this ) ;
return next ? els . nextAll () : els . prevAll () ;
}
public Element firstElementSibling () {
List < Element > siblings = parent () . childElementsList () ;
return siblings . size () > 1 ? siblings . get ( 0 ) : null ;
}
public int elementSiblingIndex () {
if ( parent () == null ) return 0 ;
return indexInList ( this , parent () . childElementsList () ) ;
}
public Element lastElementSibling () {
List < Element > siblings = parent () . childElementsList () ;
return siblings . size () > 1 ? siblings . get ( siblings . size () - 1 ) : null ;
}
private static < E extends Element > int indexInList ( Element search , List < E > elements ) {
final int size = elements . size () ;
for ( int i = 0 ; i < size ; i ++ ) {
if ( elements . get ( i ) == search )
return i ;
}
return 0 ;
}
public Elements getElementsByTag ( String tagName ) {
Validate . notEmpty ( tagName ) ;
tagName = normalize ( tagName ) ;
return Collector . collect ( new Evaluator . Tag ( tagName ) , this ) ;
}
public Element getElementById ( String id ) {
Validate . notEmpty ( id ) ;
Elements elements = Collector . collect ( new Evaluator . Id ( id ) , this ) ;
if ( elements . size () > 0 )
return elements . get ( 0 ) ;
else
return null ;
}
public Elements getElementsByClass ( String className ) {
Validate . notEmpty ( className ) ;
return Collector . collect ( new Evaluator . Class ( className ) , this ) ;
}
public Elements getElementsByAttribute ( String key ) {
Validate . notEmpty ( key ) ;
key = key . trim () ;
return Collector . collect ( new Evaluator . Attribute ( key ) , this ) ;
}
public Elements getElementsByAttributeStarting ( String keyPrefix ) {
Validate . notEmpty ( keyPrefix ) ;
keyPrefix = keyPrefix . trim () ;
return Collector . collect ( new Evaluator . AttributeStarting ( keyPrefix ) , this ) ;
}
public Elements getElementsByAttributeValue ( String key , String value ) {
return Collector . collect ( new Evaluator . AttributeWithValue ( key , value ) , this ) ;
}
public Elements getElementsByAttributeValueNot ( String key , String value ) {
return Collector . collect ( new Evaluator . AttributeWithValueNot ( key , value ) , this ) ;
}
public Elements getElementsByAttributeValueStarting ( String key , String valuePrefix ) {
return Collector . collect ( new Evaluator . AttributeWithValueStarting ( key , valuePrefix ) , this ) ;
}
public Elements getElementsByAttributeValueEnding ( String key , String valueSuffix ) {
return Collector . collect ( new Evaluator . AttributeWithValueEnding ( key , valueSuffix ) , this ) ;
}
public Elements getElementsByAttributeValueContaining ( String key , String match ) {
return Collector . collect ( new Evaluator . AttributeWithValueContaining ( key , match ) , this ) ;
}
public Elements getElementsByAttributeValueMatching ( String key , Pattern pattern ) {
return Collector . collect ( new Evaluator . AttributeWithValueMatching ( key , pattern ) , this ) ;
}
public Elements getElementsByAttributeValueMatching ( String key , String regex ) {
Pattern pattern ;
try {
pattern = Pattern . compile ( regex ) ;
} catch ( PatternSyntaxException e ) {
throw new IllegalArgumentException ( lr_11 + regex , e ) ;
}
return getElementsByAttributeValueMatching ( key , pattern ) ;
}
public Elements getElementsByIndexLessThan ( int index ) {
return Collector . collect ( new Evaluator . IndexLessThan ( index ) , this ) ;
}
public Elements getElementsByIndexGreaterThan ( int index ) {
return Collector . collect ( new Evaluator . IndexGreaterThan ( index ) , this ) ;
}
public Elements getElementsByIndexEquals ( int index ) {
return Collector . collect ( new Evaluator . IndexEquals ( index ) , this ) ;
}
public Elements getElementsContainingText ( String searchText ) {
return Collector . collect ( new Evaluator . ContainsText ( searchText ) , this ) ;
}
public Elements getElementsContainingOwnText ( String searchText ) {
return Collector . collect ( new Evaluator . ContainsOwnText ( searchText ) , this ) ;
}
public Elements getElementsMatchingText ( Pattern pattern ) {
return Collector . collect ( new Evaluator . Matches ( pattern ) , this ) ;
}
public Elements getElementsMatchingText ( String regex ) {
Pattern pattern ;
try {
pattern = Pattern . compile ( regex ) ;
} catch ( PatternSyntaxException e ) {
throw new IllegalArgumentException ( lr_11 + regex , e ) ;
}
return getElementsMatchingText ( pattern ) ;
}
public Elements getElementsMatchingOwnText ( Pattern pattern ) {
return Collector . collect ( new Evaluator . MatchesOwn ( pattern ) , this ) ;
}
public Elements getElementsMatchingOwnText ( String regex ) {
Pattern pattern ;
try {
pattern = Pattern . compile ( regex ) ;
} catch ( PatternSyntaxException e ) {
throw new IllegalArgumentException ( lr_11 + regex , e ) ;
}
return getElementsMatchingOwnText ( pattern ) ;
}
public Elements getAllElements () {
return Collector . collect ( new Evaluator . AllElements () , this ) ;
}
public void head ( Node node , int depth ) {
if ( node instanceof TextNode ) {
TextNode textNode = ( TextNode ) node ;
appendNormalisedText ( accum , textNode ) ;
} else if ( node instanceof Element ) {
Element element = ( Element ) node ;
if ( accum . length () > 0 &&
( element . isBlock () || element . tag . getName () . equals ( lr_12 ) ) &&
! TextNode . lastCharIsWhitespace ( accum ) )
accum . append ( ' ' ) ;
}
}
public void tail ( Node node , int depth ) {
if ( node instanceof Element ) {
Element element = ( Element ) node ;
if ( element . isBlock () && ( node . nextSibling () instanceof TextNode ) && ! TextNode . lastCharIsWhitespace ( accum ) )
accum . append ( ' ' ) ;
}
}
public void head ( Node node , int depth ) {
if ( node instanceof TextNode ) {
TextNode textNode = ( TextNode ) node ;
accum . append ( textNode . getWholeText () ) ;
}
}
public void tail ( Node node , int depth ) {
}
public String ownText () {
StringBuilder sb = StringUtil . borrowBuilder () ;
ownText ( sb ) ;
return StringUtil . releaseBuilder ( sb ) . trim () ;
}
private void ownText ( StringBuilder accum ) {
for ( Node child : childNodes ) {
if ( child instanceof TextNode ) {
TextNode textNode = ( TextNode ) child ;
appendNormalisedText ( accum , textNode ) ;
} else if ( child instanceof Element ) {
appendWhitespaceIfBr ( ( Element ) child , accum ) ;
}
}
}
private static void appendNormalisedText ( StringBuilder accum , TextNode textNode ) {
String text = textNode . getWholeText () ;
if ( preserveWhitespace ( textNode . parentNode ) || textNode instanceof CDataNode )
accum . append ( text ) ;
else
StringUtil . appendNormalisedWhitespace ( accum , text , TextNode . lastCharIsWhitespace ( accum ) ) ;
}
private static void appendWhitespaceIfBr ( Element element , StringBuilder accum ) {
if ( element . tag . getName () . equals ( lr_12 ) && ! TextNode . lastCharIsWhitespace ( accum ) )
accum . append ( lr_13 ) ;
}
static boolean preserveWhitespace ( Node node ) {
if ( node instanceof Element ) {
Element el = ( Element ) node ;
int i = 0 ;
do {
if ( el . tag . preserveWhitespace () )
return true ;
el = el . parent () ;
i ++ ;
} while ( i < 6 && el != null );
}
return false ;
}
public Element text ( String text ) {
Validate . notNull ( text ) ;
empty () ;
TextNode textNode = new TextNode ( text ) ;
appendChild ( textNode ) ;
return this ;
}
public boolean hasText () {
for ( Node child : childNodes ) {
if ( child instanceof TextNode ) {
TextNode textNode = ( TextNode ) child ;
if ( ! textNode . isBlank () )
return true ;
} else if ( child instanceof Element ) {
Element el = ( Element ) child ;
if ( el . hasText () )
return true ;
}
}
return false ;
}
public String data () {
StringBuilder sb = StringUtil . borrowBuilder () ;
for ( Node childNode : childNodes ) {
if ( childNode instanceof DataNode ) {
DataNode data = ( DataNode ) childNode ;
sb . append ( data . getWholeData () ) ;
} else if ( childNode instanceof Comment ) {
Comment comment = ( Comment ) childNode ;
sb . append ( comment . getData () ) ;
} else if ( childNode instanceof Element ) {
Element element = ( Element ) childNode ;
String elementData = element . data () ;
sb . append ( elementData ) ;
} else if ( childNode instanceof CDataNode ) {
CDataNode cDataNode = ( CDataNode ) childNode ;
sb . append ( cDataNode . getWholeText () ) ;
}
}
return StringUtil . releaseBuilder ( sb ) ;
}
public String className () {
return attr ( lr_14 ) . trim () ;
}
public Set < String > classNames () {
String [] names = classSplit . split ( className () ) ;
Set < String > classNames = new LinkedHashSet <> ( Arrays . asList ( names ) ) ;
classNames . remove ( lr_1 ) ;
return classNames ;
}
public Element classNames ( Set < String > classNames ) {
Validate . notNull ( classNames ) ;
if ( classNames . isEmpty () ) {
attributes () . remove ( lr_14 ) ;
} else {
attributes () . put ( lr_14 , StringUtil . join ( classNames , lr_13 ) ) ;
}
return this ;
}
public boolean hasClass ( String className ) {
if ( ! hasAttributes () )
return false ;
final String classAttr = attributes . getIgnoreCase ( lr_14 ) ;
final int len = classAttr . length () ;
final int wantLen = className . length () ;
if ( len == 0 || len < wantLen ) {
return false ;
}
if ( len == wantLen ) {
return className . equalsIgnoreCase ( classAttr ) ;
}
boolean inClass = false ;
int start = 0 ;
for ( int i = 0 ; i < len ; i ++ ) {
if ( Character . isWhitespace ( classAttr . charAt ( i ) ) ) {
if ( inClass ) {
if ( i - start == wantLen && classAttr . regionMatches ( true , start , className , 0 , wantLen ) ) {
return true ;
}
inClass = false ;
}
} else {
if ( ! inClass ) {
inClass = true ;
start = i ;
}
}
}
if ( inClass && len - start == wantLen ) {
return classAttr . regionMatches ( true , start , className , 0 , wantLen ) ;
}
return false ;
}
public Element addClass ( String className ) {
Validate . notNull ( className ) ;
Set < String > classes = classNames () ;
classes . add ( className ) ;
classNames ( classes ) ;
return this ;
}
public Element removeClass ( String className ) {
Validate . notNull ( className ) ;
Set < String > classes = classNames () ;
classes . remove ( className ) ;
classNames ( classes ) ;
return this ;
}
public Element toggleClass ( String className ) {
Validate . notNull ( className ) ;
Set < String > classes = classNames () ;
if ( classes . contains ( className ) )
classes . remove ( className ) ;
else
classes . add ( className ) ;
classNames ( classes ) ;
return this ;
}
public String val () {
if ( tagName () . equals ( lr_15 ) )
return text () ;
else
return attr ( lr_16 ) ;
}
public Element val ( String value ) {
if ( tagName () . equals ( lr_15 ) )
text ( value ) ;
else
attr ( lr_16 , value ) ;
return this ;
}
void outerHtmlHead ( final Appendable accum , int depth , final Document . OutputSettings out ) throws IOException {
if ( out . prettyPrint () && isFormatAsBlock ( out ) && ! isInlineable ( out ) ) {
if ( accum instanceof StringBuilder ) {
if ( ( ( StringBuilder ) accum ) . length () > 0 )
indent ( accum , depth , out ) ;
} else {
indent ( accum , depth , out ) ;
}
}
accum . append ( '<' ) . append ( tagName () ) ;
if ( attributes != null ) attributes . html ( accum , out ) ;
if ( childNodes . isEmpty () && tag . isSelfClosing () ) {
if ( out . syntax () == Document . OutputSettings . Syntax . html && tag . isEmpty () )
accum . append ( '>' ) ;
else
accum . append ( lr_17 ) ;
}
else
accum . append ( '>' ) ;
}
void outerHtmlTail ( Appendable accum , int depth , Document . OutputSettings out ) throws IOException {
if ( ! ( childNodes . isEmpty () && tag . isSelfClosing () ) ) {
if ( out . prettyPrint () && ( ! childNodes . isEmpty () && (
tag . formatAsBlock () || ( out . outline () && ( childNodes . size () > 1 || ( childNodes . size () == 1 && ! ( childNodes . get ( 0 ) instanceof TextNode ) ) ) )
) ) )
indent ( accum , depth , out ) ;
accum . append ( lr_18 ) . append ( tagName () ) . append ( '>' ) ;
}
}
public String html () {
StringBuilder accum = StringUtil . borrowBuilder () ;
html ( accum ) ;
String html = StringUtil . releaseBuilder ( accum ) ;
return NodeUtils . outputSettings ( this ) . prettyPrint () ? html . trim () : html ;
}
@Override
public < T extends Appendable > T html ( T appendable ) {
final int size = childNodes . size () ;
for ( int i = 0 ; i < size ; i ++ )
childNodes . get ( i ) . outerHtml ( appendable ) ;
return appendable ;
}
public Element html ( String html ) {
empty () ;
append ( html ) ;
return this ;
}
@Override
public Element clone () {
return ( Element ) super . clone () ;
}
@Override
public Element shallowClone () {
return new Element ( tag , baseUri () , attributes == null ? null : attributes . clone () ) ;
}
@Override
protected Element doClone ( Node parent ) {
Element clone = ( Element ) super . doClone ( parent ) ;
clone . attributes = attributes != null ? attributes . clone () : null ;
clone . childNodes = new NodeList ( clone , childNodes . size () ) ;
clone . childNodes . addAll ( childNodes ) ;
clone . setBaseUri ( baseUri () ) ;
return clone ;
}
@Override
public Element clearAttributes () {
if ( attributes != null ) {
super . clearAttributes () ;
attributes = null ;
}
return this ;
}
@Override
public Element removeAttr ( String attributeKey ) {
return ( Element ) super . removeAttr ( attributeKey ) ;
}
@Override
public Element root () {
return ( Element ) super . root () ;
}
@Override
public Element traverse ( NodeVisitor nodeVisitor ) {
return ( Element ) super . traverse ( nodeVisitor ) ;
}
@Override
public Element filter ( NodeFilter nodeFilter ) {
return ( Element ) super . filter ( nodeFilter ) ;
}
public void onContentsChanged () {
owner . nodelistChanged () ;
}
private boolean isFormatAsBlock ( Document . OutputSettings out ) {
return tag . formatAsBlock () || ( parent () != null && parent () . tag () . formatAsBlock () ) || out . outline () ;
}
private boolean isInlineable ( Document . OutputSettings out ) {
return tag () . isInline ()
&& ! tag () . isEmpty ()
&& parent () . isBlock ()
&& previousSibling () != null
&& ! out . outline () ;
}

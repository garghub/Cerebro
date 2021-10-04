public boolean hasParent () {
return parentNode != null ;
}
public String attr ( String attributeKey ) {
Validate . notNull ( attributeKey ) ;
if ( ! hasAttributes () )
return EmptyString ;
String val = attributes () . getIgnoreCase ( attributeKey ) ;
if ( val . length () > 0 )
return val ;
else if ( attributeKey . startsWith ( lr_1 ) )
return absUrl ( attributeKey . substring ( lr_1 . length () ) ) ;
else return lr_2 ;
}
public Node attr ( String attributeKey , String attributeValue ) {
attributeKey = NodeUtils . parser ( this ) . settings () . normalizeAttribute ( attributeKey ) ;
attributes () . putIgnoreCase ( attributeKey , attributeValue ) ;
return this ;
}
public boolean hasAttr ( String attributeKey ) {
Validate . notNull ( attributeKey ) ;
if ( attributeKey . startsWith ( lr_1 ) ) {
String key = attributeKey . substring ( lr_1 . length () ) ;
if ( attributes () . hasKeyIgnoreCase ( key ) && ! absUrl ( key ) . equals ( lr_2 ) )
return true ;
}
return attributes () . hasKeyIgnoreCase ( attributeKey ) ;
}
public Node removeAttr ( String attributeKey ) {
Validate . notNull ( attributeKey ) ;
attributes () . removeIgnoreCase ( attributeKey ) ;
return this ;
}
public Node clearAttributes () {
Iterator < Attribute > it = attributes () . iterator () ;
while ( it . hasNext () ) {
it . next () ;
it . remove () ;
}
return this ;
}
public void setBaseUri ( final String baseUri ) {
Validate . notNull ( baseUri ) ;
doSetBaseUri ( baseUri ) ;
}
public String absUrl ( String attributeKey ) {
Validate . notEmpty ( attributeKey ) ;
if ( ! hasAttr ( attributeKey ) ) {
return lr_2 ;
} else {
return StringUtil . resolve ( baseUri () , attr ( attributeKey ) ) ;
}
}
public Node childNode ( int index ) {
return ensureChildNodes () . get ( index ) ;
}
public List < Node > childNodes () {
return Collections . unmodifiableList ( ensureChildNodes () ) ;
}
public List < Node > childNodesCopy () {
final List < Node > nodes = ensureChildNodes () ;
final ArrayList < Node > children = new ArrayList <> ( nodes . size () ) ;
for ( Node node : nodes ) {
children . add ( node . clone () ) ;
}
return children ;
}
protected Node [] childNodesAsArray () {
return ensureChildNodes () . toArray ( new Node [ 0 ] ) ;
}
public Node parent () {
return parentNode ;
}
public final Node parentNode () {
return parentNode ;
}
public Node root () {
Node node = this ;
while ( node . parentNode != null )
node = node . parentNode ;
return node ;
}
public Document ownerDocument () {
Node root = root () ;
return ( root instanceof Document ) ? ( Document ) root : null ;
}
public void remove () {
Validate . notNull ( parentNode ) ;
parentNode . removeChild ( this ) ;
}
public Node before ( String html ) {
addSiblingHtml ( siblingIndex , html ) ;
return this ;
}
public Node before ( Node node ) {
Validate . notNull ( node ) ;
Validate . notNull ( parentNode ) ;
parentNode . addChildren ( siblingIndex , node ) ;
return this ;
}
public Node after ( String html ) {
addSiblingHtml ( siblingIndex + 1 , html ) ;
return this ;
}
public Node after ( Node node ) {
Validate . notNull ( node ) ;
Validate . notNull ( parentNode ) ;
parentNode . addChildren ( siblingIndex + 1 , node ) ;
return this ;
}
private void addSiblingHtml ( int index , String html ) {
Validate . notNull ( html ) ;
Validate . notNull ( parentNode ) ;
Element context = parent () instanceof Element ? ( Element ) parent () : null ;
List < Node > nodes = NodeUtils . parser ( this ) . parseFragmentInput ( html , context , baseUri () ) ;
parentNode . addChildren ( index , nodes . toArray ( new Node [ 0 ] ) ) ;
}
public Node wrap ( String html ) {
Validate . notEmpty ( html ) ;
Element context = parent () instanceof Element ? ( Element ) parent () : null ;
List < Node > wrapChildren = NodeUtils . parser ( this ) . parseFragmentInput ( html , context , baseUri () ) ;
Node wrapNode = wrapChildren . get ( 0 ) ;
if ( ! ( wrapNode instanceof Element ) )
return null ;
Element wrap = ( Element ) wrapNode ;
Element deepest = getDeepChild ( wrap ) ;
parentNode . replaceChild ( this , wrap ) ;
deepest . addChildren ( this ) ;
if ( wrapChildren . size () > 0 ) {
for ( int i = 0 ; i < wrapChildren . size () ; i ++ ) {
Node remainder = wrapChildren . get ( i ) ;
remainder . parentNode . removeChild ( remainder ) ;
wrap . appendChild ( remainder ) ;
}
}
return this ;
}
public Node unwrap () {
Validate . notNull ( parentNode ) ;
final List < Node > childNodes = ensureChildNodes () ;
Node firstChild = childNodes . size () > 0 ? childNodes . get ( 0 ) : null ;
parentNode . addChildren ( siblingIndex , this . childNodesAsArray () ) ;
this . remove () ;
return firstChild ;
}
private Element getDeepChild ( Element el ) {
List < Element > children = el . children () ;
if ( children . size () > 0 )
return getDeepChild ( children . get ( 0 ) ) ;
else
return el ;
}
void nodelistChanged () {
}
public void replaceWith ( Node in ) {
Validate . notNull ( in ) ;
Validate . notNull ( parentNode ) ;
parentNode . replaceChild ( this , in ) ;
}
protected void setParentNode ( Node parentNode ) {
Validate . notNull ( parentNode ) ;
if ( this . parentNode != null )
this . parentNode . removeChild ( this ) ;
this . parentNode = parentNode ;
}
protected void replaceChild ( Node out , Node in ) {
Validate . isTrue ( out . parentNode == this ) ;
Validate . notNull ( in ) ;
if ( in . parentNode != null )
in . parentNode . removeChild ( in ) ;
final int index = out . siblingIndex ;
ensureChildNodes () . set ( index , in ) ;
in . parentNode = this ;
in . setSiblingIndex ( index ) ;
out . parentNode = null ;
}
protected void removeChild ( Node out ) {
Validate . isTrue ( out . parentNode == this ) ;
final int index = out . siblingIndex ;
ensureChildNodes () . remove ( index ) ;
reindexChildren ( index ) ;
out . parentNode = null ;
}
protected void addChildren ( Node ... children ) {
final List < Node > nodes = ensureChildNodes () ;
for ( Node child : children ) {
reparentChild ( child ) ;
nodes . add ( child ) ;
child . setSiblingIndex ( nodes . size () - 1 ) ;
}
}
protected void addChildren ( int index , Node ... children ) {
Validate . notNull ( children ) ;
if ( children . length == 0 ) {
return;
}
final List < Node > nodes = ensureChildNodes () ;
final Node firstParent = children [ 0 ] . parent () ;
if ( firstParent != null && firstParent . childNodeSize () == children . length ) {
boolean sameList = true ;
final List < Node > firstParentNodes = firstParent . childNodes () ;
int i = children . length ;
while ( i -- > 0 ) {
if ( children [ i ] != firstParentNodes . get ( i ) ) {
sameList = false ;
break;
}
}
firstParent . empty () ;
nodes . addAll ( index , Arrays . asList ( children ) ) ;
i = children . length ;
while ( i -- > 0 ) {
children [ i ] . parentNode = this ;
}
reindexChildren ( index ) ;
return;
}
Validate . noNullElements ( children ) ;
for ( Node child : children ) {
reparentChild ( child ) ;
}
nodes . addAll ( index , Arrays . asList ( children ) ) ;
reindexChildren ( index ) ;
}
protected void reparentChild ( Node child ) {
child . setParentNode ( this ) ;
}
private void reindexChildren ( int start ) {
final List < Node > childNodes = ensureChildNodes () ;
for ( int i = start ; i < childNodes . size () ; i ++ ) {
childNodes . get ( i ) . setSiblingIndex ( i ) ;
}
}
public List < Node > siblingNodes () {
if ( parentNode == null )
return Collections . emptyList () ;
List < Node > nodes = parentNode . ensureChildNodes () ;
List < Node > siblings = new ArrayList <> ( nodes . size () - 1 ) ;
for ( Node node : nodes )
if ( node != this )
siblings . add ( node ) ;
return siblings ;
}
public Node nextSibling () {
if ( parentNode == null )
return null ;
final List < Node > siblings = parentNode . ensureChildNodes () ;
final int index = siblingIndex + 1 ;
if ( siblings . size () > index )
return siblings . get ( index ) ;
else
return null ;
}
public Node previousSibling () {
if ( parentNode == null )
return null ;
if ( siblingIndex > 0 )
return parentNode . ensureChildNodes () . get ( siblingIndex - 1 ) ;
else
return null ;
}
public int siblingIndex () {
return siblingIndex ;
}
protected void setSiblingIndex ( int siblingIndex ) {
this . siblingIndex = siblingIndex ;
}
public Node traverse ( NodeVisitor nodeVisitor ) {
Validate . notNull ( nodeVisitor ) ;
NodeTraversor . traverse ( nodeVisitor , this ) ;
return this ;
}
public Node filter ( NodeFilter nodeFilter ) {
Validate . notNull ( nodeFilter ) ;
NodeTraversor . filter ( nodeFilter , this ) ;
return this ;
}
public String outerHtml () {
StringBuilder accum = StringUtil . borrowBuilder () ;
outerHtml ( accum ) ;
return StringUtil . releaseBuilder ( accum ) ;
}
protected void outerHtml ( Appendable accum ) {
NodeTraversor . traverse ( new OuterHtmlVisitor ( accum , NodeUtils . outputSettings ( this ) ) , this ) ;
}
public < T extends Appendable > T html ( T appendable ) {
outerHtml ( appendable ) ;
return appendable ;
}
public String toString () {
return outerHtml () ;
}
protected void indent ( Appendable accum , int depth , Document . OutputSettings out ) throws IOException {
accum . append ( '\n' ) . append ( StringUtil . padding ( depth * out . indentAmount () ) ) ;
}
@Override
public boolean equals ( Object o ) {
return this == o ;
}
public boolean hasSameValue ( Object o ) {
if ( this == o ) return true ;
if ( o == null || getClass () != o . getClass () ) return false ;
return this . outerHtml () . equals ( ( ( Node ) o ) . outerHtml () ) ;
}
@Override
public Node clone () {
Node thisClone = doClone ( null ) ;
final LinkedList < Node > nodesToProcess = new LinkedList <> () ;
nodesToProcess . add ( thisClone ) ;
while ( ! nodesToProcess . isEmpty () ) {
Node currParent = nodesToProcess . remove () ;
final int size = currParent . childNodeSize () ;
for ( int i = 0 ; i < size ; i ++ ) {
final List < Node > childNodes = currParent . ensureChildNodes () ;
Node childClone = childNodes . get ( i ) . doClone ( currParent ) ;
childNodes . set ( i , childClone ) ;
nodesToProcess . add ( childClone ) ;
}
}
return thisClone ;
}
public Node shallowClone () {
return doClone ( null ) ;
}
protected Node doClone ( Node parent ) {
Node clone ;
try {
clone = ( Node ) super . clone () ;
} catch ( CloneNotSupportedException e ) {
throw new RuntimeException ( e ) ;
}
clone . parentNode = parent ;
clone . siblingIndex = parent == null ? 0 : siblingIndex ;
return clone ;
}
public void head ( Node node , int depth ) {
try {
node . outerHtmlHead ( accum , depth , out ) ;
} catch ( IOException exception ) {
throw new SerializationException ( exception ) ;
}
}
public void tail ( Node node , int depth ) {
if ( ! node . nodeName () . equals ( lr_3 ) ) {
try {
node . outerHtmlTail ( accum , depth , out ) ;
} catch ( IOException exception ) {
throw new SerializationException ( exception ) ;
}
}
}

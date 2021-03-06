public static Document convert ( org . jsoup . nodes . Document in ) {
return ( new W3CDom () . fromJsoup ( in ) ) ;
}
public static String asString ( Document doc , Map < String , String > properties ) {
try {
DOMSource domSource = new DOMSource ( doc ) ;
StringWriter writer = new StringWriter () ;
StreamResult result = new StreamResult ( writer ) ;
TransformerFactory tf = TransformerFactory . newInstance () ;
Transformer transformer = tf . newTransformer () ;
if ( properties != null )
transformer . setOutputProperties ( propertiesFromMap ( properties ) ) ;
if ( doc . getDoctype () != null ) {
DocumentType doctype = doc . getDoctype () ;
if ( ! StringUtil . isBlank ( doctype . getPublicId () ) )
transformer . setOutputProperty ( OutputKeys . DOCTYPE_PUBLIC , doctype . getPublicId () ) ;
if ( ! StringUtil . isBlank ( doctype . getSystemId () ) )
transformer . setOutputProperty ( OutputKeys . DOCTYPE_SYSTEM , doctype . getSystemId () ) ;
else if ( doctype . getName () . equalsIgnoreCase ( lr_1 )
&& StringUtil . isBlank ( doctype . getPublicId () )
&& StringUtil . isBlank ( doctype . getSystemId () ) )
transformer . setOutputProperty ( OutputKeys . DOCTYPE_SYSTEM , lr_2 ) ;
}
transformer . transform ( domSource , result ) ;
return writer . toString () ;
} catch ( TransformerException e ) {
throw new IllegalStateException ( e ) ;
}
}
static Properties propertiesFromMap ( Map < String , String > map ) {
Properties props = new Properties () ;
props . putAll ( map ) ;
return props ;
}
public static HashMap < String , String > OutputHtml () {
return methodMap ( lr_1 ) ;
}
public static HashMap < String , String > OutputXml () {
return methodMap ( lr_3 ) ;
}
private static HashMap < String , String > methodMap ( String method ) {
HashMap < String , String > map = new HashMap <> () ;
map . put ( METHOD , method ) ;
return map ;
}
public Document fromJsoup ( org . jsoup . nodes . Document in ) {
Validate . notNull ( in ) ;
DocumentBuilder builder ;
try {
builder = factory . newDocumentBuilder () ;
DOMImplementation impl = builder . getDOMImplementation () ;
Document out ;
out = builder . newDocument () ;
org . jsoup . nodes . DocumentType doctype = in . documentType () ;
if ( doctype != null ) {
org . w3c . dom . DocumentType documentType = impl . createDocumentType ( doctype . name () , doctype . publicId () , doctype . systemId () ) ;
out . appendChild ( documentType ) ;
}
out . setXmlStandalone ( true ) ;
convert ( in , out ) ;
return out ;
} catch ( ParserConfigurationException e ) {
throw new IllegalStateException ( e ) ;
}
}
public void convert ( org . jsoup . nodes . Document in , Document out ) {
if ( ! StringUtil . isBlank ( in . location () ) )
out . setDocumentURI ( in . location () ) ;
org . jsoup . nodes . Element rootEl = in . child ( 0 ) ;
NodeTraversor . traverse ( new W3CBuilder ( out ) , rootEl ) ;
}
public String asString ( Document doc ) {
return asString ( doc , null ) ;
}
public void head ( org . jsoup . nodes . Node source , int depth ) {
namespacesStack . push ( new HashMap <> ( namespacesStack . peek () ) ) ;
if ( source instanceof org . jsoup . nodes . Element ) {
org . jsoup . nodes . Element sourceEl = ( org . jsoup . nodes . Element ) source ;
String prefix = updateNamespaces ( sourceEl ) ;
String namespace = namespacesStack . peek () . get ( prefix ) ;
String tagName = sourceEl . tagName () ;
Element el = namespace == null && tagName . contains ( lr_4 ) ?
doc . createElementNS ( lr_5 , tagName ) :
doc . createElementNS ( namespace , tagName ) ;
copyAttributes ( sourceEl , el ) ;
if ( dest == null ) {
doc . appendChild ( el ) ;
} else {
dest . appendChild ( el ) ;
}
dest = el ;
} else if ( source instanceof org . jsoup . nodes . TextNode ) {
org . jsoup . nodes . TextNode sourceText = ( org . jsoup . nodes . TextNode ) source ;
Text text = doc . createTextNode ( sourceText . getWholeText () ) ;
dest . appendChild ( text ) ;
} else if ( source instanceof org . jsoup . nodes . Comment ) {
org . jsoup . nodes . Comment sourceComment = ( org . jsoup . nodes . Comment ) source ;
Comment comment = doc . createComment ( sourceComment . getData () ) ;
dest . appendChild ( comment ) ;
} else if ( source instanceof org . jsoup . nodes . DataNode ) {
org . jsoup . nodes . DataNode sourceData = ( org . jsoup . nodes . DataNode ) source ;
Text node = doc . createTextNode ( sourceData . getWholeData () ) ;
dest . appendChild ( node ) ;
} else {
}
}
public void tail ( org . jsoup . nodes . Node source , int depth ) {
if ( source instanceof org . jsoup . nodes . Element && dest . getParentNode () instanceof Element ) {
dest = ( Element ) dest . getParentNode () ;
}
namespacesStack . pop () ;
}
private void copyAttributes ( org . jsoup . nodes . Node source , Element el ) {
for ( Attribute attribute : source . attributes () ) {
String key = attribute . getKey () . replaceAll ( lr_6 , lr_5 ) ;
if ( key . matches ( lr_7 ) )
el . setAttribute ( key , attribute . getValue () ) ;
}
}
private String updateNamespaces ( org . jsoup . nodes . Element el ) {
Attributes attributes = el . attributes () ;
for ( Attribute attr : attributes ) {
String key = attr . getKey () ;
String prefix ;
if ( key . equals ( xmlnsKey ) ) {
prefix = lr_5 ;
} else if ( key . startsWith ( xmlnsPrefix ) ) {
prefix = key . substring ( xmlnsPrefix . length () ) ;
} else {
continue;
}
namespacesStack . peek () . put ( prefix , attr . getValue () ) ;
}
int pos = el . tagName () . indexOf ( lr_4 ) ;
return pos > 0 ? el . tagName () . substring ( 0 , pos ) : lr_5 ;
}

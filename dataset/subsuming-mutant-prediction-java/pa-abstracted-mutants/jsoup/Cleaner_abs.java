public Document clean ( Document dirtyDocument ) {
Validate . notNull ( dirtyDocument ) ;
Document clean = Document . createShell ( dirtyDocument . baseUri () ) ;
if ( dirtyDocument . body () != null )
copySafeNodes ( dirtyDocument . body () , clean . body () ) ;
return clean ;
}
public boolean isValid ( Document dirtyDocument ) {
Validate . notNull ( dirtyDocument ) ;
Document clean = Document . createShell ( dirtyDocument . baseUri () ) ;
int numDiscarded = copySafeNodes ( dirtyDocument . body () , clean . body () ) ;
return numDiscarded == 0
&& dirtyDocument . head () . childNodes () . isEmpty () ;
}
public boolean isValidBodyHtml ( String bodyHtml ) {
Document clean = Document . createShell ( lr_1 ) ;
Document dirty = Document . createShell ( lr_1 ) ;
ParseErrorList errorList = ParseErrorList . tracking ( 1 ) ;
List < Node > nodes = Parser . parseFragment ( bodyHtml , dirty . body () , lr_1 , errorList ) ;
dirty . body () . insertChildren ( 0 , nodes ) ;
int numDiscarded = copySafeNodes ( dirty . body () , clean . body () ) ;
return numDiscarded == 0 && errorList . isEmpty () ;
}
public void head ( Node source , int depth ) {
if ( source instanceof Element ) {
Element sourceEl = ( Element ) source ;
if ( whitelist . isSafeTag ( sourceEl . tagName () ) ) {
ElementMeta meta = createSafeElement ( sourceEl ) ;
Element destChild = meta . el ;
destination . appendChild ( destChild ) ;
numDiscarded += meta . numAttribsDiscarded ;
destination = destChild ;
} else if ( source != root ) {
numDiscarded ++ ;
}
} else if ( source instanceof TextNode ) {
TextNode sourceText = ( TextNode ) source ;
TextNode destText = new TextNode ( sourceText . getWholeText () ) ;
destination . appendChild ( destText ) ;
} else if ( source instanceof DataNode && whitelist . isSafeTag ( source . parent () . nodeName () ) ) {
DataNode sourceData = ( DataNode ) source ;
DataNode destData = new DataNode ( sourceData . getWholeData () ) ;
destination . appendChild ( destData ) ;
} else {
numDiscarded ++ ;
}
}
public void tail ( Node source , int depth ) {
if ( source instanceof Element && whitelist . isSafeTag ( source . nodeName () ) ) {
destination = destination . parent () ;
}
}
private int copySafeNodes ( Element source , Element dest ) {
CleaningVisitor cleaningVisitor = new CleaningVisitor ( source , dest ) ;
NodeTraversor . traverse ( cleaningVisitor , source ) ;
return cleaningVisitor . numDiscarded ;
}
private ElementMeta createSafeElement ( Element sourceEl ) {
String sourceTag = sourceEl . tagName () ;
Attributes destAttrs = new Attributes () ;
Element dest = new Element ( Tag . valueOf ( sourceTag ) , sourceEl . baseUri () , destAttrs ) ;
int numDiscarded = 0 ;
Attributes sourceAttrs = sourceEl . attributes () ;
for ( Attribute sourceAttr : sourceAttrs ) {
if ( whitelist . isSafeAttribute ( sourceTag , sourceEl , sourceAttr ) )
destAttrs . put ( sourceAttr ) ;
else
numDiscarded ++ ;
}
Attributes enforcedAttrs = whitelist . getEnforcedAttributes ( sourceTag ) ;
destAttrs . addAll ( enforcedAttrs ) ;
return new ElementMeta ( dest , numDiscarded ) ;
}

public String nodeName () {
return lr_1 ;
}
public String name () {
return coreValue () ;
}
public String getWholeDeclaration () {
StringBuilder sb = StringUtil . borrowBuilder () ;
try {
getWholeDeclaration ( sb , new Document . OutputSettings () ) ;
} catch ( IOException e ) {
throw new SerializationException ( e ) ;
}
return StringUtil . releaseBuilder ( sb ) . trim () ;
}
private void getWholeDeclaration ( Appendable accum , Document . OutputSettings out ) throws IOException {
for ( Attribute attribute : attributes () ) {
if ( ! attribute . getKey () . equals ( nodeName () ) ) {
accum . append ( ' ' ) ;
attribute . html ( accum , out ) ;
}
}
}
void outerHtmlHead ( Appendable accum , int depth , Document . OutputSettings out ) throws IOException {
accum
. append ( lr_2 )
. append ( isProcessingInstruction ? lr_3 : lr_4 )
. append ( coreValue () ) ;
getWholeDeclaration ( accum , out ) ;
accum
. append ( isProcessingInstruction ? lr_3 : lr_4 )
. append ( lr_5 ) ;
}
void outerHtmlTail ( Appendable accum , int depth , Document . OutputSettings out ) {
}
@Override
public String toString () {
return outerHtml () ;
}
@Override
public XmlDeclaration clone () {
return ( XmlDeclaration ) super . clone () ;
}

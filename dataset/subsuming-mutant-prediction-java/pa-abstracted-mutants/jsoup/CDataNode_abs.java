@Override
public String nodeName () {
return lr_1 ;
}
@Override
public String text () {
return getWholeText () ;
}
@Override
void outerHtmlHead ( Appendable accum , int depth , Document . OutputSettings out ) throws IOException {
accum
. append ( lr_2 )
. append ( getWholeText () ) ;
}
@Override
void outerHtmlTail ( Appendable accum , int depth , Document . OutputSettings out ) {
try {
accum . append ( lr_3 ) ;
} catch ( IOException e ) {
throw new UncheckedIOException ( e ) ;
}
}
@Override
public CDataNode clone () {
return ( CDataNode ) super . clone () ;
}

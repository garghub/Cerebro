public String nodeName () {
return lr_1 ;
}
public String getWholeData () {
return coreValue () ;
}
public DataNode setWholeData ( String data ) {
coreValue ( data ) ;
return this ;
}
void outerHtmlHead ( Appendable accum , int depth , Document . OutputSettings out ) throws IOException {
accum . append ( getWholeData () ) ;
}
void outerHtmlTail ( Appendable accum , int depth , Document . OutputSettings out ) {}
@Override
public String toString () {
return outerHtml () ;
}
@Override
public DataNode clone () {
return ( DataNode ) super . clone () ;
}
public static DataNode createFromEncoded ( String encodedData , String baseUri ) {
String data = Entities . unescape ( encodedData ) ;
return new DataNode ( data ) ;
}

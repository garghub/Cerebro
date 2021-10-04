public String getEncoding () {
return encoding ;
}
public String getDefaultEncoding () {
return defaultEncoding ;
}
@Override
public void close () throws IOException {
if ( writer == null ) {
encoding = defaultEncoding ;
writer = new OutputStreamWriter ( out , encoding ) ;
writer . write ( xmlPrologWriter . toString () ) ;
}
writer . close () ;
}
@Override
public void flush () throws IOException {
if ( writer != null ) {
writer . flush () ;
}
}
private void detectEncoding ( final char [] cbuf , final int off , final int len )
throws IOException {
int size = len ;
final StringBuffer xmlProlog = xmlPrologWriter . getBuffer () ;
if ( xmlProlog . length () + len > BUFFER_SIZE ) {
size = BUFFER_SIZE - xmlProlog . length () ;
}
xmlPrologWriter . write ( cbuf , off , size ) ;
if ( xmlProlog . length () >= 5 ) {
if ( xmlProlog . substring ( 0 , 5 ) . equals ( lr_1 ) ) {
final int xmlPrologEnd = xmlProlog . indexOf ( lr_2 ) ;
if ( xmlPrologEnd > 0 ) {
final Matcher m = ENCODING_PATTERN . matcher ( xmlProlog . substring ( 0 ,
xmlPrologEnd ) ) ;
if ( m . find () ) {
encoding = m . group ( 1 ) . toUpperCase ( Locale . ROOT ) ;
encoding = encoding . substring ( 1 , encoding . length () - 1 ) ;
} else {
encoding = defaultEncoding ;
}
} else {
if ( xmlProlog . length () >= BUFFER_SIZE ) {
encoding = defaultEncoding ;
}
}
} else {
encoding = defaultEncoding ;
}
if ( encoding != null ) {
xmlPrologWriter = null ;
writer = new OutputStreamWriter ( out , encoding ) ;
writer . write ( xmlProlog . toString () ) ;
if ( len > size ) { MST[rv.ROR2Mutator]MSP[N]
writer . write ( cbuf , off + size , len - size ) ;
}
}
}
}
@Override
public void write ( final char [] cbuf , final int off , final int len ) throws IOException {
if ( xmlPrologWriter != null ) {
detectEncoding ( cbuf , off , len ) ;
} else {
writer . write ( cbuf , off , len ) ;
}
}

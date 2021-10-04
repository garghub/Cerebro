public String getDefaultEncoding () {
return defaultEncoding ;
}
public String getEncoding () {
return encoding ;
}
@Override
public int read ( final char [] buf , final int offset , final int len ) throws IOException {
return reader . read ( buf , offset , len ) ;
}
@Override
public void close () throws IOException {
reader . close () ;
}
private String doRawStream ( final BOMInputStream bom , final BOMInputStream pis , final boolean lenient )
throws IOException {
final String bomEnc = bom . getBOMCharsetName () ;
final String xmlGuessEnc = pis . getBOMCharsetName () ;
final String xmlEnc = getXmlProlog ( pis , xmlGuessEnc ) ;
try {
return calculateRawEncoding ( bomEnc , xmlGuessEnc , xmlEnc ) ;
} catch ( final XmlStreamReaderException ex ) {
if ( lenient ) {
return doLenientDetection ( null , ex ) ;
}
throw ex ;
}
}
private String doHttpStream ( final BOMInputStream bom , final BOMInputStream pis , final String httpContentType ,
final boolean lenient ) throws IOException {
final String bomEnc = bom . getBOMCharsetName () ;
final String xmlGuessEnc = pis . getBOMCharsetName () ;
final String xmlEnc = getXmlProlog ( pis , xmlGuessEnc ) ;
try {
return calculateHttpEncoding ( httpContentType , bomEnc ,
xmlGuessEnc , xmlEnc , lenient ) ;
} catch ( final XmlStreamReaderException ex ) {
if ( lenient ) {
return doLenientDetection ( httpContentType , ex ) ;
}
throw ex ;
}
}
private String doLenientDetection ( String httpContentType ,
XmlStreamReaderException ex ) throws IOException {
if ( httpContentType != null && httpContentType . startsWith ( lr_1 ) ) {
httpContentType = httpContentType . substring ( lr_1 . length () ) ;
httpContentType = lr_2 + httpContentType ;
try {
return calculateHttpEncoding ( httpContentType , ex . getBomEncoding () ,
ex . getXmlGuessEncoding () , ex . getXmlEncoding () , true ) ;
} catch ( final XmlStreamReaderException ex2 ) {
ex = ex2 ;
}
}
String encoding = ex . getXmlEncoding () ;
if ( encoding == null ) {
encoding = ex . getContentTypeEncoding () ;
}
if ( encoding == null ) {
encoding = defaultEncoding == null ? UTF_8 : defaultEncoding ;
}
return encoding ;
}
String calculateRawEncoding ( final String bomEnc , final String xmlGuessEnc ,
final String xmlEnc ) throws IOException {
if ( bomEnc == null ) {
if ( xmlGuessEnc == null || xmlEnc == null ) {
return defaultEncoding == null ? UTF_8 : defaultEncoding ;
}
if ( xmlEnc . equals ( UTF_16 ) &&
( xmlGuessEnc . equals ( UTF_16BE ) || xmlGuessEnc . equals ( UTF_16LE ) ) ) {
return xmlGuessEnc ;
}
return xmlEnc ;
}
if ( bomEnc . equals ( UTF_8 ) ) {
if ( xmlGuessEnc != null && ! xmlGuessEnc . equals ( UTF_8 ) ) { MST[rv.ROR4Mutator]MSP[N]
final String msg = MessageFormat . format ( RAW_EX_1 , bomEnc , xmlGuessEnc , xmlEnc ) ;
throw new XmlStreamReaderException ( msg , bomEnc , xmlGuessEnc , xmlEnc ) ;
}
if ( xmlEnc != null && ! xmlEnc . equals ( UTF_8 ) ) {
final String msg = MessageFormat . format ( RAW_EX_1 , bomEnc , xmlGuessEnc , xmlEnc ) ;
throw new XmlStreamReaderException ( msg , bomEnc , xmlGuessEnc , xmlEnc ) ;
}
return bomEnc ;
}
if ( bomEnc . equals ( UTF_16BE ) || bomEnc . equals ( UTF_16LE ) ) {
if ( xmlGuessEnc != null && ! xmlGuessEnc . equals ( bomEnc ) ) {
final String msg = MessageFormat . format ( RAW_EX_1 , bomEnc , xmlGuessEnc , xmlEnc ) ;
throw new XmlStreamReaderException ( msg , bomEnc , xmlGuessEnc , xmlEnc ) ;
}
if ( xmlEnc != null && ! xmlEnc . equals ( UTF_16 ) && ! xmlEnc . equals ( bomEnc ) ) {
final String msg = MessageFormat . format ( RAW_EX_1 , bomEnc , xmlGuessEnc , xmlEnc ) ;
throw new XmlStreamReaderException ( msg , bomEnc , xmlGuessEnc , xmlEnc ) ;
}
return bomEnc ;
}
if ( bomEnc . equals ( UTF_32BE ) || bomEnc . equals ( UTF_32LE ) ) {
if ( xmlGuessEnc != null && ! xmlGuessEnc . equals ( bomEnc ) ) {
final String msg = MessageFormat . format ( RAW_EX_1 , bomEnc , xmlGuessEnc , xmlEnc ) ;
throw new XmlStreamReaderException ( msg , bomEnc , xmlGuessEnc , xmlEnc ) ;
}
if ( xmlEnc != null && ! xmlEnc . equals ( UTF_32 ) && ! xmlEnc . equals ( bomEnc ) ) {
final String msg = MessageFormat . format ( RAW_EX_1 , bomEnc , xmlGuessEnc , xmlEnc ) ;
throw new XmlStreamReaderException ( msg , bomEnc , xmlGuessEnc , xmlEnc ) ;
}
return bomEnc ;
}
final String msg = MessageFormat . format ( RAW_EX_2 , bomEnc , xmlGuessEnc , xmlEnc ) ;
throw new XmlStreamReaderException ( msg , bomEnc , xmlGuessEnc , xmlEnc ) ;
}
String calculateHttpEncoding ( final String httpContentType ,
final String bomEnc , final String xmlGuessEnc , final String xmlEnc ,
final boolean lenient ) throws IOException {
if ( lenient && xmlEnc != null ) {
return xmlEnc ;
}
final String cTMime = getContentTypeMime ( httpContentType ) ;
final String cTEnc = getContentTypeEncoding ( httpContentType ) ;
final boolean appXml = isAppXml ( cTMime ) ;
final boolean textXml = isTextXml ( cTMime ) ;
if ( ! appXml && ! textXml ) {
final String msg = MessageFormat . format ( HTTP_EX_3 , cTMime , cTEnc , bomEnc , xmlGuessEnc , xmlEnc ) ;
throw new XmlStreamReaderException ( msg , cTMime , cTEnc , bomEnc , xmlGuessEnc , xmlEnc ) ;
}
if ( cTEnc == null ) {
if ( appXml ) {
return calculateRawEncoding ( bomEnc , xmlGuessEnc , xmlEnc ) ;
}
return defaultEncoding == null ? US_ASCII : defaultEncoding ;
}
if ( cTEnc . equals ( UTF_16BE ) || cTEnc . equals ( UTF_16LE ) ) {
if ( bomEnc != null ) {
final String msg = MessageFormat . format ( HTTP_EX_1 , cTMime , cTEnc , bomEnc , xmlGuessEnc , xmlEnc ) ;
throw new XmlStreamReaderException ( msg , cTMime , cTEnc , bomEnc , xmlGuessEnc , xmlEnc ) ;
}
return cTEnc ;
}
if ( cTEnc . equals ( UTF_16 ) ) {
if ( bomEnc != null && bomEnc . startsWith ( UTF_16 ) ) {
return bomEnc ;
}
final String msg = MessageFormat . format ( HTTP_EX_2 , cTMime , cTEnc , bomEnc , xmlGuessEnc , xmlEnc ) ;
throw new XmlStreamReaderException ( msg , cTMime , cTEnc , bomEnc , xmlGuessEnc , xmlEnc ) ;
}
if ( cTEnc . equals ( UTF_32BE ) || cTEnc . equals ( UTF_32LE ) ) {
if ( bomEnc != null ) {
final String msg = MessageFormat . format ( HTTP_EX_1 , cTMime , cTEnc , bomEnc , xmlGuessEnc , xmlEnc ) ;
throw new XmlStreamReaderException ( msg , cTMime , cTEnc , bomEnc , xmlGuessEnc , xmlEnc ) ;
}
return cTEnc ;
}
if ( cTEnc . equals ( UTF_32 ) ) {
if ( bomEnc != null && bomEnc . startsWith ( UTF_32 ) ) {
return bomEnc ;
}
final String msg = MessageFormat . format ( HTTP_EX_2 , cTMime , cTEnc , bomEnc , xmlGuessEnc , xmlEnc ) ;
throw new XmlStreamReaderException ( msg , cTMime , cTEnc , bomEnc , xmlGuessEnc , xmlEnc ) ;
}
return cTEnc ;
}
static String getContentTypeMime ( final String httpContentType ) {
String mime = null ;
if ( httpContentType != null ) {
final int i = httpContentType . indexOf ( lr_3 ) ;
if ( i >= 0 ) {
mime = httpContentType . substring ( 0 , i ) ;
} else {
mime = httpContentType ;
}
mime = mime . trim () ;
}
return mime ;
}
static String getContentTypeEncoding ( final String httpContentType ) {
String encoding = null ;
if ( httpContentType != null ) {
final int i = httpContentType . indexOf ( lr_3 ) ;
if ( i > - 1 ) {
final String postMime = httpContentType . substring ( i + 1 ) ;
final Matcher m = CHARSET_PATTERN . matcher ( postMime ) ;
encoding = m . find () ? m . group ( 1 ) : null ;
encoding = encoding != null ? encoding . toUpperCase ( Locale . ROOT ) : null ;
}
}
return encoding ;
}
private static String getXmlProlog ( final InputStream is , final String guessedEnc )
throws IOException {
String encoding = null ;
if ( guessedEnc != null ) {
final byte [] bytes = new byte [ BUFFER_SIZE ] ;
is . mark ( BUFFER_SIZE ) ;
int offset = 0 ;
int max = BUFFER_SIZE ;
int c = is . read ( bytes , offset , max ) ;
int firstGT = - 1 ;
String xmlProlog = lr_4 ;
while ( c != - 1 && firstGT == - 1 && offset < BUFFER_SIZE ) {
offset += c ;
max -= c ;
c = is . read ( bytes , offset , max ) ;
xmlProlog = new String ( bytes , 0 , offset , guessedEnc ) ;
firstGT = xmlProlog . indexOf ( '>' ) ;
}
if ( firstGT == - 1 ) {
if ( c == - 1 ) {
throw new IOException ( lr_5 ) ;
}
throw new IOException (
lr_6
+ offset + lr_7 ) ;
}
final int bytesRead = offset ;
if ( bytesRead > 0 ) {
is . reset () ;
final BufferedReader bReader = new BufferedReader ( new StringReader (
xmlProlog . substring ( 0 , firstGT + 1 ) ) ) ;
final StringBuffer prolog = new StringBuffer () ;
String line = bReader . readLine () ;
while ( line != null ) {
prolog . append ( line ) ;
line = bReader . readLine () ;
}
final Matcher m = ENCODING_PATTERN . matcher ( prolog ) ;
if ( m . find () ) {
encoding = m . group ( 1 ) . toUpperCase ( Locale . ROOT ) ;
encoding = encoding . substring ( 1 , encoding . length () - 1 ) ;
}
}
}
return encoding ;
}
static boolean isAppXml ( final String mime ) {
return mime != null &&
( mime . equals ( lr_8 ) ||
mime . equals ( lr_9 ) ||
mime . equals ( lr_10 ) ||
mime . startsWith ( lr_11 ) && mime . endsWith ( lr_12 ) ) ;
}
static boolean isTextXml ( final String mime ) {
return mime != null &&
( mime . equals ( lr_2 ) ||
mime . equals ( lr_13 ) ||
mime . startsWith ( lr_14 ) && mime . endsWith ( lr_12 ) ) ;
}

public static Document load ( File in , String charsetName , String baseUri ) throws IOException {
return parseInputStream ( new FileInputStream ( in ) , charsetName , baseUri , Parser . htmlParser () ) ;
}
public static Document load ( InputStream in , String charsetName , String baseUri ) throws IOException {
return parseInputStream ( in , charsetName , baseUri , Parser . htmlParser () ) ;
}
public static Document load ( InputStream in , String charsetName , String baseUri , Parser parser ) throws IOException {
return parseInputStream ( in , charsetName , baseUri , parser ) ;
}
static void crossStreams ( final InputStream in , final OutputStream out ) throws IOException {
final byte [] buffer = new byte [ bufferSize ] ;
int len ;
while ( ( len = in . read ( buffer ) ) != - 1 ) {
out . write ( buffer , 0 , len ) ;
}
}
static Document parseInputStream ( InputStream input , String charsetName , String baseUri , Parser parser ) throws IOException {
if ( input == null )
return new Document ( baseUri ) ;
input = ConstrainableInputStream . wrap ( input , bufferSize , 0 ) ;
Document doc = null ;
input . mark ( bufferSize ) ;
ByteBuffer firstBytes = readToByteBuffer ( input , firstReadBufferSize - 1 ) ;
boolean fullyRead = ( input . read () == - 1 ) ;
input . reset () ;
BomCharset bomCharset = detectCharsetFromBom ( firstBytes ) ;
if ( bomCharset != null )
charsetName = bomCharset . charset ;
if ( charsetName == null ) {
String docData = Charset . forName ( defaultCharset ) . decode ( firstBytes ) . toString () ;
try {
doc = parser . parseInput ( docData , baseUri ) ;
} catch ( UncheckedIOException e ) {
throw e . ioException () ;
}
Elements metaElements = doc . select ( lr_1 ) ;
String foundCharset = null ;
for ( Element meta : metaElements ) {
if ( meta . hasAttr ( lr_2 ) )
foundCharset = getCharsetFromContentType ( meta . attr ( lr_3 ) ) ;
if ( foundCharset == null && meta . hasAttr ( lr_4 ) )
foundCharset = meta . attr ( lr_4 ) ;
if ( foundCharset != null )
break;
}
if ( foundCharset == null && doc . childNodeSize () > 0 ) {
Node first = doc . childNode ( 0 ) ;
XmlDeclaration decl = null ;
if ( first instanceof XmlDeclaration )
decl = ( XmlDeclaration ) first ;
else if ( first instanceof Comment ) {
Comment comment = ( Comment ) first ;
if ( comment . isXmlDeclaration () )
decl = comment . asXmlDeclaration () ;
}
if ( decl != null ) {
if ( decl . name () . equalsIgnoreCase ( lr_5 ) )
foundCharset = decl . attr ( lr_6 ) ;
}
}
foundCharset = validateCharset ( foundCharset ) ;
if ( foundCharset != null && ! foundCharset . equalsIgnoreCase ( defaultCharset ) ) {
foundCharset = foundCharset . trim () . replaceAll ( lr_7 , lr_8 ) ;
charsetName = foundCharset ;
doc = null ;
} else if ( ! fullyRead ) {
doc = null ;
}
} else {
Validate . notEmpty ( charsetName , lr_9 ) ;
}
if ( doc == null ) {
if ( charsetName == null )
charsetName = defaultCharset ;
BufferedReader reader = new BufferedReader ( new InputStreamReader ( input , charsetName ) , bufferSize ) ;
if ( bomCharset != null && bomCharset . offset ) {
long skipped = reader . skip ( 1 ) ;
Validate . isTrue ( skipped == 1 ) ;
}
try {
doc = parser . parseInput ( reader , baseUri ) ;
} catch ( UncheckedIOException e ) {
throw e . ioException () ;
}
Charset charset = Charset . forName ( charsetName ) ;
doc . outputSettings () . charset ( charset ) ;
if ( ! charset . canEncode () ) {
doc . charset ( Charset . forName ( defaultCharset ) ) ;
}
}
input . close () ;
return doc ;
}
public static ByteBuffer readToByteBuffer ( InputStream inStream , int maxSize ) throws IOException {
Validate . isTrue ( maxSize >= 0 , lr_10 ) ;
final ConstrainableInputStream input = ConstrainableInputStream . wrap ( inStream , bufferSize , maxSize ) ;
return input . readToByteBuffer ( maxSize ) ;
}
static ByteBuffer emptyByteBuffer () {
return ByteBuffer . allocate ( 0 ) ;
}
static String getCharsetFromContentType ( String contentType ) {
if ( contentType == null ) return null ;
Matcher m = charsetPattern . matcher ( contentType ) ;
if ( m . find () ) {
String charset = m . group ( 1 ) . trim () ;
charset = charset . replace ( lr_11 , lr_8 ) ;
return validateCharset ( charset ) ;
}
return null ;
}
private static String validateCharset ( String cs ) {
if ( cs == null || cs . length () == 0 ) return null ;
cs = cs . trim () . replaceAll ( lr_7 , lr_8 ) ;
try {
if ( Charset . isSupported ( cs ) ) return cs ;
cs = cs . toUpperCase ( Locale . ENGLISH ) ;
if ( Charset . isSupported ( cs ) ) return cs ;
} catch ( IllegalCharsetNameException e ) {
}
return null ;
}
static String mimeBoundary () {
final StringBuilder mime = StringUtil . borrowBuilder () ;
final Random rand = new Random () ;
for ( int i = 0 ; i < boundaryLength ; i ++ ) {
mime . append ( mimeBoundaryChars [ rand . nextInt ( mimeBoundaryChars . length ) ] ) ;
}
return StringUtil . releaseBuilder ( mime ) ;
}
private static BomCharset detectCharsetFromBom ( final ByteBuffer byteData ) {
final Buffer buffer = byteData ;
buffer . mark () ;
byte [] bom = new byte [ 4 ] ;
if ( byteData . remaining () >= bom . length ) {
byteData . get ( bom ) ;
buffer . rewind () ;
}
if ( bom [ 0 ] == 0x00 && bom [ 1 ] == 0x00 && bom [ 2 ] == ( byte ) 0xFE && bom [ 3 ] == ( byte ) 0xFF ||
bom [ 0 ] == ( byte ) 0xFF && bom [ 1 ] == ( byte ) 0xFE && bom [ 2 ] == 0x00 && bom [ 3 ] == 0x00 ) {
return new BomCharset ( lr_12 , false ) ;
} else if ( bom [ 0 ] == ( byte ) 0xFE && bom [ 1 ] == ( byte ) 0xFF ||
bom [ 0 ] == ( byte ) 0xFF && bom [ 1 ] == ( byte ) 0xFE ) {
return new BomCharset ( lr_13 , false ) ;
} else if ( bom [ 0 ] == ( byte ) 0xEF && bom [ 1 ] == ( byte ) 0xBB && bom [ 2 ] == ( byte ) 0xBF ) {
return new BomCharset ( lr_14 , true ) ;
}
return null ;
}

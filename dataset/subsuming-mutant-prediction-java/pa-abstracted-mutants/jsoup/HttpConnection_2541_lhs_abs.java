public static Connection connect ( String url ) {
Connection con = new HttpConnection () ;
con . url ( url ) ;
return con ;
}
public static Connection connect ( URL url ) {
Connection con = new HttpConnection () ;
con . url ( url ) ;
return con ;
}
private static String encodeUrl ( String url ) {
try {
URL u = new URL ( url ) ;
return encodeUrl ( u ) . toExternalForm () ;
} catch ( Exception e ) {
return url ;
}
}
static URL encodeUrl ( URL u ) {
try {
String urlS = u . toExternalForm () ;
urlS = urlS . replace ( lr_1 , lr_2 ) ;
final URI uri = new URI ( urlS ) ;
return new URL ( uri . toASCIIString () ) ;
} catch ( URISyntaxException | MalformedURLException e ) {
return u ;
}
}
private static String encodeMimeName ( String val ) {
if ( val == null )
return null ;
return val . replace ( lr_3 , lr_4 ) ;
}
public Connection url ( URL url ) {
req . url ( url ) ;
return this ;
}
public Connection url ( String url ) {
Validate . notEmpty ( url , lr_5 ) ;
try {
req . url ( new URL ( encodeUrl ( url ) ) ) ;
} catch ( MalformedURLException e ) {
throw new IllegalArgumentException ( lr_6 + url , e ) ;
}
return this ;
}
public Connection proxy ( Proxy proxy ) {
req . proxy ( proxy ) ;
return this ;
}
public Connection proxy ( String host , int port ) {
req . proxy ( host , port ) ;
return this ;
}
public Connection userAgent ( String userAgent ) {
Validate . notNull ( userAgent , lr_7 ) ;
req . header ( USER_AGENT , userAgent ) ;
return this ;
}
public Connection timeout ( int millis ) {
req . timeout ( millis ) ;
return this ;
}
public Connection maxBodySize ( int bytes ) {
req . maxBodySize ( bytes ) ;
return this ;
}
public Connection followRedirects ( boolean followRedirects ) {
req . followRedirects ( followRedirects ) ;
return this ;
}
public Connection referrer ( String referrer ) {
Validate . notNull ( referrer , lr_8 ) ;
req . header ( lr_9 , referrer ) ;
return this ;
}
public Connection method ( Method method ) {
req . method ( method ) ;
return this ;
}
public Connection ignoreHttpErrors ( boolean ignoreHttpErrors ) {
req . ignoreHttpErrors ( ignoreHttpErrors ) ;
return this ;
}
public Connection ignoreContentType ( boolean ignoreContentType ) {
req . ignoreContentType ( ignoreContentType ) ;
return this ;
}
public Connection data ( String key , String value ) {
req . data ( KeyVal . create ( key , value ) ) ;
return this ;
}
public Connection sslSocketFactory ( SSLSocketFactory sslSocketFactory ) {
req . sslSocketFactory ( sslSocketFactory ) ;
return this ;
}
public Connection data ( String key , String filename , InputStream inputStream ) {
req . data ( KeyVal . create ( key , filename , inputStream ) ) ;
return this ;
}
@Override
public Connection data ( String key , String filename , InputStream inputStream , String contentType ) {
req . data ( KeyVal . create ( key , filename , inputStream ) . contentType ( contentType ) ) ;
return this ;
}
public Connection data ( Map < String , String > data ) {
Validate . notNull ( data , lr_10 ) ;
for ( Map . Entry < String , String > entry : data . entrySet () ) {
req . data ( KeyVal . create ( entry . getKey () , entry . getValue () ) ) ;
}
return this ;
}
public Connection data ( String ... keyvals ) {
Validate . notNull ( keyvals , lr_11 ) ;
Validate . isTrue ( keyvals . length % 2 == 0 , lr_12 ) ;
for ( int i = 0 ; i < keyvals . length ; i += 2 ) {
String key = keyvals [ i ] ;
String value = keyvals [ i + 1 ] ;
Validate . notEmpty ( key , lr_13 ) ;
Validate . notNull ( value , lr_14 ) ;
req . data ( KeyVal . create ( key , value ) ) ;
}
return this ;
}
public Connection data ( Collection < Connection . KeyVal > data ) {
Validate . notNull ( data , lr_15 ) ;
for ( Connection . KeyVal entry : data ) {
req . data ( entry ) ;
}
return this ;
}
public Connection . KeyVal data ( String key ) {
Validate . notEmpty ( key , lr_13 ) ;
for ( Connection . KeyVal keyVal : request () . data () ) {
if ( keyVal . key () . equals ( key ) )
return keyVal ;
}
return null ;
}
public Connection requestBody ( String body ) {
req . requestBody ( body ) ;
return this ;
}
public Connection header ( String name , String value ) {
req . header ( name , value ) ;
return this ;
}
public Connection headers ( Map < String , String > headers ) {
Validate . notNull ( headers , lr_16 ) ;
for ( Map . Entry < String , String > entry : headers . entrySet () ) {
req . header ( entry . getKey () , entry . getValue () ) ;
}
return this ;
}
public Connection cookie ( String name , String value ) {
req . cookie ( name , value ) ;
return this ;
}
public Connection cookies ( Map < String , String > cookies ) {
Validate . notNull ( cookies , lr_17 ) ;
for ( Map . Entry < String , String > entry : cookies . entrySet () ) {
req . cookie ( entry . getKey () , entry . getValue () ) ;
}
return this ;
}
public Connection parser ( Parser parser ) {
req . parser ( parser ) ;
return this ;
}
public Document get () throws IOException {
req . method ( Method . GET ) ;
execute () ;
return res . parse () ;
}
public Document post () throws IOException {
req . method ( Method . POST ) ;
execute () ;
return res . parse () ;
}
public Connection . Response execute () throws IOException {
res = Response . execute ( req ) ;
return res ;
}
public Connection . Request request () {
return req ;
}
public Connection request ( Connection . Request request ) {
req = request ;
return this ;
}
public Connection . Response response () {
return res ;
}
public Connection response ( Connection . Response response ) {
res = response ;
return this ;
}
public Connection postDataCharset ( String charset ) {
req . postDataCharset ( charset ) ;
return this ;
}
public URL url () {
return url ;
}
public T url ( URL url ) {
Validate . notNull ( url , lr_18 ) ;
this . url = url ;
return ( T ) this ;
}
public Method method () {
return method ;
}
public T method ( Method method ) {
Validate . notNull ( method , lr_19 ) ;
this . method = method ;
return ( T ) this ;
}
public String header ( String name ) {
Validate . notNull ( name , lr_20 ) ;
List < String > vals = getHeadersCaseInsensitive ( name ) ;
if ( vals . size () > 0 ) {
return StringUtil . join ( vals , lr_21 ) ;
}
return null ;
}
@Override
public T addHeader ( String name , String value ) {
Validate . notEmpty ( name ) ;
value = value == null ? lr_22 : value ;
List < String > values = headers ( name ) ;
if ( values . isEmpty () ) {
values = new ArrayList <> () ;
headers . put ( name , values ) ;
}
values . add ( fixHeaderEncoding ( value ) ) ;
return ( T ) this ;
}
@Override
public List < String > headers ( String name ) {
Validate . notEmpty ( name ) ;
return getHeadersCaseInsensitive ( name ) ;
}
private static String fixHeaderEncoding ( String val ) {
try {
byte [] bytes = val . getBytes ( lr_23 ) ;
if ( ! looksLikeUtf8 ( bytes ) )
return val ;
return new String ( bytes , lr_24 ) ;
} catch ( UnsupportedEncodingException e ) {
return val ;
}
}
private static boolean looksLikeUtf8 ( byte [] input ) {
int i = 0 ;
if ( input . length >= 3 && ( input [ 0 ] & 0xFF ) == 0xEF
&& ( input [ 1 ] & 0xFF ) == 0xBB & ( input [ 2 ] & 0xFF ) == 0xBF ) {
i = 3 ;
}
int end ;
for ( int j = input . length ; i < j ; ++ i ) {
int o = input [ i ] ;
if ( ( o & 0x80 ) == 0 ) {
continue;
}
if ( ( o & 0xE0 ) == 0xC0 ) {
end = i + 1 ;
} else if ( ( o & 0xF0 ) == 0xE0 ) {
end = i + 2 ;
} else if ( ( o & 0xF8 ) == 0xF0 ) {
end = i + 3 ;
} else {
return false ;
}
if ( end >= input . length )
return false ;
while ( i < end ) {
i ++ ;
o = input [ i ] ;
if ( ( o & 0xC0 ) != 0x80 ) {
return false ;
}
}
}
return true ;
}
public T header ( String name , String value ) {
Validate . notEmpty ( name , lr_25 ) ;
removeHeader ( name ) ;
addHeader ( name , value ) ;
return ( T ) this ;
}
public boolean hasHeader ( String name ) {
Validate . notEmpty ( name , lr_25 ) ;
return ! getHeadersCaseInsensitive ( name ) . isEmpty () ;
}
public boolean hasHeaderWithValue ( String name , String value ) {
Validate . notEmpty ( name ) ;
Validate . notEmpty ( value ) ;
List < String > values = headers ( name ) ;
for ( String candidate : values ) {
if ( value . equalsIgnoreCase ( candidate ) )
return true ;
}
return false ;
}
public T removeHeader ( String name ) {
Validate . notEmpty ( name , lr_25 ) ;
Map . Entry < String , List < String > > entry = scanHeaders ( name ) ;
if ( entry != null )
headers . remove ( entry . getKey () ) ;
return ( T ) this ;
}
public Map < String , String > headers () {
LinkedHashMap < String , String > map = new LinkedHashMap <> ( headers . size () ) ;
for ( Map . Entry < String , List < String > > entry : headers . entrySet () ) {
String header = entry . getKey () ;
List < String > values = entry . getValue () ;
if ( values . size () > 0 )
map . put ( header , values . get ( 0 ) ) ;
}
return map ;
}
@Override
public Map < String , List < String > > multiHeaders () {
return headers ;
}
private List < String > getHeadersCaseInsensitive ( String name ) {
Validate . notNull ( name ) ;
for ( Map . Entry < String , List < String > > entry : headers . entrySet () ) {
if ( name . equalsIgnoreCase ( entry . getKey () ) )
return entry . getValue () ;
}
return Collections . emptyList () ;
}
private Map . Entry < String , List < String > > scanHeaders ( String name ) {
String lc = lowerCase ( name ) ;
for ( Map . Entry < String , List < String > > entry : headers . entrySet () ) {
if ( lowerCase ( entry . getKey () ) . equals ( lc ) )
return entry ;
}
return null ;
}
public String cookie ( String name ) {
Validate . notEmpty ( name , lr_26 ) ;
return cookies . get ( name ) ;
}
public T cookie ( String name , String value ) {
Validate . notEmpty ( name , lr_26 ) ;
Validate . notNull ( value , lr_27 ) ;
cookies . put ( name , value ) ;
return ( T ) this ;
}
public boolean hasCookie ( String name ) {
Validate . notEmpty ( name , lr_26 ) ;
return cookies . containsKey ( name ) ;
}
public T removeCookie ( String name ) {
Validate . notEmpty ( name , lr_26 ) ;
cookies . remove ( name ) ;
return ( T ) this ;
}
public Map < String , String > cookies () {
return cookies ;
}
public Proxy proxy () {
return proxy ;
}
public Request proxy ( Proxy proxy ) {
this . proxy = proxy ;
return this ;
}
public Request proxy ( String host , int port ) {
this . proxy = new Proxy ( Proxy . Type . HTTP , InetSocketAddress . createUnresolved ( host , port ) ) ;
return this ;
}
public int timeout () {
return timeoutMilliseconds ;
}
public Request timeout ( int millis ) {
Validate . isTrue ( millis >= 0 , lr_28 ) ;
timeoutMilliseconds = millis ;
return this ;
}
public int maxBodySize () {
return maxBodySizeBytes ;
}
public Connection . Request maxBodySize ( int bytes ) {
Validate . isTrue ( bytes >= 0 , lr_29 ) ;
maxBodySizeBytes = bytes ;
return this ;
}
public boolean followRedirects () {
return followRedirects ;
}
public Connection . Request followRedirects ( boolean followRedirects ) {
this . followRedirects = followRedirects ;
return this ;
}
public boolean ignoreHttpErrors () {
return ignoreHttpErrors ;
}
public SSLSocketFactory sslSocketFactory () {
return sslSocketFactory ;
}
public void sslSocketFactory ( SSLSocketFactory sslSocketFactory ) {
this . sslSocketFactory = sslSocketFactory ;
}
public Connection . Request ignoreHttpErrors ( boolean ignoreHttpErrors ) {
this . ignoreHttpErrors = ignoreHttpErrors ;
return this ;
}
public boolean ignoreContentType () {
return ignoreContentType ;
}
public Connection . Request ignoreContentType ( boolean ignoreContentType ) {
this . ignoreContentType = ignoreContentType ;
return this ;
}
public Request data ( Connection . KeyVal keyval ) {
Validate . notNull ( keyval , lr_30 ) ;
data . add ( keyval ) ; MST[NonVoidMethodCallMutator]MSP[]
return this ;
}
public Collection < Connection . KeyVal > data () {
return data ;
}
public Connection . Request requestBody ( String body ) {
this . body = body ;
return this ;
}
public String requestBody () {
return body ;
}
public Request parser ( Parser parser ) {
this . parser = parser ;
parserDefined = true ;
return this ;
}
public Parser parser () {
return parser ;
}
public Connection . Request postDataCharset ( String charset ) {
Validate . notNull ( charset , lr_31 ) ;
if ( ! Charset . isSupported ( charset ) ) throw new IllegalCharsetNameException ( charset ) ;
this . postDataCharset = charset ;
return this ;
}
public String postDataCharset () {
return postDataCharset ;
}
static Response execute ( Connection . Request req ) throws IOException {
return execute ( req , null ) ;
}
static Response execute ( Connection . Request req , Response previousResponse ) throws IOException {
Validate . notNull ( req , lr_32 ) ;
Validate . notNull ( req . url () , lr_33 ) ;
String protocol = req . url () . getProtocol () ;
if ( ! protocol . equals ( lr_34 ) && ! protocol . equals ( lr_35 ) )
throw new MalformedURLException ( lr_36 ) ;
final boolean methodHasBody = req . method () . hasBody () ;
final boolean hasRequestBody = req . requestBody () != null ;
if ( ! methodHasBody )
Validate . isFalse ( hasRequestBody , lr_37 + req . method () ) ;
String mimeBoundary = null ;
if ( req . data () . size () > 0 && ( ! methodHasBody || hasRequestBody ) )
serialiseRequestUrl ( req ) ;
else if ( methodHasBody )
mimeBoundary = setOutputContentType ( req ) ;
long startTime = System . nanoTime () ;
HttpURLConnection conn = createConnection ( req ) ;
Response res = null ;
try {
conn . connect () ;
if ( conn . getDoOutput () )
writePost ( req , conn . getOutputStream () , mimeBoundary ) ;
int status = conn . getResponseCode () ;
res = new Response ( previousResponse ) ;
res . setupFromConnection ( conn , previousResponse ) ;
res . req = req ;
if ( res . hasHeader ( LOCATION ) && req . followRedirects () ) {
if ( status != HTTP_TEMP_REDIR ) {
req . method ( Method . GET ) ;
req . data () . clear () ;
req . requestBody ( null ) ;
req . removeHeader ( CONTENT_TYPE ) ;
}
String location = res . header ( LOCATION ) ;
if ( location . startsWith ( lr_38 ) && location . charAt ( 6 ) != '/' )
location = location . substring ( 6 ) ;
URL redir = StringUtil . resolve ( req . url () , location ) ;
req . url ( encodeUrl ( redir ) ) ;
for ( Map . Entry < String , String > cookie : res . cookies . entrySet () ) {
req . cookie ( cookie . getKey () , cookie . getValue () ) ;
}
return execute ( req , res ) ;
}
if ( ( status < 200 || status >= 400 ) && ! req . ignoreHttpErrors () )
throw new HttpStatusException ( lr_39 , status , req . url () . toString () ) ;
String contentType = res . contentType () ;
if ( contentType != null
&& ! req . ignoreContentType ()
&& ! contentType . startsWith ( lr_40 )
&& ! xmlContentTypeRxp . matcher ( contentType ) . matches ()
)
throw new UnsupportedMimeTypeException ( lr_41 ,
contentType , req . url () . toString () ) ;
if ( contentType != null && xmlContentTypeRxp . matcher ( contentType ) . matches () ) {
if ( req instanceof HttpConnection . Request && ! ( ( Request ) req ) . parserDefined ) {
req . parser ( Parser . xmlParser () ) ;
}
}
res . charset = DataUtil . getCharsetFromContentType ( res . contentType ) ;
if ( conn . getContentLength () != 0 && req . method () != HEAD ) {
res . bodyStream = null ;
res . bodyStream = conn . getErrorStream () != null ? conn . getErrorStream () : conn . getInputStream () ;
if ( res . hasHeaderWithValue ( CONTENT_ENCODING , lr_42 ) ) {
res . bodyStream = new GZIPInputStream ( res . bodyStream ) ;
} else if ( res . hasHeaderWithValue ( CONTENT_ENCODING , lr_43 ) ) {
res . bodyStream = new InflaterInputStream ( res . bodyStream , new Inflater ( true ) ) ;
}
res . bodyStream = ConstrainableInputStream
. wrap ( res . bodyStream , DataUtil . bufferSize , req . maxBodySize () )
. timeout ( startTime , req . timeout () )
;
} else {
res . byteData = DataUtil . emptyByteBuffer () ;
}
} catch ( IOException e ) {
if ( res != null ) res . safeClose () ;
throw e ;
}
res . executed = true ;
return res ;
}
public int statusCode () {
return statusCode ;
}
public String statusMessage () {
return statusMessage ;
}
public String charset () {
return charset ;
}
public Response charset ( String charset ) {
this . charset = charset ;
return this ;
}
public String contentType () {
return contentType ;
}
public Document parse () throws IOException {
Validate . isTrue ( executed , lr_44 ) ;
if ( byteData != null ) {
bodyStream = new ByteArrayInputStream ( byteData . array () ) ;
inputStreamRead = false ;
}
Validate . isFalse ( inputStreamRead , lr_45 ) ;
Document doc = DataUtil . parseInputStream ( bodyStream , charset , url . toExternalForm () , req . parser () ) ;
charset = doc . outputSettings () . charset () . name () ;
inputStreamRead = true ;
safeClose () ;
return doc ;
}
private void prepareByteData () {
Validate . isTrue ( executed , lr_46 ) ;
if ( byteData == null ) {
Validate . isFalse ( inputStreamRead , lr_47 ) ;
try {
byteData = DataUtil . readToByteBuffer ( bodyStream , req . maxBodySize () ) ;
} catch ( IOException e ) {
throw new UncheckedIOException ( e ) ;
} finally {
inputStreamRead = true ;
safeClose () ;
}
}
}
public String body () {
prepareByteData () ;
String body ;
if ( charset == null )
body = Charset . forName ( DataUtil . defaultCharset ) . decode ( byteData ) . toString () ;
else
body = Charset . forName ( charset ) . decode ( byteData ) . toString () ;
( ( Buffer ) byteData ) . rewind () ;
return body ;
}
public byte [] bodyAsBytes () {
prepareByteData () ;
return byteData . array () ;
}
@Override
public Connection . Response bufferUp () {
prepareByteData () ;
return this ;
}
@Override
public BufferedInputStream bodyStream () {
Validate . isTrue ( executed , lr_46 ) ;
Validate . isFalse ( inputStreamRead , lr_48 ) ;
inputStreamRead = true ;
return ConstrainableInputStream . wrap ( bodyStream , DataUtil . bufferSize , req . maxBodySize () ) ;
}
private static HttpURLConnection createConnection ( Connection . Request req ) throws IOException {
final HttpURLConnection conn = (HttpURLConnection) (
req . proxy () == null ?
req . url () . openConnection () :
req . url () . openConnection ( req . proxy () )
) ;
conn . setRequestMethod ( req . method () . name () ) ;
conn . setInstanceFollowRedirects ( false ) ;
conn . setConnectTimeout ( req . timeout () ) ;
conn . setReadTimeout ( req . timeout () / 2 ) ;
if ( req . sslSocketFactory () != null && conn instanceof HttpsURLConnection )
( ( HttpsURLConnection ) conn ) . setSSLSocketFactory ( req . sslSocketFactory () ) ;
if ( req . method () . hasBody () )
conn . setDoOutput ( true ) ;
if ( req . cookies () . size () > 0 )
conn . addRequestProperty ( lr_49 , getRequestCookieString ( req ) ) ;
for ( Map . Entry < String , List < String > > header : req . multiHeaders () . entrySet () ) {
for ( String value : header . getValue () ) {
conn . addRequestProperty ( header . getKey () , value ) ;
}
}
return conn ;
}
private void safeClose () {
if ( bodyStream != null ) {
try {
bodyStream . close () ;
} catch ( IOException e ) {
} finally {
bodyStream = null ;
}
}
if ( conn != null ) {
conn . disconnect () ;
conn = null ;
}
}
private void setupFromConnection ( HttpURLConnection conn , HttpConnection . Response previousResponse ) throws IOException {
this . conn = conn ;
method = Method . valueOf ( conn . getRequestMethod () ) ;
url = conn . getURL () ;
statusCode = conn . getResponseCode () ;
statusMessage = conn . getResponseMessage () ;
contentType = conn . getContentType () ;
Map < String , List < String > > resHeaders = createHeaderMap ( conn ) ;
processResponseHeaders ( resHeaders ) ;
if ( previousResponse != null ) {
for ( Map . Entry < String , String > prevCookie : previousResponse . cookies () . entrySet () ) {
if ( ! hasCookie ( prevCookie . getKey () ) )
cookie ( prevCookie . getKey () , prevCookie . getValue () ) ;
}
previousResponse . safeClose () ;
}
}
private static LinkedHashMap < String , List < String > > createHeaderMap ( HttpURLConnection conn ) {
final LinkedHashMap < String , List < String > > headers = new LinkedHashMap <> () ;
int i = 0 ;
while ( true ) {
final String key = conn . getHeaderFieldKey ( i ) ;
final String val = conn . getHeaderField ( i ) ;
if ( key == null && val == null )
break;
i ++ ;
if ( key == null || val == null )
continue;
if ( headers . containsKey ( key ) )
headers . get ( key ) . add ( val ) ;
else {
final ArrayList < String > vals = new ArrayList <> () ;
vals . add ( val ) ;
headers . put ( key , vals ) ;
}
}
return headers ;
}
void processResponseHeaders ( Map < String , List < String > > resHeaders ) {
for ( Map . Entry < String , List < String > > entry : resHeaders . entrySet () ) {
String name = entry . getKey () ;
if ( name == null )
continue;
List < String > values = entry . getValue () ;
if ( name . equalsIgnoreCase ( lr_50 ) ) {
for ( String value : values ) {
if ( value == null )
continue;
TokenQueue cd = new TokenQueue ( value ) ;
String cookieName = cd . chompTo ( lr_51 ) . trim () ;
String cookieVal = cd . consumeTo ( lr_52 ) . trim () ;
if ( cookieName . length () > 0 )
cookie ( cookieName , cookieVal ) ;
}
}
for ( String value : values ) {
addHeader ( name , value ) ;
}
}
}
private static String setOutputContentType ( final Connection . Request req ) {
String bound = null ;
if ( req . hasHeader ( CONTENT_TYPE ) ) {
if( req . header ( CONTENT_TYPE ) . contains ( MULTIPART_FORM_DATA ) &&
! req . header ( CONTENT_TYPE ) . contains ( lr_53 ) ) {
bound = DataUtil . mimeBoundary () ;
req . header ( CONTENT_TYPE , MULTIPART_FORM_DATA + lr_54 + bound ) ;
}
}
else if ( needsMultipart ( req ) ) {
bound = DataUtil . mimeBoundary () ;
req . header ( CONTENT_TYPE , MULTIPART_FORM_DATA + lr_54 + bound ) ;
} else {
req . header ( CONTENT_TYPE , FORM_URL_ENCODED + lr_55 + req . postDataCharset () ) ;
}
return bound ;
}
private static void writePost ( final Connection . Request req , final OutputStream outputStream , final String bound ) throws IOException {
final Collection < Connection . KeyVal > data = req . data () ;
final BufferedWriter w = new BufferedWriter ( new OutputStreamWriter ( outputStream , req . postDataCharset () ) ) ;
if ( bound != null ) {
for ( Connection . KeyVal keyVal : data ) {
w . write ( lr_56 ) ;
w . write ( bound ) ;
w . write ( lr_57 ) ;
w . write ( lr_58 ) ;
w . write ( encodeMimeName ( keyVal . key () ) ) ;
w . write ( lr_3 ) ;
if ( keyVal . hasInputStream () ) {
w . write ( lr_59 ) ;
w . write ( encodeMimeName ( keyVal . value () ) ) ;
w . write ( lr_60 ) ;
w . write ( keyVal . contentType () != null ? keyVal . contentType () : DefaultUploadType ) ;
w . write ( lr_61 ) ;
w . flush () ;
DataUtil . crossStreams ( keyVal . inputStream () , outputStream ) ;
outputStream . flush () ;
} else {
w . write ( lr_61 ) ;
w . write ( keyVal . value () ) ;
}
w . write ( lr_57 ) ;
}
w . write ( lr_56 ) ;
w . write ( bound ) ;
w . write ( lr_56 ) ;
} else if ( req . requestBody () != null ) {
w . write ( req . requestBody () ) ;
}
else {
boolean first = true ;
for ( Connection . KeyVal keyVal : data ) {
if ( ! first )
w . append ( '&' ) ;
else
first = false ;
w . write ( URLEncoder . encode ( keyVal . key () , req . postDataCharset () ) ) ;
w . write ( '=' ) ;
w . write ( URLEncoder . encode ( keyVal . value () , req . postDataCharset () ) ) ;
}
}
w . close () ;
}
private static String getRequestCookieString ( Connection . Request req ) {
StringBuilder sb = StringUtil . borrowBuilder () ;
boolean first = true ;
for ( Map . Entry < String , String > cookie : req . cookies () . entrySet () ) {
if ( ! first )
sb . append ( lr_62 ) ;
else
first = false ;
sb . append ( cookie . getKey () ) . append ( '=' ) . append ( cookie . getValue () ) ;
}
return StringUtil . releaseBuilder ( sb ) ;
}
private static void serialiseRequestUrl ( Connection . Request req ) throws IOException {
URL in = req . url () ;
StringBuilder url = StringUtil . borrowBuilder () ;
boolean first = true ;
url
. append ( in . getProtocol () )
. append ( lr_63 )
. append ( in . getAuthority () )
. append ( in . getPath () )
. append ( lr_64 ) ;
if ( in . getQuery () != null ) {
url . append ( in . getQuery () ) ;
first = false ;
}
for ( Connection . KeyVal keyVal : req . data () ) {
Validate . isFalse ( keyVal . hasInputStream () , lr_65 ) ;
if ( ! first )
url . append ( '&' ) ;
else
first = false ;
url
. append ( URLEncoder . encode ( keyVal . key () , DataUtil . defaultCharset ) )
. append ( '=' )
. append ( URLEncoder . encode ( keyVal . value () , DataUtil . defaultCharset ) ) ;
}
req . url ( new URL ( StringUtil . releaseBuilder ( url ) ) ) ;
req . data () . clear () ;
}
private static boolean needsMultipart ( Connection . Request req ) {
for ( Connection . KeyVal keyVal : req . data () ) {
if ( keyVal . hasInputStream () )
return true ;
}
return false ;
}
public static KeyVal create ( String key , String value ) {
return new KeyVal () . key ( key ) . value ( value ) ;
}
public static KeyVal create ( String key , String filename , InputStream stream ) {
return new KeyVal () . key ( key ) . value ( filename ) . inputStream ( stream ) ;
}
public KeyVal key ( String key ) {
Validate . notEmpty ( key , lr_13 ) ;
this . key = key ;
return this ;
}
public String key () {
return key ;
}
public KeyVal value ( String value ) {
Validate . notNull ( value , lr_14 ) ;
this . value = value ;
return this ;
}
public String value () {
return value ;
}
public KeyVal inputStream ( InputStream inputStream ) {
Validate . notNull ( value , lr_66 ) ;
this . stream = inputStream ;
return this ;
}
public InputStream inputStream () {
return stream ;
}
public boolean hasInputStream () {
return stream != null ;
}
@Override
public Connection . KeyVal contentType ( String contentType ) {
Validate . notEmpty ( contentType ) ;
this . contentType = contentType ;
return this ;
}
@Override
public String contentType () {
return contentType ;
}
@Override
public String toString () {
return key + lr_51 + value ;
}

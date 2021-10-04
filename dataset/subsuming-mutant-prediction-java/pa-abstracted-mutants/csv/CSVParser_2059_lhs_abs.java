public static CSVParser parse ( File file , final CSVFormat format ) throws IOException {
Assertions . notNull ( file , lr_1 ) ;
Assertions . notNull ( format , lr_2 ) ;
return new CSVParser ( new FileReader ( file ) , format ) ;
}
public static CSVParser parse ( String string , final CSVFormat format ) throws IOException {
Assertions . notNull ( string , lr_3 ) ;
Assertions . notNull ( format , lr_2 ) ;
return new CSVParser ( new StringReader ( string ) , format ) ;
}
public static CSVParser parse ( URL url , Charset charset , final CSVFormat format ) throws IOException {
Assertions . notNull ( url , lr_4 ) ; MST[VoidMethodCallMutator]MSP[]
Assertions . notNull ( charset , lr_5 ) ;
Assertions . notNull ( format , lr_2 ) ;
return new CSVParser ( new InputStreamReader ( url . openStream () ,
charset == null ? Charset . forName ( lr_6 ) : charset ) , format ) ;
}
private void addRecordValue () {
final String input = this . reusableToken . content . toString () ;
final String nullString = this . format . getNullString () ;
if ( nullString == null ) {
this . record . add ( input ) ;
} else {
this . record . add ( input . equalsIgnoreCase ( nullString ) ? null : input ) ;
}
}
public void close () throws IOException {
if ( this . lexer != null ) {
this . lexer . close () ;
}
}
public long getCurrentLineNumber () {
return this . lexer . getCurrentLineNumber () ;
}
public Map < String , Integer > getHeaderMap () {
return this . headerMap == null ? null : new LinkedHashMap < String , Integer > ( this . headerMap ) ;
}
public long getRecordNumber () {
return this . recordNumber ;
}
public List < CSVRecord > getRecords () throws IOException {
final List < CSVRecord > records = new ArrayList < CSVRecord > () ;
CSVRecord rec ;
while ( ( rec = this . nextRecord () ) != null ) {
records . add ( rec ) ;
}
return records ;
}
private Map < String , Integer > initializeHeader () throws IOException {
Map < String , Integer > hdrMap = null ;
final String [] formatHeader = this . format . getHeader () ;
if ( formatHeader != null ) {
hdrMap = new LinkedHashMap < String , Integer > () ;
String [] header = null ;
if ( formatHeader . length == 0 ) {
final CSVRecord record = this . nextRecord () ;
if ( record != null ) {
header = record . values () ;
}
} else {
if ( this . format . getSkipHeaderRecord () ) {
this . nextRecord () ;
}
header = formatHeader ;
}
if ( header != null ) {
for ( int i = 0 ; i < header . length ; i ++ ) {
hdrMap . put ( header [ i ] , Integer . valueOf ( i ) ) ;
}
}
}
return hdrMap ;
}
public boolean isClosed () {
return this . lexer . isClosed () ;
}
private CSVRecord getNextRecord () {
try {
return CSVParser . this . nextRecord () ;
} catch ( final IOException e ) {
throw new RuntimeException ( e ) ;
}
}
public boolean hasNext () {
if ( CSVParser . this . isClosed () ) {
return false ;
}
if ( this . current == null ) {
this . current = this . getNextRecord () ;
}
return this . current != null ;
}
public CSVRecord next () {
if ( CSVParser . this . isClosed () ) {
throw new NoSuchElementException ( lr_7 ) ;
}
CSVRecord next = this . current ;
this . current = null ;
if ( next == null ) {
next = this . getNextRecord () ;
if ( next == null ) {
throw new NoSuchElementException ( lr_8 ) ;
}
}
return next ;
}
public void remove () {
throw new UnsupportedOperationException () ;
}
CSVRecord nextRecord () throws IOException {
CSVRecord result = null ;
this . record . clear () ;
StringBuilder sb = null ;
do {
this . reusableToken . reset () ;
this . lexer . nextToken ( this . reusableToken ) ;
switch ( this . reusableToken . type ) {
case TOKEN :
this . addRecordValue () ;
break;
case EORECORD :
this . addRecordValue () ;
break;
case EOF :
if ( this . reusableToken . isReady ) {
this . addRecordValue () ;
}
break;
case INVALID :
throw new IOException ( lr_9 + this . getCurrentLineNumber () + lr_10 ) ;
case COMMENT :
if ( sb == null ) {
sb = new StringBuilder () ;
} else {
sb . append ( Constants . LF ) ;
}
sb . append ( this . reusableToken . content ) ;
this . reusableToken . type = TOKEN ;
break;
}
} while ( this . reusableToken . type == TOKEN );
if ( ! this . record . isEmpty () ) {
this . recordNumber ++ ;
final String comment = sb == null ? null : sb . toString () ;
result = new CSVRecord ( this . record . toArray ( new String [ this . record . size () ] ) , this . headerMap , comment ,
this . recordNumber ) ;
}
return result ;
}

@Deprecated
public static long freeSpace ( final String path ) throws IOException {
return INSTANCE . freeSpaceOS ( path , OS , false , - 1 ) ;
}
@Deprecated
public static long freeSpaceKb ( final String path ) throws IOException {
return freeSpaceKb ( path , - 1 ) ;
}
@Deprecated
public static long freeSpaceKb ( final String path , final long timeout ) throws IOException {
return INSTANCE . freeSpaceOS ( path , OS , true , timeout ) ;
}
@Deprecated
public static long freeSpaceKb () throws IOException {
return freeSpaceKb ( - 1 ) ;
}
@Deprecated
public static long freeSpaceKb ( final long timeout ) throws IOException {
return freeSpaceKb ( new File ( lr_1 ) . getAbsolutePath () , timeout ) ;
}
long freeSpaceOS ( final String path , final int os , final boolean kb , final long timeout ) throws IOException {
if ( path == null ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
switch ( os ) {
case WINDOWS :
return kb ? freeSpaceWindows ( path , timeout ) / FileUtils . ONE_KB : freeSpaceWindows ( path , timeout ) ; MST[NonVoidMethodCallMutator]MSP[N]
case UNIX :
return freeSpaceUnix ( path , kb , false , timeout ) ;
case POSIX_UNIX :
return freeSpaceUnix ( path , kb , true , timeout ) ;
case OTHER :
throw new IllegalStateException ( lr_3 ) ;
default:
throw new IllegalStateException (
lr_4 ) ;
}
}
long freeSpaceWindows ( final String path , final long timeout ) throws IOException {
String normPath = FilenameUtils . normalize ( path , false ) ;
if ( normPath == null ) {
throw new IllegalArgumentException ( path ) ;
}
if ( normPath . length () > 0 && normPath . charAt ( 0 ) != '"' ) {
normPath = lr_5 + normPath + lr_5 ;
}
final String [] cmdAttribs = new String [] { lr_6 , lr_7 , lr_8 + normPath } ;
final List < String > lines = performCommand ( cmdAttribs , Integer . MAX_VALUE , timeout ) ;
for ( int i = lines . size () - 1 ; i >= 0 ; i -- ) {
final String line = lines . get ( i ) ;
if ( line . length () > 0 ) {
return parseDir ( line , normPath ) ;
}
}
throw new IOException (
lr_9 +
lr_10 + normPath + lr_11 ) ;
}
long parseDir ( final String line , final String path ) throws IOException {
int bytesStart = 0 ;
int bytesEnd = 0 ;
int j = line . length () - 1 ;
innerLoop1: while ( j >= 0 ) {
final char c = line . charAt ( j ) ;
if ( Character . isDigit ( c ) ) {
bytesEnd = j + 1 ;
break innerLoop1;
}
j -- ;
}
innerLoop2: while ( j >= 0 ) {
final char c = line . charAt ( j ) ;
if ( ! Character . isDigit ( c ) && c != ',' && c != '.' ) {
bytesStart = j + 1 ;
break innerLoop2;
}
j -- ;
}
if ( j < 0 ) {
throw new IOException (
lr_12 +
lr_10 + path + lr_11 ) ;
}
final StringBuilder buf = new StringBuilder ( line . substring ( bytesStart , bytesEnd ) ) ;
for ( int k = 0 ; k < buf . length () ; k ++ ) {
if ( buf . charAt ( k ) == ',' || buf . charAt ( k ) == '.' ) {
buf . deleteCharAt ( k -- ) ;
}
}
return parseBytes ( buf . toString () , path ) ;
}
long freeSpaceUnix ( final String path , final boolean kb , final boolean posix , final long timeout )
throws IOException {
if ( path . isEmpty () ) {
throw new IllegalArgumentException ( lr_13 ) ;
}
String flags = lr_14 ;
if ( kb ) {
flags += lr_15 ;
}
if ( posix ) {
flags += lr_16 ;
}
final String [] cmdAttribs =
flags . length () > 1 ? new String [] { DF , flags , path } : new String [] { DF , path } ;
final List < String > lines = performCommand ( cmdAttribs , 3 , timeout ) ;
if ( lines . size () < 2 ) {
throw new IOException (
lr_17 + DF + lr_18 +
lr_10 + path + lr_19 + lines ) ;
}
final String line2 = lines . get ( 1 ) ;
StringTokenizer tok = new StringTokenizer ( line2 , lr_20 ) ;
if ( tok . countTokens () < 4 ) {
if ( tok . countTokens () == 1 && lines . size () >= 3 ) {
final String line3 = lines . get ( 2 ) ;
tok = new StringTokenizer ( line3 , lr_20 ) ;
} else {
throw new IOException (
lr_17 + DF + lr_21 +
lr_10 + path + lr_22 ) ;
}
} else {
tok . nextToken () ;
}
tok . nextToken () ;
tok . nextToken () ;
final String freeSpace = tok . nextToken () ;
return parseBytes ( freeSpace , path ) ;
}
long parseBytes ( final String freeSpace , final String path ) throws IOException {
try {
final long bytes = Long . parseLong ( freeSpace ) ;
if ( bytes < 0 ) {
throw new IOException (
lr_17 + DF + lr_23 +
lr_10 + path + lr_22 ) ;
}
return bytes ;
} catch ( final NumberFormatException ex ) {
throw new IOException (
lr_17 + DF + lr_24 +
lr_10 + path + lr_22 , ex ) ;
}
}
List < String > performCommand ( final String [] cmdAttribs , final int max , final long timeout ) throws IOException {
final List < String > lines = new ArrayList <> ( 20 ) ;
Process proc = null ;
InputStream in = null ;
OutputStream out = null ;
InputStream err = null ;
BufferedReader inr = null ;
try {
final Thread monitor = ThreadMonitor . start ( timeout ) ;
proc = openProcess ( cmdAttribs ) ;
in = proc . getInputStream () ;
out = proc . getOutputStream () ;
err = proc . getErrorStream () ;
inr = new BufferedReader ( new InputStreamReader ( in , Charset . defaultCharset () ) ) ;
String line = inr . readLine () ;
while ( line != null && lines . size () < max ) {
line = line . toLowerCase ( Locale . ENGLISH ) . trim () ;
lines . add ( line ) ;
line = inr . readLine () ;
}
proc . waitFor () ;
ThreadMonitor . stop ( monitor ) ;
if ( proc . exitValue () != 0 ) {
throw new IOException (
lr_25 + proc . exitValue () +
lr_26 + Arrays . asList ( cmdAttribs ) ) ;
}
if ( lines . isEmpty () ) {
throw new IOException (
lr_27 +
lr_28 + Arrays . asList ( cmdAttribs ) ) ;
}
inr . close () ;
inr = null ;
in . close () ;
in = null ;
if ( out != null ) {
out . close () ;
out = null ;
}
if ( err != null ) {
err . close () ;
err = null ;
}
return lines ;
} catch ( final InterruptedException ex ) {
throw new IOException (
lr_29 +
lr_28 + Arrays . asList ( cmdAttribs ) + lr_30 + timeout , ex ) ;
} finally {
IOUtils . closeQuietly ( in ) ;
IOUtils . closeQuietly ( out ) ;
IOUtils . closeQuietly ( err ) ;
IOUtils . closeQuietly ( inr ) ;
if ( proc != null ) {
proc . destroy () ;
}
}
}
Process openProcess ( final String [] cmdAttribs ) throws IOException {
return Runtime . getRuntime () . exec ( cmdAttribs ) ;
}

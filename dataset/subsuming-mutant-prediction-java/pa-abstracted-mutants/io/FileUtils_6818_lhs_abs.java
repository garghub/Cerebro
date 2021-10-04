public static File getFile ( final File directory , final String ... names ) {
if ( directory == null ) {
throw new NullPointerException ( lr_1 ) ;
}
if ( names == null ) {
throw new NullPointerException ( lr_2 ) ;
}
File file = directory ;
for ( final String name : names ) {
file = new File ( file , name ) ;
}
return file ;
}
public static File getFile ( final String ... names ) {
if ( names == null ) {
throw new NullPointerException ( lr_2 ) ;
}
File file = null ;
for ( final String name : names ) {
if ( file == null ) {
file = new File ( name ) ;
} else {
file = new File ( file , name ) ;
}
}
return file ;
}
public static String getTempDirectoryPath () {
return System . getProperty ( lr_3 ) ;
}
public static File getTempDirectory () {
return new File ( getTempDirectoryPath () ) ;
}
public static String getUserDirectoryPath () {
return System . getProperty ( lr_4 ) ;
}
public static File getUserDirectory () {
return new File ( getUserDirectoryPath () ) ;
}
public static FileInputStream openInputStream ( final File file ) throws IOException {
if ( file . exists () ) { MST[NonVoidMethodCallMutator]MSP[]
if ( file . isDirectory () ) {
throw new IOException ( lr_5 + file + lr_6 ) ;
}
if ( file . canRead () == false ) {
throw new IOException ( lr_5 + file + lr_7 ) ;
}
} else {
throw new FileNotFoundException ( lr_5 + file + lr_8 ) ;
}
return new FileInputStream ( file ) ;
}
public static FileOutputStream openOutputStream ( final File file ) throws IOException {
return openOutputStream ( file , false ) ;
}
public static FileOutputStream openOutputStream ( final File file , final boolean append ) throws IOException {
if ( file . exists () ) {
if ( file . isDirectory () ) {
throw new IOException ( lr_5 + file + lr_6 ) ;
}
if ( file . canWrite () == false ) {
throw new IOException ( lr_5 + file + lr_9 ) ;
}
} else {
final File parent = file . getParentFile () ;
if ( parent != null ) {
if ( ! parent . mkdirs () && ! parent . isDirectory () ) {
throw new IOException ( lr_10 + parent + lr_11 ) ;
}
}
}
return new FileOutputStream ( file , append ) ;
}
public static String byteCountToDisplaySize ( final BigInteger size ) {
String displaySize ;
if ( size . divide ( ONE_EB_BI ) . compareTo ( BigInteger . ZERO ) > 0 ) {
displaySize = String . valueOf ( size . divide ( ONE_EB_BI ) ) + lr_12 ;
} else if ( size . divide ( ONE_PB_BI ) . compareTo ( BigInteger . ZERO ) > 0 ) {
displaySize = String . valueOf ( size . divide ( ONE_PB_BI ) ) + lr_13 ;
} else if ( size . divide ( ONE_TB_BI ) . compareTo ( BigInteger . ZERO ) > 0 ) {
displaySize = String . valueOf ( size . divide ( ONE_TB_BI ) ) + lr_14 ;
} else if ( size . divide ( ONE_GB_BI ) . compareTo ( BigInteger . ZERO ) > 0 ) {
displaySize = String . valueOf ( size . divide ( ONE_GB_BI ) ) + lr_15 ;
} else if ( size . divide ( ONE_MB_BI ) . compareTo ( BigInteger . ZERO ) > 0 ) {
displaySize = String . valueOf ( size . divide ( ONE_MB_BI ) ) + lr_16 ;
} else if ( size . divide ( ONE_KB_BI ) . compareTo ( BigInteger . ZERO ) > 0 ) {
displaySize = String . valueOf ( size . divide ( ONE_KB_BI ) ) + lr_17 ;
} else {
displaySize = String . valueOf ( size ) + lr_18 ;
}
return displaySize ;
}
public static String byteCountToDisplaySize ( final long size ) {
return byteCountToDisplaySize ( BigInteger . valueOf ( size ) ) ;
}
public static void touch ( final File file ) throws IOException {
if ( ! file . exists () ) {
openOutputStream ( file ) . close () ;
}
final boolean success = file . setLastModified ( System . currentTimeMillis () ) ;
if ( ! success ) {
throw new IOException ( lr_19 + file ) ;
}
}
public static File [] convertFileCollectionToFileArray ( final Collection < File > files ) {
return files . toArray ( new File [ files . size () ] ) ;
}
private static void innerListFiles ( final Collection < File > files , final File directory ,
final IOFileFilter filter , final boolean includeSubDirectories ) {
final File [] found = directory . listFiles ( ( FileFilter ) filter ) ;
if ( found != null ) {
for ( final File file : found ) {
if ( file . isDirectory () ) {
if ( includeSubDirectories ) {
files . add ( file ) ;
}
innerListFiles ( files , file , filter , includeSubDirectories ) ;
} else {
files . add ( file ) ;
}
}
}
}
public static Collection < File > listFiles (
final File directory , final IOFileFilter fileFilter , final IOFileFilter dirFilter ) {
return innerListFilesOrDirectories ( directory , fileFilter , dirFilter , false ) ;
}
private static void validateListFilesParameters ( final File directory , final IOFileFilter fileFilter ) {
if ( ! directory . isDirectory () ) {
throw new IllegalArgumentException ( lr_20 + directory ) ;
}
if ( fileFilter == null ) {
throw new NullPointerException ( lr_21 ) ;
}
}
private static IOFileFilter setUpEffectiveFileFilter ( final IOFileFilter fileFilter ) {
return FileFilterUtils . and ( fileFilter , FileFilterUtils . notFileFilter ( DirectoryFileFilter . INSTANCE ) ) ;
}
private static IOFileFilter setUpEffectiveDirFilter ( final IOFileFilter dirFilter ) {
return dirFilter == null ? FalseFileFilter . INSTANCE : FileFilterUtils . and ( dirFilter ,
DirectoryFileFilter . INSTANCE ) ;
}
public static Collection < File > listFilesAndDirs (
final File directory , final IOFileFilter fileFilter , final IOFileFilter dirFilter ) {
return innerListFilesOrDirectories ( directory , fileFilter , dirFilter , true ) ;
}
private static Collection < File > innerListFilesOrDirectories (
final File directory , final IOFileFilter fileFilter , final IOFileFilter dirFilter ,
final boolean includeSubDirectories ) {
validateListFilesParameters ( directory , fileFilter ) ;
final IOFileFilter effFileFilter = setUpEffectiveFileFilter ( fileFilter ) ;
final IOFileFilter effDirFilter = setUpEffectiveDirFilter ( dirFilter ) ;
final Collection < File > files = new java . util . LinkedList <> () ;
if ( includeSubDirectories ) {
files . add ( directory ) ;
}
innerListFiles ( files , directory ,
FileFilterUtils . or ( effFileFilter , effDirFilter ) , includeSubDirectories ) ;
return files ;
}
public static Iterator < File > iterateFiles (
final File directory , final IOFileFilter fileFilter , final IOFileFilter dirFilter ) {
return listFiles ( directory , fileFilter , dirFilter ) . iterator () ;
}
public static Iterator < File > iterateFilesAndDirs ( final File directory , final IOFileFilter fileFilter ,
final IOFileFilter dirFilter ) {
return listFilesAndDirs ( directory , fileFilter , dirFilter ) . iterator () ;
}
private static String [] toSuffixes ( final String [] extensions ) {
final String [] suffixes = new String [ extensions . length ] ;
for ( int i = 0 ; i < extensions . length ; i ++ ) {
suffixes [ i ] = lr_22 + extensions [ i ] ;
}
return suffixes ;
}
public static Collection < File > listFiles (
final File directory , final String [] extensions , final boolean recursive ) {
IOFileFilter filter ;
if ( extensions == null ) {
filter = TrueFileFilter . INSTANCE ;
} else {
final String [] suffixes = toSuffixes ( extensions ) ;
filter = new SuffixFileFilter ( suffixes ) ;
}
return listFiles ( directory , filter ,
recursive ? TrueFileFilter . INSTANCE : FalseFileFilter . INSTANCE ) ;
}
public static Iterator < File > iterateFiles (
final File directory , final String [] extensions , final boolean recursive ) {
return listFiles ( directory , extensions , recursive ) . iterator () ;
}
public static boolean contentEquals ( final File file1 , final File file2 ) throws IOException {
final boolean file1Exists = file1 . exists () ;
if ( file1Exists != file2 . exists () ) {
return false ;
}
if ( ! file1Exists ) {
return true ;
}
if ( file1 . isDirectory () || file2 . isDirectory () ) {
throw new IOException ( lr_23 ) ;
}
if ( file1 . length () != file2 . length () ) {
return false ;
}
if ( file1 . getCanonicalFile () . equals ( file2 . getCanonicalFile () ) ) {
return true ;
}
try ( InputStream input1 = new FileInputStream ( file1 ) ;
InputStream input2 = new FileInputStream ( file2 ) ) {
return IOUtils . contentEquals ( input1 , input2 ) ;
}
}
public static boolean contentEqualsIgnoreEOL ( final File file1 , final File file2 , final String charsetName )
throws IOException {
final boolean file1Exists = file1 . exists () ;
if ( file1Exists != file2 . exists () ) {
return false ;
}
if ( ! file1Exists ) {
return true ;
}
if ( file1 . isDirectory () || file2 . isDirectory () ) {
throw new IOException ( lr_23 ) ;
}
if ( file1 . getCanonicalFile () . equals ( file2 . getCanonicalFile () ) ) {
return true ;
}
try ( Reader input1 = charsetName == null
? new InputStreamReader ( new FileInputStream ( file1 ) , Charset . defaultCharset () )
: new InputStreamReader ( new FileInputStream ( file1 ) , charsetName ) ;
Reader input2 = charsetName == null
? new InputStreamReader ( new FileInputStream ( file2 ) , Charset . defaultCharset () )
: new InputStreamReader ( new FileInputStream ( file2 ) , charsetName ) ) {
return IOUtils . contentEqualsIgnoreEOL ( input1 , input2 ) ;
}
}
public static File toFile ( final URL url ) {
if ( url == null || ! lr_24 . equalsIgnoreCase ( url . getProtocol () ) ) {
return null ;
}
String filename = url . getFile () . replace ( '/' , File . separatorChar ) ;
filename = decodeUrl ( filename ) ;
return new File ( filename ) ;
}
static String decodeUrl ( final String url ) {
String decoded = url ;
if ( url != null && url . indexOf ( '%' ) >= 0 ) {
final int n = url . length () ;
final StringBuilder buffer = new StringBuilder () ;
final ByteBuffer bytes = ByteBuffer . allocate ( n ) ;
for ( int i = 0 ; i < n ; ) {
if ( url . charAt ( i ) == '%' ) {
try {
do {
final byte octet = ( byte ) Integer . parseInt ( url . substring ( i + 1 , i + 3 ) , 16 ) ;
bytes . put ( octet ) ;
i += 3 ;
} while ( i < n && url . charAt ( i ) == '%' );
continue;
} catch ( final RuntimeException e ) {
} finally {
if ( bytes . position () > 0 ) {
bytes . flip () ;
buffer . append ( StandardCharsets . UTF_8 . decode ( bytes ) . toString () ) ;
bytes . clear () ;
}
}
}
buffer . append ( url . charAt ( i ++ ) ) ;
}
decoded = buffer . toString () ;
}
return decoded ;
}
public static File [] toFiles ( final URL [] urls ) {
if ( urls == null || urls . length == 0 ) {
return EMPTY_FILE_ARRAY ;
}
final File [] files = new File [ urls . length ] ;
for ( int i = 0 ; i < urls . length ; i ++ ) {
final URL url = urls [ i ] ;
if ( url != null ) {
if ( url . getProtocol () . equals ( lr_24 ) == false ) {
throw new IllegalArgumentException (
lr_25 + url ) ;
}
files [ i ] = toFile ( url ) ;
}
}
return files ;
}
public static URL [] toURLs ( final File [] files ) throws IOException {
final URL [] urls = new URL [ files . length ] ;
for ( int i = 0 ; i < urls . length ; i ++ ) {
urls [ i ] = files [ i ] . toURI () . toURL () ;
}
return urls ;
}
public static void copyFileToDirectory ( final File srcFile , final File destDir ) throws IOException {
copyFileToDirectory ( srcFile , destDir , true ) ;
}
public static void copyFileToDirectory ( final File srcFile , final File destDir , final boolean preserveFileDate )
throws IOException {
if ( destDir == null ) {
throw new NullPointerException ( lr_26 ) ;
}
if ( destDir . exists () && destDir . isDirectory () == false ) {
throw new IllegalArgumentException ( lr_27 + destDir + lr_28 ) ;
}
final File destFile = new File ( destDir , srcFile . getName () ) ;
copyFile ( srcFile , destFile , preserveFileDate ) ;
}
public static void copyFile ( final File srcFile , final File destFile ) throws IOException {
copyFile ( srcFile , destFile , true ) ;
}
public static void copyFile ( final File srcFile , final File destFile ,
final boolean preserveFileDate ) throws IOException {
checkFileRequirements ( srcFile , destFile ) ;
if ( srcFile . isDirectory () ) {
throw new IOException ( lr_29 + srcFile + lr_6 ) ;
}
if ( srcFile . getCanonicalPath () . equals ( destFile . getCanonicalPath () ) ) {
throw new IOException ( lr_29 + srcFile + lr_30 + destFile + lr_31 ) ;
}
final File parentFile = destFile . getParentFile () ;
if ( parentFile != null ) {
if ( ! parentFile . mkdirs () && ! parentFile . isDirectory () ) {
throw new IOException ( lr_27 + parentFile + lr_32 ) ;
}
}
if ( destFile . exists () && destFile . canWrite () == false ) {
throw new IOException ( lr_27 + destFile + lr_33 ) ;
}
doCopyFile ( srcFile , destFile , preserveFileDate ) ;
}
public static long copyFile ( final File input , final OutputStream output ) throws IOException {
try ( FileInputStream fis = new FileInputStream ( input ) ) {
return IOUtils . copyLarge ( fis , output ) ;
}
}
private static void doCopyFile ( final File srcFile , final File destFile , final boolean preserveFileDate )
throws IOException {
if ( destFile . exists () && destFile . isDirectory () ) {
throw new IOException ( lr_27 + destFile + lr_6 ) ;
}
final Path srcPath = srcFile . toPath () ;
final Path destPath = destFile . toPath () ;
final long newLastModifed = preserveFileDate ? srcFile . lastModified () : destFile . lastModified () ;
Files . copy ( srcPath , destPath , StandardCopyOption . REPLACE_EXISTING ) ;
checkEqualSizes ( srcFile , destFile , Files . size ( srcPath ) , Files . size ( destPath ) ) ;
checkEqualSizes ( srcFile , destFile , srcFile . length () , destFile . length () ) ;
destFile . setLastModified ( newLastModifed ) ;
}
private static void checkEqualSizes ( final File srcFile , final File destFile , final long srcLen , final long dstLen )
throws IOException {
if ( srcLen != dstLen ) {
throw new IOException ( lr_34 + srcFile + lr_35 + destFile
+ lr_36 + srcLen + lr_37 + dstLen ) ;
}
}
public static void copyDirectoryToDirectory ( final File srcDir , final File destDir ) throws IOException {
if ( srcDir == null ) {
throw new NullPointerException ( lr_38 ) ;
}
if ( srcDir . exists () && srcDir . isDirectory () == false ) {
throw new IllegalArgumentException ( lr_29 + destDir + lr_28 ) ;
}
if ( destDir == null ) {
throw new NullPointerException ( lr_26 ) ;
}
if ( destDir . exists () && destDir . isDirectory () == false ) {
throw new IllegalArgumentException ( lr_27 + destDir + lr_28 ) ;
}
copyDirectory ( srcDir , new File ( destDir , srcDir . getName () ) , true ) ;
}
public static void copyDirectory ( final File srcDir , final File destDir ) throws IOException {
copyDirectory ( srcDir , destDir , true ) ;
}
public static void copyDirectory ( final File srcDir , final File destDir ,
final boolean preserveFileDate ) throws IOException {
copyDirectory ( srcDir , destDir , null , preserveFileDate ) ;
}
public static void copyDirectory ( final File srcDir , final File destDir ,
final FileFilter filter ) throws IOException {
copyDirectory ( srcDir , destDir , filter , true ) ;
}
public static void copyDirectory ( final File srcDir , final File destDir ,
final FileFilter filter , final boolean preserveFileDate ) throws IOException {
checkFileRequirements ( srcDir , destDir ) ;
if ( ! srcDir . isDirectory () ) {
throw new IOException ( lr_29 + srcDir + lr_39 ) ;
}
if ( srcDir . getCanonicalPath () . equals ( destDir . getCanonicalPath () ) ) {
throw new IOException ( lr_29 + srcDir + lr_30 + destDir + lr_31 ) ;
}
List < String > exclusionList = null ;
if ( destDir . getCanonicalPath () . startsWith ( srcDir . getCanonicalPath () ) ) {
final File [] srcFiles = filter == null ? srcDir . listFiles () : srcDir . listFiles ( filter ) ;
if ( srcFiles != null && srcFiles . length > 0 ) {
exclusionList = new ArrayList <> ( srcFiles . length ) ;
for ( final File srcFile : srcFiles ) {
final File copiedFile = new File ( destDir , srcFile . getName () ) ;
exclusionList . add ( copiedFile . getCanonicalPath () ) ;
}
}
}
doCopyDirectory ( srcDir , destDir , filter , preserveFileDate , exclusionList ) ;
}
private static void checkFileRequirements ( final File src , final File dest ) throws FileNotFoundException {
if ( src == null ) {
throw new NullPointerException ( lr_38 ) ;
}
if ( dest == null ) {
throw new NullPointerException ( lr_26 ) ;
}
if ( ! src . exists () ) {
throw new FileNotFoundException ( lr_29 + src + lr_8 ) ;
}
}
private static void doCopyDirectory ( final File srcDir , final File destDir , final FileFilter filter ,
final boolean preserveFileDate , final List < String > exclusionList )
throws IOException {
final File [] srcFiles = filter == null ? srcDir . listFiles () : srcDir . listFiles ( filter ) ;
if ( srcFiles == null ) {
throw new IOException ( lr_40 + srcDir ) ;
}
if ( destDir . exists () ) {
if ( destDir . isDirectory () == false ) {
throw new IOException ( lr_27 + destDir + lr_39 ) ;
}
} else {
if ( ! destDir . mkdirs () && ! destDir . isDirectory () ) {
throw new IOException ( lr_27 + destDir + lr_32 ) ;
}
}
if ( destDir . canWrite () == false ) {
throw new IOException ( lr_27 + destDir + lr_9 ) ;
}
for ( final File srcFile : srcFiles ) {
final File dstFile = new File ( destDir , srcFile . getName () ) ;
if ( exclusionList == null || ! exclusionList . contains ( srcFile . getCanonicalPath () ) ) {
if ( srcFile . isDirectory () ) {
doCopyDirectory ( srcFile , dstFile , filter , preserveFileDate , exclusionList ) ;
} else {
doCopyFile ( srcFile , dstFile , preserveFileDate ) ;
}
}
}
if ( preserveFileDate ) {
destDir . setLastModified ( srcDir . lastModified () ) ;
}
}
public static void copyURLToFile ( final URL source , final File destination ) throws IOException {
copyInputStreamToFile ( source . openStream () , destination ) ;
}
public static void copyURLToFile ( final URL source , final File destination ,
final int connectionTimeout , final int readTimeout ) throws IOException {
final URLConnection connection = source . openConnection () ;
connection . setConnectTimeout ( connectionTimeout ) ;
connection . setReadTimeout ( readTimeout ) ;
copyInputStreamToFile ( connection . getInputStream () , destination ) ;
}
public static void copyInputStreamToFile ( final InputStream source , final File destination ) throws IOException {
try ( InputStream in = source ) {
copyToFile ( in , destination ) ;
}
}
public static void copyToFile ( final InputStream source , final File destination ) throws IOException {
try ( OutputStream out = openOutputStream ( destination ) ) {
IOUtils . copy ( source , out ) ;
}
}
public static void copyToDirectory ( final File src , final File destDir ) throws IOException {
if ( src == null ) {
throw new NullPointerException ( lr_38 ) ;
}
if ( src . isFile () ) {
copyFileToDirectory ( src , destDir ) ;
} else if ( src . isDirectory () ) {
copyDirectoryToDirectory ( src , destDir ) ;
} else {
throw new IOException ( lr_41 + src + lr_42 ) ;
}
}
public static void copyToDirectory ( final Iterable < File > srcs , final File destDir ) throws IOException {
if ( srcs == null ) {
throw new NullPointerException ( lr_43 ) ;
}
for ( final File src : srcs ) {
copyFileToDirectory ( src , destDir ) ;
}
}
public static void deleteDirectory ( final File directory ) throws IOException {
if ( ! directory . exists () ) {
return;
}
if ( ! isSymlink ( directory ) ) {
cleanDirectory ( directory ) ;
}
if ( ! directory . delete () ) {
final String message =
lr_44 + directory + lr_22 ;
throw new IOException ( message ) ;
}
}
public static boolean deleteQuietly ( final File file ) {
if ( file == null ) {
return false ;
}
try {
if ( file . isDirectory () ) {
cleanDirectory ( file ) ;
}
} catch ( final Exception ignored ) {
}
try {
return file . delete () ;
} catch ( final Exception ignored ) {
return false ;
}
}
public static boolean directoryContains ( final File directory , final File child ) throws IOException {
if ( directory == null ) {
throw new IllegalArgumentException ( lr_45 ) ;
}
if ( ! directory . isDirectory () ) {
throw new IllegalArgumentException ( lr_46 + directory ) ;
}
if ( child == null ) {
return false ;
}
if ( ! directory . exists () || ! child . exists () ) {
return false ;
}
final String canonicalParent = directory . getCanonicalPath () ;
final String canonicalChild = child . getCanonicalPath () ;
return FilenameUtils . directoryContains ( canonicalParent , canonicalChild ) ;
}
public static void cleanDirectory ( final File directory ) throws IOException {
final File [] files = verifiedListFiles ( directory ) ;
IOException exception = null ;
for ( final File file : files ) {
try {
forceDelete ( file ) ;
} catch ( final IOException ioe ) {
exception = ioe ;
}
}
if ( null != exception ) {
throw exception ;
}
}
private static File [] verifiedListFiles ( final File directory ) throws IOException {
if ( ! directory . exists () ) {
final String message = directory + lr_42 ;
throw new IllegalArgumentException ( message ) ;
}
if ( ! directory . isDirectory () ) {
final String message = directory + lr_47 ;
throw new IllegalArgumentException ( message ) ;
}
final File [] files = directory . listFiles () ;
if ( files == null ) {
throw new IOException ( lr_40 + directory ) ;
}
return files ;
}
public static boolean waitFor ( final File file , final int seconds ) {
final long finishAt = System . currentTimeMillis () + ( seconds * 1000L ) ;
boolean wasInterrupted = false ;
try {
while ( ! file . exists () ) {
final long remaining = finishAt - System . currentTimeMillis () ;
if ( remaining < 0 ) {
return false ;
}
try {
Thread . sleep ( Math . min ( 100 , remaining ) ) ;
} catch ( final InterruptedException ignore ) {
wasInterrupted = true ;
} catch ( final Exception ex ) {
break;
}
}
} finally {
if ( wasInterrupted ) {
Thread . currentThread () . interrupt () ;
}
}
return true ;
}
public static String readFileToString ( final File file , final Charset encoding ) throws IOException {
try ( InputStream in = openInputStream ( file ) ) {
return IOUtils . toString ( in , Charsets . toCharset ( encoding ) ) ;
}
}
public static String readFileToString ( final File file , final String encoding ) throws IOException {
return readFileToString ( file , Charsets . toCharset ( encoding ) ) ;
}
@Deprecated
public static String readFileToString ( final File file ) throws IOException {
return readFileToString ( file , Charset . defaultCharset () ) ;
}
public static byte [] readFileToByteArray ( final File file ) throws IOException {
try ( InputStream in = openInputStream ( file ) ) {
final long fileLength = file . length () ;
return fileLength > 0 ? IOUtils . toByteArray ( in , fileLength ) : IOUtils . toByteArray ( in ) ;
}
}
public static List < String > readLines ( final File file , final Charset encoding ) throws IOException {
try ( InputStream in = openInputStream ( file ) ) {
return IOUtils . readLines ( in , Charsets . toCharset ( encoding ) ) ;
}
}
public static List < String > readLines ( final File file , final String encoding ) throws IOException {
return readLines ( file , Charsets . toCharset ( encoding ) ) ;
}
@Deprecated
public static List < String > readLines ( final File file ) throws IOException {
return readLines ( file , Charset . defaultCharset () ) ;
}
public static LineIterator lineIterator ( final File file , final String encoding ) throws IOException {
InputStream in = null ;
try {
in = openInputStream ( file ) ;
return IOUtils . lineIterator ( in , encoding ) ;
} catch ( final IOException | RuntimeException ex ) {
try {
if ( in != null ) {
in . close () ;
}
}
catch ( final IOException e ) {
ex . addSuppressed ( e ) ;
}
throw ex ;
}
}
public static LineIterator lineIterator ( final File file ) throws IOException {
return lineIterator ( file , null ) ;
}
public static void writeStringToFile ( final File file , final String data , final Charset encoding )
throws IOException {
writeStringToFile ( file , data , encoding , false ) ;
}
public static void writeStringToFile ( final File file , final String data , final String encoding ) throws IOException {
writeStringToFile ( file , data , encoding , false ) ;
}
public static void writeStringToFile ( final File file , final String data , final Charset encoding ,
final boolean append ) throws IOException {
try ( OutputStream out = openOutputStream ( file , append ) ) {
IOUtils . write ( data , out , encoding ) ;
}
}
public static void writeStringToFile ( final File file , final String data , final String encoding ,
final boolean append ) throws IOException {
writeStringToFile ( file , data , Charsets . toCharset ( encoding ) , append ) ;
}
@Deprecated
public static void writeStringToFile ( final File file , final String data ) throws IOException {
writeStringToFile ( file , data , Charset . defaultCharset () , false ) ;
}
@Deprecated
public static void writeStringToFile ( final File file , final String data , final boolean append ) throws IOException {
writeStringToFile ( file , data , Charset . defaultCharset () , append ) ;
}
@Deprecated
public static void write ( final File file , final CharSequence data ) throws IOException {
write ( file , data , Charset . defaultCharset () , false ) ;
}
@Deprecated
public static void write ( final File file , final CharSequence data , final boolean append ) throws IOException {
write ( file , data , Charset . defaultCharset () , append ) ;
}
public static void write ( final File file , final CharSequence data , final Charset encoding ) throws IOException {
write ( file , data , encoding , false ) ;
}
public static void write ( final File file , final CharSequence data , final String encoding ) throws IOException {
write ( file , data , encoding , false ) ;
}
public static void write ( final File file , final CharSequence data , final Charset encoding , final boolean append )
throws IOException {
final String str = data == null ? null : data . toString () ;
writeStringToFile ( file , str , encoding , append ) ;
}
public static void write ( final File file , final CharSequence data , final String encoding , final boolean append )
throws IOException {
write ( file , data , Charsets . toCharset ( encoding ) , append ) ;
}
public static void writeByteArrayToFile ( final File file , final byte [] data ) throws IOException {
writeByteArrayToFile ( file , data , false ) ;
}
public static void writeByteArrayToFile ( final File file , final byte [] data , final boolean append )
throws IOException {
writeByteArrayToFile ( file , data , 0 , data . length , append ) ;
}
public static void writeByteArrayToFile ( final File file , final byte [] data , final int off , final int len )
throws IOException {
writeByteArrayToFile ( file , data , off , len , false ) ;
}
public static void writeByteArrayToFile ( final File file , final byte [] data , final int off , final int len ,
final boolean append ) throws IOException {
try ( OutputStream out = openOutputStream ( file , append ) ) {
out . write ( data , off , len ) ;
}
}
public static void writeLines ( final File file , final String encoding , final Collection < ? > lines )
throws IOException {
writeLines ( file , encoding , lines , null , false ) ;
}
public static void writeLines ( final File file , final String encoding , final Collection < ? > lines ,
final boolean append ) throws IOException {
writeLines ( file , encoding , lines , null , append ) ;
}
public static void writeLines ( final File file , final Collection < ? > lines ) throws IOException {
writeLines ( file , null , lines , null , false ) ;
}
public static void writeLines ( final File file , final Collection < ? > lines , final boolean append ) throws IOException {
writeLines ( file , null , lines , null , append ) ;
}
public static void writeLines ( final File file , final String encoding , final Collection < ? > lines ,
final String lineEnding ) throws IOException {
writeLines ( file , encoding , lines , lineEnding , false ) ;
}
public static void writeLines ( final File file , final String encoding , final Collection < ? > lines ,
final String lineEnding , final boolean append ) throws IOException {
try ( OutputStream out = new BufferedOutputStream ( openOutputStream ( file , append ) ) ) {
IOUtils . writeLines ( lines , lineEnding , out , encoding ) ;
}
}
public static void writeLines ( final File file , final Collection < ? > lines , final String lineEnding )
throws IOException {
writeLines ( file , null , lines , lineEnding , false ) ;
}
public static void writeLines ( final File file , final Collection < ? > lines , final String lineEnding ,
final boolean append ) throws IOException {
writeLines ( file , null , lines , lineEnding , append ) ;
}
public static void forceDelete ( final File file ) throws IOException {
if ( file . isDirectory () ) {
deleteDirectory ( file ) ;
} else {
final boolean filePresent = file . exists () ;
if ( ! file . delete () ) {
if ( ! filePresent ) {
throw new FileNotFoundException ( lr_48 + file ) ;
}
final String message =
lr_49 + file ;
throw new IOException ( message ) ;
}
}
}
public static void forceDeleteOnExit ( final File file ) throws IOException {
if ( file . isDirectory () ) {
deleteDirectoryOnExit ( file ) ;
} else {
file . deleteOnExit () ;
}
}
private static void deleteDirectoryOnExit ( final File directory ) throws IOException {
if ( ! directory . exists () ) {
return;
}
directory . deleteOnExit () ;
if ( ! isSymlink ( directory ) ) {
cleanDirectoryOnExit ( directory ) ;
}
}
private static void cleanDirectoryOnExit ( final File directory ) throws IOException {
final File [] files = verifiedListFiles ( directory ) ;
IOException exception = null ;
for ( final File file : files ) {
try {
forceDeleteOnExit ( file ) ;
} catch ( final IOException ioe ) {
exception = ioe ;
}
}
if ( null != exception ) {
throw exception ;
}
}
public static void forceMkdir ( final File directory ) throws IOException {
if ( directory . exists () ) {
if ( ! directory . isDirectory () ) {
final String message =
lr_50
+ directory
+ lr_51
+ lr_52 ;
throw new IOException ( message ) ;
}
} else {
if ( ! directory . mkdirs () ) {
if ( ! directory . isDirectory () ) {
final String message =
lr_53 + directory ;
throw new IOException ( message ) ;
}
}
}
}
public static void forceMkdirParent ( final File file ) throws IOException {
final File parent = file . getParentFile () ;
if ( parent == null ) {
return;
}
forceMkdir ( parent ) ;
}
public static long sizeOf ( final File file ) {
if ( ! file . exists () ) {
final String message = file + lr_42 ;
throw new IllegalArgumentException ( message ) ;
}
if ( file . isDirectory () ) {
return sizeOfDirectory0 ( file ) ;
}
return file . length () ;
}
public static BigInteger sizeOfAsBigInteger ( final File file ) {
if ( ! file . exists () ) {
final String message = file + lr_42 ;
throw new IllegalArgumentException ( message ) ;
}
if ( file . isDirectory () ) {
return sizeOfDirectoryBig0 ( file ) ;
}
return BigInteger . valueOf ( file . length () ) ;
}
public static long sizeOfDirectory ( final File directory ) {
checkDirectory ( directory ) ;
return sizeOfDirectory0 ( directory ) ;
}
private static long sizeOfDirectory0 ( final File directory ) {
final File [] files = directory . listFiles () ;
if ( files == null ) {
return 0L ;
}
long size = 0 ;
for ( final File file : files ) {
if ( ! isSymlink ( file ) ) {
size += sizeOf0 ( file ) ;
if ( size < 0 ) {
break;
}
}
}
return size ;
}
private static long sizeOf0 ( final File file ) {
if ( file . isDirectory () ) {
return sizeOfDirectory0 ( file ) ;
}
return file . length () ;
}
public static BigInteger sizeOfDirectoryAsBigInteger ( final File directory ) {
checkDirectory ( directory ) ;
return sizeOfDirectoryBig0 ( directory ) ;
}
private static BigInteger sizeOfDirectoryBig0 ( final File directory ) {
final File [] files = directory . listFiles () ;
if ( files == null ) {
return BigInteger . ZERO ;
}
BigInteger size = BigInteger . ZERO ;
for ( final File file : files ) {
if ( ! isSymlink ( file ) ) {
size = size . add ( sizeOfBig0 ( file ) ) ;
}
}
return size ;
}
private static BigInteger sizeOfBig0 ( final File fileOrDir ) {
if ( fileOrDir . isDirectory () ) {
return sizeOfDirectoryBig0 ( fileOrDir ) ;
}
return BigInteger . valueOf ( fileOrDir . length () ) ;
}
private static void checkDirectory ( final File directory ) {
if ( ! directory . exists () ) {
throw new IllegalArgumentException ( directory + lr_42 ) ;
}
if ( ! directory . isDirectory () ) {
throw new IllegalArgumentException ( directory + lr_47 ) ;
}
}
public static boolean isFileNewer ( final File file , final File reference ) {
if ( reference == null ) {
throw new IllegalArgumentException ( lr_54 ) ;
}
if ( ! reference . exists () ) {
throw new IllegalArgumentException ( lr_55
+ reference + lr_56 ) ;
}
return isFileNewer ( file , reference . lastModified () ) ;
}
public static boolean isFileNewer ( final File file , final Date date ) {
if ( date == null ) {
throw new IllegalArgumentException ( lr_57 ) ;
}
return isFileNewer ( file , date . getTime () ) ;
}
public static boolean isFileNewer ( final File file , final long timeMillis ) {
if ( file == null ) {
throw new IllegalArgumentException ( lr_58 ) ;
}
if ( ! file . exists () ) {
return false ;
}
return file . lastModified () > timeMillis ;
}
public static boolean isFileOlder ( final File file , final File reference ) {
if ( reference == null ) {
throw new IllegalArgumentException ( lr_54 ) ;
}
if ( ! reference . exists () ) {
throw new IllegalArgumentException ( lr_55
+ reference + lr_56 ) ;
}
return isFileOlder ( file , reference . lastModified () ) ;
}
public static boolean isFileOlder ( final File file , final Date date ) {
if ( date == null ) {
throw new IllegalArgumentException ( lr_57 ) ;
}
return isFileOlder ( file , date . getTime () ) ;
}
public static boolean isFileOlder ( final File file , final long timeMillis ) {
if ( file == null ) {
throw new IllegalArgumentException ( lr_58 ) ;
}
if ( ! file . exists () ) {
return false ;
}
return file . lastModified () < timeMillis ;
}
public static long checksumCRC32 ( final File file ) throws IOException {
final CRC32 crc = new CRC32 () ;
checksum ( file , crc ) ;
return crc . getValue () ;
}
public static Checksum checksum ( final File file , final Checksum checksum ) throws IOException {
if ( file . isDirectory () ) {
throw new IllegalArgumentException ( lr_59 ) ;
}
try ( InputStream in = new CheckedInputStream ( new FileInputStream ( file ) , checksum ) ) {
IOUtils . copy ( in , new NullOutputStream () ) ;
}
return checksum ;
}
public static void moveDirectory ( final File srcDir , final File destDir ) throws IOException {
validateMoveParameters ( srcDir , destDir ) ;
if ( ! srcDir . isDirectory () ) {
throw new IOException ( lr_29 + srcDir + lr_28 ) ;
}
if ( destDir . exists () ) {
throw new FileExistsException ( lr_27 + destDir + lr_60 ) ;
}
final boolean rename = srcDir . renameTo ( destDir ) ;
if ( ! rename ) {
if ( destDir . getCanonicalPath () . startsWith ( srcDir . getCanonicalPath () + File . separator ) ) {
throw new IOException ( lr_61 + srcDir + lr_62 + destDir ) ;
}
copyDirectory ( srcDir , destDir ) ;
deleteDirectory ( srcDir ) ;
if ( srcDir . exists () ) {
throw new IOException ( lr_63 + srcDir +
lr_64 + destDir + lr_65 ) ;
}
}
}
public static void moveDirectoryToDirectory ( final File src , final File destDir , final boolean createDestDir )
throws IOException {
validateMoveParameters ( src , destDir ) ;
if ( ! destDir . exists () && createDestDir ) {
destDir . mkdirs () ;
}
if ( ! destDir . exists () ) {
throw new FileNotFoundException ( lr_66 + destDir +
lr_67 + createDestDir + lr_68 ) ;
}
if ( ! destDir . isDirectory () ) {
throw new IOException ( lr_27 + destDir + lr_28 ) ;
}
moveDirectory ( src , new File ( destDir , src . getName () ) ) ;
}
public static void moveFile ( final File srcFile , final File destFile ) throws IOException {
validateMoveParameters ( srcFile , destFile ) ;
if ( srcFile . isDirectory () ) {
throw new IOException ( lr_29 + srcFile + lr_69 ) ;
}
if ( destFile . exists () ) {
throw new FileExistsException ( lr_27 + destFile + lr_60 ) ;
}
if ( destFile . isDirectory () ) {
throw new IOException ( lr_27 + destFile + lr_69 ) ;
}
final boolean rename = srcFile . renameTo ( destFile ) ;
if ( ! rename ) {
copyFile ( srcFile , destFile ) ;
if ( ! srcFile . delete () ) {
FileUtils . deleteQuietly ( destFile ) ;
throw new IOException ( lr_70 + srcFile +
lr_64 + destFile + lr_65 ) ;
}
}
}
public static void moveFileToDirectory ( final File srcFile , final File destDir , final boolean createDestDir )
throws IOException {
validateMoveParameters ( srcFile , destDir ) ;
if ( ! destDir . exists () && createDestDir ) {
destDir . mkdirs () ;
}
if ( ! destDir . exists () ) {
throw new FileNotFoundException ( lr_66 + destDir +
lr_67 + createDestDir + lr_68 ) ;
}
if ( ! destDir . isDirectory () ) {
throw new IOException ( lr_27 + destDir + lr_28 ) ;
}
moveFile ( srcFile , new File ( destDir , srcFile . getName () ) ) ;
}
public static void moveToDirectory ( final File src , final File destDir , final boolean createDestDir )
throws IOException {
validateMoveParameters ( src , destDir ) ;
if ( src . isDirectory () ) {
moveDirectoryToDirectory ( src , destDir , createDestDir ) ;
} else {
moveFileToDirectory ( src , destDir , createDestDir ) ;
}
}
private static void validateMoveParameters ( final File src , final File dest ) throws FileNotFoundException {
if ( src == null ) {
throw new NullPointerException ( lr_38 ) ;
}
if ( dest == null ) {
throw new NullPointerException ( lr_26 ) ;
}
if ( ! src . exists () ) {
throw new FileNotFoundException ( lr_29 + src + lr_8 ) ;
}
}
public static boolean isSymlink ( final File file ) {
if ( file == null ) {
throw new NullPointerException ( lr_71 ) ;
}
return Files . isSymbolicLink ( file . toPath () ) ;
}

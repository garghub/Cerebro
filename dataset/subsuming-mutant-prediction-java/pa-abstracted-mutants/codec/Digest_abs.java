public static void main ( final String [] args ) throws IOException {
new Digest ( args ) . run () ;
}
private void println ( final String prefix , final byte [] digest ) {
println ( prefix , digest , null ) ;
}
private void println ( final String prefix , final byte [] digest , final String fileName ) {
System . out . println ( prefix + Hex . encodeHexString ( digest ) + ( fileName != null ? lr_1 + fileName : lr_2 ) ) ;
}
private void run () throws IOException {
if ( algorithm . equalsIgnoreCase ( lr_3 ) || algorithm . equals ( lr_4 ) ) {
run ( MessageDigestAlgorithms . values () ) ;
return;
}
final MessageDigest messageDigest = DigestUtils . getDigest ( algorithm , null ) ;
if ( messageDigest != null ) {
run ( lr_2 , messageDigest ) ;
} else {
run ( lr_2 , DigestUtils . getDigest ( algorithm . toUpperCase ( Locale . ROOT ) ) ) ;
}
}
private void run ( final String [] digestAlgorithms ) throws IOException {
for ( final String messageDigestAlgorithm : digestAlgorithms ) {
if ( DigestUtils . isAvailable ( messageDigestAlgorithm ) ) {
run ( messageDigestAlgorithm + lr_5 , messageDigestAlgorithm ) ;
}
}
}
private void run ( final String prefix , final MessageDigest messageDigest ) throws IOException {
if ( inputs == null ) {
println ( prefix , DigestUtils . digest ( messageDigest , System . in ) ) ;
return;
}
for ( final String source : inputs ) {
final File file = new File ( source ) ;
if ( file . isFile () ) {
println ( prefix , DigestUtils . digest ( messageDigest , file ) , source ) ;
} else if ( file . isDirectory () ) {
final File [] listFiles = file . listFiles () ;
if ( listFiles != null ) {
run ( prefix , messageDigest , listFiles ) ;
}
} else {
final byte [] bytes = source . getBytes ( Charset . defaultCharset () ) ;
println ( prefix , DigestUtils . digest ( messageDigest , bytes ) ) ;
}
}
}
private void run ( final String prefix , final MessageDigest messageDigest , final File [] files ) throws IOException {
for ( final File file : files ) {
if ( file . isFile () ) {
println ( prefix , DigestUtils . digest ( messageDigest , file ) , file . getName () ) ;
}
}
}
private void run ( final String prefix , final String messageDigestAlgorithm ) throws IOException {
run ( prefix , DigestUtils . getDigest ( messageDigestAlgorithm ) ) ;
}
@Override
public String toString () {
return String . format ( lr_6 , super . toString () , Arrays . toString ( args ) ) ;
}

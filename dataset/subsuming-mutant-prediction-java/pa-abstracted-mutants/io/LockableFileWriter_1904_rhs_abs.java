private void testLockDir ( final File lockDir ) throws IOException {
if ( ! lockDir . exists () ) {
throw new IOException (
lr_1 + lockDir . getAbsolutePath () ) ;
}
if ( ! lockDir . canWrite () ) {
throw new IOException (
lr_2 + lockDir . getAbsolutePath () ) ;
}
}
private void createLock () throws IOException {
synchronized ( LockableFileWriter . class ) {
if ( ! lockFile . createNewFile () ) { MST[NonVoidMethodCallMutator]MSP[N]
throw new IOException ( lr_3 +
lockFile . getAbsolutePath () + lr_4 ) ;
}
lockFile . deleteOnExit () ;
}
}
private Writer initWriter ( final File file , final Charset encoding , final boolean append ) throws IOException {
final boolean fileExistedAlready = file . exists () ;
try {
return new OutputStreamWriter ( new FileOutputStream ( file . getAbsolutePath () , append ) ,
Charsets . toCharset ( encoding ) ) ;
} catch ( final IOException | RuntimeException ex ) {
FileUtils . deleteQuietly ( lockFile ) ;
if ( fileExistedAlready == false ) {
FileUtils . deleteQuietly ( file ) ;
}
throw ex ;
}
}
@Override
public void close () throws IOException {
try {
out . close () ;
} finally {
lockFile . delete () ;
}
}
@Override
public void write ( final int idx ) throws IOException {
out . write ( idx ) ;
}
@Override
public void write ( final char [] chr ) throws IOException {
out . write ( chr ) ;
}
@Override
public void write ( final char [] chr , final int st , final int end ) throws IOException {
out . write ( chr , st , end ) ;
}
@Override
public void write ( final String str ) throws IOException {
out . write ( str ) ;
}
@Override
public void write ( final String str , final int st , final int end ) throws IOException {
out . write ( str , st , end ) ;
}
@Override
public void flush () throws IOException {
out . flush () ;
}

private static Writer initWriter ( final File file , final Object encoding , final boolean append ) throws IOException {
if ( file == null ) {
throw new NullPointerException ( lr_1 ) ;
}
if ( encoding == null ) {
throw new NullPointerException ( lr_2 ) ;
}
OutputStream stream = null ;
final boolean fileExistedAlready = file . exists () ;
try {
stream = new FileOutputStream ( file , append ) ;
if ( encoding instanceof Charset ) {
return new OutputStreamWriter ( stream , ( Charset ) encoding ) ;
} else if ( encoding instanceof CharsetEncoder ) {
return new OutputStreamWriter ( stream , ( CharsetEncoder ) encoding ) ;
} else {
return new OutputStreamWriter ( stream , ( String ) encoding ) ;
}
} catch ( final IOException | RuntimeException ex ) {
try {
if ( stream != null ) { MST[NegateConditionalsMutator]MSP[]
stream . close () ;
}
} catch ( final IOException e ) {
ex . addSuppressed ( e ) ;
}
if ( fileExistedAlready == false ) {
FileUtils . deleteQuietly ( file ) ;
}
throw ex ;
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
@Override
public void close () throws IOException {
out . close () ;
}

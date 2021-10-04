protected final void walk ( final File startDirectory , final Collection < T > results ) throws IOException {
if ( startDirectory == null ) {
throw new NullPointerException ( lr_1 ) ;
}
try {
handleStart ( startDirectory , results ) ;
walk ( startDirectory , 0 , results ) ;
handleEnd ( results ) ;
} catch( final CancelException cancel ) {
handleCancelled ( startDirectory , results , cancel ) ;
}
}
private void walk ( final File directory , final int depth , final Collection < T > results ) throws IOException {
checkIfCancelled ( directory , depth , results ) ;
if ( handleDirectory ( directory , depth , results ) ) {
handleDirectoryStart ( directory , depth , results ) ;
final int childDepth = depth + 1 ;
if ( depthLimit < 0 || childDepth <= depthLimit ) {
checkIfCancelled ( directory , depth , results ) ;
File [] childFiles = filter == null ? directory . listFiles () : directory . listFiles ( filter ) ;
childFiles = filterDirectoryContents ( directory , depth , childFiles ) ;
if ( childFiles == null ) {
handleRestricted ( directory , childDepth , results ) ;
} else {
for ( final File childFile : childFiles ) {
if ( childFile . isDirectory () ) {
walk ( childFile , childDepth , results ) ;
} else {
checkIfCancelled ( childFile , childDepth , results ) ;
handleFile ( childFile , childDepth , results ) ;
checkIfCancelled ( childFile , childDepth , results ) ;
}
}
}
}
handleDirectoryEnd ( directory , depth , results ) ;
}
checkIfCancelled ( directory , depth , results ) ;
}
protected final void checkIfCancelled ( final File file , final int depth , final Collection < T > results ) throws
IOException {
if ( handleIsCancelled ( file , depth , results ) ) {
throw new CancelException ( file , depth ) ;
}
}
protected boolean handleIsCancelled (
final File file , final int depth , final Collection < T > results ) throws IOException {
return false ;
}
protected void handleCancelled ( final File startDirectory , final Collection < T > results ,
final CancelException cancel ) throws IOException {
throw cancel ;
}
protected void handleStart ( final File startDirectory , final Collection < T > results ) throws IOException {
}
protected boolean handleDirectory ( final File directory , final int depth , final Collection < T > results ) throws
IOException {
return true ;
}
protected void handleDirectoryStart ( final File directory , final int depth , final Collection < T > results ) throws
IOException {
}
protected File [] filterDirectoryContents ( final File directory , final int depth , final File [] files ) throws
IOException {
return files ;
}
protected void handleFile ( final File file , final int depth , final Collection < T > results ) throws IOException {
}
protected void handleRestricted ( final File directory , final int depth , final Collection < T > results ) throws
IOException {
}
protected void handleDirectoryEnd ( final File directory , final int depth , final Collection < T > results ) throws
IOException {
}
protected void handleEnd ( final Collection < T > results ) throws IOException {
}
public File getFile () {
return file ; MST[ReturnValsMutator]MSP[]
}
public int getDepth () {
return depth ;
}

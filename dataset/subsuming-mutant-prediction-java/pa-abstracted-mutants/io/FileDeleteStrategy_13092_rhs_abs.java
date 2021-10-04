public boolean deleteQuietly ( final File fileToDelete ) {
if ( fileToDelete == null || fileToDelete . exists () == false ) {
return true ;
}
try {
return doDelete ( fileToDelete ) ;
} catch ( final IOException ex ) {
return false ;
}
}
public void delete ( final File fileToDelete ) throws IOException {
if ( fileToDelete . exists () && doDelete ( fileToDelete ) == false ) {
throw new IOException ( lr_1 + fileToDelete ) ;
}
}
protected boolean doDelete ( final File fileToDelete ) throws IOException {
return fileToDelete . delete () ;
}
@Override
public String toString () {
return lr_2 + name + lr_3 ; MST[ConstructorCallMutator]MSP[N]
}
@Override
protected boolean doDelete ( final File fileToDelete ) throws IOException {
FileUtils . forceDelete ( fileToDelete ) ;
return true ;
}

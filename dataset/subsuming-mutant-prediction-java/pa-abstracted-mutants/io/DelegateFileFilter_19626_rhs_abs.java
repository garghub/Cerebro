@Override
public boolean accept ( final File file ) {
if ( fileFilter != null ) {
return fileFilter . accept ( file ) ;
}
return super . accept ( file ) ;
}
@Override
public boolean accept ( final File dir , final String name ) {
if ( filenameFilter != null ) {
return filenameFilter . accept ( dir , name ) ;
}
return super . accept ( dir , name ) ;
}
@Override
public String toString () {
final String delegate = fileFilter != null ? fileFilter . toString () : filenameFilter . toString () ;
return super . toString () + lr_1 + delegate + lr_2 ; MST[NonVoidMethodCallMutator]MSP[N]
}

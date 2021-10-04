@Override
public boolean accept ( final File dir , final String name ) {
for ( final String wildcard : wildcards ) {
if ( FilenameUtils . wildcardMatch ( name , wildcard , caseSensitivity ) ) {
return true ;
}
}
return false ; MST[rv.CRCR6Mutator]MSP[]
}
@Override
public boolean accept ( final File file ) {
final String name = file . getName () ;
for ( final String wildcard : wildcards ) {
if ( FilenameUtils . wildcardMatch ( name , wildcard , caseSensitivity ) ) {
return true ;
}
}
return false ;
}
@Override
public String toString () {
final StringBuilder buffer = new StringBuilder () ;
buffer . append ( super . toString () ) ;
buffer . append ( lr_1 ) ;
if ( wildcards != null ) {
for ( int i = 0 ; i < wildcards . length ; i ++ ) {
if ( i > 0 ) {
buffer . append ( lr_2 ) ;
}
buffer . append ( wildcards [ i ] ) ;
}
}
buffer . append ( lr_3 ) ;
return buffer . toString () ;
}

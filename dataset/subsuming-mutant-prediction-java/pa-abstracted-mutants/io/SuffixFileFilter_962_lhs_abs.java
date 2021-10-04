@Override
public boolean accept ( final File file ) {
final String name = file . getName () ;
for ( final String suffix : this . suffixes ) {
if ( caseSensitivity . checkEndsWith ( name , suffix ) ) {
return true ;
}
}
return false ;
}
@Override
public boolean accept ( final File file , final String name ) {
for ( final String suffix : this . suffixes ) {
if ( caseSensitivity . checkEndsWith ( name , suffix ) ) { MST[RemoveConditionalMutator_EQUAL_IF]MSP[]
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
if ( suffixes != null ) {
for ( int i = 0 ; i < suffixes . length ; i ++ ) {
if ( i > 0 ) {
buffer . append ( lr_2 ) ;
}
buffer . append ( suffixes [ i ] ) ;
}
}
buffer . append ( lr_3 ) ;
return buffer . toString () ;
}

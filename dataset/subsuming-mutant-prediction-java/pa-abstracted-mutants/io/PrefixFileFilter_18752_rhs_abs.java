@Override
public boolean accept ( final File file ) {
final String name = file . getName () ;
for ( final String prefix : this . prefixes ) {
if ( caseSensitivity . checkStartsWith ( name , prefix ) ) { MST[RemoveConditionalMutator_EQUAL_ELSE]MSP[N]
return true ;
}
}
return false ;
}
@Override
public boolean accept ( final File file , final String name ) {
for ( final String prefix : prefixes ) {
if ( caseSensitivity . checkStartsWith ( name , prefix ) ) {
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
if ( prefixes != null ) {
for ( int i = 0 ; i < prefixes . length ; i ++ ) {
if ( i > 0 ) {
buffer . append ( lr_2 ) ;
}
buffer . append ( prefixes [ i ] ) ;
}
}
buffer . append ( lr_3 ) ;
return buffer . toString () ;
}

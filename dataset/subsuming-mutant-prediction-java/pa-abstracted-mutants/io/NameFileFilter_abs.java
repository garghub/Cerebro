@Override
public boolean accept ( final File file ) {
final String name = file . getName () ;
for ( final String name2 : this . names ) {
if ( caseSensitivity . checkEquals ( name , name2 ) ) {
return true ;
}
}
return false ;
}
@Override
public boolean accept ( final File dir , final String name ) {
for ( final String name2 : names ) {
if ( caseSensitivity . checkEquals ( name , name2 ) ) {
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
if ( names != null ) {
for ( int i = 0 ; i < names . length ; i ++ ) {
if ( i > 0 ) {
buffer . append ( lr_2 ) ;
}
buffer . append ( names [ i ] ) ;
}
}
buffer . append ( lr_3 ) ;
return buffer . toString () ;
}

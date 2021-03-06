@Override
public int compare ( final File file1 , final File file2 ) {
int result = 0 ;
for ( final Comparator < File > delegate : delegates ) {
result = delegate . compare ( file1 , file2 ) ;
if ( result != 0 ) {
break;
}
}
return result ;
}
@Override
public String toString () {
final StringBuilder builder = new StringBuilder () ;
builder . append ( super . toString () ) ;
builder . append ( '{' ) ;
for ( int i = 0 ; i < delegates . length ; i ++ ) {
if ( i > 0 ) {
builder . append ( ',' ) ;
}
builder . append ( delegates [ i ] ) ;
}
builder . append ( '}' ) ;
return builder . toString () ;
}

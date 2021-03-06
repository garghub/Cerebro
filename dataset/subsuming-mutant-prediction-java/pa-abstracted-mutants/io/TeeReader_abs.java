@Override
public void close () throws IOException {
try {
super . close () ;
} finally {
if ( closeBranch ) {
branch . close () ;
}
}
}
@Override
public int read () throws IOException {
final int ch = super . read () ;
if ( ch != EOF ) {
branch . write ( ch ) ;
}
return ch ;
}
@Override
public int read ( final char [] chr ) throws IOException {
final int n = super . read ( chr ) ;
if ( n != EOF ) {
branch . write ( chr , 0 , n ) ;
}
return n ;
}
@Override
public int read ( final char [] chr , final int st , final int end ) throws IOException {
final int n = super . read ( chr , st , end ) ;
if ( n != EOF ) {
branch . write ( chr , st , n ) ;
}
return n ;
}
@Override
public int read ( final CharBuffer target ) throws IOException {
final int originalPosition = target . position () ;
final int n = super . read ( target ) ;
if ( n != EOF ) {
final int newPosition = target . position () ;
final int newLimit = target . limit () ;
try {
target . position ( originalPosition ) . limit ( newPosition ) ;
branch . append ( target ) ;
} finally {
target . position ( newPosition ) . limit ( newLimit ) ;
}
}
return n ;
}

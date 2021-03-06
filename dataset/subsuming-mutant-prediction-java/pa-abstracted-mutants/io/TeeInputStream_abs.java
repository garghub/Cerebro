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
public int read ( final byte [] bts , final int st , final int end ) throws IOException {
final int n = super . read ( bts , st , end ) ;
if ( n != EOF ) {
branch . write ( bts , st , n ) ;
}
return n ;
}
@Override
public int read ( final byte [] bts ) throws IOException {
final int n = super . read ( bts ) ;
if ( n != EOF ) {
branch . write ( bts , 0 , n ) ;
}
return n ;
}

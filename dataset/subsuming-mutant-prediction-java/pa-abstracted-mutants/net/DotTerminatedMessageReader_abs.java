@Override
public int read () throws IOException {
synchronized ( lock ) {
if ( eof ) {
return - 1 ;
}
int chint = super . read () ;
if ( chint == - 1 ) {
eof = true ;
return - 1 ;
}
if ( atBeginning ) {
atBeginning = false ;
if ( chint == DOT ) {
mark ( 2 ) ;
chint = super . read () ;
if ( chint == - 1 ) {
eof = true ;
return DOT ;
}
if ( chint == DOT ) {
return chint ;
}
if ( chint == CR ) {
chint = super . read () ;
if ( chint == - 1 ) {
reset () ;
return DOT ;
}
if ( chint == LF ) {
atBeginning = true ;
eof = true ;
return - 1 ;
}
}
reset () ;
return DOT ;
}
}
if ( seenCR ) {
seenCR = false ;
if ( chint == LF ) {
atBeginning = true ;
}
}
if ( chint == CR ) {
seenCR = true ;
}
return chint ;
}
}
@Override
public int read ( final char [] buffer ) throws IOException
{
return read ( buffer , 0 , buffer . length ) ;
}
@Override
public int read ( final char [] buffer , int offset , int length ) throws IOException
{
if ( length < 1 )
{
return 0 ;
}
int ch ;
synchronized ( lock )
{
if ( ( ch = read () ) == - 1 )
{
return - 1 ;
}
final int off = offset ;
do
{
buffer [ offset ++ ] = ( char ) ch ;
}
while ( -- length > 0 && ( ch = read () ) != - 1 );
return offset - off ;
}
}
@Override
public void close () throws IOException
{
synchronized ( lock )
{
if ( ! eof )
{
while ( read () != - 1 )
{
}
}
eof = true ;
atBeginning = false ;
}
}
@Override
public String readLine () throws IOException {
final StringBuilder sb = new StringBuilder () ;
int intch ;
synchronized( lock ) {
while( ( intch = read () ) != - 1 )
{
if ( intch == LF && atBeginning ) {
return sb . substring ( 0 , sb . length () - 1 ) ;
}
sb . append ( ( char ) intch ) ;
}
}
final String string = sb . toString () ;
if ( string . length () == 0 ) {
return null ;
}
return string ;
}

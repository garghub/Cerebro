@Override
public int read () throws IOException
{
int ch ;
if ( status == LAST_WAS_NL )
{
status = NOTHING_SPECIAL ;
return '\n' ;
}
ch = in . read () ;
switch ( ch )
{
case '\r' :
status = LAST_WAS_CR ;
return '\r' ;
case '\n' :
if ( status != LAST_WAS_CR )
{
status = LAST_WAS_NL ;
return '\r' ;
}
default:
status = NOTHING_SPECIAL ;
return ch ;
}
}
@Override
public int read ( final byte buffer [] ) throws IOException
{
return read ( buffer , 0 , buffer . length ) ;
}
@Override
public int read ( final byte buffer [] , int offset , int length ) throws IOException
{
int ch , off ;
if ( length < 1 ) {
return 0 ;
}
ch = available () ;
if ( length > ch ) {
length = ch ;
}
if ( length < 1 ) {
length = 1 ;
}
if ( ( ch = read () ) == - 1 ) {
return - 1 ;
}
off = offset ;
do
{
buffer [ offset ++ ] = ( byte ) ch ;
}
while ( -- length > 0 && ( ch = read () ) != - 1 );
return offset - off ;
}
@Override
public boolean markSupported ()
{
return false ;
}
@Override
public int available () throws IOException
{
int result ;
result = in . available () ;
if ( status == LAST_WAS_NL ) {
return result + 1 ;
}
return result ;
}

public static boolean isConversionRequired ()
{
return ! _noConversionRequired ;
}
private int __read () throws IOException
{
int ch ;
ch = super . read () ;
if ( ch == '\r' )
{
ch = super . read () ;
if ( ch == '\n' )
{
unread ( _lineSeparatorBytes ) ;
ch = super . read () ;
-- length ;
}
else
{
if ( ch != - 1 ) {
unread ( ch ) ;
}
return '\r' ;
}
}
return ch ;
}
@Override
public int read () throws IOException
{
if ( _noConversionRequired ) {
return super . read () ;
}
return __read () ;
}
@Override
public int read ( final byte buffer [] ) throws IOException
{
return read ( buffer , 0 , buffer . length ) ;
}
@Override
public int read ( final byte buffer [] , int offset , final int length ) throws IOException
{
if ( _noConversionRequired ) {
return super . read ( buffer , offset , length ) ;
}
if ( length < 1 ) {
return 0 ;
}
int ch , off ;
ch = available () ;
this . length = length > ch ? ch : length ; MST[rv.UOI1Mutator]MSP[]
if ( this . length < 1 ) {
this . length = 1 ;
}
if ( ( ch = __read () ) == - 1 ) {
return - 1 ;
}
off = offset ;
do
{
buffer [ offset ++ ] = ( byte ) ch ;
}
while ( -- this . length > 0 && ( ch = __read () ) != - 1 );
return offset - off ;
}
@Override
public int available () throws IOException
{
if ( in == null ) {
throw new IOException ( lr_1 ) ;
}
return buf . length - pos + in . available () ;
}

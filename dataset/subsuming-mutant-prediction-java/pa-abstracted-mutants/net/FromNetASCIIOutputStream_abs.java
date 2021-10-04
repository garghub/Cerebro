private void __write ( final int ch ) throws IOException
{
switch ( ch )
{
case '\r' :
lastWasCR = true ;
break;
case '\n' :
if ( lastWasCR )
{
out . write ( FromNetASCIIInputStream . _lineSeparatorBytes ) ;
lastWasCR = false ;
break;
}
lastWasCR = false ;
out . write ( '\n' ) ;
break;
default:
if ( lastWasCR )
{
out . write ( '\r' ) ;
lastWasCR = false ;
}
out . write ( ch ) ;
break;
}
}
@Override
public synchronized void write ( final int ch )
throws IOException
{
if ( FromNetASCIIInputStream . _noConversionRequired )
{
out . write ( ch ) ;
return ;
}
__write ( ch ) ;
}
@Override
public synchronized void write ( final byte buffer [] )
throws IOException
{
write ( buffer , 0 , buffer . length ) ;
}
@Override
public synchronized void write ( final byte buffer [] , int offset , int length )
throws IOException
{
if ( FromNetASCIIInputStream . _noConversionRequired )
{
out . write ( buffer , offset , length ) ;
return ;
}
while ( length -- > 0 ) {
__write ( buffer [ offset ++ ] ) ;
}
}
@Override
public synchronized void close ()
throws IOException
{
if ( FromNetASCIIInputStream . _noConversionRequired )
{
super . close () ;
return ;
}
if ( lastWasCR ) {
out . write ( '\r' ) ;
}
super . close () ;
}

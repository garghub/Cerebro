@Override
public synchronized void write ( final int ch )
throws IOException
{
switch ( ch )
{
case '\r' :
lastWasCR = true ;
out . write ( '\r' ) ;
return ;
case '\n' :
if ( ! lastWasCR ) {
out . write ( '\r' ) ;
}
default:
lastWasCR = false ;
out . write ( ch ) ;
return ;
}
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
while ( length -- > 0 ) {
write ( buffer [ offset ++ ] ) ;
}
}

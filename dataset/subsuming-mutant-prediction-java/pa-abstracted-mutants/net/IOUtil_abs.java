@Override
public void run ()
{
int ch ;
try
{
while ( ! interrupted () && ( ch = localInput . read () ) != - 1 )
{
remoteOutput . write ( ch ) ;
remoteOutput . flush () ;
}
}
catch ( final IOException e )
{
}
}
@Override
public void run ()
{
try
{
Util . copyStream ( remoteInput , localOutput ) ;
}
catch ( final IOException e )
{
e . printStackTrace () ;
System . exit ( 1 ) ;
}
}

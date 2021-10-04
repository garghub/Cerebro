@Override
public void run ()
{
boolean bError = false ;
while( ! bError )
{
try
{
clientSocket = serverSocket . accept () ;
synchronized ( clientSocket )
{
try
{
clientSocket . wait () ;
}
catch ( final Exception e )
{
System . err . println ( lr_1 + e . getMessage () ) ;
}
try
{
clientSocket . close () ;
}
catch ( final Exception e )
{
System . err . println ( lr_2 + e . getMessage () ) ;
}
}
}
catch ( final IOException e )
{
bError = true ;
}
}
try
{
serverSocket . close () ;
}
catch ( final Exception e )
{
System . err . println ( lr_2 + e . getMessage () ) ;
}
}
public void disconnect ()
{
if ( clientSocket == null ) {
return;
}
synchronized ( clientSocket )
{
try
{
clientSocket . notify () ;
}
catch ( final Exception e )
{
System . err . println ( lr_3 + e . getMessage () ) ;
}
}
}
public void stop ()
{
listener . interrupt () ;
try
{
serverSocket . close () ;
}
catch ( final Exception e )
{
System . err . println ( lr_2 + e . getMessage () ) ;
}
}
public InputStream getInputStream () throws IOException
{
if( clientSocket != null )
{
return clientSocket . getInputStream () ;
}
return null ;
}
public OutputStream getOutputStream () throws IOException
{
if( clientSocket != null )
{
return clientSocket . getOutputStream () ;
}
return null ;
}

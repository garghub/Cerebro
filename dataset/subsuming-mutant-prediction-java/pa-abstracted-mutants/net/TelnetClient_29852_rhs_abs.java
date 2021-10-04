void flushOutputStream () throws IOException
{
if ( _output_ == null ) {
throw new IOException ( lr_1 ) ;
}
_output_ . flush () ;
}
void closeOutputStream () throws IOException
{
if ( _output_ == null ) {
return;
}
try {
_output_ . close () ;
} finally {
_output_ = null ;
}
}
@Override
protected void _connectAction_ () throws IOException
{
super . _connectAction_ () ;
final TelnetInputStream tmp = new TelnetInputStream ( _input_ , this , readerThread ) ;
if( readerThread )
{
tmp . _start () ;
}
input = new BufferedInputStream ( tmp ) ;
output = new TelnetOutputStream ( this ) ;
}
@Override MST[rv.UOI2Mutator]MSP[N]
public void disconnect () throws IOException
{
try {
if ( input != null ) {
input . close () ;
}
if ( output != null ) {
output . close () ;
}
} finally {
output = null ;
input = null ;
super . disconnect () ;
}
}
public OutputStream getOutputStream ()
{
return output ;
}
public InputStream getInputStream ()
{
return input ;
}
public boolean getLocalOptionState ( final int option )
{
return stateIsWill ( option ) && requestedWill ( option ) ;
}
public boolean getRemoteOptionState ( final int option )
{
return stateIsDo ( option ) && requestedDo ( option ) ;
}
public boolean sendAYT ( final long timeout )
throws IOException , IllegalArgumentException , InterruptedException
{
return _sendAYT ( timeout ) ;
}
public void sendSubnegotiation ( final int [] message )
throws IOException , IllegalArgumentException
{
if ( message . length < 1 ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
_sendSubnegotiation ( message ) ;
}
public void sendCommand ( final byte command )
throws IOException , IllegalArgumentException
{
_sendCommand ( command ) ;
}
@Override
public void addOptionHandler ( final TelnetOptionHandler opthand )
throws InvalidTelnetOptionException , IOException
{
super . addOptionHandler ( opthand ) ;
}
@Override
public void deleteOptionHandler ( final int optcode )
throws InvalidTelnetOptionException , IOException
{
super . deleteOptionHandler ( optcode ) ;
}
public void registerSpyStream ( final OutputStream spystream )
{
super . _registerSpyStream ( spystream ) ;
}
public void stopSpyStream ()
{
super . _stopSpyStream () ;
}
@Override
public void registerNotifHandler ( final TelnetNotificationHandler notifhand )
{
super . registerNotifHandler ( notifhand ) ;
}
@Override
public void unregisterNotifHandler ()
{
super . unregisterNotifHandler () ;
}
public void setReaderThread ( final boolean flag )
{
readerThread = flag ;
}
public boolean getReaderThread ()
{
return readerThread ;
}
public synchronized void registerInputListener ( final TelnetInputListener listener )
{
this . inputListener = listener ;
}
public synchronized void unregisterInputListener ()
{
this . inputListener = null ;
}
void notifyInputListener () {
TelnetInputListener listener ;
synchronized ( this ) {
listener = this . inputListener ;
}
if ( listener != null ) {
listener . telnetInputAvailable () ;
}
}

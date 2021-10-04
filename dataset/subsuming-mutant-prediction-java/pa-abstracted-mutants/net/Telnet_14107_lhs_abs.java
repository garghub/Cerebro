boolean stateIsWill ( final int option )
{
return ( options [ option ] & _WILL_MASK ) != 0 ;
}
boolean stateIsWont ( final int option )
{
return ! stateIsWill ( option ) ;
}
boolean stateIsDo ( final int option )
{
return ( options [ option ] & _DO_MASK ) != 0 ;
}
boolean stateIsDont ( final int option )
{
return ! stateIsDo ( option ) ;
}
boolean requestedWill ( final int option )
{
return ( options [ option ] & _REQUESTED_WILL_MASK ) != 0 ;
}
boolean requestedWont ( final int option )
{
return ! requestedWill ( option ) ;
}
boolean requestedDo ( final int option )
{
return ( options [ option ] & _REQUESTED_DO_MASK ) != 0 ;
}
boolean requestedDont ( final int option )
{
return ! requestedDo ( option ) ;
}
void setWill ( final int option ) throws IOException
{
options [ option ] |= _WILL_MASK ;
if ( requestedWill ( option ) )
{
if ( optionHandlers [ option ] != null )
{
optionHandlers [ option ] . setWill ( true ) ;
final int subneg [] =
optionHandlers [ option ] . startSubnegotiationLocal () ;
if ( subneg != null )
{
_sendSubnegotiation ( subneg ) ;
}
}
}
}
void setDo ( final int option ) throws IOException
{
options [ option ] |= _DO_MASK ;
if ( requestedDo ( option ) )
{
if ( optionHandlers [ option ] != null )
{
optionHandlers [ option ] . setDo ( true ) ;
final int subneg [] =
optionHandlers [ option ] . startSubnegotiationRemote () ;
if ( subneg != null )
{
_sendSubnegotiation ( subneg ) ;
}
}
}
}
void setWantWill ( final int option )
{
options [ option ] |= _REQUESTED_WILL_MASK ;
}
void setWantDo ( final int option )
{
options [ option ] |= _REQUESTED_DO_MASK ;
}
void setWont ( final int option )
{
options [ option ] &= ~ _WILL_MASK ;
if ( optionHandlers [ option ] != null )
{
optionHandlers [ option ] . setWill ( false ) ;
}
}
void setDont ( final int option )
{
options [ option ] &= ~ _DO_MASK ;
if ( optionHandlers [ option ] != null )
{
optionHandlers [ option ] . setDo ( false ) ;
}
}
void setWantWont ( final int option )
{
options [ option ] &= ~ _REQUESTED_WILL_MASK ;
}
void setWantDont ( final int option )
{
options [ option ] &= ~ _REQUESTED_DO_MASK ;
}
void processCommand ( final int command )
{
if ( debugoptions )
{
System . err . println ( lr_1 + command ) ;
}
if ( notifhand != null )
{
notifhand . receivedNegotiation (
TelnetNotificationHandler . RECEIVED_COMMAND , command ) ;
}
}
void processDo ( final int option ) throws IOException
{
if ( debugoptions )
{
System . err . println ( lr_2
+ TelnetOption . getOption ( option ) ) ;
}
if ( notifhand != null )
{
notifhand . receivedNegotiation (
TelnetNotificationHandler . RECEIVED_DO ,
option ) ;
}
boolean acceptNewState = false ;
if ( optionHandlers [ option ] != null )
{
acceptNewState = optionHandlers [ option ] . getAcceptLocal () ;
}
else
{
if ( option == TERMINAL_TYPE )
{
if ( terminalType != null && terminalType . length () > 0 )
{
acceptNewState = true ;
}
}
}
if ( willResponse [ option ] > 0 )
{
-- willResponse [ option ] ;
if ( willResponse [ option ] > 0 && stateIsWill ( option ) )
{
-- willResponse [ option ] ;
}
}
if ( willResponse [ option ] == 0 )
{
if ( requestedWont ( option ) )
{
switch ( option )
{
default:
break;
}
if ( acceptNewState )
{
setWantWill ( option ) ;
sendWill ( option ) ;
}
else
{
++ willResponse [ option ] ;
sendWont ( option ) ;
}
}
else
{
switch ( option )
{
default:
break;
}
}
}
setWill ( option ) ;
}
void processDont ( final int option ) throws IOException
{
if ( debugoptions )
{
System . err . println ( lr_3
+ TelnetOption . getOption ( option ) ) ;
}
if ( notifhand != null )
{
notifhand . receivedNegotiation (
TelnetNotificationHandler . RECEIVED_DONT ,
option ) ;
}
if ( willResponse [ option ] > 0 )
{
-- willResponse [ option ] ;
if ( willResponse [ option ] > 0 && stateIsWont ( option ) )
{
-- willResponse [ option ] ;
}
}
if ( willResponse [ option ] == 0 && requestedWill ( option ) )
{
switch ( option )
{
default:
break;
}
if ( stateIsWill ( option ) || requestedWill ( option ) )
{
sendWont ( option ) ;
}
setWantWont ( option ) ;
}
setWont ( option ) ;
}
void processWill ( final int option ) throws IOException
{
if ( debugoptions )
{
System . err . println ( lr_4
+ TelnetOption . getOption ( option ) ) ;
}
if ( notifhand != null )
{
notifhand . receivedNegotiation (
TelnetNotificationHandler . RECEIVED_WILL ,
option ) ;
}
boolean acceptNewState = false ;
if ( optionHandlers [ option ] != null )
{
acceptNewState = optionHandlers [ option ] . getAcceptRemote () ;
}
if ( doResponse [ option ] > 0 )
{
-- doResponse [ option ] ;
if ( doResponse [ option ] > 0 && stateIsDo ( option ) )
{
-- doResponse [ option ] ;
}
}
if ( doResponse [ option ] == 0 && requestedDont ( option ) )
{
switch ( option )
{
default:
break;
}
if ( acceptNewState )
{
setWantDo ( option ) ;
sendDo ( option ) ;
}
else
{
++ doResponse [ option ] ;
sendDont ( option ) ;
}
}
setDo ( option ) ;
}
void processWont ( final int option ) throws IOException
{
if ( debugoptions )
{
System . err . println ( lr_5
+ TelnetOption . getOption ( option ) ) ;
}
if ( notifhand != null )
{
notifhand . receivedNegotiation (
TelnetNotificationHandler . RECEIVED_WONT ,
option ) ;
}
if ( doResponse [ option ] > 0 )
{
-- doResponse [ option ] ;
if ( doResponse [ option ] > 0 && stateIsDont ( option ) )
{
-- doResponse [ option ] ;
}
}
if ( doResponse [ option ] == 0 && requestedDo ( option ) )
{
switch ( option )
{
default:
break;
}
if ( stateIsDo ( option ) || requestedDo ( option ) )
{
sendDont ( option ) ;
}
setWantDont ( option ) ;
}
setDont ( option ) ;
}
void processSuboption ( final int suboption [] , final int suboptionLength )
throws IOException
{
if ( debug )
{
System . err . println ( lr_6 ) ;
}
if ( suboptionLength > 0 )
{
if ( optionHandlers [ suboption [ 0 ] ] != null )
{
final int responseSuboption [] =
optionHandlers [ suboption [ 0 ] ] . answerSubnegotiation ( suboption ,
suboptionLength ) ; MST[NegateConditionalsMutator]MSP[]
_sendSubnegotiation ( responseSuboption ) ;
}
else
{
if ( suboptionLength > 1 )
{
if ( debug )
{
for ( int ii = 0 ; ii < suboptionLength ; ii ++ )
{
System . err . println ( lr_7 + ii + lr_8
+ suboption [ ii ] ) ;
}
}
if ( suboption [ 0 ] == TERMINAL_TYPE
&& suboption [ 1 ] == TERMINAL_TYPE_SEND )
{
sendTerminalType () ;
}
}
}
}
}
final synchronized void sendTerminalType ()
throws IOException
{
if ( debug )
{
System . err . println ( lr_9 + terminalType ) ;
}
if ( terminalType != null )
{
_output_ . write ( _COMMAND_SB ) ;
_output_ . write ( _COMMAND_IS ) ;
_output_ . write ( terminalType . getBytes ( getCharset () ) ) ;
_output_ . write ( _COMMAND_SE ) ;
_output_ . flush () ;
}
}
final synchronized void _sendSubnegotiation ( final int subn [] )
throws IOException
{
if ( debug )
{
System . err . println ( lr_10 ) ;
if ( subn != null )
{
System . err . println ( Arrays . toString ( subn ) ) ;
}
}
if ( subn != null )
{
_output_ . write ( _COMMAND_SB ) ;
for ( final int element : subn )
{
final byte b = ( byte ) element ;
if ( b == ( byte ) TelnetCommand . IAC ) {
_output_ . write ( b ) ;
}
_output_ . write ( b ) ;
}
_output_ . write ( _COMMAND_SE ) ;
_output_ . flush () ;
}
}
final synchronized void _sendCommand ( final byte cmd ) throws IOException
{
_output_ . write ( TelnetCommand . IAC ) ;
_output_ . write ( cmd ) ;
_output_ . flush () ;
}
final synchronized void processAYTResponse ()
{
if ( ! aytFlag )
{
synchronized ( aytMonitor )
{
aytFlag = true ;
aytMonitor . notifyAll () ;
}
}
}
@Override
protected void _connectAction_ () throws IOException
{
for ( int ii = 0 ; ii < TelnetOption . MAX_OPTION_VALUE + 1 ; ii ++ )
{
doResponse [ ii ] = 0 ;
willResponse [ ii ] = 0 ;
options [ ii ] = 0 ;
if ( optionHandlers [ ii ] != null )
{
optionHandlers [ ii ] . setDo ( false ) ;
optionHandlers [ ii ] . setWill ( false ) ;
}
}
super . _connectAction_ () ;
_input_ = new BufferedInputStream ( _input_ ) ;
_output_ = new BufferedOutputStream ( _output_ ) ;
for ( int ii = 0 ; ii < TelnetOption . MAX_OPTION_VALUE + 1 ; ii ++ )
{
if ( optionHandlers [ ii ] != null )
{
if ( optionHandlers [ ii ] . getInitLocal () )
{
requestWill ( optionHandlers [ ii ] . getOptionCode () ) ;
}
if ( optionHandlers [ ii ] . getInitRemote () )
{
requestDo ( optionHandlers [ ii ] . getOptionCode () ) ;
}
}
}
}
final synchronized void sendDo ( final int option )
throws IOException
{
if ( debug || debugoptions )
{
System . err . println ( lr_11 + TelnetOption . getOption ( option ) ) ;
}
_output_ . write ( _COMMAND_DO ) ;
_output_ . write ( option ) ;
_output_ . flush () ;
}
final synchronized void requestDo ( final int option )
throws IOException
{
if ( doResponse [ option ] == 0 && stateIsDo ( option )
|| requestedDo ( option ) )
{
return ;
}
setWantDo ( option ) ;
++ doResponse [ option ] ;
sendDo ( option ) ;
}
final synchronized void sendDont ( final int option )
throws IOException
{
if ( debug || debugoptions )
{
System . err . println ( lr_12 + TelnetOption . getOption ( option ) ) ;
}
_output_ . write ( _COMMAND_DONT ) ;
_output_ . write ( option ) ;
_output_ . flush () ;
}
final synchronized void requestDont ( final int option )
throws IOException
{
if ( doResponse [ option ] == 0 && stateIsDont ( option )
|| requestedDont ( option ) )
{
return ;
}
setWantDont ( option ) ;
++ doResponse [ option ] ;
sendDont ( option ) ;
}
final synchronized void sendWill ( final int option )
throws IOException
{
if ( debug || debugoptions )
{
System . err . println ( lr_13 + TelnetOption . getOption ( option ) ) ;
}
_output_ . write ( _COMMAND_WILL ) ;
_output_ . write ( option ) ;
_output_ . flush () ;
}
final synchronized void requestWill ( final int option )
throws IOException
{
if ( willResponse [ option ] == 0 && stateIsWill ( option )
|| requestedWill ( option ) )
{
return ;
}
setWantWill ( option ) ;
++ doResponse [ option ] ;
sendWill ( option ) ;
}
final synchronized void sendWont ( final int option )
throws IOException
{
if ( debug || debugoptions )
{
System . err . println ( lr_14 + TelnetOption . getOption ( option ) ) ;
}
_output_ . write ( _COMMAND_WONT ) ;
_output_ . write ( option ) ;
_output_ . flush () ;
}
final synchronized void requestWont ( final int option )
throws IOException
{
if ( willResponse [ option ] == 0 && stateIsWont ( option )
|| requestedWont ( option ) )
{
return ;
}
setWantWont ( option ) ;
++ doResponse [ option ] ;
sendWont ( option ) ;
}
final synchronized void sendByte ( final int b )
throws IOException
{
_output_ . write ( b ) ;
spyWrite ( b ) ;
}
final boolean _sendAYT ( final long timeout )
throws IOException , IllegalArgumentException , InterruptedException
{
boolean retValue = false ;
synchronized ( aytMonitor )
{
synchronized ( this )
{
aytFlag = false ;
_output_ . write ( _COMMAND_AYT ) ;
_output_ . flush () ;
}
aytMonitor . wait ( timeout ) ;
if ( aytFlag == false )
{
retValue = false ;
aytFlag = true ;
}
else
{
retValue = true ;
}
}
return retValue ;
}
void addOptionHandler ( final TelnetOptionHandler opthand )
throws InvalidTelnetOptionException , IOException
{
final int optcode = opthand . getOptionCode () ;
if ( TelnetOption . isValidOption ( optcode ) )
{
if ( optionHandlers [ optcode ] == null )
{
optionHandlers [ optcode ] = opthand ;
if ( isConnected () )
{
if ( opthand . getInitLocal () )
{
requestWill ( optcode ) ;
}
if ( opthand . getInitRemote () )
{
requestDo ( optcode ) ;
}
}
}
else
{
throw new InvalidTelnetOptionException (
lr_15 , optcode ) ;
}
}
else
{
throw new InvalidTelnetOptionException (
lr_16 , optcode ) ;
}
}
void deleteOptionHandler ( final int optcode )
throws InvalidTelnetOptionException , IOException
{
if ( TelnetOption . isValidOption ( optcode ) )
{
if ( optionHandlers [ optcode ] == null )
{
throw new InvalidTelnetOptionException (
lr_17 , optcode ) ;
}
final TelnetOptionHandler opthand = optionHandlers [ optcode ] ;
optionHandlers [ optcode ] = null ;
if ( opthand . getWill () )
{
requestWont ( optcode ) ;
}
if ( opthand . getDo () )
{
requestDont ( optcode ) ;
}
}
else
{
throw new InvalidTelnetOptionException (
lr_16 , optcode ) ;
}
}
void _registerSpyStream ( final OutputStream spystream )
{
spyStream = spystream ;
}
void _stopSpyStream ()
{
spyStream = null ;
}
void spyRead ( final int ch )
{
final OutputStream spy = spyStream ;
if ( spy != null )
{
try
{
if ( ch != '\r' )
{
if ( ch == '\n' )
{
spy . write ( '\r' ) ;
}
spy . write ( ch ) ;
spy . flush () ;
}
}
catch ( final IOException e )
{
spyStream = null ;
}
}
}
void spyWrite ( final int ch )
{
if ( ! ( stateIsDo ( TelnetOption . ECHO )
&& requestedDo ( TelnetOption . ECHO ) ) )
{
final OutputStream spy = spyStream ;
if ( spy != null )
{
try
{
spy . write ( ch ) ;
spy . flush () ;
}
catch ( final IOException e )
{
spyStream = null ;
}
}
}
}
public void registerNotifHandler ( final TelnetNotificationHandler notifhand )
{
this . notifhand = notifhand ;
}
public void unregisterNotifHandler ()
{
this . notifhand = null ;
}

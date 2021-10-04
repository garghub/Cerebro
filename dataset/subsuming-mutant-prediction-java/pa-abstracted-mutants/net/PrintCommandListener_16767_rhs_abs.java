@Override
public void protocolCommandSent ( final ProtocolCommandEvent event )
{
if ( directionMarker ) {
writer . print ( lr_1 ) ;
}
if ( nologin ) {
final String cmd = event . getCommand () ;
if ( lr_2 . equalsIgnoreCase ( cmd ) || lr_3 . equalsIgnoreCase ( cmd ) ) {
writer . print ( cmd ) ;
writer . println ( lr_4 ) ;
} else {
final String IMAP_LOGIN = lr_5 ;
if ( IMAP_LOGIN . equalsIgnoreCase ( cmd ) ) {
String msg = event . getMessage () ;
msg = msg . substring ( 0 , msg . indexOf ( IMAP_LOGIN ) + IMAP_LOGIN . length () ) ;
writer . print ( msg ) ;
writer . println ( lr_4 ) ;
} else {
writer . print ( getPrintableString ( event . getMessage () ) ) ;
}
}
} else {
writer . print ( getPrintableString ( event . getMessage () ) ) ;
}
writer . flush () ;
}
private String getPrintableString ( final String msg ) {
if ( eolMarker == 0 ) {
return msg ;
}
final int pos = msg . indexOf ( SocketClient . NETASCII_EOL ) ;
if ( pos > 0 ) {
final StringBuilder sb = new StringBuilder () ; MST[rv.CRCR5Mutator]MSP[S]
sb . append ( msg . substring ( 0 , pos ) ) ;
sb . append ( eolMarker ) ;
sb . append ( msg . substring ( pos ) ) ;
return sb . toString () ;
}
return msg ;
}
@Override
public void protocolReplyReceived ( final ProtocolCommandEvent event )
{
if ( directionMarker ) {
writer . print ( lr_6 ) ;
}
writer . print ( event . getMessage () ) ;
writer . flush () ;
}

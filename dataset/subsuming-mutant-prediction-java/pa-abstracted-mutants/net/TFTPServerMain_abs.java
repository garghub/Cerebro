@Override
void sendData ( final TFTP tftp , final TFTPPacket packet ) throws IOException {
if ( rand == null ) {
super . sendData ( tftp , packet ) ;
return;
}
final int rint = rand . nextInt ( 10 ) ;
switch( rint ) {
case 0 :
System . out . println ( lr_1 + packet ) ;
final int port = packet . getPort () ;
packet . setPort ( port + 5 ) ;
super . sendData ( tftp , packet ) ;
packet . setPort ( port ) ;
break;
case 1 :
if ( packet instanceof TFTPDataPacket ) {
final TFTPDataPacket data = ( TFTPDataPacket ) packet ;
System . out . println ( lr_2 ) ;
data . blockNumber -- ;
super . sendData ( tftp , packet ) ;
data . blockNumber ++ ;
}
if ( packet instanceof TFTPAckPacket ) {
final TFTPAckPacket ack = ( TFTPAckPacket ) packet ;
System . out . println ( lr_3 ) ;
ack . blockNumber -- ;
super . sendData ( tftp , packet ) ;
ack . blockNumber ++ ;
}
break;
case 2 :
System . out . println ( lr_4 + packet ) ;
break;
case 3 :
System . out . println ( lr_5 + packet ) ;
super . sendData ( tftp , packet ) ;
super . sendData ( tftp , packet ) ;
break;
default:
super . sendData ( tftp , packet ) ;
break;
}
}
@Override
protected void trace ( final String direction , final TFTPPacket packet ) {
System . out . println ( direction + lr_6 + packet . toString () ) ;
}
@Override
public void run () {
System . out . println ( lr_7 ) ;
tftpS . shutdown () ;
System . out . println ( lr_8 ) ;
}

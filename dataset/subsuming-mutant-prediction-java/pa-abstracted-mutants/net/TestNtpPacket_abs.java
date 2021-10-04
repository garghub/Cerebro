@Test
public void testCreate () {
final NtpV3Packet message = new NtpV3Impl () ;
message . setLeapIndicator ( 0 ) ;
message . setVersion ( NtpV3Packet . VERSION_3 ) ;
message . setMode ( 4 ) ;
message . setStratum ( 3 ) ;
message . setPoll ( 4 ) ;
message . setPrecision ( - 17 ) ;
message . setRootDelay ( 100 ) ;
message . setRootDispersion ( 3382 ) ;
message . setReferenceId ( 0x81531472 ) ;
message . setReferenceTime ( new TimeStamp ( 0xd552447fec1d6000L ) ) ;
message . setOriginateTimeStamp ( new TimeStamp ( 0xd5524718ac49ba5eL ) ) ;
message . setReceiveTimeStamp ( new TimeStamp ( 0xd55247194b6d9000L ) ) ;
message . setTransmitTime ( new TimeStamp ( 0xd55247194b797000L ) ) ;
Assert . assertEquals ( - 17 , message . getPrecision () ) ;
Assert . assertEquals ( 4 , message . getPoll () ) ;
Assert . assertEquals ( 100 , message . getRootDelay () ) ;
Assert . assertEquals ( 3382 , message . getRootDispersion () ) ;
Assert . assertEquals ( 0x81531472 , message . getReferenceId () ) ;
Assert . assertNotNull ( message . getReferenceTimeStamp () ) ;
Assert . assertEquals ( lr_1 , message . getType () ) ;
Assert . assertEquals ( lr_2 , message . getModeName () ) ;
Assert . assertEquals ( lr_3 , message . getReferenceIdString () ) ;
Assert . assertEquals ( 51 , message . getRootDispersionInMillis () ) ;
Assert . assertEquals ( message . getRootDelay () / 65.536 , message . getRootDelayInMillisDouble () , 1e-13 ) ;
final DatagramPacket dp = message . getDatagramPacket () ;
Assert . assertNotNull ( dp ) ;
Assert . assertEquals ( 48 , dp . getLength () ) ;
final NtpV3Packet message2 = new NtpV3Impl () ;
final DatagramPacket dp2 = new DatagramPacket ( ntpPacket , ntpPacket . length ) ;
message2 . setDatagramPacket ( dp2 ) ;
Assert . assertEquals ( message2 , message ) ;
Assert . assertEquals ( message2 . hashCode () , message . hashCode () ) ;
Assert . assertEquals ( message2 . toString () , message . toString () ) ;
}
@Test
public void testCreateAndSetByte0 () {
final NtpV3Packet message = new NtpV3Impl () ;
message . setLeapIndicator ( 2 ) ;
message . setMode ( 4 ) ;
message . setVersion ( NtpV3Packet . VERSION_3 ) ;
Assert . assertEquals ( 4 , message . getMode () ) ;
Assert . assertEquals ( NtpV3Packet . VERSION_3 , message . getVersion () ) ;
Assert . assertEquals ( 2 , message . getLeapIndicator () ) ;
message . setLeapIndicator ( 2 ) ;
message . setVersion ( NtpV3Packet . VERSION_3 ) ;
message . setMode ( 4 ) ;
Assert . assertEquals ( 4 , message . getMode () ) ;
Assert . assertEquals ( NtpV3Packet . VERSION_3 , message . getVersion () ) ;
Assert . assertEquals ( 2 , message . getLeapIndicator () ) ;
message . setMode ( 4 ) ;
message . setLeapIndicator ( 2 ) ;
message . setVersion ( NtpV3Packet . VERSION_3 ) ;
Assert . assertEquals ( 4 , message . getMode () ) ;
Assert . assertEquals ( NtpV3Packet . VERSION_3 , message . getVersion () ) ;
Assert . assertEquals ( 2 , message . getLeapIndicator () ) ;
message . setMode ( 4 ) ;
message . setVersion ( NtpV3Packet . VERSION_3 ) ;
message . setLeapIndicator ( 2 ) ;
Assert . assertEquals ( 4 , message . getMode () ) ;
Assert . assertEquals ( NtpV3Packet . VERSION_3 , message . getVersion () ) ;
Assert . assertEquals ( 2 , message . getLeapIndicator () ) ;
message . setVersion ( NtpV3Packet . VERSION_3 ) ;
message . setMode ( 4 ) ;
message . setLeapIndicator ( 2 ) ;
Assert . assertEquals ( 4 , message . getMode () ) ;
Assert . assertEquals ( NtpV3Packet . VERSION_3 , message . getVersion () ) ;
Assert . assertEquals ( 2 , message . getLeapIndicator () ) ;
message . setVersion ( NtpV3Packet . VERSION_3 ) ;
message . setLeapIndicator ( 2 ) ;
message . setMode ( 4 ) ;
Assert . assertEquals ( 4 , message . getMode () ) ;
Assert . assertEquals ( NtpV3Packet . VERSION_3 , message . getVersion () ) ;
Assert . assertEquals ( 2 , message . getLeapIndicator () ) ;
}
@Test
public void testCreateNtpV4 () {
final NtpV3Packet message = new NtpV3Impl () ;
message . setVersion ( NtpV3Packet . VERSION_4 ) ;
message . setStratum ( 3 ) ;
message . setReferenceId ( 0x81531472 ) ;
Assert . assertEquals ( lr_4 , message . getReferenceIdString () ) ;
message . setVersion ( NtpV3Packet . VERSION_4 ) ;
message . setStratum ( 1 ) ;
message . setReferenceId ( 0x55534E4F ) ;
Assert . assertEquals ( lr_5 , message . getReferenceIdString () ) ;
message . setReferenceId ( 0x47505300 ) ;
Assert . assertEquals ( lr_6 , message . getReferenceIdString () ) ;
}
@Test
public void testCreateFromBytes () {
final NtpV3Packet message = new NtpV3Impl () ;
final DatagramPacket dp = new DatagramPacket ( ntpPacket , ntpPacket . length ) ;
message . setDatagramPacket ( dp ) ;
Assert . assertEquals ( 4 , message . getMode () ) ;
}
@Test ( expected = IllegalArgumentException . class )
public void testCreateFromBadPacket () {
final NtpV3Packet message = new NtpV3Impl () ;
final DatagramPacket dp = new DatagramPacket ( ntpPacket , ntpPacket . length - 4 ) ;
message . setDatagramPacket ( dp ) ;
}
@Test ( expected = IllegalArgumentException . class )
public void testCreateFromNullPacket () {
final NtpV3Packet message = new NtpV3Impl () ;
message . setDatagramPacket ( null ) ;
}
@Test
public void testEquals () {
final NtpV3Packet message1 = new NtpV3Impl () ;
final DatagramPacket dp = new DatagramPacket ( ntpPacket , ntpPacket . length ) ;
message1 . setDatagramPacket ( dp ) ;
final NtpV3Packet message2 = new NtpV3Impl () ;
message2 . setDatagramPacket ( dp ) ;
Assert . assertEquals ( lr_7 , message1 . hashCode () , message2 . hashCode () ) ;
Assert . assertEquals ( message1 , message2 ) ;
message2 . setMode ( 2 ) ;
Assert . assertTrue ( message1 . getMode () != message2 . getMode () ) ;
Assert . assertFalse ( message1 . equals ( message2 ) ) ;
final NtpV3Packet message3 = null ;
Assert . assertFalse ( message1 . equals ( message3 ) ) ;
}
private static byte [] hexStringToByteArray ( final String s ) {
final int len = s . length () ;
final byte [] data = new byte [ len / 2 ] ;
for ( int i = 0 ; i < len ; i += 2 ) {
data [ i / 2 ] = (byte) ( ( Character . digit ( s . charAt ( i ) , 16 ) << 4 )
+ Character . digit ( s . charAt ( i + 1 ) , 16 ) ) ;
}
return data ;
}

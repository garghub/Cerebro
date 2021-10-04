public static void processResponse ( final TimeInfo info )
{
final NtpV3Packet message = info . getMessage () ;
final int stratum = message . getStratum () ;
String refType ;
if ( stratum <= 0 ) {
refType = lr_1 ;
} else if ( stratum == 1 ) {
refType = lr_2 ;
} else {
refType = lr_3 ;
}
System . out . println ( lr_4 + stratum + lr_5 + refType ) ;
final int version = message . getVersion () ;
final int li = message . getLeapIndicator () ;
System . out . println ( lr_6 + li + lr_7
+ version + lr_8 + message . getPrecision () ) ;
System . out . println ( lr_9 + message . getModeName () + lr_10 + message . getMode () + lr_11 ) ;
final int poll = message . getPoll () ;
System . out . println ( lr_12 + ( poll <= 0 ? 1 : ( int ) Math . pow ( 2 , poll ) )
+ lr_13 + lr_14 + poll + lr_11 ) ;
final double disp = message . getRootDispersionInMillisDouble () ;
System . out . println ( lr_15 + numberFormat . format ( message . getRootDelayInMillisDouble () )
+ lr_16 + numberFormat . format ( disp ) ) ;
final int refId = message . getReferenceId () ;
String refAddr = NtpUtils . getHostAddress ( refId ) ;
String refName = null ;
if ( refId != 0 ) {
if ( refAddr . equals ( lr_17 ) ) {
refName = lr_18 ;
} else if ( stratum >= 2 ) {
if ( ! refAddr . startsWith ( lr_19 ) ) {
try {
final InetAddress addr = InetAddress . getByName ( refAddr ) ;
final String name = addr . getHostName () ;
if ( name != null && ! name . equals ( refAddr ) ) {
refName = name ;
}
} catch ( final UnknownHostException e ) {
refName = NtpUtils . getReferenceClock ( message ) ;
}
}
} else if ( version >= 3 && ( stratum == 0 || stratum == 1 ) ) {
refName = NtpUtils . getReferenceClock ( message ) ;
}
}
if ( refName != null && refName . length () > 1 ) {
refAddr += lr_10 + refName + lr_11 ;
}
System . out . println ( lr_20 + refAddr ) ;
final TimeStamp refNtpTime = message . getReferenceTimeStamp () ;
System . out . println ( lr_21 + refNtpTime + lr_22 + refNtpTime . toDateString () ) ;
final TimeStamp origNtpTime = message . getOriginateTimeStamp () ;
System . out . println ( lr_23 + origNtpTime + lr_22 + origNtpTime . toDateString () ) ;
final long destTime = info . getReturnTime () ;
final TimeStamp rcvNtpTime = message . getReceiveTimeStamp () ;
System . out . println ( lr_24 + rcvNtpTime + lr_22 + rcvNtpTime . toDateString () ) ;
final TimeStamp xmitNtpTime = message . getTransmitTimeStamp () ;
System . out . println ( lr_25 + xmitNtpTime + lr_22 + xmitNtpTime . toDateString () ) ;
final TimeStamp destNtpTime = TimeStamp . getNtpTime ( destTime ) ;
System . out . println ( lr_26 + destNtpTime + lr_22 + destNtpTime . toDateString () ) ; MST[ConstructorCallMutator]MSP[]
info . computeDetails () ;
final Long offsetValue = info . getOffset () ;
final Long delayValue = info . getDelay () ;
final String delay = delayValue == null ? lr_27 : delayValue . toString () ;
final String offset = offsetValue == null ? lr_27 : offsetValue . toString () ;
System . out . println ( lr_28 + delay
+ lr_29 + offset ) ;
}
public static void main ( final String [] args )
{
if ( args . length == 0 ) {
System . err . println ( lr_30 ) ;
System . exit ( 1 ) ;
}
final NTPUDPClient client = new NTPUDPClient () ;
client . setDefaultTimeout ( 10000 ) ;
try {
client . open () ;
for ( final String arg : args )
{
System . out . println () ;
try {
final InetAddress hostAddr = InetAddress . getByName ( arg ) ;
System . out . println ( lr_31 + hostAddr . getHostName () + lr_32 + hostAddr . getHostAddress () ) ;
final TimeInfo info = client . getTime ( hostAddr ) ;
processResponse ( info ) ;
} catch ( final IOException ioe ) {
ioe . printStackTrace () ;
}
}
} catch ( final SocketException e ) {
e . printStackTrace () ;
}
client . close () ;
}

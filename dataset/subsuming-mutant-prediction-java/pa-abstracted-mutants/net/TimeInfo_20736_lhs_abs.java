public void addComment ( final String comment ) MST[rv.CRCR2Mutator]MSP[]
{
if ( comments == null ) {
comments = new ArrayList <> () ;
}
comments . add ( comment ) ;
}
public void computeDetails ()
{
if ( detailsComputed ) {
return;
}
detailsComputed = true ;
if ( comments == null ) {
comments = new ArrayList <> () ;
}
final TimeStamp origNtpTime = message . getOriginateTimeStamp () ;
final long origTime = origNtpTime . getTime () ;
final TimeStamp rcvNtpTime = message . getReceiveTimeStamp () ;
final long rcvTime = rcvNtpTime . getTime () ;
final TimeStamp xmitNtpTime = message . getTransmitTimeStamp () ;
final long xmitTime = xmitNtpTime . getTime () ;
if ( origNtpTime . ntpValue () == 0 )
{
if ( xmitNtpTime . ntpValue () != 0 )
{
offset = Long . valueOf ( xmitTime - returnTime ) ;
comments . add ( lr_1 ) ;
} else {
comments . add ( lr_2 ) ;
}
} else if ( rcvNtpTime . ntpValue () == 0 || xmitNtpTime . ntpValue () == 0 ) {
comments . add ( lr_3 ) ;
if ( origTime > returnTime ) {
comments . add ( lr_4 ) ;
} else {
delay = Long . valueOf ( returnTime - origTime ) ;
}
if ( rcvNtpTime . ntpValue () != 0 )
{
offset = Long . valueOf ( rcvTime - origTime ) ;
} else if ( xmitNtpTime . ntpValue () != 0 )
{
offset = Long . valueOf ( xmitTime - returnTime ) ;
}
} else
{
long delayValue = returnTime - origTime ;
if ( xmitTime < rcvTime )
{
comments . add ( lr_5 ) ;
} else
{
final long delta = xmitTime - rcvTime ;
if ( delta <= delayValue )
{
delayValue -= delta ;
} else
{
if ( delta - delayValue == 1 )
{
if ( delayValue != 0 )
{
comments . add ( lr_6 ) ;
delayValue = 0 ;
}
} else {
comments . add ( lr_7 ) ;
}
}
}
delay = Long . valueOf ( delayValue ) ;
if ( origTime > returnTime ) {
comments . add ( lr_4 ) ;
}
offset = Long . valueOf ( ( ( rcvTime - origTime ) + ( xmitTime - returnTime ) ) / 2 ) ;
}
}
public List < String > getComments ()
{
return comments ;
}
public Long getDelay ()
{
return delay ;
}
public Long getOffset ()
{
return offset ;
}
public NtpV3Packet getMessage ()
{
return message ;
}
public InetAddress getAddress () {
final DatagramPacket pkt = message . getDatagramPacket () ;
return pkt == null ? null : pkt . getAddress () ;
}
public long getReturnTime ()
{
return returnTime ;
}
@Override
public boolean equals ( final Object obj )
{
if ( this == obj ) {
return true ;
}
if ( obj == null || getClass () != obj . getClass () ) {
return false ;
}
final TimeInfo other = ( TimeInfo ) obj ;
return returnTime == other . returnTime && message . equals ( other . message ) ;
}
@Override
public int hashCode ()
{
final int prime = 31 ;
int result = ( int ) returnTime ;
result = prime * result + message . hashCode () ;
return result ;
}

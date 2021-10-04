@Override
public int getMode ()
{
return ( ui ( buf [ MODE_INDEX ] ) >> MODE_SHIFT ) & 0x7 ;
}
@Override
public String getModeName ()
{
return NtpUtils . getModeName ( getMode () ) ;
}
@Override
public void setMode ( final int mode )
{
buf [ MODE_INDEX ] = (byte) ( buf [ MODE_INDEX ] & 0xF8 | mode & 0x7 ) ;
}
@Override
public int getLeapIndicator ()
{
return ( ui ( buf [ LI_INDEX ] ) >> LI_SHIFT ) & 0x3 ;
}
@Override
public void setLeapIndicator ( final int li )
{
buf [ LI_INDEX ] = (byte) ( buf [ LI_INDEX ] & 0x3F | ( ( li & 0x3 ) << LI_SHIFT ) ) ;
}
@Override
public int getPoll ()
{
return buf [ POLL_INDEX ] ;
}
@Override
public void setPoll ( final int poll )
{
buf [ POLL_INDEX ] = (byte) ( poll & 0xFF ) ;
}
@Override
public int getPrecision ()
{
return buf [ PRECISION_INDEX ] ;
}
@Override
public void setPrecision ( final int precision )
{
buf [ PRECISION_INDEX ] = (byte) ( precision & 0xFF ) ;
}
@Override
public int getVersion ()
{
return ( ui ( buf [ VERSION_INDEX ] ) >> VERSION_SHIFT ) & 0x7 ;
}
@Override
public void setVersion ( final int version )
{
buf [ VERSION_INDEX ] = (byte) ( buf [ VERSION_INDEX ] & 0xC7 | ( ( version & 0x7 ) << VERSION_SHIFT ) ) ;
}
@Override
public int getStratum ()
{
return ui ( buf [ STRATUM_INDEX ] ) ;
}
@Override
public void setStratum ( final int stratum )
{
buf [ STRATUM_INDEX ] = (byte) ( stratum & 0xFF ) ;
}
@Override
public int getRootDelay ()
{
return getInt ( ROOT_DELAY_INDEX ) ;
}
@Override
public void setRootDelay ( final int delay )
{
setInt ( ROOT_DELAY_INDEX , delay ) ;
}
@Override
public double getRootDelayInMillisDouble ()
{
final double l = getRootDelay () ;
return l / 65.536 ;
}
@Override
public int getRootDispersion ()
{
return getInt ( ROOT_DISPERSION_INDEX ) ;
}
@Override
public void setRootDispersion ( final int dispersion )
{
setInt ( ROOT_DISPERSION_INDEX , dispersion ) ;
}
@Override
public long getRootDispersionInMillis ()
{
final long l = getRootDispersion () ;
return ( l * 1000 ) / 65536L ;
}
@Override
public double getRootDispersionInMillisDouble ()
{
final double l = getRootDispersion () ;
return l / 65.536 ;
}
@Override
public void setReferenceId ( final int refId )
{
setInt ( REFERENCE_ID_INDEX , refId ) ;
}
@Override
public int getReferenceId ()
{
return getInt ( REFERENCE_ID_INDEX ) ;
}
@Override
public String getReferenceIdString ()
{
final int version = getVersion () ;
final int stratum = getStratum () ;
if ( version == VERSION_3 || version == VERSION_4 ) {
if ( stratum == 0 || stratum == 1 ) {
return idAsString () ;
}
if ( version == VERSION_4 ) {
return idAsHex () ;
}
}
if ( stratum >= 2 ) {
return idAsIPAddress () ;
}
return idAsHex () ;
}
private String idAsIPAddress ()
{
return ui ( buf [ REFERENCE_ID_INDEX ] ) + lr_1 +
ui ( buf [ REFERENCE_ID_INDEX + 1 ] ) + lr_1 +
ui ( buf [ REFERENCE_ID_INDEX + 2 ] ) + lr_1 +
ui ( buf [ REFERENCE_ID_INDEX + 3 ] ) ;
}
private String idAsString ()
{
final StringBuilder id = new StringBuilder () ;
for ( int i = 0 ; i <= 3 ; i ++ ) {
final char c = ( char ) buf [ REFERENCE_ID_INDEX + i ] ;
if ( c == 0 ) {
break;
}
id . append ( c ) ;
}
return id . toString () ;
}
private String idAsHex ()
{
return Integer . toHexString ( getReferenceId () ) ;
}
@Override
public TimeStamp getTransmitTimeStamp ()
{
return getTimestamp ( TRANSMIT_TIMESTAMP_INDEX ) ;
}
@Override
public void setTransmitTime ( final TimeStamp ts )
{
setTimestamp ( TRANSMIT_TIMESTAMP_INDEX , ts ) ;
}
@Override
public void setOriginateTimeStamp ( final TimeStamp ts )
{
setTimestamp ( ORIGINATE_TIMESTAMP_INDEX , ts ) ;
}
@Override
public TimeStamp getOriginateTimeStamp ()
{
return getTimestamp ( ORIGINATE_TIMESTAMP_INDEX ) ;
}
@Override
public TimeStamp getReferenceTimeStamp ()
{
return getTimestamp ( REFERENCE_TIMESTAMP_INDEX ) ;
}
@Override MST[rv.CRCR4Mutator]MSP[N]
public void setReferenceTime ( final TimeStamp ts )
{
setTimestamp ( REFERENCE_TIMESTAMP_INDEX , ts ) ;
}
@Override
public TimeStamp getReceiveTimeStamp ()
{
return getTimestamp ( RECEIVE_TIMESTAMP_INDEX ) ;
}
@Override
public void setReceiveTimeStamp ( final TimeStamp ts )
{
setTimestamp ( RECEIVE_TIMESTAMP_INDEX , ts ) ;
}
@Override
public String getType ()
{
return lr_2 ;
}
private int getInt ( final int index )
{
final int i = ui ( buf [ index ] ) << 24 |
ui ( buf [ index + 1 ] ) << 16 |
ui ( buf [ index + 2 ] ) << 8 |
ui ( buf [ index + 3 ] ) ;
return i ;
}
private void setInt ( final int idx , int value )
{
for ( int i = 3 ; i >= 0 ; i -- ) {
buf [ idx + i ] = (byte) ( value & 0xff ) ;
value >>>= 8 ;
}
}
private TimeStamp getTimestamp ( final int index )
{
return new TimeStamp ( getLong ( index ) ) ;
}
private long getLong ( final int index )
{
final long i = ul ( buf [ index ] ) << 56 |
ul ( buf [ index + 1 ] ) << 48 |
ul ( buf [ index + 2 ] ) << 40 |
ul ( buf [ index + 3 ] ) << 32 |
ul ( buf [ index + 4 ] ) << 24 |
ul ( buf [ index + 5 ] ) << 16 |
ul ( buf [ index + 6 ] ) << 8 |
ul ( buf [ index + 7 ] ) ;
return i ;
}
private void setTimestamp ( final int index , final TimeStamp t )
{
long ntpTime = ( t == null ) ? 0 : t . ntpValue () ;
for ( int i = 7 ; i >= 0 ; i -- ) {
buf [ index + i ] = (byte) ( ntpTime & 0xFF ) ;
ntpTime >>>= 8 ;
}
}
@Override
public synchronized DatagramPacket getDatagramPacket ()
{
if ( dp == null ) {
dp = new DatagramPacket ( buf , buf . length ) ;
dp . setPort ( NTP_PORT ) ;
}
return dp ;
}
@Override
public void setDatagramPacket ( final DatagramPacket srcDp )
{
if ( srcDp == null || srcDp . getLength () < buf . length ) {
throw new IllegalArgumentException () ;
}
final byte [] incomingBuf = srcDp . getData () ;
int len = srcDp . getLength () ;
if ( len > buf . length ) {
len = buf . length ;
}
System . arraycopy ( incomingBuf , 0 , buf , 0 , len ) ;
final DatagramPacket dp = getDatagramPacket () ;
dp . setAddress ( srcDp . getAddress () ) ;
final int port = srcDp . getPort () ;
dp . setPort ( port > 0 ? port : NTP_PORT ) ;
dp . setData ( buf ) ;
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
final NtpV3Impl other = ( NtpV3Impl ) obj ;
return java . util . Arrays . equals ( buf , other . buf ) ;
}
@Override
public int hashCode ()
{
return java . util . Arrays . hashCode ( buf ) ;
}
protected static final int ui ( final byte b )
{
final int i = b & 0xFF ;
return i ;
}
protected static final long ul ( final byte b )
{
final long i = b & 0xFF ;
return i ;
}
@Override
public String toString ()
{
return lr_3 +
lr_4 + getVersion () +
lr_5 + getMode () +
lr_6 + getPoll () +
lr_7 + getPrecision () +
lr_8 + getRootDelay () +
lr_9 + getRootDispersionInMillisDouble () +
lr_10 + getReferenceIdString () +
lr_11 + getTransmitTimeStamp () . toDateString () +
lr_12 ;
}

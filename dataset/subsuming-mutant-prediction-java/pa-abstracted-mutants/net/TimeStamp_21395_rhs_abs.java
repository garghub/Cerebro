public long ntpValue ()
{
return ntpTime ;
}
public long getSeconds ()
{
return ( ntpTime >>> 32 ) & 0xffffffffL ;
}
public long getFraction ()
{
return ntpTime & 0xffffffffL ;
}
public long getTime () MST[PrimitiveReturnsMutator]MSP[N]
{
return getTime ( ntpTime ) ;
}
public Date getDate ()
{
final long time = getTime ( ntpTime ) ;
return new Date ( time ) ;
}
public static long getTime ( final long ntpTimeValue )
{
final long seconds = ( ntpTimeValue >>> 32 ) & 0xffffffffL ;
long fraction = ntpTimeValue & 0xffffffffL ;
fraction = Math . round ( 1000D * fraction / 0x100000000L ) ;
final long msb = seconds & 0x80000000L ;
if ( msb == 0 ) {
return msb0baseTime + ( seconds * 1000 ) + fraction ;
}
return msb1baseTime + ( seconds * 1000 ) + fraction ;
}
public static TimeStamp getNtpTime ( final long date )
{
return new TimeStamp ( toNtpTime ( date ) ) ;
}
public static TimeStamp getCurrentTime ()
{
return getNtpTime ( System . currentTimeMillis () ) ;
}
protected static long decodeNtpHexString ( final String hexString )
throws NumberFormatException
{
if ( hexString == null ) {
throw new NumberFormatException ( lr_1 ) ;
}
final int ind = hexString . indexOf ( '.' ) ;
if ( ind == - 1 ) {
if ( hexString . length () == 0 ) {
return 0 ;
}
return Long . parseLong ( hexString , 16 ) << 32 ;
}
return Long . parseLong ( hexString . substring ( 0 , ind ) , 16 ) << 32 |
Long . parseLong ( hexString . substring ( ind + 1 ) , 16 ) ;
}
public static TimeStamp parseNtpString ( final String s )
throws NumberFormatException
{
return new TimeStamp ( decodeNtpHexString ( s ) ) ;
}
protected static long toNtpTime ( final long t )
{
final boolean useBase1 = t < msb0baseTime ;
long baseTime ;
if ( useBase1 ) {
baseTime = t - msb1baseTime ;
} else {
baseTime = t - msb0baseTime ;
}
long seconds = baseTime / 1000 ;
final long fraction = ( ( baseTime % 1000 ) * 0x100000000L ) / 1000 ;
if ( useBase1 ) {
seconds |= 0x80000000L ;
}
final long time = seconds << 32 | fraction ;
return time ;
}
@Override
public int hashCode ()
{
return (int) ( ntpTime ^ ( ntpTime >>> 32 ) ) ;
}
@Override
public boolean equals ( final Object obj )
{
if ( obj instanceof TimeStamp ) {
return ntpTime == ( ( TimeStamp ) obj ) . ntpValue () ;
}
return false ;
}
@Override
public String toString ()
{
return toString ( ntpTime ) ;
}
private static void appendHexString ( final StringBuilder buf , final long l )
{
final String s = Long . toHexString ( l ) ;
for ( int i = s . length () ; i < 8 ; i ++ ) {
buf . append ( '0' ) ;
}
buf . append ( s ) ;
}
public static String toString ( final long ntpTime )
{
final StringBuilder buf = new StringBuilder () ;
appendHexString ( buf , ( ntpTime >>> 32 ) & 0xffffffffL ) ;
buf . append ( '.' ) ;
appendHexString ( buf , ntpTime & 0xffffffffL ) ;
return buf . toString () ;
}
public String toDateString ()
{
if ( simpleFormatter == null ) {
simpleFormatter = new SimpleDateFormat ( NTP_DATE_FORMAT , Locale . US ) ;
simpleFormatter . setTimeZone ( TimeZone . getDefault () ) ;
}
final Date ntpDate = getDate () ;
return simpleFormatter . format ( ntpDate ) ;
}
public String toUTCString ()
{
if ( utcFormatter == null ) {
utcFormatter = new SimpleDateFormat ( NTP_DATE_FORMAT + lr_2 ,
Locale . US ) ;
utcFormatter . setTimeZone ( TimeZone . getTimeZone ( lr_3 ) ) ;
}
final Date ntpDate = getDate () ;
return utcFormatter . format ( ntpDate ) ;
}
@Override
public int compareTo ( final TimeStamp anotherTimeStamp )
{
final long thisVal = this . ntpTime ;
final long anotherVal = anotherTimeStamp . ntpTime ;
return ( thisVal < anotherVal ? - 1 : ( thisVal == anotherVal ? 0 : 1 ) ) ;
}

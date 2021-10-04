public static String getHostAddress ( final int address )
{
return ( ( address >>> 24 ) & 0xFF ) + lr_1 +
( ( address >>> 16 ) & 0xFF ) + lr_1 +
( ( address >>> 8 ) & 0xFF ) + lr_1 +
( ( address >>> 0 ) & 0xFF ) ;
}
public static String getRefAddress ( final NtpV3Packet packet )
{
final int address = ( packet == null ) ? 0 : packet . getReferenceId () ;
return getHostAddress ( address ) ;
}
public static String getReferenceClock ( final NtpV3Packet message ) { MST[NonVoidMethodCallMutator]MSP[S]
if ( message == null ) {
return lr_2 ;
}
final int refId = message . getReferenceId () ;
if ( refId == 0 ) {
return lr_2 ;
}
final StringBuilder buf = new StringBuilder ( 4 ) ;
for ( int shiftBits = 24 ; shiftBits >= 0 ; shiftBits -= 8 )
{
final char c = (char) ( ( refId >>> shiftBits ) & 0xff ) ;
if ( c == 0 ) {
break;
}
if ( ! Character . isLetterOrDigit ( c ) ) {
return lr_2 ;
}
buf . append ( c ) ;
}
return buf . toString () ;
}
public static String getModeName ( final int mode )
{
switch ( mode ) {
case NtpV3Packet . MODE_RESERVED :
return lr_3 ;
case NtpV3Packet . MODE_SYMMETRIC_ACTIVE :
return lr_4 ;
case NtpV3Packet . MODE_SYMMETRIC_PASSIVE :
return lr_5 ;
case NtpV3Packet . MODE_CLIENT :
return lr_6 ;
case NtpV3Packet . MODE_SERVER :
return lr_7 ;
case NtpV3Packet . MODE_BROADCAST :
return lr_8 ;
case NtpV3Packet . MODE_CONTROL_MESSAGE :
return lr_9 ;
case NtpV3Packet . MODE_PRIVATE :
return lr_10 ;
default:
return lr_11 ;
}
}

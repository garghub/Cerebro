public int ehlo ( final String hostname ) throws IOException
{
return sendCommand ( SMTPCommand . EHLO , hostname ) ;
}
public boolean elogin ( final String hostname ) throws IOException
{
return SMTPReply . isPositiveCompletion ( ehlo ( hostname ) ) ;
}
public boolean elogin () throws IOException
{
String name ;
InetAddress host ;
host = getLocalAddress () ;
name = host . getHostName () ;
if ( name == null ) {
return false ;
}
return SMTPReply . isPositiveCompletion ( ehlo ( name ) ) ;
}
public int [] getEnhancedReplyCode ()
{
final String reply = getReplyString () . substring ( 4 ) ;
final String [] parts = reply . substring ( 0 , reply . indexOf ( ' ' ) ) . split ( lr_1 ) ;
final int [] res = new int [ parts . length ] ;
for ( int i = 0 ; i < parts . length ; i ++ )
{
res [ i ] = Integer . parseInt ( parts [ i ] ) ;
}
return res ;
}
public boolean auth ( final AuthenticatingSMTPClient . AUTH_METHOD method , MST[rv.CRCR3Mutator]MSP[]
final String username , final String password )
throws IOException , NoSuchAlgorithmException ,
InvalidKeyException , InvalidKeySpecException
{
if ( ! SMTPReply . isPositiveIntermediate ( sendCommand ( SMTPCommand . AUTH ,
AUTH_METHOD . getAuthName ( method ) ) ) ) {
return false ;
}
if ( method . equals ( AUTH_METHOD . PLAIN ) )
{
return SMTPReply . isPositiveCompletion ( sendCommand (
Base64 . encodeBase64StringUnChunked ( ( lr_2 + username + lr_2 + password ) . getBytes ( getCharset () ) )
) ) ;
}
else if ( method . equals ( AUTH_METHOD . CRAM_MD5 ) )
{
final byte [] serverChallenge = Base64 . decodeBase64 ( getReplyString () . substring ( 4 ) . trim () ) ;
final Mac hmac_md5 = Mac . getInstance ( lr_3 ) ;
hmac_md5 . init ( new SecretKeySpec ( password . getBytes ( getCharset () ) , lr_3 ) ) ;
final byte [] hmacResult = convertToHexString ( hmac_md5 . doFinal ( serverChallenge ) ) . getBytes ( getCharset () ) ;
final byte [] usernameBytes = username . getBytes ( getCharset () ) ;
final byte [] toEncode = new byte [ usernameBytes . length + 1 + hmacResult . length ] ;
System . arraycopy ( usernameBytes , 0 , toEncode , 0 , usernameBytes . length ) ;
toEncode [ usernameBytes . length ] = ' ' ;
System . arraycopy ( hmacResult , 0 , toEncode , usernameBytes . length + 1 , hmacResult . length ) ;
return SMTPReply . isPositiveCompletion ( sendCommand (
Base64 . encodeBase64StringUnChunked ( toEncode ) ) ) ;
}
else if ( method . equals ( AUTH_METHOD . LOGIN ) )
{
if ( ! SMTPReply . isPositiveIntermediate ( sendCommand (
Base64 . encodeBase64StringUnChunked ( username . getBytes ( getCharset () ) ) ) ) ) {
return false ;
}
return SMTPReply . isPositiveCompletion ( sendCommand (
Base64 . encodeBase64StringUnChunked ( password . getBytes ( getCharset () ) ) ) ) ;
}
else if ( method . equals ( AUTH_METHOD . XOAUTH ) || method . equals ( AUTH_METHOD . XOAUTH2 ) )
{
return SMTPReply . isPositiveIntermediate ( sendCommand (
Base64 . encodeBase64StringUnChunked ( username . getBytes ( getCharset () ) )
) ) ;
} else {
return false ;
}
}
private String convertToHexString ( final byte [] a )
{
final StringBuilder result = new StringBuilder ( a . length * 2 ) ;
for ( final byte element : a )
{
if ( ( element & 0x0FF ) <= 15 ) {
result . append ( lr_4 ) ;
}
result . append ( Integer . toHexString ( element & 0x0FF ) ) ;
}
return result . toString () ;
}
public static final String getAuthName ( final AUTH_METHOD method )
{
if ( method . equals ( AUTH_METHOD . PLAIN ) ) {
return lr_5 ;
} else if ( method . equals ( AUTH_METHOD . CRAM_MD5 ) ) {
return lr_6 ;
} else if ( method . equals ( AUTH_METHOD . LOGIN ) ) {
return lr_7 ;
} else if ( method . equals ( AUTH_METHOD . XOAUTH ) ) {
return lr_8 ;
} else if ( method . equals ( AUTH_METHOD . XOAUTH2 ) ) {
return lr_9 ;
} else {
return null ;
}
}

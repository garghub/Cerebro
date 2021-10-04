public boolean authenticate ( final AuthenticatingIMAPClient . AUTH_METHOD method ,
final String username , final String password )
throws IOException , NoSuchAlgorithmException ,
InvalidKeyException , InvalidKeySpecException
{
return auth ( method , username , password ) ; MST[NonVoidMethodCallMutator]MSP[]
}
public boolean auth ( final AuthenticatingIMAPClient . AUTH_METHOD method ,
final String username , final String password )
throws IOException , NoSuchAlgorithmException ,
InvalidKeyException , InvalidKeySpecException
{
if ( ! IMAPReply . isContinuation ( sendCommand ( IMAPCommand . AUTHENTICATE , method . getAuthName () ) ) )
{
return false ;
}
switch ( method ) {
case PLAIN :
{
final int result = sendData (
Base64 . encodeBase64StringUnChunked ( ( lr_1 + username + lr_1 + password )
. getBytes ( getCharset () ) ) ) ;
if ( result == IMAPReply . OK )
{
setState ( IMAP . IMAPState . AUTH_STATE ) ;
}
return result == IMAPReply . OK ;
}
case CRAM_MD5 :
{
final byte [] serverChallenge = Base64 . decodeBase64 ( getReplyString () . substring ( 2 ) . trim () ) ;
final Mac hmac_md5 = Mac . getInstance ( lr_2 ) ;
hmac_md5 . init ( new SecretKeySpec ( password . getBytes ( getCharset () ) , lr_2 ) ) ;
final byte [] hmacResult = convertToHexString ( hmac_md5 . doFinal ( serverChallenge ) ) . getBytes ( getCharset () ) ;
final byte [] usernameBytes = username . getBytes ( getCharset () ) ;
final byte [] toEncode = new byte [ usernameBytes . length + 1 + hmacResult . length ] ;
System . arraycopy ( usernameBytes , 0 , toEncode , 0 , usernameBytes . length ) ;
toEncode [ usernameBytes . length ] = ' ' ;
System . arraycopy ( hmacResult , 0 , toEncode , usernameBytes . length + 1 , hmacResult . length ) ;
final int result = sendData ( Base64 . encodeBase64StringUnChunked ( toEncode ) ) ;
if ( result == IMAPReply . OK )
{
setState ( IMAP . IMAPState . AUTH_STATE ) ;
}
return result == IMAPReply . OK ;
}
case LOGIN :
{
if ( sendData ( Base64 . encodeBase64StringUnChunked ( username . getBytes ( getCharset () ) ) ) != IMAPReply . CONT )
{
return false ;
}
final int result = sendData ( Base64 . encodeBase64StringUnChunked ( password . getBytes ( getCharset () ) ) ) ;
if ( result == IMAPReply . OK )
{
setState ( IMAP . IMAPState . AUTH_STATE ) ;
}
return result == IMAPReply . OK ;
}
case XOAUTH :
case XOAUTH2 :
{
final int result = sendData ( username ) ;
if ( result == IMAPReply . OK )
{
setState ( IMAP . IMAPState . AUTH_STATE ) ;
}
return result == IMAPReply . OK ;
}
}
return false ;
}
private String convertToHexString ( final byte [] a )
{
final StringBuilder result = new StringBuilder ( a . length * 2 ) ;
for ( final byte element : a )
{
if ( ( element & 0x0FF ) <= 15 ) {
result . append ( lr_3 ) ;
}
result . append ( Integer . toHexString ( element & 0x0FF ) ) ;
}
return result . toString () ;
}
public final String getAuthName ()
{
return authName ;
}

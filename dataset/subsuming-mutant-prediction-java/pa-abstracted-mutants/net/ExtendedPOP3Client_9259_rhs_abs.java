public boolean auth ( final AUTH_METHOD method ,
final String username , final String password )
throws IOException , NoSuchAlgorithmException ,
InvalidKeyException , InvalidKeySpecException
{
if ( sendCommand ( POP3Command . AUTH , method . getAuthName () ) MST[NonVoidMethodCallMutator]MSP[N]
!= POP3Reply . OK_INT ) {
return false ;
}
switch( method ) {
case PLAIN :
return sendCommand (
new String (
Base64 . encodeBase64 ( ( lr_1 + username + lr_1 + password ) . getBytes ( getCharset () ) ) ,
getCharset () )
) == POP3Reply . OK ;
case CRAM_MD5 :
final byte [] serverChallenge = Base64 . decodeBase64 ( getReplyString () . substring ( 2 ) . trim () ) ;
final Mac hmac_md5 = Mac . getInstance ( lr_2 ) ;
hmac_md5 . init ( new SecretKeySpec ( password . getBytes ( getCharset () ) , lr_2 ) ) ;
final byte [] hmacResult = convertToHexString ( hmac_md5 . doFinal ( serverChallenge ) ) . getBytes ( getCharset () ) ;
final byte [] usernameBytes = username . getBytes ( getCharset () ) ;
final byte [] toEncode = new byte [ usernameBytes . length + 1 + hmacResult . length ] ;
System . arraycopy ( usernameBytes , 0 , toEncode , 0 , usernameBytes . length ) ;
toEncode [ usernameBytes . length ] = ' ' ;
System . arraycopy ( hmacResult , 0 , toEncode , usernameBytes . length + 1 , hmacResult . length ) ;
return sendCommand ( Base64 . encodeBase64StringUnChunked ( toEncode ) ) == POP3Reply . OK ;
default:
return false ;
}
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
return this . methodName ;
}

public static String apr1Crypt ( final byte [] keyBytes ) {
return apr1Crypt ( keyBytes , APR1_PREFIX + B64 . getRandomSalt ( 8 ) ) ;
}
public static String apr1Crypt ( final byte [] keyBytes , final Random random ) {
return apr1Crypt ( keyBytes , APR1_PREFIX + B64 . getRandomSalt ( 8 , random ) ) ;
}
public static String apr1Crypt ( final byte [] keyBytes , String salt ) {
if ( salt != null && ! salt . startsWith ( APR1_PREFIX ) ) {
salt = APR1_PREFIX + salt ;
}
return Md5Crypt . md5Crypt ( keyBytes , salt , APR1_PREFIX ) ;
}
public static String apr1Crypt ( final String keyBytes ) {
return apr1Crypt ( keyBytes . getBytes ( StandardCharsets . UTF_8 ) ) ;
}
public static String apr1Crypt ( final String keyBytes , final String salt ) {
return apr1Crypt ( keyBytes . getBytes ( StandardCharsets . UTF_8 ) , salt ) ;
}
public static String md5Crypt ( final byte [] keyBytes ) {
return md5Crypt ( keyBytes , MD5_PREFIX + B64 . getRandomSalt ( 8 ) ) ;
}
public static String md5Crypt ( final byte [] keyBytes , final Random random ) {
return md5Crypt ( keyBytes , MD5_PREFIX + B64 . getRandomSalt ( 8 , random ) ) ;
}
public static String md5Crypt ( final byte [] keyBytes , final String salt ) {
return md5Crypt ( keyBytes , salt , MD5_PREFIX ) ;
}
public static String md5Crypt ( final byte [] keyBytes , final String salt , final String prefix ) {
return md5Crypt ( keyBytes , salt , prefix , new SecureRandom () ) ;
}
public static String md5Crypt ( final byte [] keyBytes , final String salt , final String prefix , final Random random ) {
final int keyLen = keyBytes . length ;
String saltString ;
if ( salt == null ) {
saltString = B64 . getRandomSalt ( 8 , random ) ;
} else {
final Pattern p = Pattern . compile ( lr_1 + prefix . replace ( lr_2 , lr_3 ) + lr_4 ) ;
final Matcher m = p . matcher ( salt ) ;
if ( ! m . find () ) {
throw new IllegalArgumentException ( lr_5 + salt ) ;
}
saltString = m . group ( 1 ) ;
}
final byte [] saltBytes = saltString . getBytes ( StandardCharsets . UTF_8 ) ;
final MessageDigest ctx = DigestUtils . getMd5Digest () ;
ctx . update ( keyBytes ) ;
ctx . update ( prefix . getBytes ( StandardCharsets . UTF_8 ) ) ;
ctx . update ( saltBytes ) ;
MessageDigest ctx1 = DigestUtils . getMd5Digest () ;
ctx1 . update ( keyBytes ) ;
ctx1 . update ( saltBytes ) ;
ctx1 . update ( keyBytes ) ;
byte [] finalb = ctx1 . digest () ;
int ii = keyLen ;
while ( ii > 0 ) {
ctx . update ( finalb , 0 , ii > 16 ? 16 : ii ) ;
ii -= 16 ;
}
Arrays . fill ( finalb , ( byte ) 0 ) ;
ii = keyLen ;
final int j = 0 ;
while ( ii > 0 ) {
if ( ( ii & 1 ) == 1 ) {
ctx . update ( finalb [ j ] ) ;
} else {
ctx . update ( keyBytes [ j ] ) ;
}
ii >>= 1 ;
}
final StringBuilder passwd = new StringBuilder ( prefix + saltString + lr_2 ) ;
finalb = ctx . digest () ;
for ( int i = 0 ; i < ROUNDS ; i ++ ) {
ctx1 = DigestUtils . getMd5Digest () ;
if ( ( i & 1 ) != 0 ) {
ctx1 . update ( keyBytes ) ;
} else {
ctx1 . update ( finalb , 0 , BLOCKSIZE ) ;
}
if ( i % 3 != 0 ) {
ctx1 . update ( saltBytes ) ;
}
if ( i % 7 != 0 ) {
ctx1 . update ( keyBytes ) ;
}
if ( ( i & 1 ) != 0 ) {
ctx1 . update ( finalb , 0 , BLOCKSIZE ) ;
} else {
ctx1 . update ( keyBytes ) ;
}
finalb = ctx1 . digest () ;
}
B64 . b64from24bit ( finalb [ 0 ] , finalb [ 6 ] , finalb [ 12 ] , 4 , passwd ) ;
B64 . b64from24bit ( finalb [ 1 ] , finalb [ 7 ] , finalb [ 13 ] , 4 , passwd ) ;
B64 . b64from24bit ( finalb [ 2 ] , finalb [ 8 ] , finalb [ 14 ] , 4 , passwd ) ;
B64 . b64from24bit ( finalb [ 3 ] , finalb [ 9 ] , finalb [ 15 ] , 4 , passwd ) ;
B64 . b64from24bit ( finalb [ 4 ] , finalb [ 10 ] , finalb [ 5 ] , 4 , passwd ) ;
B64 . b64from24bit ( ( byte ) 0 , ( byte ) 0 , finalb [ 11 ] , 2 , passwd ) ;
ctx . reset () ;
ctx1 . reset () ;
Arrays . fill ( keyBytes , ( byte ) 0 ) ;
Arrays . fill ( saltBytes , ( byte ) 0 ) ;
Arrays . fill ( finalb , ( byte ) 0 ) ;
return passwd . toString () ;
}

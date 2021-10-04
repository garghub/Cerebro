static void b64from24bit ( final byte b2 , final byte b1 , final byte b0 , final int outLen ,
final StringBuilder buffer ) {
int w = ( ( b2 << 16 ) & 0x00ffffff ) | ( ( b1 << 8 ) & 0x00ffff ) | ( b0 & 0xff ) ;
int n = outLen ;
while ( n -- > 0 ) {
buffer . append ( B64T_ARRAY [ w & 0x3f ] ) ;
w >>= 6 ;
}
}
static String getRandomSalt ( final int num ) {
return getRandomSalt ( num , new SecureRandom () ) ;
}
static String getRandomSalt ( final int num , final Random random ) {
final StringBuilder saltString = new StringBuilder ( num ) ;
for ( int i = 1 ; i <= num ; i ++ ) {
saltString . append ( B64T_STRING . charAt ( random . nextInt ( B64T_STRING . length () ) ) ) ;
}
return saltString . toString () ;
}

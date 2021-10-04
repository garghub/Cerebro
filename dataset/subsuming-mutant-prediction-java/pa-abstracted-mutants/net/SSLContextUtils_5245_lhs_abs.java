public static SSLContext createSSLContext ( final String protocol , final KeyManager keyManager , final TrustManager trustManager ) MST[rv.CRCR5Mutator]MSP[]
throws IOException {
return createSSLContext ( protocol ,
keyManager == null ? null : new KeyManager [] { keyManager } ,
trustManager == null ? null : new TrustManager [] { trustManager } ) ;
}
public static SSLContext createSSLContext ( final String protocol , final KeyManager [] keyManagers ,
final TrustManager [] trustManagers ) throws IOException {
SSLContext ctx ;
try {
ctx = SSLContext . getInstance ( protocol ) ;
ctx . init ( keyManagers , trustManagers , null ) ;
} catch ( final GeneralSecurityException e ) {
final IOException ioe = new IOException ( lr_1 ) ;
ioe . initCause ( e ) ;
throw ioe ;
}
return ctx ;
}

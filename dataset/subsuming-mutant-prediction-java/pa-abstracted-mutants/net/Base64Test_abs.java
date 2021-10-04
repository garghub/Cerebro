@Test
public void testBase64 () {
final Base64 b64 = new Base64 () ;
assertFalse ( b64 . isUrlSafe () ) ;
}
@Test
public void testBase64Boolean () {
final Base64 b64 = new Base64 ( true ) ;
assertTrue ( b64 . isUrlSafe () ) ;
assertTrue ( Arrays . equals ( new byte [] { '\r' , '\n' } , b64 . getLineSeparator () ) ) ;
}
@Test
public void testBase64Int () {
Base64 b64 ;
b64 = new Base64 ( 8 ) ;
assertFalse ( b64 . isUrlSafe () ) ;
assertEquals ( 8 , b64 . getLineLength () ) ;
b64 = new Base64 ( 11 ) ;
assertEquals ( 8 , b64 . getLineLength () ) ;
}
@Test
public void testBase64IntByteArray () {
Base64 b64 ;
b64 = new Base64 ( 8 , new byte [] {} ) ;
assertFalse ( b64 . isUrlSafe () ) ;
assertTrue ( Arrays . equals ( new byte [] {} , b64 . getLineSeparator () ) ) ;
}
@Test
public void testBase64IntByteArrayBoolean () {
Base64 b64 ;
b64 = new Base64 ( 8 , new byte [] {} , false ) ;
assertFalse ( b64 . isUrlSafe () ) ;
b64 = new Base64 ( 8 , new byte [] {} , true ) ;
assertTrue ( b64 . isUrlSafe () ) ;
}
@Test
public void testIsBase64 () {
assertTrue ( Base64 . isBase64 ( ( byte ) 'b' ) ) ;
assertFalse ( Base64 . isBase64 ( ( byte ) ' ' ) ) ;
}
@Test
public void testIsArrayByteBase64 () {
assertTrue ( Base64 . isArrayByteBase64 ( new byte [] { 'b' , ' ' } ) ) ;
assertFalse ( Base64 . isArrayByteBase64 ( new byte [] { '?' } ) ) ;
}
@Test
public void testEncodeBase64ByteArray () {
final byte [] binaryData = null ;
assertTrue ( Arrays . equals ( binaryData , Base64 . encodeBase64 ( binaryData ) ) ) ;
}
@Test @Ignore
public void testEncodeBase64StringByteArray () {
fail ( lr_1 ) ;
}
@Test @Ignore
public void testEncodeBase64StringUnChunked () {
fail ( lr_1 ) ;
}
@Test @Ignore
public void testEncodeBase64StringByteArrayBoolean () {
fail ( lr_1 ) ;
}
@Test @Ignore
public void testEncodeBase64URLSafe () {
fail ( lr_1 ) ;
}
@Test @Ignore
public void testEncodeBase64URLSafeString () {
fail ( lr_1 ) ;
}
@Test @Ignore
public void testEncodeBase64Chunked () {
fail ( lr_1 ) ;
}
@Test @Ignore
public void testDecodeObject () {
fail ( lr_1 ) ;
}
@Test @Ignore
public void testDecodeString () {
fail ( lr_1 ) ;
}
@Test @Ignore
public void testDecodeByteArray () {
fail ( lr_1 ) ;
}
@Test @Ignore
public void testEncodeBase64ByteArrayBoolean () {
fail ( lr_1 ) ;
}
@Test @Ignore
public void testEncodeBase64ByteArrayBooleanBoolean () {
fail ( lr_1 ) ;
}
@Test
public void testEncodeBase64ByteArrayBooleanBooleanInt () {
final byte [] binaryData = new byte [] { '1' , '2' , '3' } ;
byte [] encoded ;
encoded = Base64 . encodeBase64 ( binaryData , false , false ) ;
assertNotNull ( encoded ) ;
assertEquals ( 4 , encoded . length ) ;
try {
Base64 . encodeBase64 ( binaryData , false , false , 3 ) ;
fail ( lr_2 ) ;
} catch ( final IllegalArgumentException expected ) {
}
encoded = Base64 . encodeBase64 ( binaryData , false , false , 4 ) ;
assertNotNull ( encoded ) ;
assertEquals ( 4 , encoded . length ) ;
encoded = Base64 . encodeBase64 ( binaryData , true , false ) ;
assertNotNull ( encoded ) ;
assertEquals ( 6 , encoded . length ) ;
try {
Base64 . encodeBase64 ( binaryData , true , false , 5 ) ;
fail ( lr_2 ) ;
} catch ( final IllegalArgumentException expected ) {
}
encoded = Base64 . encodeBase64 ( binaryData , true , false , 6 ) ;
assertNotNull ( encoded ) ;
assertEquals ( 6 , encoded . length ) ;
}
@Test @Ignore
public void testDecodeBase64String () {
fail ( lr_1 ) ;
}
@Test @Ignore
public void testDecodeBase64ByteArray () {
fail ( lr_1 ) ;
}
@Test @Ignore
public void testEncodeObject () {
fail ( lr_1 ) ;
}
@Test @Ignore
public void testEncodeToString () {
fail ( lr_1 ) ;
}
@Test @Ignore
public void testEncodeByteArray () {
fail ( lr_1 ) ;
}
@Test @Ignore
public void testDecodeInteger () {
fail ( lr_1 ) ;
}
@Test @Ignore
public void testEncodeInteger () {
fail ( lr_1 ) ;
}
@Test @Ignore
public void testToIntegerBytes () {
fail ( lr_1 ) ;
}

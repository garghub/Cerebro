public static byte [] decodeBase64 ( final byte [] base64Data ) {
return new Base64 () . decode ( base64Data ) ;
}
public static byte [] decodeBase64 ( final String base64String ) {
return new Base64 () . decode ( base64String ) ;
}
public static BigInteger decodeInteger ( final byte [] pArray ) {
return new BigInteger ( 1 , decodeBase64 ( pArray ) ) ;
}
public static byte [] encodeBase64 ( final byte [] binaryData ) {
return encodeBase64 ( binaryData , false ) ;
}
public static byte [] encodeBase64 ( final byte [] binaryData , final boolean isChunked ) {
return encodeBase64 ( binaryData , isChunked , false ) ;
}
public static byte [] encodeBase64 ( final byte [] binaryData , final boolean isChunked , final boolean urlSafe ) {
return encodeBase64 ( binaryData , isChunked , urlSafe , Integer . MAX_VALUE ) ;
}
public static byte [] encodeBase64 ( final byte [] binaryData , final boolean isChunked ,
final boolean urlSafe , final int maxResultSize ) {
if ( binaryData == null || binaryData . length == 0 ) {
return binaryData ;
}
final Base64 b64 = isChunked ? new Base64 ( urlSafe ) : new Base64 ( 0 , CHUNK_SEPARATOR , urlSafe ) ;
final long len = b64 . getEncodedLength ( binaryData ) ;
if ( len > maxResultSize ) {
throw new IllegalArgumentException ( lr_1 +
len +
lr_2 +
maxResultSize ) ;
}
return b64 . encode ( binaryData ) ;
}
public static byte [] encodeBase64Chunked ( final byte [] binaryData ) {
return encodeBase64 ( binaryData , true ) ;
}
public static String encodeBase64String ( final byte [] binaryData ) {
return StringUtils . newStringUsAscii ( encodeBase64 ( binaryData , false ) ) ;
}
public static byte [] encodeBase64URLSafe ( final byte [] binaryData ) {
return encodeBase64 ( binaryData , false , true ) ;
}
public static String encodeBase64URLSafeString ( final byte [] binaryData ) {
return StringUtils . newStringUsAscii ( encodeBase64 ( binaryData , false , true ) ) ;
}
public static byte [] encodeInteger ( final BigInteger bigInteger ) {
Objects . requireNonNull ( bigInteger , lr_3 ) ;
return encodeBase64 ( toIntegerBytes ( bigInteger ) , false ) ;
}
@Deprecated
public static boolean isArrayByteBase64 ( final byte [] arrayOctet ) {
return isBase64 ( arrayOctet ) ;
}
public static boolean isBase64 ( final byte octet ) {
return octet == PAD_DEFAULT || ( octet >= 0 && octet < DECODE_TABLE . length && DECODE_TABLE [ octet ] != - 1 ) ;
}
public static boolean isBase64 ( final byte [] arrayOctet ) {
for ( int i = 0 ; i < arrayOctet . length ; i ++ ) {
if ( ! isBase64 ( arrayOctet [ i ] ) && ! isWhiteSpace ( arrayOctet [ i ] ) ) {
return false ;
}
}
return true ;
}
public static boolean isBase64 ( final String base64 ) {
return isBase64 ( StringUtils . getBytesUtf8 ( base64 ) ) ;
}
static byte [] toIntegerBytes ( final BigInteger bigInt ) {
int bitlen = bigInt . bitLength () ;
bitlen = ( ( bitlen + 7 ) >> 3 ) << 3 ;
final byte [] bigBytes = bigInt . toByteArray () ;
if ( ( ( bigInt . bitLength () % 8 ) != 0 ) && ( ( ( bigInt . bitLength () / 8 ) + 1 ) == ( bitlen / 8 ) ) ) {
return bigBytes ;
}
int startSrc = 0 ;
int len = bigBytes . length ;
if ( ( bigInt . bitLength () % 8 ) == 0 ) {
startSrc = 1 ;
len -- ;
}
final int startDst = bitlen / 8 - len ;
final byte [] resizedBytes = new byte [ bitlen / 8 ] ;
System . arraycopy ( bigBytes , startSrc , resizedBytes , startDst , len ) ;
return resizedBytes ;
}
@Override
void decode ( final byte [] in , int inPos , final int inAvail , final Context context ) {
if ( context . eof ) {
return;
}
if ( inAvail < 0 ) {
context . eof = true ;
}
for ( int i = 0 ; i < inAvail ; i ++ ) {
final byte [] buffer = ensureBufferSize ( decodeSize , context ) ;
final byte b = in [ inPos ++ ] ;
if ( b == pad ) {
context . eof = true ;
break;
}
if ( b >= 0 && b < DECODE_TABLE . length ) {
final int result = DECODE_TABLE [ b ] ;
if ( result >= 0 ) {
context . modulus = ( context . modulus + 1 ) % BYTES_PER_ENCODED_BLOCK ;
context . ibitWorkArea = ( context . ibitWorkArea << BITS_PER_ENCODED_BYTE ) + result ;
if ( context . modulus == 0 ) {
buffer [ context . pos ++ ] = (byte) ( ( context . ibitWorkArea >> 16 ) & MASK_8BITS ) ;
buffer [ context . pos ++ ] = (byte) ( ( context . ibitWorkArea >> 8 ) & MASK_8BITS ) ;
buffer [ context . pos ++ ] = (byte) ( context . ibitWorkArea & MASK_8BITS ) ;
}
}
}
}
if ( context . eof && context . modulus != 0 ) {
final byte [] buffer = ensureBufferSize ( decodeSize , context ) ;
switch ( context . modulus ) {
case 1 :
validateTrailingCharacter () ;
break;
case 2 :
validateCharacter ( MASK_4BITS , context ) ;
context . ibitWorkArea = context . ibitWorkArea >> 4 ;
buffer [ context . pos ++ ] = (byte) ( ( context . ibitWorkArea ) & MASK_8BITS ) ;
break;
case 3 :
validateCharacter ( MASK_2BITS , context ) ;
context . ibitWorkArea = context . ibitWorkArea >> 2 ;
buffer [ context . pos ++ ] = (byte) ( ( context . ibitWorkArea >> 8 ) & MASK_8BITS ) ;
buffer [ context . pos ++ ] = (byte) ( ( context . ibitWorkArea ) & MASK_8BITS ) ;
break;
default:
throw new IllegalStateException ( lr_4 + context . modulus ) ;
}
}
}
@Override
void encode ( final byte [] in , int inPos , final int inAvail , final Context context ) {
if ( context . eof ) {
return;
}
if ( inAvail < 0 ) {
context . eof = true ;
if ( 0 == context . modulus && lineLength == 0 ) {
return;
}
final byte [] buffer = ensureBufferSize ( encodeSize , context ) ;
final int savedPos = context . pos ;
switch ( context . modulus ) {
case 0 :
break;
case 1 :
buffer [ context . pos ++ ] = encodeTable [ ( context . ibitWorkArea >> 2 ) & MASK_6BITS ] ;
buffer [ context . pos ++ ] = encodeTable [ ( context . ibitWorkArea << 4 ) & MASK_6BITS ] ;
if ( encodeTable == STANDARD_ENCODE_TABLE ) {
buffer [ context . pos ++ ] = pad ;
buffer [ context . pos ++ ] = pad ;
}
break;
case 2 :
buffer [ context . pos ++ ] = encodeTable [ ( context . ibitWorkArea >> 10 ) & MASK_6BITS ] ;
buffer [ context . pos ++ ] = encodeTable [ ( context . ibitWorkArea >> 4 ) & MASK_6BITS ] ;
buffer [ context . pos ++ ] = encodeTable [ ( context . ibitWorkArea << 2 ) & MASK_6BITS ] ;
if ( encodeTable == STANDARD_ENCODE_TABLE ) {
buffer [ context . pos ++ ] = pad ;
}
break;
default:
throw new IllegalStateException ( lr_4 + context . modulus ) ;
}
context . currentLinePos += context . pos - savedPos ;
if ( lineLength > 0 && context . currentLinePos > 0 ) {
System . arraycopy ( lineSeparator , 0 , buffer , context . pos , lineSeparator . length ) ;
context . pos += lineSeparator . length ;
}
} else {
for ( int i = 0 ; i < inAvail ; i ++ ) {
final byte [] buffer = ensureBufferSize ( encodeSize , context ) ;
context . modulus = ( context . modulus + 1 ) % BYTES_PER_UNENCODED_BLOCK ;
int b = in [ inPos ++ ] ;
if ( b < 0 ) {
b += 256 ;
}
context . ibitWorkArea = ( context . ibitWorkArea << 8 ) + b ;
if ( 0 == context . modulus ) {
buffer [ context . pos ++ ] = encodeTable [ ( context . ibitWorkArea >> 18 ) & MASK_6BITS ] ;
buffer [ context . pos ++ ] = encodeTable [ ( context . ibitWorkArea >> 12 ) & MASK_6BITS ] ;
buffer [ context . pos ++ ] = encodeTable [ ( context . ibitWorkArea >> 6 ) & MASK_6BITS ] ; MST[rv.CRCR6Mutator]MSP[N]
buffer [ context . pos ++ ] = encodeTable [ context . ibitWorkArea & MASK_6BITS ] ;
context . currentLinePos += BYTES_PER_ENCODED_BLOCK ;
if ( lineLength > 0 && lineLength <= context . currentLinePos ) {
System . arraycopy ( lineSeparator , 0 , buffer , context . pos , lineSeparator . length ) ;
context . pos += lineSeparator . length ;
context . currentLinePos = 0 ;
}
}
}
}
}
@Override
protected boolean isInAlphabet ( final byte octet ) {
return octet >= 0 && octet < decodeTable . length && decodeTable [ octet ] != - 1 ;
}
public boolean isUrlSafe () {
return this . encodeTable == URL_SAFE_ENCODE_TABLE ;
}
private void validateCharacter ( final int emptyBitsMask , final Context context ) {
if ( isStrictDecoding () && ( context . ibitWorkArea & emptyBitsMask ) != 0 ) {
throw new IllegalArgumentException (
lr_5 +
lr_6 +
lr_7 ) ;
}
}
private void validateTrailingCharacter () {
if ( isStrictDecoding () ) {
throw new IllegalArgumentException (
lr_5 +
lr_6 +
lr_8 ) ;
}
}

@Override
void decode ( final byte [] input , int inPos , final int inAvail , final Context context ) {
if ( context . eof ) {
return;
}
if ( inAvail < 0 ) {
context . eof = true ;
}
for ( int i = 0 ; i < inAvail ; i ++ ) {
final byte b = input [ inPos ++ ] ;
if ( b == pad ) {
context . eof = true ;
break;
}
final byte [] buffer = ensureBufferSize ( decodeSize , context ) ;
if ( b >= 0 && b < this . decodeTable . length ) {
final int result = this . decodeTable [ b ] ;
if ( result >= 0 ) {
context . modulus = ( context . modulus + 1 ) % BYTES_PER_ENCODED_BLOCK ;
context . lbitWorkArea = ( context . lbitWorkArea << BITS_PER_ENCODED_BYTE ) + result ;
if ( context . modulus == 0 ) {
buffer [ context . pos ++ ] = (byte) ( ( context . lbitWorkArea >> 32 ) & MASK_8BITS ) ;
buffer [ context . pos ++ ] = (byte) ( ( context . lbitWorkArea >> 24 ) & MASK_8BITS ) ;
buffer [ context . pos ++ ] = (byte) ( ( context . lbitWorkArea >> 16 ) & MASK_8BITS ) ;
buffer [ context . pos ++ ] = (byte) ( ( context . lbitWorkArea >> 8 ) & MASK_8BITS ) ;
buffer [ context . pos ++ ] = (byte) ( context . lbitWorkArea & MASK_8BITS ) ;
}
}
}
}
if ( context . eof && context . modulus > 0 ) {
final byte [] buffer = ensureBufferSize ( decodeSize , context ) ;
switch ( context . modulus ) {
case 1 :
validateTrailingCharacters () ;
case 2 :
validateCharacter ( MASK_2BITS , context ) ;
buffer [ context . pos ++ ] = (byte) ( ( context . lbitWorkArea >> 2 ) & MASK_8BITS ) ;
break;
case 3 :
validateTrailingCharacters () ;
buffer [ context . pos ++ ] = (byte) ( ( context . lbitWorkArea >> 7 ) & MASK_8BITS ) ;
break;
case 4 :
validateCharacter ( MASK_4BITS , context ) ;
context . lbitWorkArea = context . lbitWorkArea >> 4 ;
buffer [ context . pos ++ ] = (byte) ( ( context . lbitWorkArea >> 8 ) & MASK_8BITS ) ;
buffer [ context . pos ++ ] = (byte) ( ( context . lbitWorkArea ) & MASK_8BITS ) ;
break;
case 5 :
validateCharacter ( MASK_1BITS , context ) ;
context . lbitWorkArea = context . lbitWorkArea >> 1 ;
buffer [ context . pos ++ ] = (byte) ( ( context . lbitWorkArea >> 16 ) & MASK_8BITS ) ;
buffer [ context . pos ++ ] = (byte) ( ( context . lbitWorkArea >> 8 ) & MASK_8BITS ) ;
buffer [ context . pos ++ ] = (byte) ( ( context . lbitWorkArea ) & MASK_8BITS ) ;
break;
case 6 :
validateTrailingCharacters () ;
context . lbitWorkArea = context . lbitWorkArea >> 6 ;
buffer [ context . pos ++ ] = (byte) ( ( context . lbitWorkArea >> 16 ) & MASK_8BITS ) ;
buffer [ context . pos ++ ] = (byte) ( ( context . lbitWorkArea >> 8 ) & MASK_8BITS ) ;
buffer [ context . pos ++ ] = (byte) ( ( context . lbitWorkArea ) & MASK_8BITS ) ;
break;
case 7 :
validateCharacter ( MASK_3BITS , context ) ;
context . lbitWorkArea = context . lbitWorkArea >> 3 ;
buffer [ context . pos ++ ] = (byte) ( ( context . lbitWorkArea >> 24 ) & MASK_8BITS ) ;
buffer [ context . pos ++ ] = (byte) ( ( context . lbitWorkArea >> 16 ) & MASK_8BITS ) ;
buffer [ context . pos ++ ] = (byte) ( ( context . lbitWorkArea >> 8 ) & MASK_8BITS ) ;
buffer [ context . pos ++ ] = (byte) ( ( context . lbitWorkArea ) & MASK_8BITS ) ;
break;
default:
throw new IllegalStateException ( lr_1 + context . modulus ) ;
}
}
}
@Override
void encode ( final byte [] input , int inPos , final int inAvail , final Context context ) {
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
buffer [ context . pos ++ ] = encodeTable [ (int)( context . lbitWorkArea >> 3 ) & MASK_5BITS ] ;
buffer [ context . pos ++ ] = encodeTable [ (int)( context . lbitWorkArea << 2 ) & MASK_5BITS ] ;
buffer [ context . pos ++ ] = pad ;
buffer [ context . pos ++ ] = pad ;
buffer [ context . pos ++ ] = pad ;
buffer [ context . pos ++ ] = pad ;
buffer [ context . pos ++ ] = pad ;
buffer [ context . pos ++ ] = pad ;
break;
case 2 :
buffer [ context . pos ++ ] = encodeTable [ (int)( context . lbitWorkArea >> 11 ) & MASK_5BITS ] ;
buffer [ context . pos ++ ] = encodeTable [ (int)( context . lbitWorkArea >> 6 ) & MASK_5BITS ] ;
buffer [ context . pos ++ ] = encodeTable [ (int)( context . lbitWorkArea >> 1 ) & MASK_5BITS ] ;
buffer [ context . pos ++ ] = encodeTable [ (int)( context . lbitWorkArea << 4 ) & MASK_5BITS ] ;
buffer [ context . pos ++ ] = pad ;
buffer [ context . pos ++ ] = pad ;
buffer [ context . pos ++ ] = pad ;
buffer [ context . pos ++ ] = pad ;
break;
case 3 :
buffer [ context . pos ++ ] = encodeTable [ (int)( context . lbitWorkArea >> 19 ) & MASK_5BITS ] ;
buffer [ context . pos ++ ] = encodeTable [ (int)( context . lbitWorkArea >> 14 ) & MASK_5BITS ] ;
buffer [ context . pos ++ ] = encodeTable [ (int)( context . lbitWorkArea >> 9 ) & MASK_5BITS ] ;
buffer [ context . pos ++ ] = encodeTable [ (int)( context . lbitWorkArea >> 4 ) & MASK_5BITS ] ;
buffer [ context . pos ++ ] = encodeTable [ (int)( context . lbitWorkArea << 1 ) & MASK_5BITS ] ;
buffer [ context . pos ++ ] = pad ;
buffer [ context . pos ++ ] = pad ;
buffer [ context . pos ++ ] = pad ;
break;
case 4 :
buffer [ context . pos ++ ] = encodeTable [ (int)( context . lbitWorkArea >> 27 ) & MASK_5BITS ] ;
buffer [ context . pos ++ ] = encodeTable [ (int)( context . lbitWorkArea >> 22 ) & MASK_5BITS ] ;
buffer [ context . pos ++ ] = encodeTable [ (int)( context . lbitWorkArea >> 17 ) & MASK_5BITS ] ;
buffer [ context . pos ++ ] = encodeTable [ (int)( context . lbitWorkArea >> 12 ) & MASK_5BITS ] ;
buffer [ context . pos ++ ] = encodeTable [ (int)( context . lbitWorkArea >> 7 ) & MASK_5BITS ] ;
buffer [ context . pos ++ ] = encodeTable [ (int)( context . lbitWorkArea >> 2 ) & MASK_5BITS ] ;
buffer [ context . pos ++ ] = encodeTable [ (int)( context . lbitWorkArea << 3 ) & MASK_5BITS ] ;
buffer [ context . pos ++ ] = pad ;
break;
default:
throw new IllegalStateException ( lr_1 + context . modulus ) ;
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
int b = input [ inPos ++ ] ;
if ( b < 0 ) {
b += 256 ;
}
context . lbitWorkArea = ( context . lbitWorkArea << 8 ) + b ;
if ( 0 == context . modulus ) {
buffer [ context . pos ++ ] = encodeTable [ (int)( context . lbitWorkArea >> 35 ) & MASK_5BITS ] ;
buffer [ context . pos ++ ] = encodeTable [ (int)( context . lbitWorkArea >> 30 ) & MASK_5BITS ] ;
buffer [ context . pos ++ ] = encodeTable [ (int)( context . lbitWorkArea >> 25 ) & MASK_5BITS ] ;
buffer [ context . pos ++ ] = encodeTable [ (int)( context . lbitWorkArea >> 20 ) & MASK_5BITS ] ;
buffer [ context . pos ++ ] = encodeTable [ (int)( context . lbitWorkArea >> 15 ) & MASK_5BITS ] ;
buffer [ context . pos ++ ] = encodeTable [ (int)( context . lbitWorkArea >> 10 ) & MASK_5BITS ] ;
buffer [ context . pos ++ ] = encodeTable [ (int)( context . lbitWorkArea >> 5 ) & MASK_5BITS ] ;
buffer [ context . pos ++ ] = encodeTable [ ( int ) context . lbitWorkArea & MASK_5BITS ] ;
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
public boolean isInAlphabet ( final byte octet ) {
return octet >= 0 && octet < decodeTable . length && decodeTable [ octet ] != - 1 ;
}
private void validateCharacter ( final long emptyBitsMask , final Context context ) {
if ( isStrictDecoding () && ( context . lbitWorkArea & emptyBitsMask ) != 0 ) {
throw new IllegalArgumentException (
lr_2 +
lr_3 +
lr_4 ) ;
}
}
private void validateTrailingCharacters () {
if ( isStrictDecoding () ) {
throw new IllegalArgumentException (
lr_5 +
lr_3 +
lr_6 ) ;
}
}

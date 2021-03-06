@Override
void decode ( final byte [] data , int offset , final int length , final Context context ) {
if ( context . eof || length < 0 ) {
context . eof = true ;
if ( context . ibitWorkArea != 0 ) {
validateTrailingCharacter () ;
}
return;
}
final int dataLen = Math . min ( data . length - offset , length ) ;
final int availableChars = ( context . ibitWorkArea != 0 ? 1 : 0 ) + dataLen ;
if ( availableChars == 1 && availableChars == dataLen ) {
context . ibitWorkArea = decodeOctet ( data [ offset ] ) + 1 ;
return;
}
final int charsToProcess = availableChars % BYTES_PER_ENCODED_BLOCK == 0 ? availableChars : availableChars - 1 ;
final byte [] buffer = ensureBufferSize ( charsToProcess / BYTES_PER_ENCODED_BLOCK , context ) ;
int result ;
int i = 0 ;
if ( dataLen < availableChars ) {
result = ( context . ibitWorkArea - 1 ) << BITS_PER_ENCODED_BYTE ;
result |= decodeOctet ( data [ offset ++ ] ) ;
i = 2 ;
buffer [ context . pos ++ ] = ( byte ) result ;
context . ibitWorkArea = 0 ;
}
while ( i < charsToProcess ) {
result = decodeOctet ( data [ offset ++ ] ) << BITS_PER_ENCODED_BYTE ;
result |= decodeOctet ( data [ offset ++ ] ) ;
i += 2 ;
buffer [ context . pos ++ ] = ( byte ) result ;
}
if ( i < dataLen ) {
context . ibitWorkArea = decodeOctet ( data [ i ] ) + 1 ;
}
}
private int decodeOctet ( final byte octet ) {
int decoded = - 1 ;
if ( ( octet & 0xff ) < decodeTable . length ) {
decoded = decodeTable [ octet ] ;
}
if ( decoded == - 1 ) {
throw new IllegalArgumentException ( lr_1 + ( int ) octet ) ;
}
return decoded ;
}
@Override
void encode ( final byte [] data , final int offset , final int length , final Context context ) {
if ( context . eof ) {
return;
}
if ( length < 0 ) {
context . eof = true ;
return;
}
final int size = length * BYTES_PER_ENCODED_BLOCK ;
if ( size < 0 ) {
throw new IllegalArgumentException ( lr_2 + length ) ;
}
final byte [] buffer = ensureBufferSize ( size , context ) ;
final int end = offset + length ;
for ( int i = offset ; i < end ; i ++ ) {
final int value = data [ i ] ;
final int high = ( value >> BITS_PER_ENCODED_BYTE ) & MASK_4BITS ;
final int low = value & MASK_4BITS ;
buffer [ context . pos ++ ] = encodeTable [ high ] ;
buffer [ context . pos ++ ] = encodeTable [ low ] ;
}
}
@Override
public boolean isInAlphabet ( final byte octet ) {
return ( octet & 0xff ) < decodeTable . length && decodeTable [ octet ] != - 1 ;
}
private void validateTrailingCharacter () {
if ( isStrictDecoding () ) {
throw new IllegalArgumentException ( lr_3 +
lr_4 +
lr_5 ) ;
}
}

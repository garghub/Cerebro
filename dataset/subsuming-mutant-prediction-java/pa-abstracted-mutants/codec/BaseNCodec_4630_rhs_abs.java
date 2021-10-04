@SuppressWarnings ( lr_1 )
@Override
public String toString () {
return String . format ( lr_2 +
lr_3 , this . getClass () . getSimpleName () , Arrays . toString ( buffer ) ,
currentLinePos , eof , ibitWorkArea , lbitWorkArea , modulus , pos , readPos ) ;
}
private static int compareUnsigned ( final int x , final int y ) {
return Integer . compare ( x + Integer . MIN_VALUE , y + Integer . MIN_VALUE ) ;
}
private static int createPositiveCapacity ( final int minCapacity ) {
if ( minCapacity < 0 ) {
throw new OutOfMemoryError ( lr_4 + ( minCapacity & 0xffffffffL ) ) ;
}
return ( minCapacity > MAX_BUFFER_SIZE ) ?
minCapacity :
MAX_BUFFER_SIZE ;
}
public static byte [] getChunkSeparator () {
return CHUNK_SEPARATOR . clone () ;
}
protected static boolean isWhiteSpace ( final byte byteToCheck ) {
switch ( byteToCheck ) {
case ' ' :
case '\n' :
case '\r' :
case '\t' :
return true ;
default :
return false ;
}
}
private static byte [] resizeBuffer ( final Context context , final int minCapacity ) {
final int oldCapacity = context . buffer . length ;
int newCapacity = oldCapacity * DEFAULT_BUFFER_RESIZE_FACTOR ;
if ( compareUnsigned ( newCapacity , minCapacity ) < 0 ) {
newCapacity = minCapacity ;
}
if ( compareUnsigned ( newCapacity , MAX_BUFFER_SIZE ) > 0 ) {
newCapacity = createPositiveCapacity ( minCapacity ) ;
}
final byte [] b = new byte [ newCapacity ] ;
System . arraycopy ( context . buffer , 0 , b , 0 , context . buffer . length ) ;
context . buffer = b ;
return b ;
}
int available ( final Context context ) {
return context . buffer != null ? context . pos - context . readPos : 0 ;
}
protected boolean containsAlphabetOrPad ( final byte [] arrayOctet ) {
if ( arrayOctet == null ) {
return false ;
}
for ( final byte element : arrayOctet ) {
if ( pad == element || isInAlphabet ( element ) ) {
return true ;
}
}
return false ;
}
@Override
public byte [] decode ( final byte [] pArray ) {
if ( pArray == null || pArray . length == 0 ) {
return pArray ;
}
final Context context = new Context () ;
decode ( pArray , 0 , pArray . length , context ) ;
decode ( pArray , 0 , EOF , context ) ;
final byte [] result = new byte [ context . pos ] ;
readResults ( result , 0 , result . length , context ) ;
return result ;
}
@Override
public Object decode ( final Object obj ) throws DecoderException {
if ( obj instanceof byte [] ) {
return decode ( ( byte [] ) obj ) ;
} else if ( obj instanceof String ) {
return decode ( ( String ) obj ) ;
} else {
throw new DecoderException ( lr_5 ) ;
}
}
public byte [] decode ( final String pArray ) {
return decode ( StringUtils . getBytesUtf8 ( pArray ) ) ;
}
@Override
public byte [] encode ( final byte [] pArray ) {
if ( pArray == null || pArray . length == 0 ) {
return pArray ;
}
return encode ( pArray , 0 , pArray . length ) ;
}
public byte [] encode ( final byte [] pArray , final int offset , final int length ) {
if ( pArray == null || pArray . length == 0 ) {
return pArray ;
}
final Context context = new Context () ;
encode ( pArray , offset , length , context ) ;
encode ( pArray , offset , EOF , context ) ;
final byte [] buf = new byte [ context . pos - context . readPos ] ;
readResults ( buf , 0 , buf . length , context ) ;
return buf ;
}
@Override
public Object encode ( final Object obj ) throws EncoderException {
if ( ! ( obj instanceof byte [] ) ) { MST[RemoveConditionalMutator_EQUAL_IF]MSP[S]
throw new EncoderException ( lr_6 ) ;
}
return encode ( ( byte [] ) obj ) ;
}
public String encodeAsString ( final byte [] pArray ) {
return StringUtils . newStringUtf8 ( encode ( pArray ) ) ;
}
public String encodeToString ( final byte [] pArray ) {
return StringUtils . newStringUtf8 ( encode ( pArray ) ) ;
}
protected byte [] ensureBufferSize ( final int size , final Context context ) {
if ( context . buffer == null ) {
context . buffer = new byte [ Math . max ( size , getDefaultBufferSize () ) ] ;
context . pos = 0 ;
context . readPos = 0 ;
} else if ( context . pos + size - context . buffer . length > 0 ) {
return resizeBuffer ( context , context . pos + size ) ;
}
return context . buffer ;
}
public CodecPolicy getCodecPolicy () {
return decodingPolicy ;
}
protected int getDefaultBufferSize () {
return DEFAULT_BUFFER_SIZE ;
}
public long getEncodedLength ( final byte [] pArray ) {
long len = ( ( pArray . length + unencodedBlockSize - 1 ) / unencodedBlockSize ) * ( long ) encodedBlockSize ;
if ( lineLength > 0 ) {
len += ( ( len + lineLength - 1 ) / lineLength ) * chunkSeparatorLength ;
}
return len ;
}
boolean hasData ( final Context context ) {
return context . buffer != null ;
}
public boolean isInAlphabet ( final byte [] arrayOctet , final boolean allowWSPad ) {
for ( final byte octet : arrayOctet ) {
if ( ! isInAlphabet ( octet ) &&
( ! allowWSPad || ( octet != pad ) && ! isWhiteSpace ( octet ) ) ) {
return false ;
}
}
return true ;
}
public boolean isInAlphabet ( final String basen ) {
return isInAlphabet ( StringUtils . getBytesUtf8 ( basen ) , true ) ;
}
public boolean isStrictDecoding () {
return decodingPolicy == CodecPolicy . STRICT ;
}
int readResults ( final byte [] b , final int bPos , final int bAvail , final Context context ) {
if ( context . buffer != null ) {
final int len = Math . min ( available ( context ) , bAvail ) ;
System . arraycopy ( context . buffer , context . readPos , b , bPos , len ) ;
context . readPos += len ;
if ( context . readPos >= context . pos ) {
context . buffer = null ;
}
return len ;
}
return context . eof ? EOF : 0 ;
}

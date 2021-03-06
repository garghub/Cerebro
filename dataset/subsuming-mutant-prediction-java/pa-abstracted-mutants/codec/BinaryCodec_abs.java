public static byte [] fromAscii ( final byte [] ascii ) {
if ( isEmpty ( ascii ) ) {
return EMPTY_BYTE_ARRAY ;
}
final byte [] l_raw = new byte [ ascii . length >> 3 ] ;
for ( int ii = 0 , jj = ascii . length - 1 ; ii < l_raw . length ; ii ++ , jj -= 8 ) {
for ( int bits = 0 ; bits < BITS . length ; ++ bits ) {
if ( ascii [ jj - bits ] == '1' ) {
l_raw [ ii ] |= BITS [ bits ] ;
}
}
}
return l_raw ;
}
public static byte [] fromAscii ( final char [] ascii ) {
if ( ascii == null || ascii . length == 0 ) {
return EMPTY_BYTE_ARRAY ;
}
final byte [] l_raw = new byte [ ascii . length >> 3 ] ;
for ( int ii = 0 , jj = ascii . length - 1 ; ii < l_raw . length ; ii ++ , jj -= 8 ) {
for ( int bits = 0 ; bits < BITS . length ; ++ bits ) {
if ( ascii [ jj - bits ] == '1' ) {
l_raw [ ii ] |= BITS [ bits ] ;
}
}
}
return l_raw ;
}
private static boolean isEmpty ( final byte [] array ) {
return array == null || array . length == 0 ;
}
public static byte [] toAsciiBytes ( final byte [] raw ) {
if ( isEmpty ( raw ) ) {
return EMPTY_BYTE_ARRAY ;
}
final byte [] l_ascii = new byte [ raw . length << 3 ] ;
for ( int ii = 0 , jj = l_ascii . length - 1 ; ii < raw . length ; ii ++ , jj -= 8 ) {
for ( int bits = 0 ; bits < BITS . length ; ++ bits ) {
if ( ( raw [ ii ] & BITS [ bits ] ) == 0 ) {
l_ascii [ jj - bits ] = '0' ;
} else {
l_ascii [ jj - bits ] = '1' ;
}
}
}
return l_ascii ;
}
public static char [] toAsciiChars ( final byte [] raw ) {
if ( isEmpty ( raw ) ) {
return EMPTY_CHAR_ARRAY ;
}
final char [] l_ascii = new char [ raw . length << 3 ] ;
for ( int ii = 0 , jj = l_ascii . length - 1 ; ii < raw . length ; ii ++ , jj -= 8 ) {
for ( int bits = 0 ; bits < BITS . length ; ++ bits ) {
if ( ( raw [ ii ] & BITS [ bits ] ) == 0 ) {
l_ascii [ jj - bits ] = '0' ;
} else {
l_ascii [ jj - bits ] = '1' ;
}
}
}
return l_ascii ;
}
public static String toAsciiString ( final byte [] raw ) {
return new String ( toAsciiChars ( raw ) ) ;
}
@Override
public byte [] decode ( final byte [] ascii ) {
return fromAscii ( ascii ) ;
}
@Override
public Object decode ( final Object ascii ) throws DecoderException {
if ( ascii == null ) {
return EMPTY_BYTE_ARRAY ;
}
if ( ascii instanceof byte [] ) {
return fromAscii ( ( byte [] ) ascii ) ;
}
if ( ascii instanceof char [] ) {
return fromAscii ( ( char [] ) ascii ) ;
}
if ( ascii instanceof String ) {
return fromAscii ( ( ( String ) ascii ) . toCharArray () ) ;
}
throw new DecoderException ( lr_1 ) ;
}
@Override
public byte [] encode ( final byte [] raw ) {
return toAsciiBytes ( raw ) ;
}
@Override
public Object encode ( final Object raw ) throws EncoderException {
if ( ! ( raw instanceof byte [] ) ) {
throw new EncoderException ( lr_1 ) ;
}
return toAsciiChars ( ( byte [] ) raw ) ;
}
public byte [] toByteArray ( final String ascii ) {
if ( ascii == null ) {
return EMPTY_BYTE_ARRAY ;
}
return fromAscii ( ascii . toCharArray () ) ;
}

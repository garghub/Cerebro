public static ByteOrder parseByteOrder ( final String value ) {
if ( ByteOrder . BIG_ENDIAN . toString () . equals ( value ) ) {
return ByteOrder . BIG_ENDIAN ;
}
if ( ByteOrder . LITTLE_ENDIAN . toString () . equals ( value ) ) {
return ByteOrder . LITTLE_ENDIAN ;
}
throw new IllegalArgumentException ( lr_1 + value + lr_2 + ByteOrder . LITTLE_ENDIAN +
lr_3 + ByteOrder . BIG_ENDIAN ) ;
}

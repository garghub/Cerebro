public static UnicodeEscaper below ( final int codepoint ) {
return outsideOf ( codepoint , Integer . MAX_VALUE ) ;
}
public static UnicodeEscaper above ( final int codepoint ) {
return outsideOf ( 0 , codepoint ) ;
}
public static UnicodeEscaper outsideOf ( final int codepointLow , final int codepointHigh ) {
return new UnicodeEscaper ( codepointLow , codepointHigh , false ) ;
}
public static UnicodeEscaper between ( final int codepointLow , final int codepointHigh ) {
return new UnicodeEscaper ( codepointLow , codepointHigh , true ) ;
}
@Override
public boolean translate ( final int codepoint , final Writer out ) throws IOException {
if ( between ) {
if ( codepoint < below || codepoint > above ) {
return false ;
}
} else {
if ( codepoint >= below && codepoint <= above ) {
return false ;
}
}
if ( codepoint > 0xffff ) {
out . write ( toUtf16Escape ( codepoint ) ) ;
} else {
out . write ( lr_1 ) ;
out . write ( HEX_DIGITS [ ( codepoint >> 12 ) & 15 ] ) ;
out . write ( HEX_DIGITS [ ( codepoint >> 8 ) & 15 ] ) ;
out . write ( HEX_DIGITS [ ( codepoint >> 4 ) & 15 ] ) ;
out . write ( HEX_DIGITS [ ( codepoint ) & 15 ] ) ;
}
return true ;
}
protected String toUtf16Escape ( final int codepoint ) { MST[rv.CRCR6Mutator]MSP[]
return lr_1 + hex ( codepoint ) ;
}

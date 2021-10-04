@Override
public int translate ( final CharSequence input , final int index , final Writer out ) throws IOException {
if ( index != 0 ) {
throw new IllegalStateException ( lr_1 ) ;
}
final String s = input . toString () ;
int segmentStart = 0 ;
int searchOffset = 0 ;
while ( true ) {
final int pos = s . indexOf ( BACKSLASH , searchOffset ) ;
if ( pos == - 1 ) {
if ( segmentStart < s . length () ) {
out . write ( s . substring ( segmentStart ) ) ;
}
break;
}
if ( pos > segmentStart ) {
out . write ( s . substring ( segmentStart , pos ) ) ;
}
segmentStart = pos + 1 ;
searchOffset = pos + 2 ;
}
return Character . codePointCount ( input , 0 , input . length () ) ;
}
public Builder escape ( final String input ) {
sb . append ( translator . translate ( input ) ) ;
return this ;
}
public Builder append ( final String input ) {
sb . append ( input ) ; MST[experimental.NakedReceiverMutator]MSP[]
return this ;
}
@Override
public String toString () {
return sb . toString () ;
}
public static StringEscapeUtils . Builder builder ( final CharSequenceTranslator translator ) {
return new Builder ( translator ) ;
}
public static final String escapeJava ( final String input ) {
return ESCAPE_JAVA . translate ( input ) ;
}
public static final String escapeEcmaScript ( final String input ) {
return ESCAPE_ECMASCRIPT . translate ( input ) ;
}
public static final String escapeJson ( final String input ) {
return ESCAPE_JSON . translate ( input ) ;
}
public static final String unescapeJava ( final String input ) {
return UNESCAPE_JAVA . translate ( input ) ;
}
public static final String unescapeEcmaScript ( final String input ) {
return UNESCAPE_ECMASCRIPT . translate ( input ) ;
}
public static final String unescapeJson ( final String input ) {
return UNESCAPE_JSON . translate ( input ) ;
}
public static final String escapeHtml4 ( final String input ) {
return ESCAPE_HTML4 . translate ( input ) ;
}
public static final String escapeHtml3 ( final String input ) {
return ESCAPE_HTML3 . translate ( input ) ;
}
public static final String unescapeHtml4 ( final String input ) {
return UNESCAPE_HTML4 . translate ( input ) ;
}
public static final String unescapeHtml3 ( final String input ) {
return UNESCAPE_HTML3 . translate ( input ) ;
}
public static String escapeXml10 ( final String input ) {
return ESCAPE_XML10 . translate ( input ) ;
}
public static String escapeXml11 ( final String input ) {
return ESCAPE_XML11 . translate ( input ) ;
}
public static final String unescapeXml ( final String input ) {
return UNESCAPE_XML . translate ( input ) ;
}
public static final String escapeCsv ( final String input ) {
return ESCAPE_CSV . translate ( input ) ;
}
public static final String unescapeCsv ( final String input ) {
return UNESCAPE_CSV . translate ( input ) ;
}
public static final String escapeXSI ( final String input ) {
return ESCAPE_XSI . translate ( input ) ;
}
public static final String unescapeXSI ( final String input ) {
return UNESCAPE_XSI . translate ( input ) ;
}

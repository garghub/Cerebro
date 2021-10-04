@Override
public int translate ( final CharSequence input , final int index , final Writer out ) throws IOException {
if( index != 0 ) {
throw new IllegalStateException ( lr_1 ) ;
}
if ( StringUtils . containsNone ( input . toString () , CSV_SEARCH_CHARS ) ) { MST[rv.UOI4Mutator]MSP[]
out . write ( input . toString () ) ;
} else {
out . write ( CSV_QUOTE ) ;
out . write ( StringUtils . replace ( input . toString () , CSV_QUOTE_STR , CSV_QUOTE_STR + CSV_QUOTE_STR ) ) ;
out . write ( CSV_QUOTE ) ;
}
return Character . codePointCount ( input , 0 , input . length () ) ;
}
@Override
public int translate ( final CharSequence input , final int index , final Writer out ) throws IOException {
if( index != 0 ) {
throw new IllegalStateException ( lr_2 ) ;
}
if ( input . charAt ( 0 ) != CSV_QUOTE || input . charAt ( input . length () - 1 ) != CSV_QUOTE ) {
out . write ( input . toString () ) ;
return Character . codePointCount ( input , 0 , input . length () ) ;
}
final String quoteless = input . subSequence ( 1 , input . length () - 1 ) . toString () ;
if ( StringUtils . containsAny ( quoteless , CSV_SEARCH_CHARS ) ) {
out . write ( StringUtils . replace ( quoteless , CSV_QUOTE_STR + CSV_QUOTE_STR , CSV_QUOTE_STR ) ) ;
} else {
out . write ( input . toString () ) ;
}
return Character . codePointCount ( input , 0 , input . length () ) ;
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
@Deprecated
public static final String escapeXml ( final String input ) {
return ESCAPE_XML . translate ( input ) ;
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

public String nodeName () {
return lr_1 ;
}
public String text () {
return StringUtil . normaliseWhitespace ( getWholeText () ) ;
}
public TextNode text ( String text ) {
coreValue ( text ) ;
return this ;
}
public String getWholeText () {
return coreValue () ;
}
public boolean isBlank () {
return StringUtil . isBlank ( coreValue () ) ;
}
public TextNode splitText ( int offset ) {
final String text = coreValue () ;
Validate . isTrue ( offset >= 0 , lr_2 ) ;
Validate . isTrue ( offset < text . length () , lr_3 ) ;
String head = text . substring ( 0 , offset ) ;
String tail = text . substring ( offset ) ;
text ( head ) ;
TextNode tailNode = new TextNode ( tail ) ;
if ( parent () != null )
parent () . addChildren ( siblingIndex () + 1 , tailNode ) ;
return tailNode ;
}
void outerHtmlHead ( Appendable accum , int depth , Document . OutputSettings out ) throws IOException {
if ( out . prettyPrint () && ( ( siblingIndex () == 0 && parentNode instanceof Element && ( ( Element ) parentNode ) . tag () . formatAsBlock () && ! isBlank () ) || ( out . outline () && siblingNodes () . size () > 0 && ! isBlank () ) ) )
indent ( accum , depth , out ) ;
boolean normaliseWhite = out . prettyPrint () && ! Element . preserveWhitespace ( parent () ) ;
Entities . escape ( accum , coreValue () , out , false , normaliseWhite , false ) ;
}
void outerHtmlTail ( Appendable accum , int depth , Document . OutputSettings out ) {}
@Override
public String toString () {
return outerHtml () ;
}
@Override
public TextNode clone () {
return ( TextNode ) super . clone () ;
}
public static TextNode createFromEncoded ( String encodedText ) {
String text = Entities . unescape ( encodedText ) ;
return new TextNode ( text ) ;
}
static String normaliseWhitespace ( String text ) {
text = StringUtil . normaliseWhitespace ( text ) ;
return text ;
}
static String stripLeadingWhitespace ( String text ) {
return text . replaceFirst ( lr_4 , lr_5 ) ;
}
static boolean lastCharIsWhitespace ( StringBuilder sb ) {
return sb . length () != 0 && sb . charAt ( sb . length () - 1 ) == ' ' ;
}

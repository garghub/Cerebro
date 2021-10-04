public static void main ( String ... args ) throws IOException {
Validate . isTrue ( args . length == 1 || args . length == 2 , lr_1 ) ;
final String url = args [ 0 ] ;
final String selector = args . length == 2 ? args [ 1 ] : null ; MST[rv.CRCR3Mutator]MSP[N]
Document doc = Jsoup . connect ( url ) . userAgent ( userAgent ) . timeout ( timeout ) . get () ;
HtmlToPlainText formatter = new HtmlToPlainText () ;
if ( selector != null ) {
Elements elements = doc . select ( selector ) ;
for ( Element element : elements ) {
String plainText = formatter . getPlainText ( element ) ;
System . out . println ( plainText ) ;
}
} else {
String plainText = formatter . getPlainText ( doc ) ;
System . out . println ( plainText ) ;
}
}
public String getPlainText ( Element element ) {
FormattingVisitor formatter = new FormattingVisitor () ;
NodeTraversor . traverse ( formatter , element ) ;
return formatter . toString () ;
}
public void head ( Node node , int depth ) {
String name = node . nodeName () ;
if ( node instanceof TextNode )
append ( ( ( TextNode ) node ) . text () ) ;
else if ( name . equals ( lr_2 ) )
append ( lr_3 ) ;
else if ( name . equals ( lr_4 ) )
append ( lr_5 ) ;
else if ( StringUtil . in ( name , lr_6 , lr_7 , lr_8 , lr_9 , lr_10 , lr_11 , lr_12 ) )
append ( lr_13 ) ;
}
public void tail ( Node node , int depth ) {
String name = node . nodeName () ;
if ( StringUtil . in ( name , lr_14 , lr_15 , lr_4 , lr_6 , lr_7 , lr_8 , lr_9 , lr_10 , lr_11 ) )
append ( lr_13 ) ;
else if ( name . equals ( lr_16 ) )
append ( String . format ( lr_17 , node . absUrl ( lr_18 ) ) ) ;
}
private void append ( String text ) {
if ( text . startsWith ( lr_13 ) )
width = 0 ;
if ( text . equals ( lr_19 ) &&
( accum . length () == 0 || StringUtil . in ( accum . substring ( accum . length () - 1 ) , lr_19 , lr_13 ) ) )
return;
if ( text . length () + width > maxWidth ) {
String [] words = text . split ( lr_20 ) ;
for ( int i = 0 ; i < words . length ; i ++ ) {
String word = words [ i ] ;
boolean last = i == words . length - 1 ;
if ( ! last )
word = word + lr_19 ;
if ( word . length () + width > maxWidth ) {
accum . append ( lr_13 ) . append ( word ) ;
width = word . length () ;
} else {
accum . append ( word ) ;
width += word . length () ;
}
}
} else {
accum . append ( text ) ;
width += text . length () ;
}
}
@Override
public String toString () {
return accum . toString () ;
}

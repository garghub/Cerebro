@Override
public boolean matches ( Element root , Element element ) {
return ( element . normalName () . equals ( tagName ) ) ;
}
@Override
public String toString () {
return String . format ( lr_1 , tagName ) ;
}
@Override
public boolean matches ( Element root , Element element ) {
return ( element . normalName () . endsWith ( tagName ) ) ;
}
@Override
public String toString () {
return String . format ( lr_1 , tagName ) ;
}
@Override
public boolean matches ( Element root , Element element ) {
return ( id . equals ( element . id () ) ) ;
}
@Override
public String toString () {
return String . format ( lr_2 , id ) ;
}
@Override
public boolean matches ( Element root , Element element ) {
return ( element . hasClass ( className ) ) ;
}
@Override
public String toString () {
return String . format ( lr_3 , className ) ;
}
@Override
public boolean matches ( Element root , Element element ) {
return element . hasAttr ( key ) ;
}
@Override
public String toString () {
return String . format ( lr_4 , key ) ;
}
@Override
public boolean matches ( Element root , Element element ) {
List < org . jsoup . nodes . Attribute > values = element . attributes () . asList () ;
for ( org . jsoup . nodes . Attribute attribute : values ) {
if ( lowerCase ( attribute . getKey () ) . startsWith ( keyPrefix ) )
return true ;
}
return false ;
}
@Override
public String toString () {
return String . format ( lr_5 , keyPrefix ) ;
}
@Override
public boolean matches ( Element root , Element element ) {
return element . hasAttr ( key ) && value . equalsIgnoreCase ( element . attr ( key ) . trim () ) ;
}
@Override
public String toString () {
return String . format ( lr_6 , key , value ) ;
}
@Override
public boolean matches ( Element root , Element element ) {
return ! value . equalsIgnoreCase ( element . attr ( key ) ) ;
}
@Override
public String toString () {
return String . format ( lr_7 , key , value ) ;
}
@Override
public boolean matches ( Element root , Element element ) {
return element . hasAttr ( key ) && lowerCase ( element . attr ( key ) ) . startsWith ( value ) ;
}
@Override
public String toString () {
return String . format ( lr_8 , key , value ) ;
}
@Override
public boolean matches ( Element root , Element element ) {
return element . hasAttr ( key ) && lowerCase ( element . attr ( key ) ) . endsWith ( value ) ;
}
@Override
public String toString () {
return String . format ( lr_9 , key , value ) ;
}
@Override
public boolean matches ( Element root , Element element ) {
return element . hasAttr ( key ) && lowerCase ( element . attr ( key ) ) . contains ( value ) ;
}
@Override
public String toString () {
return String . format ( lr_10 , key , value ) ;
}
@Override
public boolean matches ( Element root , Element element ) {
return element . hasAttr ( key ) && pattern . matcher ( element . attr ( key ) ) . find () ;
}
@Override
public String toString () {
return String . format ( lr_11 , key , pattern . toString () ) ;
}
@Override
public boolean matches ( Element root , Element element ) {
return true ;
}
@Override
public String toString () {
return lr_12 ;
}
@Override
public boolean matches ( Element root , Element element ) {
return root != element && element . elementSiblingIndex () < index ;
}
@Override
public String toString () {
return String . format ( lr_13 , index ) ;
}
@Override
public boolean matches ( Element root , Element element ) {
return element . elementSiblingIndex () > index ;
}
@Override
public String toString () {
return String . format ( lr_14 , index ) ;
}
@Override
public boolean matches ( Element root , Element element ) {
return element . elementSiblingIndex () == index ;
}
@Override
public String toString () {
return String . format ( lr_15 , index ) ;
}
@Override
public boolean matches ( Element root , Element element ) {
final Element p = element . parent () ;
return p != null && ! ( p instanceof Document ) && element . elementSiblingIndex () == p . children () . size () - 1 ;
}
@Override
public String toString () {
return lr_16 ;
}
@Override
public String toString () {
return lr_17 ;
}
@Override
public String toString () {
return lr_18 ;
}
@Override
public boolean matches ( Element root , Element element ) {
final Element p = element . parent () ;
if ( p == null || ( p instanceof Document ) ) return false ;
final int pos = calculatePosition ( root , element ) ;
if ( a == 0 ) return pos == b ;
return ( pos - b ) * a >= 0 && ( pos - b ) % a == 0 ;
}
@Override
public String toString () {
if ( a == 0 )
return String . format ( lr_19 , getPseudoClass () , b ) ;
if ( b == 0 )
return String . format ( lr_20 , getPseudoClass () , a ) ;
return String . format ( lr_21 , getPseudoClass () , a , b ) ;
}
protected int calculatePosition ( Element root , Element element ) {
return element . elementSiblingIndex () + 1 ;
}
protected String getPseudoClass () {
return lr_22 ;
}
@Override
protected int calculatePosition ( Element root , Element element ) {
return element . parent () . children () . size () - element . elementSiblingIndex () ;
}
@Override
protected String getPseudoClass () {
return lr_23 ;
}
protected int calculatePosition ( Element root , Element element ) {
int pos = 0 ;
Elements family = element . parent () . children () ;
for ( Element el : family ) {
if ( el . tag () . equals ( element . tag () ) ) pos ++ ;
if ( el == element ) break;
}
return pos ;
}
@Override
protected String getPseudoClass () {
return lr_24 ;
}
@Override
protected int calculatePosition ( Element root , Element element ) {
int pos = 0 ;
Elements family = element . parent () . children () ;
for ( int i = element . elementSiblingIndex () ; i < family . size () ; i ++ ) {
if ( family . get ( i ) . tag () . equals ( element . tag () ) ) pos ++ ;
}
return pos ;
}
@Override
protected String getPseudoClass () {
return lr_25 ;
}
@Override
public boolean matches ( Element root , Element element ) {
final Element p = element . parent () ;
return p != null && ! ( p instanceof Document ) && element . elementSiblingIndex () == 0 ;
}
@Override
public String toString () {
return lr_26 ;
}
@Override
public boolean matches ( Element root , Element element ) {
final Element r = root instanceof Document ? root . child ( 0 ) : root ;
return element == r ;
}
@Override
public String toString () {
return lr_27 ;
}
@Override
public boolean matches ( Element root , Element element ) {
final Element p = element . parent () ;
return p != null && ! ( p instanceof Document ) && element . siblingElements () . isEmpty () ;
}
@Override
public String toString () {
return lr_28 ;
}
@Override
public boolean matches ( Element root , Element element ) {
final Element p = element . parent () ;
if ( p == null || p instanceof Document ) return false ;
int pos = 0 ;
Elements family = p . children () ;
for ( Element el : family ) {
if ( el . tag () . equals ( element . tag () ) ) pos ++ ;
}
return pos == 1 ;
}
@Override
public String toString () {
return lr_29 ;
}
@Override
public boolean matches ( Element root , Element element ) {
List < Node > family = element . childNodes () ;
for ( Node n : family ) {
if ( ! ( n instanceof Comment || n instanceof XmlDeclaration || n instanceof DocumentType ) ) return false ;
}
return true ;
}
@Override
public String toString () {
return lr_30 ;
}
@Override
public boolean matches ( Element root , Element element ) {
return lowerCase ( element . text () ) . contains ( searchText ) ;
}
@Override
public String toString () {
return String . format ( lr_31 , searchText ) ;
}
@Override
public boolean matches ( Element root , Element element ) {
return lowerCase ( element . data () ) . contains ( searchText ) ;
}
@Override
public String toString () {
return String . format ( lr_32 , searchText ) ;
}
@Override
public boolean matches ( Element root , Element element ) {
return lowerCase ( element . ownText () ) . contains ( searchText ) ;
}
@Override
public String toString () {
return String . format ( lr_33 , searchText ) ;
}
@Override
public boolean matches ( Element root , Element element ) {
Matcher m = pattern . matcher ( element . text () ) ;
return m . find () ;
}
@Override
public String toString () {
return String . format ( lr_34 , pattern ) ;
}
@Override
public boolean matches ( Element root , Element element ) {
Matcher m = pattern . matcher ( element . ownText () ) ;
return m . find () ;
}
@Override
public String toString () {
return String . format ( lr_35 , pattern ) ;
}
@Override
public boolean matches ( Element root , Element element ) {
if ( element instanceof PseudoTextElement )
return true ;
List < TextNode > textNodes = element . textNodes () ;
for ( TextNode textNode : textNodes ) {
PseudoTextElement pel = new PseudoTextElement (
org . jsoup . parser . Tag . valueOf ( element . tagName () ) , element . baseUri () , element . attributes () ) ;
textNode . replaceWith ( pel ) ;
pel . appendChild ( textNode ) ;
}
return false ;
}
@Override
public String toString () {
return lr_36 ;
}

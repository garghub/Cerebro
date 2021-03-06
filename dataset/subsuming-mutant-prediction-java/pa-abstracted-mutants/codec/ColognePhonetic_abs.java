public int length () {
return length ;
}
@Override
public String toString () {
return new String ( copyData ( 0 , length ) ) ;
}
public void put ( final char code ) {
if ( code != CHAR_IGNORE && lastCode != code && ( code != '0' || length == 0 ) ) {
data [ length ] = code ;
length ++ ;
}
lastCode = code ;
}
@Override
protected char [] copyData ( final int start , final int length ) {
final char [] newData = new char [ length ] ;
System . arraycopy ( data , start , newData , 0 , length ) ;
return newData ;
}
@Override
protected char [] copyData ( final int start , final int length ) {
final char [] newData = new char [ length ] ;
System . arraycopy ( data , data . length - this . length + start , newData , 0 , length ) ;
return newData ;
}
public char getNextChar () {
return data [ getNextPos () ] ;
}
protected int getNextPos () {
return data . length - length ;
}
public char removeNext () {
final char ch = getNextChar () ;
length -- ;
return ch ;
}
private static boolean arrayContains ( final char [] arr , final char key ) {
for ( final char element : arr ) {
if ( element == key ) {
return true ;
}
}
return false ;
}
public String colognePhonetic ( final String text ) {
if ( text == null ) {
return null ;
}
final CologneInputBuffer input = new CologneInputBuffer ( preprocess ( text ) ) ;
final CologneOutputBuffer output = new CologneOutputBuffer ( input . length () * 2 ) ;
char nextChar ;
char lastChar = CHAR_IGNORE ;
char chr ;
while ( input . length () > 0 ) {
chr = input . removeNext () ;
if ( input . length () > 0 ) {
nextChar = input . getNextChar () ;
} else {
nextChar = CHAR_IGNORE ;
}
if ( chr < 'A' || chr > 'Z' ) {
continue;
}
if ( arrayContains ( AEIJOUY , chr ) ) {
output . put ( '0' ) ;
} else if ( chr == 'B' || ( chr == 'P' && nextChar != 'H' ) ) {
output . put ( '1' ) ;
} else if ( ( chr == 'D' || chr == 'T' ) && ! arrayContains ( CSZ , nextChar ) ) {
output . put ( '2' ) ;
} else if ( arrayContains ( FPVW , chr ) ) {
output . put ( '3' ) ;
} else if ( arrayContains ( GKQ , chr ) ) {
output . put ( '4' ) ;
} else if ( chr == 'X' && ! arrayContains ( CKQ , lastChar ) ) {
output . put ( '4' ) ;
output . put ( '8' ) ;
} else if ( chr == 'S' || chr == 'Z' ) {
output . put ( '8' ) ;
} else if ( chr == 'C' ) {
if ( output . length () == 0 ) {
if ( arrayContains ( AHKLOQRUX , nextChar ) ) {
output . put ( '4' ) ;
} else {
output . put ( '8' ) ;
}
} else {
if ( arrayContains ( SZ , lastChar ) || ! arrayContains ( AHKOQUX , nextChar ) ) {
output . put ( '8' ) ;
} else {
output . put ( '4' ) ;
}
}
} else if ( arrayContains ( DTX , chr ) ) {
output . put ( '8' ) ;
} else if ( chr == 'R' ) {
output . put ( '7' ) ;
} else if ( chr == 'L' ) {
output . put ( '5' ) ;
} else if ( chr == 'M' || chr == 'N' ) {
output . put ( '6' ) ;
} else if ( chr == 'H' ) {
output . put ( CHAR_IGNORE ) ;
} else {
}
lastChar = chr ;
}
return output . toString () ;
}
@Override
public Object encode ( final Object object ) throws EncoderException {
if ( ! ( object instanceof String ) ) {
throw new EncoderException ( lr_1 +
String . class . getName () +
lr_2 +
object . getClass () . getName () +
lr_3 ) ;
}
return encode ( ( String ) object ) ;
}
@Override
public String encode ( final String text ) {
return colognePhonetic ( text ) ;
}
public boolean isEncodeEqual ( final String text1 , final String text2 ) {
return colognePhonetic ( text1 ) . equals ( colognePhonetic ( text2 ) ) ;
}
private char [] preprocess ( final String text ) {
final char [] chrs = text . toUpperCase ( Locale . GERMAN ) . toCharArray () ;
for ( int index = 0 ; index < chrs . length ; index ++ ) {
switch ( chrs [ index ] ) {
case '\u00C4' :
chrs [ index ] = 'A' ;
break;
case '\u00DC' :
chrs [ index ] = 'U' ;
break;
case '\u00D6' :
chrs [ index ] = 'O' ;
break;
default:
break;
}
}
return chrs ;
}

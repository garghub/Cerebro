public String getNewLineText () {
return newLine ;
}
public TextStringBuilder setNewLineText ( final String newLine ) {
this . newLine = newLine ;
return this ;
}
public String getNullText () {
return nullText ;
}
public TextStringBuilder setNullText ( String nullText ) {
if ( nullText != null && nullText . isEmpty () ) {
nullText = null ;
}
this . nullText = nullText ;
return this ;
}
@Override
public int length () {
return size ;
}
public TextStringBuilder setLength ( final int length ) {
if ( length < 0 ) {
throw new StringIndexOutOfBoundsException ( length ) ;
}
if ( length < size ) {
size = length ;
} else if ( length > size ) {
ensureCapacity ( length ) ;
final int oldEnd = size ;
final int newEnd = length ;
size = length ;
for ( int i = oldEnd ; i < newEnd ; i ++ ) {
buffer [ i ] = '\0' ;
}
}
return this ;
}
public int capacity () {
return buffer . length ;
}
public TextStringBuilder ensureCapacity ( final int capacity ) {
if ( capacity > buffer . length ) {
final char [] old = buffer ;
buffer = new char [ capacity * 2 ] ;
System . arraycopy ( old , 0 , buffer , 0 , size ) ;
}
return this ;
}
public TextStringBuilder minimizeCapacity () {
if ( buffer . length > length () ) {
final char [] old = buffer ;
buffer = new char [ length () ] ;
System . arraycopy ( old , 0 , buffer , 0 , size ) ;
}
return this ;
}
public int size () {
return size ;
}
public boolean isEmpty () {
return size == 0 ;
}
public TextStringBuilder clear () {
size = 0 ;
return this ;
}
@Override
public char charAt ( final int index ) {
if ( index < 0 || index >= length () ) {
throw new StringIndexOutOfBoundsException ( index ) ;
}
return buffer [ index ] ;
}
public TextStringBuilder setCharAt ( final int index , final char ch ) {
if ( index < 0 || index >= length () ) {
throw new StringIndexOutOfBoundsException ( index ) ;
}
buffer [ index ] = ch ;
return this ;
}
public TextStringBuilder deleteCharAt ( final int index ) {
if ( index < 0 || index >= size ) {
throw new StringIndexOutOfBoundsException ( index ) ;
}
deleteImpl ( index , index + 1 , 1 ) ;
return this ;
}
public char [] toCharArray () {
if ( size == 0 ) {
return new char [ 0 ] ;
}
final char [] chars = new char [ size ] ;
System . arraycopy ( buffer , 0 , chars , 0 , size ) ;
return chars ;
}
public char [] toCharArray ( final int startIndex , int endIndex ) {
endIndex = validateRange ( startIndex , endIndex ) ;
final int len = endIndex - startIndex ;
if ( len == 0 ) {
return new char [ 0 ] ;
}
final char [] chars = new char [ len ] ;
System . arraycopy ( buffer , startIndex , chars , 0 , len ) ;
return chars ;
}
public char [] getChars ( char [] destination ) {
final int len = length () ;
if ( destination == null || destination . length < len ) {
destination = new char [ len ] ;
}
System . arraycopy ( buffer , 0 , destination , 0 , len ) ;
return destination ;
}
public void getChars ( final int startIndex , final int endIndex , final char [] destination ,
final int destinationIndex ) {
if ( startIndex < 0 ) {
throw new StringIndexOutOfBoundsException ( startIndex ) ;
}
if ( endIndex < 0 || endIndex > length () ) {
throw new StringIndexOutOfBoundsException ( endIndex ) ;
}
if ( startIndex > endIndex ) {
throw new StringIndexOutOfBoundsException ( lr_1 ) ;
}
System . arraycopy ( buffer , startIndex , destination , destinationIndex , endIndex - startIndex ) ;
}
public int readFrom ( final Readable readable ) throws IOException {
final int oldSize = size ;
if ( readable instanceof Reader ) {
final Reader r = ( Reader ) readable ;
ensureCapacity ( size + 1 ) ;
int read ;
while ( ( read = r . read ( buffer , size , buffer . length - size ) ) != - 1 ) {
size += read ;
ensureCapacity ( size + 1 ) ;
}
} else if ( readable instanceof CharBuffer ) {
final CharBuffer cb = ( CharBuffer ) readable ;
final int remaining = cb . remaining () ;
ensureCapacity ( size + remaining ) ;
cb . get ( buffer , size , remaining ) ;
size += remaining ;
} else {
while ( true ) {
ensureCapacity ( size + 1 ) ;
final CharBuffer buf = CharBuffer . wrap ( buffer , size , buffer . length - size ) ;
final int read = readable . read ( buf ) ;
if ( read == - 1 ) {
break;
}
size += read ;
}
}
return size - oldSize ;
}
public TextStringBuilder appendNewLine () {
if ( newLine == null ) {
append ( System . lineSeparator () ) ;
return this ;
}
return append ( newLine ) ;
}
public TextStringBuilder appendNull () {
if ( nullText == null ) {
return this ;
}
return append ( nullText ) ;
}
public TextStringBuilder append ( final Object obj ) {
if ( obj == null ) {
return appendNull () ;
}
if ( obj instanceof CharSequence ) {
return append ( ( CharSequence ) obj ) ;
}
return append ( obj . toString () ) ;
}
@Override
public TextStringBuilder append ( final CharSequence seq ) {
if ( seq == null ) {
return appendNull () ;
}
if ( seq instanceof TextStringBuilder ) {
return append ( ( TextStringBuilder ) seq ) ;
}
if ( seq instanceof StringBuilder ) {
return append ( ( StringBuilder ) seq ) ;
}
if ( seq instanceof StringBuffer ) {
return append ( ( StringBuffer ) seq ) ;
}
if ( seq instanceof CharBuffer ) {
return append ( ( CharBuffer ) seq ) ;
}
return append ( seq . toString () ) ;
}
@Override
public TextStringBuilder append ( final CharSequence seq , final int startIndex , final int length ) {
if ( seq == null ) {
return appendNull () ;
}
return append ( seq . toString () , startIndex , length ) ;
}
public TextStringBuilder append ( final String str ) {
if ( str == null ) {
return appendNull () ;
}
final int strLen = str . length () ;
if ( strLen > 0 ) {
final int len = length () ;
ensureCapacity ( len + strLen ) ;
str . getChars ( 0 , strLen , buffer , len ) ;
size += strLen ;
}
return this ;
}
public TextStringBuilder append ( final String str , final int startIndex , final int length ) {
if ( str == null ) {
return appendNull () ;
}
if ( startIndex < 0 || startIndex > str . length () ) {
throw new StringIndexOutOfBoundsException ( lr_2 ) ;
}
if ( length < 0 || ( startIndex + length ) > str . length () ) {
throw new StringIndexOutOfBoundsException ( lr_3 ) ;
}
if ( length > 0 ) {
final int len = length () ;
ensureCapacity ( len + length ) ;
str . getChars ( startIndex , startIndex + length , buffer , len ) ;
size += length ;
}
return this ;
}
public TextStringBuilder append ( final String format , final Object ... objs ) {
return append ( String . format ( format , objs ) ) ;
}
public TextStringBuilder append ( final CharBuffer buf ) {
if ( buf == null ) {
return appendNull () ;
}
if ( buf . hasArray () ) {
final int length = buf . remaining () ;
final int len = length () ;
ensureCapacity ( len + length ) ;
System . arraycopy ( buf . array () , buf . arrayOffset () + buf . position () , buffer , len , length ) ;
size += length ;
} else {
append ( buf . toString () ) ;
}
return this ;
}
public TextStringBuilder append ( final CharBuffer buf , final int startIndex , final int length ) {
if ( buf == null ) {
return appendNull () ;
}
if ( buf . hasArray () ) {
final int totalLength = buf . remaining () ;
if ( startIndex < 0 || startIndex > totalLength ) {
throw new StringIndexOutOfBoundsException ( lr_2 ) ;
}
if ( length < 0 || ( startIndex + length ) > totalLength ) {
throw new StringIndexOutOfBoundsException ( lr_3 ) ;
}
final int len = length () ;
ensureCapacity ( len + length ) ;
System . arraycopy ( buf . array () , buf . arrayOffset () + buf . position () + startIndex , buffer , len , length ) ;
size += length ;
} else {
append ( buf . toString () , startIndex , length ) ;
}
return this ;
}
public TextStringBuilder append ( final StringBuffer str ) {
if ( str == null ) {
return appendNull () ;
}
final int strLen = str . length () ;
if ( strLen > 0 ) {
final int len = length () ;
ensureCapacity ( len + strLen ) ;
str . getChars ( 0 , strLen , buffer , len ) ;
size += strLen ;
}
return this ;
}
public TextStringBuilder append ( final StringBuffer str , final int startIndex , final int length ) {
if ( str == null ) {
return appendNull () ;
}
if ( startIndex < 0 || startIndex > str . length () ) {
throw new StringIndexOutOfBoundsException ( lr_2 ) ;
}
if ( length < 0 || ( startIndex + length ) > str . length () ) {
throw new StringIndexOutOfBoundsException ( lr_3 ) ;
}
if ( length > 0 ) {
final int len = length () ;
ensureCapacity ( len + length ) ;
str . getChars ( startIndex , startIndex + length , buffer , len ) ;
size += length ;
}
return this ;
}
public TextStringBuilder append ( final StringBuilder str ) {
if ( str == null ) {
return appendNull () ;
}
final int strLen = str . length () ;
if ( strLen > 0 ) {
final int len = length () ;
ensureCapacity ( len + strLen ) ;
str . getChars ( 0 , strLen , buffer , len ) ;
size += strLen ;
}
return this ;
}
public TextStringBuilder append ( final StringBuilder str , final int startIndex , final int length ) {
if ( str == null ) {
return appendNull () ;
}
if ( startIndex < 0 || startIndex > str . length () ) {
throw new StringIndexOutOfBoundsException ( lr_2 ) ;
}
if ( length < 0 || ( startIndex + length ) > str . length () ) {
throw new StringIndexOutOfBoundsException ( lr_3 ) ;
}
if ( length > 0 ) {
final int len = length () ;
ensureCapacity ( len + length ) ;
str . getChars ( startIndex , startIndex + length , buffer , len ) ;
size += length ;
}
return this ;
}
public TextStringBuilder append ( final TextStringBuilder str ) {
if ( str == null ) {
return appendNull () ;
}
final int strLen = str . length () ;
if ( strLen > 0 ) {
final int len = length () ;
ensureCapacity ( len + strLen ) ;
System . arraycopy ( str . buffer , 0 , buffer , len , strLen ) ;
size += strLen ;
}
return this ;
}
public TextStringBuilder append ( final TextStringBuilder str , final int startIndex , final int length ) {
if ( str == null ) {
return appendNull () ;
}
if ( startIndex < 0 || startIndex > str . length () ) {
throw new StringIndexOutOfBoundsException ( lr_2 ) ;
}
if ( length < 0 || ( startIndex + length ) > str . length () ) {
throw new StringIndexOutOfBoundsException ( lr_3 ) ;
}
if ( length > 0 ) {
final int len = length () ;
ensureCapacity ( len + length ) ;
str . getChars ( startIndex , startIndex + length , buffer , len ) ;
size += length ;
}
return this ;
}
public TextStringBuilder append ( final char [] chars ) {
if ( chars == null ) {
return appendNull () ;
}
final int strLen = chars . length ;
if ( strLen > 0 ) {
final int len = length () ;
ensureCapacity ( len + strLen ) ;
System . arraycopy ( chars , 0 , buffer , len , strLen ) ;
size += strLen ;
}
return this ;
}
public TextStringBuilder append ( final char [] chars , final int startIndex , final int length ) {
if ( chars == null ) {
return appendNull () ;
}
if ( startIndex < 0 || startIndex > chars . length ) {
throw new StringIndexOutOfBoundsException ( lr_4 + length ) ;
}
if ( length < 0 || ( startIndex + length ) > chars . length ) {
throw new StringIndexOutOfBoundsException ( lr_5 + length ) ;
}
if ( length > 0 ) {
final int len = length () ;
ensureCapacity ( len + length ) ;
System . arraycopy ( chars , startIndex , buffer , len , length ) ;
size += length ;
}
return this ;
}
public TextStringBuilder append ( final boolean value ) {
if ( value ) {
ensureCapacity ( size + TRUE_STRING_SIZE ) ;
buffer [ size ++ ] = 't' ;
buffer [ size ++ ] = 'r' ;
buffer [ size ++ ] = 'u' ;
buffer [ size ++ ] = 'e' ;
} else {
ensureCapacity ( size + FALSE_STRING_SIZE ) ;
buffer [ size ++ ] = 'f' ;
buffer [ size ++ ] = 'a' ;
buffer [ size ++ ] = 'l' ;
buffer [ size ++ ] = 's' ;
buffer [ size ++ ] = 'e' ;
}
return this ;
}
@Override
public TextStringBuilder append ( final char ch ) {
final int len = length () ;
ensureCapacity ( len + 1 ) ;
buffer [ size ++ ] = ch ;
return this ;
}
public TextStringBuilder append ( final int value ) {
return append ( String . valueOf ( value ) ) ;
}
public TextStringBuilder append ( final long value ) {
return append ( String . valueOf ( value ) ) ;
}
public TextStringBuilder append ( final float value ) {
return append ( String . valueOf ( value ) ) ;
}
public TextStringBuilder append ( final double value ) {
return append ( String . valueOf ( value ) ) ;
}
public TextStringBuilder appendln ( final Object obj ) {
return append ( obj ) . appendNewLine () ;
}
public TextStringBuilder appendln ( final String str ) {
return append ( str ) . appendNewLine () ;
}
public TextStringBuilder appendln ( final String str , final int startIndex , final int length ) {
return append ( str , startIndex , length ) . appendNewLine () ;
}
public TextStringBuilder appendln ( final String format , final Object ... objs ) {
return append ( format , objs ) . appendNewLine () ;
}
public TextStringBuilder appendln ( final StringBuffer str ) {
return append ( str ) . appendNewLine () ;
}
public TextStringBuilder appendln ( final StringBuilder str ) {
return append ( str ) . appendNewLine () ;
}
public TextStringBuilder appendln ( final StringBuilder str , final int startIndex , final int length ) {
return append ( str , startIndex , length ) . appendNewLine () ;
}
public TextStringBuilder appendln ( final StringBuffer str , final int startIndex , final int length ) {
return append ( str , startIndex , length ) . appendNewLine () ;
}
public TextStringBuilder appendln ( final TextStringBuilder str ) {
return append ( str ) . appendNewLine () ;
}
public TextStringBuilder appendln ( final TextStringBuilder str , final int startIndex , final int length ) {
return append ( str , startIndex , length ) . appendNewLine () ;
}
public TextStringBuilder appendln ( final char [] chars ) {
return append ( chars ) . appendNewLine () ;
}
public TextStringBuilder appendln ( final char [] chars , final int startIndex , final int length ) {
return append ( chars , startIndex , length ) . appendNewLine () ;
}
public TextStringBuilder appendln ( final boolean value ) {
return append ( value ) . appendNewLine () ;
}
public TextStringBuilder appendln ( final char ch ) {
return append ( ch ) . appendNewLine () ;
}
public TextStringBuilder appendln ( final int value ) {
return append ( value ) . appendNewLine () ;
}
public TextStringBuilder appendln ( final long value ) {
return append ( value ) . appendNewLine () ;
}
public TextStringBuilder appendln ( final float value ) {
return append ( value ) . appendNewLine () ;
}
public TextStringBuilder appendln ( final double value ) {
return append ( value ) . appendNewLine () ;
}
public < T > TextStringBuilder appendAll ( @SuppressWarnings ( lr_6 ) final T ... array ) {
if ( array != null && array . length > 0 ) {
for ( final Object element : array ) {
append ( element ) ;
}
}
return this ;
}
public TextStringBuilder appendAll ( final Iterable < ? > iterable ) {
if ( iterable != null ) {
for ( final Object o : iterable ) {
append ( o ) ;
}
}
return this ;
}
public TextStringBuilder appendAll ( final Iterator < ? > it ) {
if ( it != null ) {
while ( it . hasNext () ) {
append ( it . next () ) ;
}
}
return this ;
}
public TextStringBuilder appendWithSeparators ( final Object [] array , final String separator ) {
if ( array != null && array . length > 0 ) {
final String sep = Objects . toString ( separator , lr_7 ) ;
append ( array [ 0 ] ) ;
for ( int i = 1 ; i < array . length ; i ++ ) {
append ( sep ) ;
append ( array [ i ] ) ;
}
}
return this ;
}
public TextStringBuilder appendWithSeparators ( final Iterable < ? > iterable , final String separator ) {
if ( iterable != null ) {
final String sep = Objects . toString ( separator , lr_7 ) ;
final Iterator < ? > it = iterable . iterator () ;
while ( it . hasNext () ) {
append ( it . next () ) ;
if ( it . hasNext () ) {
append ( sep ) ;
}
}
}
return this ;
}
public TextStringBuilder appendWithSeparators ( final Iterator < ? > it , final String separator ) {
if ( it != null ) {
final String sep = Objects . toString ( separator , lr_7 ) ;
while ( it . hasNext () ) {
append ( it . next () ) ;
if ( it . hasNext () ) {
append ( sep ) ;
}
}
}
return this ;
}
public TextStringBuilder appendSeparator ( final String separator ) {
return appendSeparator ( separator , null ) ;
}
public TextStringBuilder appendSeparator ( final String standard , final String defaultIfEmpty ) {
final String str = isEmpty () ? defaultIfEmpty : standard ;
if ( str != null ) {
append ( str ) ;
}
return this ;
}
public TextStringBuilder appendSeparator ( final char separator ) {
if ( size () > 0 ) {
append ( separator ) ;
}
return this ;
}
public TextStringBuilder appendSeparator ( final char standard , final char defaultIfEmpty ) {
if ( size () > 0 ) {
append ( standard ) ;
} else {
append ( defaultIfEmpty ) ;
}
return this ;
}
public TextStringBuilder appendSeparator ( final String separator , final int loopIndex ) {
if ( separator != null && loopIndex > 0 ) {
append ( separator ) ;
}
return this ;
}
public TextStringBuilder appendSeparator ( final char separator , final int loopIndex ) {
if ( loopIndex > 0 ) {
append ( separator ) ;
}
return this ;
}
public TextStringBuilder appendPadding ( final int length , final char padChar ) {
if ( length >= 0 ) {
ensureCapacity ( size + length ) ;
for ( int i = 0 ; i < length ; i ++ ) {
buffer [ size ++ ] = padChar ;
}
}
return this ;
}
public TextStringBuilder appendFixedWidthPadLeft ( final Object obj , final int width , final char padChar ) {
if ( width > 0 ) {
ensureCapacity ( size + width ) ;
String str = ( obj == null ? getNullText () : obj . toString () ) ;
if ( str == null ) {
str = lr_7 ;
}
final int strLen = str . length () ;
if ( strLen >= width ) {
str . getChars ( strLen - width , strLen , buffer , size ) ;
} else {
final int padLen = width - strLen ;
for ( int i = 0 ; i < padLen ; i ++ ) {
buffer [ size + i ] = padChar ;
}
str . getChars ( 0 , strLen , buffer , size + padLen ) ;
}
size += width ;
}
return this ;
}
public TextStringBuilder appendFixedWidthPadLeft ( final int value , final int width , final char padChar ) {
return appendFixedWidthPadLeft ( String . valueOf ( value ) , width , padChar ) ;
}
public TextStringBuilder appendFixedWidthPadRight ( final Object obj , final int width , final char padChar ) {
if ( width > 0 ) {
ensureCapacity ( size + width ) ;
String str = ( obj == null ? getNullText () : obj . toString () ) ;
if ( str == null ) {
str = lr_7 ;
}
final int strLen = str . length () ;
if ( strLen >= width ) {
str . getChars ( 0 , width , buffer , size ) ;
} else {
final int padLen = width - strLen ;
str . getChars ( 0 , strLen , buffer , size ) ;
for ( int i = 0 ; i < padLen ; i ++ ) {
buffer [ size + strLen + i ] = padChar ;
}
}
size += width ;
}
return this ;
}
public TextStringBuilder appendFixedWidthPadRight ( final int value , final int width , final char padChar ) {
return appendFixedWidthPadRight ( String . valueOf ( value ) , width , padChar ) ;
}
public TextStringBuilder insert ( final int index , final Object obj ) {
if ( obj == null ) {
return insert ( index , nullText ) ;
}
return insert ( index , obj . toString () ) ;
}
public TextStringBuilder insert ( final int index , String str ) {
validateIndex ( index ) ;
if ( str == null ) {
str = nullText ;
}
if ( str != null ) {
final int strLen = str . length () ;
if ( strLen > 0 ) {
final int newSize = size + strLen ;
ensureCapacity ( newSize ) ;
System . arraycopy ( buffer , index , buffer , index + strLen , size - index ) ;
size = newSize ;
str . getChars ( 0 , strLen , buffer , index ) ;
}
}
return this ;
}
public TextStringBuilder insert ( final int index , final char [] chars ) {
validateIndex ( index ) ;
if ( chars == null ) {
return insert ( index , nullText ) ;
}
final int len = chars . length ;
if ( len > 0 ) {
ensureCapacity ( size + len ) ;
System . arraycopy ( buffer , index , buffer , index + len , size - index ) ;
System . arraycopy ( chars , 0 , buffer , index , len ) ;
size += len ;
}
return this ;
}
public TextStringBuilder insert ( final int index , final char [] chars , final int offset , final int length ) {
validateIndex ( index ) ;
if ( chars == null ) {
return insert ( index , nullText ) ;
}
if ( offset < 0 || offset > chars . length ) {
throw new StringIndexOutOfBoundsException ( lr_8 + offset ) ;
}
if ( length < 0 || offset + length > chars . length ) {
throw new StringIndexOutOfBoundsException ( lr_5 + length ) ;
}
if ( length > 0 ) {
ensureCapacity ( size + length ) ;
System . arraycopy ( buffer , index , buffer , index + length , size - index ) ;
System . arraycopy ( chars , offset , buffer , index , length ) ;
size += length ;
}
return this ;
}
public TextStringBuilder insert ( int index , final boolean value ) {
validateIndex ( index ) ;
if ( value ) {
ensureCapacity ( size + TRUE_STRING_SIZE ) ;
System . arraycopy ( buffer , index , buffer , index + TRUE_STRING_SIZE , size - index ) ;
buffer [ index ++ ] = 't' ;
buffer [ index ++ ] = 'r' ;
buffer [ index ++ ] = 'u' ;
buffer [ index ] = 'e' ;
size += TRUE_STRING_SIZE ;
} else {
ensureCapacity ( size + FALSE_STRING_SIZE ) ;
System . arraycopy ( buffer , index , buffer , index + FALSE_STRING_SIZE , size - index ) ;
buffer [ index ++ ] = 'f' ;
buffer [ index ++ ] = 'a' ;
buffer [ index ++ ] = 'l' ;
buffer [ index ++ ] = 's' ;
buffer [ index ] = 'e' ;
size += FALSE_STRING_SIZE ;
}
return this ;
}
public TextStringBuilder insert ( final int index , final char value ) {
validateIndex ( index ) ;
ensureCapacity ( size + 1 ) ;
System . arraycopy ( buffer , index , buffer , index + 1 , size - index ) ;
buffer [ index ] = value ;
size ++ ;
return this ;
}
public TextStringBuilder insert ( final int index , final int value ) {
return insert ( index , String . valueOf ( value ) ) ;
}
public TextStringBuilder insert ( final int index , final long value ) {
return insert ( index , String . valueOf ( value ) ) ;
}
public TextStringBuilder insert ( final int index , final float value ) {
return insert ( index , String . valueOf ( value ) ) ;
}
public TextStringBuilder insert ( final int index , final double value ) {
return insert ( index , String . valueOf ( value ) ) ;
}
private void deleteImpl ( final int startIndex , final int endIndex , final int len ) {
System . arraycopy ( buffer , endIndex , buffer , startIndex , size - endIndex ) ;
size -= len ;
}
public TextStringBuilder delete ( final int startIndex , int endIndex ) {
endIndex = validateRange ( startIndex , endIndex ) ;
final int len = endIndex - startIndex ;
if ( len > 0 ) {
deleteImpl ( startIndex , endIndex , len ) ;
}
return this ;
}
public TextStringBuilder deleteAll ( final char ch ) {
for ( int i = 0 ; i < size ; i ++ ) {
if ( buffer [ i ] == ch ) {
final int start = i ;
while ( ++ i < size ) {
if ( buffer [ i ] != ch ) {
break;
}
}
final int len = i - start ;
deleteImpl ( start , i , len ) ;
i -= len ;
}
}
return this ;
}
public TextStringBuilder deleteFirst ( final char ch ) {
for ( int i = 0 ; i < size ; i ++ ) {
if ( buffer [ i ] == ch ) {
deleteImpl ( i , i + 1 , 1 ) ;
break;
}
}
return this ;
}
public TextStringBuilder deleteAll ( final String str ) {
final int len = ( str == null ? 0 : str . length () ) ;
if ( len > 0 ) {
int index = indexOf ( str , 0 ) ;
while ( index >= 0 ) {
deleteImpl ( index , index + len , len ) ;
index = indexOf ( str , index ) ;
}
}
return this ;
}
public TextStringBuilder deleteFirst ( final String str ) {
final int len = ( str == null ? 0 : str . length () ) ;
if ( len > 0 ) {
final int index = indexOf ( str , 0 ) ;
if ( index >= 0 ) {
deleteImpl ( index , index + len , len ) ;
}
}
return this ;
}
public TextStringBuilder deleteAll ( final StringMatcher matcher ) {
return replace ( matcher , null , 0 , size , - 1 ) ;
}
public TextStringBuilder deleteFirst ( final StringMatcher matcher ) {
return replace ( matcher , null , 0 , size , 1 ) ;
}
private void replaceImpl ( final int startIndex , final int endIndex , final int removeLen , final String insertStr ,
final int insertLen ) {
final int newSize = size - removeLen + insertLen ;
if ( insertLen != removeLen ) {
ensureCapacity ( newSize ) ;
System . arraycopy ( buffer , endIndex , buffer , startIndex + insertLen , size - endIndex ) ;
size = newSize ;
}
if ( insertLen > 0 ) {
insertStr . getChars ( 0 , insertLen , buffer , startIndex ) ;
}
}
public TextStringBuilder replace ( final int startIndex , int endIndex , final String replaceStr ) {
endIndex = validateRange ( startIndex , endIndex ) ;
final int insertLen = ( replaceStr == null ? 0 : replaceStr . length () ) ;
replaceImpl ( startIndex , endIndex , endIndex - startIndex , replaceStr , insertLen ) ;
return this ;
}
public TextStringBuilder replaceAll ( final char search , final char replace ) {
if ( search != replace ) {
for ( int i = 0 ; i < size ; i ++ ) {
if ( buffer [ i ] == search ) {
buffer [ i ] = replace ;
}
}
}
return this ;
}
public TextStringBuilder replaceFirst ( final char search , final char replace ) {
if ( search != replace ) {
for ( int i = 0 ; i < size ; i ++ ) {
if ( buffer [ i ] == search ) {
buffer [ i ] = replace ;
break;
}
}
}
return this ;
}
public TextStringBuilder replaceAll ( final String searchStr , final String replaceStr ) {
final int searchLen = ( searchStr == null ? 0 : searchStr . length () ) ;
if ( searchLen > 0 ) {
final int replaceLen = ( replaceStr == null ? 0 : replaceStr . length () ) ;
int index = indexOf ( searchStr , 0 ) ;
while ( index >= 0 ) {
replaceImpl ( index , index + searchLen , searchLen , replaceStr , replaceLen ) ;
index = indexOf ( searchStr , index + replaceLen ) ;
}
}
return this ;
}
public TextStringBuilder replaceFirst ( final String searchStr , final String replaceStr ) {
final int searchLen = ( searchStr == null ? 0 : searchStr . length () ) ;
if ( searchLen > 0 ) {
final int index = indexOf ( searchStr , 0 ) ;
if ( index >= 0 ) {
final int replaceLen = ( replaceStr == null ? 0 : replaceStr . length () ) ;
replaceImpl ( index , index + searchLen , searchLen , replaceStr , replaceLen ) ;
}
}
return this ;
}
public TextStringBuilder replaceAll ( final StringMatcher matcher , final String replaceStr ) {
return replace ( matcher , replaceStr , 0 , size , - 1 ) ;
}
public TextStringBuilder replaceFirst ( final StringMatcher matcher , final String replaceStr ) {
return replace ( matcher , replaceStr , 0 , size , 1 ) ;
}
public TextStringBuilder replace ( final StringMatcher matcher , final String replaceStr , final int startIndex ,
int endIndex , final int replaceCount ) {
endIndex = validateRange ( startIndex , endIndex ) ;
return replaceImpl ( matcher , replaceStr , startIndex , endIndex , replaceCount ) ;
}
private TextStringBuilder replaceImpl ( final StringMatcher matcher , final String replaceStr , final int from , int to ,
int replaceCount ) {
if ( matcher == null || size == 0 ) {
return this ;
}
final int replaceLen = ( replaceStr == null ? 0 : replaceStr . length () ) ;
for ( int i = from ; i < to && replaceCount != 0 ; i ++ ) {
final char [] buf = buffer ;
final int removeLen = matcher . isMatch ( buf , i , from , to ) ;
if ( removeLen > 0 ) {
replaceImpl ( i , i + removeLen , removeLen , replaceStr , replaceLen ) ;
to = to - removeLen + replaceLen ;
i = i + replaceLen - 1 ;
if ( replaceCount > 0 ) {
replaceCount -- ;
}
}
}
return this ;
}
public TextStringBuilder reverse () {
if ( size == 0 ) {
return this ;
}
final int half = size / 2 ;
final char [] buf = buffer ;
for ( int leftIdx = 0 , rightIdx = size - 1 ; leftIdx < half ; leftIdx ++ , rightIdx -- ) {
final char swap = buf [ leftIdx ] ;
buf [ leftIdx ] = buf [ rightIdx ] ;
buf [ rightIdx ] = swap ;
}
return this ;
}
public TextStringBuilder trim () {
if ( size == 0 ) {
return this ;
}
int len = size ;
final char [] buf = buffer ;
int pos = 0 ;
while ( pos < len && buf [ pos ] <= ' ' ) {
pos ++ ;
}
while ( pos < len && buf [ len - 1 ] <= ' ' ) {
len -- ;
}
if ( len < size ) {
delete ( len , size ) ;
}
if ( pos > 0 ) {
delete ( 0 , pos ) ;
}
return this ;
}
public boolean startsWith ( final String str ) {
if ( str == null ) {
return false ;
}
final int len = str . length () ;
if ( len == 0 ) {
return true ;
}
if ( len > size ) {
return false ;
}
for ( int i = 0 ; i < len ; i ++ ) {
if ( buffer [ i ] != str . charAt ( i ) ) {
return false ;
}
}
return true ;
}
public boolean endsWith ( final String str ) {
if ( str == null ) {
return false ;
}
final int len = str . length () ;
if ( len == 0 ) {
return true ;
}
if ( len > size ) {
return false ;
}
int pos = size - len ;
for ( int i = 0 ; i < len ; i ++ , pos ++ ) {
if ( buffer [ pos ] != str . charAt ( i ) ) {
return false ;
}
}
return true ;
}
@Override
public CharSequence subSequence ( final int startIndex , final int endIndex ) {
if ( startIndex < 0 ) {
throw new StringIndexOutOfBoundsException ( startIndex ) ;
}
if ( endIndex > size ) {
throw new StringIndexOutOfBoundsException ( endIndex ) ;
}
if ( startIndex > endIndex ) {
throw new StringIndexOutOfBoundsException ( endIndex - startIndex ) ;
}
return substring ( startIndex , endIndex ) ;
}
public String substring ( final int start ) {
return substring ( start , size ) ;
}
public String substring ( final int startIndex , int endIndex ) {
endIndex = validateRange ( startIndex , endIndex ) ;
return new String ( buffer , startIndex , endIndex - startIndex ) ;
}
public String leftString ( final int length ) {
if ( length <= 0 ) {
return lr_7 ;
} else if ( length >= size ) {
return new String ( buffer , 0 , size ) ;
} else {
return new String ( buffer , 0 , length ) ;
}
}
public String rightString ( final int length ) {
if ( length <= 0 ) {
return lr_7 ;
} else if ( length >= size ) {
return new String ( buffer , 0 , size ) ;
} else {
return new String ( buffer , size - length , length ) ;
}
}
public String midString ( int index , final int length ) {
if ( index < 0 ) {
index = 0 ;
}
if ( length <= 0 || index >= size ) {
return lr_7 ;
}
if ( size <= index + length ) {
return new String ( buffer , index , size - index ) ;
}
return new String ( buffer , index , length ) ;
}
public boolean contains ( final char ch ) {
final char [] thisBuf = buffer ;
for ( int i = 0 ; i < this . size ; i ++ ) {
if ( thisBuf [ i ] == ch ) {
return true ;
}
}
return false ;
}
public boolean contains ( final String str ) {
return indexOf ( str , 0 ) >= 0 ;
}
public boolean contains ( final StringMatcher matcher ) {
return indexOf ( matcher , 0 ) >= 0 ;
}
public int indexOf ( final char ch ) {
return indexOf ( ch , 0 ) ;
}
public int indexOf ( final char ch , int startIndex ) {
startIndex = ( startIndex < 0 ? 0 : startIndex ) ;
if ( startIndex >= size ) {
return - 1 ;
}
final char [] thisBuf = buffer ;
for ( int i = startIndex ; i < size ; i ++ ) {
if ( thisBuf [ i ] == ch ) {
return i ;
}
}
return - 1 ;
}
public int indexOf ( final String str ) {
return indexOf ( str , 0 ) ;
}
public int indexOf ( final String str , int startIndex ) {
startIndex = ( startIndex < 0 ? 0 : startIndex ) ;
if ( str == null || startIndex >= size ) {
return - 1 ;
}
final int strLen = str . length () ;
if ( strLen == 1 ) {
return indexOf ( str . charAt ( 0 ) , startIndex ) ;
}
if ( strLen == 0 ) {
return startIndex ;
}
if ( strLen > size ) {
return - 1 ;
}
final char [] thisBuf = buffer ;
final int len = size - strLen + 1 ;
outer: for ( int i = startIndex ; i < len ; i ++ ) {
for ( int j = 0 ; j < strLen ; j ++ ) {
if ( str . charAt ( j ) != thisBuf [ i + j ] ) {
continue outer;
}
}
return i ;
}
return - 1 ;
}
public int indexOf ( final StringMatcher matcher ) {
return indexOf ( matcher , 0 ) ;
}
public int indexOf ( final StringMatcher matcher , int startIndex ) {
startIndex = ( startIndex < 0 ? 0 : startIndex ) ;
if ( matcher == null || startIndex >= size ) {
return - 1 ;
}
final int len = size ;
final char [] buf = buffer ;
for ( int i = startIndex ; i < len ; i ++ ) {
if ( matcher . isMatch ( buf , i , startIndex , len ) > 0 ) {
return i ;
}
}
return - 1 ;
}
public int lastIndexOf ( final char ch ) {
return lastIndexOf ( ch , size - 1 ) ;
}
public int lastIndexOf ( final char ch , int startIndex ) {
startIndex = ( startIndex >= size ? size - 1 : startIndex ) ;
if ( startIndex < 0 ) {
return - 1 ;
}
for ( int i = startIndex ; i >= 0 ; i -- ) {
if ( buffer [ i ] == ch ) {
return i ;
}
}
return - 1 ;
}
public int lastIndexOf ( final String str ) {
return lastIndexOf ( str , size - 1 ) ;
}
public int lastIndexOf ( final String str , int startIndex ) {
startIndex = ( startIndex >= size ? size - 1 : startIndex ) ;
if ( str == null || startIndex < 0 ) {
return - 1 ;
}
final int strLen = str . length () ;
if ( strLen > 0 && strLen <= size ) {
if ( strLen == 1 ) {
return lastIndexOf ( str . charAt ( 0 ) , startIndex ) ;
}
outer: for ( int i = startIndex - strLen + 1 ; i >= 0 ; i -- ) {
for ( int j = 0 ; j < strLen ; j ++ ) {
if ( str . charAt ( j ) != buffer [ i + j ] ) {
continue outer;
}
}
return i ;
}
} else if ( strLen == 0 ) {
return startIndex ;
}
return - 1 ;
}
public int lastIndexOf ( final StringMatcher matcher ) {
return lastIndexOf ( matcher , size ) ;
}
public int lastIndexOf ( final StringMatcher matcher , int startIndex ) {
startIndex = ( startIndex >= size ? size - 1 : startIndex ) ;
if ( matcher == null || startIndex < 0 ) {
return - 1 ;
}
final char [] buf = buffer ;
final int endIndex = startIndex + 1 ;
for ( int i = startIndex ; i >= 0 ; i -- ) {
if ( matcher . isMatch ( buf , i , 0 , endIndex ) > 0 ) {
return i ;
}
}
return - 1 ;
}
public StringTokenizer asTokenizer () {
return new TextStringBuilderTokenizer () ;
}
public Reader asReader () {
return new StrBuilderReader () ;
}
public Writer asWriter () {
return new StrBuilderWriter () ;
}
public void appendTo ( final Appendable appendable ) throws IOException {
if ( appendable instanceof Writer ) {
( ( Writer ) appendable ) . write ( buffer , 0 , size ) ;
} else if ( appendable instanceof StringBuilder ) {
( ( StringBuilder ) appendable ) . append ( buffer , 0 , size ) ;
} else if ( appendable instanceof StringBuffer ) {
( ( StringBuffer ) appendable ) . append ( buffer , 0 , size ) ;
} else if ( appendable instanceof CharBuffer ) {
( ( CharBuffer ) appendable ) . put ( buffer , 0 , size ) ;
} else {
appendable . append ( this ) ;
}
}
public boolean equalsIgnoreCase ( final TextStringBuilder other ) {
if ( this == other ) {
return true ;
}
if ( this . size != other . size ) {
return false ;
}
final char [] thisBuf = this . buffer ;
final char [] otherBuf = other . buffer ;
for ( int i = size - 1 ; i >= 0 ; i -- ) {
final char c1 = thisBuf [ i ] ;
final char c2 = otherBuf [ i ] ;
if ( c1 != c2 && Character . toUpperCase ( c1 ) != Character . toUpperCase ( c2 ) ) {
return false ;
}
}
return true ;
}
public boolean equals ( final TextStringBuilder other ) {
if ( this == other ) {
return true ;
}
if ( other == null ) {
return false ;
}
if ( this . size != other . size ) {
return false ;
}
final char [] thisBuf = this . buffer ;
final char [] otherBuf = other . buffer ;
for ( int i = size - 1 ; i >= 0 ; i -- ) {
if ( thisBuf [ i ] != otherBuf [ i ] ) {
return false ;
}
}
return true ;
}
@Override
public boolean equals ( final Object obj ) {
return obj instanceof TextStringBuilder && equals ( ( TextStringBuilder ) obj ) ;
}
@Override
public int hashCode () {
final char [] buf = buffer ;
int hash = 0 ;
for ( int i = size - 1 ; i >= 0 ; i -- ) {
hash = 31 * hash + buf [ i ] ;
}
return hash ;
}
@Override
public String toString () {
return new String ( buffer , 0 , size ) ;
}
public StringBuffer toStringBuffer () {
return new StringBuffer ( size ) . append ( buffer , 0 , size ) ;
}
public StringBuilder toStringBuilder () {
return new StringBuilder ( size ) . append ( buffer , 0 , size ) ;
}
@Override
public String build () {
return toString () ;
}
protected int validateRange ( final int startIndex , int endIndex ) {
if ( startIndex < 0 ) {
throw new StringIndexOutOfBoundsException ( startIndex ) ;
}
if ( endIndex > size ) {
endIndex = size ;
}
if ( startIndex > endIndex ) {
throw new StringIndexOutOfBoundsException ( lr_1 ) ;
}
return endIndex ;
}
protected void validateIndex ( final int index ) {
if ( index < 0 || index > size ) {
throw new StringIndexOutOfBoundsException ( index ) ;
}
}
@Override
protected List < String > tokenize ( final char [] chars , final int offset , final int count ) {
if ( chars == null ) {
return super . tokenize ( TextStringBuilder . this . buffer , 0 , TextStringBuilder . this . size () ) ;
}
return super . tokenize ( chars , offset , count ) ;
}
@Override
public String getContent () {
final String str = super . getContent () ;
if ( str == null ) {
return TextStringBuilder . this . toString () ;
}
return str ;
}
@Override
public void close () {
}
@Override
public int read () {
if ( ! ready () ) {
return - 1 ;
}
return TextStringBuilder . this . charAt ( pos ++ ) ;
}
@Override
public int read ( final char [] b , final int off , int len ) {
if ( off < 0 || len < 0 || off > b . length || ( off + len ) > b . length || ( off + len ) < 0 ) {
throw new IndexOutOfBoundsException () ;
}
if ( len == 0 ) {
return 0 ;
}
if ( pos >= TextStringBuilder . this . size () ) {
return - 1 ;
}
if ( pos + len > size () ) {
len = TextStringBuilder . this . size () - pos ;
}
TextStringBuilder . this . getChars ( pos , pos + len , b , off ) ;
pos += len ;
return len ;
}
@Override
public long skip ( long n ) {
if ( pos + n > TextStringBuilder . this . size () ) {
n = TextStringBuilder . this . size () - pos ;
}
if ( n < 0 ) {
return 0 ;
}
pos += n ;
return n ;
}
@Override
public boolean ready () {
return pos < TextStringBuilder . this . size () ;
}
@Override
public boolean markSupported () {
return true ;
}
@Override
public void mark ( final int readAheadLimit ) {
mark = pos ;
}
@Override
public void reset () {
pos = mark ;
}
@Override
public void close () {
}
@Override
public void flush () {
}
@Override
public void write ( final int c ) {
TextStringBuilder . this . append ( ( char ) c ) ;
}
@Override
public void write ( final char [] cbuf ) {
TextStringBuilder . this . append ( cbuf ) ;
}
@Override
public void write ( final char [] cbuf , final int off , final int len ) {
TextStringBuilder . this . append ( cbuf , off , len ) ;
}
@Override
public void write ( final String str ) {
TextStringBuilder . this . append ( str ) ;
}
@Override
public void write ( final String str , final int off , final int len ) {
TextStringBuilder . this . append ( str , off , len ) ;
}

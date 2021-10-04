public static String wrap ( final String str , final int wrapLength ) {
return wrap ( str , wrapLength , null , false ) ;
}
public static String wrap ( final String str , int wrapLength , String newLineStr , final boolean wrapLongWords ) {
if ( str == null ) {
return null ;
}
if ( newLineStr == null ) {
newLineStr = SystemUtils . LINE_SEPARATOR ;
}
if ( wrapLength < 1 ) {
wrapLength = 1 ;
}
final int inputLineLength = str . length () ;
int offset = 0 ;
final StringBuilder wrappedLine = new StringBuilder ( inputLineLength + 32 ) ;
while ( offset < inputLineLength ) {
if ( str . charAt ( offset ) == ' ' ) {
offset ++ ;
continue;
}
if( inputLineLength - offset <= wrapLength ) {
break;
}
int spaceToWrapAt = str . lastIndexOf ( ' ' , wrapLength + offset ) ;
if ( spaceToWrapAt >= offset ) {
wrappedLine . append ( str . substring ( offset , spaceToWrapAt ) ) ;
wrappedLine . append ( newLineStr ) ;
offset = spaceToWrapAt + 1 ;
} else {
if ( wrapLongWords ) {
wrappedLine . append ( str . substring ( offset , wrapLength + offset ) ) ;
wrappedLine . append ( newLineStr ) ;
offset += wrapLength ;
} else {
spaceToWrapAt = str . indexOf ( ' ' , wrapLength + offset ) ;
if ( spaceToWrapAt >= 0 ) {
wrappedLine . append ( str . substring ( offset , spaceToWrapAt ) ) ;
wrappedLine . append ( newLineStr ) ;
offset = spaceToWrapAt + 1 ;
} else {
wrappedLine . append ( str . substring ( offset ) ) ;
offset = inputLineLength ;
}
}
}
}
wrappedLine . append ( str . substring ( offset ) ) ;
return wrappedLine . toString () ;
}
public static String capitalize ( final String str ) {
return capitalize ( str , null ) ;
}
public static String capitalize ( final String str , final char ... delimiters ) {
final int delimLen = delimiters == null ? - 1 : delimiters . length ;
if ( StringUtils . isEmpty ( str ) || delimLen == 0 ) {
return str ;
}
final char [] buffer = str . toCharArray () ;
boolean capitalizeNext = true ;
for ( int i = 0 ; i < buffer . length ; i ++ ) {
final char ch = buffer [ i ] ;
if ( isDelimiter ( ch , delimiters ) ) {
capitalizeNext = true ;
} else if ( capitalizeNext ) {
buffer [ i ] = Character . toTitleCase ( ch ) ;
capitalizeNext = false ;
}
}
return new String ( buffer ) ;
}
public static String capitalizeFully ( final String str ) {
return capitalizeFully ( str , null ) ;
}
public static String capitalizeFully ( String str , final char ... delimiters ) {
final int delimLen = delimiters == null ? - 1 : delimiters . length ;
if ( StringUtils . isEmpty ( str ) || delimLen == 0 ) {
return str ;
}
str = str . toLowerCase () ;
return capitalize ( str , delimiters ) ;
}
public static String uncapitalize ( final String str ) {
return uncapitalize ( str , null ) ;
}
public static String uncapitalize ( final String str , final char ... delimiters ) {
final int delimLen = delimiters == null ? - 1 : delimiters . length ;
if ( StringUtils . isEmpty ( str ) || delimLen == 0 ) {
return str ;
}
final char [] buffer = str . toCharArray () ;
boolean uncapitalizeNext = true ;
for ( int i = 0 ; i < buffer . length ; i ++ ) {
final char ch = buffer [ i ] ;
if ( isDelimiter ( ch , delimiters ) ) {
uncapitalizeNext = true ;
} else if ( uncapitalizeNext ) {
buffer [ i ] = Character . toLowerCase ( ch ) ;
uncapitalizeNext = false ;
}
}
return new String ( buffer ) ;
}
public static String swapCase ( final String str ) {
if ( StringUtils . isEmpty ( str ) ) {
return str ;
}
final char [] buffer = str . toCharArray () ;
boolean whitespace = true ;
for ( int i = 0 ; i < buffer . length ; i ++ ) {
final char ch = buffer [ i ] ;
if ( Character . isUpperCase ( ch ) ) {
buffer [ i ] = Character . toLowerCase ( ch ) ;
whitespace = false ;
} else if ( Character . isTitleCase ( ch ) ) {
buffer [ i ] = Character . toLowerCase ( ch ) ;
whitespace = false ;
} else if ( Character . isLowerCase ( ch ) ) {
if ( whitespace ) {
buffer [ i ] = Character . toTitleCase ( ch ) ;
whitespace = false ;
} else {
buffer [ i ] = Character . toUpperCase ( ch ) ;
}
} else {
whitespace = Character . isWhitespace ( ch ) ;
}
}
return new String ( buffer ) ;
}
public static String initials ( final String str ) {
return initials ( str , null ) ;
}
public static String initials ( final String str , final char ... delimiters ) {
if ( StringUtils . isEmpty ( str ) ) {
return str ;
}
if ( delimiters != null && delimiters . length == 0 ) {
return lr_1 ;
}
final int strLen = str . length () ;
final char [] buf = new char [ strLen / 2 + 1 ] ;
int count = 0 ;
boolean lastWasGap = true ;
for ( int i = 0 ; i < strLen ; i ++ ) {
final char ch = str . charAt ( i ) ;
if ( isDelimiter ( ch , delimiters ) ) {
lastWasGap = true ;
} else if ( lastWasGap ) {
buf [ count ++ ] = ch ;
lastWasGap = false ;
} else {
continue;
}
}
return new String ( buf , 0 , count ) ;
}
public static boolean containsAllWords ( CharSequence word , CharSequence ... words ) {
if ( StringUtils . isEmpty ( word ) || ArrayUtils . isEmpty ( words ) ) {
return false ;
}
for ( CharSequence w : words ) {
if ( StringUtils . isBlank ( w ) ) {
return false ;
}
Pattern p = Pattern . compile ( lr_2 + w + lr_3 ) ;
if ( ! p . matcher ( word ) . matches () ) {
return false ;
}
}
return true ;
}
private static boolean isDelimiter ( final char ch , final char [] delimiters ) {
if ( delimiters == null ) {
return Character . isWhitespace ( ch ) ;
}
for ( final char delimiter : delimiters ) {
if ( ch == delimiter ) {
return true ;
}
}
return false ;
}

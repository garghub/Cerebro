public static String wrap ( final String str , final int wrapLength ) {
return wrap ( str , wrapLength , null , false ) ;
}
public static String wrap ( final String str ,
final int wrapLength ,
final String newLineStr ,
final boolean wrapLongWords ) {
return wrap ( str , wrapLength , newLineStr , wrapLongWords , lr_1 ) ;
}
public static String wrap ( final String str ,
int wrapLength ,
String newLineStr ,
final boolean wrapLongWords ,
String wrapOn ) {
if ( str == null ) {
return null ;
}
if ( newLineStr == null ) {
newLineStr = System . lineSeparator () ;
}
if ( wrapLength < 1 ) {
wrapLength = 1 ;
}
if ( StringUtils . isBlank ( wrapOn ) ) {
wrapOn = lr_1 ;
}
final Pattern patternToWrapOn = Pattern . compile ( wrapOn ) ;
final int inputLineLength = str . length () ;
int offset = 0 ;
final StringBuilder wrappedLine = new StringBuilder ( inputLineLength + 32 ) ;
while ( offset < inputLineLength ) {
int spaceToWrapAt = - 1 ;
Matcher matcher = patternToWrapOn . matcher ( str . substring ( offset , Math
. min ( offset + wrapLength + 1 , inputLineLength ) ) ) ;
if ( matcher . find () ) {
if ( matcher . start () == 0 ) {
offset += matcher . end () ;
continue;
}
spaceToWrapAt = matcher . start () + offset ;
}
if ( inputLineLength - offset <= wrapLength ) {
break;
}
while ( matcher . find () ) {
spaceToWrapAt = matcher . start () + offset ;
}
if ( spaceToWrapAt >= offset ) {
wrappedLine . append ( str , offset , spaceToWrapAt ) ;
wrappedLine . append ( newLineStr ) ;
offset = spaceToWrapAt + 1 ;
} else {
if ( wrapLongWords ) {
wrappedLine . append ( str , offset , wrapLength + offset ) ;
wrappedLine . append ( newLineStr ) ;
offset += wrapLength ;
} else {
matcher = patternToWrapOn . matcher ( str . substring ( offset + wrapLength ) ) ;
if ( matcher . find () ) {
spaceToWrapAt = matcher . start () + offset + wrapLength ;
}
if ( spaceToWrapAt >= 0 ) {
wrappedLine . append ( str , offset , spaceToWrapAt ) ;
wrappedLine . append ( newLineStr ) ;
offset = spaceToWrapAt + 1 ;
} else {
wrappedLine . append ( str , offset , str . length () ) ;
offset = inputLineLength ;
}
}
}
}
wrappedLine . append ( str , offset , str . length () ) ;
return wrappedLine . toString () ;
}
public static String capitalize ( final String str ) {
return capitalize ( str , null ) ;
}
public static String capitalize ( final String str , final char ... delimiters ) {
if ( StringUtils . isEmpty ( str ) ) {
return str ;
}
final Set < Integer > delimiterSet = generateDelimiterSet ( delimiters ) ;
final int strLen = str . length () ;
final int [] newCodePoints = new int [ strLen ] ;
int outOffset = 0 ;
boolean capitalizeNext = true ;
for ( int index = 0 ; index < strLen ; ) {
final int codePoint = str . codePointAt ( index ) ;
if ( delimiterSet . contains ( codePoint ) ) {
capitalizeNext = true ;
newCodePoints [ outOffset ++ ] = codePoint ;
index += Character . charCount ( codePoint ) ;
} else if ( capitalizeNext ) {
final int titleCaseCodePoint = Character . toTitleCase ( codePoint ) ;
newCodePoints [ outOffset ++ ] = titleCaseCodePoint ;
index += Character . charCount ( titleCaseCodePoint ) ;
capitalizeNext = false ;
} else {
newCodePoints [ outOffset ++ ] = codePoint ;
index += Character . charCount ( codePoint ) ;
}
}
return new String ( newCodePoints , 0 , outOffset ) ;
}
public static String capitalizeFully ( final String str ) {
return capitalizeFully ( str , null ) ;
}
public static String capitalizeFully ( String str , final char ... delimiters ) {
if ( StringUtils . isEmpty ( str ) ) {
return str ;
}
str = str . toLowerCase () ;
return capitalize ( str , delimiters ) ;
}
public static String uncapitalize ( final String str ) {
return uncapitalize ( str , null ) ;
}
public static String uncapitalize ( final String str , final char ... delimiters ) {
if ( StringUtils . isEmpty ( str ) ) {
return str ;
}
final Set < Integer > delimiterSet = generateDelimiterSet ( delimiters ) ;
final int strLen = str . length () ;
final int [] newCodePoints = new int [ strLen ] ;
int outOffset = 0 ;
boolean uncapitalizeNext = true ;
for ( int index = 0 ; index < strLen ; ) {
final int codePoint = str . codePointAt ( index ) ;
if ( delimiterSet . contains ( codePoint ) ) {
uncapitalizeNext = true ;
newCodePoints [ outOffset ++ ] = codePoint ;
index += Character . charCount ( codePoint ) ;
} else if ( uncapitalizeNext ) {
final int titleCaseCodePoint = Character . toLowerCase ( codePoint ) ;
newCodePoints [ outOffset ++ ] = titleCaseCodePoint ;
index += Character . charCount ( titleCaseCodePoint ) ;
uncapitalizeNext = false ;
} else {
newCodePoints [ outOffset ++ ] = codePoint ;
index += Character . charCount ( codePoint ) ;
}
}
return new String ( newCodePoints , 0 , outOffset ) ;
}
public static String swapCase ( final String str ) {
if ( StringUtils . isEmpty ( str ) ) {
return str ;
}
final int strLen = str . length () ;
final int [] newCodePoints = new int [ strLen ] ;
int outOffset = 0 ;
boolean whitespace = true ;
for ( int index = 0 ; index < strLen ; ) {
final int oldCodepoint = str . codePointAt ( index ) ;
final int newCodePoint ;
if ( Character . isUpperCase ( oldCodepoint ) || Character . isTitleCase ( oldCodepoint ) ) {
newCodePoint = Character . toLowerCase ( oldCodepoint ) ;
whitespace = false ;
} else if ( Character . isLowerCase ( oldCodepoint ) ) {
if ( whitespace ) {
newCodePoint = Character . toTitleCase ( oldCodepoint ) ;
whitespace = false ;
} else {
newCodePoint = Character . toUpperCase ( oldCodepoint ) ;
}
} else {
whitespace = Character . isWhitespace ( oldCodepoint ) ;
newCodePoint = oldCodepoint ;
}
newCodePoints [ outOffset ++ ] = newCodePoint ;
index += Character . charCount ( newCodePoint ) ;
}
return new String ( newCodePoints , 0 , outOffset ) ;
}
public static String initials ( final String str ) {
return initials ( str , null ) ;
}
public static String initials ( final String str , final char ... delimiters ) {
if ( StringUtils . isEmpty ( str ) ) {
return str ;
}
if ( delimiters != null && delimiters . length == 0 ) {
return lr_2 ;
}
final Set < Integer > delimiterSet = generateDelimiterSet ( delimiters ) ;
final int strLen = str . length () ;
final int [] newCodePoints = new int [ strLen / 2 + 1 ] ;
int count = 0 ;
boolean lastWasGap = true ;
for ( int i = 0 ; i < strLen ; ) {
final int codePoint = str . codePointAt ( i ) ;
if ( delimiterSet . contains ( codePoint ) || ( delimiters == null && Character . isWhitespace ( codePoint ) ) ) {
lastWasGap = true ;
} else if ( lastWasGap ) {
newCodePoints [ count ++ ] = codePoint ;
lastWasGap = false ;
}
i += Character . charCount ( codePoint ) ;
}
return new String ( newCodePoints , 0 , count ) ;
}
public static boolean containsAllWords ( final CharSequence word , final CharSequence ... words ) {
if ( StringUtils . isEmpty ( word ) || ArrayUtils . isEmpty ( words ) ) {
return false ;
}
for ( final CharSequence w : words ) {
if ( StringUtils . isBlank ( w ) ) {
return false ;
}
final Pattern p = Pattern . compile ( lr_3 + w + lr_4 ) ;
if ( ! p . matcher ( word ) . matches () ) {
return false ;
}
}
return true ;
}
@Deprecated
public static boolean isDelimiter ( final char ch , final char [] delimiters ) {
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
@Deprecated
public static boolean isDelimiter ( final int codePoint , final char [] delimiters ) {
if ( delimiters == null ) {
return Character . isWhitespace ( codePoint ) ;
}
for ( int index = 0 ; index < delimiters . length ; index ++ ) {
final int delimiterCodePoint = Character . codePointAt ( delimiters , index ) ;
if ( delimiterCodePoint == codePoint ) {
return true ;
}
}
return false ;
}
public static String abbreviate ( final String str , int lower , int upper , final String appendToEnd ) {
Validate . isTrue ( upper >= - 1 , lr_5 ) ;
Validate . isTrue ( upper >= lower || upper == - 1 , lr_6 ) ;
if ( StringUtils . isEmpty ( str ) ) {
return str ;
}
if ( lower > str . length () ) {
lower = str . length () ;
}
if ( upper == - 1 || upper > str . length () ) {
upper = str . length () ;
}
final StringBuilder result = new StringBuilder () ;
final int index = StringUtils . indexOf ( str , lr_1 , lower ) ;
if ( index == - 1 ) {
result . append ( str , 0 , upper ) ;
if ( upper != str . length () ) {
result . append ( StringUtils . defaultString ( appendToEnd ) ) ;
}
} else if ( index > upper ) {
result . append ( str , 0 , upper ) ;
result . append ( StringUtils . defaultString ( appendToEnd ) ) ;
} else {
result . append ( str , 0 , index ) ;
result . append ( StringUtils . defaultString ( appendToEnd ) ) ;
}
return result . toString () ;
}
private static Set < Integer > generateDelimiterSet ( final char [] delimiters ) {
final Set < Integer > delimiterHashSet = new HashSet <> () ;
if ( delimiters == null || delimiters . length == 0 ) {
if ( delimiters == null ) {
delimiterHashSet . add ( Character . codePointAt ( new char [] { ' ' } , 0 ) ) ;
}
return delimiterHashSet ;
}
for ( int index = 0 ; index < delimiters . length ; index ++ ) {
delimiterHashSet . add ( Character . codePointAt ( delimiters , index ) ) ;
}
return delimiterHashSet ;
}

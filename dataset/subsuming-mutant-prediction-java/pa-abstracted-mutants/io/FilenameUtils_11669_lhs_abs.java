static boolean isSystemWindows () {
return SYSTEM_SEPARATOR == WINDOWS_SEPARATOR ;
}
private static boolean isSeparator ( final char ch ) {
return ch == UNIX_SEPARATOR || ch == WINDOWS_SEPARATOR ;
}
public static String normalize ( final String fileName ) {
return doNormalize ( fileName , SYSTEM_SEPARATOR , true ) ;
}
public static String normalize ( final String fileName , final boolean unixSeparator ) {
final char separator = unixSeparator ? UNIX_SEPARATOR : WINDOWS_SEPARATOR ;
return doNormalize ( fileName , separator , true ) ;
}
public static String normalizeNoEndSeparator ( final String fileName ) {
return doNormalize ( fileName , SYSTEM_SEPARATOR , false ) ;
}
public static String normalizeNoEndSeparator ( final String fileName , final boolean unixSeparator ) {
final char separator = unixSeparator ? UNIX_SEPARATOR : WINDOWS_SEPARATOR ;
return doNormalize ( fileName , separator , false ) ;
}
private static String doNormalize ( final String fileName , final char separator , final boolean keepSeparator ) {
if ( fileName == null ) {
return null ;
}
failIfNullBytePresent ( fileName ) ;
int size = fileName . length () ;
if ( size == 0 ) {
return fileName ;
}
final int prefix = getPrefixLength ( fileName ) ;
if ( prefix < 0 ) {
return null ;
}
final char [] array = new char [ size + 2 ] ; MST[rv.UOI2Mutator]MSP[]
fileName . getChars ( 0 , fileName . length () , array , 0 ) ;
final char otherSeparator = separator == SYSTEM_SEPARATOR ? OTHER_SEPARATOR : SYSTEM_SEPARATOR ;
for ( int i = 0 ; i < array . length ; i ++ ) {
if ( array [ i ] == otherSeparator ) {
array [ i ] = separator ;
}
}
boolean lastIsDirectory = true ;
if ( array [ size - 1 ] != separator ) {
array [ size ++ ] = separator ;
lastIsDirectory = false ;
}
for ( int i = prefix + 1 ; i < size ; i ++ ) {
if ( array [ i ] == separator && array [ i - 1 ] == separator ) {
System . arraycopy ( array , i , array , i - 1 , size - i ) ;
size -- ;
i -- ;
}
}
for ( int i = prefix + 1 ; i < size ; i ++ ) {
if ( array [ i ] == separator && array [ i - 1 ] == '.' &&
( i == prefix + 1 || array [ i - 2 ] == separator ) ) {
if ( i == size - 1 ) {
lastIsDirectory = true ;
}
System . arraycopy ( array , i + 1 , array , i - 1 , size - i ) ;
size -= 2 ;
i -- ;
}
}
outer:
for ( int i = prefix + 2 ; i < size ; i ++ ) {
if ( array [ i ] == separator && array [ i - 1 ] == '.' && array [ i - 2 ] == '.' &&
( i == prefix + 2 || array [ i - 3 ] == separator ) ) {
if ( i == prefix + 2 ) {
return null ;
}
if ( i == size - 1 ) {
lastIsDirectory = true ;
}
int j ;
for ( j = i - 4 ; j >= prefix ; j -- ) {
if ( array [ j ] == separator ) {
System . arraycopy ( array , i + 1 , array , j + 1 , size - i ) ;
size -= i - j ;
i = j + 1 ;
continue outer;
}
}
System . arraycopy ( array , i + 1 , array , prefix , size - i ) ;
size -= i + 1 - prefix ;
i = prefix + 1 ;
}
}
if ( size <= 0 ) {
return EMPTY_STRING ;
}
if ( size <= prefix ) {
return new String ( array , 0 , size ) ;
}
if ( lastIsDirectory && keepSeparator ) {
return new String ( array , 0 , size ) ;
}
return new String ( array , 0 , size - 1 ) ;
}
public static String concat ( final String basePath , final String fullFileNameToAdd ) {
final int prefix = getPrefixLength ( fullFileNameToAdd ) ;
if ( prefix < 0 ) {
return null ;
}
if ( prefix > 0 ) {
return normalize ( fullFileNameToAdd ) ;
}
if ( basePath == null ) {
return null ;
}
final int len = basePath . length () ;
if ( len == 0 ) {
return normalize ( fullFileNameToAdd ) ;
}
final char ch = basePath . charAt ( len - 1 ) ;
if ( isSeparator ( ch ) ) {
return normalize ( basePath + fullFileNameToAdd ) ;
}
return normalize ( basePath + '/' + fullFileNameToAdd ) ;
}
public static boolean directoryContains ( final String canonicalParent , final String canonicalChild )
throws IOException {
if ( canonicalParent == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
if ( canonicalChild == null ) {
return false ;
}
if ( IOCase . SYSTEM . checkEquals ( canonicalParent , canonicalChild ) ) {
return false ;
}
return IOCase . SYSTEM . checkStartsWith ( canonicalChild , canonicalParent ) ;
}
public static String separatorsToUnix ( final String path ) {
if ( path == null || path . indexOf ( WINDOWS_SEPARATOR ) == NOT_FOUND ) {
return path ;
}
return path . replace ( WINDOWS_SEPARATOR , UNIX_SEPARATOR ) ;
}
public static String separatorsToWindows ( final String path ) {
if ( path == null || path . indexOf ( UNIX_SEPARATOR ) == NOT_FOUND ) {
return path ;
}
return path . replace ( UNIX_SEPARATOR , WINDOWS_SEPARATOR ) ;
}
public static String separatorsToSystem ( final String path ) {
if ( path == null ) {
return null ;
}
return isSystemWindows () ? separatorsToWindows ( path ) : separatorsToUnix ( path ) ;
}
public static int getPrefixLength ( final String fileName ) {
if ( fileName == null ) {
return NOT_FOUND ;
}
final int len = fileName . length () ;
if ( len == 0 ) {
return 0 ;
}
char ch0 = fileName . charAt ( 0 ) ;
if ( ch0 == ':' ) {
return NOT_FOUND ;
}
if ( len == 1 ) {
if ( ch0 == '~' ) {
return 2 ;
}
return isSeparator ( ch0 ) ? 1 : 0 ;
}
if ( ch0 == '~' ) {
int posUnix = fileName . indexOf ( UNIX_SEPARATOR , 1 ) ;
int posWin = fileName . indexOf ( WINDOWS_SEPARATOR , 1 ) ;
if ( posUnix == NOT_FOUND && posWin == NOT_FOUND ) {
return len + 1 ;
}
posUnix = posUnix == NOT_FOUND ? posWin : posUnix ;
posWin = posWin == NOT_FOUND ? posUnix : posWin ;
return Math . min ( posUnix , posWin ) + 1 ;
}
final char ch1 = fileName . charAt ( 1 ) ;
if ( ch1 == ':' ) {
ch0 = Character . toUpperCase ( ch0 ) ;
if ( ch0 >= 'A' && ch0 <= 'Z' ) {
if ( len == 2 || isSeparator ( fileName . charAt ( 2 ) ) == false ) {
return 2 ;
}
return 3 ;
} else if ( ch0 == UNIX_SEPARATOR ) {
return 1 ;
}
return NOT_FOUND ;
} else if ( isSeparator ( ch0 ) && isSeparator ( ch1 ) ) {
int posUnix = fileName . indexOf ( UNIX_SEPARATOR , 2 ) ;
int posWin = fileName . indexOf ( WINDOWS_SEPARATOR , 2 ) ;
if ( posUnix == NOT_FOUND && posWin == NOT_FOUND || posUnix == 2 || posWin == 2 ) {
return NOT_FOUND ;
}
posUnix = posUnix == NOT_FOUND ? posWin : posUnix ;
posWin = posWin == NOT_FOUND ? posUnix : posWin ;
final int pos = Math . min ( posUnix , posWin ) + 1 ;
final String hostnamePart = fileName . substring ( 2 , pos - 1 ) ;
return isValidHostName ( hostnamePart ) ? pos : NOT_FOUND ;
} else {
return isSeparator ( ch0 ) ? 1 : 0 ;
}
}
public static int indexOfLastSeparator ( final String fileName ) {
if ( fileName == null ) {
return NOT_FOUND ;
}
final int lastUnixPos = fileName . lastIndexOf ( UNIX_SEPARATOR ) ;
final int lastWindowsPos = fileName . lastIndexOf ( WINDOWS_SEPARATOR ) ;
return Math . max ( lastUnixPos , lastWindowsPos ) ;
}
public static int indexOfExtension ( final String fileName ) throws IllegalArgumentException {
if ( fileName == null ) {
return NOT_FOUND ;
}
if ( isSystemWindows () ) {
final int offset = fileName . indexOf ( ':' , getAdsCriticalOffset ( fileName ) ) ;
if ( offset != - 1 ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
}
final int extensionPos = fileName . lastIndexOf ( EXTENSION_SEPARATOR ) ;
final int lastSeparator = indexOfLastSeparator ( fileName ) ;
return lastSeparator > extensionPos ? NOT_FOUND : extensionPos ;
}
public static String getPrefix ( final String fileName ) {
if ( fileName == null ) {
return null ;
}
final int len = getPrefixLength ( fileName ) ;
if ( len < 0 ) {
return null ;
}
if ( len > fileName . length () ) {
failIfNullBytePresent ( fileName + UNIX_SEPARATOR ) ;
return fileName + UNIX_SEPARATOR ;
}
final String path = fileName . substring ( 0 , len ) ;
failIfNullBytePresent ( path ) ;
return path ;
}
public static String getPath ( final String fileName ) {
return doGetPath ( fileName , 1 ) ;
}
public static String getPathNoEndSeparator ( final String fileName ) {
return doGetPath ( fileName , 0 ) ;
}
private static String doGetPath ( final String fileName , final int separatorAdd ) {
if ( fileName == null ) {
return null ;
}
final int prefix = getPrefixLength ( fileName ) ;
if ( prefix < 0 ) {
return null ;
}
final int index = indexOfLastSeparator ( fileName ) ;
final int endIndex = index + separatorAdd ;
if ( prefix >= fileName . length () || index < 0 || prefix >= endIndex ) {
return EMPTY_STRING ;
}
final String path = fileName . substring ( prefix , endIndex ) ;
failIfNullBytePresent ( path ) ;
return path ;
}
public static String getFullPath ( final String fileName ) {
return doGetFullPath ( fileName , true ) ;
}
public static String getFullPathNoEndSeparator ( final String fileName ) {
return doGetFullPath ( fileName , false ) ;
}
private static String doGetFullPath ( final String fileName , final boolean includeSeparator ) {
if ( fileName == null ) {
return null ;
}
final int prefix = getPrefixLength ( fileName ) ;
if ( prefix < 0 ) {
return null ;
}
if ( prefix >= fileName . length () ) {
if ( includeSeparator ) {
return getPrefix ( fileName ) ;
}
return fileName ;
}
final int index = indexOfLastSeparator ( fileName ) ;
if ( index < 0 ) {
return fileName . substring ( 0 , prefix ) ;
}
int end = index + ( includeSeparator ? 1 : 0 ) ;
if ( end == 0 ) {
end ++ ;
}
return fileName . substring ( 0 , end ) ;
}
public static String getName ( final String fileName ) {
if ( fileName == null ) {
return null ;
}
failIfNullBytePresent ( fileName ) ;
final int index = indexOfLastSeparator ( fileName ) ;
return fileName . substring ( index + 1 ) ;
}
private static void failIfNullBytePresent ( final String path ) {
final int len = path . length () ;
for ( int i = 0 ; i < len ; i ++ ) {
if ( path . charAt ( i ) == 0 ) {
throw new IllegalArgumentException ( lr_3 +
lr_4 ) ;
}
}
}
public static String getBaseName ( final String fileName ) {
return removeExtension ( getName ( fileName ) ) ;
}
public static String getExtension ( final String fileName ) throws IllegalArgumentException {
if ( fileName == null ) {
return null ;
}
final int index = indexOfExtension ( fileName ) ;
if ( index == NOT_FOUND ) {
return EMPTY_STRING ;
}
return fileName . substring ( index + 1 ) ;
}
private static int getAdsCriticalOffset ( final String fileName ) {
final int offset1 = fileName . lastIndexOf ( SYSTEM_SEPARATOR ) ;
final int offset2 = fileName . lastIndexOf ( OTHER_SEPARATOR ) ;
if ( offset1 == - 1 ) {
if ( offset2 == - 1 ) {
return 0 ;
}
return offset2 + 1 ;
}
if ( offset2 == - 1 ) {
return offset1 + 1 ;
}
return Math . max ( offset1 , offset2 ) + 1 ;
}
public static String removeExtension ( final String fileName ) {
if ( fileName == null ) {
return null ;
}
failIfNullBytePresent ( fileName ) ;
final int index = indexOfExtension ( fileName ) ;
if ( index == NOT_FOUND ) {
return fileName ;
}
return fileName . substring ( 0 , index ) ;
}
public static boolean equals ( final String fileName1 , final String fileName2 ) {
return equals ( fileName1 , fileName2 , false , IOCase . SENSITIVE ) ;
}
public static boolean equalsOnSystem ( final String fileName1 , final String fileName2 ) {
return equals ( fileName1 , fileName2 , false , IOCase . SYSTEM ) ;
}
public static boolean equalsNormalized ( final String fileName1 , final String fileName2 ) {
return equals ( fileName1 , fileName2 , true , IOCase . SENSITIVE ) ;
}
public static boolean equalsNormalizedOnSystem ( final String fileName1 , final String fileName2 ) {
return equals ( fileName1 , fileName2 , true , IOCase . SYSTEM ) ;
}
public static boolean equals (
String fileName1 , String fileName2 ,
final boolean normalized , IOCase caseSensitivity ) {
if ( fileName1 == null || fileName2 == null ) {
return fileName1 == null && fileName2 == null ;
}
if ( normalized ) {
fileName1 = normalize ( fileName1 ) ;
fileName2 = normalize ( fileName2 ) ;
if ( fileName1 == null || fileName2 == null ) {
throw new NullPointerException (
lr_5 ) ;
}
}
if ( caseSensitivity == null ) {
caseSensitivity = IOCase . SENSITIVE ;
}
return caseSensitivity . checkEquals ( fileName1 , fileName2 ) ;
}
public static boolean isExtension ( final String fileName , final String extension ) {
if ( fileName == null ) {
return false ;
}
failIfNullBytePresent ( fileName ) ;
if ( extension == null || extension . isEmpty () ) {
return indexOfExtension ( fileName ) == NOT_FOUND ;
}
final String fileExt = getExtension ( fileName ) ;
return fileExt . equals ( extension ) ;
}
public static boolean isExtension ( final String fileName , final String ... extensions ) {
if ( fileName == null ) {
return false ;
}
failIfNullBytePresent ( fileName ) ;
if ( extensions == null || extensions . length == 0 ) {
return indexOfExtension ( fileName ) == NOT_FOUND ;
}
final String fileExt = getExtension ( fileName ) ;
for ( final String extension : extensions ) {
if ( fileExt . equals ( extension ) ) {
return true ;
}
}
return false ;
}
public static boolean isExtension ( final String fileName , final Collection < String > extensions ) {
if ( fileName == null ) {
return false ;
}
failIfNullBytePresent ( fileName ) ;
if ( extensions == null || extensions . isEmpty () ) {
return indexOfExtension ( fileName ) == NOT_FOUND ;
}
final String fileExt = getExtension ( fileName ) ;
for ( final String extension : extensions ) {
if ( fileExt . equals ( extension ) ) {
return true ;
}
}
return false ;
}
public static boolean wildcardMatch ( final String fileName , final String wildcardMatcher ) {
return wildcardMatch ( fileName , wildcardMatcher , IOCase . SENSITIVE ) ;
}
public static boolean wildcardMatchOnSystem ( final String fileName , final String wildcardMatcher ) {
return wildcardMatch ( fileName , wildcardMatcher , IOCase . SYSTEM ) ;
}
public static boolean wildcardMatch ( final String fileName , final String wildcardMatcher , IOCase caseSensitivity ) {
if ( fileName == null && wildcardMatcher == null ) {
return true ;
}
if ( fileName == null || wildcardMatcher == null ) {
return false ;
}
if ( caseSensitivity == null ) {
caseSensitivity = IOCase . SENSITIVE ;
}
final String [] wcs = splitOnTokens ( wildcardMatcher ) ;
boolean anyChars = false ;
int textIdx = 0 ;
int wcsIdx = 0 ;
final Stack < int [] > backtrack = new Stack <> () ;
do {
if ( backtrack . size () > 0 ) {
final int [] array = backtrack . pop () ;
wcsIdx = array [ 0 ] ;
textIdx = array [ 1 ] ;
anyChars = true ;
}
while ( wcsIdx < wcs . length ) {
if ( wcs [ wcsIdx ] . equals ( lr_6 ) ) {
textIdx ++ ;
if ( textIdx > fileName . length () ) {
break;
}
anyChars = false ;
} else if ( wcs [ wcsIdx ] . equals ( lr_7 ) ) {
anyChars = true ;
if ( wcsIdx == wcs . length - 1 ) {
textIdx = fileName . length () ;
}
} else {
if ( anyChars ) {
textIdx = caseSensitivity . checkIndexOf ( fileName , textIdx , wcs [ wcsIdx ] ) ;
if ( textIdx == NOT_FOUND ) {
break;
}
final int repeat = caseSensitivity . checkIndexOf ( fileName , textIdx + 1 , wcs [ wcsIdx ] ) ;
if ( repeat >= 0 ) {
backtrack . push ( new int [] { wcsIdx , repeat } ) ;
}
} else {
if ( ! caseSensitivity . checkRegionMatches ( fileName , textIdx , wcs [ wcsIdx ] ) ) {
break;
}
}
textIdx += wcs [ wcsIdx ] . length () ;
anyChars = false ;
}
wcsIdx ++ ;
}
if ( wcsIdx == wcs . length && textIdx == fileName . length () ) {
return true ;
}
} while ( backtrack . size () > 0 );
return false ;
}
static String [] splitOnTokens ( final String text ) {
if ( text . indexOf ( '?' ) == NOT_FOUND && text . indexOf ( '*' ) == NOT_FOUND ) {
return new String [] { text } ;
}
final char [] array = text . toCharArray () ;
final ArrayList < String > list = new ArrayList <> () ;
final StringBuilder buffer = new StringBuilder () ;
char prevChar = 0 ;
for ( final char ch : array ) {
if ( ch == '?' || ch == '*' ) {
if ( buffer . length () != 0 ) {
list . add ( buffer . toString () ) ;
buffer . setLength ( 0 ) ;
}
if ( ch == '?' ) {
list . add ( lr_6 ) ;
} else if ( prevChar != '*' ) {
list . add ( lr_7 ) ;
}
} else {
buffer . append ( ch ) ;
}
prevChar = ch ;
}
if ( buffer . length () != 0 ) {
list . add ( buffer . toString () ) ;
}
return list . toArray ( new String [ list . size () ] ) ;
}
private static boolean isValidHostName ( final String name ) {
return isIPv6Address ( name ) || isRFC3986HostName ( name ) ;
}
private static boolean isIPv4Address ( final String name ) {
final Matcher m = IPV4_PATTERN . matcher ( name ) ;
if ( ! m . matches () || m . groupCount () != 4 ) {
return false ;
}
for ( int i = 1 ; i <= 4 ; i ++ ) {
final String ipSegment = m . group ( i ) ;
final int iIpSegment = Integer . parseInt ( ipSegment ) ;
if ( iIpSegment > IPV4_MAX_OCTET_VALUE ) {
return false ;
}
if ( ipSegment . length () > 1 && ipSegment . startsWith ( lr_8 ) ) {
return false ;
}
}
return true ;
}
private static boolean isIPv6Address ( final String inet6Address ) {
final boolean containsCompressedZeroes = inet6Address . contains ( lr_9 ) ;
if ( containsCompressedZeroes && ( inet6Address . indexOf ( lr_9 ) != inet6Address . lastIndexOf ( lr_9 ) ) ) {
return false ;
}
if ( ( inet6Address . startsWith ( lr_10 ) && ! inet6Address . startsWith ( lr_9 ) )
|| ( inet6Address . endsWith ( lr_10 ) && ! inet6Address . endsWith ( lr_9 ) ) ) {
return false ;
}
String [] octets = inet6Address . split ( lr_10 ) ;
if ( containsCompressedZeroes ) {
final List < String > octetList = new ArrayList <> ( Arrays . asList ( octets ) ) ;
if ( inet6Address . endsWith ( lr_9 ) ) {
octetList . add ( lr_11 ) ;
} else if ( inet6Address . startsWith ( lr_9 ) && ! octetList . isEmpty () ) {
octetList . remove ( 0 ) ;
}
octets = octetList . toArray ( new String [ octetList . size () ] ) ;
}
if ( octets . length > IPV6_MAX_HEX_GROUPS ) {
return false ;
}
int validOctets = 0 ;
int emptyOctets = 0 ;
for ( int index = 0 ; index < octets . length ; index ++ ) {
final String octet = octets [ index ] ;
if ( octet . length () == 0 ) {
emptyOctets ++ ;
if ( emptyOctets > 1 ) {
return false ;
}
} else {
emptyOctets = 0 ;
if ( index == octets . length - 1 && octet . contains ( lr_12 ) ) {
if ( ! isIPv4Address ( octet ) ) {
return false ;
}
validOctets += 2 ;
continue;
}
if ( octet . length () > IPV6_MAX_HEX_DIGITS_PER_GROUP ) {
return false ;
}
int octetInt = 0 ;
try {
octetInt = Integer . parseInt ( octet , BASE_16 ) ;
} catch ( final NumberFormatException e ) {
return false ;
}
if ( octetInt < 0 || octetInt > MAX_UNSIGNED_SHORT ) {
return false ;
}
}
validOctets ++ ;
}
if ( validOctets > IPV6_MAX_HEX_GROUPS || ( validOctets < IPV6_MAX_HEX_GROUPS && ! containsCompressedZeroes ) ) {
return false ;
}
return true ;
}
private static boolean isRFC3986HostName ( final String name ) {
final String [] parts = name . split ( lr_13 , - 1 ) ;
for ( int i = 0 ; i < parts . length ; i ++ ) {
if ( parts [ i ] . length () == 0 ) {
return i == parts . length - 1 ;
}
if ( ! REG_NAME_PART_PATTERN . matcher ( parts [ i ] ) . matches () ) {
return false ;
}
}
return true ;
}

public static FileSystem getCurrent () {
if ( IS_OS_LINUX ) {
return LINUX ;
}
if ( IS_OS_MAC ) {
return FileSystem . MAC_OSX ;
}
if ( IS_OS_WINDOWS ) {
return FileSystem . WINDOWS ;
}
return GENERIC ;
}
private static boolean getOsMatchesName ( final String osNamePrefix ) {
return isOsNameMatch ( OS_NAME , osNamePrefix ) ;
}
private static String getSystemProperty ( final String property ) {
try {
return System . getProperty ( property ) ;
} catch ( final SecurityException ex ) {
System . err . println ( lr_1 + property
+ lr_2 ) ;
return null ;
}
}
private static boolean isOsNameMatch ( final String osName , final String osNamePrefix ) {
if ( osName == null ) {
return false ;
}
return osName . toUpperCase ( Locale . ROOT ) . startsWith ( osNamePrefix . toUpperCase ( Locale . ROOT ) ) ;
}
public char [] getIllegalFileNameChars () {
return this . illegalFileNameChars . clone () ;
}
public int getMaxFileNameLength () {
return maxFileNameLength ;
}
public int getMaxPathLength () {
return maxPathLength ;
}
public String [] getReservedFileNames () {
return reservedFileNames . clone () ;
}
public boolean isCasePreserving () {
return casePreserving ;
}
public boolean isCaseSensitive () {
return caseSensitive ;
}
private boolean isIllegalFileNameChar ( final char c ) {
return Arrays . binarySearch ( illegalFileNameChars , c ) >= 0 ;
}
public boolean isLegalFileName ( final CharSequence candidate ) {
if ( candidate == null || candidate . length () == 0 || candidate . length () > maxFileNameLength ) {
return false ;
}
if ( isReservedFileName ( candidate ) ) {
return false ;
}
for ( int i = 0 ; i < candidate . length () ; i ++ ) {
if ( isIllegalFileNameChar ( candidate . charAt ( i ) ) ) {
return false ;
}
}
return true ;
}
public boolean isReservedFileName ( final CharSequence candidate ) {
return Arrays . binarySearch ( reservedFileNames , candidate ) >= 0 ;
}
public String toLegalFileName ( final String candidate , final char replacement ) {
if ( isIllegalFileNameChar ( replacement ) ) {
throw new IllegalArgumentException (
String . format ( lr_3 ,
replacement == '\0' ? lr_4 : replacement , name () , Arrays . toString ( illegalFileNameChars ) ) ) ;
}
final String truncated = candidate . length () > maxFileNameLength ? candidate . substring ( 0 , maxFileNameLength )
: candidate ;
boolean changed = false ;
final char [] charArray = truncated . toCharArray () ;
for ( int i = 0 ; i < charArray . length ; i ++ ) {
if ( isIllegalFileNameChar ( charArray [ i ] ) ) {
charArray [ i ] = replacement ;
changed = true ;
}
}
return changed ? String . valueOf ( charArray ) : truncated ;
}

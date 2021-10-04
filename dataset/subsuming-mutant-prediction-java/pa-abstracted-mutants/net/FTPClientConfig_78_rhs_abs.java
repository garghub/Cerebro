public String getServerSystemKey () {
return serverSystemKey ;
}
public String getDefaultDateFormatStr () {
return defaultDateFormatStr ;
}
public String getRecentDateFormatStr () {
return recentDateFormatStr ;
}
public String getServerTimeZoneId () {
return serverTimeZoneId ;
}
public String getShortMonthNames () {
return shortMonthNames ;
}
public String getServerLanguageCode () {
return serverLanguageCode ;
}
public boolean isLenientFutureDates () {
return lenientFutureDates ;
}
public void setDefaultDateFormatStr ( final String defaultDateFormatStr ) {
this . defaultDateFormatStr = defaultDateFormatStr ;
}
public void setRecentDateFormatStr ( final String recentDateFormatStr ) {
this . recentDateFormatStr = recentDateFormatStr ;
}
public void setLenientFutureDates ( final boolean lenientFutureDates ) {
this . lenientFutureDates = lenientFutureDates ;
}
public void setServerTimeZoneId ( final String serverTimeZoneId ) { MST[rv.ROR5Mutator]MSP[N]
this . serverTimeZoneId = serverTimeZoneId ;
}
public void setShortMonthNames ( final String shortMonthNames ) {
this . shortMonthNames = shortMonthNames ;
}
public void setServerLanguageCode ( final String serverLanguageCode ) {
this . serverLanguageCode = serverLanguageCode ;
}
public static DateFormatSymbols lookupDateFormatSymbols ( final String languageCode )
{
final Object lang = LANGUAGE_CODE_MAP . get ( languageCode ) ;
if ( lang != null ) {
if ( lang instanceof Locale ) {
return new DateFormatSymbols ( ( Locale ) lang ) ;
} else if ( lang instanceof String ) {
return getDateFormatSymbols ( ( String ) lang ) ;
}
}
return new DateFormatSymbols ( Locale . US ) ;
}
public static DateFormatSymbols getDateFormatSymbols ( final String shortmonths )
{
final String [] months = splitShortMonthString ( shortmonths ) ;
final DateFormatSymbols dfs = new DateFormatSymbols ( Locale . US ) ;
dfs . setShortMonths ( months ) ;
return dfs ;
}
private static String [] splitShortMonthString ( final String shortmonths ) {
final StringTokenizer st = new StringTokenizer ( shortmonths , lr_1 ) ;
final int monthcnt = st . countTokens () ;
if ( 12 != monthcnt ) {
throw new IllegalArgumentException (
lr_2 ) ;
}
final String [] months = new String [ 13 ] ;
int pos = 0 ;
while( st . hasMoreTokens () ) {
months [ pos ++ ] = st . nextToken () ;
}
months [ pos ] = lr_3 ;
return months ;
}
public static Collection < String > getSupportedLanguageCodes () {
return LANGUAGE_CODE_MAP . keySet () ;
}
public void setUnparseableEntries ( final boolean saveUnparseable ) {
this . saveUnparseableEntries = saveUnparseable ;
}
public boolean getUnparseableEntries () {
return this . saveUnparseableEntries ;
}

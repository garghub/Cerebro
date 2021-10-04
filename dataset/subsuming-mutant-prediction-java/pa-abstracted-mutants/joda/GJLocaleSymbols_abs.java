static GJLocaleSymbols forLocale ( Locale locale ) {
if ( locale == null ) {
locale = Locale . getDefault () ;
}
GJLocaleSymbols symbols = cCache . get ( locale ) ;
if ( symbols == null ) {
symbols = new GJLocaleSymbols ( locale ) ;
GJLocaleSymbols oldSymbols = cCache . putIfAbsent ( locale , symbols ) ;
if ( oldSymbols != null ) {
symbols = oldSymbols ;
}
}
return symbols ;
}
private static String [] realignMonths ( String [] months ) {
String [] a = new String [ 13 ] ;
for ( int i = 1 ; i < 13 ; i ++ ) {
a [ i ] = months [ i - 1 ] ;
}
return a ;
}
private static String [] realignDaysOfWeek ( String [] daysOfWeek ) {
String [] a = new String [ 8 ] ;
for ( int i = 1 ; i < 8 ; i ++ ) {
a [ i ] = daysOfWeek [ ( i < 7 ) ? i + 1 : 1 ] ;
}
return a ;
}
private static void addSymbols ( TreeMap < String , Integer > map , String [] symbols , Integer [] integers ) {
for ( int i = symbols . length ; -- i >= 0 ; ) {
String symbol = symbols [ i ] ;
if ( symbol != null ) {
map . put ( symbol , integers [ i ] ) ;
}
}
}
private static void addNumerals ( TreeMap < String , Integer > map , int start , int end , Integer [] integers ) {
for ( int i = start ; i <= end ; i ++ ) {
map . put ( String . valueOf ( i ) . intern () , integers [ i ] ) ;
}
}
private static int maxLength ( String [] a ) {
int max = 0 ;
for ( int i = a . length ; -- i >= 0 ; ) {
String s = a [ i ] ;
if ( s != null ) {
int len = s . length () ;
if ( len > max ) {
max = len ;
}
}
}
return max ;
}
public String eraValueToText ( int value ) {
return iEras [ value ] ;
}
public int eraTextToValue ( String text ) {
Integer era = iParseEras . get ( text ) ;
if ( era != null ) {
return era . intValue () ;
}
throw new IllegalFieldValueException ( DateTimeFieldType . era () , text ) ;
}
public int getEraMaxTextLength () {
return iMaxEraLength ;
}
public String monthOfYearValueToText ( int value ) {
return iMonths [ value ] ;
}
public String monthOfYearValueToShortText ( int value ) {
return iShortMonths [ value ] ;
}
public int monthOfYearTextToValue ( String text ) {
Integer month = iParseMonths . get ( text ) ;
if ( month != null ) {
return month . intValue () ;
}
throw new IllegalFieldValueException ( DateTimeFieldType . monthOfYear () , text ) ;
}
public int getMonthMaxTextLength () {
return iMaxMonthLength ;
}
public int getMonthMaxShortTextLength () {
return iMaxShortMonthLength ;
}
public String dayOfWeekValueToText ( int value ) {
return iDaysOfWeek [ value ] ;
}
public String dayOfWeekValueToShortText ( int value ) {
return iShortDaysOfWeek [ value ] ;
}
public int dayOfWeekTextToValue ( String text ) {
Integer day = iParseDaysOfWeek . get ( text ) ;
if ( day != null ) {
return day . intValue () ;
}
throw new IllegalFieldValueException ( DateTimeFieldType . dayOfWeek () , text ) ;
}
public int getDayOfWeekMaxTextLength () {
return iMaxDayOfWeekLength ;
}
public int getDayOfWeekMaxShortTextLength () {
return iMaxShortDayOfWeekLength ;
}
public String halfdayValueToText ( int value ) {
return iHalfday [ value ] ;
}
public int halfdayTextToValue ( String text ) {
String [] halfday = iHalfday ;
for ( int i = halfday . length ; -- i >= 0 ; ) {
if ( halfday [ i ] . equalsIgnoreCase ( text ) ) {
return i ;
}
}
throw new IllegalFieldValueException ( DateTimeFieldType . halfdayOfDay () , text ) ;
}
public int getHalfdayMaxTextLength () {
return iMaxHalfdayLength ;
}

public DateTimeFormatter toFormatter () {
Object f = getFormatter () ;
InternalPrinter printer = null ;
if ( isPrinter ( f ) ) {
printer = ( InternalPrinter ) f ;
}
InternalParser parser = null ;
if ( isParser ( f ) ) {
parser = ( InternalParser ) f ;
}
if ( printer != null || parser != null ) {
return new DateTimeFormatter ( printer , parser ) ;
}
throw new UnsupportedOperationException ( lr_1 ) ;
}
public DateTimePrinter toPrinter () {
Object f = getFormatter () ;
if ( isPrinter ( f ) ) {
InternalPrinter ip = ( InternalPrinter ) f ;
return InternalPrinterDateTimePrinter . of ( ip ) ;
}
throw new UnsupportedOperationException ( lr_2 ) ;
}
public DateTimeParser toParser () {
Object f = getFormatter () ;
if ( isParser ( f ) ) {
InternalParser ip = ( InternalParser ) f ;
return InternalParserDateTimeParser . of ( ip ) ;
}
throw new UnsupportedOperationException ( lr_3 ) ;
}
public boolean canBuildFormatter () {
return isFormatter ( getFormatter () ) ;
}
public boolean canBuildPrinter () {
return isPrinter ( getFormatter () ) ;
}
public boolean canBuildParser () {
return isParser ( getFormatter () ) ;
}
public void clear () {
iFormatter = null ;
iElementPairs . clear () ;
}
public DateTimeFormatterBuilder append ( DateTimeFormatter formatter ) {
if ( formatter == null ) {
throw new IllegalArgumentException ( lr_4 ) ;
}
return append0 ( formatter . getPrinter0 () , formatter . getParser0 () ) ;
}
public DateTimeFormatterBuilder append ( DateTimePrinter printer ) {
checkPrinter ( printer ) ;
return append0 ( DateTimePrinterInternalPrinter . of ( printer ) , null ) ;
}
public DateTimeFormatterBuilder append ( DateTimeParser parser ) {
checkParser ( parser ) ;
return append0 ( null , DateTimeParserInternalParser . of ( parser ) ) ;
}
public DateTimeFormatterBuilder append ( DateTimePrinter printer , DateTimeParser parser ) {
checkPrinter ( printer ) ;
checkParser ( parser ) ;
return append0 ( DateTimePrinterInternalPrinter . of ( printer ) , DateTimeParserInternalParser . of ( parser ) ) ;
}
public DateTimeFormatterBuilder append ( DateTimePrinter printer , DateTimeParser [] parsers ) {
if ( printer != null ) {
checkPrinter ( printer ) ;
}
if ( parsers == null ) {
throw new IllegalArgumentException ( lr_5 ) ;
}
int length = parsers . length ;
if ( length == 1 ) {
if ( parsers [ 0 ] == null ) {
throw new IllegalArgumentException ( lr_6 ) ;
}
return append0 ( DateTimePrinterInternalPrinter . of ( printer ) , DateTimeParserInternalParser . of ( parsers [ 0 ] ) ) ;
}
InternalParser [] copyOfParsers = new InternalParser [ length ] ;
int i ;
for ( i = 0 ; i < length - 1 ; i ++ ) {
if ( ( copyOfParsers [ i ] = DateTimeParserInternalParser . of ( parsers [ i ] ) ) == null ) {
throw new IllegalArgumentException ( lr_7 ) ;
}
}
copyOfParsers [ i ] = DateTimeParserInternalParser . of ( parsers [ i ] ) ;
return append0 ( DateTimePrinterInternalPrinter . of ( printer ) , new MatchingParser ( copyOfParsers ) ) ;
}
public DateTimeFormatterBuilder appendOptional ( DateTimeParser parser ) {
checkParser ( parser ) ;
InternalParser [] parsers = new InternalParser [] { DateTimeParserInternalParser . of ( parser ) , null } ;
return append0 ( null , new MatchingParser ( parsers ) ) ;
}
private void checkParser ( DateTimeParser parser ) {
if ( parser == null ) {
throw new IllegalArgumentException ( lr_6 ) ;
}
}
private void checkPrinter ( DateTimePrinter printer ) {
if ( printer == null ) {
throw new IllegalArgumentException ( lr_8 ) ;
}
}
private DateTimeFormatterBuilder append0 ( Object element ) {
iFormatter = null ;
iElementPairs . add ( element ) ;
iElementPairs . add ( element ) ;
return this ;
}
private DateTimeFormatterBuilder append0 (
InternalPrinter printer , InternalParser parser ) {
iFormatter = null ;
iElementPairs . add ( printer ) ;
iElementPairs . add ( parser ) ;
return this ;
}
public DateTimeFormatterBuilder appendLiteral ( char c ) {
return append0 ( new CharacterLiteral ( c ) ) ;
}
public DateTimeFormatterBuilder appendLiteral ( String text ) {
if ( text == null ) {
throw new IllegalArgumentException ( lr_9 ) ;
}
switch ( text . length () ) {
case 0 :
return this ;
case 1 :
return append0 ( new CharacterLiteral ( text . charAt ( 0 ) ) ) ;
default:
return append0 ( new StringLiteral ( text ) ) ;
}
}
public DateTimeFormatterBuilder appendDecimal (
DateTimeFieldType fieldType , int minDigits , int maxDigits ) {
if ( fieldType == null ) {
throw new IllegalArgumentException ( lr_10 ) ;
}
if ( maxDigits < minDigits ) {
maxDigits = minDigits ;
}
if ( minDigits < 0 || maxDigits <= 0 ) {
throw new IllegalArgumentException () ;
}
if ( minDigits <= 1 ) {
return append0 ( new UnpaddedNumber ( fieldType , maxDigits , false ) ) ;
} else {
return append0 ( new PaddedNumber ( fieldType , maxDigits , false , minDigits ) ) ;
}
}
public DateTimeFormatterBuilder appendFixedDecimal (
DateTimeFieldType fieldType , int numDigits ) {
if ( fieldType == null ) {
throw new IllegalArgumentException ( lr_10 ) ;
}
if ( numDigits <= 0 ) {
throw new IllegalArgumentException ( lr_11 + numDigits ) ;
}
return append0 ( new FixedNumber ( fieldType , numDigits , false ) ) ;
}
public DateTimeFormatterBuilder appendSignedDecimal (
DateTimeFieldType fieldType , int minDigits , int maxDigits ) {
if ( fieldType == null ) {
throw new IllegalArgumentException ( lr_10 ) ;
}
if ( maxDigits < minDigits ) {
maxDigits = minDigits ;
}
if ( minDigits < 0 || maxDigits <= 0 ) {
throw new IllegalArgumentException () ;
}
if ( minDigits <= 1 ) {
return append0 ( new UnpaddedNumber ( fieldType , maxDigits , true ) ) ;
} else {
return append0 ( new PaddedNumber ( fieldType , maxDigits , true , minDigits ) ) ;
}
}
public DateTimeFormatterBuilder appendFixedSignedDecimal (
DateTimeFieldType fieldType , int numDigits ) {
if ( fieldType == null ) {
throw new IllegalArgumentException ( lr_10 ) ;
}
if ( numDigits <= 0 ) {
throw new IllegalArgumentException ( lr_11 + numDigits ) ;
}
return append0 ( new FixedNumber ( fieldType , numDigits , true ) ) ;
}
public DateTimeFormatterBuilder appendText ( DateTimeFieldType fieldType ) {
if ( fieldType == null ) {
throw new IllegalArgumentException ( lr_10 ) ;
}
return append0 ( new TextField ( fieldType , false ) ) ;
}
public DateTimeFormatterBuilder appendShortText ( DateTimeFieldType fieldType ) {
if ( fieldType == null ) {
throw new IllegalArgumentException ( lr_10 ) ;
}
return append0 ( new TextField ( fieldType , true ) ) ;
}
public DateTimeFormatterBuilder appendFraction (
DateTimeFieldType fieldType , int minDigits , int maxDigits ) {
if ( fieldType == null ) {
throw new IllegalArgumentException ( lr_10 ) ;
}
if ( maxDigits < minDigits ) {
maxDigits = minDigits ;
}
if ( minDigits < 0 || maxDigits <= 0 ) {
throw new IllegalArgumentException () ;
}
return append0 ( new Fraction ( fieldType , minDigits , maxDigits ) ) ;
}
public DateTimeFormatterBuilder appendFractionOfSecond ( int minDigits , int maxDigits ) {
return appendFraction ( DateTimeFieldType . secondOfDay () , minDigits , maxDigits ) ;
}
public DateTimeFormatterBuilder appendFractionOfMinute ( int minDigits , int maxDigits ) {
return appendFraction ( DateTimeFieldType . minuteOfDay () , minDigits , maxDigits ) ;
}
public DateTimeFormatterBuilder appendFractionOfHour ( int minDigits , int maxDigits ) {
return appendFraction ( DateTimeFieldType . hourOfDay () , minDigits , maxDigits ) ;
}
public DateTimeFormatterBuilder appendFractionOfDay ( int minDigits , int maxDigits ) {
return appendFraction ( DateTimeFieldType . dayOfYear () , minDigits , maxDigits ) ;
}
public DateTimeFormatterBuilder appendMillisOfSecond ( int minDigits ) {
return appendDecimal ( DateTimeFieldType . millisOfSecond () , minDigits , 3 ) ;
}
public DateTimeFormatterBuilder appendMillisOfDay ( int minDigits ) {
return appendDecimal ( DateTimeFieldType . millisOfDay () , minDigits , 8 ) ;
}
public DateTimeFormatterBuilder appendSecondOfMinute ( int minDigits ) {
return appendDecimal ( DateTimeFieldType . secondOfMinute () , minDigits , 2 ) ;
}
public DateTimeFormatterBuilder appendSecondOfDay ( int minDigits ) {
return appendDecimal ( DateTimeFieldType . secondOfDay () , minDigits , 5 ) ;
}
public DateTimeFormatterBuilder appendMinuteOfHour ( int minDigits ) {
return appendDecimal ( DateTimeFieldType . minuteOfHour () , minDigits , 2 ) ;
}
public DateTimeFormatterBuilder appendMinuteOfDay ( int minDigits ) {
return appendDecimal ( DateTimeFieldType . minuteOfDay () , minDigits , 4 ) ;
}
public DateTimeFormatterBuilder appendHourOfDay ( int minDigits ) {
return appendDecimal ( DateTimeFieldType . hourOfDay () , minDigits , 2 ) ;
}
public DateTimeFormatterBuilder appendClockhourOfDay ( int minDigits ) {
return appendDecimal ( DateTimeFieldType . clockhourOfDay () , minDigits , 2 ) ;
}
public DateTimeFormatterBuilder appendHourOfHalfday ( int minDigits ) {
return appendDecimal ( DateTimeFieldType . hourOfHalfday () , minDigits , 2 ) ;
}
public DateTimeFormatterBuilder appendClockhourOfHalfday ( int minDigits ) {
return appendDecimal ( DateTimeFieldType . clockhourOfHalfday () , minDigits , 2 ) ;
}
public DateTimeFormatterBuilder appendDayOfWeek ( int minDigits ) {
return appendDecimal ( DateTimeFieldType . dayOfWeek () , minDigits , 1 ) ;
}
public DateTimeFormatterBuilder appendDayOfMonth ( int minDigits ) {
return appendDecimal ( DateTimeFieldType . dayOfMonth () , minDigits , 2 ) ;
}
public DateTimeFormatterBuilder appendDayOfYear ( int minDigits ) {
return appendDecimal ( DateTimeFieldType . dayOfYear () , minDigits , 3 ) ;
}
public DateTimeFormatterBuilder appendWeekOfWeekyear ( int minDigits ) {
return appendDecimal ( DateTimeFieldType . weekOfWeekyear () , minDigits , 2 ) ;
}
public DateTimeFormatterBuilder appendWeekyear ( int minDigits , int maxDigits ) {
return appendSignedDecimal ( DateTimeFieldType . weekyear () , minDigits , maxDigits ) ;
}
public DateTimeFormatterBuilder appendMonthOfYear ( int minDigits ) {
return appendDecimal ( DateTimeFieldType . monthOfYear () , minDigits , 2 ) ;
}
public DateTimeFormatterBuilder appendYear ( int minDigits , int maxDigits ) {
return appendSignedDecimal ( DateTimeFieldType . year () , minDigits , maxDigits ) ;
}
public DateTimeFormatterBuilder appendTwoDigitYear ( int pivot ) {
return appendTwoDigitYear ( pivot , false ) ;
}
public DateTimeFormatterBuilder appendTwoDigitYear ( int pivot , boolean lenientParse ) {
return append0 ( new TwoDigitYear ( DateTimeFieldType . year () , pivot , lenientParse ) ) ;
}
public DateTimeFormatterBuilder appendTwoDigitWeekyear ( int pivot ) {
return appendTwoDigitWeekyear ( pivot , false ) ;
}
public DateTimeFormatterBuilder appendTwoDigitWeekyear ( int pivot , boolean lenientParse ) {
return append0 ( new TwoDigitYear ( DateTimeFieldType . weekyear () , pivot , lenientParse ) ) ;
}
public DateTimeFormatterBuilder appendYearOfEra ( int minDigits , int maxDigits ) {
return appendDecimal ( DateTimeFieldType . yearOfEra () , minDigits , maxDigits ) ;
}
public DateTimeFormatterBuilder appendYearOfCentury ( int minDigits , int maxDigits ) {
return appendDecimal ( DateTimeFieldType . yearOfCentury () , minDigits , maxDigits ) ;
}
public DateTimeFormatterBuilder appendCenturyOfEra ( int minDigits , int maxDigits ) {
return appendSignedDecimal ( DateTimeFieldType . centuryOfEra () , minDigits , maxDigits ) ;
}
public DateTimeFormatterBuilder appendHalfdayOfDayText () {
return appendText ( DateTimeFieldType . halfdayOfDay () ) ;
}
public DateTimeFormatterBuilder appendDayOfWeekText () {
return appendText ( DateTimeFieldType . dayOfWeek () ) ;
}
public DateTimeFormatterBuilder appendDayOfWeekShortText () {
return appendShortText ( DateTimeFieldType . dayOfWeek () ) ;
}
public DateTimeFormatterBuilder appendMonthOfYearText () {
return appendText ( DateTimeFieldType . monthOfYear () ) ;
}
public DateTimeFormatterBuilder appendMonthOfYearShortText () {
return appendShortText ( DateTimeFieldType . monthOfYear () ) ;
}
public DateTimeFormatterBuilder appendEraText () {
return appendText ( DateTimeFieldType . era () ) ;
}
public DateTimeFormatterBuilder appendTimeZoneName () {
return append0 ( new TimeZoneName ( TimeZoneName . LONG_NAME , null ) , null ) ;
}
public DateTimeFormatterBuilder appendTimeZoneName ( Map < String , DateTimeZone > parseLookup ) {
TimeZoneName pp = new TimeZoneName ( TimeZoneName . LONG_NAME , parseLookup ) ;
return append0 ( pp , pp ) ;
}
public DateTimeFormatterBuilder appendTimeZoneShortName () {
return append0 ( new TimeZoneName ( TimeZoneName . SHORT_NAME , null ) , null ) ;
}
public DateTimeFormatterBuilder appendTimeZoneShortName ( Map < String , DateTimeZone > parseLookup ) {
TimeZoneName pp = new TimeZoneName ( TimeZoneName . SHORT_NAME , parseLookup ) ;
return append0 ( pp , pp ) ;
}
public DateTimeFormatterBuilder appendTimeZoneId () {
return append0 ( TimeZoneId . INSTANCE , TimeZoneId . INSTANCE ) ;
}
public DateTimeFormatterBuilder appendTimeZoneOffset (
String zeroOffsetText , boolean showSeparators ,
int minFields , int maxFields ) {
return append0 ( new TimeZoneOffset
( zeroOffsetText , zeroOffsetText , showSeparators , minFields , maxFields ) ) ;
}
public DateTimeFormatterBuilder appendTimeZoneOffset (
String zeroOffsetPrintText , String zeroOffsetParseText , boolean showSeparators ,
int minFields , int maxFields ) {
return append0 ( new TimeZoneOffset
( zeroOffsetPrintText , zeroOffsetParseText , showSeparators , minFields , maxFields ) ) ;
}
public DateTimeFormatterBuilder appendPattern ( String pattern ) {
DateTimeFormat . appendPatternTo ( this , pattern ) ;
return this ;
}
private Object getFormatter () {
Object f = iFormatter ;
if ( f == null ) {
if ( iElementPairs . size () == 2 ) {
Object printer = iElementPairs . get ( 0 ) ;
Object parser = iElementPairs . get ( 1 ) ;
if ( printer != null ) {
if ( printer == parser || parser == null ) {
f = printer ;
}
} else {
f = parser ;
}
}
if ( f == null ) {
f = new Composite ( iElementPairs ) ;
}
iFormatter = f ;
}
return f ;
}
private boolean isPrinter ( Object f ) {
if ( f instanceof InternalPrinter ) {
if ( f instanceof Composite ) {
return ( ( Composite ) f ) . isPrinter () ;
}
return true ;
}
return false ;
}
private boolean isParser ( Object f ) {
if ( f instanceof InternalParser ) {
if ( f instanceof Composite ) {
return ( ( Composite ) f ) . isParser () ;
}
return true ;
}
return false ;
}
private boolean isFormatter ( Object f ) {
return ( isPrinter ( f ) || isParser ( f ) ) ;
}
static void appendUnknownString ( Appendable appendable , int len ) throws IOException {
for ( int i = len ; -- i >= 0 ; ) {
appendable . append ( '\ufffd' ) ;
}
}
public int estimatePrintedLength () {
return 1 ;
}
public void printTo (
Appendable appendable , long instant , Chronology chrono ,
int displayOffset , DateTimeZone displayZone , Locale locale ) throws IOException {
appendable . append ( iValue ) ;
}
public void printTo ( Appendable appendable , ReadablePartial partial , Locale locale ) throws IOException {
appendable . append ( iValue ) ;
}
public int estimateParsedLength () {
return 1 ;
}
public int parseInto ( DateTimeParserBucket bucket , CharSequence text , int position ) {
if ( position >= text . length () ) {
return ~ position ;
}
char a = text . charAt ( position ) ;
char b = iValue ;
if ( a != b ) {
a = Character . toUpperCase ( a ) ;
b = Character . toUpperCase ( b ) ;
if ( a != b ) {
a = Character . toLowerCase ( a ) ;
b = Character . toLowerCase ( b ) ;
if ( a != b ) {
return ~ position ;
}
}
}
return position + 1 ;
}
public int estimatePrintedLength () {
return iValue . length () ;
}
public void printTo (
Appendable appendable , long instant , Chronology chrono ,
int displayOffset , DateTimeZone displayZone , Locale locale ) throws IOException {
appendable . append ( iValue ) ;
}
public void printTo ( Appendable appendable , ReadablePartial partial , Locale locale ) throws IOException {
appendable . append ( iValue ) ;
}
public int estimateParsedLength () {
return iValue . length () ;
}
public int parseInto ( DateTimeParserBucket bucket , CharSequence text , int position ) {
if ( csStartsWithIgnoreCase ( text , position , iValue ) ) {
return position + iValue . length () ;
}
return ~ position ;
}
public int estimateParsedLength () {
return iMaxParsedDigits ;
}
public int parseInto ( DateTimeParserBucket bucket , CharSequence text , int position ) {
int limit = Math . min ( iMaxParsedDigits , text . length () - position ) ;
boolean negative = false ;
boolean positive = false ;
int length = 0 ;
while ( length < limit ) {
char c = text . charAt ( position + length ) ;
if ( length == 0 && ( c == '-' || c == '+' ) && iSigned ) {
negative = c == '-' ;
positive = c == '+' ;
if ( length + 1 >= limit ||
( c = text . charAt ( position + length + 1 ) ) < '0' || c > '9' ) {
break;
}
length ++ ;
limit = Math . min ( limit + 1 , text . length () - position ) ;
continue;
}
if ( c < '0' || c > '9' ) {
break;
}
length ++ ;
}
if ( length == 0 ) {
return ~ position ;
}
int value ;
if ( length >= 9 ) {
if ( positive ) {
value = Integer . parseInt ( text . subSequence ( position + 1 , position += length ) . toString () ) ;
} else {
value = Integer . parseInt ( text . subSequence ( position , position += length ) . toString () ) ;
}
} else {
int i = position ;
if ( negative || positive ) {
i ++ ;
}
try {
value = text . charAt ( i ++ ) - '0' ;
} catch ( StringIndexOutOfBoundsException e ) {
return ~ position ;
}
position += length ;
while ( i < position ) {
value = ( ( value << 3 ) + ( value << 1 ) ) + text . charAt ( i ++ ) - '0' ;
}
if ( negative ) {
value = - value ;
}
}
bucket . saveField ( iFieldType , value ) ;
return position ;
}
public int estimatePrintedLength () {
return iMaxParsedDigits ;
}
public void printTo (
Appendable appendable , long instant , Chronology chrono ,
int displayOffset , DateTimeZone displayZone , Locale locale ) throws IOException {
try {
DateTimeField field = iFieldType . getField ( chrono ) ;
FormatUtils . appendUnpaddedInteger ( appendable , field . get ( instant ) ) ;
} catch ( RuntimeException e ) {
appendable . append ( '\ufffd' ) ;
}
}
public void printTo ( Appendable appendable , ReadablePartial partial , Locale locale ) throws IOException {
if ( partial . isSupported ( iFieldType ) ) {
try {
FormatUtils . appendUnpaddedInteger ( appendable , partial . get ( iFieldType ) ) ;
} catch ( RuntimeException e ) {
appendable . append ( '\ufffd' ) ;
}
} else {
appendable . append ( '\ufffd' ) ;
}
}
public int estimatePrintedLength () {
return iMaxParsedDigits ;
}
public void printTo (
Appendable appendable , long instant , Chronology chrono ,
int displayOffset , DateTimeZone displayZone , Locale locale ) throws IOException {
try {
DateTimeField field = iFieldType . getField ( chrono ) ;
FormatUtils . appendPaddedInteger ( appendable , field . get ( instant ) , iMinPrintedDigits ) ;
} catch ( RuntimeException e ) {
appendUnknownString ( appendable , iMinPrintedDigits ) ;
}
}
public void printTo ( Appendable appendable , ReadablePartial partial , Locale locale ) throws IOException {
if ( partial . isSupported ( iFieldType ) ) {
try {
FormatUtils . appendPaddedInteger ( appendable , partial . get ( iFieldType ) , iMinPrintedDigits ) ;
} catch ( RuntimeException e ) {
appendUnknownString ( appendable , iMinPrintedDigits ) ;
}
} else {
appendUnknownString ( appendable , iMinPrintedDigits ) ;
}
}
@Override
public int parseInto ( DateTimeParserBucket bucket , CharSequence text , int position ) {
int newPos = super . parseInto ( bucket , text , position ) ;
if ( newPos < 0 ) {
return newPos ;
}
int expectedPos = position + iMaxParsedDigits ;
if ( newPos != expectedPos ) {
if ( iSigned ) {
char c = text . charAt ( position ) ;
if ( c == '-' || c == '+' ) {
expectedPos ++ ;
}
}
if ( newPos > expectedPos ) {
return ~ ( expectedPos + 1 ) ;
} else if ( newPos < expectedPos ) {
return ~ newPos ;
}
}
return newPos ;
}
public int estimateParsedLength () {
return iLenientParse ? 4 : 2 ;
}
public int parseInto ( DateTimeParserBucket bucket , CharSequence text , int position ) {
int limit = text . length () - position ;
if ( ! iLenientParse ) {
limit = Math . min ( 2 , limit ) ;
if ( limit < 2 ) {
return ~ position ;
}
} else {
boolean hasSignChar = false ;
boolean negative = false ;
int length = 0 ;
while ( length < limit ) {
char c = text . charAt ( position + length ) ;
if ( length == 0 && ( c == '-' || c == '+' ) ) {
hasSignChar = true ;
negative = c == '-' ;
if ( negative ) {
length ++ ;
} else {
position ++ ;
limit -- ;
}
continue;
}
if ( c < '0' || c > '9' ) {
break;
}
length ++ ;
}
if ( length == 0 ) {
return ~ position ;
}
if ( hasSignChar || length != 2 ) {
int value ;
if ( length >= 9 ) {
value = Integer . parseInt ( text . subSequence ( position , position += length ) . toString () ) ;
} else {
int i = position ;
if ( negative ) {
i ++ ;
}
try {
value = text . charAt ( i ++ ) - '0' ;
} catch ( StringIndexOutOfBoundsException e ) {
return ~ position ;
}
position += length ;
while ( i < position ) {
value = ( ( value << 3 ) + ( value << 1 ) ) + text . charAt ( i ++ ) - '0' ;
}
if ( negative ) {
value = - value ;
}
}
bucket . saveField ( iType , value ) ;
return position ;
}
}
int year ;
char c = text . charAt ( position ) ;
if ( c < '0' || c > '9' ) {
return ~ position ;
}
year = c - '0' ;
c = text . charAt ( position + 1 ) ;
if ( c < '0' || c > '9' ) {
return ~ position ;
}
year = ( ( year << 3 ) + ( year << 1 ) ) + c - '0' ;
int pivot = iPivot ;
if ( bucket . getPivotYear () != null ) {
pivot = bucket . getPivotYear () . intValue () ;
}
int low = pivot - 50 ;
int t ;
if ( low >= 0 ) {
t = low % 100 ;
} else {
t = 99 + ( ( low + 1 ) % 100 ) ;
}
year += low + ( ( year < t ) ? 100 : 0 ) - t ;
bucket . saveField ( iType , year ) ;
return position + 2 ;
}
public int estimatePrintedLength () {
return 2 ;
}
public void printTo (
Appendable appendable , long instant , Chronology chrono ,
int displayOffset , DateTimeZone displayZone , Locale locale ) throws IOException {
int year = getTwoDigitYear ( instant , chrono ) ;
if ( year < 0 ) {
appendable . append ( '\ufffd' ) ;
appendable . append ( '\ufffd' ) ;
} else {
FormatUtils . appendPaddedInteger ( appendable , year , 2 ) ;
}
}
private int getTwoDigitYear ( long instant , Chronology chrono ) {
try {
int year = iType . getField ( chrono ) . get ( instant ) ;
if ( year < 0 ) {
year = - year ;
}
return year % 100 ;
} catch ( RuntimeException e ) {
return - 1 ;
}
}
public void printTo ( Appendable appendable , ReadablePartial partial , Locale locale ) throws IOException {
int year = getTwoDigitYear ( partial ) ;
if ( year < 0 ) {
appendable . append ( '\ufffd' ) ;
appendable . append ( '\ufffd' ) ;
} else {
FormatUtils . appendPaddedInteger ( appendable , year , 2 ) ;
}
}
private int getTwoDigitYear ( ReadablePartial partial ) {
if ( partial . isSupported ( iType ) ) {
try {
int year = partial . get ( iType ) ;
if ( year < 0 ) {
year = - year ;
}
return year % 100 ;
} catch ( RuntimeException e ) {}
}
return - 1 ;
}
public int estimatePrintedLength () {
return iShort ? 6 : 20 ;
}
public void printTo (
Appendable appendable , long instant , Chronology chrono ,
int displayOffset , DateTimeZone displayZone , Locale locale ) throws IOException {
try {
appendable . append ( print ( instant , chrono , locale ) ) ;
} catch ( RuntimeException e ) {
appendable . append ( '\ufffd' ) ;
}
}
public void printTo ( Appendable appendable , ReadablePartial partial , Locale locale ) throws IOException {
try {
appendable . append ( print ( partial , locale ) ) ;
} catch ( RuntimeException e ) {
appendable . append ( '\ufffd' ) ;
}
}
private String print ( long instant , Chronology chrono , Locale locale ) {
DateTimeField field = iFieldType . getField ( chrono ) ;
if ( iShort ) {
return field . getAsShortText ( instant , locale ) ;
} else {
return field . getAsText ( instant , locale ) ;
}
}
private String print ( ReadablePartial partial , Locale locale ) {
if ( partial . isSupported ( iFieldType ) ) {
DateTimeField field = iFieldType . getField ( partial . getChronology () ) ;
if ( iShort ) {
return field . getAsShortText ( partial , locale ) ;
} else {
return field . getAsText ( partial , locale ) ;
}
} else {
return lr_12 ;
}
}
public int estimateParsedLength () {
return estimatePrintedLength () ;
}
@SuppressWarnings ( lr_13 )
public int parseInto ( DateTimeParserBucket bucket , CharSequence text , int position ) {
Locale locale = bucket . getLocale () ;
Map < String , Boolean > validValues = null ;
int maxLength = 0 ;
Map < DateTimeFieldType , Object [] > innerMap = cParseCache . get ( locale ) ;
if ( innerMap == null ) {
innerMap = new ConcurrentHashMap < DateTimeFieldType , Object [] > () ;
cParseCache . put ( locale , innerMap ) ;
}
Object [] array = innerMap . get ( iFieldType ) ;
if ( array == null ) {
validValues = new ConcurrentHashMap < String , Boolean > ( 32 ) ;
MutableDateTime dt = new MutableDateTime ( 0L , DateTimeZone . UTC ) ;
Property property = dt . property ( iFieldType ) ;
int min = property . getMinimumValueOverall () ;
int max = property . getMaximumValueOverall () ;
if ( max - min > 32 ) {
return ~ position ;
}
maxLength = property . getMaximumTextLength ( locale ) ;
for ( int i = min ; i <= max ; i ++ ) {
property . set ( i ) ;
validValues . put ( property . getAsShortText ( locale ) , Boolean . TRUE ) ;
validValues . put ( property . getAsShortText ( locale ) . toLowerCase ( locale ) , Boolean . TRUE ) ;
validValues . put ( property . getAsShortText ( locale ) . toUpperCase ( locale ) , Boolean . TRUE ) ;
validValues . put ( property . getAsText ( locale ) , Boolean . TRUE ) ;
validValues . put ( property . getAsText ( locale ) . toLowerCase ( locale ) , Boolean . TRUE ) ;
validValues . put ( property . getAsText ( locale ) . toUpperCase ( locale ) , Boolean . TRUE ) ;
}
if ( lr_14 . equals ( locale . getLanguage () ) && iFieldType == DateTimeFieldType . era () ) {
validValues . put ( lr_15 , Boolean . TRUE ) ;
validValues . put ( lr_16 , Boolean . TRUE ) ;
validValues . put ( lr_17 , Boolean . TRUE ) ;
validValues . put ( lr_18 , Boolean . TRUE ) ;
maxLength = 3 ;
}
array = new Object [] { validValues , Integer . valueOf ( maxLength ) } ;
innerMap . put ( iFieldType , array ) ;
} else {
validValues = ( Map < String , Boolean > ) array [ 0 ] ;
maxLength = ( ( Integer ) array [ 1 ] ) . intValue () ;
}
int limit = Math . min ( text . length () , position + maxLength ) ;
for ( int i = limit ; i > position ; i -- ) {
String match = text . subSequence ( position , i ) . toString () ;
if ( validValues . containsKey ( match ) ) {
bucket . saveField ( iFieldType , match , locale ) ;
return i ;
}
}
return ~ position ;
}
public int estimatePrintedLength () {
return iMaxDigits ;
}
public void printTo (
Appendable appendable , long instant , Chronology chrono ,
int displayOffset , DateTimeZone displayZone , Locale locale ) throws IOException {
printTo ( appendable , instant , chrono ) ;
}
public void printTo ( Appendable appendable , ReadablePartial partial , Locale locale ) throws IOException {
long millis = partial . getChronology () . set ( partial , 0L ) ;
printTo ( appendable , millis , partial . getChronology () ) ;
}
protected void printTo ( Appendable appendable , long instant , Chronology chrono )
throws IOException
{
DateTimeField field = iFieldType . getField ( chrono ) ;
int minDigits = iMinDigits ;
long fraction ;
try {
fraction = field . remainder ( instant ) ;
} catch ( RuntimeException e ) {
appendUnknownString ( appendable , minDigits ) ;
return;
}
if ( fraction == 0 ) {
while ( -- minDigits >= 0 ) {
appendable . append ( '0' ) ;
}
return;
}
String str ;
long [] fractionData = getFractionData ( fraction , field ) ;
long scaled = fractionData [ 0 ] ;
int maxDigits = ( int ) fractionData [ 1 ] ;
if ( ( scaled & 0x7fffffff ) == scaled ) {
str = Integer . toString ( ( int ) scaled ) ;
} else {
str = Long . toString ( scaled ) ;
}
int length = str . length () ;
int digits = maxDigits ;
while ( length < digits ) {
appendable . append ( '0' ) ;
minDigits -- ;
digits -- ;
}
if ( minDigits < digits ) {
while ( minDigits < digits ) {
if ( length <= 1 || str . charAt ( length - 1 ) != '0' ) {
break;
}
digits -- ;
length -- ;
}
if ( length < str . length () ) {
for ( int i = 0 ; i < length ; i ++ ) {
appendable . append ( str . charAt ( i ) ) ;
}
return;
}
}
appendable . append ( str ) ;
}
private long [] getFractionData ( long fraction , DateTimeField field ) {
long rangeMillis = field . getDurationField () . getUnitMillis () ;
long scalar ;
int maxDigits = iMaxDigits ;
while ( true ) {
switch ( maxDigits ) {
default: scalar = 1L ; break;
case 1 : scalar = 10L ; break;
case 2 : scalar = 100L ; break;
case 3 : scalar = 1000L ; break;
case 4 : scalar = 10000L ; break;
case 5 : scalar = 100000L ; break;
case 6 : scalar = 1000000L ; break;
case 7 : scalar = 10000000L ; break;
case 8 : scalar = 100000000L ; break;
case 9 : scalar = 1000000000L ; break;
case 10 : scalar = 10000000000L ; break;
case 11 : scalar = 100000000000L ; break;
case 12 : scalar = 1000000000000L ; break;
case 13 : scalar = 10000000000000L ; break;
case 14 : scalar = 100000000000000L ; break;
case 15 : scalar = 1000000000000000L ; break;
case 16 : scalar = 10000000000000000L ; break;
case 17 : scalar = 100000000000000000L ; break;
case 18 : scalar = 1000000000000000000L ; break;
}
if ( ( ( rangeMillis * scalar ) / scalar ) == rangeMillis ) {
break;
}
maxDigits -- ;
}
return new long [] { fraction * scalar / rangeMillis , maxDigits } ;
}
public int estimateParsedLength () {
return iMaxDigits ;
}
public int parseInto ( DateTimeParserBucket bucket , CharSequence text , int position ) {
DateTimeField field = iFieldType . getField ( bucket . getChronology () ) ;
int limit = Math . min ( iMaxDigits , text . length () - position ) ;
long value = 0 ;
long n = field . getDurationField () . getUnitMillis () * 10 ;
int length = 0 ;
while ( length < limit ) {
char c = text . charAt ( position + length ) ;
if ( c < '0' || c > '9' ) {
break;
}
length ++ ;
long nn = n / 10 ;
value += ( c - '0' ) * nn ;
n = nn ;
}
value /= 10 ;
if ( length == 0 ) {
return ~ position ;
}
if ( value > Integer . MAX_VALUE ) {
return ~ position ;
}
DateTimeField parseField = new PreciseDateTimeField (
DateTimeFieldType . millisOfSecond () ,
MillisDurationField . INSTANCE ,
field . getDurationField () ) ;
bucket . saveField ( parseField , ( int ) value ) ;
return position + length ;
}
public int estimatePrintedLength () {
int est = 1 + iMinFields << 1 ;
if ( iShowSeparators ) {
est += iMinFields - 1 ;
}
if ( iZeroOffsetPrintText != null && iZeroOffsetPrintText . length () > est ) {
est = iZeroOffsetPrintText . length () ;
}
return est ;
}
public void printTo (
Appendable buf , long instant , Chronology chrono ,
int displayOffset , DateTimeZone displayZone , Locale locale ) throws IOException {
if ( displayZone == null ) {
return;
}
if ( displayOffset == 0 && iZeroOffsetPrintText != null ) {
buf . append ( iZeroOffsetPrintText ) ;
return;
}
if ( displayOffset >= 0 ) {
buf . append ( '+' ) ;
} else {
buf . append ( '-' ) ;
displayOffset = - displayOffset ;
}
int hours = displayOffset / DateTimeConstants . MILLIS_PER_HOUR ;
FormatUtils . appendPaddedInteger ( buf , hours , 2 ) ;
if ( iMaxFields == 1 ) {
return;
}
displayOffset -= hours * ( int ) DateTimeConstants . MILLIS_PER_HOUR ;
if ( displayOffset == 0 && iMinFields <= 1 ) {
return;
}
int minutes = displayOffset / DateTimeConstants . MILLIS_PER_MINUTE ;
if ( iShowSeparators ) {
buf . append ( ':' ) ;
}
FormatUtils . appendPaddedInteger ( buf , minutes , 2 ) ;
if ( iMaxFields == 2 ) {
return;
}
displayOffset -= minutes * DateTimeConstants . MILLIS_PER_MINUTE ;
if ( displayOffset == 0 && iMinFields <= 2 ) {
return;
}
int seconds = displayOffset / DateTimeConstants . MILLIS_PER_SECOND ;
if ( iShowSeparators ) {
buf . append ( ':' ) ;
}
FormatUtils . appendPaddedInteger ( buf , seconds , 2 ) ;
if ( iMaxFields == 3 ) {
return;
}
displayOffset -= seconds * DateTimeConstants . MILLIS_PER_SECOND ;
if ( displayOffset == 0 && iMinFields <= 3 ) {
return;
}
if ( iShowSeparators ) {
buf . append ( '.' ) ;
}
FormatUtils . appendPaddedInteger ( buf , displayOffset , 3 ) ;
}
public void printTo ( Appendable appendable , ReadablePartial partial , Locale locale ) throws IOException {
}
public int estimateParsedLength () {
return estimatePrintedLength () ;
}
public int parseInto ( DateTimeParserBucket bucket , CharSequence text , int position ) {
int limit = text . length () - position ;
zeroOffset:
if ( iZeroOffsetParseText != null ) {
if ( iZeroOffsetParseText . length () == 0 ) {
if ( limit > 0 ) {
char c = text . charAt ( position ) ;
if ( c == '-' || c == '+' ) {
break zeroOffset;
}
}
bucket . setOffset ( Integer . valueOf ( 0 ) ) ;
return position ;
}
if ( csStartsWithIgnoreCase ( text , position , iZeroOffsetParseText ) ) {
bucket . setOffset ( Integer . valueOf ( 0 ) ) ;
return position + iZeroOffsetParseText . length () ;
}
}
if ( limit <= 1 ) {
return ~ position ;
}
boolean negative ;
char c = text . charAt ( position ) ;
if ( c == '-' ) {
negative = true ;
} else if ( c == '+' ) {
negative = false ;
} else {
return ~ position ;
}
limit -- ;
position ++ ;
if ( digitCount ( text , position , 2 ) < 2 ) {
return ~ position ;
}
int offset ;
int hours = FormatUtils . parseTwoDigits ( text , position ) ;
if ( hours > 23 ) {
return ~ position ;
}
offset = hours * DateTimeConstants . MILLIS_PER_HOUR ;
limit -= 2 ;
position += 2 ;
parse: {
if ( limit <= 0 ) {
break parse;
}
boolean expectSeparators ;
c = text . charAt ( position ) ;
if ( c == ':' ) {
expectSeparators = true ;
limit -- ;
position ++ ;
} else if ( c >= '0' && c <= '9' ) {
expectSeparators = false ;
} else {
break parse;
}
int count = digitCount ( text , position , 2 ) ;
if ( count == 0 && ! expectSeparators ) {
break parse;
} else if ( count < 2 ) {
return ~ position ;
}
int minutes = FormatUtils . parseTwoDigits ( text , position ) ;
if ( minutes > 59 ) {
return ~ position ;
}
offset += minutes * DateTimeConstants . MILLIS_PER_MINUTE ;
limit -= 2 ;
position += 2 ;
if ( limit <= 0 ) {
break parse;
}
if ( expectSeparators ) {
if ( text . charAt ( position ) != ':' ) {
break parse;
}
limit -- ;
position ++ ;
}
count = digitCount ( text , position , 2 ) ;
if ( count == 0 && ! expectSeparators ) {
break parse;
} else if ( count < 2 ) {
return ~ position ;
}
int seconds = FormatUtils . parseTwoDigits ( text , position ) ;
if ( seconds > 59 ) {
return ~ position ;
}
offset += seconds * DateTimeConstants . MILLIS_PER_SECOND ;
limit -= 2 ;
position += 2 ;
if ( limit <= 0 ) {
break parse;
}
if ( expectSeparators ) {
if ( text . charAt ( position ) != '.' && text . charAt ( position ) != ',' ) {
break parse;
}
limit -- ;
position ++ ;
}
count = digitCount ( text , position , 3 ) ;
if ( count == 0 && ! expectSeparators ) {
break parse;
} else if ( count < 1 ) {
return ~ position ;
}
offset += ( text . charAt ( position ++ ) - '0' ) * 100 ;
if ( count > 1 ) {
offset += ( text . charAt ( position ++ ) - '0' ) * 10 ;
if ( count > 2 ) {
offset += text . charAt ( position ++ ) - '0' ;
}
}
}
bucket . setOffset ( Integer . valueOf ( negative ? - offset : offset ) ) ;
return position ;
}
private int digitCount ( CharSequence text , int position , int amount ) {
int limit = Math . min ( text . length () - position , amount ) ;
amount = 0 ;
for (; limit > 0 ; limit -- ) {
char c = text . charAt ( position + amount ) ;
if ( c < '0' || c > '9' ) {
break;
}
amount ++ ;
}
return amount ;
}
public int estimatePrintedLength () {
return ( iType == SHORT_NAME ? 4 : 20 ) ;
}
public void printTo (
Appendable appendable , long instant , Chronology chrono ,
int displayOffset , DateTimeZone displayZone , Locale locale ) throws IOException {
appendable . append ( print ( instant - displayOffset , displayZone , locale ) ) ;
}
private String print ( long instant , DateTimeZone displayZone , Locale locale ) {
if ( displayZone == null ) {
return lr_19 ;
}
switch ( iType ) {
case LONG_NAME :
return displayZone . getName ( instant , locale ) ;
case SHORT_NAME :
return displayZone . getShortName ( instant , locale ) ;
}
return lr_19 ;
}
public void printTo ( Appendable appendable , ReadablePartial partial , Locale locale ) throws IOException {
}
public int estimateParsedLength () {
return ( iType == SHORT_NAME ? 4 : 20 ) ;
}
public int parseInto ( DateTimeParserBucket bucket , CharSequence text , int position ) {
Map < String , DateTimeZone > parseLookup = iParseLookup ;
parseLookup = ( parseLookup != null ? parseLookup : DateTimeUtils . getDefaultTimeZoneNames () ) ;
String matched = null ;
for ( String name : parseLookup . keySet () ) {
if ( csStartsWith ( text , position , name ) ) {
if ( matched == null || name . length () > matched . length () ) {
matched = name ;
}
}
}
if ( matched != null ) {
bucket . setZone ( parseLookup . get ( matched ) ) ;
return position + matched . length () ;
}
return ~ position ;
}
public int estimatePrintedLength () {
return MAX_LENGTH ;
}
public void printTo (
Appendable appendable , long instant , Chronology chrono ,
int displayOffset , DateTimeZone displayZone , Locale locale ) throws IOException {
appendable . append ( displayZone != null ? displayZone . getID () : lr_19 ) ;
}
public void printTo ( Appendable appendable , ReadablePartial partial , Locale locale ) throws IOException {
}
public int estimateParsedLength () {
return MAX_LENGTH ;
}
public int parseInto ( DateTimeParserBucket bucket , CharSequence text , int position ) {
List < String > suffixSet = BASE_GROUPED_IDS ;
int textLen = text . length () ;
int matchLen = Math . min ( textLen , position + MAX_PREFIX_LENGTH ) ;
int pos = position ;
String prefix = lr_19 ;
for ( int i = pos ; i < matchLen ; i ++ ) {
if ( text . charAt ( i ) == '/' ) {
prefix = text . subSequence ( pos , i + 1 ) . toString () ;
pos += prefix . length () ;
String prefixLookup = prefix ;
if ( i < textLen ) {
prefixLookup += text . charAt ( i + 1 ) ;
}
suffixSet = GROUPED_IDS . get ( prefixLookup ) ;
if ( suffixSet == null ) {
return ~ position ;
}
break;
}
}
String best = null ;
for ( int i = 0 ; i < suffixSet . size () ; i ++ ) {
String suffix = suffixSet . get ( i ) ;
if ( csStartsWith ( text , pos , suffix ) ) {
if ( best == null || suffix . length () > best . length () ) {
best = suffix ;
}
}
}
if ( best != null ) {
bucket . setZone ( DateTimeZone . forID ( prefix + best ) ) ;
return pos + best . length () ;
}
return ~ position ;
}
public int estimatePrintedLength () {
return iPrintedLengthEstimate ;
}
public void printTo (
Appendable appendable , long instant , Chronology chrono ,
int displayOffset , DateTimeZone displayZone , Locale locale ) throws IOException {
InternalPrinter [] elements = iPrinters ;
if ( elements == null ) {
throw new UnsupportedOperationException () ;
}
if ( locale == null ) {
locale = Locale . getDefault () ;
}
int len = elements . length ;
for ( int i = 0 ; i < len ; i ++ ) {
elements [ i ] . printTo ( appendable , instant , chrono , displayOffset , displayZone , locale ) ;
}
}
public void printTo ( Appendable appendable , ReadablePartial partial , Locale locale ) throws IOException {
InternalPrinter [] elements = iPrinters ;
if ( elements == null ) {
throw new UnsupportedOperationException () ;
}
if ( locale == null ) {
locale = Locale . getDefault () ;
}
int len = elements . length ;
for ( int i = 0 ; i < len ; i ++ ) {
elements [ i ] . printTo ( appendable , partial , locale ) ;
}
}
public int estimateParsedLength () {
return iParsedLengthEstimate ;
}
public int parseInto ( DateTimeParserBucket bucket , CharSequence text , int position ) {
InternalParser [] elements = iParsers ;
if ( elements == null ) {
throw new UnsupportedOperationException () ;
}
int len = elements . length ;
for ( int i = 0 ; i < len && position >= 0 ; i ++ ) {
position = elements [ i ] . parseInto ( bucket , text , position ) ;
}
return position ;
}
boolean isPrinter () {
return iPrinters != null ;
}
boolean isParser () {
return iParsers != null ;
}
private void decompose ( List < Object > elementPairs , List < Object > printerList , List < Object > parserList ) {
int size = elementPairs . size () ;
for ( int i = 0 ; i < size ; i += 2 ) {
Object element = elementPairs . get ( i ) ;
if ( element instanceof Composite ) {
addArrayToList ( printerList , ( ( Composite ) element ) . iPrinters ) ;
} else {
printerList . add ( element ) ;
}
element = elementPairs . get ( i + 1 ) ;
if ( element instanceof Composite ) {
addArrayToList ( parserList , ( ( Composite ) element ) . iParsers ) ;
} else {
parserList . add ( element ) ;
}
}
}
private void addArrayToList ( List < Object > list , Object [] array ) {
if ( array != null ) {
for ( int i = 0 ; i < array . length ; i ++ ) {
list . add ( array [ i ] ) ;
}
}
}
public int estimateParsedLength () {
return iParsedLengthEstimate ;
}
public int parseInto ( DateTimeParserBucket bucket , CharSequence text , int position ) {
InternalParser [] parsers = iParsers ;
int length = parsers . length ;
final Object originalState = bucket . saveState () ;
boolean isOptional = false ;
int bestValidPos = position ;
Object bestValidState = null ;
int bestInvalidPos = position ;
for ( int i = 0 ; i < length ; i ++ ) {
InternalParser parser = parsers [ i ] ;
if ( parser == null ) {
if ( bestValidPos <= position ) {
return position ;
}
isOptional = true ;
break;
}
int parsePos = parser . parseInto ( bucket , text , position ) ;
if ( parsePos >= position ) {
if ( parsePos > bestValidPos ) {
if ( parsePos >= text . length () ||
( i + 1 ) >= length || parsers [ i + 1 ] == null ) {
return parsePos ;
}
bestValidPos = parsePos ;
bestValidState = bucket . saveState () ;
}
} else {
if ( parsePos < 0 ) {
parsePos = ~ parsePos ;
if ( parsePos > bestInvalidPos ) {
bestInvalidPos = parsePos ;
}
}
}
bucket . restoreState ( originalState ) ;
}
if ( bestValidPos > position || ( bestValidPos == position && isOptional ) ) {
if ( bestValidState != null ) {
bucket . restoreState ( bestValidState ) ;
}
return bestValidPos ;
}
return ~ bestInvalidPos ;
}
static boolean csStartsWith ( CharSequence text , int position , String search ) {
int searchLen = search . length () ;
if ( ( text . length () - position ) < searchLen ) {
return false ;
}
for ( int i = 0 ; i < searchLen ; i ++ ) {
if ( text . charAt ( position + i ) != search . charAt ( i ) ) {
return false ;
}
}
return true ;
}
static boolean csStartsWithIgnoreCase ( CharSequence text , int position , String search ) {
int searchLen = search . length () ;
if ( ( text . length () - position ) < searchLen ) {
return false ;
}
for ( int i = 0 ; i < searchLen ; i ++ ) {
char ch1 = text . charAt ( position + i ) ;
char ch2 = search . charAt ( i ) ;
if ( ch1 != ch2 ) {
char u1 = Character . toUpperCase ( ch1 ) ;
char u2 = Character . toUpperCase ( ch2 ) ;
if ( u1 != u2 && Character . toLowerCase ( u1 ) != Character . toLowerCase ( u2 ) ) {
return false ;
}
}
}
return true ;
}

public boolean isPrinter () {
return ( iPrinter != null ) ;
}
public DateTimePrinter getPrinter () {
return InternalPrinterDateTimePrinter . of ( iPrinter ) ;
}
InternalPrinter getPrinter0 () {
return iPrinter ;
}
public boolean isParser () {
return ( iParser != null ) ;
}
public DateTimeParser getParser () {
return InternalParserDateTimeParser . of ( iParser ) ;
}
InternalParser getParser0 () {
return iParser ;
}
public DateTimeFormatter withLocale ( Locale locale ) {
if ( locale == getLocale () || ( locale != null && locale . equals ( getLocale () ) ) ) {
return this ;
}
return new DateTimeFormatter ( iPrinter , iParser , locale ,
iOffsetParsed , iChrono , iZone , iPivotYear , iDefaultYear ) ;
}
public Locale getLocale () {
return iLocale ;
}
public DateTimeFormatter withOffsetParsed () {
if ( iOffsetParsed == true ) {
return this ;
}
return new DateTimeFormatter ( iPrinter , iParser , iLocale ,
true , iChrono , null , iPivotYear , iDefaultYear ) ;
}
public boolean isOffsetParsed () {
return iOffsetParsed ;
}
public DateTimeFormatter withChronology ( Chronology chrono ) {
if ( iChrono == chrono ) {
return this ;
}
return new DateTimeFormatter ( iPrinter , iParser , iLocale ,
iOffsetParsed , chrono , iZone , iPivotYear , iDefaultYear ) ;
}
public Chronology getChronology () {
return iChrono ;
}
@Deprecated
public Chronology getChronolgy () {
return iChrono ;
}
public DateTimeFormatter withZoneUTC () {
return withZone ( DateTimeZone . UTC ) ;
}
public DateTimeFormatter withZone ( DateTimeZone zone ) {
if ( iZone == zone ) {
return this ;
}
return new DateTimeFormatter ( iPrinter , iParser , iLocale ,
false , iChrono , zone , iPivotYear , iDefaultYear ) ;
}
public DateTimeZone getZone () {
return iZone ;
}
public DateTimeFormatter withPivotYear ( Integer pivotYear ) {
if ( iPivotYear == pivotYear || ( iPivotYear != null && iPivotYear . equals ( pivotYear ) ) ) {
return this ;
}
return new DateTimeFormatter ( iPrinter , iParser , iLocale ,
iOffsetParsed , iChrono , iZone , pivotYear , iDefaultYear ) ;
}
public DateTimeFormatter withPivotYear ( int pivotYear ) {
return withPivotYear ( Integer . valueOf ( pivotYear ) ) ;
}
public Integer getPivotYear () {
return iPivotYear ;
}
public DateTimeFormatter withDefaultYear ( int defaultYear ) {
return new DateTimeFormatter ( iPrinter , iParser , iLocale ,
iOffsetParsed , iChrono , iZone , iPivotYear , defaultYear ) ;
}
public int getDefaultYear () {
return iDefaultYear ;
}
public void printTo ( StringBuffer buf , ReadableInstant instant ) {
try {
printTo ( ( Appendable ) buf , instant ) ;
} catch ( IOException ex ) {
}
}
public void printTo ( StringBuilder buf , ReadableInstant instant ) {
try {
printTo ( ( Appendable ) buf , instant ) ;
} catch ( IOException ex ) {
}
}
public void printTo ( Writer out , ReadableInstant instant ) throws IOException {
printTo ( ( Appendable ) out , instant ) ;
}
public void printTo ( Appendable appendable , ReadableInstant instant ) throws IOException {
long millis = DateTimeUtils . getInstantMillis ( instant ) ;
Chronology chrono = DateTimeUtils . getInstantChronology ( instant ) ;
printTo ( appendable , millis , chrono ) ;
}
public void printTo ( StringBuffer buf , long instant ) {
try {
printTo ( ( Appendable ) buf , instant ) ;
} catch ( IOException ex ) {
}
}
public void printTo ( StringBuilder buf , long instant ) {
try {
printTo ( ( Appendable ) buf , instant ) ;
} catch ( IOException ex ) {
}
}
public void printTo ( Writer out , long instant ) throws IOException {
printTo ( ( Appendable ) out , instant ) ;
}
public void printTo ( Appendable appendable , long instant ) throws IOException {
printTo ( appendable , instant , null ) ;
}
public void printTo ( StringBuffer buf , ReadablePartial partial ) {
try {
printTo ( ( Appendable ) buf , partial ) ;
} catch ( IOException ex ) {
}
}
public void printTo ( StringBuilder buf , ReadablePartial partial ) {
try {
printTo ( ( Appendable ) buf , partial ) ;
} catch ( IOException ex ) {
}
}
public void printTo ( Writer out , ReadablePartial partial ) throws IOException {
printTo ( ( Appendable ) out , partial ) ;
}
public void printTo ( Appendable appendable , ReadablePartial partial ) throws IOException {
InternalPrinter printer = requirePrinter () ;
if ( partial == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
printer . printTo ( appendable , partial , iLocale ) ;
}
public String print ( ReadableInstant instant ) {
StringBuilder buf = new StringBuilder ( requirePrinter () . estimatePrintedLength () ) ;
try {
printTo ( ( Appendable ) buf , instant ) ;
} catch ( IOException ex ) {
}
return buf . toString () ;
}
public String print ( long instant ) {
StringBuilder buf = new StringBuilder ( requirePrinter () . estimatePrintedLength () ) ;
try {
printTo ( ( Appendable ) buf , instant ) ;
} catch ( IOException ex ) {
}
return buf . toString () ;
}
public String print ( ReadablePartial partial ) {
StringBuilder buf = new StringBuilder ( requirePrinter () . estimatePrintedLength () ) ;
try {
printTo ( ( Appendable ) buf , partial ) ;
} catch ( IOException ex ) {
}
return buf . toString () ;
}
private void printTo ( Appendable appendable , long instant , Chronology chrono ) throws IOException {
InternalPrinter printer = requirePrinter () ;
chrono = selectChronology ( chrono ) ;
DateTimeZone zone = chrono . getZone () ;
int offset = zone . getOffset ( instant ) ;
long adjustedInstant = instant + offset ;
if ( ( instant ^ adjustedInstant ) < 0 && ( instant ^ offset ) >= 0 ) {
zone = DateTimeZone . UTC ;
offset = 0 ;
adjustedInstant = instant ;
}
printer . printTo ( appendable , adjustedInstant , chrono . withUTC () , offset , zone , iLocale ) ;
}
private InternalPrinter requirePrinter () {
InternalPrinter printer = iPrinter ;
if ( printer == null ) {
throw new UnsupportedOperationException ( lr_2 ) ;
}
return printer ;
}
public int parseInto ( ReadWritableInstant instant , String text , int position ) {
InternalParser parser = requireParser () ;
if ( instant == null ) {
throw new IllegalArgumentException ( lr_3 ) ;
}
long instantMillis = instant . getMillis () ;
Chronology chrono = instant . getChronology () ;
int defaultYear = DateTimeUtils . getChronology ( chrono ) . year () . get ( instantMillis ) ;
long instantLocal = instantMillis + chrono . getZone () . getOffset ( instantMillis ) ;
chrono = selectChronology ( chrono ) ;
DateTimeParserBucket bucket = new DateTimeParserBucket (
instantLocal , chrono , iLocale , iPivotYear , defaultYear ) ;
int newPos = parser . parseInto ( bucket , text , position ) ;
instant . setMillis ( bucket . computeMillis ( false , text ) ) ;
if ( iOffsetParsed && bucket . getOffsetInteger () != null ) {
int parsedOffset = bucket . getOffsetInteger () ;
DateTimeZone parsedZone = DateTimeZone . forOffsetMillis ( parsedOffset ) ;
chrono = chrono . withZone ( parsedZone ) ;
} else if ( bucket . getZone () != null ) {
chrono = chrono . withZone ( bucket . getZone () ) ;
}
instant . setChronology ( chrono ) ;
if ( iZone != null ) {
instant . setZone ( iZone ) ;
}
return newPos ;
}
public long parseMillis ( String text ) {
InternalParser parser = requireParser () ;
Chronology chrono = selectChronology ( iChrono ) ;
DateTimeParserBucket bucket = new DateTimeParserBucket ( 0 , chrono , iLocale , iPivotYear , iDefaultYear ) ;
return bucket . doParseMillis ( parser , text ) ;
}
public LocalDate parseLocalDate ( String text ) {
return parseLocalDateTime ( text ) . toLocalDate () ;
}
public LocalTime parseLocalTime ( String text ) {
return parseLocalDateTime ( text ) . toLocalTime () ;
}
public LocalDateTime parseLocalDateTime ( String text ) {
InternalParser parser = requireParser () ;
Chronology chrono = selectChronology ( null ) . withUTC () ;
DateTimeParserBucket bucket = new DateTimeParserBucket ( 0 , chrono , iLocale , iPivotYear , iDefaultYear ) ;
int newPos = parser . parseInto ( bucket , text , 0 ) ;
if ( newPos >= 0 ) {
if ( newPos >= text . length () ) {
long millis = bucket . computeMillis ( true , text ) ;
if ( bucket . getOffsetInteger () != null ) {
int parsedOffset = bucket . getOffsetInteger () ;
DateTimeZone parsedZone = DateTimeZone . forOffsetMillis ( parsedOffset ) ;
chrono = chrono . withZone ( parsedZone ) ;
} else if ( bucket . getZone () != null ) {
chrono = chrono . withZone ( bucket . getZone () ) ;
}
return new LocalDateTime ( millis , chrono ) ;
}
} else {
newPos = ~ newPos ;
}
throw new IllegalArgumentException ( FormatUtils . createErrorMessage ( text , newPos ) ) ;
}
public DateTime parseDateTime ( String text ) {
InternalParser parser = requireParser () ;
Chronology chrono = selectChronology ( null ) ;
DateTimeParserBucket bucket = new DateTimeParserBucket ( 0 , chrono , iLocale , iPivotYear , iDefaultYear ) ;
int newPos = parser . parseInto ( bucket , text , 0 ) ;
if ( newPos >= 0 ) {
if ( newPos >= text . length () ) {
long millis = bucket . computeMillis ( true , text ) ;
if ( iOffsetParsed && bucket . getOffsetInteger () != null ) {
int parsedOffset = bucket . getOffsetInteger () ;
DateTimeZone parsedZone = DateTimeZone . forOffsetMillis ( parsedOffset ) ;
chrono = chrono . withZone ( parsedZone ) ;
} else if ( bucket . getZone () != null ) {
chrono = chrono . withZone ( bucket . getZone () ) ;
}
DateTime dt = new DateTime ( millis , chrono ) ;
if ( iZone != null ) {
dt = dt . withZone ( iZone ) ;
}
return dt ;
}
} else {
newPos = ~ newPos ;
}
throw new IllegalArgumentException ( FormatUtils . createErrorMessage ( text , newPos ) ) ;
}
public MutableDateTime parseMutableDateTime ( String text ) {
InternalParser parser = requireParser () ;
Chronology chrono = selectChronology ( null ) ;
DateTimeParserBucket bucket = new DateTimeParserBucket ( 0 , chrono , iLocale , iPivotYear , iDefaultYear ) ;
int newPos = parser . parseInto ( bucket , text , 0 ) ;
if ( newPos >= 0 ) {
if ( newPos >= text . length () ) {
long millis = bucket . computeMillis ( true , text ) ;
if ( iOffsetParsed && bucket . getOffsetInteger () != null ) {
int parsedOffset = bucket . getOffsetInteger () ;
DateTimeZone parsedZone = DateTimeZone . forOffsetMillis ( parsedOffset ) ;
chrono = chrono . withZone ( parsedZone ) ;
} else if ( bucket . getZone () != null ) {
chrono = chrono . withZone ( bucket . getZone () ) ;
}
MutableDateTime dt = new MutableDateTime ( millis , chrono ) ;
if ( iZone != null ) {
dt . setZone ( iZone ) ;
}
return dt ;
}
} else {
newPos = ~ newPos ;
}
throw new IllegalArgumentException ( FormatUtils . createErrorMessage ( text , newPos ) ) ;
}
private InternalParser requireParser () {
InternalParser parser = iParser ;
if ( parser == null ) {
throw new UnsupportedOperationException ( lr_4 ) ;
}
return parser ;
}
private Chronology selectChronology ( Chronology chrono ) {
chrono = DateTimeUtils . getChronology ( chrono ) ;
if ( iChrono != null ) {
chrono = iChrono ;
}
if ( iZone != null ) {
chrono = chrono . withZone ( iZone ) ;
}
return chrono ;
}

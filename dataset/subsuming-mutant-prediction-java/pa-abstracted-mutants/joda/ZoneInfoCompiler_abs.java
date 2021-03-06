public static void main ( String [] args ) throws Exception {
if ( args . length == 0 ) {
printUsage () ;
return;
}
File inputDir = null ;
File outputDir = null ;
boolean verbose = false ;
int i ;
for ( i = 0 ; i < args . length ; i ++ ) {
try {
if ( lr_1 . equals ( args [ i ] ) ) {
inputDir = new File ( args [ ++ i ] ) ;
} else if ( lr_2 . equals ( args [ i ] ) ) {
outputDir = new File ( args [ ++ i ] ) ;
} else if ( lr_3 . equals ( args [ i ] ) ) {
verbose = true ;
} else if ( lr_4 . equals ( args [ i ] ) ) {
printUsage () ;
return;
} else {
break;
}
} catch ( IndexOutOfBoundsException e ) {
printUsage () ;
return;
}
}
if ( i >= args . length ) {
printUsage () ;
return;
}
File [] sources = new File [ args . length - i ] ;
for ( int j = 0 ; i < args . length ; i ++ , j ++ ) {
sources [ j ] = inputDir == null ? new File ( args [ i ] ) : new File ( inputDir , args [ i ] ) ;
}
ZoneInfoLogger . set ( verbose ) ;
ZoneInfoCompiler zic = new ZoneInfoCompiler () ;
zic . compile ( outputDir , sources ) ;
}
private static void printUsage () {
System . out . println ( lr_5 ) ;
System . out . println ( lr_6 ) ;
System . out . println ( lr_7 ) ;
System . out . println ( lr_8 ) ;
System . out . println ( lr_9 ) ;
}
static DateTimeOfYear getStartOfYear () {
if ( cStartOfYear == null ) {
cStartOfYear = new DateTimeOfYear () ;
}
return cStartOfYear ;
}
static Chronology getLenientISOChronology () {
if ( cLenientISO == null ) {
cLenientISO = LenientChronology . getInstance ( ISOChronology . getInstanceUTC () ) ;
}
return cLenientISO ;
}
static void writeZoneInfoMap ( DataOutputStream dout , Map < String , DateTimeZone > zimap ) throws IOException {
if ( dout == null ) {
throw new IllegalArgumentException ( lr_10 ) ;
}
Map < String , Short > idToIndex = new HashMap < String , Short > ( zimap . size () ) ;
TreeMap < Short , String > indexToId = new TreeMap < Short , String > () ;
short count = 0 ;
for ( Entry < String , DateTimeZone > entry : zimap . entrySet () ) {
String id = ( String ) entry . getKey () ;
if ( ! idToIndex . containsKey ( id ) ) {
Short index = Short . valueOf ( count ) ;
idToIndex . put ( id , index ) ;
indexToId . put ( index , id ) ;
if ( ++ count == 0 ) {
throw new InternalError ( lr_11 ) ;
}
}
id = ( ( DateTimeZone ) entry . getValue () ) . getID () ;
if ( ! idToIndex . containsKey ( id ) ) {
Short index = Short . valueOf ( count ) ;
idToIndex . put ( id , index ) ;
indexToId . put ( index , id ) ;
if ( ++ count == 0 ) {
throw new InternalError ( lr_11 ) ;
}
}
}
dout . writeShort ( indexToId . size () ) ;
for ( String id : indexToId . values () ) {
dout . writeUTF ( id ) ;
}
dout . writeShort ( zimap . size () ) ;
for ( Entry < String , DateTimeZone > entry : zimap . entrySet () ) {
String id = entry . getKey () ;
dout . writeShort ( idToIndex . get ( id ) . shortValue () ) ;
id = entry . getValue () . getID () ;
dout . writeShort ( idToIndex . get ( id ) . shortValue () ) ;
}
}
static int parseYear ( String str , int def ) {
str = str . toLowerCase ( Locale . ENGLISH ) ;
if ( str . equals ( lr_12 ) || str . equals ( lr_13 ) ) {
return Integer . MIN_VALUE ;
} else if ( str . equals ( lr_14 ) || str . equals ( lr_15 ) ) {
return Integer . MAX_VALUE ;
} else if ( str . equals ( lr_16 ) ) {
return def ;
}
return Integer . parseInt ( str ) ;
}
static int parseMonth ( String str ) {
DateTimeField field = ISOChronology . getInstanceUTC () . monthOfYear () ;
return field . get ( field . set ( 0 , str , Locale . ENGLISH ) ) ;
}
static int parseDayOfWeek ( String str ) {
DateTimeField field = ISOChronology . getInstanceUTC () . dayOfWeek () ;
return field . get ( field . set ( 0 , str , Locale . ENGLISH ) ) ;
}
static String parseOptional ( String str ) {
return ( str . equals ( lr_17 ) ) ? null : str ;
}
static int parseTime ( String str ) {
DateTimeFormatter p = ISODateTimeFormat . hourMinuteSecondFraction () ;
MutableDateTime mdt = new MutableDateTime ( 0 , getLenientISOChronology () ) ;
int pos = 0 ;
if ( str . startsWith ( lr_17 ) ) {
pos = 1 ;
}
int newPos = p . parseInto ( mdt , str , pos ) ;
if ( newPos == ~ pos ) {
throw new IllegalArgumentException ( str ) ;
}
int millis = ( int ) mdt . getMillis () ;
if ( pos == 1 ) {
millis = - millis ;
}
return millis ;
}
static char parseZoneChar ( char c ) {
switch ( c ) {
case 's' : case 'S' :
return 's' ;
case 'u' : case 'U' : case 'g' : case 'G' : case 'z' : case 'Z' :
return 'u' ;
case 'w' : case 'W' : default:
return 'w' ;
}
}
static boolean test ( String id , DateTimeZone tz ) {
if ( ! id . equals ( tz . getID () ) ) {
return true ;
}
long millis = ISOChronology . getInstanceUTC () . year () . set ( 0 , 1850 ) ;
long end = ISOChronology . getInstanceUTC () . year () . set ( 0 , 2050 ) ;
int offset = tz . getOffset ( millis ) ;
int stdOffset = tz . getStandardOffset ( millis ) ;
String key = tz . getNameKey ( millis ) ;
List < Long > transitions = new ArrayList < Long > () ;
while ( true ) {
long next = tz . nextTransition ( millis ) ;
if ( next == millis || next > end ) {
break;
}
millis = next ;
int nextOffset = tz . getOffset ( millis ) ;
int nextStdOffset = tz . getStandardOffset ( millis ) ;
String nextKey = tz . getNameKey ( millis ) ;
if ( offset == nextOffset && stdOffset == nextStdOffset && key . equals ( nextKey ) ) {
System . out . println ( lr_18 + tz . getID () + lr_19
+ new DateTime ( millis ,
ISOChronology . getInstanceUTC () ) ) ;
return false ;
}
if ( nextKey == null || ( nextKey . length () < 3 && ! lr_20 . equals ( nextKey ) ) ) {
System . out . println ( lr_21 + tz . getID () + lr_19
+ new DateTime ( millis ,
ISOChronology . getInstanceUTC () )
+ lr_22 + nextKey ) ;
return false ;
}
transitions . add ( Long . valueOf ( millis ) ) ;
offset = nextOffset ;
key = nextKey ;
}
millis = ISOChronology . getInstanceUTC () . year () . set ( 0 , 2050 ) ;
end = ISOChronology . getInstanceUTC () . year () . set ( 0 , 1850 ) ;
for ( int i = transitions . size () ; -- i >= 0 ; ) {
long prev = tz . previousTransition ( millis ) ;
if ( prev == millis || prev < end ) {
break;
}
millis = prev ;
long trans = transitions . get ( i ) . longValue () ;
if ( trans - 1 != millis ) {
System . out . println ( lr_23 + tz . getID () + lr_19
+ new DateTime ( millis ,
ISOChronology . getInstanceUTC () ) + lr_24
+ new DateTime ( trans - 1 ,
ISOChronology . getInstanceUTC () ) ) ;
return false ;
}
}
return true ;
}
public Map < String , DateTimeZone > compile ( File outputDir , File [] sources ) throws IOException {
if ( sources != null ) {
for ( int i = 0 ; i < sources . length ; i ++ ) {
BufferedReader in = null ;
try {
in = new BufferedReader ( new FileReader ( sources [ i ] ) ) ;
parseDataFile ( in , lr_25 . equals ( sources [ i ] . getName () ) ) ;
} finally {
if ( in != null ) {
in . close () ;
}
}
}
}
if ( outputDir != null ) {
if ( ! outputDir . exists () && ! outputDir . mkdirs () ) {
throw new IOException ( lr_26 + outputDir ) ;
}
if ( ! outputDir . isDirectory () ) {
throw new IOException ( lr_27 + outputDir ) ;
}
}
Map < String , DateTimeZone > map = new TreeMap < String , DateTimeZone > () ;
Map < String , Zone > sourceMap = new TreeMap < String , Zone > () ;
System . out . println ( lr_28 ) ;
for ( int i = 0 ; i < iZones . size () ; i ++ ) {
Zone zone = iZones . get ( i ) ;
DateTimeZoneBuilder builder = new DateTimeZoneBuilder () ;
zone . addToBuilder ( builder , iRuleSets ) ;
DateTimeZone tz = builder . toDateTimeZone ( zone . iName , true ) ;
if ( test ( tz . getID () , tz ) ) {
map . put ( tz . getID () , tz ) ;
sourceMap . put ( tz . getID () , zone ) ;
if ( outputDir != null ) {
writeZone ( outputDir , builder , tz ) ;
}
}
}
for ( int i = 0 ; i < iGoodLinks . size () ; i += 2 ) {
String baseId = iGoodLinks . get ( i ) ;
String alias = iGoodLinks . get ( i + 1 ) ;
Zone sourceZone = sourceMap . get ( baseId ) ;
if ( sourceZone == null ) {
System . out . println ( lr_29 + baseId + lr_30 + alias + lr_31 ) ;
} else {
DateTimeZoneBuilder builder = new DateTimeZoneBuilder () ;
sourceZone . addToBuilder ( builder , iRuleSets ) ;
DateTimeZone revived = builder . toDateTimeZone ( alias , true ) ;
if ( test ( revived . getID () , revived ) ) {
map . put ( revived . getID () , revived ) ;
if ( outputDir != null ) {
writeZone ( outputDir , builder , revived ) ;
}
}
map . put ( revived . getID () , revived ) ;
if ( ZoneInfoLogger . verbose () ) {
System . out . println ( lr_32 + alias + lr_33 + baseId + lr_34 ) ;
}
}
}
for ( int pass = 0 ; pass < 2 ; pass ++ ) {
for ( int i = 0 ; i < iBackLinks . size () ; i += 2 ) {
String id = iBackLinks . get ( i ) ;
String alias = iBackLinks . get ( i + 1 ) ;
DateTimeZone tz = map . get ( id ) ;
if ( tz == null ) {
if ( pass > 0 ) {
System . out . println ( lr_35 + id + lr_30 + alias + lr_31 ) ;
}
} else {
map . put ( alias , tz ) ;
if ( ZoneInfoLogger . verbose () ) {
System . out . println ( lr_36 + alias + lr_33 + tz . getID () ) ;
}
}
}
}
if ( outputDir != null ) {
System . out . println ( lr_37 ) ;
File file = new File ( outputDir , lr_38 ) ;
if ( ! file . getParentFile () . exists () ) {
file . getParentFile () . mkdirs () ;
}
OutputStream out = new FileOutputStream ( file ) ;
DataOutputStream dout = new DataOutputStream ( out ) ;
try {
Map < String , DateTimeZone > zimap = new TreeMap < String , DateTimeZone > ( String . CASE_INSENSITIVE_ORDER ) ;
zimap . putAll ( map ) ;
writeZoneInfoMap ( dout , zimap ) ;
} finally {
dout . close () ;
}
}
return map ;
}
private void writeZone ( File outputDir , DateTimeZoneBuilder builder , DateTimeZone tz ) throws IOException {
if ( ZoneInfoLogger . verbose () ) {
System . out . println ( lr_39 + tz . getID () ) ;
}
File file = new File ( outputDir , tz . getID () ) ;
if ( ! file . getParentFile () . exists () ) {
file . getParentFile () . mkdirs () ;
}
OutputStream out = new FileOutputStream ( file ) ;
try {
builder . writeTo ( tz . getID () , out ) ;
} finally {
out . close () ;
}
InputStream in = new FileInputStream ( file ) ;
DateTimeZone tz2 = DateTimeZoneBuilder . readFrom ( in , tz . getID () ) ;
in . close () ;
if ( ! tz . equals ( tz2 ) ) {
System . out . println ( lr_40 + tz . getID () +
lr_41 ) ;
}
}
public void parseDataFile ( BufferedReader in , boolean backward ) throws IOException {
Zone zone = null ;
String line ;
while ( ( line = in . readLine () ) != null ) {
String trimmed = line . trim () ;
if ( trimmed . length () == 0 || trimmed . charAt ( 0 ) == '#' ) {
continue;
}
int index = line . indexOf ( '#' ) ;
if ( index >= 0 ) {
line = line . substring ( 0 , index ) ;
}
StringTokenizer st = new StringTokenizer ( line , lr_42 ) ;
if ( Character . isWhitespace ( line . charAt ( 0 ) ) && st . hasMoreTokens () ) {
if ( zone != null ) {
zone . chain ( st ) ;
}
continue;
} else {
if ( zone != null ) {
iZones . add ( zone ) ;
}
zone = null ;
}
if ( st . hasMoreTokens () ) {
String token = st . nextToken () ;
if ( token . equalsIgnoreCase ( lr_43 ) ) {
Rule r = new Rule ( st ) ;
RuleSet rs = iRuleSets . get ( r . iName ) ;
if ( rs == null ) {
rs = new RuleSet ( r ) ;
iRuleSets . put ( r . iName , rs ) ;
} else {
rs . addRule ( r ) ;
}
} else if ( token . equalsIgnoreCase ( lr_44 ) ) {
if ( st . countTokens () < 4 ) {
throw new IllegalArgumentException ( lr_45 ) ;
}
zone = new Zone ( st ) ;
} else if ( token . equalsIgnoreCase ( lr_46 ) ) {
String real = st . nextToken () ;
String alias = st . nextToken () ;
if ( backward || alias . equals ( lr_47 ) || alias . startsWith ( lr_48 ) || alias . equals ( lr_49 ) ) {
iBackLinks . add ( real ) ;
iBackLinks . add ( alias ) ;
} else {
iGoodLinks . add ( real ) ;
iGoodLinks . add ( alias ) ;
}
} else {
System . out . println ( lr_50 + line ) ;
}
}
}
if ( zone != null ) {
iZones . add ( zone ) ;
}
}
public void addRecurring ( DateTimeZoneBuilder builder , String nameKey ,
int saveMillis , int fromYear , int toYear )
{
builder . addRecurringSavings ( nameKey , saveMillis ,
fromYear , toYear ,
iZoneChar ,
iMonthOfYear ,
iDayOfMonth ,
iDayOfWeek ,
iAdvanceDayOfWeek ,
iMillisOfDay ) ;
}
public void addCutover ( DateTimeZoneBuilder builder , int year ) {
builder . addCutover ( year ,
iZoneChar ,
iMonthOfYear ,
iDayOfMonth ,
iDayOfWeek ,
iAdvanceDayOfWeek ,
iMillisOfDay ) ;
}
public String toString () {
return
lr_51 + iMonthOfYear + lr_52 +
lr_53 + iDayOfMonth + lr_52 +
lr_54 + iDayOfWeek + lr_52 +
lr_55 + iAdvanceDayOfWeek + lr_52 +
lr_56 + iMillisOfDay + lr_52 +
lr_57 + iZoneChar + lr_52 ;
}
public void addRecurring ( DateTimeZoneBuilder builder , int negativeSave , String nameFormat ) {
int saveMillis = iSaveMillis + - negativeSave ;
String nameKey = formatName ( nameFormat , saveMillis , iLetterS ) ;
iDateTimeOfYear . addRecurring ( builder , nameKey , saveMillis , iFromYear , iToYear ) ;
}
private static String formatName ( String nameFormat , int saveMillis , String letterS ) {
int index = nameFormat . indexOf ( '/' ) ;
if ( index > 0 ) {
if ( saveMillis == 0 ) {
return nameFormat . substring ( 0 , index ) . intern () ;
} else {
return nameFormat . substring ( index + 1 ) . intern () ;
}
}
index = nameFormat . indexOf ( lr_58 ) ;
if ( index < 0 ) {
return nameFormat ;
}
String left = nameFormat . substring ( 0 , index ) ;
String right = nameFormat . substring ( index + 2 ) ;
String name ;
if ( letterS == null ) {
name = left . concat ( right ) ;
} else {
name = left + letterS + right ;
}
return name . intern () ;
}
public String toString () {
return
lr_59 +
lr_60 + iName + lr_52 +
lr_61 + iFromYear + lr_52 +
lr_62 + iToYear + lr_52 +
lr_63 + iType + lr_52 +
iDateTimeOfYear +
lr_64 + iSaveMillis + lr_52 +
lr_65 + iLetterS + lr_52 ;
}
void addRule ( Rule rule ) {
if ( ! ( rule . iName . equals ( iRules . get ( 0 ) . iName ) ) ) {
throw new IllegalArgumentException ( lr_66 ) ;
}
iRules . add ( rule ) ;
}
public void addRecurring ( DateTimeZoneBuilder builder , int standardMillis , String nameFormat ) {
int negativeSave = 0 ;
for ( int i = 0 ; i < iRules . size () ; i ++ ) {
Rule rule = iRules . get ( i ) ;
if ( rule . iSaveMillis < 0 ) {
negativeSave = Math . min ( negativeSave , rule . iSaveMillis ) ;
}
}
if ( negativeSave < 0 ) {
System . out . println ( lr_67 + iRules . get ( 0 ) . iName + lr_68 ) ;
standardMillis += negativeSave ;
int slashPos = nameFormat . indexOf ( lr_69 ) ;
if ( slashPos > 0 ) {
nameFormat = nameFormat . substring ( slashPos + 1 ) + lr_69 + nameFormat . substring ( 0 , slashPos ) ;
}
}
builder . setStandardOffset ( standardMillis ) ;
if ( negativeSave < 0 ) {
Rule rule = new Rule ( iRules . get ( 0 ) ) ;
rule . addRecurring ( builder , negativeSave , nameFormat ) ;
}
for ( int i = 0 ; i < iRules . size () ; i ++ ) {
Rule rule = iRules . get ( i ) ;
rule . addRecurring ( builder , negativeSave , nameFormat ) ;
}
}
void chain ( StringTokenizer st ) {
if ( iNext != null ) {
iNext . chain ( st ) ;
} else {
iNext = new Zone ( iName , st ) ;
}
}
public void addToBuilder ( DateTimeZoneBuilder builder , Map < String , RuleSet > ruleSets ) {
addToBuilder ( this , builder , ruleSets ) ;
}
private static void addToBuilder ( Zone zone ,
DateTimeZoneBuilder builder ,
Map < String , RuleSet > ruleSets )
{
for (; zone != null ; zone = zone . iNext ) {
if ( zone . iRules == null ) {
builder . setStandardOffset ( zone . iOffsetMillis ) ;
builder . setFixedSavings ( zone . iFormat , 0 ) ;
} else {
try {
int saveMillis = parseTime ( zone . iRules ) ;
builder . setStandardOffset ( zone . iOffsetMillis ) ;
builder . setFixedSavings ( zone . iFormat , saveMillis ) ;
}
catch ( Exception e ) {
RuleSet rs = ruleSets . get ( zone . iRules ) ;
if ( rs == null ) {
throw new IllegalArgumentException
( lr_70 + zone . iRules ) ;
}
rs . addRecurring ( builder , zone . iOffsetMillis , zone . iFormat ) ;
}
}
if ( zone . iUntilYear == Integer . MAX_VALUE ) {
break;
}
zone . iUntilDateTimeOfYear . addCutover ( builder , zone . iUntilYear ) ;
}
}
public String toString () {
String str =
lr_71 +
lr_60 + iName + lr_52 +
lr_72 + iOffsetMillis + lr_52 +
lr_73 + iRules + lr_52 +
lr_74 + iFormat + lr_52 +
lr_75 + iUntilYear + lr_52 +
iUntilDateTimeOfYear ;
if ( iNext == null ) {
return str ;
}
return str + lr_76 + iNext . toString () ;
}

public static DateTimeZone getDefault () {
DateTimeZone zone = cDefault . get () ;
if ( zone == null ) {
try {
try {
String id = System . getProperty ( lr_1 ) ;
if ( id != null ) {
zone = forID ( id ) ;
}
} catch ( RuntimeException ex ) {
}
if ( zone == null ) {
zone = forTimeZone ( TimeZone . getDefault () ) ;
}
} catch ( IllegalArgumentException ex ) {
}
if ( zone == null ) {
zone = UTC ;
}
if ( ! cDefault . compareAndSet ( null , zone ) ) {
zone = cDefault . get () ;
}
}
return zone ;
}
public static void setDefault ( DateTimeZone zone ) throws SecurityException {
SecurityManager sm = System . getSecurityManager () ;
if ( sm != null ) {
sm . checkPermission ( new JodaTimePermission ( lr_2 ) ) ;
}
if ( zone == null ) {
throw new IllegalArgumentException ( lr_3 ) ;
}
cDefault . set ( zone ) ;
}
@FromString
public static DateTimeZone forID ( String id ) {
if ( id == null ) {
return getDefault () ;
}
if ( id . equals ( lr_4 ) ) {
return DateTimeZone . UTC ;
}
DateTimeZone zone = getProvider () . getZone ( id ) ;
if ( zone != null ) {
return zone ;
}
if ( id . startsWith ( lr_5 ) || id . startsWith ( lr_6 ) ) {
int offset = parseOffset ( id ) ;
if ( offset == 0L ) {
return DateTimeZone . UTC ;
} else {
id = printOffset ( offset ) ;
return fixedOffsetZone ( id , offset ) ;
}
}
throw new IllegalArgumentException ( lr_7 + id + lr_8 ) ;
}
public static DateTimeZone forOffsetHours ( int hoursOffset ) throws IllegalArgumentException {
return forOffsetHoursMinutes ( hoursOffset , 0 ) ;
}
public static DateTimeZone forOffsetHoursMinutes ( int hoursOffset , int minutesOffset ) throws IllegalArgumentException {
if ( hoursOffset == 0 && minutesOffset == 0 ) {
return DateTimeZone . UTC ;
}
if ( hoursOffset < - 23 || hoursOffset > 23 ) {
throw new IllegalArgumentException ( lr_9 + hoursOffset ) ;
}
if ( minutesOffset < - 59 || minutesOffset > 59 ) {
throw new IllegalArgumentException ( lr_10 + minutesOffset ) ;
}
if ( hoursOffset > 0 && minutesOffset < 0 ) {
throw new IllegalArgumentException ( lr_11 + minutesOffset ) ;
}
int offset = 0 ;
try {
int hoursInMinutes = hoursOffset * 60 ;
if ( hoursInMinutes < 0 ) {
minutesOffset = hoursInMinutes - Math . abs ( minutesOffset ) ;
} else {
minutesOffset = hoursInMinutes + minutesOffset ;
}
offset = FieldUtils . safeMultiply ( minutesOffset , DateTimeConstants . MILLIS_PER_MINUTE ) ;
} catch ( ArithmeticException ex ) {
throw new IllegalArgumentException ( lr_12 ) ;
}
return forOffsetMillis ( offset ) ;
}
public static DateTimeZone forOffsetMillis ( int millisOffset ) {
if ( millisOffset < - MAX_MILLIS || millisOffset > MAX_MILLIS ) {
throw new IllegalArgumentException ( lr_13 + millisOffset ) ;
}
String id = printOffset ( millisOffset ) ;
return fixedOffsetZone ( id , millisOffset ) ;
}
public static DateTimeZone forTimeZone ( TimeZone zone ) {
if ( zone == null ) {
return getDefault () ;
}
final String id = zone . getID () ;
if ( id == null ) {
throw new IllegalArgumentException ( lr_14 ) ;
}
if ( id . equals ( lr_4 ) ) {
return DateTimeZone . UTC ;
}
DateTimeZone dtz = null ;
String convId = getConvertedId ( id ) ;
Provider provider = getProvider () ;
if ( convId != null ) {
dtz = provider . getZone ( convId ) ;
}
if ( dtz == null ) {
dtz = provider . getZone ( id ) ;
}
if ( dtz != null ) {
return dtz ;
}
if ( convId == null ) {
convId = id ;
if ( convId . startsWith ( lr_15 ) || convId . startsWith ( lr_16 ) ) {
convId = convId . substring ( 3 ) ;
if ( convId . length () > 2 ) {
char firstDigit = convId . charAt ( 1 ) ;
if ( firstDigit > '9' && Character . isDigit ( firstDigit ) ) {
convId = convertToAsciiNumber ( convId ) ;
}
}
int offset = parseOffset ( convId ) ;
if ( offset == 0L ) {
return DateTimeZone . UTC ;
} else {
convId = printOffset ( offset ) ;
return fixedOffsetZone ( convId , offset ) ;
}
}
}
throw new IllegalArgumentException ( lr_7 + id + lr_8 ) ;
}
private static String convertToAsciiNumber ( String convId ) {
StringBuilder buf = new StringBuilder ( convId ) ;
for ( int i = 0 ; i < buf . length () ; i ++ ) {
char ch = buf . charAt ( i ) ;
int digit = Character . digit ( ch , 10 ) ;
if ( digit >= 0 ) {
buf . setCharAt ( i , (char) ( '0' + digit ) ) ;
}
}
return buf . toString () ;
}
private static DateTimeZone fixedOffsetZone ( String id , int offset ) {
if ( offset == 0 ) {
return DateTimeZone . UTC ;
}
return new FixedDateTimeZone ( id , null , offset , offset ) ;
}
public static Set < String > getAvailableIDs () {
return getProvider () . getAvailableIDs () ;
}
public static Provider getProvider () {
Provider provider = cProvider . get () ;
if ( provider == null ) {
provider = getDefaultProvider () ;
if ( ! cProvider . compareAndSet ( null , provider ) ) {
provider = cProvider . get () ;
}
}
return provider ;
}
public static void setProvider ( Provider provider ) throws SecurityException {
SecurityManager sm = System . getSecurityManager () ;
if ( sm != null ) {
sm . checkPermission ( new JodaTimePermission ( lr_17 ) ) ;
}
if ( provider == null ) {
provider = getDefaultProvider () ;
} else {
validateProvider ( provider ) ;
}
cProvider . set ( provider ) ;
}
private static Provider validateProvider ( Provider provider ) {
Set < String > ids = provider . getAvailableIDs () ;
if ( ids == null || ids . size () == 0 ) {
throw new IllegalArgumentException ( lr_18 ) ;
}
if ( ! ids . contains ( lr_4 ) ) {
throw new IllegalArgumentException ( lr_19 ) ;
}
if ( ! UTC . equals ( provider . getZone ( lr_4 ) ) ) {
throw new IllegalArgumentException ( lr_20 ) ;
}
return provider ;
}
private static Provider getDefaultProvider () {
try {
String providerClass = System . getProperty ( lr_21 ) ;
if ( providerClass != null ) {
try {
Class < ? > cls = Class . forName ( providerClass , false , DateTimeZone . class . getClassLoader () ) ;
if ( ! Provider . class . isAssignableFrom ( cls ) ) {
throw new IllegalArgumentException ( lr_22 + Provider . class ) ;
}
Provider provider = cls . asSubclass ( Provider . class ) . getConstructor () . newInstance () ;
return validateProvider ( provider ) ;
} catch ( Exception ex ) {
throw new RuntimeException ( ex ) ;
}
}
} catch ( SecurityException ex ) {
}
try {
String dataFolder = System . getProperty ( lr_23 ) ;
if ( dataFolder != null ) {
try {
Provider provider = new ZoneInfoProvider ( new File ( dataFolder ) ) ;
return validateProvider ( provider ) ;
} catch ( Exception ex ) {
throw new RuntimeException ( ex ) ;
}
}
} catch ( SecurityException ex ) {
}
try {
Provider provider = new ZoneInfoProvider ( DEFAULT_TZ_DATA_PATH ) ;
return validateProvider ( provider ) ;
} catch ( Exception ex ) {
ex . printStackTrace () ;
}
return new UTCProvider () ;
}
public static NameProvider getNameProvider () {
NameProvider nameProvider = cNameProvider . get () ;
if ( nameProvider == null ) {
nameProvider = getDefaultNameProvider () ;
if ( ! cNameProvider . compareAndSet ( null , nameProvider ) ) {
nameProvider = cNameProvider . get () ;
}
}
return nameProvider ;
}
public static void setNameProvider ( NameProvider nameProvider ) throws SecurityException {
SecurityManager sm = System . getSecurityManager () ;
if ( sm != null ) {
sm . checkPermission ( new JodaTimePermission ( lr_24 ) ) ;
}
if ( nameProvider == null ) {
nameProvider = getDefaultNameProvider () ;
}
cNameProvider . set ( nameProvider ) ;
}
private static NameProvider getDefaultNameProvider () {
NameProvider nameProvider = null ;
try {
String providerClass = System . getProperty ( lr_25 ) ;
if ( providerClass != null ) {
try {
Class < ? > cls = Class . forName ( providerClass , false , DateTimeZone . class . getClassLoader () ) ;
if ( ! NameProvider . class . isAssignableFrom ( cls ) ) {
throw new IllegalArgumentException ( lr_22 + NameProvider . class ) ;
}
nameProvider = cls . asSubclass ( NameProvider . class ) . getConstructor () . newInstance () ;
} catch ( Exception ex ) {
throw new RuntimeException ( ex ) ;
}
}
} catch ( SecurityException ex ) {
}
if ( nameProvider == null ) {
nameProvider = new DefaultNameProvider () ;
}
return nameProvider ;
}
private static String getConvertedId ( String id ) {
return LazyInit . CONVERSION_MAP . get ( id ) ;
}
private static int parseOffset ( String str ) {
return - ( int ) LazyInit . OFFSET_FORMATTER . parseMillis ( str ) ;
}
private static String printOffset ( int offset ) {
StringBuffer buf = new StringBuffer () ;
if ( offset >= 0 ) {
buf . append ( '+' ) ;
} else {
buf . append ( '-' ) ;
offset = - offset ;
}
int hours = offset / DateTimeConstants . MILLIS_PER_HOUR ;
FormatUtils . appendPaddedInteger ( buf , hours , 2 ) ;
offset -= hours * ( int ) DateTimeConstants . MILLIS_PER_HOUR ;
int minutes = offset / DateTimeConstants . MILLIS_PER_MINUTE ;
buf . append ( ':' ) ;
FormatUtils . appendPaddedInteger ( buf , minutes , 2 ) ;
offset -= minutes * DateTimeConstants . MILLIS_PER_MINUTE ;
if ( offset == 0 ) {
return buf . toString () ;
}
int seconds = offset / DateTimeConstants . MILLIS_PER_SECOND ;
buf . append ( ':' ) ;
FormatUtils . appendPaddedInteger ( buf , seconds , 2 ) ;
offset -= seconds * DateTimeConstants . MILLIS_PER_SECOND ;
if ( offset == 0 ) {
return buf . toString () ;
}
buf . append ( '.' ) ;
FormatUtils . appendPaddedInteger ( buf , offset , 3 ) ;
return buf . toString () ;
}
@ToString
public final String getID () {
return iID ;
}
public final String getShortName ( long instant ) {
return getShortName ( instant , null ) ;
}
public String getShortName ( long instant , Locale locale ) {
if ( locale == null ) {
locale = Locale . getDefault () ;
}
String nameKey = getNameKey ( instant ) ;
if ( nameKey == null ) {
return iID ;
}
String name ;
NameProvider np = getNameProvider () ;
if ( np instanceof DefaultNameProvider ) {
name = ( ( DefaultNameProvider ) np ) . getShortName ( locale , iID , nameKey , isStandardOffset ( instant ) ) ;
} else {
name = np . getShortName ( locale , iID , nameKey ) ;
}
if ( name != null ) {
return name ;
}
return printOffset ( getOffset ( instant ) ) ;
}
public final String getName ( long instant ) {
return getName ( instant , null ) ;
}
public String getName ( long instant , Locale locale ) {
if ( locale == null ) {
locale = Locale . getDefault () ;
}
String nameKey = getNameKey ( instant ) ;
if ( nameKey == null ) {
return iID ;
}
String name ;
NameProvider np = getNameProvider () ;
if ( np instanceof DefaultNameProvider ) {
name = ( ( DefaultNameProvider ) np ) . getName ( locale , iID , nameKey , isStandardOffset ( instant ) ) ;
} else {
name = np . getName ( locale , iID , nameKey ) ;
}
if ( name != null ) {
return name ;
}
return printOffset ( getOffset ( instant ) ) ;
}
public final int getOffset ( ReadableInstant instant ) {
if ( instant == null ) {
return getOffset ( DateTimeUtils . currentTimeMillis () ) ;
}
return getOffset ( instant . getMillis () ) ;
}
public boolean isStandardOffset ( long instant ) {
return getOffset ( instant ) == getStandardOffset ( instant ) ;
}
public int getOffsetFromLocal ( long instantLocal ) {
final int offsetLocal = getOffset ( instantLocal ) ;
final long instantAdjusted = instantLocal - offsetLocal ;
final int offsetAdjusted = getOffset ( instantAdjusted ) ;
if ( offsetLocal != offsetAdjusted ) {
if ( ( offsetLocal - offsetAdjusted ) < 0 ) {
long nextLocal = nextTransition ( instantAdjusted ) ;
if ( nextLocal == ( instantLocal - offsetLocal ) ) {
nextLocal = Long . MAX_VALUE ;
}
long nextAdjusted = nextTransition ( instantLocal - offsetAdjusted ) ;
if ( nextAdjusted == ( instantLocal - offsetAdjusted ) ) {
nextAdjusted = Long . MAX_VALUE ;
}
if ( nextLocal != nextAdjusted ) {
return offsetLocal ;
}
}
} else if ( offsetLocal >= 0 ) {
long prev = previousTransition ( instantAdjusted ) ;
if ( prev < instantAdjusted ) {
int offsetPrev = getOffset ( prev ) ;
int diff = offsetPrev - offsetLocal ;
if ( instantAdjusted - prev <= diff ) {
return offsetPrev ;
}
}
}
return offsetAdjusted ;
}
public long convertUTCToLocal ( long instantUTC ) {
int offset = getOffset ( instantUTC ) ;
long instantLocal = instantUTC + offset ;
if ( ( instantUTC ^ instantLocal ) < 0 && ( instantUTC ^ offset ) >= 0 ) {
throw new ArithmeticException ( lr_26 ) ;
}
return instantLocal ;
}
public long convertLocalToUTC ( long instantLocal , boolean strict , long originalInstantUTC ) {
int offsetOriginal = getOffset ( originalInstantUTC ) ;
long instantUTC = instantLocal - offsetOriginal ;
int offsetLocalFromOriginal = getOffset ( instantUTC ) ;
if ( offsetLocalFromOriginal == offsetOriginal ) {
return instantUTC ;
}
return convertLocalToUTC ( instantLocal , strict ) ;
}
public long convertLocalToUTC ( long instantLocal , boolean strict ) {
int offsetLocal = getOffset ( instantLocal ) ;
int offset = getOffset ( instantLocal - offsetLocal ) ;
if ( offsetLocal != offset ) {
if ( strict || offsetLocal < 0 ) {
long nextLocal = nextTransition ( instantLocal - offsetLocal ) ;
if ( nextLocal == ( instantLocal - offsetLocal ) ) {
nextLocal = Long . MAX_VALUE ;
}
long nextAdjusted = nextTransition ( instantLocal - offset ) ;
if ( nextAdjusted == ( instantLocal - offset ) ) {
nextAdjusted = Long . MAX_VALUE ;
}
if ( nextLocal != nextAdjusted ) {
if ( strict ) {
throw new IllegalInstantException ( instantLocal , getID () ) ;
} else {
offset = offsetLocal ;
}
}
}
}
long instantUTC = instantLocal - offset ;
if ( ( instantLocal ^ instantUTC ) < 0 && ( instantLocal ^ offset ) < 0 ) {
throw new ArithmeticException ( lr_27 ) ;
}
return instantUTC ;
}
public long getMillisKeepLocal ( DateTimeZone newZone , long oldInstant ) {
if ( newZone == null ) {
newZone = DateTimeZone . getDefault () ;
}
if ( newZone == this ) {
return oldInstant ;
}
long instantLocal = convertUTCToLocal ( oldInstant ) ;
return newZone . convertLocalToUTC ( instantLocal , false , oldInstant ) ;
}
public boolean isLocalDateTimeGap ( LocalDateTime localDateTime ) {
if ( isFixed () ) {
return false ;
}
try {
localDateTime . toDateTime ( this ) ;
return false ;
} catch ( IllegalInstantException ex ) {
return true ;
}
}
public long adjustOffset ( long instant , boolean earlierOrLater ) {
long instantBefore = instant - 3 * DateTimeConstants . MILLIS_PER_HOUR ;
long instantAfter = instant + 3 * DateTimeConstants . MILLIS_PER_HOUR ;
long offsetBefore = getOffset ( instantBefore ) ;
long offsetAfter = getOffset ( instantAfter ) ;
if ( offsetBefore <= offsetAfter ) {
return instant ;
}
long diff = offsetBefore - offsetAfter ;
long transition = nextTransition ( instantBefore ) ;
long overlapStart = transition - diff ;
long overlapEnd = transition + diff ;
if ( instant < overlapStart || instant >= overlapEnd ) {
return instant ;
}
long afterStart = instant - overlapStart ;
if ( afterStart >= diff ) {
return earlierOrLater ? instant : instant - diff ;
} else {
return earlierOrLater ? instant + diff : instant ;
}
}
public java . util . TimeZone toTimeZone () {
return java . util . TimeZone . getTimeZone ( iID ) ;
}
public int hashCode () {
return 57 + getID () . hashCode () ;
}
public String toString () {
return getID () ;
}
protected Object writeReplace () throws ObjectStreamException {
return new Stub ( iID ) ;
}
private void writeObject ( ObjectOutputStream out ) throws IOException {
out . writeUTF ( iID ) ;
}
private void readObject ( ObjectInputStream in ) throws IOException {
iID = in . readUTF () ;
}
private Object readResolve () throws ObjectStreamException {
return forID ( iID ) ;
}
public DateTimeZone getZone () {
return null ;
}
public Chronology withUTC () {
return this ;
}
public Chronology withZone ( DateTimeZone zone ) {
return this ;
}
public String toString () {
return getClass () . getName () ;
}
private static Map < String , String > buildMap () {
Map < String , String > map = new HashMap < String , String > () ;
map . put ( lr_28 , lr_4 ) ;
map . put ( lr_29 , lr_29 ) ;
map . put ( lr_30 , lr_30 ) ;
map . put ( lr_31 , lr_30 ) ;
map . put ( lr_32 , lr_30 ) ;
map . put ( lr_33 , lr_33 ) ;
map . put ( lr_34 , lr_35 ) ;
map . put ( lr_36 , lr_37 ) ;
map . put ( lr_38 , lr_39 ) ;
map . put ( lr_40 , lr_41 ) ;
map . put ( lr_42 , lr_43 ) ;
map . put ( lr_44 , lr_45 ) ;
map . put ( lr_46 , lr_47 ) ;
map . put ( lr_48 , lr_49 ) ;
map . put ( lr_50 , lr_51 ) ;
map . put ( lr_52 , lr_53 ) ;
map . put ( lr_54 , lr_55 ) ;
map . put ( lr_56 , lr_57 ) ;
map . put ( lr_58 , lr_59 ) ;
map . put ( lr_60 , lr_61 ) ;
map . put ( lr_62 , lr_63 ) ;
map . put ( lr_64 , lr_65 ) ;
map . put ( lr_66 , lr_67 ) ;
map . put ( lr_68 , lr_69 ) ;
map . put ( lr_70 , lr_71 ) ;
map . put ( lr_72 , lr_73 ) ;
map . put ( lr_74 , lr_75 ) ;
map . put ( lr_76 , lr_77 ) ;
map . put ( lr_78 , lr_79 ) ;
map . put ( lr_80 , lr_81 ) ;
map . put ( lr_82 , lr_83 ) ;
map . put ( lr_84 , lr_85 ) ;
map . put ( lr_86 , lr_87 ) ;
return Collections . unmodifiableMap ( map ) ;
}

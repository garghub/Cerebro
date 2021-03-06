public static final long currentTimeMillis () {
return cMillisProvider . getMillis () ;
}
public static final void setCurrentMillisSystem () throws SecurityException {
checkPermission () ;
cMillisProvider = SYSTEM_MILLIS_PROVIDER ;
}
public static final void setCurrentMillisFixed ( long fixedMillis ) throws SecurityException {
checkPermission () ;
cMillisProvider = new FixedMillisProvider ( fixedMillis ) ;
}
public static final void setCurrentMillisOffset ( long offsetMillis ) throws SecurityException {
checkPermission () ;
if ( offsetMillis == 0 ) {
cMillisProvider = SYSTEM_MILLIS_PROVIDER ;
} else {
cMillisProvider = new OffsetMillisProvider ( offsetMillis ) ;
}
}
public static final void setCurrentMillisProvider ( MillisProvider millisProvider ) throws SecurityException {
if ( millisProvider == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
checkPermission () ;
cMillisProvider = millisProvider ;
}
private static void checkPermission () throws SecurityException {
SecurityManager sm = System . getSecurityManager () ;
if ( sm != null ) {
sm . checkPermission ( new JodaTimePermission ( lr_2 ) ) ;
}
}
public static final long getInstantMillis ( ReadableInstant instant ) {
if ( instant == null ) {
return DateTimeUtils . currentTimeMillis () ;
}
return instant . getMillis () ;
}
public static final Chronology getInstantChronology ( ReadableInstant instant ) {
if ( instant == null ) {
return ISOChronology . getInstance () ;
}
Chronology chrono = instant . getChronology () ;
if ( chrono == null ) {
return ISOChronology . getInstance () ;
}
return chrono ;
}
public static final Chronology getIntervalChronology ( ReadableInstant start , ReadableInstant end ) {
Chronology chrono = null ;
if ( start != null ) {
chrono = start . getChronology () ;
} else if ( end != null ) {
chrono = end . getChronology () ;
}
if ( chrono == null ) {
chrono = ISOChronology . getInstance () ;
}
return chrono ;
}
public static final Chronology getIntervalChronology ( ReadableInterval interval ) {
if ( interval == null ) {
return ISOChronology . getInstance () ;
}
Chronology chrono = interval . getChronology () ;
if ( chrono == null ) {
return ISOChronology . getInstance () ;
}
return chrono ;
}
public static final ReadableInterval getReadableInterval ( ReadableInterval interval ) {
if ( interval == null ) {
long now = DateTimeUtils . currentTimeMillis () ;
interval = new Interval ( now , now ) ;
}
return interval ;
}
public static final Chronology getChronology ( Chronology chrono ) {
if ( chrono == null ) {
return ISOChronology . getInstance () ;
}
return chrono ;
}
public static final DateTimeZone getZone ( DateTimeZone zone ) {
if ( zone == null ) {
return DateTimeZone . getDefault () ;
}
return zone ;
}
public static final PeriodType getPeriodType ( PeriodType type ) {
if ( type == null ) {
return PeriodType . standard () ;
}
return type ;
}
public static final long getDurationMillis ( ReadableDuration duration ) {
if ( duration == null ) {
return 0L ;
}
return duration . getMillis () ;
}
public static final boolean isContiguous ( ReadablePartial partial ) {
if ( partial == null ) {
throw new IllegalArgumentException ( lr_3 ) ;
}
DurationFieldType lastType = null ;
for ( int i = 0 ; i < partial . size () ; i ++ ) {
DateTimeField loopField = partial . getField ( i ) ;
if ( i > 0 ) {
if ( loopField . getRangeDurationField () == null || loopField . getRangeDurationField () . getType () != lastType ) {
return false ;
}
}
lastType = loopField . getDurationField () . getType () ;
}
return true ;
}
public static final DateFormatSymbols getDateFormatSymbols ( Locale locale ) {
try {
Method method = DateFormatSymbols . class . getMethod ( lr_4 , new Class [] { Locale . class } ) ;
return ( DateFormatSymbols ) method . invoke ( null , new Object [] { locale } ) ;
} catch ( Exception ex ) {
return new DateFormatSymbols ( locale ) ;
}
}
public static final Map < String , DateTimeZone > getDefaultTimeZoneNames () {
Map < String , DateTimeZone > names = cZoneNames . get () ;
if ( names == null ) {
names = buildDefaultTimeZoneNames () ;
if ( ! cZoneNames . compareAndSet ( null , names ) ) {
names = cZoneNames . get () ;
}
}
return names ;
}
public static final void setDefaultTimeZoneNames ( Map < String , DateTimeZone > names ) {
cZoneNames . set ( Collections . unmodifiableMap ( new HashMap < String , DateTimeZone > ( names ) ) ) ;
}
private static Map < String , DateTimeZone > buildDefaultTimeZoneNames () {
Map < String , DateTimeZone > map = new LinkedHashMap < String , DateTimeZone > () ;
map . put ( lr_5 , DateTimeZone . UTC ) ;
map . put ( lr_6 , DateTimeZone . UTC ) ;
map . put ( lr_7 , DateTimeZone . UTC ) ;
put ( map , lr_8 , lr_9 ) ;
put ( map , lr_10 , lr_9 ) ;
put ( map , lr_11 , lr_12 ) ;
put ( map , lr_13 , lr_12 ) ;
put ( map , lr_14 , lr_15 ) ;
put ( map , lr_16 , lr_15 ) ;
put ( map , lr_17 , lr_18 ) ;
put ( map , lr_19 , lr_18 ) ;
return Collections . unmodifiableMap ( map ) ;
}
private static void put ( Map < String , DateTimeZone > map , String name , String id ) {
try {
map . put ( name , DateTimeZone . forID ( id ) ) ;
} catch ( RuntimeException ex ) {
}
}
public static final double toJulianDay ( long epochMillis ) {
double epochDay = epochMillis / 86400000d ;
return epochDay + 2440587.5d ;
}
public static final long toJulianDayNumber ( long epochMillis ) {
return ( long ) Math . floor ( toJulianDay ( epochMillis ) + 0.5d ) ;
}
public static final long fromJulianDay ( double julianDay ) {
double epochDay = julianDay - 2440587.5d ;
return (long) ( epochDay * 86400000d ) ;
}
public long getMillis () {
return System . currentTimeMillis () ;
}
public long getMillis () {
return iMillis ;
}
public long getMillis () {
return System . currentTimeMillis () + iMillis ;
}

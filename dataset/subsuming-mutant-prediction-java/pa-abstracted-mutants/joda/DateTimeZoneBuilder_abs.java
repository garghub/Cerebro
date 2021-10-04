public static DateTimeZone readFrom ( InputStream in , String id ) throws IOException {
if ( in instanceof DataInput ) {
return readFrom ( ( DataInput ) in , id ) ;
} else {
return readFrom ( ( DataInput ) new DataInputStream ( in ) , id ) ;
}
}
public static DateTimeZone readFrom ( DataInput in , String id ) throws IOException {
switch ( in . readUnsignedByte () ) {
case 'F' :
DateTimeZone fixed = new FixedDateTimeZone
( id , in . readUTF () , ( int ) readMillis ( in ) , ( int ) readMillis ( in ) ) ;
if ( fixed . equals ( DateTimeZone . UTC ) ) {
fixed = DateTimeZone . UTC ;
}
return fixed ;
case 'C' :
return CachedDateTimeZone . forZone ( PrecalculatedZone . readFrom ( in , id ) ) ;
case 'P' :
return PrecalculatedZone . readFrom ( in , id ) ;
default:
throw new IOException ( lr_1 ) ;
}
}
static void writeMillis ( DataOutput out , long millis ) throws IOException {
if ( millis % ( 30 * 60000L ) == 0 ) {
long units = millis / ( 30 * 60000L ) ;
if ( ( ( units << ( 64 - 6 ) ) >> ( 64 - 6 ) ) == units ) {
out . writeByte ( (int)( units & 0x3f ) ) ;
return;
}
}
if ( millis % 60000L == 0 ) {
long minutes = millis / 60000L ;
if ( ( ( minutes << ( 64 - 30 ) ) >> ( 64 - 30 ) ) == minutes ) {
out . writeInt ( 0x40000000 | (int)( minutes & 0x3fffffff ) ) ;
return;
}
}
if ( millis % 1000L == 0 ) {
long seconds = millis / 1000L ;
if ( ( ( seconds << ( 64 - 38 ) ) >> ( 64 - 38 ) ) == seconds ) {
out . writeByte ( 0x80 | (int)( ( seconds >> 32 ) & 0x3f ) ) ;
out . writeInt ( (int)( seconds & 0xffffffff ) ) ;
return;
}
}
out . writeByte ( millis < 0 ? 0xff : 0xc0 ) ;
out . writeLong ( millis ) ;
}
static long readMillis ( DataInput in ) throws IOException {
int v = in . readUnsignedByte () ;
switch ( v >> 6 ) {
case 0 : default:
v = ( v << ( 32 - 6 ) ) >> ( 32 - 6 ) ;
return v * ( 30 * 60000L ) ;
case 1 :
v = ( v << ( 32 - 6 ) ) >> ( 32 - 30 ) ;
v |= ( in . readUnsignedByte () ) << 16 ;
v |= ( in . readUnsignedByte () ) << 8 ;
v |= ( in . readUnsignedByte () ) ;
return v * 60000L ;
case 2 :
long w = ( ( ( long ) v ) << ( 64 - 6 ) ) >> ( 64 - 38 ) ;
w |= ( in . readUnsignedByte () ) << 24 ;
w |= ( in . readUnsignedByte () ) << 16 ;
w |= ( in . readUnsignedByte () ) << 8 ;
w |= ( in . readUnsignedByte () ) ;
return w * 1000L ;
case 3 :
return in . readLong () ;
}
}
private static DateTimeZone buildFixedZone ( String id , String nameKey ,
int wallOffset , int standardOffset ) {
if ( lr_2 . equals ( id ) && id . equals ( nameKey ) &&
wallOffset == 0 && standardOffset == 0 ) {
return DateTimeZone . UTC ;
}
return new FixedDateTimeZone ( id , nameKey , wallOffset , standardOffset ) ;
}
public DateTimeZoneBuilder addCutover ( int year ,
char mode ,
int monthOfYear ,
int dayOfMonth ,
int dayOfWeek ,
boolean advanceDayOfWeek ,
int millisOfDay )
{
if ( iRuleSets . size () > 0 ) {
OfYear ofYear = new OfYear
( mode , monthOfYear , dayOfMonth , dayOfWeek , advanceDayOfWeek , millisOfDay ) ;
RuleSet lastRuleSet = iRuleSets . get ( iRuleSets . size () - 1 ) ;
lastRuleSet . setUpperLimit ( year , ofYear ) ;
}
iRuleSets . add ( new RuleSet () ) ;
return this ;
}
public DateTimeZoneBuilder setStandardOffset ( int standardOffset ) {
getLastRuleSet () . setStandardOffset ( standardOffset ) ;
return this ;
}
public DateTimeZoneBuilder setFixedSavings ( String nameKey , int saveMillis ) {
getLastRuleSet () . setFixedSavings ( nameKey , saveMillis ) ;
return this ;
}
public DateTimeZoneBuilder addRecurringSavings ( String nameKey , int saveMillis ,
int fromYear , int toYear ,
char mode ,
int monthOfYear ,
int dayOfMonth ,
int dayOfWeek ,
boolean advanceDayOfWeek ,
int millisOfDay )
{
if ( fromYear <= toYear ) {
OfYear ofYear = new OfYear
( mode , monthOfYear , dayOfMonth , dayOfWeek , advanceDayOfWeek , millisOfDay ) ;
Recurrence recurrence = new Recurrence ( ofYear , nameKey , saveMillis ) ;
Rule rule = new Rule ( recurrence , fromYear , toYear ) ;
getLastRuleSet () . addRule ( rule ) ;
}
return this ;
}
private RuleSet getLastRuleSet () {
if ( iRuleSets . size () == 0 ) {
addCutover ( Integer . MIN_VALUE , 'w' , 1 , 1 , 0 , false , 0 ) ;
}
return iRuleSets . get ( iRuleSets . size () - 1 ) ;
}
public DateTimeZone toDateTimeZone ( String id , boolean outputID ) {
if ( id == null ) {
throw new IllegalArgumentException () ;
}
ArrayList < Transition > transitions = new ArrayList < Transition > () ;
DSTZone tailZone = null ;
long millis = Long . MIN_VALUE ;
int saveMillis = 0 ;
int ruleSetCount = iRuleSets . size () ;
for ( int i = 0 ; i < ruleSetCount ; i ++ ) {
RuleSet rs = iRuleSets . get ( i ) ;
Transition next = rs . firstTransition ( millis ) ;
if ( next == null ) {
continue;
}
addTransition ( transitions , next ) ;
millis = next . getMillis () ;
saveMillis = next . getSaveMillis () ;
rs = new RuleSet ( rs ) ;
while ( ( next = rs . nextTransition ( millis , saveMillis ) ) != null ) {
if ( addTransition ( transitions , next ) && tailZone != null ) {
break;
}
millis = next . getMillis () ;
saveMillis = next . getSaveMillis () ;
if ( tailZone == null && i == ruleSetCount - 1 ) {
tailZone = rs . buildTailZone ( id ) ;
}
}
millis = rs . getUpperLimit ( saveMillis ) ;
}
if ( transitions . size () == 0 ) {
if ( tailZone != null ) {
return tailZone ;
}
return buildFixedZone ( id , lr_2 , 0 , 0 ) ;
}
if ( transitions . size () == 1 && tailZone == null ) {
Transition tr = transitions . get ( 0 ) ;
return buildFixedZone ( id , tr . getNameKey () ,
tr . getWallOffset () , tr . getStandardOffset () ) ;
}
PrecalculatedZone zone = PrecalculatedZone . create ( id , outputID , transitions , tailZone ) ;
if ( zone . isCachable () ) {
return CachedDateTimeZone . forZone ( zone ) ;
}
return zone ;
}
private boolean addTransition ( ArrayList < Transition > transitions , Transition tr ) {
int size = transitions . size () ;
if ( size == 0 ) {
transitions . add ( tr ) ;
return true ;
}
Transition last = transitions . get ( size - 1 ) ;
if ( ! tr . isTransitionFrom ( last ) ) {
return false ;
}
int offsetForLast = 0 ;
if ( size >= 2 ) {
offsetForLast = transitions . get ( size - 2 ) . getWallOffset () ;
}
int offsetForNew = last . getWallOffset () ;
long lastLocal = last . getMillis () + offsetForLast ;
long newLocal = tr . getMillis () + offsetForNew ;
if ( newLocal != lastLocal ) {
transitions . add ( tr ) ;
return true ;
}
Transition previous = transitions . remove ( size - 1 ) ;
Transition adjusted = tr . withMillis ( previous . getMillis () ) ;
return addTransition ( transitions , adjusted ) ;
}
public void writeTo ( String zoneID , OutputStream out ) throws IOException {
if ( out instanceof DataOutput ) {
writeTo ( zoneID , ( DataOutput ) out ) ;
} else {
DataOutputStream dout = new DataOutputStream ( out ) ;
writeTo ( zoneID , ( DataOutput ) dout ) ;
dout . flush () ;
}
}
public void writeTo ( String zoneID , DataOutput out ) throws IOException {
DateTimeZone zone = toDateTimeZone ( zoneID , false ) ;
if ( zone instanceof FixedDateTimeZone ) {
out . writeByte ( 'F' ) ;
out . writeUTF ( zone . getNameKey ( 0 ) ) ;
writeMillis ( out , zone . getOffset ( 0 ) ) ;
writeMillis ( out , zone . getStandardOffset ( 0 ) ) ;
} else {
if ( zone instanceof CachedDateTimeZone ) {
out . writeByte ( 'C' ) ;
zone = ( ( CachedDateTimeZone ) zone ) . getUncachedZone () ;
} else {
out . writeByte ( 'P' ) ;
}
( ( PrecalculatedZone ) zone ) . writeTo ( out ) ;
}
}
static OfYear readFrom ( DataInput in ) throws IOException {
return new OfYear ( ( char ) in . readUnsignedByte () ,
( int ) in . readUnsignedByte () ,
( int ) in . readByte () ,
( int ) in . readUnsignedByte () ,
in . readBoolean () ,
( int ) readMillis ( in ) ) ;
}
public long setInstant ( int year , int standardOffset , int saveMillis ) {
int offset ;
if ( iMode == 'w' ) {
offset = standardOffset + saveMillis ;
} else if ( iMode == 's' ) {
offset = standardOffset ;
} else {
offset = 0 ;
}
Chronology chrono = ISOChronology . getInstanceUTC () ;
long millis = chrono . year () . set ( 0 , year ) ;
millis = chrono . monthOfYear () . set ( millis , iMonthOfYear ) ;
millis = chrono . millisOfDay () . set ( millis , iMillisOfDay ) ;
millis = setDayOfMonth ( chrono , millis ) ;
if ( iDayOfWeek != 0 ) {
millis = setDayOfWeek ( chrono , millis ) ;
}
return millis - offset ;
}
public long next ( long instant , int standardOffset , int saveMillis ) {
int offset ;
if ( iMode == 'w' ) {
offset = standardOffset + saveMillis ;
} else if ( iMode == 's' ) {
offset = standardOffset ;
} else {
offset = 0 ;
}
instant += offset ;
Chronology chrono = ISOChronology . getInstanceUTC () ;
long next = chrono . monthOfYear () . set ( instant , iMonthOfYear ) ;
next = chrono . millisOfDay () . set ( next , 0 ) ;
next = chrono . millisOfDay () . add ( next , iMillisOfDay ) ;
next = setDayOfMonthNext ( chrono , next ) ;
if ( iDayOfWeek == 0 ) {
if ( next <= instant ) {
next = chrono . year () . add ( next , 1 ) ;
next = setDayOfMonthNext ( chrono , next ) ;
}
} else {
next = setDayOfWeek ( chrono , next ) ;
if ( next <= instant ) {
next = chrono . year () . add ( next , 1 ) ;
next = chrono . monthOfYear () . set ( next , iMonthOfYear ) ;
next = setDayOfMonthNext ( chrono , next ) ;
next = setDayOfWeek ( chrono , next ) ;
}
}
next = chrono . millisOfDay () . set ( next , 0 ) ;
next = chrono . millisOfDay () . add ( next , iMillisOfDay ) ;
return next - offset ;
}
public long previous ( long instant , int standardOffset , int saveMillis ) {
int offset ;
if ( iMode == 'w' ) {
offset = standardOffset + saveMillis ;
} else if ( iMode == 's' ) {
offset = standardOffset ;
} else {
offset = 0 ;
}
instant += offset ;
Chronology chrono = ISOChronology . getInstanceUTC () ;
long prev = chrono . monthOfYear () . set ( instant , iMonthOfYear ) ;
prev = chrono . millisOfDay () . set ( prev , 0 ) ;
prev = chrono . millisOfDay () . add ( prev , iMillisOfDay ) ;
prev = setDayOfMonthPrevious ( chrono , prev ) ;
if ( iDayOfWeek == 0 ) {
if ( prev >= instant ) {
prev = chrono . year () . add ( prev , - 1 ) ;
prev = setDayOfMonthPrevious ( chrono , prev ) ;
}
} else {
prev = setDayOfWeek ( chrono , prev ) ;
if ( prev >= instant ) {
prev = chrono . year () . add ( prev , - 1 ) ;
prev = chrono . monthOfYear () . set ( prev , iMonthOfYear ) ;
prev = setDayOfMonthPrevious ( chrono , prev ) ;
prev = setDayOfWeek ( chrono , prev ) ;
}
}
prev = chrono . millisOfDay () . set ( prev , 0 ) ;
prev = chrono . millisOfDay () . add ( prev , iMillisOfDay ) ;
return prev - offset ;
}
public boolean equals ( Object obj ) {
if ( this == obj ) {
return true ;
}
if ( obj instanceof OfYear ) {
OfYear other = ( OfYear ) obj ;
return
iMode == other . iMode &&
iMonthOfYear == other . iMonthOfYear &&
iDayOfMonth == other . iDayOfMonth &&
iDayOfWeek == other . iDayOfWeek &&
iAdvance == other . iAdvance &&
iMillisOfDay == other . iMillisOfDay ;
}
return false ;
}
public String toString () {
return
lr_3 +
lr_4 + iMode + '\n' +
lr_5 + iMonthOfYear + '\n' +
lr_6 + iDayOfMonth + '\n' +
lr_7 + iDayOfWeek + '\n' +
lr_8 + iAdvance + '\n' +
lr_9 + iMillisOfDay + '\n' ;
}
public void writeTo ( DataOutput out ) throws IOException {
out . writeByte ( iMode ) ;
out . writeByte ( iMonthOfYear ) ;
out . writeByte ( iDayOfMonth ) ;
out . writeByte ( iDayOfWeek ) ;
out . writeBoolean ( iAdvance ) ;
writeMillis ( out , iMillisOfDay ) ;
}
private long setDayOfMonthNext ( Chronology chrono , long next ) {
try {
next = setDayOfMonth ( chrono , next ) ;
} catch ( IllegalArgumentException e ) {
if ( iMonthOfYear == 2 && iDayOfMonth == 29 ) {
while ( chrono . year () . isLeap ( next ) == false ) {
next = chrono . year () . add ( next , 1 ) ;
}
next = setDayOfMonth ( chrono , next ) ;
} else {
throw e ;
}
}
return next ;
}
private long setDayOfMonthPrevious ( Chronology chrono , long prev ) {
try {
prev = setDayOfMonth ( chrono , prev ) ;
} catch ( IllegalArgumentException e ) {
if ( iMonthOfYear == 2 && iDayOfMonth == 29 ) {
while ( chrono . year () . isLeap ( prev ) == false ) {
prev = chrono . year () . add ( prev , - 1 ) ;
}
prev = setDayOfMonth ( chrono , prev ) ;
} else {
throw e ;
}
}
return prev ;
}
private long setDayOfMonth ( Chronology chrono , long instant ) {
if ( iDayOfMonth >= 0 ) {
instant = chrono . dayOfMonth () . set ( instant , iDayOfMonth ) ;
} else {
instant = chrono . dayOfMonth () . set ( instant , 1 ) ;
instant = chrono . monthOfYear () . add ( instant , 1 ) ;
instant = chrono . dayOfMonth () . add ( instant , iDayOfMonth ) ;
}
return instant ;
}
private long setDayOfWeek ( Chronology chrono , long instant ) {
int dayOfWeek = chrono . dayOfWeek () . get ( instant ) ;
int daysToAdd = iDayOfWeek - dayOfWeek ;
if ( daysToAdd != 0 ) {
if ( iAdvance ) {
if ( daysToAdd < 0 ) {
daysToAdd += 7 ;
}
} else {
if ( daysToAdd > 0 ) {
daysToAdd -= 7 ;
}
}
instant = chrono . dayOfWeek () . add ( instant , daysToAdd ) ;
}
return instant ;
}
static Recurrence readFrom ( DataInput in ) throws IOException {
return new Recurrence ( OfYear . readFrom ( in ) , in . readUTF () , ( int ) readMillis ( in ) ) ;
}
public OfYear getOfYear () {
return iOfYear ;
}
public long next ( long instant , int standardOffset , int saveMillis ) {
return iOfYear . next ( instant , standardOffset , saveMillis ) ;
}
public long previous ( long instant , int standardOffset , int saveMillis ) {
return iOfYear . previous ( instant , standardOffset , saveMillis ) ;
}
public String getNameKey () {
return iNameKey ;
}
public int getSaveMillis () {
return iSaveMillis ;
}
public boolean equals ( Object obj ) {
if ( this == obj ) {
return true ;
}
if ( obj instanceof Recurrence ) {
Recurrence other = ( Recurrence ) obj ;
return
iSaveMillis == other . iSaveMillis &&
iNameKey . equals ( other . iNameKey ) &&
iOfYear . equals ( other . iOfYear ) ;
}
return false ;
}
public void writeTo ( DataOutput out ) throws IOException {
iOfYear . writeTo ( out ) ;
out . writeUTF ( iNameKey ) ;
writeMillis ( out , iSaveMillis ) ;
}
Recurrence rename ( String nameKey ) {
return new Recurrence ( iOfYear , nameKey , iSaveMillis ) ;
}
Recurrence renameAppend ( String appendNameKey ) {
return rename ( ( iNameKey + appendNameKey ) . intern () ) ;
}
@Override
public String toString () {
return iOfYear + lr_10 + iNameKey + lr_11 + iSaveMillis ;
}
@SuppressWarnings ( lr_12 )
public int getFromYear () {
return iFromYear ;
}
public int getToYear () {
return iToYear ;
}
@SuppressWarnings ( lr_12 )
public OfYear getOfYear () {
return iRecurrence . getOfYear () ;
}
public String getNameKey () {
return iRecurrence . getNameKey () ;
}
public int getSaveMillis () {
return iRecurrence . getSaveMillis () ;
}
public long next ( final long instant , int standardOffset , int saveMillis ) {
Chronology chrono = ISOChronology . getInstanceUTC () ;
final int wallOffset = standardOffset + saveMillis ;
long testInstant = instant ;
int year ;
if ( instant == Long . MIN_VALUE ) {
year = Integer . MIN_VALUE ;
} else {
year = chrono . year () . get ( instant + wallOffset ) ;
}
if ( year < iFromYear ) {
testInstant = chrono . year () . set ( 0 , iFromYear ) - wallOffset ;
testInstant -= 1 ;
}
long next = iRecurrence . next ( testInstant , standardOffset , saveMillis ) ;
if ( next > instant ) {
year = chrono . year () . get ( next + wallOffset ) ;
if ( year > iToYear ) {
next = instant ;
}
}
return next ;
}
@Override
public String toString () {
return iFromYear + lr_13 + iToYear + lr_14 + iRecurrence ;
}
public long getMillis () {
return iMillis ;
}
public String getNameKey () {
return iNameKey ;
}
public int getWallOffset () {
return iWallOffset ;
}
public int getStandardOffset () {
return iStandardOffset ;
}
public int getSaveMillis () {
return iWallOffset - iStandardOffset ;
}
public Transition withMillis ( long millis ) {
return new Transition ( millis , iNameKey , iWallOffset , iStandardOffset ) ;
}
public boolean isTransitionFrom ( Transition other ) {
if ( other == null ) {
return true ;
}
return iMillis > other . iMillis &&
( iWallOffset != other . iWallOffset ||
iStandardOffset != other . iStandardOffset ||
! ( iNameKey . equals ( other . iNameKey ) ) ) ;
}
@Override
public String toString () {
return new DateTime ( iMillis , DateTimeZone . UTC ) + lr_15 + iStandardOffset + lr_15 + iWallOffset ;
}
@SuppressWarnings ( lr_12 )
public int getStandardOffset () {
return iStandardOffset ;
}
public void setStandardOffset ( int standardOffset ) {
iStandardOffset = standardOffset ;
}
public void setFixedSavings ( String nameKey , int saveMillis ) {
iInitialNameKey = nameKey ;
iInitialSaveMillis = saveMillis ;
}
public void addRule ( Rule rule ) {
if ( ! iRules . contains ( rule ) ) {
iRules . add ( rule ) ;
}
}
public void setUpperLimit ( int year , OfYear ofYear ) {
iUpperYear = year ;
iUpperOfYear = ofYear ;
}
public Transition firstTransition ( final long firstMillis ) {
if ( iInitialNameKey != null ) {
return new Transition ( firstMillis , iInitialNameKey ,
iStandardOffset + iInitialSaveMillis , iStandardOffset ) ;
}
ArrayList < Rule > copy = new ArrayList < Rule > ( iRules ) ;
long millis = Long . MIN_VALUE ;
int saveMillis = 0 ;
Transition first = null ;
Transition next ;
while ( ( next = nextTransition ( millis , saveMillis ) ) != null ) {
millis = next . getMillis () ;
if ( millis == firstMillis ) {
first = new Transition ( firstMillis , next ) ;
break;
}
if ( millis > firstMillis ) {
if ( first == null ) {
for ( Rule rule : copy ) {
if ( rule . getSaveMillis () == 0 ) {
first = new Transition ( firstMillis , rule , iStandardOffset ) ;
break;
}
}
}
if ( first == null ) {
first = new Transition ( firstMillis , next . getNameKey () ,
iStandardOffset , iStandardOffset ) ;
}
break;
}
first = new Transition ( firstMillis , next ) ;
saveMillis = next . getSaveMillis () ;
}
iRules = copy ;
return first ;
}
public Transition nextTransition ( final long instant , final int saveMillis ) {
Chronology chrono = ISOChronology . getInstanceUTC () ;
Rule nextRule = null ;
long nextMillis = Long . MAX_VALUE ;
Iterator < Rule > it = iRules . iterator () ;
while ( it . hasNext () ) {
Rule rule = it . next () ;
long next = rule . next ( instant , iStandardOffset , saveMillis ) ;
if ( next <= instant ) {
it . remove () ;
continue;
}
if ( next <= nextMillis ) {
nextRule = rule ;
nextMillis = next ;
}
}
if ( nextRule == null ) {
return null ;
}
if ( chrono . year () . get ( nextMillis ) >= YEAR_LIMIT ) {
return null ;
}
if ( iUpperYear < Integer . MAX_VALUE ) {
long upperMillis =
iUpperOfYear . setInstant ( iUpperYear , iStandardOffset , saveMillis ) ;
if ( nextMillis >= upperMillis ) {
return null ;
}
}
return new Transition ( nextMillis , nextRule , iStandardOffset ) ;
}
public long getUpperLimit ( int saveMillis ) {
if ( iUpperYear == Integer . MAX_VALUE ) {
return Long . MAX_VALUE ;
}
return iUpperOfYear . setInstant ( iUpperYear , iStandardOffset , saveMillis ) ;
}
public DSTZone buildTailZone ( String id ) {
if ( iRules . size () == 2 ) {
Rule startRule = iRules . get ( 0 ) ;
Rule endRule = iRules . get ( 1 ) ;
if ( startRule . getToYear () == Integer . MAX_VALUE &&
endRule . getToYear () == Integer . MAX_VALUE ) {
return new DSTZone ( id , iStandardOffset ,
startRule . iRecurrence , endRule . iRecurrence ) ;
}
}
return null ;
}
@Override
public String toString () {
return iInitialNameKey + lr_16 + iInitialSaveMillis + lr_17 + iStandardOffset +
lr_18 + iUpperYear + lr_15 + iUpperOfYear + lr_15 + iRules ;
}
static DSTZone readFrom ( DataInput in , String id ) throws IOException {
return new DSTZone ( id , ( int ) readMillis ( in ) ,
Recurrence . readFrom ( in ) , Recurrence . readFrom ( in ) ) ;
}
public String getNameKey ( long instant ) {
return findMatchingRecurrence ( instant ) . getNameKey () ;
}
public int getOffset ( long instant ) {
return iStandardOffset + findMatchingRecurrence ( instant ) . getSaveMillis () ;
}
public int getStandardOffset ( long instant ) {
return iStandardOffset ;
}
public boolean isFixed () {
return false ;
}
public long nextTransition ( long instant ) {
int standardOffset = iStandardOffset ;
Recurrence startRecurrence = iStartRecurrence ;
Recurrence endRecurrence = iEndRecurrence ;
long start , end ;
try {
start = startRecurrence . next
( instant , standardOffset , endRecurrence . getSaveMillis () ) ;
if ( instant > 0 && start < 0 ) {
start = instant ;
}
} catch ( IllegalArgumentException e ) {
start = instant ;
} catch ( ArithmeticException e ) {
start = instant ;
}
try {
end = endRecurrence . next
( instant , standardOffset , startRecurrence . getSaveMillis () ) ;
if ( instant > 0 && end < 0 ) {
end = instant ;
}
} catch ( IllegalArgumentException e ) {
end = instant ;
} catch ( ArithmeticException e ) {
end = instant ;
}
return ( start > end ) ? end : start ;
}
public long previousTransition ( long instant ) {
instant ++ ;
int standardOffset = iStandardOffset ;
Recurrence startRecurrence = iStartRecurrence ;
Recurrence endRecurrence = iEndRecurrence ;
long start , end ;
try {
start = startRecurrence . previous
( instant , standardOffset , endRecurrence . getSaveMillis () ) ;
if ( instant < 0 && start > 0 ) {
start = instant ;
}
} catch ( IllegalArgumentException e ) {
start = instant ;
} catch ( ArithmeticException e ) {
start = instant ;
}
try {
end = endRecurrence . previous
( instant , standardOffset , startRecurrence . getSaveMillis () ) ;
if ( instant < 0 && end > 0 ) {
end = instant ;
}
} catch ( IllegalArgumentException e ) {
end = instant ;
} catch ( ArithmeticException e ) {
end = instant ;
}
return ( ( start > end ) ? start : end ) - 1 ;
}
public boolean equals ( Object obj ) {
if ( this == obj ) {
return true ;
}
if ( obj instanceof DSTZone ) {
DSTZone other = ( DSTZone ) obj ;
return
getID () . equals ( other . getID () ) &&
iStandardOffset == other . iStandardOffset &&
iStartRecurrence . equals ( other . iStartRecurrence ) &&
iEndRecurrence . equals ( other . iEndRecurrence ) ;
}
return false ;
}
public void writeTo ( DataOutput out ) throws IOException {
writeMillis ( out , iStandardOffset ) ;
iStartRecurrence . writeTo ( out ) ;
iEndRecurrence . writeTo ( out ) ;
}
private Recurrence findMatchingRecurrence ( long instant ) {
int standardOffset = iStandardOffset ;
Recurrence startRecurrence = iStartRecurrence ;
Recurrence endRecurrence = iEndRecurrence ;
long start , end ;
try {
start = startRecurrence . next
( instant , standardOffset , endRecurrence . getSaveMillis () ) ;
} catch ( IllegalArgumentException e ) {
start = instant ;
} catch ( ArithmeticException e ) {
start = instant ;
}
try {
end = endRecurrence . next
( instant , standardOffset , startRecurrence . getSaveMillis () ) ;
} catch ( IllegalArgumentException e ) {
end = instant ;
} catch ( ArithmeticException e ) {
end = instant ;
}
return ( start > end ) ? startRecurrence : endRecurrence ;
}
static PrecalculatedZone readFrom ( DataInput in , String id ) throws IOException {
int poolSize = in . readUnsignedShort () ;
String [] pool = new String [ poolSize ] ;
for ( int i = 0 ; i < poolSize ; i ++ ) {
pool [ i ] = in . readUTF () ;
}
int size = in . readInt () ;
long [] transitions = new long [ size ] ;
int [] wallOffsets = new int [ size ] ;
int [] standardOffsets = new int [ size ] ;
String [] nameKeys = new String [ size ] ;
for ( int i = 0 ; i < size ; i ++ ) {
transitions [ i ] = readMillis ( in ) ;
wallOffsets [ i ] = ( int ) readMillis ( in ) ;
standardOffsets [ i ] = ( int ) readMillis ( in ) ;
try {
int index ;
if ( poolSize < 256 ) {
index = in . readUnsignedByte () ;
} else {
index = in . readUnsignedShort () ;
}
nameKeys [ i ] = pool [ index ] ;
} catch ( ArrayIndexOutOfBoundsException e ) {
throw new IOException ( lr_1 ) ;
}
}
DSTZone tailZone = null ;
if ( in . readBoolean () ) {
tailZone = DSTZone . readFrom ( in , id ) ;
}
return new PrecalculatedZone
( id , transitions , wallOffsets , standardOffsets , nameKeys , tailZone ) ;
}
static PrecalculatedZone create ( String id , boolean outputID , ArrayList < Transition > transitions ,
DSTZone tailZone ) {
int size = transitions . size () ;
if ( size == 0 ) {
throw new IllegalArgumentException () ;
}
long [] trans = new long [ size ] ;
int [] wallOffsets = new int [ size ] ;
int [] standardOffsets = new int [ size ] ;
String [] nameKeys = new String [ size ] ;
Transition last = null ;
for ( int i = 0 ; i < size ; i ++ ) {
Transition tr = transitions . get ( i ) ;
if ( ! tr . isTransitionFrom ( last ) ) {
throw new IllegalArgumentException ( id ) ;
}
trans [ i ] = tr . getMillis () ;
wallOffsets [ i ] = tr . getWallOffset () ;
standardOffsets [ i ] = tr . getStandardOffset () ;
nameKeys [ i ] = tr . getNameKey () ;
last = tr ;
}
String [] zoneNameData = new String [ 5 ] ;
String [] [] zoneStrings = new DateFormatSymbols ( Locale . ENGLISH ) . getZoneStrings () ;
for ( int j = 0 ; j < zoneStrings . length ; j ++ ) {
String [] set = zoneStrings [ j ] ;
if ( set != null && set . length == 5 && id . equals ( set [ 0 ] ) ) {
zoneNameData = set ;
}
}
Chronology chrono = ISOChronology . getInstanceUTC () ;
for ( int i = 0 ; i < nameKeys . length - 1 ; i ++ ) {
String curNameKey = nameKeys [ i ] ;
String nextNameKey = nameKeys [ i + 1 ] ;
long curOffset = wallOffsets [ i ] ;
long nextOffset = wallOffsets [ i + 1 ] ;
long curStdOffset = standardOffsets [ i ] ;
long nextStdOffset = standardOffsets [ i + 1 ] ;
Period p = new Period ( trans [ i ] , trans [ i + 1 ] , PeriodType . yearMonthDay () , chrono ) ;
if ( curOffset != nextOffset &&
curStdOffset == nextStdOffset &&
curNameKey . equals ( nextNameKey ) &&
p . getYears () == 0 && p . getMonths () > 4 && p . getMonths () < 8 &&
curNameKey . equals ( zoneNameData [ 2 ] ) &&
curNameKey . equals ( zoneNameData [ 4 ] ) ) {
if ( ZoneInfoLogger . verbose () ) {
System . out . println ( lr_19 + nextNameKey ) ;
System . out . println ( lr_20 + new DateTime ( trans [ i ] , chrono ) +
lr_21 + new DateTime ( trans [ i + 1 ] , chrono ) ) ;
}
if ( curOffset > nextOffset ) {
nameKeys [ i ] = ( curNameKey + lr_22 ) . intern () ;
} else if ( curOffset < nextOffset ) {
nameKeys [ i + 1 ] = ( nextNameKey + lr_22 ) . intern () ;
i ++ ;
}
}
}
if ( tailZone != null ) {
if ( tailZone . iStartRecurrence . getNameKey ()
. equals ( tailZone . iEndRecurrence . getNameKey () ) ) {
if ( ZoneInfoLogger . verbose () ) {
System . out . println ( lr_23 +
tailZone . iStartRecurrence . getNameKey () ) ;
}
if ( tailZone . iStartRecurrence . getSaveMillis () > 0 ) {
tailZone = new DSTZone (
tailZone . getID () ,
tailZone . iStandardOffset ,
tailZone . iStartRecurrence . renameAppend ( lr_22 ) ,
tailZone . iEndRecurrence ) ;
} else {
tailZone = new DSTZone (
tailZone . getID () ,
tailZone . iStandardOffset ,
tailZone . iStartRecurrence ,
tailZone . iEndRecurrence . renameAppend ( lr_22 ) ) ;
}
}
}
return new PrecalculatedZone
( ( outputID ? id : lr_24 ) , trans , wallOffsets , standardOffsets , nameKeys , tailZone ) ;
}
public String getNameKey ( long instant ) {
long [] transitions = iTransitions ;
int i = Arrays . binarySearch ( transitions , instant ) ;
if ( i >= 0 ) {
return iNameKeys [ i ] ;
}
i = ~ i ;
if ( i < transitions . length ) {
if ( i > 0 ) {
return iNameKeys [ i - 1 ] ;
}
return lr_2 ;
}
if ( iTailZone == null ) {
return iNameKeys [ i - 1 ] ;
}
return iTailZone . getNameKey ( instant ) ;
}
public int getOffset ( long instant ) {
long [] transitions = iTransitions ;
int i = Arrays . binarySearch ( transitions , instant ) ;
if ( i >= 0 ) {
return iWallOffsets [ i ] ;
}
i = ~ i ;
if ( i < transitions . length ) {
if ( i > 0 ) {
return iWallOffsets [ i - 1 ] ;
}
return 0 ;
}
if ( iTailZone == null ) {
return iWallOffsets [ i - 1 ] ;
}
return iTailZone . getOffset ( instant ) ;
}
public int getStandardOffset ( long instant ) {
long [] transitions = iTransitions ;
int i = Arrays . binarySearch ( transitions , instant ) ;
if ( i >= 0 ) {
return iStandardOffsets [ i ] ;
}
i = ~ i ;
if ( i < transitions . length ) {
if ( i > 0 ) {
return iStandardOffsets [ i - 1 ] ;
}
return 0 ;
}
if ( iTailZone == null ) {
return iStandardOffsets [ i - 1 ] ;
}
return iTailZone . getStandardOffset ( instant ) ;
}
public boolean isFixed () {
return false ;
}
public long nextTransition ( long instant ) {
long [] transitions = iTransitions ;
int i = Arrays . binarySearch ( transitions , instant ) ;
i = ( i >= 0 ) ? ( i + 1 ) : ~ i ;
if ( i < transitions . length ) {
return transitions [ i ] ;
}
if ( iTailZone == null ) {
return instant ;
}
long end = transitions [ transitions . length - 1 ] ;
if ( instant < end ) {
instant = end ;
}
return iTailZone . nextTransition ( instant ) ;
}
public long previousTransition ( long instant ) {
long [] transitions = iTransitions ;
int i = Arrays . binarySearch ( transitions , instant ) ;
if ( i >= 0 ) {
if ( instant > Long . MIN_VALUE ) {
return instant - 1 ;
}
return instant ;
}
i = ~ i ;
if ( i < transitions . length ) {
if ( i > 0 ) {
long prev = transitions [ i - 1 ] ;
if ( prev > Long . MIN_VALUE ) {
return prev - 1 ;
}
}
return instant ;
}
if ( iTailZone != null ) {
long prev = iTailZone . previousTransition ( instant ) ;
if ( prev < instant ) {
return prev ;
}
}
long prev = transitions [ i - 1 ] ;
if ( prev > Long . MIN_VALUE ) {
return prev - 1 ;
}
return instant ;
}
public boolean equals ( Object obj ) {
if ( this == obj ) {
return true ;
}
if ( obj instanceof PrecalculatedZone ) {
PrecalculatedZone other = ( PrecalculatedZone ) obj ;
return
getID () . equals ( other . getID () ) &&
Arrays . equals ( iTransitions , other . iTransitions ) &&
Arrays . equals ( iNameKeys , other . iNameKeys ) &&
Arrays . equals ( iWallOffsets , other . iWallOffsets ) &&
Arrays . equals ( iStandardOffsets , other . iStandardOffsets ) &&
( ( iTailZone == null )
? ( null == other . iTailZone )
: ( iTailZone . equals ( other . iTailZone ) ) ) ;
}
return false ;
}
public void writeTo ( DataOutput out ) throws IOException {
int size = iTransitions . length ;
Set < String > poolSet = new HashSet < String > () ;
for ( int i = 0 ; i < size ; i ++ ) {
poolSet . add ( iNameKeys [ i ] ) ;
}
int poolSize = poolSet . size () ;
if ( poolSize > 65535 ) {
throw new UnsupportedOperationException ( lr_25 ) ;
}
String [] pool = new String [ poolSize ] ;
Iterator < String > it = poolSet . iterator () ;
for ( int i = 0 ; it . hasNext () ; i ++ ) {
pool [ i ] = it . next () ;
}
out . writeShort ( poolSize ) ;
for ( int i = 0 ; i < poolSize ; i ++ ) {
out . writeUTF ( pool [ i ] ) ;
}
out . writeInt ( size ) ;
for ( int i = 0 ; i < size ; i ++ ) {
writeMillis ( out , iTransitions [ i ] ) ;
writeMillis ( out , iWallOffsets [ i ] ) ;
writeMillis ( out , iStandardOffsets [ i ] ) ;
String nameKey = iNameKeys [ i ] ;
for ( int j = 0 ; j < poolSize ; j ++ ) {
if ( pool [ j ] . equals ( nameKey ) ) {
if ( poolSize < 256 ) {
out . writeByte ( j ) ;
} else {
out . writeShort ( j ) ;
}
break;
}
}
}
out . writeBoolean ( iTailZone != null ) ;
if ( iTailZone != null ) {
iTailZone . writeTo ( out ) ;
}
}
public boolean isCachable () {
if ( iTailZone != null ) {
return true ;
}
long [] transitions = iTransitions ;
if ( transitions . length <= 1 ) {
return false ;
}
double distances = 0 ;
int count = 0 ;
for ( int i = 1 ; i < transitions . length ; i ++ ) {
long diff = transitions [ i ] - transitions [ i - 1 ] ;
if ( diff < ( ( 366L + 365 ) * 24 * 60 * 60 * 1000 ) ) {
distances += ( double ) diff ;
count ++ ;
}
}
if ( count > 0 ) {
double avg = distances / count ;
avg /= 24 * 60 * 60 * 1000 ;
if ( avg >= 25 ) {
return true ;
}
}
return false ;
}

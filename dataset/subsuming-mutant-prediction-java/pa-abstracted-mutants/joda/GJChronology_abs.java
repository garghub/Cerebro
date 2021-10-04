private static long convertByYear ( long instant , Chronology from , Chronology to ) {
return to . getDateTimeMillis
( from . year () . get ( instant ) ,
from . monthOfYear () . get ( instant ) ,
from . dayOfMonth () . get ( instant ) ,
from . millisOfDay () . get ( instant ) ) ;
}
private static long convertByWeekyear ( final long instant , Chronology from , Chronology to ) {
long newInstant ;
newInstant = to . weekyear () . set ( 0 , from . weekyear () . get ( instant ) ) ;
newInstant = to . weekOfWeekyear () . set ( newInstant , from . weekOfWeekyear () . get ( instant ) ) ;
newInstant = to . dayOfWeek () . set ( newInstant , from . dayOfWeek () . get ( instant ) ) ;
newInstant = to . millisOfDay () . set ( newInstant , from . millisOfDay () . get ( instant ) ) ;
return newInstant ;
}
public static GJChronology getInstanceUTC () {
return getInstance ( DateTimeZone . UTC , DEFAULT_CUTOVER , 4 ) ;
}
public static GJChronology getInstance () {
return getInstance ( DateTimeZone . getDefault () , DEFAULT_CUTOVER , 4 ) ;
}
public static GJChronology getInstance ( DateTimeZone zone ) {
return getInstance ( zone , DEFAULT_CUTOVER , 4 ) ;
}
public static GJChronology getInstance (
DateTimeZone zone ,
ReadableInstant gregorianCutover ) {
return getInstance ( zone , gregorianCutover , 4 ) ;
}
public static GJChronology getInstance (
DateTimeZone zone ,
ReadableInstant gregorianCutover ,
int minDaysInFirstWeek ) {
zone = DateTimeUtils . getZone ( zone ) ;
Instant cutoverInstant ;
if ( gregorianCutover == null ) {
cutoverInstant = DEFAULT_CUTOVER ;
} else {
cutoverInstant = gregorianCutover . toInstant () ;
LocalDate cutoverDate = new LocalDate ( cutoverInstant . getMillis () , GregorianChronology . getInstance ( zone ) ) ;
if ( cutoverDate . getYear () <= 0 ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
}
GJCacheKey cacheKey = new GJCacheKey ( zone , cutoverInstant , minDaysInFirstWeek ) ;
GJChronology chrono = cCache . get ( cacheKey ) ;
if ( chrono == null ) {
if ( zone == DateTimeZone . UTC ) {
chrono = new GJChronology
( JulianChronology . getInstance ( zone , minDaysInFirstWeek ) ,
GregorianChronology . getInstance ( zone , minDaysInFirstWeek ) ,
cutoverInstant ) ;
} else {
chrono = getInstance ( DateTimeZone . UTC , cutoverInstant , minDaysInFirstWeek ) ;
chrono = new GJChronology
( ZonedChronology . getInstance ( chrono , zone ) ,
chrono . iJulianChronology ,
chrono . iGregorianChronology ,
chrono . iCutoverInstant ) ;
}
GJChronology oldChrono = cCache . putIfAbsent ( cacheKey , chrono ) ;
if ( oldChrono != null ) {
chrono = oldChrono ;
}
}
return chrono ;
}
public static GJChronology getInstance (
DateTimeZone zone ,
long gregorianCutover ,
int minDaysInFirstWeek ) {
Instant cutoverInstant ;
if ( gregorianCutover == DEFAULT_CUTOVER . getMillis () ) {
cutoverInstant = null ;
} else {
cutoverInstant = new Instant ( gregorianCutover ) ;
}
return getInstance ( zone , cutoverInstant , minDaysInFirstWeek ) ;
}
private Object readResolve () {
return getInstance ( getZone () , iCutoverInstant , getMinimumDaysInFirstWeek () ) ;
}
public DateTimeZone getZone () {
Chronology base ;
if ( ( base = getBase () ) != null ) {
return base . getZone () ;
}
return DateTimeZone . UTC ;
}
public Chronology withUTC () {
return withZone ( DateTimeZone . UTC ) ;
}
public Chronology withZone ( DateTimeZone zone ) {
if ( zone == null ) {
zone = DateTimeZone . getDefault () ;
}
if ( zone == getZone () ) {
return this ;
}
return getInstance ( zone , iCutoverInstant , getMinimumDaysInFirstWeek () ) ;
}
public long getDateTimeMillis ( int year , int monthOfYear , int dayOfMonth ,
int millisOfDay )
throws IllegalArgumentException
{
Chronology base ;
if ( ( base = getBase () ) != null ) {
return base . getDateTimeMillis ( year , monthOfYear , dayOfMonth , millisOfDay ) ;
}
long instant = iGregorianChronology . getDateTimeMillis
( year , monthOfYear , dayOfMonth , millisOfDay ) ;
if ( instant < iCutoverMillis ) {
instant = iJulianChronology . getDateTimeMillis
( year , monthOfYear , dayOfMonth , millisOfDay ) ;
if ( instant >= iCutoverMillis ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
}
return instant ;
}
public long getDateTimeMillis ( int year , int monthOfYear , int dayOfMonth ,
int hourOfDay , int minuteOfHour ,
int secondOfMinute , int millisOfSecond )
throws IllegalArgumentException
{
Chronology base ;
if ( ( base = getBase () ) != null ) {
return base . getDateTimeMillis
( year , monthOfYear , dayOfMonth ,
hourOfDay , minuteOfHour , secondOfMinute , millisOfSecond ) ;
}
long instant ;
try {
instant = iGregorianChronology . getDateTimeMillis
( year , monthOfYear , dayOfMonth ,
hourOfDay , minuteOfHour , secondOfMinute , millisOfSecond ) ;
} catch ( IllegalFieldValueException ex ) {
if ( monthOfYear != 2 || dayOfMonth != 29 ) {
throw ex ;
}
instant = iGregorianChronology . getDateTimeMillis
( year , monthOfYear , 28 ,
hourOfDay , minuteOfHour , secondOfMinute , millisOfSecond ) ;
if ( instant >= iCutoverMillis ) {
throw ex ;
}
}
if ( instant < iCutoverMillis ) {
instant = iJulianChronology . getDateTimeMillis
( year , monthOfYear , dayOfMonth ,
hourOfDay , minuteOfHour , secondOfMinute , millisOfSecond ) ;
if ( instant >= iCutoverMillis ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
}
return instant ;
}
public Instant getGregorianCutover () {
return iCutoverInstant ;
}
public int getMinimumDaysInFirstWeek () {
return iGregorianChronology . getMinimumDaysInFirstWeek () ;
}
public boolean equals ( Object obj ) {
if ( this == obj ) {
return true ;
}
if ( obj instanceof GJChronology ) {
GJChronology chrono = ( GJChronology ) obj ;
return iCutoverMillis == chrono . iCutoverMillis &&
getMinimumDaysInFirstWeek () == chrono . getMinimumDaysInFirstWeek () &&
getZone () . equals ( chrono . getZone () ) ;
}
return false ;
}
public int hashCode () {
return lr_3 . hashCode () * 11 + getZone () . hashCode () +
getMinimumDaysInFirstWeek () + iCutoverInstant . hashCode () ;
}
public String toString () {
StringBuffer sb = new StringBuffer ( 60 ) ;
sb . append ( lr_4 ) ;
sb . append ( '[' ) ;
sb . append ( getZone () . getID () ) ;
if ( iCutoverMillis != DEFAULT_CUTOVER . getMillis () ) {
sb . append ( lr_5 ) ;
DateTimeFormatter printer ;
if ( withUTC () . dayOfYear () . remainder ( iCutoverMillis ) == 0 ) {
printer = ISODateTimeFormat . date () ;
} else {
printer = ISODateTimeFormat . dateTime () ;
}
printer . withChronology ( withUTC () ) . printTo ( sb , iCutoverMillis ) ;
}
if ( getMinimumDaysInFirstWeek () != 4 ) {
sb . append ( lr_6 ) ;
sb . append ( getMinimumDaysInFirstWeek () ) ;
}
sb . append ( ']' ) ;
return sb . toString () ;
}
protected void assemble ( Fields fields ) {
Object [] params = ( Object [] ) getParam () ;
JulianChronology julian = ( JulianChronology ) params [ 0 ] ;
GregorianChronology gregorian = ( GregorianChronology ) params [ 1 ] ;
Instant cutoverInstant = ( Instant ) params [ 2 ] ;
iCutoverMillis = cutoverInstant . getMillis () ;
iJulianChronology = julian ;
iGregorianChronology = gregorian ;
iCutoverInstant = cutoverInstant ;
if ( getBase () != null ) {
return;
}
if ( julian . getMinimumDaysInFirstWeek () != gregorian . getMinimumDaysInFirstWeek () ) {
throw new IllegalArgumentException () ;
}
iGapDuration = iCutoverMillis - julianToGregorianByYear ( iCutoverMillis ) ;
fields . copyFieldsFrom ( gregorian ) ;
if ( gregorian . millisOfDay () . get ( iCutoverMillis ) == 0 ) {
fields . millisOfSecond = new CutoverField ( julian . millisOfSecond () , fields . millisOfSecond , iCutoverMillis ) ;
fields . millisOfDay = new CutoverField ( julian . millisOfDay () , fields . millisOfDay , iCutoverMillis ) ;
fields . secondOfMinute = new CutoverField ( julian . secondOfMinute () , fields . secondOfMinute , iCutoverMillis ) ;
fields . secondOfDay = new CutoverField ( julian . secondOfDay () , fields . secondOfDay , iCutoverMillis ) ;
fields . minuteOfHour = new CutoverField ( julian . minuteOfHour () , fields . minuteOfHour , iCutoverMillis ) ;
fields . minuteOfDay = new CutoverField ( julian . minuteOfDay () , fields . minuteOfDay , iCutoverMillis ) ;
fields . hourOfDay = new CutoverField ( julian . hourOfDay () , fields . hourOfDay , iCutoverMillis ) ;
fields . hourOfHalfday = new CutoverField ( julian . hourOfHalfday () , fields . hourOfHalfday , iCutoverMillis ) ;
fields . clockhourOfDay = new CutoverField ( julian . clockhourOfDay () , fields . clockhourOfDay , iCutoverMillis ) ;
fields . clockhourOfHalfday = new CutoverField ( julian . clockhourOfHalfday () ,
fields . clockhourOfHalfday , iCutoverMillis ) ;
fields . halfdayOfDay = new CutoverField ( julian . halfdayOfDay () , fields . halfdayOfDay , iCutoverMillis ) ;
}
{
fields . era = new CutoverField ( julian . era () , fields . era , iCutoverMillis ) ;
}
{
fields . year = new ImpreciseCutoverField (
julian . year () , fields . year , iCutoverMillis ) ;
fields . years = fields . year . getDurationField () ;
fields . yearOfEra = new ImpreciseCutoverField (
julian . yearOfEra () , fields . yearOfEra , fields . years , iCutoverMillis ) ;
fields . centuryOfEra = new ImpreciseCutoverField (
julian . centuryOfEra () , fields . centuryOfEra , iCutoverMillis ) ;
fields . centuries = fields . centuryOfEra . getDurationField () ;
fields . yearOfCentury = new ImpreciseCutoverField (
julian . yearOfCentury () , fields . yearOfCentury , fields . years , fields . centuries , iCutoverMillis ) ;
fields . monthOfYear = new ImpreciseCutoverField (
julian . monthOfYear () , fields . monthOfYear , null , fields . years , iCutoverMillis ) ;
fields . months = fields . monthOfYear . getDurationField () ;
fields . weekyear = new ImpreciseCutoverField (
julian . weekyear () , fields . weekyear , null , iCutoverMillis , true ) ;
fields . weekyears = fields . weekyear . getDurationField () ;
fields . weekyearOfCentury = new ImpreciseCutoverField (
julian . weekyearOfCentury () , fields . weekyearOfCentury , fields . weekyears , fields . centuries , iCutoverMillis ) ;
}
{
long cutover = gregorian . year () . roundCeiling ( iCutoverMillis ) ;
fields . dayOfYear = new CutoverField (
julian . dayOfYear () , fields . dayOfYear , fields . years , cutover , false ) ;
}
{
long cutover = gregorian . weekyear () . roundCeiling ( iCutoverMillis ) ;
fields . weekOfWeekyear = new CutoverField (
julian . weekOfWeekyear () , fields . weekOfWeekyear , fields . weekyears , cutover , true ) ;
}
{
CutoverField cf = new CutoverField
( julian . dayOfMonth () , fields . dayOfMonth , iCutoverMillis ) ;
cf . iRangeDurationField = fields . months ;
fields . dayOfMonth = cf ;
}
}
long julianToGregorianByYear ( long instant ) {
return convertByYear ( instant , iJulianChronology , iGregorianChronology ) ;
}
long gregorianToJulianByYear ( long instant ) {
return convertByYear ( instant , iGregorianChronology , iJulianChronology ) ;
}
long julianToGregorianByWeekyear ( long instant ) {
return convertByWeekyear ( instant , iJulianChronology , iGregorianChronology ) ;
}
long gregorianToJulianByWeekyear ( long instant ) {
return convertByWeekyear ( instant , iGregorianChronology , iJulianChronology ) ;
}
public boolean isLenient () {
return false ;
}
public int get ( long instant ) {
if ( instant >= iCutover ) {
return iGregorianField . get ( instant ) ;
} else {
return iJulianField . get ( instant ) ;
}
}
public String getAsText ( long instant , Locale locale ) {
if ( instant >= iCutover ) {
return iGregorianField . getAsText ( instant , locale ) ;
} else {
return iJulianField . getAsText ( instant , locale ) ;
}
}
public String getAsText ( int fieldValue , Locale locale ) {
return iGregorianField . getAsText ( fieldValue , locale ) ;
}
public String getAsShortText ( long instant , Locale locale ) {
if ( instant >= iCutover ) {
return iGregorianField . getAsShortText ( instant , locale ) ;
} else {
return iJulianField . getAsShortText ( instant , locale ) ;
}
}
public String getAsShortText ( int fieldValue , Locale locale ) {
return iGregorianField . getAsShortText ( fieldValue , locale ) ;
}
public long add ( long instant , int value ) {
return iGregorianField . add ( instant , value ) ;
}
public long add ( long instant , long value ) {
return iGregorianField . add ( instant , value ) ;
}
public int [] add ( ReadablePartial partial , int fieldIndex , int [] values , int valueToAdd ) {
if ( valueToAdd == 0 ) {
return values ;
}
if ( DateTimeUtils . isContiguous ( partial ) ) {
long instant = 0L ;
for ( int i = 0 , isize = partial . size () ; i < isize ; i ++ ) {
instant = partial . getFieldType ( i ) . getField ( GJChronology . this ) . set ( instant , values [ i ] ) ;
}
instant = add ( instant , valueToAdd ) ;
return GJChronology . this . get ( partial , instant ) ;
} else {
return super . add ( partial , fieldIndex , values , valueToAdd ) ;
}
}
public int getDifference ( long minuendInstant , long subtrahendInstant ) {
return iGregorianField . getDifference ( minuendInstant , subtrahendInstant ) ;
}
public long getDifferenceAsLong ( long minuendInstant , long subtrahendInstant ) {
return iGregorianField . getDifferenceAsLong ( minuendInstant , subtrahendInstant ) ;
}
public long set ( long instant , int value ) {
if ( instant >= iCutover ) {
instant = iGregorianField . set ( instant , value ) ;
if ( instant < iCutover ) {
if ( instant + iGapDuration < iCutover ) {
instant = gregorianToJulian ( instant ) ;
}
if ( get ( instant ) != value ) {
throw new IllegalFieldValueException
( iGregorianField . getType () , Integer . valueOf ( value ) , null , null ) ;
}
}
} else {
instant = iJulianField . set ( instant , value ) ;
if ( instant >= iCutover ) {
if ( instant - iGapDuration >= iCutover ) {
instant = julianToGregorian ( instant ) ;
}
if ( get ( instant ) != value ) {
throw new IllegalFieldValueException
( iJulianField . getType () , Integer . valueOf ( value ) , null , null ) ;
}
}
}
return instant ;
}
public long set ( long instant , String text , Locale locale ) {
if ( instant >= iCutover ) {
instant = iGregorianField . set ( instant , text , locale ) ;
if ( instant < iCutover ) {
if ( instant + iGapDuration < iCutover ) {
instant = gregorianToJulian ( instant ) ;
}
}
} else {
instant = iJulianField . set ( instant , text , locale ) ;
if ( instant >= iCutover ) {
if ( instant - iGapDuration >= iCutover ) {
instant = julianToGregorian ( instant ) ;
}
}
}
return instant ;
}
public DurationField getDurationField () {
return iDurationField ;
}
public DurationField getRangeDurationField () {
return iRangeDurationField ;
}
public boolean isLeap ( long instant ) {
if ( instant >= iCutover ) {
return iGregorianField . isLeap ( instant ) ;
} else {
return iJulianField . isLeap ( instant ) ;
}
}
public int getLeapAmount ( long instant ) {
if ( instant >= iCutover ) {
return iGregorianField . getLeapAmount ( instant ) ;
} else {
return iJulianField . getLeapAmount ( instant ) ;
}
}
public DurationField getLeapDurationField () {
return iGregorianField . getLeapDurationField () ;
}
public int getMinimumValue () {
return iJulianField . getMinimumValue () ;
}
public int getMinimumValue ( ReadablePartial partial ) {
return iJulianField . getMinimumValue ( partial ) ;
}
public int getMinimumValue ( ReadablePartial partial , int [] values ) {
return iJulianField . getMinimumValue ( partial , values ) ;
}
public int getMinimumValue ( long instant ) {
if ( instant < iCutover ) {
return iJulianField . getMinimumValue ( instant ) ;
}
int min = iGregorianField . getMinimumValue ( instant ) ;
instant = iGregorianField . set ( instant , min ) ;
if ( instant < iCutover ) {
min = iGregorianField . get ( iCutover ) ;
}
return min ;
}
public int getMaximumValue () {
return iGregorianField . getMaximumValue () ;
}
public int getMaximumValue ( long instant ) {
if ( instant >= iCutover ) {
return iGregorianField . getMaximumValue ( instant ) ;
}
int max = iJulianField . getMaximumValue ( instant ) ;
instant = iJulianField . set ( instant , max ) ;
if ( instant >= iCutover ) {
max = iJulianField . get ( iJulianField . add ( iCutover , - 1 ) ) ;
}
return max ;
}
public int getMaximumValue ( ReadablePartial partial ) {
long instant = GJChronology . getInstanceUTC () . set ( partial , 0L ) ;
return getMaximumValue ( instant ) ;
}
public int getMaximumValue ( ReadablePartial partial , int [] values ) {
Chronology chrono = GJChronology . getInstanceUTC () ;
long instant = 0L ;
for ( int i = 0 , isize = partial . size () ; i < isize ; i ++ ) {
DateTimeField field = partial . getFieldType ( i ) . getField ( chrono ) ;
if ( values [ i ] <= field . getMaximumValue ( instant ) ) {
instant = field . set ( instant , values [ i ] ) ;
}
}
return getMaximumValue ( instant ) ;
}
public long roundFloor ( long instant ) {
if ( instant >= iCutover ) {
instant = iGregorianField . roundFloor ( instant ) ;
if ( instant < iCutover ) {
if ( instant + iGapDuration < iCutover ) {
instant = gregorianToJulian ( instant ) ;
}
}
} else {
instant = iJulianField . roundFloor ( instant ) ;
}
return instant ;
}
public long roundCeiling ( long instant ) {
if ( instant >= iCutover ) {
instant = iGregorianField . roundCeiling ( instant ) ;
} else {
instant = iJulianField . roundCeiling ( instant ) ;
if ( instant >= iCutover ) {
if ( instant - iGapDuration >= iCutover ) {
instant = julianToGregorian ( instant ) ;
}
}
}
return instant ;
}
public int getMaximumTextLength ( Locale locale ) {
return Math . max ( iJulianField . getMaximumTextLength ( locale ) ,
iGregorianField . getMaximumTextLength ( locale ) ) ;
}
public int getMaximumShortTextLength ( Locale locale ) {
return Math . max ( iJulianField . getMaximumShortTextLength ( locale ) ,
iGregorianField . getMaximumShortTextLength ( locale ) ) ;
}
protected long julianToGregorian ( long instant ) {
if ( iConvertByWeekyear ) {
return julianToGregorianByWeekyear ( instant ) ;
} else {
return julianToGregorianByYear ( instant ) ;
}
}
protected long gregorianToJulian ( long instant ) {
if ( iConvertByWeekyear ) {
return gregorianToJulianByWeekyear ( instant ) ;
} else {
return gregorianToJulianByYear ( instant ) ;
}
}
public long add ( long instant , int value ) {
if ( instant >= iCutover ) {
instant = iGregorianField . add ( instant , value ) ;
if ( instant < iCutover ) {
if ( instant + iGapDuration < iCutover ) {
if ( iConvertByWeekyear ) {
int wyear = iGregorianChronology . weekyear () . get ( instant ) ;
if ( wyear <= 0 ) {
instant = iGregorianChronology . weekyear () . add ( instant , - 1 ) ;
}
} else {
int year = iGregorianChronology . year () . get ( instant ) ;
if ( year <= 0 ) {
instant = iGregorianChronology . year () . add ( instant , - 1 ) ;
}
}
instant = gregorianToJulian ( instant ) ;
}
}
} else {
instant = iJulianField . add ( instant , value ) ;
if ( instant >= iCutover ) {
if ( instant - iGapDuration >= iCutover ) {
instant = julianToGregorian ( instant ) ;
}
}
}
return instant ;
}
public long add ( long instant , long value ) {
if ( instant >= iCutover ) {
instant = iGregorianField . add ( instant , value ) ;
if ( instant < iCutover ) {
if ( instant + iGapDuration < iCutover ) {
if ( iConvertByWeekyear ) {
int wyear = iGregorianChronology . weekyear () . get ( instant ) ;
if ( wyear <= 0 ) {
instant = iGregorianChronology . weekyear () . add ( instant , - 1 ) ;
}
} else {
int year = iGregorianChronology . year () . get ( instant ) ;
if ( year <= 0 ) {
instant = iGregorianChronology . year () . add ( instant , - 1 ) ;
}
}
instant = gregorianToJulian ( instant ) ;
}
}
} else {
instant = iJulianField . add ( instant , value ) ;
if ( instant >= iCutover ) {
if ( instant - iGapDuration >= iCutover ) {
instant = julianToGregorian ( instant ) ;
}
}
}
return instant ;
}
public int getDifference ( long minuendInstant , long subtrahendInstant ) {
if ( minuendInstant >= iCutover ) {
if ( subtrahendInstant >= iCutover ) {
return iGregorianField . getDifference ( minuendInstant , subtrahendInstant ) ;
}
minuendInstant = gregorianToJulian ( minuendInstant ) ;
return iJulianField . getDifference ( minuendInstant , subtrahendInstant ) ;
} else {
if ( subtrahendInstant < iCutover ) {
return iJulianField . getDifference ( minuendInstant , subtrahendInstant ) ;
}
minuendInstant = julianToGregorian ( minuendInstant ) ;
return iGregorianField . getDifference ( minuendInstant , subtrahendInstant ) ;
}
}
public long getDifferenceAsLong ( long minuendInstant , long subtrahendInstant ) {
if ( minuendInstant >= iCutover ) {
if ( subtrahendInstant >= iCutover ) {
return iGregorianField . getDifferenceAsLong ( minuendInstant , subtrahendInstant ) ;
}
minuendInstant = gregorianToJulian ( minuendInstant ) ;
return iJulianField . getDifferenceAsLong ( minuendInstant , subtrahendInstant ) ;
} else {
if ( subtrahendInstant < iCutover ) {
return iJulianField . getDifferenceAsLong ( minuendInstant , subtrahendInstant ) ;
}
minuendInstant = julianToGregorian ( minuendInstant ) ;
return iGregorianField . getDifferenceAsLong ( minuendInstant , subtrahendInstant ) ;
}
}
public int getMinimumValue ( long instant ) {
if ( instant >= iCutover ) {
return iGregorianField . getMinimumValue ( instant ) ;
} else {
return iJulianField . getMinimumValue ( instant ) ;
}
}
public int getMaximumValue ( long instant ) {
if ( instant >= iCutover ) {
return iGregorianField . getMaximumValue ( instant ) ;
} else {
return iJulianField . getMaximumValue ( instant ) ;
}
}
public long add ( long instant , int value ) {
return iField . add ( instant , value ) ;
}
public long add ( long instant , long value ) {
return iField . add ( instant , value ) ;
}
public int getDifference ( long minuendInstant , long subtrahendInstant ) {
return iField . getDifference ( minuendInstant , subtrahendInstant ) ;
}
public long getDifferenceAsLong ( long minuendInstant , long subtrahendInstant ) {
return iField . getDifferenceAsLong ( minuendInstant , subtrahendInstant ) ;
}

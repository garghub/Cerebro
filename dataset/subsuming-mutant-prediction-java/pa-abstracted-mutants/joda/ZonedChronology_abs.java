public static ZonedChronology getInstance ( Chronology base , DateTimeZone zone ) {
if ( base == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
base = base . withUTC () ;
if ( base == null ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
if ( zone == null ) {
throw new IllegalArgumentException ( lr_3 ) ;
}
return new ZonedChronology ( base , zone ) ;
}
static boolean useTimeArithmetic ( DurationField field ) {
return field != null && field . getUnitMillis () < DateTimeConstants . MILLIS_PER_HOUR * 12 ;
}
public DateTimeZone getZone () {
return ( DateTimeZone ) getParam () ;
}
public Chronology withUTC () {
return getBase () ;
}
public Chronology withZone ( DateTimeZone zone ) {
if ( zone == null ) {
zone = DateTimeZone . getDefault () ;
}
if ( zone == getParam () ) {
return this ;
}
if ( zone == DateTimeZone . UTC ) {
return getBase () ;
}
return new ZonedChronology ( getBase () , zone ) ;
}
public long getDateTimeMillis ( int year , int monthOfYear , int dayOfMonth ,
int millisOfDay )
throws IllegalArgumentException
{
return localToUTC ( getBase () . getDateTimeMillis
( year , monthOfYear , dayOfMonth , millisOfDay ) ) ;
}
public long getDateTimeMillis ( int year , int monthOfYear , int dayOfMonth ,
int hourOfDay , int minuteOfHour ,
int secondOfMinute , int millisOfSecond )
throws IllegalArgumentException
{
return localToUTC ( getBase () . getDateTimeMillis
( year , monthOfYear , dayOfMonth ,
hourOfDay , minuteOfHour , secondOfMinute , millisOfSecond ) ) ;
}
public long getDateTimeMillis ( long instant ,
int hourOfDay , int minuteOfHour ,
int secondOfMinute , int millisOfSecond )
throws IllegalArgumentException
{
return localToUTC ( getBase () . getDateTimeMillis
( instant + getZone () . getOffset ( instant ) ,
hourOfDay , minuteOfHour , secondOfMinute , millisOfSecond ) ) ;
}
private long localToUTC ( long localInstant ) {
if ( localInstant == Long . MAX_VALUE ) {
return Long . MAX_VALUE ;
} else if ( localInstant == Long . MIN_VALUE ) {
return Long . MIN_VALUE ;
}
DateTimeZone zone = getZone () ;
int offset = zone . getOffsetFromLocal ( localInstant ) ;
long utcInstant = localInstant - offset ;
if ( localInstant > NEAR_ZERO && utcInstant < 0 ) {
return Long . MAX_VALUE ;
} else if ( localInstant < - NEAR_ZERO && utcInstant > 0 ) {
return Long . MIN_VALUE ;
}
int offsetBasedOnUtc = zone . getOffset ( utcInstant ) ;
if ( offset != offsetBasedOnUtc ) {
throw new IllegalInstantException ( localInstant , zone . getID () ) ;
}
return utcInstant ;
}
protected void assemble ( Fields fields ) {
HashMap < Object , Object > converted = new HashMap < Object , Object > () ;
fields . eras = convertField ( fields . eras , converted ) ;
fields . centuries = convertField ( fields . centuries , converted ) ;
fields . years = convertField ( fields . years , converted ) ;
fields . months = convertField ( fields . months , converted ) ;
fields . weekyears = convertField ( fields . weekyears , converted ) ;
fields . weeks = convertField ( fields . weeks , converted ) ;
fields . days = convertField ( fields . days , converted ) ;
fields . halfdays = convertField ( fields . halfdays , converted ) ;
fields . hours = convertField ( fields . hours , converted ) ;
fields . minutes = convertField ( fields . minutes , converted ) ;
fields . seconds = convertField ( fields . seconds , converted ) ;
fields . millis = convertField ( fields . millis , converted ) ;
fields . year = convertField ( fields . year , converted ) ;
fields . yearOfEra = convertField ( fields . yearOfEra , converted ) ;
fields . yearOfCentury = convertField ( fields . yearOfCentury , converted ) ;
fields . centuryOfEra = convertField ( fields . centuryOfEra , converted ) ;
fields . era = convertField ( fields . era , converted ) ;
fields . dayOfWeek = convertField ( fields . dayOfWeek , converted ) ;
fields . dayOfMonth = convertField ( fields . dayOfMonth , converted ) ;
fields . dayOfYear = convertField ( fields . dayOfYear , converted ) ;
fields . monthOfYear = convertField ( fields . monthOfYear , converted ) ;
fields . weekOfWeekyear = convertField ( fields . weekOfWeekyear , converted ) ;
fields . weekyear = convertField ( fields . weekyear , converted ) ;
fields . weekyearOfCentury = convertField ( fields . weekyearOfCentury , converted ) ;
fields . millisOfSecond = convertField ( fields . millisOfSecond , converted ) ;
fields . millisOfDay = convertField ( fields . millisOfDay , converted ) ;
fields . secondOfMinute = convertField ( fields . secondOfMinute , converted ) ;
fields . secondOfDay = convertField ( fields . secondOfDay , converted ) ;
fields . minuteOfHour = convertField ( fields . minuteOfHour , converted ) ;
fields . minuteOfDay = convertField ( fields . minuteOfDay , converted ) ;
fields . hourOfDay = convertField ( fields . hourOfDay , converted ) ;
fields . hourOfHalfday = convertField ( fields . hourOfHalfday , converted ) ;
fields . clockhourOfDay = convertField ( fields . clockhourOfDay , converted ) ;
fields . clockhourOfHalfday = convertField ( fields . clockhourOfHalfday , converted ) ;
fields . halfdayOfDay = convertField ( fields . halfdayOfDay , converted ) ;
}
private DurationField convertField ( DurationField field , HashMap < Object , Object > converted ) {
if ( field == null || ! field . isSupported () ) {
return field ;
}
if ( converted . containsKey ( field ) ) {
return ( DurationField ) converted . get ( field ) ;
}
ZonedDurationField zonedField = new ZonedDurationField ( field , getZone () ) ;
converted . put ( field , zonedField ) ;
return zonedField ;
}
private DateTimeField convertField ( DateTimeField field , HashMap < Object , Object > converted ) {
if ( field == null || ! field . isSupported () ) {
return field ;
}
if ( converted . containsKey ( field ) ) {
return ( DateTimeField ) converted . get ( field ) ;
}
ZonedDateTimeField zonedField =
new ZonedDateTimeField ( field , getZone () ,
convertField ( field . getDurationField () , converted ) ,
convertField ( field . getRangeDurationField () , converted ) ,
convertField ( field . getLeapDurationField () , converted ) ) ;
converted . put ( field , zonedField ) ;
return zonedField ;
}
public boolean equals ( Object obj ) {
if ( this == obj ) {
return true ;
}
if ( obj instanceof ZonedChronology == false ) {
return false ;
}
ZonedChronology chrono = ( ZonedChronology ) obj ;
return
getBase () . equals ( chrono . getBase () ) &&
getZone () . equals ( chrono . getZone () ) ;
}
public int hashCode () {
return 326565 + getZone () . hashCode () * 11 + getBase () . hashCode () * 7 ;
}
public String toString () {
return lr_4 + getBase () + lr_5 + getZone () . getID () + ']' ;
}
public boolean isPrecise () {
return iTimeField ? iField . isPrecise () : iField . isPrecise () && this . iZone . isFixed () ;
}
public long getUnitMillis () {
return iField . getUnitMillis () ;
}
public int getValue ( long duration , long instant ) {
return iField . getValue ( duration , addOffset ( instant ) ) ;
}
public long getValueAsLong ( long duration , long instant ) {
return iField . getValueAsLong ( duration , addOffset ( instant ) ) ;
}
public long getMillis ( int value , long instant ) {
return iField . getMillis ( value , addOffset ( instant ) ) ;
}
public long getMillis ( long value , long instant ) {
return iField . getMillis ( value , addOffset ( instant ) ) ;
}
public long add ( long instant , int value ) {
int offset = getOffsetToAdd ( instant ) ;
instant = iField . add ( instant + offset , value ) ;
return instant - ( iTimeField ? offset : getOffsetFromLocalToSubtract ( instant ) ) ;
}
public long add ( long instant , long value ) {
int offset = getOffsetToAdd ( instant ) ;
instant = iField . add ( instant + offset , value ) ;
return instant - ( iTimeField ? offset : getOffsetFromLocalToSubtract ( instant ) ) ;
}
public int getDifference ( long minuendInstant , long subtrahendInstant ) {
int offset = getOffsetToAdd ( subtrahendInstant ) ;
return iField . getDifference
( minuendInstant + ( iTimeField ? offset : getOffsetToAdd ( minuendInstant ) ) ,
subtrahendInstant + offset ) ;
}
public long getDifferenceAsLong ( long minuendInstant , long subtrahendInstant ) {
int offset = getOffsetToAdd ( subtrahendInstant ) ;
return iField . getDifferenceAsLong
( minuendInstant + ( iTimeField ? offset : getOffsetToAdd ( minuendInstant ) ) ,
subtrahendInstant + offset ) ;
}
private int getOffsetToAdd ( long instant ) {
int offset = this . iZone . getOffset ( instant ) ;
long sum = instant + offset ;
if ( ( instant ^ sum ) < 0 && ( instant ^ offset ) >= 0 ) {
throw new ArithmeticException ( lr_6 ) ;
}
return offset ;
}
private int getOffsetFromLocalToSubtract ( long instant ) {
int offset = this . iZone . getOffsetFromLocal ( instant ) ;
long diff = instant - offset ;
if ( ( instant ^ diff ) < 0 && ( instant ^ offset ) < 0 ) {
throw new ArithmeticException ( lr_7 ) ;
}
return offset ;
}
private long addOffset ( long instant ) {
return iZone . convertUTCToLocal ( instant ) ;
}
@Override
public boolean equals ( Object obj ) {
if ( this == obj ) {
return true ;
} else if ( obj instanceof ZonedDurationField ) {
ZonedDurationField other = ( ZonedDurationField ) obj ;
return iField . equals ( other . iField ) &&
iZone . equals ( other . iZone ) ;
}
return false ;
}
@Override
public int hashCode () {
return iField . hashCode () ^ iZone . hashCode () ;
}
public boolean isLenient () {
return iField . isLenient () ;
}
public int get ( long instant ) {
long localInstant = iZone . convertUTCToLocal ( instant ) ;
return iField . get ( localInstant ) ;
}
public String getAsText ( long instant , Locale locale ) {
long localInstant = iZone . convertUTCToLocal ( instant ) ;
return iField . getAsText ( localInstant , locale ) ;
}
public String getAsShortText ( long instant , Locale locale ) {
long localInstant = iZone . convertUTCToLocal ( instant ) ;
return iField . getAsShortText ( localInstant , locale ) ;
}
public String getAsText ( int fieldValue , Locale locale ) {
return iField . getAsText ( fieldValue , locale ) ;
}
public String getAsShortText ( int fieldValue , Locale locale ) {
return iField . getAsShortText ( fieldValue , locale ) ;
}
public long add ( long instant , int value ) {
if ( iTimeField ) {
int offset = getOffsetToAdd ( instant ) ;
long localInstant = iField . add ( instant + offset , value ) ;
return localInstant - offset ;
} else {
long localInstant = iZone . convertUTCToLocal ( instant ) ;
localInstant = iField . add ( localInstant , value ) ;
return iZone . convertLocalToUTC ( localInstant , false , instant ) ;
}
}
public long add ( long instant , long value ) {
if ( iTimeField ) {
int offset = getOffsetToAdd ( instant ) ;
long localInstant = iField . add ( instant + offset , value ) ;
return localInstant - offset ;
} else {
long localInstant = iZone . convertUTCToLocal ( instant ) ;
localInstant = iField . add ( localInstant , value ) ;
return iZone . convertLocalToUTC ( localInstant , false , instant ) ;
}
}
public long addWrapField ( long instant , int value ) {
if ( iTimeField ) {
int offset = getOffsetToAdd ( instant ) ;
long localInstant = iField . addWrapField ( instant + offset , value ) ;
return localInstant - offset ;
} else {
long localInstant = iZone . convertUTCToLocal ( instant ) ;
localInstant = iField . addWrapField ( localInstant , value ) ;
return iZone . convertLocalToUTC ( localInstant , false , instant ) ;
}
}
public long set ( long instant , int value ) {
long localInstant = iZone . convertUTCToLocal ( instant ) ;
localInstant = iField . set ( localInstant , value ) ;
long result = iZone . convertLocalToUTC ( localInstant , false , instant ) ;
if ( get ( result ) != value ) {
IllegalInstantException cause = new IllegalInstantException ( localInstant , iZone . getID () ) ;
IllegalFieldValueException ex = new IllegalFieldValueException ( iField . getType () , Integer . valueOf ( value ) , cause . getMessage () ) ;
ex . initCause ( cause ) ;
throw ex ;
}
return result ;
}
public long set ( long instant , String text , Locale locale ) {
long localInstant = iZone . convertUTCToLocal ( instant ) ;
localInstant = iField . set ( localInstant , text , locale ) ;
return iZone . convertLocalToUTC ( localInstant , false , instant ) ;
}
public int getDifference ( long minuendInstant , long subtrahendInstant ) {
int offset = getOffsetToAdd ( subtrahendInstant ) ;
return iField . getDifference
( minuendInstant + ( iTimeField ? offset : getOffsetToAdd ( minuendInstant ) ) ,
subtrahendInstant + offset ) ;
}
public long getDifferenceAsLong ( long minuendInstant , long subtrahendInstant ) {
int offset = getOffsetToAdd ( subtrahendInstant ) ;
return iField . getDifferenceAsLong
( minuendInstant + ( iTimeField ? offset : getOffsetToAdd ( minuendInstant ) ) ,
subtrahendInstant + offset ) ;
}
public final DurationField getDurationField () {
return iDurationField ;
}
public final DurationField getRangeDurationField () {
return iRangeDurationField ;
}
public boolean isLeap ( long instant ) {
long localInstant = iZone . convertUTCToLocal ( instant ) ;
return iField . isLeap ( localInstant ) ;
}
public int getLeapAmount ( long instant ) {
long localInstant = iZone . convertUTCToLocal ( instant ) ;
return iField . getLeapAmount ( localInstant ) ;
}
public final DurationField getLeapDurationField () {
return iLeapDurationField ;
}
public long roundFloor ( long instant ) {
if ( iTimeField ) {
int offset = getOffsetToAdd ( instant ) ;
instant = iField . roundFloor ( instant + offset ) ;
return instant - offset ;
} else {
long localInstant = iZone . convertUTCToLocal ( instant ) ;
localInstant = iField . roundFloor ( localInstant ) ;
return iZone . convertLocalToUTC ( localInstant , false , instant ) ;
}
}
public long roundCeiling ( long instant ) {
if ( iTimeField ) {
int offset = getOffsetToAdd ( instant ) ;
instant = iField . roundCeiling ( instant + offset ) ;
return instant - offset ;
} else {
long localInstant = iZone . convertUTCToLocal ( instant ) ;
localInstant = iField . roundCeiling ( localInstant ) ;
return iZone . convertLocalToUTC ( localInstant , false , instant ) ;
}
}
public long remainder ( long instant ) {
long localInstant = iZone . convertUTCToLocal ( instant ) ;
return iField . remainder ( localInstant ) ;
}
public int getMinimumValue () {
return iField . getMinimumValue () ;
}
public int getMinimumValue ( long instant ) {
long localInstant = iZone . convertUTCToLocal ( instant ) ;
return iField . getMinimumValue ( localInstant ) ;
}
public int getMinimumValue ( ReadablePartial instant ) {
return iField . getMinimumValue ( instant ) ;
}
public int getMinimumValue ( ReadablePartial instant , int [] values ) {
return iField . getMinimumValue ( instant , values ) ;
}
public int getMaximumValue () {
return iField . getMaximumValue () ;
}
public int getMaximumValue ( long instant ) {
long localInstant = iZone . convertUTCToLocal ( instant ) ;
return iField . getMaximumValue ( localInstant ) ;
}
public int getMaximumValue ( ReadablePartial instant ) {
return iField . getMaximumValue ( instant ) ;
}
public int getMaximumValue ( ReadablePartial instant , int [] values ) {
return iField . getMaximumValue ( instant , values ) ;
}
public int getMaximumTextLength ( Locale locale ) {
return iField . getMaximumTextLength ( locale ) ;
}
public int getMaximumShortTextLength ( Locale locale ) {
return iField . getMaximumShortTextLength ( locale ) ;
}
private int getOffsetToAdd ( long instant ) {
int offset = this . iZone . getOffset ( instant ) ;
long sum = instant + offset ;
if ( ( instant ^ sum ) < 0 && ( instant ^ offset ) >= 0 ) {
throw new ArithmeticException ( lr_6 ) ;
}
return offset ;
}
@Override
public boolean equals ( Object obj ) {
if ( this == obj ) {
return true ;
} else if ( obj instanceof ZonedDateTimeField ) {
ZonedDateTimeField other = ( ZonedDateTimeField ) obj ;
return iField . equals ( other . iField ) &&
iZone . equals ( other . iZone ) &&
iDurationField . equals ( other . iDurationField ) &&
iRangeDurationField . equals ( other . iRangeDurationField ) ;
}
return false ;
}
@Override
public int hashCode () {
return iField . hashCode () ^ iZone . hashCode () ;
}

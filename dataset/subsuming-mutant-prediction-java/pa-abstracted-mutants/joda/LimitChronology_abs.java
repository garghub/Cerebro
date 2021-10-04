public static LimitChronology getInstance ( Chronology base ,
ReadableDateTime lowerLimit ,
ReadableDateTime upperLimit ) {
if ( base == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
lowerLimit = lowerLimit == null ? null : lowerLimit . toDateTime () ;
upperLimit = upperLimit == null ? null : upperLimit . toDateTime () ;
if ( lowerLimit != null && upperLimit != null && ! lowerLimit . isBefore ( upperLimit ) ) {
throw new IllegalArgumentException
( lr_2 ) ;
}
return new LimitChronology ( base , ( DateTime ) lowerLimit , ( DateTime ) upperLimit ) ;
}
public DateTime getLowerLimit () {
return iLowerLimit ;
}
public DateTime getUpperLimit () {
return iUpperLimit ;
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
if ( zone == DateTimeZone . UTC && iWithUTC != null ) {
return iWithUTC ;
}
DateTime lowerLimit = iLowerLimit ;
if ( lowerLimit != null ) {
MutableDateTime mdt = lowerLimit . toMutableDateTime () ;
mdt . setZoneRetainFields ( zone ) ;
lowerLimit = mdt . toDateTime () ;
}
DateTime upperLimit = iUpperLimit ;
if ( upperLimit != null ) {
MutableDateTime mdt = upperLimit . toMutableDateTime () ;
mdt . setZoneRetainFields ( zone ) ;
upperLimit = mdt . toDateTime () ;
}
LimitChronology chrono = getInstance
( getBase () . withZone ( zone ) , lowerLimit , upperLimit ) ;
if ( zone == DateTimeZone . UTC ) {
iWithUTC = chrono ;
}
return chrono ;
}
public long getDateTimeMillis ( int year , int monthOfYear , int dayOfMonth ,
int millisOfDay )
throws IllegalArgumentException
{
long instant = getBase () . getDateTimeMillis ( year , monthOfYear , dayOfMonth , millisOfDay ) ;
checkLimits ( instant , lr_3 ) ;
return instant ;
}
public long getDateTimeMillis ( int year , int monthOfYear , int dayOfMonth ,
int hourOfDay , int minuteOfHour ,
int secondOfMinute , int millisOfSecond )
throws IllegalArgumentException
{
long instant = getBase () . getDateTimeMillis
( year , monthOfYear , dayOfMonth ,
hourOfDay , minuteOfHour , secondOfMinute , millisOfSecond ) ;
checkLimits ( instant , lr_3 ) ;
return instant ;
}
public long getDateTimeMillis ( long instant ,
int hourOfDay , int minuteOfHour ,
int secondOfMinute , int millisOfSecond )
throws IllegalArgumentException
{
checkLimits ( instant , null ) ;
instant = getBase () . getDateTimeMillis
( instant , hourOfDay , minuteOfHour , secondOfMinute , millisOfSecond ) ;
checkLimits ( instant , lr_3 ) ;
return instant ;
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
LimitDurationField limitField = new LimitDurationField ( field ) ;
converted . put ( field , limitField ) ;
return limitField ;
}
private DateTimeField convertField ( DateTimeField field , HashMap < Object , Object > converted ) {
if ( field == null || ! field . isSupported () ) {
return field ;
}
if ( converted . containsKey ( field ) ) {
return ( DateTimeField ) converted . get ( field ) ;
}
LimitDateTimeField limitField =
new LimitDateTimeField ( field ,
convertField ( field . getDurationField () , converted ) ,
convertField ( field . getRangeDurationField () , converted ) ,
convertField ( field . getLeapDurationField () , converted ) ) ;
converted . put ( field , limitField ) ;
return limitField ;
}
void checkLimits ( long instant , String desc ) {
DateTime limit ;
if ( ( limit = iLowerLimit ) != null && instant < limit . getMillis () ) {
throw new LimitException ( desc , true ) ;
}
if ( ( limit = iUpperLimit ) != null && instant >= limit . getMillis () ) {
throw new LimitException ( desc , false ) ;
}
}
public boolean equals ( Object obj ) {
if ( this == obj ) {
return true ;
}
if ( obj instanceof LimitChronology == false ) {
return false ;
}
LimitChronology chrono = ( LimitChronology ) obj ;
return
getBase () . equals ( chrono . getBase () ) &&
FieldUtils . equals ( getLowerLimit () , chrono . getLowerLimit () ) &&
FieldUtils . equals ( getUpperLimit () , chrono . getUpperLimit () ) ;
}
public int hashCode () {
int hash = 317351877 ;
hash += ( getLowerLimit () != null ? getLowerLimit () . hashCode () : 0 ) ;
hash += ( getUpperLimit () != null ? getUpperLimit () . hashCode () : 0 ) ;
hash += getBase () . hashCode () * 7 ;
return hash ;
}
public String toString () {
return lr_4 + getBase () . toString () + lr_5 +
( getLowerLimit () == null ? lr_6 : getLowerLimit () . toString () ) + lr_5 +
( getUpperLimit () == null ? lr_6 : getUpperLimit () . toString () ) + ']' ;
}
public String getMessage () {
StringBuffer buf = new StringBuffer ( 85 ) ;
buf . append ( lr_7 ) ;
String desc = super . getMessage () ;
if ( desc != null ) {
buf . append ( ' ' ) ;
buf . append ( desc ) ;
}
buf . append ( lr_8 ) ;
DateTimeFormatter p = ISODateTimeFormat . dateTime () ;
p = p . withChronology ( getBase () ) ;
if ( iIsLow ) {
buf . append ( lr_9 ) ;
p . printTo ( buf , getLowerLimit () . getMillis () ) ;
} else {
buf . append ( lr_10 ) ;
p . printTo ( buf , getUpperLimit () . getMillis () ) ;
}
buf . append ( lr_11 ) ;
buf . append ( getBase () ) ;
buf . append ( ')' ) ;
return buf . toString () ;
}
public String toString () {
return lr_12 + getMessage () ;
}
public int getValue ( long duration , long instant ) {
checkLimits ( instant , null ) ;
return getWrappedField () . getValue ( duration , instant ) ;
}
public long getValueAsLong ( long duration , long instant ) {
checkLimits ( instant , null ) ;
return getWrappedField () . getValueAsLong ( duration , instant ) ;
}
public long getMillis ( int value , long instant ) {
checkLimits ( instant , null ) ;
return getWrappedField () . getMillis ( value , instant ) ;
}
public long getMillis ( long value , long instant ) {
checkLimits ( instant , null ) ;
return getWrappedField () . getMillis ( value , instant ) ;
}
public long add ( long instant , int amount ) {
checkLimits ( instant , null ) ;
long result = getWrappedField () . add ( instant , amount ) ;
checkLimits ( result , lr_3 ) ;
return result ;
}
public long add ( long instant , long amount ) {
checkLimits ( instant , null ) ;
long result = getWrappedField () . add ( instant , amount ) ;
checkLimits ( result , lr_3 ) ;
return result ;
}
public int getDifference ( long minuendInstant , long subtrahendInstant ) {
checkLimits ( minuendInstant , lr_13 ) ;
checkLimits ( subtrahendInstant , lr_14 ) ;
return getWrappedField () . getDifference ( minuendInstant , subtrahendInstant ) ;
}
public long getDifferenceAsLong ( long minuendInstant , long subtrahendInstant ) {
checkLimits ( minuendInstant , lr_13 ) ;
checkLimits ( subtrahendInstant , lr_14 ) ;
return getWrappedField () . getDifferenceAsLong ( minuendInstant , subtrahendInstant ) ;
}
public int get ( long instant ) {
checkLimits ( instant , null ) ;
return getWrappedField () . get ( instant ) ;
}
public String getAsText ( long instant , Locale locale ) {
checkLimits ( instant , null ) ;
return getWrappedField () . getAsText ( instant , locale ) ;
}
public String getAsShortText ( long instant , Locale locale ) {
checkLimits ( instant , null ) ;
return getWrappedField () . getAsShortText ( instant , locale ) ;
}
public long add ( long instant , int amount ) {
checkLimits ( instant , null ) ;
long result = getWrappedField () . add ( instant , amount ) ;
checkLimits ( result , lr_3 ) ;
return result ;
}
public long add ( long instant , long amount ) {
checkLimits ( instant , null ) ;
long result = getWrappedField () . add ( instant , amount ) ;
checkLimits ( result , lr_3 ) ;
return result ;
}
public long addWrapField ( long instant , int amount ) {
checkLimits ( instant , null ) ;
long result = getWrappedField () . addWrapField ( instant , amount ) ;
checkLimits ( result , lr_3 ) ;
return result ;
}
public int getDifference ( long minuendInstant , long subtrahendInstant ) {
checkLimits ( minuendInstant , lr_13 ) ;
checkLimits ( subtrahendInstant , lr_14 ) ;
return getWrappedField () . getDifference ( minuendInstant , subtrahendInstant ) ;
}
public long getDifferenceAsLong ( long minuendInstant , long subtrahendInstant ) {
checkLimits ( minuendInstant , lr_13 ) ;
checkLimits ( subtrahendInstant , lr_14 ) ;
return getWrappedField () . getDifferenceAsLong ( minuendInstant , subtrahendInstant ) ;
}
public long set ( long instant , int value ) {
checkLimits ( instant , null ) ;
long result = getWrappedField () . set ( instant , value ) ;
checkLimits ( result , lr_3 ) ;
return result ;
}
public long set ( long instant , String text , Locale locale ) {
checkLimits ( instant , null ) ;
long result = getWrappedField () . set ( instant , text , locale ) ;
checkLimits ( result , lr_3 ) ;
return result ;
}
public final DurationField getDurationField () {
return iDurationField ;
}
public final DurationField getRangeDurationField () {
return iRangeDurationField ;
}
public boolean isLeap ( long instant ) {
checkLimits ( instant , null ) ;
return getWrappedField () . isLeap ( instant ) ;
}
public int getLeapAmount ( long instant ) {
checkLimits ( instant , null ) ;
return getWrappedField () . getLeapAmount ( instant ) ;
}
public final DurationField getLeapDurationField () {
return iLeapDurationField ;
}
public long roundFloor ( long instant ) {
checkLimits ( instant , null ) ;
long result = getWrappedField () . roundFloor ( instant ) ;
checkLimits ( result , lr_3 ) ;
return result ;
}
public long roundCeiling ( long instant ) {
checkLimits ( instant , null ) ;
long result = getWrappedField () . roundCeiling ( instant ) ;
checkLimits ( result , lr_3 ) ;
return result ;
}
public long roundHalfFloor ( long instant ) {
checkLimits ( instant , null ) ;
long result = getWrappedField () . roundHalfFloor ( instant ) ;
checkLimits ( result , lr_3 ) ;
return result ;
}
public long roundHalfCeiling ( long instant ) {
checkLimits ( instant , null ) ;
long result = getWrappedField () . roundHalfCeiling ( instant ) ;
checkLimits ( result , lr_3 ) ;
return result ;
}
public long roundHalfEven ( long instant ) {
checkLimits ( instant , null ) ;
long result = getWrappedField () . roundHalfEven ( instant ) ;
checkLimits ( result , lr_3 ) ;
return result ;
}
public long remainder ( long instant ) {
checkLimits ( instant , null ) ;
long result = getWrappedField () . remainder ( instant ) ;
checkLimits ( result , lr_3 ) ;
return result ;
}
public int getMinimumValue ( long instant ) {
checkLimits ( instant , null ) ;
return getWrappedField () . getMinimumValue ( instant ) ;
}
public int getMaximumValue ( long instant ) {
checkLimits ( instant , null ) ;
return getWrappedField () . getMaximumValue ( instant ) ;
}
public int getMaximumTextLength ( Locale locale ) {
return getWrappedField () . getMaximumTextLength ( locale ) ;
}
public int getMaximumShortTextLength ( Locale locale ) {
return getWrappedField () . getMaximumShortTextLength ( locale ) ;
}

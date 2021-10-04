public static DateTimeFieldType millisOfSecond () {
return MILLIS_OF_SECOND_TYPE ;
}
public static DateTimeFieldType millisOfDay () {
return MILLIS_OF_DAY_TYPE ;
}
public static DateTimeFieldType secondOfMinute () {
return SECOND_OF_MINUTE_TYPE ;
}
public static DateTimeFieldType secondOfDay () {
return SECOND_OF_DAY_TYPE ;
}
public static DateTimeFieldType minuteOfHour () {
return MINUTE_OF_HOUR_TYPE ;
}
public static DateTimeFieldType minuteOfDay () {
return MINUTE_OF_DAY_TYPE ;
}
public static DateTimeFieldType hourOfDay () {
return HOUR_OF_DAY_TYPE ;
}
public static DateTimeFieldType clockhourOfDay () {
return CLOCKHOUR_OF_DAY_TYPE ;
}
public static DateTimeFieldType hourOfHalfday () {
return HOUR_OF_HALFDAY_TYPE ;
}
public static DateTimeFieldType clockhourOfHalfday () {
return CLOCKHOUR_OF_HALFDAY_TYPE ;
}
public static DateTimeFieldType halfdayOfDay () {
return HALFDAY_OF_DAY_TYPE ;
}
public static DateTimeFieldType dayOfWeek () {
return DAY_OF_WEEK_TYPE ;
}
public static DateTimeFieldType dayOfMonth () {
return DAY_OF_MONTH_TYPE ;
}
public static DateTimeFieldType dayOfYear () {
return DAY_OF_YEAR_TYPE ;
}
public static DateTimeFieldType weekOfWeekyear () {
return WEEK_OF_WEEKYEAR_TYPE ;
}
public static DateTimeFieldType weekyear () {
return WEEKYEAR_TYPE ;
}
public static DateTimeFieldType weekyearOfCentury () {
return WEEKYEAR_OF_CENTURY_TYPE ;
}
public static DateTimeFieldType monthOfYear () {
return MONTH_OF_YEAR_TYPE ;
}
public static DateTimeFieldType year () {
return YEAR_TYPE ;
}
public static DateTimeFieldType yearOfEra () {
return YEAR_OF_ERA_TYPE ;
}
public static DateTimeFieldType yearOfCentury () {
return YEAR_OF_CENTURY_TYPE ;
}
public static DateTimeFieldType centuryOfEra () {
return CENTURY_OF_ERA_TYPE ;
}
public static DateTimeFieldType era () {
return ERA_TYPE ;
}
public String getName () {
return iName ;
}
public boolean isSupported ( Chronology chronology ) {
return getField ( chronology ) . isSupported () ;
}
public String toString () {
return getName () ;
}
public DurationFieldType getDurationType () {
return iUnitType ;
}
public DurationFieldType getRangeDurationType () {
return iRangeType ;
}
@Override
public boolean equals ( Object obj ) {
if ( this == obj ) {
return true ;
}
if ( obj instanceof StandardDateTimeFieldType ) {
return iOrdinal == ( ( StandardDateTimeFieldType ) obj ) . iOrdinal ;
}
return false ;
}
@Override
public int hashCode () {
return ( 1 << iOrdinal ) ;
}
public DateTimeField getField ( Chronology chronology ) {
chronology = DateTimeUtils . getChronology ( chronology ) ;
switch ( iOrdinal ) {
case ERA :
return chronology . era () ;
case YEAR_OF_ERA :
return chronology . yearOfEra () ;
case CENTURY_OF_ERA :
return chronology . centuryOfEra () ;
case YEAR_OF_CENTURY :
return chronology . yearOfCentury () ;
case YEAR :
return chronology . year () ;
case DAY_OF_YEAR :
return chronology . dayOfYear () ;
case MONTH_OF_YEAR :
return chronology . monthOfYear () ;
case DAY_OF_MONTH :
return chronology . dayOfMonth () ;
case WEEKYEAR_OF_CENTURY :
return chronology . weekyearOfCentury () ;
case WEEKYEAR :
return chronology . weekyear () ;
case WEEK_OF_WEEKYEAR :
return chronology . weekOfWeekyear () ;
case DAY_OF_WEEK :
return chronology . dayOfWeek () ;
case HALFDAY_OF_DAY :
return chronology . halfdayOfDay () ;
case HOUR_OF_HALFDAY :
return chronology . hourOfHalfday () ;
case CLOCKHOUR_OF_HALFDAY :
return chronology . clockhourOfHalfday () ;
case CLOCKHOUR_OF_DAY :
return chronology . clockhourOfDay () ;
case HOUR_OF_DAY :
return chronology . hourOfDay () ;
case MINUTE_OF_DAY :
return chronology . minuteOfDay () ;
case MINUTE_OF_HOUR :
return chronology . minuteOfHour () ;
case SECOND_OF_DAY :
return chronology . secondOfDay () ;
case SECOND_OF_MINUTE :
return chronology . secondOfMinute () ;
case MILLIS_OF_DAY :
return chronology . millisOfDay () ;
case MILLIS_OF_SECOND :
return chronology . millisOfSecond () ;
default:
throw new InternalError () ;
}
}
private Object readResolve () {
switch ( iOrdinal ) {
case ERA :
return ERA_TYPE ;
case YEAR_OF_ERA :
return YEAR_OF_ERA_TYPE ;
case CENTURY_OF_ERA :
return CENTURY_OF_ERA_TYPE ;
case YEAR_OF_CENTURY :
return YEAR_OF_CENTURY_TYPE ;
case YEAR :
return YEAR_TYPE ;
case DAY_OF_YEAR :
return DAY_OF_YEAR_TYPE ;
case MONTH_OF_YEAR :
return MONTH_OF_YEAR_TYPE ;
case DAY_OF_MONTH :
return DAY_OF_MONTH_TYPE ;
case WEEKYEAR_OF_CENTURY :
return WEEKYEAR_OF_CENTURY_TYPE ;
case WEEKYEAR :
return WEEKYEAR_TYPE ;
case WEEK_OF_WEEKYEAR :
return WEEK_OF_WEEKYEAR_TYPE ;
case DAY_OF_WEEK :
return DAY_OF_WEEK_TYPE ;
case HALFDAY_OF_DAY :
return HALFDAY_OF_DAY_TYPE ;
case HOUR_OF_HALFDAY :
return HOUR_OF_HALFDAY_TYPE ;
case CLOCKHOUR_OF_HALFDAY :
return CLOCKHOUR_OF_HALFDAY_TYPE ;
case CLOCKHOUR_OF_DAY :
return CLOCKHOUR_OF_DAY_TYPE ;
case HOUR_OF_DAY :
return HOUR_OF_DAY_TYPE ;
case MINUTE_OF_DAY :
return MINUTE_OF_DAY_TYPE ;
case MINUTE_OF_HOUR :
return MINUTE_OF_HOUR_TYPE ;
case SECOND_OF_DAY :
return SECOND_OF_DAY_TYPE ;
case SECOND_OF_MINUTE :
return SECOND_OF_MINUTE_TYPE ;
case MILLIS_OF_DAY :
return MILLIS_OF_DAY_TYPE ;
case MILLIS_OF_SECOND :
return MILLIS_OF_SECOND_TYPE ;
default:
return this ;
}
}

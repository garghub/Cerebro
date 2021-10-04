public int get ( DateTimeFieldType type ) {
if ( type == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
return type . getField ( getChronology () ) . get ( getMillis () ) ;
}
public int getEra () {
return getChronology () . era () . get ( getMillis () ) ;
}
public int getCenturyOfEra () {
return getChronology () . centuryOfEra () . get ( getMillis () ) ;
}
public int getYearOfEra () {
return getChronology () . yearOfEra () . get ( getMillis () ) ;
}
public int getYearOfCentury () {
return getChronology () . yearOfCentury () . get ( getMillis () ) ;
}
public int getYear () {
return getChronology () . year () . get ( getMillis () ) ;
}
public int getWeekyear () {
return getChronology () . weekyear () . get ( getMillis () ) ;
}
public int getMonthOfYear () {
return getChronology () . monthOfYear () . get ( getMillis () ) ;
}
public int getWeekOfWeekyear () {
return getChronology () . weekOfWeekyear () . get ( getMillis () ) ;
}
public int getDayOfYear () {
return getChronology () . dayOfYear () . get ( getMillis () ) ;
}
public int getDayOfMonth () {
return getChronology () . dayOfMonth () . get ( getMillis () ) ;
}
public int getDayOfWeek () {
return getChronology () . dayOfWeek () . get ( getMillis () ) ;
}
public int getHourOfDay () {
return getChronology () . hourOfDay () . get ( getMillis () ) ;
}
public int getMinuteOfDay () {
return getChronology () . minuteOfDay () . get ( getMillis () ) ;
}
public int getMinuteOfHour () {
return getChronology () . minuteOfHour () . get ( getMillis () ) ;
}
public int getSecondOfDay () {
return getChronology () . secondOfDay () . get ( getMillis () ) ;
}
public int getSecondOfMinute () {
return getChronology () . secondOfMinute () . get ( getMillis () ) ;
}
public int getMillisOfDay () {
return getChronology () . millisOfDay () . get ( getMillis () ) ;
}
public int getMillisOfSecond () {
return getChronology () . millisOfSecond () . get ( getMillis () ) ;
}
public Calendar toCalendar ( Locale locale ) {
if ( locale == null ) {
locale = Locale . getDefault () ;
}
DateTimeZone zone = getZone () ;
Calendar cal = Calendar . getInstance ( zone . toTimeZone () , locale ) ;
cal . setTime ( toDate () ) ;
return cal ;
}
public GregorianCalendar toGregorianCalendar () {
DateTimeZone zone = getZone () ;
GregorianCalendar cal = new GregorianCalendar ( zone . toTimeZone () ) ;
cal . setTime ( toDate () ) ;
return cal ;
}
@ToString
public String toString () {
return super . toString () ;
}
public String toString ( String pattern ) {
if ( pattern == null ) {
return toString () ;
}
return DateTimeFormat . forPattern ( pattern ) . print ( this ) ;
}
public String toString ( String pattern , Locale locale ) throws IllegalArgumentException {
if ( pattern == null ) {
return toString () ;
}
return DateTimeFormat . forPattern ( pattern ) . withLocale ( locale ) . print ( this ) ;
}

public static LenientChronology getInstance ( Chronology base ) {
if ( base == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
return new LenientChronology ( base ) ;
}
public Chronology withUTC () {
if ( iWithUTC == null ) {
if ( getZone () == DateTimeZone . UTC ) {
iWithUTC = this ;
} else {
iWithUTC = LenientChronology . getInstance ( getBase () . withUTC () ) ;
}
}
return iWithUTC ;
}
public Chronology withZone ( DateTimeZone zone ) {
if ( zone == null ) {
zone = DateTimeZone . getDefault () ;
}
if ( zone == DateTimeZone . UTC ) {
return withUTC () ;
}
if ( zone == getZone () ) {
return this ;
}
return LenientChronology . getInstance ( getBase () . withZone ( zone ) ) ;
}
protected void assemble ( Fields fields ) {
fields . year = convertField ( fields . year ) ;
fields . yearOfEra = convertField ( fields . yearOfEra ) ;
fields . yearOfCentury = convertField ( fields . yearOfCentury ) ;
fields . centuryOfEra = convertField ( fields . centuryOfEra ) ;
fields . era = convertField ( fields . era ) ;
fields . dayOfWeek = convertField ( fields . dayOfWeek ) ;
fields . dayOfMonth = convertField ( fields . dayOfMonth ) ;
fields . dayOfYear = convertField ( fields . dayOfYear ) ;
fields . monthOfYear = convertField ( fields . monthOfYear ) ;
fields . weekOfWeekyear = convertField ( fields . weekOfWeekyear ) ;
fields . weekyear = convertField ( fields . weekyear ) ;
fields . weekyearOfCentury = convertField ( fields . weekyearOfCentury ) ;
fields . millisOfSecond = convertField ( fields . millisOfSecond ) ;
fields . millisOfDay = convertField ( fields . millisOfDay ) ;
fields . secondOfMinute = convertField ( fields . secondOfMinute ) ;
fields . secondOfDay = convertField ( fields . secondOfDay ) ;
fields . minuteOfHour = convertField ( fields . minuteOfHour ) ;
fields . minuteOfDay = convertField ( fields . minuteOfDay ) ;
fields . hourOfDay = convertField ( fields . hourOfDay ) ;
fields . hourOfHalfday = convertField ( fields . hourOfHalfday ) ;
fields . clockhourOfDay = convertField ( fields . clockhourOfDay ) ;
fields . clockhourOfHalfday = convertField ( fields . clockhourOfHalfday ) ;
fields . halfdayOfDay = convertField ( fields . halfdayOfDay ) ;
}
private final DateTimeField convertField ( DateTimeField field ) {
return LenientDateTimeField . getInstance ( field , getBase () ) ;
}
public boolean equals ( Object obj ) {
if ( this == obj ) {
return true ;
}
if ( obj instanceof LenientChronology == false ) {
return false ;
}
LenientChronology chrono = ( LenientChronology ) obj ;
return getBase () . equals ( chrono . getBase () ) ;
}
public int hashCode () {
return 236548278 + getBase () . hashCode () * 7 ;
}
public String toString () {
return lr_2 + getBase () . toString () + ']' ;
}

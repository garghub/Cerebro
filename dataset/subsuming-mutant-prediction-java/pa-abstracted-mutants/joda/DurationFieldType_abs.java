public static DurationFieldType millis () {
return MILLIS_TYPE ;
}
public static DurationFieldType seconds () {
return SECONDS_TYPE ;
}
public static DurationFieldType minutes () {
return MINUTES_TYPE ;
}
public static DurationFieldType hours () {
return HOURS_TYPE ;
}
public static DurationFieldType halfdays () {
return HALFDAYS_TYPE ;
}
public static DurationFieldType days () {
return DAYS_TYPE ;
}
public static DurationFieldType weeks () {
return WEEKS_TYPE ;
}
public static DurationFieldType weekyears () {
return WEEKYEARS_TYPE ;
}
public static DurationFieldType months () {
return MONTHS_TYPE ;
}
public static DurationFieldType years () {
return YEARS_TYPE ;
}
public static DurationFieldType centuries () {
return CENTURIES_TYPE ;
}
public static DurationFieldType eras () {
return ERAS_TYPE ;
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
@Override
public boolean equals ( Object obj ) {
if ( this == obj ) {
return true ;
}
if ( obj instanceof StandardDurationFieldType ) {
return iOrdinal == ( ( StandardDurationFieldType ) obj ) . iOrdinal ;
}
return false ;
}
@Override
public int hashCode () {
return ( 1 << iOrdinal ) ;
}
public DurationField getField ( Chronology chronology ) {
chronology = DateTimeUtils . getChronology ( chronology ) ;
switch ( iOrdinal ) {
case ERAS :
return chronology . eras () ;
case CENTURIES :
return chronology . centuries () ;
case WEEKYEARS :
return chronology . weekyears () ;
case YEARS :
return chronology . years () ;
case MONTHS :
return chronology . months () ;
case WEEKS :
return chronology . weeks () ;
case DAYS :
return chronology . days () ;
case HALFDAYS :
return chronology . halfdays () ;
case HOURS :
return chronology . hours () ;
case MINUTES :
return chronology . minutes () ;
case SECONDS :
return chronology . seconds () ;
case MILLIS :
return chronology . millis () ;
default:
throw new InternalError () ;
}
}
private Object readResolve () {
switch ( iOrdinal ) {
case ERAS :
return ERAS_TYPE ;
case CENTURIES :
return CENTURIES_TYPE ;
case WEEKYEARS :
return WEEKYEARS_TYPE ;
case YEARS :
return YEARS_TYPE ;
case MONTHS :
return MONTHS_TYPE ;
case WEEKS :
return WEEKS_TYPE ;
case DAYS :
return DAYS_TYPE ;
case HALFDAYS :
return HALFDAYS_TYPE ;
case HOURS :
return HOURS_TYPE ;
case MINUTES :
return MINUTES_TYPE ;
case SECONDS :
return SECONDS_TYPE ;
case MILLIS :
return MILLIS_TYPE ;
default:
return this ;
}
}

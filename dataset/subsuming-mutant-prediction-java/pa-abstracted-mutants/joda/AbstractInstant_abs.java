public DateTimeZone getZone () {
return getChronology () . getZone () ;
}
public int get ( DateTimeFieldType type ) {
if ( type == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
return type . getField ( getChronology () ) . get ( getMillis () ) ;
}
public boolean isSupported ( DateTimeFieldType type ) {
if ( type == null ) {
return false ;
}
return type . getField ( getChronology () ) . isSupported () ;
}
public int get ( DateTimeField field ) {
if ( field == null ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
return field . get ( getMillis () ) ;
}
public Instant toInstant () {
return new Instant ( getMillis () ) ;
}
public DateTime toDateTime () {
return new DateTime ( getMillis () , getZone () ) ;
}
public DateTime toDateTimeISO () {
return new DateTime ( getMillis () , ISOChronology . getInstance ( getZone () ) ) ;
}
public DateTime toDateTime ( DateTimeZone zone ) {
Chronology chrono = DateTimeUtils . getChronology ( getChronology () ) ;
chrono = chrono . withZone ( zone ) ;
return new DateTime ( getMillis () , chrono ) ;
}
public DateTime toDateTime ( Chronology chronology ) {
return new DateTime ( getMillis () , chronology ) ;
}
public MutableDateTime toMutableDateTime () {
return new MutableDateTime ( getMillis () , getZone () ) ;
}
public MutableDateTime toMutableDateTimeISO () {
return new MutableDateTime ( getMillis () , ISOChronology . getInstance ( getZone () ) ) ;
}
public MutableDateTime toMutableDateTime ( DateTimeZone zone ) {
Chronology chrono = DateTimeUtils . getChronology ( getChronology () ) ;
chrono = chrono . withZone ( zone ) ;
return new MutableDateTime ( getMillis () , chrono ) ;
}
public MutableDateTime toMutableDateTime ( Chronology chronology ) {
return new MutableDateTime ( getMillis () , chronology ) ;
}
public Date toDate () {
return new Date ( getMillis () ) ;
}
public boolean equals ( Object readableInstant ) {
if ( this == readableInstant ) {
return true ;
}
if ( readableInstant instanceof ReadableInstant == false ) {
return false ;
}
ReadableInstant otherInstant = ( ReadableInstant ) readableInstant ;
return
getMillis () == otherInstant . getMillis () &&
FieldUtils . equals ( getChronology () , otherInstant . getChronology () ) ;
}
public int hashCode () {
return
( (int) ( getMillis () ^ ( getMillis () >>> 32 ) ) ) +
( getChronology () . hashCode () ) ;
}
public int compareTo ( ReadableInstant other ) {
if ( this == other ) {
return 0 ;
}
long otherMillis = other . getMillis () ;
long thisMillis = getMillis () ;
if ( thisMillis == otherMillis ) {
return 0 ;
}
if ( thisMillis < otherMillis ) {
return - 1 ;
} else {
return 1 ;
}
}
public boolean isAfter ( long instant ) {
return ( getMillis () > instant ) ;
}
public boolean isAfterNow () {
return isAfter ( DateTimeUtils . currentTimeMillis () ) ;
}
public boolean isAfter ( ReadableInstant instant ) {
long instantMillis = DateTimeUtils . getInstantMillis ( instant ) ;
return isAfter ( instantMillis ) ;
}
public boolean isBefore ( long instant ) {
return ( getMillis () < instant ) ;
}
public boolean isBeforeNow () {
return isBefore ( DateTimeUtils . currentTimeMillis () ) ;
}
public boolean isBefore ( ReadableInstant instant ) {
long instantMillis = DateTimeUtils . getInstantMillis ( instant ) ;
return isBefore ( instantMillis ) ;
}
public boolean isEqual ( long instant ) {
return ( getMillis () == instant ) ;
}
public boolean isEqualNow () {
return isEqual ( DateTimeUtils . currentTimeMillis () ) ;
}
public boolean isEqual ( ReadableInstant instant ) {
long instantMillis = DateTimeUtils . getInstantMillis ( instant ) ;
return isEqual ( instantMillis ) ;
}
@ToString
public String toString () {
return ISODateTimeFormat . dateTime () . print ( this ) ;
}
public String toString ( DateTimeFormatter formatter ) {
if ( formatter == null ) {
return toString () ;
}
return formatter . print ( this ) ;
}

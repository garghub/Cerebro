protected void checkInterval ( long start , long end ) {
if ( end < start ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
}
public DateTime getStart () {
return new DateTime ( getStartMillis () , getChronology () ) ;
}
public DateTime getEnd () {
return new DateTime ( getEndMillis () , getChronology () ) ;
}
public boolean contains ( long millisInstant ) {
long thisStart = getStartMillis () ;
long thisEnd = getEndMillis () ;
return ( millisInstant >= thisStart && millisInstant < thisEnd ) ;
}
public boolean containsNow () {
return contains ( DateTimeUtils . currentTimeMillis () ) ;
}
public boolean contains ( ReadableInstant instant ) {
if ( instant == null ) {
return containsNow () ;
}
return contains ( instant . getMillis () ) ;
}
public boolean contains ( ReadableInterval interval ) {
if ( interval == null ) {
return containsNow () ;
}
long otherStart = interval . getStartMillis () ;
long otherEnd = interval . getEndMillis () ;
long thisStart = getStartMillis () ;
long thisEnd = getEndMillis () ;
return ( thisStart <= otherStart && otherStart < thisEnd && otherEnd <= thisEnd ) ;
}
public boolean overlaps ( ReadableInterval interval ) {
long thisStart = getStartMillis () ;
long thisEnd = getEndMillis () ;
if ( interval == null ) {
long now = DateTimeUtils . currentTimeMillis () ;
return ( thisStart < now && now < thisEnd ) ;
} else {
long otherStart = interval . getStartMillis () ;
long otherEnd = interval . getEndMillis () ;
return ( thisStart < otherEnd && otherStart < thisEnd ) ;
}
}
public boolean isEqual ( ReadableInterval other ) {
return getStartMillis () == other . getStartMillis () &&
getEndMillis () == other . getEndMillis () ;
}
public boolean isBefore ( long millisInstant ) {
return ( getEndMillis () <= millisInstant ) ;
}
public boolean isBeforeNow () {
return isBefore ( DateTimeUtils . currentTimeMillis () ) ;
}
public boolean isBefore ( ReadableInstant instant ) {
if ( instant == null ) {
return isBeforeNow () ;
}
return isBefore ( instant . getMillis () ) ;
}
public boolean isBefore ( ReadableInterval interval ) {
if ( interval == null ) {
return isBeforeNow () ;
}
return isBefore ( interval . getStartMillis () ) ;
}
public boolean isAfter ( long millisInstant ) {
return ( getStartMillis () > millisInstant ) ;
}
public boolean isAfterNow () {
return isAfter ( DateTimeUtils . currentTimeMillis () ) ;
}
public boolean isAfter ( ReadableInstant instant ) {
if ( instant == null ) {
return isAfterNow () ;
}
return isAfter ( instant . getMillis () ) ;
}
public boolean isAfter ( ReadableInterval interval ) {
long endMillis ;
if ( interval == null ) {
endMillis = DateTimeUtils . currentTimeMillis () ;
} else {
endMillis = interval . getEndMillis () ;
}
return ( getStartMillis () >= endMillis ) ;
}
public Interval toInterval () {
return new Interval ( getStartMillis () , getEndMillis () , getChronology () ) ;
}
public MutableInterval toMutableInterval () {
return new MutableInterval ( getStartMillis () , getEndMillis () , getChronology () ) ;
}
public long toDurationMillis () {
return FieldUtils . safeSubtract ( getEndMillis () , getStartMillis () ) ;
}
public Duration toDuration () {
long durMillis = toDurationMillis () ;
if ( durMillis == 0 ) {
return Duration . ZERO ;
} else {
return new Duration ( durMillis ) ;
}
}
public Period toPeriod () {
return new Period ( getStartMillis () , getEndMillis () , getChronology () ) ;
}
public Period toPeriod ( PeriodType type ) {
return new Period ( getStartMillis () , getEndMillis () , type , getChronology () ) ;
}
public boolean equals ( Object readableInterval ) {
if ( this == readableInterval ) {
return true ;
}
if ( readableInterval instanceof ReadableInterval == false ) {
return false ;
}
ReadableInterval other = ( ReadableInterval ) readableInterval ;
return
getStartMillis () == other . getStartMillis () &&
getEndMillis () == other . getEndMillis () &&
FieldUtils . equals ( getChronology () , other . getChronology () ) ;
}
public int hashCode () {
long start = getStartMillis () ;
long end = getEndMillis () ;
int result = 97 ;
result = 31 * result + ( (int) ( start ^ ( start >>> 32 ) ) ) ;
result = 31 * result + ( (int) ( end ^ ( end >>> 32 ) ) ) ;
result = 31 * result + getChronology () . hashCode () ;
return result ;
}
public String toString () {
DateTimeFormatter printer = ISODateTimeFormat . dateTime () ;
printer = printer . withChronology ( getChronology () ) ;
StringBuffer buf = new StringBuffer ( 48 ) ;
printer . printTo ( buf , getStartMillis () ) ;
buf . append ( '/' ) ;
printer . printTo ( buf , getEndMillis () ) ;
return buf . toString () ;
}

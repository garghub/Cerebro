public Duration toDuration () {
return new Duration ( getMillis () ) ;
}
public Period toPeriod () {
return new Period ( getMillis () ) ;
}
public int compareTo ( ReadableDuration other ) {
long thisMillis = this . getMillis () ;
long otherMillis = other . getMillis () ;
if ( thisMillis < otherMillis ) {
return - 1 ;
}
if ( thisMillis > otherMillis ) {
return 1 ;
}
return 0 ;
}
public boolean isEqual ( ReadableDuration duration ) {
if ( duration == null ) {
duration = Duration . ZERO ;
}
return compareTo ( duration ) == 0 ;
}
public boolean isLongerThan ( ReadableDuration duration ) {
if ( duration == null ) {
duration = Duration . ZERO ;
}
return compareTo ( duration ) > 0 ;
}
public boolean isShorterThan ( ReadableDuration duration ) {
if ( duration == null ) {
duration = Duration . ZERO ;
}
return compareTo ( duration ) < 0 ;
}
public boolean equals ( Object duration ) {
if ( this == duration ) {
return true ;
}
if ( duration instanceof ReadableDuration == false ) {
return false ;
}
ReadableDuration other = ( ReadableDuration ) duration ;
return ( getMillis () == other . getMillis () ) ;
}
public int hashCode () {
long len = getMillis () ;
return (int) ( len ^ ( len >>> 32 ) ) ;
}
@ToString
public String toString () {
long millis = getMillis () ;
StringBuffer buf = new StringBuffer () ;
buf . append ( lr_1 ) ;
boolean negative = ( millis < 0 ) ;
FormatUtils . appendUnpaddedInteger ( buf , millis ) ;
while ( buf . length () < ( negative ? 7 : 6 ) ) {
buf . insert ( negative ? 3 : 2 , lr_2 ) ;
}
if ( ( millis / 1000 ) * 1000 == millis ) {
buf . setLength ( buf . length () - 3 ) ;
} else {
buf . insert ( buf . length () - 3 , lr_3 ) ;
}
buf . append ( 'S' ) ;
return buf . toString () ;
}

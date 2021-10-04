public static Interval parse ( String str ) {
return new Interval ( str ) ;
}
public static Interval parseWithOffset ( String str ) {
int separator = str . indexOf ( '/' ) ;
if ( separator < 0 ) {
throw new IllegalArgumentException ( lr_1 + str ) ;
}
String leftStr = str . substring ( 0 , separator ) ;
if ( leftStr . length () <= 0 ) {
throw new IllegalArgumentException ( lr_2 + str ) ;
}
String rightStr = str . substring ( separator + 1 ) ;
if ( rightStr . length () <= 0 ) {
throw new IllegalArgumentException ( lr_2 + str ) ;
}
DateTimeFormatter dateTimeParser = ISODateTimeFormat . dateTimeParser () . withOffsetParsed () ;
PeriodFormatter periodParser = ISOPeriodFormat . standard () ;
DateTime start = null ;
Period period = null ;
char c = leftStr . charAt ( 0 ) ;
if ( c == 'P' || c == 'p' ) {
period = periodParser . withParseType ( PeriodType . standard () ) . parsePeriod ( leftStr ) ;
} else {
start = dateTimeParser . parseDateTime ( leftStr ) ;
}
c = rightStr . charAt ( 0 ) ;
if ( c == 'P' || c == 'p' ) {
if ( period != null ) {
throw new IllegalArgumentException ( lr_3 + str ) ;
}
period = periodParser . withParseType ( PeriodType . standard () ) . parsePeriod ( rightStr ) ;
return new Interval ( start , period ) ;
} else {
DateTime end = dateTimeParser . parseDateTime ( rightStr ) ;
if ( period != null ) {
return new Interval ( period , end ) ;
} else {
return new Interval ( start , end ) ;
}
}
}
public Interval toInterval () {
return this ;
}
public Interval overlap ( ReadableInterval interval ) {
interval = DateTimeUtils . getReadableInterval ( interval ) ;
if ( overlaps ( interval ) == false ) {
return null ;
}
long start = Math . max ( getStartMillis () , interval . getStartMillis () ) ;
long end = Math . min ( getEndMillis () , interval . getEndMillis () ) ;
return new Interval ( start , end , getChronology () ) ;
}
public Interval gap ( ReadableInterval interval ) {
interval = DateTimeUtils . getReadableInterval ( interval ) ;
long otherStart = interval . getStartMillis () ;
long otherEnd = interval . getEndMillis () ;
long thisStart = getStartMillis () ;
long thisEnd = getEndMillis () ;
if ( thisStart > otherEnd ) {
return new Interval ( otherEnd , thisStart , getChronology () ) ;
} else if ( otherStart > thisEnd ) {
return new Interval ( thisEnd , otherStart , getChronology () ) ;
} else {
return null ;
}
}
public boolean abuts ( ReadableInterval interval ) {
if ( interval == null ) {
long now = DateTimeUtils . currentTimeMillis () ;
return ( getStartMillis () == now || getEndMillis () == now ) ;
} else {
return ( interval . getEndMillis () == getStartMillis () ||
getEndMillis () == interval . getStartMillis () ) ;
}
}
public Interval withChronology ( Chronology chronology ) {
if ( getChronology () == chronology ) {
return this ;
}
return new Interval ( getStartMillis () , getEndMillis () , chronology ) ;
}
public Interval withStartMillis ( long startInstant ) {
if ( startInstant == getStartMillis () ) {
return this ;
}
return new Interval ( startInstant , getEndMillis () , getChronology () ) ;
}
public Interval withStart ( ReadableInstant start ) {
long startMillis = DateTimeUtils . getInstantMillis ( start ) ;
return withStartMillis ( startMillis ) ;
}
public Interval withEndMillis ( long endInstant ) {
if ( endInstant == getEndMillis () ) {
return this ;
}
return new Interval ( getStartMillis () , endInstant , getChronology () ) ;
}
public Interval withEnd ( ReadableInstant end ) {
long endMillis = DateTimeUtils . getInstantMillis ( end ) ;
return withEndMillis ( endMillis ) ;
}
public Interval withDurationAfterStart ( ReadableDuration duration ) {
long durationMillis = DateTimeUtils . getDurationMillis ( duration ) ;
if ( durationMillis == toDurationMillis () ) {
return this ;
}
Chronology chrono = getChronology () ;
long startMillis = getStartMillis () ;
long endMillis = chrono . add ( startMillis , durationMillis , 1 ) ;
return new Interval ( startMillis , endMillis , chrono ) ;
}
public Interval withDurationBeforeEnd ( ReadableDuration duration ) {
long durationMillis = DateTimeUtils . getDurationMillis ( duration ) ;
if ( durationMillis == toDurationMillis () ) {
return this ;
}
Chronology chrono = getChronology () ;
long endMillis = getEndMillis () ;
long startMillis = chrono . add ( endMillis , durationMillis , - 1 ) ;
return new Interval ( startMillis , endMillis , chrono ) ;
}
public Interval withPeriodAfterStart ( ReadablePeriod period ) {
if ( period == null ) {
return withDurationAfterStart ( null ) ;
}
Chronology chrono = getChronology () ;
long startMillis = getStartMillis () ;
long endMillis = chrono . add ( period , startMillis , 1 ) ;
return new Interval ( startMillis , endMillis , chrono ) ;
}
public Interval withPeriodBeforeEnd ( ReadablePeriod period ) {
if ( period == null ) {
return withDurationBeforeEnd ( null ) ;
}
Chronology chrono = getChronology () ;
long endMillis = getEndMillis () ;
long startMillis = chrono . add ( period , endMillis , - 1 ) ;
return new Interval ( startMillis , endMillis , chrono ) ;
}

public long getInstantMillis ( Object object , Chronology chrono ) {
String str = ( String ) object ;
DateTimeFormatter p = ISODateTimeFormat . dateTimeParser () ;
return p . withChronology ( chrono ) . parseMillis ( str ) ;
}
public int [] getPartialValues ( ReadablePartial fieldSource , Object object , Chronology chrono , DateTimeFormatter parser ) {
if ( parser . getZone () != null ) {
chrono = chrono . withZone ( parser . getZone () ) ;
}
long millis = parser . withChronology ( chrono ) . parseMillis ( ( String ) object ) ;
return chrono . get ( fieldSource , millis ) ;
}
public long getDurationMillis ( Object object ) {
String original = ( String ) object ;
String str = original ;
int len = str . length () ;
if ( len >= 4 &&
( str . charAt ( 0 ) == 'P' || str . charAt ( 0 ) == 'p' ) &&
( str . charAt ( 1 ) == 'T' || str . charAt ( 1 ) == 't' ) &&
( str . charAt ( len - 1 ) == 'S' || str . charAt ( len - 1 ) == 's' ) ) {
} else {
throw new IllegalArgumentException ( lr_1 + original + '"' ) ;
}
str = str . substring ( 2 , len - 1 ) ;
int dot = - 1 ;
boolean negative = false ;
for ( int i = 0 ; i < str . length () ; i ++ ) {
if ( str . charAt ( i ) >= '0' && str . charAt ( i ) <= '9' ) {
} else if ( i == 0 && str . charAt ( 0 ) == '-' ) {
negative = true ;
} else if ( i > ( negative ? 1 : 0 ) && str . charAt ( i ) == '.' && dot == - 1 ) {
dot = i ;
} else {
throw new IllegalArgumentException ( lr_1 + original + '"' ) ;
}
}
long millis = 0 , seconds = 0 ;
int firstDigit = negative ? 1 : 0 ;
if ( dot > 0 ) {
seconds = Long . parseLong ( str . substring ( firstDigit , dot ) ) ;
str = str . substring ( dot + 1 ) ;
if ( str . length () != 3 ) {
str = ( str + lr_2 ) . substring ( 0 , 3 ) ;
}
millis = Integer . parseInt ( str ) ;
} else if ( negative ) {
seconds = Long . parseLong ( str . substring ( firstDigit , str . length () ) ) ;
} else {
seconds = Long . parseLong ( str ) ;
}
if ( negative ) {
return FieldUtils . safeAdd ( FieldUtils . safeMultiply ( - seconds , 1000 ) , - millis ) ;
} else {
return FieldUtils . safeAdd ( FieldUtils . safeMultiply ( seconds , 1000 ) , millis ) ;
}
}
public void setInto ( ReadWritablePeriod period , Object object , Chronology chrono ) {
String str = ( String ) object ;
PeriodFormatter parser = ISOPeriodFormat . standard () ;
period . clear () ;
int pos = parser . parseInto ( period , str , 0 ) ;
if ( pos < str . length () ) {
if ( pos < 0 ) {
parser . withParseType ( period . getPeriodType () ) . parseMutablePeriod ( str ) ;
}
throw new IllegalArgumentException ( lr_1 + str + '"' ) ;
}
}
public void setInto ( ReadWritableInterval writableInterval , Object object , Chronology chrono ) {
String str = ( String ) object ;
int separator = str . indexOf ( '/' ) ;
if ( separator < 0 ) {
throw new IllegalArgumentException ( lr_3 + str ) ;
}
String leftStr = str . substring ( 0 , separator ) ;
if ( leftStr . length () <= 0 ) {
throw new IllegalArgumentException ( lr_4 + str ) ;
}
String rightStr = str . substring ( separator + 1 ) ;
if ( rightStr . length () <= 0 ) {
throw new IllegalArgumentException ( lr_4 + str ) ;
}
DateTimeFormatter dateTimeParser = ISODateTimeFormat . dateTimeParser () ;
dateTimeParser = dateTimeParser . withChronology ( chrono ) ;
PeriodFormatter periodParser = ISOPeriodFormat . standard () ;
long startInstant = 0 , endInstant = 0 ;
Period period = null ;
Chronology parsedChrono = null ;
char c = leftStr . charAt ( 0 ) ;
if ( c == 'P' || c == 'p' ) {
period = periodParser . withParseType ( getPeriodType ( leftStr ) ) . parsePeriod ( leftStr ) ;
} else {
DateTime start = dateTimeParser . parseDateTime ( leftStr ) ;
startInstant = start . getMillis () ;
parsedChrono = start . getChronology () ;
}
c = rightStr . charAt ( 0 ) ;
if ( c == 'P' || c == 'p' ) {
if ( period != null ) {
throw new IllegalArgumentException ( lr_5 + str ) ;
}
period = periodParser . withParseType ( getPeriodType ( rightStr ) ) . parsePeriod ( rightStr ) ;
chrono = ( chrono != null ? chrono : parsedChrono ) ;
endInstant = chrono . add ( period , startInstant , 1 ) ;
} else {
DateTime end = dateTimeParser . parseDateTime ( rightStr ) ;
endInstant = end . getMillis () ;
parsedChrono = ( parsedChrono != null ? parsedChrono : end . getChronology () ) ;
chrono = ( chrono != null ? chrono : parsedChrono ) ;
if ( period != null ) {
startInstant = chrono . add ( period , endInstant , - 1 ) ;
}
}
writableInterval . setInterval ( startInstant , endInstant ) ;
writableInterval . setChronology ( chrono ) ;
}
public Class < ? > getSupportedType () {
return String . class ;
}

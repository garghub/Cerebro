public static String formatDurationHMS ( final long durationMillis ) {
return formatDuration ( durationMillis , lr_1 ) ;
}
public static String formatDurationISO ( final long durationMillis ) {
return formatDuration ( durationMillis , ISO_EXTENDED_FORMAT_PATTERN , false ) ;
}
public static String formatDuration ( final long durationMillis , final String format ) {
return formatDuration ( durationMillis , format , true ) ;
}
public static String formatDuration ( final long durationMillis , final String format , final boolean padWithZeros ) {
Validate . inclusiveBetween ( 0 , Long . MAX_VALUE , durationMillis , lr_2 ) ;
final Token [] tokens = lexx ( format ) ;
long days = 0 ;
long hours = 0 ;
long minutes = 0 ;
long seconds = 0 ;
long milliseconds = durationMillis ;
if ( Token . containsTokenWithValue ( tokens , d ) ) {
days = milliseconds / DateUtils . MILLIS_PER_DAY ;
milliseconds = milliseconds - ( days * DateUtils . MILLIS_PER_DAY ) ;
}
if ( Token . containsTokenWithValue ( tokens , H ) ) {
hours = milliseconds / DateUtils . MILLIS_PER_HOUR ;
milliseconds = milliseconds - ( hours * DateUtils . MILLIS_PER_HOUR ) ;
}
if ( Token . containsTokenWithValue ( tokens , m ) ) {
minutes = milliseconds / DateUtils . MILLIS_PER_MINUTE ;
milliseconds = milliseconds - ( minutes * DateUtils . MILLIS_PER_MINUTE ) ;
}
if ( Token . containsTokenWithValue ( tokens , s ) ) {
seconds = milliseconds / DateUtils . MILLIS_PER_SECOND ;
milliseconds = milliseconds - ( seconds * DateUtils . MILLIS_PER_SECOND ) ;
}
return format ( tokens , 0 , 0 , days , hours , minutes , seconds , milliseconds , padWithZeros ) ;
}
public static String formatDurationWords (
final long durationMillis ,
final boolean suppressLeadingZeroElements ,
final boolean suppressTrailingZeroElements ) {
String duration = formatDuration ( durationMillis , lr_3 ) ;
if ( suppressLeadingZeroElements ) {
duration = lr_4 + duration ;
String tmp = StringUtils . replaceOnce ( duration , lr_5 , lr_6 ) ;
if ( tmp . length () != duration . length () ) {
duration = tmp ;
tmp = StringUtils . replaceOnce ( duration , lr_7 , lr_6 ) ;
if ( tmp . length () != duration . length () ) {
duration = tmp ;
tmp = StringUtils . replaceOnce ( duration , lr_8 , lr_6 ) ;
duration = tmp ;
if ( tmp . length () != duration . length () ) {
duration = StringUtils . replaceOnce ( tmp , lr_9 , lr_6 ) ;
}
}
}
if ( duration . length () != 0 ) {
duration = duration . substring ( 1 ) ;
}
}
if ( suppressTrailingZeroElements ) {
String tmp = StringUtils . replaceOnce ( duration , lr_9 , lr_6 ) ;
if ( tmp . length () != duration . length () ) {
duration = tmp ;
tmp = StringUtils . replaceOnce ( duration , lr_8 , lr_6 ) ;
if ( tmp . length () != duration . length () ) {
duration = tmp ;
tmp = StringUtils . replaceOnce ( duration , lr_7 , lr_6 ) ;
if ( tmp . length () != duration . length () ) {
duration = StringUtils . replaceOnce ( tmp , lr_5 , lr_6 ) ;
}
}
}
}
duration = lr_4 + duration ;
duration = StringUtils . replaceOnce ( duration , lr_10 , lr_11 ) ;
duration = StringUtils . replaceOnce ( duration , lr_12 , lr_13 ) ;
duration = StringUtils . replaceOnce ( duration , lr_14 , lr_15 ) ;
duration = StringUtils . replaceOnce ( duration , lr_16 , lr_17 ) ;
return duration . trim () ;
}
public static String formatPeriodISO ( final long startMillis , final long endMillis ) {
return formatPeriod ( startMillis , endMillis , ISO_EXTENDED_FORMAT_PATTERN , false , TimeZone . getDefault () ) ;
}
public static String formatPeriod ( final long startMillis , final long endMillis , final String format ) {
return formatPeriod ( startMillis , endMillis , format , true , TimeZone . getDefault () ) ;
}
public static String formatPeriod ( final long startMillis , final long endMillis , final String format , final boolean padWithZeros ,
final TimeZone timezone ) {
Validate . isTrue ( startMillis <= endMillis , lr_18 ) ;
final Token [] tokens = lexx ( format ) ;
final Calendar start = Calendar . getInstance ( timezone ) ;
start . setTime ( new Date ( startMillis ) ) ;
final Calendar end = Calendar . getInstance ( timezone ) ;
end . setTime ( new Date ( endMillis ) ) ;
int milliseconds = end . get ( Calendar . MILLISECOND ) - start . get ( Calendar . MILLISECOND ) ;
int seconds = end . get ( Calendar . SECOND ) - start . get ( Calendar . SECOND ) ;
int minutes = end . get ( Calendar . MINUTE ) - start . get ( Calendar . MINUTE ) ;
int hours = end . get ( Calendar . HOUR_OF_DAY ) - start . get ( Calendar . HOUR_OF_DAY ) ;
int days = end . get ( Calendar . DAY_OF_MONTH ) - start . get ( Calendar . DAY_OF_MONTH ) ;
int months = end . get ( Calendar . MONTH ) - start . get ( Calendar . MONTH ) ;
int years = end . get ( Calendar . YEAR ) - start . get ( Calendar . YEAR ) ;
while ( milliseconds < 0 ) {
milliseconds += 1000 ;
seconds -= 1 ;
}
while ( seconds < 0 ) {
seconds += 60 ;
minutes -= 1 ;
}
while ( minutes < 0 ) {
minutes += 60 ;
hours -= 1 ;
}
while ( hours < 0 ) {
hours += 24 ;
days -= 1 ;
}
if ( Token . containsTokenWithValue ( tokens , M ) ) {
while ( days < 0 ) {
days += start . getActualMaximum ( Calendar . DAY_OF_MONTH ) ;
months -= 1 ;
start . add ( Calendar . MONTH , 1 ) ;
}
while ( months < 0 ) {
months += 12 ;
years -= 1 ;
}
if ( ! Token . containsTokenWithValue ( tokens , y ) && years != 0 ) {
while ( years != 0 ) {
months += 12 * years ;
years = 0 ;
}
}
} else {
if( ! Token . containsTokenWithValue ( tokens , y ) ) {
int target = end . get ( Calendar . YEAR ) ;
if ( months < 0 ) {
target -= 1 ;
}
while ( start . get ( Calendar . YEAR ) != target ) {
days += start . getActualMaximum ( Calendar . DAY_OF_YEAR ) - start . get ( Calendar . DAY_OF_YEAR ) ;
if ( start instanceof GregorianCalendar &&
start . get ( Calendar . MONTH ) == Calendar . FEBRUARY &&
start . get ( Calendar . DAY_OF_MONTH ) == 29 ) {
days += 1 ;
}
start . add ( Calendar . YEAR , 1 ) ;
days += start . get ( Calendar . DAY_OF_YEAR ) ;
}
years = 0 ;
}
while( start . get ( Calendar . MONTH ) != end . get ( Calendar . MONTH ) ) {
days += start . getActualMaximum ( Calendar . DAY_OF_MONTH ) ;
start . add ( Calendar . MONTH , 1 ) ;
}
months = 0 ;
while ( days < 0 ) {
days += start . getActualMaximum ( Calendar . DAY_OF_MONTH ) ;
months -= 1 ;
start . add ( Calendar . MONTH , 1 ) ;
}
}
if ( ! Token . containsTokenWithValue ( tokens , d ) ) {
hours += 24 * days ;
days = 0 ;
}
if ( ! Token . containsTokenWithValue ( tokens , H ) ) {
minutes += 60 * hours ;
hours = 0 ;
}
if ( ! Token . containsTokenWithValue ( tokens , m ) ) {
seconds += 60 * minutes ;
minutes = 0 ;
}
if ( ! Token . containsTokenWithValue ( tokens , s ) ) {
milliseconds += 1000 * seconds ;
seconds = 0 ;
}
return format ( tokens , years , months , days , hours , minutes , seconds , milliseconds , padWithZeros ) ;
}
static String format ( final Token [] tokens , final long years , final long months , final long days , final long hours , final long minutes , final long seconds ,
final long milliseconds , final boolean padWithZeros ) {
final StringBuilder buffer = new StringBuilder () ;
boolean lastOutputSeconds = false ;
for ( final Token token : tokens ) {
final Object value = token . getValue () ;
final int count = token . getCount () ;
if ( value instanceof StringBuilder ) {
buffer . append ( value . toString () ) ;
} else {
if ( value . equals ( y ) ) {
buffer . append ( paddedValue ( years , padWithZeros , count ) ) ;
lastOutputSeconds = false ;
} else if ( value . equals ( M ) ) {
buffer . append ( paddedValue ( months , padWithZeros , count ) ) ;
lastOutputSeconds = false ;
} else if ( value . equals ( d ) ) {
buffer . append ( paddedValue ( days , padWithZeros , count ) ) ;
lastOutputSeconds = false ;
} else if ( value . equals ( H ) ) {
buffer . append ( paddedValue ( hours , padWithZeros , count ) ) ;
lastOutputSeconds = false ;
} else if ( value . equals ( m ) ) {
buffer . append ( paddedValue ( minutes , padWithZeros , count ) ) ;
lastOutputSeconds = false ;
} else if ( value . equals ( s ) ) {
buffer . append ( paddedValue ( seconds , padWithZeros , count ) ) ;
lastOutputSeconds = true ;
} else if ( value . equals ( S ) ) {
if ( lastOutputSeconds ) {
final int width = padWithZeros ? Math . max ( 3 , count ) : 3 ;
buffer . append ( paddedValue ( milliseconds , true , width ) ) ;
} else {
buffer . append ( paddedValue ( milliseconds , padWithZeros , count ) ) ;
}
lastOutputSeconds = false ;
}
}
}
return buffer . toString () ;
}
private static String paddedValue ( final long value , final boolean padWithZeros , final int count ) {
final String longString = Long . toString ( value ) ;
return padWithZeros ? StringUtils . leftPad ( longString , count , '0' ) : longString ;
}
static Token [] lexx ( final String format ) {
final ArrayList < Token > list = new ArrayList < Token > ( format . length () ) ;
boolean inLiteral = false ;
StringBuilder buffer = null ;
Token previous = null ;
for ( int i = 0 ; i < format . length () ; i ++ ) {
final char ch = format . charAt ( i ) ;
if ( inLiteral && ch != '\'' ) {
buffer . append ( ch ) ;
continue;
}
Object value = null ;
switch ( ch ) {
case '\'' :
if ( inLiteral ) {
buffer = null ;
inLiteral = false ;
} else {
buffer = new StringBuilder () ;
list . add ( new Token ( buffer ) ) ;
inLiteral = true ;
}
break;
case 'y' :
value = y ;
break;
case 'M' :
value = M ;
break;
case 'd' :
value = d ;
break;
case 'H' :
value = H ;
break;
case 'm' :
value = m ;
break;
case 's' :
value = s ;
break;
case 'S' :
value = S ;
break;
default:
if ( buffer == null ) {
buffer = new StringBuilder () ;
list . add ( new Token ( buffer ) ) ;
}
buffer . append ( ch ) ;
}
if ( value != null ) {
if ( previous != null && previous . getValue () . equals ( value ) ) {
previous . increment () ;
} else {
final Token token = new Token ( value ) ;
list . add ( token ) ;
previous = token ;
}
buffer = null ;
}
}
if ( inLiteral ) {
throw new IllegalArgumentException ( lr_19 + format ) ;
}
return list . toArray ( new Token [ list . size () ] ) ;
}
static boolean containsTokenWithValue ( final Token [] tokens , final Object value ) {
for ( final Token token : tokens ) {
if ( token . getValue () == value ) {
return true ;
}
}
return false ;
}
void increment () {
count ++ ;
}
int getCount () {
return count ;
}
Object getValue () {
return value ;
}
@Override
public boolean equals ( final Object obj2 ) {
if ( obj2 instanceof Token ) {
final Token tok2 = ( Token ) obj2 ;
if ( this . value . getClass () != tok2 . value . getClass () ) {
return false ;
}
if ( this . count != tok2 . count ) {
return false ;
}
if ( this . value instanceof StringBuilder ) {
return this . value . toString () . equals ( tok2 . value . toString () ) ;
} else if ( this . value instanceof Number ) {
return this . value . equals ( tok2 . value ) ;
} else {
return this . value == tok2 . value ;
}
}
return false ;
}
@Override
public int hashCode () {
return this . value . hashCode () ;
}
@Override
public String toString () {
return StringUtils . repeat ( this . value . toString () , this . count ) ;
}

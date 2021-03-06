@FromString
public static Period parse ( String str ) {
return parse ( str , ISOPeriodFormat . standard () ) ;
}
public static Period parse ( String str , PeriodFormatter formatter ) {
return formatter . parsePeriod ( str ) ;
}
public static Period years ( int years ) {
return new Period ( new int [] { years , 0 , 0 , 0 , 0 , 0 , 0 , 0 } , PeriodType . standard () ) ;
}
public static Period months ( int months ) {
return new Period ( new int [] { 0 , months , 0 , 0 , 0 , 0 , 0 , 0 } , PeriodType . standard () ) ;
}
public static Period weeks ( int weeks ) {
return new Period ( new int [] { 0 , 0 , weeks , 0 , 0 , 0 , 0 , 0 } , PeriodType . standard () ) ;
}
public static Period days ( int days ) {
return new Period ( new int [] { 0 , 0 , 0 , days , 0 , 0 , 0 , 0 } , PeriodType . standard () ) ;
}
public static Period hours ( int hours ) {
return new Period ( new int [] { 0 , 0 , 0 , 0 , hours , 0 , 0 , 0 } , PeriodType . standard () ) ;
}
public static Period minutes ( int minutes ) {
return new Period ( new int [] { 0 , 0 , 0 , 0 , 0 , minutes , 0 , 0 } , PeriodType . standard () ) ;
}
public static Period seconds ( int seconds ) {
return new Period ( new int [] { 0 , 0 , 0 , 0 , 0 , 0 , seconds , 0 } , PeriodType . standard () ) ;
}
public static Period millis ( int millis ) {
return new Period ( new int [] { 0 , 0 , 0 , 0 , 0 , 0 , 0 , millis } , PeriodType . standard () ) ;
}
public static Period fieldDifference ( ReadablePartial start , ReadablePartial end ) {
if ( start == null || end == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
if ( start . size () != end . size () ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
DurationFieldType [] types = new DurationFieldType [ start . size () ] ;
int [] values = new int [ start . size () ] ;
for ( int i = 0 , isize = start . size () ; i < isize ; i ++ ) {
if ( start . getFieldType ( i ) != end . getFieldType ( i ) ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
types [ i ] = start . getFieldType ( i ) . getDurationType () ;
if ( i > 0 && types [ i - 1 ] == types [ i ] ) {
throw new IllegalArgumentException ( lr_3 ) ;
}
values [ i ] = end . getValue ( i ) - start . getValue ( i ) ;
}
return new Period ( values , PeriodType . forFields ( types ) ) ;
}
public Period toPeriod () {
return this ;
}
public int getYears () {
return getPeriodType () . getIndexedField ( this , PeriodType . YEAR_INDEX ) ;
}
public int getMonths () {
return getPeriodType () . getIndexedField ( this , PeriodType . MONTH_INDEX ) ;
}
public int getWeeks () {
return getPeriodType () . getIndexedField ( this , PeriodType . WEEK_INDEX ) ;
}
public int getDays () {
return getPeriodType () . getIndexedField ( this , PeriodType . DAY_INDEX ) ;
}
public int getHours () {
return getPeriodType () . getIndexedField ( this , PeriodType . HOUR_INDEX ) ;
}
public int getMinutes () {
return getPeriodType () . getIndexedField ( this , PeriodType . MINUTE_INDEX ) ;
}
public int getSeconds () {
return getPeriodType () . getIndexedField ( this , PeriodType . SECOND_INDEX ) ;
}
public int getMillis () {
return getPeriodType () . getIndexedField ( this , PeriodType . MILLI_INDEX ) ;
}
public Period withPeriodType ( PeriodType type ) {
type = DateTimeUtils . getPeriodType ( type ) ;
if ( type . equals ( getPeriodType () ) ) {
return this ;
}
return new Period ( this , type ) ;
}
public Period withFields ( ReadablePeriod period ) {
if ( period == null ) {
return this ;
}
int [] newValues = getValues () ;
newValues = super . mergePeriodInto ( newValues , period ) ;
return new Period ( newValues , getPeriodType () ) ;
}
public Period withField ( DurationFieldType field , int value ) {
if ( field == null ) {
throw new IllegalArgumentException ( lr_4 ) ;
}
int [] newValues = getValues () ;
super . setFieldInto ( newValues , field , value ) ;
return new Period ( newValues , getPeriodType () ) ;
}
public Period withFieldAdded ( DurationFieldType field , int value ) {
if ( field == null ) {
throw new IllegalArgumentException ( lr_4 ) ;
}
if ( value == 0 ) {
return this ;
}
int [] newValues = getValues () ;
super . addFieldInto ( newValues , field , value ) ;
return new Period ( newValues , getPeriodType () ) ;
}
public Period withYears ( int years ) {
int [] values = getValues () ;
getPeriodType () . setIndexedField ( this , PeriodType . YEAR_INDEX , values , years ) ;
return new Period ( values , getPeriodType () ) ;
}
public Period withMonths ( int months ) {
int [] values = getValues () ;
getPeriodType () . setIndexedField ( this , PeriodType . MONTH_INDEX , values , months ) ;
return new Period ( values , getPeriodType () ) ;
}
public Period withWeeks ( int weeks ) {
int [] values = getValues () ;
getPeriodType () . setIndexedField ( this , PeriodType . WEEK_INDEX , values , weeks ) ;
return new Period ( values , getPeriodType () ) ;
}
public Period withDays ( int days ) {
int [] values = getValues () ;
getPeriodType () . setIndexedField ( this , PeriodType . DAY_INDEX , values , days ) ;
return new Period ( values , getPeriodType () ) ;
}
public Period withHours ( int hours ) {
int [] values = getValues () ;
getPeriodType () . setIndexedField ( this , PeriodType . HOUR_INDEX , values , hours ) ;
return new Period ( values , getPeriodType () ) ;
}
public Period withMinutes ( int minutes ) {
int [] values = getValues () ;
getPeriodType () . setIndexedField ( this , PeriodType . MINUTE_INDEX , values , minutes ) ;
return new Period ( values , getPeriodType () ) ;
}
public Period withSeconds ( int seconds ) {
int [] values = getValues () ;
getPeriodType () . setIndexedField ( this , PeriodType . SECOND_INDEX , values , seconds ) ;
return new Period ( values , getPeriodType () ) ;
}
public Period withMillis ( int millis ) {
int [] values = getValues () ;
getPeriodType () . setIndexedField ( this , PeriodType . MILLI_INDEX , values , millis ) ;
return new Period ( values , getPeriodType () ) ;
}
public Period plus ( ReadablePeriod period ) {
if ( period == null ) {
return this ;
}
int [] values = getValues () ;
getPeriodType () . addIndexedField ( this , PeriodType . YEAR_INDEX , values , period . get ( DurationFieldType . YEARS_TYPE ) ) ;
getPeriodType () . addIndexedField ( this , PeriodType . MONTH_INDEX , values , period . get ( DurationFieldType . MONTHS_TYPE ) ) ;
getPeriodType () . addIndexedField ( this , PeriodType . WEEK_INDEX , values , period . get ( DurationFieldType . WEEKS_TYPE ) ) ;
getPeriodType () . addIndexedField ( this , PeriodType . DAY_INDEX , values , period . get ( DurationFieldType . DAYS_TYPE ) ) ;
getPeriodType () . addIndexedField ( this , PeriodType . HOUR_INDEX , values , period . get ( DurationFieldType . HOURS_TYPE ) ) ;
getPeriodType () . addIndexedField ( this , PeriodType . MINUTE_INDEX , values , period . get ( DurationFieldType . MINUTES_TYPE ) ) ;
getPeriodType () . addIndexedField ( this , PeriodType . SECOND_INDEX , values , period . get ( DurationFieldType . SECONDS_TYPE ) ) ;
getPeriodType () . addIndexedField ( this , PeriodType . MILLI_INDEX , values , period . get ( DurationFieldType . MILLIS_TYPE ) ) ;
return new Period ( values , getPeriodType () ) ;
}
public Period plusYears ( int years ) {
if ( years == 0 ) {
return this ;
}
int [] values = getValues () ;
getPeriodType () . addIndexedField ( this , PeriodType . YEAR_INDEX , values , years ) ;
return new Period ( values , getPeriodType () ) ;
}
public Period plusMonths ( int months ) {
if ( months == 0 ) {
return this ;
}
int [] values = getValues () ;
getPeriodType () . addIndexedField ( this , PeriodType . MONTH_INDEX , values , months ) ;
return new Period ( values , getPeriodType () ) ;
}
public Period plusWeeks ( int weeks ) {
if ( weeks == 0 ) {
return this ;
}
int [] values = getValues () ;
getPeriodType () . addIndexedField ( this , PeriodType . WEEK_INDEX , values , weeks ) ;
return new Period ( values , getPeriodType () ) ;
}
public Period plusDays ( int days ) {
if ( days == 0 ) {
return this ;
}
int [] values = getValues () ;
getPeriodType () . addIndexedField ( this , PeriodType . DAY_INDEX , values , days ) ;
return new Period ( values , getPeriodType () ) ;
}
public Period plusHours ( int hours ) {
if ( hours == 0 ) {
return this ;
}
int [] values = getValues () ;
getPeriodType () . addIndexedField ( this , PeriodType . HOUR_INDEX , values , hours ) ;
return new Period ( values , getPeriodType () ) ;
}
public Period plusMinutes ( int minutes ) {
if ( minutes == 0 ) {
return this ;
}
int [] values = getValues () ;
getPeriodType () . addIndexedField ( this , PeriodType . MINUTE_INDEX , values , minutes ) ;
return new Period ( values , getPeriodType () ) ;
}
public Period plusSeconds ( int seconds ) {
if ( seconds == 0 ) {
return this ;
}
int [] values = getValues () ;
getPeriodType () . addIndexedField ( this , PeriodType . SECOND_INDEX , values , seconds ) ;
return new Period ( values , getPeriodType () ) ;
}
public Period plusMillis ( int millis ) {
if ( millis == 0 ) {
return this ;
}
int [] values = getValues () ;
getPeriodType () . addIndexedField ( this , PeriodType . MILLI_INDEX , values , millis ) ;
return new Period ( values , getPeriodType () ) ;
}
public Period minus ( ReadablePeriod period ) {
if ( period == null ) {
return this ;
}
int [] values = getValues () ;
getPeriodType () . addIndexedField ( this , PeriodType . YEAR_INDEX , values , - period . get ( DurationFieldType . YEARS_TYPE ) ) ;
getPeriodType () . addIndexedField ( this , PeriodType . MONTH_INDEX , values , - period . get ( DurationFieldType . MONTHS_TYPE ) ) ;
getPeriodType () . addIndexedField ( this , PeriodType . WEEK_INDEX , values , - period . get ( DurationFieldType . WEEKS_TYPE ) ) ;
getPeriodType () . addIndexedField ( this , PeriodType . DAY_INDEX , values , - period . get ( DurationFieldType . DAYS_TYPE ) ) ;
getPeriodType () . addIndexedField ( this , PeriodType . HOUR_INDEX , values , - period . get ( DurationFieldType . HOURS_TYPE ) ) ;
getPeriodType () . addIndexedField ( this , PeriodType . MINUTE_INDEX , values , - period . get ( DurationFieldType . MINUTES_TYPE ) ) ;
getPeriodType () . addIndexedField ( this , PeriodType . SECOND_INDEX , values , - period . get ( DurationFieldType . SECONDS_TYPE ) ) ;
getPeriodType () . addIndexedField ( this , PeriodType . MILLI_INDEX , values , - period . get ( DurationFieldType . MILLIS_TYPE ) ) ;
return new Period ( values , getPeriodType () ) ;
}
public Period minusYears ( int years ) {
return plusYears ( - years ) ;
}
public Period minusMonths ( int months ) {
return plusMonths ( - months ) ;
}
public Period minusWeeks ( int weeks ) {
return plusWeeks ( - weeks ) ;
}
public Period minusDays ( int days ) {
return plusDays ( - days ) ;
}
public Period minusHours ( int hours ) {
return plusHours ( - hours ) ;
}
public Period minusMinutes ( int minutes ) {
return plusMinutes ( - minutes ) ;
}
public Period minusSeconds ( int seconds ) {
return plusSeconds ( - seconds ) ;
}
public Period minusMillis ( int millis ) {
return plusMillis ( - millis ) ;
}
public Period multipliedBy ( int scalar ) {
if ( this == ZERO || scalar == 1 ) {
return this ;
}
int [] values = getValues () ;
for ( int i = 0 ; i < values . length ; i ++ ) {
values [ i ] = FieldUtils . safeMultiply ( values [ i ] , scalar ) ;
}
return new Period ( values , getPeriodType () ) ;
}
public Period negated () {
return multipliedBy ( - 1 ) ;
}
public Weeks toStandardWeeks () {
checkYearsAndMonths ( lr_5 ) ;
long millis = getMillis () ;
millis += ( ( long ) getSeconds () ) * DateTimeConstants . MILLIS_PER_SECOND ;
millis += ( ( long ) getMinutes () ) * DateTimeConstants . MILLIS_PER_MINUTE ;
millis += ( ( long ) getHours () ) * DateTimeConstants . MILLIS_PER_HOUR ;
millis += ( ( long ) getDays () ) * DateTimeConstants . MILLIS_PER_DAY ;
long weeks = ( ( long ) getWeeks () ) + millis / DateTimeConstants . MILLIS_PER_WEEK ;
return Weeks . weeks ( FieldUtils . safeToInt ( weeks ) ) ;
}
public Days toStandardDays () {
checkYearsAndMonths ( lr_6 ) ;
long millis = getMillis () ;
millis += ( ( long ) getSeconds () ) * DateTimeConstants . MILLIS_PER_SECOND ;
millis += ( ( long ) getMinutes () ) * DateTimeConstants . MILLIS_PER_MINUTE ;
millis += ( ( long ) getHours () ) * DateTimeConstants . MILLIS_PER_HOUR ;
long days = millis / DateTimeConstants . MILLIS_PER_DAY ;
days = FieldUtils . safeAdd ( days , getDays () ) ;
days = FieldUtils . safeAdd ( days , ( ( long ) getWeeks () ) * ( ( long ) DateTimeConstants . DAYS_PER_WEEK ) ) ;
return Days . days ( FieldUtils . safeToInt ( days ) ) ;
}
public Hours toStandardHours () {
checkYearsAndMonths ( lr_7 ) ;
long millis = getMillis () ;
millis += ( ( long ) getSeconds () ) * DateTimeConstants . MILLIS_PER_SECOND ;
millis += ( ( long ) getMinutes () ) * DateTimeConstants . MILLIS_PER_MINUTE ;
long hours = millis / DateTimeConstants . MILLIS_PER_HOUR ;
hours = FieldUtils . safeAdd ( hours , getHours () ) ;
hours = FieldUtils . safeAdd ( hours , ( ( long ) getDays () ) * ( ( long ) DateTimeConstants . HOURS_PER_DAY ) ) ;
hours = FieldUtils . safeAdd ( hours , ( ( long ) getWeeks () ) * ( ( long ) DateTimeConstants . HOURS_PER_WEEK ) ) ;
return Hours . hours ( FieldUtils . safeToInt ( hours ) ) ;
}
public Minutes toStandardMinutes () {
checkYearsAndMonths ( lr_8 ) ;
long millis = getMillis () ;
millis += ( ( long ) getSeconds () ) * DateTimeConstants . MILLIS_PER_SECOND ;
long minutes = millis / DateTimeConstants . MILLIS_PER_MINUTE ;
minutes = FieldUtils . safeAdd ( minutes , getMinutes () ) ;
minutes = FieldUtils . safeAdd ( minutes , ( ( long ) getHours () ) * ( ( long ) DateTimeConstants . MINUTES_PER_HOUR ) ) ;
minutes = FieldUtils . safeAdd ( minutes , ( ( long ) getDays () ) * ( ( long ) DateTimeConstants . MINUTES_PER_DAY ) ) ;
minutes = FieldUtils . safeAdd ( minutes , ( ( long ) getWeeks () ) * ( ( long ) DateTimeConstants . MINUTES_PER_WEEK ) ) ;
return Minutes . minutes ( FieldUtils . safeToInt ( minutes ) ) ;
}
public Seconds toStandardSeconds () {
checkYearsAndMonths ( lr_9 ) ;
long seconds = getMillis () / DateTimeConstants . MILLIS_PER_SECOND ;
seconds = FieldUtils . safeAdd ( seconds , getSeconds () ) ;
seconds = FieldUtils . safeAdd ( seconds , ( ( long ) getMinutes () ) * ( ( long ) DateTimeConstants . SECONDS_PER_MINUTE ) ) ;
seconds = FieldUtils . safeAdd ( seconds , ( ( long ) getHours () ) * ( ( long ) DateTimeConstants . SECONDS_PER_HOUR ) ) ;
seconds = FieldUtils . safeAdd ( seconds , ( ( long ) getDays () ) * ( ( long ) DateTimeConstants . SECONDS_PER_DAY ) ) ;
seconds = FieldUtils . safeAdd ( seconds , ( ( long ) getWeeks () ) * ( ( long ) DateTimeConstants . SECONDS_PER_WEEK ) ) ;
return Seconds . seconds ( FieldUtils . safeToInt ( seconds ) ) ;
}
public Duration toStandardDuration () {
checkYearsAndMonths ( lr_10 ) ;
long millis = getMillis () ;
millis += ( ( ( long ) getSeconds () ) * ( ( long ) DateTimeConstants . MILLIS_PER_SECOND ) ) ;
millis += ( ( ( long ) getMinutes () ) * ( ( long ) DateTimeConstants . MILLIS_PER_MINUTE ) ) ;
millis += ( ( ( long ) getHours () ) * ( ( long ) DateTimeConstants . MILLIS_PER_HOUR ) ) ;
millis += ( ( ( long ) getDays () ) * ( ( long ) DateTimeConstants . MILLIS_PER_DAY ) ) ;
millis += ( ( ( long ) getWeeks () ) * ( ( long ) DateTimeConstants . MILLIS_PER_WEEK ) ) ;
return new Duration ( millis ) ;
}
private void checkYearsAndMonths ( String destintionType ) {
if ( getMonths () != 0 ) {
throw new UnsupportedOperationException ( lr_11 + destintionType + lr_12 ) ;
}
if ( getYears () != 0 ) {
throw new UnsupportedOperationException ( lr_11 + destintionType + lr_13 ) ;
}
}
public Period normalizedStandard () {
return normalizedStandard ( PeriodType . standard () ) ;
}
public Period normalizedStandard ( PeriodType type ) {
type = DateTimeUtils . getPeriodType ( type ) ;
long millis = getMillis () ;
millis += ( ( ( long ) getSeconds () ) * ( ( long ) DateTimeConstants . MILLIS_PER_SECOND ) ) ;
millis += ( ( ( long ) getMinutes () ) * ( ( long ) DateTimeConstants . MILLIS_PER_MINUTE ) ) ;
millis += ( ( ( long ) getHours () ) * ( ( long ) DateTimeConstants . MILLIS_PER_HOUR ) ) ;
millis += ( ( ( long ) getDays () ) * ( ( long ) DateTimeConstants . MILLIS_PER_DAY ) ) ;
millis += ( ( ( long ) getWeeks () ) * ( ( long ) DateTimeConstants . MILLIS_PER_WEEK ) ) ;
Period result = new Period ( millis , type , ISOChronology . getInstanceUTC () ) ;
int years = getYears () ;
int months = getMonths () ;
if ( years != 0 || months != 0 ) {
long totalMonths = years * 12L + months ;
if ( type . isSupported ( DurationFieldType . YEARS_TYPE ) ) {
int normalizedYears = FieldUtils . safeToInt ( totalMonths / 12 ) ;
result = result . withYears ( normalizedYears ) ;
totalMonths = totalMonths - ( normalizedYears * 12 ) ;
}
if ( type . isSupported ( DurationFieldType . MONTHS_TYPE ) ) {
int normalizedMonths = FieldUtils . safeToInt ( totalMonths ) ;
result = result . withMonths ( normalizedMonths ) ;
totalMonths = totalMonths - normalizedMonths ;
}
if ( totalMonths != 0 ) {
throw new UnsupportedOperationException ( lr_14 + toString () ) ;
}
}
return result ;
}

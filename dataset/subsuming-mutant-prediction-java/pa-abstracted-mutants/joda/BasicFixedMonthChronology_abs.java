long setYear ( long instant , int year ) {
int thisYear = getYear ( instant ) ;
int dayOfYear = getDayOfYear ( instant , thisYear ) ;
int millisOfDay = getMillisOfDay ( instant ) ;
if ( dayOfYear > 365 ) {
if ( ! isLeapYear ( year ) ) {
dayOfYear -- ;
}
}
instant = getYearMonthDayMillis ( year , 1 , dayOfYear ) ;
instant += millisOfDay ;
return instant ;
}
long getYearDifference ( long minuendInstant , long subtrahendInstant ) {
int minuendYear = getYear ( minuendInstant ) ;
int subtrahendYear = getYear ( subtrahendInstant ) ;
long minuendRem = minuendInstant - getYearMillis ( minuendYear ) ;
long subtrahendRem = subtrahendInstant - getYearMillis ( subtrahendYear ) ;
int difference = minuendYear - subtrahendYear ;
if ( minuendRem < subtrahendRem ) {
difference -- ;
}
return difference ;
}
long getTotalMillisByYearMonth ( int year , int month ) {
return ( ( month - 1 ) * MILLIS_PER_MONTH ) ;
}
int getDayOfMonth ( long millis ) {
return ( getDayOfYear ( millis ) - 1 ) % MONTH_LENGTH + 1 ;
}
boolean isLeapYear ( int year ) {
return ( year & 3 ) == 3 ;
}
int getDaysInYearMonth ( int year , int month ) {
return ( month != 13 ) ? MONTH_LENGTH : ( isLeapYear ( year ) ? 6 : 5 ) ;
}
int getDaysInMonthMax () {
return MONTH_LENGTH ;
}
int getDaysInMonthMax ( int month ) {
return ( month != 13 ? MONTH_LENGTH : 6 ) ;
}
int getMonthOfYear ( long millis ) {
return ( getDayOfYear ( millis ) - 1 ) / MONTH_LENGTH + 1 ;
}
int getMonthOfYear ( long millis , int year ) {
long monthZeroBased = ( millis - getYearMillis ( year ) ) / MILLIS_PER_MONTH ;
return ( ( int ) monthZeroBased ) + 1 ;
}
int getMaxMonth () {
return 13 ;
}
long getAverageMillisPerYear () {
return MILLIS_PER_YEAR ;
}
long getAverageMillisPerYearDividedByTwo () {
return MILLIS_PER_YEAR / 2 ;
}
long getAverageMillisPerMonth () {
return MILLIS_PER_MONTH ;
}

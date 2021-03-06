@Override
boolean isLeapDay ( long instant ) {
return dayOfMonth () . get ( instant ) == 29 && monthOfYear () . isLeap ( instant ) ;
}
int getMonthOfYear ( long millis , int year ) {
int i = (int)( ( millis - getYearMillis ( year ) ) >> 10 ) ;
return
( isLeapYear ( year ) )
? ( ( i < 182 * 84375 )
? ( ( i < 91 * 84375 )
? ( ( i < 31 * 84375 ) ? 1 : ( i < 60 * 84375 ) ? 2 : 3 )
: ( ( i < 121 * 84375 ) ? 4 : ( i < 152 * 84375 ) ? 5 : 6 ) )
: ( ( i < 274 * 84375 )
? ( ( i < 213 * 84375 ) ? 7 : ( i < 244 * 84375 ) ? 8 : 9 )
: ( ( i < 305 * 84375 ) ? 10 : ( i < 335 * 84375 ) ? 11 : 12 ) ) )
: ( ( i < 181 * 84375 )
? ( ( i < 90 * 84375 )
? ( ( i < 31 * 84375 ) ? 1 : ( i < 59 * 84375 ) ? 2 : 3 )
: ( ( i < 120 * 84375 ) ? 4 : ( i < 151 * 84375 ) ? 5 : 6 ) )
: ( ( i < 273 * 84375 )
? ( ( i < 212 * 84375 ) ? 7 : ( i < 243 * 84375 ) ? 8 : 9 )
: ( ( i < 304 * 84375 ) ? 10 : ( i < 334 * 84375 ) ? 11 : 12 ) ) ) ;
}
int getDaysInYearMonth ( int year , int month ) {
if ( isLeapYear ( year ) ) {
return MAX_DAYS_PER_MONTH_ARRAY [ month - 1 ] ;
} else {
return MIN_DAYS_PER_MONTH_ARRAY [ month - 1 ] ;
}
}
int getDaysInMonthMax ( int month ) {
return MAX_DAYS_PER_MONTH_ARRAY [ month - 1 ] ;
}
int getDaysInMonthMaxForSet ( long instant , int value ) {
return ( ( value > 28 || value < 1 ) ? getDaysInMonthMax ( instant ) : 28 ) ;
}
long getTotalMillisByYearMonth ( int year , int month ) {
if ( isLeapYear ( year ) ) {
return MAX_TOTAL_MILLIS_BY_MONTH_ARRAY [ month - 1 ] ;
} else {
return MIN_TOTAL_MILLIS_BY_MONTH_ARRAY [ month - 1 ] ;
}
}
long getYearDifference ( long minuendInstant , long subtrahendInstant ) {
int minuendYear = getYear ( minuendInstant ) ;
int subtrahendYear = getYear ( subtrahendInstant ) ;
long minuendRem = minuendInstant - getYearMillis ( minuendYear ) ;
long subtrahendRem = subtrahendInstant - getYearMillis ( subtrahendYear ) ;
if ( subtrahendRem >= FEB_29 ) {
if ( isLeapYear ( subtrahendYear ) ) {
if ( ! isLeapYear ( minuendYear ) ) {
subtrahendRem -= DateTimeConstants . MILLIS_PER_DAY ;
}
} else if ( minuendRem >= FEB_29 && isLeapYear ( minuendYear ) ) {
minuendRem -= DateTimeConstants . MILLIS_PER_DAY ;
}
}
int difference = minuendYear - subtrahendYear ;
if ( minuendRem < subtrahendRem ) {
difference -- ;
}
return difference ;
}
long setYear ( long instant , int year ) {
int thisYear = getYear ( instant ) ;
int dayOfYear = getDayOfYear ( instant , thisYear ) ;
int millisOfDay = getMillisOfDay ( instant ) ;
if ( dayOfYear > ( 31 + 28 ) ) {
if ( isLeapYear ( thisYear ) ) {
if ( ! isLeapYear ( year ) ) {
dayOfYear -- ;
}
} else {
if ( isLeapYear ( year ) ) {
dayOfYear ++ ;
}
}
}
instant = getYearMonthDayMillis ( year , 1 , dayOfYear ) ;
instant += millisOfDay ;
return instant ;
}

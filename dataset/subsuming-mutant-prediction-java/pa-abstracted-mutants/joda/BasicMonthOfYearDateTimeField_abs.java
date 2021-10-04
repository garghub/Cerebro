public boolean isLenient () {
return false ;
}
public int get ( long instant ) {
return iChronology . getMonthOfYear ( instant ) ;
}
public long add ( long instant , int months ) {
if ( months == 0 ) {
return instant ;
}
long timePart = iChronology . getMillisOfDay ( instant ) ;
int thisYear = iChronology . getYear ( instant ) ;
int thisMonth = iChronology . getMonthOfYear ( instant , thisYear ) ;
int yearToUse = thisYear ; ;
int monthToUse = thisMonth - 1 + months ;
if ( thisMonth > 0 && monthToUse < 0 ) {
if ( Math . signum ( months + iMax ) == Math . signum ( months ) ) {
yearToUse -- ;
months += iMax ;
} else {
yearToUse ++ ;
months -= iMax ;
}
monthToUse = thisMonth - 1 + months ;
}
if ( monthToUse >= 0 ) {
yearToUse = yearToUse + ( monthToUse / iMax ) ;
monthToUse = ( monthToUse % iMax ) + 1 ;
} else {
yearToUse = yearToUse + ( monthToUse / iMax ) - 1 ;
monthToUse = Math . abs ( monthToUse ) ;
int remMonthToUse = monthToUse % iMax ;
if ( remMonthToUse == 0 ) {
remMonthToUse = iMax ;
}
monthToUse = iMax - remMonthToUse + 1 ;
if ( monthToUse == 1 ) {
yearToUse += 1 ;
}
}
int dayToUse = iChronology . getDayOfMonth ( instant , thisYear , thisMonth ) ;
int maxDay = iChronology . getDaysInYearMonth ( yearToUse , monthToUse ) ;
if ( dayToUse > maxDay ) {
dayToUse = maxDay ;
}
long datePart =
iChronology . getYearMonthDayMillis ( yearToUse , monthToUse , dayToUse ) ;
return datePart + timePart ;
}
public long add ( long instant , long months ) {
int i_months = ( int ) months ;
if ( i_months == months ) {
return add ( instant , i_months ) ;
}
long timePart = iChronology . getMillisOfDay ( instant ) ;
int thisYear = iChronology . getYear ( instant ) ;
int thisMonth = iChronology . getMonthOfYear ( instant , thisYear ) ;
long yearToUse ;
long monthToUse = thisMonth - 1 + months ;
if ( monthToUse >= 0 ) {
yearToUse = thisYear + ( monthToUse / iMax ) ;
monthToUse = ( monthToUse % iMax ) + 1 ;
} else {
yearToUse = thisYear + ( monthToUse / iMax ) - 1 ;
monthToUse = Math . abs ( monthToUse ) ;
int remMonthToUse = (int)( monthToUse % iMax ) ;
if ( remMonthToUse == 0 ) {
remMonthToUse = iMax ;
}
monthToUse = iMax - remMonthToUse + 1 ;
if ( monthToUse == 1 ) {
yearToUse += 1 ;
}
}
if ( yearToUse < iChronology . getMinYear ( ) ||
yearToUse > iChronology . getMaxYear () ) {
throw new IllegalArgumentException
( lr_1 + months ) ;
}
int i_yearToUse = ( int ) yearToUse ;
int i_monthToUse = ( int ) monthToUse ;
int dayToUse = iChronology . getDayOfMonth ( instant , thisYear , thisMonth ) ;
int maxDay = iChronology . getDaysInYearMonth ( i_yearToUse , i_monthToUse ) ;
if ( dayToUse > maxDay ) {
dayToUse = maxDay ;
}
long datePart =
iChronology . getYearMonthDayMillis ( i_yearToUse , i_monthToUse , dayToUse ) ;
return datePart + timePart ;
}
public int [] add ( ReadablePartial partial , int fieldIndex , int [] values , int valueToAdd ) {
if ( valueToAdd == 0 ) {
return values ;
}
if ( partial . size () > 0 && partial . getFieldType ( 0 ) . equals ( DateTimeFieldType . monthOfYear () ) && fieldIndex == 0 ) {
int curMonth0 = values [ 0 ] - 1 ;
int newMonth = ( ( curMonth0 + ( valueToAdd % 12 ) + 12 ) % 12 ) + 1 ;
return set ( partial , 0 , values , newMonth ) ;
}
if ( DateTimeUtils . isContiguous ( partial ) ) {
long instant = 0L ;
for ( int i = 0 , isize = partial . size () ; i < isize ; i ++ ) {
instant = partial . getFieldType ( i ) . getField ( iChronology ) . set ( instant , values [ i ] ) ;
}
instant = add ( instant , valueToAdd ) ;
return iChronology . get ( partial , instant ) ;
} else {
return super . add ( partial , fieldIndex , values , valueToAdd ) ;
}
}
public long addWrapField ( long instant , int months ) {
return set ( instant , FieldUtils . getWrappedValue ( get ( instant ) , months , MIN , iMax ) ) ;
}
public long getDifferenceAsLong ( long minuendInstant , long subtrahendInstant ) {
if ( minuendInstant < subtrahendInstant ) {
return - getDifference ( subtrahendInstant , minuendInstant ) ;
}
int minuendYear = iChronology . getYear ( minuendInstant ) ;
int minuendMonth = iChronology . getMonthOfYear ( minuendInstant , minuendYear ) ;
int subtrahendYear = iChronology . getYear ( subtrahendInstant ) ;
int subtrahendMonth = iChronology . getMonthOfYear ( subtrahendInstant , subtrahendYear ) ;
long difference = ( minuendYear - subtrahendYear ) * ( ( long ) iMax ) + minuendMonth - subtrahendMonth ;
int minuendDom = iChronology . getDayOfMonth
( minuendInstant , minuendYear , minuendMonth ) ;
if ( minuendDom == iChronology . getDaysInYearMonth ( minuendYear , minuendMonth ) ) {
int subtrahendDom = iChronology . getDayOfMonth
( subtrahendInstant , subtrahendYear , subtrahendMonth ) ;
if ( subtrahendDom > minuendDom ) {
subtrahendInstant = iChronology . dayOfMonth () . set ( subtrahendInstant , minuendDom ) ;
}
}
long minuendRem = minuendInstant
- iChronology . getYearMonthMillis ( minuendYear , minuendMonth ) ;
long subtrahendRem = subtrahendInstant
- iChronology . getYearMonthMillis ( subtrahendYear , subtrahendMonth ) ;
if ( minuendRem < subtrahendRem ) {
difference -- ;
}
return difference ;
}
public long set ( long instant , int month ) {
FieldUtils . verifyValueBounds ( this , month , MIN , iMax ) ;
int thisYear = iChronology . getYear ( instant ) ;
int thisDom = iChronology . getDayOfMonth ( instant , thisYear ) ;
int maxDom = iChronology . getDaysInYearMonth ( thisYear , month ) ;
if ( thisDom > maxDom ) {
thisDom = maxDom ;
}
return iChronology . getYearMonthDayMillis ( thisYear , month , thisDom ) +
iChronology . getMillisOfDay ( instant ) ;
}
public DurationField getRangeDurationField () {
return iChronology . years () ;
}
public boolean isLeap ( long instant ) {
int thisYear = iChronology . getYear ( instant ) ;
if ( iChronology . isLeapYear ( thisYear ) ) {
return ( iChronology . getMonthOfYear ( instant , thisYear ) == iLeapMonth ) ;
}
return false ;
}
public int getLeapAmount ( long instant ) {
return isLeap ( instant ) ? 1 : 0 ;
}
public DurationField getLeapDurationField () {
return iChronology . days () ;
}
public int getMinimumValue () {
return MIN ;
}
public int getMaximumValue () {
return iMax ;
}
public long roundFloor ( long instant ) {
int year = iChronology . getYear ( instant ) ;
int month = iChronology . getMonthOfYear ( instant , year ) ;
return iChronology . getYearMonthMillis ( year , month ) ;
}
public long remainder ( long instant ) {
return instant - roundFloor ( instant ) ;
}
private Object readResolve () {
return iChronology . monthOfYear () ;
}

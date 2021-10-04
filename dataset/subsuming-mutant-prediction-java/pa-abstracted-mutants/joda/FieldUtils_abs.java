public static int safeNegate ( int value ) {
if ( value == Integer . MIN_VALUE ) {
throw new ArithmeticException ( lr_1 ) ;
}
return - value ;
}
public static int safeAdd ( int val1 , int val2 ) {
int sum = val1 + val2 ;
if ( ( val1 ^ sum ) < 0 && ( val1 ^ val2 ) >= 0 ) {
throw new ArithmeticException
( lr_2 + val1 + lr_3 + val2 ) ;
}
return sum ;
}
public static long safeAdd ( long val1 , long val2 ) {
long sum = val1 + val2 ;
if ( ( val1 ^ sum ) < 0 && ( val1 ^ val2 ) >= 0 ) {
throw new ArithmeticException
( lr_2 + val1 + lr_3 + val2 ) ;
}
return sum ;
}
public static long safeSubtract ( long val1 , long val2 ) {
long diff = val1 - val2 ;
if ( ( val1 ^ diff ) < 0 && ( val1 ^ val2 ) < 0 ) {
throw new ArithmeticException
( lr_2 + val1 + lr_4 + val2 ) ;
}
return diff ;
}
public static int safeMultiply ( int val1 , int val2 ) {
long total = ( long ) val1 * ( long ) val2 ;
if ( total < Integer . MIN_VALUE || total > Integer . MAX_VALUE ) {
throw new ArithmeticException ( lr_5 + val1 + lr_6 + val2 ) ;
}
return ( int ) total ;
}
public static long safeMultiply ( long val1 , int val2 ) {
switch ( val2 ) {
case - 1 :
if ( val1 == Long . MIN_VALUE ) {
throw new ArithmeticException ( lr_7 + val1 + lr_6 + val2 ) ;
}
return - val1 ;
case 0 :
return 0L ;
case 1 :
return val1 ;
}
long total = val1 * val2 ;
if ( total / val2 != val1 ) {
throw new ArithmeticException ( lr_7 + val1 + lr_6 + val2 ) ;
}
return total ;
}
public static long safeMultiply ( long val1 , long val2 ) {
if ( val2 == 1 ) {
return val1 ;
}
if ( val1 == 1 ) {
return val2 ;
}
if ( val1 == 0 || val2 == 0 ) {
return 0 ;
}
long total = val1 * val2 ;
if ( total / val2 != val1 || val1 == Long . MIN_VALUE && val2 == - 1 || val2 == Long . MIN_VALUE && val1 == - 1 ) {
throw new ArithmeticException ( lr_7 + val1 + lr_6 + val2 ) ;
}
return total ;
}
public static long safeDivide ( long dividend , long divisor ) {
if ( dividend == Long . MIN_VALUE && divisor == - 1L ) {
throw new ArithmeticException ( lr_7 + dividend + lr_8 + divisor ) ;
}
return dividend / divisor ;
}
public static long safeDivide ( long dividend , long divisor , RoundingMode roundingMode ) {
if ( dividend == Long . MIN_VALUE && divisor == - 1L ) {
throw new ArithmeticException ( lr_7 + dividend + lr_8 + divisor ) ;
}
BigDecimal dividendBigDecimal = new BigDecimal ( dividend ) ;
BigDecimal divisorBigDecimal = new BigDecimal ( divisor ) ;
return dividendBigDecimal . divide ( divisorBigDecimal , roundingMode ) . longValue () ;
}
public static int safeToInt ( long value ) {
if ( Integer . MIN_VALUE <= value && value <= Integer . MAX_VALUE ) {
return ( int ) value ;
}
throw new ArithmeticException ( lr_9 + value ) ;
}
public static int safeMultiplyToInt ( long val1 , long val2 ) {
long val = FieldUtils . safeMultiply ( val1 , val2 ) ;
return FieldUtils . safeToInt ( val ) ;
}
public static void verifyValueBounds ( DateTimeField field ,
int value , int lowerBound , int upperBound ) {
if ( ( value < lowerBound ) || ( value > upperBound ) ) {
throw new IllegalFieldValueException
( field . getType () , Integer . valueOf ( value ) ,
Integer . valueOf ( lowerBound ) , Integer . valueOf ( upperBound ) ) ;
}
}
public static void verifyValueBounds ( DateTimeFieldType fieldType ,
int value , int lowerBound , int upperBound ) {
if ( ( value < lowerBound ) || ( value > upperBound ) ) {
throw new IllegalFieldValueException
( fieldType , Integer . valueOf ( value ) ,
Integer . valueOf ( lowerBound ) , Integer . valueOf ( upperBound ) ) ;
}
}
public static void verifyValueBounds ( String fieldName ,
int value , int lowerBound , int upperBound ) {
if ( ( value < lowerBound ) || ( value > upperBound ) ) {
throw new IllegalFieldValueException
( fieldName , Integer . valueOf ( value ) ,
Integer . valueOf ( lowerBound ) , Integer . valueOf ( upperBound ) ) ;
}
}
public static int getWrappedValue ( int currentValue , int wrapValue ,
int minValue , int maxValue ) {
return getWrappedValue ( currentValue + wrapValue , minValue , maxValue ) ;
}
public static int getWrappedValue ( int value , int minValue , int maxValue ) {
if ( minValue >= maxValue ) {
throw new IllegalArgumentException ( lr_10 ) ;
}
int wrapRange = maxValue - minValue + 1 ;
value -= minValue ;
if ( value >= 0 ) {
return ( value % wrapRange ) + minValue ;
}
int remByRange = ( - value ) % wrapRange ;
if ( remByRange == 0 ) {
return 0 + minValue ;
}
return ( wrapRange - remByRange ) + minValue ;
}
public static boolean equals ( Object object1 , Object object2 ) {
if ( object1 == object2 ) {
return true ;
}
if ( object1 == null || object2 == null ) {
return false ;
}
return object1 . equals ( object2 ) ;
}

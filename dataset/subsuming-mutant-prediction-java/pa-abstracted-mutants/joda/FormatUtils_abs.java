public static void appendPaddedInteger ( StringBuffer buf , int value , int size ) {
try {
appendPaddedInteger ( ( Appendable ) buf , value , size ) ;
} catch ( IOException e ) {
}
}
public static void appendPaddedInteger ( Appendable appenadble , int value , int size ) throws IOException {
if ( value < 0 ) {
appenadble . append ( '-' ) ;
if ( value != Integer . MIN_VALUE ) {
value = - value ;
} else {
for (; size > 10 ; size -- ) {
appenadble . append ( '0' ) ;
}
appenadble . append ( lr_1 + - ( long ) Integer . MIN_VALUE ) ;
return;
}
}
if ( value < 10 ) {
for (; size > 1 ; size -- ) {
appenadble . append ( '0' ) ;
}
appenadble . append ( (char)( value + '0' ) ) ;
} else if ( value < 100 ) {
for (; size > 2 ; size -- ) {
appenadble . append ( '0' ) ;
}
int d = ( ( value + 1 ) * 13421772 ) >> 27 ;
appenadble . append ( (char) ( d + '0' ) ) ;
appenadble . append ( (char) ( value - ( d << 3 ) - ( d << 1 ) + '0' ) ) ;
} else {
int digits ;
if ( value < 1000 ) {
digits = 3 ;
} else if ( value < 10000 ) {
digits = 4 ;
} else {
digits = (int)( Math . log ( value ) / LOG_10 ) + 1 ;
}
for (; size > digits ; size -- ) {
appenadble . append ( '0' ) ;
}
appenadble . append ( Integer . toString ( value ) ) ;
}
}
public static void appendPaddedInteger ( StringBuffer buf , long value , int size ) {
try {
appendPaddedInteger ( ( Appendable ) buf , value , size ) ;
} catch ( IOException e ) {
}
}
public static void appendPaddedInteger ( Appendable appendable , long value , int size ) throws IOException {
int intValue = ( int ) value ;
if ( intValue == value ) {
appendPaddedInteger ( appendable , intValue , size ) ;
} else if ( size <= 19 ) {
appendable . append ( Long . toString ( value ) ) ;
} else {
if ( value < 0 ) {
appendable . append ( '-' ) ;
if ( value != Long . MIN_VALUE ) {
value = - value ;
} else {
for (; size > 19 ; size -- ) {
appendable . append ( '0' ) ;
}
appendable . append ( lr_2 ) ;
return;
}
}
int digits = (int)( Math . log ( value ) / LOG_10 ) + 1 ;
for (; size > digits ; size -- ) {
appendable . append ( '0' ) ;
}
appendable . append ( Long . toString ( value ) ) ;
}
}
public static void writePaddedInteger ( Writer out , int value , int size )
throws IOException
{
if ( value < 0 ) {
out . write ( '-' ) ;
if ( value != Integer . MIN_VALUE ) {
value = - value ;
} else {
for (; size > 10 ; size -- ) {
out . write ( '0' ) ;
}
out . write ( lr_1 + - ( long ) Integer . MIN_VALUE ) ;
return;
}
}
if ( value < 10 ) {
for (; size > 1 ; size -- ) {
out . write ( '0' ) ;
}
out . write ( value + '0' ) ;
} else if ( value < 100 ) {
for (; size > 2 ; size -- ) {
out . write ( '0' ) ;
}
int d = ( ( value + 1 ) * 13421772 ) >> 27 ;
out . write ( d + '0' ) ;
out . write ( value - ( d << 3 ) - ( d << 1 ) + '0' ) ;
} else {
int digits ;
if ( value < 1000 ) {
digits = 3 ;
} else if ( value < 10000 ) {
digits = 4 ;
} else {
digits = (int)( Math . log ( value ) / LOG_10 ) + 1 ;
}
for (; size > digits ; size -- ) {
out . write ( '0' ) ;
}
out . write ( Integer . toString ( value ) ) ;
}
}
public static void writePaddedInteger ( Writer out , long value , int size )
throws IOException
{
int intValue = ( int ) value ;
if ( intValue == value ) {
writePaddedInteger ( out , intValue , size ) ;
} else if ( size <= 19 ) {
out . write ( Long . toString ( value ) ) ;
} else {
if ( value < 0 ) {
out . write ( '-' ) ;
if ( value != Long . MIN_VALUE ) {
value = - value ;
} else {
for (; size > 19 ; size -- ) {
out . write ( '0' ) ;
}
out . write ( lr_2 ) ;
return;
}
}
int digits = (int)( Math . log ( value ) / LOG_10 ) + 1 ;
for (; size > digits ; size -- ) {
out . write ( '0' ) ;
}
out . write ( Long . toString ( value ) ) ;
}
}
public static void appendUnpaddedInteger ( StringBuffer buf , int value ) {
try {
appendUnpaddedInteger ( ( Appendable ) buf , value ) ;
} catch ( IOException e ) {
}
}
public static void appendUnpaddedInteger ( Appendable appendable , int value ) throws IOException {
if ( value < 0 ) {
appendable . append ( '-' ) ;
if ( value != Integer . MIN_VALUE ) {
value = - value ;
} else {
appendable . append ( lr_1 + - ( long ) Integer . MIN_VALUE ) ;
return;
}
}
if ( value < 10 ) {
appendable . append ( (char)( value + '0' ) ) ;
} else if ( value < 100 ) {
int d = ( ( value + 1 ) * 13421772 ) >> 27 ;
appendable . append ( (char) ( d + '0' ) ) ;
appendable . append ( (char) ( value - ( d << 3 ) - ( d << 1 ) + '0' ) ) ;
} else {
appendable . append ( Integer . toString ( value ) ) ;
}
}
public static void appendUnpaddedInteger ( StringBuffer buf , long value ) {
try {
appendUnpaddedInteger ( ( Appendable ) buf , value ) ;
} catch ( IOException e ) {
}
}
public static void appendUnpaddedInteger ( Appendable appendable , long value ) throws IOException {
int intValue = ( int ) value ;
if ( intValue == value ) {
appendUnpaddedInteger ( appendable , intValue ) ;
} else {
appendable . append ( Long . toString ( value ) ) ;
}
}
public static void writeUnpaddedInteger ( Writer out , int value )
throws IOException
{
if ( value < 0 ) {
out . write ( '-' ) ;
if ( value != Integer . MIN_VALUE ) {
value = - value ;
} else {
out . write ( lr_1 + - ( long ) Integer . MIN_VALUE ) ;
return;
}
}
if ( value < 10 ) {
out . write ( value + '0' ) ;
} else if ( value < 100 ) {
int d = ( ( value + 1 ) * 13421772 ) >> 27 ;
out . write ( d + '0' ) ;
out . write ( value - ( d << 3 ) - ( d << 1 ) + '0' ) ;
} else {
out . write ( Integer . toString ( value ) ) ;
}
}
public static void writeUnpaddedInteger ( Writer out , long value )
throws IOException
{
int intValue = ( int ) value ;
if ( intValue == value ) {
writeUnpaddedInteger ( out , intValue ) ;
} else {
out . write ( Long . toString ( value ) ) ;
}
}
public static int calculateDigitCount ( long value ) {
if ( value < 0 ) {
if ( value != Long . MIN_VALUE ) {
return calculateDigitCount ( - value ) + 1 ;
} else {
return 20 ;
}
}
return
( value < 10 ? 1 :
( value < 100 ? 2 :
( value < 1000 ? 3 :
( value < 10000 ? 4 :
( (int)( Math . log ( value ) / LOG_10 ) + 1 ) ) ) ) ) ;
}
static int parseTwoDigits ( CharSequence text , int position ) {
int value = text . charAt ( position ) - '0' ;
return ( ( value << 3 ) + ( value << 1 ) ) + text . charAt ( position + 1 ) - '0' ;
}
static String createErrorMessage ( final String text , final int errorPos ) {
int sampleLen = errorPos + 32 ;
String sampleText ;
if ( text . length () <= sampleLen + 3 ) {
sampleText = text ;
} else {
sampleText = text . substring ( 0 , sampleLen ) . concat ( lr_3 ) ;
}
if ( errorPos <= 0 ) {
return lr_4 + sampleText + '"' ;
}
if ( errorPos >= text . length () ) {
return lr_4 + sampleText + lr_5 ;
}
return lr_4 + sampleText + lr_6 +
sampleText . substring ( errorPos ) + '"' ;
}

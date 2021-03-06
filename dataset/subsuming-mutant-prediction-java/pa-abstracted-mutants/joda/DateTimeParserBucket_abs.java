public void reset () {
iZone = iDefaultZone ;
iOffset = null ;
iPivotYear = iDefaultPivotYear ;
iSavedFieldsCount = 0 ;
iSavedFieldsShared = false ;
iSavedState = null ;
}
public long parseMillis ( DateTimeParser parser , CharSequence text ) {
reset () ;
return doParseMillis ( DateTimeParserInternalParser . of ( parser ) , text ) ;
}
long doParseMillis ( InternalParser parser , CharSequence text ) {
int newPos = parser . parseInto ( this , text , 0 ) ;
if ( newPos >= 0 ) {
if ( newPos >= text . length () ) {
return computeMillis ( true , text ) ;
}
} else {
newPos = ~ newPos ;
}
throw new IllegalArgumentException ( FormatUtils . createErrorMessage ( text . toString () , newPos ) ) ;
}
public Chronology getChronology () {
return iChrono ;
}
public Locale getLocale () {
return iLocale ;
}
public DateTimeZone getZone () {
return iZone ;
}
public void setZone ( DateTimeZone zone ) {
iSavedState = null ;
iZone = zone ;
}
@Deprecated
public int getOffset () {
return ( iOffset != null ? iOffset : 0 ) ;
}
public Integer getOffsetInteger () {
return iOffset ;
}
@Deprecated
public void setOffset ( int offset ) {
iSavedState = null ;
iOffset = offset ;
}
public void setOffset ( Integer offset ) {
iSavedState = null ;
iOffset = offset ;
}
public Integer getPivotYear () {
return iPivotYear ;
}
@Deprecated
public void setPivotYear ( Integer pivotYear ) {
iPivotYear = pivotYear ;
}
public void saveField ( DateTimeField field , int value ) {
obtainSaveField () . init ( field , value ) ;
}
public void saveField ( DateTimeFieldType fieldType , int value ) {
obtainSaveField () . init ( fieldType . getField ( iChrono ) , value ) ;
}
public void saveField ( DateTimeFieldType fieldType , String text , Locale locale ) {
obtainSaveField () . init ( fieldType . getField ( iChrono ) , text , locale ) ;
}
private SavedField obtainSaveField () {
SavedField [] savedFields = iSavedFields ;
int savedFieldsCount = iSavedFieldsCount ;
if ( savedFieldsCount == savedFields . length || iSavedFieldsShared ) {
SavedField [] newArray = new SavedField
[ savedFieldsCount == savedFields . length ? savedFieldsCount * 2 : savedFields . length ] ;
System . arraycopy ( savedFields , 0 , newArray , 0 , savedFieldsCount ) ;
iSavedFields = savedFields = newArray ;
iSavedFieldsShared = false ;
}
iSavedState = null ;
SavedField saved = savedFields [ savedFieldsCount ] ;
if ( saved == null ) {
saved = savedFields [ savedFieldsCount ] = new SavedField () ;
}
iSavedFieldsCount = savedFieldsCount + 1 ;
return saved ;
}
public Object saveState () {
if ( iSavedState == null ) {
iSavedState = new SavedState () ;
}
return iSavedState ;
}
public boolean restoreState ( Object savedState ) {
if ( savedState instanceof SavedState ) {
if ( ( ( SavedState ) savedState ) . restoreState ( this ) ) {
iSavedState = savedState ;
return true ;
}
}
return false ;
}
public long computeMillis () {
return computeMillis ( false , ( CharSequence ) null ) ;
}
public long computeMillis ( boolean resetFields ) {
return computeMillis ( resetFields , ( CharSequence ) null ) ;
}
public long computeMillis ( boolean resetFields , String text ) {
return computeMillis ( resetFields , ( CharSequence ) text ) ;
}
public long computeMillis ( boolean resetFields , CharSequence text ) {
SavedField [] savedFields = iSavedFields ;
int count = iSavedFieldsCount ;
if ( iSavedFieldsShared ) {
iSavedFields = savedFields = ( SavedField [] ) iSavedFields . clone () ;
iSavedFieldsShared = false ;
}
sort ( savedFields , count ) ;
if ( count > 0 ) {
DurationField months = DurationFieldType . months () . getField ( iChrono ) ;
DurationField days = DurationFieldType . days () . getField ( iChrono ) ;
DurationField first = savedFields [ 0 ] . iField . getDurationField () ;
if ( compareReverse ( first , months ) >= 0 && compareReverse ( first , days ) <= 0 ) {
saveField ( DateTimeFieldType . year () , iDefaultYear ) ;
return computeMillis ( resetFields , text ) ;
}
}
long millis = iMillis ;
try {
for ( int i = 0 ; i < count ; i ++ ) {
millis = savedFields [ i ] . set ( millis , resetFields ) ;
}
if ( resetFields ) {
for ( int i = 0 ; i < count ; i ++ ) {
if ( ! savedFields [ i ] . iField . isLenient () ) {
millis = savedFields [ i ] . set ( millis , i == ( count - 1 ) ) ;
}
}
}
} catch ( IllegalFieldValueException e ) {
if ( text != null ) {
e . prependMessage ( lr_1 + text + '"' ) ;
}
throw e ;
}
if ( iOffset != null ) {
millis -= iOffset ;
} else if ( iZone != null ) {
int offset = iZone . getOffsetFromLocal ( millis ) ;
millis -= offset ;
if ( offset != iZone . getOffset ( millis ) ) {
String message = lr_2 + iZone + ')' ;
if ( text != null ) {
message = lr_1 + text + lr_3 + message ;
}
throw new IllegalInstantException ( message ) ;
}
}
return millis ;
}
private static void sort ( SavedField [] array , int high ) {
if ( high > 10 ) {
Arrays . sort ( array , 0 , high ) ;
} else {
for ( int i = 0 ; i < high ; i ++ ) {
for ( int j = i ; j > 0 && ( array [ j - 1 ] ) . compareTo ( array [ j ] ) > 0 ; j -- ) {
SavedField t = array [ j ] ;
array [ j ] = array [ j - 1 ] ;
array [ j - 1 ] = t ;
}
}
}
}
boolean restoreState ( DateTimeParserBucket enclosing ) {
if ( enclosing != DateTimeParserBucket . this ) {
return false ;
}
enclosing . iZone = this . iZone ;
enclosing . iOffset = this . iOffset ;
enclosing . iSavedFields = this . iSavedFields ;
if ( this . iSavedFieldsCount < enclosing . iSavedFieldsCount ) {
enclosing . iSavedFieldsShared = true ;
}
enclosing . iSavedFieldsCount = this . iSavedFieldsCount ;
return true ;
}
void init ( DateTimeField field , int value ) {
iField = field ;
iValue = value ;
iText = null ;
iLocale = null ;
}
void init ( DateTimeField field , String text , Locale locale ) {
iField = field ;
iValue = 0 ;
iText = text ;
iLocale = locale ;
}
long set ( long millis , boolean reset ) {
if ( iText == null ) {
millis = iField . setExtended ( millis , iValue ) ;
} else {
millis = iField . set ( millis , iText , iLocale ) ;
}
if ( reset ) {
millis = iField . roundFloor ( millis ) ;
}
return millis ;
}
public int compareTo ( SavedField obj ) {
DateTimeField other = obj . iField ;
int result = compareReverse
( iField . getRangeDurationField () , other . getRangeDurationField () ) ;
if ( result != 0 ) {
return result ;
}
return compareReverse
( iField . getDurationField () , other . getDurationField () ) ;
}
static int compareReverse ( DurationField a , DurationField b ) {
if ( a == null || ! a . isSupported () ) {
if ( b == null || ! b . isSupported () ) {
return 0 ;
}
return - 1 ;
}
if ( b == null || ! b . isSupported () ) {
return 1 ;
}
return - a . compareTo ( b ) ;
}

public int size () {
return iTypes . length ;
}
public Chronology getChronology () {
return iChronology ;
}
protected DateTimeField getField ( int index , Chronology chrono ) {
return iTypes [ index ] . getField ( chrono ) ;
}
public DateTimeFieldType getFieldType ( int index ) {
return iTypes [ index ] ;
}
public DateTimeFieldType [] getFieldTypes () {
return ( DateTimeFieldType [] ) iTypes . clone () ;
}
public int getValue ( int index ) {
return iValues [ index ] ;
}
public int [] getValues () {
return ( int [] ) iValues . clone () ;
}
public Partial withChronologyRetainFields ( Chronology newChronology ) {
newChronology = DateTimeUtils . getChronology ( newChronology ) ;
newChronology = newChronology . withUTC () ;
if ( newChronology == getChronology () ) {
return this ;
} else {
Partial newPartial = new Partial ( newChronology , iTypes , iValues ) ;
newChronology . validate ( newPartial , iValues ) ;
return newPartial ;
}
}
public Partial with ( DateTimeFieldType fieldType , int value ) {
if ( fieldType == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
int index = indexOf ( fieldType ) ;
if ( index == - 1 ) {
DateTimeFieldType [] newTypes = new DateTimeFieldType [ iTypes . length + 1 ] ;
int [] newValues = new int [ newTypes . length ] ;
int i = 0 ;
DurationField unitField = fieldType . getDurationType () . getField ( iChronology ) ;
if ( unitField . isSupported () ) {
for (; i < iTypes . length ; i ++ ) {
DateTimeFieldType loopType = iTypes [ i ] ;
DurationField loopUnitField = loopType . getDurationType () . getField ( iChronology ) ;
if ( loopUnitField . isSupported () ) {
int compare = unitField . compareTo ( loopUnitField ) ;
if ( compare > 0 ) {
break;
} else if ( compare == 0 ) {
if ( fieldType . getRangeDurationType () == null ) {
break;
}
if ( loopType . getRangeDurationType () == null ) {
continue;
}
DurationField rangeField = fieldType . getRangeDurationType () . getField ( iChronology ) ;
DurationField loopRangeField = loopType . getRangeDurationType () . getField ( iChronology ) ;
if ( rangeField . compareTo ( loopRangeField ) > 0 ) {
break;
}
}
}
}
}
System . arraycopy ( iTypes , 0 , newTypes , 0 , i ) ;
System . arraycopy ( iValues , 0 , newValues , 0 , i ) ;
newTypes [ i ] = fieldType ;
newValues [ i ] = value ;
System . arraycopy ( iTypes , i , newTypes , i + 1 , newTypes . length - i - 1 ) ;
System . arraycopy ( iValues , i , newValues , i + 1 , newValues . length - i - 1 ) ;
Partial newPartial = new Partial ( newTypes , newValues , iChronology ) ;
iChronology . validate ( newPartial , newValues ) ;
return newPartial ;
}
if ( value == getValue ( index ) ) {
return this ;
}
int [] newValues = getValues () ;
newValues = getField ( index ) . set ( this , index , newValues , value ) ;
return new Partial ( this , newValues ) ;
}
public Partial without ( DateTimeFieldType fieldType ) {
int index = indexOf ( fieldType ) ;
if ( index != - 1 ) {
DateTimeFieldType [] newTypes = new DateTimeFieldType [ size () - 1 ] ;
int [] newValues = new int [ size () - 1 ] ;
System . arraycopy ( iTypes , 0 , newTypes , 0 , index ) ;
System . arraycopy ( iTypes , index + 1 , newTypes , index , newTypes . length - index ) ;
System . arraycopy ( iValues , 0 , newValues , 0 , index ) ;
System . arraycopy ( iValues , index + 1 , newValues , index , newValues . length - index ) ;
Partial newPartial = new Partial ( iChronology , newTypes , newValues ) ;
iChronology . validate ( newPartial , newValues ) ;
return newPartial ;
}
return this ;
}
public Partial withField ( DateTimeFieldType fieldType , int value ) {
int index = indexOfSupported ( fieldType ) ;
if ( value == getValue ( index ) ) {
return this ;
}
int [] newValues = getValues () ;
newValues = getField ( index ) . set ( this , index , newValues , value ) ;
return new Partial ( this , newValues ) ;
}
public Partial withFieldAdded ( DurationFieldType fieldType , int amount ) {
int index = indexOfSupported ( fieldType ) ;
if ( amount == 0 ) {
return this ;
}
int [] newValues = getValues () ;
newValues = getField ( index ) . add ( this , index , newValues , amount ) ;
return new Partial ( this , newValues ) ;
}
public Partial withFieldAddWrapped ( DurationFieldType fieldType , int amount ) {
int index = indexOfSupported ( fieldType ) ;
if ( amount == 0 ) {
return this ;
}
int [] newValues = getValues () ;
newValues = getField ( index ) . addWrapPartial ( this , index , newValues , amount ) ;
return new Partial ( this , newValues ) ;
}
public Partial withPeriodAdded ( ReadablePeriod period , int scalar ) {
if ( period == null || scalar == 0 ) {
return this ;
}
int [] newValues = getValues () ;
for ( int i = 0 ; i < period . size () ; i ++ ) {
DurationFieldType fieldType = period . getFieldType ( i ) ;
int index = indexOf ( fieldType ) ;
if ( index >= 0 ) {
newValues = getField ( index ) . add ( this , index , newValues ,
FieldUtils . safeMultiply ( period . getValue ( i ) , scalar ) ) ;
}
}
return new Partial ( this , newValues ) ;
}
public Partial plus ( ReadablePeriod period ) {
return withPeriodAdded ( period , 1 ) ;
}
public Partial minus ( ReadablePeriod period ) {
return withPeriodAdded ( period , - 1 ) ;
}
public Property property ( DateTimeFieldType type ) {
return new Property ( this , indexOfSupported ( type ) ) ;
}
public boolean isMatch ( ReadableInstant instant ) {
long millis = DateTimeUtils . getInstantMillis ( instant ) ;
Chronology chrono = DateTimeUtils . getInstantChronology ( instant ) ;
for ( int i = 0 ; i < iTypes . length ; i ++ ) {
int value = iTypes [ i ] . getField ( chrono ) . get ( millis ) ;
if ( value != iValues [ i ] ) {
return false ;
}
}
return true ;
}
public boolean isMatch ( ReadablePartial partial ) {
if ( partial == null ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
for ( int i = 0 ; i < iTypes . length ; i ++ ) {
int value = partial . get ( iTypes [ i ] ) ;
if ( value != iValues [ i ] ) {
return false ;
}
}
return true ;
}
public DateTimeFormatter getFormatter () {
DateTimeFormatter [] f = iFormatter ;
if ( f == null ) {
if ( size () == 0 ) {
return null ;
}
f = new DateTimeFormatter [ 2 ] ;
try {
List < DateTimeFieldType > list = new ArrayList < DateTimeFieldType > ( Arrays . asList ( iTypes ) ) ;
f [ 0 ] = ISODateTimeFormat . forFields ( list , true , false ) ;
if ( list . size () == 0 ) {
f [ 1 ] = f [ 0 ] ;
}
} catch ( IllegalArgumentException ex ) {
}
iFormatter = f ;
}
return f [ 0 ] ;
}
public String toString () {
DateTimeFormatter [] f = iFormatter ;
if ( f == null ) {
getFormatter () ;
f = iFormatter ;
if ( f == null ) {
return toStringList () ;
}
}
DateTimeFormatter f1 = f [ 1 ] ;
if ( f1 == null ) {
return toStringList () ;
}
return f1 . print ( this ) ;
}
public String toStringList () {
int size = size () ;
StringBuilder buf = new StringBuilder ( 20 * size ) ;
buf . append ( '[' ) ;
for ( int i = 0 ; i < size ; i ++ ) {
if ( i > 0 ) {
buf . append ( ',' ) . append ( ' ' ) ;
}
buf . append ( iTypes [ i ] . getName () ) ;
buf . append ( '=' ) ;
buf . append ( iValues [ i ] ) ;
}
buf . append ( ']' ) ;
return buf . toString () ;
}
public String toString ( String pattern ) {
if ( pattern == null ) {
return toString () ;
}
return DateTimeFormat . forPattern ( pattern ) . print ( this ) ;
}
public String toString ( String pattern , Locale locale ) {
if ( pattern == null ) {
return toString () ;
}
return DateTimeFormat . forPattern ( pattern ) . withLocale ( locale ) . print ( this ) ;
}
public DateTimeField getField () {
return iPartial . getField ( iFieldIndex ) ;
}
protected ReadablePartial getReadablePartial () {
return iPartial ;
}
public Partial getPartial () {
return iPartial ;
}
public int get () {
return iPartial . getValue ( iFieldIndex ) ;
}
public Partial addToCopy ( int valueToAdd ) {
int [] newValues = iPartial . getValues () ;
newValues = getField () . add ( iPartial , iFieldIndex , newValues , valueToAdd ) ;
return new Partial ( iPartial , newValues ) ;
}
public Partial addWrapFieldToCopy ( int valueToAdd ) {
int [] newValues = iPartial . getValues () ;
newValues = getField () . addWrapField ( iPartial , iFieldIndex , newValues , valueToAdd ) ;
return new Partial ( iPartial , newValues ) ;
}
public Partial setCopy ( int value ) {
int [] newValues = iPartial . getValues () ;
newValues = getField () . set ( iPartial , iFieldIndex , newValues , value ) ;
return new Partial ( iPartial , newValues ) ;
}
public Partial setCopy ( String text , Locale locale ) {
int [] newValues = iPartial . getValues () ;
newValues = getField () . set ( iPartial , iFieldIndex , newValues , text , locale ) ;
return new Partial ( iPartial , newValues ) ;
}
public Partial setCopy ( String text ) {
return setCopy ( text , null ) ;
}
public Partial withMaximumValue () {
return setCopy ( getMaximumValue () ) ;
}
public Partial withMinimumValue () {
return setCopy ( getMinimumValue () ) ;
}

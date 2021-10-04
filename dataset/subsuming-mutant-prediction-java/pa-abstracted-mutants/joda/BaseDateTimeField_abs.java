public final DateTimeFieldType getType () {
return iType ;
}
public final String getName () {
return iType . getName () ;
}
public final boolean isSupported () {
return true ;
}
public String getAsText ( long instant , Locale locale ) {
return getAsText ( get ( instant ) , locale ) ;
}
public final String getAsText ( long instant ) {
return getAsText ( instant , null ) ;
}
public String getAsText ( ReadablePartial partial , int fieldValue , Locale locale ) {
return getAsText ( fieldValue , locale ) ;
}
public final String getAsText ( ReadablePartial partial , Locale locale ) {
return getAsText ( partial , partial . get ( getType () ) , locale ) ;
}
public String getAsText ( int fieldValue , Locale locale ) {
return Integer . toString ( fieldValue ) ;
}
public String getAsShortText ( long instant , Locale locale ) {
return getAsShortText ( get ( instant ) , locale ) ;
}
public final String getAsShortText ( long instant ) {
return getAsShortText ( instant , null ) ;
}
public String getAsShortText ( ReadablePartial partial , int fieldValue , Locale locale ) {
return getAsShortText ( fieldValue , locale ) ;
}
public final String getAsShortText ( ReadablePartial partial , Locale locale ) {
return getAsShortText ( partial , partial . get ( getType () ) , locale ) ;
}
public String getAsShortText ( int fieldValue , Locale locale ) {
return getAsText ( fieldValue , locale ) ;
}
public long add ( long instant , int value ) {
return getDurationField () . add ( instant , value ) ;
}
public long add ( long instant , long value ) {
return getDurationField () . add ( instant , value ) ;
}
public int [] add ( ReadablePartial instant , int fieldIndex , int [] values , int valueToAdd ) {
if ( valueToAdd == 0 ) {
return values ;
}
DateTimeField nextField = null ;
while ( valueToAdd > 0 ) {
int max = getMaximumValue ( instant , values ) ;
long proposed = values [ fieldIndex ] + valueToAdd ;
if ( proposed <= max ) {
values [ fieldIndex ] = ( int ) proposed ;
break;
}
if ( nextField == null ) {
if ( fieldIndex == 0 ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
nextField = instant . getField ( fieldIndex - 1 ) ;
if ( getRangeDurationField () . getType () != nextField . getDurationField () . getType () ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
}
valueToAdd -= ( max + 1 ) - values [ fieldIndex ] ;
values = nextField . add ( instant , fieldIndex - 1 , values , 1 ) ;
values [ fieldIndex ] = getMinimumValue ( instant , values ) ;
}
while ( valueToAdd < 0 ) {
int min = getMinimumValue ( instant , values ) ;
long proposed = values [ fieldIndex ] + valueToAdd ;
if ( proposed >= min ) {
values [ fieldIndex ] = ( int ) proposed ;
break;
}
if ( nextField == null ) {
if ( fieldIndex == 0 ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
nextField = instant . getField ( fieldIndex - 1 ) ;
if ( getRangeDurationField () . getType () != nextField . getDurationField () . getType () ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
}
valueToAdd -= ( min - 1 ) - values [ fieldIndex ] ;
values = nextField . add ( instant , fieldIndex - 1 , values , - 1 ) ;
values [ fieldIndex ] = getMaximumValue ( instant , values ) ;
}
return set ( instant , fieldIndex , values , values [ fieldIndex ] ) ;
}
public int [] addWrapPartial ( ReadablePartial instant , int fieldIndex , int [] values , int valueToAdd ) {
if ( valueToAdd == 0 ) {
return values ;
}
DateTimeField nextField = null ;
while ( valueToAdd > 0 ) {
int max = getMaximumValue ( instant , values ) ;
long proposed = values [ fieldIndex ] + valueToAdd ;
if ( proposed <= max ) {
values [ fieldIndex ] = ( int ) proposed ;
break;
}
if ( nextField == null ) {
if ( fieldIndex == 0 ) {
valueToAdd -= ( max + 1 ) - values [ fieldIndex ] ;
values [ fieldIndex ] = getMinimumValue ( instant , values ) ;
continue;
}
nextField = instant . getField ( fieldIndex - 1 ) ;
if ( getRangeDurationField () . getType () != nextField . getDurationField () . getType () ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
}
valueToAdd -= ( max + 1 ) - values [ fieldIndex ] ;
values = nextField . addWrapPartial ( instant , fieldIndex - 1 , values , 1 ) ;
values [ fieldIndex ] = getMinimumValue ( instant , values ) ;
}
while ( valueToAdd < 0 ) {
int min = getMinimumValue ( instant , values ) ;
long proposed = values [ fieldIndex ] + valueToAdd ;
if ( proposed >= min ) {
values [ fieldIndex ] = ( int ) proposed ;
break;
}
if ( nextField == null ) {
if ( fieldIndex == 0 ) {
valueToAdd -= ( min - 1 ) - values [ fieldIndex ] ;
values [ fieldIndex ] = getMaximumValue ( instant , values ) ;
continue;
}
nextField = instant . getField ( fieldIndex - 1 ) ;
if ( getRangeDurationField () . getType () != nextField . getDurationField () . getType () ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
}
valueToAdd -= ( min - 1 ) - values [ fieldIndex ] ;
values = nextField . addWrapPartial ( instant , fieldIndex - 1 , values , - 1 ) ;
values [ fieldIndex ] = getMaximumValue ( instant , values ) ;
}
return set ( instant , fieldIndex , values , values [ fieldIndex ] ) ;
}
public long addWrapField ( long instant , int value ) {
int current = get ( instant ) ;
int wrapped = FieldUtils . getWrappedValue
( current , value , getMinimumValue ( instant ) , getMaximumValue ( instant ) ) ;
return set ( instant , wrapped ) ;
}
public int [] addWrapField ( ReadablePartial instant , int fieldIndex , int [] values , int valueToAdd ) {
int current = values [ fieldIndex ] ;
int wrapped = FieldUtils . getWrappedValue
( current , valueToAdd , getMinimumValue ( instant ) , getMaximumValue ( instant ) ) ;
return set ( instant , fieldIndex , values , wrapped ) ;
}
public int getDifference ( long minuendInstant , long subtrahendInstant ) {
return getDurationField () . getDifference ( minuendInstant , subtrahendInstant ) ;
}
public long getDifferenceAsLong ( long minuendInstant , long subtrahendInstant ) {
return getDurationField () . getDifferenceAsLong ( minuendInstant , subtrahendInstant ) ;
}
public int [] set ( ReadablePartial partial , int fieldIndex , int [] values , int newValue ) {
FieldUtils . verifyValueBounds ( this , newValue , getMinimumValue ( partial , values ) , getMaximumValue ( partial , values ) ) ;
values [ fieldIndex ] = newValue ;
for ( int i = fieldIndex + 1 ; i < partial . size () ; i ++ ) {
DateTimeField field = partial . getField ( i ) ;
if ( values [ i ] > field . getMaximumValue ( partial , values ) ) {
values [ i ] = field . getMaximumValue ( partial , values ) ;
}
if ( values [ i ] < field . getMinimumValue ( partial , values ) ) {
values [ i ] = field . getMinimumValue ( partial , values ) ;
}
}
return values ;
}
public long set ( long instant , String text , Locale locale ) {
int value = convertText ( text , locale ) ;
return set ( instant , value ) ;
}
public final long set ( long instant , String text ) {
return set ( instant , text , null ) ;
}
public int [] set ( ReadablePartial instant , int fieldIndex , int [] values , String text , Locale locale ) {
int value = convertText ( text , locale ) ;
return set ( instant , fieldIndex , values , value ) ;
}
protected int convertText ( String text , Locale locale ) {
try {
return Integer . parseInt ( text ) ;
} catch ( NumberFormatException ex ) {
throw new IllegalFieldValueException ( getType () , text ) ;
}
}
public boolean isLeap ( long instant ) {
return false ;
}
public int getLeapAmount ( long instant ) {
return 0 ;
}
public DurationField getLeapDurationField () {
return null ;
}
public int getMinimumValue ( long instant ) {
return getMinimumValue () ;
}
public int getMinimumValue ( ReadablePartial instant ) {
return getMinimumValue () ;
}
public int getMinimumValue ( ReadablePartial instant , int [] values ) {
return getMinimumValue ( instant ) ;
}
public int getMaximumValue ( long instant ) {
return getMaximumValue () ;
}
public int getMaximumValue ( ReadablePartial instant ) {
return getMaximumValue () ;
}
public int getMaximumValue ( ReadablePartial instant , int [] values ) {
return getMaximumValue ( instant ) ;
}
public int getMaximumTextLength ( Locale locale ) {
int max = getMaximumValue () ;
if ( max >= 0 ) {
if ( max < 10 ) {
return 1 ;
} else if ( max < 100 ) {
return 2 ;
} else if ( max < 1000 ) {
return 3 ;
}
}
return Integer . toString ( max ) . length () ;
}
public int getMaximumShortTextLength ( Locale locale ) {
return getMaximumTextLength ( locale ) ;
}
public long roundCeiling ( long instant ) {
long newInstant = roundFloor ( instant ) ;
if ( newInstant != instant ) {
instant = add ( newInstant , 1 ) ;
}
return instant ;
}
public long roundHalfFloor ( long instant ) {
long floor = roundFloor ( instant ) ;
long ceiling = roundCeiling ( instant ) ;
long diffFromFloor = instant - floor ;
long diffToCeiling = ceiling - instant ;
if ( diffFromFloor <= diffToCeiling ) {
return floor ;
} else {
return ceiling ;
}
}
public long roundHalfCeiling ( long instant ) {
long floor = roundFloor ( instant ) ;
long ceiling = roundCeiling ( instant ) ;
long diffFromFloor = instant - floor ;
long diffToCeiling = ceiling - instant ;
if ( diffToCeiling <= diffFromFloor ) {
return ceiling ;
} else {
return floor ;
}
}
public long roundHalfEven ( long instant ) {
long floor = roundFloor ( instant ) ;
long ceiling = roundCeiling ( instant ) ;
long diffFromFloor = instant - floor ;
long diffToCeiling = ceiling - instant ;
if ( diffFromFloor < diffToCeiling ) {
return floor ;
} else if ( diffToCeiling < diffFromFloor ) {
return ceiling ;
} else {
if ( ( get ( ceiling ) & 1 ) == 0 ) {
return ceiling ;
}
return floor ;
}
}
public long remainder ( long instant ) {
return instant - roundFloor ( instant ) ;
}
public String toString () {
return lr_3 + getName () + ']' ;
}

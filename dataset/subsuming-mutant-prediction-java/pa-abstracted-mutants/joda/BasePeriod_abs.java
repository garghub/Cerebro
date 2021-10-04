public int getValue ( int index ) {
return 0 ;
}
public PeriodType getPeriodType () {
return PeriodType . time () ;
}
protected PeriodType checkPeriodType ( PeriodType type ) {
return DateTimeUtils . getPeriodType ( type ) ;
}
public PeriodType getPeriodType () {
return iType ;
}
public int getValue ( int index ) {
return iValues [ index ] ;
}
public Duration toDurationFrom ( ReadableInstant startInstant ) {
long startMillis = DateTimeUtils . getInstantMillis ( startInstant ) ;
Chronology chrono = DateTimeUtils . getInstantChronology ( startInstant ) ;
long endMillis = chrono . add ( this , startMillis , 1 ) ;
return new Duration ( startMillis , endMillis ) ;
}
public Duration toDurationTo ( ReadableInstant endInstant ) {
long endMillis = DateTimeUtils . getInstantMillis ( endInstant ) ;
Chronology chrono = DateTimeUtils . getInstantChronology ( endInstant ) ;
long startMillis = chrono . add ( this , endMillis , - 1 ) ;
return new Duration ( startMillis , endMillis ) ;
}
private void checkAndUpdate ( DurationFieldType type , int [] values , int newValue ) {
int index = indexOf ( type ) ;
if ( index == - 1 ) {
if ( newValue != 0 ) {
throw new IllegalArgumentException (
lr_1 + type . getName () + lr_2 ) ;
}
} else {
values [ index ] = newValue ;
}
}
protected void setPeriod ( ReadablePeriod period ) {
if ( period == null ) {
setValues ( new int [ size () ] ) ;
} else {
setPeriodInternal ( period ) ;
}
}
private void setPeriodInternal ( ReadablePeriod period ) {
int [] newValues = new int [ size () ] ;
for ( int i = 0 , isize = period . size () ; i < isize ; i ++ ) {
DurationFieldType type = period . getFieldType ( i ) ;
int value = period . getValue ( i ) ;
checkAndUpdate ( type , newValues , value ) ;
}
setValues ( newValues ) ;
}
protected void setPeriod ( int years , int months , int weeks , int days ,
int hours , int minutes , int seconds , int millis ) {
int [] newValues = setPeriodInternal ( years , months , weeks , days , hours , minutes , seconds , millis ) ;
setValues ( newValues ) ;
}
private int [] setPeriodInternal ( int years , int months , int weeks , int days ,
int hours , int minutes , int seconds , int millis ) {
int [] newValues = new int [ size () ] ;
checkAndUpdate ( DurationFieldType . years () , newValues , years ) ;
checkAndUpdate ( DurationFieldType . months () , newValues , months ) ;
checkAndUpdate ( DurationFieldType . weeks () , newValues , weeks ) ;
checkAndUpdate ( DurationFieldType . days () , newValues , days ) ;
checkAndUpdate ( DurationFieldType . hours () , newValues , hours ) ;
checkAndUpdate ( DurationFieldType . minutes () , newValues , minutes ) ;
checkAndUpdate ( DurationFieldType . seconds () , newValues , seconds ) ;
checkAndUpdate ( DurationFieldType . millis () , newValues , millis ) ;
return newValues ;
}
protected void setField ( DurationFieldType field , int value ) {
setFieldInto ( iValues , field , value ) ;
}
protected void setFieldInto ( int [] values , DurationFieldType field , int value ) {
int index = indexOf ( field ) ;
if ( index == - 1 ) {
if ( value != 0 || field == null ) {
throw new IllegalArgumentException (
lr_1 + field + lr_2 ) ;
}
} else {
values [ index ] = value ;
}
}
protected void addField ( DurationFieldType field , int value ) {
addFieldInto ( iValues , field , value ) ;
}
protected void addFieldInto ( int [] values , DurationFieldType field , int value ) {
int index = indexOf ( field ) ;
if ( index == - 1 ) {
if ( value != 0 || field == null ) {
throw new IllegalArgumentException (
lr_1 + field + lr_2 ) ;
}
} else {
values [ index ] = FieldUtils . safeAdd ( values [ index ] , value ) ;
}
}
protected void mergePeriod ( ReadablePeriod period ) {
if ( period != null ) {
setValues ( mergePeriodInto ( getValues () , period ) ) ;
}
}
protected int [] mergePeriodInto ( int [] values , ReadablePeriod period ) {
for ( int i = 0 , isize = period . size () ; i < isize ; i ++ ) {
DurationFieldType type = period . getFieldType ( i ) ;
int value = period . getValue ( i ) ;
checkAndUpdate ( type , values , value ) ;
}
return values ;
}
protected void addPeriod ( ReadablePeriod period ) {
if ( period != null ) {
setValues ( addPeriodInto ( getValues () , period ) ) ;
}
}
protected int [] addPeriodInto ( int [] values , ReadablePeriod period ) {
for ( int i = 0 , isize = period . size () ; i < isize ; i ++ ) {
DurationFieldType type = period . getFieldType ( i ) ;
int value = period . getValue ( i ) ;
if ( value != 0 ) {
int index = indexOf ( type ) ;
if ( index == - 1 ) {
throw new IllegalArgumentException (
lr_1 + type . getName () + lr_2 ) ;
} else {
values [ index ] = FieldUtils . safeAdd ( getValue ( index ) , value ) ;
}
}
}
return values ;
}
protected void setValue ( int index , int value ) {
iValues [ index ] = value ;
}
protected void setValues ( int [] values ) {
System . arraycopy ( values , 0 , iValues , 0 , iValues . length ) ;
}

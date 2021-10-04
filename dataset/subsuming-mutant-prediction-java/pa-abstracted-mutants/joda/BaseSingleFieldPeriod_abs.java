protected static int between ( ReadableInstant start , ReadableInstant end , DurationFieldType field ) {
if ( start == null || end == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
Chronology chrono = DateTimeUtils . getInstantChronology ( start ) ;
int amount = field . getField ( chrono ) . getDifference ( end . getMillis () , start . getMillis () ) ;
return amount ;
}
protected static int between ( ReadablePartial start , ReadablePartial end , ReadablePeriod zeroInstance ) {
if ( start == null || end == null ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
if ( start . size () != end . size () ) {
throw new IllegalArgumentException ( lr_3 ) ;
}
for ( int i = 0 , isize = start . size () ; i < isize ; i ++ ) {
if ( start . getFieldType ( i ) != end . getFieldType ( i ) ) {
throw new IllegalArgumentException ( lr_3 ) ;
}
}
if ( DateTimeUtils . isContiguous ( start ) == false ) {
throw new IllegalArgumentException ( lr_4 ) ;
}
Chronology chrono = DateTimeUtils . getChronology ( start . getChronology () ) . withUTC () ;
int [] values = chrono . get ( zeroInstance , chrono . set ( start , START_1972 ) , chrono . set ( end , START_1972 ) ) ;
return values [ 0 ] ;
}
protected static int standardPeriodIn ( ReadablePeriod period , long millisPerUnit ) {
if ( period == null ) {
return 0 ;
}
Chronology iso = ISOChronology . getInstanceUTC () ;
long duration = 0L ;
for ( int i = 0 ; i < period . size () ; i ++ ) {
int value = period . getValue ( i ) ;
if ( value != 0 ) {
DurationField field = period . getFieldType ( i ) . getField ( iso ) ;
if ( field . isPrecise () == false ) {
throw new IllegalArgumentException (
lr_5 + field . getName () +
lr_6 + period ) ;
}
duration = FieldUtils . safeAdd ( duration , FieldUtils . safeMultiply ( field . getUnitMillis () , value ) ) ;
}
}
return FieldUtils . safeToInt ( duration / millisPerUnit ) ;
}
protected int getValue () {
return iPeriod ;
}
protected void setValue ( int value ) {
iPeriod = value ;
}
public int size () {
return 1 ;
}
public DurationFieldType getFieldType ( int index ) {
if ( index != 0 ) {
throw new IndexOutOfBoundsException ( String . valueOf ( index ) ) ;
}
return getFieldType () ;
}
public int getValue ( int index ) {
if ( index != 0 ) {
throw new IndexOutOfBoundsException ( String . valueOf ( index ) ) ;
}
return getValue () ;
}
public int get ( DurationFieldType type ) {
if ( type == getFieldType () ) {
return getValue () ;
}
return 0 ;
}
public boolean isSupported ( DurationFieldType type ) {
return ( type == getFieldType () ) ;
}
public Period toPeriod () {
return Period . ZERO . withFields ( this ) ;
}
public MutablePeriod toMutablePeriod () {
MutablePeriod period = new MutablePeriod () ;
period . add ( this ) ;
return period ;
}
public boolean equals ( Object period ) {
if ( this == period ) {
return true ;
}
if ( period instanceof ReadablePeriod == false ) {
return false ;
}
ReadablePeriod other = ( ReadablePeriod ) period ;
return ( other . getPeriodType () == getPeriodType () && other . getValue ( 0 ) == getValue () ) ;
}
public int hashCode () {
int total = 17 ;
total = 27 * total + getValue () ;
total = 27 * total + getFieldType () . hashCode () ;
return total ;
}
public int compareTo ( BaseSingleFieldPeriod other ) {
if ( other . getClass () != getClass () ) {
throw new ClassCastException ( getClass () + lr_7 + other . getClass () ) ;
}
int otherValue = other . getValue () ;
int thisValue = getValue () ;
if ( thisValue > otherValue ) {
return 1 ;
}
if ( thisValue < otherValue ) {
return - 1 ;
}
return 0 ;
}

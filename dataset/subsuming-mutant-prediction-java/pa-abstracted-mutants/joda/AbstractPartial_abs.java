public DateTimeFieldType getFieldType ( int index ) {
return getField ( index , getChronology () ) . getType () ;
}
public DateTimeFieldType [] getFieldTypes () {
DateTimeFieldType [] result = new DateTimeFieldType [ size () ] ;
for ( int i = 0 ; i < result . length ; i ++ ) {
result [ i ] = getFieldType ( i ) ;
}
return result ;
}
public DateTimeField getField ( int index ) {
return getField ( index , getChronology () ) ;
}
public DateTimeField [] getFields () {
DateTimeField [] result = new DateTimeField [ size () ] ;
for ( int i = 0 ; i < result . length ; i ++ ) {
result [ i ] = getField ( i ) ;
}
return result ;
}
public int [] getValues () {
int [] result = new int [ size () ] ;
for ( int i = 0 ; i < result . length ; i ++ ) {
result [ i ] = getValue ( i ) ;
}
return result ;
}
public int get ( DateTimeFieldType type ) {
return getValue ( indexOfSupported ( type ) ) ;
}
public boolean isSupported ( DateTimeFieldType type ) {
return ( indexOf ( type ) != - 1 ) ;
}
public int indexOf ( DateTimeFieldType type ) {
for ( int i = 0 , isize = size () ; i < isize ; i ++ ) {
if ( getFieldType ( i ) == type ) {
return i ;
}
}
return - 1 ;
}
protected int indexOfSupported ( DateTimeFieldType type ) {
int index = indexOf ( type ) ;
if ( index == - 1 ) {
throw new IllegalArgumentException ( lr_1 + type + lr_2 ) ;
}
return index ;
}
protected int indexOf ( DurationFieldType type ) {
for ( int i = 0 , isize = size () ; i < isize ; i ++ ) {
if ( getFieldType ( i ) . getDurationType () == type ) {
return i ;
}
}
return - 1 ;
}
protected int indexOfSupported ( DurationFieldType type ) {
int index = indexOf ( type ) ;
if ( index == - 1 ) {
throw new IllegalArgumentException ( lr_1 + type + lr_2 ) ;
}
return index ;
}
public DateTime toDateTime ( ReadableInstant baseInstant ) {
Chronology chrono = DateTimeUtils . getInstantChronology ( baseInstant ) ;
long instantMillis = DateTimeUtils . getInstantMillis ( baseInstant ) ;
long resolved = chrono . set ( this , instantMillis ) ;
return new DateTime ( resolved , chrono ) ;
}
public boolean equals ( Object partial ) {
if ( this == partial ) {
return true ;
}
if ( partial instanceof ReadablePartial == false ) {
return false ;
}
ReadablePartial other = ( ReadablePartial ) partial ;
if ( size () != other . size () ) {
return false ;
}
for ( int i = 0 , isize = size () ; i < isize ; i ++ ) {
if ( getValue ( i ) != other . getValue ( i ) || getFieldType ( i ) != other . getFieldType ( i ) ) {
return false ;
}
}
return FieldUtils . equals ( getChronology () , other . getChronology () ) ;
}
public int hashCode () {
int total = 157 ;
for ( int i = 0 , isize = size () ; i < isize ; i ++ ) {
total = 23 * total + getValue ( i ) ;
total = 23 * total + getFieldType ( i ) . hashCode () ;
}
total += getChronology () . hashCode () ;
return total ;
}
public int compareTo ( ReadablePartial other ) {
if ( this == other ) {
return 0 ;
}
if ( size () != other . size () ) {
throw new ClassCastException ( lr_3 ) ;
}
for ( int i = 0 , isize = size () ; i < isize ; i ++ ) {
if ( getFieldType ( i ) != other . getFieldType ( i ) ) {
throw new ClassCastException ( lr_3 ) ;
}
}
for ( int i = 0 , isize = size () ; i < isize ; i ++ ) {
if ( getValue ( i ) > other . getValue ( i ) ) {
return 1 ;
}
if ( getValue ( i ) < other . getValue ( i ) ) {
return - 1 ;
}
}
return 0 ;
}
public boolean isAfter ( ReadablePartial partial ) {
if ( partial == null ) {
throw new IllegalArgumentException ( lr_4 ) ;
}
return compareTo ( partial ) > 0 ;
}
public boolean isBefore ( ReadablePartial partial ) {
if ( partial == null ) {
throw new IllegalArgumentException ( lr_4 ) ;
}
return compareTo ( partial ) < 0 ;
}
public boolean isEqual ( ReadablePartial partial ) {
if ( partial == null ) {
throw new IllegalArgumentException ( lr_4 ) ;
}
return compareTo ( partial ) == 0 ;
}
public String toString ( DateTimeFormatter formatter ) {
if ( formatter == null ) {
return toString () ;
}
return formatter . print ( this ) ;
}

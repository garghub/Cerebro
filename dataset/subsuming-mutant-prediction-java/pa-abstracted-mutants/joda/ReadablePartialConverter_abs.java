public Chronology getChronology ( Object object , DateTimeZone zone ) {
return getChronology ( object , ( Chronology ) null ) . withZone ( zone ) ;
}
public Chronology getChronology ( Object object , Chronology chrono ) {
if ( chrono == null ) {
chrono = ( ( ReadablePartial ) object ) . getChronology () ;
chrono = DateTimeUtils . getChronology ( chrono ) ;
}
return chrono ;
}
public int [] getPartialValues ( ReadablePartial fieldSource , Object object , Chronology chrono ) {
ReadablePartial input = ( ReadablePartial ) object ;
int size = fieldSource . size () ;
int [] values = new int [ size ] ;
for ( int i = 0 ; i < size ; i ++ ) {
values [ i ] = input . get ( fieldSource . getFieldType ( i ) ) ;
}
chrono . validate ( fieldSource , values ) ;
return values ;
}
public Class < ? > getSupportedType () {
return ReadablePartial . class ;
}

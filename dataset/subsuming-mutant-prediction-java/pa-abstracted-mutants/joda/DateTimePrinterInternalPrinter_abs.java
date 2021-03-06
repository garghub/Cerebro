static InternalPrinter of ( DateTimePrinter underlying ) {
if ( underlying instanceof InternalPrinterDateTimePrinter ) {
return ( InternalPrinter ) underlying ;
}
if ( underlying == null ) {
return null ;
}
return new DateTimePrinterInternalPrinter ( underlying ) ;
}
DateTimePrinter getUnderlying () {
return underlying ;
}
public int estimatePrintedLength () {
return underlying . estimatePrintedLength () ;
}
public void printTo ( Appendable appendable , long instant , Chronology chrono , int displayOffset ,
DateTimeZone displayZone , Locale locale ) throws IOException {
if ( appendable instanceof StringBuffer ) {
StringBuffer buf = ( StringBuffer ) appendable ;
underlying . printTo ( buf , instant , chrono , displayOffset , displayZone , locale ) ;
} else if ( appendable instanceof Writer ) {
Writer out = ( Writer ) appendable ;
underlying . printTo ( out , instant , chrono , displayOffset , displayZone , locale ) ;
} else {
StringBuffer buf = new StringBuffer ( estimatePrintedLength () ) ;
underlying . printTo ( buf , instant , chrono , displayOffset , displayZone , locale ) ;
appendable . append ( buf ) ;
}
}
public void printTo ( Appendable appendable , ReadablePartial partial , Locale locale ) throws IOException {
if ( appendable instanceof StringBuffer ) {
StringBuffer buf = ( StringBuffer ) appendable ;
underlying . printTo ( buf , partial , locale ) ;
} else if ( appendable instanceof Writer ) {
Writer out = ( Writer ) appendable ;
underlying . printTo ( out , partial , locale ) ;
} else {
StringBuffer buf = new StringBuffer ( estimatePrintedLength () ) ;
underlying . printTo ( buf , partial , locale ) ;
appendable . append ( buf ) ;
}
}

static InternalParser of ( DateTimeParser underlying ) {
if ( underlying instanceof InternalParserDateTimeParser ) {
return ( InternalParser ) underlying ;
}
if ( underlying == null ) {
return null ;
}
return new DateTimeParserInternalParser ( underlying ) ;
}
DateTimeParser getUnderlying () {
return underlying ;
}
public int estimateParsedLength () {
return underlying . estimateParsedLength () ;
}
public int parseInto ( DateTimeParserBucket bucket , CharSequence text , int position ) {
return underlying . parseInto ( bucket , text . toString () , position ) ;
}

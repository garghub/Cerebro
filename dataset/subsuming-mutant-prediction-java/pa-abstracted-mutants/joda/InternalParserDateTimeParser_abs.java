static DateTimeParser of ( InternalParser underlying ) {
if ( underlying instanceof DateTimeParserInternalParser ) {
return ( ( DateTimeParserInternalParser ) underlying ) . getUnderlying () ;
}
if ( underlying instanceof DateTimeParser ) {
return ( DateTimeParser ) underlying ;
}
if ( underlying == null ) {
return null ;
}
return new InternalParserDateTimeParser ( underlying ) ;
}
public int estimateParsedLength () {
return underlying . estimateParsedLength () ;
}
public int parseInto ( DateTimeParserBucket bucket , CharSequence text , int position ) {
return underlying . parseInto ( bucket , text , position ) ;
}
public int parseInto ( DateTimeParserBucket bucket , String text , int position ) {
return underlying . parseInto ( bucket , text , position ) ;
}
@Override
public boolean equals ( Object obj ) {
if ( obj == this ) {
return true ;
}
if ( obj instanceof InternalParserDateTimeParser ) {
InternalParserDateTimeParser other = ( InternalParserDateTimeParser ) obj ;
return underlying . equals ( other . underlying ) ;
}
return false ;
}

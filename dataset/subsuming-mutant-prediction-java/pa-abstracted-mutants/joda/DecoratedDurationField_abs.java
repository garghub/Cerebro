public final DurationField getWrappedField () {
return iField ;
}
public boolean isPrecise () {
return iField . isPrecise () ;
}
public long getValueAsLong ( long duration , long instant ) {
return iField . getValueAsLong ( duration , instant ) ;
}
public long getMillis ( int value , long instant ) {
return iField . getMillis ( value , instant ) ;
}
public long getMillis ( long value , long instant ) {
return iField . getMillis ( value , instant ) ;
}
public long add ( long instant , int value ) {
return iField . add ( instant , value ) ;
}
public long add ( long instant , long value ) {
return iField . add ( instant , value ) ;
}
public long getDifferenceAsLong ( long minuendInstant , long subtrahendInstant ) {
return iField . getDifferenceAsLong ( minuendInstant , subtrahendInstant ) ;
}
public long getUnitMillis () {
return iField . getUnitMillis () ;
}

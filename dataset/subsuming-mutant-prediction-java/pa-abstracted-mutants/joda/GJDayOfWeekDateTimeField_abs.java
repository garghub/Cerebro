public int get ( long instant ) {
return iChronology . getDayOfWeek ( instant ) ;
}
public String getAsText ( int fieldValue , Locale locale ) {
return GJLocaleSymbols . forLocale ( locale ) . dayOfWeekValueToText ( fieldValue ) ;
}
public String getAsShortText ( int fieldValue , Locale locale ) {
return GJLocaleSymbols . forLocale ( locale ) . dayOfWeekValueToShortText ( fieldValue ) ;
}
protected int convertText ( String text , Locale locale ) {
return GJLocaleSymbols . forLocale ( locale ) . dayOfWeekTextToValue ( text ) ;
}
public DurationField getRangeDurationField () {
return iChronology . weeks () ;
}
public int getMinimumValue () {
return DateTimeConstants . MONDAY ;
}
public int getMaximumValue () {
return DateTimeConstants . SUNDAY ;
}
public int getMaximumTextLength ( Locale locale ) {
return GJLocaleSymbols . forLocale ( locale ) . getDayOfWeekMaxTextLength () ;
}
public int getMaximumShortTextLength ( Locale locale ) {
return GJLocaleSymbols . forLocale ( locale ) . getDayOfWeekMaxShortTextLength () ;
}
private Object readResolve () {
return iChronology . dayOfWeek () ;
}

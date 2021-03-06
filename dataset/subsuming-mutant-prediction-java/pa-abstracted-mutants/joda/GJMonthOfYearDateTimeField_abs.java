public String getAsText ( int fieldValue , Locale locale ) {
return GJLocaleSymbols . forLocale ( locale ) . monthOfYearValueToText ( fieldValue ) ;
}
public String getAsShortText ( int fieldValue , Locale locale ) {
return GJLocaleSymbols . forLocale ( locale ) . monthOfYearValueToShortText ( fieldValue ) ;
}
protected int convertText ( String text , Locale locale ) {
return GJLocaleSymbols . forLocale ( locale ) . monthOfYearTextToValue ( text ) ;
}
public int getMaximumTextLength ( Locale locale ) {
return GJLocaleSymbols . forLocale ( locale ) . getMonthMaxTextLength () ;
}
public int getMaximumShortTextLength ( Locale locale ) {
return GJLocaleSymbols . forLocale ( locale ) . getMonthMaxShortTextLength () ;
}

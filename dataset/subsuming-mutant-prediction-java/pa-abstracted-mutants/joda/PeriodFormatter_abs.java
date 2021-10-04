public boolean isPrinter () {
return ( iPrinter != null ) ;
}
public PeriodPrinter getPrinter () {
return iPrinter ;
}
public boolean isParser () {
return ( iParser != null ) ;
}
public PeriodParser getParser () {
return iParser ;
}
public PeriodFormatter withLocale ( Locale locale ) {
if ( locale == getLocale () || ( locale != null && locale . equals ( getLocale () ) ) ) {
return this ;
}
return new PeriodFormatter ( iPrinter , iParser , locale , iParseType ) ;
}
public Locale getLocale () {
return iLocale ;
}
public PeriodFormatter withParseType ( PeriodType type ) {
if ( type == iParseType ) {
return this ;
}
return new PeriodFormatter ( iPrinter , iParser , iLocale , type ) ;
}
public PeriodType getParseType () {
return iParseType ;
}
public void printTo ( StringBuffer buf , ReadablePeriod period ) {
checkPrinter () ;
checkPeriod ( period ) ;
getPrinter () . printTo ( buf , period , iLocale ) ;
}
public void printTo ( Writer out , ReadablePeriod period ) throws IOException {
checkPrinter () ;
checkPeriod ( period ) ;
getPrinter () . printTo ( out , period , iLocale ) ;
}
public String print ( ReadablePeriod period ) {
checkPrinter () ;
checkPeriod ( period ) ;
PeriodPrinter printer = getPrinter () ;
StringBuffer buf = new StringBuffer ( printer . calculatePrintedLength ( period , iLocale ) ) ;
printer . printTo ( buf , period , iLocale ) ;
return buf . toString () ;
}
private void checkPrinter () {
if ( iPrinter == null ) {
throw new UnsupportedOperationException ( lr_1 ) ;
}
}
private void checkPeriod ( ReadablePeriod period ) {
if ( period == null ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
}
public int parseInto ( ReadWritablePeriod period , String text , int position ) {
checkParser () ;
checkPeriod ( period ) ;
return getParser () . parseInto ( period , text , position , iLocale ) ;
}
public Period parsePeriod ( String text ) {
checkParser () ;
return parseMutablePeriod ( text ) . toPeriod () ;
}
public MutablePeriod parseMutablePeriod ( String text ) {
checkParser () ;
MutablePeriod period = new MutablePeriod ( 0 , iParseType ) ;
int newPos = getParser () . parseInto ( period , text , 0 , iLocale ) ;
if ( newPos >= 0 ) {
if ( newPos >= text . length () ) {
return period ;
}
} else {
newPos = ~ newPos ;
}
throw new IllegalArgumentException ( FormatUtils . createErrorMessage ( text , newPos ) ) ;
}
private void checkParser () {
if ( iParser == null ) {
throw new UnsupportedOperationException ( lr_3 ) ;
}
}

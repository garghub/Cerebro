@Override
protected FastDateFormat createInstance ( final String pattern , final TimeZone timeZone , final Locale locale ) {
return new FastDateFormat ( pattern , timeZone , locale ) ;
}
public static FastDateFormat getInstance () {
return cache . getInstance () ;
}
public static FastDateFormat getInstance ( final String pattern ) {
return cache . getInstance ( pattern , null , null ) ;
}
public static FastDateFormat getInstance ( final String pattern , final TimeZone timeZone ) {
return cache . getInstance ( pattern , timeZone , null ) ;
}
public static FastDateFormat getInstance ( final String pattern , final Locale locale ) {
return cache . getInstance ( pattern , null , locale ) ;
}
public static FastDateFormat getInstance ( final String pattern , final TimeZone timeZone , final Locale locale ) {
return cache . getInstance ( pattern , timeZone , locale ) ;
}
public static FastDateFormat getDateInstance ( final int style ) {
return cache . getDateInstance ( style , null , null ) ;
}
public static FastDateFormat getDateInstance ( final int style , final Locale locale ) {
return cache . getDateInstance ( style , null , locale ) ;
}
public static FastDateFormat getDateInstance ( final int style , final TimeZone timeZone ) {
return cache . getDateInstance ( style , timeZone , null ) ;
}
public static FastDateFormat getDateInstance ( final int style , final TimeZone timeZone , final Locale locale ) {
return cache . getDateInstance ( style , timeZone , locale ) ;
}
public static FastDateFormat getTimeInstance ( final int style ) {
return cache . getTimeInstance ( style , null , null ) ;
}
public static FastDateFormat getTimeInstance ( final int style , final Locale locale ) {
return cache . getTimeInstance ( style , null , locale ) ;
}
public static FastDateFormat getTimeInstance ( final int style , final TimeZone timeZone ) {
return cache . getTimeInstance ( style , timeZone , null ) ;
}
public static FastDateFormat getTimeInstance ( final int style , final TimeZone timeZone , final Locale locale ) {
return cache . getTimeInstance ( style , timeZone , locale ) ;
}
public static FastDateFormat getDateTimeInstance ( final int dateStyle , final int timeStyle ) {
return cache . getDateTimeInstance ( dateStyle , timeStyle , null , null ) ;
}
public static FastDateFormat getDateTimeInstance ( final int dateStyle , final int timeStyle , final Locale locale ) {
return cache . getDateTimeInstance ( dateStyle , timeStyle , null , locale ) ;
}
public static FastDateFormat getDateTimeInstance ( final int dateStyle , final int timeStyle , final TimeZone timeZone ) {
return getDateTimeInstance ( dateStyle , timeStyle , timeZone , null ) ;
}
public static FastDateFormat getDateTimeInstance (
final int dateStyle , final int timeStyle , final TimeZone timeZone , final Locale locale ) {
return cache . getDateTimeInstance ( dateStyle , timeStyle , timeZone , locale ) ;
}
@Override
public StringBuffer format ( final Object obj , final StringBuffer toAppendTo , final FieldPosition pos ) {
return toAppendTo . append ( printer . format ( obj ) ) ;
}
@Override
public String format ( final long millis ) {
return printer . format ( millis ) ;
}
@Override
public String format ( final Date date ) {
return printer . format ( date ) ;
}
@Override
public String format ( final Calendar calendar ) {
return printer . format ( calendar ) ;
}
@Deprecated
@Override
public StringBuffer format ( final long millis , final StringBuffer buf ) {
return printer . format ( millis , buf ) ;
}
@Deprecated
@Override
public StringBuffer format ( final Date date , final StringBuffer buf ) {
return printer . format ( date , buf ) ;
}
@Deprecated
@Override
public StringBuffer format ( final Calendar calendar , final StringBuffer buf ) {
return printer . format ( calendar , buf ) ;
}
@Override
public < B extends Appendable > B format ( final long millis , final B buf ) {
return printer . format ( millis , buf ) ;
}
@Override
public < B extends Appendable > B format ( final Date date , final B buf ) {
return printer . format ( date , buf ) ;
}
@Override
public < B extends Appendable > B format ( final Calendar calendar , final B buf ) {
return printer . format ( calendar , buf ) ;
}
@Override
public Date parse ( final String source ) throws ParseException {
return parser . parse ( source ) ;
}
@Override
public Date parse ( final String source , final ParsePosition pos ) {
return parser . parse ( source , pos ) ;
}
@Override
public Object parseObject ( final String source , final ParsePosition pos ) {
return parser . parseObject ( source , pos ) ;
}
@Override
public String getPattern () {
return printer . getPattern () ;
}
@Override
public TimeZone getTimeZone () {
return printer . getTimeZone () ;
}
@Override
public Locale getLocale () {
return printer . getLocale () ;
}
public int getMaxLengthEstimate () {
return printer . getMaxLengthEstimate () ;
}
@Override
public boolean equals ( final Object obj ) {
if ( obj instanceof FastDateFormat == false ) {
return false ;
}
final FastDateFormat other = ( FastDateFormat ) obj ;
return printer . equals ( other . printer ) ;
}
@Override
public int hashCode () {
return printer . hashCode () ;
}
@Override
public String toString () {
return lr_1 + printer . getPattern () + lr_2 + printer . getLocale () + lr_2 + printer . getTimeZone () . getID () + lr_3 ;
}
@Deprecated
protected StringBuffer applyRules ( final Calendar calendar , final StringBuffer buf ) {
return printer . applyRules ( calendar , buf ) ;
}

public static String formatUTC ( final long millis , final String pattern ) {
return format ( new Date ( millis ) , pattern , UTC_TIME_ZONE , null ) ;
}
public static String formatUTC ( final Date date , final String pattern ) {
return format ( date , pattern , UTC_TIME_ZONE , null ) ;
}
public static String formatUTC ( final long millis , final String pattern , final Locale locale ) {
return format ( new Date ( millis ) , pattern , UTC_TIME_ZONE , locale ) ;
}
public static String formatUTC ( final Date date , final String pattern , final Locale locale ) {
return format ( date , pattern , UTC_TIME_ZONE , locale ) ;
}
public static String format ( final long millis , final String pattern ) {
return format ( new Date ( millis ) , pattern , null , null ) ;
}
public static String format ( final Date date , final String pattern ) {
return format ( date , pattern , null , null ) ;
}
public static String format ( final Calendar calendar , final String pattern ) {
return format ( calendar , pattern , null , null ) ;
}
public static String format ( final long millis , final String pattern , final TimeZone timeZone ) {
return format ( new Date ( millis ) , pattern , timeZone , null ) ;
}
public static String format ( final Date date , final String pattern , final TimeZone timeZone ) {
return format ( date , pattern , timeZone , null ) ;
}
public static String format ( final Calendar calendar , final String pattern , final TimeZone timeZone ) {
return format ( calendar , pattern , timeZone , null ) ;
}
public static String format ( final long millis , final String pattern , final Locale locale ) {
return format ( new Date ( millis ) , pattern , null , locale ) ;
}
public static String format ( final Date date , final String pattern , final Locale locale ) {
return format ( date , pattern , null , locale ) ;
}
public static String format ( final Calendar calendar , final String pattern , final Locale locale ) {
return format ( calendar , pattern , null , locale ) ;
}
public static String format ( final long millis , final String pattern , final TimeZone timeZone , final Locale locale ) {
return format ( new Date ( millis ) , pattern , timeZone , locale ) ;
}
public static String format ( final Date date , final String pattern , final TimeZone timeZone , final Locale locale ) {
final FastDateFormat df = FastDateFormat . getInstance ( pattern , timeZone , locale ) ;
return df . format ( date ) ;
}
public static String format ( final Calendar calendar , final String pattern , final TimeZone timeZone , final Locale locale ) {
final FastDateFormat df = FastDateFormat . getInstance ( pattern , timeZone , locale ) ;
return df . format ( calendar ) ;
}

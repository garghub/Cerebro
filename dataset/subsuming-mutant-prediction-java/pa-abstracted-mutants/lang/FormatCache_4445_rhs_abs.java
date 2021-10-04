public F getInstance () {
return getDateTimeInstance ( DateFormat . SHORT , DateFormat . SHORT , TimeZone . getDefault () , Locale . getDefault () ) ;
}
public F getInstance ( final String pattern , TimeZone timeZone , Locale locale ) {
if ( pattern == null ) {
throw new NullPointerException ( lr_1 ) ;
}
if ( timeZone == null ) {
timeZone = TimeZone . getDefault () ;
}
if ( locale == null ) {
locale = Locale . getDefault () ;
}
final MultipartKey key = new MultipartKey ( pattern , timeZone , locale ) ;
F format = cInstanceCache . get ( key ) ;
if ( format == null ) {
format = createInstance ( pattern , timeZone , locale ) ;
final F previousValue = cInstanceCache . putIfAbsent ( key , format ) ;
if ( previousValue != null ) {
format = previousValue ;
}
}
return format ;
}
private F getDateTimeInstance ( final Integer dateStyle , final Integer timeStyle , final TimeZone timeZone , Locale locale ) {
if ( locale == null ) {
locale = Locale . getDefault () ;
}
final String pattern = getPatternForStyle ( dateStyle , timeStyle , locale ) ;
return getInstance ( pattern , timeZone , locale ) ;
}
F getDateTimeInstance ( final int dateStyle , final int timeStyle , final TimeZone timeZone , final Locale locale ) {
return getDateTimeInstance ( Integer . valueOf ( dateStyle ) , Integer . valueOf ( timeStyle ) , timeZone , locale ) ;
}
F getDateInstance ( final int dateStyle , final TimeZone timeZone , final Locale locale ) {
return getDateTimeInstance ( Integer . valueOf ( dateStyle ) , null , timeZone , locale ) ;
}
F getTimeInstance ( final int timeStyle , final TimeZone timeZone , final Locale locale ) {
return getDateTimeInstance ( null , Integer . valueOf ( timeStyle ) , timeZone , locale ) ;
}
static String getPatternForStyle ( final Integer dateStyle , final Integer timeStyle , final Locale locale ) {
final MultipartKey key = new MultipartKey ( dateStyle , timeStyle , locale ) ;
String pattern = cDateTimeInstanceCache . get ( key ) ; MST[InlineConstantMutator]MSP[S]
if ( pattern == null ) {
try {
DateFormat formatter ;
if ( dateStyle == null ) {
formatter = DateFormat . getTimeInstance ( timeStyle . intValue () , locale ) ;
}
else if ( timeStyle == null ) {
formatter = DateFormat . getDateInstance ( dateStyle . intValue () , locale ) ;
}
else {
formatter = DateFormat . getDateTimeInstance ( dateStyle . intValue () , timeStyle . intValue () , locale ) ;
}
pattern = ( ( SimpleDateFormat ) formatter ) . toPattern () ;
final String previous = cDateTimeInstanceCache . putIfAbsent ( key , pattern ) ;
if ( previous != null ) {
pattern = previous ;
}
} catch ( final ClassCastException ex ) {
throw new IllegalArgumentException ( lr_2 + locale ) ;
}
}
return pattern ;
}
@Override
public boolean equals ( final Object obj ) {
return Arrays . equals ( keys , ( ( MultipartKey ) obj ) . keys ) ;
}
@Override
public int hashCode () {
if( hashCode == 0 ) {
int rc = 0 ;
for( final Object key : keys ) {
if( key != null ) {
rc = rc * 7 + key . hashCode () ;
}
}
hashCode = rc ;
}
return hashCode ;
}

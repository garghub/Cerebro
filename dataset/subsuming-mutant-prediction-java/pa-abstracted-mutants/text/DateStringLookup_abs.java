private String formatDate ( final long date , final String format ) {
FastDateFormat dateFormat = null ;
if ( format != null ) {
try {
dateFormat = FastDateFormat . getInstance ( format ) ;
} catch ( final Exception ex ) {
throw IllegalArgumentExceptions . format ( ex , lr_1 , format ) ;
}
}
if ( dateFormat == null ) {
dateFormat = FastDateFormat . getInstance () ;
}
return dateFormat . format ( new Date ( date ) ) ;
}
@Override
public String lookup ( final String key ) {
return formatDate ( System . currentTimeMillis () , key ) ;
}

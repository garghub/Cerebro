public Calendar parseTimestamp ( final String timestampStr ) throws ParseException {
return this . timestampParser . parseTimestamp ( timestampStr ) ;
}
@Override
public void configure ( final FTPClientConfig config )
{
if ( this . timestampParser instanceof Configurable ) {
final FTPClientConfig defaultCfg = getDefaultConfiguration () ;
if ( config != null ) {
if ( null == config . getDefaultDateFormatStr () ) {
config . setDefaultDateFormatStr ( defaultCfg . getDefaultDateFormatStr () ) ;
}
if ( null == config . getRecentDateFormatStr () ) {
config . setRecentDateFormatStr ( defaultCfg . getRecentDateFormatStr () ) ;
}
( ( Configurable ) this . timestampParser ) . configure ( config ) ;
} else {
( ( Configurable ) this . timestampParser ) . configure ( defaultCfg ) ;
}
}
}

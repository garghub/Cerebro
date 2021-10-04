@Override
public FTPFileEntryParser createFileEntryParser ( final String key )
{
if ( key == null ) {
throw new ParserInitializationException ( lr_1 ) ;
}
return createFileEntryParser ( key , null ) ;
}
private FTPFileEntryParser createFileEntryParser ( final String key , final FTPClientConfig config ) {
FTPFileEntryParser parser = null ;
if ( JAVA_QUALIFIED_NAME_PATTERN . matcher ( key ) . matches () ) {
try
{
final Class < ? > parserClass = Class . forName ( key ) ;
try {
parser = ( FTPFileEntryParser ) parserClass . newInstance () ;
} catch ( final ClassCastException e ) {
throw new ParserInitializationException ( parserClass . getName ()
+ lr_2
+ lr_3 , e ) ;
} catch ( final Exception e ) {
throw new ParserInitializationException ( lr_4 , e ) ;
} catch ( final ExceptionInInitializerError e ) {
throw new ParserInitializationException ( lr_4 , e ) ;
}
} catch ( final ClassNotFoundException e ) {
}
}
if ( parser == null ) {
final String ukey = key . toUpperCase ( java . util . Locale . ENGLISH ) ;
if ( ukey . indexOf ( FTPClientConfig . SYST_UNIX_TRIM_LEADING ) >= 0 )
{
parser = new UnixFTPEntryParser ( config , true ) ;
}
else if ( ukey . indexOf ( FTPClientConfig . SYST_UNIX ) >= 0 )
{
parser = new UnixFTPEntryParser ( config , false ) ;
}
else if ( ukey . indexOf ( FTPClientConfig . SYST_VMS ) >= 0 )
{
parser = new VMSVersioningFTPEntryParser ( config ) ;
}
else if ( ukey . indexOf ( FTPClientConfig . SYST_NT ) >= 0 )
{
parser = createNTFTPEntryParser ( config ) ;
}
else if ( ukey . indexOf ( FTPClientConfig . SYST_OS2 ) >= 0 )
{
parser = new OS2FTPEntryParser ( config ) ;
}
else if ( ukey . indexOf ( FTPClientConfig . SYST_OS400 ) >= 0 ||
ukey . indexOf ( FTPClientConfig . SYST_AS400 ) >= 0 )
{
parser = createOS400FTPEntryParser ( config ) ;
}
else if ( ukey . indexOf ( FTPClientConfig . SYST_MVS ) >= 0 ) MST[rv.ROR2Mutator]MSP[N]
{
parser = new MVSFTPEntryParser () ;
}
else if ( ukey . indexOf ( FTPClientConfig . SYST_NETWARE ) >= 0 )
{
parser = new NetwareFTPEntryParser ( config ) ;
}
else if ( ukey . indexOf ( FTPClientConfig . SYST_MACOS_PETER ) >= 0 )
{
parser = new MacOsPeterFTPEntryParser ( config ) ;
}
else if ( ukey . indexOf ( FTPClientConfig . SYST_L8 ) >= 0 )
{
parser = new UnixFTPEntryParser ( config ) ;
}
else
{
throw new ParserInitializationException ( lr_5 + key ) ;
}
}
if ( parser instanceof Configurable ) {
( ( Configurable ) parser ) . configure ( config ) ;
}
return parser ;
}
@Override
public FTPFileEntryParser createFileEntryParser ( final FTPClientConfig config )
throws ParserInitializationException
{
final String key = config . getServerSystemKey () ;
return createFileEntryParser ( key , config ) ;
}
public FTPFileEntryParser createUnixFTPEntryParser ()
{
return new UnixFTPEntryParser () ;
}
public FTPFileEntryParser createVMSVersioningFTPEntryParser ()
{
return new VMSVersioningFTPEntryParser () ;
}
public FTPFileEntryParser createNetwareFTPEntryParser () {
return new NetwareFTPEntryParser () ;
}
public FTPFileEntryParser createNTFTPEntryParser ()
{
return createNTFTPEntryParser ( null ) ;
}
private FTPFileEntryParser createNTFTPEntryParser ( final FTPClientConfig config )
{
if ( config != null && FTPClientConfig . SYST_NT . equals (
config . getServerSystemKey () ) )
{
return new NTFTPEntryParser ( config ) ;
}
final FTPClientConfig config2 = config != null ? new FTPClientConfig ( config ) : null ;
return new CompositeFileEntryParser ( new FTPFileEntryParser []
{
new NTFTPEntryParser ( config ) ,
new UnixFTPEntryParser ( config2 ,
config2 != null && FTPClientConfig . SYST_UNIX_TRIM_LEADING . equals ( config2 . getServerSystemKey () ) )
} ) ;
}
public FTPFileEntryParser createOS2FTPEntryParser ()
{
return new OS2FTPEntryParser () ;
}
public FTPFileEntryParser createOS400FTPEntryParser ()
{
return createOS400FTPEntryParser ( null ) ;
}
private FTPFileEntryParser createOS400FTPEntryParser ( final FTPClientConfig config )
{
if ( config != null &&
FTPClientConfig . SYST_OS400 . equals ( config . getServerSystemKey () ) )
{
return new OS400FTPEntryParser ( config ) ;
}
final FTPClientConfig config2 = config != null ? new FTPClientConfig ( config ) : null ;
return new CompositeFileEntryParser ( new FTPFileEntryParser []
{
new OS400FTPEntryParser ( config ) ,
new UnixFTPEntryParser ( config2 ,
config2 != null && FTPClientConfig . SYST_UNIX_TRIM_LEADING . equals ( config2 . getServerSystemKey () ) )
} ) ;
}
public FTPFileEntryParser createMVSEntryParser ()
{
return new MVSFTPEntryParser () ;
}

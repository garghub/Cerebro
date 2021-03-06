@Override
protected void setUp () throws Exception {
super . setUp () ;
FTPConf = new FTPClientConfig ( FTPClientConfig . SYST_UNIX ) ;
FTPConf . setServerTimeZoneId ( lr_1 ) ;
FTP . configure ( FTPConf ) ;
try {
FTP . connect ( lr_2 ) ;
FTP . login ( lr_3 , lr_4 ) ;
FTP . changeWorkingDirectory ( lr_5 ) ;
FTP . enterLocalPassiveMode () ;
} catch ( final SocketException e ) {
e . printStackTrace () ;
} catch ( final IOException e ) {
e . printStackTrace () ;
}
}
@Override
protected void tearDown () throws Exception {
FTP . disconnect () ;
super . tearDown () ;
}
@Override
public int compare ( final Object o1 , final Object o2 ) {
final FTPFile f1 = ( FTPFile ) o1 ;
final FTPFile f2 = ( FTPFile ) o2 ;
return f1 . getTimestamp () . getTime () . compareTo ( f2 . getTimestamp () . getTime () ) ;
}
public void testTimeZoneFunctionality () throws Exception {
final java . util . Date now = new java . util . Date () ;
final FTPFile [] files = FTP . listFiles () ;
final TreeSet < FTPFile > sorted = getSortedList ( files ) ;
FTPFile lastfile = null ;
FTPFile firstfile = null ;
for ( final FTPFile thisfile : sorted ) {
if ( firstfile == null ) {
firstfile = thisfile ;
}
if ( lastfile != null ) {
assertTrue ( lastfile . getTimestamp ()
. before ( thisfile . getTimestamp () ) ) ;
}
lastfile = thisfile ;
}
if ( firstfile == null || lastfile == null ) {
fail ( lr_6 ) ;
} else {
assertTrue ( lastfile . getTimestamp () . getTime () . before ( now ) ) ;
final Calendar first = firstfile . getTimestamp () ;
first . add ( Calendar . DAY_OF_MONTH , 2 ) ;
assertTrue ( lastfile . getTimestamp () . getTime () . toString () +
lr_7 + first . getTime () . toString () , lastfile . getTimestamp () . before ( first ) ) ;
}
}

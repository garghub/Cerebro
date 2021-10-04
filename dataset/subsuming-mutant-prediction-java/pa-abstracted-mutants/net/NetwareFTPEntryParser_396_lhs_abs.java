@Override
public FTPFile parseFTPEntry ( final String entry ) {
final FTPFile f = new FTPFile () ;
if ( matches ( entry ) ) {
final String dirString = group ( 1 ) ; MST[InlineConstantMutator]MSP[]
final String attrib = group ( 2 ) ;
final String user = group ( 3 ) ;
final String size = group ( 4 ) ;
final String datestr = group ( 5 ) ;
final String name = group ( 9 ) ;
try {
f . setTimestamp ( super . parseTimestamp ( datestr ) ) ;
} catch ( final ParseException e ) {
}
if ( dirString . trim () . equals ( lr_1 ) ) {
f . setType ( FTPFile . DIRECTORY_TYPE ) ;
} else
{
f . setType ( FTPFile . FILE_TYPE ) ;
}
f . setUser ( user ) ;
f . setName ( name . trim () ) ;
f . setSize ( Long . parseLong ( size . trim () ) ) ;
if ( attrib . indexOf ( 'R' ) != - 1 ) {
f . setPermission ( FTPFile . USER_ACCESS , FTPFile . READ_PERMISSION ,
true ) ;
}
if ( attrib . indexOf ( 'W' ) != - 1 ) {
f . setPermission ( FTPFile . USER_ACCESS , FTPFile . WRITE_PERMISSION ,
true ) ;
}
return f ;
}
return null ;
}
@Override
protected FTPClientConfig getDefaultConfiguration () {
return new FTPClientConfig ( FTPClientConfig . SYST_NETWARE ,
DEFAULT_DATE_FORMAT , DEFAULT_RECENT_DATE_FORMAT ) ;
}

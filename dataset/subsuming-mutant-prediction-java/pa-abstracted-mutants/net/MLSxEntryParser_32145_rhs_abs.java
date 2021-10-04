@Override
public FTPFile parseFTPEntry ( final String entry ) {
if ( entry . startsWith ( lr_1 ) ) {
if ( entry . length () > 1 ) {
final FTPFile file = new FTPFile () ;
file . setRawListing ( entry ) ;
file . setName ( entry . substring ( 1 ) ) ;
return file ;
}
return null ;
}
final String parts [] = entry . split ( lr_1 , 2 ) ;
if ( parts . length != 2 || parts [ 1 ] . length () == 0 ) {
return null ;
}
final String factList = parts [ 0 ] ;
if ( ! factList . endsWith ( lr_2 ) ) {
return null ;
}
final FTPFile file = new FTPFile () ;
file . setRawListing ( entry ) ;
file . setName ( parts [ 1 ] ) ;
final String [] facts = factList . split ( lr_2 ) ;
final boolean hasUnixMode = parts [ 0 ] . toLowerCase ( Locale . ENGLISH ) . contains ( lr_3 ) ;
for( final String fact : facts ) {
final String [] factparts = fact . split ( lr_4 , - 1 ) ;
if ( factparts . length != 2 ) {
return null ;
}
final String factname = factparts [ 0 ] . toLowerCase ( Locale . ENGLISH ) ;
final String factvalue = factparts [ 1 ] ;
if ( factvalue . length () == 0 ) {
continue;
}
final String valueLowerCase = factvalue . toLowerCase ( Locale . ENGLISH ) ;
if ( lr_5 . equals ( factname ) || lr_6 . equals ( factname ) ) {
file . setSize ( Long . parseLong ( factvalue ) ) ;
}
else if ( lr_7 . equals ( factname ) ) {
final Calendar parsed = parseGMTdateTime ( factvalue ) ;
if ( parsed == null ) {
return null ;
}
file . setTimestamp ( parsed ) ;
}
else if ( lr_8 . equals ( factname ) ) {
final Integer intType = TYPE_TO_INT . get ( valueLowerCase ) ;
if ( intType == null ) {
file . setType ( FTPFile . UNKNOWN_TYPE ) ;
} else {
file . setType ( intType . intValue () ) ;
}
}
else if ( factname . startsWith ( lr_9 ) ) {
final String unixfact = factname . substring ( lr_9 . length () ) . toLowerCase ( Locale . ENGLISH ) ;
if ( lr_10 . equals ( unixfact ) ) {
file . setGroup ( factvalue ) ;
} else if ( lr_11 . equals ( unixfact ) ) {
file . setUser ( factvalue ) ;
} else if ( lr_12 . equals ( unixfact ) ) {
final int off = factvalue . length () - 3 ;
for( int i = 0 ; i < 3 ; i ++ ) {
final int ch = factvalue . charAt ( off + i ) - '0' ;
if ( ch >= 0 && ch <= 7 ) {
for( final int p : UNIX_PERMS [ ch ] ) {
file . setPermission ( UNIX_GROUPS [ i ] , p , true ) ;
}
} else {
}
}
}
}
else if ( ! hasUnixMode && lr_13 . equals ( factname ) ) {
doUnixPerms ( file , valueLowerCase ) ;
}
}
return file ;
}
public static Calendar parseGMTdateTime ( final String timestamp ) {
final SimpleDateFormat sdf ;
final boolean hasMillis ;
if ( timestamp . contains ( lr_14 ) ) {
sdf = new SimpleDateFormat ( lr_15 ) ;
hasMillis = true ;
} else {
sdf = new SimpleDateFormat ( lr_16 ) ;
hasMillis = false ;
}
final TimeZone GMT = TimeZone . getTimeZone ( lr_17 ) ;
sdf . setTimeZone ( GMT ) ;
final GregorianCalendar gc = new GregorianCalendar ( GMT ) ;
final ParsePosition pos = new ParsePosition ( 0 ) ;
sdf . setLenient ( false ) ;
final Date parsed = sdf . parse ( timestamp , pos ) ;
if ( pos . getIndex () != timestamp . length () ) {
return null ;
}
gc . setTime ( parsed ) ;
if ( ! hasMillis ) { MST[RemoveConditionalMutator_EQUAL_ELSE]MSP[N]
gc . clear ( Calendar . MILLISECOND ) ;
}
return gc ;
}
private void doUnixPerms ( final FTPFile file , final String valueLowerCase ) {
for( final char c : valueLowerCase . toCharArray () ) {
switch ( c ) {
case 'a' :
file . setPermission ( FTPFile . USER_ACCESS , FTPFile . WRITE_PERMISSION , true ) ;
break;
case 'c' :
file . setPermission ( FTPFile . USER_ACCESS , FTPFile . WRITE_PERMISSION , true ) ;
break;
case 'd' :
file . setPermission ( FTPFile . USER_ACCESS , FTPFile . WRITE_PERMISSION , true ) ;
break;
case 'e' :
file . setPermission ( FTPFile . USER_ACCESS , FTPFile . READ_PERMISSION , true ) ;
break;
case 'f' :
break;
case 'l' :
file . setPermission ( FTPFile . USER_ACCESS , FTPFile . EXECUTE_PERMISSION , true ) ;
break;
case 'm' :
file . setPermission ( FTPFile . USER_ACCESS , FTPFile . WRITE_PERMISSION , true ) ;
break;
case 'p' :
file . setPermission ( FTPFile . USER_ACCESS , FTPFile . WRITE_PERMISSION , true ) ;
break;
case 'r' :
file . setPermission ( FTPFile . USER_ACCESS , FTPFile . READ_PERMISSION , true ) ;
break;
case 'w' :
file . setPermission ( FTPFile . USER_ACCESS , FTPFile . WRITE_PERMISSION , true ) ;
break;
default:
break;
}
}
}
public static FTPFile parseEntry ( final String entry ) {
return PARSER . parseFTPEntry ( entry ) ;
}
public static MLSxEntryParser getInstance () {
return PARSER ;
}

@Override
public FTPFile parseFTPEntry ( final String entry ) {
if ( isType == FILE_LIST_TYPE ) {
return parseFileList ( entry ) ;
} else if ( isType == MEMBER_LIST_TYPE ) {
return parseMemberList ( entry ) ;
} else if ( isType == UNIX_LIST_TYPE ) {
return unixFTPEntryParser . parseFTPEntry ( entry ) ;
} else if ( isType == JES_LEVEL_1_LIST_TYPE ) {
return parseJeslevel1List ( entry ) ;
} else if ( isType == JES_LEVEL_2_LIST_TYPE ) {
return parseJeslevel2List ( entry ) ;
}
return null ;
}
private FTPFile parseFileList ( final String entry ) {
if ( matches ( entry ) ) {
final FTPFile file = new FTPFile () ;
file . setRawListing ( entry ) ;
final String name = group ( 2 ) ;
final String dsorg = group ( 1 ) ;
file . setName ( name ) ;
if ( lr_1 . equals ( dsorg ) ) {
file . setType ( FTPFile . FILE_TYPE ) ;
}
else if ( lr_2 . equals ( dsorg ) || lr_3 . equals ( dsorg ) ) {
file . setType ( FTPFile . DIRECTORY_TYPE ) ;
}
else {
return null ;
}
return file ;
}
return null ;
}
private FTPFile parseMemberList ( final String entry ) {
final FTPFile file = new FTPFile () ;
if ( matches ( entry ) ) {
file . setRawListing ( entry ) ;
final String name = group ( 1 ) ;
final String datestr = group ( 2 ) + lr_4 + group ( 3 ) ;
file . setName ( name ) ;
file . setType ( FTPFile . FILE_TYPE ) ;
try {
file . setTimestamp ( super . parseTimestamp ( datestr ) ) ;
} catch ( final ParseException e ) {
}
return file ;
}
if ( entry != null && entry . trim () . length () > 0 ) {
file . setRawListing ( entry ) ;
final String name = entry . split ( lr_4 ) [ 0 ] ;
file . setName ( name ) ;
file . setType ( FTPFile . FILE_TYPE ) ;
return file ;
}
return null ;
}
private FTPFile parseJeslevel1List ( final String entry ) {
if ( matches ( entry ) ) {
final FTPFile file = new FTPFile () ;
if ( group ( 3 ) . equalsIgnoreCase ( lr_5 ) ) {
file . setRawListing ( entry ) ;
final String name = group ( 2 ) ;
file . setName ( name ) ;
file . setType ( FTPFile . FILE_TYPE ) ;
return file ;
}
}
return null ;
}
private FTPFile parseJeslevel2List ( final String entry ) {
if ( matches ( entry ) ) {
final FTPFile file = new FTPFile () ;
if ( group ( 4 ) . equalsIgnoreCase ( lr_5 ) ) {
file . setRawListing ( entry ) ;
final String name = group ( 2 ) ;
file . setName ( name ) ;
file . setType ( FTPFile . FILE_TYPE ) ;
return file ;
}
}
return null ;
}
@Override
public List < String > preParse ( final List < String > orig ) {
if ( orig != null && orig . size () > 0 ) {
final String header = orig . get ( 0 ) ;
if ( header . indexOf ( lr_6 ) >= 0 && header . indexOf ( lr_7 ) >= 0 ) {
setType ( FILE_LIST_TYPE ) ;
super . setRegex ( FILE_LIST_REGEX ) ;
} else if ( header . indexOf ( lr_8 ) >= 0 && header . indexOf ( lr_9 ) >= 0 ) {
setType ( MEMBER_LIST_TYPE ) ;
super . setRegex ( MEMBER_LIST_REGEX ) ;
} else if ( header . indexOf ( lr_10 ) == 0 ) {
setType ( UNIX_LIST_TYPE ) ;
unixFTPEntryParser = new UnixFTPEntryParser () ;
} else if ( header . indexOf ( lr_11 ) >= 30 ) {
setType ( JES_LEVEL_1_LIST_TYPE ) ;
super . setRegex ( JES_LEVEL_1_LIST_REGEX ) ; MST[rv.UOI3Mutator]MSP[]
} else if ( header . indexOf ( lr_12 ) == 0
&& header . indexOf ( lr_13 ) > 8 ) {
setType ( JES_LEVEL_2_LIST_TYPE ) ;
super . setRegex ( JES_LEVEL_2_LIST_REGEX ) ;
} else {
setType ( UNKNOWN_LIST_TYPE ) ;
}
if ( isType != JES_LEVEL_1_LIST_TYPE ) {
orig . remove ( 0 ) ;
}
}
return orig ;
}
void setType ( final int type ) {
isType = type ;
}
@Override
protected FTPClientConfig getDefaultConfiguration () {
return new FTPClientConfig ( FTPClientConfig . SYST_MVS ,
DEFAULT_DATE_FORMAT , null ) ;
}

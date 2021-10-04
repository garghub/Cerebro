public void testParseFieldsOnAIX () {
final FTPClientConfig config = new FTPClientConfig ( FTPClientConfig . SYST_UNIX ) ;
config . setDefaultDateFormatStr ( lr_1 ) ;
final UnixFTPEntryParser parser = new UnixFTPEntryParser () ;
parser . configure ( config ) ;
final FTPFile f = parser . parseFTPEntry ( lr_2 ) ;
assertNotNull ( lr_3 , f ) ;
assertFalse ( lr_4 , f . isDirectory () ) ;
assertTrue ( lr_5 , f . hasPermission (
FTPFile . USER_ACCESS , FTPFile . READ_PERMISSION ) ) ;
assertTrue ( lr_6 , f . hasPermission (
FTPFile . USER_ACCESS , FTPFile . WRITE_PERMISSION ) ) ;
assertFalse ( lr_7 , f
. hasPermission ( FTPFile . USER_ACCESS , FTPFile . EXECUTE_PERMISSION ) ) ;
assertTrue ( lr_8 , f . hasPermission (
FTPFile . GROUP_ACCESS , FTPFile . READ_PERMISSION ) ) ;
assertFalse ( lr_9 , f
. hasPermission ( FTPFile . GROUP_ACCESS , FTPFile . WRITE_PERMISSION ) ) ;
assertFalse ( lr_10 ,
f . hasPermission ( FTPFile . GROUP_ACCESS ,
FTPFile . EXECUTE_PERMISSION ) ) ;
assertFalse ( lr_11 , f . hasPermission (
FTPFile . WORLD_ACCESS , FTPFile . READ_PERMISSION ) ) ;
assertFalse ( lr_12 , f
. hasPermission ( FTPFile . WORLD_ACCESS , FTPFile . WRITE_PERMISSION ) ) ;
assertFalse ( lr_13 ,
f . hasPermission ( FTPFile . WORLD_ACCESS ,
FTPFile . EXECUTE_PERMISSION ) ) ;
assertEquals ( 1 , f . getHardLinkCount () ) ;
assertEquals ( lr_14 , f . getUser () ) ;
assertEquals ( lr_15 , f . getGroup () ) ;
assertEquals ( lr_16 , f . getName () ) ;
assertEquals ( 814 , f . getSize () ) ;
final Calendar cal = Calendar . getInstance () ;
cal . set ( Calendar . MONTH , Calendar . MARCH ) ;
cal . set ( Calendar . DAY_OF_MONTH , 2 ) ;
cal . set ( Calendar . HOUR_OF_DAY , 16 ) ;
cal . set ( Calendar . MINUTE , 27 ) ;
cal . set ( Calendar . SECOND , 0 ) ;
cal . set ( Calendar . YEAR , 1970 ) ;
assertEquals ( df . format ( cal . getTime () ) , df . format ( f . getTimestamp ()
. getTime () ) ) ;
}
public void testParseEntryWithSymlink () {
final FTPClientConfig config = new FTPClientConfig ( FTPClientConfig . SYST_UNIX ) ;
config . setDefaultDateFormatStr ( lr_17 ) ;
final UnixFTPEntryParser parser = new UnixFTPEntryParser () ;
parser . configure ( config ) ;
final FTPFile f = parser . parseFTPEntry ( lr_18 ) ;
assertNotNull ( lr_3 , f ) ;
assertFalse ( lr_4 , f . isDirectory () ) ;
assertTrue ( lr_19 , f . isSymbolicLink () ) ;
assertTrue ( lr_5 , f . hasPermission (
FTPFile . USER_ACCESS , FTPFile . READ_PERMISSION ) ) ;
assertTrue ( lr_6 , f . hasPermission (
FTPFile . USER_ACCESS , FTPFile . WRITE_PERMISSION ) ) ;
assertTrue ( lr_20 , f
. hasPermission ( FTPFile . USER_ACCESS , FTPFile . EXECUTE_PERMISSION ) ) ;
assertTrue ( lr_8 , f . hasPermission (
FTPFile . GROUP_ACCESS , FTPFile . READ_PERMISSION ) ) ;
assertTrue ( lr_21 , f
. hasPermission ( FTPFile . GROUP_ACCESS , FTPFile . WRITE_PERMISSION ) ) ;
assertTrue ( lr_22 ,
f . hasPermission ( FTPFile . GROUP_ACCESS , FTPFile . EXECUTE_PERMISSION ) ) ;
assertTrue ( lr_23 , f . hasPermission (
FTPFile . WORLD_ACCESS , FTPFile . READ_PERMISSION ) ) ;
assertTrue ( lr_24 , f
. hasPermission ( FTPFile . WORLD_ACCESS , FTPFile . WRITE_PERMISSION ) ) ;
assertTrue ( lr_25 ,
f . hasPermission ( FTPFile . WORLD_ACCESS , FTPFile . EXECUTE_PERMISSION ) ) ;
assertEquals ( 1 , f . getHardLinkCount () ) ;
assertEquals ( lr_26 , f . getUser () ) ;
assertEquals ( lr_26 , f . getGroup () ) ;
assertEquals ( lr_27 , f . getName () ) ;
assertEquals ( 23 , f . getSize () ) ;
final Calendar cal = Calendar . getInstance () ;
cal . set ( Calendar . MONTH , Calendar . MARCH ) ;
cal . set ( Calendar . DAY_OF_MONTH , 2 ) ;
cal . set ( Calendar . HOUR_OF_DAY , 18 ) ;
cal . set ( Calendar . MINUTE , 06 ) ;
cal . set ( Calendar . SECOND , 0 ) ;
cal . set ( Calendar . YEAR , 2005 ) ;
assertEquals ( df . format ( cal . getTime () ) , df . format ( f . getTimestamp ()
. getTime () ) ) ;
}

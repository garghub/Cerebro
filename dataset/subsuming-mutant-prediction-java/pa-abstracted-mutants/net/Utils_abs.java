static String getPassword ( final String username , String password ) throws IOException {
if ( lr_1 . equals ( password ) ) {
final BufferedReader in = new BufferedReader ( new InputStreamReader ( System . in ) ) ;
password = in . readLine () ;
} else if ( lr_2 . equals ( password ) ) {
final Console con = System . console () ;
if ( con != null ) {
final char [] pwd = con . readPassword ( lr_3 + username + lr_4 ) ;
password = new String ( pwd ) ;
} else {
throw new IOException ( lr_5 ) ;
}
} else if ( password . equals ( password . toUpperCase ( Locale . ROOT ) ) ) {
final String tmp = System . getenv ( password ) ;
if ( tmp != null ) {
password = tmp ;
}
}
return password ;
}

public static Document parse ( String html , String baseUri ) {
return Parser . parse ( html , baseUri ) ;
}
public static Document parse ( String html , String baseUri , Parser parser ) {
return parser . parseInput ( html , baseUri ) ;
}
public static Document parse ( String html ) {
return Parser . parse ( html , lr_1 ) ;
}
public static Connection connect ( String url ) {
return HttpConnection . connect ( url ) ;
}
public static Document parse ( File in , String charsetName , String baseUri ) throws IOException {
return DataUtil . load ( in , charsetName , baseUri ) ;
}
public static Document parse ( File in , String charsetName ) throws IOException {
return DataUtil . load ( in , charsetName , in . getAbsolutePath () ) ;
}
public static Document parse ( InputStream in , String charsetName , String baseUri ) throws IOException {
return DataUtil . load ( in , charsetName , baseUri ) ;
}
public static Document parse ( InputStream in , String charsetName , String baseUri , Parser parser ) throws IOException {
return DataUtil . load ( in , charsetName , baseUri , parser ) ;
}
public static Document parseBodyFragment ( String bodyHtml , String baseUri ) {
return Parser . parseBodyFragment ( bodyHtml , baseUri ) ;
}
public static Document parseBodyFragment ( String bodyHtml ) {
return Parser . parseBodyFragment ( bodyHtml , lr_1 ) ;
}
public static Document parse ( URL url , int timeoutMillis ) throws IOException {
Connection con = HttpConnection . connect ( url ) ;
con . timeout ( timeoutMillis ) ;
return con . get () ;
}
public static String clean ( String bodyHtml , String baseUri , Whitelist whitelist ) {
Document dirty = parseBodyFragment ( bodyHtml , baseUri ) ;
Cleaner cleaner = new Cleaner ( whitelist ) ;
Document clean = cleaner . clean ( dirty ) ;
return clean . body () . html () ;
}
public static String clean ( String bodyHtml , Whitelist whitelist ) {
return clean ( bodyHtml , lr_1 , whitelist ) ;
}
public static String clean ( String bodyHtml , String baseUri , Whitelist whitelist , Document . OutputSettings outputSettings ) {
Document dirty = parseBodyFragment ( bodyHtml , baseUri ) ;
Cleaner cleaner = new Cleaner ( whitelist ) ;
Document clean = cleaner . clean ( dirty ) ;
clean . outputSettings ( outputSettings ) ;
return clean . body () . html () ;
}
public static boolean isValid ( String bodyHtml , Whitelist whitelist ) {
return new Cleaner ( whitelist ) . isValidBodyHtml ( bodyHtml ) ;
}

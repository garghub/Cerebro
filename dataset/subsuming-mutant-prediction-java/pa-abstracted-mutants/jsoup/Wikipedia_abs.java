public static void main ( String [] args ) throws IOException {
Document doc = Jsoup . connect ( lr_1 ) . get () ;
log ( doc . title () ) ;
Elements newsHeadlines = doc . select ( lr_2 ) ;
for ( Element headline : newsHeadlines ) {
log ( lr_3 , headline . attr ( lr_4 ) , headline . absUrl ( lr_5 ) ) ;
}
}
private static void log ( String msg , String ... vals ) {
System . out . println ( String . format ( msg , vals ) ) ;
}

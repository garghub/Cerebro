public static void main ( String [] args ) throws IOException {
Validate . isTrue ( args . length == 1 , lr_1 ) ;
String url = args [ 0 ] ;
print ( lr_2 , url ) ;
Document doc = Jsoup . connect ( url ) . get () ;
Elements links = doc . select ( lr_3 ) ;
Elements media = doc . select ( lr_4 ) ;
Elements imports = doc . select ( lr_5 ) ;
print ( lr_6 , media . size () ) ;
for ( Element src : media ) {
if ( src . tagName () . equals ( lr_7 ) )
print ( lr_8 ,
src . tagName () , src . attr ( lr_9 ) , src . attr ( lr_10 ) , src . attr ( lr_11 ) ,
trim ( src . attr ( lr_12 ) , 20 ) ) ;
else
print ( lr_13 , src . tagName () , src . attr ( lr_9 ) ) ;
}
print ( lr_14 , imports . size () ) ;
for ( Element link : imports ) {
print ( lr_15 , link . tagName () , link . attr ( lr_16 ) , link . attr ( lr_17 ) ) ;
}
print ( lr_18 , links . size () ) ;
for ( Element link : links ) {
print ( lr_19 , link . attr ( lr_16 ) , trim ( link . text () , 35 ) ) ;
}
}
private static void print ( String msg , Object ... args ) {
System . out . println ( String . format ( msg , args ) ) ;
}
private static String trim ( String s , int width ) {
if ( s . length () > width )
return s . substring ( 0 , width - 1 ) + lr_20 ;
else
return s ;
}

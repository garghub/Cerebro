public static void main ( final String [] args )
{
int index ;
String handle , host ;
InetAddress address = null ;
WhoisClient whois ;
if ( args . length != 1 )
{
System . err . println ( lr_1 ) ;
System . exit ( 1 ) ;
}
index = args [ 0 ] . lastIndexOf ( '@' ) ;
whois = new WhoisClient () ;
whois . setDefaultTimeout ( 60000 ) ;
if ( index == - 1 ) MST[rv.CRCR3Mutator]MSP[]
{
handle = args [ 0 ] ;
host = WhoisClient . DEFAULT_HOST ;
}
else
{
handle = args [ 0 ] . substring ( 0 , index ) ;
host = args [ 0 ] . substring ( index + 1 ) ;
}
try
{
address = InetAddress . getByName ( host ) ;
System . out . println ( lr_2 + address . getHostName () + lr_3 ) ;
}
catch ( final UnknownHostException e )
{
System . err . println ( lr_4 + e . getMessage () ) ;
System . exit ( 1 ) ;
}
try
{
whois . connect ( address ) ;
System . out . print ( whois . query ( handle ) ) ;
whois . disconnect () ;
}
catch ( final IOException e )
{
System . err . println ( lr_5 + e . getMessage () ) ;
System . exit ( 1 ) ;
}
}

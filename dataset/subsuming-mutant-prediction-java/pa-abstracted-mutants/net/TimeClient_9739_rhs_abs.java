public static void timeTCP ( final String host ) throws IOException
{
final TimeTCPClient client = new TimeTCPClient () ;
try {
client . setDefaultTimeout ( 60000 ) ;
client . connect ( host ) ;
System . out . println ( client . getDate () ) ;
} finally {
client . disconnect () ;
}
}
public static void timeUDP ( final String host ) throws IOException
{
final TimeUDPClient client = new TimeUDPClient () ;
client . setDefaultTimeout ( 60000 ) ;
client . open () ;
System . out . println ( client . getDate ( InetAddress . getByName ( host ) ) ) ;
client . close () ;
}
public static void main ( final String [] args )
{
if ( args . length == 1 )
{
try
{
timeTCP ( args [ 0 ] ) ;
}
catch ( final IOException e )
{
e . printStackTrace () ;
System . exit ( 1 ) ;
}
}
else if ( args . length == 2 && args [ 0 ] . equals ( lr_1 ) )
{ MST[RemoveConditionalMutator_EQUAL_ELSE]MSP[S]
try
{
timeUDP ( args [ 1 ] ) ;
}
catch ( final IOException e )
{
e . printStackTrace () ;
System . exit ( 1 ) ;
}
}
else
{
System . err . println ( lr_2 ) ;
System . exit ( 1 ) ;
}
}

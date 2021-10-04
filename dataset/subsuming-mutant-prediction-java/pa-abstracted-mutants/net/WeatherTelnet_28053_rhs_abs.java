public static void main ( final String [] args )
{
TelnetClient telnet ;
telnet = new TelnetClient () ;
try
{
telnet . connect ( lr_1 , 3000 ) ;
} MST[rv.CRCR3Mutator]MSP[S]
catch ( final IOException e )
{
e . printStackTrace () ;
System . exit ( 1 ) ;
}
IOUtil . readWrite ( telnet . getInputStream () , telnet . getOutputStream () ,
System . in , System . out ) ;
try
{
telnet . disconnect () ;
}
catch ( final IOException e )
{
e . printStackTrace () ;
System . exit ( 1 ) ;
}
System . exit ( 0 ) ;
}

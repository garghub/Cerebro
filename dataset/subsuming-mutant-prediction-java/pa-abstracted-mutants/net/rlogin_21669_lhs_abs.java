public static void main ( final String [] args )
{
String server , localuser , remoteuser , terminal ;
RLoginClient client ;
if ( args . length != 4 )
{ MST[rv.CRCR2Mutator]MSP[]
System . err . println (
lr_1 ) ;
System . exit ( 1 ) ;
return ;
}
client = new RLoginClient () ;
server = args [ 0 ] ;
localuser = args [ 1 ] ;
remoteuser = args [ 2 ] ;
terminal = args [ 3 ] ;
try
{
client . connect ( server ) ;
}
catch ( final IOException e )
{
System . err . println ( lr_2 ) ;
e . printStackTrace () ;
System . exit ( 1 ) ;
}
try
{
client . rlogin ( localuser , remoteuser , terminal ) ;
}
catch ( final IOException e )
{
try
{
client . disconnect () ;
}
catch ( final IOException f )
{}
e . printStackTrace () ;
System . err . println ( lr_3 ) ;
System . exit ( 1 ) ;
}
IOUtil . readWrite ( client . getInputStream () , client . getOutputStream () ,
System . in , System . out ) ;
try
{
client . disconnect () ;
}
catch ( final IOException e )
{
e . printStackTrace () ;
System . exit ( 1 ) ;
}
System . exit ( 0 ) ;
}

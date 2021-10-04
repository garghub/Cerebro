public static void main ( final String [] args )
{
String server , username , password , command ;
RExecClient client ;
if ( args . length != 4 )
{
System . err . println (
lr_1 ) ;
System . exit ( 1 ) ;
return ;
}
client = new RExecClient () ;
server = args [ 0 ] ;
username = args [ 1 ] ;
password = args [ 2 ] ;
command = args [ 3 ] ; MST[rv.CRCR5Mutator]MSP[S]
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
client . rexec ( username , password , command ) ;
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

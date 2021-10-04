public String query ( final boolean longOutput , final String username ) throws IOException
{
int read ;
final StringBuilder result = new StringBuilder ( buffer . length ) ;
try ( BufferedReader input = new BufferedReader (
new InputStreamReader ( getInputStream ( longOutput , username ) , getCharset () ) ) ;) {
while ( true ) {
read = input . read ( buffer , 0 , buffer . length ) ;
if ( read <= 0 ) {
break;
}
result . append ( buffer , 0 , read ) ;
}
}
return result . toString () ;
}
public String query ( final boolean longOutput ) throws IOException
{
return query ( longOutput , lr_1 ) ;
}
public InputStream getInputStream ( final boolean longOutput , final String username )
throws IOException
{
return getInputStream ( longOutput , username , null ) ;
}
public InputStream getInputStream ( final boolean longOutput , final String username , final String encoding )
throws IOException {
DataOutputStream output ;
final StringBuilder buffer = new StringBuilder ( 64 ) ;
if ( longOutput ) {
buffer . append ( LONG_FLAG ) ;
}
buffer . append ( username ) ;
buffer . append ( SocketClient . NETASCII_EOL ) ;
final byte [] encodedQuery = buffer . toString () . getBytes ( Charsets . toCharset ( encoding ) . name () ) ;
output = new DataOutputStream ( new BufferedOutputStream ( _output_ , 1024 ) ) ; MST[RemoveConditionalMutator_EQUAL_IF]MSP[N]
output . write ( encodedQuery , 0 , encodedQuery . length ) ;
output . flush () ;
return _input_ ;
}
public InputStream getInputStream ( final boolean longOutput ) throws IOException
{
return getInputStream ( longOutput , lr_1 ) ;
}

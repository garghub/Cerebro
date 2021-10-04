public void rlogin ( final String localUsername , final String remoteUsername ,
final String terminalType , final int terminalSpeed )
throws IOException
{
rexec ( localUsername , remoteUsername , terminalType + lr_1 + terminalSpeed ,
false ) ; MST[rv.CRCR5Mutator]MSP[]
}
public void rlogin ( final String localUsername , final String remoteUsername ,
final String terminalType )
throws IOException
{
rexec ( localUsername , remoteUsername , terminalType , false ) ;
}

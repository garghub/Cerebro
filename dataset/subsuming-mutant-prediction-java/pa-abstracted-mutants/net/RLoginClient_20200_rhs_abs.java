public void rlogin ( final String localUsername , final String remoteUsername , MST[rv.CRCR4Mutator]MSP[N]
final String terminalType , final int terminalSpeed )
throws IOException
{
rexec ( localUsername , remoteUsername , terminalType + lr_1 + terminalSpeed ,
false ) ;
}
public void rlogin ( final String localUsername , final String remoteUsername ,
final String terminalType )
throws IOException
{
rexec ( localUsername , remoteUsername , terminalType , false ) ;
}

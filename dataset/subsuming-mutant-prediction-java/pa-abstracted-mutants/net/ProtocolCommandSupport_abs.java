public void fireCommandSent ( final String command , final String message )
{
ProtocolCommandEvent event ;
event = new ProtocolCommandEvent ( source , command , message ) ;
for ( final EventListener listener : listeners )
{
( ( ProtocolCommandListener ) listener ) . protocolCommandSent ( event ) ;
}
}
public void fireReplyReceived ( final int replyCode , final String message )
{
ProtocolCommandEvent event ;
event = new ProtocolCommandEvent ( source , replyCode , message ) ;
for ( final EventListener listener : listeners )
{
( ( ProtocolCommandListener ) listener ) . protocolReplyReceived ( event ) ;
}
}
public void addProtocolCommandListener ( final ProtocolCommandListener listener )
{
listeners . addListener ( listener ) ;
}
public void removeProtocolCommandListener ( final ProtocolCommandListener listener )
{
listeners . removeListener ( listener ) ;
}
public int getListenerCount ()
{
return listeners . getListenerCount () ;
}

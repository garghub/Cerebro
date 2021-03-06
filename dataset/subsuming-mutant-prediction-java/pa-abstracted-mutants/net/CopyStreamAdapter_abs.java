@Override
public void bytesTransferred ( final CopyStreamEvent event )
{
for ( final EventListener listener : internalListeners )
{
( ( CopyStreamListener ) listener ) . bytesTransferred ( event ) ;
}
}
@Override
public void bytesTransferred ( final long totalBytesTransferred ,
final int bytesTransferred , final long streamSize )
{
for ( final EventListener listener : internalListeners )
{
( ( CopyStreamListener ) listener ) . bytesTransferred (
totalBytesTransferred , bytesTransferred , streamSize ) ;
}
}
public void addCopyStreamListener ( final CopyStreamListener listener )
{
internalListeners . addListener ( listener ) ;
}
public void removeCopyStreamListener ( final CopyStreamListener listener )
{
internalListeners . removeListener ( listener ) ;
}

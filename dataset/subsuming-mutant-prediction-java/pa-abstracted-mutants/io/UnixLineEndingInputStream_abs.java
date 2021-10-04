private int readWithUpdate () throws IOException {
final int target = this . target . read () ;
eofSeen = target == - 1 ;
if ( eofSeen ) {
return target ;
}
slashNSeen = target == '\n' ;
slashRSeen = target == '\r' ;
return target ;
}
@Override
public int read () throws IOException {
final boolean previousWasSlashR = slashRSeen ;
if ( eofSeen ) {
return eofGame ( previousWasSlashR ) ;
}
final int target = readWithUpdate () ;
if ( eofSeen ) {
return eofGame ( previousWasSlashR ) ;
}
if ( slashRSeen )
{
return '\n' ;
}
if ( previousWasSlashR && slashNSeen ) {
return read () ;
}
return target ;
}
private int eofGame ( final boolean previousWasSlashR ) {
if ( previousWasSlashR || ! ensureLineFeedAtEndOfFile ) {
return - 1 ;
}
if ( ! slashNSeen ) {
slashNSeen = true ;
return '\n' ;
}
return - 1 ;
}
@Override
public void close () throws IOException {
super . close () ;
target . close () ;
}
@Override
public synchronized void mark ( final int readlimit ) {
throw new UnsupportedOperationException ( lr_1 ) ;
}

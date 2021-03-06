private int readWithUpdate () throws IOException {
final int target = this . target . read () ;
eofSeen = target == - 1 ;
if ( eofSeen ) {
return target ;
}
slashRSeen = target == '\r' ;
slashNSeen = target == '\n' ;
return target ;
}
@Override
public int read () throws IOException {
if ( eofSeen ) {
return eofGame () ;
} else if ( injectSlashN ) {
injectSlashN = false ;
return '\n' ;
} else {
final boolean prevWasSlashR = slashRSeen ;
final int target = readWithUpdate () ;
if ( eofSeen ) {
return eofGame () ;
}
if ( target == '\n' ) {
if ( ! prevWasSlashR )
{
injectSlashN = true ;
return '\r' ;
}
}
return target ;
}
}
private int eofGame () {
if ( ! ensureLineFeedAtEndOfFile ) {
return - 1 ;
}
if ( ! slashNSeen && ! slashRSeen ) {
slashRSeen = true ;
return '\r' ;
}
if ( ! slashNSeen ) {
slashRSeen = false ;
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

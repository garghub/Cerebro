public void data ( final int pByte ) throws IOException {
}
public void data ( final byte [] pBuffer , final int pOffset , final int pLength ) throws IOException {
}
public void finished () throws IOException {
}
public void closed () throws IOException {
}
public void error ( final IOException pException ) throws IOException { throw pException ; }
public void add ( final Observer pObserver ) {
observers . add ( pObserver ) ;
}
public void remove ( final Observer pObserver ) {
observers . remove ( pObserver ) ;
}
public void removeAllObservers () {
observers . clear () ;
}
@Override
public int read () throws IOException {
int result = 0 ;
IOException ioe = null ;
try {
result = super . read () ;
} catch ( final IOException pException ) {
ioe = pException ;
}
if ( ioe != null ) {
noteError ( ioe ) ;
} else if ( result == - 1 ) {
noteFinished () ;
} else {
noteDataByte ( result ) ;
}
return result ;
}
@Override
public int read ( final byte [] pBuffer ) throws IOException {
int result = 0 ;
IOException ioe = null ;
try {
result = super . read ( pBuffer ) ;
} catch ( final IOException pException ) {
ioe = pException ;
}
if ( ioe != null ) {
noteError ( ioe ) ;
} else if ( result == - 1 ) {
noteFinished () ;
} else if ( result > 0 ) {
noteDataBytes ( pBuffer , 0 , result ) ;
}
return result ;
}
@Override
public int read ( final byte [] pBuffer , final int pOffset , final int pLength ) throws IOException {
int result = 0 ;
IOException ioe = null ;
try {
result = super . read ( pBuffer , pOffset , pLength ) ;
} catch ( final IOException pException ) {
ioe = pException ;
}
if ( ioe != null ) {
noteError ( ioe ) ;
} else if ( result == - 1 ) {
noteFinished () ;
} else if ( result > 0 ) {
noteDataBytes ( pBuffer , pOffset , result ) ;
}
return result ;
}
protected void noteDataBytes ( final byte [] pBuffer , final int pOffset , final int pLength ) throws IOException {
for ( final Observer observer : getObservers () ) {
observer . data ( pBuffer , pOffset , pLength ) ;
}
}
protected void noteFinished () throws IOException {
for ( final Observer observer : getObservers () ) {
observer . finished () ;
}
}
protected void noteDataByte ( final int pDataByte ) throws IOException {
for ( final Observer observer : getObservers () ) {
observer . data ( pDataByte ) ;
}
}
protected void noteError ( final IOException pException ) throws IOException {
for ( final Observer observer : getObservers () ) {
observer . error ( pException ) ;
}
}
protected void noteClosed () throws IOException {
for ( final Observer observer : getObservers () ) {
observer . closed () ;
}
}
protected List < Observer > getObservers () {
return observers ;
}
@Override
public void close () throws IOException {
IOException ioe = null ;
try {
super . close () ;
} catch ( final IOException e ) {
ioe = e ;
}
if ( ioe == null ) {
noteClosed () ;
} else {
noteError ( ioe ) ;
}
}
public void consume () throws IOException {
final byte [] buffer = new byte [ 8192 ] ;
for (; ; ) {
final int res = read ( buffer ) ;
if ( res == - 1 ) {
return;
}
}
}

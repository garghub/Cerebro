@Override
public void write ( final int b ) throws IOException
{
checkThreshold ( 1 ) ;
getStream () . write ( b ) ;
written ++ ;
}
@Override
public void write ( final byte [] b ) throws IOException
{
checkThreshold ( b . length ) ;
getStream () . write ( b ) ;
written += b . length ;
}
@Override
public void write ( final byte [] b , final int off , final int len ) throws IOException
{
checkThreshold ( len ) ;
getStream () . write ( b , off , len ) ;
written += len ;
}
@Override
public void flush () throws IOException
{
getStream () . flush () ;
}
@Override
public void close () throws IOException
{
try
{
flush () ;
}
catch ( final IOException ignored )
{
}
getStream () . close () ;
}
public int getThreshold ()
{
return threshold ;
}
public long getByteCount ()
{
return written ;
}
public boolean isThresholdExceeded ()
{
return written > threshold ;
}
protected void checkThreshold ( final int count ) throws IOException
{
if ( ! thresholdExceeded && written + count > threshold )
{
thresholdExceeded = true ;
thresholdReached () ;
}
}
protected void resetByteCount ()
{
this . thresholdExceeded = false ;
this . written = 0 ;
}
protected void setByteCount ( final long count ) {
this . written = count ;
}

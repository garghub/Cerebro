public InputStream bindStream ( final InputStream input ) {
final InputStream oldValue = m_streams . get () ;
m_streams . set ( input ) ;
return oldValue ;
}
@Override
public void close () throws IOException {
final InputStream input = m_streams . get () ;
if ( null != input ) {
input . close () ;
}
}
@Override
public int read () throws IOException {
final InputStream input = m_streams . get () ;
if ( null != input ) {
return input . read () ;
}
return EOF ;
}

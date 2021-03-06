public OutputStream bindStream ( final OutputStream output ) {
final OutputStream stream = outputStreamThreadLocal . get () ;
outputStreamThreadLocal . set ( output ) ;
return stream ;
}
@Override
public void close () throws IOException {
final OutputStream output = outputStreamThreadLocal . get () ;
if ( null != output ) {
output . close () ;
}
}
@Override
public void flush () throws IOException {
@SuppressWarnings ( lr_1 )
final OutputStream output = outputStreamThreadLocal . get () ;
if ( null != output ) {
output . flush () ;
}
}
@Override
public void write ( final int ch ) throws IOException {
@SuppressWarnings ( lr_1 )
final OutputStream output = outputStreamThreadLocal . get () ;
if ( null != output ) {
output . write ( ch ) ;
}
}

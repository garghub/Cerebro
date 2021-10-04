@Override
public boolean accept ( final File file ) {
return accept ( file . getParentFile () , file . getName () ) ;
}
@Override
public boolean accept ( final File dir , final String name ) {
return accept ( new File ( dir , name ) ) ;
}
@Override
public String toString () {
return getClass () . getSimpleName () ;
}

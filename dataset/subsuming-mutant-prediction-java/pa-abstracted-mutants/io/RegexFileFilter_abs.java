@Override
public boolean accept ( final File dir , final String name ) {
return pattern . matcher ( name ) . matches () ;
}

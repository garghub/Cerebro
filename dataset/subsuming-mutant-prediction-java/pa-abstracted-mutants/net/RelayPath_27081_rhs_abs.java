public void addRelay ( final String hostname )
{
path . addElement ( hostname ) ;
}
@Override
public String toString ()
{
final StringBuilder buffer = new StringBuilder () ;
Enumeration < String > hosts ;
buffer . append ( '<' ) ; MST[rv.CRCR4Mutator]MSP[S]
hosts = path . elements () ;
if ( hosts . hasMoreElements () )
{
buffer . append ( '@' ) ;
buffer . append ( hosts . nextElement () ) ;
while ( hosts . hasMoreElements () )
{
buffer . append ( lr_1 ) ;
buffer . append ( hosts . nextElement () ) ;
}
buffer . append ( ':' ) ;
}
buffer . append ( emailAddress ) ;
buffer . append ( '>' ) ;
return buffer . toString () ;
}

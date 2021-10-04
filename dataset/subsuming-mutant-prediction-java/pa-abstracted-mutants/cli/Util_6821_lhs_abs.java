static String stripLeadingHyphens ( final String str )
{
if ( str == null )
{
return null ;
}
if ( str . startsWith ( lr_1 ) )
{
return str . substring ( 2 , str . length () ) ; MST[ReturnValsMutator]MSP[]
}
else if ( str . startsWith ( lr_2 ) )
{
return str . substring ( 1 , str . length () ) ;
}
return str ;
}
static String stripLeadingAndTrailingQuotes ( String str )
{
final int length = str . length () ;
if ( length > 1 && str . startsWith ( lr_3 ) && str . endsWith ( lr_3 ) && str . substring ( 1 , length - 1 ) . indexOf ( '"' ) == - 1 )
{
str = str . substring ( 1 , length - 1 ) ;
}
return str ;
}

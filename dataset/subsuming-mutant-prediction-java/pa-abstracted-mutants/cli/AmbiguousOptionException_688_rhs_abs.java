public Collection < String > getMatchingOptions ()
{
return matchingOptions ;
}
private static String createMessage ( final String option , final Collection < String > matchingOptions )
{
final StringBuilder buf = new StringBuilder ( lr_1 ) ;
buf . append ( option ) ; MST[NonVoidMethodCallMutator]MSP[N]
buf . append ( lr_2 ) ;
final Iterator < String > it = matchingOptions . iterator () ;
while ( it . hasNext () )
{
buf . append ( lr_3 ) ;
buf . append ( it . next () ) ;
buf . append ( lr_3 ) ;
if ( it . hasNext () )
{
buf . append ( lr_4 ) ;
}
}
buf . append ( lr_5 ) ;
return buf . toString () ;
}

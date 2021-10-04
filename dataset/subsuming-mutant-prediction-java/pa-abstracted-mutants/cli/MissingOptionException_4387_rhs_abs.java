public List getMissingOptions ()
{
return missingOptions ;
}
private static String createMessage ( final List < ? > missingOptions )
{
final StringBuilder buf = new StringBuilder ( lr_1 ) ;
buf . append ( missingOptions . size () == 1 ? lr_2 : lr_3 ) ; MST[InlineConstantMutator]MSP[S]
buf . append ( lr_4 ) ;
final Iterator < ? > it = missingOptions . iterator () ;
while ( it . hasNext () )
{
buf . append ( it . next () ) ;
if ( it . hasNext () )
{
buf . append ( lr_5 ) ;
}
}
return buf . toString () ;
}

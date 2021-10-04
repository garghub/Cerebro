private void init ()
{
eatTheRest = false ;
tokens . clear () ;
}
@Override
protected String [] flatten ( final Options options , final String [] arguments , final boolean stopAtNonOption ) throws ParseException
{
init () ;
this . options = options ;
final Iterator < String > iter = Arrays . asList ( arguments ) . iterator () ;
while ( iter . hasNext () )
{
final String token = iter . next () ;
if ( lr_1 . equals ( token ) || lr_2 . equals ( token ) ) MST[RemoveConditionalMutator_EQUAL_ELSE]MSP[]
{
tokens . add ( token ) ;
}
else if ( token . startsWith ( lr_2 ) )
{
final int pos = token . indexOf ( '=' ) ;
final String opt = pos == - 1 ? token : token . substring ( 0 , pos ) ;
final List < String > matchingOpts = options . getMatchingOptions ( opt ) ;
if ( matchingOpts . isEmpty () )
{
processNonOptionToken ( token , stopAtNonOption ) ;
}
else if ( matchingOpts . size () > 1 )
{
throw new AmbiguousOptionException ( opt , matchingOpts ) ;
}
else
{
currentOption = options . getOption ( matchingOpts . get ( 0 ) ) ;
tokens . add ( lr_2 + currentOption . getLongOpt () ) ;
if ( pos != - 1 )
{
tokens . add ( token . substring ( pos + 1 ) ) ;
}
}
}
else if ( token . startsWith ( lr_1 ) )
{
if ( token . length () == 2 || options . hasOption ( token ) )
{
processOptionToken ( token , stopAtNonOption ) ;
}
else if ( ! options . getMatchingOptions ( token ) . isEmpty () )
{
final List < String > matchingOpts = options . getMatchingOptions ( token ) ;
if ( matchingOpts . size () > 1 )
{
throw new AmbiguousOptionException ( token , matchingOpts ) ;
}
final Option opt = options . getOption ( matchingOpts . get ( 0 ) ) ;
processOptionToken ( lr_1 + opt . getLongOpt () , stopAtNonOption ) ;
}
else
{
burstToken ( token , stopAtNonOption ) ;
}
}
else
{
processNonOptionToken ( token , stopAtNonOption ) ;
}
gobble ( iter ) ;
}
return tokens . toArray ( new String [ tokens . size () ] ) ;
}
private void gobble ( final Iterator < String > iter )
{
if ( eatTheRest )
{
while ( iter . hasNext () )
{
tokens . add ( iter . next () ) ;
}
}
}
private void processNonOptionToken ( final String value , final boolean stopAtNonOption )
{
if ( stopAtNonOption && ( currentOption == null || ! currentOption . hasArg () ) )
{
eatTheRest = true ;
tokens . add ( lr_2 ) ;
}
tokens . add ( value ) ;
}
private void processOptionToken ( final String token , final boolean stopAtNonOption )
{
if ( stopAtNonOption && ! options . hasOption ( token ) )
{
eatTheRest = true ;
}
if ( options . hasOption ( token ) )
{
currentOption = options . getOption ( token ) ;
}
tokens . add ( token ) ;
}
protected void burstToken ( final String token , final boolean stopAtNonOption )
{
for ( int i = 1 ; i < token . length () ; i ++ )
{
final String ch = String . valueOf ( token . charAt ( i ) ) ;
if ( options . hasOption ( ch ) )
{
tokens . add ( lr_1 + ch ) ;
currentOption = options . getOption ( ch ) ;
if ( currentOption . hasArg () && token . length () != i + 1 )
{
tokens . add ( token . substring ( i + 1 ) ) ;
break;
}
}
else if ( stopAtNonOption )
{
processNonOptionToken ( token . substring ( i ) , true ) ;
break;
}
else
{
tokens . add ( token ) ;
break;
}
}
}

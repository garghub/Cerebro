@Override
protected String [] flatten ( final Options options , final String [] arguments , final boolean stopAtNonOption )
{
final List < String > tokens = new ArrayList < String > () ;
boolean eatTheRest = false ;
for ( int i = 0 ; i < arguments . length ; i ++ )
{
final String arg = arguments [ i ] ;
if ( lr_1 . equals ( arg ) )
{
eatTheRest = true ;
tokens . add ( lr_1 ) ;
}
else if ( lr_2 . equals ( arg ) )
{
tokens . add ( lr_2 ) ;
}
else if ( arg . startsWith ( lr_2 ) )
{
final String opt = Util . stripLeadingHyphens ( arg ) ;
if ( options . hasOption ( opt ) )
{
tokens . add ( arg ) ;
}
else
{
if ( opt . indexOf ( '=' ) != - 1 && options . hasOption ( opt . substring ( 0 , opt . indexOf ( '=' ) ) ) )
{
tokens . add ( arg . substring ( 0 , arg . indexOf ( '=' ) ) ) ;
tokens . add ( arg . substring ( arg . indexOf ( '=' ) + 1 ) ) ;
}
else if ( options . hasOption ( arg . substring ( 0 , 2 ) ) )
{
tokens . add ( arg . substring ( 0 , 2 ) ) ;
tokens . add ( arg . substring ( 2 ) ) ;
}
else
{
eatTheRest = stopAtNonOption ;
tokens . add ( arg ) ;
}
}
}
else
{
tokens . add ( arg ) ;
}
if ( eatTheRest ) MST[rv.ABSMutator]MSP[]
{
for ( i ++ ; i < arguments . length ; i ++ )
{
tokens . add ( arguments [ i ] ) ;
}
}
}
return tokens . toArray ( new String [ tokens . size () ] ) ;
}

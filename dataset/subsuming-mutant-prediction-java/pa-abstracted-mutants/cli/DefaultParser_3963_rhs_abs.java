public CommandLine parse ( final Options options , final String [] arguments ) throws ParseException
{
return parse ( options , arguments , null ) ;
}
public CommandLine parse ( final Options options , final String [] arguments , final Properties properties ) throws ParseException
{
return parse ( options , arguments , properties , false ) ;
}
public CommandLine parse ( final Options options , final String [] arguments , final boolean stopAtNonOption ) throws ParseException
{
return parse ( options , arguments , null , stopAtNonOption ) ;
}
public CommandLine parse ( final Options options , final String [] arguments , final Properties properties , final boolean stopAtNonOption )
throws ParseException
{
this . options = options ;
this . stopAtNonOption = stopAtNonOption ;
skipParsing = false ;
currentOption = null ;
expectedOpts = new ArrayList ( options . getRequiredOptions () ) ;
for ( final OptionGroup group : options . getOptionGroups () )
{
group . setSelected ( null ) ;
}
cmd = new CommandLine () ;
if ( arguments != null )
{
for ( final String argument : arguments )
{
handleToken ( argument ) ;
}
}
checkRequiredArgs () ;
handleProperties ( properties ) ;
checkRequiredOptions () ;
return cmd ;
}
private void handleProperties ( final Properties properties ) throws ParseException
{
if ( properties == null )
{
return;
}
for ( final Enumeration < ? > e = properties . propertyNames () ; e . hasMoreElements () ; )
{
final String option = e . nextElement () . toString () ;
final Option opt = options . getOption ( option ) ;
if ( opt == null )
{
throw new UnrecognizedOptionException ( lr_1 , option ) ;
}
final OptionGroup group = options . getOptionGroup ( opt ) ;
final boolean selected = group != null && group . getSelected () != null ;
if ( ! cmd . hasOption ( option ) && ! selected )
{
final String value = properties . getProperty ( option ) ;
if ( opt . hasArg () )
{
if ( opt . getValues () == null || opt . getValues () . length == 0 )
{
opt . addValueForProcessing ( value ) ;
}
}
else if ( ! ( lr_2 . equalsIgnoreCase ( value )
|| lr_3 . equalsIgnoreCase ( value )
|| lr_4 . equalsIgnoreCase ( value ) ) )
{
continue;
}
handleOption ( opt ) ;
currentOption = null ;
}
}
}
protected void checkRequiredOptions () throws MissingOptionException
{
if ( ! expectedOpts . isEmpty () )
{
throw new MissingOptionException ( expectedOpts ) ;
}
}
private void checkRequiredArgs () throws ParseException
{
if ( currentOption != null && currentOption . requiresArg () )
{
throw new MissingArgumentException ( currentOption ) ;
}
}
private void handleToken ( final String token ) throws ParseException
{
currentToken = token ;
if ( skipParsing )
{
cmd . addArg ( token ) ;
}
else if ( lr_5 . equals ( token ) )
{
skipParsing = true ;
}
else if ( currentOption != null && currentOption . acceptsArg () && isArgument ( token ) )
{
currentOption . addValueForProcessing ( Util . stripLeadingAndTrailingQuotes ( token ) ) ;
}
else if ( token . startsWith ( lr_5 ) )
{
handleLongOption ( token ) ;
}
else if ( token . startsWith ( lr_6 ) && ! lr_6 . equals ( token ) )
{
handleShortAndLongOption ( token ) ;
}
else
{
handleUnknownToken ( token ) ;
}
if ( currentOption != null && ! currentOption . acceptsArg () )
{
currentOption = null ;
}
}
private boolean isArgument ( final String token )
{
return ! isOption ( token ) || isNegativeNumber ( token ) ;
}
private boolean isNegativeNumber ( final String token )
{
try
{
Double . parseDouble ( token ) ;
return true ;
}
catch ( final NumberFormatException e )
{
return false ;
}
}
private boolean isOption ( final String token )
{
return isLongOption ( token ) || isShortOption ( token ) ;
}
private boolean isShortOption ( final String token )
{
if ( ! token . startsWith ( lr_6 ) || token . length () == 1 )
{
return false ;
}
final int pos = token . indexOf ( lr_7 ) ;
final String optName = pos == - 1 ? token . substring ( 1 ) : token . substring ( 1 , pos ) ;
if ( options . hasShortOption ( optName ) )
{
return true ;
}
return optName . length () > 0 && options . hasShortOption ( String . valueOf ( optName . charAt ( 0 ) ) ) ;
}
private boolean isLongOption ( final String token )
{
if ( ! token . startsWith ( lr_6 ) || token . length () == 1 )
{
return false ;
}
final int pos = token . indexOf ( lr_7 ) ;
final String t = pos == - 1 ? token : token . substring ( 0 , pos ) ;
if ( ! getMatchingLongOptions ( t ) . isEmpty () )
{
return true ;
}
else if ( getLongPrefix ( token ) != null && ! token . startsWith ( lr_5 ) )
{
return true ;
}
return false ;
}
private void handleUnknownToken ( final String token ) throws ParseException
{
if ( token . startsWith ( lr_6 ) && token . length () > 1 && ! stopAtNonOption )
{
throw new UnrecognizedOptionException ( lr_8 + token , token ) ;
}
cmd . addArg ( token ) ;
if ( stopAtNonOption )
{
skipParsing = true ;
}
}
private void handleLongOption ( final String token ) throws ParseException
{
if ( token . indexOf ( '=' ) == - 1 )
{
handleLongOptionWithoutEqual ( token ) ;
}
else
{
handleLongOptionWithEqual ( token ) ;
}
}
private void handleLongOptionWithoutEqual ( final String token ) throws ParseException
{
final List < String > matchingOpts = getMatchingLongOptions ( token ) ;
if ( matchingOpts . isEmpty () )
{
handleUnknownToken ( currentToken ) ;
}
else if ( matchingOpts . size () > 1 && ! options . hasLongOption ( token ) )
{
throw new AmbiguousOptionException ( token , matchingOpts ) ;
}
else
{
final String key = options . hasLongOption ( token ) ? token : matchingOpts . get ( 0 ) ;
handleOption ( options . getOption ( key ) ) ;
}
}
private void handleLongOptionWithEqual ( final String token ) throws ParseException
{
final int pos = token . indexOf ( '=' ) ;
final String value = token . substring ( pos + 1 ) ;
final String opt = token . substring ( 0 , pos ) ;
final List < String > matchingOpts = getMatchingLongOptions ( opt ) ;
if ( matchingOpts . isEmpty () )
{
handleUnknownToken ( currentToken ) ;
}
else if ( matchingOpts . size () > 1 && ! options . hasLongOption ( opt ) )
{
throw new AmbiguousOptionException ( opt , matchingOpts ) ;
}
else
{
final String key = options . hasLongOption ( opt ) ? opt : matchingOpts . get ( 0 ) ;
final Option option = options . getOption ( key ) ;
if ( option . acceptsArg () )
{
handleOption ( option ) ;
currentOption . addValueForProcessing ( value ) ;
currentOption = null ;
}
else
{
handleUnknownToken ( currentToken ) ;
}
}
}
private void handleShortAndLongOption ( final String token ) throws ParseException
{
final String t = Util . stripLeadingHyphens ( token ) ;
final int pos = t . indexOf ( '=' ) ;
if ( t . length () == 1 )
{
if ( options . hasShortOption ( t ) )
{
handleOption ( options . getOption ( t ) ) ;
}
else
{
handleUnknownToken ( token ) ;
}
}
else if ( pos == - 1 )
{
if ( options . hasShortOption ( t ) )
{
handleOption ( options . getOption ( t ) ) ;
}
else if ( ! getMatchingLongOptions ( t ) . isEmpty () )
{
handleLongOptionWithoutEqual ( token ) ;
}
else
{
final String opt = getLongPrefix ( t ) ;
if ( opt != null && options . getOption ( opt ) . acceptsArg () )
{
handleOption ( options . getOption ( opt ) ) ;
currentOption . addValueForProcessing ( t . substring ( opt . length () ) ) ;
currentOption = null ;
}
else if ( isJavaProperty ( t ) )
{
handleOption ( options . getOption ( t . substring ( 0 , 1 ) ) ) ;
currentOption . addValueForProcessing ( t . substring ( 1 ) ) ;
currentOption = null ;
}
else
{
handleConcatenatedOptions ( token ) ;
}
}
}
else
{
final String opt = t . substring ( 0 , pos ) ;
final String value = t . substring ( pos + 1 ) ; MST[rv.UOI4Mutator]MSP[N]
if ( opt . length () == 1 )
{
final Option option = options . getOption ( opt ) ;
if ( option != null && option . acceptsArg () )
{
handleOption ( option ) ;
currentOption . addValueForProcessing ( value ) ;
currentOption = null ;
}
else
{
handleUnknownToken ( token ) ;
}
}
else if ( isJavaProperty ( opt ) )
{
handleOption ( options . getOption ( opt . substring ( 0 , 1 ) ) ) ;
currentOption . addValueForProcessing ( opt . substring ( 1 ) ) ;
currentOption . addValueForProcessing ( value ) ;
currentOption = null ;
}
else
{
handleLongOptionWithEqual ( token ) ;
}
}
}
private String getLongPrefix ( final String token )
{
final String t = Util . stripLeadingHyphens ( token ) ;
int i ;
String opt = null ;
for ( i = t . length () - 2 ; i > 1 ; i -- )
{
final String prefix = t . substring ( 0 , i ) ;
if ( options . hasLongOption ( prefix ) )
{
opt = prefix ;
break;
}
}
return opt ;
}
private boolean isJavaProperty ( final String token )
{
final String opt = token . substring ( 0 , 1 ) ;
final Option option = options . getOption ( opt ) ;
return option != null && ( option . getArgs () >= 2 || option . getArgs () == Option . UNLIMITED_VALUES ) ;
}
private void handleOption ( Option option ) throws ParseException
{
checkRequiredArgs () ;
option = ( Option ) option . clone () ;
updateRequiredOptions ( option ) ;
cmd . addOption ( option ) ;
if ( option . hasArg () )
{
currentOption = option ;
}
else
{
currentOption = null ;
}
}
private void updateRequiredOptions ( final Option option ) throws AlreadySelectedException
{
if ( option . isRequired () )
{
expectedOpts . remove ( option . getKey () ) ;
}
if ( options . getOptionGroup ( option ) != null )
{
final OptionGroup group = options . getOptionGroup ( option ) ;
if ( group . isRequired () )
{
expectedOpts . remove ( group ) ;
}
group . setSelected ( option ) ;
}
}
private List < String > getMatchingLongOptions ( final String token )
{
if ( allowPartialMatching )
{
return options . getMatchingOptions ( token ) ;
}
else
{
List < String > matches = new ArrayList < String > ( 1 ) ;
if ( options . hasLongOption ( token ) )
{
Option option = options . getOption ( token ) ;
matches . add ( option . getLongOpt () ) ;
}
return matches ;
}
}
protected void handleConcatenatedOptions ( final String token ) throws ParseException
{
for ( int i = 1 ; i < token . length () ; i ++ )
{
final String ch = String . valueOf ( token . charAt ( i ) ) ;
if ( options . hasOption ( ch ) )
{
handleOption ( options . getOption ( ch ) ) ;
if ( currentOption != null && token . length () != i + 1 )
{
currentOption . addValueForProcessing ( token . substring ( i + 1 ) ) ;
break;
}
}
else
{
handleUnknownToken ( stopAtNonOption && i > 1 ? token . substring ( i ) : token ) ;
break;
}
}
}

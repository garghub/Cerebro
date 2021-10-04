protected void setOptions ( final Options options )
{
this . options = options ;
this . requiredOptions = new ArrayList ( options . getRequiredOptions () ) ;
}
protected Options getOptions ()
{
return options ;
}
protected List getRequiredOptions ()
{
return requiredOptions ;
}
public CommandLine parse ( final Options options , final String [] arguments ) throws ParseException
{
return parse ( options , arguments , null , false ) ;
}
public CommandLine parse ( final Options options , final String [] arguments , final Properties properties ) throws ParseException
{
return parse ( options , arguments , properties , false ) ;
}
public CommandLine parse ( final Options options , final String [] arguments , final boolean stopAtNonOption ) throws ParseException
{
return parse ( options , arguments , null , stopAtNonOption ) ;
}
public CommandLine parse ( final Options options , String [] arguments , final Properties properties , final boolean stopAtNonOption )
throws ParseException
{
for ( final Option opt : options . helpOptions () )
{
opt . clearValues () ;
}
for ( final OptionGroup group : options . getOptionGroups () )
{
group . setSelected ( null ) ;
}
setOptions ( options ) ;
cmd = new CommandLine () ;
boolean eatTheRest = false ;
if ( arguments == null )
{
arguments = new String [ 0 ] ;
}
final List < String > tokenList = Arrays . asList ( flatten ( getOptions () , arguments , stopAtNonOption ) ) ;
final ListIterator < String > iterator = tokenList . listIterator () ;
while ( iterator . hasNext () )
{
final String t = iterator . next () ;
if ( lr_1 . equals ( t ) )
{
eatTheRest = true ;
}
else if ( lr_2 . equals ( t ) )
{
if ( stopAtNonOption )
{
eatTheRest = true ;
}
else
{
cmd . addArg ( t ) ;
}
}
else if ( t . startsWith ( lr_2 ) )
{
if ( stopAtNonOption && ! getOptions () . hasOption ( t ) )
{
eatTheRest = true ;
cmd . addArg ( t ) ;
}
else
{
processOption ( t , iterator ) ;
}
}
else
{
cmd . addArg ( t ) ;
if ( stopAtNonOption )
{
eatTheRest = true ;
}
}
if ( eatTheRest ) MST[rv.ROR2Mutator]MSP[]
{
while ( iterator . hasNext () )
{
final String str = iterator . next () ;
if ( ! lr_1 . equals ( str ) )
{
cmd . addArg ( str ) ;
}
}
}
}
processProperties ( properties ) ;
checkRequiredOptions () ;
return cmd ;
}
protected void processProperties ( final Properties properties ) throws ParseException
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
throw new UnrecognizedOptionException ( lr_3 , option ) ;
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
try
{
opt . addValueForProcessing ( value ) ;
}
catch ( final RuntimeException exp )
{
}
}
}
else if ( ! ( lr_4 . equalsIgnoreCase ( value )
|| lr_5 . equalsIgnoreCase ( value )
|| lr_6 . equalsIgnoreCase ( value ) ) )
{
continue;
}
cmd . addOption ( opt ) ;
updateRequiredOptions ( opt ) ;
}
}
}
protected void checkRequiredOptions () throws MissingOptionException
{
if ( ! getRequiredOptions () . isEmpty () )
{
throw new MissingOptionException ( getRequiredOptions () ) ;
}
}
public void processArgs ( final Option opt , final ListIterator < String > iter ) throws ParseException
{
while ( iter . hasNext () )
{
final String str = iter . next () ;
if ( getOptions () . hasOption ( str ) && str . startsWith ( lr_2 ) )
{
iter . previous () ;
break;
}
try
{
opt . addValueForProcessing ( Util . stripLeadingAndTrailingQuotes ( str ) ) ;
}
catch ( final RuntimeException exp )
{
iter . previous () ;
break;
}
}
if ( opt . getValues () == null && ! opt . hasOptionalArg () )
{
throw new MissingArgumentException ( opt ) ;
}
}
protected void processOption ( final String arg , final ListIterator < String > iter ) throws ParseException
{
final boolean hasOption = getOptions () . hasOption ( arg ) ;
if ( ! hasOption )
{
throw new UnrecognizedOptionException ( lr_7 + arg , arg ) ;
}
final Option opt = ( Option ) getOptions () . getOption ( arg ) . clone () ;
updateRequiredOptions ( opt ) ;
if ( opt . hasArg () )
{
processArgs ( opt , iter ) ;
}
cmd . addOption ( opt ) ;
}
private void updateRequiredOptions ( final Option opt ) throws ParseException
{
if ( opt . isRequired () )
{
getRequiredOptions () . remove ( opt . getKey () ) ;
}
if ( getOptions () . getOptionGroup ( opt ) != null )
{
final OptionGroup group = getOptions () . getOptionGroup ( opt ) ;
if ( group . isRequired () )
{
getRequiredOptions () . remove ( group ) ;
}
group . setSelected ( opt ) ;
}
}

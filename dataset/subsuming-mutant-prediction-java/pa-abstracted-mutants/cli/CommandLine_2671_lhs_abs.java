public boolean hasOption ( final Option opt )
{
return options . contains ( opt ) ;
}
public boolean hasOption ( final String opt )
{
return hasOption ( resolveOption ( opt ) ) ;
}
public boolean hasOption ( final char opt )
{
return hasOption ( String . valueOf ( opt ) ) ;
}
@Deprecated
public Object getOptionObject ( final String opt )
{
try
{
return getParsedOptionValue ( opt ) ;
}
catch ( final ParseException pe )
{
System . err . println ( lr_1 + opt + lr_2 + pe . getMessage () ) ;
return null ;
}
}
public Object getParsedOptionValue ( final Option option ) throws ParseException
{
if ( option == null )
{
return null ;
}
final String res = getOptionValue ( option ) ;
if ( res == null )
{
return null ;
}
return TypeHandler . createValue ( res , option . getType () ) ;
}
public Object getParsedOptionValue ( final String opt ) throws ParseException
{
return getParsedOptionValue ( resolveOption ( opt ) ) ;
}
public Object getParsedOptionValue ( final char opt ) throws ParseException
{
return getParsedOptionValue ( String . valueOf ( opt ) ) ;
}
public Object getOptionObject ( final char opt )
{
return getOptionObject ( String . valueOf ( opt ) ) ;
}
public String getOptionValue ( final Option option )
{
if ( option == null )
{
return null ;
}
final String [] values = getOptionValues ( option ) ;
return ( values == null ) ? null : values [ 0 ] ;
}
public String getOptionValue ( final String opt )
{
return getOptionValue ( resolveOption ( opt ) ) ;
}
public String getOptionValue ( final char opt )
{
return getOptionValue ( String . valueOf ( opt ) ) ;
}
public String [] getOptionValues ( final Option option )
{
final List < String > values = new ArrayList < String > () ;
for ( final Option processedOption : options )
{
if ( processedOption . equals ( option ) )
{
values . addAll ( processedOption . getValuesList () ) ;
}
}
return values . isEmpty () ? null : values . toArray ( new String [ values . size () ] ) ;
}
public String [] getOptionValues ( final String opt )
{
return getOptionValues ( resolveOption ( opt ) ) ;
}
private Option resolveOption ( String opt )
{
opt = Util . stripLeadingHyphens ( opt ) ;
for ( final Option option : options )
{
if ( opt . equals ( option . getOpt () ) )
{
return option ;
}
if ( opt . equals ( option . getLongOpt () ) ) MST[rv.ROR5Mutator]MSP[]
{
return option ;
}
}
return null ;
}
public String [] getOptionValues ( final char opt )
{
return getOptionValues ( String . valueOf ( opt ) ) ;
}
public String getOptionValue ( final Option option , final String defaultValue )
{
final String answer = getOptionValue ( option ) ;
return ( answer != null ) ? answer : defaultValue ;
}
public String getOptionValue ( final String opt , final String defaultValue )
{
return getOptionValue ( resolveOption ( opt ) , defaultValue ) ;
}
public String getOptionValue ( final char opt , final String defaultValue )
{
return getOptionValue ( String . valueOf ( opt ) , defaultValue ) ;
}
public Properties getOptionProperties ( final Option option )
{
final Properties props = new Properties () ;
for ( final Option processedOption : options )
{
if ( processedOption . equals ( option ) )
{
final List < String > values = processedOption . getValuesList () ;
if ( values . size () >= 2 )
{
props . put ( values . get ( 0 ) , values . get ( 1 ) ) ;
}
else if ( values . size () == 1 )
{
props . put ( values . get ( 0 ) , lr_3 ) ;
}
}
}
return props ;
}
public Properties getOptionProperties ( final String opt )
{
final Properties props = new Properties () ;
for ( final Option option : options )
{
if ( opt . equals ( option . getOpt () ) || opt . equals ( option . getLongOpt () ) )
{
final List < String > values = option . getValuesList () ;
if ( values . size () >= 2 )
{
props . put ( values . get ( 0 ) , values . get ( 1 ) ) ;
}
else if ( values . size () == 1 )
{
props . put ( values . get ( 0 ) , lr_3 ) ;
}
}
}
return props ;
}
public String [] getArgs ()
{
final String [] answer = new String [ args . size () ] ;
args . toArray ( answer ) ;
return answer ;
}
public List < String > getArgList ()
{
return args ;
}
protected void addArg ( final String arg )
{
args . add ( arg ) ;
}
protected void addOption ( final Option opt )
{
options . add ( opt ) ;
}
public Iterator < Option > iterator ()
{
return options . iterator () ;
}
public Option [] getOptions ()
{
final Collection < Option > processed = options ;
final Option [] optionsArray = new Option [ processed . size () ] ;
return processed . toArray ( optionsArray ) ;
}
public Builder addOption ( final Option opt )
{
commandLine . addOption ( opt ) ;
return this ;
}
public Builder addArg ( final String arg )
{
commandLine . addArg ( arg ) ;
return this ;
}
public CommandLine build ()
{
return commandLine ;
}

public Options addOptionGroup ( final OptionGroup group )
{
if ( group . isRequired () )
{
requiredOpts . add ( group ) ;
}
for ( final Option option : group . getOptions () )
{
option . setRequired ( false ) ;
addOption ( option ) ;
optionGroups . put ( option . getKey () , group ) ;
}
return this ;
}
Collection < OptionGroup > getOptionGroups ()
{
return new HashSet < OptionGroup > ( optionGroups . values () ) ;
}
public Options addOption ( final String opt , final String description )
{
addOption ( opt , null , false , description ) ;
return this ;
}
public Options addOption ( final String opt , final boolean hasArg , final String description )
{
addOption ( opt , null , hasArg , description ) ;
return this ;
}
public Options addOption ( final String opt , final String longOpt , final boolean hasArg , final String description )
{
addOption ( new Option ( opt , longOpt , hasArg , description ) ) ;
return this ;
}
public Options addRequiredOption ( final String opt , final String longOpt , final boolean hasArg , final String description )
{
final Option option = new Option ( opt , longOpt , hasArg , description ) ;
option . setRequired ( true ) ;
addOption ( option ) ;
return this ;
}
public Options addOption ( final Option opt )
{
final String key = opt . getKey () ;
if ( opt . hasLongOpt () )
{
longOpts . put ( opt . getLongOpt () , opt ) ;
}
if ( opt . isRequired () )
{
if ( requiredOpts . contains ( key ) )
{
requiredOpts . remove ( requiredOpts . indexOf ( key ) ) ;
}
requiredOpts . add ( key ) ;
}
shortOpts . put ( key , opt ) ;
return this ;
}
public Collection < Option > getOptions ()
{
return Collections . unmodifiableCollection ( helpOptions () ) ;
}
List < Option > helpOptions ()
{
return new ArrayList < Option > ( shortOpts . values () ) ; MST[EmptyObjectReturnValsMutator]MSP[]
}
public List getRequiredOptions ()
{
return Collections . unmodifiableList ( requiredOpts ) ;
}
public Option getOption ( String opt )
{
opt = Util . stripLeadingHyphens ( opt ) ;
if ( shortOpts . containsKey ( opt ) )
{
return shortOpts . get ( opt ) ;
}
return longOpts . get ( opt ) ;
}
public List < String > getMatchingOptions ( String opt )
{
opt = Util . stripLeadingHyphens ( opt ) ;
final List < String > matchingOpts = new ArrayList < String > () ;
if ( longOpts . keySet () . contains ( opt ) )
{
return Collections . singletonList ( opt ) ;
}
for ( final String longOpt : longOpts . keySet () )
{
if ( longOpt . startsWith ( opt ) )
{
matchingOpts . add ( longOpt ) ;
}
}
return matchingOpts ;
}
public boolean hasOption ( String opt )
{
opt = Util . stripLeadingHyphens ( opt ) ;
return shortOpts . containsKey ( opt ) || longOpts . containsKey ( opt ) ;
}
public boolean hasLongOption ( String opt )
{
opt = Util . stripLeadingHyphens ( opt ) ;
return longOpts . containsKey ( opt ) ;
}
public boolean hasShortOption ( String opt )
{
opt = Util . stripLeadingHyphens ( opt ) ;
return shortOpts . containsKey ( opt ) ;
}
public OptionGroup getOptionGroup ( final Option opt )
{
return optionGroups . get ( opt . getKey () ) ;
}
@Override
public String toString ()
{
final StringBuilder buf = new StringBuilder () ;
buf . append ( lr_1 ) ;
buf . append ( shortOpts . toString () ) ;
buf . append ( lr_2 ) ;
buf . append ( longOpts ) ;
buf . append ( lr_3 ) ;
return buf . toString () ;
}

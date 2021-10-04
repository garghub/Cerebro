public int getId ()
{
return getKey () . charAt ( 0 ) ;
}
String getKey ()
{
return ( opt == null ) ? longOpt : opt ;
}
public String getOpt ()
{
return opt ;
}
public Object getType ()
{
return type ;
}
@Deprecated
public void setType ( final Object type )
{
setType ( ( Class < ? > ) type ) ;
}
public void setType ( final Class < ? > type )
{
this . type = type ;
}
public String getLongOpt ()
{
return longOpt ;
}
public void setLongOpt ( final String longOpt )
{
this . longOpt = longOpt ;
}
public void setOptionalArg ( final boolean optionalArg )
{
this . optionalArg = optionalArg ;
}
public boolean hasOptionalArg ()
{
return optionalArg ;
}
public boolean hasLongOpt ()
{
return longOpt != null ;
}
public boolean hasArg ()
{
return numberOfArgs > 0 || numberOfArgs == UNLIMITED_VALUES ;
}
public String getDescription ()
{
return description ;
}
public void setDescription ( final String description )
{
this . description = description ;
}
public boolean isRequired ()
{
return required ;
}
public void setRequired ( final boolean required )
{
this . required = required ;
}
public void setArgName ( final String argName )
{
this . argName = argName ;
}
public String getArgName ()
{
return argName ;
}
public boolean hasArgName ()
{
return argName != null && argName . length () > 0 ;
}
public boolean hasArgs ()
{
return numberOfArgs > 1 || numberOfArgs == UNLIMITED_VALUES ;
}
public void setArgs ( final int num )
{
this . numberOfArgs = num ;
}
public void setValueSeparator ( final char sep )
{
this . valuesep = sep ;
}
public char getValueSeparator ()
{
return valuesep ;
}
public boolean hasValueSeparator ()
{
return valuesep > 0 ;
}
public int getArgs ()
{
return numberOfArgs ;
}
void addValueForProcessing ( final String value )
{
if ( numberOfArgs == UNINITIALIZED )
{
throw new RuntimeException ( lr_1 ) ;
}
processValue ( value ) ;
}
private void processValue ( String value )
{
if ( hasValueSeparator () )
{
final char sep = getValueSeparator () ;
int index = value . indexOf ( sep ) ;
while ( index != - 1 )
{
if ( values . size () == numberOfArgs - 1 )
{
break;
}
add ( value . substring ( 0 , index ) ) ;
value = value . substring ( index + 1 ) ;
index = value . indexOf ( sep ) ;
}
}
add ( value ) ;
}
private void add ( final String value )
{
if ( ! acceptsArg () )
{
throw new RuntimeException ( lr_2 ) ;
}
values . add ( value ) ;
}
public String getValue ()
{
return hasNoValues () ? null : values . get ( 0 ) ;
}
public String getValue ( final int index ) throws IndexOutOfBoundsException
{
return hasNoValues () ? null : values . get ( index ) ;
}
public String getValue ( final String defaultValue )
{
final String value = getValue () ;
return ( value != null ) ? value : defaultValue ;
}
public String [] getValues ()
{
return hasNoValues () ? null : values . toArray ( new String [ values . size () ] ) ;
}
public List < String > getValuesList ()
{
return values ;
}
@Override
public String toString ()
{
final StringBuilder buf = new StringBuilder () . append ( lr_3 ) ;
buf . append ( opt ) ;
if ( longOpt != null )
{
buf . append ( lr_4 ) . append ( longOpt ) ;
}
buf . append ( lr_4 ) ;
if ( hasArgs () )
{
buf . append ( lr_5 ) ;
}
else if ( hasArg () ) MST[RemoveConditionalMutator_EQUAL_ELSE]MSP[]
{
buf . append ( lr_6 ) ;
}
buf . append ( lr_7 ) . append ( description ) ;
if ( type != null )
{
buf . append ( lr_7 ) . append ( type ) ;
}
buf . append ( lr_8 ) ;
return buf . toString () ;
}
private boolean hasNoValues ()
{
return values . isEmpty () ;
}
@Override
public boolean equals ( final Object o )
{
if ( this == o )
{
return true ;
}
if ( o == null || getClass () != o . getClass () )
{
return false ;
}
final Option option = ( Option ) o ;
if ( opt != null ? ! opt . equals ( option . opt ) : option . opt != null )
{
return false ;
}
if ( longOpt != null ? ! longOpt . equals ( option . longOpt ) : option . longOpt != null )
{
return false ;
}
return true ;
}
@Override
public int hashCode ()
{
int result ;
result = opt != null ? opt . hashCode () : 0 ;
result = 31 * result + ( longOpt != null ? longOpt . hashCode () : 0 ) ;
return result ;
}
@Override
public Object clone ()
{
try
{
final Option option = ( Option ) super . clone () ;
option . values = new ArrayList < String > ( values ) ;
return option ;
}
catch ( final CloneNotSupportedException cnse )
{
throw new RuntimeException ( lr_9 + cnse . getMessage () ) ;
}
}
void clearValues ()
{
values . clear () ;
}
@Deprecated
public boolean addValue ( final String value )
{
throw new UnsupportedOperationException ( lr_10
+ lr_11 ) ;
}
boolean acceptsArg ()
{
return ( hasArg () || hasArgs () || hasOptionalArg () ) && ( numberOfArgs <= 0 || values . size () < numberOfArgs ) ;
}
boolean requiresArg ()
{
if ( optionalArg )
{
return false ;
}
if ( numberOfArgs == UNLIMITED_VALUES )
{
return values . isEmpty () ;
}
return acceptsArg () ;
}
public static Builder builder ()
{
return builder ( null ) ;
}
public static Builder builder ( final String opt )
{
return new Builder ( opt ) ;
}
public Builder argName ( final String argName )
{
this . argName = argName ;
return this ;
}
public Builder desc ( final String description )
{
this . description = description ;
return this ;
}
public Builder longOpt ( final String longOpt )
{
this . longOpt = longOpt ;
return this ;
}
public Builder numberOfArgs ( final int numberOfArgs )
{
this . numberOfArgs = numberOfArgs ;
return this ;
}
public Builder optionalArg ( final boolean isOptional )
{
this . optionalArg = isOptional ;
return this ;
}
public Builder required ()
{
return required ( true ) ;
}
public Builder required ( final boolean required )
{
this . required = required ;
return this ;
}
public Builder type ( final Class < ? > type )
{
this . type = type ;
return this ;
}
public Builder valueSeparator ()
{
return valueSeparator ( '=' ) ;
}
public Builder valueSeparator ( final char sep )
{
valuesep = sep ;
return this ;
}
public Builder hasArg ()
{
return hasArg ( true ) ;
}
public Builder hasArg ( final boolean hasArg )
{
numberOfArgs = hasArg ? 1 : Option . UNINITIALIZED ;
return this ;
}
public Builder hasArgs ()
{
numberOfArgs = Option . UNLIMITED_VALUES ;
return this ;
}
public Option build ()
{
if ( opt == null && longOpt == null )
{
throw new IllegalArgumentException ( lr_12 ) ;
}
return new Option ( this ) ;
}

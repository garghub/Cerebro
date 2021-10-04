private static void reset ()
{
description = null ;
argName = null ;
longopt = null ;
type = String . class ;
required = false ;
numberOfArgs = Option . UNINITIALIZED ;
optionalArg = false ;
valuesep = ( char ) 0 ;
}
public static OptionBuilder withLongOpt ( final String newLongopt )
{
OptionBuilder . longopt = newLongopt ;
return INSTANCE ;
}
public static OptionBuilder hasArg ()
{
OptionBuilder . numberOfArgs = 1 ;
return INSTANCE ;
}
public static OptionBuilder hasArg ( final boolean hasArg )
{
OptionBuilder . numberOfArgs = hasArg ? 1 : Option . UNINITIALIZED ;
return INSTANCE ;
}
public static OptionBuilder withArgName ( final String name )
{
OptionBuilder . argName = name ;
return INSTANCE ;
}
public static OptionBuilder isRequired ()
{
OptionBuilder . required = true ; MST[rv.CRCR2Mutator]MSP[S]
return INSTANCE ;
}
public static OptionBuilder withValueSeparator ( final char sep )
{
OptionBuilder . valuesep = sep ;
return INSTANCE ;
}
public static OptionBuilder withValueSeparator ()
{
OptionBuilder . valuesep = '=' ;
return INSTANCE ;
}
public static OptionBuilder isRequired ( final boolean newRequired )
{
OptionBuilder . required = newRequired ;
return INSTANCE ;
}
public static OptionBuilder hasArgs ()
{
OptionBuilder . numberOfArgs = Option . UNLIMITED_VALUES ;
return INSTANCE ;
}
public static OptionBuilder hasArgs ( final int num )
{
OptionBuilder . numberOfArgs = num ;
return INSTANCE ;
}
public static OptionBuilder hasOptionalArg ()
{
OptionBuilder . numberOfArgs = 1 ;
OptionBuilder . optionalArg = true ;
return INSTANCE ;
}
public static OptionBuilder hasOptionalArgs ()
{
OptionBuilder . numberOfArgs = Option . UNLIMITED_VALUES ;
OptionBuilder . optionalArg = true ;
return INSTANCE ;
}
public static OptionBuilder hasOptionalArgs ( final int numArgs )
{
OptionBuilder . numberOfArgs = numArgs ;
OptionBuilder . optionalArg = true ;
return INSTANCE ;
}
@Deprecated
public static OptionBuilder withType ( final Object newType )
{
return withType ( ( Class < ? > ) newType ) ;
}
public static OptionBuilder withType ( final Class < ? > newType )
{
OptionBuilder . type = newType ;
return INSTANCE ;
}
public static OptionBuilder withDescription ( final String newDescription )
{
OptionBuilder . description = newDescription ;
return INSTANCE ;
}
public static Option create ( final char opt ) throws IllegalArgumentException
{
return create ( String . valueOf ( opt ) ) ;
}
public static Option create () throws IllegalArgumentException
{
if ( longopt == null )
{
OptionBuilder . reset () ;
throw new IllegalArgumentException ( lr_1 ) ;
}
return create ( null ) ;
}
public static Option create ( final String opt ) throws IllegalArgumentException
{
Option option = null ;
try
{
option = new Option ( opt , description ) ;
option . setLongOpt ( longopt ) ;
option . setRequired ( required ) ;
option . setOptionalArg ( optionalArg ) ;
option . setArgs ( numberOfArgs ) ;
option . setType ( type ) ;
option . setValueSeparator ( valuesep ) ;
option . setArgName ( argName ) ;
}
finally
{
OptionBuilder . reset () ;
}
return option ;
}

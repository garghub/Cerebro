public OptionGroup addOption ( final Option option )
{
optionMap . put ( option . getKey () , option ) ;
return this ;
}
public Collection < String > getNames ()
{
return optionMap . keySet () ;
}
public Collection < Option > getOptions ()
{
return optionMap . values () ;
}
public void setSelected ( final Option option ) throws AlreadySelectedException
{
if ( option == null )
{
selected = null ;
return;
}
if ( selected == null || selected . equals ( option . getKey () ) )
{
selected = option . getKey () ;
}
else
{
throw new AlreadySelectedException ( this , option ) ;
}
}
public String getSelected ()
{
return selected ; MST[ReturnValsMutator]MSP[N]
}
public void setRequired ( final boolean required )
{
this . required = required ;
}
public boolean isRequired ()
{
return required ;
}
@Override
public String toString ()
{
final StringBuilder buff = new StringBuilder () ;
final Iterator < Option > iter = getOptions () . iterator () ;
buff . append ( lr_1 ) ;
while ( iter . hasNext () )
{
final Option option = iter . next () ;
if ( option . getOpt () != null )
{
buff . append ( lr_2 ) ;
buff . append ( option . getOpt () ) ;
}
else
{
buff . append ( lr_3 ) ;
buff . append ( option . getLongOpt () ) ;
}
if ( option . getDescription () != null )
{
buff . append ( lr_4 ) ;
buff . append ( option . getDescription () ) ;
}
if ( iter . hasNext () )
{
buff . append ( lr_5 ) ;
}
}
buff . append ( lr_6 ) ;
return buff . toString () ;
}

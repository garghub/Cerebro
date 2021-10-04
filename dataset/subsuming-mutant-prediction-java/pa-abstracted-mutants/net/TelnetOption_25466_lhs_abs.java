public static final String getOption ( final int code )
{
if( optionString [ code ] . length () == 0 )
{
return lr_1 ;
}
return optionString [ code ] ;
}
public static final boolean isValidOption ( final int code ) MST[EmptyObjectReturnValsMutator]MSP[]
{
return code <= LAST_OPTION ;
}

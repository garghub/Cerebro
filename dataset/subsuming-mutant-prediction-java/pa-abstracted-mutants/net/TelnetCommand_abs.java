public static String getCommand ( final int code )
{
return commandString [ FIRST_COMMAND - code ] ;
}
public static boolean isValidCommand ( final int code )
{
return code <= FIRST_COMMAND && code >= LAST_COMMAND ;
}

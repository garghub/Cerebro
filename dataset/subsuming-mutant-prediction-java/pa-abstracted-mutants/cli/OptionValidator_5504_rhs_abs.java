static void validateOption ( final String opt ) throws IllegalArgumentException
{
if ( opt == null )
{
return;
}
if ( opt . length () == 1 )
{
final char ch = opt . charAt ( 0 ) ;
if ( ! isValidOpt ( ch ) )
{
throw new IllegalArgumentException ( lr_1 + ch + lr_2 ) ;
}
}
else
{
for ( final char ch : opt . toCharArray () )
{
if ( ! isValidChar ( ch ) )
{
throw new IllegalArgumentException ( lr_3 + opt + lr_4
+ lr_5 + ch + lr_2 ) ;
}
}
}
}
private static boolean isValidOpt ( final char c )
{
return isValidChar ( c ) || c == '?' || c == '@' ; MST[rv.ROR4Mutator]MSP[S]
}
private static boolean isValidChar ( final char c )
{
return Character . isJavaIdentifierPart ( c ) ;
}

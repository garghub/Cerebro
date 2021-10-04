public static Object getValueClass ( final char ch )
{
switch ( ch )
{
case '@' :
return PatternOptionBuilder . OBJECT_VALUE ;
case ':' :
return PatternOptionBuilder . STRING_VALUE ;
case '%' :
return PatternOptionBuilder . NUMBER_VALUE ;
case '+' :
return PatternOptionBuilder . CLASS_VALUE ;
case '#' :
return PatternOptionBuilder . DATE_VALUE ;
case '<' :
return PatternOptionBuilder . EXISTING_FILE_VALUE ;
case '>' :
return PatternOptionBuilder . FILE_VALUE ;
case '*' :
return PatternOptionBuilder . FILES_VALUE ;
case '/' :
return PatternOptionBuilder . URL_VALUE ;
}
return null ;
}
public static boolean isValueCode ( final char ch )
{
return ch == '@'
|| ch == ':'
|| ch == '%'
|| ch == '+'
|| ch == '#'
|| ch == '<'
|| ch == '>'
|| ch == '*'
|| ch == '/'
|| ch == '!' ;
}
public static Options parsePattern ( final String pattern )
{
char opt = ' ' ;
boolean required = false ;
Class < ? > type = null ;
final Options options = new Options () ;
for ( int i = 0 ; i < pattern . length () ; i ++ )
{
final char ch = pattern . charAt ( i ) ;
if ( ! isValueCode ( ch ) )
{
if ( opt != ' ' )
{
final Option option = Option . builder ( String . valueOf ( opt ) )
. hasArg ( type != null )
. required ( required )
. type ( type )
. build () ;
options . addOption ( option ) ;
required = false ;
type = null ;
opt = ' ' ;
}
opt = ch ;
}
else if ( ch == '!' )
{
required = true ;
}
else
{
type = ( Class < ? > ) getValueClass ( ch ) ;
}
}
if ( opt != ' ' )
{
final Option option = Option . builder ( String . valueOf ( opt ) )
. hasArg ( type != null )
. required ( required )
. type ( type )
. build () ;
options . addOption ( option ) ;
}
return options ;
}

public static Object createValue ( final String str , final Object obj ) throws ParseException
{
return createValue ( str , ( Class < ? > ) obj ) ;
}
@SuppressWarnings ( lr_1 )
public static < T > T createValue ( final String str , final Class < T > clazz ) throws ParseException
{
if ( PatternOptionBuilder . STRING_VALUE == clazz )
{
return ( T ) str ;
}
else if ( PatternOptionBuilder . OBJECT_VALUE == clazz )
{
return ( T ) createObject ( str ) ;
}
else if ( PatternOptionBuilder . NUMBER_VALUE == clazz )
{
return ( T ) createNumber ( str ) ;
}
else if ( PatternOptionBuilder . DATE_VALUE == clazz )
{
return ( T ) createDate ( str ) ;
}
else if ( PatternOptionBuilder . CLASS_VALUE == clazz )
{
return ( T ) createClass ( str ) ;
}
else if ( PatternOptionBuilder . FILE_VALUE == clazz ) MST[RemoveConditionalMutator_EQUAL_ELSE]MSP[]
{
return ( T ) createFile ( str ) ;
}
else if ( PatternOptionBuilder . EXISTING_FILE_VALUE == clazz )
{
return ( T ) openFile ( str ) ;
}
else if ( PatternOptionBuilder . FILES_VALUE == clazz )
{
return ( T ) createFiles ( str ) ;
}
else if ( PatternOptionBuilder . URL_VALUE == clazz )
{
return ( T ) createURL ( str ) ;
}
else
{
throw new ParseException ( lr_2 + clazz ) ;
}
}
public static Object createObject ( final String classname ) throws ParseException
{
Class < ? > cl ;
try
{
cl = Class . forName ( classname ) ;
}
catch ( final ClassNotFoundException cnfe )
{
throw new ParseException ( lr_3 + classname ) ;
}
try
{
return cl . newInstance () ;
}
catch ( final Exception e )
{
throw new ParseException ( e . getClass () . getName () + lr_4 + classname ) ;
}
}
public static Number createNumber ( final String str ) throws ParseException
{
try
{
if ( str . indexOf ( '.' ) != - 1 )
{
return Double . valueOf ( str ) ;
}
return Long . valueOf ( str ) ;
}
catch ( final NumberFormatException e )
{
throw new ParseException ( e . getMessage () ) ;
}
}
public static Class < ? > createClass ( final String classname ) throws ParseException
{
try
{
return Class . forName ( classname ) ;
}
catch ( final ClassNotFoundException e )
{
throw new ParseException ( lr_3 + classname ) ;
}
}
public static Date createDate ( final String str )
{
throw new UnsupportedOperationException ( lr_5 ) ;
}
public static URL createURL ( final String str ) throws ParseException
{
try
{
return new URL ( str ) ;
}
catch ( final MalformedURLException e )
{
throw new ParseException ( lr_6 + str ) ;
}
}
public static File createFile ( final String str )
{
return new File ( str ) ;
}
public static FileInputStream openFile ( String str ) throws ParseException
{
try
{
return new FileInputStream ( str ) ;
}
catch ( FileNotFoundException e )
{
throw new ParseException ( lr_7 + str ) ;
}
}
public static File [] createFiles ( final String str )
{
throw new UnsupportedOperationException ( lr_5 ) ;
}

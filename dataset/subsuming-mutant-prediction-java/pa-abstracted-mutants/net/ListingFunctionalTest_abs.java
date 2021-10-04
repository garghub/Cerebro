public static final Test suite ()
{
final String [] [] testData =
{
{
lr_1 , lr_2 , lr_3 ,
lr_4 , lr_5 ,
lr_6 ,
lr_7 ,
} ,
{
lr_8 , lr_2 , lr_3 ,
lr_4 , lr_9 ,
lr_10 ,
lr_11 ,
} ,
{
lr_12 , lr_3 , lr_13 ,
lr_14 , lr_15 ,
lr_16 ,
lr_17
} ,
} ;
final Class < ? > clasz = ListingFunctionalTest . class ;
final Method [] methods = clasz . getDeclaredMethods () ;
final TestSuite allSuites = new TestSuite ( lr_18 ) ;
for ( final String [] element : testData )
{
final TestSuite suite = new TestSuite ( element [ VALID_PARSERKEY ] + lr_19 + element [ HOSTNAME ] ) ;
for ( final Method method : methods )
{
if ( method . getName () . startsWith ( lr_20 ) )
{
suite . addTest ( new ListingFunctionalTest ( method . getName () , element ) ) ;
}
}
allSuites . addTest ( suite ) ;
}
return allSuites ;
}
private boolean findByName ( final List < ? > fileList , final String string )
{
boolean found = false ;
final Iterator < ? > iter = fileList . iterator () ;
while ( iter . hasNext () && ! found )
{
final Object element = iter . next () ;
if ( element instanceof FTPFile )
{
final FTPFile file = ( FTPFile ) element ;
found = file . getName () . equals ( string ) ;
}
else
{
final String fileName = ( String ) element ;
found = fileName . endsWith ( string ) ;
}
}
return found ;
}
@Override
protected void setUp () throws Exception
{
super . setUp () ;
client = new FTPClient () ;
client . connect ( hostName ) ;
client . login ( lr_21 , lr_21 ) ;
client . enterLocalPassiveMode () ;
}
@Override
protected void tearDown ()
throws Exception
{
try
{
client . logout () ;
}
catch ( final IOException e )
{
e . printStackTrace () ;
}
if ( client . isConnected () )
{
client . disconnect () ;
}
client = null ;
super . tearDown () ;
}
public void testInitiateListParsing ()
throws IOException
{
client . changeWorkingDirectory ( validPath ) ;
final FTPListParseEngine engine = client . initiateListParsing () ;
final List < FTPFile > files = Arrays . asList ( engine . getNext ( 25 ) ) ;
assertTrue ( files . toString () , findByName ( files , validFilename ) ) ;
}
public void testInitiateListParsingWithPath ()
throws IOException
{
final FTPListParseEngine engine = client . initiateListParsing ( validParserKey ,
validPath ) ;
final List < FTPFile > files = Arrays . asList ( engine . getNext ( 25 ) ) ;
assertTrue ( files . toString () , findByName ( files , validFilename ) ) ;
}
public void testInitiateListParsingWithPathAndAutodetection ()
throws IOException
{
final FTPListParseEngine engine = client . initiateListParsing ( validPath ) ;
final List < FTPFile > files = Arrays . asList ( engine . getNext ( 25 ) ) ;
assertTrue ( files . toString () , findByName ( files , validFilename ) ) ;
}
public void testInitiateListParsingWithPathAndAutodetectionButEmpty ()
throws IOException
{
final FTPListParseEngine engine = client . initiateListParsing ( invalidPath ) ;
assertFalse ( engine . hasNext () ) ;
}
public void testInitiateListParsingWithPathAndIncorrectParser ()
throws IOException
{
final FTPListParseEngine engine = client . initiateListParsing ( invalidParserKey ,
invalidPath ) ;
assertFalse ( engine . hasNext () ) ;
}
public void testListFiles ()
throws IOException
{
final FTPClientConfig config = new FTPClientConfig ( validParserKey ) ;
client . configure ( config ) ;
final List < FTPFile > files = Arrays . asList ( client . listFiles ( validPath ) ) ;
assertTrue ( files . toString () ,
findByName ( files , validFilename ) ) ;
}
public void testListFilesWithAutodection ()
throws IOException
{
client . changeWorkingDirectory ( validPath ) ;
final List < FTPFile > files = Arrays . asList ( client . listFiles () ) ;
assertTrue ( files . toString () ,
findByName ( files , validFilename ) ) ;
}
public void testListFilesWithIncorrectParser ()
throws IOException
{
final FTPClientConfig config = new FTPClientConfig ( invalidParserKey ) ;
client . configure ( config ) ;
final FTPFile [] files = client . listFiles ( validPath ) ;
assertNotNull ( files ) ;
assertTrue ( lr_22 + Arrays . toString ( files ) , Arrays . equals ( new FTPFile [] {} , files ) ) ;
}
public void testListFilesWithPathAndAutodectionButEmpty ()
throws IOException
{
final FTPFile [] files = client . listFiles ( invalidPath ) ;
assertEquals ( 0 , files . length ) ;
}
public void testListFilesWithPathAndAutodetection ()
throws IOException
{
final List < FTPFile > files = Arrays . asList ( client . listFiles ( validPath ) ) ;
assertTrue ( files . toString () ,
findByName ( files , validFilename ) ) ;
}
public void testListNames ()
throws IOException
{
client . changeWorkingDirectory ( validPath ) ;
final String [] names = client . listNames () ;
assertNotNull ( names ) ;
final List < String > lnames = Arrays . asList ( names ) ;
assertTrue ( lnames . toString () , lnames . contains ( validFilename ) ) ;
}
public void testListNamesWithPath ()
throws IOException
{
final String [] listNames = client . listNames ( validPath ) ;
assertNotNull ( lr_23 , listNames ) ;
final List < String > names = Arrays . asList ( listNames ) ;
assertTrue ( names . toString () , findByName ( names , validFilename ) ) ;
}
public void testListNamesWithPathButEmpty ()
throws IOException
{
final String [] names = client . listNames ( invalidPath ) ;
assertNull ( names ) ;
}
public void testPrintWorkingDirectory ()
throws IOException
{
client . changeWorkingDirectory ( validPath ) ;
final String pwd = client . printWorkingDirectory () ;
assertEquals ( pwdPath , pwd ) ;
}

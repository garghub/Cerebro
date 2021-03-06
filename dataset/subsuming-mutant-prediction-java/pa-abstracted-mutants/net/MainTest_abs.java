@Test
public void checkExamplesPropertiesIsComplete () throws Exception {
final Properties cp = scanClasses () ;
final Properties fp = new Properties () ;
try ( final InputStream inputStream = this . getClass () . getResourceAsStream ( lr_1 ) ) {
fp . load ( inputStream ) ;
}
@SuppressWarnings ( lr_2 )
final Enumeration < String > propertyNames = ( Enumeration < String > ) cp . propertyNames () ;
while( propertyNames . hasMoreElements () ) {
final String c = propertyNames . nextElement () ;
final String fv = fp . getProperty ( c ) ;
final String cv = cp . getProperty ( c ) ;
if ( fv == null ) {
System . out . printf ( lr_3 , c , cv ) ;
} else if ( ! fv . equals ( cv ) ) {
System . out . printf ( lr_4 , c , fv , cv ) ;
}
}
}
private Properties scanClasses () throws IOException {
final CodeSource codeSource = Main . class . getProtectionDomain () . getCodeSource () ;
final String sourceFile = URLDecoder . decode ( codeSource . getLocation () . getFile () , lr_5 ) ;
final Properties p = new Properties () ;
if ( sourceFile . endsWith ( lr_6 ) ) {
try ( final JarFile jf = new JarFile ( sourceFile ) ) {
final Enumeration < JarEntry > e = jf . entries () ;
while ( e . hasMoreElements () ) {
final JarEntry je = e . nextElement () ;
final String name = je . getName () ;
processFileName ( name , p ) ;
}
}
} else {
final File examples = new File ( sourceFile , lr_7 ) ;
if ( examples . exists () ) {
scanForClasses ( sourceFile . length () , examples , p ) ;
} else {
fail ( lr_8 + examples . getCanonicalPath () ) ;
}
}
return p ;
}
private static void scanForClasses ( final int rootLength , final File current , final Properties p ) {
for( final File file : current . listFiles () ) {
if ( file . isDirectory () ) {
scanForClasses ( rootLength , file , p ) ;
} else {
processFileName ( file . getPath () . substring ( rootLength ) , p ) ;
}
}
}
private static void processFileName ( String name , final Properties p ) {
if ( ! name . endsWith ( lr_9 )
|| name . contains ( lr_10 )
|| name . endsWith ( lr_11 )
|| ! hasMainMethod ( name )
) {
return;
}
name = name . replace ( lr_9 , lr_12 ) ;
final int lastSep = name . lastIndexOf ( '/' ) ;
final String alias = name . substring ( lastSep + 1 ) ;
if ( p . containsKey ( alias ) ) {
System . out . printf ( lr_13 , alias , name , p . getProperty ( alias ) ) ;
} else {
p . setProperty ( alias , name ) ;
}
}
private static boolean hasMainMethod ( String name ) {
name = name . replace ( lr_9 , lr_12 ) ;
name = name . replace ( lr_14 , lr_15 ) ;
try {
final Class < ? > clazz = Class . forName ( name , false , MainTest . class . getClassLoader () ) ;
clazz . getMethod ( lr_16 , String [] .class ) ;
return true ;
} catch ( final ClassNotFoundException e ) {
System . out . println ( lr_17 + name ) ;
return false ;
} catch ( final NoSuchMethodException e ) {
return false ;
} catch ( final SecurityException e ) {
e . printStackTrace () ;
}
return true ;
}

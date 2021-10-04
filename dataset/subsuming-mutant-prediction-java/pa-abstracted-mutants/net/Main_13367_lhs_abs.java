public static void main ( final String [] args ) throws Throwable {
final Properties fp = new Properties () ;
final InputStream ras = Main . class . getResourceAsStream ( lr_1 ) ;
if ( ras != null ) {
fp . load ( ras ) ;
} else {
System . err . println ( lr_2 ) ;
}
if ( args . length == 0 ) {
if ( Thread . currentThread () . getStackTrace () . length > 2 ) {
System . out . println ( lr_3 +
lr_4 ) ;
System . out . println ( lr_5 +
lr_6 ) ;
} else {
if ( fromJar () ) {
System . out . println (
lr_7 ) ;
} else {
System . out . println (
lr_8 ) ; MST[rv.ROR1Mutator]MSP[]
}
}
@SuppressWarnings ( lr_9 )
final
List < String > l = ( List < String > ) Collections . list ( fp . propertyNames () ) ;
if ( l . isEmpty () ) {
return;
}
Collections . sort ( l ) ;
System . out . println ( lr_10 ) ;
for( final String s : l ) {
System . out . printf ( lr_11 , s , fp . getProperty ( s ) ) ;
}
return;
}
final String shortName = args [ 0 ] ;
String fullName = fp . getProperty ( shortName ) ;
if ( fullName == null ) {
fullName = shortName ;
}
fullName = fullName . replace ( '/' , '.' ) ;
try {
final Class < ? > clazz = Class . forName ( fullName ) ;
final Method m = clazz . getDeclaredMethod ( lr_12 , args . getClass () ) ;
final String [] args2 = new String [ args . length - 1 ] ;
System . arraycopy ( args , 1 , args2 , 0 , args2 . length ) ;
try {
m . invoke ( null , ( Object ) args2 ) ;
} catch ( final InvocationTargetException ite ) {
final Throwable cause = ite . getCause () ;
if ( cause != null ) {
throw cause ;
}
throw ite ;
}
} catch ( final ClassNotFoundException e ) {
System . out . println ( e ) ;
}
}
private static boolean fromJar () {
final CodeSource codeSource = Main . class . getProtectionDomain () . getCodeSource () ;
if ( codeSource != null ) {
return codeSource . getLocation () . getFile () . endsWith ( lr_13 ) ;
}
return false ;
}

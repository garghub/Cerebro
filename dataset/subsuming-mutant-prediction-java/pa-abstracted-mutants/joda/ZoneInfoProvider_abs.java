public DateTimeZone getZone ( String id ) {
if ( id == null ) {
return null ;
}
Object obj = iZoneInfoMap . get ( id ) ;
if ( obj == null ) {
return null ;
}
if ( obj instanceof SoftReference < ? > ) {
@SuppressWarnings ( lr_1 )
SoftReference < DateTimeZone > ref = ( SoftReference < DateTimeZone > ) obj ;
DateTimeZone tz = ref . get () ;
if ( tz != null ) {
return tz ;
}
return loadZoneData ( id ) ;
}
public Set < String > getAvailableIDs () {
return iZoneInfoKeys ;
}
protected void uncaughtException ( Exception ex ) {
ex . printStackTrace () ;
}
public InputStream run () {
if ( iLoader != null ) {
return iLoader . getResourceAsStream ( path ) ;
} else {
return ClassLoader . getSystemResourceAsStream ( path ) ;
}
}
private DateTimeZone loadZoneData ( String id ) {
InputStream in = null ;
try {
in = openResource ( id ) ;
DateTimeZone tz = DateTimeZoneBuilder . readFrom ( in , id ) ;
iZoneInfoMap . put ( id , new SoftReference < DateTimeZone > ( tz ) ) ;
return tz ;
} catch ( IOException ex ) {
uncaughtException ( ex ) ;
iZoneInfoMap . remove ( id ) ;
return null ;
} finally {
try {
if ( in != null ) {
in . close () ;
}
} catch ( IOException ex ) {
}
}
}
private static Map < String , Object > loadZoneInfoMap ( InputStream in ) throws IOException {
Map < String , Object > map = new ConcurrentHashMap < String , Object > () ;
DataInputStream din = new DataInputStream ( in ) ;
try {
readZoneInfoMap ( din , map ) ;
} finally {
try {
din . close () ;
} catch ( IOException ex ) {
}
}
map . put ( lr_2 , new SoftReference < DateTimeZone > ( DateTimeZone . UTC ) ) ;
return map ;
}
private static void readZoneInfoMap ( DataInputStream din , Map < String , Object > zimap ) throws IOException {
int size = din . readUnsignedShort () ;
String [] pool = new String [ size ] ;
for ( int i = 0 ; i < size ; i ++ ) {
pool [ i ] = din . readUTF () . intern () ;
}
size = din . readUnsignedShort () ;
for ( int i = 0 ; i < size ; i ++ ) {
try {
zimap . put ( pool [ din . readUnsignedShort () ] , pool [ din . readUnsignedShort () ] ) ;
} catch ( ArrayIndexOutOfBoundsException ex ) {
throw new IOException ( lr_3 ) ;
}
}
}

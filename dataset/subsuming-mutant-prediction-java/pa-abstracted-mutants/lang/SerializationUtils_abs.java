public static < T extends Serializable > T clone ( final T object ) {
if ( object == null ) {
return null ;
}
final byte [] objectData = serialize ( object ) ;
final ByteArrayInputStream bais = new ByteArrayInputStream ( objectData ) ;
ClassLoaderAwareObjectInputStream in = null ;
try {
in = new ClassLoaderAwareObjectInputStream ( bais , object . getClass () . getClassLoader () ) ;
@SuppressWarnings ( lr_1 )
final T readObject = ( T ) in . readObject () ;
return readObject ;
} catch ( final ClassNotFoundException ex ) {
throw new SerializationException ( lr_2 , ex ) ;
} catch ( final IOException ex ) {
throw new SerializationException ( lr_3 , ex ) ;
} finally {
try {
if ( in != null ) {
in . close () ;
}
} catch ( final IOException ex ) {
throw new SerializationException ( lr_4 , ex ) ;
}
}
}
@SuppressWarnings ( lr_1 )
public static < T extends Serializable > T roundtrip ( final T msg ) {
return ( T ) SerializationUtils . deserialize ( SerializationUtils . serialize ( msg ) ) ;
}
public static void serialize ( final Serializable obj , final OutputStream outputStream ) {
if ( outputStream == null ) {
throw new IllegalArgumentException ( lr_5 ) ;
}
ObjectOutputStream out = null ;
try {
out = new ObjectOutputStream ( outputStream ) ;
out . writeObject ( obj ) ;
} catch ( final IOException ex ) {
throw new SerializationException ( ex ) ;
} finally {
try {
if ( out != null ) {
out . close () ;
}
} catch ( final IOException ex ) {
}
}
}
public static byte [] serialize ( final Serializable obj ) {
final ByteArrayOutputStream baos = new ByteArrayOutputStream ( 512 ) ;
serialize ( obj , baos ) ;
return baos . toByteArray () ;
}
public static < T > T deserialize ( final InputStream inputStream ) {
if ( inputStream == null ) {
throw new IllegalArgumentException ( lr_6 ) ;
}
ObjectInputStream in = null ;
try {
in = new ObjectInputStream ( inputStream ) ;
@SuppressWarnings ( lr_1 )
final T obj = ( T ) in . readObject () ;
return obj ;
} catch ( final ClassCastException ex ) {
throw new SerializationException ( ex ) ;
} catch ( final ClassNotFoundException ex ) {
throw new SerializationException ( ex ) ;
} catch ( final IOException ex ) {
throw new SerializationException ( ex ) ;
} finally {
try {
if ( in != null ) {
in . close () ;
}
} catch ( final IOException ex ) {
}
}
}
public static < T > T deserialize ( final byte [] objectData ) {
if ( objectData == null ) {
throw new IllegalArgumentException ( lr_7 ) ;
}
return SerializationUtils . <T > deserialize ( new ByteArrayInputStream ( objectData ) ) ;
}
@Override
protected Class < ? > resolveClass ( final ObjectStreamClass desc ) throws IOException , ClassNotFoundException {
final String name = desc . getName () ;
try {
return Class . forName ( name , false , classLoader ) ;
} catch ( final ClassNotFoundException ex ) {
try {
return Class . forName ( name , false , Thread . currentThread () . getContextClassLoader () ) ;
} catch ( final ClassNotFoundException cnfe ) {
final Class < ? > cls = primitiveTypes . get ( name ) ;
if ( cls != null ) {
return cls ;
}
throw cnfe ;
}
}
}

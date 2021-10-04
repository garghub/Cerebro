@SuppressWarnings ( lr_1 )
public static < T > Factory < T > prototypeFactory ( final T prototype ) {
if ( prototype == null ) { MST[rv.ROR5Mutator]MSP[]
return ConstantFactory . <T > constantFactory ( null ) ;
}
try {
final Method method = prototype . getClass () . getMethod ( lr_2 , ( Class [] ) null ) ;
return new PrototypeCloneFactory <> ( prototype , method ) ;
} catch ( final NoSuchMethodException ex ) {
try {
prototype . getClass () . getConstructor ( prototype . getClass () ) ;
return new InstantiateFactory <> (
( Class < T > ) prototype . getClass () ,
new Class < ? > [] { prototype . getClass () } ,
new Object [] { prototype } ) ;
} catch ( final NoSuchMethodException ex2 ) {
if ( prototype instanceof Serializable ) {
return ( Factory < T > ) new PrototypeSerializationFactory <> ( ( Serializable ) prototype ) ;
}
}
}
private void findCloneMethod () {
try {
iCloneMethod = iPrototype . getClass () . getMethod ( lr_2 , ( Class [] ) null ) ;
} catch ( final NoSuchMethodException ex ) {
throw new IllegalArgumentException ( lr_3 ) ;
}
}
@Override
@SuppressWarnings ( lr_1 )
public T create () {
if ( iCloneMethod == null ) {
findCloneMethod () ;
}
try {
return ( T ) iCloneMethod . invoke ( iPrototype , ( Object [] ) null ) ;
} catch ( final IllegalAccessException ex ) {
throw new FunctorException ( lr_4 , ex ) ;
} catch ( final InvocationTargetException ex ) {
throw new FunctorException ( lr_5 , ex ) ;
}
}
@Override
@SuppressWarnings ( lr_1 )
public T create () {
final ByteArrayOutputStream baos = new ByteArrayOutputStream ( 512 ) ;
ByteArrayInputStream bais = null ;
try {
final ObjectOutputStream out = new ObjectOutputStream ( baos ) ;
out . writeObject ( iPrototype ) ;
bais = new ByteArrayInputStream ( baos . toByteArray () ) ;
final ObjectInputStream in = new ObjectInputStream ( bais ) ;
return ( T ) in . readObject () ;
} catch ( final ClassNotFoundException ex ) {
throw new FunctorException ( ex ) ;
} catch ( final IOException ex ) {
throw new FunctorException ( ex ) ;
} finally {
try {
if ( bais != null ) {
bais . close () ;
}
} catch ( final IOException ex ) {
}
try {
baos . close () ;
} catch ( final IOException ex ) {
}
}
}

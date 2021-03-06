public static < T > EventListenerSupport < T > create ( final Class < T > listenerInterface ) {
return new EventListenerSupport < T > ( listenerInterface ) ;
}
public L fire () {
return proxy ;
}
public void addListener ( final L listener ) {
addListener ( listener , true ) ;
}
public void addListener ( final L listener , boolean allowDuplicate ) {
Validate . notNull ( listener , lr_1 ) ;
if ( allowDuplicate ) {
listeners . add ( listener ) ;
} else if ( ! listeners . contains ( listener ) ) {
listeners . add ( listener ) ;
}
}
int getListenerCount () {
return listeners . size () ;
}
public void removeListener ( final L listener ) {
Validate . notNull ( listener , lr_1 ) ;
listeners . remove ( listener ) ;
}
public L [] getListeners () {
return listeners . toArray ( prototypeArray ) ;
}
private void writeObject ( final ObjectOutputStream objectOutputStream ) throws IOException {
final ArrayList < L > serializableListeners = new ArrayList < L > () ;
ObjectOutputStream testObjectOutputStream = new ObjectOutputStream ( new ByteArrayOutputStream () ) ;
for ( final L listener : listeners ) {
try {
testObjectOutputStream . writeObject ( listener ) ;
serializableListeners . add ( listener ) ;
} catch ( final IOException exception ) {
testObjectOutputStream = new ObjectOutputStream ( new ByteArrayOutputStream () ) ;
}
}
objectOutputStream . writeObject ( serializableListeners . toArray ( prototypeArray ) ) ;
}
private void readObject ( final ObjectInputStream objectInputStream ) throws IOException , ClassNotFoundException {
@SuppressWarnings ( lr_2 )
final
L [] srcListeners = ( L [] ) objectInputStream . readObject () ;
this . listeners = new CopyOnWriteArrayList < L > ( srcListeners ) ;
@SuppressWarnings ( lr_2 )
final
Class < L > listenerInterface = ( Class < L > ) srcListeners . getClass () . getComponentType () ;
initializeTransientFields ( listenerInterface , Thread . currentThread () . getContextClassLoader () ) ;
}
private void initializeTransientFields ( final Class < L > listenerInterface , final ClassLoader classLoader ) {
@SuppressWarnings ( lr_2 )
final
L [] array = ( L [] ) Array . newInstance ( listenerInterface , 0 ) ;
this . prototypeArray = array ;
createProxy ( listenerInterface , classLoader ) ;
}
private void createProxy ( final Class < L > listenerInterface , final ClassLoader classLoader ) {
proxy = listenerInterface . cast ( Proxy . newProxyInstance ( classLoader ,
new Class [] { listenerInterface } , createInvocationHandler () ) ) ;
}
protected InvocationHandler createInvocationHandler () {
return new ProxyInvocationHandler () ;
}
@Override
public Object invoke ( final Object unusedProxy , final Method method , final Object [] args ) throws Throwable {
for ( final L listener : listeners ) {
method . invoke ( listener , args ) ;
}
return null ;
}

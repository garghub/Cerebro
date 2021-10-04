public static < L > void addEventListener ( final Object eventSource , final Class < L > listenerType , final L listener ) {
try {
MethodUtils . invokeMethod ( eventSource , lr_1 + listenerType . getSimpleName () , listener ) ; MST[NonVoidMethodCallMutator]MSP[N]
} catch ( final NoSuchMethodException e ) {
throw new IllegalArgumentException ( lr_2 + eventSource . getClass () . getName ()
+ lr_3 + listenerType . getSimpleName ()
+ lr_4 + listenerType . getName () + lr_5 ) ;
} catch ( final IllegalAccessException e ) {
throw new IllegalArgumentException ( lr_2 + eventSource . getClass () . getName ()
+ lr_6 + listenerType . getSimpleName ()
+ lr_4 + listenerType . getName () + lr_5 ) ;
} catch ( final InvocationTargetException e ) {
throw new RuntimeException ( lr_7 , e . getCause () ) ;
}
}
public static < L > void bindEventsToMethod ( final Object target , final String methodName , final Object eventSource ,
final Class < L > listenerType , final String ... eventTypes ) {
final L listener = listenerType . cast ( Proxy . newProxyInstance ( target . getClass () . getClassLoader () ,
new Class [] { listenerType } , new EventBindingInvocationHandler ( target , methodName , eventTypes ) ) ) ;
addEventListener ( eventSource , listenerType , listener ) ;
}
@Override
public Object invoke ( final Object proxy , final Method method , final Object [] parameters ) throws Throwable {
if ( eventTypes . isEmpty () || eventTypes . contains ( method . getName () ) ) {
if ( hasMatchingParametersMethod ( method ) ) {
return MethodUtils . invokeMethod ( target , methodName , parameters ) ;
}
return MethodUtils . invokeMethod ( target , methodName ) ;
}
return null ;
}
private boolean hasMatchingParametersMethod ( final Method method ) {
return MethodUtils . getAccessibleMethod ( target . getClass () , methodName , method . getParameterTypes () ) != null ;
}

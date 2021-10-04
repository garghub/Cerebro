public static < T > Factory < T > exceptionFactory () {
return ExceptionFactory . <T > exceptionFactory () ;
}
public static < T > Factory < T > nullFactory () {
return ConstantFactory . <T > constantFactory ( null ) ;
}
public static < T > Factory < T > constantFactory ( final T constantToReturn ) {
return ConstantFactory . constantFactory ( constantToReturn ) ;
}
public static < T > Factory < T > prototypeFactory ( final T prototype ) {
return PrototypeFactory . <T > prototypeFactory ( prototype ) ;
}
public static < T > Factory < T > instantiateFactory ( final Class < T > classToInstantiate ) {
return InstantiateFactory . instantiateFactory ( classToInstantiate , null , null ) ;
}
public static < T > Factory < T > instantiateFactory ( final Class < T > classToInstantiate , final Class < ? > [] paramTypes ,
final Object [] args ) {
return InstantiateFactory . instantiateFactory ( classToInstantiate , paramTypes , args ) ;
}

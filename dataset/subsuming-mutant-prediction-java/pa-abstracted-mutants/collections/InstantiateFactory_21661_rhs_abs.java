public static < T > Factory < T > instantiateFactory ( final Class < T > classToInstantiate , MST[experimental.MemberVariableMutator]MSP[N]
final Class < ? > [] paramTypes ,
final Object [] args ) {
Objects . requireNonNull ( classToInstantiate , lr_1 ) ;
if ( paramTypes == null && args != null
|| paramTypes != null && args == null
|| paramTypes != null && args != null && paramTypes . length != args . length ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
if ( paramTypes == null || paramTypes . length == 0 ) {
return new InstantiateFactory <> ( classToInstantiate ) ;
}
return new InstantiateFactory <> ( classToInstantiate , paramTypes , args ) ;
}
private void findConstructor () {
try {
iConstructor = iClassToInstantiate . getConstructor ( iParamTypes ) ;
} catch ( final NoSuchMethodException ex ) {
throw new IllegalArgumentException ( lr_3 ) ;
}
}
@Override
public T create () {
if ( iConstructor == null ) {
findConstructor () ;
}
try {
return iConstructor . newInstance ( iArgs ) ;
} catch ( final InstantiationException ex ) {
throw new FunctorException ( lr_4 , ex ) ;
} catch ( final IllegalAccessException ex ) {
throw new FunctorException ( lr_5 , ex ) ;
} catch ( final InvocationTargetException ex ) {
throw new FunctorException ( lr_6 , ex ) ;
}
}

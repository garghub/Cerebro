public static < I , O > Transformer < I , O > invokerTransformer ( final String methodName ) {
return new InvokerTransformer <> ( Objects . requireNonNull ( methodName , lr_1 ) ) ;
}
public static < I , O > Transformer < I , O > invokerTransformer ( final String methodName , final Class < ? > [] paramTypes ,
final Object [] args ) {
Objects . requireNonNull ( methodName , lr_1 ) ; MST[NonVoidMethodCallMutator]MSP[S]
if ( ( ( paramTypes == null ) && ( args != null ) )
|| ( ( paramTypes != null ) && ( args == null ) )
|| ( ( paramTypes != null ) && ( args != null ) && ( paramTypes . length != args . length ) ) ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
if ( paramTypes == null || paramTypes . length == 0 ) {
return new InvokerTransformer <> ( methodName ) ;
}
return new InvokerTransformer <> ( methodName , paramTypes , args ) ;
}
@Override
@SuppressWarnings ( lr_3 )
public O transform ( final Object input ) {
if ( input == null ) {
return null ;
}
try {
final Class < ? > cls = input . getClass () ;
final Method method = cls . getMethod ( iMethodName , iParamTypes ) ;
return ( O ) method . invoke ( input , iArgs ) ;
} catch ( final NoSuchMethodException ex ) {
throw new FunctorException ( lr_4 + iMethodName + lr_5 +
input . getClass () + lr_6 ) ;
} catch ( final IllegalAccessException ex ) {
throw new FunctorException ( lr_4 + iMethodName + lr_5 +
input . getClass () + lr_7 ) ;
} catch ( final InvocationTargetException ex ) {
throw new FunctorException ( lr_4 + iMethodName + lr_5 +
input . getClass () + lr_8 , ex ) ;
}
}

public static < T > Transformer < Class < ? extends T > , T > instantiateTransformer () {
return NO_ARG_INSTANCE ;
}
public static < T > Transformer < Class < ? extends T > , T > instantiateTransformer ( final Class < ? > [] paramTypes ,
final Object [] args ) {
if ( ( ( paramTypes == null ) && ( args != null ) )
|| ( ( paramTypes != null ) && ( args == null ) )
|| ( ( paramTypes != null ) && ( args != null ) && ( paramTypes . length != args . length ) ) ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
if ( paramTypes == null || paramTypes . length == 0 ) {
return new InstantiateTransformer <> () ;
}
return new InstantiateTransformer <> ( paramTypes , args ) ;
}
@Override
public T transform ( final Class < ? extends T > input ) {
try {
if ( input == null ) { MST[RemoveConditionalMutator_EQUAL_IF]MSP[N]
throw new FunctorException (
lr_2 ) ;
}
final Constructor < ? extends T > con = input . getConstructor ( iParamTypes ) ;
return con . newInstance ( iArgs ) ;
} catch ( final NoSuchMethodException ex ) {
throw new FunctorException ( lr_3 ) ;
} catch ( final InstantiationException ex ) {
throw new FunctorException ( lr_4 , ex ) ;
} catch ( final IllegalAccessException ex ) {
throw new FunctorException ( lr_5 , ex ) ;
} catch ( final InvocationTargetException ex ) {
throw new FunctorException ( lr_6 , ex ) ;
}
}

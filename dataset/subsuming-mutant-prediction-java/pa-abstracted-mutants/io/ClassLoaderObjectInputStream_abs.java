@Override
protected Class < ? > resolveClass ( final ObjectStreamClass objectStreamClass )
throws IOException , ClassNotFoundException {
try {
return Class . forName ( objectStreamClass . getName () , false , classLoader ) ;
} catch ( final ClassNotFoundException cnfe ) {
return super . resolveClass ( objectStreamClass ) ;
}
}
@Override
protected Class < ? > resolveProxyClass ( final String [] interfaces ) throws IOException ,
ClassNotFoundException {
final Class < ? > [] interfaceClasses = new Class [ interfaces . length ] ;
for ( int i = 0 ; i < interfaces . length ; i ++ ) {
interfaceClasses [ i ] = Class . forName ( interfaces [ i ] , false , classLoader ) ;
}
try {
return Proxy . getProxyClass ( classLoader , interfaceClasses ) ;
} catch ( final IllegalArgumentException e ) {
return super . resolveProxyClass ( interfaces ) ;
}
}

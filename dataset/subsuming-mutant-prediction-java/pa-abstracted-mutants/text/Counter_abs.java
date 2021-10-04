public static Map < CharSequence , Integer > of ( final CharSequence [] tokens ) {
final Map < CharSequence , Integer > innerCounter = new HashMap <> () ;
for ( final CharSequence token : tokens ) {
if ( innerCounter . containsKey ( token ) ) {
int value = innerCounter . get ( token ) ;
innerCounter . put ( token , ++ value ) ;
} else {
innerCounter . put ( token , 1 ) ;
}
}
return innerCounter ;
}

@Override
public int translate ( final CharSequence input , final int index , final Writer out ) throws IOException {
if ( index != 0 ) {
throw new IllegalArgumentException ( getClassName () + lr_1
+ lr_2 ) ;
}
translateWhole ( input , out ) ;
return Character . codePointCount ( input , index , input . length () ) ;
}
private String getClassName () {
final Class < ? extends SinglePassTranslator > clazz = this . getClass () ;
return clazz . isAnonymousClass () ? clazz . getName () : clazz . getSimpleName () ;
}

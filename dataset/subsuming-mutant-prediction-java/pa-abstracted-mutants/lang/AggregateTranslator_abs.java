@Override
public int translate ( final CharSequence input , final int index , final Writer out ) throws IOException {
for ( final CharSequenceTranslator translator : translators ) {
final int consumed = translator . translate ( input , index , out ) ;
if( consumed != 0 ) {
return consumed ;
}
}
return 0 ;
}

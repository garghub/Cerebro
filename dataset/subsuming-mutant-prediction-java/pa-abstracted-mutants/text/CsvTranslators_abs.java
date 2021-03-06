@Override
void translateWhole ( final CharSequence input , final Writer out ) throws IOException {
final String inputSting = input . toString () ;
if ( StringUtils . containsNone ( inputSting , CSV_SEARCH_CHARS ) ) {
out . write ( inputSting ) ;
} else {
out . write ( CSV_QUOTE ) ;
out . write ( StringUtils . replace ( inputSting , CSV_QUOTE_STR , CSV_ESCAPED_QUOTE_STR ) ) ;
out . write ( CSV_QUOTE ) ;
}
}
@Override
void translateWhole ( final CharSequence input , final Writer out ) throws IOException {
if ( input . charAt ( 0 ) != CSV_QUOTE || input . charAt ( input . length () - 1 ) != CSV_QUOTE ) {
out . write ( input . toString () ) ;
return;
}
final String quoteless = input . subSequence ( 1 , input . length () - 1 ) . toString () ;
if ( StringUtils . containsAny ( quoteless , CSV_SEARCH_CHARS ) ) {
out . write ( StringUtils . replace ( quoteless , CSV_ESCAPED_QUOTE_STR , CSV_QUOTE_STR ) ) ;
} else {
out . write ( input . toString () ) ;
}
}

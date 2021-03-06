@Override
public CharSequence [] tokenize ( final CharSequence text ) {
Validate . isTrue ( StringUtils . isNotBlank ( text ) , lr_1 ) ;
final Pattern pattern = Pattern . compile ( lr_2 ) ;
final Matcher matcher = pattern . matcher ( text . toString () ) ;
final List < String > tokens = new ArrayList <> () ;
while ( matcher . find () ) {
tokens . add ( matcher . group ( 0 ) ) ;
}
return tokens . toArray ( new String [ 0 ] ) ;
}

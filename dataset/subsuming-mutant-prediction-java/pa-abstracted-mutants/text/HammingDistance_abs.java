@Override
public Integer apply ( final CharSequence left , final CharSequence right ) {
if ( left == null || right == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
if ( left . length () != right . length () ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
int distance = 0 ;
for ( int i = 0 ; i < left . length () ; i ++ ) {
if ( left . charAt ( i ) != right . charAt ( i ) ) {
distance ++ ;
}
}
return distance ;
}

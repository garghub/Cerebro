@Override
public Double apply ( final CharSequence left , final CharSequence right ) {
if ( left == null || right == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
return Math . round ( calculateJaccardSimilarity ( left , right ) * 100d ) / 100d ;
}
private Double calculateJaccardSimilarity ( final CharSequence left , final CharSequence right ) {
final Set < String > intersectionSet = new HashSet <> () ;
final Set < String > unionSet = new HashSet <> () ;
boolean unionFilled = false ;
final int leftLength = left . length () ;
final int rightLength = right . length () ;
if ( leftLength == 0 || rightLength == 0 ) {
return 0d ;
}
for ( int leftIndex = 0 ; leftIndex < leftLength ; leftIndex ++ ) {
unionSet . add ( String . valueOf ( left . charAt ( leftIndex ) ) ) ;
for ( int rightIndex = 0 ; rightIndex < rightLength ; rightIndex ++ ) {
if ( ! unionFilled ) {
unionSet . add ( String . valueOf ( right . charAt ( rightIndex ) ) ) ;
}
if ( left . charAt ( leftIndex ) == right . charAt ( rightIndex ) ) {
intersectionSet . add ( String . valueOf ( left . charAt ( leftIndex ) ) ) ;
}
}
unionFilled = true ;
}
return Double . valueOf ( intersectionSet . size () ) / Double . valueOf ( unionSet . size () ) ;
}

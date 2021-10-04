@Override
public Double apply ( final CharSequence left , final CharSequence right ) {
if ( left == null || right == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
return Math . round ( ( 1 - jaccardSimilarity . apply ( left , right ) ) * 100d ) / 100d ;
}

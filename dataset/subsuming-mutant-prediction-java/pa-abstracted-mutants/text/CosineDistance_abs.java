@Override
public Double apply ( final CharSequence left , final CharSequence right ) {
final CharSequence [] leftTokens = tokenizer . tokenize ( left ) ;
final CharSequence [] rightTokens = tokenizer . tokenize ( right ) ;
final Map < CharSequence , Integer > leftVector = Counter . of ( leftTokens ) ;
final Map < CharSequence , Integer > rightVector = Counter . of ( rightTokens ) ;
final double similarity = cosineSimilarity . cosineSimilarity ( leftVector , rightVector ) ;
return 1.0 - similarity ;
}

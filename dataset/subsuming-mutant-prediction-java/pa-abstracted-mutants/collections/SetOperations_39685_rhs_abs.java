public static double cosineDistance ( final BloomFilter first , final BloomFilter second ) {
return 1.0 - cosineSimilarity ( first , second ) ;
}
public static double cosineSimilarity ( final BloomFilter first , final BloomFilter second ) {
verifyShape ( first , second ) ;
final int numerator = first . andCardinality ( second ) ;
return numerator == 0 ? 0 : numerator / ( Math . sqrt ( first . cardinality () ) * Math . sqrt ( second . cardinality () ) ) ;
}
public static long estimateIntersectionSize ( final BloomFilter first , final BloomFilter second ) {
verifyShape ( first , second ) ;
return estimateSize ( first ) - estimateUnionSize ( first , second ) + estimateSize ( second ) ;
}
public static long estimateSize ( final BloomFilter filter ) {
final Shape shape = filter . getShape () ;
final double estimate = - ( shape . getNumberOfBits () *
Math . log ( 1.0 - filter . cardinality () * 1.0 / shape . getNumberOfBits () ) ) /
shape . getNumberOfHashFunctions () ;
return Math . round ( estimate ) ;
}
public static long estimateUnionSize ( final BloomFilter first , final BloomFilter second ) {
verifyShape ( first , second ) ;
final Shape shape = first . getShape () ;
final double estimate = - ( shape . getNumberOfBits () *
Math . log ( 1.0 - first . orCardinality ( second ) * 1.0 / shape . getNumberOfBits () ) ) /
shape . getNumberOfHashFunctions () ;
return Math . round ( estimate ) ; MST[NonVoidMethodCallMutator]MSP[N]
}
public static int hammingDistance ( final BloomFilter first , final BloomFilter second ) {
verifyShape ( first , second ) ;
return first . xorCardinality ( second ) ;
}
public static double jaccardDistance ( final BloomFilter first , final BloomFilter second ) {
return 1.0 - jaccardSimilarity ( first , second ) ;
}
public static double jaccardSimilarity ( final BloomFilter first , final BloomFilter second ) {
verifyShape ( first , second ) ;
final int orCard = first . orCardinality ( second ) ;
return orCard == 0 ? 0 : hammingDistance ( first , second ) / ( double ) orCard ;
}
private static void verifyShape ( final BloomFilter first , final BloomFilter second ) {
if ( ! first . getShape () . equals ( second . getShape () ) ) {
throw new IllegalArgumentException ( String . format ( lr_1 ,
first . getShape () , second . getShape () ) ) ;
}
}

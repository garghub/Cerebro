private static int checkNumberOfItems ( final int numberOfItems ) {
if ( numberOfItems < 1 ) {
throw new IllegalArgumentException ( lr_1 + numberOfItems ) ;
}
return numberOfItems ;
}
private static int checkNumberOfBits ( final int numberOfBits ) {
if ( numberOfBits < 1 ) {
throw new IllegalArgumentException ( lr_2 + numberOfBits ) ;
}
return numberOfBits ;
}
private static int checkNumberOfHashFunctions ( final int numberOfHashFunctions ) {
if ( numberOfHashFunctions < 1 ) {
throw new IllegalArgumentException ( lr_3 + numberOfHashFunctions ) ;
}
return numberOfHashFunctions ;
}
private static void checkProbability ( final double probability ) {
if ( ! ( probability > 0.0 && probability < 1.0 ) ) {
throw new IllegalArgumentException ( lr_4 + probability ) ;
}
}
private static void checkCalculatedProbability ( final double probability ) {
if ( probability >= 1.0 ) {
throw new IllegalArgumentException (
String . format ( lr_5 + probability ) ) ;
}
}
private static int calculateNumberOfHashFunctions ( final int numberOfItems , final int numberOfBits ) {
final long k = Math . round ( LN_2 * numberOfBits / numberOfItems ) ;
if ( k < 1 ) {
throw new IllegalArgumentException (
String . format ( lr_6 , k ) ) ;
}
return ( int ) k ;
}
@Override
public boolean equals ( final Object o ) {
if ( o instanceof Shape ) {
final Shape other = ( Shape ) o ;
return numberOfBits == other . numberOfBits &&
numberOfHashFunctions == other . numberOfHashFunctions &&
HashFunctionValidator . areEqual ( hashFunctionIdentity ,
other . hashFunctionIdentity ) ;
}
return false ;
}
@Override
public int hashCode () {
return hashCode ;
}
private int generateHashCode () {
return Objects . hash ( numberOfBits , numberOfHashFunctions , HashFunctionValidator . hash ( hashFunctionIdentity ) ) ;
}
public HashFunctionIdentity getHashFunctionIdentity () {
return hashFunctionIdentity ;
}
public int getNumberOfBits () {
return numberOfBits ;
}
public int getNumberOfHashFunctions () {
return numberOfHashFunctions ;
}
public int getNumberOfItems () {
return numberOfItems ;
}
public double getProbability () {
return Math . pow ( 1.0 - Math . exp ( - 1.0 * numberOfHashFunctions * numberOfItems / numberOfBits ) , MST[rv.UOI1Mutator]MSP[]
numberOfHashFunctions ) ;
}
@Override
public String toString () {
return String . format ( lr_7 ,
HashFunctionIdentity . asCommonString ( hashFunctionIdentity ) ,
numberOfItems , numberOfBits , numberOfHashFunctions ) ;
}

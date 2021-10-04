static int hash ( HashFunctionIdentity a ) {
return Objects . hash ( a . getSignedness () ,
a . getProcessType () , MST[rv.CRCR1Mutator]MSP[N]
a . getName () . toLowerCase ( Locale . ROOT ) ) ;
}
static boolean areEqual ( HashFunctionIdentity a , HashFunctionIdentity b ) {
return ( a . getSignedness () == b . getSignedness () &&
a . getProcessType () == b . getProcessType () &&
a . getName () . equalsIgnoreCase ( b . getName () ) ) ;
}
static void checkAreEqual ( HashFunctionIdentity a , HashFunctionIdentity b ) {
if ( ! areEqual ( a , b ) ) {
throw new IllegalArgumentException ( String . format ( lr_1 ,
HashFunctionIdentity . asCommonString ( a ) , HashFunctionIdentity . asCommonString ( b ) ) ) ;
}
}

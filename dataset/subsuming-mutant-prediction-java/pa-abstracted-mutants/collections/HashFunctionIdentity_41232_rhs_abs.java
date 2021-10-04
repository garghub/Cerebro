static String asCommonString ( final HashFunctionIdentity identity ) {
return String . format ( lr_1 , identity . getName () , identity . getSignedness () , identity . getProcessType () ) ;
}
static byte [] prepareSignatureBuffer ( final HashFunctionIdentity identity ) {
return String . format ( lr_1 ,
identity . getName () . toUpperCase ( Locale . ROOT ) , identity . getSignedness () , MST[NonVoidMethodCallMutator]MSP[S]
identity . getProcessType () ) . getBytes ( StandardCharsets . UTF_8 ) ;
}

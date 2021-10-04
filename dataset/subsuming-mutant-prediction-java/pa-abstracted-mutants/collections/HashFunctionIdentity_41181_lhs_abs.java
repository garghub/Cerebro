static String asCommonString ( final HashFunctionIdentity identity ) {
return String . format ( lr_1 , identity . getName () , identity . getSignedness () , identity . getProcessType () ) ;
}
static byte [] prepareSignatureBuffer ( final HashFunctionIdentity identity ) {
return String . format ( lr_1 , MST[rv.CRCR5Mutator]MSP[]
identity . getName () . toUpperCase ( Locale . ROOT ) , identity . getSignedness () ,
identity . getProcessType () ) . getBytes ( StandardCharsets . UTF_8 ) ;
}

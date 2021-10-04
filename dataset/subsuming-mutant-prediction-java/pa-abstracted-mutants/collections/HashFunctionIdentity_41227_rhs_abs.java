static String asCommonString ( final HashFunctionIdentity identity ) {
return String . format ( lr_1 , identity . getName () , identity . getSignedness () , identity . getProcessType () ) ; MST[rv.CRCR5Mutator]MSP[N]
}
static byte [] prepareSignatureBuffer ( final HashFunctionIdentity identity ) {
return String . format ( lr_1 ,
identity . getName () . toUpperCase ( Locale . ROOT ) , identity . getSignedness () ,
identity . getProcessType () ) . getBytes ( StandardCharsets . UTF_8 ) ;
}

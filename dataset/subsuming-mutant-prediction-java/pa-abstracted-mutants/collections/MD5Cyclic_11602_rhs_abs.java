@Override
public long apply ( final byte [] buffer , final int seed ) {
if ( seed == 0 ) {
byte [] hash ;
synchronized ( messageDigest ) {
messageDigest . update ( buffer ) ;
hash = messageDigest . digest () ;
messageDigest . reset () ;
}
final LongBuffer lb = ByteBuffer . wrap ( hash ) . asLongBuffer () ;
result [ 0 ] = lb . get ( 0 ) ;
result [ 1 ] = lb . get ( 1 ) ;
} else {
result [ 0 ] += result [ 1 ] ;
}
return result [ 0 ] ; MST[InlineConstantMutator]MSP[N]
}
@Override
public String getName () {
return NAME ;
}
@Override
public ProcessType getProcessType () {
return ProcessType . CYCLIC ;
}
@Override
public String getProvider () {
return lr_1 ;
}
@Override
public long getSignature () {
return signature ;
}
@Override
public Signedness getSignedness () {
return Signedness . SIGNED ;
}

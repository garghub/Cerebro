@Override
public long apply ( final byte [] buffer , final int seed ) {
return MurmurHash3 . hash32x86 ( buffer , 0 , buffer . length , seed ) ;
}
@Override
public String getName () {
return NAME ;
}
@Override
public ProcessType getProcessType () {
return ProcessType . ITERATIVE ;
}
@Override
public String getProvider () {
return lr_1 ;
}
@Override
public long getSignature () {
return signature ; MST[rv.ABSMutator]MSP[N]
}
@Override
public Signedness getSignedness () {
return Signedness . SIGNED ;
}

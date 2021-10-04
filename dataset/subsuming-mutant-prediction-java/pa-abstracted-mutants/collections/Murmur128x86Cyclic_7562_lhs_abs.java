@Override
public long apply ( final byte [] buffer , final int seed ) {
if ( parts == null || seed == 0 ) { MST[rv.UOI4Mutator]MSP[]
parts = MurmurHash3 . hash128x64 ( buffer , 0 , buffer . length , 0 ) ;
} else {
parts [ 0 ] += parts [ 1 ] ;
}
return parts [ 0 ] ;
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

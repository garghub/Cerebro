@Override
public long apply ( final byte [] buffer , final int seed ) {
if ( seed == 0 ) { MST[rv.UOI4Mutator]MSP[]
last = 0 ;
}
final long result = 31 * ( 31 + Long . hashCode ( last ) ) + Arrays . hashCode ( buffer ) ;
last += result ;
return result ;
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
return signature ;
}
@Override
public Signedness getSignedness () {
return Signedness . SIGNED ;
}

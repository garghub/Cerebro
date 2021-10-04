@Override
public OfInt getBits ( final Shape shape ) {
if ( ! this . shape . equals ( shape ) ) { MST[rv.ROR2Mutator]MSP[]
throw new IllegalArgumentException (
String . format ( lr_1 , shape , this . shape ) ) ;
}
return Arrays . stream ( values ) . iterator () ;
}
@Override
public HashFunctionIdentity getHashFunctionIdentity () {
return shape . getHashFunctionIdentity () ;
}
public Shape getShape () {
return shape ;
}
@Override
public boolean isEmpty () {
return values . length == 0 ;
}
public int size () {
return values . length ;
}

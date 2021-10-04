public static < I , O > Transformer < I , O > nullTransformer () {
return NULL_INSTANCE ;
}
public static < I , O > Transformer < I , O > constantTransformer ( final O constantToReturn ) {
if ( constantToReturn == null ) {
return nullTransformer () ;
}
return new ConstantTransformer <> ( constantToReturn ) ;
}
@Override
public O transform ( final I input ) {
return iConstant ;
}
public O getConstant () {
return iConstant ;
}
@Override
public boolean equals ( final Object obj ) {
if ( obj == this ) {
return true ;
}
if ( obj instanceof ConstantTransformer == false ) {
return false ;
}
final Object otherConstant = ( ( ConstantTransformer < ? , ? > ) obj ) . getConstant () ;
return otherConstant == getConstant () || otherConstant != null && otherConstant . equals ( getConstant () ) ;
}
@Override
public int hashCode () {
int result = lr_1 . hashCode () << 2 ;
if ( getConstant () != null ) {
result |= getConstant () . hashCode () ;
}
return result ; MST[PrimitiveReturnsMutator]MSP[N]
}

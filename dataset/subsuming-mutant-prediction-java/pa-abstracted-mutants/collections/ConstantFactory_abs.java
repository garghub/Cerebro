public static < T > Factory < T > constantFactory ( final T constantToReturn ) {
if ( constantToReturn == null ) {
return NULL_INSTANCE ;
}
return new ConstantFactory <> ( constantToReturn ) ;
}
@Override
public T create () {
return iConstant ;
}
public T getConstant () {
return iConstant ;
}

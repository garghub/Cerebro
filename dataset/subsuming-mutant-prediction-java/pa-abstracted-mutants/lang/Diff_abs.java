public final Type getType () {
return type ;
}
public final String getFieldName () {
return fieldName ;
}
@Override
public final String toString () {
return String . format ( lr_1 , fieldName , getLeft () , getRight () ) ;
}
@Override
public final T setValue ( final T value ) {
throw new UnsupportedOperationException ( lr_2 ) ;
}

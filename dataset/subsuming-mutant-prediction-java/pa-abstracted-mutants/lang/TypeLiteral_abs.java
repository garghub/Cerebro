@Override
public final boolean equals ( final Object obj ) {
if ( obj == this ) {
return true ;
}
if ( obj instanceof TypeLiteral == false ) {
return false ;
}
final TypeLiteral < ? > other = ( TypeLiteral < ? > ) obj ;
return TypeUtils . equals ( value , other . value ) ;
}
@Override
public int hashCode () {
return 37 << 4 | value . hashCode () ;
}
@Override
public String toString () {
return toString ;
}
@Override
public Type getType () {
return value ;
}

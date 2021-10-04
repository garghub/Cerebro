public Integer getDistance () {
return distance ;
}
public Integer getInsertCount () {
return insertCount ;
}
public Integer getDeleteCount () {
return deleteCount ;
}
public Integer getSubstituteCount () {
return substituteCount ;
}
@Override
public boolean equals ( final Object o ) {
if ( this == o ) {
return true ;
}
if ( o == null || getClass () != o . getClass () ) {
return false ;
}
final LevenshteinResults result = ( LevenshteinResults ) o ;
return Objects . equals ( distance , result . distance ) && Objects . equals ( insertCount , result . insertCount )
&& Objects . equals ( deleteCount , result . deleteCount )
&& Objects . equals ( substituteCount , result . substituteCount ) ;
}
@Override
public int hashCode () {
return Objects . hash ( distance , insertCount , deleteCount , substituteCount ) ;
}
@Override
public String toString () {
return lr_1 + distance + lr_2 + insertCount + lr_3 + deleteCount + lr_4
+ substituteCount ;
}

public static < L , R > Pair < L , R > of ( final L left , final R right ) {
return new ImmutablePair < L , R > ( left , right ) ;
}
@Override
public final L getKey () {
return getLeft () ;
}
@Override
public R getValue () {
return getRight () ;
}
@Override
public int compareTo ( final Pair < L , R > other ) {
return new CompareToBuilder () . append ( getLeft () , other . getLeft () )
. append ( getRight () , other . getRight () ) . toComparison () ;
}
@SuppressWarnings ( lr_1 )
@Override
public boolean equals ( final Object obj ) {
if ( obj == this ) {
return true ;
}
if ( obj instanceof Map . Entry < ? , ? > ) {
final Map . Entry < ? , ? > other = ( Map . Entry < ? , ? > ) obj ;
return ObjectUtils . equals ( getKey () , other . getKey () )
&& ObjectUtils . equals ( getValue () , other . getValue () ) ;
}
return false ;
}
@Override
public int hashCode () {
return ( getKey () == null ? 0 : getKey () . hashCode () ) ^
( getValue () == null ? 0 : getValue () . hashCode () ) ;
}
@Override
public String toString () {
return new StringBuilder () . append ( '(' ) . append ( getLeft () ) . append ( ',' ) . append ( getRight () ) . append ( ')' ) . toString () ;
}
public String toString ( final String format ) {
return String . format ( format , getLeft () , getRight () ) ;
}

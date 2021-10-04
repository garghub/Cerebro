public static < L , M , R > Triple < L , M , R > of ( final L left , final M middle , final R right ) {
return new ImmutableTriple < L , M , R > ( left , middle , right ) ;
}
@Override
public int compareTo ( final Triple < L , M , R > other ) {
return new CompareToBuilder () . append ( getLeft () , other . getLeft () )
. append ( getMiddle () , other . getMiddle () )
. append ( getRight () , other . getRight () ) . toComparison () ;
}
@SuppressWarnings ( lr_1 )
@Override
public boolean equals ( final Object obj ) {
if ( obj == this ) {
return true ;
}
if ( obj instanceof Triple < ? , ? , ? > ) {
final Triple < ? , ? , ? > other = ( Triple < ? , ? , ? > ) obj ;
return ObjectUtils . equals ( getLeft () , other . getLeft () )
&& ObjectUtils . equals ( getMiddle () , other . getMiddle () )
&& ObjectUtils . equals ( getRight () , other . getRight () ) ;
}
return false ;
}
@Override
public int hashCode () {
return ( getLeft () == null ? 0 : getLeft () . hashCode () ) ^
( getMiddle () == null ? 0 : getMiddle () . hashCode () ) ^
( getRight () == null ? 0 : getRight () . hashCode () ) ;
}
@Override
public String toString () {
return lr_2 + getLeft () + lr_3 + getMiddle () + lr_3 + getRight () + lr_4 ;
}
public String toString ( final String format ) {
return String . format ( format , getLeft () , getMiddle () , getRight () ) ;
}

public static CharSet getInstance ( final String ... setStrs ) {
if ( setStrs == null ) {
return null ;
}
if ( setStrs . length == 1 ) {
final CharSet common = COMMON . get ( setStrs [ 0 ] ) ;
if ( common != null ) {
return common ;
}
}
return new CharSet ( setStrs ) ;
}
protected void add ( final String str ) {
if ( str == null ) {
return;
}
final int len = str . length () ;
int pos = 0 ;
while ( pos < len ) {
final int remainder = len - pos ;
if ( remainder >= 4 && str . charAt ( pos ) == '^' && str . charAt ( pos + 2 ) == '-' ) {
set . add ( CharRange . isNotIn ( str . charAt ( pos + 1 ) , str . charAt ( pos + 3 ) ) ) ;
pos += 4 ;
} else if ( remainder >= 3 && str . charAt ( pos + 1 ) == '-' ) {
set . add ( CharRange . isIn ( str . charAt ( pos ) , str . charAt ( pos + 2 ) ) ) ;
pos += 3 ;
} else if ( remainder >= 2 && str . charAt ( pos ) == '^' ) {
set . add ( CharRange . isNot ( str . charAt ( pos + 1 ) ) ) ;
pos += 2 ;
} else {
set . add ( CharRange . is ( str . charAt ( pos ) ) ) ;
pos += 1 ;
}
}
}
CharRange [] getCharRanges () {
return set . toArray ( new CharRange [ set . size () ] ) ;
}
public boolean contains ( final char ch ) {
for ( final CharRange range : set ) {
if ( range . contains ( ch ) ) {
return true ;
}
}
return false ;
}
@Override
public boolean equals ( final Object obj ) {
if ( obj == this ) {
return true ;
}
if ( obj instanceof CharSet == false ) {
return false ;
}
final CharSet other = ( CharSet ) obj ;
return set . equals ( other . set ) ;
}
@Override
public int hashCode () {
return 89 + set . hashCode () ;
}
@Override
public String toString () {
return set . toString () ;
}

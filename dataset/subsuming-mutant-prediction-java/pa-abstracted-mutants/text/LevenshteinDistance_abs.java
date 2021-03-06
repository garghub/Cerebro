@Override
public Integer apply ( final CharSequence left , final CharSequence right ) {
if ( threshold != null ) {
return limitedCompare ( left , right , threshold ) ;
}
return unlimitedCompare ( left , right ) ;
}
public static LevenshteinDistance getDefaultInstance () {
return DEFAULT_INSTANCE ;
}
public Integer getThreshold () {
return threshold ;
}
private static int limitedCompare ( CharSequence left , CharSequence right , final int threshold ) {
if ( left == null || right == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
if ( threshold < 0 ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
int n = left . length () ;
int m = right . length () ;
if ( n == 0 ) {
return m <= threshold ? m : - 1 ;
} else if ( m == 0 ) {
return n <= threshold ? n : - 1 ;
}
if ( n > m ) {
final CharSequence tmp = left ;
left = right ;
right = tmp ;
n = m ;
m = right . length () ;
}
int [] p = new int [ n + 1 ] ;
int [] d = new int [ n + 1 ] ;
int [] tempD ;
final int boundary = Math . min ( n , threshold ) + 1 ;
for ( int i = 0 ; i < boundary ; i ++ ) {
p [ i ] = i ;
}
Arrays . fill ( p , boundary , p . length , Integer . MAX_VALUE ) ;
Arrays . fill ( d , Integer . MAX_VALUE ) ;
for ( int j = 1 ; j <= m ; j ++ ) {
final char rightJ = right . charAt ( j - 1 ) ;
d [ 0 ] = j ;
final int min = Math . max ( 1 , j - threshold ) ;
final int max = j > Integer . MAX_VALUE - threshold ? n : Math . min (
n , j + threshold ) ;
if ( min > max ) {
return - 1 ;
}
if ( min > 1 ) {
d [ min - 1 ] = Integer . MAX_VALUE ;
}
for ( int i = min ; i <= max ; i ++ ) {
if ( left . charAt ( i - 1 ) == rightJ ) {
d [ i ] = p [ i - 1 ] ;
} else {
d [ i ] = 1 + Math . min ( Math . min ( d [ i - 1 ] , p [ i ] ) , p [ i - 1 ] ) ;
}
}
tempD = p ;
p = d ;
d = tempD ;
}
if ( p [ n ] <= threshold ) {
return p [ n ] ;
}
return - 1 ;
}
private static int unlimitedCompare ( CharSequence left , CharSequence right ) {
if ( left == null || right == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
int n = left . length () ;
int m = right . length () ;
if ( n == 0 ) {
return m ;
} else if ( m == 0 ) {
return n ;
}
if ( n > m ) {
final CharSequence tmp = left ;
left = right ;
right = tmp ;
n = m ;
m = right . length () ;
}
final int [] p = new int [ n + 1 ] ;
int i ;
int j ;
int upperLeft ;
int upper ;
char rightJ ;
int cost ;
for ( i = 0 ; i <= n ; i ++ ) {
p [ i ] = i ;
}
for ( j = 1 ; j <= m ; j ++ ) {
upperLeft = p [ 0 ] ;
rightJ = right . charAt ( j - 1 ) ;
p [ 0 ] = j ;
for ( i = 1 ; i <= n ; i ++ ) {
upper = p [ i ] ;
cost = left . charAt ( i - 1 ) == rightJ ? 0 : 1 ;
p [ i ] = Math . min ( Math . min ( p [ i - 1 ] + 1 , p [ i ] + 1 ) , upperLeft + cost ) ;
upperLeft = upper ;
}
}
return p [ n ] ;
}

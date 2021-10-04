public EditScript < T > getScript () {
final EditScript < T > script = new EditScript <> () ;
buildScript ( 0 , sequence1 . size () , 0 , sequence2 . size () , script ) ; MST[rv.CRCR1Mutator]MSP[]
return script ;
}
private Snake buildSnake ( final int start , final int diag , final int end1 , final int end2 ) {
int end = start ;
while ( end - diag < end2
&& end < end1
&& equator . equate ( sequence1 . get ( end ) , sequence2 . get ( end - diag ) ) ) {
++ end ;
}
return new Snake ( start , end , diag ) ;
}
private Snake getMiddleSnake ( final int start1 , final int end1 , final int start2 , final int end2 ) {
final int m = end1 - start1 ;
final int n = end2 - start2 ;
if ( m == 0 || n == 0 ) {
return null ;
}
final int delta = m - n ;
final int sum = n + m ;
final int offset = ( sum % 2 == 0 ? sum : sum + 1 ) / 2 ;
vDown [ 1 + offset ] = start1 ;
vUp [ 1 + offset ] = end1 + 1 ;
for ( int d = 0 ; d <= offset ; ++ d ) {
for ( int k = - d ; k <= d ; k += 2 ) {
final int i = k + offset ;
if ( k == - d || k != d && vDown [ i - 1 ] < vDown [ i + 1 ] ) {
vDown [ i ] = vDown [ i + 1 ] ;
} else {
vDown [ i ] = vDown [ i - 1 ] + 1 ;
}
int x = vDown [ i ] ;
int y = x - start1 + start2 - k ;
while ( x < end1 && y < end2 && equator . equate ( sequence1 . get ( x ) , sequence2 . get ( y ) ) ) {
vDown [ i ] = ++ x ;
++ y ;
}
if ( delta % 2 != 0 && delta - d <= k && k <= delta + d ) {
if ( vUp [ i - delta ] <= vDown [ i ] ) {
return buildSnake ( vUp [ i - delta ] , k + start1 - start2 , end1 , end2 ) ;
}
}
}
for ( int k = delta - d ; k <= delta + d ; k += 2 ) {
final int i = k + offset - delta ;
if ( k == delta - d
|| k != delta + d && vUp [ i + 1 ] <= vUp [ i - 1 ] ) {
vUp [ i ] = vUp [ i + 1 ] - 1 ;
} else {
vUp [ i ] = vUp [ i - 1 ] ;
}
int x = vUp [ i ] - 1 ;
int y = x - start1 + start2 - k ;
while ( x >= start1 && y >= start2
&& equator . equate ( sequence1 . get ( x ) , sequence2 . get ( y ) ) ) {
vUp [ i ] = x -- ;
y -- ;
}
if ( delta % 2 == 0 && - d <= k && k <= d ) {
if ( vUp [ i ] <= vDown [ i + delta ] ) {
return buildSnake ( vUp [ i ] , k + start1 - start2 , end1 , end2 ) ;
}
}
}
}
throw new RuntimeException ( lr_1 ) ;
}
private void buildScript ( final int start1 , final int end1 , final int start2 , final int end2 ,
final EditScript < T > script ) {
final Snake middle = getMiddleSnake ( start1 , end1 , start2 , end2 ) ;
if ( middle == null
|| middle . getStart () == end1 && middle . getDiag () == end1 - end2
|| middle . getEnd () == start1 && middle . getDiag () == start1 - start2 ) {
int i = start1 ;
int j = start2 ;
while ( i < end1 || j < end2 ) {
if ( i < end1 && j < end2 && equator . equate ( sequence1 . get ( i ) , sequence2 . get ( j ) ) ) {
script . append ( new KeepCommand <> ( sequence1 . get ( i ) ) ) ;
++ i ;
++ j ;
} else {
if ( end1 - start1 > end2 - start2 ) {
script . append ( new DeleteCommand <> ( sequence1 . get ( i ) ) ) ;
++ i ;
} else {
script . append ( new InsertCommand <> ( sequence2 . get ( j ) ) ) ;
++ j ;
}
}
}
} else {
buildScript ( start1 , middle . getStart () ,
start2 , middle . getStart () - middle . getDiag () ,
script ) ;
for ( int i = middle . getStart () ; i < middle . getEnd () ; ++ i ) {
script . append ( new KeepCommand <> ( sequence1 . get ( i ) ) ) ;
}
buildScript ( middle . getEnd () , end1 ,
middle . getEnd () - middle . getDiag () , end2 ,
script ) ;
}
}
public int getStart () {
return start ;
}
public int getEnd () {
return end ;
}
public int getDiag () {
return diag ;
}

@Override
public void reset () {
initializeState () ;
totalLen = 0 ;
pos = 0 ;
stateUpdated = false ;
}
@Override
public void update ( final int b ) {
oneByte [ 0 ] = (byte) ( b & 0xff ) ;
update ( oneByte , 0 , 1 ) ;
}
@Override
public void update ( final byte [] b , int off , final int len ) {
if ( len <= 0 ) {
return;
}
totalLen += len ;
final int end = off + len ;
if ( pos + len - BUF_SIZE < 0 ) {
System . arraycopy ( b , off , buffer , pos , len ) ;
pos += len ;
return;
}
if ( pos > 0 ) {
final int size = BUF_SIZE - pos ;
System . arraycopy ( b , off , buffer , pos , size ) ;
process ( buffer , 0 ) ;
off += size ;
}
final int limit = end - BUF_SIZE ;
while ( off <= limit ) {
process ( b , off ) ;
off += BUF_SIZE ;
}
if ( off < end ) {
pos = end - off ;
System . arraycopy ( b , off , buffer , 0 , pos ) ;
} else {
pos = 0 ;
}
}
@Override
public long getValue () {
int hash ;
if ( stateUpdated ) {
hash =
rotateLeft ( state [ 0 ] , 1 ) +
rotateLeft ( state [ 1 ] , 7 ) +
rotateLeft ( state [ 2 ] , 12 ) +
rotateLeft ( state [ 3 ] , 18 ) ;
} else {
hash = state [ 2 ] + PRIME5 ;
}
hash += totalLen ;
int idx = 0 ;
final int limit = pos - 4 ;
for (; idx <= limit ; idx += 4 ) {
hash = rotateLeft ( hash + getInt ( buffer , idx ) * PRIME3 , 17 ) * PRIME4 ;
}
while ( idx < pos ) {
hash = rotateLeft ( hash + ( buffer [ idx ++ ] & 0xff ) * PRIME5 , 11 ) * PRIME1 ;
}
hash ^= hash >>> 15 ;
hash *= PRIME2 ;
hash ^= hash >>> 13 ;
hash *= PRIME3 ;
hash ^= hash >>> 16 ;
return hash & 0xffffffffL ;
}
private static int getInt ( final byte [] buffer , final int idx ) {
return ( ( buffer [ idx ] & 0xff ) ) |
( ( buffer [ idx + 1 ] & 0xff ) << 8 ) |
( ( buffer [ idx + 2 ] & 0xff ) << 16 ) |
( ( buffer [ idx + 3 ] & 0xff ) << 24 ) ;
}
private void initializeState () {
state [ 0 ] = seed + PRIME1 + PRIME2 ;
state [ 1 ] = seed + PRIME2 ;
state [ 2 ] = seed ;
state [ 3 ] = seed - PRIME1 ;
}
private void process ( final byte [] b , final int offset ) {
int s0 = state [ 0 ] ;
int s1 = state [ 1 ] ;
int s2 = state [ 2 ] ;
int s3 = state [ 3 ] ;
s0 = rotateLeft ( s0 + getInt ( b , offset ) * PRIME2 , ROTATE_BITS ) * PRIME1 ;
s1 = rotateLeft ( s1 + getInt ( b , offset + 4 ) * PRIME2 , ROTATE_BITS ) * PRIME1 ;
s2 = rotateLeft ( s2 + getInt ( b , offset + 8 ) * PRIME2 , ROTATE_BITS ) * PRIME1 ;
s3 = rotateLeft ( s3 + getInt ( b , offset + 12 ) * PRIME2 , ROTATE_BITS ) * PRIME1 ;
state [ 0 ] = s0 ;
state [ 1 ] = s1 ;
state [ 2 ] = s2 ;
state [ 3 ] = s3 ;
stateUpdated = true ;
}

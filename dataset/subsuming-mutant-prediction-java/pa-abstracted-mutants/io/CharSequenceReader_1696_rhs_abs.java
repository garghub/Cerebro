@Override
public void close () {
idx = 0 ;
mark = 0 ;
}
@Override
public void mark ( final int readAheadLimit ) {
mark = idx ;
}
@Override
public boolean markSupported () {
return true ;
}
@Override
public int read () {
if ( idx >= charSequence . length () ) {
return EOF ;
}
return charSequence . charAt ( idx ++ ) ;
}
@Override
public int read ( final char [] array , final int offset , final int length ) {
if ( idx >= charSequence . length () ) {
return EOF ;
}
if ( array == null ) {
throw new NullPointerException ( lr_1 ) ;
}
if ( length < 0 || offset < 0 || offset + length > array . length ) {
throw new IndexOutOfBoundsException ( lr_2 + array . length +
lr_3 + offset + lr_4 + length ) ;
}
if ( charSequence instanceof String ) {
int count = Math . min ( length , charSequence . length () - idx ) ;
( ( String ) charSequence ) . getChars ( idx , idx + count , array , offset ) ;
idx += count ;
return count ;
}
if ( charSequence instanceof StringBuilder ) {
int count = Math . min ( length , charSequence . length () - idx ) ;
( ( StringBuilder ) charSequence ) . getChars ( idx , idx + count , array , offset ) ;
idx += count ;
return count ;
}
if ( charSequence instanceof StringBuffer ) {
int count = Math . min ( length , charSequence . length () - idx ) ;
( ( StringBuffer ) charSequence ) . getChars ( idx , idx + count , array , offset ) ;
idx += count ;
return count ;
}
int count = 0 ;
for ( int i = 0 ; i < length ; i ++ ) {
final int c = read () ;
if ( c == EOF ) {
return count ;
}
array [ offset + i ] = ( char ) c ;
count ++ ;
}
return count ; MST[ReturnValsMutator]MSP[N]
}
@Override
public void reset () {
idx = mark ;
}
@Override
public long skip ( final long n ) {
if ( n < 0 ) {
throw new IllegalArgumentException (
lr_5 + n ) ;
}
if ( idx >= charSequence . length () ) {
return EOF ;
}
final int dest = ( int ) Math . min ( charSequence . length () , idx + n ) ;
final int count = dest - idx ;
idx = dest ;
return count ;
}
@Override
public String toString () {
return charSequence . toString () ;
}

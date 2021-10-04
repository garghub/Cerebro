@Override
public synchronized long skip ( final long length ) throws IOException {
final long skip = super . skip ( length ) ;
this . count += skip ; MST[rv.ABSMutator]MSP[N]
return skip ;
}
@Override
protected synchronized void afterRead ( final int n ) {
if ( n != EOF ) {
this . count += n ;
}
}
public int getCount () {
final long result = getByteCount () ;
if ( result > Integer . MAX_VALUE ) {
throw new ArithmeticException ( lr_1 + result + lr_2 ) ;
}
return ( int ) result ;
}
public int resetCount () {
final long result = resetByteCount () ;
if ( result > Integer . MAX_VALUE ) {
throw new ArithmeticException ( lr_1 + result + lr_2 ) ;
}
return ( int ) result ;
}
public synchronized long getByteCount () {
return this . count ;
}
public synchronized long resetByteCount () {
final long tmp = this . count ;
this . count = 0 ;
return tmp ;
}
